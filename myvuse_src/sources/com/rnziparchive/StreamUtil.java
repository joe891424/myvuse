package com.rnziparchive;

import com.facebook.common.internal.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class StreamUtil {
    private static final int BUF_SIZE = 4096;

    public interface ProgressCallback {
        void onCopyProgress(long j);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, ProgressCallback progressCallback) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            long j2 = i;
            j += j2;
            if (progressCallback != null) {
                progressCallback.onCopyProgress(j2);
            }
        }
    }
}
