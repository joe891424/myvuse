package com.bat.sdk.asav.core;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.UIntRange;

/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m5598d2 = {"Lcom/bat/sdk/asav/core/Channels;", "Lcom/bat/sdk/asav/core/IAsavChannels;", "<init>", "()V", "challengeRequestChannel", "Lcom/bat/sdk/asav/core/Channel;", "getChallengeRequestChannel", "()Lcom/bat/sdk/asav/core/Channel;", "challengeResponseChannel", "getChallengeResponseChannel", "signatureRequestChannel", "getSignatureRequestChannel", "signatureResponseChannel", "getSignatureResponseChannel", "channelRange", "", "Lkotlin/UInt;", "ch0", "init", "", "randomChannel", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class Channels implements IAsavChannels {
    private Channel ch0;
    private final List<UInt> channelRange;

    public Channels() {
        UIntRange uIntRange = new UIntRange(1, 65526, null);
        ArrayList arrayList = new ArrayList();
        for (UInt uInt : uIntRange) {
            if (Integer.remainderUnsigned(uInt.getData(), 2) == 0) {
                arrayList.add(uInt);
            }
        }
        this.channelRange = arrayList;
    }

    @Override // com.bat.sdk.asav.core.IAsavChannels
    public Channel getChallengeRequestChannel() {
        Channel channel = this.ch0;
        if (channel != null) {
            return channel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ch0");
        return null;
    }

    @Override // com.bat.sdk.asav.core.IAsavChannels
    public Channel getChallengeResponseChannel() {
        Channel channel = this.ch0;
        if (channel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ch0");
            channel = null;
        }
        return channel.m5878plusWZ4Q5Ns(1);
    }

    @Override // com.bat.sdk.asav.core.IAsavChannels
    public Channel getSignatureRequestChannel() {
        Channel channel = this.ch0;
        if (channel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ch0");
            channel = null;
        }
        return channel.m5878plusWZ4Q5Ns(2);
    }

    @Override // com.bat.sdk.asav.core.IAsavChannels
    public Channel getSignatureResponseChannel() {
        Channel channel = this.ch0;
        if (channel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ch0");
            channel = null;
        }
        return channel.m5878plusWZ4Q5Ns(3);
    }

    @Override // com.bat.sdk.asav.core.IAsavChannels
    public void init() {
        this.ch0 = randomChannel();
        AsavLogKt.getLogger().console(ChannelsKt.TAG0, getChallengeRequestChannel(), getChallengeResponseChannel(), getSignatureRequestChannel(), getSignatureResponseChannel());
    }

    private final Channel randomChannel() {
        return new Channel(((UInt) CollectionsKt.random(this.channelRange, Random.INSTANCE)).getData(), null);
    }
}
