package com.dylanvann.fastimage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PorterDuff;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
class FastImageViewManager extends SimpleViewManager<FastImageViewWithUrl> implements FastImageProgressListener {
    static final String REACT_CLASS = "FastImageView";
    static final String REACT_ON_LOAD_START_EVENT = "onFastImageLoadStart";
    static final String REACT_ON_PROGRESS_EVENT = "onFastImageProgress";
    private static final Map<String, List<FastImageViewWithUrl>> VIEWS_FOR_URLS = new WeakHashMap();

    @Nullable
    private RequestManager requestManager = null;

    @Override // com.dylanvann.fastimage.FastImageProgressListener
    public float getGranularityPercentage() {
        return 0.5f;
    }

    FastImageViewManager() {
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public FastImageViewWithUrl createViewInstance(ThemedReactContext themedReactContext) {
        if (isValidContextForGlide(themedReactContext)) {
            this.requestManager = Glide.with(themedReactContext);
        }
        return new FastImageViewWithUrl(themedReactContext);
    }

    @ReactProp(name = "source")
    public void setSource(FastImageViewWithUrl fastImageViewWithUrl, @Nullable ReadableMap readableMap) {
        fastImageViewWithUrl.setSource(readableMap);
    }

    @ReactProp(name = "defaultSource")
    public void setDefaultSource(FastImageViewWithUrl fastImageViewWithUrl, @Nullable String str) {
        fastImageViewWithUrl.setDefaultSource(ResourceDrawableIdHelper.getInstance().getResourceDrawable(fastImageViewWithUrl.getContext(), str));
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public void setTintColor(FastImageViewWithUrl fastImageViewWithUrl, @Nullable Integer num) {
        if (num == null) {
            fastImageViewWithUrl.clearColorFilter();
        } else {
            fastImageViewWithUrl.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(FastImageViewWithUrl fastImageViewWithUrl, String str) {
        fastImageViewWithUrl.setScaleType(FastImageViewConverter.getScaleType(str));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(FastImageViewWithUrl fastImageViewWithUrl) {
        fastImageViewWithUrl.clearView(this.requestManager);
        if (fastImageViewWithUrl.glideUrl != null) {
            String string = fastImageViewWithUrl.glideUrl.toString();
            FastImageOkHttpProgressGlideModule.forget(string);
            Map<String, List<FastImageViewWithUrl>> map = VIEWS_FOR_URLS;
            List<FastImageViewWithUrl> list = map.get(string);
            if (list != null) {
                list.remove(fastImageViewWithUrl);
                if (list.size() == 0) {
                    map.remove(string);
                }
            }
        }
        super.onDropViewInstance(fastImageViewWithUrl);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put(REACT_ON_LOAD_START_EVENT, MapBuilder.m1349of("registrationName", REACT_ON_LOAD_START_EVENT)).put(REACT_ON_PROGRESS_EVENT, MapBuilder.m1349of("registrationName", REACT_ON_PROGRESS_EVENT)).put("onFastImageLoad", MapBuilder.m1349of("registrationName", "onFastImageLoad")).put("onFastImageError", MapBuilder.m1349of("registrationName", "onFastImageError")).put("onFastImageLoadEnd", MapBuilder.m1349of("registrationName", "onFastImageLoadEnd")).build();
    }

    @Override // com.dylanvann.fastimage.FastImageProgressListener
    public void onProgress(String str, long j, long j2) {
        List<FastImageViewWithUrl> list = VIEWS_FOR_URLS.get(str);
        if (list != null) {
            for (FastImageViewWithUrl fastImageViewWithUrl : list) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putInt("loaded", (int) j);
                writableNativeMap.putInt("total", (int) j2);
                ((RCTEventEmitter) ((ThemedReactContext) fastImageViewWithUrl.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(fastImageViewWithUrl.getId(), REACT_ON_PROGRESS_EVENT, writableNativeMap);
            }
        }
    }

    private static boolean isValidContextForGlide(Context context) {
        if (getActivityFromContext(context) == null) {
            return false;
        }
        return !isActivityDestroyed(r0);
    }

    private static Activity getActivityFromContext(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ThemedReactContext)) {
            return null;
        }
        Context baseContext = ((ThemedReactContext) context).getBaseContext();
        if (baseContext instanceof Activity) {
            return (Activity) baseContext;
        }
        if (!(baseContext instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext2 = ((ContextWrapper) baseContext).getBaseContext();
        if (baseContext2 instanceof Activity) {
            return (Activity) baseContext2;
        }
        return null;
    }

    private static boolean isActivityDestroyed(Activity activity) {
        return activity.isDestroyed() || activity.isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(FastImageViewWithUrl fastImageViewWithUrl) {
        super.onAfterUpdateTransaction(fastImageViewWithUrl);
        fastImageViewWithUrl.onAfterUpdate(this, this.requestManager, VIEWS_FOR_URLS);
    }
}
