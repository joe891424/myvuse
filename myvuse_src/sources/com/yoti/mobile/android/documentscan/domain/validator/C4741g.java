package com.yoti.mobile.android.documentscan.domain.validator;

import com.yoti.mobile.android.documentscan.domain.validator.UKDrivingLicenceValidator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.g */
/* JADX INFO: loaded from: classes5.dex */
final class C4741g extends Lambda implements Function0<C4756v> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ UKDrivingLicenceValidator f6961a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4741g(UKDrivingLicenceValidator uKDrivingLicenceValidator) {
        super(0);
        this.f6961a = uKDrivingLicenceValidator;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final C4756v invoke() {
        String strM4881b = this.f6961a.f6949a.m4881b();
        if (strM4881b == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = strM4881b.substring(8, 10);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return new C4756v(Integer.parseInt(strSubstring) == this.f6961a.f6949a.m4880a(), UKDrivingLicenceValidator.UKDrivingLicenceValidationResult.MismatchedDayOfBirth);
    }
}
