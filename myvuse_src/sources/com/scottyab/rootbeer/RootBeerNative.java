package com.scottyab.rootbeer;

import com.scottyab.rootbeer.util.QLog;

/* JADX INFO: loaded from: classes6.dex */
public class RootBeerNative {
    private static boolean libraryLoaded = false;

    public native int checkForRoot(Object[] objArr);

    public native int setLogDebugMessages(boolean z);

    static {
        try {
            System.loadLibrary("toolChecker");
            libraryLoaded = true;
        } catch (UnsatisfiedLinkError e) {
            QLog.m4357e(e);
        }
    }

    public boolean wasNativeLibraryLoaded() {
        return libraryLoaded;
    }
}
