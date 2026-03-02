package com.yoti.mobile.android.mrtd.domain;

import android.nfc.Tag;
import kotlin.Metadata;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/domain/INfcTagProcessor;", "", "onTagDetected", "", HeaderParameterNames.AUTHENTICATION_TAG, "Landroid/nfc/Tag;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface INfcTagProcessor {
    void onTagDetected(Tag tag);
}
