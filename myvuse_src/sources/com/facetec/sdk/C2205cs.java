package com.facetec.sdk;

import android.view.ViewConfiguration;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: renamed from: com.facetec.sdk.cs */
/* JADX INFO: loaded from: classes3.dex */
final class C2205cs extends Thread {

    /* JADX INFO: renamed from: B */
    private static int f3117B = 1;
    private static int Code = 0;

    /* JADX INFO: renamed from: V */
    private static long f3118V = -1448913474082955810L;

    /* JADX INFO: renamed from: I */
    private final BufferedReader f3119I;

    /* JADX INFO: renamed from: Z */
    private final StringBuilder f3120Z = new StringBuilder();

    public C2205cs(InputStream inputStream) {
        this.f3119I = new BufferedReader(new InputStreamReader(inputStream));
    }

    /* JADX INFO: renamed from: Z */
    public final String m2043Z() {
        int i = Code + 3;
        f3117B = i % 128;
        int i2 = i % 2;
        String string = this.f3120Z.toString();
        int i3 = Code + 85;
        f3117B = i3 % 128;
        int i4 = i3 % 2;
        return string;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                String line = this.f3119I.readLine();
                if (line == null) {
                    this.f3119I.close();
                    return;
                }
                this.f3120Z.append(new StringBuilder().append(line).append(Code("쐪쐠硄ퟟ㞙", ViewConfiguration.getScrollBarSize() >> 8)).toString());
                int i = f3117B + 53;
                Code = i % 128;
                int i2 = i % 2;
            } catch (IOException unused) {
                return;
            }
        }
    }

    private static String Code(String str, int i) {
        String str2;
        char[] charArray = str.toCharArray();
        synchronized (C2194ch.Code) {
            char[] cArrCode = C2194ch.Code(f3118V, charArray, i);
            C2194ch.f3035V = 4;
            while (C2194ch.f3035V < cArrCode.length) {
                C2194ch.f3034I = C2194ch.f3035V - 4;
                cArrCode[C2194ch.f3035V] = (char) (((long) (cArrCode[C2194ch.f3035V] ^ cArrCode[C2194ch.f3035V % 4])) ^ (((long) C2194ch.f3034I) * f3118V));
                C2194ch.f3035V++;
            }
            str2 = new String(cArrCode, 4, cArrCode.length - 4);
        }
        return str2;
    }
}
