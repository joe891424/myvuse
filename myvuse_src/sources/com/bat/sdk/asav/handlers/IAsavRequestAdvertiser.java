package com.bat.sdk.asav.handlers;

import com.bat.sdk.asav.request.AsavChannelRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IAsavRequestAdvertiser.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/asav/handlers/IAsavRequestAdvertiser;", "", "advertise", "", "request", "Lcom/bat/sdk/asav/request/AsavChannelRequest;", "(Lcom/bat/sdk/asav/request/AsavChannelRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface IAsavRequestAdvertiser {
    Object advertise(AsavChannelRequest asavChannelRequest, Continuation<? super Unit> continuation);

    void reset();
}
