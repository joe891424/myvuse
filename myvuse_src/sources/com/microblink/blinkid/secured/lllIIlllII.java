package com.microblink.blinkid.secured;

import java.util.Stack;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lllIIlllII {
    private static Stack<Long> llIIlIlIIl = new Stack<>();

    public static void IlIllIlIIl() {
        llIIlIlIIl.push(Long.valueOf(System.currentTimeMillis()));
    }

    public static long llIIlIlIIl() {
        if (llIIlIlIIl.isEmpty()) {
            return -1L;
        }
        return System.currentTimeMillis() - llIIlIlIIl.pop().longValue();
    }
}
