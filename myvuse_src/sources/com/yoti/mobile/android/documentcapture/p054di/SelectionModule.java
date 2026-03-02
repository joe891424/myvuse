package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalArgumentsToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewData;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0017J\b\u0010\t\u001a\u00020\nH\u0017J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u0006H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/di/SelectionModule;", "", "dependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentSelectionDependenciesProvider;", "(Lcom/yoti/mobile/android/documentcapture/di/IDocumentSelectionDependenciesProvider;)V", "provideDocumentFeatureErrorToFailureMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "providesDocumentEducationalArgumentsToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalArgumentsToViewDataMapper;", "providesEntityToSelectionViewData", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewData;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class SelectionModule {
    private final IDocumentSelectionDependenciesProvider dependenciesProvider;

    public SelectionModule(IDocumentSelectionDependenciesProvider dependenciesProvider) {
        Intrinsics.checkNotNullParameter(dependenciesProvider, "dependenciesProvider");
        this.dependenciesProvider = dependenciesProvider;
    }

    @Provides
    @DocumentSelection
    public Mapper<Throwable, YdsFailure> provideDocumentFeatureErrorToFailureMapper() {
        return this.dependenciesProvider.getDocumentFeatureErrorToFailureMapper();
    }

    @Provides
    public DocumentEducationalArgumentsToViewDataMapper providesDocumentEducationalArgumentsToViewDataMapper() {
        return this.dependenciesProvider.getDocumentEducationalArgumentsToViewDataMapper();
    }

    @Provides
    public Mapper<DocumentResourceConfigEntity, DocumentSelectionViewData> providesEntityToSelectionViewData() {
        return this.dependenciesProvider.getDocResourceConfigToSelectionViewDataMapper();
    }
}
