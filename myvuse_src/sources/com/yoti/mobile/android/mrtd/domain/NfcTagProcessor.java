package com.yoti.mobile.android.mrtd.domain;

import android.content.Intent;
import android.nfc.Tag;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/domain/NfcTagProcessor;", "Lcom/yoti/mobile/android/mrtd/domain/INfcTagProcessor;", "broadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "(Landroidx/localbroadcastmanager/content/LocalBroadcastManager;)V", "onTagDetected", "", HeaderParameterNames.AUTHENTICATION_TAG, "Landroid/nfc/Tag;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NfcTagProcessor implements INfcTagProcessor {
    private final LocalBroadcastManager broadcastManager;

    @Inject
    public NfcTagProcessor(LocalBroadcastManager broadcastManager) {
        Intrinsics.checkNotNullParameter(broadcastManager, "broadcastManager");
        this.broadcastManager = broadcastManager;
    }

    @Override // com.yoti.mobile.android.mrtd.domain.INfcTagProcessor
    public void onTagDetected(Tag tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intent intent = new Intent(NfcBroadcastDefsKt.NFC_BROADCAST_ACTION);
        intent.putExtra(NfcBroadcastDefsKt.NFC_BROADCAST_INTENT_EXTRA, tag);
        this.broadcastManager.sendBroadcast(intent);
    }
}
