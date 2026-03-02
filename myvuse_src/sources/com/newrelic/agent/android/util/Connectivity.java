package com.newrelic.agent.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.newrelic.agent.android.api.common.CarrierType;
import com.newrelic.agent.android.api.common.WanType;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.text.MessageFormat;

/* JADX INFO: loaded from: classes6.dex */
public final class Connectivity {
    private static final String ANDROID = "Android";
    private static AgentLog log = AgentLogManager.getAgentLog();

    public static String carrierNameFromContext(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = getNetworkInfo(context);
        } catch (SecurityException unused) {
        }
        if (!isConnected(networkInfo)) {
            return "none";
        }
        if (isHardwired(networkInfo)) {
            return CarrierType.ETHERNET;
        }
        if (isWan(networkInfo)) {
            return carrierNameFromTelephonyManager(context);
        }
        if (isWifi(networkInfo)) {
            return "wifi";
        }
        if (isBluetooth(networkInfo)) {
            return CarrierType.BLUETOOTH;
        }
        log.warn(MessageFormat.format("Unknown network type: {0} [{1}]", networkInfo.getTypeName(), Integer.valueOf(networkInfo.getType())));
        return "unknown";
    }

    public static String wanType(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = getNetworkInfo(context);
        } catch (SecurityException unused) {
        }
        if (!isConnected(networkInfo)) {
            return "none";
        }
        if (isWifi(networkInfo)) {
            return "wifi";
        }
        if (isHardwired(networkInfo)) {
            return connectionNameFromNetworkSubtype(networkInfo.getSubtype());
        }
        if (isWan(networkInfo)) {
            return connectionNameFromNetworkSubtype(networkInfo.getSubtype());
        }
        return "unknown";
    }

    private static boolean isConnected(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnected();
    }

    private static boolean isWan(NetworkInfo networkInfo) {
        int type = networkInfo.getType();
        return type == 0 || type == 9 || type == 2 || type == 3 || type == 4 || type == 5;
    }

    private static boolean isWifi(NetworkInfo networkInfo) {
        int type = networkInfo.getType();
        return type == 1 || type == 6;
    }

    private static boolean isHardwired(NetworkInfo networkInfo) {
        int type = networkInfo.getType();
        return type == 4 || type == 9;
    }

    private static boolean isBluetooth(NetworkInfo networkInfo) {
        return networkInfo.getType() == 7;
    }

    private static NetworkInfo getNetworkInfo(Context context) throws SecurityException {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            log.warn("Cannot determine network state. Enable android.permission.ACCESS_NETWORK_STATE in your manifest.");
            throw e;
        }
    }

    private static String carrierNameFromTelephonyManager(Context context) {
        String networkOperatorName = ((TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkOperatorName();
        if (networkOperatorName == null || networkOperatorName.isEmpty()) {
            return "unknown";
        }
        return (networkOperatorName.equals("Android") && (Build.PRODUCT.equals("google_sdk") || Build.PRODUCT.equals("sdk") || Build.PRODUCT.equals("sdk_x86") || Build.FINGERPRINT.startsWith("generic"))) ? "wifi" : networkOperatorName;
    }

    private static String connectionNameFromNetworkSubtype(int i) {
        switch (i) {
            case 1:
                return WanType.GPRS;
            case 2:
                return WanType.EDGE;
            case 3:
                return WanType.UMTS;
            case 4:
                return WanType.CDMA;
            case 5:
                return WanType.EVDO_REV_0;
            case 6:
                return WanType.EVDO_REV_A;
            case 7:
                return WanType.RTT;
            case 8:
                return WanType.HSDPA;
            case 9:
                return WanType.HSUPA;
            case 10:
                return WanType.HSPA;
            case 11:
                return WanType.IDEN;
            case 12:
                return WanType.EVDO_REV_B;
            case 13:
                return WanType.LTE;
            case 14:
                return WanType.HRPD;
            case 15:
                return WanType.HSPAP;
            default:
                return "unknown";
        }
    }
}
