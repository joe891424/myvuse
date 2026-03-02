package com.bat.sdk.asav.request;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bat.sdk.asav.core.IAsavChannel;
import com.bat.sdk.asav.core.IAsavOutputBucket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: compiled from: AsavChannelRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/asav/request/AsavChannelRequest;", "", "channel", "Lcom/bat/sdk/asav/core/IAsavChannel;", "outputBucket", "Lcom/bat/sdk/asav/core/IAsavOutputBucket;", "<init>", "(Lcom/bat/sdk/asav/core/IAsavChannel;Lcom/bat/sdk/asav/core/IAsavOutputBucket;)V", "getChannel", "()Lcom/bat/sdk/asav/core/IAsavChannel;", NewHtcHomeBadger.COUNT, "", "getCount", "()I", "nextChunk", "", TypedValues.CycleType.S_WAVE_OFFSET, "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class AsavChannelRequest {
    private final IAsavChannel channel;
    private final int count;
    private final IAsavOutputBucket outputBucket;

    public AsavChannelRequest(IAsavChannel channel, IAsavOutputBucket outputBucket) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(outputBucket, "outputBucket");
        this.channel = channel;
        this.outputBucket = outputBucket;
        this.count = outputBucket.count();
    }

    public final IAsavChannel getChannel() {
        return this.channel;
    }

    public final int getCount() {
        return this.count;
    }

    public final String nextChunk(int offset) {
        int i = this.count;
        return this.channel.toUUID(offset % i, i, this.outputBucket);
    }
}
