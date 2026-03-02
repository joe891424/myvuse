package com.microblink.fragment.overlay.components;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.microblink.hardware.camera.AutoFocusRequiredButNotSupportedException;
import com.microblink.hardware.camera.CameraResolutionTooSmallException;
import com.microblink.library.C3714R;
import com.microblink.licence.exception.LicenceLockedException;
import com.microblink.licence.exception.RemoteLicenceCheckException;
import com.microblink.recognition.FeatureNotSupportedException;
import com.microblink.recognition.RecognizerError;
import com.microblink.util.Log;
import com.microblink.view.NotSupportedReason;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class ErrorDialogFactory {

    /* JADX INFO: renamed from: com.microblink.fragment.overlay.components.ErrorDialogFactory$2 */
    /* JADX INFO: compiled from: line */
    static /* synthetic */ class C36952 {
        static final /* synthetic */ int[] llIIlIlIIl;

        static {
            int[] iArr = new int[NotSupportedReason.values().length];
            llIIlIlIIl = iArr;
            try {
                iArr[NotSupportedReason.CUSTOM_UI_FORBIDDEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                llIIlIlIIl[NotSupportedReason.INVALID_OR_MISSING_LICENSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                llIIlIlIIl[NotSupportedReason.UNSUPPORTED_ANDROID_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                llIIlIlIIl[NotSupportedReason.BLACKLISTED_DEVICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                llIIlIlIIl[NotSupportedReason.NO_CAMERA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                llIIlIlIIl[NotSupportedReason.UNSUPPORTED_PROCESSOR_ARCHITECTURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private AlertDialog llIIlIlIIl(Activity activity, final Runnable runnable, String str, String str2) {
        return new AlertDialog.Builder(activity).setTitle(str).setMessage(str2).setNeutralButton(activity.getString(C3714R.string.mb_dismiss_error_dialog), new DialogInterface.OnClickListener(this) { // from class: com.microblink.fragment.overlay.components.ErrorDialogFactory.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                runnable.run();
            }
        }).setCancelable(false).create();
    }

    public AlertDialog createErrorDialog(Activity activity, Throwable th, Runnable runnable) {
        String string;
        String string2 = activity.getString(C3714R.string.mb_warning_title);
        if (th instanceof CameraResolutionTooSmallException) {
            Log.m2710e(this, th, "Camera resolution too low!", new Object[0]);
            return llIIlIlIIl(activity, runnable, string2, activity.getString(C3714R.string.mb_feature_unsupported_device));
        }
        if (th instanceof RecognizerError) {
            Log.m2710e(this, th, "There was an error starting a native recognizer. Reason: {}", th.getMessage());
            return llIIlIlIIl(activity, runnable, string2, activity.getString(C3714R.string.mb_error_initializing));
        }
        if (th instanceof UnsatisfiedLinkError) {
            Log.m2710e(this, th, "Native library not loaded!", new Object[0]);
            return llIIlIlIIl(activity, runnable, string2, activity.getString(C3714R.string.mb_error_initializing));
        }
        if (th instanceof AutoFocusRequiredButNotSupportedException) {
            Log.m2710e(this, th, "Autofocus required, but not supported!", new Object[0]);
            return llIIlIlIIl(activity, runnable, string2, activity.getString(C3714R.string.mb_feature_unsupported_autofocus));
        }
        if (!(th instanceof FeatureNotSupportedException)) {
            if (!(th instanceof SecurityException)) {
                return th instanceof LicenceLockedException ? llIIlIlIIl(activity, runnable, "", activity.getString(C3714R.string.mb_licence_locked)) : th instanceof RemoteLicenceCheckException ? llIIlIlIIl(activity, runnable, "", activity.getString(C3714R.string.mb_licence_check_failed)) : llIIlIlIIl(activity, runnable, string2, activity.getString(C3714R.string.mb_camera_not_ready));
            }
            Log.m2710e(this, th, "Camera permission not given!", new Object[0]);
            return llIIlIlIIl(activity, runnable, string2, activity.getString(C3714R.string.mb_camera_not_allowed));
        }
        switch (C36952.llIIlIlIIl[((FeatureNotSupportedException) th).getReason().ordinal()]) {
            case 1:
                string = activity.getString(C3714R.string.mb_custom_ui_forbidden);
                break;
            case 2:
                string = activity.getString(C3714R.string.mb_invalid_license);
                break;
            case 3:
                string = activity.getString(C3714R.string.mb_feature_unsupported_android_version);
                break;
            case 4:
            case 5:
            case 6:
                string = activity.getString(C3714R.string.mb_feature_unsupported_device);
                break;
            default:
                string = null;
                break;
        }
        return llIIlIlIIl(activity, runnable, string2, string);
    }
}
