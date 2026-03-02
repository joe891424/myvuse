package com.transistorsoft.tsbackgroundfetch;

import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class BackgroundFetchConfig {
    private static final int DEFAULT_FETCH_INTERVAL = 15;
    static int FETCH_JOB_ID = 999;
    public static final String FIELD_DELAY = "delay";
    public static final String FIELD_FORCE_ALARM_MANAGER = "forceAlarmManager";
    public static final String FIELD_IS_FETCH_TASK = "isFetchTask";
    public static final String FIELD_JOB_SERVICE = "jobService";
    public static final String FIELD_MINIMUM_FETCH_INTERVAL = "minimumFetchInterval";
    public static final String FIELD_PERIODIC = "periodic";
    public static final String FIELD_REQUIRED_NETWORK_TYPE = "requiredNetworkType";
    public static final String FIELD_REQUIRES_BATTERY_NOT_LOW = "requiresBatteryNotLow";
    public static final String FIELD_REQUIRES_CHARGING = "requiresCharging";
    public static final String FIELD_REQUIRES_DEVICE_IDLE = "requiresDeviceIdle";
    public static final String FIELD_REQUIRES_STORAGE_NOT_LOW = "requiresStorageNotLow";
    public static final String FIELD_START_ON_BOOT = "startOnBoot";
    public static final String FIELD_STOP_ON_TERMINATE = "stopOnTerminate";
    public static final String FIELD_TASK_ID = "taskId";
    private static final int MINIMUM_FETCH_INTERVAL = 1;
    private Builder config;

    interface OnLoadCallback {
        void onLoad(List<BackgroundFetchConfig> list);
    }

    public static class Builder {
        private String taskId;
        private int minimumFetchInterval = 15;
        private long delay = -1;
        private boolean periodic = false;
        private boolean forceAlarmManager = false;
        private boolean stopOnTerminate = true;
        private boolean startOnBoot = false;
        private int requiredNetworkType = 0;
        private boolean requiresBatteryNotLow = false;
        private boolean requiresCharging = false;
        private boolean requiresDeviceIdle = false;
        private boolean requiresStorageNotLow = false;
        private boolean isFetchTask = false;
        private String jobService = null;

        public Builder setTaskId(String str) {
            this.taskId = str;
            return this;
        }

        public Builder setIsFetchTask(boolean z) {
            this.isFetchTask = z;
            return this;
        }

        public Builder setMinimumFetchInterval(int i) {
            if (i >= 1) {
                this.minimumFetchInterval = i;
            }
            return this;
        }

        public Builder setStopOnTerminate(boolean z) {
            this.stopOnTerminate = z;
            return this;
        }

        public Builder setStartOnBoot(boolean z) {
            this.startOnBoot = z;
            return this;
        }

        public Builder setRequiredNetworkType(int i) {
            if (i != 1 && i != 4 && i != 0 && i != 3 && i != 2) {
                LogInstrumentation.m2728e(BackgroundFetch.TAG, "[ERROR] Invalid requiredNetworkType: " + i + "; Defaulting to NETWORK_TYPE_NONE");
                i = 0;
            }
            this.requiredNetworkType = i;
            return this;
        }

        public Builder setRequiresBatteryNotLow(boolean z) {
            this.requiresBatteryNotLow = z;
            return this;
        }

        public Builder setRequiresCharging(boolean z) {
            this.requiresCharging = z;
            return this;
        }

        public Builder setRequiresDeviceIdle(boolean z) {
            this.requiresDeviceIdle = z;
            return this;
        }

        public Builder setRequiresStorageNotLow(boolean z) {
            this.requiresStorageNotLow = z;
            return this;
        }

        public Builder setJobService(String str) {
            this.jobService = str;
            return this;
        }

        public Builder setForceAlarmManager(boolean z) {
            this.forceAlarmManager = z;
            return this;
        }

        public Builder setPeriodic(boolean z) {
            this.periodic = z;
            return this;
        }

        public Builder setDelay(long j) {
            this.delay = j;
            return this;
        }

        public BackgroundFetchConfig build() {
            return new BackgroundFetchConfig(this);
        }

        public BackgroundFetchConfig load(Context context, String str) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("TSBackgroundFetch:" + str, 0);
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_TASK_ID)) {
                setTaskId(sharedPreferences.getString(BackgroundFetchConfig.FIELD_TASK_ID, str));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_IS_FETCH_TASK)) {
                setIsFetchTask(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_IS_FETCH_TASK, this.isFetchTask));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_MINIMUM_FETCH_INTERVAL)) {
                setMinimumFetchInterval(sharedPreferences.getInt(BackgroundFetchConfig.FIELD_MINIMUM_FETCH_INTERVAL, this.minimumFetchInterval));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_STOP_ON_TERMINATE)) {
                setStopOnTerminate(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_STOP_ON_TERMINATE, this.stopOnTerminate));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_REQUIRED_NETWORK_TYPE)) {
                setRequiredNetworkType(sharedPreferences.getInt(BackgroundFetchConfig.FIELD_REQUIRED_NETWORK_TYPE, this.requiredNetworkType));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_REQUIRES_BATTERY_NOT_LOW)) {
                setRequiresBatteryNotLow(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_REQUIRES_BATTERY_NOT_LOW, this.requiresBatteryNotLow));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_REQUIRES_CHARGING)) {
                setRequiresCharging(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_REQUIRES_CHARGING, this.requiresCharging));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_REQUIRES_DEVICE_IDLE)) {
                setRequiresDeviceIdle(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_REQUIRES_DEVICE_IDLE, this.requiresDeviceIdle));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_REQUIRES_STORAGE_NOT_LOW)) {
                setRequiresStorageNotLow(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_REQUIRES_STORAGE_NOT_LOW, this.requiresStorageNotLow));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_START_ON_BOOT)) {
                setStartOnBoot(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_START_ON_BOOT, this.startOnBoot));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_JOB_SERVICE)) {
                setJobService(sharedPreferences.getString(BackgroundFetchConfig.FIELD_JOB_SERVICE, null));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_FORCE_ALARM_MANAGER)) {
                setForceAlarmManager(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_FORCE_ALARM_MANAGER, this.forceAlarmManager));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_PERIODIC)) {
                setPeriodic(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_PERIODIC, this.periodic));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_DELAY)) {
                setDelay(sharedPreferences.getLong(BackgroundFetchConfig.FIELD_DELAY, this.delay));
            }
            return new BackgroundFetchConfig(this);
        }
    }

    private BackgroundFetchConfig(Builder builder) {
        this.config = builder;
        if (builder.jobService == null) {
            if (!this.config.stopOnTerminate) {
                LogInstrumentation.m2734w(BackgroundFetch.TAG, "- Configuration error:  In order to use stopOnTerminate: false, you must set enableHeadless: true");
                this.config.setStopOnTerminate(true);
            }
            if (this.config.startOnBoot) {
                LogInstrumentation.m2734w(BackgroundFetch.TAG, "- Configuration error:  In order to use startOnBoot: true, you must enableHeadless: true");
                this.config.setStartOnBoot(false);
            }
        }
    }

    void save(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(BackgroundFetch.TAG, 0);
        Set<String> stringSet = sharedPreferences.getStringSet("tasks", new HashSet());
        if (stringSet == null) {
            stringSet = new HashSet<>();
        }
        if (!stringSet.contains(this.config.taskId)) {
            HashSet hashSet = new HashSet(stringSet);
            hashSet.add(this.config.taskId);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putStringSet("tasks", hashSet);
            editorEdit.apply();
        }
        SharedPreferences.Editor editorEdit2 = context.getSharedPreferences("TSBackgroundFetch:" + this.config.taskId, 0).edit();
        editorEdit2.putString(FIELD_TASK_ID, this.config.taskId);
        editorEdit2.putBoolean(FIELD_IS_FETCH_TASK, this.config.isFetchTask);
        editorEdit2.putInt(FIELD_MINIMUM_FETCH_INTERVAL, this.config.minimumFetchInterval);
        editorEdit2.putBoolean(FIELD_STOP_ON_TERMINATE, this.config.stopOnTerminate);
        editorEdit2.putBoolean(FIELD_START_ON_BOOT, this.config.startOnBoot);
        editorEdit2.putInt(FIELD_REQUIRED_NETWORK_TYPE, this.config.requiredNetworkType);
        editorEdit2.putBoolean(FIELD_REQUIRES_BATTERY_NOT_LOW, this.config.requiresBatteryNotLow);
        editorEdit2.putBoolean(FIELD_REQUIRES_CHARGING, this.config.requiresCharging);
        editorEdit2.putBoolean(FIELD_REQUIRES_DEVICE_IDLE, this.config.requiresDeviceIdle);
        editorEdit2.putBoolean(FIELD_REQUIRES_STORAGE_NOT_LOW, this.config.requiresStorageNotLow);
        editorEdit2.putString(FIELD_JOB_SERVICE, this.config.jobService);
        editorEdit2.putBoolean(FIELD_FORCE_ALARM_MANAGER, this.config.forceAlarmManager);
        editorEdit2.putBoolean(FIELD_PERIODIC, this.config.periodic);
        editorEdit2.putLong(FIELD_DELAY, this.config.delay);
        editorEdit2.apply();
    }

    void destroy(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(BackgroundFetch.TAG, 0);
        Set<String> stringSet = sharedPreferences.getStringSet("tasks", new HashSet());
        if (stringSet == null) {
            stringSet = new HashSet<>();
        }
        if (stringSet.contains(this.config.taskId)) {
            HashSet hashSet = new HashSet(stringSet);
            hashSet.remove(this.config.taskId);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putStringSet("tasks", hashSet);
            editorEdit.apply();
        }
        if (this.config.isFetchTask) {
            return;
        }
        SharedPreferences.Editor editorEdit2 = context.getSharedPreferences("TSBackgroundFetch:" + this.config.taskId, 0).edit();
        editorEdit2.clear();
        editorEdit2.apply();
    }

    boolean isFetchTask() {
        return this.config.isFetchTask;
    }

    public String getTaskId() {
        return this.config.taskId;
    }

    public int getMinimumFetchInterval() {
        return this.config.minimumFetchInterval;
    }

    public int getRequiredNetworkType() {
        return this.config.requiredNetworkType;
    }

    public boolean getRequiresBatteryNotLow() {
        return this.config.requiresBatteryNotLow;
    }

    public boolean getRequiresCharging() {
        return this.config.requiresCharging;
    }

    public boolean getRequiresDeviceIdle() {
        return this.config.requiresDeviceIdle;
    }

    public boolean getRequiresStorageNotLow() {
        return this.config.requiresStorageNotLow;
    }

    public boolean getStopOnTerminate() {
        return this.config.stopOnTerminate;
    }

    public boolean getStartOnBoot() {
        return this.config.startOnBoot;
    }

    public String getJobService() {
        return this.config.jobService;
    }

    public boolean getForceAlarmManager() {
        return this.config.forceAlarmManager;
    }

    public boolean getPeriodic() {
        return this.config.periodic || isFetchTask();
    }

    public long getDelay() {
        return this.config.delay;
    }

    int getJobId() {
        if (this.config.forceAlarmManager) {
            return 0;
        }
        return isFetchTask() ? FETCH_JOB_ID : this.config.taskId.hashCode();
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FIELD_TASK_ID, this.config.taskId);
            jSONObject.put(FIELD_IS_FETCH_TASK, this.config.isFetchTask);
            jSONObject.put(FIELD_MINIMUM_FETCH_INTERVAL, this.config.minimumFetchInterval);
            jSONObject.put(FIELD_STOP_ON_TERMINATE, this.config.stopOnTerminate);
            jSONObject.put(FIELD_REQUIRED_NETWORK_TYPE, this.config.requiredNetworkType);
            jSONObject.put(FIELD_REQUIRES_BATTERY_NOT_LOW, this.config.requiresBatteryNotLow);
            jSONObject.put(FIELD_REQUIRES_CHARGING, this.config.requiresCharging);
            jSONObject.put(FIELD_REQUIRES_DEVICE_IDLE, this.config.requiresDeviceIdle);
            jSONObject.put(FIELD_REQUIRES_STORAGE_NOT_LOW, this.config.requiresStorageNotLow);
            jSONObject.put(FIELD_START_ON_BOOT, this.config.startOnBoot);
            jSONObject.put(FIELD_JOB_SERVICE, this.config.jobService);
            jSONObject.put(FIELD_FORCE_ALARM_MANAGER, this.config.forceAlarmManager);
            jSONObject.put(FIELD_PERIODIC, getPeriodic());
            jSONObject.put(FIELD_DELAY, this.config.delay);
            if (!(jSONObject instanceof JSONObject)) {
                return jSONObject.toString(2);
            }
            return JSONObjectInstrumentation.toString(jSONObject, 2);
        } catch (JSONException e) {
            e.printStackTrace();
            return !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
        }
    }

    static void load(final Context context, final OnLoadCallback onLoadCallback) {
        BackgroundFetch.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig.1
            @Override // java.lang.Runnable
            public void run() {
                final ArrayList arrayList = new ArrayList();
                Set<String> stringSet = context.getSharedPreferences(BackgroundFetch.TAG, 0).getStringSet("tasks", new HashSet());
                if (stringSet != null) {
                    Iterator<String> it2 = stringSet.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new Builder().load(context, it2.next()));
                    }
                }
                BackgroundFetch.getUiHandler().post(new Runnable() { // from class: com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        onLoadCallback.onLoad(arrayList);
                    }
                });
            }
        });
    }
}
