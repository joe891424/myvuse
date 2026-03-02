package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
class ServerRequestLogout extends ServerRequest {
    private Branch.LogoutStatusListener callback_;

    @Override // io.branch.referral.ServerRequest
    public boolean isGetRequest() {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    boolean isPersistable() {
        return false;
    }

    public ServerRequestLogout(Context context, Branch.LogoutStatusListener logoutStatusListener) {
        super(context, Defines.RequestPath.Logout);
        this.callback_ = logoutStatusListener;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Defines.Jsonkey.RandomizedBundleToken.getKey(), this.prefHelper_.getRandomizedBundleToken());
            jSONObject.put(Defines.Jsonkey.RandomizedDeviceToken.getKey(), this.prefHelper_.getRandomizedDeviceToken());
            jSONObject.put(Defines.Jsonkey.SessionID.getKey(), this.prefHelper_.getSessionID());
            if (!this.prefHelper_.getLinkClickID().equals(PrefHelper.NO_STRING_VALUE)) {
                jSONObject.put(Defines.Jsonkey.LinkClickID.getKey(), this.prefHelper_.getLinkClickID());
            }
            setPost(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            this.constructError_ = true;
        }
    }

    public ServerRequestLogout(Defines.RequestPath requestPath, JSONObject jSONObject, Context context) {
        super(requestPath, jSONObject, context);
    }

    @Override // io.branch.referral.ServerRequest
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        Branch.LogoutStatusListener logoutStatusListener;
        try {
            try {
                this.prefHelper_.setSessionID(serverResponse.getObject().getString(Defines.Jsonkey.SessionID.getKey()));
                this.prefHelper_.setRandomizedBundleToken(serverResponse.getObject().getString(Defines.Jsonkey.RandomizedBundleToken.getKey()));
                this.prefHelper_.setUserURL(serverResponse.getObject().getString(Defines.Jsonkey.Link.getKey()));
                this.prefHelper_.setInstallParams(PrefHelper.NO_STRING_VALUE);
                this.prefHelper_.setSessionParams(PrefHelper.NO_STRING_VALUE);
                this.prefHelper_.setIdentity(PrefHelper.NO_STRING_VALUE);
                this.prefHelper_.clearUserValues();
                logoutStatusListener = this.callback_;
            } catch (JSONException e) {
                e.printStackTrace();
                logoutStatusListener = this.callback_;
                if (logoutStatusListener != null) {
                }
            }
            if (logoutStatusListener != null) {
                logoutStatusListener.onLogoutFinished(true, null);
            }
        } catch (Throwable th) {
            Branch.LogoutStatusListener logoutStatusListener2 = this.callback_;
            if (logoutStatusListener2 != null) {
                logoutStatusListener2.onLogoutFinished(true, null);
            }
            throw th;
        }
    }

    @Override // io.branch.referral.ServerRequest
    public void handleFailure(int i, String str) {
        Branch.LogoutStatusListener logoutStatusListener = this.callback_;
        if (logoutStatusListener != null) {
            logoutStatusListener.onLogoutFinished(false, new BranchError("Logout error. " + str, i));
        }
    }

    @Override // io.branch.referral.ServerRequest
    public boolean handleErrors(Context context) {
        if (super.doesAppHasInternetPermission(context)) {
            return false;
        }
        Branch.LogoutStatusListener logoutStatusListener = this.callback_;
        if (logoutStatusListener == null) {
            return true;
        }
        logoutStatusListener.onLogoutFinished(false, new BranchError("Logout failed", BranchError.ERR_NO_INTERNET_PERMISSION));
        return true;
    }

    @Override // io.branch.referral.ServerRequest
    public void clearCallbacks() {
        this.callback_ = null;
    }
}
