package com.yoti.mobile.android.common.p049ui.widgets.educationCard;

import androidx.core.view.GravityCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0019\b\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardAlignment;", "", "", "b", "F", "getLinkButtonHorizontalBias", "()F", "linkButtonHorizontalBias", "", "a", "I", "getGravity", "()I", "gravity", "<init>", "(Ljava/lang/String;IIF)V", "Companion", "START", "CENTER", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public enum CardAlignment {
    START(GravityCompat.START, 0.0f),
    CENTER(17, 0.5f);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int gravity;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final float linkButtonHorizontalBias;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardAlignment$Companion;", "", "", "value", "Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardAlignment;", "toCardAlignment$uiWidgets_release", "(I)Lcom/yoti/mobile/android/common/ui/widgets/educationCard/CardAlignment;", "toCardAlignment", "<init>", "()V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CardAlignment toCardAlignment$uiWidgets_release(int value) {
            return CardAlignment.values()[value];
        }
    }

    CardAlignment(int i, float f) {
        this.gravity = i;
        this.linkButtonHorizontalBias = f;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final float getLinkButtonHorizontalBias() {
        return this.linkButtonHorizontalBias;
    }
}
