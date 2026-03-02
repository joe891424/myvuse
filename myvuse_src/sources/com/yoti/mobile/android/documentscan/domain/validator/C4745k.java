package com.yoti.mobile.android.documentscan.domain.validator;

import com.yoti.mobile.android.documentscan.domain.validator.UKDrivingLicenceValidator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.k */
/* JADX INFO: loaded from: classes5.dex */
final class C4745k extends Lambda implements Function0<C4756v> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ UKDrivingLicenceValidator f6965a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4745k(UKDrivingLicenceValidator uKDrivingLicenceValidator) {
        super(0);
        this.f6965a = uKDrivingLicenceValidator;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final C4756v invoke() {
        String strM4881b = this.f6965a.f6949a.m4881b();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= strM4881b.length()) {
                z = true;
                break;
            }
            if (!Character.isDigit(strM4881b.charAt(i))) {
                break;
            }
            i++;
        }
        return new C4756v(z, UKDrivingLicenceValidator.UKDrivingLicenceValidationResult.AlphaCharactersPresent);
    }
}
