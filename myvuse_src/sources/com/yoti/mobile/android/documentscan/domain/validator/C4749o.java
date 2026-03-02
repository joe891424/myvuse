package com.yoti.mobile.android.documentscan.domain.validator;

import com.yoti.mobile.android.documentscan.domain.validator.UKDrivingLicenceValidator;
import java.io.IOException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.o */
/* JADX INFO: loaded from: classes5.dex */
final class C4749o extends Lambda implements Function0<C4756v> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ UKDrivingLicenceValidator f6969a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4749o(UKDrivingLicenceValidator uKDrivingLicenceValidator) {
        super(0);
        this.f6969a = uKDrivingLicenceValidator;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final C4756v invoke() throws IOException {
        String strM4881b = this.f6969a.f6949a.m4881b();
        if (strM4881b == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = strM4881b.substring(8, 10);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        StringBuilder sb = new StringBuilder();
        int length = strSubstring.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = strSubstring.charAt(i);
            if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "filterTo(StringBuilder(), predicate).toString()");
        return new C4756v(string.length() == 2, UKDrivingLicenceValidator.UKDrivingLicenceValidationResult.InvalidDayOfBirth);
    }
}
