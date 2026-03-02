package com.reactnativenavigation.views.stack.fab;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import com.github.clans.fab.FloatingActionButton;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.utils.ImageLoader;
import com.reactnativenavigation.utils.ImageLoadingListenerAdapter;
import com.reactnativenavigation.viewcontrollers.stack.FabAnimator;
import com.reactnativenavigation.viewcontrollers.stack.FabCollapseBehaviour;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Fab extends FloatingActionButton implements FabAnimator {
    private FabCollapseBehaviour collapseBehaviour;

    /* JADX INFO: renamed from: id */
    private String f4213id;

    public Fab(Context context, String str) {
        super(context);
        this.f4213id = "";
        this.collapseBehaviour = new FabCollapseBehaviour(this);
        this.f4213id = str;
    }

    public void applyIcon(String str, final ThemeColour themeColour) {
        new ImageLoader().loadIcons(getContext(), Collections.singletonList(str), new ImageLoadingListenerAdapter() { // from class: com.reactnativenavigation.views.stack.fab.Fab.1
            @Override // com.reactnativenavigation.utils.ImageLoadingListenerAdapter, com.reactnativenavigation.utils.ImageLoader.ImagesLoadingListener
            public void onComplete(List<? extends Drawable> list) {
                if (themeColour.hasValue()) {
                    list.get(0).setColorFilter(new PorterDuffColorFilter(themeColour.get(), PorterDuff.Mode.SRC_IN));
                }
                Fab.this.setImageDrawable(list.get(0));
            }

            @Override // com.reactnativenavigation.utils.ImageLoadingListenerAdapter, com.reactnativenavigation.utils.ImageLoader.ImagesLoadingListener
            public void onError(Throwable th) {
                th.printStackTrace();
            }
        });
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f4213id.equals(((Fab) obj).f4213id);
    }

    public int hashCode() {
        return this.f4213id.hashCode();
    }

    @Override // com.reactnativenavigation.viewcontrollers.stack.FabAnimator
    public void show() {
        show(true);
    }

    @Override // com.reactnativenavigation.viewcontrollers.stack.FabAnimator
    public void hide() {
        hide(true);
    }

    public void enableCollapse(ScrollEventListener scrollEventListener) {
        this.collapseBehaviour.enableCollapse(scrollEventListener);
    }

    public void disableCollapse() {
        this.collapseBehaviour.disableCollapse();
    }

    public String getFabId() {
        return this.f4213id;
    }
}
