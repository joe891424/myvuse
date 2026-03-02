package com.yoti.mobile.android.documentscan.domain.validator;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrzResult;
import com.microblink.results.date.Date;
import com.yoti.mobile.android.documentscan.domain.p059a.p061b.C4700b;
import com.yoti.mobile.android.documentscan.domain.utils.BlinkDateUtils;
import com.yoti.mobile.android.documentscan.domain.validator.UKDrivingLicenceValidator;
import com.yoti.mobile.android.documentscan.model.result.DateResult;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.e */
/* JADX INFO: loaded from: classes5.dex */
public final class C4739e {
    /* JADX INFO: renamed from: a */
    public static final C4738d m4888a(BlinkIdCombinedRecognizer.Result mapToLicence, BlinkDateUtils blinkDateUtils) {
        String documentNumber;
        Integer day;
        Integer month;
        Integer year;
        Intrinsics.checkParameterIsNotNull(mapToLicence, "$this$mapToLicence");
        Intrinsics.checkParameterIsNotNull(blinkDateUtils, "blinkDateUtils");
        String issuingAuthority = mapToLicence.getIssuingAuthority();
        Intrinsics.checkExpressionValueIsNotNull(issuingAuthority, "issuingAuthority");
        UKDrivingLicenceValidator.Issuer issuerValueOf = UKDrivingLicenceValidator.Issuer.valueOf(issuingAuthority);
        MrzResult mrzResult = mapToLicence.getMrzResult();
        Intrinsics.checkExpressionValueIsNotNull(mrzResult, "mrzResult");
        String documentNumber2 = mrzResult.getDocumentNumber();
        Intrinsics.checkExpressionValueIsNotNull(documentNumber2, "mrzResult.documentNumber");
        if (documentNumber2.length() == 0) {
            documentNumber = mapToLicence.getDocumentNumber();
        } else {
            MrzResult mrzResult2 = mapToLicence.getMrzResult();
            Intrinsics.checkExpressionValueIsNotNull(mrzResult2, "mrzResult");
            documentNumber = mrzResult2.getDocumentNumber();
        }
        String str = documentNumber;
        Intrinsics.checkExpressionValueIsNotNull(str, "if (mrzResult.documentNu…umentNumber\n            }");
        String strReplace$default = StringsKt.replace$default(C4700b.m4742c(mapToLicence), ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, " ", false, 4, (Object) null);
        String strM4740a = C4700b.m4740a(mapToLicence);
        String strReplace$default2 = StringsKt.replace$default(C4700b.m4741b(mapToLicence), ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, " ", false, 4, (Object) null);
        DateResult dateResultM4890b = m4890b(mapToLicence, blinkDateUtils);
        int iIntValue = (dateResultM4890b == null || (year = dateResultM4890b.getYear()) == null) ? 0 : year.intValue();
        DateResult dateResultM4890b2 = m4890b(mapToLicence, blinkDateUtils);
        int iIntValue2 = (dateResultM4890b2 == null || (month = dateResultM4890b2.getMonth()) == null) ? 0 : month.intValue();
        DateResult dateResultM4890b3 = m4890b(mapToLicence, blinkDateUtils);
        return new C4738d(issuerValueOf, str, strReplace$default, strM4740a, strReplace$default2, iIntValue, iIntValue2, (dateResultM4890b3 == null || (day = dateResultM4890b3.getDay()) == null) ? 0 : day.intValue());
    }

    /* JADX INFO: renamed from: a */
    private static final DateResult m4889a(Date date, BlinkDateUtils blinkDateUtils) {
        if (date != null) {
            return new DateResult(blinkDateUtils.m4782a(date));
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    private static final DateResult m4890b(BlinkIdCombinedRecognizer.Result result, BlinkDateUtils blinkDateUtils) {
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
        return m4889a(dateOfBirth.getDate(), blinkDateUtils);
    }
}
