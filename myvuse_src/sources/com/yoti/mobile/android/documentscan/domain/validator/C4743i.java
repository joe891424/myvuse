package com.yoti.mobile.android.documentscan.domain.validator;

import com.yoti.mobile.android.documentscan.domain.validator.UKDrivingLicenceValidator;
import java.io.IOException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.i */
/* JADX INFO: loaded from: classes5.dex */
final class C4743i extends Lambda implements Function0<C4756v> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ UKDrivingLicenceValidator f6963a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4743i(UKDrivingLicenceValidator uKDrivingLicenceValidator) {
        super(0);
        this.f6963a = uKDrivingLicenceValidator;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final C4756v invoke() throws IOException {
        String strM4882c = this.f6963a.f6949a.m4882c();
        StringBuilder sb = new StringBuilder();
        int length = strM4882c.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = strM4882c.charAt(i);
            if (Character.isLetter(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "filterTo(StringBuilder(), predicate).toString()");
        if (string.length() < 6) {
            string = string + StringsKt.repeat("9", 6 - string.length());
        }
        if (string == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = string.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        if (StringsKt.startsWith$default(upperCase, "MAC", false, 2, (Object) null)) {
            upperCase = StringsKt.replaceFirst$default(upperCase, "MAC", "MC", false, 4, (Object) null);
        }
        if (upperCase == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = upperCase.substring(0, 5);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strM4881b = this.f6963a.f6949a.m4881b();
        if (strM4881b == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring2 = strM4881b.substring(0, 5);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return new C4756v(Intrinsics.areEqual(strSubstring, strSubstring2), UKDrivingLicenceValidator.UKDrivingLicenceValidationResult.MismatchedSurname);
    }
}
