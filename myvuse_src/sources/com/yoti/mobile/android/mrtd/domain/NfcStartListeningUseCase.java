package com.yoti.mobile.android.mrtd.domain;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/domain/NfcStartListeningUseCase;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yoti/mobile/android/mrtd/domain/INfcReadController;", "(Lcom/yoti/mobile/android/mrtd/domain/INfcReadController;)V", "invoke", "", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NfcStartListeningUseCase {
    private final INfcReadController listener;

    @Inject
    public NfcStartListeningUseCase(INfcReadController listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void invoke() {
        this.listener.registerForReadBroadcasts();
    }
}
