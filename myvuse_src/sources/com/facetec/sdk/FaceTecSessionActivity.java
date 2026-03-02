package com.facetec.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class FaceTecSessionActivity extends AbstractActivityC2219g {

    /* JADX INFO: renamed from: C */
    static FaceTecIDScanProcessor f2243C;
    static FaceTecFaceScanProcessor Code;

    @Override // com.facetec.sdk.AbstractActivityC2219g, android.app.Activity
    public final /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h, android.app.Activity, android.content.ComponentCallbacks
    public final /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.facetec.sdk.AbstractActivityC2219g
    public final /* bridge */ /* synthetic */ void onFlashButtonPressed(View view) {
        super.onFlashButtonPressed(view);
    }

    @Override // com.facetec.sdk.AbstractActivityC2219g, android.app.Activity
    public final /* bridge */ /* synthetic */ void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.facetec.sdk.AbstractActivityC2219g, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public final /* bridge */ /* synthetic */ void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.facetec.sdk.AbstractActivityC2219g, com.facetec.sdk.AbstractActivityC2220h, android.app.Activity, android.view.Window.Callback
    public final /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public static void createAndLaunchSession(Context context, FaceTecFaceScanProcessor faceTecFaceScanProcessor) {
        createAndLaunchSession(context, faceTecFaceScanProcessor, null, "");
    }

    public static void createAndLaunchSession(Context context, FaceTecFaceScanProcessor faceTecFaceScanProcessor, String str) {
        createAndLaunchSession(context, faceTecFaceScanProcessor, null, str);
    }

    public static void createAndLaunchSession(Context context, FaceTecFaceScanProcessor faceTecFaceScanProcessor, FaceTecIDScanProcessor faceTecIDScanProcessor) {
        createAndLaunchSession(context, faceTecFaceScanProcessor, faceTecIDScanProcessor, "");
    }

    public static void createAndLaunchSession(Context context, FaceTecFaceScanProcessor faceTecFaceScanProcessor, FaceTecIDScanProcessor faceTecIDScanProcessor, String str) {
        Intent intent = new Intent(context, (Class<?>) FaceTecSessionActivity.class);
        if (str != null) {
            intent.putExtra("zoom.serverSessionToken", str);
        }
        C2221j.Code(context);
        Code = faceTecFaceScanProcessor;
        f2243C = faceTecIDScanProcessor;
        ((Activity) context).startActivityForResult(intent, 1002);
    }

    public static FaceTecSessionResult getSessionResultFromActivityResult(Intent intent) {
        if (intent != null) {
            return (FaceTecSessionResult) intent.getParcelableExtra(FaceTecSDK.EXTRA_SESSION_RESULTS);
        }
        return null;
    }

    public static FaceTecIDScanResult getIDScanResultFromActivityResult(Intent intent) {
        if (intent != null) {
            return (FaceTecIDScanResult) intent.getParcelableExtra(FaceTecSDK.EXTRA_ID_SCAN_RESULTS);
        }
        return null;
    }
}
