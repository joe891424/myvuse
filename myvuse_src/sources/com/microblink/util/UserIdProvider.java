package com.microblink.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class UserIdProvider {
    public static String getUserId(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.microblink.ping.preferences", 0);
        String string = sharedPreferences.getString("com.microblink.ping.preferences.userId", null);
        if (string != null) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        sharedPreferences.edit().putString("com.microblink.ping.preferences.userId", string2).apply();
        return string2;
    }
}
