package com.yoti.mobile.android.documentscan.domain.p059a.p065f;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.imageutils.JfifUtil;
import com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys;
import com.microblink.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
import com.yoti.mobile.android.documentscan.domain.AbstractC4696a;
import com.yoti.mobile.android.documentscan.domain.utils.BlinkDateUtils;
import com.yoti.mobile.android.documentscan.model.result.Country;
import com.yoti.mobile.android.documentscan.model.result.DateResult;
import com.yoti.mobile.android.documentscan.model.result.DocumentData;
import com.yoti.mobile.android.documentscan.model.result.Gender;
import com.yoti.mobile.android.documentscan.model.result.Holder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.a.f.a */
/* JADX INFO: loaded from: classes5.dex */
public final class C4710a extends AbstractC4696a<UsdlCombinedRecognizer.Result> {

    /* JADX INFO: renamed from: a */
    private final BlinkDateUtils f6879a;

    public C4710a(BlinkDateUtils blinkDateUtils) {
        Intrinsics.checkParameterIsNotNull(blinkDateUtils, "blinkDateUtils");
        this.f6879a = blinkDateUtils;
    }

    /* JADX INFO: renamed from: a */
    private final DateResult m4769a(String str) {
        if (str != null) {
            return this.f6879a.m4784b(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    private final Gender m4770b(String str) {
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
    private final boolean m4771e(UsdlCombinedRecognizer.Result result) {
        String field = result.getField(UsdlKeys.AddressStreet);
        Intrinsics.checkExpressionValueIsNotNull(field, "getField(UsdlKeys.AddressStreet)");
        if (field.length() > 0) {
            String field2 = result.getField(UsdlKeys.AddressCity);
            Intrinsics.checkExpressionValueIsNotNull(field2, "getField(UsdlKeys.AddressCity)");
            if (field2.length() > 0) {
                String field3 = result.getField(UsdlKeys.AddressJurisdictionCode);
                Intrinsics.checkExpressionValueIsNotNull(field3, "getField(UsdlKeys.AddressJurisdictionCode)");
                if (field3.length() > 0) {
                    String field4 = result.getField(UsdlKeys.AddressPostalCode);
                    Intrinsics.checkExpressionValueIsNotNull(field4, "getField(UsdlKeys.AddressPostalCode)");
                    if (field4.length() > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.yoti.mobile.android.documentscan.model.result.Address mo4706a(com.microblink.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer.Result r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "it"
            r2 = 0
            if (r0 == 0) goto L65
            boolean r3 = r18.m4771e(r19)
            if (r3 == 0) goto Lf
            r3 = r0
            goto L10
        Lf:
            r3 = r2
        L10:
            if (r3 == 0) goto L65
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys r0 = com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys.AddressStreet
            java.lang.String r0 = r3.getField(r0)
            java.lang.String r4 = "result.getField(UsdlKeys.AddressStreet)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
            r5.add(r0)
            com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys r0 = com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys.AddressStreet2
            java.lang.String r0 = r3.getField(r0)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            int r4 = r0.length()
            if (r4 <= 0) goto L35
            r2 = r0
        L35:
            if (r2 == 0) goto L3d
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r1)
            r5.add(r2)
        L3d:
            com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys r0 = com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys.AddressCity
            java.lang.String r6 = r3.getField(r0)
            com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys r0 = com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys.AddressJurisdictionCode
            java.lang.String r8 = r3.getField(r0)
            com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys r0 = com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys.AddressPostalCode
            java.lang.String r9 = r3.getField(r0)
            com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys r0 = com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys.FullAddress
            java.lang.String r17 = r3.getField(r0)
            com.yoti.mobile.android.documentscan.model.result.Address r0 = new com.yoti.mobile.android.documentscan.model.result.Address
            r15 = 0
            r16 = 0
            r7 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            goto L92
        L65:
            if (r0 == 0) goto L7b
            com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys r3 = com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys.FullAddress
            java.lang.String r0 = r0.getField(r3)
            if (r0 == 0) goto L7b
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            int r1 = r0.length()
            if (r1 <= 0) goto L7b
            r16 = r0
            goto L7d
        L7b:
            r16 = r2
        L7d:
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
        L92:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentscan.domain.p059a.p065f.C4710a.mo4706a(com.microblink.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer$Result):com.yoti.mobile.android.documentscan.model.result.Address");
    }

    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DocumentData mo4707b(UsdlCombinedRecognizer.Result result) {
        if (result != null) {
            return new DocumentData(m4769a(result.getField(UsdlKeys.DocumentIssueDate)), m4769a(result.getField(UsdlKeys.DocumentExpirationDate)), new Country(result.getField(UsdlKeys.CountryIdentification)), result.getField(UsdlKeys.IssuerIdentificationNumber), result.getField(UsdlKeys.CustomerIdNumber), null, null, null, JfifUtil.MARKER_SOFn, null);
        }
        return null;
    }

    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Holder mo4708c(UsdlCombinedRecognizer.Result result) {
        if (result != null) {
            return new Holder(null, result.getField(UsdlKeys.AKAGivenName), null, result.getField(UsdlKeys.AKAMiddleName), result.getField(UsdlKeys.AKAFamilyName), null, null, null, null, null, null);
        }
        return null;
    }

    @Override // com.yoti.mobile.android.documentscan.domain.AbstractC4696a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Holder mo4709d(UsdlCombinedRecognizer.Result result) {
        if (result != null) {
            return new Holder(result.getField(UsdlKeys.NamePrefix), result.getField(UsdlKeys.CustomerFirstName), null, result.getField(UsdlKeys.CustomerMiddleName), result.getField(UsdlKeys.CustomerFamilyName), result.getField(UsdlKeys.NameSuffix), null, m4769a(result.getField(UsdlKeys.DateOfBirth)), null, m4770b(result.getField(UsdlKeys.Sex)), null);
        }
        return null;
    }
}
