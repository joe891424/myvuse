package com.yoti.mobile.mpp.mrtddump.reader;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.common.base.Ascii;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import kotlin.Metadata;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileType;", "", "shortId", "", "fileId", "", HeaderParameterNames.AUTHENTICATION_TAG, "estimatedLength", "(Ljava/lang/String;IBIII)V", "getEstimatedLength", "()I", "getFileId", "getShortId", "()B", "getTag", "DG1", "DG2", "DG3", "DG4", "DG5", "DG6", "DG7", "DG8", "DG9", "DG10", "DG11", "DG12", "DG13", "DG14", "DG15", "DG16", "SOD", "COM", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public enum MrtdFileType {
    DG1((byte) 1, 257, 97, 40),
    DG2((byte) 2, 258, 117, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH),
    DG3((byte) 3, 259, 99, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH),
    DG4((byte) 4, 260, 118, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH),
    DG5((byte) 5, 261, 101, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH),
    DG6((byte) 6, 262, 102, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH),
    DG7((byte) 7, 263, 103, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH),
    DG8((byte) 8, 264, 104, 1000),
    DG9((byte) 9, 265, 105, 1000),
    DG10((byte) 10, 266, 106, 1000),
    DG11(Ascii.f3760VT, 267, 107, 1000),
    DG12(Ascii.f3749FF, 268, 108, 1000),
    DG13(Ascii.f3747CR, 269, 109, 1000),
    DG14(Ascii.f3757SO, RotationOptions.ROTATE_270, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SHOW_BANNER_CALLED, 200),
    DG15(Ascii.f3756SI, 271, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_NEW_GROUP_ADDED, 200),
    DG16(Ascii.DLE, 272, 112, 200),
    SOD(Ascii.f3751GS, 285, 119, 2000),
    COM(Ascii.f3755RS, 286, 96, 100);

    private final int estimatedLength;
    private final int fileId;
    private final byte shortId;
    private final int tag;

    MrtdFileType(byte b, int i, int i2, int i3) {
        this.shortId = b;
        this.fileId = i;
        this.tag = i2;
        this.estimatedLength = i3;
    }

    public final int getEstimatedLength() {
        return this.estimatedLength;
    }

    public final int getFileId() {
        return this.fileId;
    }

    public final byte getShortId() {
        return this.shortId;
    }

    public final int getTag() {
        return this.tag;
    }
}
