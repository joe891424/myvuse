package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.HuaweiMediaStoreLocationValidationQuirk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
class ImageSaveLocationValidator {
    private static final String TAG = "SaveLocationValidator";

    private ImageSaveLocationValidator() {
    }

    static boolean isValid(final ImageCapture.OutputFileOptions outputFileOptions) {
        if (isSaveToFile(outputFileOptions)) {
            return canSaveToFile(outputFileOptions.getFile());
        }
        if (!isSaveToMediaStore(outputFileOptions)) {
            return true;
        }
        HuaweiMediaStoreLocationValidationQuirk huaweiMediaStoreLocationValidationQuirk = (HuaweiMediaStoreLocationValidationQuirk) DeviceQuirks.get(HuaweiMediaStoreLocationValidationQuirk.class);
        if (huaweiMediaStoreLocationValidationQuirk != null) {
            return huaweiMediaStoreLocationValidationQuirk.canSaveToMediaStore();
        }
        return canSaveToMediaStore(outputFileOptions.getContentResolver(), outputFileOptions.getSaveCollection(), outputFileOptions.getContentValues());
    }

    private static boolean isSaveToFile(final ImageCapture.OutputFileOptions outputFileOptions) {
        return outputFileOptions.getFile() != null;
    }

    private static boolean isSaveToMediaStore(final ImageCapture.OutputFileOptions outputFileOptions) {
        return (outputFileOptions.getSaveCollection() == null || outputFileOptions.getContentResolver() == null || outputFileOptions.getContentValues() == null) ? false : true;
    }

    private static boolean canSaveToFile(final File file) {
        try {
            new FileOutputStream(file).close();
            return true;
        } catch (IOException e) {
            Logger.m1140e(TAG, "Failed to open a write stream to " + file.toString(), e);
            return false;
        }
    }

    private static boolean canSaveToMediaStore(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        try {
            Uri uriInsert = contentResolver.insert(uri, contentValues);
            if (uriInsert == null) {
                return false;
            }
            try {
                try {
                    OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
                    boolean z = outputStreamOpenOutputStream != null;
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                    }
                    return z;
                } catch (IOException e) {
                    Logger.m1140e(TAG, "Failed to open a write stream to" + uriInsert.toString(), e);
                    try {
                        contentResolver.delete(uriInsert, null, null);
                    } catch (IllegalArgumentException e2) {
                        Logger.m1140e(TAG, "Failed to delete inserted row at " + uriInsert.toString(), e2);
                    }
                    return false;
                }
            } finally {
                try {
                    contentResolver.delete(uriInsert, null, null);
                } catch (IllegalArgumentException e3) {
                    Logger.m1140e(TAG, "Failed to delete inserted row at " + uriInsert.toString(), e3);
                }
            }
        } catch (IllegalArgumentException e4) {
            Logger.m1140e(TAG, "Failed to insert into " + uri.toString(), e4);
            return false;
        }
    }
}
