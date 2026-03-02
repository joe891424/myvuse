package com.yoti.mobile.android.mrtd.data;

import android.nfc.NfcAdapter;
import com.yoti.mobile.android.mrtd.domain.INfcStateRepository;
import com.yoti.mobile.android.mrtd.domain.model.NfcState;
import javax.inject.Inject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/data/NfcStateRepository;", "Lcom/yoti/mobile/android/mrtd/domain/INfcStateRepository;", "nfcAdapter", "Landroid/nfc/NfcAdapter;", "(Landroid/nfc/NfcAdapter;)V", "state", "Lcom/yoti/mobile/android/mrtd/domain/model/NfcState;", "getState", "()Lcom/yoti/mobile/android/mrtd/domain/model/NfcState;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NfcStateRepository implements INfcStateRepository {
    private final NfcAdapter nfcAdapter;

    @Inject
    public NfcStateRepository(NfcAdapter nfcAdapter) {
        this.nfcAdapter = nfcAdapter;
    }

    @Override // com.yoti.mobile.android.mrtd.domain.INfcStateRepository
    public NfcState getState() {
        NfcAdapter nfcAdapter = this.nfcAdapter;
        if (nfcAdapter != null) {
            NfcState nfcState = nfcAdapter.isEnabled() ? NfcState.ACTIVE : NfcState.DISABLED;
            if (nfcState != null) {
                return nfcState;
            }
        }
        return NfcState.NONE;
    }
}
