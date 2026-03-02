package com.dylanvann.fastimage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.surajit.rnrg.RadialGradientManager;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
class FastImageViewConverter {
    private static final Drawable TRANSPARENT_DRAWABLE = new ColorDrawable(0);
    private static final Map<String, FastImageCacheControl> FAST_IMAGE_CACHE_CONTROL_MAP = new HashMap<String, FastImageCacheControl>() { // from class: com.dylanvann.fastimage.FastImageViewConverter.1
        {
            put("immutable", FastImageCacheControl.IMMUTABLE);
            put("web", FastImageCacheControl.WEB);
            put("cacheOnly", FastImageCacheControl.CACHE_ONLY);
        }
    };
    private static final Map<String, Priority> FAST_IMAGE_PRIORITY_MAP = new HashMap<String, Priority>() { // from class: com.dylanvann.fastimage.FastImageViewConverter.2
        {
            put("low", Priority.LOW);
            put("normal", Priority.NORMAL);
            put("high", Priority.HIGH);
        }
    };
    private static final Map<String, ImageView.ScaleType> FAST_IMAGE_RESIZE_MODE_MAP = new HashMap<String, ImageView.ScaleType>() { // from class: com.dylanvann.fastimage.FastImageViewConverter.3
        {
            put("contain", ImageView.ScaleType.FIT_CENTER);
            put("cover", ImageView.ScaleType.CENTER_CROP);
            put("stretch", ImageView.ScaleType.FIT_XY);
            put(RadialGradientManager.PROP_CENTER, ImageView.ScaleType.CENTER_INSIDE);
        }
    };

    FastImageViewConverter() {
    }

    @Nullable
    static FastImageSource getImageSource(Context context, @Nullable ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        return new FastImageSource(context, readableMap.getString("uri"), getHeaders(readableMap));
    }

    static Headers getHeaders(ReadableMap readableMap) {
        Headers headers = Headers.DEFAULT;
        if (!readableMap.hasKey("headers")) {
            return headers;
        }
        ReadableMap map = readableMap.getMap("headers");
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
        LazyHeaders.Builder builder = new LazyHeaders.Builder();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            builder.addHeader(strNextKey, map.getString(strNextKey));
        }
        return builder.build();
    }

    static RequestOptions getOptions(Context context, FastImageSource fastImageSource, ReadableMap readableMap) {
        Priority priority = getPriority(readableMap);
        FastImageCacheControl cacheControl = getCacheControl(readableMap);
        DiskCacheStrategy diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
        int i = C16734.$SwitchMap$com$dylanvann$fastimage$FastImageCacheControl[cacheControl.ordinal()];
        boolean z = true;
        boolean z2 = false;
        if (i == 1) {
            diskCacheStrategy = DiskCacheStrategy.NONE;
            z2 = true;
            z = false;
        } else if (i != 2) {
            z = false;
        }
        RequestOptions requestOptionsPlaceholder = new RequestOptions().diskCacheStrategy(diskCacheStrategy).onlyRetrieveFromCache(z).skipMemoryCache(z2).priority(priority).placeholder(TRANSPARENT_DRAWABLE);
        return fastImageSource.isResource() ? requestOptionsPlaceholder.apply(RequestOptions.signatureOf(ApplicationVersionSignature.obtain(context))) : requestOptionsPlaceholder;
    }

    /* JADX INFO: renamed from: com.dylanvann.fastimage.FastImageViewConverter$4 */
    static /* synthetic */ class C16734 {
        static final /* synthetic */ int[] $SwitchMap$com$dylanvann$fastimage$FastImageCacheControl;

        static {
            int[] iArr = new int[FastImageCacheControl.values().length];
            $SwitchMap$com$dylanvann$fastimage$FastImageCacheControl = iArr;
            try {
                iArr[FastImageCacheControl.WEB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dylanvann$fastimage$FastImageCacheControl[FastImageCacheControl.CACHE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dylanvann$fastimage$FastImageCacheControl[FastImageCacheControl.IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static FastImageCacheControl getCacheControl(ReadableMap readableMap) {
        return (FastImageCacheControl) getValueFromSource("cache", "immutable", FAST_IMAGE_CACHE_CONTROL_MAP, readableMap);
    }

    private static Priority getPriority(ReadableMap readableMap) {
        return (Priority) getValueFromSource("priority", "normal", FAST_IMAGE_PRIORITY_MAP, readableMap);
    }

    static ImageView.ScaleType getScaleType(String str) {
        return (ImageView.ScaleType) getValue("resizeMode", "cover", FAST_IMAGE_RESIZE_MODE_MAP, str);
    }

    private static <T> T getValue(String str, String str2, Map<String, T> map, String str3) {
        if (str3 != null) {
            str2 = str3;
        }
        T t = map.get(str2);
        if (t != null) {
            return t;
        }
        throw new JSApplicationIllegalArgumentException("FastImage, invalid " + str + " : " + str2);
    }

    private static <T> T getValueFromSource(String str, String str2, Map<String, T> map, ReadableMap readableMap) {
        String string = null;
        if (readableMap != null) {
            try {
                string = readableMap.getString(str);
            } catch (NoSuchKeyException unused) {
            }
        }
        return (T) getValue(str, str2, map, string);
    }
}
