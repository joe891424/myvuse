package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.documentcapture.p054di.IDocumentSelectionDependenciesProvider;
import com.yoti.mobile.android.documentcapture.p055id.view.IdDocumentFeatureErrorToFailureMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.selection.IdDocConfigToDocSelectionViewDataMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.selection.IdDocumentEducationalArgumentsToViewDataMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentSelectionDependenciesProvider;", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentSelectionDependenciesProvider;", "docResourceConfigToSelectionViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/id/view/selection/IdDocConfigToDocSelectionViewDataMapper;", "documentEducationalArgumentsToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/id/view/selection/IdDocumentEducationalArgumentsToViewDataMapper;", "documentFeatureErrorToFailureMapper", "Lcom/yoti/mobile/android/documentcapture/id/view/IdDocumentFeatureErrorToFailureMapper;", "(Lcom/yoti/mobile/android/documentcapture/id/view/selection/IdDocConfigToDocSelectionViewDataMapper;Lcom/yoti/mobile/android/documentcapture/id/view/selection/IdDocumentEducationalArgumentsToViewDataMapper;Lcom/yoti/mobile/android/documentcapture/id/view/IdDocumentFeatureErrorToFailureMapper;)V", "getDocResourceConfigToSelectionViewDataMapper", "()Lcom/yoti/mobile/android/documentcapture/id/view/selection/IdDocConfigToDocSelectionViewDataMapper;", "getDocumentEducationalArgumentsToViewDataMapper", "()Lcom/yoti/mobile/android/documentcapture/id/view/selection/IdDocumentEducationalArgumentsToViewDataMapper;", "getDocumentFeatureErrorToFailureMapper", "()Lcom/yoti/mobile/android/documentcapture/id/view/IdDocumentFeatureErrorToFailureMapper;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentSelectionDependenciesProvider implements IDocumentSelectionDependenciesProvider {
    private final IdDocConfigToDocSelectionViewDataMapper docResourceConfigToSelectionViewDataMapper;
    private final IdDocumentEducationalArgumentsToViewDataMapper documentEducationalArgumentsToViewDataMapper;
    private final IdDocumentFeatureErrorToFailureMapper documentFeatureErrorToFailureMapper;

    @Inject
    public IdDocumentSelectionDependenciesProvider(IdDocConfigToDocSelectionViewDataMapper docResourceConfigToSelectionViewDataMapper, IdDocumentEducationalArgumentsToViewDataMapper documentEducationalArgumentsToViewDataMapper, IdDocumentFeatureErrorToFailureMapper documentFeatureErrorToFailureMapper) {
        Intrinsics.checkNotNullParameter(docResourceConfigToSelectionViewDataMapper, "docResourceConfigToSelectionViewDataMapper");
        Intrinsics.checkNotNullParameter(documentEducationalArgumentsToViewDataMapper, "documentEducationalArgumentsToViewDataMapper");
        Intrinsics.checkNotNullParameter(documentFeatureErrorToFailureMapper, "documentFeatureErrorToFailureMapper");
        this.docResourceConfigToSelectionViewDataMapper = docResourceConfigToSelectionViewDataMapper;
        this.documentEducationalArgumentsToViewDataMapper = documentEducationalArgumentsToViewDataMapper;
        this.documentFeatureErrorToFailureMapper = documentFeatureErrorToFailureMapper;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.IDocumentSelectionDependenciesProvider
    public IdDocConfigToDocSelectionViewDataMapper getDocResourceConfigToSelectionViewDataMapper() {
        return this.docResourceConfigToSelectionViewDataMapper;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.IDocumentSelectionDependenciesProvider
    public IdDocumentEducationalArgumentsToViewDataMapper getDocumentEducationalArgumentsToViewDataMapper() {
        return this.documentEducationalArgumentsToViewDataMapper;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.IDocumentSelectionDependenciesProvider
    public IdDocumentFeatureErrorToFailureMapper getDocumentFeatureErrorToFailureMapper() {
        return this.documentFeatureErrorToFailureMapper;
    }
}
