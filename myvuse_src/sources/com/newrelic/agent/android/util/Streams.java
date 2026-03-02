package com.newrelic.agent.android.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes6.dex */
public class Streams {
    public static final int DEFAULT_BUFFER_SIZE = 65536;

    static /* synthetic */ boolean lambda$list$1(File file) {
        return true;
    }

    static /* synthetic */ boolean lambda$list$2(File file) {
        return false;
    }

    private Streams() {
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copy(inputStream, outputStream, 65536, false);
    }

    public static int copy(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        return copy(inputStream, outputStream, 65536, z);
    }

    public static int copy(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        return copy(inputStream, outputStream, i, false);
    }

    public static int copy(InputStream inputStream, OutputStream outputStream, int i, boolean z) throws IOException {
        try {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (true) {
                int i3 = inputStream.read(bArr);
                if (-1 == i3) {
                    break;
                }
                outputStream.write(bArr, 0, i3);
                i2 += i3;
            }
            return i2;
        } finally {
            if (z) {
                inputStream.close();
                outputStream.close();
            }
        }
    }

    public static byte[] slurpBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            copy(inputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
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
    }

    public static String slurpString(InputStream inputStream) throws IOException {
        return slurpString(inputStream, StandardCharsets.UTF_8.name());
    }

    public static String slurpString(InputStream inputStream, String str) throws IOException {
        try {
            try {
                byte[] bArrSlurpBytes = slurpBytes(inputStream);
                if (str == null || str.isEmpty()) {
                    str = StandardCharsets.UTF_8.name();
                }
                return new String(bArrSlurpBytes, str);
            } catch (Exception e) {
                e.printStackTrace();
                inputStream.close();
                return "";
            }
        } finally {
            inputStream.close();
        }
    }

    public static String slurpString(File file, String str) throws IOException {
        return slurpString(new FileInputStream(file), str);
    }

    public static String[] readAllLines(File file) throws IOException {
        String[] strArr = new String[0];
        BufferedReader bufferedReaderNewBufferedFileReader = newBufferedFileReader(file);
        try {
            String[] strArr2 = (String[]) bufferedReaderNewBufferedFileReader.lines().map(new Function() { // from class: com.newrelic.agent.android.util.Streams$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((String) obj).toString();
                }
            }).toArray(new IntFunction() { // from class: com.newrelic.agent.android.util.Streams$$ExternalSyntheticLambda1
                @Override // java.util.function.IntFunction
                public final Object apply(int i) {
                    return Streams.lambda$readAllLines$0(i);
                }
            });
            if (bufferedReaderNewBufferedFileReader != null) {
                bufferedReaderNewBufferedFileReader.close();
            }
            return strArr2;
        } catch (Throwable th) {
            if (bufferedReaderNewBufferedFileReader != null) {
                try {
                    bufferedReaderNewBufferedFileReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    static /* synthetic */ String[] lambda$readAllLines$0(int i) {
        return new String[i];
    }

    public static Stream<String> lines(File file) throws IOException {
        return new BufferedReader(new FileReader(file)).lines();
    }

    public static byte[] readAllBytes(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        byte[] bArrSlurpBytes = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    bArrSlurpBytes = slurpBytes(fileInputStream);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                fileInputStream2.close();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2.close();
            throw th;
        }
        fileInputStream.close();
        return bArrSlurpBytes;
    }

    public static BufferedReader newBufferedFileReader(File file) throws IOException {
        return new BufferedReader(new FileReader(file));
    }

    public static BufferedWriter newBufferedFileWriter(File file) throws IOException {
        return new BufferedWriter(new FileWriter(file));
    }

    public static Stream<File> list(File file) throws IllegalArgumentException {
        return list(file, new FileFilter() { // from class: com.newrelic.agent.android.util.Streams$$ExternalSyntheticLambda2
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return Streams.lambda$list$1(file2);
            }
        });
    }

    public static Stream<File> list(File file, FileFilter fileFilter) throws IllegalArgumentException {
        if (file == null) {
            throw new IllegalArgumentException("Invalid file argument: file is null");
        }
        if (!file.exists()) {
            throw new IllegalArgumentException("Invalid file argument: file does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Invalid file argument: file is not a directory");
        }
        if (fileFilter == null) {
            fileFilter = new FileFilter() { // from class: com.newrelic.agent.android.util.Streams$$ExternalSyntheticLambda3
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    return Streams.lambda$list$2(file2);
                }
            };
        }
        return Arrays.stream(file.listFiles(fileFilter));
    }
}
