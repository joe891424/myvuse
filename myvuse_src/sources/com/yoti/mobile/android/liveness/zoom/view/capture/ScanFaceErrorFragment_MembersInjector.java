package com.yoti.mobile.android.liveness.zoom.view.capture;

import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class ScanFaceErrorFragment_MembersInjector implements MembersInjector<ScanFaceErrorFragment> {
    private final Provider<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> guidelinesViewDataFactoryProvider;

    public ScanFaceErrorFragment_MembersInjector(Provider<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> provider) {
        this.guidelinesViewDataFactoryProvider = provider;
    }

    public static MembersInjector<ScanFaceErrorFragment> create(Provider<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> provider) {
        return new ScanFaceErrorFragment_MembersInjector(provider);
    }

    public static void injectGuidelinesViewDataFactory(ScanFaceErrorFragment scanFaceErrorFragment, LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> factory) {
        scanFaceErrorFragment.guidelinesViewDataFactory = factory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ScanFaceErrorFragment scanFaceErrorFragment) {
        injectGuidelinesViewDataFactory(scanFaceErrorFragment, this.guidelinesViewDataFactoryProvider.get());
    }
}
