package com.bat.sdk.asav.handlers;

import com.bat.sdk.asav.core.AsavStatus;
import com.bat.sdk.asav.core.IAsavContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsavHandlersExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\b"}, m5598d2 = {"challengeRequestAdvertiser", "Lcom/bat/sdk/asav/handlers/IAsavRequestAdvertiser;", "asavContext", "Lcom/bat/sdk/asav/core/IAsavContext;", "challengeResponseDiscoverer", "Lcom/bat/sdk/asav/handlers/IAsavResponseDiscoverer;", "signatureRequestAdvertiser", "signatureResponseDiscoverer", "sdk_release"}, m5599k = 2, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavHandlersExtensionsKt {
    public static final IAsavRequestAdvertiser challengeRequestAdvertiser(IAsavContext asavContext) {
        Intrinsics.checkNotNullParameter(asavContext, "asavContext");
        return new AsavBaseAdvertiser(asavContext, AsavStatus.ChallengeRequest.INSTANCE, AsavStatus.ChallengeResponse.INSTANCE);
    }

    public static final IAsavResponseDiscoverer challengeResponseDiscoverer(IAsavContext asavContext) {
        Intrinsics.checkNotNullParameter(asavContext, "asavContext");
        return new AsavBaseDiscoverer(asavContext, asavContext.settings().getChallengeResponseChannel(), AsavStatus.ChallengeRequest.INSTANCE, AsavStatus.ChallengeResponse.INSTANCE);
    }

    public static final IAsavRequestAdvertiser signatureRequestAdvertiser(IAsavContext asavContext) {
        Intrinsics.checkNotNullParameter(asavContext, "asavContext");
        return new AsavBaseAdvertiser(asavContext, AsavStatus.SignatureRequest.INSTANCE, AsavStatus.SignatureResponse.INSTANCE);
    }

    public static final IAsavResponseDiscoverer signatureResponseDiscoverer(IAsavContext asavContext) {
        Intrinsics.checkNotNullParameter(asavContext, "asavContext");
        return new AsavBaseDiscoverer(asavContext, asavContext.settings().getSignatureResponseChannel(), AsavStatus.SignatureRequest.INSTANCE, AsavStatus.SignatureResponse.INSTANCE);
    }
}
