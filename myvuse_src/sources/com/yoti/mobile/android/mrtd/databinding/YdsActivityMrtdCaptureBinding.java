package com.yoti.mobile.android.mrtd.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.mrtd.C4900R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsActivityMrtdCaptureBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private YdsActivityMrtdCaptureBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public static YdsActivityMrtdCaptureBinding bind(View view) {
        if (view != null) {
            return new YdsActivityMrtdCaptureBinding((ConstraintLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static YdsActivityMrtdCaptureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsActivityMrtdCaptureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4900R.layout.yds_activity_mrtd_capture, viewGroup, false);
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
