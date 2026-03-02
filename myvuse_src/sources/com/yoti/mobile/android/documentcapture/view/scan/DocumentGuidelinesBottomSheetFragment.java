package com.yoti.mobile.android.documentcapture.view.scan;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.yoti.mobile.android.commonui.GuidelinesViewData;
import com.yoti.mobile.android.commonui.NestedGuidelinesFragment;
import com.yoti.mobile.android.commonui.YotiBottomSheetDialog;
import com.yoti.mobile.android.documentcapture.C4597R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/scan/DocumentGuidelinesBottomSheetFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/yoti/mobile/android/commonui/NestedGuidelinesFragment$Listener;", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPrimaryButtonClick", "", "onViewCreated", "view", "Companion", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentGuidelinesBottomSheetFragment extends BottomSheetDialogFragment implements NestedGuidelinesFragment.Listener {
    private static final String ARG_GUIDELINES_VIEW_DATA = "ARG_GUIDELINES_VIEW_DATA";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/scan/DocumentGuidelinesBottomSheetFragment$Companion;", "", "()V", DocumentGuidelinesBottomSheetFragment.ARG_GUIDELINES_VIEW_DATA, "", "newInstance", "Lcom/yoti/mobile/android/documentcapture/view/scan/DocumentGuidelinesBottomSheetFragment;", "viewData", "Lcom/yoti/mobile/android/commonui/GuidelinesViewData;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DocumentGuidelinesBottomSheetFragment newInstance(GuidelinesViewData viewData) {
            Intrinsics.checkNotNullParameter(viewData, "viewData");
            DocumentGuidelinesBottomSheetFragment documentGuidelinesBottomSheetFragment = new DocumentGuidelinesBottomSheetFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(DocumentGuidelinesBottomSheetFragment.ARG_GUIDELINES_VIEW_DATA, viewData);
            documentGuidelinesBottomSheetFragment.setArguments(bundle);
            return documentGuidelinesBottomSheetFragment;
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return new YotiBottomSheetDialog(contextRequireContext, C4597R.style.Yds_BottomSheetDialogTheme, null, 4, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(C4597R.layout.yds_fragment_document_guidelines_bottom_sheet, container, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflater.inflate(\n      …,\n            false\n    )");
        return viewInflate;
    }

    @Override // com.yoti.mobile.android.commonui.NestedGuidelinesFragment.Listener
    public boolean onNavigateBack() {
        return NestedGuidelinesFragment.Listener.DefaultImpls.onNavigateBack(this);
    }

    @Override // com.yoti.mobile.android.commonui.NestedGuidelinesFragment.Listener
    public void onPrimaryButtonClick() {
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Parcelable parcelable = requireArguments().getParcelable(ARG_GUIDELINES_VIEW_DATA);
        if (parcelable == null) {
            throw new IllegalArgumentException(("Fragment " + this + " does not have the required arguments.").toString());
        }
        GuidelinesViewData viewData = (GuidelinesViewData) parcelable;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.checkExpressionValueIsNotNull(fragmentTransactionBeginTransaction, "beginTransaction()");
        int i = C4597R.id.documentGuidelinesFragment;
        NestedGuidelinesFragment.Companion companion = NestedGuidelinesFragment.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(viewData, "viewData");
        fragmentTransactionBeginTransaction.replace(i, companion.newInstance(viewData));
        fragmentTransactionBeginTransaction.commit();
    }
}
