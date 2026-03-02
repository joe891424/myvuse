package com.yoti.mobile.android.common.p049ui.widgets.educationCard;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CtaType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "NONE", "LINK", "BUTTON", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public enum CtaType {
    NONE,
    LINK,
    BUTTON;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CtaType$Companion;", "", "", "value", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CtaType;", "toCtaType$uiWidgets_release", "(I)Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CtaType;", "toCtaType", "<init>", "()V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CtaType toCtaType$uiWidgets_release(int value) {
            return CtaType.values()[value];
        }
    }
}
