package com.bat.sdk.asav.request;

import com.bat.sdk.asav.core.IAsavChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: AsavSignatureRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\n"}, m5598d2 = {"Lcom/bat/sdk/asav/request/AsavSignatureRequest;", "Lcom/bat/sdk/asav/request/AsavChannelRequest;", "channel", "Lcom/bat/sdk/asav/core/IAsavChannel;", "signature", "", "<init>", "(Lcom/bat/sdk/asav/core/IAsavChannel;Ljava/lang/String;)V", "toString", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavSignatureRequest extends AsavChannelRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Reflection.getOrCreateKotlinClass(AsavSignatureRequest.class).getSimpleName();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsavSignatureRequest(IAsavChannel channel, String signature) {
        super(channel, channel.newOutputBucket(signature));
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(signature, "signature");
    }

    /* JADX INFO: compiled from: AsavSignatureRequest.kt */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/asav/request/AsavSignatureRequest$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return AsavSignatureRequest.TAG;
        }
    }

    public String toString() {
        return "AsavSignatureRequest(channel=" + getChannel() + ", count=" + getCount() + ')';
    }
}
