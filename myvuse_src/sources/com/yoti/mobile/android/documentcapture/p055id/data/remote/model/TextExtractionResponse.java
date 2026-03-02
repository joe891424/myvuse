package com.yoti.mobile.android.documentcapture.p055id.data.remote.model;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.yoti.mobile.android.remote.debug.RemoteDebugPreferencesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0010\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\bR\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\t¨\u0006\u001f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse;", "", NotificationCompat.CATEGORY_RECOMMENDATION, "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation;", "retriesRemaining", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$RetriesRemaining;", "(Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation;Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$RetriesRemaining;)V", "isResourceBlocked", "", "()Z", "isResourceValid", "getRecommendation", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation;", "getRetriesRemaining", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$RetriesRemaining;", "shouldRetry", "getShouldRetry", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "validate", "", "isSessionFeedbackEnabled", "Recommendation", "RetriesRemaining", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class TextExtractionResponse {

    @SerializedName(NotificationCompat.CATEGORY_RECOMMENDATION)
    private final Recommendation recommendation;

    @SerializedName("attempts_remaining")
    private final RetriesRemaining retriesRemaining;

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$RetriesRemaining;", "", "generic", "", "reclassification", "(II)V", "getGeneric", "()I", "isRetryPossible", "", "()Z", "getReclassification", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class RetriesRemaining {

        @SerializedName("GENERIC")
        private final int generic;

        @SerializedName("RECLASSIFICATION")
        private final int reclassification;

        public RetriesRemaining(int i, int i2) {
            this.generic = i;
            this.reclassification = i2;
        }

        public static /* synthetic */ RetriesRemaining copy$default(RetriesRemaining retriesRemaining, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = retriesRemaining.generic;
            }
            if ((i3 & 2) != 0) {
                i2 = retriesRemaining.reclassification;
            }
            return retriesRemaining.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getGeneric() {
            return this.generic;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getReclassification() {
            return this.reclassification;
        }

        public final RetriesRemaining copy(int generic, int reclassification) {
            return new RetriesRemaining(generic, reclassification);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RetriesRemaining)) {
                return false;
            }
            RetriesRemaining retriesRemaining = (RetriesRemaining) other;
            return this.generic == retriesRemaining.generic && this.reclassification == retriesRemaining.reclassification;
        }

        public final int getGeneric() {
            return this.generic;
        }

        public final int getReclassification() {
            return this.reclassification;
        }

        public int hashCode() {
            return (Integer.hashCode(this.generic) * 31) + Integer.hashCode(this.reclassification);
        }

        public final boolean isRetryPossible() {
            return this.generic > 0 && this.reclassification > 0;
        }

        public String toString() {
            return "RetriesRemaining(generic=" + this.generic + ", reclassification=" + this.reclassification + ')';
        }
    }

    public TextExtractionResponse(Recommendation recommendation, RetriesRemaining retriesRemaining) {
        Intrinsics.checkNotNullParameter(recommendation, "recommendation");
        Intrinsics.checkNotNullParameter(retriesRemaining, "retriesRemaining");
        this.recommendation = recommendation;
        this.retriesRemaining = retriesRemaining;
    }

    public static /* synthetic */ TextExtractionResponse copy$default(TextExtractionResponse textExtractionResponse, Recommendation recommendation, RetriesRemaining retriesRemaining, int i, Object obj) {
        if ((i & 1) != 0) {
            recommendation = textExtractionResponse.recommendation;
        }
        if ((i & 2) != 0) {
            retriesRemaining = textExtractionResponse.retriesRemaining;
        }
        return textExtractionResponse.copy(recommendation, retriesRemaining);
    }

    private final boolean getShouldRetry() {
        return this.recommendation.getType() != Recommendation.RecommendationType.PROGRESS && this.retriesRemaining.isRetryPossible();
    }

    private final boolean isResourceBlocked() {
        return (isResourceValid() || this.retriesRemaining.isRetryPossible()) ? false : true;
    }

    private final boolean isResourceValid() {
        return !this.recommendation.getReason().getDetail().getIsReclassificationError() ? this.recommendation.getType() == Recommendation.RecommendationType.MUST_TRY_AGAIN : this.recommendation.getType() != Recommendation.RecommendationType.PROGRESS;
    }

    public static /* synthetic */ void validate$default(TextExtractionResponse textExtractionResponse, boolean z, int i, Object obj) throws TextExtractionException {
        if ((i & 1) != 0) {
            z = true;
        }
        textExtractionResponse.validate(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Recommendation getRecommendation() {
        return this.recommendation;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RetriesRemaining getRetriesRemaining() {
        return this.retriesRemaining;
    }

    public final TextExtractionResponse copy(Recommendation recommendation, RetriesRemaining retriesRemaining) {
        Intrinsics.checkNotNullParameter(recommendation, "recommendation");
        Intrinsics.checkNotNullParameter(retriesRemaining, "retriesRemaining");
        return new TextExtractionResponse(recommendation, retriesRemaining);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextExtractionResponse)) {
            return false;
        }
        TextExtractionResponse textExtractionResponse = (TextExtractionResponse) other;
        return Intrinsics.areEqual(this.recommendation, textExtractionResponse.recommendation) && Intrinsics.areEqual(this.retriesRemaining, textExtractionResponse.retriesRemaining);
    }

    public final Recommendation getRecommendation() {
        return this.recommendation;
    }

    public final RetriesRemaining getRetriesRemaining() {
        return this.retriesRemaining;
    }

    public int hashCode() {
        return (this.recommendation.hashCode() * 31) + this.retriesRemaining.hashCode();
    }

    public String toString() {
        return "TextExtractionResponse(recommendation=" + this.recommendation + ", retriesRemaining=" + this.retriesRemaining + ')';
    }

    public final void validate(boolean isSessionFeedbackEnabled) throws TextExtractionException {
        if (isSessionFeedbackEnabled) {
            if (getShouldRetry() || isResourceBlocked()) {
                throw new TextExtractionException(getShouldRetry(), this.recommendation.getReason().getDetail());
            }
        }
    }

    @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÂ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation;", "", "_type", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$RecommendationType;", "_reason", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason;", "(Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$RecommendationType;Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason;)V", AnalyticsAttribute.APP_EXIT_REASON_ATTRIBUTE, "getReason", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason;", "type", "getType", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$RecommendationType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Reason", "RecommendationType", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Recommendation {

        @SerializedName(AnalyticsAttribute.APP_EXIT_REASON_ATTRIBUTE)
        private final Reason _reason;

        @SerializedName("value")
        private final RecommendationType _type;

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$RecommendationType;", "", "(Ljava/lang/String;I)V", "PROGRESS", "SHOULD_TRY_AGAIN", "MUST_TRY_AGAIN", "UNKNOWN", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public enum RecommendationType {
            PROGRESS,
            SHOULD_TRY_AGAIN,
            MUST_TRY_AGAIN,
            UNKNOWN
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Recommendation() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public Recommendation(RecommendationType recommendationType, Reason reason) {
            this._type = recommendationType;
            this._reason = reason;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final RecommendationType get_type() {
            return this._type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        private final Reason get_reason() {
            return this._reason;
        }

        public static /* synthetic */ Recommendation copy$default(Recommendation recommendation, RecommendationType recommendationType, Reason reason, int i, Object obj) {
            if ((i & 1) != 0) {
                recommendationType = recommendation._type;
            }
            if ((i & 2) != 0) {
                reason = recommendation._reason;
            }
            return recommendation.copy(recommendationType, reason);
        }

        public final Recommendation copy(RecommendationType _type, Reason _reason) {
            return new Recommendation(_type, _reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Recommendation)) {
                return false;
            }
            Recommendation recommendation = (Recommendation) other;
            return this._type == recommendation._type && Intrinsics.areEqual(this._reason, recommendation._reason);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Reason getReason() {
            Reason reason = this._reason;
            if (reason != null) {
                return reason;
            }
            return new Reason(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public final RecommendationType getType() {
            RecommendationType recommendationType = this._type;
            return recommendationType == null ? RecommendationType.UNKNOWN : recommendationType;
        }

        public int hashCode() {
            RecommendationType recommendationType = this._type;
            int iHashCode = (recommendationType == null ? 0 : recommendationType.hashCode()) * 31;
            Reason reason = this._reason;
            return iHashCode + (reason != null ? reason.hashCode() : 0);
        }

        public String toString() {
            return "Recommendation(_type=" + this._type + ", _reason=" + this._reason + ')';
        }

        @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÂ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason;", "", "_type", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason$ReasonType;", "_detail", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason$DetailType;", "(Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason$ReasonType;Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason$DetailType;)V", "detail", "getDetail", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason$DetailType;", "type", "getType", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason$ReasonType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "DetailType", "ReasonType", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class Reason {

            @SerializedName("detail")
            private final DetailType _detail;

            @SerializedName("value")
            private final ReasonType _type;

            /* JADX WARN: Enum visitor error
            jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'FACE_NOT_FOUND' uses external variables
            	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
            	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
            	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
            	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
            	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
            	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
            	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
            	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
            	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
             */
            /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
            @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason$DetailType;", "", "isReclassificationError", "", "(Ljava/lang/String;IZ)V", "()Z", "WRONG_DOCUMENT_UPLOADED", "UNSUPPORTED_DOCUMENT", "WRONG_NUMBER_OF_PAGES", "DUPLICATED_DOCUMENT", "DOCUMENT_IS_EXPIRED", "NO_DOCUMENT", "FACE_NOT_FOUND", "OUT_OF_BOUNDS", "BAD_ANGLE", "SCREEN_CAPTURE", "OUT_OF_FOCUS", "LOW_RESOLUTION", "GLARE_OBSTRUCTION", "NO_COLOR", "UNABLE_TO_READ_BARCODE", "MISSING_BACK_PAGE", "NO_BARCODE", "UNKNOWN", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class DetailType {
                public static final DetailType BAD_ANGLE;
                public static final DetailType FACE_NOT_FOUND;
                public static final DetailType GLARE_OBSTRUCTION;
                public static final DetailType LOW_RESOLUTION;
                public static final DetailType MISSING_BACK_PAGE;
                public static final DetailType NO_BARCODE;
                public static final DetailType NO_COLOR;
                public static final DetailType OUT_OF_BOUNDS;
                public static final DetailType OUT_OF_FOCUS;
                public static final DetailType SCREEN_CAPTURE;
                public static final DetailType UNABLE_TO_READ_BARCODE;
                public static final DetailType UNKNOWN;
                private final boolean isReclassificationError;
                public static final DetailType WRONG_DOCUMENT_UPLOADED = new DetailType("WRONG_DOCUMENT_UPLOADED", 0, true);
                public static final DetailType UNSUPPORTED_DOCUMENT = new DetailType("UNSUPPORTED_DOCUMENT", 1, true);
                public static final DetailType WRONG_NUMBER_OF_PAGES = new DetailType("WRONG_NUMBER_OF_PAGES", 2, true);
                public static final DetailType DUPLICATED_DOCUMENT = new DetailType("DUPLICATED_DOCUMENT", 3, true);
                public static final DetailType DOCUMENT_IS_EXPIRED = new DetailType("DOCUMENT_IS_EXPIRED", 4, false, 1, null);
                public static final DetailType NO_DOCUMENT = new DetailType("NO_DOCUMENT", 5, false, 1, null);
                private static final /* synthetic */ DetailType[] $VALUES = $values();

                private static final /* synthetic */ DetailType[] $values() {
                    return new DetailType[]{WRONG_DOCUMENT_UPLOADED, UNSUPPORTED_DOCUMENT, WRONG_NUMBER_OF_PAGES, DUPLICATED_DOCUMENT, DOCUMENT_IS_EXPIRED, NO_DOCUMENT, FACE_NOT_FOUND, OUT_OF_BOUNDS, BAD_ANGLE, SCREEN_CAPTURE, OUT_OF_FOCUS, LOW_RESOLUTION, GLARE_OBSTRUCTION, NO_COLOR, UNABLE_TO_READ_BARCODE, MISSING_BACK_PAGE, NO_BARCODE, UNKNOWN};
                }

                static {
                    int i = 1;
                    DefaultConstructorMarker defaultConstructorMarker = null;
                    boolean z = false;
                    FACE_NOT_FOUND = new DetailType("FACE_NOT_FOUND", 6, z, i, defaultConstructorMarker);
                    int i2 = 1;
                    DefaultConstructorMarker defaultConstructorMarker2 = null;
                    boolean z2 = false;
                    OUT_OF_BOUNDS = new DetailType("OUT_OF_BOUNDS", 7, z2, i2, defaultConstructorMarker2);
                    BAD_ANGLE = new DetailType("BAD_ANGLE", 8, z, i, defaultConstructorMarker);
                    SCREEN_CAPTURE = new DetailType("SCREEN_CAPTURE", 9, z2, i2, defaultConstructorMarker2);
                    OUT_OF_FOCUS = new DetailType("OUT_OF_FOCUS", 10, z, i, defaultConstructorMarker);
                    LOW_RESOLUTION = new DetailType("LOW_RESOLUTION", 11, z2, i2, defaultConstructorMarker2);
                    GLARE_OBSTRUCTION = new DetailType("GLARE_OBSTRUCTION", 12, z, i, defaultConstructorMarker);
                    NO_COLOR = new DetailType("NO_COLOR", 13, z2, i2, defaultConstructorMarker2);
                    UNABLE_TO_READ_BARCODE = new DetailType("UNABLE_TO_READ_BARCODE", 14, z, i, defaultConstructorMarker);
                    MISSING_BACK_PAGE = new DetailType("MISSING_BACK_PAGE", 15, z2, i2, defaultConstructorMarker2);
                    NO_BARCODE = new DetailType("NO_BARCODE", 16, z, i, defaultConstructorMarker);
                    UNKNOWN = new DetailType("UNKNOWN", 17, z2, i2, defaultConstructorMarker2);
                }

                private DetailType(String str, int i, boolean z) {
                    this.isReclassificationError = z;
                }

                public static DetailType valueOf(String str) {
                    return (DetailType) Enum.valueOf(DetailType.class, str);
                }

                public static DetailType[] values() {
                    return (DetailType[]) $VALUES.clone();
                }

                /* JADX INFO: renamed from: isReclassificationError, reason: from getter */
                public final boolean getIsReclassificationError() {
                    return this.isReclassificationError;
                }

                /* synthetic */ DetailType(String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                    this(str, i, (i2 & 1) != 0 ? false : z);
                }
            }

            @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason$ReasonType;", "", "(Ljava/lang/String;I)V", "QUALITY", "USER_ERROR", RemoteDebugPreferencesKt.DEBUG_OPTIONS_REMOTE_BEHAVIOUR_ERROR, "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
            public enum ReasonType {
                QUALITY,
                USER_ERROR,
                ERROR
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Reason() {
                this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }

            public Reason(ReasonType reasonType, DetailType detailType) {
                this._type = reasonType;
                this._detail = detailType;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            private final ReasonType get_type() {
                return this._type;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            private final DetailType get_detail() {
                return this._detail;
            }

            public static /* synthetic */ Reason copy$default(Reason reason, ReasonType reasonType, DetailType detailType, int i, Object obj) {
                if ((i & 1) != 0) {
                    reasonType = reason._type;
                }
                if ((i & 2) != 0) {
                    detailType = reason._detail;
                }
                return reason.copy(reasonType, detailType);
            }

            public final Reason copy(ReasonType _type, DetailType _detail) {
                return new Reason(_type, _detail);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Reason)) {
                    return false;
                }
                Reason reason = (Reason) other;
                return this._type == reason._type && this._detail == reason._detail;
            }

            public final DetailType getDetail() {
                DetailType detailType = this._detail;
                return detailType == null ? DetailType.UNKNOWN : detailType;
            }

            public final ReasonType getType() {
                ReasonType reasonType = this._type;
                return reasonType == null ? ReasonType.ERROR : reasonType;
            }

            public int hashCode() {
                ReasonType reasonType = this._type;
                int iHashCode = (reasonType == null ? 0 : reasonType.hashCode()) * 31;
                DetailType detailType = this._detail;
                return iHashCode + (detailType != null ? detailType.hashCode() : 0);
            }

            public String toString() {
                return "Reason(_type=" + this._type + ", _detail=" + this._detail + ')';
            }

            public /* synthetic */ Reason(ReasonType reasonType, DetailType detailType, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : reasonType, (i & 2) != 0 ? null : detailType);
            }
        }

        public /* synthetic */ Recommendation(RecommendationType recommendationType, Reason reason, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : recommendationType, (i & 2) != 0 ? null : reason);
        }
    }
}
