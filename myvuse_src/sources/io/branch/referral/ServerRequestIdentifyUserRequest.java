package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
class ServerRequestIdentifyUserRequest extends ServerRequest {
    Branch.BranchReferralInitListener callback_;
    String userId_;

    @Override // io.branch.referral.ServerRequest
    public boolean isGetRequest() {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    public boolean shouldRetryOnFail() {
        return true;
    }

    public ServerRequestIdentifyUserRequest(Context context, Branch.BranchReferralInitListener branchReferralInitListener, String str) {
        super(context, Defines.RequestPath.IdentifyUser);
        this.callback_ = branchReferralInitListener;
        this.userId_ = str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Defines.Jsonkey.RandomizedBundleToken.getKey(), this.prefHelper_.getRandomizedBundleToken());
            jSONObject.put(Defines.Jsonkey.RandomizedDeviceToken.getKey(), this.prefHelper_.getRandomizedDeviceToken());
            jSONObject.put(Defines.Jsonkey.SessionID.getKey(), this.prefHelper_.getSessionID());
            if (!this.prefHelper_.getLinkClickID().equals(PrefHelper.NO_STRING_VALUE)) {
                jSONObject.put(Defines.Jsonkey.LinkClickID.getKey(), this.prefHelper_.getLinkClickID());
            }
            jSONObject.put(Defines.Jsonkey.Identity.getKey(), str);
            setPost(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            this.constructError_ = true;
        }
    }

    public ServerRequestIdentifyUserRequest(Defines.RequestPath requestPath, JSONObject jSONObject, Context context) {
        super(requestPath, jSONObject, context);
        this.userId_ = null;
    }

    @Override // io.branch.referral.ServerRequest
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        try {
            if (getPost() != null && getPost().has(Defines.Jsonkey.Identity.getKey())) {
                this.prefHelper_.setIdentity(Branch.installDeveloperId);
            }
            this.prefHelper_.setRandomizedBundleToken(serverResponse.getObject().getString(Defines.Jsonkey.RandomizedBundleToken.getKey()));
            this.prefHelper_.setUserURL(serverResponse.getObject().getString(Defines.Jsonkey.Link.getKey()));
            if (serverResponse.getObject().has(Defines.Jsonkey.ReferringData.getKey())) {
                this.prefHelper_.setInstallParams(serverResponse.getObject().getString(Defines.Jsonkey.ReferringData.getKey()));
            }
            Branch.BranchReferralInitListener branchReferralInitListener = this.callback_;
            if (branchReferralInitListener != null) {
                branchReferralInitListener.onInitFinished(branch.getFirstReferringParams(), null);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // io.branch.referral.ServerRequest
    public void handleFailure(int i, String str) {
        if (this.callback_ != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_message", "Trouble reaching server. Please try again in a few minutes");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.callback_.onInitFinished(jSONObject, new BranchError("Trouble setting the user alias. " + str, i));
        }
    }

    @Override // io.branch.referral.ServerRequest
    public boolean handleErrors(Context context) {
        if (!super.doesAppHasInternetPermission(context)) {
            Branch.BranchReferralInitListener branchReferralInitListener = this.callback_;
            if (branchReferralInitListener != null) {
                branchReferralInitListener.onInitFinished(null, new BranchError("Trouble setting the user alias.", BranchError.ERR_NO_INTERNET_PERMISSION));
            }
            return true;
        }
        try {
            String string = getPost().getString(Defines.Jsonkey.Identity.getKey());
            if (string != null && string.length() != 0) {
                if (!string.equals(this.prefHelper_.getIdentity())) {
                    return false;
                }
            }
            return true;
        } catch (JSONException e) {
            BranchLogger.m5575d(e.getMessage());
            return true;
        }
    }

    public boolean isExistingID() {
        try {
            String string = getPost().getString(Defines.Jsonkey.Identity.getKey());
            if (string != null) {
                return string.equals(this.prefHelper_.getIdentity());
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void handleUserExist(Branch branch) {
        Branch.BranchReferralInitListener branchReferralInitListener = this.callback_;
        if (branchReferralInitListener != null) {
            branchReferralInitListener.onInitFinished(branch.getFirstReferringParams(), null);
        }
    }

    @Override // io.branch.referral.ServerRequest
    public void clearCallbacks() {
        this.callback_ = null;
    }
}
