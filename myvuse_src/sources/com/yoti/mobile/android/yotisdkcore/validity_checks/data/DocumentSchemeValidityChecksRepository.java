package com.yoti.mobile.android.yotisdkcore.validity_checks.data;

import com.yoti.mobile.android.yotisdkcore.core.data.remote.RemoteErrorToYdsErrorMapper;
import com.yoti.mobile.android.yotisdkcore.p082c.domain.IDocumentSchemeValidityChecksRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.data.c, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/DocumentSchemeValidityChecksRepository;", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/IDocumentSchemeValidityChecksRepository;", "remoteDataSource", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/IDocumentSchemeValidityChecksDataSource;", "assessmentEntityToValidityCheckRequestMapper", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/DocumentSchemeAssessmentEntityToValidityCheckRequestMapper;", "validityCheckToEntityMapper", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/DocumentSchemeValidityCheckDataToEntityMapper;", "remoteErrorToYdsErrorMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/remote/RemoteErrorToYdsErrorMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/IDocumentSchemeValidityChecksDataSource;Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/DocumentSchemeAssessmentEntityToValidityCheckRequestMapper;Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/DocumentSchemeValidityCheckDataToEntityMapper;Lcom/yoti/mobile/android/yotisdkcore/core/data/remote/RemoteErrorToYdsErrorMapper;)V", "getChecks", "Lcom/yoti/mobile/android/commons/functional/Either;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/model/RequirementsEntity;", "documentSchemeAssessment", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/IDocumentSchemeValidityChecksRepository$DocumentSchemeAssessmentEntity;", "(Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/IDocumentSchemeValidityChecksRepository$DocumentSchemeAssessmentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentSchemeValidityChecksRepository implements IDocumentSchemeValidityChecksRepository {

    /* JADX INFO: renamed from: a */
    private final IDocumentSchemeValidityChecksDataSource f7882a;

    @Inject
    public DocumentSchemeValidityChecksRepository(IDocumentSchemeValidityChecksDataSource remoteDataSource, DocumentSchemeAssessmentEntityToValidityCheckRequestMapper assessmentEntityToValidityCheckRequestMapper, DocumentSchemeValidityCheckDataToEntityMapper validityCheckToEntityMapper, RemoteErrorToYdsErrorMapper remoteErrorToYdsErrorMapper) {
        Intrinsics.checkNotNullParameter(remoteDataSource, "remoteDataSource");
        Intrinsics.checkNotNullParameter(assessmentEntityToValidityCheckRequestMapper, "assessmentEntityToValidityCheckRequestMapper");
        Intrinsics.checkNotNullParameter(validityCheckToEntityMapper, "validityCheckToEntityMapper");
        Intrinsics.checkNotNullParameter(remoteErrorToYdsErrorMapper, "remoteErrorToYdsErrorMapper");
        this.f7882a = remoteDataSource;
    }
}
