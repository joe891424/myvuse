package com.yoti.mobile.android.mrtd.data;

import com.yoti.mobile.mpp.mrtddump.MrtdReader;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/data/ReaderQueueFactory;", "", "()V", "create", "Lkotlinx/coroutines/channels/Channel;", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReader;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ReaderQueueFactory {
    @Inject
    public ReaderQueueFactory() {
    }

    public final Channel<MrtdReader> create() {
        return ChannelKt.Channel$default(-1, null, null, 6, null);
    }
}
