package com.yoti.mobile.android.documentscan.domain.validator;

import com.yoti.mobile.android.documentscan.domain.validator.UKDrivingLicenceValidator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.r */
/* JADX INFO: loaded from: classes5.dex */
final class C4752r extends Lambda implements Function0<C4756v> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ UKDrivingLicenceValidator f6972a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4752r(UKDrivingLicenceValidator uKDrivingLicenceValidator) {
        super(0);
        this.f6972a = uKDrivingLicenceValidator;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final C4756v invoke() {
        String strM4882c = this.f6972a.f6949a.m4882c();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= strM4882c.length()) {
                break;
            }
            if (Character.isLetter(strM4882c.charAt(i))) {
                z = true;
                break;
            }
            i++;
        }
        return new C4756v(z, UKDrivingLicenceValidator.UKDrivingLicenceValidationResult.InvalidSurname);
    }
}
