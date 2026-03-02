package com.yoti.mobile.android.commons.image;

import com.brentvatne.react.ReactVideoViewManager;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: StrideBuffer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0016\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fB5\b\u0017\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\t\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J9\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tH\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0016\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u001b\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0016\u0010\u001d\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0013¨\u0006#"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/image/StrideBuffer;", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "", "dest", "", "fillData", "([B)V", "Ljava/nio/ByteBuffer;", ReactVideoViewManager.PROP_SRC, "", "bytesToRead", "bytesToSkip", "totalBytesRead", "readPixelRow", "(Ljava/nio/ByteBuffer;[BIII)I", "c", "Ljava/nio/ByteBuffer;", "wrapped", "a", "I", "getWidth", "()I", "width", "b", "getHeight", "height", "d", "rowStride", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "pixelStride", "<init>", "(IILjava/nio/ByteBuffer;II)V", "raw", "stride", "(II[BII)V", "commons-image_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public class StrideBuffer implements ImageBuffer {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int width;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int height;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final ByteBuffer wrapped;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final int rowStride;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final int pixelStride;

    public StrideBuffer(int i, int i2, ByteBuffer wrapped, int i3, int i4) {
        Intrinsics.checkNotNullParameter(wrapped, "wrapped");
        this.width = i;
        this.height = i2;
        this.wrapped = wrapped;
        this.rowStride = i3;
        this.pixelStride = i4;
    }

    public StrideBuffer(int i, int i2, byte[] bArr) {
        this(i, i2, bArr, 0, 0, 24, (DefaultConstructorMarker) null);
    }

    public StrideBuffer(int i, int i2, byte[] bArr, int i3) {
        this(i, i2, bArr, i3, 0, 16, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ int readPixelRow$default(StrideBuffer strideBuffer, ByteBuffer byteBuffer, byte[] bArr, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readPixelRow");
        }
        if ((i4 & 16) != 0) {
            i3 = 0;
        }
        return strideBuffer.readPixelRow(byteBuffer, bArr, i, i2, i3);
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    public void fillData(byte[] dest) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        int pixelRow = 0;
        if (this.pixelStride == 1) {
            int width = this.rowStride - getWidth();
            if (width == 0) {
                ByteBuffer byteBuffer = this.wrapped;
                byteBuffer.get(dest, 0, byteBuffer.remaining());
                return;
            } else {
                while (this.wrapped.hasRemaining()) {
                    pixelRow += readPixelRow(this.wrapped, dest, getWidth(), width, pixelRow);
                }
                return;
            }
        }
        int width2 = getWidth() * this.pixelStride;
        int i = this.rowStride - width2;
        byte[] bArr = new byte[width2];
        int width3 = 0;
        while (this.wrapped.hasRemaining()) {
            readPixelRow$default(this, this.wrapped, bArr, width2, i, 0, 16, null);
            int width4 = getWidth();
            for (int i2 = 0; i2 < width4; i2++) {
                dest[width3 + i2] = bArr[this.pixelStride * i2];
            }
            width3 += getWidth();
        }
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    public byte[] getData() {
        return ImageBuffer.DefaultImpls.getData(this);
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    public int getHeight() {
        return this.height;
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    public int getWidth() {
        return this.width;
    }

    protected final int readPixelRow(ByteBuffer src, byte[] dest, int bytesToRead, int bytesToSkip, int totalBytesRead) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dest, "dest");
        int iMin = Math.min(bytesToRead, src.remaining());
        src.get(dest, totalBytesRead, iMin);
        src.position(Math.min(src.position() + bytesToSkip, src.limit()));
        return iMin;
    }

    public /* synthetic */ StrideBuffer(int i, int i2, ByteBuffer byteBuffer, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, byteBuffer, (i5 & 8) != 0 ? i : i3, (i5 & 16) != 0 ? 1 : i4);
    }

    public /* synthetic */ StrideBuffer(int i, int i2, byte[] bArr, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, bArr, (i5 & 8) != 0 ? i : i3, (i5 & 16) != 0 ? 1 : i4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public StrideBuffer(int i, int i2, byte[] raw, int i3, int i4) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(raw);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "ByteBuffer.wrap(raw)");
        this(i, i2, byteBufferWrap, i3, i4);
    }
}
