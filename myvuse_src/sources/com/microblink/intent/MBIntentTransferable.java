package com.microblink.intent;

import android.content.Intent;
import android.os.Parcelable;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface MBIntentTransferable extends Parcelable {
    void clearSavedState();

    boolean existsInIntent(Intent intent);

    void loadFromIntent(Intent intent);

    void saveState();

    void saveToIntent(Intent intent);
}
