package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.yoti.mobile.android.documentcapture.p054di.IDocumentSelectionDependenciesProvider;
import com.yoti.mobile.android.documentcapture.sup.view.SupDocumentFeatureErrorToFailureMapper;
import com.yoti.mobile.android.documentcapture.sup.view.selection.SupDocumentConfigToDocSelectionViewDataMapper;
import com.yoti.mobile.android.documentcapture.sup.view.selection.SupDocumentEducationalArgumentsToViewDataMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/di/SupplementaryDocumentSelectionDependenciesProvider;", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentSelectionDependenciesProvider;", "docResourceConfigToSelectionViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/sup/view/selection/SupDocumentConfigToDocSelectionViewDataMapper;", "documentEducationalArgumentsToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/sup/view/selection/SupDocumentEducationalArgumentsToViewDataMapper;", "documentFeatureErrorToFailureMapper", "Lcom/yoti/mobile/android/documentcapture/sup/view/SupDocumentFeatureErrorToFailureMapper;", "(Lcom/yoti/mobile/android/documentcapture/sup/view/selection/SupDocumentConfigToDocSelectionViewDataMapper;Lcom/yoti/mobile/android/documentcapture/sup/view/selection/SupDocumentEducationalArgumentsToViewDataMapper;Lcom/yoti/mobile/android/documentcapture/sup/view/SupDocumentFeatureErrorToFailureMapper;)V", "getDocResourceConfigToSelectionViewDataMapper", "()Lcom/yoti/mobile/android/documentcapture/sup/view/selection/SupDocumentConfigToDocSelectionViewDataMapper;", "getDocumentEducationalArgumentsToViewDataMapper", "()Lcom/yoti/mobile/android/documentcapture/sup/view/selection/SupDocumentEducationalArgumentsToViewDataMapper;", "getDocumentFeatureErrorToFailureMapper", "()Lcom/yoti/mobile/android/documentcapture/sup/view/SupDocumentFeatureErrorToFailureMapper;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupplementaryDocumentSelectionDependenciesProvider implements IDocumentSelectionDependenciesProvider {
    private final SupDocumentConfigToDocSelectionViewDataMapper docResourceConfigToSelectionViewDataMapper;
    private final SupDocumentEducationalArgumentsToViewDataMapper documentEducationalArgumentsToViewDataMapper;
    private final SupDocumentFeatureErrorToFailureMapper documentFeatureErrorToFailureMapper;

    @Inject
    public SupplementaryDocumentSelectionDependenciesProvider(SupDocumentConfigToDocSelectionViewDataMapper docResourceConfigToSelectionViewDataMapper, SupDocumentEducationalArgumentsToViewDataMapper documentEducationalArgumentsToViewDataMapper, SupDocumentFeatureErrorToFailureMapper documentFeatureErrorToFailureMapper) {
        Intrinsics.checkNotNullParameter(docResourceConfigToSelectionViewDataMapper, "docResourceConfigToSelectionViewDataMapper");
        Intrinsics.checkNotNullParameter(documentEducationalArgumentsToViewDataMapper, "documentEducationalArgumentsToViewDataMapper");
        Intrinsics.checkNotNullParameter(documentFeatureErrorToFailureMapper, "documentFeatureErrorToFailureMapper");
        this.docResourceConfigToSelectionViewDataMapper = docResourceConfigToSelectionViewDataMapper;
        this.documentEducationalArgumentsToViewDataMapper = documentEducationalArgumentsToViewDataMapper;
        this.documentFeatureErrorToFailureMapper = documentFeatureErrorToFailureMapper;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.IDocumentSelectionDependenciesProvider
    public SupDocumentConfigToDocSelectionViewDataMapper getDocResourceConfigToSelectionViewDataMapper() {
        return this.docResourceConfigToSelectionViewDataMapper;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.IDocumentSelectionDependenciesProvider
    public SupDocumentEducationalArgumentsToViewDataMapper getDocumentEducationalArgumentsToViewDataMapper() {
        return this.documentEducationalArgumentsToViewDataMapper;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.IDocumentSelectionDependenciesProvider
    public SupDocumentFeatureErrorToFailureMapper getDocumentFeatureErrorToFailureMapper() {
        return this.documentFeatureErrorToFailureMapper;
    }
}
