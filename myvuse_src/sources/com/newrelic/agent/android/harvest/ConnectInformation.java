package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.com.google.gson.JsonArray;

/* JADX INFO: loaded from: classes6.dex */
public class ConnectInformation extends HarvestableArray {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private ApplicationInformation applicationInformation;
    private DeviceInformation deviceInformation;

    public ConnectInformation(ApplicationInformation applicationInformation, DeviceInformation deviceInformation) {
        if (applicationInformation == null) {
            log.error("null applicationInformation passed into ConnectInformation constructor");
        }
        if (deviceInformation == null) {
            log.error("null deviceInformation passed into ConnectInformation constructor");
        }
        this.applicationInformation = applicationInformation;
        this.deviceInformation = deviceInformation;
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableArray, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        notNull(this.applicationInformation);
        jsonArray.add(this.applicationInformation.asJsonArray());
        notNull(this.deviceInformation);
        jsonArray.add(this.deviceInformation.asJsonArray());
        return jsonArray;
    }

    public ApplicationInformation getApplicationInformation() {
        return this.applicationInformation;
    }

    public DeviceInformation getDeviceInformation() {
        return this.deviceInformation;
    }

    public void setApplicationInformation(ApplicationInformation applicationInformation) {
        this.applicationInformation = applicationInformation;
    }

    public void setDeviceInformation(DeviceInformation deviceInformation) {
        this.deviceInformation = deviceInformation;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConnectInformation connectInformation = (ConnectInformation) obj;
        ApplicationInformation applicationInformation = this.applicationInformation;
        if (applicationInformation == null ? connectInformation.applicationInformation != null : !applicationInformation.equals(connectInformation.applicationInformation)) {
            return false;
        }
        DeviceInformation deviceInformation = this.deviceInformation;
        DeviceInformation deviceInformation2 = connectInformation.deviceInformation;
        return deviceInformation == null ? deviceInformation2 == null : deviceInformation.equals(deviceInformation2);
    }

    public int hashCode() {
        ApplicationInformation applicationInformation = this.applicationInformation;
        int iHashCode = (applicationInformation != null ? applicationInformation.hashCode() : 0) * 31;
        DeviceInformation deviceInformation = this.deviceInformation;
        return iHashCode + (deviceInformation != null ? deviceInformation.hashCode() : 0);
    }
}
