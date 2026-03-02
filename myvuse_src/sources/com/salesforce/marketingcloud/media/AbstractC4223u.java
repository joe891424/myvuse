package com.salesforce.marketingcloud.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.salesforce.marketingcloud.media.C4217o;
import com.salesforce.marketingcloud.util.C4388g;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.u */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractC4223u {

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.u$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo3560a(b bVar);

        /* JADX INFO: renamed from: a */
        void mo3561a(Throwable th);
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.u$b */
    public static final class b {

        /* JADX INFO: renamed from: a */
        private final C4217o.b f5137a;

        /* JADX INFO: renamed from: b */
        private final Bitmap f5138b;

        /* JADX INFO: renamed from: c */
        private final Drawable f5139c;

        private b(Bitmap bitmap, Drawable drawable, C4217o.b bVar) {
            this.f5138b = bitmap;
            this.f5139c = drawable;
            this.f5137a = bVar;
        }

        /* JADX INFO: renamed from: a */
        public Bitmap m3619a() {
            return this.f5138b;
        }

        /* JADX INFO: renamed from: b */
        public Drawable m3620b() {
            return this.f5139c;
        }

        /* JADX INFO: renamed from: c */
        public C4217o.b m3621c() {
            return this.f5137a;
        }

        /* JADX INFO: renamed from: d */
        public boolean m3622d() {
            return this.f5138b != null;
        }

        /* JADX INFO: renamed from: e */
        public boolean m3623e() {
            return this.f5139c != null;
        }

        public b(Bitmap bitmap, C4217o.b bVar) {
            this(bitmap, null, bVar);
        }

        public b(Drawable drawable, C4217o.b bVar) {
            this(null, drawable, bVar);
        }
    }

    /* JADX INFO: renamed from: a */
    static void m3615a(int i, int i2, int i3, int i4, BitmapFactory.Options options) {
        int iMin;
        double d;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                d = i3 / i;
            } else if (i == 0) {
                d = i4 / i2;
            } else {
                iMin = Math.min((int) Math.floor(i4 / i2), (int) Math.floor(i3 / i));
            }
            iMin = (int) Math.floor(d);
        } else {
            iMin = 1;
        }
        options.inSampleSize = iMin;
        options.inJustDecodeBounds = false;
    }

    /* JADX INFO: renamed from: b */
    static BitmapFactory.Options m3618b(C4221s c4221s) {
        if (!c4221s.m3587d()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        return options;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo3538a(C4217o c4217o, C4221s c4221s, a aVar) throws IOException;

    /* JADX INFO: renamed from: a */
    public abstract boolean mo3539a(C4221s c4221s);

    /* JADX INFO: renamed from: a */
    private static void m3616a(int i, int i2, BitmapFactory.Options options) {
        m3615a(i, i2, options.outWidth, options.outHeight, options);
    }

    /* JADX INFO: renamed from: a */
    static Bitmap m3614a(InputStream inputStream, C4221s c4221s) throws IOException {
        BitmapFactory.Options optionsM3618b = m3618b(c4221s);
        boolean zM3617a = m3617a(optionsM3618b);
        byte[] bArrM4317a = C4388g.m4317a(inputStream);
        if (zM3617a) {
            BitmapFactoryInstrumentation.decodeStream(new ByteArrayInputStream(bArrM4317a), null, optionsM3618b);
            m3616a(c4221s.f5111e, c4221s.f5112f, optionsM3618b);
        }
        Bitmap bitmapDecodeStream = BitmapFactoryInstrumentation.decodeStream(new ByteArrayInputStream(bArrM4317a), null, optionsM3618b);
        if (bitmapDecodeStream != null) {
            return bitmapDecodeStream;
        }
        throw new IOException("Failed to decode bitmap");
    }

    /* JADX INFO: renamed from: a */
    static boolean m3617a(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }
}
