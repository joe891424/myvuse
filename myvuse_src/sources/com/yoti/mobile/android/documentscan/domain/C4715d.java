package com.yoti.mobile.android.documentscan.domain;

import android.graphics.Bitmap;
import com.microblink.image.Image;
import com.yoti.mobile.android.commons.image.DirectBuffer;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import com.yoti.mobile.android.commons.image.StrideBuffer;
import com.yoti.mobile.android.core.image.RotationBufferKt;
import com.yoti.mobile.android.documentscan.ui.helpers.scan.C4802c;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.d */
/* JADX INFO: loaded from: classes5.dex */
public final class C4715d {

    /* JADX INFO: renamed from: a */
    private final C4802c f6900a;

    /* JADX WARN: Multi-variable type inference failed */
    public C4715d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public C4715d(C4802c blinkRotationHelper) {
        Intrinsics.checkParameterIsNotNull(blinkRotationHelper, "blinkRotationHelper");
        this.f6900a = blinkRotationHelper;
    }

    public /* synthetic */ C4715d(C4802c c4802c, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C4802c() : c4802c);
    }

    /* JADX INFO: renamed from: a */
    private final DirectBuffer m4786a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        return new DirectBuffer(width, height, m4789a(width, height, bitmap));
    }

    /* JADX INFO: renamed from: a */
    private final void m4787a(byte[] bArr, int[] iArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = 0;
            while (i7 < i) {
                int i8 = iArr[i5];
                int i9 = (16711680 & i8) >> 16;
                int i10 = (65280 & i8) >> 8;
                int i11 = i8 & 255;
                int i12 = (((((i9 * 66) + (i10 * 129)) + (i11 * 25)) + 128) >> 8) + 16;
                int i13 = (((((i9 * (-38)) - (i10 * 74)) + (i11 * 112)) + 128) >> 8) + 128;
                int i14 = (((((i9 * 112) - (i10 * 94)) - (i11 * 18)) + 128) >> 8) + 128;
                int i15 = i4 + 1;
                bArr[i4] = (byte) RangesKt.coerceIn(i12, 0, 255);
                if (i6 % 2 == 0 && i5 % 2 == 0) {
                    int i16 = i3 + 1;
                    bArr[i3] = (byte) RangesKt.coerceIn(i14, 0, 255);
                    i3 += 2;
                    bArr[i16] = (byte) RangesKt.coerceIn(i13, 0, 255);
                }
                i5++;
                i7++;
                i4 = i15;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private final boolean m4788a(int i) {
        return i % 2 == 0;
    }

    /* JADX INFO: renamed from: a */
    private final byte[] m4789a(int i, int i2, Bitmap bitmap) {
        int i3 = i * i2;
        int[] iArr = new int[i3];
        bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
        byte[] bArr = new byte[i3 + (((int) Math.ceil(((double) i2) / 2.0d)) * 2 * ((int) Math.ceil(((double) i) / 2.0d)))];
        m4787a(bArr, iArr, i, i2);
        bitmap.recycle();
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.yoti.mobile.android.commons.image.DirectBuffer m4790b(android.graphics.Bitmap r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            int r1 = r6.getWidth()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            boolean r1 = r5.m4788a(r1)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r1 == 0) goto L10
            int r1 = r6.getWidth()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            goto L16
        L10:
            int r1 = r6.getWidth()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            int r1 = r1 + 1
        L16:
            int r2 = r6.getHeight()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            boolean r2 = r5.m4788a(r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r2 == 0) goto L25
            int r2 = r6.getHeight()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            goto L2b
        L25:
            int r2 = r6.getHeight()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            int r2 = r2 + 1
        L2b:
            r3 = 0
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createScaledBitmap(r6, r1, r2, r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            com.yoti.mobile.android.commons.image.DirectBuffer r0 = r5.m4786a(r6)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L4c
            if (r6 == 0) goto L4b
        L36:
            r6.recycle()
            goto L4b
        L3a:
            r1 = move-exception
            goto L41
        L3c:
            r6 = move-exception
            goto L50
        L3e:
            r6 = move-exception
            r1 = r6
            r6 = r0
        L41:
            java.lang.String r2 = "BlinkImageConverter"
            java.lang.String r3 = "Scale BlinkImage failed"
            com.yoti.mobile.android.commons.util.C4588L.logError(r2, r3, r1)     // Catch: java.lang.Throwable -> L4c
            if (r6 == 0) goto L4b
            goto L36
        L4b:
            return r0
        L4c:
            r0 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L50:
            if (r0 == 0) goto L55
            r0.recycle()
        L55:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentscan.domain.C4715d.m4790b(android.graphics.Bitmap):com.yoti.mobile.android.commons.image.DirectBuffer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x002f  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.yoti.mobile.android.commons.image.DirectBuffer m4791a(com.microblink.image.Image r6) {
        /*
            r5 = this;
            java.lang.String r0 = "blinkImage"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            r0 = 0
            android.graphics.Bitmap r6 = r6.convertToBitmap()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            if (r6 == 0) goto L15
            com.yoti.mobile.android.commons.image.DirectBuffer r0 = r5.m4790b(r6)     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L13
            goto L15
        L11:
            r0 = move-exception
            goto L2a
        L13:
            r1 = move-exception
            goto L1f
        L15:
            if (r6 == 0) goto L29
        L17:
            r6.recycle()
            goto L29
        L1b:
            r6 = move-exception
            goto L2d
        L1d:
            r1 = move-exception
            r6 = r0
        L1f:
            java.lang.String r2 = "BlinkImageConverter"
            java.lang.String r3 = "couldn't convert Blink Image to buffer"
            com.yoti.mobile.android.commons.util.C4588L.logError(r2, r3, r1)     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L29
            goto L17
        L29:
            return r0
        L2a:
            r4 = r0
            r0 = r6
            r6 = r4
        L2d:
            if (r0 == 0) goto L32
            r0.recycle()
        L32:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentscan.domain.C4715d.m4791a(com.microblink.image.Image):com.yoti.mobile.android.commons.image.DirectBuffer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0032  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.yoti.mobile.android.commons.image.DirectBuffer m4792a(byte[] r6) {
        /*
            r5 = this;
            java.lang.String r0 = "jpg"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            r0 = 0
            int r1 = r6.length     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r2 = 0
            android.graphics.Bitmap r6 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeByteArray(r6, r2, r1)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            if (r6 == 0) goto L17
            com.yoti.mobile.android.commons.image.DirectBuffer r0 = r5.m4790b(r6)     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L15
            goto L17
        L13:
            r0 = move-exception
            goto L2d
        L15:
            r1 = move-exception
            goto L22
        L17:
            if (r6 == 0) goto L2c
        L19:
            r6.recycle()
            goto L2c
        L1d:
            r6 = move-exception
            goto L30
        L1f:
            r6 = move-exception
            r1 = r6
            r6 = r0
        L22:
            java.lang.String r2 = "BlinkImageConverter"
            java.lang.String r3 = "couldn't convert Blink Image to buffer"
            com.yoti.mobile.android.commons.util.C4588L.logError(r2, r3, r1)     // Catch: java.lang.Throwable -> L13
            if (r6 == 0) goto L2c
            goto L19
        L2c:
            return r0
        L2d:
            r4 = r0
            r0 = r6
            r6 = r4
        L30:
            if (r0 == 0) goto L35
            r0.recycle()
        L35:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentscan.domain.C4715d.m4792a(byte[]):com.yoti.mobile.android.commons.image.DirectBuffer");
    }

    /* JADX INFO: renamed from: b */
    public final ImageBuffer m4793b(Image image) {
        Intrinsics.checkParameterIsNotNull(image, "image");
        int rawWidth = image.getRawWidth();
        int rawHeight = image.getRawHeight();
        ByteBuffer buffer = image.getBuffer();
        Intrinsics.checkExpressionValueIsNotNull(buffer, "image.buffer");
        return RotationBufferKt.rotateBy(new StrideBuffer(rawWidth, rawHeight, buffer, image.getRowStride(), image.getPixelStride()), this.f6900a.m5007a(image.getImageOrientation()));
    }
}
