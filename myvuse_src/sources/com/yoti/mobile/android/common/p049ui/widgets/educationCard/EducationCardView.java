package com.yoti.mobile.android.common.p049ui.widgets.educationCard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.color.MaterialColors;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.common.p049ui.widgets.educationCard.CardAlignment;
import com.yoti.mobile.android.common.p049ui.widgets.educationCard.CardSize;
import com.yoti.mobile.android.common.p049ui.widgets.educationCard.CardStyle;
import com.yoti.mobile.android.common.p049ui.widgets.educationCard.CtaType;
import com.yoti.mobile.android.common.p049ui.widgets.educationCard.EducationCardView;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import com.yoti.mobile.android.commons.p051ui.widgets.p052a.C4585a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001LB'\b\u0007\u0012\u0006\u0010F\u001a\u00020E\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G\u0012\b\b\u0002\u0010I\u001a\u00020\u0013¢\u0006\u0004\bJ\u0010KJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0011\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0011\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0017\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u00052\b\b\u0001\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001a\u0010\u0012J\u0015\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J\u001b\u0010,\u001a\u00020\u00052\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b,\u0010-J\u0015\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H\u0014¢\u0006\u0004\b3\u00104J\u0019\u00106\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u000102H\u0014¢\u0006\u0004\b6\u00107R\u0016\u00109\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00108R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010:R\u0016\u0010=\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010<R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010?R\u0016\u0010B\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010AR\u0016\u0010D\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010C¨\u0006M"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/educationCard/EducationCardView;", "Lcom/google/android/material/card/MaterialCardView;", "Landroid/view/View;", "view", "Lkotlin/Function0;", "", "a", "(Landroid/view/View;)Lkotlin/jvm/functions/Function0;", "()V", "f", "b", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "d", "c", "g", "", "title", "setTitleText", "(Ljava/lang/String;)V", "", "titleResId", "(I)V", "content", "setContentText", "textResId", "ctaText", "setCtaText", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CtaType;", "ctaType", "setCtaType", "(Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CtaType;)V", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardAlignment;", "alignment", "setAlignment", "(Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardAlignment;)V", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardSize;", "size", "setSize", "(Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardSize;)V", "Landroid/graphics/drawable/Drawable;", "icon", "setIconDrawable", "(Landroid/graphics/drawable/Drawable;)V", "onClick", "setButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardStyle;", "style", "setStyle", "(Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardStyle;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CtaType;", "cardCtaType", "Lkotlin/jvm/functions/Function0;", "buttonClickListener", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardSize;", "cardSize", "Lcom/yoti/mobile/android/commons/ui/widgets/a/a;", "Lcom/yoti/mobile/android/commons/ui/widgets/a/a;", "binding", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardAlignment;", "cardAlignment", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardStyle;", "cardStyle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SavedState", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class EducationCardView extends MaterialCardView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private Function0<Unit> buttonClickListener;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final C4585a binding;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private CardStyle cardStyle;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private CardSize cardSize;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private CardAlignment cardAlignment;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private CtaType cardCtaType;

    /* JADX INFO: renamed from: g */
    private HashMap f6428g;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/B\u0011\b\u0016\u0012\u0006\u0010)\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b*\u0010.J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00060"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/educationCard/EducationCardView$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", "out", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardSize;", "a", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardSize;", "getCardSize", "()Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardSize;", "setCardSize", "(Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardSize;)V", "cardSize", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardStyle;", "b", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardStyle;", "getCardStyle", "()Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardStyle;", "setCardStyle", "(Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardStyle;)V", "cardStyle", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CtaType;", "d", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CtaType;", "getCtaType", "()Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CtaType;", "setCtaType", "(Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CtaType;)V", "ctaType", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardAlignment;", "c", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardAlignment;", "getCardAlignment", "()Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardAlignment;", "setCardAlignment", "(Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardAlignment;)V", "cardAlignment", "source", "<init>", "(Landroid/os/Parcel;)V", "Landroid/os/Parcelable;", "superState", "(Landroid/os/Parcelable;)V", "Companion", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final class SavedState extends View.BaseSavedState {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private CardSize cardSize;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private CardStyle cardStyle;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private CardAlignment cardAlignment;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private CtaType ctaType;
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.yoti.mobile.android.common.ui.widgets.educationCard.EducationCardView$SavedState$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public EducationCardView.SavedState createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                return new EducationCardView.SavedState(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public EducationCardView.SavedState[] newArray(int size) {
                return new EducationCardView.SavedState[size];
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel source) {
            super(source);
            Intrinsics.checkNotNullParameter(source, "source");
            CardSize.Companion companion = CardSize.INSTANCE;
            this.cardSize = companion.toCardSize$uiWidgets_release(EducationCardViewKt.f6435b.ordinal());
            CardStyle.Companion companion2 = CardStyle.INSTANCE;
            this.cardStyle = companion2.toCardStyle$uiWidgets_release(EducationCardViewKt.f6434a.ordinal());
            CardAlignment.Companion companion3 = CardAlignment.INSTANCE;
            this.cardAlignment = companion3.toCardAlignment$uiWidgets_release(EducationCardViewKt.f6436c.ordinal());
            CtaType.Companion companion4 = CtaType.INSTANCE;
            this.ctaType = companion4.toCtaType$uiWidgets_release(EducationCardViewKt.f6437d.ordinal());
            this.cardSize = companion.toCardSize$uiWidgets_release(source.readInt());
            this.cardStyle = companion2.toCardStyle$uiWidgets_release(source.readInt());
            this.cardAlignment = companion3.toCardAlignment$uiWidgets_release(source.readInt());
            this.ctaType = companion4.toCtaType$uiWidgets_release(source.readInt());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable superState) {
            super(superState);
            Intrinsics.checkNotNullParameter(superState, "superState");
            this.cardSize = CardSize.INSTANCE.toCardSize$uiWidgets_release(EducationCardViewKt.f6435b.ordinal());
            this.cardStyle = CardStyle.INSTANCE.toCardStyle$uiWidgets_release(EducationCardViewKt.f6434a.ordinal());
            this.cardAlignment = CardAlignment.INSTANCE.toCardAlignment$uiWidgets_release(EducationCardViewKt.f6436c.ordinal());
            this.ctaType = CtaType.INSTANCE.toCtaType$uiWidgets_release(EducationCardViewKt.f6437d.ordinal());
        }

        public final CardAlignment getCardAlignment() {
            return this.cardAlignment;
        }

        public final CardSize getCardSize() {
            return this.cardSize;
        }

        public final CardStyle getCardStyle() {
            return this.cardStyle;
        }

        public final CtaType getCtaType() {
            return this.ctaType;
        }

        public final void setCardAlignment(CardAlignment cardAlignment) {
            Intrinsics.checkNotNullParameter(cardAlignment, "<set-?>");
            this.cardAlignment = cardAlignment;
        }

        public final void setCardSize(CardSize cardSize) {
            Intrinsics.checkNotNullParameter(cardSize, "<set-?>");
            this.cardSize = cardSize;
        }

        public final void setCardStyle(CardStyle cardStyle) {
            Intrinsics.checkNotNullParameter(cardStyle, "<set-?>");
            this.cardStyle = cardStyle;
        }

        public final void setCtaType(CtaType ctaType) {
            Intrinsics.checkNotNullParameter(ctaType, "<set-?>");
            this.ctaType = ctaType;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            Intrinsics.checkNotNullParameter(out, "out");
            super.writeToParcel(out, flags);
            out.writeInt(this.cardSize.ordinal());
            out.writeInt(this.cardStyle.ordinal());
            out.writeInt(this.cardAlignment.ordinal());
            out.writeInt(this.ctaType.ordinal());
        }
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CardAlignment.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CardAlignment.START.ordinal()] = 1;
            iArr[CardAlignment.CENTER.ordinal()] = 2;
            int[] iArr2 = new int[CtaType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[CtaType.LINK.ordinal()] = 1;
            iArr2[CtaType.BUTTON.ordinal()] = 2;
            iArr2[CtaType.NONE.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.educationCard.EducationCardView$a */
    static final class C4554a extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a */
        public static final C4554a f6433a = new C4554a();

        C4554a() {
            super(0);
        }

        /* JADX INFO: renamed from: a */
        public final void m4663a() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            m4663a();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.educationCard.EducationCardView$b */
    static final /* synthetic */ class C4555b extends AdaptedFunctionReference implements Function1<View, Unit> {
        C4555b(EducationCardView educationCardView) {
            super(1, educationCardView, EducationCardView.class, "handleButtonClick", "handleButtonClick(Landroid/view/View;)Lkotlin/jvm/functions/Function0;", 8);
        }

        /* JADX INFO: renamed from: a */
        public final void m4664a(View p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((EducationCardView) this.receiver).m4655a(p1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            m4664a(view);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.educationCard.EducationCardView$c */
    static final /* synthetic */ class C4556c extends AdaptedFunctionReference implements Function1<View, Unit> {
        C4556c(EducationCardView educationCardView) {
            super(1, educationCardView, EducationCardView.class, "handleButtonClick", "handleButtonClick(Landroid/view/View;)Lkotlin/jvm/functions/Function0;", 8);
        }

        /* JADX INFO: renamed from: a */
        public final void m4665a(View p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((EducationCardView) this.receiver).m4655a(p1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            m4665a(view);
            return Unit.INSTANCE;
        }
    }

    public EducationCardView(Context context) {
        this(context, null, 0, 6, null);
    }

    public EducationCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EducationCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.buttonClickListener = C4554a.f6433a;
        C4585a c4585aM4686a = C4585a.m4686a(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c4585aM4686a, "ViewEducationCardBinding…rom(context), this, true)");
        this.binding = c4585aM4686a;
        this.cardStyle = EducationCardViewKt.f6434a;
        this.cardSize = EducationCardViewKt.f6435b;
        this.cardAlignment = EducationCardViewKt.f6436c;
        this.cardCtaType = EducationCardViewKt.f6437d;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4584R.styleable.EducationCardView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…nCardView, 0, 0\n        )");
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C4584R.styleable.EducationCardView_card_icon);
        String string = typedArrayObtainStyledAttributes.getString(C4584R.styleable.EducationCardView_card_title);
        String string2 = typedArrayObtainStyledAttributes.getString(C4584R.styleable.EducationCardView_card_text);
        String string3 = typedArrayObtainStyledAttributes.getString(C4584R.styleable.EducationCardView_cta_text);
        this.cardStyle = CardStyle.INSTANCE.toCardStyle$uiWidgets_release(typedArrayObtainStyledAttributes.getInt(C4584R.styleable.EducationCardView_card_style, EducationCardViewKt.f6434a.ordinal()));
        this.cardSize = CardSize.INSTANCE.toCardSize$uiWidgets_release(typedArrayObtainStyledAttributes.getInt(C4584R.styleable.EducationCardView_card_size, EducationCardViewKt.f6435b.ordinal()));
        this.cardAlignment = CardAlignment.INSTANCE.toCardAlignment$uiWidgets_release(typedArrayObtainStyledAttributes.getInt(C4584R.styleable.EducationCardView_card_alignment, EducationCardViewKt.f6436c.ordinal()));
        this.cardCtaType = CtaType.INSTANCE.toCtaType$uiWidgets_release(typedArrayObtainStyledAttributes.getInt(C4584R.styleable.EducationCardView_cta_type, EducationCardViewKt.f6437d.ordinal()));
        setStrokeWidth(getResources().getDimensionPixelSize(C4584R.dimen.education_card_border_width));
        setRadius(getResources().getDimension(C4584R.dimen.education_card_corner_radius));
        setElevation(0.0f);
        TextView cardTitle = c4585aM4686a.f6588g;
        Intrinsics.checkNotNullExpressionValue(cardTitle, "cardTitle");
        cardTitle.setText(string);
        TextView cardText = c4585aM4686a.f6587f;
        Intrinsics.checkNotNullExpressionValue(cardText, "cardText");
        cardText.setText(string2);
        YotiButton cardButtonMedium = c4585aM4686a.f6583b;
        Intrinsics.checkNotNullExpressionValue(cardButtonMedium, "cardButtonMedium");
        cardButtonMedium.setText(string3);
        YotiButton cardButtonSmall = c4585aM4686a.f6584c;
        Intrinsics.checkNotNullExpressionValue(cardButtonSmall, "cardButtonSmall");
        cardButtonSmall.setText(string3);
        YotiButton cardLinkMedium = c4585aM4686a.f6585d;
        Intrinsics.checkNotNullExpressionValue(cardLinkMedium, "cardLinkMedium");
        cardLinkMedium.setText(string3);
        YotiButton cardLinkSmall = c4585aM4686a.f6586e;
        Intrinsics.checkNotNullExpressionValue(cardLinkSmall, "cardLinkSmall");
        cardLinkSmall.setText(string3);
        c4585aM4686a.f6590i.setImageDrawable(drawable);
        c4585aM4686a.f6589h.setImageDrawable(drawable);
        setStyle(this.cardStyle);
        m4656a();
        typedArrayObtainStyledAttributes.recycle();
    }

    public /* synthetic */ EducationCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final Function0<Unit> m4655a(View view) {
        return this.buttonClickListener;
    }

    /* JADX INFO: renamed from: a */
    private final void m4656a() {
        m4657b();
        m4660e();
        m4659d();
        m4658c();
        m4661f();
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m4657b() {
        /*
            r6 = this;
            com.yoti.mobile.android.commons.ui.widgets.a.a r0 = r6.binding
            android.widget.TextView r1 = r0.f6587f
            java.lang.String r2 = "cardText"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.yoti.mobile.android.common.ui.widgets.educationCard.CardAlignment r3 = r6.cardAlignment
            int r3 = r3.getGravity()
            r1.setGravity(r3)
            android.widget.TextView r1 = r0.f6587f
            com.yoti.mobile.android.common.ui.widgets.educationCard.CardSize r3 = r6.cardSize
            int r3 = r3.getTextAppearance()
            androidx.core.widget.TextViewCompat.setTextAppearance(r1, r3)
            android.content.res.Resources r1 = r6.getResources()
            android.widget.ImageView r3 = r0.f6590i
            java.lang.String r4 = "startCardIcon"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            android.graphics.drawable.Drawable r3 = r3.getDrawable()
            if (r3 == 0) goto L3b
            com.yoti.mobile.android.common.ui.widgets.educationCard.CardAlignment r3 = r6.cardAlignment
            com.yoti.mobile.android.common.ui.widgets.educationCard.CardAlignment r5 = com.yoti.mobile.android.common.p049ui.widgets.educationCard.CardAlignment.START
            if (r3 != r5) goto L3b
            com.yoti.mobile.android.common.ui.widgets.educationCard.CardSize r3 = r6.cardSize
            int r3 = r3.getContentTextStartMargin()
            goto L3d
        L3b:
            int r3 = com.yoti.mobile.android.commons.p051ui.widgets.C4584R.dimen.education_card_horizontal_margin
        L3d:
            int r1 = r1.getDimensionPixelSize(r3)
            android.widget.ImageView r3 = r0.f6590i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            android.graphics.drawable.Drawable r3 = r3.getDrawable()
            r4 = 0
            if (r3 == 0) goto L75
            com.yoti.mobile.android.common.ui.widgets.educationCard.CardAlignment r3 = r6.cardAlignment
            com.yoti.mobile.android.common.ui.widgets.educationCard.CardAlignment r5 = com.yoti.mobile.android.common.p049ui.widgets.educationCard.CardAlignment.START
            if (r3 != r5) goto L75
            android.widget.TextView r3 = r0.f6588g
            java.lang.String r5 = "cardTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            java.lang.CharSequence r3 = r3.getText()
            if (r3 == 0) goto L66
            int r3 = r3.length()
            if (r3 != 0) goto L75
        L66:
            android.content.res.Resources r3 = r6.getResources()
            com.yoti.mobile.android.common.ui.widgets.educationCard.CardSize r5 = r6.cardSize
            int r5 = r5.getContentTextTopMargin()
            int r3 = r3.getDimensionPixelSize(r5)
            goto L76
        L75:
            r3 = r4
        L76:
            android.widget.TextView r0 = r0.f6587f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            android.view.ViewGroup$LayoutParams r2 = r0.getLayoutParams()
            if (r2 == 0) goto L90
            android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
            r2.setMargins(r1, r3, r4, r4)
            r2.setMarginStart(r1)
            r2.setMarginEnd(r4)
            r0.setLayoutParams(r2)
            return
        L90:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.common.p049ui.widgets.educationCard.EducationCardView.m4657b():void");
    }

    /* JADX INFO: renamed from: c */
    private final void m4658c() {
        C4585a c4585a = this.binding;
        YotiButton cardLinkSmall = c4585a.f6586e;
        Intrinsics.checkNotNullExpressionValue(cardLinkSmall, "cardLinkSmall");
        cardLinkSmall.setVisibility(8);
        YotiButton cardLinkMedium = c4585a.f6585d;
        Intrinsics.checkNotNullExpressionValue(cardLinkMedium, "cardLinkMedium");
        cardLinkMedium.setVisibility(8);
        YotiButton cardButtonMedium = c4585a.f6583b;
        Intrinsics.checkNotNullExpressionValue(cardButtonMedium, "cardButtonMedium");
        cardButtonMedium.setVisibility(8);
        YotiButton cardButtonSmall = c4585a.f6584c;
        Intrinsics.checkNotNullExpressionValue(cardButtonSmall, "cardButtonSmall");
        cardButtonSmall.setVisibility(8);
        ConstraintLayout root = c4585a.getRoot();
        ConstraintLayout root2 = c4585a.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "root");
        int paddingStart = root2.getPaddingStart();
        ConstraintLayout root3 = c4585a.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "root");
        int paddingTop = root3.getPaddingTop();
        ConstraintLayout root4 = c4585a.getRoot();
        Intrinsics.checkNotNullExpressionValue(root4, "root");
        root.setPaddingRelative(paddingStart, paddingTop, root4.getPaddingEnd(), getResources().getDimensionPixelSize(C4584R.dimen.education_card_vertical_margin));
        int i = WhenMappings.$EnumSwitchMapping$1[this.cardCtaType.ordinal()];
        if (i == 1) {
            m4662g();
            return;
        }
        if (i != 2) {
            return;
        }
        YotiButton yotiButton = this.cardSize == CardSize.SMALL ? c4585a.f6584c : c4585a.f6583b;
        Intrinsics.checkNotNullExpressionValue(yotiButton, "if (cardSize == SMALL) c…all else cardButtonMedium");
        yotiButton.setOnClickListener(new EducationCardViewKt$sam$i$android_view_View_OnClickListener$0(new C4555b(this)));
        CharSequence text = yotiButton.getText();
        if (text == null || text.length() == 0) {
            return;
        }
        yotiButton.setVisibility(0);
    }

    /* JADX INFO: renamed from: d */
    private final void m4659d() {
        ImageView startCardIcon;
        C4585a c4585a = this.binding;
        int i = WhenMappings.$EnumSwitchMapping$0[this.cardAlignment.ordinal()];
        if (i == 1) {
            ImageView startCardIcon2 = c4585a.f6590i;
            Intrinsics.checkNotNullExpressionValue(startCardIcon2, "startCardIcon");
            if (startCardIcon2.getDrawable() == null) {
                startCardIcon = c4585a.f6590i;
                Intrinsics.checkNotNullExpressionValue(startCardIcon, "startCardIcon");
                startCardIcon.setVisibility(8);
            }
            ImageView startCardIcon3 = c4585a.f6590i;
            Intrinsics.checkNotNullExpressionValue(startCardIcon3, "startCardIcon");
            startCardIcon3.getLayoutParams().height = getResources().getDimensionPixelSize(this.cardSize.getIconSize());
            ImageView startCardIcon4 = c4585a.f6590i;
            Intrinsics.checkNotNullExpressionValue(startCardIcon4, "startCardIcon");
            startCardIcon4.getLayoutParams().width = getResources().getDimensionPixelSize(this.cardSize.getIconSize());
            ImageView startCardIcon5 = c4585a.f6590i;
            Intrinsics.checkNotNullExpressionValue(startCardIcon5, "startCardIcon");
            startCardIcon5.setVisibility(0);
        } else {
            if (i != 2) {
                return;
            }
            ImageView centerCardIcon = c4585a.f6589h;
            Intrinsics.checkNotNullExpressionValue(centerCardIcon, "centerCardIcon");
            if (centerCardIcon.getDrawable() != null) {
                ImageView centerCardIcon2 = c4585a.f6589h;
                Intrinsics.checkNotNullExpressionValue(centerCardIcon2, "centerCardIcon");
                centerCardIcon2.getLayoutParams().height = getResources().getDimensionPixelSize(this.cardSize.getIconSize());
                ImageView centerCardIcon3 = c4585a.f6589h;
                Intrinsics.checkNotNullExpressionValue(centerCardIcon3, "centerCardIcon");
                centerCardIcon3.getLayoutParams().width = getResources().getDimensionPixelSize(this.cardSize.getIconSize());
                ImageView centerCardIcon4 = c4585a.f6589h;
                Intrinsics.checkNotNullExpressionValue(centerCardIcon4, "centerCardIcon");
                centerCardIcon4.setVisibility(0);
                ImageView startCardIcon6 = c4585a.f6590i;
                Intrinsics.checkNotNullExpressionValue(startCardIcon6, "startCardIcon");
                startCardIcon6.setVisibility(8);
                ImageView centerCardIcon5 = c4585a.f6589h;
                Intrinsics.checkNotNullExpressionValue(centerCardIcon5, "centerCardIcon");
                ViewGroup.LayoutParams layoutParams = centerCardIcon5.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, 0, 0, getResources().getDimensionPixelSize(this.cardSize.getCenteredIconBottomMargin()));
                centerCardIcon5.setLayoutParams(marginLayoutParams);
                return;
            }
        }
        startCardIcon = c4585a.f6589h;
        Intrinsics.checkNotNullExpressionValue(startCardIcon, "centerCardIcon");
        startCardIcon.setVisibility(8);
    }

    /* JADX INFO: renamed from: e */
    private final void m4660e() {
        C4585a c4585a = this.binding;
        TextView cardTitle = c4585a.f6588g;
        Intrinsics.checkNotNullExpressionValue(cardTitle, "cardTitle");
        TextView cardTitle2 = c4585a.f6588g;
        Intrinsics.checkNotNullExpressionValue(cardTitle2, "cardTitle");
        CharSequence text = cardTitle2.getText();
        cardTitle.setVisibility((text == null || text.length() == 0) ? 8 : 0);
        TextView cardTitle3 = c4585a.f6588g;
        Intrinsics.checkNotNullExpressionValue(cardTitle3, "cardTitle");
        cardTitle3.setGravity(this.cardAlignment.getGravity());
        TextViewCompat.setTextAppearance(c4585a.f6588g, this.cardSize.getTitleTextAppearance());
        ImageView startCardIcon = c4585a.f6590i;
        Intrinsics.checkNotNullExpressionValue(startCardIcon, "startCardIcon");
        int dimensionPixelSize = (startCardIcon.getDrawable() == null || this.cardAlignment != CardAlignment.START) ? 0 : getResources().getDimensionPixelSize(this.cardSize.getTitleTopMargin());
        TextView cardTitle4 = c4585a.f6588g;
        Intrinsics.checkNotNullExpressionValue(cardTitle4, "cardTitle");
        ViewGroup.LayoutParams layoutParams = cardTitle4.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(0, dimensionPixelSize, 0, getResources().getDimensionPixelSize(this.cardSize.getTitleBottomMargin()));
        cardTitle4.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: renamed from: f */
    private final void m4661f() {
        TextView cardTitle = (TextView) _$_findCachedViewById(C4584R.id.cardTitle);
        Intrinsics.checkNotNullExpressionValue(cardTitle, "cardTitle");
        CharSequence text = cardTitle.getText();
        int i = (text == null || text.length() == 0) ? C4584R.attr.typography_neutral_mid : C4584R.attr.typography_neutral_contrast;
        ((ImageView) _$_findCachedViewById(C4584R.id.centerCardIcon)).setColorFilter(MaterialColors.getColor(getRootView(), i));
        ((ImageView) _$_findCachedViewById(C4584R.id.startCardIcon)).setColorFilter(MaterialColors.getColor(getRootView(), i));
    }

    /* JADX INFO: renamed from: g */
    private final void m4662g() {
        C4585a c4585a = this.binding;
        YotiButton yotiButton = this.cardSize == CardSize.SMALL ? c4585a.f6586e : c4585a.f6585d;
        Intrinsics.checkNotNullExpressionValue(yotiButton, "if (cardSize == SMALL) c…Small else cardLinkMedium");
        CharSequence text = yotiButton.getText();
        if (text != null && text.length() != 0) {
            yotiButton.setVisibility(0);
        }
        yotiButton.setOnClickListener(new EducationCardViewKt$sam$i$android_view_View_OnClickListener$0(new C4556c(this)));
        yotiButton.setGravity(this.cardAlignment.getGravity());
        ViewGroup.LayoutParams layoutParams = yotiButton.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.horizontalBias = this.cardAlignment.getLinkButtonHorizontalBias();
        yotiButton.setLayoutParams(layoutParams2);
        ConstraintLayout root = c4585a.getRoot();
        ConstraintLayout root2 = c4585a.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "root");
        int paddingStart = root2.getPaddingStart();
        ConstraintLayout root3 = c4585a.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "root");
        int paddingTop = root3.getPaddingTop();
        ConstraintLayout root4 = c4585a.getRoot();
        Intrinsics.checkNotNullExpressionValue(root4, "root");
        root.setPaddingRelative(paddingStart, paddingTop, root4.getPaddingEnd(), getResources().getDimensionPixelSize(this.cardSize.getLinkButtonBottomPadding()));
        int dimensionPixelSize = this.cardAlignment == CardAlignment.START ? getResources().getDimensionPixelSize(this.cardSize.getLinkButtonStartMargin()) : 0;
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(this.cardSize.getLinkButtonTopMargin());
        ViewGroup.LayoutParams layoutParams3 = yotiButton.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
        marginLayoutParams.setMargins(dimensionPixelSize, dimensionPixelSize2, 0, 0);
        marginLayoutParams.setMarginStart(dimensionPixelSize);
        marginLayoutParams.setMarginEnd(0);
        yotiButton.setLayoutParams(marginLayoutParams);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6428g;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f6428g == null) {
            this.f6428g = new HashMap();
        }
        View view = (View) this.f6428g.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f6428g.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        boolean z = state instanceof SavedState;
        super.onRestoreInstanceState(state);
        if (z) {
            SavedState savedState = (SavedState) state;
            this.cardSize = savedState.getCardSize();
            this.cardStyle = savedState.getCardStyle();
            this.cardAlignment = savedState.getCardAlignment();
            this.cardCtaType = savedState.getCtaType();
            m4656a();
            setStyle(this.cardStyle);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNullExpressionValue(parcelableOnSaveInstanceState, "super.onSaveInstanceState()");
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.setCardSize(this.cardSize);
        savedState.setCardStyle(this.cardStyle);
        savedState.setCardAlignment(this.cardAlignment);
        savedState.setCtaType(this.cardCtaType);
        return savedState;
    }

    public final void setAlignment(CardAlignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.cardAlignment = alignment;
        m4656a();
    }

    public final void setButtonClickListener(Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.buttonClickListener = onClick;
    }

    public final void setContentText(int textResId) {
        setContentText(getResources().getString(textResId));
    }

    public final void setContentText(String content) {
        TextView textView = this.binding.f6587f;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.cardText");
        textView.setText(content);
    }

    public final void setCtaText(String ctaText) {
        C4585a c4585a = this.binding;
        YotiButton cardButtonMedium = c4585a.f6583b;
        Intrinsics.checkNotNullExpressionValue(cardButtonMedium, "cardButtonMedium");
        cardButtonMedium.setText(ctaText);
        YotiButton cardButtonSmall = c4585a.f6584c;
        Intrinsics.checkNotNullExpressionValue(cardButtonSmall, "cardButtonSmall");
        cardButtonSmall.setText(ctaText);
        YotiButton cardLinkMedium = c4585a.f6585d;
        Intrinsics.checkNotNullExpressionValue(cardLinkMedium, "cardLinkMedium");
        cardLinkMedium.setText(ctaText);
        YotiButton cardLinkSmall = c4585a.f6586e;
        Intrinsics.checkNotNullExpressionValue(cardLinkSmall, "cardLinkSmall");
        cardLinkSmall.setText(ctaText);
        m4656a();
    }

    public final void setCtaType(CtaType ctaType) {
        Intrinsics.checkNotNullParameter(ctaType, "ctaType");
        this.cardCtaType = ctaType;
        m4656a();
    }

    public final void setIconDrawable(Drawable icon) {
        C4585a c4585a = this.binding;
        c4585a.f6590i.setImageDrawable(icon);
        c4585a.f6589h.setImageDrawable(icon);
        m4656a();
    }

    public final void setSize(CardSize size) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.cardSize = size;
        m4656a();
    }

    public final void setStyle(CardStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.cardStyle = style;
        setCardBackgroundColor(MaterialColors.getColor(getRootView(), style.getBackgroundColorAttr()));
        setStrokeColor(MaterialColors.getColor(getRootView(), style.getBorderColorAttr()));
    }

    public final void setTitleText(int titleResId) {
        setTitleText(getResources().getString(titleResId));
    }

    public final void setTitleText(String title) {
        TextView textView = this.binding.f6588g;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.cardTitle");
        textView.setText(title);
        m4656a();
    }
}
