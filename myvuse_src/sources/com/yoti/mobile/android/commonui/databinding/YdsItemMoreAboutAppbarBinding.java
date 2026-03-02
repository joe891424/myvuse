package com.yoti.mobile.android.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.commonui.C4590R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsItemMoreAboutAppbarBinding implements ViewBinding {
    public final YotiAppbar appBar;
    private final YotiAppbar rootView;

    private YdsItemMoreAboutAppbarBinding(YotiAppbar yotiAppbar, YotiAppbar yotiAppbar2) {
        this.rootView = yotiAppbar;
        this.appBar = yotiAppbar2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public YotiAppbar getRoot() {
        return this.rootView;
    }

    public static YdsItemMoreAboutAppbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsItemMoreAboutAppbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4590R.layout.yds_item_more_about_appbar, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static YdsItemMoreAboutAppbarBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        YotiAppbar yotiAppbar = (YotiAppbar) view;
        return new YdsItemMoreAboutAppbarBinding(yotiAppbar, yotiAppbar);
    }
}
