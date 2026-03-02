package com.yoti.mobile.android.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.commonui.C4590R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentMoreAboutBinding implements ViewBinding {
    public final YotiButton buttonAction;
    public final RecyclerView moreAboutVerificationRecyclerView;
    private final ConstraintLayout rootView;
    public final View shadow;

    private YdsFragmentMoreAboutBinding(ConstraintLayout constraintLayout, YotiButton yotiButton, RecyclerView recyclerView, View view) {
        this.rootView = constraintLayout;
        this.buttonAction = yotiButton;
        this.moreAboutVerificationRecyclerView = recyclerView;
        this.shadow = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static YdsFragmentMoreAboutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentMoreAboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4590R.layout.yds_fragment_more_about, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static YdsFragmentMoreAboutBinding bind(View view) {
        View viewFindViewById;
        int i = C4590R.id.buttonAction;
        YotiButton yotiButton = (YotiButton) view.findViewById(i);
        if (yotiButton != null) {
            i = C4590R.id.moreAboutVerificationRecyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
            if (recyclerView != null && (viewFindViewById = view.findViewById((i = C4590R.id.shadow))) != null) {
                return new YdsFragmentMoreAboutBinding((ConstraintLayout) view, yotiButton, recyclerView, viewFindViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
