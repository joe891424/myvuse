package com.yoti.mobile.android.commons.image;

import android.graphics.ImageFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: ImageBuffer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "", "", "getData", "()[B", "dest", "", "fillData", "([B)V", "", "getHeight", "()I", "height", "getWidth", "width", "Companion", "commons-image_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public interface ImageBuffer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.f6508a;

    /* JADX INFO: compiled from: ImageBuffer.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/image/ImageBuffer$Companion;", "", "", "width", "height", "getRequiredBufferSize", "(II)I", "<init>", "()V", "commons-image_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final class Companion {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ Companion f6508a = new Companion();

        private Companion() {
        }

        @JvmStatic
        public final int getRequiredBufferSize(int width, int height) {
            return ((width * height) * ImageFormat.getBitsPerPixel(17)) / 8;
        }
    }

    /* JADX INFO: compiled from: ImageBuffer.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static byte[] getData(ImageBuffer imageBuffer) {
            byte[] bArr = new byte[ImageBuffer.INSTANCE.getRequiredBufferSize(imageBuffer.getWidth(), imageBuffer.getHeight())];
            imageBuffer.fillData(bArr);
            return bArr;
        }
    }

    @JvmStatic
    static int getRequiredBufferSize(int i, int i2) {
        return INSTANCE.getRequiredBufferSize(i, i2);
    }

    void fillData(byte[] dest);

    byte[] getData();

    int getHeight();

    int getWidth();
}
