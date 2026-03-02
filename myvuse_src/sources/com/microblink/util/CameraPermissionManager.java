package com.microblink.util;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.microblink.blinkid.secured.IIllIllIIl;
import com.microblink.blinkid.secured.llIIllllIl;
import com.microblink.library.C3714R;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class CameraPermissionManager {
    private IllIIIllII llIIlIlIIl;
    private View IlIllIlIIl = null;
    private boolean IllIIIllII = false;
    private View.OnClickListener llIIIlllll = new llIIlIlIIl();
    private View.OnClickListener IllIIIIllI = new IlIllIlIIl();

    /* JADX INFO: compiled from: line */
    class IlIllIlIIl implements View.OnClickListener {

        /* JADX INFO: compiled from: line */
        class llIIlIlIIl implements DialogInterface.OnClickListener {
            final /* synthetic */ boolean llIIlIlIIl;

            llIIlIlIIl(boolean z) {
                this.llIIlIlIIl = z;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                CameraPermissionManager.this.IlIllIlIIl.setVisibility(8);
                if (this.llIIlIlIIl) {
                    return;
                }
                CameraPermissionManager.this.llIIlIlIIl.llIIlIlIIl().startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(IIllIllIIl.llIIlIlIIl("package:").append(CameraPermissionManager.this.llIIlIlIIl.llIIlIlIIl().getPackageName()).toString())));
            }
        }

        IlIllIlIIl() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context contextLlIIlIlIIl = CameraPermissionManager.this.llIIlIlIIl.llIIlIlIIl();
            AlertDialog.Builder builder = new AlertDialog.Builder(contextLlIIlIlIIl);
            boolean zLlIIlIlIIl = CameraPermissionManager.llIIlIlIIl(CameraPermissionManager.this, contextLlIIlIlIIl);
            builder.setCancelable(false).setTitle(C3714R.string.mb_warning_title).setMessage(zLlIIlIlIIl ? C3714R.string.mb_enable_permission_help_instant_app : C3714R.string.mb_enable_permission_help).setNeutralButton(R.string.ok, new llIIlIlIIl(zLlIIlIlIIl)).create().show();
        }
    }

    /* JADX INFO: compiled from: line */
    private static final class IllIIIllII {
        private Fragment IlIllIlIIl;
        private androidx.fragment.app.Fragment IllIIIllII;
        private Context llIIIlllll;
        private Activity llIIlIlIIl;

        IllIIIllII(Activity activity) {
            this.llIIlIlIIl = activity;
            this.llIIIlllll = activity;
        }

        boolean IlIllIlIIl(String str) {
            Fragment fragment = this.IlIllIlIIl;
            if (fragment != null) {
                return fragment.shouldShowRequestPermissionRationale(str);
            }
            Activity activity = this.llIIlIlIIl;
            if (activity != null) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
            androidx.fragment.app.Fragment fragment2 = this.IllIIIllII;
            return fragment2 != null && fragment2.shouldShowRequestPermissionRationale(str);
        }

        Context llIIlIlIIl() {
            return this.llIIIlllll;
        }

        final int llIIlIlIIl(String str) {
            Fragment fragment = this.IlIllIlIIl;
            if (fragment != null) {
                return fragment.getActivity().checkSelfPermission(str);
            }
            Activity activity = this.llIIlIlIIl;
            if (activity != null) {
                return activity.checkSelfPermission(str);
            }
            androidx.fragment.app.Fragment fragment2 = this.IllIIIllII;
            if (fragment2 != null) {
                return fragment2.getActivity().checkSelfPermission(str);
            }
            return -1;
        }

        IllIIIllII(Fragment fragment) {
            this.IlIllIlIIl = fragment;
            this.llIIIlllll = fragment.getActivity();
        }

        IllIIIllII(androidx.fragment.app.Fragment fragment) {
            this.IllIIIllII = fragment;
            this.llIIIlllll = fragment.getContext();
        }

        final void llIIlIlIIl(String[] strArr, int i) {
            Fragment fragment = this.IlIllIlIIl;
            if (fragment != null) {
                fragment.requestPermissions(strArr, i);
            }
            Activity activity = this.llIIlIlIIl;
            if (activity != null) {
                activity.requestPermissions(strArr, i);
            }
            androidx.fragment.app.Fragment fragment2 = this.IllIIIllII;
            if (fragment2 != null) {
                fragment2.requestPermissions(strArr, i);
            }
        }

        SharedPreferences llIIlIlIIl(String str, int i) {
            Fragment fragment = this.IlIllIlIIl;
            if (fragment != null) {
                return fragment.getActivity().getSharedPreferences(str, i);
            }
            Activity activity = this.llIIlIlIIl;
            if (activity != null) {
                return activity.getSharedPreferences(str, i);
            }
            androidx.fragment.app.Fragment fragment2 = this.IllIIIllII;
            if (fragment2 != null) {
                return fragment2.getActivity().getSharedPreferences(str, i);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements View.OnClickListener {
        llIIlIlIIl() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraPermissionManager.this.llIIlIlIIl();
        }
    }

    public CameraPermissionManager(Activity activity) {
        this.llIIlIlIIl = new IllIIIllII(activity);
        llIIlIlIIl(activity.getLayoutInflater());
    }

    public void askForCameraPermission() {
        if (hasCameraPermission()) {
            View view = this.IlIllIlIIl;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        View viewFindViewById = this.IlIllIlIIl.findViewById(C3714R.id.camera_ask_permission_button);
        if (this.llIIlIlIIl.IlIllIlIIl("android.permission.CAMERA")) {
            this.IlIllIlIIl.setVisibility(0);
            viewFindViewById.setOnClickListener(this.llIIIlllll);
        } else if (this.llIIlIlIIl.llIIlIlIIl("CameraPermissionManager.prefs", 0).getBoolean("DeniedPermission", false)) {
            this.IlIllIlIIl.setVisibility(0);
            viewFindViewById.setOnClickListener(this.IllIIIIllI);
        } else {
            this.IlIllIlIIl.setVisibility(8);
            llIIlIlIIl();
        }
    }

    public View getAskPermissionOverlay() {
        return this.IlIllIlIIl;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.IllIIIllII = false;
        if (i != 69) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= strArr.length) {
                break;
            }
            if (!strArr[i2].equals("android.permission.CAMERA")) {
                i2++;
            } else if (iArr[i2] == 0) {
                llIIlIlIIl(false);
                this.IlIllIlIIl.setVisibility(8);
                return;
            }
        }
        llIIlIlIIl(true);
        this.IlIllIlIIl.setVisibility(0);
        View viewFindViewById = this.IlIllIlIIl.findViewById(C3714R.id.camera_ask_permission_button);
        if (this.llIIlIlIIl.IlIllIlIIl("android.permission.CAMERA")) {
            viewFindViewById.setOnClickListener(this.llIIIlllll);
        } else {
            viewFindViewById.setOnClickListener(this.IllIIIIllI);
        }
    }

    public void onResume() {
        if (hasCameraPermission()) {
            llIIlIlIIl(false);
        }
    }

    static boolean llIIlIlIIl(CameraPermissionManager cameraPermissionManager, Context context) {
        cameraPermissionManager.getClass();
        return context.getApplicationContext().getPackageManager().isInstantApp();
    }

    public boolean hasCameraPermission() {
        return this.llIIlIlIIl.llIIlIlIIl("android.permission.CAMERA") == 0;
    }

    private void llIIlIlIIl(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(llIIllllIl.IlIllIlIIl, (ViewGroup) null);
        this.IlIllIlIIl = viewInflate;
        viewInflate.setVisibility(8);
    }

    private void llIIlIlIIl(boolean z) {
        SharedPreferences.Editor editorEdit = this.llIIlIlIIl.llIIlIlIIl("CameraPermissionManager.prefs", 0).edit();
        editorEdit.putBoolean("DeniedPermission", z);
        editorEdit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void llIIlIlIIl() {
        if (this.IllIIIllII) {
            return;
        }
        this.llIIlIlIIl.llIIlIlIIl(new String[]{"android.permission.CAMERA"}, 69);
        this.IllIIIllII = true;
    }

    public CameraPermissionManager(Fragment fragment) {
        this.llIIlIlIIl = new IllIIIllII(fragment);
        llIIlIlIIl(fragment.getActivity().getLayoutInflater());
    }

    public CameraPermissionManager(androidx.fragment.app.Fragment fragment) {
        this.llIIlIlIIl = new IllIIIllII(fragment);
        llIIlIlIIl(fragment.getLayoutInflater());
    }
}
