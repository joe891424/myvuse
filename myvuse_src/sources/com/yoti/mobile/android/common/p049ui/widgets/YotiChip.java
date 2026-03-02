package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.chip.Chip;
import com.google.android.material.color.MaterialColors;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\r\u0010\u0011B!\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiChip;", "Lcom/google/android/material/chip/Chip;", "Lcom/yoti/mobile/android/common/ui/widgets/ChipStyle;", "style", "", "setStyle", "(Lcom/yoti/mobile/android/common/ui/widgets/ChipStyle;)V", "Lcom/yoti/mobile/android/common/ui/widgets/ChipSize;", "size", "setSize", "(Lcom/yoti/mobile/android/common/ui/widgets/ChipSize;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Lcom/yoti/mobile/android/common/ui/widgets/ChipStyle;Lcom/yoti/mobile/android/common/ui/widgets/ChipSize;)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class YotiChip extends Chip {

    /* JADX INFO: renamed from: a */
    private HashMap f6018a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiChip(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setEnabled(false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiChip(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        setEnabled(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, C4584R.styleable.YotiChip, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl….YotiChip, 0, 0\n        )");
        setStyle(YotiChipKt.m4419b(typedArrayObtainStyledAttributes.getInt(C4584R.styleable.YotiChip_yotiChipStyle, YotiChipKt.f6019a)));
        setSize(YotiChipKt.m4418a(typedArrayObtainStyledAttributes.getInt(C4584R.styleable.YotiChip_yotiChipSize, YotiChipKt.f6020b)));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiChip(Context context, ChipStyle style, ChipSize size) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(size, "size");
        setEnabled(false);
        setStyle(style);
        setSize(size);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6018a;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f6018a == null) {
            this.f6018a = new HashMap();
        }
        View view = (View) this.f6018a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f6018a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void setSize(ChipSize size) {
        Intrinsics.checkNotNullParameter(size, "size");
        setTextAppearance(size.getTextAppearanceRes());
        setChipIconSizeResource(size.getIconSizeRes());
        setChipStartPaddingResource(size.getStartPaddingRes());
        setTextStartPaddingResource(size.getTextPaddingRes());
        setChipEndPaddingResource(size.getEndPaddingRes());
        setTextEndPadding(0.0f);
        setIconEndPaddingResource(size.getIconPaddingRes());
    }

    public final void setStyle(ChipStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        setChipBackgroundColor(ColorStateList.valueOf(MaterialColors.getColor(this, style.getBackgroundColorAttr())));
        setChipIconTint(ColorStateList.valueOf(MaterialColors.getColor(this, style.getTintColorAttr())));
        setTextColor(MaterialColors.getColor(this, style.getTextColorAttr()));
    }
}
