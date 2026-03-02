package com.yoti.mobile.android.liveness.view.biometric_consent;

import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class BiometricConsentFragment$onViewCreated$1$1$3 extends FunctionReferenceImpl implements Function1<BiometricConsentViewModel.BiometricConsentNavigationEvent, Unit> {
    BiometricConsentFragment$onViewCreated$1$1$3(Object obj) {
        super(1, obj, BiometricConsentFragment.class, "onNavigationEventReceived", "onNavigationEventReceived(Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentNavigationEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BiometricConsentViewModel.BiometricConsentNavigationEvent biometricConsentNavigationEvent) {
        invoke2(biometricConsentNavigationEvent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BiometricConsentViewModel.BiometricConsentNavigationEvent p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((BiometricConsentFragment) this.receiver).onNavigationEventReceived(p0);
    }
}
