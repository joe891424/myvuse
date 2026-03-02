package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.documentcapture.p055id.data.INfcPassportCountriesDataSource;
import com.yoti.mobile.android.documentcapture.p055id.data.NfcPassportCountriesRepository;
import com.yoti.mobile.android.documentcapture.p055id.data.local.NfcPassportCountriesLocalDataSource;
import com.yoti.mobile.android.documentcapture.p055id.domain.INfcPassportCountriesRepository;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH'¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/di/NfcPassportCountriesModule;", "", "()V", "bindNfcPassportCountriesDataSource", "Lcom/yoti/mobile/android/documentcapture/id/data/INfcPassportCountriesDataSource;", "actual", "Lcom/yoti/mobile/android/documentcapture/id/data/local/NfcPassportCountriesLocalDataSource;", "bindNfcPassportCountriesRepository", "Lcom/yoti/mobile/android/documentcapture/id/domain/INfcPassportCountriesRepository;", "Lcom/yoti/mobile/android/documentcapture/id/data/NfcPassportCountriesRepository;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public abstract class NfcPassportCountriesModule {
    @Binds
    public abstract INfcPassportCountriesDataSource bindNfcPassportCountriesDataSource(NfcPassportCountriesLocalDataSource actual);

    @Binds
    public abstract INfcPassportCountriesRepository bindNfcPassportCountriesRepository(NfcPassportCountriesRepository actual);
}
