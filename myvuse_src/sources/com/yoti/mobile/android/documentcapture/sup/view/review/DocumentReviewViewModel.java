package com.yoti.mobile.android.documentcapture.sup.view.review;

import android.graphics.Bitmap;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.yoti.mobile.android.commons.functional.Either;
import com.yoti.mobile.android.commons.util.C4588L;
import com.yoti.mobile.android.commonui.GenericMessageFragmentArgs;
import com.yoti.mobile.android.commonui.SavedStateHandleHolder;
import com.yoti.mobile.android.commonui.SingleLiveDataEvent;
import com.yoti.mobile.android.documentcapture.sup.C4653R;
import com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidator;
import com.yoti.mobile.android.documentcapture.sup.view.review.transformer.CaptureToBitmapTransformerFactory;
import com.yoti.mobile.android.documentcapture.sup.view.review.transformer.ICaptureToBitmapTransformer;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupplementaryDocumentViewData;
import com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData;
import com.yoti.mobile.android.yotidocs.common.BitmapRotateUseCase;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0002FGB/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0006\u0010%\u001a\u00020&J\u001c\u0010'\u001a\u00020(2\b\b\u0001\u0010)\u001a\u00020*2\b\b\u0001\u0010+\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020*H\u0002J\u0018\u00100\u001a\u00020&2\b\b\u0002\u0010/\u001a\u00020*2\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020(H\u0002J\b\u00105\u001a\u00020&H\u0002J\b\u00106\u001a\u00020&H\u0014J\u0010\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\u001cH\u0002J\u0010\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020;H\u0002J\u0006\u0010>\u001a\u00020&J\u0016\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020A2\u0006\u0010/\u001a\u00020*J\u0010\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020$H\u0016J\u000e\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020\u0015R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000¨\u0006H"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/yoti/mobile/android/commonui/SavedStateHandleHolder;", "fileSizeValidator", "Lcom/yoti/mobile/android/documentcapture/sup/domain/FileSizeValidator;", "captureToBitmapTransformerFactory", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/CaptureToBitmapTransformerFactory;", "bitmapRotateUseCase", "Lcom/yoti/mobile/android/yotidocs/common/BitmapRotateUseCase;", "exceptionToFailureMapper", "Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;", "pageNumberIndicatorFormatter", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/PageNumberIndicatorFormatter;", "(Lcom/yoti/mobile/android/documentcapture/sup/domain/FileSizeValidator;Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/CaptureToBitmapTransformerFactory;Lcom/yoti/mobile/android/yotidocs/common/BitmapRotateUseCase;Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;Lcom/yoti/mobile/android/documentcapture/sup/view/review/PageNumberIndicatorFormatter;)V", "_navigationEvent", "Lcom/yoti/mobile/android/commonui/SingleLiveDataEvent;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$NavigationEvent;", "_reviewState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$DocumentReviewState;", "captureData", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;", "kotlin.jvm.PlatformType", "getCaptureData", "()Landroidx/lifecycle/MutableLiveData;", "captureData$delegate", "Lkotlin/Lazy;", "captureToBitmapTransformer", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer;", "navigationEvent", "Landroidx/lifecycle/LiveData;", "getNavigationEvent", "()Landroidx/lifecycle/LiveData;", "reviewState", "getReviewState", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "approveCapture", "", "createGenericMessageFragmentArgs", "Lcom/yoti/mobile/android/commonui/GenericMessageFragmentArgs;", "titleResId", "", "contentResId", "getCaptureToBitmapTransformer", "getPageNumberIndicator", "", "pageNumber", "loadImage", "previewSize", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer$TransformOptions$Size;", "navigateToFileOpenError", "args", "navigateToFileSizeError", "onCleared", "onCreateTransformerSuccess", "transformer", "onError", "throwable", "", "onTransformerError", HexAttribute.HEX_ATTR_CAUSE, "rejectCapture", "rotateImage", "bitmap", "Landroid/graphics/Bitmap;", "setSavedStateHandle", "handle", "setupCapture", "capture", "DocumentReviewState", "NavigationEvent", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentReviewViewModel extends ViewModel implements SavedStateHandleHolder {
    private final SingleLiveDataEvent<NavigationEvent> _navigationEvent;
    private final MutableLiveData<DocumentReviewState> _reviewState;
    private final BitmapRotateUseCase bitmapRotateUseCase;

    /* JADX INFO: renamed from: captureData$delegate, reason: from kotlin metadata */
    private final Lazy captureData;
    private ICaptureToBitmapTransformer captureToBitmapTransformer;
    private final CaptureToBitmapTransformerFactory captureToBitmapTransformerFactory;
    private final ExceptionToFailureMapper exceptionToFailureMapper;
    private final FileSizeValidator fileSizeValidator;
    private final LiveData<NavigationEvent> navigationEvent;
    private final PageNumberIndicatorFormatter pageNumberIndicatorFormatter;
    private final LiveData<DocumentReviewState> reviewState;
    private SavedStateHandle savedStateHandle;

    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$DocumentReviewState;", "", "()V", "BitmapLoaded", "Error", "ViewConfiguration", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$DocumentReviewState$ViewConfiguration;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$DocumentReviewState$BitmapLoaded;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$DocumentReviewState$Error;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class DocumentReviewState {

        @Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$DocumentReviewState$BitmapLoaded;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$DocumentReviewState;", "bitmap", "Landroid/graphics/Bitmap;", "page", "", "pageNumberIndicator", "", "rotationEnabled", "", "(Landroid/graphics/Bitmap;ILjava/lang/String;Z)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getPage", "()I", "getPageNumberIndicator", "()Ljava/lang/String;", "getRotationEnabled", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class BitmapLoaded extends DocumentReviewState {
            private final Bitmap bitmap;
            private final int page;
            private final String pageNumberIndicator;
            private final boolean rotationEnabled;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BitmapLoaded(Bitmap bitmap, int i, String str, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                this.bitmap = bitmap;
                this.page = i;
                this.pageNumberIndicator = str;
                this.rotationEnabled = z;
            }

            public static /* synthetic */ BitmapLoaded copy$default(BitmapLoaded bitmapLoaded, Bitmap bitmap, int i, String str, boolean z, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    bitmap = bitmapLoaded.bitmap;
                }
                if ((i2 & 2) != 0) {
                    i = bitmapLoaded.page;
                }
                if ((i2 & 4) != 0) {
                    str = bitmapLoaded.pageNumberIndicator;
                }
                if ((i2 & 8) != 0) {
                    z = bitmapLoaded.rotationEnabled;
                }
                return bitmapLoaded.copy(bitmap, i, str, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Bitmap getBitmap() {
                return this.bitmap;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getPage() {
                return this.page;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getPageNumberIndicator() {
                return this.pageNumberIndicator;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getRotationEnabled() {
                return this.rotationEnabled;
            }

            public final BitmapLoaded copy(Bitmap bitmap, int page, String pageNumberIndicator, boolean rotationEnabled) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                return new BitmapLoaded(bitmap, page, pageNumberIndicator, rotationEnabled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BitmapLoaded)) {
                    return false;
                }
                BitmapLoaded bitmapLoaded = (BitmapLoaded) other;
                return Intrinsics.areEqual(this.bitmap, bitmapLoaded.bitmap) && this.page == bitmapLoaded.page && Intrinsics.areEqual(this.pageNumberIndicator, bitmapLoaded.pageNumberIndicator) && this.rotationEnabled == bitmapLoaded.rotationEnabled;
            }

            public final Bitmap getBitmap() {
                return this.bitmap;
            }

            public final int getPage() {
                return this.page;
            }

            public final String getPageNumberIndicator() {
                return this.pageNumberIndicator;
            }

            public final boolean getRotationEnabled() {
                return this.rotationEnabled;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r1v9 */
            public int hashCode() {
                int iHashCode = ((this.bitmap.hashCode() * 31) + Integer.hashCode(this.page)) * 31;
                String str = this.pageNumberIndicator;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                boolean z = this.rotationEnabled;
                ?? r1 = z;
                if (z) {
                    r1 = 1;
                }
                return iHashCode2 + r1;
            }

            public String toString() {
                return "BitmapLoaded(bitmap=" + this.bitmap + ", page=" + this.page + ", pageNumberIndicator=" + this.pageNumberIndicator + ", rotationEnabled=" + this.rotationEnabled + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$DocumentReviewState$Error;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$DocumentReviewState;", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;)V", "getFailure", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class Error extends DocumentReviewState {
            private final YdsFailure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(YdsFailure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ Error copy$default(Error error, YdsFailure ydsFailure, int i, Object obj) {
                if ((i & 1) != 0) {
                    ydsFailure = error.failure;
                }
                return error.copy(ydsFailure);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final YdsFailure getFailure() {
                return this.failure;
            }

            public final Error copy(YdsFailure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new Error(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.failure, ((Error) other).failure);
            }

            public final YdsFailure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "Error(failure=" + this.failure + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$DocumentReviewState$ViewConfiguration;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$DocumentReviewState;", "pages", "", "(I)V", "getPages", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class ViewConfiguration extends DocumentReviewState {
            private final int pages;

            public ViewConfiguration(int i) {
                super(null);
                this.pages = i;
            }

            public static /* synthetic */ ViewConfiguration copy$default(ViewConfiguration viewConfiguration, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = viewConfiguration.pages;
                }
                return viewConfiguration.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getPages() {
                return this.pages;
            }

            public final ViewConfiguration copy(int pages) {
                return new ViewConfiguration(pages);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ViewConfiguration) && this.pages == ((ViewConfiguration) other).pages;
            }

            public final int getPages() {
                return this.pages;
            }

            public int hashCode() {
                return Integer.hashCode(this.pages);
            }

            public String toString() {
                return "ViewConfiguration(pages=" + this.pages + ')';
            }
        }

        private DocumentReviewState() {
        }

        public /* synthetic */ DocumentReviewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$NavigationEvent;", "", "()V", "NavigateToFileOpenError", "NavigateToScan", "NavigateToUpload", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$NavigationEvent$NavigateToFileOpenError;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$NavigationEvent$NavigateToUpload;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$NavigationEvent$NavigateToScan;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class NavigationEvent {

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$NavigationEvent$NavigateToFileOpenError;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$NavigationEvent;", "args", "Lcom/yoti/mobile/android/commonui/GenericMessageFragmentArgs;", "(Lcom/yoti/mobile/android/commonui/GenericMessageFragmentArgs;)V", "getArgs", "()Lcom/yoti/mobile/android/commonui/GenericMessageFragmentArgs;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class NavigateToFileOpenError extends NavigationEvent {
            private final GenericMessageFragmentArgs args;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToFileOpenError(GenericMessageFragmentArgs args) {
                super(null);
                Intrinsics.checkNotNullParameter(args, "args");
                this.args = args;
            }

            public static /* synthetic */ NavigateToFileOpenError copy$default(NavigateToFileOpenError navigateToFileOpenError, GenericMessageFragmentArgs genericMessageFragmentArgs, int i, Object obj) {
                if ((i & 1) != 0) {
                    genericMessageFragmentArgs = navigateToFileOpenError.args;
                }
                return navigateToFileOpenError.copy(genericMessageFragmentArgs);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GenericMessageFragmentArgs getArgs() {
                return this.args;
            }

            public final NavigateToFileOpenError copy(GenericMessageFragmentArgs args) {
                Intrinsics.checkNotNullParameter(args, "args");
                return new NavigateToFileOpenError(args);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToFileOpenError) && Intrinsics.areEqual(this.args, ((NavigateToFileOpenError) other).args);
            }

            public final GenericMessageFragmentArgs getArgs() {
                return this.args;
            }

            public int hashCode() {
                return this.args.hashCode();
            }

            public String toString() {
                return "NavigateToFileOpenError(args=" + this.args + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$NavigationEvent$NavigateToScan;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$NavigationEvent;", "()V", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class NavigateToScan extends NavigationEvent {
            public static final NavigateToScan INSTANCE = new NavigateToScan();

            private NavigateToScan() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$NavigationEvent$NavigateToUpload;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$NavigationEvent;", "documentData", "Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;", "(Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;)V", "getDocumentData", "()Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class NavigateToUpload extends NavigationEvent {
            private final IDocumentViewData documentData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToUpload(IDocumentViewData documentData) {
                super(null);
                Intrinsics.checkNotNullParameter(documentData, "documentData");
                this.documentData = documentData;
            }

            public static /* synthetic */ NavigateToUpload copy$default(NavigateToUpload navigateToUpload, IDocumentViewData iDocumentViewData, int i, Object obj) {
                if ((i & 1) != 0) {
                    iDocumentViewData = navigateToUpload.documentData;
                }
                return navigateToUpload.copy(iDocumentViewData);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final IDocumentViewData getDocumentData() {
                return this.documentData;
            }

            public final NavigateToUpload copy(IDocumentViewData documentData) {
                Intrinsics.checkNotNullParameter(documentData, "documentData");
                return new NavigateToUpload(documentData);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToUpload) && Intrinsics.areEqual(this.documentData, ((NavigateToUpload) other).documentData);
            }

            public final IDocumentViewData getDocumentData() {
                return this.documentData;
            }

            public int hashCode() {
                return this.documentData.hashCode();
            }

            public String toString() {
                return "NavigateToUpload(documentData=" + this.documentData + ')';
            }
        }

        private NavigationEvent() {
        }

        public /* synthetic */ NavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel$loadImage$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel$loadImage$1", m5608f = "DocumentReviewViewModel.kt", m5609i = {}, m5610l = {101}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageNumber;
        final /* synthetic */ ICaptureToBitmapTransformer.TransformOptions.Size $previewSize;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C46711(int i, ICaptureToBitmapTransformer.TransformOptions.Size size, Continuation<? super C46711> continuation) {
            super(2, continuation);
            this.$pageNumber = i;
            this.$previewSize = size;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C46711 c46711 = DocumentReviewViewModel.this.new C46711(this.$pageNumber, this.$previewSize, continuation);
            c46711.L$0 = obj;
            return c46711;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM7233constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DocumentReviewViewModel documentReviewViewModel = DocumentReviewViewModel.this;
                    int i2 = this.$pageNumber;
                    ICaptureToBitmapTransformer.TransformOptions.Size size = this.$previewSize;
                    ICaptureToBitmapTransformer captureToBitmapTransformer = documentReviewViewModel.getCaptureToBitmapTransformer();
                    ICaptureToBitmapTransformer.TransformOptions transformOptions = new ICaptureToBitmapTransformer.TransformOptions(size, false, 2, null);
                    this.label = 1;
                    obj = captureToBitmapTransformer.transform(i2, transformOptions, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Intrinsics.checkNotNull(obj);
                objM7233constructorimpl = Result.m7233constructorimpl((Bitmap) obj);
            } catch (Throwable th) {
                objM7233constructorimpl = Result.m7233constructorimpl(ResultKt.createFailure(th));
            }
            DocumentReviewViewModel documentReviewViewModel2 = DocumentReviewViewModel.this;
            int i3 = this.$pageNumber;
            if (Result.m7240isSuccessimpl(objM7233constructorimpl)) {
                documentReviewViewModel2._reviewState.setValue(new DocumentReviewState.BitmapLoaded((Bitmap) objM7233constructorimpl, i3, documentReviewViewModel2.getPageNumberIndicator(i3), true));
            }
            DocumentReviewViewModel documentReviewViewModel3 = DocumentReviewViewModel.this;
            Throwable thM7236exceptionOrNullimpl = Result.m7236exceptionOrNullimpl(objM7233constructorimpl);
            if (thM7236exceptionOrNullimpl != null) {
                documentReviewViewModel3.onTransformerError(thM7236exceptionOrNullimpl);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel$rotateImage$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel$rotateImage$1", m5608f = "DocumentReviewViewModel.kt", m5609i = {}, m5610l = {120}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ String $pageIndicator;
        final /* synthetic */ int $pageNumber;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C46721(Bitmap bitmap, int i, String str, Continuation<? super C46721> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.$pageNumber = i;
            this.$pageIndicator = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DocumentReviewViewModel.this.new C46721(this.$bitmap, this.$pageNumber, this.$pageIndicator, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BitmapRotateUseCase bitmapRotateUseCase = DocumentReviewViewModel.this.bitmapRotateUseCase;
                Bitmap bitmap = this.$bitmap;
                this.label = 1;
                obj = bitmapRotateUseCase.invoke(bitmap, 90, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Either either = (Either) obj;
            DocumentReviewViewModel documentReviewViewModel = DocumentReviewViewModel.this;
            int i2 = this.$pageNumber;
            String str = this.$pageIndicator;
            if (either instanceof Either.Failure) {
                documentReviewViewModel.onError((Throwable) ((Either.Failure) either).getFailResult());
            } else {
                if (!(either instanceof Either.Success)) {
                    throw new NoWhenBranchMatchedException();
                }
                documentReviewViewModel._reviewState.setValue(new DocumentReviewState.BitmapLoaded((Bitmap) ((Either.Success) either).getSuccessResult(), i2, str, true));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel$setupCapture$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel$setupCapture$1", m5608f = "DocumentReviewViewModel.kt", m5609i = {}, m5610l = {78, 81}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SupplementaryDocumentViewData $capture;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C46731(SupplementaryDocumentViewData supplementaryDocumentViewData, Continuation<? super C46731> continuation) {
            super(2, continuation);
            this.$capture = supplementaryDocumentViewData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DocumentReviewViewModel.this.new C46731(this.$capture, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r5)
                goto L60
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L36
            L1e:
                kotlin.ResultKt.throwOnFailure(r5)
                com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel r5 = com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel.this
                com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidator r5 = com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel.access$getFileSizeValidator$p(r5)
                com.yoti.mobile.android.documentcapture.sup.view.scan.SupplementaryDocumentViewData r1 = r4.$capture
                android.net.Uri r1 = r1.getFilePath()
                r4.label = r3
                java.lang.Object r5 = r5.validate(r1, r4)
                if (r5 != r0) goto L36
                return r0
            L36:
                com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidationResult r5 = (com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidationResult) r5
                com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidationResult$ValidSize r1 = com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidationResult.ValidSize.INSTANCE
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r1)
                if (r1 == 0) goto L8e
                com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel r5 = com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel.this
                androidx.lifecycle.MutableLiveData r5 = com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel.access$getCaptureData(r5)
                com.yoti.mobile.android.documentcapture.sup.view.scan.SupplementaryDocumentViewData r1 = r4.$capture
                r5.setValue(r1)
                com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel r5 = com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel.this
                com.yoti.mobile.android.documentcapture.sup.view.review.transformer.CaptureToBitmapTransformerFactory r5 = com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel.access$getCaptureToBitmapTransformerFactory$p(r5)
                com.yoti.mobile.android.documentcapture.sup.view.scan.SupplementaryDocumentViewData r1 = r4.$capture
                android.net.Uri r1 = r1.getFilePath()
                r4.label = r2
                java.lang.Object r5 = r5.getTransformer(r1, r4)
                if (r5 != r0) goto L60
                return r0
            L60:
                com.yoti.mobile.android.commons.functional.Either r5 = (com.yoti.mobile.android.commons.functional.Either) r5
                com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel r0 = com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel.this
                boolean r1 = r5 instanceof com.yoti.mobile.android.commons.functional.Either.Failure
                if (r1 == 0) goto L78
                com.yoti.mobile.android.commons.functional.Either$Failure r5 = (com.yoti.mobile.android.commons.functional.Either.Failure) r5
                java.lang.Object r5 = r5.getFailResult()
                com.yoti.mobile.android.documentcapture.sup.view.review.transformer.FileOpenError r5 = (com.yoti.mobile.android.documentcapture.sup.view.review.transformer.FileOpenError) r5
                java.lang.Throwable r5 = r5.getCause()
                com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel.access$onTransformerError(r0, r5)
                goto Lb2
            L78:
                boolean r1 = r5 instanceof com.yoti.mobile.android.commons.functional.Either.Success
                if (r1 == 0) goto L88
                com.yoti.mobile.android.commons.functional.Either$Success r5 = (com.yoti.mobile.android.commons.functional.Either.Success) r5
                java.lang.Object r5 = r5.getSuccessResult()
                com.yoti.mobile.android.documentcapture.sup.view.review.transformer.ICaptureToBitmapTransformer r5 = (com.yoti.mobile.android.documentcapture.sup.view.review.transformer.ICaptureToBitmapTransformer) r5
                com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel.access$onCreateTransformerSuccess(r0, r5)
                goto Lb2
            L88:
                kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                r5.<init>()
                throw r5
            L8e:
                com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidationResult$InvalidSize r0 = com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidationResult.InvalidSize.INSTANCE
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
                if (r0 == 0) goto L9c
                com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel r5 = com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel.this
                com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel.access$navigateToFileSizeError(r5)
                goto Lb2
            L9c:
                boolean r0 = r5 instanceof com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidationResult.Error
                if (r0 == 0) goto Lb2
                com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidationResult$Error r5 = (com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidationResult.Error) r5
                java.lang.Exception r5 = r5.getException()
                java.lang.String r0 = "DocumentReviewViewModel"
                java.lang.String r1 = "Error validating file size"
                com.yoti.mobile.android.commons.util.C4588L.logError(r0, r1, r5)
                com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel r5 = com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel.this
                com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel.access$navigateToFileSizeError(r5)
            Lb2:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel.C46731.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Inject
    public DocumentReviewViewModel(FileSizeValidator fileSizeValidator, CaptureToBitmapTransformerFactory captureToBitmapTransformerFactory, BitmapRotateUseCase bitmapRotateUseCase, ExceptionToFailureMapper exceptionToFailureMapper, PageNumberIndicatorFormatter pageNumberIndicatorFormatter) {
        Intrinsics.checkNotNullParameter(fileSizeValidator, "fileSizeValidator");
        Intrinsics.checkNotNullParameter(captureToBitmapTransformerFactory, "captureToBitmapTransformerFactory");
        Intrinsics.checkNotNullParameter(bitmapRotateUseCase, "bitmapRotateUseCase");
        Intrinsics.checkNotNullParameter(exceptionToFailureMapper, "exceptionToFailureMapper");
        Intrinsics.checkNotNullParameter(pageNumberIndicatorFormatter, "pageNumberIndicatorFormatter");
        this.fileSizeValidator = fileSizeValidator;
        this.captureToBitmapTransformerFactory = captureToBitmapTransformerFactory;
        this.bitmapRotateUseCase = bitmapRotateUseCase;
        this.exceptionToFailureMapper = exceptionToFailureMapper;
        this.pageNumberIndicatorFormatter = pageNumberIndicatorFormatter;
        this.captureData = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<MutableLiveData<SupplementaryDocumentViewData>>() { // from class: com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel$captureData$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MutableLiveData<SupplementaryDocumentViewData> invoke() {
                SavedStateHandle savedStateHandle = this.this$0.savedStateHandle;
                if (savedStateHandle == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
                    savedStateHandle = null;
                }
                return savedStateHandle.getLiveData(DocumentReviewViewModelKt.KEY_SUP_DOCUMENT_VIEWDATA);
            }
        });
        MutableLiveData<DocumentReviewState> mutableLiveData = new MutableLiveData<>();
        this._reviewState = mutableLiveData;
        this.reviewState = mutableLiveData;
        SingleLiveDataEvent<NavigationEvent> singleLiveDataEvent = new SingleLiveDataEvent<>(null, 1, null);
        this._navigationEvent = singleLiveDataEvent;
        this.navigationEvent = singleLiveDataEvent;
    }

    private final GenericMessageFragmentArgs createGenericMessageFragmentArgs(int titleResId, int contentResId) {
        return new GenericMessageFragmentArgs(C4653R.drawable.yds_ic_error, titleResId, null, contentResId, null, C4653R.string.yds_common_try_again, null, C4653R.drawable.yds_ico_retry, 0, null, 0, null, 3924, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableLiveData<SupplementaryDocumentViewData> getCaptureData() {
        return (MutableLiveData) this.captureData.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ICaptureToBitmapTransformer getCaptureToBitmapTransformer() {
        ICaptureToBitmapTransformer iCaptureToBitmapTransformer = this.captureToBitmapTransformer;
        if (iCaptureToBitmapTransformer != null) {
            return iCaptureToBitmapTransformer;
        }
        throw new IllegalArgumentException("ICaptureToBitmapTransformer not initialized".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPageNumberIndicator(int pageNumber) {
        return this.pageNumberIndicatorFormatter.format(pageNumber, getCaptureToBitmapTransformer().getPageCount());
    }

    public static /* synthetic */ void loadImage$default(DocumentReviewViewModel documentReviewViewModel, int i, ICaptureToBitmapTransformer.TransformOptions.Size size, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        documentReviewViewModel.loadImage(i, size);
    }

    private final void navigateToFileOpenError(GenericMessageFragmentArgs args) {
        this._navigationEvent.setValue(new NavigationEvent.NavigateToFileOpenError(args));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToFileSizeError() {
        navigateToFileOpenError(createGenericMessageFragmentArgs(C4653R.string.ios_android_yds_invalid_file_size_header, C4653R.string.ios_android_yds_invalid_file_size_description));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCreateTransformerSuccess(ICaptureToBitmapTransformer transformer) {
        this.captureToBitmapTransformer = transformer;
        this._reviewState.setValue(new DocumentReviewState.ViewConfiguration(transformer.getPageCount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onError(Throwable throwable) {
        this._reviewState.setValue(new DocumentReviewState.Error(this.exceptionToFailureMapper.map(throwable)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTransformerError(Throwable cause) {
        C4588L.logError("DocumentReviewViewModel", "Error while loading image", cause);
        navigateToFileOpenError(createGenericMessageFragmentArgs(C4653R.string.ios_android_yds_non_id_document_failed_preview_header, C4653R.string.ios_android_yds_non_id_document_failed_preview_description));
    }

    public final void approveCapture() {
        SingleLiveDataEvent<NavigationEvent> singleLiveDataEvent = this._navigationEvent;
        SupplementaryDocumentViewData value = getCaptureData().getValue();
        Intrinsics.checkNotNull(value);
        singleLiveDataEvent.setValue(new NavigationEvent.NavigateToUpload(value));
    }

    public final LiveData<NavigationEvent> getNavigationEvent() {
        return this.navigationEvent;
    }

    public final LiveData<DocumentReviewState> getReviewState() {
        return this.reviewState;
    }

    public final void loadImage(int pageNumber, ICaptureToBitmapTransformer.TransformOptions.Size previewSize) {
        Intrinsics.checkNotNullParameter(previewSize, "previewSize");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C46711(pageNumber, previewSize, null), 3, null);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() throws Exception {
        super.onCleared();
        ICaptureToBitmapTransformer iCaptureToBitmapTransformer = this.captureToBitmapTransformer;
        if (iCaptureToBitmapTransformer != null) {
            iCaptureToBitmapTransformer.close();
        }
    }

    public final void rejectCapture() {
        this._navigationEvent.setValue(NavigationEvent.NavigateToScan.INSTANCE);
    }

    public final void rotateImage(Bitmap bitmap, int pageNumber) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        String pageNumberIndicator = getPageNumberIndicator(pageNumber);
        this._reviewState.setValue(new DocumentReviewState.BitmapLoaded(bitmap, pageNumber, pageNumberIndicator, false));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C46721(bitmap, pageNumber, pageNumberIndicator, null), 3, null);
    }

    @Override // com.yoti.mobile.android.commonui.SavedStateHandleHolder
    public void setSavedStateHandle(SavedStateHandle handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.savedStateHandle = handle;
    }

    public final void setupCapture(SupplementaryDocumentViewData capture) {
        Intrinsics.checkNotNullParameter(capture, "capture");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C46731(capture, null), 3, null);
    }
}
