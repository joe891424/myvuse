package com.yoti.mobile.android.liveness.domain;

import com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity;
import com.yoti.mobile.android.liveness.domain.model.LivenessValidationError;
import com.yoti.mobile.android.yotidocs.common.FlowableUseCase;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0015\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/domain/UploadLivenessCaptureInteractor;", "Lcom/yoti/mobile/android/yotidocs/common/FlowableUseCase;", "", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessCaptureEntity;", "livenessRepository", "Lcom/yoti/mobile/android/liveness/domain/ILivenessCaptureRepository;", "(Lcom/yoti/mobile/android/liveness/domain/ILivenessCaptureRepository;)V", "buildUseCase", "Lio/reactivex/Flowable;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class UploadLivenessCaptureInteractor extends FlowableUseCase<Double, ILivenessCaptureEntity> {
    private final ILivenessCaptureRepository<ILivenessCaptureEntity> livenessRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public UploadLivenessCaptureInteractor(ILivenessCaptureRepository<ILivenessCaptureEntity> livenessRepository) {
        super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(livenessRepository, "livenessRepository");
        this.livenessRepository = livenessRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: buildUseCase$lambda-1$lambda-0, reason: not valid java name */
    public static final Publisher m6864buildUseCase$lambda1$lambda0(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return (!(error instanceof LivenessValidationError) || ((LivenessValidationError) error).getF7491a()) ? Flowable.error(error) : Flowable.just(Double.valueOf(1.0d));
    }

    @Override // com.yoti.mobile.android.yotidocs.common.FlowableUseCase
    public Flowable<Double> buildUseCase(ILivenessCaptureEntity params) {
        if (params == null) {
            Flowable<Double> flowableError = Flowable.error(new IllegalArgumentException("A LivenessFaceTecCapture is needed to make the upload!"));
            Intrinsics.checkNotNullExpressionValue(flowableError, "error(IllegalArgumentExc…ed to make the upload!\"))");
            return flowableError;
        }
        if (params.isValid()) {
            Flowable<Double> flowableOnErrorResumeNext = this.livenessRepository.upload(params).onErrorResumeNext(new Function() { // from class: com.yoti.mobile.android.liveness.domain.UploadLivenessCaptureInteractor$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return UploadLivenessCaptureInteractor.m6864buildUseCase$lambda1$lambda0((Throwable) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(flowableOnErrorResumeNext, "{\n                livene…         }\n\n            }");
            return flowableOnErrorResumeNext;
        }
        Flowable<Double> flowableError2 = Flowable.error(new IllegalArgumentException("LivenessCapture validation error"));
        Intrinsics.checkNotNullExpressionValue(flowableError2, "{\n                Flowab…on error\"))\n            }");
        return flowableError2;
    }
}
