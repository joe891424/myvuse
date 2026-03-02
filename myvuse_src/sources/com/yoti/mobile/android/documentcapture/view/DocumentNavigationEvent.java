package com.yoti.mobile.android.documentcapture.view;

import android.os.Bundle;
import com.yoti.mobile.android.commons.navigation.NavigationEvent;
import com.yoti.mobile.android.commonui.moreabout.MoreAboutFragmentArgs;
import com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DoNotHaveDocumentsDialogViewData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0003\u0004\u0005\u0006\u0007\b\t\n\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\t\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent;", "Lcom/yoti/mobile/android/commons/navigation/NavigationEvent;", "()V", "AbstractDocumentNavigationEvent", "CancelFlow", "NavigateBack", "NavigateToAdditionalInstructions", "NavigateToCameraPermissionDenied", "NavigateToDoNotHaveDocumentsDialog", "NavigateToMoreAboutVerification", "NavigateToScan", "RequestCameraPermission", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$RequestCameraPermission;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$NavigateToCameraPermissionDenied;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$NavigateToScan;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$NavigateToAdditionalInstructions;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$NavigateToMoreAboutVerification;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$NavigateToDoNotHaveDocumentsDialog;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$CancelFlow;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$NavigateBack;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$AbstractDocumentNavigationEvent;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class DocumentNavigationEvent implements NavigationEvent {

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$AbstractDocumentNavigationEvent;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class AbstractDocumentNavigationEvent extends DocumentNavigationEvent {
        public AbstractDocumentNavigationEvent() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$CancelFlow;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class CancelFlow extends DocumentNavigationEvent {
        public static final CancelFlow INSTANCE = new CancelFlow();

        private CancelFlow() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$NavigateBack;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class NavigateBack extends DocumentNavigationEvent {
        public static final NavigateBack INSTANCE = new NavigateBack();

        private NavigateBack() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$NavigateToAdditionalInstructions;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent;", "fragmentArgs", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "getFragmentArgs", "()Landroid/os/Bundle;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class NavigateToAdditionalInstructions extends DocumentNavigationEvent {
        private final Bundle fragmentArgs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateToAdditionalInstructions(Bundle fragmentArgs) {
            super(null);
            Intrinsics.checkNotNullParameter(fragmentArgs, "fragmentArgs");
            this.fragmentArgs = fragmentArgs;
        }

        public static /* synthetic */ NavigateToAdditionalInstructions copy$default(NavigateToAdditionalInstructions navigateToAdditionalInstructions, Bundle bundle, int i, Object obj) {
            if ((i & 1) != 0) {
                bundle = navigateToAdditionalInstructions.fragmentArgs;
            }
            return navigateToAdditionalInstructions.copy(bundle);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Bundle getFragmentArgs() {
            return this.fragmentArgs;
        }

        public final NavigateToAdditionalInstructions copy(Bundle fragmentArgs) {
            Intrinsics.checkNotNullParameter(fragmentArgs, "fragmentArgs");
            return new NavigateToAdditionalInstructions(fragmentArgs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NavigateToAdditionalInstructions) && Intrinsics.areEqual(this.fragmentArgs, ((NavigateToAdditionalInstructions) other).fragmentArgs);
        }

        public final Bundle getFragmentArgs() {
            return this.fragmentArgs;
        }

        public int hashCode() {
            return this.fragmentArgs.hashCode();
        }

        public String toString() {
            return "NavigateToAdditionalInstructions(fragmentArgs=" + this.fragmentArgs + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$NavigateToCameraPermissionDenied;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class NavigateToCameraPermissionDenied extends DocumentNavigationEvent {
        public static final NavigateToCameraPermissionDenied INSTANCE = new NavigateToCameraPermissionDenied();

        private NavigateToCameraPermissionDenied() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$NavigateToDoNotHaveDocumentsDialog;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent;", "dialogViewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DoNotHaveDocumentsDialogViewData;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DoNotHaveDocumentsDialogViewData;)V", "getDialogViewData", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DoNotHaveDocumentsDialogViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class NavigateToDoNotHaveDocumentsDialog extends DocumentNavigationEvent {
        private final DoNotHaveDocumentsDialogViewData dialogViewData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateToDoNotHaveDocumentsDialog(DoNotHaveDocumentsDialogViewData dialogViewData) {
            super(null);
            Intrinsics.checkNotNullParameter(dialogViewData, "dialogViewData");
            this.dialogViewData = dialogViewData;
        }

        public static /* synthetic */ NavigateToDoNotHaveDocumentsDialog copy$default(NavigateToDoNotHaveDocumentsDialog navigateToDoNotHaveDocumentsDialog, DoNotHaveDocumentsDialogViewData doNotHaveDocumentsDialogViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                doNotHaveDocumentsDialogViewData = navigateToDoNotHaveDocumentsDialog.dialogViewData;
            }
            return navigateToDoNotHaveDocumentsDialog.copy(doNotHaveDocumentsDialogViewData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DoNotHaveDocumentsDialogViewData getDialogViewData() {
            return this.dialogViewData;
        }

        public final NavigateToDoNotHaveDocumentsDialog copy(DoNotHaveDocumentsDialogViewData dialogViewData) {
            Intrinsics.checkNotNullParameter(dialogViewData, "dialogViewData");
            return new NavigateToDoNotHaveDocumentsDialog(dialogViewData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NavigateToDoNotHaveDocumentsDialog) && Intrinsics.areEqual(this.dialogViewData, ((NavigateToDoNotHaveDocumentsDialog) other).dialogViewData);
        }

        public final DoNotHaveDocumentsDialogViewData getDialogViewData() {
            return this.dialogViewData;
        }

        public int hashCode() {
            return this.dialogViewData.hashCode();
        }

        public String toString() {
            return "NavigateToDoNotHaveDocumentsDialog(dialogViewData=" + this.dialogViewData + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$NavigateToMoreAboutVerification;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent;", "fragmentArgs", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentArgs;", "(Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentArgs;)V", "getFragmentArgs", "()Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentArgs;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class NavigateToMoreAboutVerification extends DocumentNavigationEvent {
        private final MoreAboutFragmentArgs fragmentArgs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateToMoreAboutVerification(MoreAboutFragmentArgs fragmentArgs) {
            super(null);
            Intrinsics.checkNotNullParameter(fragmentArgs, "fragmentArgs");
            this.fragmentArgs = fragmentArgs;
        }

        public static /* synthetic */ NavigateToMoreAboutVerification copy$default(NavigateToMoreAboutVerification navigateToMoreAboutVerification, MoreAboutFragmentArgs moreAboutFragmentArgs, int i, Object obj) {
            if ((i & 1) != 0) {
                moreAboutFragmentArgs = navigateToMoreAboutVerification.fragmentArgs;
            }
            return navigateToMoreAboutVerification.copy(moreAboutFragmentArgs);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MoreAboutFragmentArgs getFragmentArgs() {
            return this.fragmentArgs;
        }

        public final NavigateToMoreAboutVerification copy(MoreAboutFragmentArgs fragmentArgs) {
            Intrinsics.checkNotNullParameter(fragmentArgs, "fragmentArgs");
            return new NavigateToMoreAboutVerification(fragmentArgs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NavigateToMoreAboutVerification) && Intrinsics.areEqual(this.fragmentArgs, ((NavigateToMoreAboutVerification) other).fragmentArgs);
        }

        public final MoreAboutFragmentArgs getFragmentArgs() {
            return this.fragmentArgs;
        }

        public int hashCode() {
            return this.fragmentArgs.hashCode();
        }

        public String toString() {
            return "NavigateToMoreAboutVerification(fragmentArgs=" + this.fragmentArgs + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$NavigateToScan;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent;", "scanConfiguration", "Lcom/yoti/mobile/android/documentcapture/view/scan/IScanConfigurationViewData;", "(Lcom/yoti/mobile/android/documentcapture/view/scan/IScanConfigurationViewData;)V", "getScanConfiguration", "()Lcom/yoti/mobile/android/documentcapture/view/scan/IScanConfigurationViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class NavigateToScan extends DocumentNavigationEvent {
        private final IScanConfigurationViewData scanConfiguration;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateToScan(IScanConfigurationViewData scanConfiguration) {
            super(null);
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            this.scanConfiguration = scanConfiguration;
        }

        public static /* synthetic */ NavigateToScan copy$default(NavigateToScan navigateToScan, IScanConfigurationViewData iScanConfigurationViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                iScanConfigurationViewData = navigateToScan.scanConfiguration;
            }
            return navigateToScan.copy(iScanConfigurationViewData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final IScanConfigurationViewData getScanConfiguration() {
            return this.scanConfiguration;
        }

        public final NavigateToScan copy(IScanConfigurationViewData scanConfiguration) {
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            return new NavigateToScan(scanConfiguration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NavigateToScan) && Intrinsics.areEqual(this.scanConfiguration, ((NavigateToScan) other).scanConfiguration);
        }

        public final IScanConfigurationViewData getScanConfiguration() {
            return this.scanConfiguration;
        }

        public int hashCode() {
            return this.scanConfiguration.hashCode();
        }

        public String toString() {
            return "NavigateToScan(scanConfiguration=" + this.scanConfiguration + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$RequestCameraPermission;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class RequestCameraPermission extends DocumentNavigationEvent {
        public static final RequestCameraPermission INSTANCE = new RequestCameraPermission();

        private RequestCameraPermission() {
            super(null);
        }
    }

    private DocumentNavigationEvent() {
    }

    public /* synthetic */ DocumentNavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
