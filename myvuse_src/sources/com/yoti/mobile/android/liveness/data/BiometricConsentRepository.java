package com.yoti.mobile.android.liveness.data;

import com.yoti.mobile.android.liveness.data.remote.GiveBiometricConsentService;
import com.yoti.mobile.android.liveness.domain.IBiometricConsentRepository;
import com.yoti.mobile.android.remote.CompletableService;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import com.yoti.mobile.android.yotidocs.common.extension.CompletableKt;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/data/BiometricConsentRepository;", "Lcom/yoti/mobile/android/liveness/domain/IBiometricConsentRepository;", "giveBiometricConsentService", "Lcom/yoti/mobile/android/liveness/data/remote/GiveBiometricConsentService;", "remoteExceptionToEntityMapper", "Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;", "(Lcom/yoti/mobile/android/liveness/data/remote/GiveBiometricConsentService;Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;)V", "giveBiometricConsent", "Lio/reactivex/Completable;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class BiometricConsentRepository implements IBiometricConsentRepository {
    private final GiveBiometricConsentService giveBiometricConsentService;
    private final RemoteExceptionToEntityMapper remoteExceptionToEntityMapper;

    @Inject
    public BiometricConsentRepository(GiveBiometricConsentService giveBiometricConsentService, RemoteExceptionToEntityMapper remoteExceptionToEntityMapper) {
        Intrinsics.checkNotNullParameter(giveBiometricConsentService, "giveBiometricConsentService");
        Intrinsics.checkNotNullParameter(remoteExceptionToEntityMapper, "remoteExceptionToEntityMapper");
        this.giveBiometricConsentService = giveBiometricConsentService;
        this.remoteExceptionToEntityMapper = remoteExceptionToEntityMapper;
    }

    @Override // com.yoti.mobile.android.liveness.domain.IBiometricConsentRepository
    public Completable giveBiometricConsent() {
        return CompletableKt.onErrorMapToErrorEntity(CompletableService.execute$default(this.giveBiometricConsentService, null, 1, null), this.remoteExceptionToEntityMapper);
    }
}
