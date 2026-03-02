package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.Asserts;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zaa implements Runnable {
    final /* synthetic */ ImageManager zaa;
    private final Uri zab;
    private final ParcelFileDescriptor zac;

    public zaa(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.zaa = imageManager;
        this.zab = uri;
        this.zac = parcelFileDescriptor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor = this.zac;
        boolean z = false;
        Bitmap bitmapDecodeFileDescriptor = null;
        if (parcelFileDescriptor != null) {
            try {
                bitmapDecodeFileDescriptor = BitmapFactoryInstrumentation.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError e) {
                LogInstrumentation.m2729e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(String.valueOf(this.zab))), e);
                z = true;
            }
            try {
                this.zac.close();
            } catch (IOException e2) {
                LogInstrumentation.m2729e("ImageManager", "closed failed", e2);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager imageManager = this.zaa;
        imageManager.zae.post(new zac(imageManager, this.zab, bitmapDecodeFileDescriptor, z, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            LogInstrumentation.m2734w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(String.valueOf(this.zab))));
        }
    }
}
