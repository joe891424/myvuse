package com.reactnativenavigation.viewcontrollers.stack.topbar.button;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.reactnativenavigation.options.ButtonOptions;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ImageLoader;
import com.reactnativenavigation.utils.ImageLoadingListenerAdapter;
import com.reactnativenavigation.utils.LogKt;

/* JADX INFO: loaded from: classes6.dex */
public class IconResolver {
    private Activity context;
    private ImageLoader imageLoader;

    public IconResolver(Activity activity, ImageLoader imageLoader) {
        this.context = activity;
        this.imageLoader = imageLoader;
    }

    public void resolve(ButtonOptions buttonOptions, final Functions.Func1<Drawable> func1) {
        if (buttonOptions.hasIcon()) {
            this.imageLoader.loadIcon(this.context, buttonOptions.icon.get(), new ImageLoadingListenerAdapter() { // from class: com.reactnativenavigation.viewcontrollers.stack.topbar.button.IconResolver.1
                @Override // com.reactnativenavigation.utils.ImageLoadingListenerAdapter, com.reactnativenavigation.utils.ImageLoader.ImagesLoadingListener
                public void onComplete(Drawable drawable) {
                    func1.run(drawable);
                }

                @Override // com.reactnativenavigation.utils.ImageLoadingListenerAdapter, com.reactnativenavigation.utils.ImageLoader.ImagesLoadingListener
                public void onError(Throwable th) {
                    throw new RuntimeException(th);
                }
            });
        } else if (buttonOptions.isBackButton()) {
            func1.run(this.imageLoader.getBackButtonIcon(this.context));
        } else {
            LogInstrumentation.m2734w(LogKt.MAIN_LIB_TAG, "Left button needs to have an icon");
        }
    }

    public ImageLoader getImageLoader() {
        return this.imageLoader;
    }
}
