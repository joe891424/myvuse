package com.microblink.fragment.overlay.components.feedback;

import com.microblink.uisettings.options.OcrResultDisplayMode;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class RecognitionFeedbackHandlerFactory {

    /* JADX INFO: renamed from: com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandlerFactory$1 */
    /* JADX INFO: compiled from: line */
    static /* synthetic */ class C37011 {
        static final /* synthetic */ int[] llIIlIlIIl;

        static {
            int[] iArr = new int[OcrResultDisplayMode.values().length];
            llIIlIlIIl = iArr;
            try {
                iArr[OcrResultDisplayMode.STATIC_CHARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                llIIlIlIIl[OcrResultDisplayMode.ANIMATED_DOTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                llIIlIlIIl[OcrResultDisplayMode.NOTHING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static RecognitionFeedbackHandler create(OcrResultDisplayMode ocrResultDisplayMode) {
        int i = C37011.llIIlIlIIl[ocrResultDisplayMode.ordinal()];
        return i != 1 ? i != 2 ? RecognitionFeedbackHandler.EMPTY : new OcrDotsFeedbackHandler() : new OcrCharsFeedbackHandler();
    }
}
