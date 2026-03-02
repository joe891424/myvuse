package com.reactnativenavigation.views.stack.topbar.titlebar;

import android.content.res.Resources;
import android.view.View;
import com.reactnativenavigation.utils.UiUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: TitleAndButtonsMeasurer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a&\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b\u001aJ\u0010\f\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b\u001a*\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000b\u001a*\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000b\u001a*\u0010\u0016\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0017\u0012\b\u0012\u00060\u0003j\u0002`\u00180\r2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005*\n\u0010\u001b\"\u00020\u00032\u00020\u0003*\n\u0010\u001c\"\u00020\u00032\u00020\u0003*\n\u0010\u001d\"\u00020\u00032\u00020\u0003*\n\u0010\u001e\"\u00020\u00032\u00020\u0003¨\u0006\u001f"}, m5598d2 = {"DEFAULT_LEFT_MARGIN_DP", "", "DEFAULT_LEFT_MARGIN_PX", "", "getDEFAULT_LEFT_MARGIN_PX", "()I", "makeTitleAtMostWidthMeasureSpec", "containerWidth", "rightBarWidth", "leftBarWidth", "isCenter", "", "resolveHorizontalTitleBoundsLimit", "Lkotlin/Pair;", "Lcom/reactnativenavigation/views/stack/topbar/titlebar/TitleLeft;", "Lcom/reactnativenavigation/views/stack/topbar/titlebar/TitleRight;", "parentWidth", "titleWidth", "isRTL", "resolveLeftButtonsBounds", "barWidth", "resolveRightButtonsBounds", "resolveVerticalTitleBoundsLimit", "Lcom/reactnativenavigation/views/stack/topbar/titlebar/TitleTop;", "Lcom/reactnativenavigation/views/stack/topbar/titlebar/TitleBottom;", "parentHeight", "titleHeight", "TitleBottom", "TitleLeft", "TitleRight", "TitleTop", "react-native-navigation_reactNative71Release"}, m5599k = 2, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class TitleAndButtonsMeasurerKt {
    public static final float DEFAULT_LEFT_MARGIN_DP = 16.0f;
    private static final int DEFAULT_LEFT_MARGIN_PX = (int) UiUtils.dpToPx(Resources.getSystem().getDisplayMetrics(), 16.0f);

    public static final int getDEFAULT_LEFT_MARGIN_PX() {
        return DEFAULT_LEFT_MARGIN_PX;
    }

    public static final int makeTitleAtMostWidthMeasureSpec(int i, int i2, int i3, boolean z) {
        if (z) {
            return View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(((i - i2) - i3) - (DEFAULT_LEFT_MARGIN_PX * 2), Integer.MIN_VALUE);
    }

    public static final Pair<Integer, Integer> resolveVerticalTitleBoundsLimit(int i, int i2) {
        float f = i / 2.0f;
        float f2 = i2 / 2.0f;
        return TuplesKt.m5605to(Integer.valueOf(MathKt.roundToInt(f - f2)), Integer.valueOf(MathKt.roundToInt(f + f2)));
    }

    public static final Pair<Integer, Integer> resolveHorizontalTitleBoundsLimit(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int iMin;
        int iMax;
        int iMax2;
        int iMin2;
        int i5 = z2 ? i4 : i3;
        if (!z2) {
            i3 = i4;
        }
        int i6 = i - i3;
        if (!z) {
            if (z2) {
                int i7 = DEFAULT_LEFT_MARGIN_PX;
                iMin = Math.max(i5 + i7, i6 - i7);
                iMax = Math.max(i5 + i7, (iMin - i2) - i7);
            } else {
                int i8 = DEFAULT_LEFT_MARGIN_PX;
                int iMin3 = Math.min(i5 + i8, i - i8);
                iMin = Math.min(i6 - i8, i2 + iMin3 + i8);
                iMax = iMin3;
            }
            iMax2 = Math.max(0, iMax);
            iMin2 = Math.min(i, iMin);
        } else {
            if (i2 >= (i - i5) - i3) {
                return TuplesKt.m5605to(Integer.valueOf(i5), Integer.valueOf(i6));
            }
            iMax2 = Math.max((i / 2) - (i2 / 2), 0);
            iMin2 = Math.min(i2 + iMax2, i);
            int iMax3 = Math.max(Math.max(i5 - iMax2, 0), Math.max(iMin2 - i6, 0));
            if (iMax3 > 0) {
                iMax2 += iMax3;
                iMin2 -= iMax3;
            }
        }
        return TuplesKt.m5605to(Integer.valueOf(iMax2), Integer.valueOf(iMin2));
    }

    public static final Pair<Integer, Integer> resolveLeftButtonsBounds(int i, int i2, boolean z) {
        if (z) {
            return TuplesKt.m5605to(Integer.valueOf(Math.max(0, i - i2)), Integer.valueOf(i));
        }
        return TuplesKt.m5605to(0, Integer.valueOf(Math.min(i2, i)));
    }

    public static final Pair<Integer, Integer> resolveRightButtonsBounds(int i, int i2, boolean z) {
        return resolveLeftButtonsBounds(i, i2, !z);
    }
}
