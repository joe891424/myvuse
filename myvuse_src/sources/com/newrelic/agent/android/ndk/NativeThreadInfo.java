package com.newrelic.agent.android.ndk;

import androidx.camera.core.CameraInfo;
import com.newrelic.agent.android.harvest.crash.ThreadInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeThreadInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u000f\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0015\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u001f\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u0017¨\u0006\u0019"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/NativeThreadInfo;", "Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;", "()V", "threadInfoAsJson", "", "(Ljava/lang/String;)V", "nativeException", "Lcom/newrelic/agent/android/ndk/NativeException;", "(Lcom/newrelic/agent/android/ndk/NativeException;)V", "fromJson", "threadInfoAsJsonStr", "fromJsonObject", "jsonObject", "Lorg/json/JSONObject;", "getStackTrace", "", "Ljava/lang/StackTraceElement;", "()[Ljava/lang/StackTraceElement;", "isCrashingThread", "", "stackTraceFromJson", "allFrames", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)[Ljava/lang/StackTraceElement;", "Companion", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NativeThreadInfo extends ThreadInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public NativeThreadInfo(NativeException nativeException) {
        super(nativeException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NativeThreadInfo() {
        this(new NativeException(null, 1, 0 == true ? 1 : 0));
    }

    public NativeThreadInfo(String str) {
        this();
        fromJson(str);
    }

    public final NativeThreadInfo fromJsonObject(JSONObject jsonObject) {
        if (jsonObject != null) {
            try {
                this.crashed = jsonObject.optBoolean("crashed", false);
                this.state = jsonObject.optString("state", "");
                this.threadId = jsonObject.optLong("threadNumber", 0L);
                this.threadName = jsonObject.optString("threadId", "");
                this.threadPriority = jsonObject.optInt("priority", -1);
                this.stackTrace = stackTraceFromJson(jsonObject.optJSONArray("stack"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public final NativeThreadInfo fromJson(String threadInfoAsJsonStr) {
        return fromJsonObject(threadInfoAsJsonStr == null ? null : new JSONObject(threadInfoAsJsonStr));
    }

    private final StackTraceElement[] stackTraceFromJson(JSONArray allFrames) {
        int i = 0;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[0];
        if (allFrames != null) {
            try {
                stackTraceElementArr = new StackTraceElement[allFrames.length()];
                int length = allFrames.length();
                while (i < length) {
                    int i2 = i + 1;
                    if (!allFrames.isNull(i)) {
                        try {
                            Object obj = allFrames.get(i);
                            if (obj == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                            stackTraceElementArr[i] = new NativeStackFrame(null, null, null, 0, 15, null).fromJson((JSONObject) obj).getDelegate();
                        } catch (Exception unused) {
                            stackTraceElementArr[i] = new StackTraceElement(CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN, CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN, CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN, -2);
                        }
                    }
                    i = i2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stackTraceElementArr;
    }

    public final boolean isCrashingThread() {
        return this.crashed;
    }

    public final StackTraceElement[] getStackTrace() {
        return this.stackTrace;
    }

    /* JADX INFO: compiled from: NativeThreadInfo.kt */
    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/NativeThreadInfo$Companion;", "", "()V", "allThreads", "", "Lcom/newrelic/agent/android/ndk/NativeThreadInfo;", "Lorg/json/JSONArray;", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<NativeThreadInfo> allThreads(JSONArray allThreads) {
            ArrayList arrayList = new ArrayList();
            if (allThreads != null) {
                int length = allThreads.length();
                int i = 0;
                while (i < length) {
                    int i2 = i + 1;
                    if (!allThreads.isNull(i)) {
                        arrayList.add(new NativeThreadInfo(allThreads.get(i).toString()));
                    }
                    i = i2;
                }
            }
            return arrayList;
        }
    }
}
