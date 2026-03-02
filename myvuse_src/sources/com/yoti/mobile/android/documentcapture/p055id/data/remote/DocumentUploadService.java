package com.yoti.mobile.android.documentcapture.p055id.data.remote;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.yoti.mobile.android.documentcapture.data.remote.model.DocumentPage;
import com.yoti.mobile.android.documentcapture.data.remote.model.PageInfo;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.IdDocument;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.OcrResult;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.TextExtractionException;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.TextExtractionResponse;
import com.yoti.mobile.android.documentcapture.p055id.p056di.ForSessionFeedbackActivation;
import com.yoti.mobile.android.remote.MultiPartBodyFactory;
import com.yoti.mobile.android.remote.UploadService;
import com.yoti.mobile.android.yotisdkcore.core.data.model.ResourceConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.data.model.SessionConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.data.model.StateType;
import com.yoti.mobile.android.yotisdkcore.core.data.remote.SdkCoreApiService;
import com.yoti.mobile.android.yotisdkcore.core.p085di.RequirementId;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.MultipartBody;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002Jd\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2:\u0010\u001f\u001a6\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00130 j\u0002`&H\u0002J7\u0010'\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022%\u0010\u001f\u001a!\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00130(j\u0002`*H\u0002J\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00162\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010-\u001a\u00020.H\u0002J\\\u0010/\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\n2\u0006\u00100\u001a\u0002012\u0006\u0010\u001c\u001a\u00020\u001d2:\u0010\u001f\u001a6\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00130 j\u0002`&H\u0002J7\u00102\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022%\u0010\u001f\u001a!\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00130(j\u0002`*H\u0002J\u0012\u00103\u001a\u00020\u001d*\b\u0012\u0004\u0012\u00020504H\u0002J\u0014\u00106\u001a\u00020\f*\u00020\u00172\u0006\u00107\u001a\u00020\u0017H\u0002J\u0014\u00108\u001a\u000209*\u00020,2\u0006\u0010:\u001a\u00020\u0017H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/DocumentUploadService;", "Lcom/yoti/mobile/android/remote/UploadService;", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/IdDocument;", "multipartBodyFactory", "Lcom/yoti/mobile/android/remote/MultiPartBodyFactory;", "apiService", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/DocumentCaptureApiService;", "sdkCoreApiService", "Lcom/yoti/mobile/android/yotisdkcore/core/data/remote/SdkCoreApiService;", "requirementId", "", "isSessionFeedbackEnabled", "", "(Lcom/yoti/mobile/android/remote/MultiPartBodyFactory;Lcom/yoti/mobile/android/documentcapture/id/data/remote/DocumentCaptureApiService;Lcom/yoti/mobile/android/yotisdkcore/core/data/remote/SdkCoreApiService;Ljava/lang/String;Z)V", "buildRequest", "Lio/reactivex/Flowable;", "", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "executeTextExtraction", "", "document", "getSessionConfiguration", "Lio/reactivex/Single;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/SessionConfiguration;", "sendDocumentFrame", "resourceId", TypedValues.AttributesType.S_FRAME, "Ljava/io/File;", "pageNumber", "", "frameNumber", "progressListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "bytesWritten", "totalBytes", "Lcom/yoti/mobile/android/remote/ProgressRequestBodyListener;", "sendDocumentNfcResult", "Lkotlin/Function1;", "progressFraction", "Lcom/yoti/mobile/android/remote/ProgressListener;", "sendDocumentOcrResult", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse;", "ocrData", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/OcrResult;", "sendDocumentPage", "page", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/DocumentPage;", "sendDocumentPages", "completedRequirements", "", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration;", "isAnotherRequirementCompleted", "other", "validate", "Lio/reactivex/Completable;", "sessionStateBeforeTextExtraction", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentUploadService extends UploadService<IdDocument> {
    private final DocumentCaptureApiService apiService;
    private final boolean isSessionFeedbackEnabled;
    private final MultiPartBodyFactory multipartBodyFactory;
    private final String requirementId;
    private final SdkCoreApiService sdkCoreApiService;

    @Inject
    public DocumentUploadService(MultiPartBodyFactory multipartBodyFactory, DocumentCaptureApiService apiService, SdkCoreApiService sdkCoreApiService, @RequirementId String requirementId, @ForSessionFeedbackActivation boolean z) {
        Intrinsics.checkNotNullParameter(multipartBodyFactory, "multipartBodyFactory");
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        Intrinsics.checkNotNullParameter(sdkCoreApiService, "sdkCoreApiService");
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        this.multipartBodyFactory = multipartBodyFactory;
        this.apiService = apiService;
        this.sdkCoreApiService = sdkCoreApiService;
        this.requirementId = requirementId;
        this.isSessionFeedbackEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: buildRequest$lambda-1, reason: not valid java name */
    public static final void m6810buildRequest$lambda1(IdDocument idDocument, DocumentUploadService this$0, final FlowableEmitter emitter) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        if (idDocument != null) {
            try {
                final double d = idDocument.getChipData() != null ? 0.9d : 1.0d;
                this$0.sendDocumentPages(idDocument, new Function1<Double, Unit>() { // from class: com.yoti.mobile.android.documentcapture.id.data.remote.DocumentUploadService$buildRequest$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Double d2) {
                        invoke(d2.doubleValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(double d2) {
                        emitter.onNext(Double.valueOf(d2 * d));
                    }
                });
                this$0.sendDocumentNfcResult(idDocument, new Function1<Double, Unit>() { // from class: com.yoti.mobile.android.documentcapture.id.data.remote.DocumentUploadService$buildRequest$1$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Double d2) {
                        invoke(d2.doubleValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(double d2) {
                        emitter.onNext(Double.valueOf(d + (d2 * 0.1d)));
                    }
                });
                this$0.executeTextExtraction(idDocument);
                emitter.onComplete();
            } catch (Throwable th) {
                emitter.tryOnError(th);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            emitter.onError(new IllegalArgumentException("Document is mandatory to make the upload"));
        }
    }

    private final int completedRequirements(List<ResourceConfiguration> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            ResourceConfiguration resourceConfiguration = (ResourceConfiguration) obj;
            if (resourceConfiguration.getState() == StateType.COMPLETE && !Intrinsics.areEqual(resourceConfiguration.getRequirementId(), this.requirementId)) {
                arrayList.add(obj);
            }
        }
        return arrayList.size();
    }

    private final void executeTextExtraction(final IdDocument document) throws Throwable {
        Throwable thBlockingGet;
        if (document.getOcrData() != null && (thBlockingGet = getSessionConfiguration().flatMapCompletable(new Function() { // from class: com.yoti.mobile.android.documentcapture.id.data.remote.DocumentUploadService$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DocumentUploadService.m6811executeTextExtraction$lambda10(this.f$0, document, (SessionConfiguration) obj);
            }
        }).blockingGet()) != null) {
            throw thBlockingGet;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: executeTextExtraction$lambda-10, reason: not valid java name */
    public static final CompletableSource m6811executeTextExtraction$lambda10(final DocumentUploadService this$0, IdDocument document, final SessionConfiguration sessionConfiguration) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(document, "$document");
        Intrinsics.checkNotNullParameter(sessionConfiguration, "sessionConfiguration");
        return this$0.sendDocumentOcrResult(document.getResourceInfo().getId(), document.getOcrData()).flatMapCompletable(new Function() { // from class: com.yoti.mobile.android.documentcapture.id.data.remote.DocumentUploadService$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DocumentUploadService.m6812executeTextExtraction$lambda10$lambda9(this.f$0, sessionConfiguration, (TextExtractionResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: executeTextExtraction$lambda-10$lambda-9, reason: not valid java name */
    public static final CompletableSource m6812executeTextExtraction$lambda10$lambda9(DocumentUploadService this$0, SessionConfiguration sessionConfiguration, TextExtractionResponse textExtractionResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sessionConfiguration, "$sessionConfiguration");
        Intrinsics.checkNotNullParameter(textExtractionResponse, "textExtractionResponse");
        return this$0.validate(textExtractionResponse, sessionConfiguration);
    }

    private final Single<SessionConfiguration> getSessionConfiguration() {
        return this.sdkCoreApiService.getSessionConfiguration();
    }

    private final boolean isAnotherRequirementCompleted(SessionConfiguration sessionConfiguration, SessionConfiguration sessionConfiguration2) {
        return completedRequirements(sessionConfiguration.getResourcesConfiguration()) != completedRequirements(sessionConfiguration2.getResourcesConfiguration());
    }

    private final void sendDocumentFrame(String resourceId, File frame, int pageNumber, int frameNumber, Function2<? super Long, ? super Long, Unit> progressListener) throws Throwable {
        Throwable thBlockingGet = this.apiService.createDocumentFrame(resourceId, pageNumber, frameNumber, this.multipartBodyFactory.create(frame, progressListener)).blockingGet();
        if (thBlockingGet != null) {
            throw thBlockingGet;
        }
    }

    private final void sendDocumentNfcResult(IdDocument document, final Function1<? super Double, Unit> progressListener) throws Throwable {
        Throwable thBlockingGet;
        if (document.getChipData() != null && (thBlockingGet = this.apiService.createDocumentNfc(document.getResourceInfo().getId(), this.multipartBodyFactory.create(document.getChipData(), new Function2<Long, Long, Unit>() { // from class: com.yoti.mobile.android.documentcapture.id.data.remote.DocumentUploadService.sendDocumentNfcResult.1
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
        })).blockingGet()) != null) {
            throw thBlockingGet;
        }
    }

    private final Single<TextExtractionResponse> sendDocumentOcrResult(String resourceId, OcrResult ocrData) {
        return this.apiService.createDocumentOCR(resourceId, this.isSessionFeedbackEnabled, ocrData);
    }

    private final void sendDocumentPage(String resourceId, DocumentPage page, int pageNumber, Function2<? super Long, ? super Long, Unit> progressListener) throws Throwable {
        MultipartBody.Part partCreate$default;
        PageInfo imageInfo = page.getImageInfo();
        if (imageInfo != null) {
            MultiPartBodyFactory multiPartBodyFactory = this.multipartBodyFactory;
            Gson gson = new Gson();
            String json = !(gson instanceof Gson) ? gson.toJson(imageInfo) : GsonInstrumentation.toJson(gson, imageInfo);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(it)");
            partCreate$default = MultiPartBodyFactory.create$default(multiPartBodyFactory, json, null, null, 6, null);
        } else {
            partCreate$default = null;
        }
        Throwable thBlockingGet = this.apiService.createDocumentPage(resourceId, pageNumber, partCreate$default, this.multipartBodyFactory.create(page.getImage(), progressListener)).blockingGet();
        if (thBlockingGet != null) {
            throw thBlockingGet;
        }
    }

    private final void sendDocumentPages(IdDocument document, final Function1<? super Double, Unit> progressListener) throws Throwable {
        final Ref.IntRef intRef = new Ref.IntRef();
        List<DocumentPage> pages = document.getPages();
        int size = pages.size();
        Iterator<T> it2 = pages.iterator();
        int size2 = 0;
        while (it2.hasNext()) {
            size2 += ((DocumentPage) it2.next()).getFrames().size();
        }
        final int i = size + size2;
        Function2<Long, Long, Unit> function2 = new Function2<Long, Long, Unit>() { // from class: com.yoti.mobile.android.documentcapture.id.data.remote.DocumentUploadService$sendDocumentPages$fileProgressListener$1
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
                progressListener.invoke(Double.valueOf(this.this$0.calculateUploadProgress(j, j2, intRef.element, i)));
            }
        };
        int i2 = 0;
        for (Object obj : document.getPages()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DocumentPage documentPage = (DocumentPage) obj;
            sendDocumentPage(document.getResourceInfo().getId(), documentPage, i3, function2);
            intRef.element++;
            int i4 = 0;
            for (Object obj2 : documentPage.getFrames()) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                sendDocumentFrame(document.getResourceInfo().getId(), (File) obj2, i3, i5, function2);
                intRef.element++;
                i4 = i5;
            }
            i2 = i3;
        }
    }

    private final Completable validate(TextExtractionResponse textExtractionResponse, final SessionConfiguration sessionConfiguration) {
        try {
            textExtractionResponse.validate(this.isSessionFeedbackEnabled);
            Completable completableComplete = Completable.complete();
            Intrinsics.checkNotNullExpressionValue(completableComplete, "{\n                this.v….complete()\n            }");
            return completableComplete;
        } catch (TextExtractionException e) {
            Completable completableFlatMapCompletable = getSessionConfiguration().flatMapCompletable(new Function() { // from class: com.yoti.mobile.android.documentcapture.id.data.remote.DocumentUploadService$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return DocumentUploadService.m6813validate$lambda13(this.f$0, sessionConfiguration, e, (SessionConfiguration) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(completableFlatMapCompletable, "{\n                getSes…          }\n            }");
            return completableFlatMapCompletable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: validate$lambda-13, reason: not valid java name */
    public static final CompletableSource m6813validate$lambda13(DocumentUploadService this$0, SessionConfiguration sessionStateBeforeTextExtraction, TextExtractionException error, SessionConfiguration sesssionstateAfterTextExtraction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sessionStateBeforeTextExtraction, "$sessionStateBeforeTextExtraction");
        Intrinsics.checkNotNullParameter(error, "$error");
        Intrinsics.checkNotNullParameter(sesssionstateAfterTextExtraction, "sesssionstateAfterTextExtraction");
        return this$0.isAnotherRequirementCompleted(sessionStateBeforeTextExtraction, sesssionstateAfterTextExtraction) ? Completable.complete() : Completable.error(error);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.remote.FlowableService
    public Flowable<Double> buildRequest(final IdDocument params) {
        Flowable<Double> flowableCreate = Flowable.create(new FlowableOnSubscribe() { // from class: com.yoti.mobile.android.documentcapture.id.data.remote.DocumentUploadService$$ExternalSyntheticLambda0
            @Override // io.reactivex.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) {
                DocumentUploadService.m6810buildRequest$lambda1(params, this, flowableEmitter);
            }
        }, BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowableCreate, "create({ emitter ->\n    …kpressureStrategy.LATEST)");
        return flowableCreate;
    }
}
