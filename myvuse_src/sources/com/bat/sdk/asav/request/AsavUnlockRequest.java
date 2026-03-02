package com.bat.sdk.asav.request;

import com.bat.sdk.asav.core.IAsavChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsavUnlockRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/asav/request/AsavUnlockRequest;", "Lcom/bat/sdk/asav/request/AsavChannelRequest;", "channel", "Lcom/bat/sdk/asav/core/IAsavChannel;", "<init>", "(Lcom/bat/sdk/asav/core/IAsavChannel;)V", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavUnlockRequest extends AsavChannelRequest {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsavUnlockRequest(IAsavChannel channel) {
        super(channel, channel.unlockAckBucket());
        Intrinsics.checkNotNullParameter(channel, "channel");
    }

    public String toString() {
        return "AsavUnlockRequest(channel=" + getChannel() + ", count=" + getCount() + ')';
    }
}
