package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalArgumentsToViewDataMapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.di.SelectionModule_ProvidesDocumentEducationalArgumentsToViewDataMapperFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4603x60b7e788 implements Factory<DocumentEducationalArgumentsToViewDataMapper> {
    private final SelectionModule module;

    public C4603x60b7e788(SelectionModule selectionModule) {
        this.module = selectionModule;
    }

    public static C4603x60b7e788 create(SelectionModule selectionModule) {
        return new C4603x60b7e788(selectionModule);
    }

    public static DocumentEducationalArgumentsToViewDataMapper providesDocumentEducationalArgumentsToViewDataMapper(SelectionModule selectionModule) {
        return (DocumentEducationalArgumentsToViewDataMapper) Preconditions.checkNotNullFromProvides(selectionModule.providesDocumentEducationalArgumentsToViewDataMapper());
    }

    @Override // javax.inject.Provider
    public DocumentEducationalArgumentsToViewDataMapper get() {
        return providesDocumentEducationalArgumentsToViewDataMapper(this.module);
    }
}
