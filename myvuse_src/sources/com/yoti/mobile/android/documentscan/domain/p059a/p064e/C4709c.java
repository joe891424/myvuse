package com.yoti.mobile.android.documentscan.domain.p059a.p064e;

import com.microblink.entities.recognizers.blinkid.mrtd.MrtdDocumentType;
import com.microblink.entities.recognizers.blinkid.mrtd.MrzResult;
import com.microblink.entities.recognizers.blinkid.passport.PassportRecognizer;
import com.microblink.results.date.Date;
import com.yoti.mobile.android.documentscan.domain.AbstractC4696a;
import com.yoti.mobile.android.documentscan.domain.p059a.p063d.C4704b;
import com.yoti.mobile.android.documentscan.domain.utils.BlinkDateUtils;
import com.yoti.mobile.android.documentscan.model.result.Address;
import com.yoti.mobile.android.documentscan.model.result.Country;
import com.yoti.mobile.android.documentscan.model.result.DateResult;
import com.yoti.mobile.android.documentscan.model.result.DocumentData;
import com.yoti.mobile.android.documentscan.model.result.Holder;
import com.yoti.mobile.android.documentscan.model.result.MrzData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.a.e.c */
/* JADX INFO: loaded from: classes5.dex */
public final class C4709c extends AbstractC4696a<PassportRecognizer.Result> {

    /* JADX INFO: renamed from: a */
    private final BlinkDateUtils f6877a;

    /* JADX INFO: renamed from: b */
    private final C4704b f6878b;

    public C4709c(BlinkDateUtils blinkDateUtils, C4704b coreDocumentTypeMapper) {
        Intrinsics.checkParameterIsNotNull(blinkDateUtils, "blinkDateUtils");
        Intrinsics.checkParameterIsNotNull(coreDocumentTypeMapper, "coreDocumentTypeMapper");
        this.f6877a = blinkDateUtils;
        this.f6878b = coreDocumentTypeMapper;
    }

    /* JADX INFO: renamed from: a */
    private final Country m4762a(String str) {
        return new Country(str);
    }

    /* JADX INFO: renamed from: a */
    private final DateResult m4763a(Date date) {
        if (date != null) {
            return new DateResult(this.f6877a.m4782a(date));
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:
    
        if (r3.equals("P") == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0034, code lost:
    
        if (r3.equals("O") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        if (r3.equals("M") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0046, code lost:
    
        if (r3.equals("H") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0051, code lost:
    
        if (r3.equals("F") != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
    
        if (r3.equals("<") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0065, code lost:
    
        if (r3.equals("0") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
    
        return com.yoti.mobile.android.documentscan.model.result.Gender.MALE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:?, code lost:
    
        return com.yoti.mobile.android.documentscan.model.result.Gender.FEMALE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
    
        return com.yoti.mobile.android.documentscan.model.result.Gender.UNSPECIFIED;
     */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.yoti.mobile.android.documentscan.model.result.Gender m4764b(java.lang.String r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L4
            goto L6a
        L4:
            int r0 = r3.hashCode()
            r1 = 48
            if (r0 == r1) goto L5f
            r1 = 60
            if (r0 == r1) goto L56
            r1 = 70
            if (r0 == r1) goto L4b
            r1 = 72
            if (r0 == r1) goto L40
            r1 = 77
            if (r0 == r1) goto L37
            r1 = 79
            if (r0 == r1) goto L2e
            r1 = 80
            if (r0 == r1) goto L25
            goto L6a
        L25:
            java.lang.String r0 = "P"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L6a
            goto L53
        L2e:
            java.lang.String r0 = "O"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L6a
            goto L67
        L37:
            java.lang.String r0 = "M"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L6a
            goto L48
        L40:
            java.lang.String r0 = "H"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L6a
        L48:
            com.yoti.mobile.android.documentscan.model.result.Gender r3 = com.yoti.mobile.android.documentscan.model.result.Gender.MALE
            goto L6b
        L4b:
            java.lang.String r0 = "F"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L6a
        L53:
            com.yoti.mobile.android.documentscan.model.result.Gender r3 = com.yoti.mobile.android.documentscan.model.result.Gender.FEMALE
            goto L6b
        L56:
            java.lang.String r0 = "<"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L6a
            goto L67
        L5f:
            java.lang.String r0 = "0"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L6a
        L67:
            com.yoti.mobile.android.documentscan.model.result.Gender r3 = com.yoti.mobile.android.documentscan.model.result.Gender.UNSPECIFIED
            goto L6b
        L6a:
            r3 = 0
        L6b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentscan.domain.p059a.p064e.C4709c.m4764b(java.lang.String):com.yoti.mobile.android.documentscan.model.result.Gender");
    }

    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Address mo4706a(PassportRecognizer.Result result) {
        return null;
    }

    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DocumentData mo4707b(PassportRecognizer.Result result) {
        MrzResult mrzResult;
        if (result == null || (mrzResult = result.getMrzResult()) == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(mrzResult, "mrzResult");
        com.microblink.results.date.DateResult dateOfExpiry = mrzResult.getDateOfExpiry();
        Intrinsics.checkExpressionValueIsNotNull(dateOfExpiry, "mrzResult.dateOfExpiry");
        DateResult dateResultM4763a = m4763a(dateOfExpiry.getDate());
        Country countryM4762a = m4762a(mrzResult.getIssuer());
        String documentNumber = mrzResult.getDocumentNumber();
        MrzData mrzDataM4761a = C4708b.m4761a(mrzResult);
        C4704b c4704b = this.f6878b;
        MrtdDocumentType documentType = mrzResult.getDocumentType();
        Intrinsics.checkExpressionValueIsNotNull(documentType, "mrzResult.documentType");
        return new DocumentData(null, dateResultM4763a, countryM4762a, null, documentNumber, mrzDataM4761a, null, c4704b.m4752a(documentType), 64, null);
    }

    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Holder mo4708c(PassportRecognizer.Result result) {
        return null;
    }

    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Holder mo4709d(PassportRecognizer.Result result) {
        MrzResult mrzResult;
        if (result == null || (mrzResult = result.getMrzResult()) == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(mrzResult, "mrzResult");
        String primaryId = mrzResult.getPrimaryId();
        String secondaryId = mrzResult.getSecondaryId();
        com.microblink.results.date.DateResult dateOfBirth = mrzResult.getDateOfBirth();
        Intrinsics.checkExpressionValueIsNotNull(dateOfBirth, "mrzResult.dateOfBirth");
        return new Holder(null, null, secondaryId, null, primaryId, null, null, m4763a(dateOfBirth.getDate()), null, m4764b(mrzResult.getGender()), m4762a(mrzResult.getNationality()));
    }
}
