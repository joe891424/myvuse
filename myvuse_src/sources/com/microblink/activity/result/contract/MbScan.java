package com.microblink.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import com.microblink.activity.result.ScanResult;
import com.microblink.uisettings.UISettings;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes2.dex */
public class MbScan extends ActivityResultContract<UISettings, ScanResult> {
    public static final String EXTRA_SCAN_EXCEPTION = "com.microblink.scanexception";

    @Override // androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, UISettings uISettings) {
        Intent intent = new Intent(context, uISettings.getTargetActivity());
        uISettings.saveToIntent(intent);
        return intent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    public ScanResult parseResult(int i, Intent intent) {
        if (intent == null) {
            return new ScanResult(ScanResult.ResultStatus.CANCELLED, null, null);
        }
        if (i == -1) {
            return new ScanResult(ScanResult.ResultStatus.FINISHED, intent, null);
        }
        Throwable th = (Throwable) intent.getSerializableExtra("com.microblink.scanexception");
        return th != null ? new ScanResult(ScanResult.ResultStatus.EXCEPTION, null, th) : new ScanResult(ScanResult.ResultStatus.CANCELLED, null, null);
    }
}
