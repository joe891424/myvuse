package com.yoti.mobile.android.documentcapture.view.additional_instructions;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.commons.navigation.NavigationCoordinatorHost;
import com.yoti.mobile.android.commons.navigation.NavigationUtilsKt;
import com.yoti.mobile.android.commons.navigation.NavigationViewModel;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.GenericMessageFragment;
import com.yoti.mobile.android.commonui.GenericMessageFragmentArgs;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.HideButtonProgressWithDelayKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreSession;
import com.yoti.mobile.android.documentcapture.view.DocumentFailureTypeToErrorTagMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorTag;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorTagToViewEventMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentSideEffect;
import com.yoti.mobile.android.documentcapture.view.DocumentViewEvent;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewEvent;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewState;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.navigation.AdditionalInstructionsCoordinator;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentRequirementViewData;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0002>?B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\"H\u0016J\u0010\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\"2\u0006\u0010-\u001a\u00020.H\u0016J+\u00100\u001a\u00020\"2\u0006\u00101\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020.042\u0006\u00105\u001a\u000206H\u0016¢\u0006\u0002\u00107J\b\u00108\u001a\u00020\"H\u0016J\u001a\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006@"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsFragment;", "Lcom/yoti/mobile/android/commonui/GenericMessageFragment;", "Lcom/yoti/mobile/android/commons/navigation/NavigationCoordinatorHost;", "()V", "coordinator", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/navigation/AdditionalInstructionsCoordinator;", "getCoordinator", "()Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/navigation/AdditionalInstructionsCoordinator;", "setCoordinator", "(Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/navigation/AdditionalInstructionsCoordinator;)V", "errorTagToViewEventMapper", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTagToViewEventMapper;", "getErrorTagToViewEventMapper", "()Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTagToViewEventMapper;", "setErrorTagToViewEventMapper", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTagToViewEventMapper;)V", "failureTypeToErrorTagMapper", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFailureTypeToErrorTagMapper;", "getFailureTypeToErrorTagMapper", "()Lcom/yoti/mobile/android/documentcapture/view/DocumentFailureTypeToErrorTagMapper;", "setFailureTypeToErrorTagMapper", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentFailureTypeToErrorTagMapper;)V", "isCameraPermissionNeeded", "", "()Z", "viewModel", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsViewModel;", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;)V", "handleSideEffect", "", "sideEffect", "Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect;", "handleViewState", "viewState", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsViewState;", "onActionButtonClicked", "onAttach", "context", "Landroid/content/Context;", "onNegativeButtonClick", "dialogTag", "", "onPositiveButtonClick", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSecondaryActionButtonClicked", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "AdditionalInstructionsCustomArgs", "FragmentArgsFactory", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AdditionalInstructionsFragment extends GenericMessageFragment implements NavigationCoordinatorHost {

    @Inject
    public AdditionalInstructionsCoordinator coordinator;

    @Inject
    public DocumentFeatureErrorTagToViewEventMapper errorTagToViewEventMapper;

    @Inject
    public DocumentFailureTypeToErrorTagMapper failureTypeToErrorTagMapper;
    private AdditionalInstructionsViewModel viewModel;

    @Inject
    public ViewModelFactory viewModelFactory;

    @Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsFragment$AdditionalInstructionsCustomArgs;", "Lcom/yoti/mobile/android/commonui/GenericMessageFragment$IGenericMessageCustomArgs;", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "countryIso3Code", "", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;Ljava/lang/String;)V", "getCountryIso3Code", "()Ljava/lang/String;", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class AdditionalInstructionsCustomArgs implements GenericMessageFragment.IGenericMessageCustomArgs {
        public static final Parcelable.Creator<AdditionalInstructionsCustomArgs> CREATOR = new Creator();
        private final String countryIso3Code;
        private final DocumentTypeViewData documentType;

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<AdditionalInstructionsCustomArgs> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AdditionalInstructionsCustomArgs createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AdditionalInstructionsCustomArgs((DocumentTypeViewData) parcel.readParcelable(AdditionalInstructionsCustomArgs.class.getClassLoader()), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AdditionalInstructionsCustomArgs[] newArray(int i) {
                return new AdditionalInstructionsCustomArgs[i];
            }
        }

        public AdditionalInstructionsCustomArgs(DocumentTypeViewData documentType, String countryIso3Code) {
            Intrinsics.checkNotNullParameter(documentType, "documentType");
            Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
            this.documentType = documentType;
            this.countryIso3Code = countryIso3Code;
        }

        public static /* synthetic */ AdditionalInstructionsCustomArgs copy$default(AdditionalInstructionsCustomArgs additionalInstructionsCustomArgs, DocumentTypeViewData documentTypeViewData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                documentTypeViewData = additionalInstructionsCustomArgs.documentType;
            }
            if ((i & 2) != 0) {
                str = additionalInstructionsCustomArgs.countryIso3Code;
            }
            return additionalInstructionsCustomArgs.copy(documentTypeViewData, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DocumentTypeViewData getDocumentType() {
            return this.documentType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCountryIso3Code() {
            return this.countryIso3Code;
        }

        public final AdditionalInstructionsCustomArgs copy(DocumentTypeViewData documentType, String countryIso3Code) {
            Intrinsics.checkNotNullParameter(documentType, "documentType");
            Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
            return new AdditionalInstructionsCustomArgs(documentType, countryIso3Code);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdditionalInstructionsCustomArgs)) {
                return false;
            }
            AdditionalInstructionsCustomArgs additionalInstructionsCustomArgs = (AdditionalInstructionsCustomArgs) other;
            return this.documentType == additionalInstructionsCustomArgs.documentType && Intrinsics.areEqual(this.countryIso3Code, additionalInstructionsCustomArgs.countryIso3Code);
        }

        public final String getCountryIso3Code() {
            return this.countryIso3Code;
        }

        public final DocumentTypeViewData getDocumentType() {
            return this.documentType;
        }

        public int hashCode() {
            return (this.documentType.hashCode() * 31) + this.countryIso3Code.hashCode();
        }

        public String toString() {
            return "AdditionalInstructionsCustomArgs(documentType=" + this.documentType + ", countryIso3Code=" + this.countryIso3Code + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.documentType, flags);
            parcel.writeString(this.countryIso3Code);
        }
    }

    @Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ6\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0015\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsFragment$FragmentArgsFactory;", "", "context", "Landroid/content/Context;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "(Landroid/content/Context;Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;)V", "create", "Landroid/os/Bundle;", "dateFrom", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementViewData$DateFromViewData;", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "countryIso3Code", "", "createArgs", "customArgs", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsFragment$AdditionalInstructionsCustomArgs;", "content", "", "secondaryButtonText", "secondaryButtonIcon", "createArgsForNonSelectableDocumentFlow", "createArgsForSelectableDocumentFlow", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class FragmentArgsFactory {
        private final Context context;
        private final DocumentCaptureConfiguration featureConfiguration;

        @Inject
        public FragmentArgsFactory(Context context, DocumentCaptureConfiguration featureConfiguration) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
            this.context = context;
            this.featureConfiguration = featureConfiguration;
        }

        private final Bundle createArgs(DocumentRequirementViewData.DateFromViewData dateFrom, AdditionalInstructionsCustomArgs customArgs, int content, int secondaryButtonText, int secondaryButtonIcon) {
            return new GenericMessageFragmentArgs(C4597R.drawable.yds_ic_check_document_issue_date, C4597R.string.yds_document_issue_date_header, null, 0, new CompoundTextResource(content, CollectionsKt.listOf(dateFrom.getDate()), null, null, 12, null).getValue(this.context).toString(), C4597R.string.android_yds_document_validation_start_scan, null, C4597R.drawable.chevron_right_white, secondaryButtonText, null, secondaryButtonIcon, customArgs, 588, null).toBundle();
        }

        private final Bundle createArgsForNonSelectableDocumentFlow(DocumentRequirementViewData.DateFromViewData dateFrom, AdditionalInstructionsCustomArgs customArgs) {
            return createArgs(dateFrom, customArgs, C4597R.string.yds_document_issue_date_single_document_description, C4597R.string.yds_common_exit, C4597R.drawable.ico_chevron_right);
        }

        private final Bundle createArgsForSelectableDocumentFlow(DocumentRequirementViewData.DateFromViewData dateFrom, AdditionalInstructionsCustomArgs customArgs) {
            return createArgs(dateFrom, customArgs, C4597R.string.yds_document_issue_date_multiple_document_description, C4597R.string.yds_common_change_document, C4597R.drawable.yds_ic_document);
        }

        public final Bundle create(DocumentRequirementViewData.DateFromViewData dateFrom, DocumentTypeViewData documentType, String countryIso3Code) {
            Intrinsics.checkNotNullParameter(dateFrom, "dateFrom");
            Intrinsics.checkNotNullParameter(documentType, "documentType");
            Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
            AdditionalInstructionsCustomArgs additionalInstructionsCustomArgs = new AdditionalInstructionsCustomArgs(documentType, countryIso3Code);
            return this.featureConfiguration.getIsSelectableDocumentFlow() ? createArgsForSelectableDocumentFlow(dateFrom, additionalInstructionsCustomArgs) : createArgsForNonSelectableDocumentFlow(dateFrom, additionalInstructionsCustomArgs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSideEffect(DocumentSideEffect sideEffect) {
        YotiButton yotiButton = getBinding().buttonAction;
        if (Intrinsics.areEqual(sideEffect, DocumentSideEffect.ShowCtaLoading.INSTANCE)) {
            yotiButton.setEnabled(false);
            yotiButton.showProgress();
        } else if (Intrinsics.areEqual(sideEffect, DocumentSideEffect.HideCtaLoading.INSTANCE)) {
            yotiButton.setEnabled(true);
            Intrinsics.checkNotNullExpressionValue(yotiButton, "");
            HideButtonProgressWithDelayKt.hideProgressWithDelay(yotiButton);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleViewState(AdditionalInstructionsViewState viewState) {
        if (!(viewState instanceof AdditionalInstructionsViewState.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        AdditionalInstructionsViewState.Error error = (AdditionalInstructionsViewState.Error) viewState;
        showFailure(error.getFailure(), getFailureTypeToErrorTagMapper().map(error.getFailure().getFailureType()).name());
    }

    private final boolean isCameraPermissionNeeded() {
        return getCoordinator().isCameraPermissionRequired() && !FragmentKt.isCameraPermissionGranted(this);
    }

    public final DocumentFeatureErrorTagToViewEventMapper getErrorTagToViewEventMapper() {
        DocumentFeatureErrorTagToViewEventMapper documentFeatureErrorTagToViewEventMapper = this.errorTagToViewEventMapper;
        if (documentFeatureErrorTagToViewEventMapper != null) {
            return documentFeatureErrorTagToViewEventMapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("errorTagToViewEventMapper");
        return null;
    }

    public final DocumentFailureTypeToErrorTagMapper getFailureTypeToErrorTagMapper() {
        DocumentFailureTypeToErrorTagMapper documentFailureTypeToErrorTagMapper = this.failureTypeToErrorTagMapper;
        if (documentFailureTypeToErrorTagMapper != null) {
            return documentFailureTypeToErrorTagMapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("failureTypeToErrorTagMapper");
        return null;
    }

    public final ViewModelFactory getViewModelFactory() {
        ViewModelFactory viewModelFactory = this.viewModelFactory;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment
    public void onActionButtonClicked() {
        AdditionalInstructionsViewModel additionalInstructionsViewModel = this.viewModel;
        if (additionalInstructionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            additionalInstructionsViewModel = null;
        }
        additionalInstructionsViewModel.handleViewEvent(new DocumentViewEvent.StartScan(isCameraPermissionNeeded()));
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DocumentCaptureCoreSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onNegativeButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        AdditionalInstructionsViewModel additionalInstructionsViewModel = this.viewModel;
        if (additionalInstructionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            additionalInstructionsViewModel = null;
        }
        additionalInstructionsViewModel.handleViewEvent(getErrorTagToViewEventMapper().map(new DocumentFeatureErrorTagToViewEventMapper.MapperParams(DocumentFeatureErrorTag.valueOf(dialogTag), false, isCameraPermissionNeeded())));
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onPositiveButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        AdditionalInstructionsViewModel additionalInstructionsViewModel = this.viewModel;
        if (additionalInstructionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            additionalInstructionsViewModel = null;
        }
        additionalInstructionsViewModel.handleViewEvent(getErrorTagToViewEventMapper().map(new DocumentFeatureErrorTagToViewEventMapper.MapperParams(DocumentFeatureErrorTag.valueOf(dialogTag), true, isCameraPermissionNeeded())));
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == 1) {
            DocumentViewEvent cameraPermissionsDenied = ((grantResults.length == 0) || grantResults[0] != 0) ? new DocumentViewEvent.CameraPermissionsDenied(shouldShowRequestPermissionRationale("android.permission.CAMERA")) : DocumentViewEvent.CameraPermissionGranted.INSTANCE;
            AdditionalInstructionsViewModel additionalInstructionsViewModel = this.viewModel;
            if (additionalInstructionsViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                additionalInstructionsViewModel = null;
            }
            additionalInstructionsViewModel.handleViewEvent(cameraPermissionsDenied);
        }
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment
    public void onSecondaryActionButtonClicked() {
        AdditionalInstructionsViewModel additionalInstructionsViewModel = this.viewModel;
        if (additionalInstructionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            additionalInstructionsViewModel = null;
        }
        additionalInstructionsViewModel.handleViewEvent(AdditionalInstructionsViewEvent.OnBackOrExit.INSTANCE);
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment, com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        YotiAppbar yotiAppbar = getBinding().appBar;
        Intrinsics.checkNotNullExpressionValue(yotiAppbar, "binding.appBar");
        BaseFragment.configureAppBar$default(this, yotiAppbar, NavigationIcon.BACK_BLUE, false, 0, 0, 0, 60, null);
        getCoordinator().bind(this, 0);
        AdditionalInstructionsViewModel additionalInstructionsViewModel = (AdditionalInstructionsViewModel) new ViewModelProvider(this, getViewModelFactory()).get(AdditionalInstructionsViewModel.class);
        GenericMessageFragment.IGenericMessageCustomArgs customArgs = getNavArguments().getCustomArgs();
        if (customArgs == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment.AdditionalInstructionsCustomArgs");
        }
        AdditionalInstructionsCustomArgs additionalInstructionsCustomArgs = (AdditionalInstructionsCustomArgs) customArgs;
        additionalInstructionsViewModel.init(additionalInstructionsCustomArgs.getDocumentType(), additionalInstructionsCustomArgs.getCountryIso3Code());
        NavigationUtilsKt.bindNavigationViewModel((Fragment) this, (NavigationViewModel) additionalInstructionsViewModel);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AdditionalInstructionsFragment$onViewCreated$1$2(this, additionalInstructionsViewModel, null), 3, null);
        this.viewModel = additionalInstructionsViewModel;
    }

    public void setCoordinator(AdditionalInstructionsCoordinator additionalInstructionsCoordinator) {
        Intrinsics.checkNotNullParameter(additionalInstructionsCoordinator, "<set-?>");
        this.coordinator = additionalInstructionsCoordinator;
    }

    public final void setErrorTagToViewEventMapper(DocumentFeatureErrorTagToViewEventMapper documentFeatureErrorTagToViewEventMapper) {
        Intrinsics.checkNotNullParameter(documentFeatureErrorTagToViewEventMapper, "<set-?>");
        this.errorTagToViewEventMapper = documentFeatureErrorTagToViewEventMapper;
    }

    public final void setFailureTypeToErrorTagMapper(DocumentFailureTypeToErrorTagMapper documentFailureTypeToErrorTagMapper) {
        Intrinsics.checkNotNullParameter(documentFailureTypeToErrorTagMapper, "<set-?>");
        this.failureTypeToErrorTagMapper = documentFailureTypeToErrorTagMapper;
    }

    public final void setViewModelFactory(ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "<set-?>");
        this.viewModelFactory = viewModelFactory;
    }

    @Override // com.yoti.mobile.android.commons.navigation.NavigationCoordinatorHost
    public AdditionalInstructionsCoordinator getCoordinator() {
        AdditionalInstructionsCoordinator additionalInstructionsCoordinator = this.coordinator;
        if (additionalInstructionsCoordinator != null) {
            return additionalInstructionsCoordinator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coordinator");
        return null;
    }
}
