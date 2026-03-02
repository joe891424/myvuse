package com.yoti.mobile.android.mrtd;

import androidx.fragment.app.Fragment;
import com.yoti.mobile.android.mrtd.domain.model.BacCredential;
import com.yoti.mobile.android.mrtd.view.MrtdFeatureConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/MrtdCaptureLauncher;", "", "authData", "Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;", "(Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;)V", "start", "", "fragment", "Landroidx/fragment/app/Fragment;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdCaptureLauncher {
    private final BacCredential authData;

    public MrtdCaptureLauncher(BacCredential authData) {
        Intrinsics.checkNotNullParameter(authData, "authData");
        this.authData = authData;
    }

    public final void start(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        MrtdCaptureSession.INSTANCE.getInstance().start(new MrtdFeatureConfiguration(this.authData), fragment, 1003);
    }
}
