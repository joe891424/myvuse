package com.newrelic.agent.android.util;

import android.content.Context;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class ComposeChecker {
    public static boolean isComposeUsed(Context context) {
        try {
            Iterator it2 = Arrays.asList("androidx.compose.ui.platform.ComposeView", "androidx.compose.runtime.Composable").iterator();
            while (it2.hasNext()) {
                context.getClassLoader().loadClass((String) it2.next());
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
