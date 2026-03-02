package com.facebook.imagepipeline.transformation;

import android.graphics.Bitmap;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: BitmapTransformation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m5598d2 = {"Lcom/facebook/imagepipeline/transformation/BitmapTransformation;", "", "modifiesTransparency", "", ViewProps.TRANSFORM, "", "bitmap", "Landroid/graphics/Bitmap;", "imagepipeline-base_release"}, m5599k = 1, m5600mv = {1, 8, 0}, m5602xi = 48)
public interface BitmapTransformation {
    boolean modifiesTransparency();

    void transform(Bitmap bitmap);
}
