package com.yoti.mobile.android.documentscan.domain.validator;

import com.yoti.mobile.android.documentscan.domain.validator.UKDrivingLicenceValidator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.j */
/* JADX INFO: loaded from: classes5.dex */
final class C4744j extends Lambda implements Function0<C4756v> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ UKDrivingLicenceValidator f6964a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4744j(UKDrivingLicenceValidator uKDrivingLicenceValidator) {
        super(0);
        this.f6964a = uKDrivingLicenceValidator;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final C4756v invoke() {
        StringBuilder sb = new StringBuilder();
        String strM4881b = this.f6964a.f6949a.m4881b();
        if (strM4881b == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = strM4881b.substring(5, 6);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        StringBuilder sbAppend = sb.append(strSubstring);
        String strM4881b2 = this.f6964a.f6949a.m4881b();
        if (strM4881b2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring2 = strM4881b2.substring(10, 11);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return new C4756v(Integer.parseInt(sbAppend.append(strSubstring2).toString()) == this.f6964a.f6949a.m4887h() % 100, UKDrivingLicenceValidator.UKDrivingLicenceValidationResult.MismatchedYearOfBirth);
    }
}
