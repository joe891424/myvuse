package com.yoti.mobile.android.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.commonui.C4590R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentGuidelinesBinding implements ViewBinding {
    public final YotiAppbar appBar;
    public final View dragIndicator;
    public final YotiButton guidelinesButtonPrimary;
    public final RecyclerView guidelinesRecyclerView;
    public final TextView guidelinesSubtitle;
    public final TextView guidelinesTitle;
    private final ConstraintLayout rootView;
    public final NestedScrollView scrollView;
    public final View shadow;

    private YdsFragmentGuidelinesBinding(ConstraintLayout constraintLayout, YotiAppbar yotiAppbar, View view, YotiButton yotiButton, RecyclerView recyclerView, TextView textView, TextView textView2, NestedScrollView nestedScrollView, View view2) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbar;
        this.dragIndicator = view;
        this.guidelinesButtonPrimary = yotiButton;
        this.guidelinesRecyclerView = recyclerView;
        this.guidelinesSubtitle = textView;
        this.guidelinesTitle = textView2;
        this.scrollView = nestedScrollView;
        this.shadow = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static YdsFragmentGuidelinesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentGuidelinesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4590R.layout.yds_fragment_guidelines, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static YdsFragmentGuidelinesBinding bind(View view) {
        View viewFindViewById;
        View viewFindViewById2;
        int i = C4590R.id.appBar;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
        if (yotiAppbar != null && (viewFindViewById = view.findViewById((i = C4590R.id.dragIndicator))) != null) {
            i = C4590R.id.guidelinesButtonPrimary;
            YotiButton yotiButton = (YotiButton) view.findViewById(i);
            if (yotiButton != null) {
                i = C4590R.id.guidelinesRecyclerView;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
                if (recyclerView != null) {
                    i = C4590R.id.guidelinesSubtitle;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = C4590R.id.guidelinesTitle;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            i = C4590R.id.scrollView;
                            NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(i);
                            if (nestedScrollView != null && (viewFindViewById2 = view.findViewById((i = C4590R.id.shadow))) != null) {
                                return new YdsFragmentGuidelinesBinding((ConstraintLayout) view, yotiAppbar, viewFindViewById, yotiButton, recyclerView, textView, textView2, nestedScrollView, viewFindViewById2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
