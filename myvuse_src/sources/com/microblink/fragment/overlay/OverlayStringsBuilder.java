package com.microblink.fragment.overlay;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class OverlayStringsBuilder<Self, Key> {
    private Map<Key, String> IlIllIlIIl = new HashMap();
    private Context llIIlIlIIl;

    public OverlayStringsBuilder(Context context) {
        this.llIIlIlIIl = context;
    }

    protected abstract Self llIIlIlIIl();

    protected String llIIlIlIIl(int i) {
        return this.llIIlIlIIl.getString(i);
    }

    protected String llIIlIlIIl(Key key) {
        return this.IlIllIlIIl.get(key);
    }

    protected Self llIIlIlIIl(Key key, String str) {
        if (str != null) {
            this.IlIllIlIIl.put(key, str);
        }
        return llIIlIlIIl();
    }
}
