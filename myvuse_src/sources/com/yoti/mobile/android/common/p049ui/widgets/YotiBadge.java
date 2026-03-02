package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import com.yoti.mobile.android.common.p049ui.widgets.utils.UiWidgetExtensionsKt;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiBadge;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "colors", "", "setBackground", "([I)V", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "getGradientOrientation", "()Landroid/graphics/drawable/GradientDrawable$Orientation;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class YotiBadge extends AppCompatTextView {

    /* JADX INFO: renamed from: a */
    private HashMap f6013a;

    public YotiBadge(Context context) {
        this(context, null, 0, 6, null);
    }

    public YotiBadge(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiBadge(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C4584R.styleable.YotiBadge, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…YotiBadge, 0, 0\n        )");
        setPaddingRelative(context.getResources().getDimensionPixelSize(C4584R.dimen.yoti_badge_padding_horizontal), context.getResources().getDimensionPixelSize(C4584R.dimen.yoti_badge_padding_vertical), context.getResources().getDimensionPixelSize(C4584R.dimen.yoti_badge_padding_horizontal), context.getResources().getDimensionPixelSize(C4584R.dimen.yoti_badge_padding_vertical));
        setGravity(17);
        int color = typedArrayObtainStyledAttributes.getColor(C4584R.styleable.YotiBadge_badge_background_color_0, -1);
        int i2 = C4584R.styleable.YotiBadge_badge_background_color_1;
        Resources.Theme theme = context.getTheme();
        Intrinsics.checkNotNullExpressionValue(theme, "context.theme");
        int color2 = typedArrayObtainStyledAttributes.getColor(i2, UiWidgetExtensionsKt.getColorFromAttribute(theme, C4584R.attr.icon_new_badge_1));
        int i3 = C4584R.styleable.YotiBadge_badge_background_color_2;
        Resources.Theme theme2 = context.getTheme();
        Intrinsics.checkNotNullExpressionValue(theme2, "context.theme");
        setBackground(new int[]{color, color2, color2, color2, typedArrayObtainStyledAttributes.getColor(i3, UiWidgetExtensionsKt.getColorFromAttribute(theme2, C4584R.attr.icon_new_badge_2))});
        typedArrayObtainStyledAttributes.recycle();
    }

    public /* synthetic */ YotiBadge(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GradientDrawable.Orientation getGradientOrientation() {
        return getLayoutDirection() != 0 ? GradientDrawable.Orientation.TR_BL : GradientDrawable.Orientation.TL_BR;
    }

    private final void setBackground(final int[] colors) {
        if (!ViewCompat.isLaidOut(this) || isLayoutRequested()) {
            addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yoti.mobile.android.common.ui.widgets.YotiBadge$setBackground$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    Intrinsics.checkParameterIsNotNull(view, "view");
                    view.removeOnLayoutChangeListener(this);
                    YotiBadge yotiBadge = this.f6014a;
                    GradientDrawable gradientDrawable = new GradientDrawable(this.f6014a.getGradientOrientation(), colors);
                    Context context = this.f6014a.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    gradientDrawable.setCornerRadius(context.getResources().getDimensionPixelSize(C4584R.dimen.yoti_badge_radius));
                    yotiBadge.setBackground(gradientDrawable);
                }
            });
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(getGradientOrientation(), colors);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        gradientDrawable.setCornerRadius(context.getResources().getDimensionPixelSize(C4584R.dimen.yoti_badge_radius));
        setBackground(gradientDrawable);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6013a;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f6013a == null) {
            this.f6013a = new HashMap();
        }
        View view = (View) this.f6013a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f6013a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }
}
