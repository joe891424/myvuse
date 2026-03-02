package com.yoti.mobile.android.mrtd.data;

import com.yoti.mobile.mpp.mrtddump.MrtdReader;
import com.yoti.mobile.mpp.mrtddump.p095io.NfcController;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/data/MrtdReaderFactory;", "", "()V", "create", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReader;", "controller", "Lcom/yoti/mobile/mpp/mrtddump/io/NfcController;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdReaderFactory {
    @Inject
    public MrtdReaderFactory() {
    }

    public final MrtdReader create(NfcController controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        return new MrtdReader(controller);
    }
}
