package com.yoti.mobile.android.mrtd.domain;

import com.yoti.mobile.android.mrtd.domain.model.MrtdReadState;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/domain/INfcReadController;", "", "getReaderListener", "Lkotlinx/coroutines/flow/Flow;", "Lcom/yoti/mobile/android/mrtd/domain/model/MrtdReadState;", "registerForReadBroadcasts", "", "unregisterForReadBroadcasts", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface INfcReadController {
    Flow<MrtdReadState> getReaderListener();

    void registerForReadBroadcasts();

    void unregisterForReadBroadcasts();
}
