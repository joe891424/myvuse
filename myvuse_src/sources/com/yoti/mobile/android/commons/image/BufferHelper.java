package com.yoti.mobile.android.commons.image;

import android.content.Context;
import android.graphics.Bitmap;
import com.yoti.mobile.android.commons.util.PictureHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BufferHelper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "Landroid/graphics/Bitmap;", "toBitmap", "(Lcom/yoti/mobile/android/commons/image/ImageBuffer;)Landroid/graphics/Bitmap;", "Landroid/content/Context;", "context", "toBitmapFast", "(Lcom/yoti/mobile/android/commons/image/ImageBuffer;Landroid/content/Context;)Landroid/graphics/Bitmap;", "commons-image_release"}, m5599k = 2, m5600mv = {1, 4, 2})
public final class BufferHelper {
    public static final Bitmap toBitmap(ImageBuffer toBitmap) {
        Intrinsics.checkNotNullParameter(toBitmap, "$this$toBitmap");
        return PictureHelper.YuvToBitmapCompat(toBitmap.getData(), toBitmap.getWidth(), toBitmap.getHeight());
    }

    public static final Bitmap toBitmapFast(ImageBuffer toBitmapFast, Context context) {
        Intrinsics.checkNotNullParameter(toBitmapFast, "$this$toBitmapFast");
        Intrinsics.checkNotNullParameter(context, "context");
        return PictureHelper.YuvToBitmap(context, toBitmapFast.getData(), toBitmapFast.getWidth(), toBitmapFast.getHeight());
    }
}
