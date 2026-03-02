package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonPrimitive;

/* JADX INFO: loaded from: classes6.dex */
public class ApplicationInformation extends HarvestableArray {
    private String appBuild;
    private String appName;
    private String appVersion;
    private String packageId;
    private int versionCode;

    public ApplicationInformation() {
        this.versionCode = -1;
    }

    public ApplicationInformation(String str, String str2, String str3, String str4) {
        this();
        this.appName = str;
        this.appVersion = str2;
        this.packageId = str3;
        this.appBuild = str4;
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableArray, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        notEmpty(this.appName);
        jsonArray.add(new JsonPrimitive(this.appName));
        notEmpty(this.appVersion);
        jsonArray.add(new JsonPrimitive(this.appVersion));
        notEmpty(this.packageId);
        jsonArray.add(new JsonPrimitive(this.packageId));
        return jsonArray;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppBuild(String str) {
        this.appBuild = str;
    }

    public String getAppBuild() {
        return this.appBuild;
    }

    public void setPackageId(String str) {
        this.packageId = str;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ApplicationInformation applicationInformation = (ApplicationInformation) obj;
        String str = this.appName;
        if (str == null ? applicationInformation.appName != null : !str.equals(applicationInformation.appName)) {
            return false;
        }
        String str2 = this.appVersion;
        if (str2 == null ? applicationInformation.appVersion != null : !str2.equals(applicationInformation.appVersion)) {
            return false;
        }
        String str3 = this.appBuild;
        if (str3 == null ? applicationInformation.appBuild != null : !str3.equals(applicationInformation.appBuild)) {
            return false;
        }
        String str4 = this.packageId;
        if (str4 == null ? applicationInformation.packageId == null : str4.equals(applicationInformation.packageId)) {
            return this.versionCode == applicationInformation.versionCode;
        }
        return false;
    }

    public int hashCode() {
        String str = this.appName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.appVersion;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.appBuild;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.packageId;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public boolean isAppUpgrade(ApplicationInformation applicationInformation) {
        int i = applicationInformation.versionCode;
        if (i == -1) {
            if (this.versionCode >= 0 && applicationInformation.appVersion != null) {
                return true;
            }
        } else if (this.versionCode > i) {
            return true;
        }
        return false;
    }
}
