package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalArgumentsToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewData;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/di/IDocumentSelectionDependenciesProvider;", "", "docResourceConfigToSelectionViewDataMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewData;", "getDocResourceConfigToSelectionViewDataMapper", "()Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "documentEducationalArgumentsToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalArgumentsToViewDataMapper;", "getDocumentEducationalArgumentsToViewDataMapper", "()Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalArgumentsToViewDataMapper;", "documentFeatureErrorToFailureMapper", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "getDocumentFeatureErrorToFailureMapper", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IDocumentSelectionDependenciesProvider {
    Mapper<DocumentResourceConfigEntity, DocumentSelectionViewData> getDocResourceConfigToSelectionViewDataMapper();

    DocumentEducationalArgumentsToViewDataMapper getDocumentEducationalArgumentsToViewDataMapper();

    Mapper<Throwable, YdsFailure> getDocumentFeatureErrorToFailureMapper();
}
