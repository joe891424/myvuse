package io.branch.referral.validators;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import io.branch.referral.BranchAsyncTask;
import io.branch.referral.BranchLogger;
import io.branch.referral.BranchUtil;
import io.branch.referral.Defines;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
class BranchIntegrationModel {
    boolean appSettingsAvailable = false;
    final List<String> applinkScheme = new ArrayList();
    private final String branchKeyLive;
    private final String branchKeyTest;
    JSONObject deeplinkUriScheme;
    final String packageName;

    public BranchIntegrationModel(Context context) {
        String string;
        String str;
        ApplicationInfo applicationInfo;
        this.packageName = context.getPackageName();
        String string2 = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            string = null;
        }
        if (applicationInfo.metaData != null) {
            string = applicationInfo.metaData.getString("io.branch.sdk.BranchKey");
            try {
                string2 = applicationInfo.metaData.getString("io.branch.sdk.BranchKey.test");
            } catch (PackageManager.NameNotFoundException e2) {
                e = e2;
                e.printStackTrace();
            }
            str = string2;
            string2 = string;
            this.branchKeyLive = string2;
            this.branchKeyTest = str;
            updateDeepLinkSchemes(context);
        }
        str = null;
        this.branchKeyLive = string2;
        this.branchKeyTest = str;
        updateDeepLinkSchemes(context);
        e.printStackTrace();
        str = string2;
        string2 = string;
        this.branchKeyLive = string2;
        this.branchKeyTest = str;
        updateDeepLinkSchemes(context);
    }

    private void updateDeepLinkSchemes(Context context) {
        Exception e;
        JSONObject jSONObject;
        try {
            jSONObject = new getDeepLinkSchemeTasks().executeTask(context).get(2500L, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e = e2;
            jSONObject = null;
        }
        try {
            this.appSettingsAvailable = true;
        } catch (Exception e3) {
            e = e3;
            BranchLogger.m5575d(e.getMessage());
        }
        if (jSONObject != null) {
            this.deeplinkUriScheme = jSONObject.optJSONObject(Defines.Jsonkey.URIScheme.getKey());
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(Defines.Jsonkey.AppLinks.getKey());
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.applinkScheme.add(jSONArrayOptJSONArray.optString(i));
                }
            }
        }
    }

    private class getDeepLinkSchemeTasks extends BranchAsyncTask<Context, Void, JSONObject> {
        private getDeepLinkSchemeTasks() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public JSONObject doInBackground(Context... contextArr) {
            return BranchUtil.getDeepLinkSchemes(contextArr[0]);
        }
    }
}
