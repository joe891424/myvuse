package com.yoti.mobile.android.documentcapture.p055id.p056di;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.documentcapture.p055id.view.verify.VerifyYourDetailsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.di.IdDocumentCaptureViewModelModule_ProvidesVerifyYourDetailsViewModelFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4624x4df2cdeb implements Factory<ViewModel> {
    private final IdDocumentCaptureViewModelModule module;
    private final Provider<VerifyYourDetailsViewModel> viewModelProvider;

    public C4624x4df2cdeb(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<VerifyYourDetailsViewModel> provider) {
        this.module = idDocumentCaptureViewModelModule;
        this.viewModelProvider = provider;
    }

    public static C4624x4df2cdeb create(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<VerifyYourDetailsViewModel> provider) {
        return new C4624x4df2cdeb(idDocumentCaptureViewModelModule, provider);
    }

    public static ViewModel providesVerifyYourDetailsViewModel(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, VerifyYourDetailsViewModel verifyYourDetailsViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(idDocumentCaptureViewModelModule.providesVerifyYourDetailsViewModel(verifyYourDetailsViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesVerifyYourDetailsViewModel(this.module, this.viewModelProvider.get());
    }
}
