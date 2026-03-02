package com.newrelic.agent.android.util;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes6.dex */
public class Deflator {
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public static byte[] deflate(byte[] bArr) {
        Deflater deflater = new Deflater();
        try {
            deflater.setInput(bArr);
            deflater.finish();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr2 = new byte[8192];
                    while (!deflater.finished()) {
                        int iDeflate = deflater.deflate(bArr2);
                        if (iDeflate <= 0) {
                            log.error("HTTP request contains an incomplete payload");
                        }
                        byteArrayOutputStream.write(bArr2, 0, iDeflate);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException unused) {
                return bArr;
            }
        } finally {
            deflater.end();
        }
    }
}
