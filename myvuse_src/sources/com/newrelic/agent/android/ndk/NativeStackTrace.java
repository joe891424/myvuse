package com.newrelic.agent.android.ndk;

import com.newrelic.agent.android.agentdata.HexAttribute;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeStackTrace.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/NativeStackTrace;", "", "stackTraceAsString", "", "(Ljava/lang/String;)V", "crashedThread", "Lcom/newrelic/agent/android/ndk/NativeThreadInfo;", "getCrashedThread", "()Lcom/newrelic/agent/android/ndk/NativeThreadInfo;", "setCrashedThread", "(Lcom/newrelic/agent/android/ndk/NativeThreadInfo;)V", AnalyticsAttribute.NATIVE_EXCEPTION_MESSAGE_ATTRIBUTE, "getExceptionMessage", "()Ljava/lang/String;", "setExceptionMessage", AnalyticsAttribute.APP_EXIT_THREADS_ATTRIBUTE, "", "getThreads", "()Ljava/util/List;", "setThreads", "(Ljava/util/List;)V", "transformNativeStackTrace", "jsonObj", "Lorg/json/JSONObject;", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NativeStackTrace {
    private NativeThreadInfo crashedThread;
    private String exceptionMessage;
    private List<NativeThreadInfo> threads;

    /* JADX WARN: Multi-variable type inference failed */
    public NativeStackTrace() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public NativeStackTrace(String str) {
        this.threads = new ArrayList();
        this.exceptionMessage = "Native exception";
        if (str == null) {
            return;
        }
        transformNativeStackTrace(str);
    }

    public /* synthetic */ NativeStackTrace(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final NativeThreadInfo getCrashedThread() {
        return this.crashedThread;
    }

    public final void setCrashedThread(NativeThreadInfo nativeThreadInfo) {
        this.crashedThread = nativeThreadInfo;
    }

    public final List<NativeThreadInfo> getThreads() {
        return this.threads;
    }

    public final void setThreads(List<NativeThreadInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.threads = list;
    }

    public final String getExceptionMessage() {
        return this.exceptionMessage;
    }

    public final void setExceptionMessage(String str) {
        this.exceptionMessage = str;
    }

    private final NativeStackTrace transformNativeStackTrace(String stackTraceAsString) {
        return transformNativeStackTrace(new JSONObject(stackTraceAsString));
    }

    private final NativeStackTrace transformNativeStackTrace(JSONObject jsonObj) {
        Object next;
        try {
            JSONObject jSONObject = jsonObj.getJSONObject("backtrace");
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("exception");
                String strOptString = jSONObject2.optString(HexAttribute.HEX_ATTR_CAUSE, "");
                setExceptionMessage(((Object) jSONObject2.getString("name")) + ": " + ((Object) strOptString));
                JSONObject jSONObject3 = jSONObject2.getJSONObject("signalInfo");
                StringBuilder sbAppend = new StringBuilder().append((Object) jSONObject3.getString("signalName")).append(" (code ").append(jSONObject3.getInt("signalCode")).append(") ").append((Object) strOptString).append(" at 0x");
                String string = Long.toString(jSONObject3.getLong("faultAddress"), CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
                setExceptionMessage(sbAppend.append(string).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                setThreads(NativeThreadInfo.INSTANCE.allThreads(jSONObject.getJSONArray(AnalyticsAttribute.APP_EXIT_THREADS_ATTRIBUTE)));
                Iterator<T> it2 = getThreads().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    if (((NativeThreadInfo) next).isCrashingThread()) {
                        break;
                    }
                }
                setCrashedThread((NativeThreadInfo) next);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            this.exceptionMessage = String.valueOf(e3.getMessage());
        }
        return this;
    }
}
