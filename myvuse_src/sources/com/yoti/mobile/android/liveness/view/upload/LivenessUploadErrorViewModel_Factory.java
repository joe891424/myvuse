package com.yoti.mobile.android.liveness.view.upload;

import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessUploadErrorViewModel_Factory implements Factory<LivenessUploadErrorViewModel> {
    private final Provider<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> factoryProvider;

    public LivenessUploadErrorViewModel_Factory(Provider<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> provider) {
        this.factoryProvider = provider;
    }

    public static LivenessUploadErrorViewModel_Factory create(Provider<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> provider) {
        return new LivenessUploadErrorViewModel_Factory(provider);
    }

    public static LivenessUploadErrorViewModel newInstance(LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> factory) {
        return new LivenessUploadErrorViewModel(factory);
    }

    @Override // javax.inject.Provider
    public LivenessUploadErrorViewModel get() {
        return newInstance(this.factoryProvider.get());
    }
}
