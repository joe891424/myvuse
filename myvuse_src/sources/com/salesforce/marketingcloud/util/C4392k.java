package com.salesforce.marketingcloud.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.util.k */
/* JADX INFO: loaded from: classes6.dex */
public class C4392k implements Closeable {

    /* JADX INFO: renamed from: f */
    private static final byte f5809f = 13;

    /* JADX INFO: renamed from: g */
    private static final byte f5810g = 10;

    /* JADX INFO: renamed from: a */
    private final InputStream f5811a;

    /* JADX INFO: renamed from: b */
    final Charset f5812b;

    /* JADX INFO: renamed from: c */
    private byte[] f5813c;

    /* JADX INFO: renamed from: d */
    private int f5814d;

    /* JADX INFO: renamed from: e */
    private int f5815e;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.util.k$a */
    class a extends ByteArrayOutputStream {
        a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            if (i > 0) {
                int i2 = i - 1;
                if (((ByteArrayOutputStream) this).buf[i2] == 13) {
                    i = i2;
                }
            }
            return new String(((ByteArrayOutputStream) this).buf, 0, i, C4392k.this.f5812b);
        }
    }

    public C4392k(InputStream inputStream) {
        this(inputStream, 8192);
    }

    /* JADX INFO: renamed from: a */
    private void m4329a() throws IOException {
        InputStream inputStream = this.f5811a;
        byte[] bArr = this.f5813c;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.f5814d = 0;
        this.f5815e = i;
    }

    /* JADX INFO: renamed from: b */
    public boolean m4330b() {
        return this.f5815e == -1;
    }

    /* JADX INFO: renamed from: c */
    public int m4331c() throws IOException {
        String strM4332d = m4332d();
        try {
            return Integer.parseInt(strM4332d);
        } catch (NumberFormatException unused) {
            throw new IOException("expected an int but was \"" + strM4332d + "\"");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f5811a) {
            if (this.f5813c != null) {
                this.f5813c = null;
                this.f5811a.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String m4332d() throws java.io.IOException {
        /*
            r7 = this;
            java.io.InputStream r0 = r7.f5811a
            monitor-enter(r0)
            byte[] r1 = r7.f5813c     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L7b
            int r1 = r7.f5814d     // Catch: java.lang.Throwable -> L83
            int r2 = r7.f5815e     // Catch: java.lang.Throwable -> L83
            if (r1 < r2) goto L10
            r7.m4329a()     // Catch: java.lang.Throwable -> L83
        L10:
            int r1 = r7.f5814d     // Catch: java.lang.Throwable -> L83
        L12:
            int r2 = r7.f5815e     // Catch: java.lang.Throwable -> L83
            r3 = 10
            if (r1 == r2) goto L3d
            byte[] r2 = r7.f5813c     // Catch: java.lang.Throwable -> L83
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L83
            if (r4 != r3) goto L3a
            int r3 = r7.f5814d     // Catch: java.lang.Throwable -> L83
            if (r1 == r3) goto L2b
            int r4 = r1 + (-1)
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L83
            r6 = 13
            if (r5 != r6) goto L2b
            goto L2c
        L2b:
            r4 = r1
        L2c:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L83
            int r4 = r4 - r3
            java.nio.charset.Charset r6 = r7.f5812b     // Catch: java.lang.Throwable -> L83
            r5.<init>(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L83
            int r1 = r1 + 1
            r7.f5814d = r1     // Catch: java.lang.Throwable -> L83
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L83
            return r5
        L3a:
            int r1 = r1 + 1
            goto L12
        L3d:
            com.salesforce.marketingcloud.util.k$a r1 = new com.salesforce.marketingcloud.util.k$a     // Catch: java.lang.Throwable -> L83
            int r2 = r7.f5815e     // Catch: java.lang.Throwable -> L83
            int r4 = r7.f5814d     // Catch: java.lang.Throwable -> L83
            int r2 = r2 - r4
            int r2 = r2 + 80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L83
        L49:
            byte[] r2 = r7.f5813c     // Catch: java.lang.Throwable -> L83
            int r4 = r7.f5814d     // Catch: java.lang.Throwable -> L83
            int r5 = r7.f5815e     // Catch: java.lang.Throwable -> L83
            int r5 = r5 - r4
            r1.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L83
            r2 = -1
            r7.f5815e = r2     // Catch: java.lang.Throwable -> L83
            r7.m4329a()     // Catch: java.lang.Throwable -> L83
            int r2 = r7.f5814d     // Catch: java.lang.Throwable -> L83
        L5b:
            int r4 = r7.f5815e     // Catch: java.lang.Throwable -> L83
            if (r2 == r4) goto L49
            byte[] r4 = r7.f5813c     // Catch: java.lang.Throwable -> L83
            r5 = r4[r2]     // Catch: java.lang.Throwable -> L83
            if (r5 != r3) goto L78
            int r3 = r7.f5814d     // Catch: java.lang.Throwable -> L83
            if (r2 == r3) goto L6e
            int r5 = r2 - r3
            r1.write(r4, r3, r5)     // Catch: java.lang.Throwable -> L83
        L6e:
            int r2 = r2 + 1
            r7.f5814d = r2     // Catch: java.lang.Throwable -> L83
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L83
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L83
            return r1
        L78:
            int r2 = r2 + 1
            goto L5b
        L7b:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = "LineReader is closed"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L83
            throw r1     // Catch: java.lang.Throwable -> L83
        L83:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L83
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.util.C4392k.m4332d():java.lang.String");
    }

    public C4392k(InputStream inputStream, int i) {
        this(inputStream, i, C4388g.f5803a);
    }

    public C4392k(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null) {
            throw new NullPointerException("in == null");
        }
        if (charset == null) {
            throw new NullPointerException("charset == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(C4388g.f5803a) && !charset.equals(C4388g.f5805c) && !charset.equals(C4388g.f5804b)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f5811a = inputStream;
        this.f5812b = charset;
        this.f5813c = new byte[i];
    }

    public C4392k(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }
}
