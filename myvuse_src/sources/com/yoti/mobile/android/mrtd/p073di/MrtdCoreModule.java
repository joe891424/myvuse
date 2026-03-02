package com.yoti.mobile.android.mrtd.p073di;

import android.content.Context;
import android.nfc.NfcAdapter;
import com.yoti.mobile.android.mrtd.data.NfcStateRepository;
import com.yoti.mobile.android.mrtd.domain.INfcDispatcher;
import com.yoti.mobile.android.mrtd.domain.INfcStateRepository;
import com.yoti.mobile.android.mrtd.domain.INfcTagProcessor;
import com.yoti.mobile.android.mrtd.domain.NfcDispatcher;
import com.yoti.mobile.android.mrtd.domain.NfcTagProcessor;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0011¢\u0006\u0002\b\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0011¢\u0006\u0002\b\u0014¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/di/MrtdCoreModule;", "", "()V", "provideNfcAdapter", "Landroid/nfc/NfcAdapter;", "context", "Landroid/content/Context;", "provideNfcDispatcher", "Lcom/yoti/mobile/android/mrtd/domain/INfcDispatcher;", "dispatcher", "Lcom/yoti/mobile/android/mrtd/domain/NfcDispatcher;", "provideNfcDispatcher$mrtd_productionRelease", "provideNfcRepository", "Lcom/yoti/mobile/android/mrtd/domain/INfcStateRepository;", "actual", "Lcom/yoti/mobile/android/mrtd/data/NfcStateRepository;", "providesNfcTagProcessor", "Lcom/yoti/mobile/android/mrtd/domain/INfcTagProcessor;", "processor", "Lcom/yoti/mobile/android/mrtd/domain/NfcTagProcessor;", "providesNfcTagProcessor$mrtd_productionRelease", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class MrtdCoreModule {
    @Provides
    public NfcAdapter provideNfcAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return NfcAdapter.getDefaultAdapter(context);
    }

    @Provides
    public INfcDispatcher provideNfcDispatcher$mrtd_productionRelease(NfcDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        return dispatcher;
    }

    @Provides
    public INfcStateRepository provideNfcRepository(NfcStateRepository actual) {
        Intrinsics.checkNotNullParameter(actual, "actual");
        return actual;
    }

    @Provides
    public INfcTagProcessor providesNfcTagProcessor$mrtd_productionRelease(NfcTagProcessor processor) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        return processor;
    }
}
