package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NATIONAL_ID' uses external variables
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001c\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScannableDocument;", "", "configKey", "", "ratio", "", "(Ljava/lang/String;ILjava/lang/String;F)V", "getConfigKey", "()Ljava/lang/String;", "getRatio", "()F", "PASSPORT", "DRIVING_LICENCE", "NATIONAL_ID", "STATE_ID", "MYKAD", "AADHAAR", "PAN", "SSS_ID", "POSTAL_ID", "RESIDENCE_PERMIT", "PROFESSIONAL_ID", "VOTER_ID", "HEALTH_CARD_QUEBEC", "NEXUS_CARD", "PHILSYS_ID", "UMID", "YOUNG_SCOT_CARD", "INDIAN_STATUS_CARD", "CITIZEN_CARD", "POST_OFFICE_PASS_CARD", "HEALTH_CARD", "UNDEFINED", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ScannableDocument {
    public static final ScannableDocument AADHAAR;
    public static final ScannableDocument CITIZEN_CARD;
    public static final ScannableDocument HEALTH_CARD;
    public static final ScannableDocument HEALTH_CARD_QUEBEC;
    public static final ScannableDocument INDIAN_STATUS_CARD;
    public static final ScannableDocument MYKAD;
    public static final ScannableDocument NATIONAL_ID;
    public static final ScannableDocument NEXUS_CARD;
    public static final ScannableDocument PAN;
    public static final ScannableDocument PHILSYS_ID;
    public static final ScannableDocument POSTAL_ID;
    public static final ScannableDocument POST_OFFICE_PASS_CARD;
    public static final ScannableDocument PROFESSIONAL_ID;
    public static final ScannableDocument RESIDENCE_PERMIT;
    public static final ScannableDocument SSS_ID;
    public static final ScannableDocument STATE_ID;
    public static final ScannableDocument UMID;
    public static final ScannableDocument UNDEFINED;
    public static final ScannableDocument VOTER_ID;
    public static final ScannableDocument YOUNG_SCOT_CARD;
    private final String configKey;
    private final float ratio;
    public static final ScannableDocument PASSPORT = new ScannableDocument("PASSPORT", 0, "PASSPORT", 0.68f);
    public static final ScannableDocument DRIVING_LICENCE = new ScannableDocument("DRIVING_LICENCE", 1, "DRIVING_LICENCE", 0.0f, 2, null);
    private static final /* synthetic */ ScannableDocument[] $VALUES = $values();

    private static final /* synthetic */ ScannableDocument[] $values() {
        return new ScannableDocument[]{PASSPORT, DRIVING_LICENCE, NATIONAL_ID, STATE_ID, MYKAD, AADHAAR, PAN, SSS_ID, POSTAL_ID, RESIDENCE_PERMIT, PROFESSIONAL_ID, VOTER_ID, HEALTH_CARD_QUEBEC, NEXUS_CARD, PHILSYS_ID, UMID, YOUNG_SCOT_CARD, INDIAN_STATUS_CARD, CITIZEN_CARD, POST_OFFICE_PASS_CARD, HEALTH_CARD, UNDEFINED};
    }

    static {
        int i = 2;
        NATIONAL_ID = new ScannableDocument("NATIONAL_ID", i, "NATIONAL_ID", 0.0f, 2, null);
        int i2 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        float f = 0.0f;
        STATE_ID = new ScannableDocument("STATE_ID", 3, "STATE_ID", f, i2, defaultConstructorMarker);
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        float f2 = 0.0f;
        MYKAD = new ScannableDocument("MYKAD", 4, "MYKAD", f2, i, defaultConstructorMarker2);
        AADHAAR = new ScannableDocument("AADHAAR", 5, "AADHAAR", f, i2, defaultConstructorMarker);
        PAN = new ScannableDocument("PAN", 6, "PAN", f2, i, defaultConstructorMarker2);
        SSS_ID = new ScannableDocument("SSS_ID", 7, "SSS_ID", f, i2, defaultConstructorMarker);
        POSTAL_ID = new ScannableDocument("POSTAL_ID", 8, "POSTAL_ID", f2, i, defaultConstructorMarker2);
        RESIDENCE_PERMIT = new ScannableDocument("RESIDENCE_PERMIT", 9, "RESIDENCE_PERMIT", f, i2, defaultConstructorMarker);
        PROFESSIONAL_ID = new ScannableDocument("PROFESSIONAL_ID", 10, "PROFESSIONAL_ID", f2, i, defaultConstructorMarker2);
        VOTER_ID = new ScannableDocument("VOTER_ID", 11, "VOTER_ID", f, i2, defaultConstructorMarker);
        HEALTH_CARD_QUEBEC = new ScannableDocument("HEALTH_CARD_QUEBEC", 12, "HEALTH_CARD_QUEBEC", f2, i, defaultConstructorMarker2);
        NEXUS_CARD = new ScannableDocument("NEXUS_CARD", 13, "NEXUS_CARD", f, i2, defaultConstructorMarker);
        PHILSYS_ID = new ScannableDocument("PHILSYS_ID", 14, "PHILSYS_ID", f2, i, defaultConstructorMarker2);
        UMID = new ScannableDocument("UMID", 15, "UMID", f, i2, defaultConstructorMarker);
        YOUNG_SCOT_CARD = new ScannableDocument("YOUNG_SCOT_CARD", 16, "YOUNG_SCOT_CARD", f2, i, defaultConstructorMarker2);
        INDIAN_STATUS_CARD = new ScannableDocument("INDIAN_STATUS_CARD", 17, "INDIAN_STATUS_CARD", f, i2, defaultConstructorMarker);
        CITIZEN_CARD = new ScannableDocument("CITIZEN_CARD", 18, "CITIZEN_CARD", f2, i, defaultConstructorMarker2);
        POST_OFFICE_PASS_CARD = new ScannableDocument("POST_OFFICE_PASS_CARD", 19, "POST_OFFICE_PASS_CARD", f, i2, defaultConstructorMarker);
        HEALTH_CARD = new ScannableDocument("HEALTH_CARD", 20, "HEALTH_CARD", f2, i, defaultConstructorMarker2);
        UNDEFINED = new ScannableDocument("UNDEFINED", 21, "UNDEFINED", f, i2, defaultConstructorMarker);
    }

    private ScannableDocument(String str, int i, String str2, float f) {
        this.configKey = str2;
        this.ratio = f;
    }

    public static ScannableDocument valueOf(String str) {
        return (ScannableDocument) Enum.valueOf(ScannableDocument.class, str);
    }

    public static ScannableDocument[] values() {
        return (ScannableDocument[]) $VALUES.clone();
    }

    public final String getConfigKey() {
        return this.configKey;
    }

    public final float getRatio() {
        return this.ratio;
    }

    /* synthetic */ ScannableDocument(String str, int i, String str2, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, (i2 & 2) != 0 ? 0.6306075f : f);
    }
}
