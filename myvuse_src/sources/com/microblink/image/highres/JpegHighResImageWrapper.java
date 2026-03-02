package com.microblink.image.highres;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class JpegHighResImageWrapper implements HighResImageWrapper {
    public static final Parcelable.Creator<JpegHighResImageWrapper> CREATOR = new Parcelable.Creator<JpegHighResImageWrapper>() { // from class: com.microblink.image.highres.JpegHighResImageWrapper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public JpegHighResImageWrapper createFromParcel(Parcel parcel) {
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            return new JpegHighResImageWrapper(bArr, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public JpegHighResImageWrapper[] newArray(int i) {
            return new JpegHighResImageWrapper[i];
        }
    };
    private byte[] IlIllIlIIl;
    private int IllIIIllII;
    private boolean llIIIlllll;
    private Image llIIlIlIIl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.microblink.image.highres.HighResImageWrapper
    public void dispose() {
        if (this.llIIIlllll) {
            return;
        }
        this.llIIIlllll = true;
        Image image = this.llIIlIlIIl;
        if (image != null) {
            image.dispose();
            this.llIIlIlIIl = null;
        }
        this.IlIllIlIIl = null;
    }

    @Override // com.microblink.image.highres.HighResImageWrapper
    public Image getImage() {
        if (this.llIIIlllll) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        if (this.llIIlIlIIl == null) {
            this.llIIlIlIIl = ImageBuilder.buildImageFromJpegBytes(this.IlIllIlIIl, this.IllIIIllII);
        }
        return this.llIIlIlIIl;
    }

    @Override // com.microblink.image.highres.HighResImageWrapper
    public void saveToFile(File file) throws IOException {
        if (this.llIIIlllll) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        FileChannel channel = new FileOutputStream(file, false).getChannel();
        channel.write(ByteBuffer.wrap(this.IlIllIlIIl));
        channel.close();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.llIIIlllll) {
            return;
        }
        parcel.writeInt(this.IlIllIlIIl.length);
        parcel.writeByteArray(this.IlIllIlIIl);
        parcel.writeInt(this.IllIIIllII);
    }

    JpegHighResImageWrapper(byte[] bArr, Orientation orientation) {
        this(bArr, orientation.intValue());
    }

    private JpegHighResImageWrapper(byte[] bArr, int i) {
        this.llIIIlllll = false;
        this.IlIllIlIIl = bArr;
        this.IllIIIllII = i;
    }
}
