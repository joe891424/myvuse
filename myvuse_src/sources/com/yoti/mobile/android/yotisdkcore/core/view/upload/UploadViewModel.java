package com.yoti.mobile.android.yotisdkcore.core.view.upload;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yoti.mobile.android.commonui.SavedStateHandleHolder;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.Status;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType;
import com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadState;
import com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadableViewData;
import io.reactivex.subscribers.ResourceSubscriber;
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

/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005:\u0001;B5\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\t¢\u0006\u0002\u0010\u000eJ\u0011\u0010/\u001a\u00020\u0018H\u0094@ø\u0001\u0000¢\u0006\u0002\u00100J\u0015\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00028\u0000H$¢\u0006\u0002\u00103J\b\u00104\u001a\u00020\u0018H\u0012J\u0010\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0010H\u0016J\b\u00107\u001a\u00020\u0018H\u0015J\b\u00108\u001a\u00020\u0018H\u0015J\u0015\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103R\u000e\u0010\u000f\u001a\u00020\u0010X\u0092.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0012X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\tX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00108TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R$\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020'8T@TX\u0094\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010%\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006<"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadableViewData;", "Landroidx/lifecycle/ViewModel;", "Lcom/yoti/mobile/android/commonui/SavedStateHandleHolder;", "Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/ViewDataUploader;", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "errorToSessionStatusTypeMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatusType;", "errorToFailureMapper", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "(Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;Lcom/yoti/mobile/android/yotidocs/common/Mapper;Lcom/yoti/mobile/android/yotidocs/common/Mapper;)V", "_savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "_uploadProgress", "Landroidx/lifecycle/MutableLiveData;", "", "get_uploadProgress", "()Landroidx/lifecycle/MutableLiveData;", "_uploadStatus", "Lcom/yoti/mobile/android/yotidocs/common/Status;", "", "get_uploadStatus", "getErrorToFailureMapper", "()Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "getErrorToSessionStatusTypeMapper", "savedStateHandle", "getSavedStateHandle", "()Landroidx/lifecycle/SavedStateHandle;", "getSessionStatus", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "uploadProgress", "Landroidx/lifecycle/LiveData;", "getUploadProgress", "()Landroidx/lifecycle/LiveData;", "value", "Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadState;", "uploadState", "getUploadState", "()Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadState;", "setUploadState", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadState;)V", "uploadStatus", "getUploadStatus", "cleanupResources", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeUpload", "uploadableData", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadableViewData;)V", "handleUploadComplete", "setSavedStateHandle", "handle", "setUploadAsInitiated", "setUploadAsSuccess", "upload", "viewData", "UploadObserver", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class UploadViewModel<T extends UploadableViewData> extends ViewModel implements SavedStateHandleHolder, ViewDataUploader<T> {
    private SavedStateHandle _savedStateHandle;
    private final MutableLiveData<Double> _uploadProgress;
    private final MutableLiveData<Status<Unit>> _uploadStatus;
    private final Mapper<Throwable, YdsFailure> errorToFailureMapper;
    private final Mapper<Throwable, SessionStatusType> errorToSessionStatusTypeMapper;
    private final SessionStatus sessionStatus;

    /* JADX INFO: Access modifiers changed from: protected */
    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0094\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadViewModel$UploadObserver;", "Lio/reactivex/subscribers/ResourceSubscriber;", "", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadViewModel;)V", "onComplete", "", "onError", "throwable", "", "onNext", "progress", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public class UploadObserver extends ResourceSubscriber<Double> {
        public UploadObserver() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UploadViewModel.this.handleUploadComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            UploadViewModel.this.get_uploadStatus().setValue(new Status.Error(UploadViewModel.this.getErrorToFailureMapper().map(throwable)));
            UploadViewModel.this.getSessionStatus().setSessionStatus(UploadViewModel.this.getErrorToSessionStatusTypeMapper().map(throwable));
        }

        public void onNext(double progress) {
            UploadViewModel.this.get_uploadProgress().setValue(Double.valueOf(progress));
        }

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext(((Number) obj).doubleValue());
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadViewModel$a */
    @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, m5598d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadableViewData;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadViewModel$handleUploadComplete$1", m5608f = "UploadViewModel.kt", m5609i = {}, m5610l = {97}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C4989a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        int f7613a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ UploadViewModel<T> f7614b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4989a(UploadViewModel<T> uploadViewModel, Continuation<? super C4989a> continuation) {
            super(2, continuation);
            this.f7614b = uploadViewModel;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C4989a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C4989a(this.f7614b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7613a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                UploadViewModel<T> uploadViewModel = this.f7614b;
                this.f7613a = 1;
                if (uploadViewModel.cleanupResources(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.f7614b.setUploadAsSuccess();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UploadViewModel(SessionStatus sessionStatus, Mapper<? super Throwable, ? extends SessionStatusType> errorToSessionStatusTypeMapper, Mapper<? super Throwable, YdsFailure> errorToFailureMapper) {
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        Intrinsics.checkNotNullParameter(errorToSessionStatusTypeMapper, "errorToSessionStatusTypeMapper");
        Intrinsics.checkNotNullParameter(errorToFailureMapper, "errorToFailureMapper");
        this.sessionStatus = sessionStatus;
        this.errorToSessionStatusTypeMapper = errorToSessionStatusTypeMapper;
        this.errorToFailureMapper = errorToFailureMapper;
        this._uploadProgress = new MutableLiveData<>();
        this._uploadStatus = new MutableLiveData<>();
    }

    static /* synthetic */ Object cleanupResources$suspendImpl(UploadViewModel uploadViewModel, Continuation continuation) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUploadComplete() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C4989a(this, null), 3, null);
    }

    protected Object cleanupResources(Continuation<? super Unit> continuation) {
        return cleanupResources$suspendImpl(this, continuation);
    }

    protected abstract void executeUpload(T uploadableData);

    protected Mapper<Throwable, YdsFailure> getErrorToFailureMapper() {
        return this.errorToFailureMapper;
    }

    protected Mapper<Throwable, SessionStatusType> getErrorToSessionStatusTypeMapper() {
        return this.errorToSessionStatusTypeMapper;
    }

    protected SavedStateHandle getSavedStateHandle() {
        SavedStateHandle savedStateHandle = this._savedStateHandle;
        if (savedStateHandle != null) {
            return savedStateHandle;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_savedStateHandle");
        return null;
    }

    protected SessionStatus getSessionStatus() {
        return this.sessionStatus;
    }

    public LiveData<Double> getUploadProgress() {
        return get_uploadProgress();
    }

    protected UploadState getUploadState() {
        UploadState uploadState = (UploadState) getSavedStateHandle().get(UploadViewModelKt.KEY_IS_UPLOAD_FINISHED);
        return uploadState == null ? UploadState.Unknown.INSTANCE : uploadState;
    }

    public LiveData<Status<Unit>> getUploadStatus() {
        return get_uploadStatus();
    }

    protected MutableLiveData<Double> get_uploadProgress() {
        return this._uploadProgress;
    }

    protected MutableLiveData<Status<Unit>> get_uploadStatus() {
        return this._uploadStatus;
    }

    @Override // com.yoti.mobile.android.commonui.SavedStateHandleHolder
    public void setSavedStateHandle(SavedStateHandle handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        this._savedStateHandle = handle;
    }

    protected void setUploadAsInitiated() {
        setUploadState(UploadState.NotFinished.INSTANCE);
        get_uploadProgress().setValue(Double.valueOf(0.0d));
        get_uploadStatus().setValue(Status.Loading.INSTANCE);
    }

    protected void setUploadAsSuccess() {
        setUploadState(UploadState.Finished.INSTANCE);
        get_uploadProgress().setValue(Double.valueOf(1.0d));
        get_uploadStatus().setValue(new Status.Success(Unit.INSTANCE));
    }

    protected void setUploadState(UploadState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        getSavedStateHandle().set(UploadViewModelKt.KEY_IS_UPLOAD_FINISHED, value);
    }

    public void upload(T viewData) {
        Intrinsics.checkNotNullParameter(viewData, "viewData");
        setUploadAsInitiated();
        executeUpload(viewData);
    }
}
