package io.branch.referral;

import android.content.Context;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import io.branch.referral.Defines;
import io.branch.referral.SystemObserver;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ServerRequest {
    private static final String POST_KEY = "REQ_POST";
    private static final String POST_PATH_KEY = "REQ_POST_PATH";
    private static final Defines.RequestPath[] initializationAndEventRoutes = {Defines.RequestPath.RegisterInstall, Defines.RequestPath.RegisterOpen, Defines.RequestPath.ContentEvent, Defines.RequestPath.TrackStandardEvent, Defines.RequestPath.TrackCustomEvent};
    public boolean constructError_;
    private final Context context_;
    public int currentRetryCount;
    private final Set<PROCESS_WAIT_LOCK> locks_;
    private JSONObject params_;
    protected final PrefHelper prefHelper_;
    private long queueWaitTime_;
    final Defines.RequestPath requestPath_;

    public enum BRANCH_API_VERSION {
        V1,
        V1_LATD,
        V2
    }

    enum PROCESS_WAIT_LOCK {
        SDK_INIT_WAIT_LOCK,
        GAID_FETCH_WAIT_LOCK,
        INTENT_PENDING_WAIT_LOCK,
        USER_SET_WAIT_LOCK,
        INSTALL_REFERRER_FETCH_WAIT_LOCK
    }

    public abstract void clearCallbacks();

    public abstract boolean handleErrors(Context context);

    public abstract void handleFailure(int i, String str);

    public boolean isGAdsParamsRequired() {
        return true;
    }

    public abstract boolean isGetRequest();

    boolean isPersistable() {
        return true;
    }

    public abstract void onRequestSucceeded(ServerResponse serverResponse, Branch branch);

    protected boolean prepareExecuteWithoutTracking() {
        return false;
    }

    public boolean shouldRetryOnFail() {
        return false;
    }

    protected boolean shouldUpdateLimitFacebookTracking() {
        return false;
    }

    public ServerRequest(Context context, Defines.RequestPath requestPath) {
        this.queueWaitTime_ = 0L;
        this.constructError_ = false;
        this.currentRetryCount = 0;
        this.context_ = context;
        this.requestPath_ = requestPath;
        this.prefHelper_ = PrefHelper.getInstance(context);
        this.params_ = new JSONObject();
        this.locks_ = new HashSet();
    }

    protected ServerRequest(Defines.RequestPath requestPath, JSONObject jSONObject, Context context) {
        this.queueWaitTime_ = 0L;
        this.constructError_ = false;
        this.currentRetryCount = 0;
        this.context_ = context;
        this.requestPath_ = requestPath;
        this.params_ = jSONObject;
        this.prefHelper_ = PrefHelper.getInstance(context);
        this.locks_ = new HashSet();
    }

    public final String getRequestPath() {
        return this.requestPath_.getPath();
    }

    public String getRequestUrl() {
        return this.prefHelper_.getAPIBaseUrl() + this.requestPath_.getPath();
    }

    protected void setPost(JSONObject jSONObject) throws JSONException {
        this.params_ = jSONObject;
        if (getBranchRemoteAPIVersion() == BRANCH_API_VERSION.V1) {
            DeviceInfo.getInstance().updateRequestWithV1Params(this, this.params_);
        } else {
            JSONObject jSONObject2 = new JSONObject();
            this.params_.put(Defines.Jsonkey.UserData.getKey(), jSONObject2);
            DeviceInfo.getInstance().updateRequestWithV2Params(this, this.prefHelper_, jSONObject2);
        }
        this.params_.put(Defines.Jsonkey.Debug.getKey(), Branch.isDeviceIDFetchDisabled());
    }

    public JSONObject getPost() {
        return this.params_;
    }

    public JSONObject getPostWithInstrumentationValues(ConcurrentHashMap<String, String> concurrentHashMap) {
        String string;
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                if (this.params_ != null) {
                    JSONObject jSONObject2 = this.params_;
                    if (jSONObject2 instanceof JSONObject) {
                        string = JSONObjectInstrumentation.toString(jSONObject2);
                    } else {
                        string = jSONObject2.toString();
                    }
                    JSONObject jSONObject3 = new JSONObject(string);
                    Iterator<String> itKeys = jSONObject3.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.put(next, jSONObject3.get(next));
                    }
                }
                if (concurrentHashMap.size() <= 0) {
                    return jSONObject;
                }
                JSONObject jSONObject4 = new JSONObject();
                try {
                    for (String str : concurrentHashMap.keySet()) {
                        jSONObject4.put(str, concurrentHashMap.get(str));
                        concurrentHashMap.remove(str);
                    }
                    jSONObject.put(Defines.Jsonkey.Branch_Instrumentation.getKey(), jSONObject4);
                    return jSONObject;
                } catch (JSONException e) {
                    BranchLogger.m5575d(e.getMessage());
                    return jSONObject;
                }
            } catch (ConcurrentModificationException unused) {
                return this.params_;
            }
        } catch (JSONException e2) {
            BranchLogger.m5575d(e2.getMessage());
            return jSONObject;
        }
    }

    public JSONObject getGetParams() {
        return this.params_;
    }

    protected void addGetParam(String str, String str2) {
        try {
            this.params_.put(str, str2);
        } catch (JSONException e) {
            BranchLogger.m5575d(e.getMessage());
        }
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(POST_KEY, this.params_);
            jSONObject.put(POST_PATH_KEY, this.requestPath_.getPath());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static ServerRequest fromJSON(JSONObject jSONObject, Context context) throws JSONException {
        String string = "";
        JSONObject jSONObject2 = jSONObject.has(POST_KEY) ? jSONObject.getJSONObject(POST_KEY) : null;
        try {
            if (jSONObject.has(POST_PATH_KEY)) {
                string = jSONObject.getString(POST_PATH_KEY);
            }
        } catch (JSONException unused) {
        }
        boolean z = true;
        try {
            if (jSONObject.has("INITIATED_BY_CLIENT")) {
                z = jSONObject.getBoolean("INITIATED_BY_CLIENT");
            }
        } catch (JSONException e) {
            BranchLogger.m5575d(e.getMessage());
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return getExtendedServerRequest(string, jSONObject2, context, z);
    }

    private static ServerRequest getExtendedServerRequest(String str, JSONObject jSONObject, Context context, boolean z) {
        if (str.equalsIgnoreCase(Defines.RequestPath.GetURL.getPath())) {
            return new ServerRequestCreateUrl(Defines.RequestPath.GetURL, jSONObject, context);
        }
        if (str.equalsIgnoreCase(Defines.RequestPath.IdentifyUser.getPath())) {
            return new ServerRequestIdentifyUserRequest(Defines.RequestPath.IdentifyUser, jSONObject, context);
        }
        if (str.equalsIgnoreCase(Defines.RequestPath.Logout.getPath())) {
            return new ServerRequestLogout(Defines.RequestPath.Logout, jSONObject, context);
        }
        if (str.equalsIgnoreCase(Defines.RequestPath.RegisterInstall.getPath())) {
            return new ServerRequestRegisterInstall(Defines.RequestPath.RegisterInstall, jSONObject, context, z);
        }
        if (str.equalsIgnoreCase(Defines.RequestPath.RegisterOpen.getPath())) {
            return new ServerRequestRegisterOpen(Defines.RequestPath.RegisterOpen, jSONObject, context, z);
        }
        return null;
    }

    void updateGAdsParams() {
        BRANCH_API_VERSION branchRemoteAPIVersion = getBranchRemoteAPIVersion();
        int lATVal = DeviceInfo.getInstance().getSystemObserver().getLATVal();
        String aid = DeviceInfo.getInstance().getSystemObserver().getAID();
        if (!TextUtils.isEmpty(aid)) {
            updateAdvertisingIdsObject(aid);
            replaceHardwareIdOnValidAdvertisingId();
        }
        try {
            if (branchRemoteAPIVersion == BRANCH_API_VERSION.V1) {
                this.params_.put(Defines.Jsonkey.LATVal.getKey(), lATVal);
                if (!TextUtils.isEmpty(aid)) {
                    if (!SystemObserver.isHuaweiMobileServicesAvailable(this.context_)) {
                        this.params_.put(Defines.Jsonkey.GoogleAdvertisingID.getKey(), aid);
                    }
                    this.params_.remove(Defines.Jsonkey.UnidentifiedDevice.getKey());
                    return;
                } else {
                    if (payloadContainsDeviceIdentifiers(this.params_) || this.params_.optBoolean(Defines.Jsonkey.UnidentifiedDevice.getKey())) {
                        return;
                    }
                    this.params_.put(Defines.Jsonkey.UnidentifiedDevice.getKey(), true);
                    return;
                }
            }
            JSONObject jSONObjectOptJSONObject = this.params_.optJSONObject(Defines.Jsonkey.UserData.getKey());
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject.put(Defines.Jsonkey.LimitedAdTracking.getKey(), lATVal);
                if (!TextUtils.isEmpty(aid)) {
                    if (!SystemObserver.isHuaweiMobileServicesAvailable(this.context_)) {
                        jSONObjectOptJSONObject.put(Defines.Jsonkey.AAID.getKey(), aid);
                    }
                    jSONObjectOptJSONObject.remove(Defines.Jsonkey.UnidentifiedDevice.getKey());
                } else {
                    if (payloadContainsDeviceIdentifiers(jSONObjectOptJSONObject) || jSONObjectOptJSONObject.optBoolean(Defines.Jsonkey.UnidentifiedDevice.getKey())) {
                        return;
                    }
                    jSONObjectOptJSONObject.put(Defines.Jsonkey.UnidentifiedDevice.getKey(), true);
                }
            }
        } catch (JSONException e) {
            BranchLogger.m5575d(e.getMessage());
        }
    }

    private void updateAdvertisingIdsObject(String str) {
        String key;
        try {
            if (SystemObserver.isFireOSDevice()) {
                key = Defines.Jsonkey.FireAdId.getKey();
            } else if (SystemObserver.isHuaweiMobileServicesAvailable(Branch.getInstance().getApplicationContext())) {
                key = Defines.Jsonkey.OpenAdvertisingID.getKey();
            } else {
                key = Defines.Jsonkey.AAID.getKey();
            }
            this.params_.put(Defines.Jsonkey.AdvertisingIDs.getKey(), new JSONObject().put(key, str));
        } catch (JSONException e) {
            BranchLogger.m5575d(e.getMessage());
        }
    }

    private void replaceHardwareIdOnValidAdvertisingId() {
        try {
            SystemObserver.UniqueId hardwareID = DeviceInfo.getInstance().getHardwareID();
            this.params_.put(Defines.Jsonkey.HardwareID.getKey(), hardwareID.getId());
            this.params_.put(Defines.Jsonkey.IsHardwareIDReal.getKey(), hardwareID.isReal());
            if (this.params_.has(Defines.Jsonkey.UserData.getKey())) {
                JSONObject jSONObject = this.params_.getJSONObject(Defines.Jsonkey.UserData.getKey());
                if (jSONObject.has(Defines.Jsonkey.AndroidID.getKey())) {
                    jSONObject.put(Defines.Jsonkey.AndroidID.getKey(), hardwareID.getId());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean payloadContainsDeviceIdentifiers(JSONObject jSONObject) {
        return jSONObject.has(Defines.Jsonkey.AndroidID.getKey()) || jSONObject.has(Defines.Jsonkey.RandomizedDeviceToken.getKey());
    }

    private void updateDeviceInfo() {
        JSONObject jSONObjectOptJSONObject;
        if (getBranchRemoteAPIVersion() != BRANCH_API_VERSION.V2 || (jSONObjectOptJSONObject = this.params_.optJSONObject(Defines.Jsonkey.UserData.getKey())) == null) {
            return;
        }
        try {
            jSONObjectOptJSONObject.put(Defines.Jsonkey.DeveloperIdentity.getKey(), this.prefHelper_.getIdentity());
            jSONObjectOptJSONObject.put(Defines.Jsonkey.RandomizedDeviceToken.getKey(), this.prefHelper_.getRandomizedDeviceToken());
        } catch (JSONException e) {
            BranchLogger.m5575d(e.getMessage());
        }
    }

    private void updateRequestMetadata() {
        try {
            JSONObject jSONObject = new JSONObject();
            Iterator<String> itKeys = this.prefHelper_.getRequestMetadata().keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, this.prefHelper_.getRequestMetadata().get(next));
            }
            JSONObject jSONObjectOptJSONObject = this.params_.optJSONObject(Defines.Jsonkey.Metadata.getKey());
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    jSONObject.put(next2, jSONObjectOptJSONObject.get(next2));
                }
            }
            if ((this instanceof ServerRequestRegisterInstall) && this.prefHelper_.getInstallMetadata().length() > 0) {
                Iterator<String> itKeys3 = this.prefHelper_.getInstallMetadata().keys();
                while (itKeys3.hasNext()) {
                    String next3 = itKeys3.next();
                    this.params_.putOpt(next3, this.prefHelper_.getInstallMetadata().get(next3));
                }
            }
            this.params_.put(Defines.Jsonkey.Metadata.getKey(), jSONObject);
        } catch (JSONException unused) {
            BranchLogger.m5578v("Could not merge metadata, ignoring user metadata.");
        }
    }

    private void updateLimitFacebookTracking() {
        boolean zIsAppTrackingLimited;
        JSONObject jSONObjectOptJSONObject = getBranchRemoteAPIVersion() == BRANCH_API_VERSION.V1 ? this.params_ : this.params_.optJSONObject(Defines.Jsonkey.UserData.getKey());
        if (jSONObjectOptJSONObject == null || !(zIsAppTrackingLimited = this.prefHelper_.isAppTrackingLimited())) {
            return;
        }
        try {
            jSONObjectOptJSONObject.putOpt(Defines.Jsonkey.limitFacebookTracking.getKey(), Boolean.valueOf(zIsAppTrackingLimited));
        } catch (JSONException e) {
            BranchLogger.m5575d(e.getMessage());
        }
    }

    private void updateDisableAdNetworkCallouts() {
        boolean adNetworkCalloutsDisabled;
        JSONObject jSONObjectOptJSONObject = getBranchRemoteAPIVersion() == BRANCH_API_VERSION.V1 ? this.params_ : this.params_.optJSONObject(Defines.Jsonkey.UserData.getKey());
        if (jSONObjectOptJSONObject == null || !(adNetworkCalloutsDisabled = this.prefHelper_.getAdNetworkCalloutsDisabled())) {
            return;
        }
        try {
            jSONObjectOptJSONObject.putOpt(Defines.Jsonkey.DisableAdNetworkCallouts.getKey(), Boolean.valueOf(adNetworkCalloutsDisabled));
        } catch (JSONException e) {
            BranchLogger.m5575d(e.getMessage());
        }
    }

    private boolean prioritizeLinkAttribution(JSONObject jSONObject) {
        return Branch.isReferringLinkAttributionForPreinstalledAppsEnabled() && jSONObject.has(Defines.Jsonkey.LinkIdentifier.getKey());
    }

    private void removePreinstallData(JSONObject jSONObject) {
        jSONObject.remove(Defines.PreinstallKey.partner.getKey());
        jSONObject.remove(Defines.PreinstallKey.campaign.getKey());
        jSONObject.remove(Defines.Jsonkey.GooglePlayInstallReferrer.getKey());
    }

    void doFinalUpdateOnMainThread() {
        updateRequestMetadata();
        if (shouldUpdateLimitFacebookTracking()) {
            updateLimitFacebookTracking();
        }
    }

    void doFinalUpdateOnBackgroundThread() {
        if (this instanceof ServerRequestInitSession) {
            ((ServerRequestInitSession) this).updateLinkReferrerParams();
            if (prioritizeLinkAttribution(this.params_)) {
                removePreinstallData(this.params_);
            }
        }
        updateDeviceInfo();
        updateDisableAdNetworkCallouts();
        if (isGAdsParamsRequired()) {
            updateGAdsParams();
        }
    }

    protected boolean doesAppHasInternetPermission(Context context) {
        int iCheckCallingOrSelfPermission = context.checkCallingOrSelfPermission("android.permission.INTERNET");
        if (iCheckCallingOrSelfPermission != 0) {
            BranchLogger.m5578v("Trouble executing your request. Please add 'android.permission.INTERNET' in your applications manifest file");
        }
        return iCheckCallingOrSelfPermission == 0;
    }

    public void onRequestQueued() {
        this.queueWaitTime_ = System.currentTimeMillis();
    }

    public long getQueueWaitTime() {
        if (this.queueWaitTime_ > 0) {
            return System.currentTimeMillis() - this.queueWaitTime_;
        }
        return 0L;
    }

    public void addProcessWaitLock(PROCESS_WAIT_LOCK process_wait_lock) {
        if (process_wait_lock != null) {
            this.locks_.add(process_wait_lock);
        }
    }

    public void removeProcessWaitLock(PROCESS_WAIT_LOCK process_wait_lock) {
        this.locks_.remove(process_wait_lock);
    }

    public boolean isWaitingOnProcessToFinish() {
        return this.locks_.size() > 0;
    }

    public void onPreExecute() {
        if ((this instanceof ServerRequestRegisterOpen) || (this instanceof ServerRequestLogEvent)) {
            try {
                ReferringUrlUtility referringUrlUtility = new ReferringUrlUtility(this.prefHelper_);
                referringUrlUtility.parseReferringURL(this.prefHelper_.getExternalIntentUri());
                JSONObject uRLQueryParamsForRequest = referringUrlUtility.getURLQueryParamsForRequest(this);
                Iterator<String> itKeys = uRLQueryParamsForRequest.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.params_.put(next, uRLQueryParamsForRequest.get(next));
                }
            } catch (Exception e) {
                BranchLogger.logException("Caught exception in onPreExecute: ", e);
            }
        }
    }

    protected void updateEnvironment(Context context, JSONObject jSONObject) {
        try {
            String key = (DeviceInfo.getInstance().isPackageInstalled() ? Defines.Jsonkey.NativeApp : Defines.Jsonkey.InstantApp).getKey();
            if (getBranchRemoteAPIVersion() == BRANCH_API_VERSION.V2) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(Defines.Jsonkey.UserData.getKey());
                if (jSONObjectOptJSONObject != null) {
                    jSONObjectOptJSONObject.put(Defines.Jsonkey.Environment.getKey(), key);
                    return;
                }
                return;
            }
            jSONObject.put(Defines.Jsonkey.Environment.getKey(), key);
        } catch (Exception e) {
            BranchLogger.m5575d(e.getMessage());
        }
    }

    public BRANCH_API_VERSION getBranchRemoteAPIVersion() {
        return BRANCH_API_VERSION.V1;
    }
}
