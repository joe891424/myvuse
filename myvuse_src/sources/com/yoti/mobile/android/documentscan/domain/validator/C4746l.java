package com.yoti.mobile.android.documentscan.domain.validator;

import com.yoti.mobile.android.documentscan.domain.validator.UKDrivingLicenceValidator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.l */
/* JADX INFO: loaded from: classes5.dex */
final class C4746l extends Lambda implements Function0<C4756v> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ UKDrivingLicenceValidator f6966a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4746l(UKDrivingLicenceValidator uKDrivingLicenceValidator) {
        super(0);
        this.f6966a = uKDrivingLicenceValidator;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final C4756v invoke() {
        return new C4756v(this.f6966a.f6949a.m4881b().length() == 8, UKDrivingLicenceValidator.UKDrivingLicenceValidationResult.InvalidLength);
    }
}
