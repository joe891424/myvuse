package com.yoti.mobile.android.documentcapture.view.upload;

import androidx.lifecycle.ViewModelKt;
import com.yoti.mobile.android.documentcapture.domain.IDocumentCleanupInteractor;
import com.yoti.mobile.android.documentcapture.domain.UploadDocumentInteractor;
import com.yoti.mobile.android.documentcapture.domain.model.IDocumentEntity;
import com.yoti.mobile.android.documentcapture.p054di.DocumentUpload;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.SuspendMapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadState;
import com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B_\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\u0019\b\u0001\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0015H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0002H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0002H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0092\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0092\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/upload/DocumentUploadViewModel;", "Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadViewModel;", "Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;", "uploadDocumentInteractor", "Lcom/yoti/mobile/android/documentcapture/domain/UploadDocumentInteractor;", "documentCleanupInteractor", "Lcom/yoti/mobile/android/documentcapture/domain/IDocumentCleanupInteractor;", "documentScanResultViewDataToEntityMapper", "Lcom/yoti/mobile/android/yotidocs/common/SuspendMapper;", "Lcom/yoti/mobile/android/documentcapture/domain/model/IDocumentEntity;", "Lkotlin/jvm/JvmSuppressWildcards;", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "errorToSessionStatusTypeMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;", "errorToFailureMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "(Lcom/yoti/mobile/android/documentcapture/domain/UploadDocumentInteractor;Lcom/yoti/mobile/android/documentcapture/domain/IDocumentCleanupInteractor;Lcom/yoti/mobile/android/yotidocs/common/SuspendMapper;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;Lcom/yoti/mobile/android/yotidocs/common/Mapper;)V", "cleanupResources", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeUpload", "uploadableData", "onCleared", "upload", "viewData", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class DocumentUploadViewModel extends UploadViewModel<IDocumentViewData> {
    private final IDocumentCleanupInteractor documentCleanupInteractor;
    private final SuspendMapper<IDocumentViewData, IDocumentEntity> documentScanResultViewDataToEntityMapper;
    private final UploadDocumentInteractor uploadDocumentInteractor;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadViewModel$executeUpload$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadViewModel$executeUpload$1", m5608f = "DocumentUploadViewModel.kt", m5609i = {}, m5610l = {45}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IDocumentViewData $uploadableData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C46941(IDocumentViewData iDocumentViewData, Continuation<? super C46941> continuation) {
            super(2, continuation);
            this.$uploadableData = iDocumentViewData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DocumentUploadViewModel.this.new C46941(this.$uploadableData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DocumentUploadViewModel.this.uploadDocumentInteractor.clear();
                SuspendMapper suspendMapper = DocumentUploadViewModel.this.documentScanResultViewDataToEntityMapper;
                IDocumentViewData iDocumentViewData = this.$uploadableData;
                this.label = 1;
                obj = suspendMapper.map(iDocumentViewData, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            DocumentUploadViewModel.this.uploadDocumentInteractor.execute((IDocumentEntity) obj, new UploadViewModel.UploadObserver());
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DocumentUploadViewModel(UploadDocumentInteractor uploadDocumentInteractor, IDocumentCleanupInteractor iDocumentCleanupInteractor, SuspendMapper<IDocumentViewData, IDocumentEntity> documentScanResultViewDataToEntityMapper, SessionStatus sessionStatus, @DocumentUpload ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper, @DocumentUpload Mapper<Throwable, YdsFailure> errorToFailureMapper) {
        super(sessionStatus, errorToSessionStatusTypeMapper, errorToFailureMapper);
        Intrinsics.checkNotNullParameter(uploadDocumentInteractor, "uploadDocumentInteractor");
        Intrinsics.checkNotNullParameter(documentScanResultViewDataToEntityMapper, "documentScanResultViewDataToEntityMapper");
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        Intrinsics.checkNotNullParameter(errorToSessionStatusTypeMapper, "errorToSessionStatusTypeMapper");
        Intrinsics.checkNotNullParameter(errorToFailureMapper, "errorToFailureMapper");
        this.uploadDocumentInteractor = uploadDocumentInteractor;
        this.documentCleanupInteractor = iDocumentCleanupInteractor;
        this.documentScanResultViewDataToEntityMapper = documentScanResultViewDataToEntityMapper;
    }

    static /* synthetic */ Object cleanupResources$suspendImpl(DocumentUploadViewModel documentUploadViewModel, Continuation continuation) {
        IDocumentCleanupInteractor iDocumentCleanupInteractor = documentUploadViewModel.documentCleanupInteractor;
        if (iDocumentCleanupInteractor != null) {
            Object objCleanupResources = iDocumentCleanupInteractor.cleanupResources(continuation);
            return objCleanupResources == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCleanupResources : Unit.INSTANCE;
        }
        if (IntrinsicsKt.getCOROUTINE_SUSPENDED() == null) {
            return null;
        }
        return Unit.INSTANCE;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadViewModel
    protected Object cleanupResources(Continuation<? super Unit> continuation) {
        return cleanupResources$suspendImpl(this, (Continuation) continuation);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        this.uploadDocumentInteractor.clear();
        super.onCleared();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadViewModel
    public void executeUpload(IDocumentViewData uploadableData) {
        Intrinsics.checkNotNullParameter(uploadableData, "uploadableData");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C46941(uploadableData, null), 3, null);
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadViewModel, com.yoti.mobile.android.yotisdkcore.core.view.upload.ViewDataUploader
    public void upload(IDocumentViewData viewData) {
        Intrinsics.checkNotNullParameter(viewData, "viewData");
        if (Intrinsics.areEqual(getUploadState(), UploadState.Finished.INSTANCE)) {
            setUploadAsSuccess();
        } else {
            super.upload(viewData);
        }
    }
}
