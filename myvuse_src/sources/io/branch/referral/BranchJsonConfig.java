package io.branch.referral;

import android.content.Context;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BranchJsonConfig {
    public static final String TAG = "BranchJsonConfig";
    private static final String fileName = "branch.json";
    private static BranchJsonConfig instance;
    private JSONObject mConfiguration;

    public enum BranchJsonKey {
        branchKey,
        testKey,
        liveKey,
        useTestInstance,
        enableLogging,
        deferInitForPluginRuntime
    }

    private BranchJsonConfig(Context context) {
        this.mConfiguration = null;
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName)));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        sb.append(line);
                    } else {
                        this.mConfiguration = new JSONObject(sb.toString());
                        return;
                    }
                }
            } catch (FileNotFoundException unused) {
            }
        } catch (IOException e) {
            LogInstrumentation.m2728e(TAG, "Error loading branch.json: " + e.getMessage());
        } catch (JSONException e2) {
            LogInstrumentation.m2728e(TAG, "Error parsing branch.json: " + e2.getMessage());
        }
    }

    public static BranchJsonConfig getInstance(Context context) {
        if (instance == null) {
            instance = new BranchJsonConfig(context);
        }
        return instance;
    }

    public boolean isValid() {
        return this.mConfiguration != null;
    }

    public boolean isValid(BranchJsonKey branchJsonKey) {
        JSONObject jSONObject = this.mConfiguration;
        return jSONObject != null && jSONObject.has(branchJsonKey.toString());
    }

    public Object get(BranchJsonKey branchJsonKey) {
        if (!isValid(branchJsonKey)) {
            return null;
        }
        try {
            return this.mConfiguration.get(branchJsonKey.toString());
        } catch (JSONException e) {
            LogInstrumentation.m2728e(TAG, "Error parsing branch.json: " + e.getMessage());
            return null;
        }
    }

    public Boolean getEnableLogging() {
        if (!isValid(BranchJsonKey.enableLogging)) {
            return null;
        }
        try {
            return Boolean.valueOf(this.mConfiguration.getBoolean(BranchJsonKey.enableLogging.toString()));
        } catch (JSONException e) {
            LogInstrumentation.m2728e(TAG, "Error parsing branch.json: " + e.getMessage());
            return false;
        }
    }

    public Boolean getDeferInitForPluginRuntime() {
        if (!isValid(BranchJsonKey.deferInitForPluginRuntime)) {
            return null;
        }
        try {
            return Boolean.valueOf(this.mConfiguration.getBoolean(BranchJsonKey.deferInitForPluginRuntime.toString()));
        } catch (JSONException e) {
            LogInstrumentation.m2728e(TAG, "Error parsing branch.json: " + e.getMessage());
            return false;
        }
    }

    public String getBranchKey() {
        if (!isValid(BranchJsonKey.branchKey) && (!isValid(BranchJsonKey.liveKey) || !isValid(BranchJsonKey.testKey) || !isValid(BranchJsonKey.useTestInstance))) {
            return null;
        }
        try {
            if (isValid(BranchJsonKey.branchKey)) {
                return this.mConfiguration.getString(BranchJsonKey.branchKey.toString());
            }
            return getUseTestInstance().booleanValue() ? getTestKey() : getLiveKey();
        } catch (JSONException e) {
            LogInstrumentation.m2728e(TAG, "Error parsing branch.json: " + e.getMessage());
            return null;
        }
    }

    private String getLiveKey() {
        if (!isValid(BranchJsonKey.liveKey)) {
            return null;
        }
        try {
            return this.mConfiguration.getString(BranchJsonKey.liveKey.toString());
        } catch (JSONException e) {
            LogInstrumentation.m2728e(TAG, "Error parsing branch.json: " + e.getMessage());
            return null;
        }
    }

    private String getTestKey() {
        JSONObject jSONObject = this.mConfiguration;
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.has("testKey")) {
                return this.mConfiguration.getString("testKey");
            }
            return null;
        } catch (JSONException e) {
            LogInstrumentation.m2728e(TAG, "Error parsing branch.json: " + e.getMessage());
            return null;
        }
    }

    public Boolean getUseTestInstance() {
        if (!isValid(BranchJsonKey.useTestInstance)) {
            return null;
        }
        try {
            return Boolean.valueOf(this.mConfiguration.getBoolean(BranchJsonKey.useTestInstance.toString()));
        } catch (JSONException e) {
            LogInstrumentation.m2728e(TAG, "Error parsing branch.json: " + e.getMessage());
            return false;
        }
    }
}
