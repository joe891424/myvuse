package com.yoti.mobile.android.liveness.view.biometric_consent;

import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class BiometricConsentFragment$onViewCreated$1$1$1 extends FunctionReferenceImpl implements Function1<BiometricConsentViewModel.BiometricConsentViewState, Unit> {
    BiometricConsentFragment$onViewCreated$1$1$1(Object obj) {
        super(1, obj, BiometricConsentFragment.class, "onViewStateChanged", "onViewStateChanged(Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BiometricConsentViewModel.BiometricConsentViewState biometricConsentViewState) {
        invoke2(biometricConsentViewState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BiometricConsentViewModel.BiometricConsentViewState p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((BiometricConsentFragment) this.receiver).onViewStateChanged(p0);
    }
}
