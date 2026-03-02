package com.salesforce.marketingcloud.media;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.g */
/* JADX INFO: loaded from: classes6.dex */
public class ViewTreeObserverOnPreDrawListenerC4209g implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a */
    final WeakReference<ImageView> f5036a;

    /* JADX INFO: renamed from: b */
    private final C4222t f5037b;

    /* JADX INFO: renamed from: c */
    InterfaceC4208f f5038c;

    public ViewTreeObserverOnPreDrawListenerC4209g(C4222t c4222t, ImageView imageView, InterfaceC4208f interfaceC4208f) {
        this.f5037b = c4222t;
        this.f5036a = new WeakReference<>(imageView);
        this.f5038c = interfaceC4208f;
        imageView.addOnAttachStateChangeListener(this);
        if (imageView.getWindowToken() != null) {
            imageView.getViewTreeObserver().addOnPreDrawListener(this);
        }
    }

    /* JADX INFO: renamed from: a */
    void m3524a() {
        this.f5038c = null;
        ImageView imageView = this.f5036a.get();
        if (imageView == null) {
            return;
        }
        this.f5036a.clear();
        imageView.removeOnAttachStateChangeListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        ImageView imageView = this.f5036a.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            imageView.removeOnAttachStateChangeListener(this);
            viewTreeObserver.removeOnPreDrawListener(this);
            this.f5036a.clear();
            this.f5037b.m3605a(width, height).m3609a(imageView, this.f5038c);
        }
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }
}
