package com.yoti.mobile.android.common.p049ui.widgets.educationCard;

import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u001d\b\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006j\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardStyle;", "", "", "b", "I", "getBorderColorAttr", "()I", "borderColorAttr", "a", "getBackgroundColorAttr", "backgroundColorAttr", "<init>", "(Ljava/lang/String;III)V", "Companion", "STANDARD", "SUCCESS", "WARNING", "CRITICAL", "NEUTRAL", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public enum CardStyle {
    STANDARD(C4584R.attr.background_emphasis, C4584R.attr.border_emphasis),
    SUCCESS(C4584R.attr.background_success, C4584R.attr.border_success),
    WARNING(C4584R.attr.background_warning, C4584R.attr.border_warning),
    CRITICAL(C4584R.attr.background_error, C4584R.attr.border_error),
    NEUTRAL(C4584R.attr.background_neutral2, C4584R.attr.border_default);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int backgroundColorAttr;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int borderColorAttr;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardStyle$Companion;", "", "", "value", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardStyle;", "toCardStyle$uiWidgets_release", "(I)Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardStyle;", "toCardStyle", "<init>", "()V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CardStyle toCardStyle$uiWidgets_release(int value) {
            return CardStyle.values()[value];
        }
    }

    CardStyle(int i, int i2) {
        this.backgroundColorAttr = i;
        this.borderColorAttr = i2;
    }

    public final int getBackgroundColorAttr() {
        return this.backgroundColorAttr;
    }

    public final int getBorderColorAttr() {
        return this.borderColorAttr;
    }
}
