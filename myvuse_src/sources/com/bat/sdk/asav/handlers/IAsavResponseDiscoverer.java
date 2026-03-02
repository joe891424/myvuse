package com.bat.sdk.asav.handlers;

import com.bat.sdk.asav.response.AsavChannelResponse;
import com.bat.sdk.ble.BatDevice;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IAsavResponseDiscoverer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m5598d2 = {"Lcom/bat/sdk/asav/handlers/IAsavResponseDiscoverer;", "", "interceptResponse", "Lcom/bat/sdk/asav/response/AsavChannelResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "batDevice", "Lcom/bat/sdk/ble/BatDevice;", "reset", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface IAsavResponseDiscoverer {
    BatDevice batDevice();

    Object interceptResponse(Continuation<? super AsavChannelResponse> continuation);

    void reset();
}
