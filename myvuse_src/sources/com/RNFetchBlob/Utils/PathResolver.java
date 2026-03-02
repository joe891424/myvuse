package com.RNFetchBlob.Utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.RNFetchBlob.RNFetchBlobUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class PathResolver {
    public static String getRealPathFromURI(Context context, Uri uri) {
        String contentName;
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    return context.getExternalFilesDir(null) + "/" + strArrSplit[1];
                }
            } else {
                if (isDownloadsDocument(uri)) {
                    try {
                        String documentId = DocumentsContract.getDocumentId(uri);
                        if (documentId != null && documentId.startsWith("raw:/")) {
                            return Uri.parse(documentId).getPath();
                        }
                        return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                    } catch (Exception unused) {
                        return null;
                    }
                }
                if (isMediaDocument(uri)) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = strArrSplit2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                }
                if ("content".equalsIgnoreCase(uri.getScheme())) {
                    if (isGooglePhotosUri(uri)) {
                        return uri.getLastPathSegment();
                    }
                    return getDataColumn(context, uri, null, null);
                }
                try {
                    InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                    if (inputStreamOpenInputStream != null && (contentName = getContentName(context.getContentResolver(), uri)) != null) {
                        File file = new File(context.getCacheDir(), contentName);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        byte[] bArr = new byte[1024];
                        while (inputStreamOpenInputStream.read(bArr) > 0) {
                            fileOutputStream.write(bArr);
                        }
                        fileOutputStream.close();
                        inputStreamOpenInputStream.close();
                        return file.getAbsolutePath();
                    }
                } catch (Exception e) {
                    RNFetchBlobUtils.emitWarningEvent(e.toString());
                    return null;
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return getDataColumn(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    private static String getContentName(ContentResolver contentResolver, Uri uri) {
        Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
        cursorQuery.moveToFirst();
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        if (columnIndex < 0) {
            return null;
        }
        String string = cursorQuery.getString(columnIndex);
        cursorQuery.close();
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) throws java.lang.Throwable {
        /*
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]
            r0 = 0
            java.lang.String r7 = "_data"
            r3[r0] = r7
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            if (r8 == 0) goto L28
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3b
            if (r9 == 0) goto L28
            int r9 = r8.getColumnIndexOrThrow(r7)     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3b
            java.lang.String r0 = r8.getString(r9)     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3b
            goto L28
        L26:
            r9 = move-exception
            goto L32
        L28:
            if (r8 == 0) goto L2d
            r8.close()
        L2d:
            return r0
        L2e:
            r9 = move-exception
            goto L3d
        L30:
            r9 = move-exception
            r8 = r0
        L32:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L3b
            if (r8 == 0) goto L3a
            r8.close()
        L3a:
            return r0
        L3b:
            r9 = move-exception
            r0 = r8
        L3d:
            if (r0 == 0) goto L42
            r0.close()
        L42:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.Utils.PathResolver.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }
}
