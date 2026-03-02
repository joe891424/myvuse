package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.ImageDecoderResourceDecoder;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.io.IOException;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

/* JADX INFO: loaded from: classes3.dex */
public final class BitmapImageDecoderResourceDecoder extends ImageDecoderResourceDecoder<Bitmap> {
    private static final String TAG = "BitmapImageDecoder";
    private final BitmapPool bitmapPool = new BitmapPoolAdapter();

    @Override // com.bumptech.glide.load.resource.ImageDecoderResourceDecoder
    protected Resource<Bitmap> decode(ImageDecoder.Source source, int i, int i2, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable(TAG, 2)) {
            LogInstrumentation.m2732v(TAG, "Decoded [" + bitmapDecodeBitmap.getWidth() + EllipticCurveJsonWebKey.X_MEMBER_NAME + bitmapDecodeBitmap.getHeight() + "] for [" + i + EllipticCurveJsonWebKey.X_MEMBER_NAME + i2 + "]");
        }
        return new BitmapResource(bitmapDecodeBitmap, this.bitmapPool);
    }
}
