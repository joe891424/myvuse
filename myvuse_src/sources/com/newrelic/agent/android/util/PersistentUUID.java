package com.newrelic.agent.android.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class PersistentUUID {
    private static final String UUID_KEY = "nr_uuid";
    private static final String UUID_FILENAME = "nr_installation";
    private static File UUID_FILE = new File(Environment.getDataDirectory(), UUID_FILENAME);
    private static AgentLog log = AgentLogManager.getAgentLog();

    public PersistentUUID(Context context) {
        UUID_FILE = new File(context.getFilesDir(), UUID_FILENAME);
    }

    public String getDeviceId(Context context) {
        String strGenerateUniqueID = generateUniqueID(context);
        return TextUtils.isEmpty(strGenerateUniqueID) ? UUID.randomUUID().toString() : strGenerateUniqueID;
    }

    private String generateUniqueID(Context context) {
        String deviceId = Build.SERIAL;
        String str = Build.ID;
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (TextUtils.isEmpty(string)) {
                return UUID.randomUUID().toString();
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                if (telephonyManager != null) {
                    deviceId = telephonyManager.getDeviceId();
                }
            } catch (Exception unused) {
                deviceId = "badf00d";
            }
            if (TextUtils.isEmpty(deviceId)) {
                deviceId = Build.HARDWARE + Build.DEVICE + Build.BOARD + Build.BRAND;
            }
            String str2 = intToHexString(string.hashCode(), 8) + "-" + intToHexString(deviceId.hashCode(), 4) + "-" + intToHexString(Build.VERSION.SDK_INT, 4) + "-" + intToHexString(Build.VERSION.RELEASE.hashCode(), 12);
            throw new RuntimeException("Not supported (TODO)");
        } catch (Exception unused2) {
            return UUID.randomUUID().toString();
        }
    }

    private String intToHexString(int i, int i2) {
        String hexString = Integer.toHexString(i);
        char[] cArr = new char[i2 - hexString.length()];
        Arrays.fill(cArr, '0');
        String str = new String(cArr) + hexString;
        String str2 = "";
        int i3 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            i3++;
            str2 = str.substring(length, length + 1) + str2;
            if (i3 % i2 == 0) {
                str2 = "-" + str2;
            }
        }
        return str2.startsWith("-") ? str2.substring(1, str2.length()) : str2;
    }

    protected void noticeUUIDMetric(String str) {
        StatsEngine statsEngine = StatsEngine.get();
        if (statsEngine != null) {
            statsEngine.inc(MetricNames.METRIC_MOBILE + str);
        } else {
            log.error("StatsEngine is null. " + str + "  not recorded.");
        }
    }

    public String getPersistentUUID() {
        String uUIDFromFileStore = getUUIDFromFileStore();
        if (!TextUtils.isEmpty(uUIDFromFileStore)) {
            StatsEngine.get().inc(MetricNames.METRIC_UUID_RECOVERED);
            return uUIDFromFileStore;
        }
        String string = UUID.randomUUID().toString();
        log.info("Created random UUID: " + string);
        StatsEngine.get().inc(MetricNames.MOBILE_APP_INSTALL);
        AnalyticsControllerImpl.getInstance().addAttributeUnchecked(new AnalyticsAttribute(AnalyticsAttribute.APP_INSTALL_ATTRIBUTE, true), false);
        setPersistedUUID(string);
        return string;
    }

    protected void setPersistedUUID(String str) {
        putUUIDToFileStore(str);
    }

    protected String getUUIDFromFileStore() {
        if (UUID_FILE.exists()) {
            try {
                return new JSONObject(new BufferedReader(new FileReader(UUID_FILE)).readLine()).getString(UUID_KEY);
            } catch (FileNotFoundException e) {
                log.error(e.getMessage());
            } catch (IOException e2) {
                log.error(e2.getMessage());
            } catch (NullPointerException e3) {
                log.error(e3.getMessage());
            } catch (JSONException e4) {
                log.error(e4.getMessage());
            }
        }
        return null;
    }

    protected void putUUIDToFileStore(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            FileWriter fileWriter = new FileWriter(UUID_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            jSONObject.put(UUID_KEY, str);
            bufferedWriter.write(jSONObject.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
