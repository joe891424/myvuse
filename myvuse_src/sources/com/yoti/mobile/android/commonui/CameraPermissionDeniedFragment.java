package com.yoti.mobile.android.commonui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraPermissionDeniedFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/CameraPermissionDeniedFragment;", "Lcom/yoti/mobile/android/commonui/GenericMessageFragment;", "()V", "navigateBackOnStart", "", "launchPermissionSettings", "", "navigateBack", "onActionButtonClicked", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onStart", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class CameraPermissionDeniedFragment extends GenericMessageFragment {
    private boolean navigateBackOnStart;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.navigateBackOnStart = savedInstanceState != null ? savedInstanceState.getBoolean("KEY_NAVIGATE_BACK_ON_START") : false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("KEY_NAVIGATE_BACK_ON_START", this.navigateBackOnStart);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.navigateBackOnStart) {
            navigateBackInBackStack();
        }
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment
    public void onActionButtonClicked() {
        this.navigateBackOnStart = true;
        launchPermissionSettings();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.commonui.BaseFragment
    public void navigateBack() {
        finishSdk();
    }

    private final void launchPermissionSettings() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + requireContext().getPackageName()));
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }
}
