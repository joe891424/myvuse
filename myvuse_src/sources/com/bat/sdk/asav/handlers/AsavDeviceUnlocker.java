package com.bat.sdk.asav.handlers;

import com.bat.sdk.asav.core.AsavLogKt;
import com.bat.sdk.asav.core.AsavStatus;
import com.bat.sdk.asav.core.IAsavContext;
import com.bat.sdk.asav.response.IAsavResultListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: AsavDeviceUnlocker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m5598d2 = {"Lcom/bat/sdk/asav/handlers/AsavDeviceUnlocker;", "Lcom/bat/sdk/asav/handlers/AsavBaseAdvertiser;", "asavContext", "Lcom/bat/sdk/asav/core/IAsavContext;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bat/sdk/asav/response/IAsavResultListener;", "<init>", "(Lcom/bat/sdk/asav/core/IAsavContext;Lcom/bat/sdk/asav/response/IAsavResultListener;)V", "getAsavContext", "()Lcom/bat/sdk/asav/core/IAsavContext;", "getListener", "()Lcom/bat/sdk/asav/response/IAsavResultListener;", "attempts", "", "onAdvertisingChunkSent", "", "chunk", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keepAdvertising", "", "asavStatus", "Lcom/bat/sdk/asav/core/AsavStatus;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavDeviceUnlocker extends AsavBaseAdvertiser {
    private final IAsavContext asavContext;
    private int attempts;
    private final IAsavResultListener listener;

    public final IAsavContext getAsavContext() {
        return this.asavContext;
    }

    public final IAsavResultListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsavDeviceUnlocker(IAsavContext asavContext, IAsavResultListener listener) {
        super(asavContext, AsavStatus.SignatureRequest.INSTANCE, AsavStatus.SignatureResponse.INSTANCE);
        Intrinsics.checkNotNullParameter(asavContext, "asavContext");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.asavContext = asavContext;
        this.listener = listener;
    }

    @Override // com.bat.sdk.asav.handlers.AsavBaseAdvertiser
    public Object onAdvertisingChunkSent(String str, Continuation<? super Unit> continuation) {
        if (this.attempts == 0) {
            AsavLogKt.getLogger().log("SDK (" + AsavDeviceUnlockerKt.TAG + "} -> Already unlocked! Sending 8-time ACKs to EPOD. Wait...");
        }
        int i = this.attempts;
        this.attempts = i + 1;
        Integer numBoxInt = Boxing.boxInt(i);
        if (numBoxInt.intValue() != 8) {
            numBoxInt = null;
        }
        if (numBoxInt != null) {
            numBoxInt.intValue();
            Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AsavDeviceUnlocker$onAdvertisingChunkSent$3$1(this, null), continuation);
            if (objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return objCoroutineScope;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.bat.sdk.asav.handlers.AsavBaseAdvertiser
    public boolean keepAdvertising(AsavStatus asavStatus) {
        Intrinsics.checkNotNullParameter(asavStatus, "asavStatus");
        return Intrinsics.areEqual(asavStatus, AsavStatus.SignatureRequest.INSTANCE) || Intrinsics.areEqual(asavStatus, AsavStatus.SignatureResponse.INSTANCE);
    }
}
