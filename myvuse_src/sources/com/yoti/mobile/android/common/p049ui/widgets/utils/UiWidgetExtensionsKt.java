package com.yoti.mobile.android.common.p049ui.widgets.utils;

import android.content.res.Resources;
import android.content.res.TypedArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0004\u001a\u00020\u0002*\u00060\u0000R\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\t\u001a\u0004\u0018\u00010\u0002*\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m5598d2 = {"Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "", "attrResId", "getColorFromAttribute", "(Landroid/content/res/Resources$Theme;I)I", "Landroid/content/res/TypedArray;", "styleableRes", "fallbackRes", "getStyleableResIfPresent", "(Landroid/content/res/TypedArray;II)Ljava/lang/Integer;", "uiWidgets_release"}, m5599k = 2, m5600mv = {1, 4, 2})
public final class UiWidgetExtensionsKt {
    public static final int getColorFromAttribute(Resources.Theme getColorFromAttribute, int i) {
        Intrinsics.checkNotNullParameter(getColorFromAttribute, "$this$getColorFromAttribute");
        TypedArray typedArrayObtainStyledAttributes = getColorFromAttribute.obtainStyledAttributes(new int[]{i});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(intArrayOf(attrResId))");
        int color = typedArrayObtainStyledAttributes.getColor(0, -65281);
        typedArrayObtainStyledAttributes.recycle();
        return color;
    }

    public static final Integer getStyleableResIfPresent(TypedArray getStyleableResIfPresent, int i, int i2) {
        Intrinsics.checkNotNullParameter(getStyleableResIfPresent, "$this$getStyleableResIfPresent");
        if (getStyleableResIfPresent.hasValue(i)) {
            return Integer.valueOf(i);
        }
        if (getStyleableResIfPresent.hasValue(i2)) {
            return Integer.valueOf(i2);
        }
        return null;
    }
}
