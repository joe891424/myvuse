package com.reactnativenavigation.views;

import android.content.Context;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.reactnativenavigation.views.component.Component;

/* JADX INFO: loaded from: classes6.dex */
public class ExternalComponentLayout extends CoordinatorLayout implements Component {
    public ExternalComponentLayout(Context context) {
        super(context);
    }

    @Override // com.reactnativenavigation.views.component.Renderable
    public boolean isRendered() {
        return getChildCount() >= 1;
    }
}
