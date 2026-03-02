package com.qualtrics.digital;

import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public class SamplingUtil {
    public static boolean checkSampling(Double d) {
        return d.doubleValue() == 100.0d || new Random().nextDouble() * 100.0d <= d.doubleValue();
    }
}
