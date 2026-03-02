package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import kotlin.Metadata;

/* JADX INFO: compiled from: PreverificationHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/facebook/imagepipeline/platform/PreverificationHelper;", "", "()V", "shouldUseHardwareBitmapConfig", "", "config", "Landroid/graphics/Bitmap$Config;", "imagepipeline_release"}, m5599k = 1, m5600mv = {1, 8, 0}, m5602xi = 48)
public final class PreverificationHelper {
    public final boolean shouldUseHardwareBitmapConfig(Bitmap.Config config) {
        return config == Bitmap.Config.HARDWARE;
    }
}
