package com.newrelic.agent.android.ndk;

import androidx.camera.core.CameraInfo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.agentdata.HexAttribute;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeStackFrame.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0003J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/NativeStackFrame;", "", HexAttribute.HEX_ATTR_CLASS_NAME, "", "methodName", "fileName", "lineNumber", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "delegate", "Ljava/lang/StackTraceElement;", "getDelegate", "()Ljava/lang/StackTraceElement;", "setDelegate", "(Ljava/lang/StackTraceElement;)V", "asStackTraceElement", "fromJson", "stackFrameAsStr", TypedValues.AttributesType.S_FRAME, "Lorg/json/JSONObject;", "Companion", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NativeStackFrame {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private StackTraceElement delegate;

    public NativeStackFrame() {
        this(null, null, null, 0, 15, null);
    }

    public NativeStackFrame(String className, String methodName, String fileName, int i) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.delegate = new StackTraceElement(className, methodName, fileName, i);
    }

    public /* synthetic */ NativeStackFrame(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "<native>" : str, (i2 & 2) != 0 ? CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN : str2, (i2 & 4) != 0 ? CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN : str3, (i2 & 8) != 0 ? -2 : i);
    }

    public final StackTraceElement getDelegate() {
        return this.delegate;
    }

    public final void setDelegate(StackTraceElement stackTraceElement) {
        Intrinsics.checkNotNullParameter(stackTraceElement, "<set-?>");
        this.delegate = stackTraceElement;
    }

    /* JADX INFO: renamed from: asStackTraceElement, reason: from getter */
    public final StackTraceElement getDelegate() {
        return this.delegate;
    }

    public final NativeStackFrame fromJson(JSONObject frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        try {
            String string = Long.toString(frame.optLong("address", frame.optLong("so_base", -1L)), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
            String strStringPlus = Intrinsics.stringPlus("0x", string);
            String strOptString = frame.optString("sym_name", "???");
            String string2 = Long.toString(frame.optLong("so_base", -1L), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string2, "toString(this, checkRadix(radix))");
            this.delegate = new StackTraceElement(strStringPlus, strOptString, frame.optString("so_path", Intrinsics.stringPlus("0x", string2)), frame.optInt("lineNumber", -2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public final NativeStackFrame fromJson(String stackFrameAsStr) {
        Intrinsics.checkNotNullParameter(stackFrameAsStr, "stackFrameAsStr");
        return fromJson(new JSONObject(stackFrameAsStr));
    }

    /* JADX INFO: compiled from: NativeStackFrame.kt */
    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¨\u0006\t"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/NativeStackFrame$Companion;", "", "()V", "allFrames", "", "Ljava/lang/StackTraceElement;", "Lorg/json/JSONArray;", "allNativeFrames", "Lcom/newrelic/agent/android/ndk/NativeStackFrame;", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<StackTraceElement> allFrames(JSONArray allFrames) {
            ArrayList arrayList = new ArrayList();
            if (allFrames != null) {
                int length = allFrames.length();
                int i = 0;
                while (i < length) {
                    int i2 = i + 1;
                    if (!allFrames.isNull(i)) {
                        try {
                            Object obj = allFrames.get(i);
                            if (obj == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                            JSONObject jSONObject = (JSONObject) obj;
                            arrayList.add(jSONObject.optInt(FirebaseAnalytics.Param.INDEX, arrayList.size()), new NativeStackFrame(null, null, null, 0, 15, null).fromJson(jSONObject).getDelegate());
                        } catch (Exception unused) {
                            arrayList.add(new NativeStackFrame(allFrames.get(i).toString(), null, null, 0, 14, null).getDelegate());
                        }
                    }
                    i = i2;
                }
            }
            return arrayList;
        }

        public final List<NativeStackFrame> allNativeFrames(JSONArray allFrames) {
            ArrayList arrayList = new ArrayList();
            if (allFrames != null) {
                int length = allFrames.length();
                int i = 0;
                while (i < length) {
                    int i2 = i + 1;
                    if (!allFrames.isNull(i)) {
                        try {
                            Object obj = allFrames.get(i);
                            if (obj == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                            JSONObject jSONObject = (JSONObject) obj;
                            arrayList.add(jSONObject.optInt(FirebaseAnalytics.Param.INDEX, arrayList.size()), new NativeStackFrame(null, null, null, 0, 15, null).fromJson(jSONObject));
                        } catch (Exception unused) {
                            arrayList.add(new NativeStackFrame(allFrames.get(i).toString(), null, null, 0, 14, null));
                        }
                    }
                    i = i2;
                }
            }
            return arrayList;
        }
    }
}
