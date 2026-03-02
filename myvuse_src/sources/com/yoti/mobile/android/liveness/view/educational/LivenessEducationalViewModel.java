package com.yoti.mobile.android.liveness.view.educational;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.commonui.SingleLiveDataEvent;
import com.yoti.mobile.android.liveness.domain.CreateLivenessResourceInteractor;
import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import com.yoti.mobile.android.yotidocs.common.SingleUseCase;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import io.reactivex.observers.DisposableSingleObserver;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001:\u0004,-./B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u001b\u001a\u00020\u001cH\u0012J\b\u0010\u001d\u001a\u00020\u001cH\u0012J\b\u0010\u001e\u001a\u00020\u001cH\u0012J\b\u0010\u001f\u001a\u00020\u001cH\u0012J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0012J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0012J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u001cH\u0012J\b\u0010*\u001a\u00020\u001cH\u0012J\b\u0010+\u001a\u00020\u001cH\u0014R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u00060"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel;", "Landroidx/lifecycle/ViewModel;", "viewConfiguration", "Lcom/yoti/mobile/android/liveness/view/educational/ILivenessEducationalViewConfiguration;", "createLivenessResourceInteractor", "Lcom/yoti/mobile/android/liveness/domain/CreateLivenessResourceInteractor;", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "errorToFailureMapper", "Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;", "errorToSessionStatusTypeMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "(Lcom/yoti/mobile/android/liveness/view/educational/ILivenessEducationalViewConfiguration;Lcom/yoti/mobile/android/liveness/domain/CreateLivenessResourceInteractor;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;)V", "_navigationEvent", "Lcom/yoti/mobile/android/commonui/SingleLiveDataEvent;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalNavigationEvent;", "_viewState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState;", "navigationEvent", "Landroidx/lifecycle/LiveData;", "getNavigationEvent", "()Landroidx/lifecycle/LiveData;", "viewState", "getViewState", "configureView", "", "createLivenessResource", "denyCameraPermissions", "grantCameraPermissions", "handleLivenessResourceCreationError", "exception", "", "handleLivenessResourceCreationSuccess", "livenessResource", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;", "handleViewEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent;", "navigateToGuidelines", "navigateToMoreAboutVerification", "onCleared", "EducationalNavigationEvent", "EducationalViewState", "LivenessEducationalViewEvent", "LivenessResourceCreationObserver", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class LivenessEducationalViewModel extends ViewModel {
    private final SingleLiveDataEvent<EducationalNavigationEvent> _navigationEvent;
    private final MutableLiveData<EducationalViewState> _viewState;
    private final CreateLivenessResourceInteractor createLivenessResourceInteractor;
    private final ExceptionToFailureMapper errorToFailureMapper;
    private final ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper;
    private final LivenessFeatureConfiguration featureConfiguration;
    private final LiveData<EducationalNavigationEvent> navigationEvent;
    private final SessionStatus sessionStatus;
    private final ILivenessEducationalViewConfiguration viewConfiguration;
    private final LiveData<EducationalViewState> viewState;

    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalNavigationEvent;", "", "()V", "NavigateToGuidelines", "NavigateToLivenessCapture", "NavigateToMoreAboutVerification", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalNavigationEvent$NavigateToMoreAboutVerification;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalNavigationEvent$NavigateToGuidelines;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalNavigationEvent$NavigateToLivenessCapture;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class EducationalNavigationEvent {

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalNavigationEvent$NavigateToGuidelines;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalNavigationEvent;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class NavigateToGuidelines extends EducationalNavigationEvent {
            public static final NavigateToGuidelines INSTANCE = new NavigateToGuidelines();

            private NavigateToGuidelines() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalNavigationEvent$NavigateToLivenessCapture;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalNavigationEvent;", "livenessResource", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;", "(Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;)V", "getLivenessResource", "()Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class NavigateToLivenessCapture extends EducationalNavigationEvent {
            private final ILivenessResourceEntity livenessResource;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToLivenessCapture(ILivenessResourceEntity livenessResource) {
                super(null);
                Intrinsics.checkNotNullParameter(livenessResource, "livenessResource");
                this.livenessResource = livenessResource;
            }

            public static /* synthetic */ NavigateToLivenessCapture copy$default(NavigateToLivenessCapture navigateToLivenessCapture, ILivenessResourceEntity iLivenessResourceEntity, int i, Object obj) {
                if ((i & 1) != 0) {
                    iLivenessResourceEntity = navigateToLivenessCapture.livenessResource;
                }
                return navigateToLivenessCapture.copy(iLivenessResourceEntity);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ILivenessResourceEntity getLivenessResource() {
                return this.livenessResource;
            }

            public final NavigateToLivenessCapture copy(ILivenessResourceEntity livenessResource) {
                Intrinsics.checkNotNullParameter(livenessResource, "livenessResource");
                return new NavigateToLivenessCapture(livenessResource);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToLivenessCapture) && Intrinsics.areEqual(this.livenessResource, ((NavigateToLivenessCapture) other).livenessResource);
            }

            public final ILivenessResourceEntity getLivenessResource() {
                return this.livenessResource;
            }

            public int hashCode() {
                return this.livenessResource.hashCode();
            }

            public String toString() {
                return "NavigateToLivenessCapture(livenessResource=" + this.livenessResource + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalNavigationEvent$NavigateToMoreAboutVerification;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalNavigationEvent;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;)V", "getFeatureConfiguration", "()Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class NavigateToMoreAboutVerification extends EducationalNavigationEvent {
            private final LivenessFeatureConfiguration featureConfiguration;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToMoreAboutVerification(LivenessFeatureConfiguration featureConfiguration) {
                super(null);
                Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
                this.featureConfiguration = featureConfiguration;
            }

            public static /* synthetic */ NavigateToMoreAboutVerification copy$default(NavigateToMoreAboutVerification navigateToMoreAboutVerification, LivenessFeatureConfiguration livenessFeatureConfiguration, int i, Object obj) {
                if ((i & 1) != 0) {
                    livenessFeatureConfiguration = navigateToMoreAboutVerification.featureConfiguration;
                }
                return navigateToMoreAboutVerification.copy(livenessFeatureConfiguration);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final LivenessFeatureConfiguration getFeatureConfiguration() {
                return this.featureConfiguration;
            }

            public final NavigateToMoreAboutVerification copy(LivenessFeatureConfiguration featureConfiguration) {
                Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
                return new NavigateToMoreAboutVerification(featureConfiguration);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToMoreAboutVerification) && Intrinsics.areEqual(this.featureConfiguration, ((NavigateToMoreAboutVerification) other).featureConfiguration);
            }

            public final LivenessFeatureConfiguration getFeatureConfiguration() {
                return this.featureConfiguration;
            }

            public int hashCode() {
                return this.featureConfiguration.hashCode();
            }

            public String toString() {
                return "NavigateToMoreAboutVerification(featureConfiguration=" + this.featureConfiguration + ')';
            }
        }

        private EducationalNavigationEvent() {
        }

        public /* synthetic */ EducationalNavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState;", "", "()V", "CameraPermissionsDenied", "CameraPermissionsGranted", "ResourceIdRequestFailure", "ResourceIdRequestInProgress", "ViewConfiguration", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState$ViewConfiguration;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState$CameraPermissionsGranted;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState$CameraPermissionsDenied;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState$ResourceIdRequestInProgress;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState$ResourceIdRequestFailure;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class EducationalViewState {

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState$CameraPermissionsDenied;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class CameraPermissionsDenied extends EducationalViewState {
            public static final CameraPermissionsDenied INSTANCE = new CameraPermissionsDenied();

            private CameraPermissionsDenied() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState$CameraPermissionsGranted;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class CameraPermissionsGranted extends EducationalViewState {
            public static final CameraPermissionsGranted INSTANCE = new CameraPermissionsGranted();

            private CameraPermissionsGranted() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState$ResourceIdRequestFailure;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState;", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;)V", "getFailure", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class ResourceIdRequestFailure extends EducationalViewState {
            private final YdsFailure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ResourceIdRequestFailure(YdsFailure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ ResourceIdRequestFailure copy$default(ResourceIdRequestFailure resourceIdRequestFailure, YdsFailure ydsFailure, int i, Object obj) {
                if ((i & 1) != 0) {
                    ydsFailure = resourceIdRequestFailure.failure;
                }
                return resourceIdRequestFailure.copy(ydsFailure);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final YdsFailure getFailure() {
                return this.failure;
            }

            public final ResourceIdRequestFailure copy(YdsFailure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new ResourceIdRequestFailure(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ResourceIdRequestFailure) && Intrinsics.areEqual(this.failure, ((ResourceIdRequestFailure) other).failure);
            }

            public final YdsFailure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "ResourceIdRequestFailure(failure=" + this.failure + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState$ResourceIdRequestInProgress;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class ResourceIdRequestInProgress extends EducationalViewState {
            public static final ResourceIdRequestInProgress INSTANCE = new ResourceIdRequestInProgress();

            private ResourceIdRequestInProgress() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState$ViewConfiguration;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState;", "viewConfig", "Lcom/yoti/mobile/android/liveness/view/educational/ILivenessEducationalViewConfiguration;", "isMoreAboutVerificationAvailable", "", "(Lcom/yoti/mobile/android/liveness/view/educational/ILivenessEducationalViewConfiguration;Z)V", "()Z", "getViewConfig", "()Lcom/yoti/mobile/android/liveness/view/educational/ILivenessEducationalViewConfiguration;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class ViewConfiguration extends EducationalViewState {
            private final boolean isMoreAboutVerificationAvailable;
            private final ILivenessEducationalViewConfiguration viewConfig;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewConfiguration(ILivenessEducationalViewConfiguration viewConfig, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(viewConfig, "viewConfig");
                this.viewConfig = viewConfig;
                this.isMoreAboutVerificationAvailable = z;
            }

            public static /* synthetic */ ViewConfiguration copy$default(ViewConfiguration viewConfiguration, ILivenessEducationalViewConfiguration iLivenessEducationalViewConfiguration, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    iLivenessEducationalViewConfiguration = viewConfiguration.viewConfig;
                }
                if ((i & 2) != 0) {
                    z = viewConfiguration.isMoreAboutVerificationAvailable;
                }
                return viewConfiguration.copy(iLivenessEducationalViewConfiguration, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ILivenessEducationalViewConfiguration getViewConfig() {
                return this.viewConfig;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsMoreAboutVerificationAvailable() {
                return this.isMoreAboutVerificationAvailable;
            }

            public final ViewConfiguration copy(ILivenessEducationalViewConfiguration viewConfig, boolean isMoreAboutVerificationAvailable) {
                Intrinsics.checkNotNullParameter(viewConfig, "viewConfig");
                return new ViewConfiguration(viewConfig, isMoreAboutVerificationAvailable);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ViewConfiguration)) {
                    return false;
                }
                ViewConfiguration viewConfiguration = (ViewConfiguration) other;
                return Intrinsics.areEqual(this.viewConfig, viewConfiguration.viewConfig) && this.isMoreAboutVerificationAvailable == viewConfiguration.isMoreAboutVerificationAvailable;
            }

            public final ILivenessEducationalViewConfiguration getViewConfig() {
                return this.viewConfig;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                int iHashCode = this.viewConfig.hashCode() * 31;
                boolean z = this.isMoreAboutVerificationAvailable;
                ?? r1 = z;
                if (z) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public final boolean isMoreAboutVerificationAvailable() {
                return this.isMoreAboutVerificationAvailable;
            }

            public String toString() {
                return "ViewConfiguration(viewConfig=" + this.viewConfig + ", isMoreAboutVerificationAvailable=" + this.isMoreAboutVerificationAvailable + ')';
            }
        }

        private EducationalViewState() {
        }

        public /* synthetic */ EducationalViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent;", "", "()V", "OnCameraPermissionsDenied", "OnCameraPermissionsGranted", "OnGuidelinesClick", "OnMoreAboutVerificationClick", "OnStartScan", "OnViewShown", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent$OnViewShown;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent$OnMoreAboutVerificationClick;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent$OnGuidelinesClick;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent$OnCameraPermissionsDenied;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent$OnCameraPermissionsGranted;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent$OnStartScan;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class LivenessEducationalViewEvent {

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent$OnCameraPermissionsDenied;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class OnCameraPermissionsDenied extends LivenessEducationalViewEvent {
            public static final OnCameraPermissionsDenied INSTANCE = new OnCameraPermissionsDenied();

            private OnCameraPermissionsDenied() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent$OnCameraPermissionsGranted;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class OnCameraPermissionsGranted extends LivenessEducationalViewEvent {
            public static final OnCameraPermissionsGranted INSTANCE = new OnCameraPermissionsGranted();

            private OnCameraPermissionsGranted() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent$OnGuidelinesClick;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class OnGuidelinesClick extends LivenessEducationalViewEvent {
            public static final OnGuidelinesClick INSTANCE = new OnGuidelinesClick();

            private OnGuidelinesClick() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent$OnMoreAboutVerificationClick;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class OnMoreAboutVerificationClick extends LivenessEducationalViewEvent {
            public static final OnMoreAboutVerificationClick INSTANCE = new OnMoreAboutVerificationClick();

            private OnMoreAboutVerificationClick() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent$OnStartScan;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class OnStartScan extends LivenessEducationalViewEvent {
            public static final OnStartScan INSTANCE = new OnStartScan();

            private OnStartScan() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent$OnViewShown;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessEducationalViewEvent;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class OnViewShown extends LivenessEducationalViewEvent {
            public static final OnViewShown INSTANCE = new OnViewShown();

            private OnViewShown() {
                super(null);
            }
        }

        private LivenessEducationalViewEvent() {
        }

        public /* synthetic */ LivenessEducationalViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$LivenessResourceCreationObserver;", "Lio/reactivex/observers/DisposableSingleObserver;", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;", "(Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel;)V", "onError", "", "exception", "", "onSuccess", "livenessResource", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private final class LivenessResourceCreationObserver extends DisposableSingleObserver<ILivenessResourceEntity> {
        public LivenessResourceCreationObserver() {
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            LivenessEducationalViewModel.this.handleLivenessResourceCreationError(exception);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(ILivenessResourceEntity livenessResource) {
            Intrinsics.checkNotNullParameter(livenessResource, "livenessResource");
            LivenessEducationalViewModel.this.handleLivenessResourceCreationSuccess(livenessResource);
        }
    }

    @Inject
    public LivenessEducationalViewModel(ILivenessEducationalViewConfiguration viewConfiguration, CreateLivenessResourceInteractor createLivenessResourceInteractor, SessionStatus sessionStatus, ExceptionToFailureMapper errorToFailureMapper, ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper, LivenessFeatureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(viewConfiguration, "viewConfiguration");
        Intrinsics.checkNotNullParameter(createLivenessResourceInteractor, "createLivenessResourceInteractor");
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        Intrinsics.checkNotNullParameter(errorToFailureMapper, "errorToFailureMapper");
        Intrinsics.checkNotNullParameter(errorToSessionStatusTypeMapper, "errorToSessionStatusTypeMapper");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.viewConfiguration = viewConfiguration;
        this.createLivenessResourceInteractor = createLivenessResourceInteractor;
        this.sessionStatus = sessionStatus;
        this.errorToFailureMapper = errorToFailureMapper;
        this.errorToSessionStatusTypeMapper = errorToSessionStatusTypeMapper;
        this.featureConfiguration = featureConfiguration;
        MutableLiveData<EducationalViewState> mutableLiveData = new MutableLiveData<>();
        this._viewState = mutableLiveData;
        this.viewState = mutableLiveData;
        SingleLiveDataEvent<EducationalNavigationEvent> singleLiveDataEvent = new SingleLiveDataEvent<>(null, 1, null);
        this._navigationEvent = singleLiveDataEvent;
        this.navigationEvent = singleLiveDataEvent;
    }

    private void configureView() {
        this._viewState.setValue(new EducationalViewState.ViewConfiguration(this.viewConfiguration, this.featureConfiguration.isMoreAboutVerificationEnabled()));
    }

    private void createLivenessResource() {
        this._viewState.setValue(EducationalViewState.ResourceIdRequestInProgress.INSTANCE);
        this.createLivenessResourceInteractor.clear();
        SingleUseCase.execute$default(this.createLivenessResourceInteractor, new LivenessResourceCreationObserver(), null, 2, null);
    }

    private void denyCameraPermissions() {
        this.sessionStatus.setSessionStatus(SessionStatusType.NO_CAMERA_PERMISSION);
        this._viewState.setValue(EducationalViewState.CameraPermissionsDenied.INSTANCE);
    }

    private void grantCameraPermissions() {
        this.sessionStatus.resetSessionStatusType();
        this._viewState.setValue(EducationalViewState.CameraPermissionsGranted.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLivenessResourceCreationError(Throwable exception) {
        this.sessionStatus.setSessionStatus(this.errorToSessionStatusTypeMapper.map(exception));
        this._viewState.setValue(new EducationalViewState.ResourceIdRequestFailure(this.errorToFailureMapper.map(exception)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLivenessResourceCreationSuccess(ILivenessResourceEntity livenessResource) {
        this._navigationEvent.setValue(new EducationalNavigationEvent.NavigateToLivenessCapture(livenessResource));
    }

    private void navigateToGuidelines() {
        this._navigationEvent.setValue(EducationalNavigationEvent.NavigateToGuidelines.INSTANCE);
    }

    private void navigateToMoreAboutVerification() {
        this._navigationEvent.setValue(new EducationalNavigationEvent.NavigateToMoreAboutVerification(this.viewConfiguration.getFeatureConfiguration()));
    }

    public LiveData<EducationalNavigationEvent> getNavigationEvent() {
        return this.navigationEvent;
    }

    public LiveData<EducationalViewState> getViewState() {
        return this.viewState;
    }

    public void handleViewEvent(LivenessEducationalViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof LivenessEducationalViewEvent.OnViewShown) {
            configureView();
            return;
        }
        if (event instanceof LivenessEducationalViewEvent.OnStartScan) {
            createLivenessResource();
            return;
        }
        if (event instanceof LivenessEducationalViewEvent.OnMoreAboutVerificationClick) {
            navigateToMoreAboutVerification();
            return;
        }
        if (event instanceof LivenessEducationalViewEvent.OnGuidelinesClick) {
            navigateToGuidelines();
        } else if (event instanceof LivenessEducationalViewEvent.OnCameraPermissionsGranted) {
            grantCameraPermissions();
        } else if (event instanceof LivenessEducationalViewEvent.OnCameraPermissionsDenied) {
            denyCameraPermissions();
        }
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        this.createLivenessResourceInteractor.clear();
        super.onCleared();
    }
}
