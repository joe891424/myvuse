package com.yoti.mobile.android.common.p049ui.widgets.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.TextViewCompat;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.color.MaterialColors;
import com.yoti.mobile.android.common.p049ui.widgets.YotiBadge;
import com.yoti.mobile.android.common.p049ui.widgets.utils.UiWidgetExtensionsKt;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001MB'\b\u0007\u0012\u0006\u0010G\u001a\u00020F\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u0012\b\b\u0002\u0010J\u001a\u00020\u0005¢\u0006\u0004\bK\u0010LJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0010J\u0019\u0010\u000f\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u000f\u0010\u0014J\u0017\u0010\u0011\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0011\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0016\u0010\u0010J\u0017\u0010\u0017\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0010J\u0019\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\"\u0010\u0004J\r\u0010#\u001a\u00020\u0002¢\u0006\u0004\b#\u0010\u0004J\u0019\u0010$\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u0007¢\u0006\u0004\b$\u0010\u0010J\u0017\u0010%\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b%\u0010\u0010J\u0019\u0010$\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b$\u0010\u0014J\u0017\u0010%\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b%\u0010\u0014J\u0019\u0010&\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u0005H\u0007¢\u0006\u0004\b&\u0010\u0010J\u0017\u0010'\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b'\u0010\u0010J\u000f\u0010(\u001a\u00020\u0002H\u0007¢\u0006\u0004\b(\u0010\u0004J\r\u0010)\u001a\u00020\u0002¢\u0006\u0004\b)\u0010\u0004J\u0017\u0010,\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-J\u0017\u0010,\u001a\u00020\u00022\b\b\u0001\u0010.\u001a\u00020\u0005¢\u0006\u0004\b,\u0010\u0010J\u0017\u00100\u001a\u00020\u00022\b\b\u0001\u0010/\u001a\u00020\u0005¢\u0006\u0004\b0\u0010\u0010J\u0017\u00101\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b1\u0010-J\u0017\u00101\u001a\u00020\u00022\b\b\u0001\u0010.\u001a\u00020\u0005¢\u0006\u0004\b1\u0010\u0010J\u0017\u00102\u001a\u00020\u00022\b\b\u0001\u0010/\u001a\u00020\u0005¢\u0006\u0004\b2\u0010\u0010J\u0017\u00104\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010*¢\u0006\u0004\b4\u0010-J\u0017\u00106\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0005H\u0007¢\u0006\u0004\b6\u0010\u0010J\u0015\u00107\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0005¢\u0006\u0004\b7\u0010\u0010J\u0017\u00108\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0005H\u0007¢\u0006\u0004\b8\u0010\u0010J\u0015\u00109\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0005¢\u0006\u0004\b9\u0010\u0010J\u0017\u0010<\u001a\u00020\u00022\u0006\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u00020\u0002¢\u0006\u0004\b>\u0010\u0004J\r\u0010?\u001a\u00020\u0002¢\u0006\u0004\b?\u0010\u0004R\u0018\u0010A\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010@R\u0016\u0010C\u001a\u00020\u00058\u0002@\u0003X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010D¨\u0006N"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/button/YotiOptionButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "d", "()V", "", "topPadding", "bottomPadding", "a", "(II)V", "b", "Lcom/yoti/mobile/android/common/ui/widgets/button/a;", "c", "()Lcom/yoti/mobile/android/common/ui/widgets/button/a;", "drawableRes", "setLeftIcon", "(I)V", "setStartIcon", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "color", "setLeftIconTint", "setStartIconTint", "", "widthPercent", "setLeftIconAsSquare", "(F)V", "setStartIconAsSquare", "Lcom/yoti/mobile/android/common/ui/widgets/button/YotiOptionButton$IconAlignment;", "alignment", "setLeftIconAlignment", "(Lcom/yoti/mobile/android/common/ui/widgets/button/YotiOptionButton$IconAlignment;)V", "setStartIconAlignment", "clearLeftIconTint", "clearStartIconTint", "setRightIcon", "setEndIcon", "setRightIconTint", "setEndIconTint", "clearRightIconTint", "clearEndIconTint", "", "text", "setTitle", "(Ljava/lang/String;)V", "stringResId", "textAppearance", "setTextAppearance", "setDescription", "setDescriptionTextAppearance", "badgeText", "setBadgeText", "visibility", "setLeftIconVisibility", "setStartIconVisibility", "setRightIconVisibility", "setEndIconVisibility", "", ViewProps.ENABLED, "setEnabled", "(Z)V", "showProgress", "hideProgress", "Ljava/lang/Integer;", "endIconTintColor", "I", "defaultIconTintColorRes", "Landroid/graphics/drawable/Drawable;", "originalDrawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "IconAlignment", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class YotiOptionButton extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private Integer endIconTintColor;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int defaultIconTintColorRes;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private Drawable originalDrawable;

    /* JADX INFO: renamed from: d */
    private HashMap f6311d;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/button/YotiOptionButton$IconAlignment;", "", "", "a", "I", "getAttrValue", "()I", "attrValue", "", "b", "F", "getVerticalBias", "()F", "verticalBias", "<init>", "(Ljava/lang/String;IIF)V", "Companion", "TOP", "MIDDLE", "BOTTOM", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public enum IconAlignment {
        TOP(0, 0.0f),
        MIDDLE(1, 0.5f),
        BOTTOM(2, 1.0f);


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int attrValue;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final float verticalBias;

        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/button/YotiOptionButton$IconAlignment$Companion;", "", "", "attrValue", "Lcom/yoti/mobile/android/common/ui/widgets/button/YotiOptionButton$IconAlignment;", "fromAttributeValue", "(I)Lcom/yoti/mobile/android/common/ui/widgets/button/YotiOptionButton$IconAlignment;", "<init>", "()V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final IconAlignment fromAttributeValue(int attrValue) {
                IconAlignment iconAlignment;
                IconAlignment[] iconAlignmentArrValues = IconAlignment.values();
                int length = iconAlignmentArrValues.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        iconAlignment = null;
                        break;
                    }
                    iconAlignment = iconAlignmentArrValues[i];
                    if (iconAlignment.getAttrValue() == attrValue) {
                        break;
                    }
                    i++;
                }
                return iconAlignment != null ? iconAlignment : IconAlignment.MIDDLE;
            }
        }

        IconAlignment(int i, float f) {
            this.attrValue = i;
            this.verticalBias = f;
        }

        public final int getAttrValue() {
            return this.attrValue;
        }

        public final float getVerticalBias() {
            return this.verticalBias;
        }
    }

    public YotiOptionButton(Context context) {
        this(context, null, 0, 6, null);
    }

    public YotiOptionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiOptionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        int i2 = C4584R.attr.icon_neutral_contrast;
        this.defaultIconTintColorRes = i2;
        ConstraintLayout.inflate(context, C4584R.layout.view_yoti_option_button, this);
        setBackgroundResource(C4584R.drawable.feedback_button_top_bg);
        Resources.Theme theme = context.getTheme();
        Intrinsics.checkNotNullExpressionValue(theme, "context.theme");
        UiWidgetExtensionsKt.getColorFromAttribute(theme, i2);
        Resources.Theme theme2 = context.getTheme();
        Intrinsics.checkNotNullExpressionValue(theme2, "context.theme");
        this.endIconTintColor = Integer.valueOf(UiWidgetExtensionsKt.getColorFromAttribute(theme2, i2));
        int[] iArr = C4584R.styleable.YotiOptionButton;
        Intrinsics.checkNotNullExpressionValue(iArr, "R.styleable.YotiOptionButton");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        setTitle(typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiOptionButton_optionTitleText));
        if (typedArrayObtainStyledAttributes.hasValue(C4584R.styleable.YotiOptionButton_optionTitleTextAppearance)) {
            TextViewCompat.setTextAppearance((TextView) _$_findCachedViewById(C4584R.id.titleTextView), typedArrayObtainStyledAttributes.getResourceId(C4584R.styleable.YotiOptionButton_optionTitleTextAppearance, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4584R.styleable.YotiOptionButton_optionDescriptionTextAppearance)) {
            TextViewCompat.setTextAppearance((TextView) _$_findCachedViewById(C4584R.id.descriptionTextView), typedArrayObtainStyledAttributes.getResourceId(C4584R.styleable.YotiOptionButton_optionDescriptionTextAppearance, -1));
        }
        ImageView startIconImageView = (ImageView) _$_findCachedViewById(C4584R.id.startIconImageView);
        Intrinsics.checkNotNullExpressionValue(startIconImageView, "startIconImageView");
        startIconImageView.setImageTintMode(PorterDuff.Mode.SRC_IN);
        Integer styleableResIfPresent = UiWidgetExtensionsKt.getStyleableResIfPresent(typedArrayObtainStyledAttributes, C4584R.styleable.YotiOptionButton_optionStartIconTint, C4584R.styleable.YotiOptionButton_optionLeftIconTint);
        if (styleableResIfPresent != null) {
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(styleableResIfPresent.intValue());
            ImageView startIconImageView2 = (ImageView) _$_findCachedViewById(C4584R.id.startIconImageView);
            Intrinsics.checkNotNullExpressionValue(startIconImageView2, "startIconImageView");
            startIconImageView2.setImageTintList(colorStateList);
        }
        Integer styleableResIfPresent2 = UiWidgetExtensionsKt.getStyleableResIfPresent(typedArrayObtainStyledAttributes, C4584R.styleable.YotiOptionButton_optionStartIconSquare, C4584R.styleable.YotiOptionButton_optionLeftIconSquare);
        if (styleableResIfPresent2 != null && typedArrayObtainStyledAttributes.getBoolean(styleableResIfPresent2.intValue(), false)) {
            setStartIconAsSquare$default(this, 0.0f, 1, null);
        }
        Integer styleableResIfPresent3 = UiWidgetExtensionsKt.getStyleableResIfPresent(typedArrayObtainStyledAttributes, C4584R.styleable.YotiOptionButton_optionStartIconAlignment, C4584R.styleable.YotiOptionButton_optionLeftIconAlignment);
        setStartIconAlignment(IconAlignment.INSTANCE.fromAttributeValue(styleableResIfPresent3 != null ? typedArrayObtainStyledAttributes.getInt(styleableResIfPresent3.intValue(), IconAlignment.TOP.getAttrValue()) : IconAlignment.TOP.getAttrValue()));
        ImageView endIconImageView = (ImageView) _$_findCachedViewById(C4584R.id.endIconImageView);
        Intrinsics.checkNotNullExpressionValue(endIconImageView, "endIconImageView");
        endIconImageView.setImageTintMode(PorterDuff.Mode.SRC_IN);
        Integer styleableResIfPresent4 = UiWidgetExtensionsKt.getStyleableResIfPresent(typedArrayObtainStyledAttributes, C4584R.styleable.YotiOptionButton_optionEndIconTint, C4584R.styleable.YotiOptionButton_optionRightIconTint);
        if (styleableResIfPresent4 != null) {
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(styleableResIfPresent4.intValue());
            ImageView endIconImageView2 = (ImageView) _$_findCachedViewById(C4584R.id.endIconImageView);
            Intrinsics.checkNotNullExpressionValue(endIconImageView2, "endIconImageView");
            endIconImageView2.setImageTintList(colorStateList2);
        }
        Integer styleableResIfPresent5 = UiWidgetExtensionsKt.getStyleableResIfPresent(typedArrayObtainStyledAttributes, C4584R.styleable.YotiOptionButton_optionStartIcon, C4584R.styleable.YotiOptionButton_optionLeftIcon);
        if (styleableResIfPresent5 != null) {
            setStartIcon(typedArrayObtainStyledAttributes.getDrawable(styleableResIfPresent5.intValue()));
        }
        Integer styleableResIfPresent6 = UiWidgetExtensionsKt.getStyleableResIfPresent(typedArrayObtainStyledAttributes, C4584R.styleable.YotiOptionButton_optionEndIcon, C4584R.styleable.YotiOptionButton_optionRightIcon);
        if (styleableResIfPresent6 != null) {
            setEndIcon(typedArrayObtainStyledAttributes.getDrawable(styleableResIfPresent6.intValue()));
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4584R.styleable.YotiOptionButton_optionBadgeText)) {
            setBadgeText(typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiOptionButton_optionBadgeText));
        }
        setDescription(typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiOptionButton_optionDescriptionText));
        Integer styleableResIfPresent7 = UiWidgetExtensionsKt.getStyleableResIfPresent(typedArrayObtainStyledAttributes, C4584R.styleable.YotiOptionButton_optionStartIconVisibility, C4584R.styleable.YotiOptionButton_optionLeftIconVisibility);
        setStartIconVisibility(styleableResIfPresent7 != null ? typedArrayObtainStyledAttributes.getInt(styleableResIfPresent7.intValue(), 0) : 0);
        Integer styleableResIfPresent8 = UiWidgetExtensionsKt.getStyleableResIfPresent(typedArrayObtainStyledAttributes, C4584R.styleable.YotiOptionButton_optionEndIconVisibility, C4584R.styleable.YotiOptionButton_optionRightIconVisibility);
        setEndIconVisibility(styleableResIfPresent8 != null ? typedArrayObtainStyledAttributes.getInt(styleableResIfPresent8.intValue(), 0) : 0);
        typedArrayObtainStyledAttributes.recycle();
        ImageView endIconImageView3 = (ImageView) _$_findCachedViewById(C4584R.id.endIconImageView);
        Intrinsics.checkNotNullExpressionValue(endIconImageView3, "endIconImageView");
        this.originalDrawable = endIconImageView3.getDrawable();
    }

    public /* synthetic */ YotiOptionButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: renamed from: a */
    private final void m4600a() {
        TextView descriptionTextView = (TextView) _$_findCachedViewById(C4584R.id.descriptionTextView);
        Intrinsics.checkNotNullExpressionValue(descriptionTextView, "descriptionTextView");
        CharSequence text = descriptionTextView.getText();
        int i = (text == null || text.length() == 0) ? C4584R.dimen.yoti_theme_option_button_smaller_margin : C4584R.dimen.yoti_theme_option_button_default_margin;
        View extraBottomSpace = _$_findCachedViewById(C4584R.id.extraBottomSpace);
        Intrinsics.checkNotNullExpressionValue(extraBottomSpace, "extraBottomSpace");
        View extraBottomSpace2 = _$_findCachedViewById(C4584R.id.extraBottomSpace);
        Intrinsics.checkNotNullExpressionValue(extraBottomSpace2, "extraBottomSpace");
        ViewGroup.LayoutParams layoutParams = extraBottomSpace2.getLayoutParams();
        layoutParams.height = getResources().getDimensionPixelSize(i);
        extraBottomSpace.setLayoutParams(layoutParams);
    }

    /* JADX INFO: renamed from: a */
    private final void m4601a(int topPadding, int bottomPadding) {
        TextView titleTextView = (TextView) _$_findCachedViewById(C4584R.id.titleTextView);
        Intrinsics.checkNotNullExpressionValue(titleTextView, "titleTextView");
        ViewGroup.LayoutParams layoutParams = titleTextView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = bottomPadding;
        TextView titleTextView2 = (TextView) _$_findCachedViewById(C4584R.id.titleTextView);
        Intrinsics.checkNotNullExpressionValue(titleTextView2, "titleTextView");
        titleTextView2.setLayoutParams(marginLayoutParams);
        FlexboxLayout flexBoxLayout = (FlexboxLayout) _$_findCachedViewById(C4584R.id.flexBoxLayout);
        Intrinsics.checkNotNullExpressionValue(flexBoxLayout, "flexBoxLayout");
        flexBoxLayout.setPadding(flexBoxLayout.getPaddingLeft(), flexBoxLayout.getPaddingTop(), flexBoxLayout.getPaddingRight(), topPadding);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m4602a(YotiOptionButton yotiOptionButton, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        yotiOptionButton.m4601a(i, i2);
    }

    /* JADX INFO: renamed from: b */
    private final void m4603b() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        FlexboxLayout flexBoxLayout = (FlexboxLayout) _$_findCachedViewById(C4584R.id.flexBoxLayout);
        Intrinsics.checkNotNullExpressionValue(flexBoxLayout, "flexBoxLayout");
        constraintSet.clear(flexBoxLayout.getId(), 4);
        constraintSet.applyTo(this);
        FlexboxLayout flexBoxLayout2 = (FlexboxLayout) _$_findCachedViewById(C4584R.id.flexBoxLayout);
        Intrinsics.checkNotNullExpressionValue(flexBoxLayout2, "flexBoxLayout");
        flexBoxLayout2.setAlignContent(5);
        FlexboxLayout flexBoxLayout3 = (FlexboxLayout) _$_findCachedViewById(C4584R.id.flexBoxLayout);
        Intrinsics.checkNotNullExpressionValue(flexBoxLayout3, "flexBoxLayout");
        flexBoxLayout3.setAlignItems(4);
        m4602a(this, 0, 0, 3, null);
        m4600a();
    }

    /* JADX INFO: renamed from: c */
    private final C4539a m4604c() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        C4539a c4539a = new C4539a(context);
        c4539a.setColorSchemeColors(MaterialColors.getColor(this, C4584R.attr.icon_neutral_mid));
        return c4539a;
    }

    /* JADX INFO: renamed from: d */
    private final void m4605d() {
        TextView descriptionTextView = (TextView) _$_findCachedViewById(C4584R.id.descriptionTextView);
        Intrinsics.checkNotNullExpressionValue(descriptionTextView, "descriptionTextView");
        CharSequence text = descriptionTextView.getText();
        if (text == null || text.length() == 0) {
            YotiBadge badge = (YotiBadge) _$_findCachedViewById(C4584R.id.badge);
            Intrinsics.checkNotNullExpressionValue(badge, "badge");
            CharSequence text2 = badge.getText();
            if (text2 == null || text2.length() == 0) {
                int id = getId();
                int dimensionPixelSize = getResources().getDimensionPixelSize(C4584R.dimen.education_card_title_bottom_margin_medium);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(C4584R.dimen.radiobutton_additional_text_padding);
                FlexboxLayout flexBoxLayout = (FlexboxLayout) _$_findCachedViewById(C4584R.id.flexBoxLayout);
                Intrinsics.checkNotNullExpressionValue(flexBoxLayout, "flexBoxLayout");
                ViewGroup.LayoutParams layoutParams = flexBoxLayout.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.bottomToBottom = id;
                flexBoxLayout.setLayoutParams(layoutParams2);
                FlexboxLayout flexBoxLayout2 = (FlexboxLayout) _$_findCachedViewById(C4584R.id.flexBoxLayout);
                Intrinsics.checkNotNullExpressionValue(flexBoxLayout2, "flexBoxLayout");
                flexBoxLayout2.setAlignContent(2);
                FlexboxLayout flexBoxLayout3 = (FlexboxLayout) _$_findCachedViewById(C4584R.id.flexBoxLayout);
                Intrinsics.checkNotNullExpressionValue(flexBoxLayout3, "flexBoxLayout");
                flexBoxLayout3.setAlignItems(2);
                View extraBottomSpace = _$_findCachedViewById(C4584R.id.extraBottomSpace);
                Intrinsics.checkNotNullExpressionValue(extraBottomSpace, "extraBottomSpace");
                View extraBottomSpace2 = _$_findCachedViewById(C4584R.id.extraBottomSpace);
                Intrinsics.checkNotNullExpressionValue(extraBottomSpace2, "extraBottomSpace");
                ViewGroup.LayoutParams layoutParams3 = extraBottomSpace2.getLayoutParams();
                layoutParams3.height = 0;
                extraBottomSpace.setLayoutParams(layoutParams3);
                m4601a(dimensionPixelSize, dimensionPixelSize2);
                return;
            }
        }
        m4603b();
    }

    public static /* synthetic */ void setLeftIconAsSquare$default(YotiOptionButton yotiOptionButton, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.33f;
        }
        yotiOptionButton.setLeftIconAsSquare(f);
    }

    public static /* synthetic */ void setStartIconAsSquare$default(YotiOptionButton yotiOptionButton, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.33f;
        }
        yotiOptionButton.setStartIconAsSquare(f);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6311d;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f6311d == null) {
            this.f6311d = new HashMap();
        }
        View view = (View) this.f6311d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f6311d.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void clearEndIconTint() {
        this.endIconTintColor = null;
        ((ImageView) _$_findCachedViewById(C4584R.id.endIconImageView)).clearColorFilter();
    }

    @Deprecated(message = "Logic moved to clearStartIconTint()", replaceWith = @ReplaceWith(expression = "YotiOptionButton.clearStartIconTint()", imports = {}))
    public final void clearLeftIconTint() {
        clearStartIconTint();
    }

    @Deprecated(message = "Logic moved to clearEndIconTint()", replaceWith = @ReplaceWith(expression = "YotiOptionButton.clearEndIconTint()", imports = {}))
    public final void clearRightIconTint() {
        clearEndIconTint();
    }

    public final void clearStartIconTint() {
        ((ImageView) _$_findCachedViewById(C4584R.id.startIconImageView)).clearColorFilter();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void hideProgress() {
        ImageView endIconImageView = (ImageView) _$_findCachedViewById(C4584R.id.endIconImageView);
        Intrinsics.checkNotNullExpressionValue(endIconImageView, "endIconImageView");
        Drawable drawable = endIconImageView.getDrawable();
        if (drawable != 0) {
            drawable.setCallback(null);
        }
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        Integer num = this.endIconTintColor;
        if (num != null) {
            setEndIconTint(num.intValue());
        } else {
            clearEndIconTint();
        }
        ((ImageView) _$_findCachedViewById(C4584R.id.endIconImageView)).setImageDrawable(this.originalDrawable);
    }

    public final void setBadgeText(String badgeText) {
        if (badgeText == null) {
            YotiBadge badge = (YotiBadge) _$_findCachedViewById(C4584R.id.badge);
            Intrinsics.checkNotNullExpressionValue(badge, "badge");
            badge.setVisibility(8);
        } else {
            YotiBadge badge2 = (YotiBadge) _$_findCachedViewById(C4584R.id.badge);
            Intrinsics.checkNotNullExpressionValue(badge2, "badge");
            badge2.setVisibility(0);
            YotiBadge badge3 = (YotiBadge) _$_findCachedViewById(C4584R.id.badge);
            Intrinsics.checkNotNullExpressionValue(badge3, "badge");
            badge3.setText(badgeText);
            m4600a();
        }
        m4605d();
    }

    public final void setDescription(int stringResId) {
        setDescription(getResources().getString(stringResId));
    }

    public final void setDescription(String text) {
        TextView descriptionTextView = (TextView) _$_findCachedViewById(C4584R.id.descriptionTextView);
        Intrinsics.checkNotNullExpressionValue(descriptionTextView, "descriptionTextView");
        descriptionTextView.setText(text);
        TextView descriptionTextView2 = (TextView) _$_findCachedViewById(C4584R.id.descriptionTextView);
        Intrinsics.checkNotNullExpressionValue(descriptionTextView2, "descriptionTextView");
        descriptionTextView2.setVisibility(text != null ? 0 : 8);
        m4605d();
    }

    public final void setDescriptionTextAppearance(int textAppearance) {
        TextViewCompat.setTextAppearance((TextView) _$_findCachedViewById(C4584R.id.descriptionTextView), textAppearance);
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        TextView titleTextView = (TextView) _$_findCachedViewById(C4584R.id.titleTextView);
        Intrinsics.checkNotNullExpressionValue(titleTextView, "titleTextView");
        titleTextView.setEnabled(enabled);
        TextView descriptionTextView = (TextView) _$_findCachedViewById(C4584R.id.descriptionTextView);
        Intrinsics.checkNotNullExpressionValue(descriptionTextView, "descriptionTextView");
        descriptionTextView.setEnabled(enabled);
        ImageView startIconImageView = (ImageView) _$_findCachedViewById(C4584R.id.startIconImageView);
        Intrinsics.checkNotNullExpressionValue(startIconImageView, "startIconImageView");
        startIconImageView.setEnabled(enabled);
        ImageView endIconImageView = (ImageView) _$_findCachedViewById(C4584R.id.endIconImageView);
        Intrinsics.checkNotNullExpressionValue(endIconImageView, "endIconImageView");
        endIconImageView.setEnabled(enabled);
    }

    public final void setEndIcon(int drawableRes) {
        setEndIcon(ResourcesCompat.getDrawable(getResources(), drawableRes, null));
    }

    public final void setEndIcon(Drawable drawable) {
        this.originalDrawable = drawable;
        ((ImageView) _$_findCachedViewById(C4584R.id.endIconImageView)).setImageDrawable(drawable);
    }

    public final void setEndIconTint(int color) {
        this.endIconTintColor = Integer.valueOf(color);
        ((ImageView) _$_findCachedViewById(C4584R.id.endIconImageView)).setColorFilter(color);
    }

    public final void setEndIconVisibility(int visibility) {
        ImageView endIconImageView = (ImageView) _$_findCachedViewById(C4584R.id.endIconImageView);
        Intrinsics.checkNotNullExpressionValue(endIconImageView, "endIconImageView");
        endIconImageView.setVisibility(visibility);
    }

    @Deprecated(message = "Logic moved to setStartIcon()", replaceWith = @ReplaceWith(expression = "YotiOptionButton.setStartIcon()", imports = {}))
    public final void setLeftIcon(int drawableRes) {
        setStartIcon(drawableRes);
    }

    @Deprecated(message = "Logic moved to setStartIcon()", replaceWith = @ReplaceWith(expression = "YotiOptionButton.setStartIcon()", imports = {}))
    public final void setLeftIcon(Drawable drawable) {
        setStartIcon(drawable);
    }

    @Deprecated(message = "Logic moved to setStartIconAlignment()", replaceWith = @ReplaceWith(expression = "YotiOptionButton.setStartIconAlignment()", imports = {}))
    public final void setLeftIconAlignment(IconAlignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        setStartIconAlignment(alignment);
    }

    @Deprecated(message = "Logic moved to setStartIconAsSquare()", replaceWith = @ReplaceWith(expression = "YotiOptionButton.setStartIconAsSquare()", imports = {}))
    public final void setLeftIconAsSquare(float widthPercent) {
        setStartIconAsSquare(widthPercent);
    }

    @Deprecated(message = "Logic moved to setStartIconTint()", replaceWith = @ReplaceWith(expression = "YotiOptionButton.setStartIconTint()", imports = {}))
    public final void setLeftIconTint(int color) {
        setStartIconTint(color);
    }

    @Deprecated(message = "Logic moved to setStartIconVisibility()", replaceWith = @ReplaceWith(expression = "YotiOptionButton.setStartIconVisibility()", imports = {}))
    public final void setLeftIconVisibility(int visibility) {
        setStartIconVisibility(visibility);
    }

    @Deprecated(message = "Logic moved to setEndIcon()", replaceWith = @ReplaceWith(expression = "YotiOptionButton.setEndIcon()", imports = {}))
    public final void setRightIcon(int drawableRes) {
        setEndIcon(drawableRes);
    }

    @Deprecated(message = "Logic moved to setEndIcon()", replaceWith = @ReplaceWith(expression = "YotiOptionButton.setEndIcon()", imports = {}))
    public final void setRightIcon(Drawable drawable) {
        setEndIcon(drawable);
    }

    @Deprecated(message = "Logic moved to setEndIconTint()", replaceWith = @ReplaceWith(expression = "YotiOptionButton.setEndIconTint()", imports = {}))
    public final void setRightIconTint(int color) {
        setEndIconTint(color);
    }

    @Deprecated(message = "Logic moved to setEndIconVisibility()", replaceWith = @ReplaceWith(expression = "YotiOptionButton.setEndIconVisibility()", imports = {}))
    public final void setRightIconVisibility(int visibility) {
        setEndIconVisibility(visibility);
    }

    public final void setStartIcon(int drawableRes) {
        ((ImageView) _$_findCachedViewById(C4584R.id.startIconImageView)).setImageResource(drawableRes);
    }

    public final void setStartIcon(Drawable drawable) {
        ((ImageView) _$_findCachedViewById(C4584R.id.startIconImageView)).setImageDrawable(drawable);
    }

    public final void setStartIconAlignment(IconAlignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        ImageView iconImageView = (ImageView) findViewById(C4584R.id.startIconImageView);
        Intrinsics.checkNotNullExpressionValue(iconImageView, "iconImageView");
        ViewGroup.LayoutParams layoutParams = iconImageView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.verticalBias = alignment.getVerticalBias();
        iconImageView.setLayoutParams(layoutParams2);
    }

    public final void setStartIconAsSquare(float widthPercent) {
        ImageView startIconImageView = (ImageView) _$_findCachedViewById(C4584R.id.startIconImageView);
        Intrinsics.checkNotNullExpressionValue(startIconImageView, "startIconImageView");
        ImageView startIconImageView2 = (ImageView) _$_findCachedViewById(C4584R.id.startIconImageView);
        Intrinsics.checkNotNullExpressionValue(startIconImageView2, "startIconImageView");
        ViewGroup.LayoutParams layoutParams = startIconImageView2.getLayoutParams();
        layoutParams.height = 0;
        startIconImageView.setLayoutParams(layoutParams);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        ImageView startIconImageView3 = (ImageView) _$_findCachedViewById(C4584R.id.startIconImageView);
        Intrinsics.checkNotNullExpressionValue(startIconImageView3, "startIconImageView");
        constraintSet.setDimensionRatio(startIconImageView3.getId(), "1:1");
        ImageView startIconImageView4 = (ImageView) _$_findCachedViewById(C4584R.id.startIconImageView);
        Intrinsics.checkNotNullExpressionValue(startIconImageView4, "startIconImageView");
        constraintSet.constrainDefaultWidth(startIconImageView4.getId(), 2);
        ImageView startIconImageView5 = (ImageView) _$_findCachedViewById(C4584R.id.startIconImageView);
        Intrinsics.checkNotNullExpressionValue(startIconImageView5, "startIconImageView");
        constraintSet.constrainPercentWidth(startIconImageView5.getId(), widthPercent);
        constraintSet.applyTo(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C4584R.dimen.yoti_option_button_padding_horizontal);
        ((ImageView) _$_findCachedViewById(C4584R.id.startIconImageView)).setPaddingRelative(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    public final void setStartIconTint(int color) {
        ((ImageView) _$_findCachedViewById(C4584R.id.startIconImageView)).setColorFilter(color);
    }

    public final void setStartIconVisibility(int visibility) {
        ImageView startIconImageView = (ImageView) _$_findCachedViewById(C4584R.id.startIconImageView);
        Intrinsics.checkNotNullExpressionValue(startIconImageView, "startIconImageView");
        startIconImageView.setVisibility(visibility);
    }

    public final void setTextAppearance(int textAppearance) {
        TextViewCompat.setTextAppearance((TextView) _$_findCachedViewById(C4584R.id.titleTextView), textAppearance);
    }

    public final void setTitle(int stringResId) {
        ((TextView) _$_findCachedViewById(C4584R.id.titleTextView)).setText(stringResId);
        TextView titleTextView = (TextView) _$_findCachedViewById(C4584R.id.titleTextView);
        Intrinsics.checkNotNullExpressionValue(titleTextView, "titleTextView");
        titleTextView.setVisibility(0);
    }

    public final void setTitle(String text) {
        TextView titleTextView = (TextView) _$_findCachedViewById(C4584R.id.titleTextView);
        Intrinsics.checkNotNullExpressionValue(titleTextView, "titleTextView");
        titleTextView.setText(text);
        TextView titleTextView2 = (TextView) _$_findCachedViewById(C4584R.id.titleTextView);
        Intrinsics.checkNotNullExpressionValue(titleTextView2, "titleTextView");
        titleTextView2.setVisibility(text != null ? 0 : 4);
    }

    public final void showProgress() {
        C4539a c4539aM4604c = m4604c();
        c4539aM4604c.setCallback(new Drawable.Callback() { // from class: com.yoti.mobile.android.common.ui.widgets.button.YotiOptionButton.showProgress.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable who) {
                Intrinsics.checkNotNullParameter(who, "who");
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable who, Runnable what, long when) {
                Intrinsics.checkNotNullParameter(who, "who");
                Intrinsics.checkNotNullParameter(what, "what");
                YotiOptionButton.this.invalidate();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable who, Runnable what) {
                Intrinsics.checkNotNullParameter(who, "who");
                Intrinsics.checkNotNullParameter(what, "what");
            }
        });
        c4539aM4604c.start();
        ((ImageView) _$_findCachedViewById(C4584R.id.endIconImageView)).clearColorFilter();
        ((ImageView) _$_findCachedViewById(C4584R.id.endIconImageView)).setImageDrawable(c4539aM4604c);
    }
}
