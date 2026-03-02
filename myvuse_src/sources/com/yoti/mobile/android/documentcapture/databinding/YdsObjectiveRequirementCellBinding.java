package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsObjectiveRequirementCellBinding implements ViewBinding {
    public final TextView objectiveRequirement;
    private final TextView rootView;

    private YdsObjectiveRequirementCellBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.objectiveRequirement = textView2;
    }

    public static YdsObjectiveRequirementCellBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new YdsObjectiveRequirementCellBinding(textView, textView);
    }

    public static YdsObjectiveRequirementCellBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsObjectiveRequirementCellBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_objective_requirement_cell, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }
}
