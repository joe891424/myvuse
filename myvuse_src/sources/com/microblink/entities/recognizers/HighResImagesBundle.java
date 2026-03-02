package com.microblink.entities.recognizers;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.image.highres.HighResImageWrapper;
import com.microblink.intent.BaseIntentTransferable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class HighResImagesBundle extends BaseIntentTransferable<HighResImagesBundle> {
    public static final Parcelable.Creator<HighResImagesBundle> CREATOR = new Parcelable.Creator<HighResImagesBundle>() { // from class: com.microblink.entities.recognizers.HighResImagesBundle.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HighResImagesBundle createFromParcel(Parcel parcel) {
            return new HighResImagesBundle(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HighResImagesBundle[] newArray(int i) {
            return new HighResImagesBundle[i];
        }
    };
    private List<HighResImageWrapper> IlIllIlIIl;

    @Override // com.microblink.intent.BaseIntentTransferable
    protected String IlIllIlIIl() {
        return "com.microblink.intent.constants.HighResImages.id";
    }

    public void addImage(HighResImageWrapper highResImageWrapper) {
        this.IlIllIlIIl.add(highResImageWrapper);
    }

    public void clearImages() {
        this.IlIllIlIIl.clear();
    }

    public List<HighResImageWrapper> getImages() {
        return this.IlIllIlIIl;
    }

    @Override // com.microblink.intent.BaseIntentTransferable
    protected void llIIlIlIIl(BaseIntentTransferable baseIntentTransferable) {
        this.IlIllIlIIl = ((HighResImagesBundle) baseIntentTransferable).IlIllIlIIl;
    }

    @Override // com.microblink.intent.BaseIntentTransferable, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelableArray((HighResImageWrapper[]) this.IlIllIlIIl.toArray(new HighResImageWrapper[0]), i);
    }

    public HighResImagesBundle() {
        this.IlIllIlIIl = new ArrayList();
    }

    @Override // com.microblink.intent.BaseIntentTransferable
    protected Parcelable.Creator<? extends HighResImagesBundle> llIIlIlIIl() {
        return CREATOR;
    }

    public HighResImagesBundle(Intent intent) {
        this.IlIllIlIIl = new ArrayList();
        loadFromIntent(intent);
    }

    @Override // com.microblink.intent.BaseIntentTransferable
    protected void llIIlIlIIl(Parcel parcel) {
        super.llIIlIlIIl(parcel);
        Parcelable[] parcelableArray = parcel.readParcelableArray(HighResImageWrapper.class.getClassLoader());
        this.IlIllIlIIl = new ArrayList();
        for (Parcelable parcelable : parcelableArray) {
            this.IlIllIlIIl.add((HighResImageWrapper) parcelable);
        }
    }

    private HighResImagesBundle(Parcel parcel) {
        this.IlIllIlIIl = new ArrayList();
        llIIlIlIIl(parcel);
    }
}
