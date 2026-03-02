package com.yoti.mobile.android.common.p049ui.widgets;

import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import kotlin.Metadata;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BE\b\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/ChipSize;", "", "", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "I", "getTextPaddingRes", "()I", "textPaddingRes", "a", "getTextAppearanceRes", "textAppearanceRes", "d", "getEndPaddingRes", "endPaddingRes", "c", "getStartPaddingRes", "startPaddingRes", "b", "getIconSizeRes", "iconSizeRes", "f", "getIconPaddingRes", "iconPaddingRes", "<init>", "(Ljava/lang/String;IIIIIII)V", "SMALL", "MEDIUM", "LARGE", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public enum ChipSize {
    SMALL(C4584R.style.Yoti_v4_Typography_Body_XS, C4584R.dimen.chip_icon_small, C4584R.dimen.chip_start_padding_small, C4584R.dimen.chip_end_padding_small, C4584R.dimen.chip_text_padding_small, C4584R.dimen.chip_icon_end_padding_small),
    MEDIUM(C4584R.style.Yoti_v4_Typography_Body_Small, C4584R.dimen.chip_icon_medium, C4584R.dimen.chip_start_padding_medium, C4584R.dimen.chip_end_padding_medium, C4584R.dimen.chip_text_padding_medium, C4584R.dimen.chip_icon_end_padding_medium),
    LARGE(C4584R.style.Yoti_v4_Typography_Body_Regular, C4584R.dimen.chip_icon_large, C4584R.dimen.chip_start_padding_large, C4584R.dimen.chip_end_padding_large, C4584R.dimen.chip_text_padding_large, C4584R.dimen.chip_icon_end_padding_large);


    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int textAppearanceRes;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int iconSizeRes;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int startPaddingRes;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final int endPaddingRes;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final int textPaddingRes;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final int iconPaddingRes;

    ChipSize(int i, int i2, int i3, int i4, int i5, int i6) {
        this.textAppearanceRes = i;
        this.iconSizeRes = i2;
        this.startPaddingRes = i3;
        this.endPaddingRes = i4;
        this.textPaddingRes = i5;
        this.iconPaddingRes = i6;
    }

    public final int getEndPaddingRes() {
        return this.endPaddingRes;
    }

    public final int getIconPaddingRes() {
        return this.iconPaddingRes;
    }

    public final int getIconSizeRes() {
        return this.iconSizeRes;
    }

    public final int getStartPaddingRes() {
        return this.startPaddingRes;
    }

    public final int getTextAppearanceRes() {
        return this.textAppearanceRes;
    }

    public final int getTextPaddingRes() {
        return this.textPaddingRes;
    }
}
