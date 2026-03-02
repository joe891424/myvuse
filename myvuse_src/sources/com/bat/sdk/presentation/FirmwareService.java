package com.bat.sdk.presentation;

import android.app.Activity;
import kotlin.Metadata;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: compiled from: FirmwareService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0012\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0007H\u0014¨\u0006\t"}, m5598d2 = {"Lcom/bat/sdk/presentation/FirmwareService;", "Lno/nordicsemi/android/dfu/DfuBaseService;", "<init>", "()V", "isDebug", "", "getNotificationTarget", "Ljava/lang/Class;", "Landroid/app/Activity;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class FirmwareService extends DfuBaseService {
    @Override // no.nordicsemi.android.dfu.DfuBaseService
    protected Class<? extends Activity> getNotificationTarget() {
        return null;
    }

    @Override // no.nordicsemi.android.dfu.DfuBaseService
    protected boolean isDebug() {
        return true;
    }
}
