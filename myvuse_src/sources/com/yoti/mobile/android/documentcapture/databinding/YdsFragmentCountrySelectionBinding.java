package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentCountrySelectionBinding implements ViewBinding {
    public final YotiAppbar appBar;
    public final FrameLayout countryPickerContainer;
    private final LinearLayout rootView;

    private YdsFragmentCountrySelectionBinding(LinearLayout linearLayout, YotiAppbar yotiAppbar, FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.appBar = yotiAppbar;
        this.countryPickerContainer = frameLayout;
    }

    public static YdsFragmentCountrySelectionBinding bind(View view) {
        int i = C4597R.id.appBar;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
        if (yotiAppbar != null) {
            i = C4597R.id.countryPickerContainer;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
            if (frameLayout != null) {
                return new YdsFragmentCountrySelectionBinding((LinearLayout) view, yotiAppbar, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentCountrySelectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentCountrySelectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_fragment_country_selection, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
