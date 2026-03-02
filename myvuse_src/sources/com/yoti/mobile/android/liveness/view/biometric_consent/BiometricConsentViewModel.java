package com.yoti.mobile.android.liveness.view.biometric_consent;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.commonui.SingleLiveDataEvent;
import com.yoti.mobile.android.liveness.domain.GiveBiometricConsentInteractor;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewData;
import com.yoti.mobile.android.yotidocs.common.CompletableUseCase;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import io.reactivex.observers.DisposableCompletableObserver;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0005'()*+B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u001f\u001a\u00020 H\u0002J\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0014R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001a¨\u0006,"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel;", "Landroidx/lifecycle/ViewModel;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "biometricConsentViewDataFactory", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$Factory;", "giveBiometricConsentInteractor", "Lcom/yoti/mobile/android/liveness/domain/GiveBiometricConsentInteractor;", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "errorToFailureMapper", "Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;", "errorToSessionStatusTypeMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$Factory;Lcom/yoti/mobile/android/liveness/domain/GiveBiometricConsentInteractor;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;)V", "_navigationEvent", "Lcom/yoti/mobile/android/commonui/SingleLiveDataEvent;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentNavigationEvent;", "_sideEffect", "Landroidx/lifecycle/MutableLiveData;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentSideEffect;", "_viewState", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewState;", "navigationEvent", "Landroidx/lifecycle/LiveData;", "getNavigationEvent", "()Landroidx/lifecycle/LiveData;", "sideEffect", "getSideEffect", "viewState", "getViewState", "giveBiometricConsent", "", "handleViewEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewEvent;", "navigateToBiometricPolicyUsLink", "navigateToPrivacyPolicyLink", "onCleared", "BiometricConsentNavigationEvent", "BiometricConsentSideEffect", "BiometricConsentViewEvent", "BiometricConsentViewState", "GiveBiometricConsentObserver", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class BiometricConsentViewModel extends ViewModel {
    private final SingleLiveDataEvent<BiometricConsentNavigationEvent> _navigationEvent;
    private final MutableLiveData<BiometricConsentSideEffect> _sideEffect;
    private final MutableLiveData<BiometricConsentViewState> _viewState;
    private final ExceptionToFailureMapper errorToFailureMapper;
    private final ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper;
    private final LivenessFeatureConfiguration featureConfiguration;
    private final GiveBiometricConsentInteractor giveBiometricConsentInteractor;
    private final LiveData<BiometricConsentNavigationEvent> navigationEvent;
    private final SessionStatus sessionStatus;
    private final LiveData<BiometricConsentSideEffect> sideEffect;
    private final LiveData<BiometricConsentViewState> viewState;

    @Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentNavigationEvent;", "", "()V", "NavigateToEducational", "NavigateToWebViewScreen", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentNavigationEvent$NavigateToWebViewScreen;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentNavigationEvent$NavigateToEducational;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class BiometricConsentNavigationEvent {

        @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentNavigationEvent$NavigateToEducational;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentNavigationEvent;", "isFirstFlowScreen", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class NavigateToEducational extends BiometricConsentNavigationEvent {
            private final boolean isFirstFlowScreen;

            public NavigateToEducational(boolean z) {
                super(null);
                this.isFirstFlowScreen = z;
            }

            public static /* synthetic */ NavigateToEducational copy$default(NavigateToEducational navigateToEducational, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = navigateToEducational.isFirstFlowScreen;
                }
                return navigateToEducational.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsFirstFlowScreen() {
                return this.isFirstFlowScreen;
            }

            public final NavigateToEducational copy(boolean isFirstFlowScreen) {
                return new NavigateToEducational(isFirstFlowScreen);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToEducational) && this.isFirstFlowScreen == ((NavigateToEducational) other).isFirstFlowScreen;
            }

            public int hashCode() {
                boolean z = this.isFirstFlowScreen;
                if (z) {
                    return 1;
                }
                return z ? 1 : 0;
            }

            public final boolean isFirstFlowScreen() {
                return this.isFirstFlowScreen;
            }

            public String toString() {
                return "NavigateToEducational(isFirstFlowScreen=" + this.isFirstFlowScreen + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentNavigationEvent$NavigateToWebViewScreen;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentNavigationEvent;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class NavigateToWebViewScreen extends BiometricConsentNavigationEvent {
            private final String url;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToWebViewScreen(String url) {
                super(null);
                Intrinsics.checkNotNullParameter(url, "url");
                this.url = url;
            }

            public static /* synthetic */ NavigateToWebViewScreen copy$default(NavigateToWebViewScreen navigateToWebViewScreen, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = navigateToWebViewScreen.url;
                }
                return navigateToWebViewScreen.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final NavigateToWebViewScreen copy(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return new NavigateToWebViewScreen(url);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToWebViewScreen) && Intrinsics.areEqual(this.url, ((NavigateToWebViewScreen) other).url);
            }

            public final String getUrl() {
                return this.url;
            }

            public int hashCode() {
                return this.url.hashCode();
            }

            public String toString() {
                return "NavigateToWebViewScreen(url=" + this.url + ')';
            }
        }

        private BiometricConsentNavigationEvent() {
        }

        public /* synthetic */ BiometricConsentNavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentSideEffect;", "", "()V", "BiometricConsentRequestFailure", "BiometricConsentRequestInProgress", "BiometricConsentRequestSuccess", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentSideEffect$BiometricConsentRequestInProgress;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentSideEffect$BiometricConsentRequestSuccess;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentSideEffect$BiometricConsentRequestFailure;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class BiometricConsentSideEffect {

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentSideEffect$BiometricConsentRequestFailure;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentSideEffect;", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;)V", "getFailure", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class BiometricConsentRequestFailure extends BiometricConsentSideEffect {
            private final YdsFailure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BiometricConsentRequestFailure(YdsFailure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ BiometricConsentRequestFailure copy$default(BiometricConsentRequestFailure biometricConsentRequestFailure, YdsFailure ydsFailure, int i, Object obj) {
                if ((i & 1) != 0) {
                    ydsFailure = biometricConsentRequestFailure.failure;
                }
                return biometricConsentRequestFailure.copy(ydsFailure);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final YdsFailure getFailure() {
                return this.failure;
            }

            public final BiometricConsentRequestFailure copy(YdsFailure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new BiometricConsentRequestFailure(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof BiometricConsentRequestFailure) && Intrinsics.areEqual(this.failure, ((BiometricConsentRequestFailure) other).failure);
            }

            public final YdsFailure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "BiometricConsentRequestFailure(failure=" + this.failure + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentSideEffect$BiometricConsentRequestInProgress;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentSideEffect;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class BiometricConsentRequestInProgress extends BiometricConsentSideEffect {
            public static final BiometricConsentRequestInProgress INSTANCE = new BiometricConsentRequestInProgress();

            private BiometricConsentRequestInProgress() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentSideEffect$BiometricConsentRequestSuccess;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentSideEffect;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class BiometricConsentRequestSuccess extends BiometricConsentSideEffect {
            public static final BiometricConsentRequestSuccess INSTANCE = new BiometricConsentRequestSuccess();

            private BiometricConsentRequestSuccess() {
                super(null);
            }
        }

        private BiometricConsentSideEffect() {
        }

        public /* synthetic */ BiometricConsentSideEffect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewEvent;", "", "()V", "OnBiometricConsentGiven", "OnBiometricPolicyUsLinkClick", "OnPrivacyPolicyLinkClick", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewEvent$OnPrivacyPolicyLinkClick;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewEvent$OnBiometricPolicyUsLinkClick;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewEvent$OnBiometricConsentGiven;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class BiometricConsentViewEvent {

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewEvent$OnBiometricConsentGiven;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewEvent;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class OnBiometricConsentGiven extends BiometricConsentViewEvent {
            public static final OnBiometricConsentGiven INSTANCE = new OnBiometricConsentGiven();

            private OnBiometricConsentGiven() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewEvent$OnBiometricPolicyUsLinkClick;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewEvent;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class OnBiometricPolicyUsLinkClick extends BiometricConsentViewEvent {
            public static final OnBiometricPolicyUsLinkClick INSTANCE = new OnBiometricPolicyUsLinkClick();

            private OnBiometricPolicyUsLinkClick() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewEvent$OnPrivacyPolicyLinkClick;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewEvent;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class OnPrivacyPolicyLinkClick extends BiometricConsentViewEvent {
            public static final OnPrivacyPolicyLinkClick INSTANCE = new OnPrivacyPolicyLinkClick();

            private OnPrivacyPolicyLinkClick() {
                super(null);
            }
        }

        private BiometricConsentViewEvent() {
        }

        public /* synthetic */ BiometricConsentViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewState;", "", "()V", "ViewConfiguration", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewState$ViewConfiguration;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class BiometricConsentViewState {

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewState$ViewConfiguration;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewState;", "data", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData;", "(Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData;)V", "getData", "()Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class ViewConfiguration extends BiometricConsentViewState {
            private final BiometricConsentViewData data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewConfiguration(BiometricConsentViewData data) {
                super(null);
                Intrinsics.checkNotNullParameter(data, "data");
                this.data = data;
            }

            public static /* synthetic */ ViewConfiguration copy$default(ViewConfiguration viewConfiguration, BiometricConsentViewData biometricConsentViewData, int i, Object obj) {
                if ((i & 1) != 0) {
                    biometricConsentViewData = viewConfiguration.data;
                }
                return viewConfiguration.copy(biometricConsentViewData);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BiometricConsentViewData getData() {
                return this.data;
            }

            public final ViewConfiguration copy(BiometricConsentViewData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return new ViewConfiguration(data);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ViewConfiguration) && Intrinsics.areEqual(this.data, ((ViewConfiguration) other).data);
            }

            public final BiometricConsentViewData getData() {
                return this.data;
            }

            public int hashCode() {
                return this.data.hashCode();
            }

            public String toString() {
                return "ViewConfiguration(data=" + this.data + ')';
            }
        }

        private BiometricConsentViewState() {
        }

        public /* synthetic */ BiometricConsentViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$GiveBiometricConsentObserver;", "Lio/reactivex/observers/DisposableCompletableObserver;", "(Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel;)V", "onComplete", "", "onError", "throwable", "", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private final class GiveBiometricConsentObserver extends DisposableCompletableObserver {
        public GiveBiometricConsentObserver() {
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            BiometricConsentViewModel.this._sideEffect.setValue(BiometricConsentSideEffect.BiometricConsentRequestSuccess.INSTANCE);
            BiometricConsentViewModel.this._navigationEvent.setValue(new BiometricConsentNavigationEvent.NavigateToEducational(false));
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            BiometricConsentViewModel.this._sideEffect.setValue(new BiometricConsentSideEffect.BiometricConsentRequestFailure(BiometricConsentViewModel.this.errorToFailureMapper.map(throwable)));
            BiometricConsentViewModel.this.sessionStatus.setSessionStatus(BiometricConsentViewModel.this.errorToSessionStatusTypeMapper.map(throwable));
        }
    }

    @Inject
    public BiometricConsentViewModel(LivenessFeatureConfiguration featureConfiguration, BiometricConsentViewData.Factory biometricConsentViewDataFactory, GiveBiometricConsentInteractor giveBiometricConsentInteractor, SessionStatus sessionStatus, ExceptionToFailureMapper errorToFailureMapper, ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        Intrinsics.checkNotNullParameter(biometricConsentViewDataFactory, "biometricConsentViewDataFactory");
        Intrinsics.checkNotNullParameter(giveBiometricConsentInteractor, "giveBiometricConsentInteractor");
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        Intrinsics.checkNotNullParameter(errorToFailureMapper, "errorToFailureMapper");
        Intrinsics.checkNotNullParameter(errorToSessionStatusTypeMapper, "errorToSessionStatusTypeMapper");
        this.featureConfiguration = featureConfiguration;
        this.giveBiometricConsentInteractor = giveBiometricConsentInteractor;
        this.sessionStatus = sessionStatus;
        this.errorToFailureMapper = errorToFailureMapper;
        this.errorToSessionStatusTypeMapper = errorToSessionStatusTypeMapper;
        MutableLiveData<BiometricConsentViewState> mutableLiveData = new MutableLiveData<>(new BiometricConsentViewState.ViewConfiguration(biometricConsentViewDataFactory.create()));
        this._viewState = mutableLiveData;
        this.viewState = mutableLiveData;
        SingleLiveDataEvent singleLiveDataEvent = new SingleLiveDataEvent(null, 1, null);
        this._sideEffect = singleLiveDataEvent;
        this.sideEffect = singleLiveDataEvent;
        SingleLiveDataEvent<BiometricConsentNavigationEvent> singleLiveDataEvent2 = featureConfiguration.getRequireBiometricConsent() ? new SingleLiveDataEvent<>(null, 1, null) : new SingleLiveDataEvent<>(new BiometricConsentNavigationEvent.NavigateToEducational(true));
        this._navigationEvent = singleLiveDataEvent2;
        this.navigationEvent = singleLiveDataEvent2;
    }

    private final void giveBiometricConsent() {
        this._sideEffect.setValue(BiometricConsentSideEffect.BiometricConsentRequestInProgress.INSTANCE);
        this.giveBiometricConsentInteractor.clear();
        CompletableUseCase.execute$default(this.giveBiometricConsentInteractor, new GiveBiometricConsentObserver(), null, 2, null);
    }

    private final void navigateToBiometricPolicyUsLink() {
        this._navigationEvent.setValue(new BiometricConsentNavigationEvent.NavigateToWebViewScreen(this.featureConfiguration.getBiometricPolicyUsUrl()));
    }

    private final void navigateToPrivacyPolicyLink() {
        String privacyPolicyUrl = this.featureConfiguration.getUiSessionConfiguration().getPrivacyPolicyUrl();
        if (privacyPolicyUrl != null) {
            this._navigationEvent.setValue(new BiometricConsentNavigationEvent.NavigateToWebViewScreen(privacyPolicyUrl));
        }
    }

    public final LiveData<BiometricConsentNavigationEvent> getNavigationEvent() {
        return this.navigationEvent;
    }

    public final LiveData<BiometricConsentSideEffect> getSideEffect() {
        return this.sideEffect;
    }

    public final LiveData<BiometricConsentViewState> getViewState() {
        return this.viewState;
    }

    public final void handleViewEvent(BiometricConsentViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, BiometricConsentViewEvent.OnBiometricConsentGiven.INSTANCE)) {
            giveBiometricConsent();
        } else if (Intrinsics.areEqual(event, BiometricConsentViewEvent.OnPrivacyPolicyLinkClick.INSTANCE)) {
            navigateToPrivacyPolicyLink();
        } else {
            if (!Intrinsics.areEqual(event, BiometricConsentViewEvent.OnBiometricPolicyUsLinkClick.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            navigateToBiometricPolicyUsLink();
        }
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        this.giveBiometricConsentInteractor.clear();
        super.onCleared();
    }
}
