package io.branch.referral;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.android.billingclient.api.Purchase;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.Defines;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerRequestGetLATD;
import io.branch.referral.SystemObserver;
import io.branch.referral.network.BranchRemoteInterface;
import io.branch.referral.network.BranchRemoteInterfaceUrlConnection;
import io.branch.referral.util.BRANCH_STANDARD_EVENT;
import io.branch.referral.util.BranchEvent;
import io.branch.referral.util.DependencyUtilsKt;
import io.branch.referral.util.LinkProperties;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class Branch {
    public static final String ALWAYS_DEEPLINK = "$always_deeplink";
    private static final String AUTO_DEEP_LINK_DISABLE = "io.branch.sdk.auto_link_disable";
    private static final String AUTO_DEEP_LINK_KEY = "io.branch.sdk.auto_link_keys";
    private static final String AUTO_DEEP_LINK_PATH = "io.branch.sdk.auto_link_path";
    private static final String AUTO_DEEP_LINK_REQ_CODE = "io.branch.sdk.auto_link_request_code";
    private static final String BRANCH_LIBRARY_VERSION;
    public static final String DEEPLINK_PATH = "$deeplink_path";
    private static final int DEF_AUTO_DEEP_LINK_REQ_CODE = 1501;
    private static final String[] EXTERNAL_INTENT_EXTRA_KEY_WHITE_LIST;
    public static final String FEATURE_TAG_SHARE = "share";
    private static final String GOOGLE_VERSION_TAG;
    private static final int LATCH_WAIT_UNTIL = 2500;
    public static final int LINK_TYPE_ONE_TIME_USE = 1;
    public static final int LINK_TYPE_UNLIMITED_USE = 0;
    public static final String OG_APP_ID = "$og_app_id";
    public static final String OG_DESC = "$og_description";
    public static final String OG_IMAGE_URL = "$og_image_url";
    public static final String OG_TITLE = "$og_title";
    public static final String OG_URL = "$og_url";
    public static final String OG_VIDEO = "$og_video";
    public static final String REDIRECT_ANDROID_URL = "$android_url";
    public static final String REDIRECT_BLACKBERRY_URL = "$blackberry_url";
    public static final String REDIRECT_DESKTOP_URL = "$desktop_url";
    public static final String REDIRECT_FIRE_URL = "$fire_url";
    public static final String REDIRECT_IOS_URL = "$ios_url";
    public static final String REDIRECT_IPAD_URL = "$ipad_url";
    public static final String REDIRECT_WINDOWS_PHONE_URL = "$windows_phone_url";
    static String _userAgentString;
    private static Branch branchReferral_;
    private static boolean bypassCurrentActivityIntentState_;
    static boolean bypassWaitingForIntent_;
    static boolean deferInitForPluginRuntime;
    static boolean disableAutoSessionInitialization;
    private static boolean disableDeviceIDFetch_;
    private static boolean enableInstantDeepLinking;
    public static String installDeveloperId;
    private static boolean isActivityLifeCycleCallbackRegistered_;
    private static String pluginName;
    private static String pluginVersion;
    static boolean referringLinkAttributionForPreinstalledAppsEnabled;
    static boolean userAgentSync;
    private BranchActivityLifecycleObserver activityLifeCycleObserver;
    private final BranchPluginSupport branchPluginSupport_;
    private final BranchQRCodeCache branchQRCodeCache_;
    private final Context context_;
    WeakReference<Activity> currentActivityReference_;
    private JSONObject deeplinkDebugParams_;
    private BranchReferralInitListener deferredCallback;
    private InitSessionBuilder deferredSessionBuilder;
    private Uri deferredUri;
    private final DeviceInfo deviceInfo_;
    final PrefHelper prefHelper_;
    public final ServerRequestQueue requestQueue_;
    private ShareLinkManager shareLinkManager_;
    private final TrackingController trackingController;
    final ConcurrentHashMap<BranchLinkData, String> linkCache_ = new ConcurrentHashMap<>();
    private INTENT_STATE intentState_ = INTENT_STATE.PENDING;
    SESSION_STATE initState_ = SESSION_STATE.UNINITIALISED;
    public boolean closeRequestNeeded = false;
    CountDownLatch getFirstReferringParamsLatch = null;
    CountDownLatch getLatestReferringParamsLatch = null;
    private boolean isInstantDeepLinkPossible = false;
    private BranchRemoteInterface branchRemoteInterface_ = new BranchRemoteInterfaceUrlConnection(this);

    public interface BranchLinkCreateListener {
        void onLinkCreate(String str, BranchError branchError);
    }

    public interface BranchLinkShareListener {
        void onChannelSelected(String str);

        void onLinkShareResponse(String str, String str2, BranchError branchError);

        void onShareLinkDialogDismissed();

        void onShareLinkDialogLaunched();
    }

    public interface BranchListResponseListener {
        void onReceivingResponse(JSONArray jSONArray, BranchError branchError);
    }

    public interface BranchReferralInitListener {
        void onInitFinished(JSONObject jSONObject, BranchError branchError);
    }

    public interface BranchReferralStateChangedListener {
        void onStateChanged(boolean z, BranchError branchError);
    }

    public interface BranchUniversalReferralInitListener {
        void onInitFinished(BranchUniversalObject branchUniversalObject, LinkProperties linkProperties, BranchError branchError);
    }

    public interface ExtendedBranchLinkShareListener extends BranchLinkShareListener {
        boolean onChannelSelected(String str, BranchUniversalObject branchUniversalObject, LinkProperties linkProperties);
    }

    public interface IChannelProperties {
        String getSharingMessageForChannel(String str);

        String getSharingTitleForChannel(String str);
    }

    enum INTENT_STATE {
        PENDING,
        READY
    }

    public interface LogoutStatusListener {
        void onLogoutFinished(boolean z, BranchError branchError);
    }

    enum SESSION_STATE {
        INITIALISED,
        INITIALISING,
        UNINITIALISED
    }

    public void disableAppList() {
    }

    static {
        String str = "io.branch.sdk.android:library:" + getSdkVersionNumber();
        BRANCH_LIBRARY_VERSION = str;
        GOOGLE_VERSION_TAG = "!SDK-VERSION-STRING!:" + str;
        _userAgentString = "";
        bypassWaitingForIntent_ = false;
        bypassCurrentActivityIntentState_ = false;
        referringLinkAttributionForPreinstalledAppsEnabled = false;
        isActivityLifeCycleCallbackRegistered_ = false;
        deferInitForPluginRuntime = false;
        EXTERNAL_INTENT_EXTRA_KEY_WHITE_LIST = new String[]{"extra_launch_uri", "branch_intent"};
        installDeveloperId = null;
        enableInstantDeepLinking = false;
        pluginVersion = null;
        pluginName = null;
    }

    private Branch(Context context) {
        this.context_ = context;
        this.prefHelper_ = PrefHelper.getInstance(context);
        this.trackingController = new TrackingController(context);
        this.deviceInfo_ = new DeviceInfo(context);
        this.branchPluginSupport_ = new BranchPluginSupport(context);
        this.branchQRCodeCache_ = new BranchQRCodeCache(context);
        this.requestQueue_ = ServerRequestQueue.getInstance(context);
    }

    public static synchronized Branch getInstance() {
        if (branchReferral_ == null) {
            BranchLogger.m5578v("Branch instance is not created yet. Make sure you call getAutoInstance(Context).");
        }
        return branchReferral_;
    }

    private static synchronized Branch initBranchSDK(Context context, String str) {
        if (branchReferral_ != null) {
            BranchLogger.m5579w("Warning, attempted to reinitialize Branch SDK singleton!");
            return branchReferral_;
        }
        branchReferral_ = new Branch(context.getApplicationContext());
        if (TextUtils.isEmpty(str)) {
            BranchLogger.m5579w("Warning: Please enter your branch_key in your project's Manifest file!");
            branchReferral_.prefHelper_.setBranchKey(PrefHelper.NO_STRING_VALUE);
        } else {
            branchReferral_.prefHelper_.setBranchKey(str);
        }
        if (context instanceof Application) {
            branchReferral_.setActivityLifeCycleObserver((Application) context);
        }
        if (userAgentSync && DeviceInfo.getInstance() != null) {
            DeviceInfo.getInstance().getUserAgentStringSync(context);
        }
        return branchReferral_;
    }

    public static synchronized Branch getAutoInstance(Context context) {
        if (branchReferral_ == null) {
            if (BranchUtil.getEnableLoggingConfig(context)) {
                enableLogging();
            }
            deferInitForPluginRuntime(BranchUtil.getDeferInitForPluginRuntimeConfig(context));
            BranchUtil.setTestMode(BranchUtil.checkTestMode(context));
            Branch branchInitBranchSDK = initBranchSDK(context, BranchUtil.readBranchKey(context));
            branchReferral_ = branchInitBranchSDK;
            BranchPreinstall.getPreinstallSystemData(branchInitBranchSDK, context);
        }
        return branchReferral_;
    }

    public static Branch getAutoInstance(Context context, String str) {
        if (branchReferral_ == null) {
            if (BranchUtil.getEnableLoggingConfig(context)) {
                enableLogging();
            }
            deferInitForPluginRuntime(BranchUtil.getDeferInitForPluginRuntimeConfig(context));
            BranchUtil.setTestMode(BranchUtil.checkTestMode(context));
            if (!PrefHelper.isValidBranchKey(str)) {
                BranchLogger.m5579w("Warning, Invalid branch key passed! Branch key will be read from manifest instead!");
                str = BranchUtil.readBranchKey(context);
            }
            Branch branchInitBranchSDK = initBranchSDK(context, str);
            branchReferral_ = branchInitBranchSDK;
            BranchPreinstall.getPreinstallSystemData(branchInitBranchSDK, context);
        }
        return branchReferral_;
    }

    public Context getApplicationContext() {
        return this.context_;
    }

    public void setBranchRemoteInterface(BranchRemoteInterface branchRemoteInterface) {
        if (branchRemoteInterface == null) {
            this.branchRemoteInterface_ = new BranchRemoteInterfaceUrlConnection(this);
        } else {
            this.branchRemoteInterface_ = branchRemoteInterface;
        }
    }

    public BranchRemoteInterface getBranchRemoteInterface() {
        return this.branchRemoteInterface_;
    }

    public static void enableTestMode() {
        BranchUtil.setTestMode(true);
        BranchLogger.logAlways("enableTestMode has been changed. It now uses the test key but will not log or randomize the device IDs. If you wish to enable logging, please invoke enableLogging. If you wish to simulate installs, please see add a Test Device (https://help.branch.io/using-branch/docs/adding-test-devices) then reset your test device's data (https://help.branch.io/using-branch/docs/adding-test-devices#section-resetting-your-test-device-data).");
    }

    public static void disableTestMode() {
        BranchUtil.setTestMode(false);
    }

    public void disableAdNetworkCallouts(boolean z) {
        PrefHelper.getInstance(this.context_).setAdNetworkCalloutsDisabled(z);
    }

    public static void expectDelayedSessionInitialization(boolean z) {
        disableAutoSessionInitialization = z;
    }

    public static void setAPIUrl(String str) {
        PrefHelper.setAPIUrl(str);
    }

    public static void setCDNBaseUrl(String str) {
        PrefHelper.setCDNBaseUrl(str);
    }

    public void disableTracking(boolean z) {
        this.trackingController.disableTracking(this.context_, z);
    }

    public boolean isTrackingDisabled() {
        return this.trackingController.isTrackingDisabled();
    }

    public static void disableInstantDeepLinking(boolean z) {
        enableInstantDeepLinking = !z;
    }

    static void shutDown() {
        ServerRequestQueue.shutDown();
        PrefHelper.shutDown();
        BranchUtil.shutDown();
        branchReferral_ = null;
        bypassCurrentActivityIntentState_ = false;
        enableInstantDeepLinking = false;
        isActivityLifeCycleCallbackRegistered_ = false;
        bypassWaitingForIntent_ = false;
    }

    public void resetUserSession() {
        setInitState(SESSION_STATE.UNINITIALISED);
    }

    public void setRetryCount(int i) {
        PrefHelper prefHelper = this.prefHelper_;
        if (prefHelper == null || i < 0) {
            return;
        }
        prefHelper.setRetryCount(i);
    }

    public void setRetryInterval(int i) {
        PrefHelper prefHelper = this.prefHelper_;
        if (prefHelper == null || i <= 0) {
            return;
        }
        prefHelper.setRetryInterval(i);
    }

    public void setNetworkTimeout(int i) {
        PrefHelper prefHelper = this.prefHelper_;
        if (prefHelper == null || i <= 0) {
            return;
        }
        prefHelper.setTimeout(i);
    }

    public void setNetworkConnectTimeout(int i) {
        PrefHelper prefHelper = this.prefHelper_;
        if (prefHelper == null || i <= 0) {
            return;
        }
        prefHelper.setConnectTimeout(i);
    }

    public void setNoConnectionRetryMax(int i) {
        PrefHelper prefHelper = this.prefHelper_;
        if (prefHelper == null || i <= 0) {
            return;
        }
        prefHelper.setNoConnectionRetryMax(i);
    }

    public void setReferrerGclidValidForWindow(long j) {
        PrefHelper prefHelper = this.prefHelper_;
        if (prefHelper != null) {
            prefHelper.setReferrerGclidValidForWindow(j);
        }
    }

    public static void disableDeviceIDFetch(Boolean bool) {
        disableDeviceIDFetch_ = bool.booleanValue();
    }

    public static boolean isDeviceIDFetchDisabled() {
        return disableDeviceIDFetch_;
    }

    public void setDeepLinkDebugMode(JSONObject jSONObject) {
        this.deeplinkDebugParams_ = jSONObject;
    }

    public void setLimitFacebookTracking(boolean z) {
        this.prefHelper_.setLimitFacebookTracking(z);
    }

    public void setRequestMetadata(String str, String str2) {
        this.prefHelper_.setRequestMetadata(str, str2);
    }

    public Branch addInstallMetadata(String str, String str2) {
        this.prefHelper_.addInstallMetadata(str, str2);
        return this;
    }

    public Branch setPreinstallCampaign(String str) {
        addInstallMetadata(Defines.PreinstallKey.campaign.getKey(), str);
        return this;
    }

    public Branch setPreinstallPartner(String str) {
        addInstallMetadata(Defines.PreinstallKey.partner.getKey(), str);
        return this;
    }

    public static void setReferringLinkAttributionForPreinstalledAppsEnabled() {
        referringLinkAttributionForPreinstalledAppsEnabled = true;
    }

    public static boolean isReferringLinkAttributionForPreinstalledAppsEnabled() {
        return referringLinkAttributionForPreinstalledAppsEnabled;
    }

    public static void setIsUserAgentSync(boolean z) {
        userAgentSync = z;
    }

    void closeSessionInternal() {
        clearPartnerParameters();
        executeClose();
        this.prefHelper_.setSessionParams(PrefHelper.NO_STRING_VALUE);
        this.prefHelper_.setExternalIntentUri(null);
        this.trackingController.updateTrackingState(this.context_);
    }

    void clearPendingRequests() {
        this.requestQueue_.clear();
    }

    private void executeClose() {
        if (this.initState_ != SESSION_STATE.UNINITIALISED) {
            setInitState(SESSION_STATE.UNINITIALISED);
        }
    }

    public static void registerPlugin(String str, String str2) {
        pluginName = str;
        pluginVersion = str2;
    }

    public static String getPluginVersion() {
        return pluginVersion;
    }

    static String getPluginName() {
        return pluginName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readAndStripParam(Uri uri, Activity activity) {
        if (enableInstantDeepLinking) {
            boolean z = this.intentState_ == INTENT_STATE.READY || !this.activityLifeCycleObserver.isCurrentActivityLaunchedFromStack();
            boolean zIsRestartSessionRequested = isRestartSessionRequested(activity != null ? activity.getIntent() : null);
            if (z && !zIsRestartSessionRequested) {
                extractSessionParamsForIDL(uri, activity);
            }
        }
        if (bypassCurrentActivityIntentState_) {
            this.intentState_ = INTENT_STATE.READY;
        }
        if (this.intentState_ == INTENT_STATE.READY) {
            extractExternalUriAndIntentExtras(uri, activity);
            if (extractBranchLinkFromIntentExtra(activity) || isActivityLaunchedFromHistory(activity) || extractClickID(uri, activity)) {
                return;
            }
            extractAppLink(uri, activity);
        }
    }

    void unlockSDKInitWaitLock() {
        ServerRequestQueue serverRequestQueue = this.requestQueue_;
        if (serverRequestQueue == null) {
            return;
        }
        serverRequestQueue.unlockProcessWait(ServerRequest.PROCESS_WAIT_LOCK.SDK_INIT_WAIT_LOCK);
        this.requestQueue_.processNextQueueItem();
    }

    private boolean isIntentParamsAlreadyConsumed(Activity activity) {
        return (activity == null || activity.getIntent() == null || !activity.getIntent().getBooleanExtra(Defines.IntentKeys.BranchLinkUsed.getKey(), false)) ? false : true;
    }

    private boolean isActivityLaunchedFromHistory(Activity activity) {
        return (activity == null || activity.getIntent() == null || (activity.getIntent().getFlags() & 1048576) == 0) ? false : true;
    }

    String getSessionReferredLink() {
        String externalIntentUri = this.prefHelper_.getExternalIntentUri();
        if (externalIntentUri.equals(PrefHelper.NO_STRING_VALUE)) {
            return null;
        }
        return externalIntentUri;
    }

    public Branch addWhiteListedScheme(String str) {
        if (str != null) {
            UniversalResourceAnalyser.getInstance(this.context_).addToAcceptURLFormats(str);
        }
        return this;
    }

    public Branch setWhiteListedSchemes(List<String> list) {
        if (list != null) {
            UniversalResourceAnalyser.getInstance(this.context_).addToAcceptURLFormats(list);
        }
        return this;
    }

    public Branch addUriHostsToSkip(String str) {
        if (!TextUtils.isEmpty(str)) {
            UniversalResourceAnalyser.getInstance(this.context_).addToSkipURLFormats(str);
        }
        return this;
    }

    void updateSkipURLFormats() {
        UniversalResourceAnalyser.getInstance(this.context_).checkAndUpdateSkipURLFormats(this.context_);
    }

    public void setIdentity(String str) {
        setIdentity(str, null);
    }

    public void setIdentity(String str, BranchReferralInitListener branchReferralInitListener) {
        installDeveloperId = str;
        ServerRequestIdentifyUserRequest serverRequestIdentifyUserRequest = new ServerRequestIdentifyUserRequest(this.context_, branchReferralInitListener, str);
        if (!serverRequestIdentifyUserRequest.constructError_ && !serverRequestIdentifyUserRequest.handleErrors(this.context_)) {
            this.requestQueue_.handleNewRequest(serverRequestIdentifyUserRequest);
        } else if (serverRequestIdentifyUserRequest.isExistingID()) {
            serverRequestIdentifyUserRequest.handleUserExist(branchReferral_);
        }
    }

    public void getLastAttributedTouchData(ServerRequestGetLATD.BranchLastAttributedTouchDataListener branchLastAttributedTouchDataListener) {
        if (this.context_ != null) {
            this.requestQueue_.handleNewRequest(new ServerRequestGetLATD(this.context_, Defines.RequestPath.GetLATD, branchLastAttributedTouchDataListener));
        }
    }

    public void getLastAttributedTouchData(ServerRequestGetLATD.BranchLastAttributedTouchDataListener branchLastAttributedTouchDataListener, int i) {
        if (this.context_ != null) {
            this.requestQueue_.handleNewRequest(new ServerRequestGetLATD(this.context_, Defines.RequestPath.GetLATD, branchLastAttributedTouchDataListener, i));
        }
    }

    public boolean isUserIdentified() {
        return !this.prefHelper_.getIdentity().equals(PrefHelper.NO_STRING_VALUE);
    }

    public void logout() {
        logout(null);
    }

    public void logout(LogoutStatusListener logoutStatusListener) {
        ServerRequestLogout serverRequestLogout = new ServerRequestLogout(this.context_, logoutStatusListener);
        if (serverRequestLogout.constructError_ || serverRequestLogout.handleErrors(this.context_)) {
            return;
        }
        this.requestQueue_.handleNewRequest(serverRequestLogout);
    }

    public JSONObject getFirstReferringParams() {
        return appendDebugParams(convertParamsStringToDictionary(this.prefHelper_.getInstallParams()));
    }

    public void removeSessionInitializationDelay() {
        this.requestQueue_.unlockProcessWait(ServerRequest.PROCESS_WAIT_LOCK.USER_SET_WAIT_LOCK);
        this.requestQueue_.processNextQueueItem();
    }

    public JSONObject getFirstReferringParamsSync() {
        this.getFirstReferringParamsLatch = new CountDownLatch(1);
        if (this.prefHelper_.getInstallParams().equals(PrefHelper.NO_STRING_VALUE)) {
            try {
                this.getFirstReferringParamsLatch.await(2500L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
            }
        }
        JSONObject jSONObjectAppendDebugParams = appendDebugParams(convertParamsStringToDictionary(this.prefHelper_.getInstallParams()));
        this.getFirstReferringParamsLatch = null;
        return jSONObjectAppendDebugParams;
    }

    public JSONObject getLatestReferringParams() {
        return appendDebugParams(convertParamsStringToDictionary(this.prefHelper_.getSessionParams()));
    }

    public JSONObject getLatestReferringParamsSync() {
        this.getLatestReferringParamsLatch = new CountDownLatch(1);
        try {
            if (this.initState_ != SESSION_STATE.INITIALISED) {
                this.getLatestReferringParamsLatch.await(2500L, TimeUnit.MILLISECONDS);
            }
        } catch (InterruptedException unused) {
        }
        JSONObject jSONObjectAppendDebugParams = appendDebugParams(convertParamsStringToDictionary(this.prefHelper_.getSessionParams()));
        this.getLatestReferringParamsLatch = null;
        return jSONObjectAppendDebugParams;
    }

    public void addFacebookPartnerParameterWithName(String str, String str2) {
        if (this.trackingController.isTrackingDisabled()) {
            return;
        }
        this.prefHelper_.partnerParams_.addFacebookParameter(str, str2);
    }

    public void addSnapPartnerParameterWithName(String str, String str2) {
        if (this.trackingController.isTrackingDisabled()) {
            return;
        }
        this.prefHelper_.partnerParams_.addSnapParameter(str, str2);
    }

    public void clearPartnerParameters() {
        this.prefHelper_.partnerParams_.clearAllParameters();
    }

    private JSONObject appendDebugParams(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = this.deeplinkDebugParams_;
                if (jSONObject2 != null) {
                    if (jSONObject2.length() > 0) {
                        BranchLogger.m5578v("You're currently in deep link debug mode. Please comment out 'setDeepLinkDebugMode' to receive the deep link parameters from a real Branch link");
                    }
                    Iterator<String> itKeys = this.deeplinkDebugParams_.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.put(next, this.deeplinkDebugParams_.get(next));
                    }
                }
            } catch (Exception e) {
                BranchLogger.m5575d(e.getMessage());
            }
        }
        return jSONObject;
    }

    public JSONObject getDeeplinkDebugParams() {
        JSONObject jSONObject = this.deeplinkDebugParams_;
        if (jSONObject != null && jSONObject.length() > 0) {
            BranchLogger.m5578v("You're currently in deep link debug mode. Please comment out 'setDeepLinkDebugMode' to receive the deep link parameters from a real Branch link");
        }
        return this.deeplinkDebugParams_;
    }

    String generateShortLinkInternal(ServerRequestCreateUrl serverRequestCreateUrl) {
        if (serverRequestCreateUrl.constructError_ || serverRequestCreateUrl.handleErrors(this.context_)) {
            return null;
        }
        if (this.linkCache_.containsKey(serverRequestCreateUrl.getLinkPost())) {
            String str = this.linkCache_.get(serverRequestCreateUrl.getLinkPost());
            serverRequestCreateUrl.onUrlAvailable(str);
            return str;
        }
        if (serverRequestCreateUrl.isAsync()) {
            this.requestQueue_.handleNewRequest(serverRequestCreateUrl);
            return null;
        }
        return generateShortLinkSync(serverRequestCreateUrl);
    }

    void shareLink(BranchShareSheetBuilder branchShareSheetBuilder) {
        ShareLinkManager shareLinkManager = this.shareLinkManager_;
        if (shareLinkManager != null) {
            shareLinkManager.cancelShareLinkDialog(true);
        }
        ShareLinkManager shareLinkManager2 = new ShareLinkManager();
        this.shareLinkManager_ = shareLinkManager2;
        shareLinkManager2.shareLink(branchShareSheetBuilder);
    }

    public void cancelShareLinkDialog(boolean z) {
        ShareLinkManager shareLinkManager = this.shareLinkManager_;
        if (shareLinkManager != null) {
            shareLinkManager.cancelShareLinkDialog(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String generateShortLinkSync(ServerRequestCreateUrl serverRequestCreateUrl) {
        ServerResponse serverResponse;
        Object[] objArr = 0;
        try {
            int timeout = this.prefHelper_.getTimeout() + 2000;
            GetShortLinkTask getShortLinkTask = new GetShortLinkTask();
            ServerRequest[] serverRequestArr = {serverRequestCreateUrl};
            serverResponse = (!(getShortLinkTask instanceof AsyncTask) ? getShortLinkTask.execute(serverRequestArr) : AsyncTaskInstrumentation.execute(getShortLinkTask, serverRequestArr)).get(timeout, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            BranchLogger.m5575d(e.getMessage());
            serverResponse = null;
        }
        String longUrl = serverRequestCreateUrl.isDefaultToLongUrl() ? serverRequestCreateUrl.getLongUrl() : null;
        if (serverResponse != null && serverResponse.getStatusCode() == 200) {
            try {
                longUrl = serverResponse.getObject().getString("url");
                if (serverRequestCreateUrl.getLinkPost() != null) {
                    this.linkCache_.put(serverRequestCreateUrl.getLinkPost(), longUrl);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return longUrl;
    }

    private JSONObject convertParamsStringToDictionary(String str) {
        if (str.equals(PrefHelper.NO_STRING_VALUE)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            try {
                return new JSONObject(new String(Base64.decode(str.getBytes(), 2)));
            } catch (JSONException e) {
                e.printStackTrace();
                return new JSONObject();
            }
        }
    }

    public TrackingController getTrackingController() {
        return this.trackingController;
    }

    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo_;
    }

    public BranchPluginSupport getBranchPluginSupport() {
        return this.branchPluginSupport_;
    }

    public BranchQRCodeCache getBranchQRCodeCache() {
        return this.branchQRCodeCache_;
    }

    PrefHelper getPrefHelper() {
        return this.prefHelper_;
    }

    ShareLinkManager getShareLinkManager() {
        return this.shareLinkManager_;
    }

    void setIntentState(INTENT_STATE intent_state) {
        this.intentState_ = intent_state;
    }

    void setInitState(SESSION_STATE session_state) {
        this.initState_ = session_state;
    }

    SESSION_STATE getInitState() {
        return this.initState_;
    }

    public void setInstantDeepLinkPossible(boolean z) {
        this.isInstantDeepLinkPossible = z;
    }

    public boolean isInstantDeepLinkPossible() {
        return this.isInstantDeepLinkPossible;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeSession(ServerRequestInitSession serverRequestInitSession, int i) {
        if (this.prefHelper_.getBranchKey() == null || this.prefHelper_.getBranchKey().equalsIgnoreCase(PrefHelper.NO_STRING_VALUE)) {
            setInitState(SESSION_STATE.UNINITIALISED);
            if (serverRequestInitSession.callback_ != null) {
                serverRequestInitSession.callback_.onInitFinished(null, new BranchError("Trouble initializing Branch.", BranchError.ERR_BRANCH_KEY_INVALID));
            }
            BranchLogger.m5579w("Warning: Please enter your branch_key in your project's manifest");
            return;
        }
        if (BranchUtil.isTestModeEnabled()) {
            BranchLogger.m5579w("Warning: You are using your test app's Branch Key. Remember to change it to live Branch Key during deployment.");
        }
        if (i > 0) {
            serverRequestInitSession.addProcessWaitLock(ServerRequest.PROCESS_WAIT_LOCK.USER_SET_WAIT_LOCK);
            new Handler().postDelayed(new Runnable() { // from class: io.branch.referral.Branch.1
                @Override // java.lang.Runnable
                public void run() {
                    Branch.this.removeSessionInitializationDelay();
                }
            }, i);
        }
        Intent intent = getCurrentActivity() != null ? getCurrentActivity().getIntent() : null;
        boolean zIsRestartSessionRequested = isRestartSessionRequested(intent);
        if (getInitState() == SESSION_STATE.UNINITIALISED || zIsRestartSessionRequested) {
            if (zIsRestartSessionRequested && intent != null) {
                intent.removeExtra(Defines.IntentKeys.ForceNewBranchSession.getKey());
            }
            registerAppInit(serverRequestInitSession, false);
            return;
        }
        if (serverRequestInitSession.callback_ != null) {
            serverRequestInitSession.callback_.onInitFinished(null, new BranchError("Warning.", BranchError.ERR_BRANCH_ALREADY_INITIALIZED));
        }
    }

    void registerAppInit(ServerRequestInitSession serverRequestInitSession, boolean z) {
        setInitState(SESSION_STATE.INITIALISING);
        ServerRequestInitSession selfInitRequest = this.requestQueue_.getSelfInitRequest();
        if (selfInitRequest == null) {
            this.requestQueue_.insertRequestAtFront(serverRequestInitSession);
        } else {
            selfInitRequest.callback_ = serverRequestInitSession.callback_;
        }
        initTasks(serverRequestInitSession, z);
        this.requestQueue_.processNextQueueItem();
    }

    private void initTasks(final ServerRequest serverRequest, boolean z) {
        if (!z) {
            if (this.intentState_ != INTENT_STATE.READY && isWaitingForIntent()) {
                serverRequest.addProcessWaitLock(ServerRequest.PROCESS_WAIT_LOCK.INTENT_PENDING_WAIT_LOCK);
            }
            serverRequest.addProcessWaitLock(ServerRequest.PROCESS_WAIT_LOCK.GAID_FETCH_WAIT_LOCK);
            if (serverRequest instanceof ServerRequestRegisterInstall) {
                serverRequest.addProcessWaitLock(ServerRequest.PROCESS_WAIT_LOCK.INSTALL_REFERRER_FETCH_WAIT_LOCK);
                this.deviceInfo_.getSystemObserver().fetchInstallReferrer(this.context_, new SystemObserver.InstallReferrerFetchEvents() { // from class: io.branch.referral.Branch.2
                    @Override // io.branch.referral.SystemObserver.InstallReferrerFetchEvents
                    public void onInstallReferrersFinished() {
                        serverRequest.removeProcessWaitLock(ServerRequest.PROCESS_WAIT_LOCK.INSTALL_REFERRER_FETCH_WAIT_LOCK);
                        BranchLogger.m5578v("calling processNextQueueItem from onInstallReferrersFinished");
                        Branch.this.requestQueue_.processNextQueueItem();
                    }
                });
            }
        }
        this.deviceInfo_.getSystemObserver().fetchAdId(this.context_, new SystemObserver.AdsParamsFetchEvents() { // from class: io.branch.referral.Branch.3
            @Override // io.branch.referral.SystemObserver.AdsParamsFetchEvents
            public void onAdsParamsFetchFinished() {
                Branch.this.requestQueue_.unlockProcessWait(ServerRequest.PROCESS_WAIT_LOCK.GAID_FETCH_WAIT_LOCK);
                Branch.this.requestQueue_.processNextQueueItem();
            }
        });
    }

    ServerRequestInitSession getInstallOrOpenRequest(BranchReferralInitListener branchReferralInitListener, boolean z) {
        if (this.requestQueue_.hasUser()) {
            return new ServerRequestRegisterOpen(this.context_, branchReferralInitListener, z);
        }
        return new ServerRequestRegisterInstall(this.context_, branchReferralInitListener, z);
    }

    void onIntentReady(Activity activity) {
        setIntentState(INTENT_STATE.READY);
        this.requestQueue_.unlockProcessWait(ServerRequest.PROCESS_WAIT_LOCK.INTENT_PENDING_WAIT_LOCK);
        if (activity.getIntent() != null && getInitState() != SESSION_STATE.INITIALISED) {
            readAndStripParam(activity.getIntent().getData(), activity);
        }
        this.requestQueue_.processNextQueueItem();
    }

    public void notifyNetworkAvailable() {
        this.requestQueue_.processNextQueueItem();
    }

    private void setActivityLifeCycleObserver(Application application) {
        try {
            BranchActivityLifecycleObserver branchActivityLifecycleObserver = new BranchActivityLifecycleObserver();
            this.activityLifeCycleObserver = branchActivityLifecycleObserver;
            application.unregisterActivityLifecycleCallbacks(branchActivityLifecycleObserver);
            application.registerActivityLifecycleCallbacks(this.activityLifeCycleObserver);
            isActivityLifeCycleCallbackRegistered_ = true;
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
            isActivityLifeCycleCallbackRegistered_ = false;
            BranchLogger.m5578v(new BranchError("", BranchError.ERR_API_LVL_14_NEEDED).getMessage());
        }
    }

    boolean isRestartSessionRequested(Intent intent) {
        return checkIntentForSessionRestart(intent) || checkIntentForUnusedBranchLink(intent);
    }

    private boolean checkIntentForSessionRestart(Intent intent) {
        if (intent != null) {
            return intent.getBooleanExtra(Defines.IntentKeys.ForceNewBranchSession.getKey(), false);
        }
        return false;
    }

    private boolean checkIntentForUnusedBranchLink(Intent intent) {
        if (intent != null) {
            return (intent.getStringExtra(Defines.IntentKeys.BranchURI.getKey()) != null) && !intent.getBooleanExtra(Defines.IntentKeys.BranchLinkUsed.getKey(), false);
        }
        return false;
    }

    private class GetShortLinkTask extends AsyncTask<ServerRequest, Void, ServerResponse> implements TraceFieldInterface {
        public Trace _nr_trace;

        @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        private GetShortLinkTask() {
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ ServerResponse doInBackground(ServerRequest[] serverRequestArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "Branch$GetShortLinkTask#doInBackground", null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod(null, "Branch$GetShortLinkTask#doInBackground", null);
            }
            ServerResponse serverResponseDoInBackground2 = doInBackground2(serverRequestArr);
            TraceMachine.exitMethod();
            return serverResponseDoInBackground2;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected ServerResponse doInBackground2(ServerRequest... serverRequestArr) {
            return Branch.this.branchRemoteInterface_.make_restful_post(serverRequestArr[0].getPost(), Branch.this.prefHelper_.getAPIBaseUrl() + Defines.RequestPath.GetURL.getPath(), Defines.RequestPath.GetURL.getPath(), Branch.this.prefHelper_.getBranchKey());
        }
    }

    public static boolean isAutoDeepLinkLaunch(Activity activity) {
        return activity.getIntent().getStringExtra(Defines.IntentKeys.AutoDeepLinked.getKey()) != null;
    }

    void checkForAutoDeepLinkConfiguration() {
        String string;
        JSONObject latestReferringParams = getLatestReferringParams();
        String str = null;
        try {
            if (latestReferringParams.has(Defines.Jsonkey.Clicked_Branch_Link.getKey()) && latestReferringParams.getBoolean(Defines.Jsonkey.Clicked_Branch_Link.getKey()) && latestReferringParams.length() > 0) {
                ApplicationInfo applicationInfo = this.context_.getPackageManager().getApplicationInfo(this.context_.getPackageName(), 128);
                if (applicationInfo.metaData == null || !applicationInfo.metaData.getBoolean(AUTO_DEEP_LINK_DISABLE, false)) {
                    ActivityInfo[] activityInfoArr = this.context_.getPackageManager().getPackageInfo(this.context_.getPackageName(), 129).activities;
                    int i = DEF_AUTO_DEEP_LINK_REQ_CODE;
                    if (activityInfoArr != null) {
                        for (ActivityInfo activityInfo : activityInfoArr) {
                            if (activityInfo != null && activityInfo.metaData != null && ((activityInfo.metaData.getString(AUTO_DEEP_LINK_KEY) != null || activityInfo.metaData.getString(AUTO_DEEP_LINK_PATH) != null) && (checkForAutoDeepLinkKeys(latestReferringParams, activityInfo) || checkForAutoDeepLinkPath(latestReferringParams, activityInfo)))) {
                                str = activityInfo.name;
                                i = activityInfo.metaData.getInt(AUTO_DEEP_LINK_REQ_CODE, DEF_AUTO_DEEP_LINK_REQ_CODE);
                                break;
                            }
                        }
                    }
                    if (str != null && getCurrentActivity() != null) {
                        Activity currentActivity = getCurrentActivity();
                        Intent intent = new Intent(currentActivity, Class.forName(str));
                        intent.putExtra(Defines.IntentKeys.AutoDeepLinked.getKey(), "true");
                        String key = Defines.Jsonkey.ReferringData.getKey();
                        if (latestReferringParams instanceof JSONObject) {
                            JSONObject jSONObject = latestReferringParams;
                            string = JSONObjectInstrumentation.toString(latestReferringParams);
                        } else {
                            string = latestReferringParams.toString();
                        }
                        intent.putExtra(key, string);
                        Iterator<String> itKeys = latestReferringParams.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            intent.putExtra(next, latestReferringParams.getString(next));
                        }
                        currentActivity.startActivityForResult(intent, i);
                        return;
                    }
                    BranchLogger.m5578v("No activity reference to launch deep linked activity");
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            BranchLogger.m5579w("Warning: Please make sure Activity names set for auto deep link are correct!");
        } catch (ClassNotFoundException unused2) {
            BranchLogger.m5579w("Warning: Please make sure Activity names set for auto deep link are correct! Error while looking for activity " + ((String) null));
        } catch (Exception unused3) {
        }
    }

    private boolean checkForAutoDeepLinkKeys(JSONObject jSONObject, ActivityInfo activityInfo) {
        if (activityInfo.metaData.getString(AUTO_DEEP_LINK_KEY) != null) {
            for (String str : activityInfo.metaData.getString(AUTO_DEEP_LINK_KEY).split(",")) {
                if (jSONObject.has(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkForAutoDeepLinkPath(org.json.JSONObject r5, android.content.pm.ActivityInfo r6) {
        /*
            r4 = this;
            r0 = 0
            io.branch.referral.Defines$Jsonkey r1 = io.branch.referral.Defines.Jsonkey.AndroidDeepLinkPath     // Catch: org.json.JSONException -> L30
            java.lang.String r1 = r1.getKey()     // Catch: org.json.JSONException -> L30
            boolean r1 = r5.has(r1)     // Catch: org.json.JSONException -> L30
            if (r1 == 0) goto L19
            io.branch.referral.Defines$Jsonkey r1 = io.branch.referral.Defines.Jsonkey.AndroidDeepLinkPath     // Catch: org.json.JSONException -> L30
            java.lang.String r1 = r1.getKey()     // Catch: org.json.JSONException -> L30
            java.lang.String r5 = r5.getString(r1)     // Catch: org.json.JSONException -> L30
        L17:
            r0 = r5
            goto L38
        L19:
            io.branch.referral.Defines$Jsonkey r1 = io.branch.referral.Defines.Jsonkey.DeepLinkPath     // Catch: org.json.JSONException -> L30
            java.lang.String r1 = r1.getKey()     // Catch: org.json.JSONException -> L30
            boolean r1 = r5.has(r1)     // Catch: org.json.JSONException -> L30
            if (r1 == 0) goto L38
            io.branch.referral.Defines$Jsonkey r1 = io.branch.referral.Defines.Jsonkey.DeepLinkPath     // Catch: org.json.JSONException -> L30
            java.lang.String r1 = r1.getKey()     // Catch: org.json.JSONException -> L30
            java.lang.String r5 = r5.getString(r1)     // Catch: org.json.JSONException -> L30
            goto L17
        L30:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            io.branch.referral.BranchLogger.m5575d(r5)
        L38:
            android.os.Bundle r5 = r6.metaData
            java.lang.String r1 = "io.branch.sdk.auto_link_path"
            java.lang.String r5 = r5.getString(r1)
            r2 = 0
            if (r5 == 0) goto L66
            if (r0 == 0) goto L66
            android.os.Bundle r5 = r6.metaData
            java.lang.String r5 = r5.getString(r1)
            java.lang.String r6 = ","
            java.lang.String[] r5 = r5.split(r6)
            int r6 = r5.length
            r1 = r2
        L53:
            if (r1 >= r6) goto L66
            r3 = r5[r1]
            java.lang.String r3 = r3.trim()
            boolean r3 = r4.pathMatch(r3, r0)
            if (r3 == 0) goto L63
            r5 = 1
            return r5
        L63:
            int r1 = r1 + 1
            goto L53
        L66:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Branch.checkForAutoDeepLinkPath(org.json.JSONObject, android.content.pm.ActivityInfo):boolean");
    }

    private boolean pathMatch(String str, String str2) {
        String[] strArrSplit = str.split("\\?")[0].split("/");
        String[] strArrSplit2 = str2.split("\\?")[0].split("/");
        if (strArrSplit.length != strArrSplit2.length) {
            return false;
        }
        for (int i = 0; i < strArrSplit.length && i < strArrSplit2.length; i++) {
            String str3 = strArrSplit[i];
            if (!str3.equals(strArrSplit2[i]) && !str3.contains("*")) {
                return false;
            }
        }
        return true;
    }

    public static void enableLogging() {
        BranchLogger.logAlways(GOOGLE_VERSION_TAG);
        BranchLogger.setLoggingEnabled(true);
    }

    public static void disableLogging() {
        BranchLogger.setLoggingEnabled(false);
    }

    @Deprecated
    public static void enableForcedSession() {
        bypassWaitingForIntent(true);
    }

    public static void bypassWaitingForIntent(boolean z) {
        bypassWaitingForIntent_ = z;
    }

    @Deprecated
    public static void disableForcedSession() {
        bypassWaitingForIntent(false);
    }

    @Deprecated
    public static boolean isForceSessionEnabled() {
        return isWaitingForIntent();
    }

    public static boolean isWaitingForIntent() {
        return !bypassWaitingForIntent_;
    }

    public static void enableBypassCurrentActivityIntentState() {
        bypassCurrentActivityIntentState_ = true;
    }

    public static boolean bypassCurrentActivityIntentState() {
        return bypassCurrentActivityIntentState_;
    }

    public void registerView(BranchUniversalObject branchUniversalObject, BranchUniversalObject.RegisterViewStatusListener registerViewStatusListener) {
        if (this.context_ != null) {
            new BranchEvent(BRANCH_STANDARD_EVENT.VIEW_ITEM).addContentItems(branchUniversalObject).logEvent(this.context_);
        }
    }

    public static boolean isInstantApp(Context context) {
        return InstantAppUtil.isInstantApp(context);
    }

    public static boolean showInstallPrompt(Activity activity, int i) {
        String string;
        String str = "";
        if (getInstance() != null) {
            JSONObject latestReferringParams = getInstance().getLatestReferringParams();
            String str2 = "~" + Defines.Jsonkey.ReferringLink.getKey();
            if (latestReferringParams != null && latestReferringParams.has(str2)) {
                try {
                    string = latestReferringParams.getString(str2);
                    try {
                        string = URLEncoder.encode(string, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e = e;
                        e.printStackTrace();
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                } catch (UnsupportedEncodingException | JSONException e3) {
                    e = e3;
                    string = "";
                }
                if (!TextUtils.isEmpty(string)) {
                    str = Defines.Jsonkey.IsFullAppConv.getKey() + "=true&" + Defines.Jsonkey.ReferringLink.getKey() + "=" + string;
                }
            }
        }
        return InstantAppUtil.doShowInstallPrompt(activity, i, str);
    }

    public static boolean showInstallPrompt(Activity activity, int i, String str) {
        return InstantAppUtil.doShowInstallPrompt(activity, i, Defines.Jsonkey.IsFullAppConv.getKey() + "=true&" + str);
    }

    public static boolean showInstallPrompt(Activity activity, int i, BranchUniversalObject branchUniversalObject) {
        String str = Defines.Jsonkey.ReferringLink.getKey() + "=" + branchUniversalObject.getShortUrl(activity, new LinkProperties());
        if (!TextUtils.isEmpty(str)) {
            return showInstallPrompt(activity, i, str);
        }
        return showInstallPrompt(activity, i, "");
    }

    private void extractSessionParamsForIDL(Uri uri, Activity activity) {
        String string;
        String string2;
        String string3;
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        Intent intent = activity.getIntent();
        if (uri != null) {
            try {
                if (!isIntentParamsAlreadyConsumed(activity)) {
                    if (!TextUtils.isEmpty(intent.getStringExtra(Defines.IntentKeys.BranchData.getKey()))) {
                        String stringExtra = intent.getStringExtra(Defines.IntentKeys.BranchData.getKey());
                        if (stringExtra != null) {
                            JSONObject jSONObject = new JSONObject(stringExtra);
                            jSONObject.put(Defines.Jsonkey.Clicked_Branch_Link.getKey(), true);
                            PrefHelper prefHelper = this.prefHelper_;
                            if (jSONObject instanceof JSONObject) {
                                string2 = JSONObjectInstrumentation.toString(jSONObject);
                            } else {
                                string2 = jSONObject.toString();
                            }
                            prefHelper.setSessionParams(string2);
                            this.isInstantDeepLinkPossible = true;
                        }
                        intent.removeExtra(Defines.IntentKeys.BranchData.getKey());
                        activity.setIntent(intent);
                        return;
                    }
                    if (uri.isHierarchical() && Boolean.valueOf(uri.getQueryParameter(Defines.Jsonkey.Instant.getKey())).booleanValue()) {
                        JSONObject jSONObject2 = new JSONObject();
                        for (String str : uri.getQueryParameterNames()) {
                            jSONObject2.put(str, uri.getQueryParameter(str));
                        }
                        jSONObject2.put(Defines.Jsonkey.Clicked_Branch_Link.getKey(), true);
                        PrefHelper prefHelper2 = this.prefHelper_;
                        if (jSONObject2 instanceof JSONObject) {
                            string = JSONObjectInstrumentation.toString(jSONObject2);
                        } else {
                            string = jSONObject2.toString();
                        }
                        prefHelper2.setSessionParams(string);
                        this.isInstantDeepLinkPossible = true;
                        return;
                    }
                    return;
                }
            } catch (JSONException e) {
                BranchLogger.m5575d(e.getMessage());
                return;
            }
        }
        if (this.prefHelper_.getInstallParams().equals(PrefHelper.NO_STRING_VALUE)) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(Defines.Jsonkey.IsFirstSession.getKey(), false);
        PrefHelper prefHelper3 = this.prefHelper_;
        if (jSONObject3 instanceof JSONObject) {
            string3 = JSONObjectInstrumentation.toString(jSONObject3);
        } else {
            string3 = jSONObject3.toString();
        }
        prefHelper3.setSessionParams(string3);
        this.isInstantDeepLinkPossible = true;
    }

    private void extractAppLink(Uri uri, Activity activity) {
        if (uri == null || activity == null) {
            return;
        }
        String scheme = uri.getScheme();
        Intent intent = activity.getIntent();
        if (scheme == null || intent == null) {
            return;
        }
        if ((!scheme.equalsIgnoreCase("http") && !scheme.equalsIgnoreCase("https")) || TextUtils.isEmpty(uri.getHost()) || isIntentParamsAlreadyConsumed(activity)) {
            return;
        }
        if (uri.toString().equalsIgnoreCase(UniversalResourceAnalyser.getInstance(this.context_).getStrippedURL(uri.toString()))) {
            this.prefHelper_.setAppLink(uri.toString());
        }
        intent.putExtra(Defines.IntentKeys.BranchLinkUsed.getKey(), true);
        activity.setIntent(intent);
    }

    private boolean extractClickID(Uri uri, Activity activity) {
        String queryParameter;
        String str;
        if (uri != null) {
            try {
                if (!uri.isHierarchical() || (queryParameter = uri.getQueryParameter(Defines.Jsonkey.LinkClickID.getKey())) == null) {
                    return false;
                }
                this.prefHelper_.setLinkClickIdentifier(queryParameter);
                String str2 = "link_click_id=" + queryParameter;
                String string = uri.toString();
                if (str2.equals(uri.getQuery())) {
                    str = "\\?" + str2;
                } else if (string.length() - str2.length() == string.indexOf(str2)) {
                    str = "&" + str2;
                } else {
                    str = str2 + "&";
                }
                activity.getIntent().setData(Uri.parse(string.replaceFirst(str, "")));
                activity.getIntent().putExtra(Defines.IntentKeys.BranchLinkUsed.getKey(), true);
                return true;
            } catch (Exception e) {
                BranchLogger.m5575d(e.getMessage());
            }
        }
        return false;
    }

    private boolean extractBranchLinkFromIntentExtra(Activity activity) {
        String string;
        if (activity == null) {
            return false;
        }
        try {
            if (activity.getIntent() == null || activity.getIntent().getExtras() == null || isIntentParamsAlreadyConsumed(activity)) {
                return false;
            }
            Object obj = activity.getIntent().getExtras().get(Defines.IntentKeys.BranchURI.getKey());
            if (obj instanceof String) {
                string = (String) obj;
            } else {
                string = obj instanceof Uri ? ((Uri) obj).toString() : null;
            }
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            this.prefHelper_.setPushIdentifier(string);
            Intent intent = activity.getIntent();
            intent.putExtra(Defines.IntentKeys.BranchLinkUsed.getKey(), true);
            activity.setIntent(intent);
            return true;
        } catch (Exception e) {
            BranchLogger.m5575d(e.getMessage());
            return false;
        }
    }

    private void extractExternalUriAndIntentExtras(Uri uri, Activity activity) {
        String string;
        try {
            if (isIntentParamsAlreadyConsumed(activity)) {
                return;
            }
            String strippedURL = UniversalResourceAnalyser.getInstance(this.context_).getStrippedURL(uri.toString());
            this.prefHelper_.setExternalIntentUri(strippedURL);
            if (strippedURL.equals(uri.toString())) {
                Bundle extras = activity.getIntent().getExtras();
                Set<String> setKeySet = extras.keySet();
                if (setKeySet.isEmpty()) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                for (String str : EXTERNAL_INTENT_EXTRA_KEY_WHITE_LIST) {
                    if (setKeySet.contains(str)) {
                        jSONObject.put(str, extras.get(str));
                    }
                }
                if (jSONObject.length() > 0) {
                    PrefHelper prefHelper = this.prefHelper_;
                    if (jSONObject instanceof JSONObject) {
                        string = JSONObjectInstrumentation.toString(jSONObject);
                    } else {
                        string = jSONObject.toString();
                    }
                    prefHelper.setExternalIntentExtra(string);
                }
            }
        } catch (Exception e) {
            BranchLogger.m5575d(e.getMessage());
        }
    }

    Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivityReference_;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static class InitSessionBuilder {
        private BranchReferralInitListener callback;
        private int delay;
        private Boolean ignoreIntent;
        private boolean isAutoInitialization;
        private boolean isReInitializing;
        private Uri uri;

        public InitSessionBuilder isReferrable(boolean z) {
            return this;
        }

        private InitSessionBuilder(Activity activity) {
            Branch branch = Branch.getInstance();
            if (activity != null) {
                if (branch.getCurrentActivity() == null || !branch.getCurrentActivity().getLocalClassName().equals(activity.getLocalClassName())) {
                    branch.currentActivityReference_ = new WeakReference<>(activity);
                }
            }
        }

        InitSessionBuilder isAutoInitialization(boolean z) {
            this.isAutoInitialization = z;
            return this;
        }

        public InitSessionBuilder withCallback(BranchUniversalReferralInitListener branchUniversalReferralInitListener) {
            this.callback = new BranchUniversalReferralInitWrapper(branchUniversalReferralInitListener);
            return this;
        }

        public InitSessionBuilder withDelay(int i) {
            this.delay = i;
            return this;
        }

        public InitSessionBuilder withCallback(BranchReferralInitListener branchReferralInitListener) {
            this.callback = branchReferralInitListener;
            return this;
        }

        public InitSessionBuilder withData(Uri uri) {
            this.uri = uri;
            return this;
        }

        public InitSessionBuilder ignoreIntent(boolean z) {
            this.ignoreIntent = Boolean.valueOf(z);
            return this;
        }

        public void init() {
            BranchLogger.m5578v("Beginning session initialization");
            BranchLogger.m5578v("Session uri is " + this.uri);
            if (Branch.deferInitForPluginRuntime) {
                BranchLogger.m5578v("Session init is deferred until signaled by plugin.");
                cacheSessionBuilder(this);
                return;
            }
            Branch branch = Branch.getInstance();
            if (branch == null) {
                BranchLogger.logAlways("Branch is not setup properly, make sure to call getAutoInstance in your application class or declare BranchApp in your manifest.");
                return;
            }
            Boolean bool = this.ignoreIntent;
            if (bool != null) {
                Branch.bypassWaitingForIntent(bool.booleanValue());
            }
            Activity currentActivity = branch.getCurrentActivity();
            Intent intent = currentActivity != null ? currentActivity.getIntent() : null;
            if (currentActivity != null && intent != null && ActivityCompat.getReferrer(currentActivity) != null) {
                PrefHelper.getInstance(currentActivity).setInitialReferrer(ActivityCompat.getReferrer(currentActivity).toString());
            }
            Uri uri = this.uri;
            if (uri != null) {
                branch.readAndStripParam(uri, currentActivity);
            } else if (this.isReInitializing && branch.isRestartSessionRequested(intent)) {
                branch.readAndStripParam(intent != null ? intent.getData() : null, currentActivity);
            } else if (this.isReInitializing) {
                BranchReferralInitListener branchReferralInitListener = this.callback;
                if (branchReferralInitListener != null) {
                    branchReferralInitListener.onInitFinished(null, new BranchError("", BranchError.ERR_IMPROPER_REINITIALIZATION));
                    return;
                }
                return;
            }
            if (branch.isInstantDeepLinkPossible) {
                branch.isInstantDeepLinkPossible = false;
                BranchReferralInitListener branchReferralInitListener2 = this.callback;
                if (branchReferralInitListener2 != null) {
                    branchReferralInitListener2.onInitFinished(branch.getLatestReferringParams(), null);
                }
                Branch.getInstance().requestQueue_.addExtraInstrumentationData(Defines.Jsonkey.InstantDeepLinkSession.getKey(), "true");
                branch.checkForAutoDeepLinkConfiguration();
                this.callback = null;
            }
            if (this.delay > 0) {
                Branch.expectDelayedSessionInitialization(true);
            }
            ServerRequestInitSession installOrOpenRequest = branch.getInstallOrOpenRequest(this.callback, this.isAutoInitialization);
            BranchLogger.m5575d("Creating " + installOrOpenRequest + " from init");
            branch.initializeSession(installOrOpenRequest, this.delay);
        }

        private void cacheSessionBuilder(InitSessionBuilder initSessionBuilder) {
            Branch.getInstance().deferredSessionBuilder = this;
            BranchLogger.m5578v("Session initialization deferred until plugin invokes notifyNativeToInit()\nCaching Session Builder " + Branch.getInstance().deferredSessionBuilder + "\nuri: " + Branch.getInstance().deferredSessionBuilder.uri + "\ncallback: " + Branch.getInstance().deferredSessionBuilder.callback + "\nisReInitializing: " + Branch.getInstance().deferredSessionBuilder.isReInitializing + "\ndelay: " + Branch.getInstance().deferredSessionBuilder.delay + "\nisAutoInitialization: " + Branch.getInstance().deferredSessionBuilder.isAutoInitialization + "\nignoreIntent: " + Branch.getInstance().deferredSessionBuilder.ignoreIntent);
        }

        public void reInit() {
            this.isReInitializing = true;
            init();
        }
    }

    boolean isIDLSession() {
        return Boolean.parseBoolean(getInstance().requestQueue_.instrumentationExtraData_.get(Defines.Jsonkey.InstantDeepLinkSession.getKey()));
    }

    public static InitSessionBuilder sessionBuilder(Activity activity) {
        return new InitSessionBuilder(activity);
    }

    public static String getSdkVersionNumber() {
        return BuildConfig.VERSION_NAME;
    }

    static void deferInitForPluginRuntime(boolean z) {
        BranchLogger.m5578v("deferInitForPluginRuntime " + z);
        deferInitForPluginRuntime = z;
        if (z) {
            expectDelayedSessionInitialization(z);
        }
    }

    public static void notifyNativeToInit() {
        BranchLogger.m5578v("notifyNativeToInit deferredSessionBuilder " + getInstance().deferredSessionBuilder);
        SESSION_STATE initState = getInstance().getInitState();
        if (initState == SESSION_STATE.UNINITIALISED) {
            deferInitForPluginRuntime = false;
            if (getInstance().deferredSessionBuilder != null) {
                getInstance().deferredSessionBuilder.init();
                return;
            }
            return;
        }
        BranchLogger.m5578v("notifyNativeToInit session is not uninitialized. Session state is " + initState);
    }

    public void logEventWithPurchase(final Context context, final Purchase purchase) {
        if (DependencyUtilsKt.classExists(DependencyUtilsKt.billingGooglePlayClass)) {
            BillingGooglePlay.INSTANCE.getInstance().startBillingClient(new Function1() { // from class: io.branch.referral.Branch$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Branch.lambda$logEventWithPurchase$0(context, purchase, (Boolean) obj);
                }
            });
        }
    }

    static /* synthetic */ Unit lambda$logEventWithPurchase$0(Context context, Purchase purchase, Boolean bool) {
        if (bool.booleanValue()) {
            BillingGooglePlay.INSTANCE.getInstance().logEventWithPurchase(context, purchase);
            return null;
        }
        BranchLogger.logException("Cannot log IAP event. Billing client setup failed", new Exception("Billing Client Setup Failed"));
        return null;
    }
}
