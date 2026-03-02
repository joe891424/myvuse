package com.yoti.mobile.android.commons.image;

import com.facebook.common.callercontext.ContextChain;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.OctetSequenceJsonWebKey;

/* JADX INFO: compiled from: PlanarStrideBuffer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0017\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\t¨\u0006\u001f"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/image/PlanarStrideBuffer;", "Lcom/yoti/mobile/android/commons/image/StrideBuffer;", "", "dest", "", "fillData", "([B)V", "", "f", "I", "getWidth", "()I", "width", "Ljava/nio/ByteBuffer;", ContextChain.TAG_INFRA, "Ljava/nio/ByteBuffer;", "vBuffer", "j", "uvRowStride", "h", "uBuffer", "g", "getHeight", "height", OctetSequenceJsonWebKey.KEY_VALUE_MEMBER_NAME, "uvPixelStride", "yBuffer", "yRowStride", "yPixelStride", "<init>", "(IILjava/nio/ByteBuffer;IILjava/nio/ByteBuffer;Ljava/nio/ByteBuffer;II)V", "commons-image_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class PlanarStrideBuffer extends StrideBuffer {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final int width;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final int height;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final ByteBuffer uBuffer;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final ByteBuffer vBuffer;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final int uvRowStride;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final int uvPixelStride;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlanarStrideBuffer(int i, int i2, ByteBuffer yBuffer, int i3, int i4, ByteBuffer uBuffer, ByteBuffer vBuffer, int i5, int i6) {
        super(i, i2, yBuffer, i3, i4);
        Intrinsics.checkNotNullParameter(yBuffer, "yBuffer");
        Intrinsics.checkNotNullParameter(uBuffer, "uBuffer");
        Intrinsics.checkNotNullParameter(vBuffer, "vBuffer");
        this.width = i;
        this.height = i2;
        this.uBuffer = uBuffer;
        this.vBuffer = vBuffer;
        this.uvRowStride = i5;
        this.uvPixelStride = i6;
    }

    @Override // com.yoti.mobile.android.commons.image.StrideBuffer, com.yoti.mobile.android.commons.image.ImageBuffer
    public void fillData(byte[] dest) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        super.fillData(dest);
        int width = getWidth() * getHeight();
        int width2 = getWidth() / 2;
        int i = this.uvPixelStride * width2;
        int i2 = this.uvRowStride - i;
        byte[] bArr = new byte[i];
        byte[] bArr2 = new byte[i];
        int height = getHeight() / 2;
        int i3 = width;
        int i4 = 0;
        while (i4 < height) {
            int i5 = i4;
            StrideBuffer.readPixelRow$default(this, this.uBuffer, bArr, i, i2, 0, 16, null);
            StrideBuffer.readPixelRow$default(this, this.vBuffer, bArr2, i, i2, 0, 16, null);
            for (int i6 = 0; i6 < width2; i6++) {
                int i7 = i3 + (i6 * 2);
                int i8 = this.uvPixelStride * i6;
                dest[i7] = bArr2[i8];
                dest[i7 + 1] = bArr[i8];
            }
            i3 += width2 * 2;
            i4 = i5 + 1;
        }
    }

    @Override // com.yoti.mobile.android.commons.image.StrideBuffer, com.yoti.mobile.android.commons.image.ImageBuffer
    public int getHeight() {
        return this.height;
    }

    @Override // com.yoti.mobile.android.commons.image.StrideBuffer, com.yoti.mobile.android.commons.image.ImageBuffer
    public int getWidth() {
        return this.width;
    }
}
