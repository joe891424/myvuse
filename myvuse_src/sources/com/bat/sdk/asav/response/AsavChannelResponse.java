package com.bat.sdk.asav.response;

import com.bat.sdk.asav.core.IAsavChannel;
import com.bat.sdk.asav.core.IAsavInputBucket;
import com.bat.sdk.ble.BatDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsavChannelResponse.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, m5598d2 = {"Lcom/bat/sdk/asav/response/AsavChannelResponse;", "", "channel", "Lcom/bat/sdk/asav/core/IAsavChannel;", "inputBucket", "Lcom/bat/sdk/asav/core/IAsavInputBucket;", "batDevice", "Lcom/bat/sdk/ble/BatDevice;", "<init>", "(Lcom/bat/sdk/asav/core/IAsavChannel;Lcom/bat/sdk/asav/core/IAsavInputBucket;Lcom/bat/sdk/ble/BatDevice;)V", "getChannel", "()Lcom/bat/sdk/asav/core/IAsavChannel;", "getInputBucket", "()Lcom/bat/sdk/asav/core/IAsavInputBucket;", "getBatDevice", "()Lcom/bat/sdk/ble/BatDevice;", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavChannelResponse {
    private final BatDevice batDevice;
    private final IAsavChannel channel;
    private final IAsavInputBucket inputBucket;

    public AsavChannelResponse(IAsavChannel channel, IAsavInputBucket inputBucket, BatDevice batDevice) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(inputBucket, "inputBucket");
        Intrinsics.checkNotNullParameter(batDevice, "batDevice");
        this.channel = channel;
        this.inputBucket = inputBucket;
        this.batDevice = batDevice;
    }

    public final BatDevice getBatDevice() {
        return this.batDevice;
    }

    public final IAsavChannel getChannel() {
        return this.channel;
    }

    public final IAsavInputBucket getInputBucket() {
        return this.inputBucket;
    }

    public String toString() {
        return "AsavChannelResponse(channel=" + this.channel + ", batDevice=" + this.batDevice + ')';
    }
}
