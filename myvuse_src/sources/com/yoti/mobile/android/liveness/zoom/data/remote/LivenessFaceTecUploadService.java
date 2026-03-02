package com.yoti.mobile.android.liveness.zoom.data.remote;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yoti.mobile.android.liveness.data.remote.model.LivenessUploadResponse;
import com.yoti.mobile.android.liveness.data.remote.model.LivenessValidationException;
import com.yoti.mobile.android.liveness.zoom.data.remote.model.LivenessFaceTecCapture;
import com.yoti.mobile.android.remote.MultiPartBodyFactory;
import com.yoti.mobile.android.remote.UploadService;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import java.io.File;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0014JG\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132%\u0010\u0014\u001a!\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r0\u0015j\u0002`\u0019H\u0002J7\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00022%\u0010\u0014\u001a!\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r0\u0015j\u0002`\u0019H\u0002J\\\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00132:\u0010\u0014\u001a6\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\r0\u001fj\u0002`#H\u0002J7\u0010$\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00022%\u0010\u0014\u001a!\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r0\u0015j\u0002`\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/data/remote/LivenessFaceTecUploadService;", "Lcom/yoti/mobile/android/remote/UploadService;", "Lcom/yoti/mobile/android/liveness/zoom/data/remote/model/LivenessFaceTecCapture;", "multipartBodyFactory", "Lcom/yoti/mobile/android/remote/MultiPartBodyFactory;", "livenessFaceTecApiService", "Lcom/yoti/mobile/android/liveness/zoom/data/remote/LivenessFaceTecApiService;", "(Lcom/yoti/mobile/android/remote/MultiPartBodyFactory;Lcom/yoti/mobile/android/liveness/zoom/data/remote/LivenessFaceTecApiService;)V", "buildRequest", "Lio/reactivex/Flowable;", "", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "sendFaceTecLivenesFaceMap", "", "resourceId", "", "faceMap", "Ljava/io/File;", "documentNumber", "", "progressListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "progressFraction", "Lcom/yoti/mobile/android/remote/ProgressListener;", "sendFaceTecLivenessCapture", "faceTecLivenessCapture", "sendFaceTecLivenessFrame", TypedValues.AttributesType.S_FRAME, "page", "Lkotlin/Function2;", "", "bytesWritten", "totalBytes", "Lcom/yoti/mobile/android/remote/ProgressRequestBodyListener;", "sendFaceTecLivenessFrames", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessFaceTecUploadService extends UploadService<LivenessFaceTecCapture> {
    private final LivenessFaceTecApiService livenessFaceTecApiService;
    private final MultiPartBodyFactory multipartBodyFactory;

    @Inject
    public LivenessFaceTecUploadService(MultiPartBodyFactory multipartBodyFactory, LivenessFaceTecApiService livenessFaceTecApiService) {
        Intrinsics.checkNotNullParameter(multipartBodyFactory, "multipartBodyFactory");
        Intrinsics.checkNotNullParameter(livenessFaceTecApiService, "livenessFaceTecApiService");
        this.multipartBodyFactory = multipartBodyFactory;
        this.livenessFaceTecApiService = livenessFaceTecApiService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: buildRequest$lambda-1, reason: not valid java name */
    public static final void m6878buildRequest$lambda1(LivenessFaceTecCapture livenessFaceTecCapture, LivenessFaceTecUploadService this$0, FlowableEmitter emitter) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        if (livenessFaceTecCapture != null) {
            try {
                this$0.sendFaceTecLivenessCapture(livenessFaceTecCapture, new LivenessFaceTecUploadService$buildRequest$1$1$1(emitter));
                emitter.onComplete();
            } catch (Throwable th) {
                emitter.tryOnError(th);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalArgumentException("LivenessFaceTecCapture is mandatory to make the upload");
        }
    }

    private final void sendFaceTecLivenesFaceMap(String resourceId, File faceMap, final int documentNumber, final Function1<? super Double, Unit> progressListener) throws LivenessValidationException {
        LivenessUploadResponse livenessUploadResponseBlockingGet = this.livenessFaceTecApiService.createLivenessFaceTecFacemap(resourceId, this.multipartBodyFactory.create(faceMap, new Function2<Long, Long, Unit>() { // from class: com.yoti.mobile.android.liveness.zoom.data.remote.LivenessFaceTecUploadService$sendFaceTecLivenesFaceMap$faceMapPart$1
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
                LivenessFaceTecUploadService livenessFaceTecUploadService = this.this$0;
                int i = documentNumber;
                progressListener.invoke(Double.valueOf(livenessFaceTecUploadService.calculateUploadProgress(j, j2, i, i)));
            }
        })).blockingGet();
        if (livenessUploadResponseBlockingGet != null && !livenessUploadResponseBlockingGet.getAccepted()) {
            throw new LivenessValidationException(livenessUploadResponseBlockingGet.getRetriesRemaining());
        }
    }

    private final void sendFaceTecLivenessCapture(LivenessFaceTecCapture faceTecLivenessCapture, Function1<? super Double, Unit> progressListener) throws Throwable {
        sendFaceTecLivenessFrames(faceTecLivenessCapture, progressListener);
        sendFaceTecLivenesFaceMap(faceTecLivenessCapture.getResourceId(), faceTecLivenessCapture.getFaceMap(), faceTecLivenessCapture.getFileCount() - 1, progressListener);
    }

    private final void sendFaceTecLivenessFrame(String resourceId, File frame, int page, Function2<? super Long, ? super Long, Unit> progressListener) throws Throwable {
        Throwable thBlockingGet = this.livenessFaceTecApiService.createLivenessFaceTecFrame(resourceId, page, this.multipartBodyFactory.create(frame, progressListener)).blockingGet();
        if (thBlockingGet != null) {
            throw thBlockingGet;
        }
    }

    private final void sendFaceTecLivenessFrames(final LivenessFaceTecCapture faceTecLivenessCapture, final Function1<? super Double, Unit> progressListener) throws Throwable {
        final int i = 0;
        for (Object obj : faceTecLivenessCapture.getFrames()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            sendFaceTecLivenessFrame(faceTecLivenessCapture.getResourceId(), (File) obj, i2, new Function2<Long, Long, Unit>() { // from class: com.yoti.mobile.android.liveness.zoom.data.remote.LivenessFaceTecUploadService$sendFaceTecLivenessFrames$1$1
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
                    progressListener.invoke(Double.valueOf(this.this$0.calculateUploadProgress(j, j2, i, faceTecLivenessCapture.getFileCount())));
                }
            });
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.remote.FlowableService
    public Flowable<Double> buildRequest(final LivenessFaceTecCapture params) {
        Flowable<Double> flowableCreate = Flowable.create(new FlowableOnSubscribe() { // from class: com.yoti.mobile.android.liveness.zoom.data.remote.LivenessFaceTecUploadService$$ExternalSyntheticLambda0
            @Override // io.reactivex.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) {
                LivenessFaceTecUploadService.m6878buildRequest$lambda1(params, this, flowableEmitter);
            }
        }, BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowableCreate, "create({ emitter ->\n    …kpressureStrategy.LATEST)");
        return flowableCreate;
    }
}
