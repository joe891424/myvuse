package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.card.MaterialCardView;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.yoti.mobile.android.common.p049ui.widgets.utils.UiWidgetExtensionsKt;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001%B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\t2\b\b\u0001\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u000bJ\u0015\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\t2\b\b\u0001\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u000bJ\u0015\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006&"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiSecurityCard;", "Lcom/google/android/material/card/MaterialCardView;", "", "sizePx", "", "a", "(F)Z", "", "color", "", "setBackground", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "tintColor", "setIconTint", "Lcom/yoti/mobile/android/common/ui/widgets/YotiSecurityCard$IconAlignment;", "alignment", "setIconAlignment", "(Lcom/yoti/mobile/android/common/ui/widgets/YotiSecurityCard$IconAlignment;)V", "", "text", "setText", "(Ljava/lang/String;)V", OTUXParamsKeys.OT_UX_TEXT_COLOR, "setTextColor", "setTextSize", "(F)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "IconAlignment", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class YotiSecurityCard extends MaterialCardView {

    /* JADX INFO: renamed from: a */
    private HashMap f6259a;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiSecurityCard$IconAlignment;", "", "", "a", "I", "getAttrValue", "()I", "attrValue", "<init>", "(Ljava/lang/String;II)V", "Companion", "TOP", "MIDDLE", "BOTTOM", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public enum IconAlignment {
        TOP(0),
        MIDDLE(1),
        BOTTOM(2);


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int attrValue;

        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiSecurityCard$IconAlignment$Companion;", "", "", "attrValue", "Lcom/yoti/mobile/android/common/ui/widgets/YotiSecurityCard$IconAlignment;", "fromAttributeValue", "(I)Lcom/yoti/mobile/android/common/ui/widgets/YotiSecurityCard$IconAlignment;", "<init>", "()V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
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

        IconAlignment(int i) {
            this.attrValue = i;
        }

        public final int getAttrValue() {
            return this.attrValue;
        }
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IconAlignment.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[IconAlignment.TOP.ordinal()] = 1;
            iArr[IconAlignment.MIDDLE.ordinal()] = 2;
            iArr[IconAlignment.BOTTOM.ordinal()] = 3;
        }
    }

    public YotiSecurityCard(Context context) {
        this(context, null, 0, 6, null);
    }

    public YotiSecurityCard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiSecurityCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        MaterialCardView.inflate(context, C4584R.layout.view_yoti_security_card, this);
        setCardElevation(0.0f);
        int[] iArr = C4584R.styleable.YotiSecurityCardView;
        Intrinsics.checkNotNullExpressionValue(iArr, "R.styleable.YotiSecurityCardView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        setRadius(typedArrayObtainStyledAttributes.getDimension(C4584R.styleable.YotiSecurityCardView_yotiSecurityCardRadius, typedArrayObtainStyledAttributes.getResources().getDimension(YotiSecurityCardKt.f6262a)));
        if (typedArrayObtainStyledAttributes.hasValue(C4584R.styleable.YotiSecurityCardView_yotiSecurityCardStrokeWidth)) {
            setStrokeWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(C4584R.styleable.YotiSecurityCardView_yotiSecurityCardStrokeWidth, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4584R.styleable.YotiSecurityCardView_yotiSecurityCardStrokeColor)) {
            setStrokeColor(typedArrayObtainStyledAttributes.getColor(C4584R.styleable.YotiSecurityCardView_yotiSecurityCardStrokeColor, 0));
        }
        int i2 = C4584R.styleable.YotiSecurityCardView_yotiSecurityCardBackgroundColor;
        Resources.Theme theme = context.getTheme();
        Intrinsics.checkNotNullExpressionValue(theme, "context.theme");
        setBackground(typedArrayObtainStyledAttributes.getColor(i2, UiWidgetExtensionsKt.getColorFromAttribute(theme, YotiSecurityCardKt.f6263b)));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C4584R.styleable.YotiSecurityCardView_yotiSecurityCardIcon);
        if (drawable != null) {
            setIcon(drawable);
        }
        setIconAlignment(IconAlignment.INSTANCE.fromAttributeValue(typedArrayObtainStyledAttributes.getInt(C4584R.styleable.YotiSecurityCardView_yotiSecurityCardIconAlignment, IconAlignment.MIDDLE.getAttrValue())));
        int i3 = C4584R.styleable.YotiSecurityCardView_yotiSecurityCardIconTint;
        Resources.Theme theme2 = context.getTheme();
        Intrinsics.checkNotNullExpressionValue(theme2, "context.theme");
        setIconTint(typedArrayObtainStyledAttributes.getColor(i3, UiWidgetExtensionsKt.getColorFromAttribute(theme2, YotiSecurityCardKt.f6265d)));
        String string = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiSecurityCardView_yotiSecurityCardText);
        if (string != null) {
            setText(string);
        }
        int i4 = C4584R.styleable.YotiSecurityCardView_yotiSecurityCardTextColor;
        Resources.Theme theme3 = context.getTheme();
        Intrinsics.checkNotNullExpressionValue(theme3, "context.theme");
        setTextColor(typedArrayObtainStyledAttributes.getColor(i4, UiWidgetExtensionsKt.getColorFromAttribute(theme3, YotiSecurityCardKt.f6264c)));
        Float fValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(C4584R.styleable.YotiSecurityCardView_yotiSecurityCardTextSize, -1.0f));
        fValueOf = m4583a(fValueOf.floatValue()) ? fValueOf : null;
        if (fValueOf != null) {
            setTextSize(fValueOf.floatValue());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public /* synthetic */ YotiSecurityCard(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: renamed from: a */
    private final boolean m4583a(float sizePx) {
        return sizePx != -1.0f;
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6259a;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f6259a == null) {
            this.f6259a = new HashMap();
        }
        View view = (View) this.f6259a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f6259a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void setBackground(int color) {
        setCardBackgroundColor(color);
    }

    public final void setIcon(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        ((ImageView) _$_findCachedViewById(C4584R.id.iconImageView)).setImageDrawable(drawable);
    }

    public final void setIconAlignment(IconAlignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        ImageView iconImageView = (ImageView) findViewById(C4584R.id.iconImageView);
        Intrinsics.checkNotNullExpressionValue(iconImageView, "iconImageView");
        ViewGroup.LayoutParams layoutParams = iconImageView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        int i = WhenMappings.$EnumSwitchMapping$0[alignment.ordinal()];
        if (i != 1) {
            if (i == 2) {
                layoutParams2.topToTop = 0;
            } else if (i == 3) {
                layoutParams2.topToTop = -1;
            }
            layoutParams2.bottomToBottom = 0;
        } else {
            layoutParams2.topToTop = 0;
            layoutParams2.bottomToBottom = -1;
        }
        iconImageView.setLayoutParams(layoutParams2);
    }

    public final void setIconTint(int tintColor) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(tintColor);
        ImageView iconImageView = (ImageView) _$_findCachedViewById(C4584R.id.iconImageView);
        Intrinsics.checkNotNullExpressionValue(iconImageView, "iconImageView");
        iconImageView.setImageTintList(colorStateListValueOf);
    }

    public final void setText(String text) {
        TextView contentTextView = (TextView) _$_findCachedViewById(C4584R.id.contentTextView);
        Intrinsics.checkNotNullExpressionValue(contentTextView, "contentTextView");
        contentTextView.setText(text);
    }

    public final void setTextColor(int textColor) {
        ((TextView) _$_findCachedViewById(C4584R.id.contentTextView)).setTextColor(textColor);
    }

    public final void setTextSize(float sizePx) {
        ((TextView) _$_findCachedViewById(C4584R.id.contentTextView)).setTextSize(0, sizePx);
    }
}
