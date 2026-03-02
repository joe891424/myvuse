package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.react.uimanager.ViewProps;
import com.yoti.mobile.android.common.p049ui.widgets.utils.UiWidgetExtensionsKt;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u000b\u0010\u000fJ\u0017\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\f\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0006J\u0017\u0010\u0011\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0013\u0010\u0006J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0006J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0006J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0006J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\""}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiSubMenu;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "text", "", "setTitle", "(I)V", "", "(Ljava/lang/CharSequence;)V", "setDescription", "drawableRes", "setLeftIcon", "setStartIcon", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "setRightIcon", "setEndIcon", "visibility", "setRightIconVisibility", "setEndIconVisibility", "setLeftIconVisibility", "setStartIconVisibility", "", ViewProps.ENABLED, "setEnabled", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class YotiSubMenu extends ConstraintLayout {

    /* JADX INFO: renamed from: a */
    private HashMap f6270a;

    public YotiSubMenu(Context context) {
        this(context, null, 0, 6, null);
    }

    public YotiSubMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiSubMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout.inflate(context, C4584R.layout.yoti_view_sub_menu, this);
        int[] iArr = C4584R.styleable.YotiSubmenu;
        Intrinsics.checkNotNullExpressionValue(iArr, "R.styleable.YotiSubmenu");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        setTitle(typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiSubmenu_submenuTitleText));
        setDescription(typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiSubmenu_submenuDescriptionText));
        Integer styleableResIfPresent = UiWidgetExtensionsKt.getStyleableResIfPresent(typedArrayObtainStyledAttributes, C4584R.styleable.YotiSubmenu_submenuStartIcon, C4584R.styleable.YotiSubmenu_submenuLeftIcon);
        if (styleableResIfPresent != null) {
            int iIntValue = styleableResIfPresent.intValue();
            setStartIconVisibility(0);
            setStartIcon(typedArrayObtainStyledAttributes.getDrawable(iIntValue));
        } else {
            setStartIconVisibility(8);
        }
        Integer styleableResIfPresent2 = UiWidgetExtensionsKt.getStyleableResIfPresent(typedArrayObtainStyledAttributes, C4584R.styleable.YotiSubmenu_submenuEndIcon, C4584R.styleable.YotiSubmenu_submenuRightIcon);
        if (styleableResIfPresent2 != null) {
            int iIntValue2 = styleableResIfPresent2.intValue();
            setEndIconVisibility(0);
            setEndIcon(typedArrayObtainStyledAttributes.getDrawable(iIntValue2));
        } else {
            setEndIconVisibility(8);
        }
        Integer styleableResIfPresent3 = UiWidgetExtensionsKt.getStyleableResIfPresent(typedArrayObtainStyledAttributes, C4584R.styleable.YotiSubmenu_subMenuStartIconVisibility, C4584R.styleable.YotiSubmenu_subMenuLeftIconVisibility);
        if (styleableResIfPresent3 != null) {
            setEndIconVisibility(typedArrayObtainStyledAttributes.getInt(styleableResIfPresent3.intValue(), 8));
        }
        Integer styleableResIfPresent4 = UiWidgetExtensionsKt.getStyleableResIfPresent(typedArrayObtainStyledAttributes, C4584R.styleable.YotiSubmenu_subMenuEndIconVisibility, C4584R.styleable.YotiSubmenu_subMenuRightIconVisibility);
        if (styleableResIfPresent4 != null) {
            setEndIconVisibility(typedArrayObtainStyledAttributes.getInt(styleableResIfPresent4.intValue(), 8));
        }
        Float fValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(C4584R.styleable.YotiSubmenu_submenuExtraVerticalPadding, 0.0f));
        fValueOf = fValueOf.floatValue() <= 0.0f ? null : fValueOf;
        if (fValueOf != null) {
            float fFloatValue = fValueOf.floatValue();
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C4584R.id.root);
            ConstraintLayout root = (ConstraintLayout) _$_findCachedViewById(C4584R.id.root);
            Intrinsics.checkNotNullExpressionValue(root, "root");
            int paddingStart = root.getPaddingStart();
            ConstraintLayout root2 = (ConstraintLayout) _$_findCachedViewById(C4584R.id.root);
            Intrinsics.checkNotNullExpressionValue(root2, "root");
            int i2 = (int) fFloatValue;
            int paddingTop = root2.getPaddingTop() + i2;
            ConstraintLayout root3 = (ConstraintLayout) _$_findCachedViewById(C4584R.id.root);
            Intrinsics.checkNotNullExpressionValue(root3, "root");
            int paddingEnd = root3.getPaddingEnd();
            ConstraintLayout root4 = (ConstraintLayout) _$_findCachedViewById(C4584R.id.root);
            Intrinsics.checkNotNullExpressionValue(root4, "root");
            constraintLayout.setPaddingRelative(paddingStart, paddingTop, paddingEnd, root4.getPaddingBottom() + i2);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public /* synthetic */ YotiSubMenu(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6270a;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f6270a == null) {
            this.f6270a = new HashMap();
        }
        View view = (View) this.f6270a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f6270a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void setDescription(int text) {
        ((TextView) _$_findCachedViewById(C4584R.id.subTextView)).setText(text);
    }

    public final void setDescription(CharSequence text) {
        TextView subTextView = (TextView) _$_findCachedViewById(C4584R.id.subTextView);
        Intrinsics.checkNotNullExpressionValue(subTextView, "subTextView");
        subTextView.setText(text);
        TextView subTextView2 = (TextView) _$_findCachedViewById(C4584R.id.subTextView);
        Intrinsics.checkNotNullExpressionValue(subTextView2, "subTextView");
        subTextView2.setVisibility(text == null ? 8 : 0);
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        float f = enabled ? 1.0f : 0.5f;
        TextView mainTextView = (TextView) _$_findCachedViewById(C4584R.id.mainTextView);
        Intrinsics.checkNotNullExpressionValue(mainTextView, "mainTextView");
        mainTextView.setAlpha(f);
        TextView subTextView = (TextView) _$_findCachedViewById(C4584R.id.subTextView);
        Intrinsics.checkNotNullExpressionValue(subTextView, "subTextView");
        subTextView.setAlpha(f);
        ImageView startIcon = (ImageView) _$_findCachedViewById(C4584R.id.startIcon);
        Intrinsics.checkNotNullExpressionValue(startIcon, "startIcon");
        startIcon.setAlpha(f);
        ImageView endIcon = (ImageView) _$_findCachedViewById(C4584R.id.endIcon);
        Intrinsics.checkNotNullExpressionValue(endIcon, "endIcon");
        endIcon.setAlpha(f);
    }

    public final void setEndIcon(int drawableRes) {
        ((ImageView) _$_findCachedViewById(C4584R.id.endIcon)).setImageResource(drawableRes);
    }

    public final void setEndIcon(Drawable drawable) {
        ((ImageView) _$_findCachedViewById(C4584R.id.endIcon)).setImageDrawable(drawable);
    }

    public final void setEndIconVisibility(int visibility) {
        ImageView endIcon = (ImageView) _$_findCachedViewById(C4584R.id.endIcon);
        Intrinsics.checkNotNullExpressionValue(endIcon, "endIcon");
        endIcon.setVisibility(visibility);
    }

    @Deprecated(message = "Functionality moved to setStartIcon()", replaceWith = @ReplaceWith(expression = "YotiSubMenu.setStartIcon()", imports = {}))
    public final void setLeftIcon(int drawableRes) {
        setStartIcon(drawableRes);
    }

    @Deprecated(message = "Functionality moved to setStartIcon()", replaceWith = @ReplaceWith(expression = "YotiSubMenu.setStartIcon()", imports = {}))
    public final void setLeftIcon(Drawable drawable) {
        setStartIcon(drawable);
    }

    @Deprecated(message = "Functionality moved to setStartIconVisibility()", replaceWith = @ReplaceWith(expression = "YotiSubMenu.setStartIconVisibility()", imports = {}))
    public final void setLeftIconVisibility(int visibility) {
        setStartIconVisibility(visibility);
    }

    @Deprecated(message = "Functionality moved to setEndIcon()", replaceWith = @ReplaceWith(expression = "YotiSubMenu.setEndIcon()", imports = {}))
    public final void setRightIcon(int drawableRes) {
        setEndIcon(drawableRes);
    }

    @Deprecated(message = "Functionality moved to setEndIcon()", replaceWith = @ReplaceWith(expression = "YotiSubMenu.setEndIcon()", imports = {}))
    public final void setRightIcon(Drawable drawable) {
        setEndIcon(drawable);
    }

    @Deprecated(message = "Functionality moved to setEndIconVisibility()", replaceWith = @ReplaceWith(expression = "YotiSubMenu.setEndIconVisibility()", imports = {}))
    public final void setRightIconVisibility(int visibility) {
        setEndIconVisibility(visibility);
    }

    public final void setStartIcon(int drawableRes) {
        ((ImageView) _$_findCachedViewById(C4584R.id.startIcon)).setImageResource(drawableRes);
    }

    public final void setStartIcon(Drawable drawable) {
        ((ImageView) _$_findCachedViewById(C4584R.id.startIcon)).setImageDrawable(drawable);
    }

    public final void setStartIconVisibility(int visibility) {
        ImageView startIcon = (ImageView) _$_findCachedViewById(C4584R.id.startIcon);
        Intrinsics.checkNotNullExpressionValue(startIcon, "startIcon");
        startIcon.setVisibility(visibility);
    }

    public final void setTitle(int text) {
        ((TextView) _$_findCachedViewById(C4584R.id.mainTextView)).setText(text);
    }

    public final void setTitle(CharSequence text) {
        TextView mainTextView = (TextView) _$_findCachedViewById(C4584R.id.mainTextView);
        Intrinsics.checkNotNullExpressionValue(mainTextView, "mainTextView");
        mainTextView.setText(text);
        TextView mainTextView2 = (TextView) _$_findCachedViewById(C4584R.id.mainTextView);
        Intrinsics.checkNotNullExpressionValue(mainTextView2, "mainTextView");
        mainTextView2.setVisibility(text == null ? 8 : 0);
    }
}
