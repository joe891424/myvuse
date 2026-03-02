package com.newrelic.agent.android.harvest.crash;

import com.brentvatne.react.ReactVideoView;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class DeviceInfo extends HarvestableObject {
    private String OSBuild;
    private String OSVersion;
    private String architecture;
    private String deviceName;
    private String deviceUuid;
    private long[] diskAvailable;
    private long memoryUsage;
    private String modelNumber;
    private String networkStatus;
    private int orientation;
    private String runTime;
    private String screenResolution;

    public DeviceInfo() {
    }

    public DeviceInfo(DeviceInformation deviceInformation, EnvironmentInformation environmentInformation) {
        this.memoryUsage = environmentInformation.getMemoryUsage();
        this.orientation = environmentInformation.getOrientation();
        this.networkStatus = environmentInformation.getNetworkStatus();
        this.diskAvailable = environmentInformation.getDiskAvailable();
        this.OSVersion = deviceInformation.getOsVersion();
        this.deviceName = deviceInformation.getManufacturer();
        this.OSBuild = deviceInformation.getOsBuild();
        this.architecture = deviceInformation.getArchitecture();
        this.modelNumber = deviceInformation.getModel();
        this.screenResolution = deviceInformation.getSize();
        this.deviceUuid = deviceInformation.getDeviceId();
        this.runTime = deviceInformation.getRunTime();
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableObject, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("memoryUsage", SafeJsonPrimitive.factory(Long.valueOf(this.memoryUsage)));
        jsonObject.add(ReactVideoView.EVENT_PROP_ORIENTATION, SafeJsonPrimitive.factory(Integer.valueOf(this.orientation)));
        jsonObject.add("networkStatus", SafeJsonPrimitive.factory(this.networkStatus));
        jsonObject.add("diskAvailable", getDiskAvailableAsJson());
        jsonObject.add(AnalyticsAttribute.OS_VERSION_ATTRIBUTE, SafeJsonPrimitive.factory(this.OSVersion));
        jsonObject.add("deviceName", SafeJsonPrimitive.factory(this.deviceName));
        jsonObject.add(AnalyticsAttribute.OS_BUILD_ATTRIBUTE, SafeJsonPrimitive.factory(this.OSBuild));
        jsonObject.add(AnalyticsAttribute.ARCHITECTURE_ATTRIBUTE, SafeJsonPrimitive.factory(this.architecture));
        jsonObject.add(AnalyticsAttribute.RUNTIME_ATTRIBUTE, SafeJsonPrimitive.factory(this.runTime));
        jsonObject.add("modelNumber", SafeJsonPrimitive.factory(this.modelNumber));
        jsonObject.add("screenResolution", SafeJsonPrimitive.factory(this.screenResolution));
        jsonObject.add("deviceUuid", SafeJsonPrimitive.factory(this.deviceUuid));
        return jsonObject;
    }

    public static DeviceInfo newFromJson(JsonObject jsonObject) {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.memoryUsage = jsonObject.get("memoryUsage").getAsLong();
        deviceInfo.orientation = jsonObject.get(ReactVideoView.EVENT_PROP_ORIENTATION).getAsInt();
        deviceInfo.networkStatus = jsonObject.get("networkStatus").getAsString();
        deviceInfo.diskAvailable = longArrayFromJsonArray(jsonObject.get("diskAvailable").getAsJsonArray());
        deviceInfo.OSVersion = jsonObject.get(AnalyticsAttribute.OS_VERSION_ATTRIBUTE).getAsString();
        deviceInfo.deviceName = jsonObject.get("deviceName").getAsString();
        deviceInfo.OSBuild = jsonObject.get(AnalyticsAttribute.OS_BUILD_ATTRIBUTE).getAsString();
        deviceInfo.architecture = jsonObject.get(AnalyticsAttribute.ARCHITECTURE_ATTRIBUTE).getAsString();
        deviceInfo.runTime = jsonObject.get(AnalyticsAttribute.RUNTIME_ATTRIBUTE).getAsString();
        deviceInfo.modelNumber = jsonObject.get("modelNumber").getAsString();
        deviceInfo.screenResolution = jsonObject.get("screenResolution").getAsString();
        deviceInfo.deviceUuid = jsonObject.get("deviceUuid").getAsString();
        return deviceInfo;
    }

    private static long[] longArrayFromJsonArray(JsonArray jsonArray) {
        long[] jArr = new long[jsonArray.size()];
        Iterator<JsonElement> it2 = jsonArray.iterator();
        int i = 0;
        while (it2.hasNext()) {
            jArr[i] = it2.next().getAsLong();
            i++;
        }
        return jArr;
    }

    private JsonArray getDiskAvailableAsJson() {
        JsonArray jsonArray = new JsonArray();
        for (long j : this.diskAvailable) {
            jsonArray.add(SafeJsonPrimitive.factory(Long.valueOf(j)));
        }
        return jsonArray;
    }
}
