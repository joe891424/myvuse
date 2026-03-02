package com.bat.sdk.asav.handlers;

import com.bat.sdk.asav.core.AsavInvalidInputBucketException;
import com.bat.sdk.asav.core.IAsavChannel;
import com.bat.sdk.asav.core.IAsavContext;
import com.bat.sdk.asav.response.AsavChannelResponse;
import com.bat.sdk.ble.BatDevice;
import com.bat.sdk.logging.Logger;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsavResponseAssembler.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/asav/handlers/AsavResponseAssembler;", "", "asavContext", "Lcom/bat/sdk/asav/core/IAsavContext;", "channel", "Lcom/bat/sdk/asav/core/IAsavChannel;", "<init>", "(Lcom/bat/sdk/asav/core/IAsavContext;Lcom/bat/sdk/asav/core/IAsavChannel;)V", "channelResponse", "Lcom/bat/sdk/asav/response/AsavChannelResponse;", "assemble", "data", "", "batDevice", "Lcom/bat/sdk/ble/BatDevice;", "reset", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavResponseAssembler {
    private final IAsavContext asavContext;
    private final IAsavChannel channel;
    private AsavChannelResponse channelResponse;

    public AsavResponseAssembler(IAsavContext asavContext, IAsavChannel channel) {
        Intrinsics.checkNotNullParameter(asavContext, "asavContext");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.asavContext = asavContext;
        this.channel = channel;
    }

    public final AsavChannelResponse assemble(String data, BatDevice batDevice) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(batDevice, "batDevice");
        try {
            Logger logger = Logger.INSTANCE;
            String str = AsavResponseAssemblerKt.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            logger.log(str, "assemble  channelResponse:" + this.channelResponse);
            AsavChannelResponse asavChannelResponse = this.channelResponse;
            if (asavChannelResponse != null) {
                if (Intrinsics.areEqual(batDevice.getAddress(), asavChannelResponse.getBatDevice().getAddress())) {
                    this.channel.addToBucket(data, asavChannelResponse.getInputBucket());
                    return asavChannelResponse;
                }
                Logger logger2 = Logger.INSTANCE;
                String str2 = AsavResponseAssemblerKt.TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                logger2.log(str2, "assemble batDevice.address NOT EQUAL to response.batDevice.address, " + batDevice.getAddress() + ", " + asavChannelResponse.getBatDevice().getAddress());
                return asavChannelResponse;
            }
            AsavResponseAssembler asavResponseAssembler = this;
            this.channelResponse = new AsavChannelResponse(this.channel, this.channel.newInputBucket(data), batDevice);
            Logger logger3 = Logger.INSTANCE;
            String str3 = AsavResponseAssemblerKt.TAG;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            StringBuilder sb = new StringBuilder("assemble channelResponse ");
            AsavChannelResponse asavChannelResponse2 = this.channelResponse;
            StringBuilder sbAppend = sb.append(asavChannelResponse2 != null ? asavChannelResponse2.getChannel() : null).append(',');
            AsavChannelResponse asavChannelResponse3 = this.channelResponse;
            StringBuilder sbAppend2 = sbAppend.append(asavChannelResponse3 != null ? asavChannelResponse3.getInputBucket() : null).append(',');
            AsavChannelResponse asavChannelResponse4 = this.channelResponse;
            logger3.log(str3, sbAppend2.append(asavChannelResponse4 != null ? asavChannelResponse4.getBatDevice() : null).append(SafeJsonPrimitive.NULL_CHAR).toString());
            return this.channelResponse;
        } catch (AsavInvalidInputBucketException unused) {
            Logger logger4 = Logger.INSTANCE;
            String str4 = AsavResponseAssemblerKt.TAG;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            logger4.log(str4, "assemble AsavInvalidInputBucketException");
            return this.channelResponse;
        } catch (Exception e) {
            Logger logger5 = Logger.INSTANCE;
            String str5 = AsavResponseAssemblerKt.TAG;
            Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$p(...)");
            logger5.log(str5, "assemble Exception " + e.getMessage());
            return this.channelResponse;
        }
    }

    public final void reset() {
        this.channelResponse = null;
    }
}
