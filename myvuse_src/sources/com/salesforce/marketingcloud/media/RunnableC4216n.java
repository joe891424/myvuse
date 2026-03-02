package com.salesforce.marketingcloud.media;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.media.AbstractC4223u;
import com.salesforce.marketingcloud.media.C4217o;
import com.salesforce.marketingcloud.media.C4221s;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.n */
/* JADX INFO: loaded from: classes6.dex */
public class RunnableC4216n implements Runnable {

    /* JADX INFO: renamed from: m */
    private static final String f5062m = "ImageHandler-";

    /* JADX INFO: renamed from: n */
    private static final String f5063n = "ImageHandler-Idle";

    /* JADX INFO: renamed from: o */
    private static final ThreadLocal<StringBuilder> f5064o = new a();

    /* JADX INFO: renamed from: p */
    private static final AbstractC4223u f5065p = new b();

    /* JADX INFO: renamed from: a */
    final C4217o f5066a;

    /* JADX INFO: renamed from: b */
    final C4210h f5067b;

    /* JADX INFO: renamed from: c */
    final String f5068c;

    /* JADX INFO: renamed from: d */
    final AbstractC4223u f5069d;

    /* JADX INFO: renamed from: e */
    final C4205c f5070e;

    /* JADX INFO: renamed from: f */
    C4221s f5071f;

    /* JADX INFO: renamed from: g */
    AbstractC4203a f5072g;

    /* JADX INFO: renamed from: h */
    List<AbstractC4203a> f5073h;

    /* JADX INFO: renamed from: i */
    AbstractC4223u.b f5074i;

    /* JADX INFO: renamed from: j */
    Future<?> f5075j;

    /* JADX INFO: renamed from: k */
    Exception f5076k;

    /* JADX INFO: renamed from: l */
    C4217o.c f5077l;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.n$a */
    class a extends ThreadLocal<StringBuilder> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder(RunnableC4216n.f5062m);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.n$b */
    class b extends AbstractC4223u {
        b() {
        }

        @Override // com.salesforce.marketingcloud.media.AbstractC4223u
        /* JADX INFO: renamed from: a */
        public boolean mo3539a(C4221s c4221s) {
            return true;
        }

