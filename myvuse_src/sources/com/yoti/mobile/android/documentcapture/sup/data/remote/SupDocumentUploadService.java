package com.yoti.mobile.android.documentcapture.sup.data.remote;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.yoti.mobile.android.documentcapture.data.remote.model.PageInfo;
import com.yoti.mobile.android.documentcapture.sup.data.remote.model.SupplementaryDocument;
import com.yoti.mobile.android.remote.MimeType;
import com.yoti.mobile.android.remote.MimeTypeProvider;
import com.yoti.mobile.android.remote.MultiPartBodyFactory;
import com.yoti.mobile.android.remote.UploadService;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0014J9\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00022%\u0010\u0011\u001a!\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0012j\u0002`\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J7\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00022%\u0010\u0011\u001a!\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0012j\u0002`\u0017H\u0002J7\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00022%\u0010\u0011\u001a!\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0012j\u0002`\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/data/remote/SupDocumentUploadService;", "Lcom/yoti/mobile/android/remote/UploadService;", "Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/SupplementaryDocument;", "apiService", "Lcom/yoti/mobile/android/documentcapture/sup/data/remote/SupDocumentCaptureApiService;", "multiPartBodyFactory", "Lcom/yoti/mobile/android/remote/MultiPartBodyFactory;", "mimeTypeProvider", "Lcom/yoti/mobile/android/remote/MimeTypeProvider;", "(Lcom/yoti/mobile/android/documentcapture/sup/data/remote/SupDocumentCaptureApiService;Lcom/yoti/mobile/android/remote/MultiPartBodyFactory;Lcom/yoti/mobile/android/remote/MimeTypeProvider;)V", "buildRequest", "Lio/reactivex/Flowable;", "", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "sendDocument", "", "document", "progressListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "progressFraction", "", "Lcom/yoti/mobile/android/remote/ProgressListener;", "sendDocumentOcrResult", "sendImageFile", "Lio/reactivex/Completable;", "sendPdfFile", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentUploadService extends UploadService<SupplementaryDocument> {
    private final SupDocumentCaptureApiService apiService;
    private final MimeTypeProvider mimeTypeProvider;
    private final MultiPartBodyFactory multiPartBodyFactory;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MimeType.values().length];
            iArr[MimeType.PDF.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public SupDocumentUploadService(SupDocumentCaptureApiService apiService, MultiPartBodyFactory multiPartBodyFactory, MimeTypeProvider mimeTypeProvider) {
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        Intrinsics.checkNotNullParameter(multiPartBodyFactory, "multiPartBodyFactory");
        Intrinsics.checkNotNullParameter(mimeTypeProvider, "mimeTypeProvider");
        this.apiService = apiService;
        this.multiPartBodyFactory = multiPartBodyFactory;
        this.mimeTypeProvider = mimeTypeProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: buildRequest$lambda-1, reason: not valid java name */
    public static final void m6828buildRequest$lambda1(SupplementaryDocument supplementaryDocument, SupDocumentUploadService this$0, final FlowableEmitter emitter) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        try {
        } catch (Throwable th) {
            emitter.tryOnError(th);
        }
        if (supplementaryDocument == null) {
            throw new IllegalArgumentException("Document is mandatory to make the upload".toString());
        }
        this$0.sendDocument(supplementaryDocument, new Function1<Double, Unit>() { // from class: com.yoti.mobile.android.documentcapture.sup.data.remote.SupDocumentUploadService$buildRequest$1$2
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
        this$0.sendDocumentOcrResult(supplementaryDocument);
        emitter.onComplete();
    }

    private final Void sendDocument(SupplementaryDocument document, Function1<? super Double, Unit> progressListener) throws Throwable {
        Throwable thBlockingGet = (WhenMappings.$EnumSwitchMapping$0[this.mimeTypeProvider.getMimeType(document.getFileUri()).ordinal()] == 1 ? sendPdfFile(document, progressListener) : sendImageFile(document, progressListener)).blockingGet();
        if (thBlockingGet == null) {
            return null;
        }
        throw thBlockingGet;
    }

    private final void sendDocumentOcrResult(SupplementaryDocument document) throws Throwable {
        Throwable thBlockingGet;
        if (document.getOcrData() != null && (thBlockingGet = this.apiService.startTextExtractionTask(document.getResourceInfo().getId(), document.getOcrData()).blockingGet()) != null) {
            throw thBlockingGet;
        }
    }

    private final Completable sendImageFile(SupplementaryDocument document, final Function1<? super Double, Unit> progressListener) {
        SupDocumentCaptureApiService supDocumentCaptureApiService = this.apiService;
        String id = document.getResourceInfo().getId();
        MultiPartBodyFactory multiPartBodyFactory = this.multiPartBodyFactory;
        Gson gson = new Gson();
        PageInfo pageInfo = document.getPageInfo();
        String json = !(gson instanceof Gson) ? gson.toJson(pageInfo) : GsonInstrumentation.toJson(gson, pageInfo);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(document.pageInfo)");
        return supDocumentCaptureApiService.createDocumentImage(id, 1, MultiPartBodyFactory.create$default(multiPartBodyFactory, json, null, null, 6, null), this.multiPartBodyFactory.create(document.getFileUri(), new Function2<Long, Long, Unit>() { // from class: com.yoti.mobile.android.documentcapture.sup.data.remote.SupDocumentUploadService.sendImageFile.1
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
        }));
    }

    private final Completable sendPdfFile(SupplementaryDocument document, final Function1<? super Double, Unit> progressListener) {
        SupDocumentCaptureApiService supDocumentCaptureApiService = this.apiService;
        String id = document.getResourceInfo().getId();
        MultiPartBodyFactory multiPartBodyFactory = this.multiPartBodyFactory;
        Gson gson = new Gson();
        PageInfo pageInfo = document.getPageInfo();
        String json = !(gson instanceof Gson) ? gson.toJson(pageInfo) : GsonInstrumentation.toJson(gson, pageInfo);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(document.pageInfo)");
        return supDocumentCaptureApiService.createDocumentFile(id, MultiPartBodyFactory.create$default(multiPartBodyFactory, json, null, null, 6, null), this.multiPartBodyFactory.create(document.getFileUri(), new Function2<Long, Long, Unit>() { // from class: com.yoti.mobile.android.documentcapture.sup.data.remote.SupDocumentUploadService.sendPdfFile.1
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
        }));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.remote.FlowableService
    public Flowable<Double> buildRequest(final SupplementaryDocument params) {
        Flowable<Double> flowableCreate = Flowable.create(new FlowableOnSubscribe() { // from class: com.yoti.mobile.android.documentcapture.sup.data.remote.SupDocumentUploadService$$ExternalSyntheticLambda0
            @Override // io.reactivex.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) {
                SupDocumentUploadService.m6828buildRequest$lambda1(params, this, flowableEmitter);
            }
        }, BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowableCreate, "create({ emitter ->\n    …kpressureStrategy.LATEST)");
        return flowableCreate;
    }
}
