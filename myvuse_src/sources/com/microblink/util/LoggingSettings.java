package com.microblink.util;

import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class LoggingSettings {
    static {
        IIIlIllllI.llIIlIlIIl();
    }

    public static final void disableMicroblinkLogging() {
        Log.setLogLevel(Log.LogLevel.LOG_QUIET);
        logEnabledNativeSet(false);
    }

    private static native void logEnabledNativeSet(boolean z);
}
