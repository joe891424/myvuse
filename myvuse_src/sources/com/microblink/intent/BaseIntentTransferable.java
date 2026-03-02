package com.microblink.intent;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkid.secured.lllIIlIlII;
import com.microblink.intent.BaseIntentTransferable;
import java.util.UUID;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseIntentTransferable<T extends BaseIntentTransferable<T>> implements MBIntentTransferable {
    private String llIIlIlIIl;

    private String llIIlIlIIl(Intent intent) {
        String stringExtra = intent.getStringExtra(IlIllIlIIl());
        if (stringExtra == null) {
            return null;
        }
        String str = this.llIIlIlIIl;
        if (str == null || stringExtra.equals(str)) {
            return stringExtra;
        }
        return null;
    }

    protected abstract String IlIllIlIIl();

    @Override // com.microblink.intent.MBIntentTransferable
    public void clearSavedState() {
        String str = this.llIIlIlIIl;
        if (str != null) {
            lllIIlIlII.llIIlIlIIl(str);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.microblink.intent.MBIntentTransferable
    public final boolean existsInIntent(Intent intent) {
        return llIIlIlIIl(intent) != null;
    }

    protected abstract Parcelable.Creator<? extends T> llIIlIlIIl();

    protected abstract void llIIlIlIIl(T t);

    @Override // com.microblink.intent.MBIntentTransferable
    public final void loadFromIntent(Intent intent) {
        String strLlIIlIlIIl = llIIlIlIIl(intent);
        if (strLlIIlIlIIl == null) {
            throw new IllegalStateException("Expected intent transferable object does not exist in the intent!");
        }
        BaseIntentTransferable baseIntentTransferable = (BaseIntentTransferable) lllIIlIlII.llIIlIlIIl(intent, strLlIIlIlIIl, llIIlIlIIl());
        if (baseIntentTransferable == null) {
            throw new IllegalStateException("Intent transferable object cannot be loaded.");
        }
        this.llIIlIlIIl = baseIntentTransferable.llIIlIlIIl;
        llIIlIlIIl(baseIntentTransferable);
    }

    @Override // com.microblink.intent.MBIntentTransferable
    public void saveState() {
        String str = this.llIIlIlIIl;
        if (str != null) {
            lllIIlIlII.llIIlIlIIl(str, this);
        }
    }

    @Override // com.microblink.intent.MBIntentTransferable
    public void saveToIntent(Intent intent) {
        if (this.llIIlIlIIl == null) {
            this.llIIlIlIIl = UUID.randomUUID().toString();
        }
        intent.putExtra(IlIllIlIIl(), this.llIIlIlIIl);
        lllIIlIlII.llIIlIlIIl(intent, this.llIIlIlIIl, this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.llIIlIlIIl);
    }

    protected void llIIlIlIIl(Parcel parcel) {
        this.llIIlIlIIl = parcel.readString();
    }
}
