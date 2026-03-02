package com.yoti.mobile.android.documentcapture.domain;

import com.yoti.mobile.android.documentcapture.domain.model.IDocumentEntity;
import com.yoti.mobile.android.yotidocs.common.FlowableUseCase;
import com.yoti.mobile.android.yotidocs.common.error.YotiSdkResourceLockedError;
import com.yoti.mobile.android.yotisdkcore.core.data.ResourceConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Completable;
import io.reactivex.Flowable;
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
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B#\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016J\u001e\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00020\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0003H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/UploadDocumentInteractor;", "Lcom/yoti/mobile/android/yotidocs/common/FlowableUseCase;", "", "Lcom/yoti/mobile/android/documentcapture/domain/model/IDocumentEntity;", "documentRepository", "Lcom/yoti/mobile/android/documentcapture/domain/IDocumentRepository;", "resourceConfigurationRepository", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ResourceConfigurationRepository;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "(Lcom/yoti/mobile/android/documentcapture/domain/IDocumentRepository;Lcom/yoti/mobile/android/yotisdkcore/core/data/ResourceConfigurationRepository;)V", "approveAssessments", "Lio/reactivex/Completable;", "resourceId", "", "resourceConfigEntity", "buildUseCase", "Lio/reactivex/Flowable;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "upload", "kotlin.jvm.PlatformType", "documentEntity", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class UploadDocumentInteractor extends FlowableUseCase<Double, IDocumentEntity> {
    private final IDocumentRepository<IDocumentEntity> documentRepository;
    private final ResourceConfigurationRepository<DocumentResourceConfigEntity> resourceConfigurationRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public UploadDocumentInteractor(IDocumentRepository<IDocumentEntity> documentRepository, ResourceConfigurationRepository<DocumentResourceConfigEntity> resourceConfigurationRepository) {
        super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(documentRepository, "documentRepository");
        Intrinsics.checkNotNullParameter(resourceConfigurationRepository, "resourceConfigurationRepository");
        this.documentRepository = documentRepository;
        this.resourceConfigurationRepository = resourceConfigurationRepository;
    }

    private final Completable approveAssessments(String resourceId, DocumentResourceConfigEntity resourceConfigEntity) {
        if (resourceConfigEntity.getIbvClientAssessments().isEmpty()) {
            Completable completableComplete = Completable.complete();
            Intrinsics.checkNotNullExpressionValue(completableComplete, "complete()");
            return completableComplete;
        }
        IDocumentRepository<IDocumentEntity> iDocumentRepository = this.documentRepository;
        List<DocumentResourceConfigEntity.IbvClientAssessmentEntity> ibvClientAssessments = resourceConfigEntity.getIbvClientAssessments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(ibvClientAssessments, 10));
        Iterator<T> it2 = ibvClientAssessments.iterator();
        while (it2.hasNext()) {
            arrayList.add(DocumentResourceConfigEntity.IbvClientAssessmentEntity.copy$default((DocumentResourceConfigEntity.IbvClientAssessmentEntity) it2.next(), null, null, DocumentResourceConfigEntity.AssessmentStateEntity.APPROVED, 3, null));
        }
        return iDocumentRepository.setAssessmentsResults(resourceId, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: buildUseCase$lambda-2, reason: not valid java name */
    public static final Publisher m6803buildUseCase$lambda2(final UploadDocumentInteractor this$0, final IDocumentEntity iDocumentEntity, DocumentResourceConfigEntity it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it2, "it");
        return this$0.approveAssessments(iDocumentEntity.getResourceInfo().getId(), it2).andThen(Flowable.defer(new Callable() { // from class: com.yoti.mobile.android.documentcapture.domain.UploadDocumentInteractor$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UploadDocumentInteractor.m6804buildUseCase$lambda2$lambda1(this.f$0, iDocumentEntity);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: buildUseCase$lambda-2$lambda-1, reason: not valid java name */
    public static final Publisher m6804buildUseCase$lambda2$lambda1(UploadDocumentInteractor this$0, IDocumentEntity iDocumentEntity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.upload(iDocumentEntity);
    }

    private final Flowable<Double> upload(IDocumentEntity documentEntity) {
        Flowable<Double> flowableOnErrorResumeNext = this.documentRepository.upload(documentEntity).onErrorResumeNext(new Function() { // from class: com.yoti.mobile.android.documentcapture.domain.UploadDocumentInteractor$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UploadDocumentInteractor.m6805upload$lambda4((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flowableOnErrorResumeNext, "documentRepository.uploa…rror(error)\n            }");
        return flowableOnErrorResumeNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: upload$lambda-4, reason: not valid java name */
    public static final Publisher m6805upload$lambda4(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return error instanceof YotiSdkResourceLockedError ? Flowable.just(Double.valueOf(1.0d)) : Flowable.error(error);
    }

    @Override // com.yoti.mobile.android.yotidocs.common.FlowableUseCase
    public Flowable<Double> buildUseCase(final IDocumentEntity params) throws IllegalArgumentException {
        if (params == null) {
            throw new IllegalArgumentException("A Document is needed to make the upload!".toString());
        }
        Flowable<Double> flowableFlatMapPublisher = this.resourceConfigurationRepository.getResourceConfiguration().flatMapPublisher(new Function() { // from class: com.yoti.mobile.android.documentcapture.domain.UploadDocumentInteractor$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UploadDocumentInteractor.m6803buildUseCase$lambda2(this.f$0, params, (DocumentResourceConfigEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flowableFlatMapPublisher, "resourceConfigurationRep…load(params) })\n        }");
        return flowableFlatMapPublisher;
    }
}
