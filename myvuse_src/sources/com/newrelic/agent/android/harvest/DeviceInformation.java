package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.ApplicationFramework;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class DeviceInformation extends HarvestableArray {
    private String agentName;
    private String agentVersion;
    private ApplicationFramework applicationFramework;
    private String applicationFrameworkVersion;
    private String architecture;
    private String countryCode;
    private String deviceId;
    private String manufacturer;
    private Map<String, String> misc = new HashMap();
    private String model;
    private String osBuild;
    private String osName;
    private String osVersion;
    private String regionCode;
    private String runTime;
    private String size;

    @Override // com.newrelic.agent.android.harvest.type.HarvestableArray, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        notEmpty(this.osName);
        jsonArray.add(new JsonPrimitive(this.osName));
        notEmpty(this.osVersion);
        jsonArray.add(new JsonPrimitive(this.osVersion));
        notEmpty(this.model);
        jsonArray.add(new JsonPrimitive(this.model));
        notEmpty(this.agentName);
        jsonArray.add(new JsonPrimitive(this.agentName));
        notEmpty(this.agentVersion);
        jsonArray.add(new JsonPrimitive(this.agentVersion));
        notEmpty(this.deviceId);
        jsonArray.add(new JsonPrimitive(this.deviceId));
        jsonArray.add(new JsonPrimitive(optional(this.countryCode)));
        jsonArray.add(new JsonPrimitive(optional(this.regionCode)));
        notEmpty(this.manufacturer);
        jsonArray.add(new JsonPrimitive(this.manufacturer));
        HashMap map = new HashMap();
        Map<String, String> map2 = this.misc;
        if (map2 != null && !map2.isEmpty()) {
            map.putAll(this.misc);
        }
        ApplicationFramework applicationFramework = this.applicationFramework;
        if (applicationFramework != null) {
            map.put("platform", applicationFramework.toString());
            String str = this.applicationFrameworkVersion;
            if (str != null) {
                map.put("platformVersion", str);
            }
        }
        jsonArray.add(new Gson().toJsonTree(map, GSON_STRING_MAP_TYPE));
        return jsonArray;
    }

    public void setOsName(String str) {
        this.osName = str;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public void setOsBuild(String str) {
        this.osBuild = str;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setRegionCode(String str) {
        this.regionCode = str;
    }

    public void setAgentName(String str) {
        this.agentName = str;
    }

    public void setAgentVersion(String str) {
        this.agentVersion = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setArchitecture(String str) {
        this.architecture = str;
    }

    public void setRunTime(String str) {
        this.runTime = str;
    }

    public void setSize(String str) {
        this.size = str;
        addMisc("size", str);
    }

    public void setApplicationFramework(ApplicationFramework applicationFramework) {
        this.applicationFramework = applicationFramework;
    }

    public void setApplicationFrameworkVersion(String str) {
        this.applicationFrameworkVersion = str;
    }

    public void setMisc(Map<String, String> map) {
        this.misc = new HashMap(map);
    }

    public void addMisc(String str, String str2) {
        this.misc.put(str, str2);
    }

    public String getOsName() {
        return this.osName;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getOsBuild() {
        return this.osBuild;
    }

    public String getModel() {
        return this.model;
    }

    public String getAgentName() {
        return this.agentName;
    }

    public String getAgentVersion() {
        return this.agentVersion;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getArchitecture() {
        return this.architecture;
    }

    public String getRunTime() {
        return this.runTime;
    }

    public String getSize() {
        return this.size;
    }

    public ApplicationFramework getApplicationFramework() {
        return this.applicationFramework;
    }

    public String getApplicationFrameworkVersion() {
        return this.applicationFrameworkVersion;
    }

    @Override // com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public String toJsonString() {
        return "DeviceInformation{manufacturer='" + this.manufacturer + "', osName='" + this.osName + "', osVersion='" + this.osVersion + "', model='" + this.model + "', agentName='" + this.agentName + "', agentVersion='" + this.agentVersion + "', deviceId='" + this.deviceId + "', countryCode='" + this.countryCode + "', regionCode='" + this.regionCode + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DeviceInformation deviceInformation = (DeviceInformation) obj;
        String str = this.agentName;
        if (str == null ? deviceInformation.agentName != null : !str.equals(deviceInformation.agentName)) {
            return false;
        }
        String str2 = this.agentVersion;
        if (str2 == null ? deviceInformation.agentVersion != null : !str2.equals(deviceInformation.agentVersion)) {
            return false;
        }
        String str3 = this.architecture;
        if (str3 == null ? deviceInformation.architecture != null : !str3.equals(deviceInformation.architecture)) {
            return false;
        }
        String str4 = this.deviceId;
        if (str4 == null ? deviceInformation.deviceId != null : !str4.equals(deviceInformation.deviceId)) {
            return false;
        }
        String str5 = this.manufacturer;
        if (str5 == null ? deviceInformation.manufacturer != null : !str5.equals(deviceInformation.manufacturer)) {
            return false;
        }
        String str6 = this.model;
        if (str6 == null ? deviceInformation.model != null : !str6.equals(deviceInformation.model)) {
            return false;
        }
        String str7 = this.osBuild;
        if (str7 == null ? deviceInformation.osBuild != null : !str7.equals(deviceInformation.osBuild)) {
            return false;
        }
        String str8 = this.osName;
        if (str8 == null ? deviceInformation.osName != null : !str8.equals(deviceInformation.osName)) {
            return false;
        }
        String str9 = this.osVersion;
        if (str9 == null ? deviceInformation.osVersion != null : !str9.equals(deviceInformation.osVersion)) {
            return false;
        }
        String str10 = this.runTime;
        if (str10 == null ? deviceInformation.runTime != null : !str10.equals(deviceInformation.runTime)) {
            return false;
        }
        String str11 = this.size;
        String str12 = deviceInformation.size;
        return str11 == null ? str12 == null : str11.equals(str12);
    }

    public int hashCode() {
        String str = this.osName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.osVersion;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.osBuild;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.model;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.agentName;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.agentVersion;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.deviceId;
        int iHashCode7 = (iHashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.manufacturer;
        int iHashCode8 = (iHashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.architecture;
        int iHashCode9 = (iHashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.runTime;
        int iHashCode10 = (iHashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.size;
        return iHashCode10 + (str11 != null ? str11.hashCode() : 0);
    }
}
