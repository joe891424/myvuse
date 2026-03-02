package com.newrelic.agent.android.ndk;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NativeException.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0002\u0010\u0013R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\b¨\u0006\u0014"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/NativeException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "stackTraceAsJson", "", "(Ljava/lang/String;)V", "message", "getMessage", "()Ljava/lang/String;", "nativeStackTrace", "Lcom/newrelic/agent/android/ndk/NativeStackTrace;", "getNativeStackTrace", "()Lcom/newrelic/agent/android/ndk/NativeStackTrace;", "setNativeStackTrace", "(Lcom/newrelic/agent/android/ndk/NativeStackTrace;)V", "getStackTraceAsJson", "getStackTrace", "", "Ljava/lang/StackTraceElement;", "()[Ljava/lang/StackTraceElement;", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class NativeException extends RuntimeException {
    private NativeStackTrace nativeStackTrace;
    private final String stackTraceAsJson;

    /* JADX WARN: Multi-variable type inference failed */
    public NativeException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ NativeException(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getStackTraceAsJson() {
        return this.stackTraceAsJson;
    }

    public NativeException(String str) {
        super("New Relic native exception");
        this.stackTraceAsJson = str;
        setStackTrace(Thread.currentThread().getStackTrace());
        if (str == null) {
            return;
        }
        setNativeStackTrace(new NativeStackTrace(str));
        setStackTrace(getStackTrace());
    }

    public final NativeStackTrace getNativeStackTrace() {
        return this.nativeStackTrace;
    }

    public final void setNativeStackTrace(NativeStackTrace nativeStackTrace) {
        this.nativeStackTrace = nativeStackTrace;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        NativeStackTrace nativeStackTrace = this.nativeStackTrace;
        if (nativeStackTrace == null) {
            return null;
        }
        return nativeStackTrace.getExceptionMessage();
    }

    @Override // java.lang.Throwable
    public StackTraceElement[] getStackTrace() {
        NativeThreadInfo crashedThread;
        StackTraceElement[] stackTrace;
        ArrayList arrayList = new ArrayList();
        NativeStackTrace nativeStackTrace = this.nativeStackTrace;
        if (nativeStackTrace != null && (crashedThread = nativeStackTrace.getCrashedThread()) != null && (stackTrace = crashedThread.getStackTrace()) != null) {
            int length = stackTrace.length;
            int i = 0;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                i++;
                if (stackTraceElement != null) {
                    arrayList.add(stackTraceElement);
                }
            }
        }
        Object[] array = arrayList.toArray(new StackTraceElement[0]);
        if (array != null) {
            return (StackTraceElement[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
