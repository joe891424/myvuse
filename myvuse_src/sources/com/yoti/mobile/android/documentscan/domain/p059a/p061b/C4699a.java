package com.yoti.mobile.android.documentscan.domain.p059a.p061b;

import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.generic.classinfo.ClassInfo;
import com.microblink.entities.recognizers.blinkid.generic.classinfo.Type;
import com.microblink.entities.recognizers.blinkid.mrtd.MrzResult;
import com.microblink.results.date.Date;
import com.yoti.mobile.android.documentscan.domain.AbstractC4696a;
import com.yoti.mobile.android.documentscan.domain.p059a.p063d.C4706d;
import com.yoti.mobile.android.documentscan.domain.p059a.p064e.C4708b;
import com.yoti.mobile.android.documentscan.domain.utils.BlinkDateUtils;
import com.yoti.mobile.android.documentscan.domain.validator.C4739e;
import com.yoti.mobile.android.documentscan.domain.validator.UKDrivingLicenceValidator;
import com.yoti.mobile.android.documentscan.model.result.Address;
import com.yoti.mobile.android.documentscan.model.result.Country;
import com.yoti.mobile.android.documentscan.model.result.DateResult;
import com.yoti.mobile.android.documentscan.model.result.DocumentData;
import com.yoti.mobile.android.documentscan.model.result.Gender;
import com.yoti.mobile.android.documentscan.model.result.Holder;
import com.yoti.mobile.android.documentscan.model.result.MrzData;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.a.b.a */
/* JADX INFO: loaded from: classes5.dex */
public final class C4699a extends AbstractC4696a<BlinkIdCombinedRecognizer.Result> {

    /* JADX INFO: renamed from: a */
    private final BlinkDateUtils f6871a;

    /* JADX INFO: renamed from: b */
    private final C4706d f6872b;

    public C4699a(BlinkDateUtils blinkDateUtils, C4706d coreDocumentTypeMapper) {
        Intrinsics.checkParameterIsNotNull(blinkDateUtils, "blinkDateUtils");
        Intrinsics.checkParameterIsNotNull(coreDocumentTypeMapper, "coreDocumentTypeMapper");
        this.f6871a = blinkDateUtils;
        this.f6872b = coreDocumentTypeMapper;
    }

    /* JADX INFO: renamed from: a */
    private final Country m4728a(String str) {
        return new Country(str);
    }

