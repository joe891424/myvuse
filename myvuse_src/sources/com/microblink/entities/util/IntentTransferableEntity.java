package com.microblink.entities.util;

import android.content.Intent;
import android.os.Parcel;
import com.microblink.entities.Entity;
import com.microblink.intent.BaseIntentTransferable;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IntentTransferableEntity<E extends Entity> extends BaseIntentTransferable<IntentTransferableEntity<E>> {
    private E IlIllIlIIl;

    public IntentTransferableEntity(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Entity must not be null!");
        }
        this.IlIllIlIIl = e;
    }

    @Override // com.microblink.intent.BaseIntentTransferable
    protected void llIIlIlIIl(BaseIntentTransferable baseIntentTransferable) {
        IntentTransferableEntity intentTransferableEntity = (IntentTransferableEntity) baseIntentTransferable;
        E e = this.IlIllIlIIl;
        if (e == null) {
            this.IlIllIlIIl = intentTransferableEntity.IlIllIlIIl;
        } else {
            e.consumeResultFrom(intentTransferableEntity.IlIllIlIIl);
        }
    }

    @Override // com.microblink.intent.BaseIntentTransferable, com.microblink.intent.MBIntentTransferable
    public void saveToIntent(Intent intent) {
        if (this.IlIllIlIIl == null) {
            throw new IllegalStateException("Unable to save wrapper without entity!");
        }
        super.saveToIntent(intent);
    }

    @Override // com.microblink.intent.BaseIntentTransferable, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        E e = this.IlIllIlIIl;
        if (e == null) {
            throw new IllegalStateException("Unable to parcelize wrapper without entity!");
        }
        parcel.writeParcelable(e, i);
        super.writeToParcel(parcel, i);
    }

    protected IntentTransferableEntity() {
    }
}
