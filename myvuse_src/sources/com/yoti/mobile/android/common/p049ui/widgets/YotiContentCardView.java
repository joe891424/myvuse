package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.google.android.material.card.MaterialCardView;
import com.yoti.mobile.android.common.p049ui.widgets.utils.UiWidgetExtensionsKt;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001+B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\u0005¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0003\u0010\fJ\u001d\u0010\u0003\u001a\u00020\u0002*\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0003\u0010\u0010J\u001d\u0010\u0003\u001a\u00020\u0002*\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0003\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u001c\u0010\u0019J\u0015\u0010\u001d\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u001e\u0010\u0019J\u0015\u0010\u001f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010\u001bJ\u0017\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#¨\u0006,"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiContentCardView;", "Lcom/google/android/material/card/MaterialCardView;", "", "a", "()V", "", "gravity", "setContentGravity", "(I)V", "", "sizePx", "", "(F)Z", "Landroid/widget/ImageView;", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;)V", "Landroid/widget/TextView;", "", "content", "(Landroid/widget/TextView;Ljava/lang/String;)V", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "text", "setHeadlineText", "(Ljava/lang/String;)V", "setHeadlineTextSize", "(F)V", "setTitleText", "setTitleTextSize", "setContentText", "setContentTextSize", "Lcom/yoti/mobile/android/common/ui/widgets/YotiContentCardView$Alignment;", "alignment", "setAlignment", "(Lcom/yoti/mobile/android/common/ui/widgets/YotiContentCardView$Alignment;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Alignment", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class YotiContentCardView extends MaterialCardView {

    /* JADX INFO: renamed from: a */
    private HashMap f6040a;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiContentCardView$Alignment;", "", "", "a", "I", "getAttrValue", "()I", "attrValue", "<init>", "(Ljava/lang/String;II)V", "Companion", "LEFT", "CENTER", "RIGHT", "START", "END", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public enum Alignment {
        LEFT(0),
        CENTER(1),
        RIGHT(2),
        START(3),
        END(4);


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int attrValue;

        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiContentCardView$Alignment$Companion;", "", "", "attrValue", "Lcom/yoti/mobile/android/common/ui/widgets/YotiContentCardView$Alignment;", "fromAttributeValue", "(I)Lcom/yoti/mobile/android/common/ui/widgets/YotiContentCardView$Alignment;", "<init>", "()V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Alignment fromAttributeValue(int attrValue) {
                Alignment alignment;
                Alignment[] alignmentArrValues = Alignment.values();
                int length = alignmentArrValues.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        alignment = null;
                        break;
                    }
                    alignment = alignmentArrValues[i];
                    if (alignment.getAttrValue() == attrValue) {
                        break;
                    }
                    i++;
                }
                return alignment != null ? alignment : Alignment.CENTER;
            }
        }

        Alignment(int i) {
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
            int[] iArr = new int[Alignment.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Alignment.LEFT.ordinal()] = 1;
            iArr[Alignment.START.ordinal()] = 2;
            iArr[Alignment.CENTER.ordinal()] = 3;
            iArr[Alignment.RIGHT.ordinal()] = 4;
            iArr[Alignment.END.ordinal()] = 5;
        }
    }

    public YotiContentCardView(Context context) {
        this(context, null, 0, 6, null);
    }

    public YotiContentCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiContentCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        MaterialCardView.inflate(context, C4584R.layout.view_yoti_content_card, this);
        setCardElevation(0.0f);
        int[] iArr = C4584R.styleable.YotiContentCardView;
        Intrinsics.checkNotNullExpressionValue(iArr, "R.styleable.YotiContentCardView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        int i2 = C4584R.styleable.YotiContentCardView_yotiCardBackgroundColor;
        Resources.Theme theme = context.getTheme();
        Intrinsics.checkNotNullExpressionValue(theme, "context.theme");
        setCardBackgroundColor(typedArrayObtainStyledAttributes.getColor(i2, UiWidgetExtensionsKt.getColorFromAttribute(theme, YotiContentCardKt.f6039c)));
        setStrokeWidth(typedArrayObtainStyledAttributes.getResources().getDimensionPixelSize(C4584R.dimen.content_card_stroke_size));
        int i3 = C4584R.styleable.YotiContentCardView_yotiCardBorderColor;
        Resources.Theme theme2 = context.getTheme();
        Intrinsics.checkNotNullExpressionValue(theme2, "context.theme");
        setStrokeColor(typedArrayObtainStyledAttributes.getColor(i3, UiWidgetExtensionsKt.getColorFromAttribute(theme2, YotiContentCardKt.f6038b)));
        setRadius(typedArrayObtainStyledAttributes.getDimension(C4584R.styleable.YotiContentCardView_yotiCardBorderRadius, typedArrayObtainStyledAttributes.getResources().getDimension(YotiContentCardKt.f6037a)));
        setAlignment(Alignment.INSTANCE.fromAttributeValue(typedArrayObtainStyledAttributes.getInt(C4584R.styleable.YotiContentCardView_yotiCardAlignment, Alignment.CENTER.getAttrValue())));
        setIcon(typedArrayObtainStyledAttributes.getDrawable(C4584R.styleable.YotiContentCardView_yotiCardIcon));
        setHeadlineText(typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiContentCardView_yotiCardHeadline));
        Float fValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(C4584R.styleable.YotiContentCardView_yotiCardHeadlineTextSize, -1.0f));
        fValueOf = m4434a(fValueOf.floatValue()) ? fValueOf : null;
        if (fValueOf != null) {
            setHeadlineTextSize(fValueOf.floatValue());
        }
        setTitleText(typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiContentCardView_yotiCardTitle));
        Float fValueOf2 = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(C4584R.styleable.YotiContentCardView_yotiCardTitleTextSize, -1.0f));
        fValueOf2 = m4434a(fValueOf2.floatValue()) ? fValueOf2 : null;
        if (fValueOf2 != null) {
            setTitleTextSize(fValueOf2.floatValue());
        }
        setContentText(typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiContentCardView_yotiCardContent));
        Float fValueOf3 = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(C4584R.styleable.YotiContentCardView_yotiCardContentTextSize, -1.0f));
        Float f = m4434a(fValueOf3.floatValue()) ? fValueOf3 : null;
        if (f != null) {
            setContentTextSize(f.floatValue());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public /* synthetic */ YotiContentCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0148  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m4431a() {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.common.p049ui.widgets.YotiContentCardView.m4431a():void");
    }

    /* JADX INFO: renamed from: a */
    private final void m4432a(ImageView imageView, Drawable drawable) {
        if (drawable == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m4433a(TextView textView, String str) {
        if (str == null || str.length() == 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    /* JADX INFO: renamed from: a */
    private final boolean m4434a(float sizePx) {
        return sizePx != -1.0f;
    }

    private final void setContentGravity(int gravity) {
        LinearLayout contentLinearLayout = (LinearLayout) _$_findCachedViewById(C4584R.id.contentLinearLayout);
        Intrinsics.checkNotNullExpressionValue(contentLinearLayout, "contentLinearLayout");
        contentLinearLayout.setGravity(gravity);
        TextView headlineTextView = (TextView) _$_findCachedViewById(C4584R.id.headlineTextView);
        Intrinsics.checkNotNullExpressionValue(headlineTextView, "headlineTextView");
        headlineTextView.setGravity(gravity);
        TextView titleTextView = (TextView) _$_findCachedViewById(C4584R.id.titleTextView);
        Intrinsics.checkNotNullExpressionValue(titleTextView, "titleTextView");
        titleTextView.setGravity(gravity);
        TextView contentTextView = (TextView) _$_findCachedViewById(C4584R.id.contentTextView);
        Intrinsics.checkNotNullExpressionValue(contentTextView, "contentTextView");
        contentTextView.setGravity(gravity);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6040a;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f6040a == null) {
            this.f6040a = new HashMap();
        }
        View view = (View) this.f6040a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f6040a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void setAlignment(Alignment alignment) {
        int i;
        if (alignment == null) {
            return;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[alignment.ordinal()];
        if (i2 == 1 || i2 == 2) {
            i = GravityCompat.START;
        } else if (i2 == 3) {
            i = 17;
        } else if (i2 != 4 && i2 != 5) {
            return;
        } else {
            i = GravityCompat.END;
        }
        setContentGravity(i);
    }

    public final void setContentText(String text) {
        TextView contentTextView = (TextView) _$_findCachedViewById(C4584R.id.contentTextView);
        Intrinsics.checkNotNullExpressionValue(contentTextView, "contentTextView");
        m4433a(contentTextView, text);
        m4431a();
    }

    public final void setContentTextSize(float sizePx) {
        ((TextView) _$_findCachedViewById(C4584R.id.contentTextView)).setTextSize(0, sizePx);
    }

    public final void setHeadlineText(String text) {
        TextView headlineTextView = (TextView) _$_findCachedViewById(C4584R.id.headlineTextView);
        Intrinsics.checkNotNullExpressionValue(headlineTextView, "headlineTextView");
        m4433a(headlineTextView, text);
        m4431a();
    }

    public final void setHeadlineTextSize(float sizePx) {
        ((TextView) _$_findCachedViewById(C4584R.id.headlineTextView)).setTextSize(0, sizePx);
    }

    public final void setIcon(Drawable drawable) {
        ImageView iconImageView = (ImageView) _$_findCachedViewById(C4584R.id.iconImageView);
        Intrinsics.checkNotNullExpressionValue(iconImageView, "iconImageView");
        m4432a(iconImageView, drawable);
        m4431a();
    }

    public final void setTitleText(String text) {
        TextView titleTextView = (TextView) _$_findCachedViewById(C4584R.id.titleTextView);
        Intrinsics.checkNotNullExpressionValue(titleTextView, "titleTextView");
        m4433a(titleTextView, text);
        m4431a();
    }

    public final void setTitleTextSize(float sizePx) {
        ((TextView) _$_findCachedViewById(C4584R.id.titleTextView)).setTextSize(0, sizePx);
    }
}
