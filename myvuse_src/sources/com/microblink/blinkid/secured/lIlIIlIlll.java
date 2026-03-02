package com.microblink.blinkid.secured;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class lIlIIlIlll {
    private SharedPreferences llIIlIlIIl;

    public lIlIIlIlll(Context context, String str) {
        this.llIIlIlIIl = context.getSharedPreferences(str, 0);
    }

    protected long IlIllIlIIl(String str) {
        return this.llIIlIlIIl.getLong(str, 0L);
    }

    protected String IllIIIllII(String str) {
        return this.llIIlIlIIl.getString(str, null);
    }

    protected void llIIIlllll(String str) {
        this.llIIlIlIIl.edit().remove(str).apply();
    }

    protected void llIIlIlIIl(String str, String str2) {
        this.llIIlIlIIl.edit().putString(str, str2).apply();
    }

    protected void llIIlIlIIl(String str, long j) {
        this.llIIlIlIIl.edit().putLong(str, j).apply();
    }

    protected void llIIlIlIIl(String str, Boolean bool) {
        this.llIIlIlIIl.edit().putBoolean(str, bool.booleanValue()).apply();
    }

    protected Boolean llIIlIlIIl(String str) {
        return Boolean.valueOf(this.llIIlIlIIl.getBoolean(str, false));
    }
}
