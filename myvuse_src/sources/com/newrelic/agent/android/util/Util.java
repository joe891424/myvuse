package com.newrelic.agent.android.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public class Util {
    private static final Random random = new Random();

    public static String sanitizeUrl(String str) {
        if (str == null) {
            return null;
        }
        try {
            URL url = new URL(str);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(url.getProtocol());
            stringBuffer.append("://");
            stringBuffer.append(url.getHost());
            if (url.getPort() != -1) {
                stringBuffer.append(":");
                stringBuffer.append(url.getPort());
            }
            stringBuffer.append(url.getPath());
            return stringBuffer.toString();
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public static Random getRandom() {
        return random;
    }
}
