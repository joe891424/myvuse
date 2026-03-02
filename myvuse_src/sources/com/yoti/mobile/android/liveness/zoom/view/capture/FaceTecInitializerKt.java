package com.yoti.mobile.android.liveness.zoom.view.capture;

import android.graphics.Rect;
import android.graphics.Typeface;
import com.yoti.mobile.android.liveness.zoom.C4888R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"#\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"#\u0010\u0015\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0016\u0010\b\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"#\u0010\u001e\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b\u001f\u0010\b¨\u0006!"}, m5598d2 = {"ACCENT_COLOR_ID", "", "ACCENT_DISABLED_COLOR_ID", "ACCENT_PRESSED_COLOR_ID", "BUTTON_FONT", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "getBUTTON_FONT", "()Landroid/graphics/Typeface;", "BUTTON_FONT$delegate", "Lkotlin/Lazy;", "CANCEL_BUTTON_IMAGE_ID", "CANCEL_BUTTON_LOCATION", "Landroid/graphics/Rect;", "FEEDBACK_BACKGROUND_COLOR_ID", "FEEDBACK_CORNER_RADIUS_DP", "FEEDBACK_TEXT_COLOR_ID", "FOREGROUND_COLOR_ID", "FRAME_BACKGROUND_COLOR_ID", "GUIDANCE_BUTTON_TEXT_COLOR_ID", "GUIDANCE_BUTTON_TEXT_DISABLED_COLOR_ID", "HEADER_FONT", "getHEADER_FONT", "HEADER_FONT$delegate", "OVAL_PROGRESS1_COLOR_ID", "OVAL_PROGRESS2_COLOR_ID", "OVAL_PROGRESS_STROKE_WIDTH_DP", "OVAL_STROKE_COLOR_ID", "OVAL_STROKE_WIDTH_DP", "RETRY_SCREEN_IMAGE_CORNER_RADIUS_DP", "SUBTEXT_FONT", "getSUBTEXT_FONT", "SUBTEXT_FONT$delegate", "liveness-zoom_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceTecInitializerKt {
    private static final int ACCENT_COLOR_ID;
    private static final int ACCENT_DISABLED_COLOR_ID;
    private static final int ACCENT_PRESSED_COLOR_ID;
    private static final int CANCEL_BUTTON_IMAGE_ID;
    private static final Rect CANCEL_BUTTON_LOCATION;
    private static final int FEEDBACK_BACKGROUND_COLOR_ID;
    private static final int FEEDBACK_CORNER_RADIUS_DP = 7;
    private static final int FEEDBACK_TEXT_COLOR_ID;
    private static final int FOREGROUND_COLOR_ID;
    private static final int FRAME_BACKGROUND_COLOR_ID;
    private static final int GUIDANCE_BUTTON_TEXT_COLOR_ID;
    private static final int GUIDANCE_BUTTON_TEXT_DISABLED_COLOR_ID;
    private static final int OVAL_PROGRESS1_COLOR_ID;
    private static final int OVAL_PROGRESS2_COLOR_ID;
    private static final int OVAL_PROGRESS_STROKE_WIDTH_DP = 8;
    private static final int OVAL_STROKE_COLOR_ID;
    private static final int OVAL_STROKE_WIDTH_DP = 0;
    private static final int RETRY_SCREEN_IMAGE_CORNER_RADIUS_DP = 7;
    private static final Lazy HEADER_FONT$delegate = LazyKt.lazy(new Function0<Typeface>() { // from class: com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecInitializerKt$HEADER_FONT$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Typeface invoke() {
            return Typeface.create("sans-serif", 1);
        }
    });
    private static final Lazy SUBTEXT_FONT$delegate = LazyKt.lazy(new Function0<Typeface>() { // from class: com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecInitializerKt$SUBTEXT_FONT$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Typeface invoke() {
            return Typeface.create("sans-serif", 0);
        }
    });
    private static final Lazy BUTTON_FONT$delegate = LazyKt.lazy(new Function0<Typeface>() { // from class: com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecInitializerKt$BUTTON_FONT$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Typeface invoke() {
            return FaceTecInitializerKt.getHEADER_FONT();
        }
    });

    static {
        int i = C4888R.color.yds_theme_secondary;
        ACCENT_COLOR_ID = i;
        ACCENT_PRESSED_COLOR_ID = C4888R.color.yds_theme_button_primary_background_pressed;
        ACCENT_DISABLED_COLOR_ID = C4888R.color.yds_theme_button_primary_background_disabled;
        int i2 = C4888R.color.yds_theme_typography_neutral_contrast;
        FOREGROUND_COLOR_ID = i2;
        int i3 = C4888R.color.yds_theme_background_neutral1;
        FRAME_BACKGROUND_COLOR_ID = i3;
        OVAL_STROKE_COLOR_ID = C4888R.color.yds_theme_color_on_primary;
        OVAL_PROGRESS1_COLOR_ID = i;
        OVAL_PROGRESS2_COLOR_ID = i;
        GUIDANCE_BUTTON_TEXT_COLOR_ID = C4888R.color.yds_theme_button_primary_foreground;
        GUIDANCE_BUTTON_TEXT_DISABLED_COLOR_ID = C4888R.color.yds_theme_button_primary_foreground_disabled;
        FEEDBACK_BACKGROUND_COLOR_ID = i2;
        FEEDBACK_TEXT_COLOR_ID = i3;
        CANCEL_BUTTON_IMAGE_ID = C4888R.drawable.ic_action_dismiss_cross_black;
        CANCEL_BUTTON_LOCATION = new Rect(8, 8, 30, 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Typeface getBUTTON_FONT() {
        return (Typeface) BUTTON_FONT$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Typeface getHEADER_FONT() {
        return (Typeface) HEADER_FONT$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Typeface getSUBTEXT_FONT() {
        return (Typeface) SUBTEXT_FONT$delegate.getValue();
    }
}
