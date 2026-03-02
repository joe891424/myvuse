package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentDocumentSelectionSuccessStateBinding implements ViewBinding {
    public final YotiButton buttonChangeCountryLink;
    public final YotiButton buttonContinueCountryNotListed;
    public final YotiButton buttonMoreAboutVerification;
    public final YdsIdentityCheckBubbleBinding identityCheckLayout;
    public final RecyclerView recyclerViewDocuments;
    private final ConstraintLayout rootView;
    public final TextView textViewHeader;
    public final TextView textViewIssuingCountry;
    public final TextView textViewIssuingCountryTitle;

    private YdsFragmentDocumentSelectionSuccessStateBinding(ConstraintLayout constraintLayout, YotiButton yotiButton, YotiButton yotiButton2, YotiButton yotiButton3, YdsIdentityCheckBubbleBinding ydsIdentityCheckBubbleBinding, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.buttonChangeCountryLink = yotiButton;
        this.buttonContinueCountryNotListed = yotiButton2;
        this.buttonMoreAboutVerification = yotiButton3;
        this.identityCheckLayout = ydsIdentityCheckBubbleBinding;
        this.recyclerViewDocuments = recyclerView;
        this.textViewHeader = textView;
        this.textViewIssuingCountry = textView2;
        this.textViewIssuingCountryTitle = textView3;
    }

    public static YdsFragmentDocumentSelectionSuccessStateBinding bind(View view) {
        View viewFindViewById;
        int i = C4597R.id.buttonChangeCountryLink;
        YotiButton yotiButton = (YotiButton) view.findViewById(i);
        if (yotiButton != null) {
            i = C4597R.id.buttonContinueCountryNotListed;
            YotiButton yotiButton2 = (YotiButton) view.findViewById(i);
            if (yotiButton2 != null) {
                i = C4597R.id.buttonMoreAboutVerification;
                YotiButton yotiButton3 = (YotiButton) view.findViewById(i);
                if (yotiButton3 != null && (viewFindViewById = view.findViewById((i = C4597R.id.identityCheckLayout))) != null) {
                    YdsIdentityCheckBubbleBinding ydsIdentityCheckBubbleBindingBind = YdsIdentityCheckBubbleBinding.bind(viewFindViewById);
                    i = C4597R.id.recyclerViewDocuments;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
                    if (recyclerView != null) {
                        i = C4597R.id.textViewHeader;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            i = C4597R.id.textViewIssuingCountry;
                            TextView textView2 = (TextView) view.findViewById(i);
                            if (textView2 != null) {
                                i = C4597R.id.textViewIssuingCountryTitle;
                                TextView textView3 = (TextView) view.findViewById(i);
                                if (textView3 != null) {
                                    return new YdsFragmentDocumentSelectionSuccessStateBinding((ConstraintLayout) view, yotiButton, yotiButton2, yotiButton3, ydsIdentityCheckBubbleBindingBind, recyclerView, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentDocumentSelectionSuccessStateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentDocumentSelectionSuccessStateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_fragment_document_selection_success_state, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
