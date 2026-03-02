package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import android.graphics.Bitmap;
import android.graphics.RectF;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentImageLoader;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultViewData;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.model.result.MetaData;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.view.localisation.LocalisedCountriesProvider;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0003789B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J$\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010!0 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u000e\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+J\u0018\u0010,\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010-\u001a\u00020.H\u0002J6\u0010/\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001d2\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010!0 H\u0002J5\u00104\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0006\u0012\u0004\u0018\u0001050 2\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010!0 H\u0082@ø\u0001\u0000¢\u0006\u0002\u00106R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel;", "Landroidx/lifecycle/ViewModel;", "imageLoader", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentImageLoader;", "localisedCountriesProvider", "Lcom/yoti/mobile/android/yotisdkcore/core/view/localisation/LocalisedCountriesProvider;", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "errorToSessionStatusTypeMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentImageLoader;Lcom/yoti/mobile/android/yotisdkcore/core/view/localisation/LocalisedCountriesProvider;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;)V", "_navigationEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorNavigationEvent;", "_textExtractionErrorViewState", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState;", "navigationEvent", "Landroidx/lifecycle/LiveData;", "getNavigationEvent", "()Landroidx/lifecycle/LiveData;", "textExtractionErrorViewState", "getTextExtractionErrorViewState", "calculateImageFrameHeight", "", "screenWidthInPixels", "cropRegion", "Landroid/graphics/RectF;", "getLocalisedCountry", "", "iso3Code", "getMetaDataPair", "Lkotlin/Pair;", "Lcom/yoti/mobile/android/documentscan/model/result/MetaData;", "scanResults", "", "Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "handleError", "", "error", "", "handleViewEvent", "viewEvent", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewEvent;", "loadCapture", "capture", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "loadImageInfo", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "countryIso3Code", "metaDataPair", "loadImages", "Landroid/graphics/Bitmap;", "(Lkotlin/Pair;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TextExtractionErrorNavigationEvent", "TextExtractionErrorViewEvent", "TextExtractionErrorViewState", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TextExtractionErrorViewModel extends ViewModel {
    private final MutableLiveData<SingleEvent<TextExtractionErrorNavigationEvent>> _navigationEvent;
    private final MutableLiveData<TextExtractionErrorViewState> _textExtractionErrorViewState;
    private final ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper;
    private final DocumentImageLoader imageLoader;
    private final LocalisedCountriesProvider localisedCountriesProvider;
    private final LiveData<SingleEvent<TextExtractionErrorNavigationEvent>> navigationEvent;
    private final SessionStatus sessionStatus;
    private final LiveData<TextExtractionErrorViewState> textExtractionErrorViewState;

    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorNavigationEvent;", "", "()V", "NavigateBackToFirstScreen", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorNavigationEvent$NavigateBackToFirstScreen;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class TextExtractionErrorNavigationEvent {

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorNavigationEvent$NavigateBackToFirstScreen;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorNavigationEvent;", "()V", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class NavigateBackToFirstScreen extends TextExtractionErrorNavigationEvent {
            public static final NavigateBackToFirstScreen INSTANCE = new NavigateBackToFirstScreen();

            private NavigateBackToFirstScreen() {
                super(null);
            }
        }

        private TextExtractionErrorNavigationEvent() {
        }

        public /* synthetic */ TextExtractionErrorNavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewEvent;", "", "()V", "LoadCapture", "NavigateBack", "TryAgain", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewEvent$LoadCapture;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewEvent$TryAgain;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewEvent$NavigateBack;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class TextExtractionErrorViewEvent {

        @Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewEvent$LoadCapture;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewEvent;", "screenWidthInPixels", "", "capture", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "(ILcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;)V", "getCapture", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "getScreenWidthInPixels", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class LoadCapture extends TextExtractionErrorViewEvent {
            private final DocumentScanResultViewData capture;
            private final int screenWidthInPixels;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadCapture(int i, DocumentScanResultViewData capture) {
                super(null);
                Intrinsics.checkNotNullParameter(capture, "capture");
                this.screenWidthInPixels = i;
                this.capture = capture;
            }

            public static /* synthetic */ LoadCapture copy$default(LoadCapture loadCapture, int i, DocumentScanResultViewData documentScanResultViewData, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = loadCapture.screenWidthInPixels;
                }
                if ((i2 & 2) != 0) {
                    documentScanResultViewData = loadCapture.capture;
                }
                return loadCapture.copy(i, documentScanResultViewData);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getScreenWidthInPixels() {
                return this.screenWidthInPixels;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final DocumentScanResultViewData getCapture() {
                return this.capture;
            }

            public final LoadCapture copy(int screenWidthInPixels, DocumentScanResultViewData capture) {
                Intrinsics.checkNotNullParameter(capture, "capture");
                return new LoadCapture(screenWidthInPixels, capture);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadCapture)) {
                    return false;
                }
                LoadCapture loadCapture = (LoadCapture) other;
                return this.screenWidthInPixels == loadCapture.screenWidthInPixels && Intrinsics.areEqual(this.capture, loadCapture.capture);
            }

            public final DocumentScanResultViewData getCapture() {
                return this.capture;
            }

            public final int getScreenWidthInPixels() {
                return this.screenWidthInPixels;
            }

            public int hashCode() {
                return (Integer.hashCode(this.screenWidthInPixels) * 31) + this.capture.hashCode();
            }

            public String toString() {
                return "LoadCapture(screenWidthInPixels=" + this.screenWidthInPixels + ", capture=" + this.capture + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewEvent$NavigateBack;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewEvent;", "()V", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class NavigateBack extends TextExtractionErrorViewEvent {
            public static final NavigateBack INSTANCE = new NavigateBack();

            private NavigateBack() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewEvent$TryAgain;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewEvent;", "()V", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class TryAgain extends TextExtractionErrorViewEvent {
            public static final TryAgain INSTANCE = new TryAgain();

            private TryAgain() {
                super(null);
            }
        }

        private TextExtractionErrorViewEvent() {
        }

        public /* synthetic */ TextExtractionErrorViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState;", "", "()V", "Error", "ImageBitmapsReady", "ImageInfoReady", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState$ImageBitmapsReady;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState$ImageInfoReady;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState$Error;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class TextExtractionErrorViewState {

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState$Error;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState;", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;)V", "getFailure", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class Error extends TextExtractionErrorViewState {
            private final YdsFailure failure;

            /* JADX WARN: Multi-variable type inference failed */
            public Error() {
                this(null, 1, 0 == true ? 1 : 0);
            }

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

            public /* synthetic */ Error(YdsFailure ydsFailure, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? new YdsFailure(null, false, null, 7, null) : ydsFailure);
            }
        }

        @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0017\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J!\u0010\t\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState$ImageBitmapsReady;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState;", "bitmaps", "Lkotlin/Pair;", "Landroid/graphics/Bitmap;", "(Lkotlin/Pair;)V", "getBitmaps", "()Lkotlin/Pair;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class ImageBitmapsReady extends TextExtractionErrorViewState {
            private final Pair<Bitmap, Bitmap> bitmaps;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ImageBitmapsReady(Pair<Bitmap, Bitmap> bitmaps) {
                super(null);
                Intrinsics.checkNotNullParameter(bitmaps, "bitmaps");
                this.bitmaps = bitmaps;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ImageBitmapsReady copy$default(ImageBitmapsReady imageBitmapsReady, Pair pair, int i, Object obj) {
                if ((i & 1) != 0) {
                    pair = imageBitmapsReady.bitmaps;
                }
                return imageBitmapsReady.copy(pair);
            }

            public final Pair<Bitmap, Bitmap> component1() {
                return this.bitmaps;
            }

            public final ImageBitmapsReady copy(Pair<Bitmap, Bitmap> bitmaps) {
                Intrinsics.checkNotNullParameter(bitmaps, "bitmaps");
                return new ImageBitmapsReady(bitmaps);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ImageBitmapsReady) && Intrinsics.areEqual(this.bitmaps, ((ImageBitmapsReady) other).bitmaps);
            }

            public final Pair<Bitmap, Bitmap> getBitmaps() {
                return this.bitmaps;
            }

            public int hashCode() {
                return this.bitmaps.hashCode();
            }

            public String toString() {
                return "ImageBitmapsReady(bitmaps=" + this.bitmaps + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState$ImageInfoReady;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState;", "documentName", "", "countryName", "", "frameHeight", "(ILjava/lang/String;I)V", "getCountryName", "()Ljava/lang/String;", "getDocumentName", "()I", "getFrameHeight", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class ImageInfoReady extends TextExtractionErrorViewState {
            private final String countryName;
            private final int documentName;
            private final int frameHeight;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ImageInfoReady(int i, String countryName, int i2) {
                super(null);
                Intrinsics.checkNotNullParameter(countryName, "countryName");
                this.documentName = i;
                this.countryName = countryName;
                this.frameHeight = i2;
            }

            public static /* synthetic */ ImageInfoReady copy$default(ImageInfoReady imageInfoReady, int i, String str, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = imageInfoReady.documentName;
                }
                if ((i3 & 2) != 0) {
                    str = imageInfoReady.countryName;
                }
                if ((i3 & 4) != 0) {
                    i2 = imageInfoReady.frameHeight;
                }
                return imageInfoReady.copy(i, str, i2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getDocumentName() {
                return this.documentName;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getCountryName() {
                return this.countryName;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getFrameHeight() {
                return this.frameHeight;
            }

            public final ImageInfoReady copy(int documentName, String countryName, int frameHeight) {
                Intrinsics.checkNotNullParameter(countryName, "countryName");
                return new ImageInfoReady(documentName, countryName, frameHeight);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ImageInfoReady)) {
                    return false;
                }
                ImageInfoReady imageInfoReady = (ImageInfoReady) other;
                return this.documentName == imageInfoReady.documentName && Intrinsics.areEqual(this.countryName, imageInfoReady.countryName) && this.frameHeight == imageInfoReady.frameHeight;
            }

            public final String getCountryName() {
                return this.countryName;
            }

            public final int getDocumentName() {
                return this.documentName;
            }

            public final int getFrameHeight() {
                return this.frameHeight;
            }

            public int hashCode() {
                return (((Integer.hashCode(this.documentName) * 31) + this.countryName.hashCode()) * 31) + Integer.hashCode(this.frameHeight);
            }

            public String toString() {
                return "ImageInfoReady(documentName=" + this.documentName + ", countryName=" + this.countryName + ", frameHeight=" + this.frameHeight + ')';
            }
        }

        private TextExtractionErrorViewState() {
        }

        public /* synthetic */ TextExtractionErrorViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.upload.TextExtractionErrorViewModel$loadCapture$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.upload.TextExtractionErrorViewModel$loadCapture$1", m5608f = "TextExtractionErrorViewModel.kt", m5609i = {}, m5610l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DocumentScanResultViewData $capture;
        final /* synthetic */ int $screenWidthInPixels;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C46471(DocumentScanResultViewData documentScanResultViewData, int i, Continuation<? super C46471> continuation) {
            super(2, continuation);
            this.$capture = documentScanResultViewData;
            this.$screenWidthInPixels = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TextExtractionErrorViewModel.this.new C46471(this.$capture, this.$screenWidthInPixels, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM7233constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    TextExtractionErrorViewModel textExtractionErrorViewModel = TextExtractionErrorViewModel.this;
                    DocumentScanResultViewData documentScanResultViewData = this.$capture;
                    int i2 = this.$screenWidthInPixels;
                    Pair metaDataPair = textExtractionErrorViewModel.getMetaDataPair(documentScanResultViewData.getScanResults());
                    textExtractionErrorViewModel.loadImageInfo(i2, documentScanResultViewData.getDocumentType(), documentScanResultViewData.getCountryIso3Code(), metaDataPair);
                    this.label = 1;
                    obj = textExtractionErrorViewModel.loadImages(metaDataPair, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                objM7233constructorimpl = Result.m7233constructorimpl((Pair) obj);
            } catch (Throwable th) {
                objM7233constructorimpl = Result.m7233constructorimpl(ResultKt.createFailure(th));
            }
            TextExtractionErrorViewModel textExtractionErrorViewModel2 = TextExtractionErrorViewModel.this;
            if (Result.m7240isSuccessimpl(objM7233constructorimpl)) {
                textExtractionErrorViewModel2._textExtractionErrorViewState.setValue(new TextExtractionErrorViewState.ImageBitmapsReady((Pair) objM7233constructorimpl));
            }
            TextExtractionErrorViewModel textExtractionErrorViewModel3 = TextExtractionErrorViewModel.this;
            Throwable thM7236exceptionOrNullimpl = Result.m7236exceptionOrNullimpl(objM7233constructorimpl);
            if (thM7236exceptionOrNullimpl != null) {
                textExtractionErrorViewModel3.handleError(thM7236exceptionOrNullimpl);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.upload.TextExtractionErrorViewModel$loadImages$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.upload.TextExtractionErrorViewModel", m5608f = "TextExtractionErrorViewModel.kt", m5609i = {0}, m5610l = {122, 122}, m5611m = "loadImages", m5612n = {"deferredImageSecond"}, m5613s = {"L$0"})
    static final class C46481 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C46481(Continuation<? super C46481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextExtractionErrorViewModel.this.loadImages(null, this);
        }
    }

    @Inject
    public TextExtractionErrorViewModel(DocumentImageLoader imageLoader, LocalisedCountriesProvider localisedCountriesProvider, SessionStatus sessionStatus, ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper) {
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(localisedCountriesProvider, "localisedCountriesProvider");
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        Intrinsics.checkNotNullParameter(errorToSessionStatusTypeMapper, "errorToSessionStatusTypeMapper");
        this.imageLoader = imageLoader;
        this.localisedCountriesProvider = localisedCountriesProvider;
        this.sessionStatus = sessionStatus;
        this.errorToSessionStatusTypeMapper = errorToSessionStatusTypeMapper;
        MutableLiveData<TextExtractionErrorViewState> mutableLiveData = new MutableLiveData<>();
        this._textExtractionErrorViewState = mutableLiveData;
        this.textExtractionErrorViewState = mutableLiveData;
        MutableLiveData<SingleEvent<TextExtractionErrorNavigationEvent>> mutableLiveData2 = new MutableLiveData<>();
        this._navigationEvent = mutableLiveData2;
        this.navigationEvent = mutableLiveData2;
    }

    private final int calculateImageFrameHeight(int screenWidthInPixels, RectF cropRegion) {
        return (int) (this.imageLoader.calculateMaximumImageFrameWidth(screenWidthInPixels) * (cropRegion.height() / cropRegion.width()));
    }

    private final String getLocalisedCountry(String iso3Code) {
        String localizedCountryName = this.localisedCountriesProvider.getLocalizedCountryName(iso3Code);
        return localizedCountryName == null ? "" : localizedCountryName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<MetaData, MetaData> getMetaDataPair(List<DocumentCaptureResult> scanResults) {
        MetaData metaData;
        MetaData metaData2 = scanResults.get(0).getMetaData();
        if (metaData2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (scanResults.size() > 1) {
            metaData = scanResults.get(1).getMetaData();
            if (metaData == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            metaData = null;
        }
        return TuplesKt.m5605to(metaData2, metaData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleError(Throwable error) {
        this.sessionStatus.setSessionStatus(this.errorToSessionStatusTypeMapper.map(error));
        this._textExtractionErrorViewState.setValue(new TextExtractionErrorViewState.Error(new YdsFailure(null, false, error, 3, null)));
    }

    private final void loadCapture(int screenWidthInPixels, DocumentScanResultViewData capture) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C46471(capture, screenWidthInPixels, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadImageInfo(int screenWidthInPixels, DocumentTypeViewData documentType, String countryIso3Code, Pair<MetaData, MetaData> metaDataPair) {
        int iCalculateImageFrameHeight;
        RectF cropRegion = metaDataPair.getFirst().getCropRegion();
        if (cropRegion == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        int iCalculateImageFrameHeight2 = calculateImageFrameHeight(screenWidthInPixels, cropRegion);
        MetaData second = metaDataPair.getSecond();
        if (second != null) {
            RectF cropRegion2 = second.getCropRegion();
            if (cropRegion2 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            iCalculateImageFrameHeight = calculateImageFrameHeight(screenWidthInPixels, cropRegion2);
        } else {
            iCalculateImageFrameHeight = 0;
        }
        this._textExtractionErrorViewState.setValue(new TextExtractionErrorViewState.ImageInfoReady(documentType.getDocumentName(countryIso3Code).getName(), getLocalisedCountry(countryIso3Code), Math.max(iCalculateImageFrameHeight2, iCalculateImageFrameHeight)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadImages(kotlin.Pair<com.yoti.mobile.android.documentscan.model.result.MetaData, com.yoti.mobile.android.documentscan.model.result.MetaData> r14, kotlin.coroutines.Continuation<? super kotlin.Pair<android.graphics.Bitmap, android.graphics.Bitmap>> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionErrorViewModel.C46481
            if (r0 == 0) goto L13
            r0 = r15
            com.yoti.mobile.android.documentcapture.id.view.upload.TextExtractionErrorViewModel$loadImages$1 r0 = (com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionErrorViewModel.C46481) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.yoti.mobile.android.documentcapture.id.view.upload.TextExtractionErrorViewModel$loadImages$1 r0 = new com.yoti.mobile.android.documentcapture.id.view.upload.TextExtractionErrorViewModel$loadImages$1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r14 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L89
        L2f:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L37:
            java.lang.Object r14 = r0.L$0
            kotlinx.coroutines.Deferred r14 = (kotlinx.coroutines.Deferred) r14
            kotlin.ResultKt.throwOnFailure(r15)
            goto L79
        L3f:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlinx.coroutines.CoroutineScope r6 = androidx.lifecycle.ViewModelKt.getViewModelScope(r13)
            com.yoti.mobile.android.documentcapture.id.view.upload.TextExtractionErrorViewModel$loadImages$deferredImageFirst$1 r9 = new com.yoti.mobile.android.documentcapture.id.view.upload.TextExtractionErrorViewModel$loadImages$deferredImageFirst$1
            r9.<init>(r13, r14, r5)
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            kotlinx.coroutines.Deferred r15 = kotlinx.coroutines.BuildersKt.async$default(r6, r7, r8, r9, r10, r11)
            java.lang.Object r14 = r14.getSecond()
            com.yoti.mobile.android.documentscan.model.result.MetaData r14 = (com.yoti.mobile.android.documentscan.model.result.MetaData) r14
            if (r14 == 0) goto L6d
            kotlinx.coroutines.CoroutineScope r6 = androidx.lifecycle.ViewModelKt.getViewModelScope(r13)
            com.yoti.mobile.android.documentcapture.id.view.upload.TextExtractionErrorViewModel$loadImages$deferredImageSecond$1$1 r9 = new com.yoti.mobile.android.documentcapture.id.view.upload.TextExtractionErrorViewModel$loadImages$deferredImageSecond$1$1
            r9.<init>(r13, r14, r5)
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            kotlinx.coroutines.Deferred r14 = kotlinx.coroutines.BuildersKt.async$default(r6, r7, r8, r9, r10, r11)
            goto L6e
        L6d:
            r14 = r5
        L6e:
            r0.L$0 = r14
            r0.label = r4
            java.lang.Object r15 = r15.await(r0)
            if (r15 != r1) goto L79
            return r1
        L79:
            if (r14 == 0) goto L8d
            r0.L$0 = r15
            r0.label = r3
            java.lang.Object r14 = r14.await(r0)
            if (r14 != r1) goto L86
            return r1
        L86:
            r12 = r15
            r15 = r14
            r14 = r12
        L89:
            r5 = r15
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            r15 = r14
        L8d:
            kotlin.Pair r14 = kotlin.TuplesKt.m5605to(r15, r5)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionErrorViewModel.loadImages(kotlin.Pair, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final LiveData<SingleEvent<TextExtractionErrorNavigationEvent>> getNavigationEvent() {
        return this.navigationEvent;
    }

    public final LiveData<TextExtractionErrorViewState> getTextExtractionErrorViewState() {
        return this.textExtractionErrorViewState;
    }

    public final void handleViewEvent(TextExtractionErrorViewEvent viewEvent) {
        Intrinsics.checkNotNullParameter(viewEvent, "viewEvent");
        if (viewEvent instanceof TextExtractionErrorViewEvent.LoadCapture) {
            TextExtractionErrorViewEvent.LoadCapture loadCapture = (TextExtractionErrorViewEvent.LoadCapture) viewEvent;
            loadCapture(loadCapture.getScreenWidthInPixels(), loadCapture.getCapture());
        } else {
            if (Intrinsics.areEqual(viewEvent, TextExtractionErrorViewEvent.TryAgain.INSTANCE) ? true : Intrinsics.areEqual(viewEvent, TextExtractionErrorViewEvent.NavigateBack.INSTANCE)) {
                this._navigationEvent.setValue(new SingleEvent<>(TextExtractionErrorNavigationEvent.NavigateBackToFirstScreen.INSTANCE));
            }
        }
    }
}
