package com.salesforce.marketingcloud.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import net.lingala.zip4j.util.InternalZipConstants;
import org.jose4j.lang.StringUtil;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.util.g */
/* JADX INFO: loaded from: classes6.dex */
public final class C4388g {

    /* JADX INFO: renamed from: a */
    public static final Charset f5803a = Charset.forName(StringUtil.US_ASCII);

    /* JADX INFO: renamed from: b */
    public static final Charset f5804b = Charset.forName(InternalZipConstants.AES_HASH_CHARSET);

    /* JADX INFO: renamed from: c */
    public static final Charset f5805c = Charset.forName("UTF-8");

    private C4388g() {
    }

    /* JADX INFO: renamed from: a */
    public static void m4312a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4318b(File file) {
        try {
            file.delete();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4314a(File file, OutputStream outputStream) throws IOException {
        m4316a(new FileInputStream(file), outputStream);
    }

    /* JADX INFO: renamed from: a */
    public static void m4315a(InputStream inputStream, File file) throws IOException {
        m4316a(inputStream, new FileOutputStream(file));
    }

    /* JADX INFO: renamed from: a */
    public static void m4316a(InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (-1 == i) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, i);
            }
        } finally {
            m4312a((Closeable) inputStream);
            m4312a(outputStream);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4313a(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                m4313a(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m4311a(Reader reader) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int i = reader.read(cArr);
                if (i == -1) {
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, i);
            }
        } finally {
            reader.close();
        }
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m4317a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m4316a(inputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        m4312a(byteArrayOutputStream);
        return byteArray;
    }
}
