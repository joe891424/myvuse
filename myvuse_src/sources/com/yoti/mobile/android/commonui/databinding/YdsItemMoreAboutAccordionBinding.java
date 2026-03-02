package com.yoti.mobile.android.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAccordion;
import com.yoti.mobile.android.commonui.C4590R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsItemMoreAboutAccordionBinding implements ViewBinding {
    public final YotiAccordion accordion;
    private final LinearLayout rootView;

    private YdsItemMoreAboutAccordionBinding(LinearLayout linearLayout, YotiAccordion yotiAccordion) {
        this.rootView = linearLayout;
        this.accordion = yotiAccordion;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static YdsItemMoreAboutAccordionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsItemMoreAboutAccordionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4590R.layout.yds_item_more_about_accordion, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static YdsItemMoreAboutAccordionBinding bind(View view) {
        int i = C4590R.id.accordion;
        YotiAccordion yotiAccordion = (YotiAccordion) view.findViewById(i);
        if (yotiAccordion != null) {
            return new YdsItemMoreAboutAccordionBinding((LinearLayout) view, yotiAccordion);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
