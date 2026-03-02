package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentDocumentEducationalBinding implements ViewBinding {
    public final YotiAppbar appBar;
    public final YotiAppbar appBarLoading;
    public final YotiButton buttonDoNotHave;
    public final View buttonDoNotHaveLoading;
    public final YotiButton buttonStartScan;
    public final View buttonStartScanLoading;
    public final YdsFragmentDocumentEducationalLoadingStateBinding loadingView;
    public final Group loadingViewGroup;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final View shadow;
    public final YdsFragmentDocumentEducationalSuccessStateBinding successView;
    public final Group successViewGroup;

    private YdsFragmentDocumentEducationalBinding(ConstraintLayout constraintLayout, YotiAppbar yotiAppbar, YotiAppbar yotiAppbar2, YotiButton yotiButton, View view, YotiButton yotiButton2, View view2, YdsFragmentDocumentEducationalLoadingStateBinding ydsFragmentDocumentEducationalLoadingStateBinding, Group group, ScrollView scrollView, View view3, YdsFragmentDocumentEducationalSuccessStateBinding ydsFragmentDocumentEducationalSuccessStateBinding, Group group2) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbar;
        this.appBarLoading = yotiAppbar2;
        this.buttonDoNotHave = yotiButton;
        this.buttonDoNotHaveLoading = view;
        this.buttonStartScan = yotiButton2;
        this.buttonStartScanLoading = view2;
        this.loadingView = ydsFragmentDocumentEducationalLoadingStateBinding;
        this.loadingViewGroup = group;
        this.scrollView = scrollView;
        this.shadow = view3;
        this.successView = ydsFragmentDocumentEducationalSuccessStateBinding;
        this.successViewGroup = group2;
    }

    public static YdsFragmentDocumentEducationalBinding bind(View view) {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        View viewFindViewById4;
        View viewFindViewById5;
        int i = C4597R.id.appBar;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
        if (yotiAppbar != null) {
            i = C4597R.id.appBarLoading;
            YotiAppbar yotiAppbar2 = (YotiAppbar) view.findViewById(i);
            if (yotiAppbar2 != null) {
                i = C4597R.id.buttonDoNotHave;
                YotiButton yotiButton = (YotiButton) view.findViewById(i);
                if (yotiButton != null && (viewFindViewById = view.findViewById((i = C4597R.id.buttonDoNotHaveLoading))) != null) {
                    i = C4597R.id.buttonStartScan;
                    YotiButton yotiButton2 = (YotiButton) view.findViewById(i);
                    if (yotiButton2 != null && (viewFindViewById2 = view.findViewById((i = C4597R.id.buttonStartScanLoading))) != null && (viewFindViewById3 = view.findViewById((i = C4597R.id.loadingView))) != null) {
                        YdsFragmentDocumentEducationalLoadingStateBinding ydsFragmentDocumentEducationalLoadingStateBindingBind = YdsFragmentDocumentEducationalLoadingStateBinding.bind(viewFindViewById3);
                        i = C4597R.id.loadingViewGroup;
                        Group group = (Group) view.findViewById(i);
                        if (group != null) {
                            i = C4597R.id.scrollView;
                            ScrollView scrollView = (ScrollView) view.findViewById(i);
                            if (scrollView != null && (viewFindViewById4 = view.findViewById((i = C4597R.id.shadow))) != null && (viewFindViewById5 = view.findViewById((i = C4597R.id.successView))) != null) {
                                YdsFragmentDocumentEducationalSuccessStateBinding ydsFragmentDocumentEducationalSuccessStateBindingBind = YdsFragmentDocumentEducationalSuccessStateBinding.bind(viewFindViewById5);
                                i = C4597R.id.successViewGroup;
                                Group group2 = (Group) view.findViewById(i);
                                if (group2 != null) {
                                    return new YdsFragmentDocumentEducationalBinding((ConstraintLayout) view, yotiAppbar, yotiAppbar2, yotiButton, viewFindViewById, yotiButton2, viewFindViewById2, ydsFragmentDocumentEducationalLoadingStateBindingBind, group, scrollView, viewFindViewById4, ydsFragmentDocumentEducationalSuccessStateBindingBind, group2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentDocumentEducationalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentDocumentEducationalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_fragment_document_educational, viewGroup, false);
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
