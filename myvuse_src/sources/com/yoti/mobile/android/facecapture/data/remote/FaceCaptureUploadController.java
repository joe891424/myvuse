package com.yoti.mobile.android.facecapture.data.remote;

import com.yoti.mobile.android.facecapture.data.remote.model.FaceCaptureData;
import com.yoti.mobile.android.facecapture.data.remote.model.FaceCaptureUploadResponse;
import com.yoti.mobile.android.facecapture.data.remote.model.FaceCaptureValidationException;
import com.yoti.mobile.android.facecapture.data.remote.model.SecurityContent;
import com.yoti.mobile.android.remote.MultiPartBodyFactory;
import com.yoti.mobile.android.remote.UploadService;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0014J7\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022%\u0010\u0011\u001a!\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000f0\u0012j\u0002`\u0016H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/data/remote/FaceCaptureUploadController;", "Lcom/yoti/mobile/android/remote/UploadService;", "Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureData;", "multipartBodyFactory", "Lcom/yoti/mobile/android/remote/MultiPartBodyFactory;", "securityContentFactory", "Lcom/yoti/mobile/android/facecapture/data/remote/model/SecurityContent$Factory;", "faceCaptureApiService", "Lcom/yoti/mobile/android/facecapture/data/remote/IFaceCaptureApiService;", "(Lcom/yoti/mobile/android/remote/MultiPartBodyFactory;Lcom/yoti/mobile/android/facecapture/data/remote/model/SecurityContent$Factory;Lcom/yoti/mobile/android/facecapture/data/remote/IFaceCaptureApiService;)V", "buildRequest", "Lio/reactivex/Flowable;", "", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "sendFaceCapture", "", "faceCapture", "progressListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "progressFraction", "Lcom/yoti/mobile/android/remote/ProgressListener;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureUploadController extends UploadService<FaceCaptureData> {
    private final IFaceCaptureApiService faceCaptureApiService;
    private final MultiPartBodyFactory multipartBodyFactory;
    private final SecurityContent.Factory securityContentFactory;

    @Inject
    public FaceCaptureUploadController(MultiPartBodyFactory multipartBodyFactory, SecurityContent.Factory securityContentFactory, IFaceCaptureApiService faceCaptureApiService) {
        Intrinsics.checkNotNullParameter(multipartBodyFactory, "multipartBodyFactory");
        Intrinsics.checkNotNullParameter(securityContentFactory, "securityContentFactory");
        Intrinsics.checkNotNullParameter(faceCaptureApiService, "faceCaptureApiService");
        this.multipartBodyFactory = multipartBodyFactory;
        this.securityContentFactory = securityContentFactory;
        this.faceCaptureApiService = faceCaptureApiService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: buildRequest$lambda-1, reason: not valid java name */
    public static final void m6856buildRequest$lambda1(FaceCaptureData faceCaptureData, FaceCaptureUploadController this$0, final FlowableEmitter emitter) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        try {
        } catch (Throwable th) {
            emitter.tryOnError(th);
        }
        if (faceCaptureData == null) {
            throw new IllegalArgumentException("FaceCapture is required to make the upload".toString());
        }
        this$0.sendFaceCapture(faceCaptureData, new Function1<Double, Unit>() { // from class: com.yoti.mobile.android.facecapture.data.remote.FaceCaptureUploadController$buildRequest$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Double d) {
                invoke(d.doubleValue());
                return Unit.INSTANCE;
            }

            public final void invoke(double d) {
                emitter.onNext(Double.valueOf(d));
            }
        });
        emitter.onComplete();
    }

    private final void sendFaceCapture(FaceCaptureData faceCapture, final Function1<? super Double, Unit> progressListener) throws FaceCaptureValidationException {
        IFaceCaptureApiService iFaceCaptureApiService = this.faceCaptureApiService;
        String resourceId = faceCapture.getResourceId();
        MultipartBody.Part partCreate = this.multipartBodyFactory.create(faceCapture.getCapture(), new Function2<Long, Long, Unit>() { // from class: com.yoti.mobile.android.facecapture.data.remote.FaceCaptureUploadController.sendFaceCapture.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
                invoke(l.longValue(), l2.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j, long j2) {
                progressListener.invoke(Double.valueOf(j / j2));
            }
        });
        SecurityContent securityContentCreate = this.securityContentFactory.create();
        FaceCaptureUploadResponse faceCaptureUploadResponseBlockingGet = iFaceCaptureApiService.uploadFaceCapture(resourceId, partCreate, securityContentCreate != null ? MultiPartBodyFactory.create$default(this.multipartBodyFactory, securityContentCreate.getValue(), securityContentCreate.getName(), null, 4, null) : null).blockingGet();
        if (faceCaptureUploadResponseBlockingGet != null && !faceCaptureUploadResponseBlockingGet.getAccepted()) {
            throw new FaceCaptureValidationException(faceCaptureUploadResponseBlockingGet.getCode(), faceCaptureUploadResponseBlockingGet.getRetriesRemaining());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.remote.FlowableService
    public Flowable<Double> buildRequest(final FaceCaptureData params) {
        Flowable<Double> flowableCreate = Flowable.create(new FlowableOnSubscribe() { // from class: com.yoti.mobile.android.facecapture.data.remote.FaceCaptureUploadController$$ExternalSyntheticLambda0
            @Override // io.reactivex.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) {
                FaceCaptureUploadController.m6856buildRequest$lambda1(params, this, flowableEmitter);
            }
        }, BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowableCreate, "create({ emitter ->\n    …kpressureStrategy.LATEST)");
        return flowableCreate;
    }
}
