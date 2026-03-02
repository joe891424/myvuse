package io.branch.referral;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.ServerRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ServerRequestQueue {
    private static final int MAX_ITEMS = 25;
    private static final String PREF_KEY = "BNCServerRequestQueue";
    private static ServerRequestQueue SharedInstance;
    private static final Object reqQueueLockObject = new Object();
    private SharedPreferences.Editor editor;
    private final List<ServerRequest> queue;
    private SharedPreferences sharedPref;
    private final Semaphore serverSema_ = new Semaphore(1);
    int networkCount_ = 0;
    final ConcurrentHashMap<String, String> instrumentationExtraData_ = new ConcurrentHashMap<>();

    public static ServerRequestQueue getInstance(Context context) {
        if (SharedInstance == null) {
            synchronized (ServerRequestQueue.class) {
                if (SharedInstance == null) {
                    SharedInstance = new ServerRequestQueue(context);
                }
            }
        }
        return SharedInstance;
    }

    static void shutDown() {
        synchronized (reqQueueLockObject) {
            SharedInstance = null;
        }
    }

    private ServerRequestQueue(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("BNC_Server_Request_Queue", 0);
        this.sharedPref = sharedPreferences;
        this.editor = sharedPreferences.edit();
        this.queue = retrieve(context);
    }

    private void persist() {
        String string;
        JSONObject json;
        try {
            JSONArray jSONArray = new JSONArray();
            synchronized (reqQueueLockObject) {
                for (ServerRequest serverRequest : this.queue) {
                    if (serverRequest.isPersistable() && (json = serverRequest.toJSON()) != null) {
                        jSONArray.put(json);
                    }
                }
            }
            SharedPreferences.Editor editor = this.editor;
            if (jSONArray instanceof JSONArray) {
                string = JSONArrayInstrumentation.toString(jSONArray);
            } else {
                string = jSONArray.toString();
            }
            editor.putString(PREF_KEY, string).apply();
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder("Failed to persist queue");
            if (message == null) {
                message = "";
            }
            BranchLogger.m5578v(sb.append(message).toString());
        }
    }

    private List<ServerRequest> retrieve(Context context) {
        String string = this.sharedPref.getString(PREF_KEY, null);
        List<ServerRequest> listSynchronizedList = Collections.synchronizedList(new LinkedList());
        synchronized (reqQueueLockObject) {
            if (string != null) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    int iMin = Math.min(jSONArray.length(), 25);
                    for (int i = 0; i < iMin; i++) {
                        ServerRequest serverRequestFromJSON = ServerRequest.fromJSON(jSONArray.getJSONObject(i), context);
                        if (serverRequestFromJSON != null) {
                            listSynchronizedList.add(serverRequestFromJSON);
                        }
                    }
                } catch (JSONException e) {
                    BranchLogger.m5575d(e.getMessage());
                }
            }
        }
        return listSynchronizedList;
    }

    public int getSize() {
        int size;
        synchronized (reqQueueLockObject) {
            size = this.queue.size();
        }
        return size;
    }

    void enqueue(ServerRequest serverRequest) {
        synchronized (reqQueueLockObject) {
            if (serverRequest != null) {
                this.queue.add(serverRequest);
                if (getSize() >= 25) {
                    this.queue.remove(1);
                }
                persist();
            }
        }
    }

    ServerRequest peek() {
        ServerRequest serverRequest;
        synchronized (reqQueueLockObject) {
            try {
                serverRequest = this.queue.get(0);
            } catch (IndexOutOfBoundsException | NoSuchElementException e) {
                BranchLogger.m5575d(e.getMessage());
                serverRequest = null;
            }
        }
        return serverRequest;
    }

    ServerRequest peekAt(int i) {
        ServerRequest serverRequest;
        synchronized (reqQueueLockObject) {
            try {
                serverRequest = this.queue.get(i);
            } catch (IndexOutOfBoundsException | NoSuchElementException e) {
                BranchLogger.m5575d(e.getMessage());
                serverRequest = null;
            }
        }
        return serverRequest;
    }

    void insert(ServerRequest serverRequest, int i) {
        synchronized (reqQueueLockObject) {
            try {
                if (this.queue.size() < i) {
                    i = this.queue.size();
                }
                this.queue.add(i, serverRequest);
                persist();
            } catch (IndexOutOfBoundsException e) {
                BranchLogger.m5575d(e.getMessage());
            }
        }
    }

    public ServerRequest removeAt(int i) {
        IndexOutOfBoundsException e;
        ServerRequest serverRequestRemove;
        synchronized (reqQueueLockObject) {
            try {
                serverRequestRemove = this.queue.remove(i);
                try {
                    persist();
                } catch (IndexOutOfBoundsException e2) {
                    e = e2;
                    BranchLogger.m5575d(e.getMessage());
                }
            } catch (IndexOutOfBoundsException e3) {
                e = e3;
                serverRequestRemove = null;
            }
        }
        return serverRequestRemove;
    }

    public boolean remove(ServerRequest serverRequest) {
        boolean zRemove;
        synchronized (reqQueueLockObject) {
            zRemove = false;
            try {
                zRemove = this.queue.remove(serverRequest);
                persist();
            } catch (UnsupportedOperationException e) {
                BranchLogger.m5575d(e.getMessage());
            }
        }
        return zRemove;
    }

    void clear() {
        synchronized (reqQueueLockObject) {
            try {
                this.queue.clear();
                persist();
            } catch (UnsupportedOperationException e) {
                BranchLogger.m5575d(e.getMessage());
            }
        }
    }

    ServerRequestInitSession getSelfInitRequest() {
        synchronized (reqQueueLockObject) {
            for (ServerRequest serverRequest : this.queue) {
                if (serverRequest instanceof ServerRequestInitSession) {
                    ServerRequestInitSession serverRequestInitSession = (ServerRequestInitSession) serverRequest;
                    if (serverRequestInitSession.initiatedByClient) {
                        return serverRequestInitSession;
                    }
                }
            }
            return null;
        }
    }

    void unlockProcessWait(ServerRequest.PROCESS_WAIT_LOCK process_wait_lock) {
        synchronized (reqQueueLockObject) {
            for (ServerRequest serverRequest : this.queue) {
                if (serverRequest != null) {
                    serverRequest.removeProcessWaitLock(process_wait_lock);
                }
            }
        }
    }

    void processNextQueueItem() {
        try {
            this.serverSema_.acquire();
            if (this.networkCount_ == 0 && getSize() > 0) {
                this.networkCount_ = 1;
                ServerRequest serverRequestPeek = peek();
                this.serverSema_.release();
                if (serverRequestPeek != null) {
                    BranchLogger.m5575d("processNextQueueItem, req " + serverRequestPeek.getClass().getSimpleName());
                    if (!serverRequestPeek.isWaitingOnProcessToFinish()) {
                        if (!(serverRequestPeek instanceof ServerRequestRegisterInstall) && !hasUser()) {
                            BranchLogger.m5575d("Branch Error: User session has not been initialized!");
                            this.networkCount_ = 0;
                            serverRequestPeek.handleFailure(BranchError.ERR_NO_SESSION, "");
                        } else if (requestNeedsSession(serverRequestPeek) && !isSessionAvailableForRequest()) {
                            this.networkCount_ = 0;
                            serverRequestPeek.handleFailure(BranchError.ERR_NO_SESSION, "");
                        } else {
                            executeTimedBranchPostTask(serverRequestPeek, Branch.getInstance().prefHelper_.getTaskTimeout());
                        }
                    } else {
                        this.networkCount_ = 0;
                    }
                } else {
                    remove(null);
                }
            } else {
                this.serverSema_.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void insertRequestAtFront(ServerRequest serverRequest) {
        if (this.networkCount_ == 0) {
            insert(serverRequest, 0);
        } else {
            insert(serverRequest, 1);
        }
    }

    private boolean requestNeedsSession(ServerRequest serverRequest) {
        return ((serverRequest instanceof ServerRequestInitSession) || (serverRequest instanceof ServerRequestCreateUrl)) ? false : true;
    }

    private boolean isSessionAvailableForRequest() {
        return hasSession() && hasRandomizedDeviceToken();
    }

    private boolean hasSession() {
        return !Branch.getInstance().prefHelper_.getSessionID().equals(PrefHelper.NO_STRING_VALUE);
    }

    private boolean hasRandomizedDeviceToken() {
        return !Branch.getInstance().prefHelper_.getRandomizedDeviceToken().equals(PrefHelper.NO_STRING_VALUE);
    }

    boolean hasUser() {
        return !Branch.getInstance().prefHelper_.getRandomizedBundleToken().equals(PrefHelper.NO_STRING_VALUE);
    }

    void updateAllRequestsInQueue() {
        JSONObject post;
        for (int i = 0; i < getSize(); i++) {
            try {
                ServerRequest serverRequestPeekAt = peekAt(i);
                if (serverRequestPeekAt != null && (post = serverRequestPeekAt.getPost()) != null) {
                    if (post.has(Defines.Jsonkey.SessionID.getKey())) {
                        serverRequestPeekAt.getPost().put(Defines.Jsonkey.SessionID.getKey(), Branch.getInstance().prefHelper_.getSessionID());
                    }
                    if (post.has(Defines.Jsonkey.RandomizedBundleToken.getKey())) {
                        serverRequestPeekAt.getPost().put(Defines.Jsonkey.RandomizedBundleToken.getKey(), Branch.getInstance().prefHelper_.getRandomizedBundleToken());
                    }
                    if (post.has(Defines.Jsonkey.RandomizedDeviceToken.getKey())) {
                        serverRequestPeekAt.getPost().put(Defines.Jsonkey.RandomizedDeviceToken.getKey(), Branch.getInstance().prefHelper_.getRandomizedDeviceToken());
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private void executeTimedBranchPostTask(ServerRequest serverRequest, final int i) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final BranchPostTask branchPostTask = new BranchPostTask(serverRequest, countDownLatch);
        branchPostTask.executeTask(new Void[0]);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread(new Runnable() { // from class: io.branch.referral.ServerRequestQueue.1
                @Override // java.lang.Runnable
                public void run() {
                    ServerRequestQueue.this.awaitTimedBranchPostTask(countDownLatch, i, branchPostTask);
                }
            }).start();
        } else {
            awaitTimedBranchPostTask(countDownLatch, i, branchPostTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awaitTimedBranchPostTask(CountDownLatch countDownLatch, int i, BranchPostTask branchPostTask) {
        try {
            if (countDownLatch.await(i, TimeUnit.MILLISECONDS)) {
                return;
            }
            branchPostTask.cancel(true);
            branchPostTask.onPostExecuteInner(new ServerResponse(branchPostTask.thisReq_.getRequestPath(), BranchError.ERR_BRANCH_TASK_TIMEOUT, ""));
        } catch (InterruptedException unused) {
            branchPostTask.cancel(true);
            branchPostTask.onPostExecuteInner(new ServerResponse(branchPostTask.thisReq_.getRequestPath(), BranchError.ERR_BRANCH_TASK_TIMEOUT, ""));
        }
    }

    public void handleNewRequest(ServerRequest serverRequest) {
        BranchLogger.m5575d("handleNewRequest " + serverRequest);
        if (Branch.getInstance().getTrackingController().isTrackingDisabled() && !serverRequest.prepareExecuteWithoutTracking()) {
            BranchLogger.m5575d("Requested operation cannot be completed since tracking is disabled [" + serverRequest.requestPath_.getPath() + "]");
            serverRequest.handleFailure(BranchError.ERR_BRANCH_TRACKING_DISABLED, "");
            return;
        }
        if (Branch.getInstance().initState_ != Branch.SESSION_STATE.INITIALISED && !(serverRequest instanceof ServerRequestInitSession)) {
            if (serverRequest instanceof ServerRequestLogout) {
                serverRequest.handleFailure(BranchError.ERR_NO_SESSION, "");
                BranchLogger.m5575d("Branch is not initialized, cannot logout");
                return;
            } else if (requestNeedsSession(serverRequest)) {
                BranchLogger.m5575d("handleNewRequest " + serverRequest + " needs a session");
                serverRequest.addProcessWaitLock(ServerRequest.PROCESS_WAIT_LOCK.SDK_INIT_WAIT_LOCK);
            }
        }
        enqueue(serverRequest);
        serverRequest.onRequestQueued();
        processNextQueueItem();
    }

    private class BranchPostTask extends BranchAsyncTask<Void, Void, ServerResponse> {
        final CountDownLatch latch_;
        ServerRequest thisReq_;

        public BranchPostTask(ServerRequest serverRequest, CountDownLatch countDownLatch) {
            this.thisReq_ = serverRequest;
            this.latch_ = countDownLatch;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.thisReq_.onPreExecute();
            this.thisReq_.doFinalUpdateOnMainThread();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public ServerResponse doInBackground(Void... voidArr) {
            ServerResponse serverResponseMake_restful_post;
            this.thisReq_.doFinalUpdateOnBackgroundThread();
            if (Branch.getInstance().getTrackingController().isTrackingDisabled() && !this.thisReq_.prepareExecuteWithoutTracking()) {
                return new ServerResponse(this.thisReq_.getRequestPath(), BranchError.ERR_BRANCH_TRACKING_DISABLED, "");
            }
            String branchKey = Branch.getInstance().prefHelper_.getBranchKey();
            if (this.thisReq_.isGetRequest()) {
                serverResponseMake_restful_post = Branch.getInstance().getBranchRemoteInterface().make_restful_get(this.thisReq_.getRequestUrl(), this.thisReq_.getGetParams(), this.thisReq_.getRequestPath(), branchKey);
            } else {
                serverResponseMake_restful_post = Branch.getInstance().getBranchRemoteInterface().make_restful_post(this.thisReq_.getPostWithInstrumentationValues(ServerRequestQueue.this.instrumentationExtraData_), this.thisReq_.getRequestUrl(), this.thisReq_.getRequestPath(), branchKey);
            }
            CountDownLatch countDownLatch = this.latch_;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            return serverResponseMake_restful_post;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(ServerResponse serverResponse) {
            super.onPostExecute(serverResponse);
            onPostExecuteInner(serverResponse);
        }

        void onPostExecuteInner(ServerResponse serverResponse) {
            CountDownLatch countDownLatch = this.latch_;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            if (serverResponse == null) {
                this.thisReq_.handleFailure(BranchError.ERR_BRANCH_INVALID_REQUEST, "Null response.");
                return;
            }
            int statusCode = serverResponse.getStatusCode();
            if (statusCode == 200) {
                onRequestSuccess(serverResponse);
            } else {
                onRequestFailed(serverResponse, statusCode);
            }
            ServerRequestQueue.this.networkCount_ = 0;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.branch.referral.ServerRequestQueue.BranchPostTask.1
                @Override // java.lang.Runnable
                public void run() {
                    ServerRequestQueue.this.processNextQueueItem();
                }
            });
        }

        private void onRequestSuccess(ServerResponse serverResponse) {
            boolean z;
            JSONObject object = serverResponse.getObject();
            if (object == null) {
                this.thisReq_.handleFailure(500, "Null response json.");
            }
            ServerRequest serverRequest = this.thisReq_;
            if ((serverRequest instanceof ServerRequestCreateUrl) && object != null) {
                try {
                    Branch.getInstance().linkCache_.put(((ServerRequestCreateUrl) serverRequest).getLinkPost(), object.getString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (serverRequest instanceof ServerRequestLogout) {
                Branch.getInstance().linkCache_.clear();
                ServerRequestQueue.this.clear();
            }
            ServerRequest serverRequest2 = this.thisReq_;
            if ((serverRequest2 instanceof ServerRequestInitSession) || (serverRequest2 instanceof ServerRequestIdentifyUserRequest)) {
                if (!Branch.getInstance().isTrackingDisabled() && object != null) {
                    try {
                        boolean z2 = true;
                        if (object.has(Defines.Jsonkey.SessionID.getKey())) {
                            Branch.getInstance().prefHelper_.setSessionID(object.getString(Defines.Jsonkey.SessionID.getKey()));
                            z = true;
                        } else {
                            z = false;
                        }
                        if (object.has(Defines.Jsonkey.RandomizedBundleToken.getKey())) {
                            String string = object.getString(Defines.Jsonkey.RandomizedBundleToken.getKey());
                            if (!Branch.getInstance().prefHelper_.getRandomizedBundleToken().equals(string)) {
                                Branch.getInstance().linkCache_.clear();
                                Branch.getInstance().prefHelper_.setRandomizedBundleToken(string);
                                z = true;
                            }
                        }
                        if (object.has(Defines.Jsonkey.RandomizedDeviceToken.getKey())) {
                            Branch.getInstance().prefHelper_.setRandomizedDeviceToken(object.getString(Defines.Jsonkey.RandomizedDeviceToken.getKey()));
                        } else {
                            z2 = z;
                        }
                        if (z2) {
                            ServerRequestQueue.this.updateAllRequestsInQueue();
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.thisReq_ instanceof ServerRequestInitSession) {
                    Branch.getInstance().setInitState(Branch.SESSION_STATE.INITIALISED);
                    Branch.getInstance().checkForAutoDeepLinkConfiguration();
                    if (Branch.getInstance().getLatestReferringParamsLatch != null) {
                        Branch.getInstance().getLatestReferringParamsLatch.countDown();
                    }
                    if (Branch.getInstance().getFirstReferringParamsLatch != null) {
                        Branch.getInstance().getFirstReferringParamsLatch.countDown();
                    }
                }
            }
            if (object != null) {
                this.thisReq_.onRequestSucceeded(serverResponse, Branch.getInstance());
                ServerRequestQueue.this.remove(this.thisReq_);
            } else if (this.thisReq_.shouldRetryOnFail()) {
                this.thisReq_.clearCallbacks();
            } else {
                ServerRequestQueue.this.remove(this.thisReq_);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void onRequestFailed(io.branch.referral.ServerResponse r4, int r5) {
            /*
                r3 = this;
                io.branch.referral.ServerRequest r0 = r3.thisReq_
                boolean r0 = r0 instanceof io.branch.referral.ServerRequestInitSession
                if (r0 == 0) goto L21
                io.branch.referral.Branch r0 = io.branch.referral.Branch.getInstance()
                io.branch.referral.PrefHelper r0 = r0.prefHelper_
                java.lang.String r0 = r0.getSessionParams()
                java.lang.String r1 = "bnc_no_value"
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L21
                io.branch.referral.Branch r0 = io.branch.referral.Branch.getInstance()
                io.branch.referral.Branch$SESSION_STATE r1 = io.branch.referral.Branch.SESSION_STATE.UNINITIALISED
                r0.setInitState(r1)
            L21:
                r0 = 400(0x190, float:5.6E-43)
                if (r5 == r0) goto L29
                r1 = 409(0x199, float:5.73E-43)
                if (r5 != r1) goto L35
            L29:
                io.branch.referral.ServerRequest r1 = r3.thisReq_
                boolean r2 = r1 instanceof io.branch.referral.ServerRequestCreateUrl
                if (r2 == 0) goto L35
                io.branch.referral.ServerRequestCreateUrl r1 = (io.branch.referral.ServerRequestCreateUrl) r1
                r1.handleDuplicateURLError()
                goto L43
            L35:
                io.branch.referral.ServerRequestQueue r1 = io.branch.referral.ServerRequestQueue.this
                r2 = 0
                r1.networkCount_ = r2
                io.branch.referral.ServerRequest r1 = r3.thisReq_
                java.lang.String r4 = r4.getFailReason()
                r1.handleFailure(r5, r4)
            L43:
                if (r0 > r5) goto L49
                r4 = 451(0x1c3, float:6.32E-43)
                if (r5 <= r4) goto L6d
            L49:
                r4 = -117(0xffffffffffffff8b, float:NaN)
                if (r5 != r4) goto L4e
                goto L6d
            L4e:
                io.branch.referral.ServerRequest r4 = r3.thisReq_
                boolean r4 = r4.shouldRetryOnFail()
                if (r4 == 0) goto L6d
                io.branch.referral.ServerRequest r4 = r3.thisReq_
                int r4 = r4.currentRetryCount
                io.branch.referral.Branch r5 = io.branch.referral.Branch.getInstance()
                io.branch.referral.PrefHelper r5 = r5.prefHelper_
                int r5 = r5.getNoConnectionRetryMax()
                if (r4 < r5) goto L67
                goto L6d
            L67:
                io.branch.referral.ServerRequest r4 = r3.thisReq_
                r4.clearCallbacks()
                goto L78
            L6d:
                io.branch.referral.Branch r4 = io.branch.referral.Branch.getInstance()
                io.branch.referral.ServerRequestQueue r4 = r4.requestQueue_
                io.branch.referral.ServerRequest r5 = r3.thisReq_
                r4.remove(r5)
            L78:
                io.branch.referral.ServerRequest r4 = r3.thisReq_
                int r5 = r4.currentRetryCount
                int r5 = r5 + 1
                r4.currentRetryCount = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestQueue.BranchPostTask.onRequestFailed(io.branch.referral.ServerResponse, int):void");
        }
    }

    public void addExtraInstrumentationData(HashMap<String, String> map) {
        this.instrumentationExtraData_.putAll(map);
    }

    public void addExtraInstrumentationData(String str, String str2) {
        this.instrumentationExtraData_.put(str, str2);
    }
}
