package com.newrelic.agent.android.payload;

import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.Streams;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes6.dex */
public class FileBackedPayload extends Payload {
    boolean isCompressed;

    public FileBackedPayload(File file) {
        super(file.getAbsolutePath().getBytes(StandardCharsets.UTF_8));
        this.isCompressed = false;
        this.uuid = file.getAbsolutePath();
        if (file.exists()) {
            this.timestamp = file.lastModified();
            this.isPersistable = file.canWrite();
            this.isCompressed = isCompressed(file);
        }
    }

    @Override // com.newrelic.agent.android.payload.Payload
    public byte[] getBytes() {
        try {
            File filePayloadFile = payloadFile();
            if (filePayloadFile.exists()) {
                return Streams.readAllBytes(filePayloadFile);
            }
        } catch (IOException e) {
            AgentLogManager.getAgentLog().error("FileBackedPayload: failed to read payload. " + String.valueOf(e));
        }
        return "".getBytes(StandardCharsets.UTF_8);
    }

    protected File payloadFile() {
        return new File(this.uuid);
    }

    @Override // com.newrelic.agent.android.payload.Payload
    public void putBytes(byte[] bArr) {
        if (isPersisted()) {
            try {
                BufferedWriter bufferedWriterNewBufferedFileWriter = Streams.newBufferedFileWriter(payloadFile());
                try {
                    bufferedWriterNewBufferedFileWriter.write(new String(bArr, StandardCharsets.UTF_8));
                    bufferedWriterNewBufferedFileWriter.flush();
                    if (bufferedWriterNewBufferedFileWriter != null) {
                        bufferedWriterNewBufferedFileWriter.close();
                        return;
                    }
                    return;
                } finally {
                }
            } catch (IOException e) {
                AgentLogManager.getAgentLog().error("FileBackedPayload: failed to write payload to backing file." + String.valueOf(e));
                return;
            }
        }
        super.putBytes(bArr);
    }

    @Override // com.newrelic.agent.android.payload.Payload
    public long getTimestamp() {
        return payloadFile().lastModified();
    }

    @Override // com.newrelic.agent.android.payload.Payload
    public void setPersisted(boolean z) {
        if (z) {
            return;
        }
        payloadFile().delete();
    }

    @Override // com.newrelic.agent.android.payload.Payload
    public long size() {
        File filePayloadFile = payloadFile();
        if (filePayloadFile.exists()) {
            return filePayloadFile.length();
        }
        return 0L;
    }

    public File compress(boolean z) throws IOException {
        return compress(payloadFile(), z);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.File compress(java.io.File r7, boolean r8) throws java.io.IOException {
        /*
            r6 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r7.getAbsolutePath()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r2 = ".gz"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r7)
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L64
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L64
            java.util.zip.GZIPOutputStream r3 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L5a
            r4 = 65536(0x10000, float:9.1835E-41)
            r5 = 1
            r3.<init>(r2, r4, r5)     // Catch: java.lang.Throwable -> L5a
            com.newrelic.agent.android.util.Streams.copy(r1, r3)     // Catch: java.lang.Throwable -> L50
            r3.flush()     // Catch: java.lang.Throwable -> L50
            if (r8 == 0) goto L45
            boolean r8 = r7.delete()     // Catch: java.lang.Throwable -> L50
            if (r8 == 0) goto L45
            r6.isCompressed = r5     // Catch: java.lang.Throwable -> L50
            boolean r8 = r0.renameTo(r7)     // Catch: java.lang.Throwable -> L50
            if (r8 == 0) goto L45
            goto L46
        L45:
            r7 = r0
        L46:
            r3.close()     // Catch: java.lang.Throwable -> L5a
            r2.close()     // Catch: java.lang.Throwable -> L64
            r1.close()
            return r7
        L50:
            r7 = move-exception
            r3.close()     // Catch: java.lang.Throwable -> L55
            goto L59
        L55:
            r8 = move-exception
            r7.addSuppressed(r8)     // Catch: java.lang.Throwable -> L5a
        L59:
            throw r7     // Catch: java.lang.Throwable -> L5a
        L5a:
            r7 = move-exception
            r2.close()     // Catch: java.lang.Throwable -> L5f
            goto L63
        L5f:
            r8 = move-exception
            r7.addSuppressed(r8)     // Catch: java.lang.Throwable -> L64
        L63:
            throw r7     // Catch: java.lang.Throwable -> L64
        L64:
            r7 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> L69
            goto L6d
        L69:
            r8 = move-exception
            r7.addSuppressed(r8)
        L6d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.payload.FileBackedPayload.compress(java.io.File, boolean):java.io.File");
    }

    public boolean isCompressed() {
        return this.isCompressed;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isCompressed(java.io.File r4) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L2c
            r1.<init>(r4)     // Catch: java.lang.Exception -> L2c
            r4 = 10
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L22
            r2 = 9
            r1.read(r4, r0, r2)     // Catch: java.lang.Throwable -> L22
            r2 = r4[r0]     // Catch: java.lang.Throwable -> L22
            r3 = 31
            if (r2 != r3) goto L1d
            r2 = 1
            r4 = r4[r2]     // Catch: java.lang.Throwable -> L22
            r3 = -117(0xffffffffffffff8b, float:NaN)
            if (r4 != r3) goto L1d
            goto L1e
        L1d:
            r2 = r0
        L1e:
            r1.close()     // Catch: java.lang.Exception -> L2c
            return r2
        L22:
            r4 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> L27
            goto L2b
        L27:
            r1 = move-exception
            r4.addSuppressed(r1)     // Catch: java.lang.Exception -> L2c
        L2b:
            throw r4     // Catch: java.lang.Exception -> L2c
        L2c:
            r4 = move-exception
            com.newrelic.agent.android.logging.AgentLog r1 = com.newrelic.agent.android.logging.AgentLogManager.getAgentLog()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "FileBackedPayload: isCompressed() - "
            r2.<init>(r3)
            java.lang.StringBuilder r4 = r2.append(r4)
            java.lang.String r4 = r4.toString()
            r1.error(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.payload.FileBackedPayload.isCompressed(java.io.File):boolean");
    }
}
