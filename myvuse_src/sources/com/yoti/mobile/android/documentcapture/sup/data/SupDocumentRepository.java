package com.yoti.mobile.android.documentcapture.sup.data;

import com.yoti.mobile.android.documentcapture.data.AssessmentEntityToAssessmentResultMapper;
import com.yoti.mobile.android.documentcapture.data.remote.model.AssessmentsResults;
import com.yoti.mobile.android.documentcapture.domain.IDocumentRepository;
import com.yoti.mobile.android.documentcapture.sup.data.remote.SupDocumentCaptureApiService;
import com.yoti.mobile.android.documentcapture.sup.data.remote.SupDocumentUploadService;
import com.yoti.mobile.android.documentcapture.sup.data.remote.model.OcrData;
import com.yoti.mobile.android.documentcapture.sup.data.remote.model.SupplementaryDocument;
import com.yoti.mobile.android.documentcapture.sup.domain.model.SupplementaryDocumentEntity;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import com.yoti.mobile.android.yotidocs.common.extension.CompletableKt;
import com.yoti.mobile.android.yotidocs.common.extension.FlowableKt;
import com.yoti.mobile.android.yotisdkcore.core.data.model.StateType;
import com.yoti.mobile.android.yotisdkcore.core.data.model.Task;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.IResourceConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/data/SupDocumentRepository;", "Lcom/yoti/mobile/android/documentcapture/domain/IDocumentRepository;", "Lcom/yoti/mobile/android/documentcapture/sup/domain/model/SupplementaryDocumentEntity;", "documentUploadService", "Lcom/yoti/mobile/android/documentcapture/sup/data/remote/SupDocumentUploadService;", "documentApiService", "Lcom/yoti/mobile/android/documentcapture/sup/data/remote/SupDocumentCaptureApiService;", "resourceConfigDataSource", "Lcom/yoti/mobile/android/yotisdkcore/core/data/repository/IResourceConfigurationCacheDataStore;", "entityToDataMapper", "Lcom/yoti/mobile/android/documentcapture/sup/data/SupDocumentEntityToDataMapper;", "assessmentEntityToAssessmentResultMapper", "Lcom/yoti/mobile/android/documentcapture/data/AssessmentEntityToAssessmentResultMapper;", "exceptionToEntityMapper", "Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;", "(Lcom/yoti/mobile/android/documentcapture/sup/data/remote/SupDocumentUploadService;Lcom/yoti/mobile/android/documentcapture/sup/data/remote/SupDocumentCaptureApiService;Lcom/yoti/mobile/android/yotisdkcore/core/data/repository/IResourceConfigurationCacheDataStore;Lcom/yoti/mobile/android/documentcapture/sup/data/SupDocumentEntityToDataMapper;Lcom/yoti/mobile/android/documentcapture/data/AssessmentEntityToAssessmentResultMapper;Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;)V", "isTextExtractionTaskNeeded", "", "setAssessmentsResults", "Lio/reactivex/Completable;", "resourceId", "", "ibvClientAssessments", "", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$IbvClientAssessmentEntity;", "upload", "Lio/reactivex/Flowable;", "", "document", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentRepository implements IDocumentRepository<SupplementaryDocumentEntity> {
    private final AssessmentEntityToAssessmentResultMapper assessmentEntityToAssessmentResultMapper;
    private final SupDocumentCaptureApiService documentApiService;
    private final SupDocumentUploadService documentUploadService;
    private final SupDocumentEntityToDataMapper entityToDataMapper;
    private final RemoteExceptionToEntityMapper exceptionToEntityMapper;
    private final IResourceConfigurationCacheDataStore resourceConfigDataSource;

    @Inject
    public SupDocumentRepository(SupDocumentUploadService documentUploadService, SupDocumentCaptureApiService documentApiService, IResourceConfigurationCacheDataStore resourceConfigDataSource, SupDocumentEntityToDataMapper entityToDataMapper, AssessmentEntityToAssessmentResultMapper assessmentEntityToAssessmentResultMapper, RemoteExceptionToEntityMapper exceptionToEntityMapper) {
        Intrinsics.checkNotNullParameter(documentUploadService, "documentUploadService");
        Intrinsics.checkNotNullParameter(documentApiService, "documentApiService");
        Intrinsics.checkNotNullParameter(resourceConfigDataSource, "resourceConfigDataSource");
        Intrinsics.checkNotNullParameter(entityToDataMapper, "entityToDataMapper");
        Intrinsics.checkNotNullParameter(assessmentEntityToAssessmentResultMapper, "assessmentEntityToAssessmentResultMapper");
        Intrinsics.checkNotNullParameter(exceptionToEntityMapper, "exceptionToEntityMapper");
        this.documentUploadService = documentUploadService;
        this.documentApiService = documentApiService;
        this.resourceConfigDataSource = resourceConfigDataSource;
        this.entityToDataMapper = entityToDataMapper;
        this.assessmentEntityToAssessmentResultMapper = assessmentEntityToAssessmentResultMapper;
        this.exceptionToEntityMapper = exceptionToEntityMapper;
    }

    private final boolean isTextExtractionTaskNeeded() {
        Object next;
        Iterator<T> it2 = this.resourceConfigDataSource.getResourceConfiguration().getTasks().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            Task task = (Task) next;
            if (task.getType() == Task.TaskType.SUPPLEMENTARY_DOCUMENT_TEXT_DATA_EXTRACTION && task.getState() == StateType.REQUIRED) {
                break;
            }
        }
        return next != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: upload$lambda-0, reason: not valid java name */
    public static final SupplementaryDocument m6826upload$lambda0(SupDocumentRepository this$0, SupplementaryDocumentEntity document) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(document, "$document");
        return SupplementaryDocument.copy$default(this$0.entityToDataMapper.map(document), null, null, null, this$0.isTextExtractionTaskNeeded() ? new OcrData(null, 1, null) : null, 7, null);
    }

    @Override // com.yoti.mobile.android.documentcapture.domain.IDocumentRepository
    public Completable setAssessmentsResults(String resourceId, List<DocumentResourceConfigEntity.IbvClientAssessmentEntity> ibvClientAssessments) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(ibvClientAssessments, "ibvClientAssessments");
        AssessmentEntityToAssessmentResultMapper assessmentEntityToAssessmentResultMapper = this.assessmentEntityToAssessmentResultMapper;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(ibvClientAssessments, 10));
        Iterator<T> it2 = ibvClientAssessments.iterator();
        while (it2.hasNext()) {
            arrayList.add(assessmentEntityToAssessmentResultMapper.map((DocumentResourceConfigEntity.IbvClientAssessmentEntity) it2.next()));
        }
        return CompletableKt.onErrorMapToErrorEntity(this.documentApiService.setAssessmentsResults(resourceId, new AssessmentsResults(arrayList)), this.exceptionToEntityMapper);
    }

    @Override // com.yoti.mobile.android.documentcapture.domain.IDocumentRepository
    public Flowable<Double> upload(final SupplementaryDocumentEntity document) {
        Intrinsics.checkNotNullParameter(document, "document");
        Single singleFromCallable = Single.fromCallable(new Callable() { // from class: com.yoti.mobile.android.documentcapture.sup.data.SupDocumentRepository$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SupDocumentRepository.m6826upload$lambda0(this.f$0, document);
            }
        });
        final SupDocumentUploadService supDocumentUploadService = this.documentUploadService;
        Flowable flowableFlatMapPublisher = singleFromCallable.flatMapPublisher(new Function() { // from class: com.yoti.mobile.android.documentcapture.sup.data.SupDocumentRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return supDocumentUploadService.execute((SupplementaryDocument) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flowableFlatMapPublisher, "fromCallable {\n         …ntUploadService::execute)");
        return FlowableKt.onErrorMapToErrorEntity(flowableFlatMapPublisher, this.exceptionToEntityMapper);
    }
}
