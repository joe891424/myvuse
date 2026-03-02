package com.qualtrics.digital;

import androidx.core.app.FrameMetricsAggregator;
import com.qualtrics.digital.theming.embedded.EmbeddedAppFeedbackTheme;
import com.qualtrics.digital.theming.prompt.MobileAppPromptTheme;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QualtricsTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0002\r\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, m5598d2 = {"Lcom/qualtrics/digital/QualtricsTheme;", "", "builder", "Lcom/qualtrics/digital/QualtricsTheme$Builder;", "(Lcom/qualtrics/digital/QualtricsTheme$Builder;)V", "embeddedAppFeedbackTheme", "Lcom/qualtrics/digital/theming/embedded/EmbeddedAppFeedbackTheme;", "getEmbeddedAppFeedbackTheme", "()Lcom/qualtrics/digital/theming/embedded/EmbeddedAppFeedbackTheme;", "mobileAppPromptTheme", "Lcom/qualtrics/digital/theming/prompt/MobileAppPromptTheme;", "getMobileAppPromptTheme", "()Lcom/qualtrics/digital/theming/prompt/MobileAppPromptTheme;", "Builder", "Companion", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class QualtricsTheme {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final EmbeddedAppFeedbackTheme embeddedAppFeedbackTheme;
    private final MobileAppPromptTheme mobileAppPromptTheme;

    public /* synthetic */ QualtricsTheme(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @JvmStatic
    public static final QualtricsTheme buildDefaultQualtricsTheme() {
        return INSTANCE.buildDefaultQualtricsTheme();
    }

    private QualtricsTheme(Builder builder) {
        this.mobileAppPromptTheme = builder.getMobileAppPromptTheme();
        this.embeddedAppFeedbackTheme = builder.getEmbeddedAppFeedbackTheme();
    }

    public final MobileAppPromptTheme getMobileAppPromptTheme() {
        return this.mobileAppPromptTheme;
    }

    public final EmbeddedAppFeedbackTheme getEmbeddedAppFeedbackTheme() {
        return this.embeddedAppFeedbackTheme;
    }

    /* JADX INFO: compiled from: QualtricsTheme.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, m5598d2 = {"Lcom/qualtrics/digital/QualtricsTheme$Builder;", "", "()V", "embeddedAppFeedbackTheme", "Lcom/qualtrics/digital/theming/embedded/EmbeddedAppFeedbackTheme;", "getEmbeddedAppFeedbackTheme$qualtrics_productionRelease", "()Lcom/qualtrics/digital/theming/embedded/EmbeddedAppFeedbackTheme;", "setEmbeddedAppFeedbackTheme$qualtrics_productionRelease", "(Lcom/qualtrics/digital/theming/embedded/EmbeddedAppFeedbackTheme;)V", "mobileAppPromptTheme", "Lcom/qualtrics/digital/theming/prompt/MobileAppPromptTheme;", "getMobileAppPromptTheme$qualtrics_productionRelease", "()Lcom/qualtrics/digital/theming/prompt/MobileAppPromptTheme;", "setMobileAppPromptTheme$qualtrics_productionRelease", "(Lcom/qualtrics/digital/theming/prompt/MobileAppPromptTheme;)V", "build", "Lcom/qualtrics/digital/QualtricsTheme;", "setEmbeddedAppFeedbackTheme", "setMobileAppPromptTheme", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Builder {
        private MobileAppPromptTheme mobileAppPromptTheme = new MobileAppPromptTheme(0, 0, null, 0, null, 0, 0, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
        private EmbeddedAppFeedbackTheme embeddedAppFeedbackTheme = new EmbeddedAppFeedbackTheme(0, 0, 0, null, null, null, null, null, null, null, null, null, null, 8191, null);

        /* JADX INFO: renamed from: getMobileAppPromptTheme$qualtrics_productionRelease, reason: from getter */
        public final MobileAppPromptTheme getMobileAppPromptTheme() {
            return this.mobileAppPromptTheme;
        }

        public final void setMobileAppPromptTheme$qualtrics_productionRelease(MobileAppPromptTheme mobileAppPromptTheme) {
            Intrinsics.checkNotNullParameter(mobileAppPromptTheme, "<set-?>");
            this.mobileAppPromptTheme = mobileAppPromptTheme;
        }

        /* JADX INFO: renamed from: getEmbeddedAppFeedbackTheme$qualtrics_productionRelease, reason: from getter */
        public final EmbeddedAppFeedbackTheme getEmbeddedAppFeedbackTheme() {
            return this.embeddedAppFeedbackTheme;
        }

        public final void setEmbeddedAppFeedbackTheme$qualtrics_productionRelease(EmbeddedAppFeedbackTheme embeddedAppFeedbackTheme) {
            Intrinsics.checkNotNullParameter(embeddedAppFeedbackTheme, "<set-?>");
            this.embeddedAppFeedbackTheme = embeddedAppFeedbackTheme;
        }

        public final Builder setMobileAppPromptTheme(MobileAppPromptTheme mobileAppPromptTheme) {
            Intrinsics.checkNotNullParameter(mobileAppPromptTheme, "mobileAppPromptTheme");
            this.mobileAppPromptTheme = mobileAppPromptTheme;
            return this;
        }

        public final Builder setEmbeddedAppFeedbackTheme(EmbeddedAppFeedbackTheme embeddedAppFeedbackTheme) {
            Intrinsics.checkNotNullParameter(embeddedAppFeedbackTheme, "embeddedAppFeedbackTheme");
            this.embeddedAppFeedbackTheme = embeddedAppFeedbackTheme;
            return this;
        }

        public final QualtricsTheme build() {
            return new QualtricsTheme(this, null);
        }
    }

    /* JADX INFO: compiled from: QualtricsTheme.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, m5598d2 = {"Lcom/qualtrics/digital/QualtricsTheme$Companion;", "", "()V", "buildDefaultQualtricsTheme", "Lcom/qualtrics/digital/QualtricsTheme;", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final QualtricsTheme buildDefaultQualtricsTheme() {
            return new Builder().build();
        }
    }
}
