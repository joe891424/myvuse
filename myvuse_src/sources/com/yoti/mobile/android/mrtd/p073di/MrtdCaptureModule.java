package com.yoti.mobile.android.mrtd.p073di;

import android.content.Context;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.yoti.mobile.android.mrtd.data.NfcPlatformController;
import com.yoti.mobile.android.mrtd.domain.INfcReadController;
import com.yoti.mobile.android.mrtd.domain.model.BacCredential;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication;
import com.yoti.mobile.mpp.mrtddump.auth.MrtdAuthentication;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0017J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0017J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/di/MrtdCaptureModule;", "", "authData", "Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;", "(Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;)V", "provideAuthData", "provideAuthenticator", "Lcom/yoti/mobile/mpp/mrtddump/auth/MrtdAuthentication;", "credential", "provideBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "context", "Landroid/content/Context;", "provideNfcController", "Lcom/yoti/mobile/android/mrtd/domain/INfcReadController;", "actual", "Lcom/yoti/mobile/android/mrtd/data/NfcPlatformController;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class MrtdCaptureModule {
    private final BacCredential authData;

    public MrtdCaptureModule(BacCredential authData) {
        Intrinsics.checkNotNullParameter(authData, "authData");
        this.authData = authData;
    }

    @Provides
    @Singleton
    /* JADX INFO: renamed from: provideAuthData, reason: from getter */
    public BacCredential getAuthData() {
        return this.authData;
    }

    @Provides
    public MrtdAuthentication provideAuthenticator(BacCredential credential) {
        Intrinsics.checkNotNullParameter(credential, "credential");
        return BacAuthentication.INSTANCE.create(credential.getDateOfBirth(), credential.getDateOfExpiry(), credential.getDocumentNumber());
    }

    @Provides
    public LocalBroadcastManager provideBroadcastManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(localBroadcastManager, "getInstance(context)");
        return localBroadcastManager;
    }

    @Provides
    public INfcReadController provideNfcController(NfcPlatformController actual) {
        Intrinsics.checkNotNullParameter(actual, "actual");
        return actual;
    }
}
