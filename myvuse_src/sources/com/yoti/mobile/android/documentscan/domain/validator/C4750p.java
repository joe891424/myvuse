package com.yoti.mobile.android.documentscan.domain.validator;

import com.yoti.mobile.android.documentscan.domain.validator.UKDrivingLicenceValidator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.p */
/* JADX INFO: loaded from: classes5.dex */
final class C4750p extends Lambda implements Function0<C4756v> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ UKDrivingLicenceValidator f6970a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4750p(UKDrivingLicenceValidator uKDrivingLicenceValidator) {
        super(0);
        this.f6970a = uKDrivingLicenceValidator;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final C4756v invoke() {
        boolean z;
        String strM4881b = this.f6970a.f6949a.m4881b();
        if (strM4881b == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = strM4881b.substring(11, 13);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String salutation = new C4736b().m4878a(this.f6970a.f6949a.m4883d()).getSalutation();
        if (salutation == null) {
            salutation = "";
        }
        try {
            new C4755u().m4891a(strSubstring, this.f6970a.f6949a.m4884e(), salutation);
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        return new C4756v(z, UKDrivingLicenceValidator.UKDrivingLicenceValidationResult.MismatchedInitials);
    }
}
