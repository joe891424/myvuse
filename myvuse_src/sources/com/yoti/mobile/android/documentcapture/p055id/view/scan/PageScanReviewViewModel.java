package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.commonui.SingleLiveDataEvent;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0011\u0018\u00002\u00020\u0001:\u0001\u001eB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u000fH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0092.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel;", "Landroidx/lifecycle/ViewModel;", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "errorToSessionStatusTypeMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;)V", "_currentState", "Lcom/yoti/mobile/android/commonui/SingleLiveDataEvent;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState;", "currentState", "Landroidx/lifecycle/LiveData;", "getCurrentState", "()Landroidx/lifecycle/LiveData;", "pageReviewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;", "errorDialogNegativeButtonClicked", "", "errorDialogPositiveButtonClicked", "guidelinesBackNavClicked", "guidelinesButtonClicked", "guidelinesGotItButtonClicked", "primaryButtonClicked", "reviewError", "error", "", "reviewScreenDismissed", "secondaryButtonClicked", "setupPageReviewData", "pageScanReviewViewData", "ReviewState", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class PageScanReviewViewModel extends ViewModel {
    private final SingleLiveDataEvent<ReviewState> _currentState;
    private final LiveData<ReviewState> currentState;
    private final ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper;
    private PageScanReviewViewData pageReviewData;
    private final SessionStatus sessionStatus;

    @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState;", "", "()V", "Error", "PageApproved", "PageRejected", "Progress", "ScreenLoading", "ScreenLoadingWithUploadOption", "ShowGuidelines", "ShowReview", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$ScreenLoading;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$ScreenLoadingWithUploadOption;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$ShowGuidelines;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$ShowReview;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$PageApproved;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$PageRejected;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$Progress;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$Error;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class ReviewState {

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$Error;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState;", "()V", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Error extends ReviewState {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$PageApproved;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState;", "()V", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class PageApproved extends ReviewState {
            public static final PageApproved INSTANCE = new PageApproved();

            private PageApproved() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$PageRejected;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState;", "()V", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class PageRejected extends ReviewState {
            public static final PageRejected INSTANCE = new PageRejected();

            private PageRejected() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$Progress;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState;", "()V", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Progress extends ReviewState {
            public static final Progress INSTANCE = new Progress();

            private Progress() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$ScreenLoading;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState;", "screenData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;", "showConsentText", "", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;Z)V", "getScreenData", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;", "getShowConsentText", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class ScreenLoading extends ReviewState {
            private final PageScanReviewViewData screenData;
            private final boolean showConsentText;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ScreenLoading(PageScanReviewViewData screenData, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(screenData, "screenData");
                this.screenData = screenData;
                this.showConsentText = z;
            }

            public static /* synthetic */ ScreenLoading copy$default(ScreenLoading screenLoading, PageScanReviewViewData pageScanReviewViewData, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    pageScanReviewViewData = screenLoading.screenData;
                }
                if ((i & 2) != 0) {
                    z = screenLoading.showConsentText;
                }
                return screenLoading.copy(pageScanReviewViewData, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PageScanReviewViewData getScreenData() {
                return this.screenData;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getShowConsentText() {
                return this.showConsentText;
            }

            public final ScreenLoading copy(PageScanReviewViewData screenData, boolean showConsentText) {
                Intrinsics.checkNotNullParameter(screenData, "screenData");
                return new ScreenLoading(screenData, showConsentText);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ScreenLoading)) {
                    return false;
                }
                ScreenLoading screenLoading = (ScreenLoading) other;
                return Intrinsics.areEqual(this.screenData, screenLoading.screenData) && this.showConsentText == screenLoading.showConsentText;
            }

            public final PageScanReviewViewData getScreenData() {
                return this.screenData;
            }

            public final boolean getShowConsentText() {
                return this.showConsentText;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                int iHashCode = this.screenData.hashCode() * 31;
                boolean z = this.showConsentText;
                ?? r1 = z;
                if (z) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                return "ScreenLoading(screenData=" + this.screenData + ", showConsentText=" + this.showConsentText + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$ScreenLoadingWithUploadOption;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState;", "screenData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;", "showConsentText", "", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;Z)V", "getScreenData", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;", "getShowConsentText", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class ScreenLoadingWithUploadOption extends ReviewState {
            private final PageScanReviewViewData screenData;
            private final boolean showConsentText;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ScreenLoadingWithUploadOption(PageScanReviewViewData screenData, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(screenData, "screenData");
                this.screenData = screenData;
                this.showConsentText = z;
            }

            public static /* synthetic */ ScreenLoadingWithUploadOption copy$default(ScreenLoadingWithUploadOption screenLoadingWithUploadOption, PageScanReviewViewData pageScanReviewViewData, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    pageScanReviewViewData = screenLoadingWithUploadOption.screenData;
                }
                if ((i & 2) != 0) {
                    z = screenLoadingWithUploadOption.showConsentText;
                }
                return screenLoadingWithUploadOption.copy(pageScanReviewViewData, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PageScanReviewViewData getScreenData() {
                return this.screenData;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getShowConsentText() {
                return this.showConsentText;
            }

            public final ScreenLoadingWithUploadOption copy(PageScanReviewViewData screenData, boolean showConsentText) {
                Intrinsics.checkNotNullParameter(screenData, "screenData");
                return new ScreenLoadingWithUploadOption(screenData, showConsentText);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ScreenLoadingWithUploadOption)) {
                    return false;
                }
                ScreenLoadingWithUploadOption screenLoadingWithUploadOption = (ScreenLoadingWithUploadOption) other;
                return Intrinsics.areEqual(this.screenData, screenLoadingWithUploadOption.screenData) && this.showConsentText == screenLoadingWithUploadOption.showConsentText;
            }

            public final PageScanReviewViewData getScreenData() {
                return this.screenData;
            }

            public final boolean getShowConsentText() {
                return this.showConsentText;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                int iHashCode = this.screenData.hashCode() * 31;
                boolean z = this.showConsentText;
                ?? r1 = z;
                if (z) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                return "ScreenLoadingWithUploadOption(screenData=" + this.screenData + ", showConsentText=" + this.showConsentText + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$ShowGuidelines;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState;", "()V", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class ShowGuidelines extends ReviewState {
            public static final ShowGuidelines INSTANCE = new ShowGuidelines();

            private ShowGuidelines() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState$ShowReview;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState;", "()V", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class ShowReview extends ReviewState {
            public static final ShowReview INSTANCE = new ShowReview();

            private ShowReview() {
                super(null);
            }
        }

        private ReviewState() {
        }

        public /* synthetic */ ReviewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public PageScanReviewViewModel(SessionStatus sessionStatus, ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper) {
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        Intrinsics.checkNotNullParameter(errorToSessionStatusTypeMapper, "errorToSessionStatusTypeMapper");
        this.sessionStatus = sessionStatus;
        this.errorToSessionStatusTypeMapper = errorToSessionStatusTypeMapper;
        SingleLiveDataEvent<ReviewState> singleLiveDataEvent = new SingleLiveDataEvent<>(null, 1, null);
        this._currentState = singleLiveDataEvent;
        this.currentState = singleLiveDataEvent;
    }

    public void errorDialogNegativeButtonClicked() {
        this._currentState.setValue(ReviewState.PageRejected.INSTANCE);
    }

    public void errorDialogPositiveButtonClicked() {
        this._currentState.setValue(ReviewState.PageRejected.INSTANCE);
    }

    public LiveData<ReviewState> getCurrentState() {
        return this.currentState;
    }

    public void guidelinesBackNavClicked() {
        this._currentState.setValue(ReviewState.ShowReview.INSTANCE);
    }

    public void guidelinesButtonClicked() {
        this._currentState.setValue(ReviewState.ShowGuidelines.INSTANCE);
    }

    public void guidelinesGotItButtonClicked() {
        this._currentState.setValue(ReviewState.ShowReview.INSTANCE);
    }

    public void primaryButtonClicked() {
        PageScanReviewViewData pageScanReviewViewData = this.pageReviewData;
        if (pageScanReviewViewData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageReviewData");
            pageScanReviewViewData = null;
        }
        if (pageScanReviewViewData.isLastPage()) {
            this._currentState.setValue(ReviewState.Progress.INSTANCE);
        } else {
            this._currentState.setValue(ReviewState.PageApproved.INSTANCE);
        }
    }

    public void reviewError(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.sessionStatus.setSessionStatus(this.errorToSessionStatusTypeMapper.map(error));
        this._currentState.setValue(ReviewState.Error.INSTANCE);
    }

    public void reviewScreenDismissed() {
        if (this._currentState.getValue() instanceof ReviewState.Progress) {
            return;
        }
        this._currentState.setValue(ReviewState.PageRejected.INSTANCE);
    }

    public void secondaryButtonClicked() {
        this._currentState.setValue(ReviewState.PageRejected.INSTANCE);
    }

    public void setupPageReviewData(PageScanReviewViewData pageScanReviewViewData) {
        ReviewState screenLoading;
        Intrinsics.checkNotNullParameter(pageScanReviewViewData, "pageScanReviewViewData");
        this.pageReviewData = pageScanReviewViewData;
        boolean zIsLastPage = pageScanReviewViewData.isLastPage();
        SingleLiveDataEvent<ReviewState> singleLiveDataEvent = this._currentState;
        PageScanReviewViewData pageScanReviewViewData2 = null;
        if (!pageScanReviewViewData.isLastPage() || pageScanReviewViewData.getShowNfcOption()) {
            PageScanReviewViewData pageScanReviewViewData3 = this.pageReviewData;
            if (pageScanReviewViewData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageReviewData");
            } else {
                pageScanReviewViewData2 = pageScanReviewViewData3;
            }
            screenLoading = new ReviewState.ScreenLoading(pageScanReviewViewData2, zIsLastPage);
        } else {
            PageScanReviewViewData pageScanReviewViewData4 = this.pageReviewData;
            if (pageScanReviewViewData4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageReviewData");
            } else {
                pageScanReviewViewData2 = pageScanReviewViewData4;
            }
            screenLoading = new ReviewState.ScreenLoadingWithUploadOption(pageScanReviewViewData2, zIsLastPage);
        }
        singleLiveDataEvent.setValue(screenLoading);
    }
}
