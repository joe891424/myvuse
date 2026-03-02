package com.facetec.sdk;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: renamed from: com.facetec.sdk.o */
/* JADX INFO: loaded from: classes3.dex */
final class C2225o {
    C2225o() {
    }

    private static byte[] Code(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return m2275Z(fileInputStream);
        } finally {
            fileInputStream.close();
        }
    }

    /* JADX INFO: renamed from: V */
    static byte[] m2271V(Context context, String str) throws Exception {
        FileInputStream fileInputStreamOpenFileInput = context.openFileInput(str);
        try {
            return m2275Z(fileInputStreamOpenFileInput);
        } finally {
            fileInputStreamOpenFileInput.close();
        }
    }

    /* JADX INFO: renamed from: Z */
    private static byte[] m2275Z(FileInputStream fileInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[(int) fileInputStream.getChannel().size()];
        while (fileInputStream.available() > 0) {
            byteArrayOutputStream.write(bArr, 0, fileInputStream.read(bArr));
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: renamed from: Z */
    static void m2273Z(Context context, String str, byte[] bArr) throws IOException {
        FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
        fileOutputStreamOpenFileOutput.write(bArr);
        fileOutputStreamOpenFileOutput.close();
    }

    /* JADX INFO: renamed from: Z */
    static void m2274Z(File file, byte[] bArr, byte[] bArr2) throws Exception {
        byte[] bArrM1797B = new C2159ay(bArr).m1797B(bArr2);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            try {
                fileOutputStream.write(bArrM1797B);
            } catch (IOException e) {
                throw e;
            }
        } finally {
            fileOutputStream.close();
        }
    }

    /* JADX INFO: renamed from: B */
    static byte[] m2270B(File file, byte[] bArr) throws Exception {
        return new C2159ay(bArr).m1798I(Code(file));
    }

    /* JADX INFO: renamed from: V */
    static byte[] m2272V(Context context, String str, byte[] bArr) throws Exception {
        return new C2159ay(bArr).m1798I(m2271V(context, str));
    }
}
