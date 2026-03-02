package com.yoti.mobile.android.facecapture.view.capture.model;

import com.yoti.mobile.android.facecapture.C4832R;
import com.yoti.mobile.android.facecapture.view.capture.model.ScanFeedback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'ANALYSIS_ERROR' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedbackType;", "", "feedbackText", "", "frameType", "Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback$FrameType;", "(Ljava/lang/String;ILjava/lang/Integer;Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback$FrameType;)V", "getFeedbackText", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFrameType", "()Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback$FrameType;", "VALID_FACE", "ANALYSIS_ERROR", "NO_FACE", "MULTIPLE_FACES", "FACE_TOO_SMALL", "FACE_TOO_BIG", "FACE_NOT_CENTERED", "FACE_NOT_STRAIGHT", "EYES_NOT_OPEN", "FACE_NOT_STABLE", "ENVIRONMENT_TOO_DARK", "NONE", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ScanFeedbackType {
    public static final ScanFeedbackType ANALYSIS_ERROR;
    public static final ScanFeedbackType ENVIRONMENT_TOO_DARK;
    public static final ScanFeedbackType EYES_NOT_OPEN;
    public static final ScanFeedbackType FACE_NOT_CENTERED;
    public static final ScanFeedbackType FACE_NOT_STABLE;
    public static final ScanFeedbackType FACE_NOT_STRAIGHT;
    public static final ScanFeedbackType FACE_TOO_BIG;
    public static final ScanFeedbackType FACE_TOO_SMALL;
    public static final ScanFeedbackType NONE;
    public static final ScanFeedbackType NO_FACE;
    private final Integer feedbackText;
    private final ScanFeedback.FrameType frameType;
    public static final ScanFeedbackType VALID_FACE = new ScanFeedbackType("VALID_FACE", 0, Integer.valueOf(C4832R.string.yds_face_capture_face_not_stable), ScanFeedback.FrameType.VALID_FACE_DETECTED);
    public static final ScanFeedbackType MULTIPLE_FACES = new ScanFeedbackType("MULTIPLE_FACES", 3, Integer.valueOf(C4832R.string.yds_face_capture_two_in_frame), ScanFeedback.FrameType.CAPTURE_ERROR);
    private static final /* synthetic */ ScanFeedbackType[] $VALUES = $values();

    private static final /* synthetic */ ScanFeedbackType[] $values() {
        return new ScanFeedbackType[]{VALID_FACE, ANALYSIS_ERROR, NO_FACE, MULTIPLE_FACES, FACE_TOO_SMALL, FACE_TOO_BIG, FACE_NOT_CENTERED, FACE_NOT_STRAIGHT, EYES_NOT_OPEN, FACE_NOT_STABLE, ENVIRONMENT_TOO_DARK, NONE};
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        ScanFeedback.FrameType frameType = null;
        ANALYSIS_ERROR = new ScanFeedbackType("ANALYSIS_ERROR", 1, null, frameType, 3, defaultConstructorMarker);
        int i = 2;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        ScanFeedback.FrameType frameType2 = null;
        NO_FACE = new ScanFeedbackType("NO_FACE", 2, Integer.valueOf(C4832R.string.yds_face_capture_frame_your_face), frameType2, i, defaultConstructorMarker2);
        FACE_TOO_SMALL = new ScanFeedbackType("FACE_TOO_SMALL", 4, Integer.valueOf(C4832R.string.yds_face_capture_move_closer), frameType, 2, defaultConstructorMarker);
        FACE_TOO_BIG = new ScanFeedbackType("FACE_TOO_BIG", 5, Integer.valueOf(C4832R.string.yds_face_capture_move_further_away), frameType2, i, defaultConstructorMarker2);
        int i2 = 2;
        DefaultConstructorMarker defaultConstructorMarker3 = null;
        ScanFeedback.FrameType frameType3 = null;
        FACE_NOT_CENTERED = new ScanFeedbackType("FACE_NOT_CENTERED", 6, Integer.valueOf(C4832R.string.yds_face_capture_central), frameType3, i2, defaultConstructorMarker3);
        int i3 = 2;
        DefaultConstructorMarker defaultConstructorMarker4 = null;
        ScanFeedback.FrameType frameType4 = null;
        FACE_NOT_STRAIGHT = new ScanFeedbackType("FACE_NOT_STRAIGHT", 7, Integer.valueOf(C4832R.string.yds_face_capture_face_not_straight), frameType4, i3, defaultConstructorMarker4);
        EYES_NOT_OPEN = new ScanFeedbackType("EYES_NOT_OPEN", 8, Integer.valueOf(C4832R.string.yds_face_capture_closed_eyes), frameType3, i2, defaultConstructorMarker3);
        FACE_NOT_STABLE = new ScanFeedbackType("FACE_NOT_STABLE", 9, Integer.valueOf(C4832R.string.yds_face_capture_face_not_stable), frameType4, i3, defaultConstructorMarker4);
        ENVIRONMENT_TOO_DARK = new ScanFeedbackType("ENVIRONMENT_TOO_DARK", 10, Integer.valueOf(C4832R.string.yds_face_capture_not_enough_light), frameType3, i2, defaultConstructorMarker3);
        NONE = new ScanFeedbackType("NONE", 11, null, frameType4, 3, defaultConstructorMarker4);
    }

    private ScanFeedbackType(String str, int i, Integer num, ScanFeedback.FrameType frameType) {
        this.feedbackText = num;
        this.frameType = frameType;
    }

    public static ScanFeedbackType valueOf(String str) {
        return (ScanFeedbackType) Enum.valueOf(ScanFeedbackType.class, str);
    }

    public static ScanFeedbackType[] values() {
        return (ScanFeedbackType[]) $VALUES.clone();
    }

    public final Integer getFeedbackText() {
        return this.feedbackText;
    }

    public final ScanFeedback.FrameType getFrameType() {
        return this.frameType;
    }

    /* synthetic */ ScanFeedbackType(String str, int i, Integer num, ScanFeedback.FrameType frameType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? ScanFeedback.FrameType.DEFAULT : frameType);
    }
}
