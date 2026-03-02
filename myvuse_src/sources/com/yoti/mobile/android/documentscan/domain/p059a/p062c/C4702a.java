package com.yoti.mobile.android.documentscan.domain.p059a.p062c;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.imageutils.JfifUtil;
import com.microblink.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer;
import com.yoti.mobile.android.documentscan.domain.AbstractC4696a;
import com.yoti.mobile.android.documentscan.domain.utils.BlinkDateUtils;
import com.yoti.mobile.android.documentscan.model.result.DateResult;
import com.yoti.mobile.android.documentscan.model.result.DocumentData;
import com.yoti.mobile.android.documentscan.model.result.Gender;
import com.yoti.mobile.android.documentscan.model.result.Holder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.a.c.a */
/* JADX INFO: loaded from: classes5.dex */
public final class C4702a extends AbstractC4696a<IdBarcodeRecognizer.Result> {

    /* JADX INFO: renamed from: a */
    private final BlinkDateUtils f6874a;

    public C4702a(BlinkDateUtils blinkDateUtils) {
        Intrinsics.checkParameterIsNotNull(blinkDateUtils, "blinkDateUtils");
        this.f6874a = blinkDateUtils;
    }

    /* JADX INFO: renamed from: a */
    private final DateResult m4745a(String str) {
        if (str != null) {
            return this.f6874a.m4784b(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    private final Gender m4746b(String str) {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != 49) {
                if (iHashCode == 50 && str.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                    return Gender.FEMALE;
                }
            } else if (str.equals("1")) {
                return Gender.MALE;
            }
        }
        return Gender.OTHER;
    }

    /* JADX INFO: renamed from: e */
    private final boolean m4747e(IdBarcodeRecognizer.Result result) {
        String street = result.getStreet();
        Intrinsics.checkExpressionValueIsNotNull(street, "street");
        if (street.length() > 0) {
            String city = result.getCity();
            Intrinsics.checkExpressionValueIsNotNull(city, "city");
            if (city.length() > 0) {
                String jurisdiction = result.getJurisdiction();
                Intrinsics.checkExpressionValueIsNotNull(jurisdiction, "jurisdiction");
                if (jurisdiction.length() > 0) {
                    String postalCode = result.getPostalCode();
                    Intrinsics.checkExpressionValueIsNotNull(postalCode, "postalCode");
                    if (postalCode.length() > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.yoti.mobile.android.documentscan.model.result.Address mo4706a(com.microblink.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer.Result r18) {
        /*
            r17 = this;
            r0 = 0
            if (r18 == 0) goto L36
            boolean r1 = r17.m4747e(r18)
            if (r1 == 0) goto Lc
            r1 = r18
            goto Ld
        Lc:
            r1 = r0
        Ld:
            if (r1 == 0) goto L36
            com.yoti.mobile.android.documentscan.model.result.Address r0 = new com.yoti.mobile.android.documentscan.model.result.Address
            java.lang.String r2 = r1.getStreet()
            java.util.List r3 = kotlin.collections.CollectionsKt.listOf(r2)
            java.lang.String r4 = r1.getCity()
            java.lang.String r6 = r1.getJurisdiction()
            java.lang.String r7 = r1.getPostalCode()
            java.lang.String r15 = r1.getAddress()
            r13 = 0
            r14 = 0
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            goto L63
        L36:
            if (r18 == 0) goto L4c
            java.lang.String r1 = r18.getAddress()
            if (r1 == 0) goto L4c
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            int r2 = r1.length()
            if (r2 <= 0) goto L4c
            r16 = r1
            goto L4e
        L4c:
            r16 = r0
        L4e:
            com.yoti.mobile.android.documentscan.model.result.Address r0 = new com.yoti.mobile.android.documentscan.model.result.Address
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            r14 = 0
            r15 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
        L63:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentscan.domain.p059a.p062c.C4702a.mo4706a(com.microblink.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer$Result):com.yoti.mobile.android.documentscan.model.result.Address");
    }

    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DocumentData mo4707b(IdBarcodeRecognizer.Result result) {
        if (result == null) {
            return null;
        }
        com.microblink.results.date.DateResult dateOfIssue = result.getDateOfIssue();
        Intrinsics.checkExpressionValueIsNotNull(dateOfIssue, "result.dateOfIssue");
        DateResult dateResultM4745a = m4745a(dateOfIssue.getOriginalDateString());
        com.microblink.results.date.DateResult dateOfExpiry = result.getDateOfExpiry();
        Intrinsics.checkExpressionValueIsNotNull(dateOfExpiry, "result.dateOfExpiry");
        return new DocumentData(dateResultM4745a, m4745a(dateOfExpiry.getOriginalDateString()), null, result.getIssuingAuthority(), result.getDocumentNumber(), null, null, null, JfifUtil.MARKER_SOFn, null);
    }

    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Holder mo4708c(IdBarcodeRecognizer.Result result) {
        return null;
    }

    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Holder mo4709d(IdBarcodeRecognizer.Result result) {
        if (result == null) {
            return null;
        }
        String firstName = result.getFirstName();
        String middleName = result.getMiddleName();
        String lastName = result.getLastName();
        String fullName = result.getFullName();
        com.microblink.results.date.DateResult dateOfBirth = result.getDateOfBirth();
        Intrinsics.checkExpressionValueIsNotNull(dateOfBirth, "result.dateOfBirth");
        return new Holder(null, firstName, null, middleName, lastName, null, fullName, m4745a(dateOfBirth.getOriginalDateString()), null, m4746b(result.getSex()), null);
    }
}
