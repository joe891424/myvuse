package org.slf4j.event;

import com.google.firebase.perf.FirebasePerformance;
import com.yoti.mobile.android.remote.debug.RemoteDebugPreferencesKt;

/* JADX INFO: loaded from: classes6.dex */
public enum Level {
    ERROR(40, RemoteDebugPreferencesKt.DEBUG_OPTIONS_REMOTE_BEHAVIOUR_ERROR),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, FirebasePerformance.HttpMethod.TRACE);

    private int levelInt;
    private String levelStr;

    Level(int i, String str) {
        this.levelInt = i;
        this.levelStr = str;
    }

    public int toInt() {
        return this.levelInt;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.levelStr;
    }
}
