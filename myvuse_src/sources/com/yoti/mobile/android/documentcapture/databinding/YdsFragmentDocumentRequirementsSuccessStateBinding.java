package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbarTransparent;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentDocumentRequirementsSuccessStateBinding implements ViewBinding {
    public final YotiAppbarTransparent appBar;
    public final YotiButton buttonRequirementsActionPrimary;
    public final YotiButton buttonRequirementsActionSecondary;
    public final YotiButton buttonSeeScanningGuidelines;
    public final RecyclerView recyclerViewRequirements;
    private final ConstraintLayout rootView;
    public final NestedScrollView scrollView;
    public final View shadowViewRequirements;
    public final TextView textViewRequirementsTitle;

    private YdsFragmentDocumentRequirementsSuccessStateBinding(ConstraintLayout constraintLayout, YotiAppbarTransparent yotiAppbarTransparent, YotiButton yotiButton, YotiButton yotiButton2, YotiButton yotiButton3, RecyclerView recyclerView, NestedScrollView nestedScrollView, View view, TextView textView) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbarTransparent;
        this.buttonRequirementsActionPrimary = yotiButton;
        this.buttonRequirementsActionSecondary = yotiButton2;
        this.buttonSeeScanningGuidelines = yotiButton3;
        this.recyclerViewRequirements = recyclerView;
        this.scrollView = nestedScrollView;
        this.shadowViewRequirements = view;
        this.textViewRequirementsTitle = textView;
    }

    public static YdsFragmentDocumentRequirementsSuccessStateBinding bind(View view) {
        View viewFindViewById;
        int i = C4597R.id.appBar;
        YotiAppbarTransparent yotiAppbarTransparent = (YotiAppbarTransparent) view.findViewById(i);
        if (yotiAppbarTransparent != null) {
            i = C4597R.id.buttonRequirementsActionPrimary;
            YotiButton yotiButton = (YotiButton) view.findViewById(i);
            if (yotiButton != null) {
                i = C4597R.id.buttonRequirementsActionSecondary;
                YotiButton yotiButton2 = (YotiButton) view.findViewById(i);
                if (yotiButton2 != null) {
                    i = C4597R.id.buttonSeeScanningGuidelines;
                    YotiButton yotiButton3 = (YotiButton) view.findViewById(i);
                    if (yotiButton3 != null) {
                        i = C4597R.id.recyclerViewRequirements;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
                        if (recyclerView != null) {
                            i = C4597R.id.scrollView;
                            NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(i);
                            if (nestedScrollView != null && (viewFindViewById = view.findViewById((i = C4597R.id.shadowViewRequirements))) != null) {
                                i = C4597R.id.textViewRequirementsTitle;
                                TextView textView = (TextView) view.findViewById(i);
                                if (textView != null) {
                                    return new YdsFragmentDocumentRequirementsSuccessStateBinding((ConstraintLayout) view, yotiAppbarTransparent, yotiButton, yotiButton2, yotiButton3, recyclerView, nestedScrollView, viewFindViewById, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentDocumentRequirementsSuccessStateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentDocumentRequirementsSuccessStateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_fragment_document_requirements_success_state, viewGroup, false);
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
