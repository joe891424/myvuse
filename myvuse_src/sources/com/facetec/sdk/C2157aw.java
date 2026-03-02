package com.facetec.sdk;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facetec.sdk.aw */
/* JADX INFO: loaded from: classes3.dex */
final class C2157aw {

    /* JADX INFO: renamed from: B */
    private static Resources f2659B;

    /* JADX INFO: renamed from: V */
    private static HashMap<Integer, String> f2660V;

    C2157aw() {
    }

    /* JADX INFO: renamed from: Z */
    static void m1785Z(Activity activity) {
        if (f2659B == null) {
            f2659B = activity.getApplicationContext().getResources();
        }
    }

    /* JADX INFO: renamed from: I */
    static String m1784I(int i) {
        if (i == 0) {
            return "";
        }
        HashMap<Integer, String> map = f2660V;
        String str = map != null ? map.get(Integer.valueOf(i)) : null;
        return str != null ? str : f2659B.getString(i);
    }

    static void Code(TextView textView, int i) {
        if (textView == null) {
            return;
        }
        textView.setText(m1784I(i));
    }

    /* JADX INFO: renamed from: Z */
    static synchronized void m1786Z(Map<Integer, String> map) {
        f2660V = new HashMap<>(map);
    }
}
