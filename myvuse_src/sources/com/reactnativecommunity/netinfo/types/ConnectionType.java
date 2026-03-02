package com.reactnativecommunity.netinfo.types;

import com.newrelic.agent.android.api.common.CarrierType;

/* JADX INFO: loaded from: classes6.dex */
public enum ConnectionType {
    BLUETOOTH(CarrierType.BLUETOOTH),
    CELLULAR(CarrierType.CELLULAR),
    ETHERNET(CarrierType.ETHERNET),
    NONE("none"),
    UNKNOWN("unknown"),
    WIFI("wifi"),
    WIMAX("wimax"),
    VPN("vpn");

    public final String label;

    ConnectionType(String str) {
        this.label = str;
    }
}
