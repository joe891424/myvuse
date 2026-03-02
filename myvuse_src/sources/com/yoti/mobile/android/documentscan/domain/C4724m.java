package com.yoti.mobile.android.documentscan.domain;

import android.os.SystemClock;
import com.yoti.mobile.android.commons.image.DirectBuffer;
import com.yoti.mobile.android.commons.image.ImageBuffer;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.m */
/* JADX INFO: loaded from: classes5.dex */
public class C4724m {

    /* JADX INFO: renamed from: a */
    private DirectBuffer f6913a;

    /* JADX INFO: renamed from: b */
    private DirectBuffer f6914b;

    /* JADX INFO: renamed from: c */
    private DirectBuffer[] f6915c;

    /* JADX INFO: renamed from: f */
    private boolean f6918f;

    /* JADX INFO: renamed from: g */
    private volatile boolean f6919g;

    /* JADX INFO: renamed from: h */
    private boolean f6920h;

    /* JADX INFO: renamed from: i */
    private int f6921i;

    /* JADX INFO: renamed from: d */
    private int f6916d = 0;

    /* JADX INFO: renamed from: e */
    private long f6917e = 0;

    /* JADX INFO: renamed from: j */
    private long f6922j = 0;

    public C4724m(int i) {
        this.f6921i = i;
        if (i > 0) {
            this.f6915c = new DirectBuffer[i];
        }
    }

    /* JADX INFO: renamed from: g */
    private boolean m4821g() {
        DirectBuffer[] directBufferArr = this.f6915c;
        return directBufferArr == null || directBufferArr.length < this.f6921i;
    }

    /* JADX INFO: renamed from: a */
    public void m4822a() {
        this.f6913a = null;
        this.f6914b = null;
        this.f6916d = 0;
        this.f6917e = 0L;
        this.f6918f = false;
    }

    /* JADX INFO: renamed from: a */
    public void m4823a(int i) {
        this.f6921i = i;
        if (i > 0) {
            this.f6915c = new DirectBuffer[i];
        }
        this.f6913a = null;
        this.f6914b = null;
        this.f6916d = 0;
        this.f6917e = 0L;
        this.f6918f = false;
    }

    /* JADX INFO: renamed from: a */
    public void m4824a(long j) {
        this.f6919g = false;
        this.f6922j = j;
        this.f6916d = 0;
        this.f6917e = SystemClock.uptimeMillis();
        this.f6918f = false;
        this.f6919g = true;
    }

    /* JADX INFO: renamed from: a */
    public boolean m4825a(ImageBuffer imageBuffer) {
        if (!this.f6919g || m4821g()) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis - this.f6917e <= this.f6922j) {
            return false;
        }
        DirectBuffer directBuffer = this.f6915c[this.f6916d];
        if (directBuffer == null || directBuffer.getWidth() != imageBuffer.getWidth() || directBuffer.getHeight() != imageBuffer.getHeight()) {
            directBuffer = new DirectBuffer(imageBuffer.getWidth(), imageBuffer.getHeight());
            this.f6915c[this.f6916d] = directBuffer;
        }
        imageBuffer.fillData(directBuffer.rawData);
        this.f6917e = jUptimeMillis;
        int i = this.f6916d + 1;
        this.f6916d = i;
        if (i >= this.f6921i) {
            this.f6916d = 0;
            this.f6918f = true;
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    public DirectBuffer m4826b() {
        return this.f6914b;
    }

    /* JADX INFO: renamed from: b */
    public void m4827b(ImageBuffer imageBuffer) {
        if (this.f6914b == null) {
            this.f6914b = new DirectBuffer(imageBuffer.getWidth(), imageBuffer.getHeight());
        }
        imageBuffer.fillData(this.f6914b.rawData);
    }

    /* JADX INFO: renamed from: c */
    public void m4828c(ImageBuffer imageBuffer) {
        if (this.f6913a == null) {
            this.f6913a = new DirectBuffer(imageBuffer.getWidth(), imageBuffer.getHeight());
        }
        imageBuffer.fillData(this.f6913a.rawData);
        this.f6920h = false;
    }

    /* JADX INFO: renamed from: c */
    public DirectBuffer[] m4829c() {
        DirectBuffer[] directBufferArr = new DirectBuffer[this.f6921i];
        if (this.f6919g) {
            int i = 0;
            while (true) {
                int i2 = this.f6921i;
                if (i >= i2) {
                    break;
                }
                directBufferArr[((i - this.f6916d) + i2) % i2] = this.f6915c[i];
                i++;
            }
        }
        return directBufferArr;
    }

    /* JADX INFO: renamed from: d */
    public boolean m4830d() {
        return this.f6918f;
    }

    /* JADX INFO: renamed from: e */
    public void m4831e() {
        this.f6914b = null;
    }

    /* JADX INFO: renamed from: f */
    public void m4832f() {
        DirectBuffer directBuffer = this.f6913a;
        if (directBuffer == null) {
            throw new IllegalStateException("Can't set frame valid with no stored frames");
        }
        if (this.f6914b == null) {
            this.f6914b = new DirectBuffer(directBuffer.getWidth(), this.f6913a.getHeight());
        }
        if (this.f6920h) {
            return;
        }
        DirectBuffer directBuffer2 = this.f6914b;
        this.f6914b = this.f6913a;
        this.f6913a = directBuffer2;
        this.f6920h = true;
    }
}
