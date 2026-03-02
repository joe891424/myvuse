package com.yoti.mobile.android.documentscan.domain.validator;

import com.yoti.mobile.android.documentscan.domain.validator.UKDrivingLicenceValidator;
import java.io.IOException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.s */
/* JADX INFO: loaded from: classes5.dex */
final class C4753s extends Lambda implements Function0<C4756v> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ UKDrivingLicenceValidator f6973a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4753s(UKDrivingLicenceValidator uKDrivingLicenceValidator) {
        super(0);
        this.f6973a = uKDrivingLicenceValidator;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final C4756v invoke() throws IOException {
        StringBuilder sb = new StringBuilder();
        String strM4881b = this.f6973a.f6949a.m4881b();
        if (strM4881b == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = strM4881b.substring(5, 6);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        StringBuilder sbAppend = sb.append(strSubstring);
        String strM4881b2 = this.f6973a.f6949a.m4881b();
        if (strM4881b2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring2 = strM4881b2.substring(10, 11);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String string = sbAppend.append(strSubstring2).toString();
        StringBuilder sb2 = new StringBuilder();
        int length = string.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = string.charAt(i);
            if (Character.isDigit(cCharAt)) {
                sb2.append(cCharAt);
            }
        }
        String string2 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "filterTo(StringBuilder(), predicate).toString()");
        return new C4756v(string2.length() == 2, UKDrivingLicenceValidator.UKDrivingLicenceValidationResult.InvalidYearOfBirth);
    }
}