    /* JADX INFO: renamed from: a */
    private final DateResult m4729a(Date date) {
        if (date != null) {
            return new DateResult(this.f6871a.m4782a(date));
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:
    
        if (r3.equals("P") == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003e, code lost:
    
        if (r3.equals("O") != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        if (r3.equals("M") != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        if (r3.equals("H") != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0059, code lost:
    
        if (r3.equals("F") != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0062, code lost:
    
        if (r3.equals("<") != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006b, code lost:
    
        if (r3.equals("0") != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0076, code lost:
    
        if (r3.equals("PEREMPUAN") != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0081, code lost:
    
        if (r3.equals("LELAKI") != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return com.yoti.mobile.android.documentscan.model.result.Gender.UNSPECIFIED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
    
        return com.yoti.mobile.android.documentscan.model.result.Gender.FEMALE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return com.yoti.mobile.android.documentscan.model.result.Gender.MALE;
     */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.yoti.mobile.android.documentscan.model.result.Gender m4730b(java.lang.String r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L4
            goto L86
        L4:
            int r0 = r3.hashCode()
            r1 = -2053099892(0xffffffff85a02e8c, float:-1.5063426E-35)
            if (r0 == r1) goto L7b
            r1 = -1057760041(0xffffffffc0f3dcd7, float:-7.620708)
            if (r0 == r1) goto L70
            r1 = 48
            if (r0 == r1) goto L65
            r1 = 60
            if (r0 == r1) goto L5c
            r1 = 70
            if (r0 == r1) goto L53
            r1 = 72
            if (r0 == r1) goto L4a
            r1 = 77
            if (r0 == r1) goto L41
            r1 = 79
            if (r0 == r1) goto L38
            r1 = 80
            if (r0 == r1) goto L2f
            goto L86
        L2f:
            java.lang.String r0 = "P"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L86
            goto L78
        L38:
            java.lang.String r0 = "O"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L86
            goto L6d
        L41:
            java.lang.String r0 = "M"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L86
            goto L83
        L4a:
            java.lang.String r0 = "H"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L86
            goto L83
        L53:
            java.lang.String r0 = "F"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L86
            goto L78
        L5c:
            java.lang.String r0 = "<"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L86
            goto L6d
        L65:
            java.lang.String r0 = "0"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L86
        L6d:
            com.yoti.mobile.android.documentscan.model.result.Gender r3 = com.yoti.mobile.android.documentscan.model.result.Gender.UNSPECIFIED
            goto L87
        L70:
            java.lang.String r0 = "PEREMPUAN"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L86
        L78:
            com.yoti.mobile.android.documentscan.model.result.Gender r3 = com.yoti.mobile.android.documentscan.model.result.Gender.FEMALE
            goto L87
        L7b:
            java.lang.String r0 = "LELAKI"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L86
        L83:
            com.yoti.mobile.android.documentscan.model.result.Gender r3 = com.yoti.mobile.android.documentscan.model.result.Gender.MALE
            goto L87
        L86:
            r3 = 0
        L87:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentscan.domain.p059a.p061b.C4699a.m4730b(java.lang.String):com.yoti.mobile.android.documentscan.model.result.Gender");
    }

    /* JADX INFO: renamed from: e */
    private final DateResult m4731e(BlinkIdCombinedRecognizer.Result result) {
        com.microblink.results.date.DateResult dateOfBirth;
        MrzResult mrzResult = result.getMrzResult();
        Intrinsics.checkExpressionValueIsNotNull(mrzResult, "mrzResult");
        com.microblink.results.date.DateResult dateOfBirth2 = mrzResult.getDateOfBirth();
        Intrinsics.checkExpressionValueIsNotNull(dateOfBirth2, "mrzResult.dateOfBirth");
        String originalDateString = dateOfBirth2.getOriginalDateString();
        Intrinsics.checkExpressionValueIsNotNull(originalDateString, "mrzResult.dateOfBirth.originalDateString");
        if (originalDateString.length() == 0) {
            dateOfBirth = result.getDateOfBirth();
            Intrinsics.checkExpressionValueIsNotNull(dateOfBirth, "dateOfBirth");
        } else {
            MrzResult mrzResult2 = result.getMrzResult();
            Intrinsics.checkExpressionValueIsNotNull(mrzResult2, "mrzResult");
            dateOfBirth = mrzResult2.getDateOfBirth();
            Intrinsics.checkExpressionValueIsNotNull(dateOfBirth, "mrzResult.dateOfBirth");
        }
        return m4729a(dateOfBirth.getDate());
    }

    /* JADX INFO: renamed from: f */
    private final Gender m4732f(BlinkIdCombinedRecognizer.Result result) {
        String gender;
        MrzResult mrzResult = result.getMrzResult();
        Intrinsics.checkExpressionValueIsNotNull(mrzResult, "mrzResult");
        String gender2 = mrzResult.getGender();
        Intrinsics.checkExpressionValueIsNotNull(gender2, "mrzResult.gender");
        if (gender2.length() == 0) {
            gender = result.getSex();
        } else {
            MrzResult mrzResult2 = result.getMrzResult();
            Intrinsics.checkExpressionValueIsNotNull(mrzResult2, "mrzResult");
            gender = mrzResult2.getGender();
        }
        return m4730b(gender);
    }

    /* JADX INFO: renamed from: g */
    private final Country m4733g(BlinkIdCombinedRecognizer.Result result) {
        String nationality;
        MrzResult mrzResult = result.getMrzResult();
        Intrinsics.checkExpressionValueIsNotNull(mrzResult, "mrzResult");
        String nationality2 = mrzResult.getNationality();
        Intrinsics.checkExpressionValueIsNotNull(nationality2, "mrzResult.nationality");
        if (nationality2.length() == 0) {
            nationality = result.getNationality();
        } else {
            MrzResult mrzResult2 = result.getMrzResult();
            Intrinsics.checkExpressionValueIsNotNull(mrzResult2, "mrzResult");
            nationality = mrzResult2.getNationality();
        }
        return m4728a(nationality);
    }

    /* JADX INFO: renamed from: h */
    private final Boolean m4734h(BlinkIdCombinedRecognizer.Result result) {
        if (m4735i(result)) {
            return Boolean.valueOf(new UKDrivingLicenceValidator(C4739e.m4888a(result, this.f6871a)).m4873a().m4892a());
        }
        return null;
    }

    /* JADX INFO: renamed from: i */
    private final boolean m4735i(BlinkIdCombinedRecognizer.Result result) {
        ClassInfo classInfo = result.getClassInfo();
        Intrinsics.checkExpressionValueIsNotNull(classInfo, "classInfo");
        if (classInfo.getType() == Type.DL) {
            ClassInfo classInfo2 = result.getClassInfo();
            Intrinsics.checkExpressionValueIsNotNull(classInfo2, "classInfo");
            if (classInfo2.getCountry() == com.microblink.entities.recognizers.blinkid.generic.classinfo.Country.UK) {
                return true;
            }
        }
        return false;
    }

    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Address mo4706a(BlinkIdCombinedRecognizer.Result result) {
        String address;
        if (result == null || (address = result.getAddress()) == null) {
            return null;
        }
        return new Address(CollectionsKt.emptyList(), null, null, null, null, null, null, null, null, null, null, null, address);
    }

    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DocumentData mo4707b(BlinkIdCombinedRecognizer.Result result) {
        com.microblink.results.date.DateResult dateOfExpiry;
        String documentNumber;
        if (result == null) {
            return null;
        }
        com.microblink.results.date.DateResult dateOfIssue = result.getDateOfIssue();
        Intrinsics.checkExpressionValueIsNotNull(dateOfIssue, "result.dateOfIssue");
        DateResult dateResultM4729a = m4729a(dateOfIssue.getDate());
        MrzResult mrzResult = result.getMrzResult();
        Intrinsics.checkExpressionValueIsNotNull(mrzResult, "result.mrzResult");
        com.microblink.results.date.DateResult dateOfExpiry2 = mrzResult.getDateOfExpiry();
        String str = "result.mrzResult.dateOfExpiry";
        Intrinsics.checkExpressionValueIsNotNull(dateOfExpiry2, "result.mrzResult.dateOfExpiry");
        String originalDateString = dateOfExpiry2.getOriginalDateString();
        Intrinsics.checkExpressionValueIsNotNull(originalDateString, "result.mrzResult.dateOfExpiry.originalDateString");
        if (originalDateString.length() == 0) {
            dateOfExpiry = result.getDateOfExpiry();
            str = "result.dateOfExpiry";
        } else {
            MrzResult mrzResult2 = result.getMrzResult();
            Intrinsics.checkExpressionValueIsNotNull(mrzResult2, "result.mrzResult");
            dateOfExpiry = mrzResult2.getDateOfExpiry();
        }
        Intrinsics.checkExpressionValueIsNotNull(dateOfExpiry, str);
        DateResult dateResultM4729a2 = m4729a(dateOfExpiry.getDate());
        MrzResult mrzResult3 = result.getMrzResult();
        Intrinsics.checkExpressionValueIsNotNull(mrzResult3, "result.mrzResult");
        Country countryM4728a = m4728a(mrzResult3.getIssuer());
        String issuingAuthority = result.getIssuingAuthority();
        MrzResult mrzResult4 = result.getMrzResult();
        Intrinsics.checkExpressionValueIsNotNull(mrzResult4, "result.mrzResult");
        String documentNumber2 = mrzResult4.getDocumentNumber();
        Intrinsics.checkExpressionValueIsNotNull(documentNumber2, "result.mrzResult.documentNumber");
        if (documentNumber2.length() == 0) {
            documentNumber = result.getDocumentNumber();
        } else {
            MrzResult mrzResult5 = result.getMrzResult();
            Intrinsics.checkExpressionValueIsNotNull(mrzResult5, "result.mrzResult");
            documentNumber = mrzResult5.getDocumentNumber();
        }
        String str2 = documentNumber;
        MrzResult mrzResult6 = result.getMrzResult();
        Intrinsics.checkExpressionValueIsNotNull(mrzResult6, "result.mrzResult");
        MrzData mrzDataM4761a = C4708b.m4761a(mrzResult6);
        Boolean boolM4734h = m4734h(result);
        C4706d c4706d = this.f6872b;
        ClassInfo classInfo = result.getClassInfo();
        Intrinsics.checkExpressionValueIsNotNull(classInfo, "ocrResult.classInfo");
        Type type = classInfo.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "ocrResult.classInfo.type");
        return new DocumentData(dateResultM4729a, dateResultM4729a2, countryM4728a, issuingAuthority, str2, mrzDataM4761a, boolM4734h, c4706d.m4753a(type));
    }

    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Holder mo4708c(BlinkIdCombinedRecognizer.Result result) {
        return null;
    }

    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Holder mo4709d(BlinkIdCombinedRecognizer.Result result) {
        if (result == null) {
            return null;
        }
        return new Holder(null, C4700b.m4741b(result), C4700b.m4742c(result), null, C4700b.m4740a(result), null, result.getFullName(), m4731e(result), result.getPlaceOfBirth(), m4732f(result), m4733g(result));
    }
}
