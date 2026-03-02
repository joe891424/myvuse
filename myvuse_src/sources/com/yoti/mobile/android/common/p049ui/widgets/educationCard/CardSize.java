package com.yoti.mobile.android.common.p049ui.widgets.educationCard;

import com.facebook.common.callercontext.ContextChain;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b)\b\u0086\u0001\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001(Bw\b\u0002\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0001\u0010%\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0001\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u0019\u0010\u001f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u0019\u0010%\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006j\u0002\b)j\u0002\b*¨\u0006+"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardSize;", "", "", "g", "I", "getTitleTopMargin", "()I", "titleTopMargin", "f", "getContentTextTopMargin", "contentTextTopMargin", ContextChain.TAG_INFRA, "getLinkButtonStartMargin", "linkButtonStartMargin", "j", "getLinkButtonTopMargin", "linkButtonTopMargin", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "getContentTextStartMargin", "contentTextStartMargin", "h", "getTitleBottomMargin", "titleBottomMargin", "b", "getTextAppearance", "textAppearance", "a", "getTitleTextAppearance", "titleTextAppearance", "d", "getCenteredIconBottomMargin", "centeredIconBottomMargin", OctetSequenceJsonWebKey.KEY_VALUE_MEMBER_NAME, "getLinkButtonBottomPadding", "linkButtonBottomPadding", "c", "getIconSize", "iconSize", "<init>", "(Ljava/lang/String;IIIIIIIIIIII)V", "Companion", "SMALL", "MEDIUM", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public enum CardSize {
    SMALL(C4584R.style.Yoti_v4_Typography_Title_Small, C4584R.style.Yoti_v4_Typography_Body_Small, C4584R.dimen.education_card_icon_size_small, C4584R.dimen.education_card_centered_icon_bottom_margin_small, C4584R.dimen.education_card_content_text_start_margin_small, C4584R.dimen.education_card_content_text_top_margin_small, C4584R.dimen.education_card_title_top_margin_small, C4584R.dimen.education_card_title_bottom_margin_small, C4584R.dimen.education_card_link_button_start_margin_small, C4584R.dimen.education_card_link_button_top_margin_small, C4584R.dimen.education_card_link_button_bottom_padding_small),
    MEDIUM(C4584R.style.Yoti_v4_Typography_Title_Regular, C4584R.style.Yoti_v4_Typography_Body_Regular, C4584R.dimen.education_card_icon_size_medium, C4584R.dimen.education_card_centered_icon_bottom_margin_medium, C4584R.dimen.education_card_content_text_start_margin_medium, C4584R.dimen.education_card_content_text_top_margin_medium, C4584R.dimen.education_card_title_top_margin_medium, C4584R.dimen.education_card_title_bottom_margin_medium, C4584R.dimen.education_card_link_button_start_margin_medium, C4584R.dimen.education_card_link_button_top_margin_medium, C4584R.dimen.education_card_link_button_bottom_padding_medium);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int titleTextAppearance;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int textAppearance;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int iconSize;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final int centeredIconBottomMargin;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final int contentTextStartMargin;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final int contentTextTopMargin;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final int titleTopMargin;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final int titleBottomMargin;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final int linkButtonStartMargin;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final int linkButtonTopMargin;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final int linkButtonBottomPadding;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardSize$Companion;", "", "", "value", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardSize;", "toCardSize$uiWidgets_release", "(I)Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardSize;", "toCardSize", "<init>", "()V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CardSize toCardSize$uiWidgets_release(int value) {
            return CardSize.values()[value];
        }
    }

    CardSize(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.titleTextAppearance = i;
        this.textAppearance = i2;
        this.iconSize = i3;
        this.centeredIconBottomMargin = i4;
        this.contentTextStartMargin = i5;
        this.contentTextTopMargin = i6;
        this.titleTopMargin = i7;
        this.titleBottomMargin = i8;
        this.linkButtonStartMargin = i9;
        this.linkButtonTopMargin = i10;
        this.linkButtonBottomPadding = i11;
    }

    public final int getCenteredIconBottomMargin() {
        return this.centeredIconBottomMargin;
    }

    public final int getContentTextStartMargin() {
        return this.contentTextStartMargin;
    }

    public final int getContentTextTopMargin() {
        return this.contentTextTopMargin;
    }

    public final int getIconSize() {
        return this.iconSize;
    }

    public final int getLinkButtonBottomPadding() {
        return this.linkButtonBottomPadding;
    }

    public final int getLinkButtonStartMargin() {
        return this.linkButtonStartMargin;
    }

    public final int getLinkButtonTopMargin() {
        return this.linkButtonTopMargin;
    }

    public final int getTextAppearance() {
        return this.textAppearance;
    }

    public final int getTitleBottomMargin() {
        return this.titleBottomMargin;
    }

    public final int getTitleTextAppearance() {
        return this.titleTextAppearance;
    }

    public final int getTitleTopMargin() {
        return this.titleTopMargin;
    }
}
