package com.microblink.image.highres;

import android.os.Parcelable;
import com.microblink.blinkid.secured.IIlIIIllIl;
import com.microblink.blinkid.secured.IIllIllIII;
import com.microblink.blinkid.secured.IllIIlIIII;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.image.Image;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface HighResImageWrapper extends Parcelable {

    /* JADX INFO: compiled from: line */
    public static final class Factory {
        public static HighResImageWrapper createFromFrame(IIllIllIII iIllIllIII, Orientation orientation) {
            if (orientation == null || orientation == Orientation.ORIENTATION_UNKNOWN) {
                throw new IllegalArgumentException("Image orientation cannot be null nor unknown");
            }
            if (iIllIllIII instanceof IIlIIIllIl) {
                IIlIIIllIl iIlIIIllIl = (IIlIIIllIl) iIllIllIII;
                int format = iIlIIIllIl.llIIlIlIIl.getFormat();
                if (format == 35) {
                    return new YuvHighResImageWrapper(iIlIIIllIl, orientation);
                }
                if (format == 256) {
                    ByteBuffer buffer = iIlIIIllIl.llIIlIlIIl.getPlanes()[0].getBuffer();
                    byte[] bArr = new byte[buffer.capacity()];
                    buffer.get(bArr);
                    return new JpegHighResImageWrapper(bArr, orientation);
                }
            } else if (iIllIllIII instanceof IllIIlIIII) {
                return new JpegHighResImageWrapper(((IllIIlIIII) iIllIllIII).llIIlIIlll(), orientation);
            }
            throw new IllegalArgumentException("Camera image must be in YUV_420_888 or JPEG format. Other formats are not supported!");
        }
    }

    void dispose();

    Image getImage();

    void saveToFile(File file) throws IOException;
}
