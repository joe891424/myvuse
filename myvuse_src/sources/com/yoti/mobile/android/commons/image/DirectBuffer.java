package com.yoti.mobile.android.commons.image;

import com.google.firebase.messaging.Constants;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DirectBuffer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B#\b\u0007\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/image/DirectBuffer;", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "Ljava/io/Serializable;", "", "dest", "", "fillData", "([B)V", "", "height", "I", "getHeight", "()I", "width", "getWidth", Constants.MessagePayloadKeys.RAW_DATA, "[B", "<init>", "(II[B)V", "Companion", "commons-image_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class DirectBuffer implements ImageBuffer, Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = 1;
    private final int height;
    public final byte[] rawData;
    private final int width;

    /* JADX INFO: compiled from: DirectBuffer.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/image/DirectBuffer$Companion;", "", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "buffer", "Lcom/yoti/mobile/android/commons/image/DirectBuffer;", "convert", "(Lcom/yoti/mobile/android/commons/image/ImageBuffer;)Lcom/yoti/mobile/android/commons/image/DirectBuffer;", "", "serialVersionUID", "J", "<init>", "()V", "commons-image_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final DirectBuffer convert(ImageBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            DirectBuffer directBuffer = (DirectBuffer) (!(buffer instanceof DirectBuffer) ? null : buffer);
            return directBuffer != null ? directBuffer : new DirectBuffer(buffer.getWidth(), buffer.getHeight(), buffer.getData());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DirectBuffer(int i, int i2) {
        this(i, i2, null, 4, null);
    }

    public DirectBuffer(int i, int i2, byte[] rawData) {
        Intrinsics.checkNotNullParameter(rawData, "rawData");
        this.width = i;
        this.height = i2;
        this.rawData = rawData;
    }

    @JvmStatic
    public static final DirectBuffer convert(ImageBuffer imageBuffer) {
        return INSTANCE.convert(imageBuffer);
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    public void fillData(byte[] dest) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        ArraysKt.copyInto$default(this.rawData, dest, 0, 0, 0, 14, (Object) null);
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

    public /* synthetic */ DirectBuffer(int i, int i2, byte[] bArr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? new byte[ImageBuffer.INSTANCE.getRequiredBufferSize(i, i2)] : bArr);
    }
}
