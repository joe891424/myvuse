package com.yoti.mobile.android.documentcapture.p055id.data;

import com.yoti.mobile.android.documentcapture.data.AssessmentEntityToAssessmentResultMapper;
import com.yoti.mobile.android.documentcapture.data.remote.model.AssessmentsResults;
import com.yoti.mobile.android.documentcapture.domain.IDocumentRepository;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.DocumentCaptureApiService;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.DocumentUploadService;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.IdDocument;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentEntity;
import com.yoti.mobile.android.yotidocs.common.extension.CompletableKt;
import com.yoti.mobile.android.yotidocs.common.extension.FlowableKt;
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
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0002H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/IdDocumentRepository;", "Lcom/yoti/mobile/android/documentcapture/domain/IDocumentRepository;", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentEntity;", "uploadService", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/DocumentUploadService;", "documentApiService", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/DocumentCaptureApiService;", "documentEntityToDataMapper", "Lcom/yoti/mobile/android/documentcapture/id/data/DocumentEntityToDataMapper;", "assessmentEntityToAssessmentResultMapper", "Lcom/yoti/mobile/android/documentcapture/data/AssessmentEntityToAssessmentResultMapper;", "exceptionToEntityMapper", "Lcom/yoti/mobile/android/documentcapture/id/data/UploadExceptionToEntityMapper;", "(Lcom/yoti/mobile/android/documentcapture/id/data/remote/DocumentUploadService;Lcom/yoti/mobile/android/documentcapture/id/data/remote/DocumentCaptureApiService;Lcom/yoti/mobile/android/documentcapture/id/data/DocumentEntityToDataMapper;Lcom/yoti/mobile/android/documentcapture/data/AssessmentEntityToAssessmentResultMapper;Lcom/yoti/mobile/android/documentcapture/id/data/UploadExceptionToEntityMapper;)V", "setAssessmentsResults", "Lio/reactivex/Completable;", "resourceId", "", "ibvClientAssessments", "", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$IbvClientAssessmentEntity;", "upload", "Lio/reactivex/Flowable;", "", "document", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentRepository implements IDocumentRepository<IdDocumentEntity> {
    private final AssessmentEntityToAssessmentResultMapper assessmentEntityToAssessmentResultMapper;
    private final DocumentCaptureApiService documentApiService;
    private final DocumentEntityToDataMapper documentEntityToDataMapper;
    private final UploadExceptionToEntityMapper exceptionToEntityMapper;
    private final DocumentUploadService uploadService;

    @Inject
    public IdDocumentRepository(DocumentUploadService uploadService, DocumentCaptureApiService documentApiService, DocumentEntityToDataMapper documentEntityToDataMapper, AssessmentEntityToAssessmentResultMapper assessmentEntityToAssessmentResultMapper, UploadExceptionToEntityMapper exceptionToEntityMapper) {
        Intrinsics.checkNotNullParameter(uploadService, "uploadService");
        Intrinsics.checkNotNullParameter(documentApiService, "documentApiService");
        Intrinsics.checkNotNullParameter(documentEntityToDataMapper, "documentEntityToDataMapper");
        Intrinsics.checkNotNullParameter(assessmentEntityToAssessmentResultMapper, "assessmentEntityToAssessmentResultMapper");
        Intrinsics.checkNotNullParameter(exceptionToEntityMapper, "exceptionToEntityMapper");
        this.uploadService = uploadService;
        this.documentApiService = documentApiService;
        this.documentEntityToDataMapper = documentEntityToDataMapper;
        this.assessmentEntityToAssessmentResultMapper = assessmentEntityToAssessmentResultMapper;
        this.exceptionToEntityMapper = exceptionToEntityMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: upload$lambda-0, reason: not valid java name */
    public static final IdDocument m6806upload$lambda0(IdDocumentRepository this$0, IdDocumentEntity document) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(document, "$document");
        return this$0.documentEntityToDataMapper.map(document);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: upload$lambda-1, reason: not valid java name */
    public static final Publisher m6807upload$lambda1(IdDocumentRepository this$0, IdDocument it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it2, "it");
        return FlowableKt.onErrorMapToErrorEntity(this$0.uploadService.execute(it2), this$0.exceptionToEntityMapper);
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
    public Flowable<Double> upload(final IdDocumentEntity document) {
        Intrinsics.checkNotNullParameter(document, "document");
        Flowable<Double> flowableFlatMapPublisher = Single.fromCallable(new Callable() { // from class: com.yoti.mobile.android.documentcapture.id.data.IdDocumentRepository$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return IdDocumentRepository.m6806upload$lambda0(this.f$0, document);
            }
        }).flatMapPublisher(new Function() { // from class: com.yoti.mobile.android.documentcapture.id.data.IdDocumentRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return IdDocumentRepository.m6807upload$lambda1(this.f$0, (IdDocument) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flowableFlatMapPublisher, "fromCallable {\n        d…tionToEntityMapper)\n    }");
        return flowableFlatMapPublisher;
    }
}
