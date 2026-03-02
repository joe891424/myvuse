package com.yoti.mobile.android.mrtd.domain;

import com.google.firebase.perf.util.Constants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/domain/NfcEnabledInteractor;", "", "repository", "Lcom/yoti/mobile/android/mrtd/domain/INfcStateRepository;", "(Lcom/yoti/mobile/android/mrtd/domain/INfcStateRepository;)V", Constants.ENABLE_DISABLE, "", "()Z", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NfcEnabledInteractor {
    private final INfcStateRepository repository;

    @Inject
    public NfcEnabledInteractor(INfcStateRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final boolean isEnabled() {
        return this.repository.getState().getAdapterEnabled();
    }
}
