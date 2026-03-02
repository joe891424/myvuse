package com.microblink.image.highres;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkid.secured.IIlIIIllIl;
import com.microblink.geometry.Rectangle;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class YuvHighResImageWrapper implements HighResImageWrapper {
    public static final Parcelable.Creator<YuvHighResImageWrapper> CREATOR = new Parcelable.Creator<YuvHighResImageWrapper>() { // from class: com.microblink.image.highres.YuvHighResImageWrapper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public YuvHighResImageWrapper createFromParcel(Parcel parcel) {
            return new YuvHighResImageWrapper((Image) parcel.readParcelable(Image.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public YuvHighResImageWrapper[] newArray(int i) {
            return new YuvHighResImageWrapper[i];
        }
    };
    private boolean IlIllIlIIl;
    private Image llIIlIlIIl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.microblink.image.highres.HighResImageWrapper
    public void dispose() {
        if (this.IlIllIlIIl) {
            return;
        }
        this.IlIllIlIIl = true;
        Image image = this.llIIlIlIIl;
        if (image != null) {
            image.dispose();
            this.llIIlIlIIl = null;
        }
    }

    @Override // com.microblink.image.highres.HighResImageWrapper
    public Image getImage() {
        if (this.IlIllIlIIl) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        return this.llIIlIlIIl;
    }

    @Override // com.microblink.image.highres.HighResImageWrapper
    public void saveToFile(File file) throws IOException {
        if (this.IlIllIlIIl) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        Bitmap bitmapConvertToBitmap = this.llIIlIlIIl.convertToBitmap();
        if (bitmapConvertToBitmap != null) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmapConvertToBitmap.compress(Bitmap.CompressFormat.JPEG, 95, fileOutputStream);
            fileOutputStream.close();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Image image;
        if (this.IlIllIlIIl || (image = this.llIIlIlIIl) == null) {
            return;
        }
        parcel.writeParcelable(image, i);
    }

    YuvHighResImageWrapper(IIlIIIllIl iIlIIIllIl, Orientation orientation) {
        this.IlIllIlIIl = false;
        this.llIIlIlIIl = ImageBuilder.buildImageFromCamera2Image(iIlIIIllIl.llIIlIlIIl, orientation, Rectangle.getDefaultROI()).m6356clone();
    }

    private YuvHighResImageWrapper(Image image) {
        this.IlIllIlIIl = false;
        this.llIIlIlIIl = image;
    }
}
