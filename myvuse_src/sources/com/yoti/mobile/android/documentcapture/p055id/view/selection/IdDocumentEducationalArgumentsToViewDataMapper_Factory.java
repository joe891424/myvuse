package com.yoti.mobile.android.documentcapture.p055id.view.selection;

import com.yoti.mobile.android.common.p049ui.components.utils.IDemonymProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocumentEducationalArgumentsToViewDataMapper_Factory implements Factory<IdDocumentEducationalArgumentsToViewDataMapper> {
    private final Provider<IDemonymProvider> demonymProvider;

    public IdDocumentEducationalArgumentsToViewDataMapper_Factory(Provider<IDemonymProvider> provider) {
        this.demonymProvider = provider;
    }

    public static IdDocumentEducationalArgumentsToViewDataMapper_Factory create(Provider<IDemonymProvider> provider) {
        return new IdDocumentEducationalArgumentsToViewDataMapper_Factory(provider);
    }

    public static IdDocumentEducationalArgumentsToViewDataMapper newInstance(IDemonymProvider iDemonymProvider) {
        return new IdDocumentEducationalArgumentsToViewDataMapper(iDemonymProvider);
    }

    @Override // javax.inject.Provider
    public IdDocumentEducationalArgumentsToViewDataMapper get() {
        return newInstance(this.demonymProvider.get());
    }
}