        @Override // com.salesforce.marketingcloud.media.AbstractC4223u
        /* JADX INFO: renamed from: a */
        public void mo3538a(C4217o c4217o, C4221s c4221s, AbstractC4223u.a aVar) throws IOException {
            aVar.mo3561a(new C4213k(c4221s));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.n$c */
    class c implements AbstractC4223u.a {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ AtomicReference f5078a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ CountDownLatch f5079b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ AtomicReference f5080c;

        c(AtomicReference atomicReference, CountDownLatch countDownLatch, AtomicReference atomicReference2) {
            this.f5078a = atomicReference;
            this.f5079b = countDownLatch;
            this.f5080c = atomicReference2;
        }

        @Override // com.salesforce.marketingcloud.media.AbstractC4223u.a
        /* JADX INFO: renamed from: a */
        public void mo3561a(Throwable th) {
            this.f5080c.set(th);
            this.f5079b.countDown();
        }

        @Override // com.salesforce.marketingcloud.media.AbstractC4223u.a
        /* JADX INFO: renamed from: a */
        public void mo3560a(AbstractC4223u.b bVar) {
            this.f5078a.set(bVar);
            this.f5079b.countDown();
        }
    }

    RunnableC4216n(C4217o c4217o, C4210h c4210h, C4205c c4205c, AbstractC4203a abstractC4203a, AbstractC4223u abstractC4223u) {
        this.f5066a = c4217o;
        this.f5067b = c4210h;
        this.f5070e = c4205c;
        this.f5072g = abstractC4203a;
        this.f5068c = abstractC4203a.m3502c();
        this.f5071f = abstractC4203a.m3504e();
        this.f5069d = abstractC4223u;
        this.f5077l = abstractC4203a.m3503d();
    }

    /* JADX INFO: renamed from: a */
    public void m3547a(AbstractC4203a abstractC4203a) {
        if (this.f5072g == null) {
            this.f5072g = abstractC4203a;
            return;
        }
        if (this.f5073h == null) {
            this.f5073h = new ArrayList();
        }
        this.f5073h.add(abstractC4203a);
        C4217o.c cVarM3503d = abstractC4203a.m3503d();
        if (cVarM3503d.ordinal() > this.f5077l.ordinal()) {
            this.f5077l = cVarM3503d;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3550b(AbstractC4203a abstractC4203a) {
        if (this.f5072g == abstractC4203a) {
            this.f5072g = null;
            return;
        }
        List<AbstractC4203a> list = this.f5073h;
        if (list != null) {
            list.remove(abstractC4203a);
        }
    }

    /* JADX INFO: renamed from: c */
    public AbstractC4203a m3551c() {
        return this.f5072g;
    }

    /* JADX INFO: renamed from: d */
    public List<AbstractC4203a> m3552d() {
        return this.f5073h;
    }

    /* JADX INFO: renamed from: e */
    public C4221s m3553e() {
        return this.f5071f;
    }

    /* JADX INFO: renamed from: f */
    public Exception m3554f() {
        return this.f5076k;
    }

    /* JADX INFO: renamed from: g */
    public C4217o m3555g() {
        return this.f5066a;
    }

    /* JADX INFO: renamed from: h */
    public String m3556h() {
        return this.f5068c;
    }

    /* JADX INFO: renamed from: i */
    public AbstractC4223u.b m3557i() {
        return this.f5074i;
    }

    /* JADX INFO: renamed from: j */
    boolean m3558j() {
        Future<?> future = this.f5075j;
        return future != null && future.isCancelled();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                m3545a(this.f5071f);
                AbstractC4223u.b bVarM3549b = m3549b();
                this.f5074i = bVarM3549b;
                if (bVarM3549b.m3622d()) {
                    C4170g.m3202a("IMAGE", "onSuccess - Loaded from: %s", this.f5074i.m3621c());
                    this.f5067b.m3532b(this);
                } else {
                    this.f5067b.m3534c(this);
                }
            } catch (Exception e) {
                this.f5076k = e;
                this.f5067b.m3534c(this);
            }
        } finally {
            Thread.currentThread().setName(f5063n);
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m3548a() {
        Future<?> future;
        if (this.f5072g != null) {
            return false;
        }
        List<AbstractC4203a> list = this.f5073h;
        return (list == null || list.isEmpty()) && (future = this.f5075j) != null && future.cancel(false);
    }

    /* JADX INFO: renamed from: b */
    AbstractC4223u.b m3549b() throws IOException {
        Bitmap bitmapM3514a;
        if (C4221s.b.m3597a(this.f5071f.f5110d) && (bitmapM3514a = this.f5070e.m3514a(this.f5068c)) != null) {
            return new AbstractC4223u.b(bitmapM3514a, C4217o.b.MEMORY);
        }
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            this.f5069d.mo3538a(this.f5066a, this.f5071f, new c(atomicReference, countDownLatch, atomicReference2));
            countDownLatch.await();
            Throwable th = (Throwable) atomicReference2.get();
            if (th != null) {
                throw new RuntimeException(th);
            }
            AbstractC4223u.b bVar = (AbstractC4223u.b) atomicReference.get();
            if (!bVar.m3622d()) {
                return bVar;
            }
            Bitmap bitmapM3619a = bVar.m3619a();
            if (!this.f5071f.m3588e()) {
                return bVar;
            }
            if (this.f5071f.m3587d()) {
                bitmapM3619a = m3546b(this.f5071f, bitmapM3619a);
            }
            if (this.f5071f.m3586c()) {
                bitmapM3619a = m3543a(this.f5071f, bitmapM3619a);
            }
            return new AbstractC4223u.b(bitmapM3619a, bVar.m3621c());
        } catch (InterruptedException e) {
            throw new InterruptedIOException(e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    static Bitmap m3543a(C4221s c4221s, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = c4221s.f5115i;
        float f2 = c4221s.f5116j;
        float f3 = width;
        float f4 = height;
        RectF rectF = new RectF(0.0f, 0.0f, f3, f4);
        RectF rectF2 = new RectF(0.0f, 0.0f, f3, f4);
        Paint paint = new Paint();
        Paint paint2 = new Paint();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        if (f2 > 0.0f) {
            paint2.setStrokeWidth(f2);
            paint2.setColor(c4221s.f5117k);
            float f5 = f2 / 2.0f;
            rectF2.inset(f5, f5);
            float fFloor = (float) Math.floor(f5);
            rectF.inset(fFloor, fFloor);
        }
        if (f > 0.0f) {
            canvas.drawRoundRect(rectF, f, f, paint);
            if (f2 > 0.0f) {
                canvas.drawRoundRect(rectF2, f, f, paint2);
            }
        } else {
            canvas.drawRect(rectF, paint);
            if (f2 > 0.0f) {
                canvas.drawRect(rectF2, paint2);
            }
        }
        if (bitmap == bitmapCreateBitmap) {
            return bitmap;
        }
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    /* JADX INFO: renamed from: b */
    static Bitmap m3546b(C4221s c4221s, Bitmap bitmap) {
        int i;
        int i2;
        int i3;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        int i4;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        int i5 = 0;
        if (c4221s.m3587d()) {
            int i6 = c4221s.f5111e;
            int i7 = c4221s.f5112f;
            if (c4221s.f5113g) {
                if (i6 != 0) {
                    f9 = i6;
                    f10 = width;
                } else {
                    f9 = i7;
                    f10 = height;
                }
                float f13 = f9 / f10;
                if (i7 != 0) {
                    f11 = i7;
                    f12 = height;
                } else {
                    f11 = i6;
                    f12 = width;
                }
                float f14 = f11 / f12;
                if (f13 > f14) {
                    int iCeil = (int) Math.ceil(height * (f14 / f13));
                    f14 = i7 / iCeil;
                    i4 = (height - iCeil) / 2;
                    height = iCeil;
                } else if (f13 < f14) {
                    int iCeil2 = (int) Math.ceil(width * (f13 / f14));
                    int i8 = (width - iCeil2) / 2;
                    width = iCeil2;
                    f13 = i6 / iCeil2;
                    i4 = 0;
                    i5 = i8;
                } else {
                    i4 = 0;
                    f13 = f14;
                }
                matrix.preScale(f13, f14);
                i = width;
                i2 = height;
                i3 = i4;
            } else {
                if (c4221s.f5114h) {
                    if (i6 != 0) {
                        f5 = i6;
                        f6 = width;
                    } else {
                        f5 = i7;
                        f6 = height;
                    }
                    float f15 = f5 / f6;
                    if (i7 != 0) {
                        f7 = i7;
                        f8 = height;
                    } else {
                        f7 = i6;
                        f8 = width;
                    }
                    float f16 = f7 / f8;
                    if (f15 >= f16) {
                        f15 = f16;
                    }
                    matrix.preScale(f15, f15);
                } else if ((i6 != 0 || i7 != 0) && (i6 != width || i7 != height)) {
                    if (i6 != 0) {
                        f = i6;
                        f2 = width;
                    } else {
                        f = i7;
                        f2 = height;
                    }
                    float f17 = f / f2;
                    if (i7 != 0) {
                        f3 = i7;
                        f4 = height;
                    } else {
                        f3 = i6;
                        f4 = width;
                    }
                    matrix.preScale(f17, f3 / f4);
                }
                i = width;
                i2 = height;
                i3 = 0;
            }
        } else {
            i = width;
            i2 = height;
            i3 = 0;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i5, i3, i, i2, matrix, true);
        if (bitmapCreateBitmap == bitmap) {
            return bitmap;
        }
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    /* JADX INFO: renamed from: a */
    static RunnableC4216n m3544a(C4217o c4217o, C4210h c4210h, C4205c c4205c, AbstractC4203a abstractC4203a) {
        C4221s c4221sM3504e = abstractC4203a.m3504e();
        List<AbstractC4223u> listM3566a = c4217o.m3566a();
        int size = listM3566a.size();
        for (int i = 0; i < size; i++) {
            AbstractC4223u abstractC4223u = listM3566a.get(i);
            if (abstractC4223u.mo3539a(c4221sM3504e)) {
                return new RunnableC4216n(c4217o, c4210h, c4205c, abstractC4203a, abstractC4223u);
            }
        }
        return new RunnableC4216n(c4217o, c4210h, c4205c, abstractC4203a, f5065p);
    }

    /* JADX INFO: renamed from: a */
    static void m3545a(C4221s c4221s) {
        String strM3585b = c4221s.m3585b();
        StringBuilder sb = f5064o.get();
        sb.ensureCapacity(strM3585b.length() + 13);
        sb.replace(13, sb.length(), strM3585b);
        Thread.currentThread().setName(sb.toString());
    }
}
