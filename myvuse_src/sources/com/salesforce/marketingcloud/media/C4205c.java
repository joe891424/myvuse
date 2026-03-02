package com.salesforce.marketingcloud.media;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.collection.LruCache;
import androidx.core.graphics.BitmapCompat;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.c */
/* JADX INFO: loaded from: classes6.dex */
public class C4205c {

    /* JADX INFO: renamed from: a */
    private final LruCache<String, b> f5024a;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.c$a */
    class a extends LruCache<String, b> {
        a(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, b bVar) {
            return bVar.f5027b;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.c$b */
    static final class b {

        /* JADX INFO: renamed from: a */
        final Bitmap f5026a;

        /* JADX INFO: renamed from: b */
        final int f5027b;

        b(Bitmap bitmap, int i) {
            this.f5026a = bitmap;
            this.f5027b = i;
        }
    }

    C4205c(Context context) {
        this.f5024a = new a(m3513a(context));
    }

    /* JADX INFO: renamed from: a */
    private static int m3513a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        return (int) ((((long) ((context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass())) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) / 10);
    }

    /* JADX INFO: renamed from: a */
    void m3515a() {
        this.f5024a.evictAll();
    }

    /* JADX INFO: renamed from: a */
    Bitmap m3514a(String str) {
        b bVar = this.f5024a.get(str);
        if (bVar != null) {
            return bVar.f5026a;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    void m3516a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return;
        }
        int allocationByteCount = BitmapCompat.getAllocationByteCount(bitmap);
        if (allocationByteCount > this.f5024a.maxSize()) {
            this.f5024a.remove(str);
        } else {
            this.f5024a.put(str, new b(bitmap, allocationByteCount));
        }
    }
}
