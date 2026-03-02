package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewData;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
public final class SelectionModule_ProvidesEntityToSelectionViewDataFactory implements Factory<Mapper<DocumentResourceConfigEntity, DocumentSelectionViewData>> {
    private final SelectionModule module;

    public SelectionModule_ProvidesEntityToSelectionViewDataFactory(SelectionModule selectionModule) {
        this.module = selectionModule;
    }

    public static SelectionModule_ProvidesEntityToSelectionViewDataFactory create(SelectionModule selectionModule) {
        return new SelectionModule_ProvidesEntityToSelectionViewDataFactory(selectionModule);
    }

    public static Mapper<DocumentResourceConfigEntity, DocumentSelectionViewData> providesEntityToSelectionViewData(SelectionModule selectionModule) {
        return (Mapper) Preconditions.checkNotNullFromProvides(selectionModule.providesEntityToSelectionViewData());
    }

    @Override // javax.inject.Provider
    public Mapper<DocumentResourceConfigEntity, DocumentSelectionViewData> get() {
        return providesEntityToSelectionViewData(this.module);
    }
}
