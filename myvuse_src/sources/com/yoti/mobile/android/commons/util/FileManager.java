package com.yoti.mobile.android.commons.util;

import android.content.Context;
import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class FileManager {
    public static final String FILES_DIR_DEFAULT = "imageTemp";

    /* JADX INFO: renamed from: a */
    private static final String f6597a = "FileManager";

    public static boolean deleteDir(File file) {
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (!deleteDir(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean deleteLocalFile(Context context, String str) {
        return deleteLocalFile(context, FILES_DIR_DEFAULT, str);
    }

    public static String getFileStoragePath(Context context, String str, String str2, String str3) {
        try {
            return new File(context.getDir(FILES_DIR_DEFAULT, 0), str).getAbsolutePath();
        } catch (Exception e) {
            C4588L.logError(str2, str3, e);
            return null;
        }
    }

    public static byte[] readByteArrayFromContentUri(Context context, String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        InputStream inputStreamOpenInputStream = null;
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(Uri.parse(str));
            while (true) {
                int i = inputStreamOpenInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e) {
                    C4588L.logWarning(f6597a, "Error closing stream", e);
                }
            }
        }
    }

    public static byte[] readByteArrayFromFile(Context context, String str) {
        return readByteArrayFromFile(context, FILES_DIR_DEFAULT, str);
    }

    public static byte[] readByteArrayFromFileThrowing(String str) throws Throwable {
        FileInputStream fileInputStream;
        File file = new File(str);
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    int i = fileInputStream.read(bArr);
                    if (i != -1) {
                        byteArrayOutputStream.write(bArr, 0, i);
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            C4588L.logWarning(f6597a, "Error closing stream", e);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            C4588L.logWarning(f6597a, "Error closing stream", e2);
                        }
                    }
                    throw th;
                }
            }
            fileInputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static <T extends Serializable> T readSerializedFromFile(String str) {
        try {
            return (T) readSerializedFromFileThrowing(str);
        } catch (FileNotFoundException e) {
            C4588L.logError(f6597a, "Missing file for read bytes", e);
            return null;
        } catch (IOException e2) {
            C4588L.logError(f6597a, "Error reading bytes", e2);
            return null;
        } catch (ClassNotFoundException e3) {
            C4588L.logError(f6597a, "Error decoding bytes", e3);
            return null;
        }
    }

    public static <T extends Serializable> T readSerializedFromFileThrowing(String str) throws Throwable {
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(new File(str)));
            try {
                T t = (T) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    C4588L.logWarning(f6597a, "Error closing stream", e);
                }
                return t;
            } catch (Throwable th) {
                th = th;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e2) {
                        C4588L.logWarning(f6597a, "Error closing stream", e2);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            objectInputStream = null;
        }
    }

    public static String saveByteArrayToFile(Context context, byte[] bArr, String str) throws IOException {
        return saveByteArrayToFile(context, bArr, FILES_DIR_DEFAULT, str);
    }

    public static String saveSerializedToFile(Context context, Serializable serializable, String str, String str2) throws Throwable {
        ObjectOutputStream objectOutputStream;
        File file = new File(context.getDir(str, 0), str2);
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            C4588L.logWarning(f6597a, "Error closing stream", e2);
        }
        try {
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
        } catch (IOException e3) {
            e = e3;
            objectOutputStream2 = objectOutputStream;
            C4588L.logError(f6597a, "Error saving bytes", e);
            if (objectOutputStream2 != null) {
                objectOutputStream2.close();
            }
            return file.getAbsolutePath();
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e4) {
                    C4588L.logWarning(f6597a, "Error closing stream", e4);
                }
            }
            throw th;
        }
        return file.getAbsolutePath();
    }

    public static boolean deleteLocalFile(Context context, String str, String str2) {
        return new File(context.getDir(str, 0), str2).delete();
    }

    public static byte[] readByteArrayFromFile(Context context, String str, String str2) {
        return readByteArrayFromFile(new File(context.getDir(str, 0), str2).getAbsolutePath());
    }

    public static String saveByteArrayToFile(Context context, byte[] bArr, String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        File file = new File(context.getDir(str, 0), str2);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            C4588L.logWarning(f6597a, "Error closing stream", e2);
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            C4588L.logError(f6597a, "Error saving bytes", e);
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            return file.getAbsolutePath();
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    C4588L.logWarning(f6597a, "Error closing stream", e4);
                }
            }
            throw th;
        }
        return file.getAbsolutePath();
    }

    public static byte[] readByteArrayFromFile(String str) {
        try {
            return readByteArrayFromFileThrowing(str);
        } catch (FileNotFoundException e) {
            C4588L.logError(f6597a, "Missing file for read bytes", e);
            return null;
        } catch (IOException e2) {
            C4588L.logError(f6597a, "Error reading bytes", e2);
            return null;
        }
    }

    public static <T extends Serializable> T readSerializedFromFile(Context context, String str, String str2) {
        return (T) readSerializedFromFile(new File(context.getDir(str, 0), str2).getAbsolutePath());
    }
}
