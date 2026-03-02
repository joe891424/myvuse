package com.reactnativenavigation.utils;

import android.graphics.drawable.Drawable;
import com.reactnativenavigation.utils.ImageLoader;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ImageLoadingListenerAdapter implements ImageLoader.ImagesLoadingListener {
    @Override // com.reactnativenavigation.utils.ImageLoader.ImagesLoadingListener
    public void onComplete(Drawable drawable) {
    }

    @Override // com.reactnativenavigation.utils.ImageLoader.ImagesLoadingListener
    public void onComplete(List<? extends Drawable> list) {
    }

    @Override // com.reactnativenavigation.utils.ImageLoader.ImagesLoadingListener
    public void onError(Throwable th) {
        th.printStackTrace();
    }
}
