package io.branch.referral.network;

import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.BranchLogger;
import io.branch.referral.Defines;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerResponse;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BranchRemoteInterface {
    public static final String RETRY_NUMBER = "retryNumber";

    public abstract BranchResponse doRestfulGet(String str) throws BranchRemoteException;

    public abstract BranchResponse doRestfulPost(String str, JSONObject jSONObject) throws BranchRemoteException;

    public final ServerResponse make_restful_get(String str, JSONObject jSONObject, String str2, String str3) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (!addCommonParams(jSONObject, str3)) {
            return new ServerResponse(str2, BranchError.ERR_BRANCH_KEY_INVALID, "");
        }
        String str4 = str + convertJSONtoString(jSONObject);
        long jCurrentTimeMillis = System.currentTimeMillis();
        BranchLogger.m5578v("getting " + str4);
        try {
            try {
                BranchResponse branchResponseDoRestfulGet = doRestfulGet(str4);
                ServerResponse serverResponseProcessEntityForJSON = processEntityForJSON(branchResponseDoRestfulGet, str2, branchResponseDoRestfulGet.requestId);
                if (Branch.getInstance() != null) {
                    Branch.getInstance().requestQueue_.addExtraInstrumentationData(str2 + "-" + Defines.Jsonkey.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - jCurrentTimeMillis)));
                }
                return serverResponseProcessEntityForJSON;
            } catch (BranchRemoteException e) {
                if (e.branchErrorCode == -111) {
                    ServerResponse serverResponse = new ServerResponse(str2, BranchError.ERR_BRANCH_REQ_TIMED_OUT, "");
                    if (Branch.getInstance() != null) {
                        Branch.getInstance().requestQueue_.addExtraInstrumentationData(str2 + "-" + Defines.Jsonkey.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - jCurrentTimeMillis)));
                    }
                    return serverResponse;
                }
                ServerResponse serverResponse2 = new ServerResponse(str2, BranchError.ERR_BRANCH_NO_CONNECTIVITY, "");
                if (Branch.getInstance() != null) {
                    Branch.getInstance().requestQueue_.addExtraInstrumentationData(str2 + "-" + Defines.Jsonkey.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - jCurrentTimeMillis)));
                }
                return serverResponse2;
            }
        } catch (Throwable th) {
            if (Branch.getInstance() != null) {
                Branch.getInstance().requestQueue_.addExtraInstrumentationData(str2 + "-" + Defines.Jsonkey.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - jCurrentTimeMillis)));
            }
            throw th;
        }
    }

    public final ServerResponse make_restful_post(JSONObject jSONObject, String str, String str2, String str3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (!addCommonParams(jSONObject, str3)) {
            return new ServerResponse(str2, BranchError.ERR_BRANCH_KEY_INVALID, "");
        }
        BranchLogger.m5578v("posting to " + str);
        BranchLogger.m5578v("Post value = " + (!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)));
        try {
            try {
                BranchResponse branchResponseDoRestfulPost = doRestfulPost(str, jSONObject);
                ServerResponse serverResponseProcessEntityForJSON = processEntityForJSON(branchResponseDoRestfulPost, str2, branchResponseDoRestfulPost.requestId);
                if (Branch.getInstance() != null) {
                    Branch.getInstance().requestQueue_.addExtraInstrumentationData(str2 + "-" + Defines.Jsonkey.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - jCurrentTimeMillis)));
                }
                return serverResponseProcessEntityForJSON;
            } catch (BranchRemoteException e) {
                if (e.branchErrorCode == -111) {
                    ServerResponse serverResponse = new ServerResponse(str2, BranchError.ERR_BRANCH_REQ_TIMED_OUT, "");
                    if (Branch.getInstance() != null) {
                        Branch.getInstance().requestQueue_.addExtraInstrumentationData(str2 + "-" + Defines.Jsonkey.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - jCurrentTimeMillis)));
                    }
                    return serverResponse;
                }
                ServerResponse serverResponse2 = new ServerResponse(str2, BranchError.ERR_BRANCH_NO_CONNECTIVITY, "");
                if (Branch.getInstance() != null) {
                    Branch.getInstance().requestQueue_.addExtraInstrumentationData(str2 + "-" + Defines.Jsonkey.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - jCurrentTimeMillis)));
                }
                return serverResponse2;
            }
        } catch (Throwable th) {
            if (Branch.getInstance() != null) {
                Branch.getInstance().requestQueue_.addExtraInstrumentationData(str2 + "-" + Defines.Jsonkey.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - jCurrentTimeMillis)));
            }
            throw th;
        }
    }

    private ServerResponse processEntityForJSON(BranchResponse branchResponse, String str, String str2) {
        String str3 = branchResponse.responseData;
        int i = branchResponse.responseCode;
        ServerResponse serverResponse = new ServerResponse(str, i, str2);
        if (!TextUtils.isEmpty(str2)) {
            BranchLogger.m5578v(String.format(Locale.getDefault(), "Server returned: [%s] Status: [%d]; Data: %s", str2, Integer.valueOf(i), str3));
        } else {
            BranchLogger.m5578v(String.format("returned %s", str3));
        }
        if (str3 != null) {
            try {
                try {
                    serverResponse.setPost(new JSONObject(str3));
                } catch (JSONException unused) {
                    serverResponse.setPost(new JSONArray(str3));
                }
            } catch (JSONException e) {
                if (str.contains(Defines.Jsonkey.QRCodeTag.getKey())) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(Defines.Jsonkey.QRCodeResponseString.getKey(), str3);
                        serverResponse.setPost(jSONObject);
                    } catch (JSONException e2) {
                        BranchLogger.m5578v("JSON exception: " + e2.getMessage());
                    }
                } else {
                    BranchLogger.m5578v("JSON exception: " + e.getMessage());
                }
            }
        }
        return serverResponse;
    }

    private boolean addCommonParams(JSONObject jSONObject, String str) {
        try {
            if (!jSONObject.has(Defines.Jsonkey.UserData.getKey())) {
                jSONObject.put(Defines.Jsonkey.SDK.getKey(), "android" + Branch.getSdkVersionNumber());
            }
            if (str.equals(PrefHelper.NO_STRING_VALUE)) {
                return false;
            }
            jSONObject.put(Defines.Jsonkey.BranchKey.getKey(), str);
            return true;
        } catch (JSONException e) {
            BranchLogger.m5575d(e.getMessage());
            return false;
        }
    }

    private String convertJSONtoString(JSONObject jSONObject) {
        JSONArray jSONArrayNames;
        StringBuilder sb = new StringBuilder();
        if (jSONObject != null && (jSONArrayNames = jSONObject.names()) != null) {
            int length = jSONArrayNames.length();
            boolean z = true;
            for (int i = 0; i < length; i++) {
                try {
                    String string = jSONArrayNames.getString(i);
                    if (z) {
                        sb.append("?");
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(string).append("=").append(jSONObject.getString(string));
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return sb.toString();
    }

    public static class BranchResponse {
        String requestId;
        private final int responseCode;
        private final String responseData;

        public BranchResponse(String str, int i) {
            this.responseData = str;
            this.responseCode = i;
        }
    }

    public static class BranchRemoteException extends Exception {
        private int branchErrorCode;

        public BranchRemoteException(int i) {
            this.branchErrorCode = i;
        }
    }
}
