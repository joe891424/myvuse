package androidx.camera.core.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class CameraValidator {
    private static final String TAG = "CameraValidator";

    private CameraValidator() {
    }

    public static void validateCameras(Context context, CameraRepository cameraRepository) throws CameraIdListIncorrectException {
        PackageManager packageManager = context.getPackageManager();
        Logger.m1137d(TAG, "Verifying camera lens facing on " + Build.DEVICE);
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera")) {
                CameraSelector.DEFAULT_BACK_CAMERA.select(cameraRepository.getCameras());
            }
            if (packageManager.hasSystemFeature("android.hardware.camera.front")) {
                CameraSelector.DEFAULT_FRONT_CAMERA.select(cameraRepository.getCameras());
            }
        } catch (IllegalArgumentException e) {
            Logger.m1139e(TAG, "Camera LensFacing verification failed, existing cameras: " + cameraRepository.getCameras());
            throw new CameraIdListIncorrectException("Expected camera missing from device.", e);
        }
    }

    public static class CameraIdListIncorrectException extends Exception {
        public CameraIdListIncorrectException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
