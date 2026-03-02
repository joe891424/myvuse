package com.newrelic.agent.android.ndk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JVMDelegate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0006¨\u0006\u000b"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/JVMDelegate;", "", "()V", "onApplicationNotResponding", "", "anrAsString", "", "onNativeCrash", "crashAsString", "onNativeException", "exceptionAsString", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class JVMDelegate {
    public final void onNativeCrash(String crashAsString) {
        AgentNDKListener nativeReportListener;
        AgentNDK.INSTANCE.getLog().debug(Intrinsics.stringPlus("onNativeCrash: ", crashAsString));
        ManagedContext managedContext = AgentNDK.INSTANCE.getInstance().getManagedContext();
        if (managedContext == null || (nativeReportListener = managedContext.getNativeReportListener()) == null) {
            return;
        }
        nativeReportListener.onNativeCrash(crashAsString);
    }

    public final void onNativeException(String exceptionAsString) {
        AgentNDKListener nativeReportListener;
        AgentNDK.INSTANCE.getLog().debug(Intrinsics.stringPlus("onNativeException: ", exceptionAsString));
        ManagedContext managedContext = AgentNDK.INSTANCE.getInstance().getManagedContext();
        if (managedContext == null || (nativeReportListener = managedContext.getNativeReportListener()) == null) {
            return;
        }
        nativeReportListener.onNativeException(exceptionAsString);
    }

    public final void onApplicationNotResponding(String anrAsString) {
        AgentNDKListener nativeReportListener;
        AgentNDK.INSTANCE.getLog().debug(Intrinsics.stringPlus("onApplicationNotResponding: ", anrAsString));
        if (ANRMonitor.INSTANCE.getInstance().isRunning()) {
            ANRMonitor.INSTANCE.getInstance().createANRReport(anrAsString);
            return;
        }
        ManagedContext managedContext = AgentNDK.INSTANCE.getInstance().getManagedContext();
        if (managedContext == null || (nativeReportListener = managedContext.getNativeReportListener()) == null) {
            return;
        }
        nativeReportListener.onApplicationNotResponding(anrAsString);
    }
}
