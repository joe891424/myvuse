package com.yoti.mobile.android.documentcapture.p055id.domain.model;

import com.newrelic.agent.android.agentdata.HexAttribute;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.TextExtractionException;
import com.yoti.mobile.android.remote.debug.RemoteDebugPreferencesKt;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsFeatureError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÂ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/model/TextExtractionError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsFeatureError;", "type", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/TextExtractionError$TextExtractionErrorTypeEntity;", "isRetryPossible", "", "error", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionException;", "(Lcom/yoti/mobile/android/documentcapture/id/domain/model/TextExtractionError$TextExtractionErrorTypeEntity;ZLcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionException;)V", "()Z", "getType", "()Lcom/yoti/mobile/android/documentcapture/id/domain/model/TextExtractionError$TextExtractionErrorTypeEntity;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "TextExtractionErrorCauseType", "TextExtractionErrorTypeEntity", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class TextExtractionError extends YotiDocsFeatureError {
    private final TextExtractionException error;
    private final boolean isRetryPossible;
    private final TextExtractionErrorTypeEntity type;

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/model/TextExtractionError$TextExtractionErrorCauseType;", "", "(Ljava/lang/String;I)V", "RECLASSIFICATION", "EXPIRATION", "QUALITY", "UNKNOWN", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum TextExtractionErrorCauseType {
        RECLASSIFICATION,
        EXPIRATION,
        QUALITY,
        UNKNOWN
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DUPLICATED' uses external variables
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
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/model/TextExtractionError$TextExtractionErrorTypeEntity;", "", HexAttribute.HEX_ATTR_CAUSE, "Lcom/yoti/mobile/android/documentcapture/id/domain/model/TextExtractionError$TextExtractionErrorCauseType;", "(Ljava/lang/String;ILcom/yoti/mobile/android/documentcapture/id/domain/model/TextExtractionError$TextExtractionErrorCauseType;)V", "getCause", "()Lcom/yoti/mobile/android/documentcapture/id/domain/model/TextExtractionError$TextExtractionErrorCauseType;", "DUPLICATED", "INVALID", "WRONG_PAGES", RemoteDebugPreferencesKt.DEBUG_OPTIONS_REMOTE_BEHAVIOUR_EXPIRED, "NO_DOCUMENT", "FACE_NOT_FOUND", "INCORRECTLY_FRAMED", "SCREEN_CAPTURE", "BLURRY", "GLARE_OBSTRUCTION", "NO_COLOR", "UNABLE_TO_READ_BARCODE", "MISSING_BACK_PAGE", "NO_BARCODE", "UNKNOWN", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class TextExtractionErrorTypeEntity {
        private static final /* synthetic */ TextExtractionErrorTypeEntity[] $VALUES;
        public static final TextExtractionErrorTypeEntity BLURRY;
        public static final TextExtractionErrorTypeEntity DUPLICATED;
        public static final TextExtractionErrorTypeEntity EXPIRED;
        public static final TextExtractionErrorTypeEntity FACE_NOT_FOUND;
        public static final TextExtractionErrorTypeEntity GLARE_OBSTRUCTION;
        public static final TextExtractionErrorTypeEntity INCORRECTLY_FRAMED;
        public static final TextExtractionErrorTypeEntity INVALID;
        public static final TextExtractionErrorTypeEntity MISSING_BACK_PAGE;
        public static final TextExtractionErrorTypeEntity NO_BARCODE;
        public static final TextExtractionErrorTypeEntity NO_COLOR;
        public static final TextExtractionErrorTypeEntity NO_DOCUMENT;
        public static final TextExtractionErrorTypeEntity SCREEN_CAPTURE;
        public static final TextExtractionErrorTypeEntity UNABLE_TO_READ_BARCODE;
        public static final TextExtractionErrorTypeEntity UNKNOWN;
        public static final TextExtractionErrorTypeEntity WRONG_PAGES;
        private final TextExtractionErrorCauseType cause;

        private static final /* synthetic */ TextExtractionErrorTypeEntity[] $values() {
            return new TextExtractionErrorTypeEntity[]{DUPLICATED, INVALID, WRONG_PAGES, EXPIRED, NO_DOCUMENT, FACE_NOT_FOUND, INCORRECTLY_FRAMED, SCREEN_CAPTURE, BLURRY, GLARE_OBSTRUCTION, NO_COLOR, UNABLE_TO_READ_BARCODE, MISSING_BACK_PAGE, NO_BARCODE, UNKNOWN};
        }

        static {
            TextExtractionErrorCauseType textExtractionErrorCauseType = TextExtractionErrorCauseType.RECLASSIFICATION;
            DUPLICATED = new TextExtractionErrorTypeEntity("DUPLICATED", 0, textExtractionErrorCauseType);
            INVALID = new TextExtractionErrorTypeEntity("INVALID", 1, textExtractionErrorCauseType);
            WRONG_PAGES = new TextExtractionErrorTypeEntity("WRONG_PAGES", 2, textExtractionErrorCauseType);
            EXPIRED = new TextExtractionErrorTypeEntity(RemoteDebugPreferencesKt.DEBUG_OPTIONS_REMOTE_BEHAVIOUR_EXPIRED, 3, TextExtractionErrorCauseType.EXPIRATION);
            TextExtractionErrorCauseType textExtractionErrorCauseType2 = TextExtractionErrorCauseType.QUALITY;
            NO_DOCUMENT = new TextExtractionErrorTypeEntity("NO_DOCUMENT", 4, textExtractionErrorCauseType2);
            FACE_NOT_FOUND = new TextExtractionErrorTypeEntity("FACE_NOT_FOUND", 5, textExtractionErrorCauseType2);
            INCORRECTLY_FRAMED = new TextExtractionErrorTypeEntity("INCORRECTLY_FRAMED", 6, textExtractionErrorCauseType2);
            SCREEN_CAPTURE = new TextExtractionErrorTypeEntity("SCREEN_CAPTURE", 7, textExtractionErrorCauseType2);
            BLURRY = new TextExtractionErrorTypeEntity("BLURRY", 8, textExtractionErrorCauseType2);
            GLARE_OBSTRUCTION = new TextExtractionErrorTypeEntity("GLARE_OBSTRUCTION", 9, textExtractionErrorCauseType2);
            NO_COLOR = new TextExtractionErrorTypeEntity("NO_COLOR", 10, textExtractionErrorCauseType2);
            UNABLE_TO_READ_BARCODE = new TextExtractionErrorTypeEntity("UNABLE_TO_READ_BARCODE", 11, textExtractionErrorCauseType2);
            MISSING_BACK_PAGE = new TextExtractionErrorTypeEntity("MISSING_BACK_PAGE", 12, textExtractionErrorCauseType2);
            NO_BARCODE = new TextExtractionErrorTypeEntity("NO_BARCODE", 13, textExtractionErrorCauseType2);
            UNKNOWN = new TextExtractionErrorTypeEntity("UNKNOWN", 14, null, 1, null);
            $VALUES = $values();
        }

        private TextExtractionErrorTypeEntity(String str, int i, TextExtractionErrorCauseType textExtractionErrorCauseType) {
            this.cause = textExtractionErrorCauseType;
        }

        public static TextExtractionErrorTypeEntity valueOf(String str) {
            return (TextExtractionErrorTypeEntity) Enum.valueOf(TextExtractionErrorTypeEntity.class, str);
        }

        public static TextExtractionErrorTypeEntity[] values() {
            return (TextExtractionErrorTypeEntity[]) $VALUES.clone();
        }

        public final TextExtractionErrorCauseType getCause() {
            return this.cause;
        }

        /* synthetic */ TextExtractionErrorTypeEntity(String str, int i, TextExtractionErrorCauseType textExtractionErrorCauseType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, (i2 & 1) != 0 ? TextExtractionErrorCauseType.UNKNOWN : textExtractionErrorCauseType);
        }
    }

    public /* synthetic */ TextExtractionError(TextExtractionErrorTypeEntity textExtractionErrorTypeEntity, boolean z, TextExtractionException textExtractionException, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? TextExtractionErrorTypeEntity.UNKNOWN : textExtractionErrorTypeEntity, (i & 2) != 0 ? true : z, textExtractionException);
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final TextExtractionException getError() {
        return this.error;
    }

    public static /* synthetic */ TextExtractionError copy$default(TextExtractionError textExtractionError, TextExtractionErrorTypeEntity textExtractionErrorTypeEntity, boolean z, TextExtractionException textExtractionException, int i, Object obj) {
        if ((i & 1) != 0) {
            textExtractionErrorTypeEntity = textExtractionError.type;
        }
        if ((i & 2) != 0) {
            z = textExtractionError.isRetryPossible;
        }
        if ((i & 4) != 0) {
            textExtractionException = textExtractionError.error;
        }
        return textExtractionError.copy(textExtractionErrorTypeEntity, z, textExtractionException);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TextExtractionErrorTypeEntity getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsRetryPossible() {
        return this.isRetryPossible;
    }

    public final TextExtractionError copy(TextExtractionErrorTypeEntity type, boolean isRetryPossible, TextExtractionException error) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(error, "error");
        return new TextExtractionError(type, isRetryPossible, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextExtractionError)) {
            return false;
        }
        TextExtractionError textExtractionError = (TextExtractionError) other;
        return this.type == textExtractionError.type && this.isRetryPossible == textExtractionError.isRetryPossible && Intrinsics.areEqual(this.error, textExtractionError.error);
    }

    public final TextExtractionErrorTypeEntity getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        boolean z = this.isRetryPossible;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + this.error.hashCode();
    }

    public final boolean isRetryPossible() {
        return this.isRetryPossible;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "TextExtractionError(type=" + this.type + ", isRetryPossible=" + this.isRetryPossible + ", error=" + this.error + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextExtractionError(TextExtractionErrorTypeEntity type, boolean z, TextExtractionException error) {
        super(error, z);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(error, "error");
        this.type = type;
        this.isRetryPossible = z;
        this.error = error;
    }
}
