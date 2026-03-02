package com.bat.sdk.asav.handlers;

import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import com.bat.sdk.asav.core.AsavLog;
import com.bat.sdk.asav.core.AsavLogKt;
import com.bat.sdk.asav.core.AsavStatus;
import com.bat.sdk.asav.core.IAsavChannel;
import com.bat.sdk.asav.core.IAsavContext;
import com.bat.sdk.asav.core.IAsavTimer;
import com.bat.sdk.asav.response.AsavChannelResponse;
import com.bat.sdk.ble.BatDevice;
import com.bat.sdk.ble.BatScanner;
import com.bat.sdk.logging.Logger;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: IAsavResponseDiscoverer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020 H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\f\u0010!\u001a\u00020\"*\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, m5598d2 = {"Lcom/bat/sdk/asav/handlers/AsavBaseDiscoverer;", "Lcom/bat/sdk/asav/handlers/IAsavResponseDiscoverer;", "asavContext", "Lcom/bat/sdk/asav/core/IAsavContext;", "asavChannel", "Lcom/bat/sdk/asav/core/IAsavChannel;", "requestStatus", "Lcom/bat/sdk/asav/core/AsavStatus;", "responseStatus", "<init>", "(Lcom/bat/sdk/asav/core/IAsavContext;Lcom/bat/sdk/asav/core/IAsavChannel;Lcom/bat/sdk/asav/core/AsavStatus;Lcom/bat/sdk/asav/core/AsavStatus;)V", "batDevice", "Lcom/bat/sdk/ble/BatDevice;", "callback", "Lcom/bat/sdk/asav/handlers/FilteringScanCallback;", "chunkAssembler", "Lcom/bat/sdk/asav/handlers/AsavResponseAssembler;", "getChunkAssembler", "()Lcom/bat/sdk/asav/handlers/AsavResponseAssembler;", "chunkAssembler$delegate", "Lkotlin/Lazy;", "statuses", "", "timer", "Lcom/bat/sdk/asav/core/IAsavTimer;", "getTimer", "()Lcom/bat/sdk/asav/core/IAsavTimer;", "timer$delegate", "interceptResponse", "Lcom/bat/sdk/asav/response/AsavChannelResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "", "isSessionDevice", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavBaseDiscoverer implements IAsavResponseDiscoverer {
    private final IAsavChannel asavChannel;
    private final IAsavContext asavContext;
    private BatDevice batDevice;
    private FilteringScanCallback callback;

    /* JADX INFO: renamed from: chunkAssembler$delegate, reason: from kotlin metadata */
    private final Lazy chunkAssembler;
    private final AsavStatus requestStatus;
    private final AsavStatus responseStatus;
    private final List<AsavStatus> statuses;

    /* JADX INFO: renamed from: timer$delegate, reason: from kotlin metadata */
    private final Lazy timer;

    public AsavBaseDiscoverer(IAsavContext asavContext, IAsavChannel asavChannel, AsavStatus requestStatus, AsavStatus responseStatus) {
        Intrinsics.checkNotNullParameter(asavContext, "asavContext");
        Intrinsics.checkNotNullParameter(asavChannel, "asavChannel");
        Intrinsics.checkNotNullParameter(requestStatus, "requestStatus");
        Intrinsics.checkNotNullParameter(responseStatus, "responseStatus");
        this.asavContext = asavContext;
        this.asavChannel = asavChannel;
        this.requestStatus = requestStatus;
        this.responseStatus = responseStatus;
        this.chunkAssembler = LazyKt.lazy(new Function0() { // from class: com.bat.sdk.asav.handlers.AsavBaseDiscoverer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AsavBaseDiscoverer.chunkAssembler_delegate$lambda$0(this.f$0);
            }
        });
        this.statuses = CollectionsKt.listOf((Object[]) new AsavStatus[]{requestStatus, responseStatus});
        this.timer = LazyKt.lazy(new Function0() { // from class: com.bat.sdk.asav.handlers.AsavBaseDiscoverer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AsavBaseDiscoverer.timer_delegate$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AsavResponseAssembler getChunkAssembler() {
        return (AsavResponseAssembler) this.chunkAssembler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsavResponseAssembler chunkAssembler_delegate$lambda$0(AsavBaseDiscoverer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return new AsavResponseAssembler(this$0.asavContext, this$0.asavChannel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAsavTimer getTimer() {
        return (IAsavTimer) this.timer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IAsavTimer timer_delegate$lambda$1(AsavBaseDiscoverer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.asavContext.timer();
    }

    @Override // com.bat.sdk.asav.handlers.IAsavResponseDiscoverer
    public void reset() {
        FilteringScanCallback filteringScanCallback = this.callback;
        if (filteringScanCallback != null) {
            this.asavContext.scanner().stop(filteringScanCallback);
        }
        getChunkAssembler().reset();
    }

    @Override // com.bat.sdk.asav.handlers.IAsavResponseDiscoverer
    /* JADX INFO: renamed from: batDevice, reason: from getter */
    public BatDevice getBatDevice() {
        return this.batDevice;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSessionDevice(BatDevice batDevice) {
        AsavLog logger = AsavLogKt.getLogger();
        String str = IAsavResponseDiscovererKt.TAG;
        StringBuilder sb = new StringBuilder("[onDiscover] isSessionDevice: ");
        BatDevice batDevice2 = this.batDevice;
        StringBuilder sbAppend = sb.append(Intrinsics.areEqual(batDevice2 != null ? batDevice2.getAddress() : null, batDevice.getAddress())).append(", session_device.address=");
        BatDevice batDevice3 = this.batDevice;
        logger.console(str, sbAppend.append(batDevice3 != null ? batDevice3.getAddress() : null).append(", current_device.address=").append(batDevice.getAddress()).toString());
        BatDevice batDevice4 = this.batDevice;
        if (batDevice4 != null) {
            return Intrinsics.areEqual(batDevice4.getAddress(), batDevice.getAddress());
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.bat.sdk.asav.handlers.AsavBaseDiscoverer$interceptResponse$2$2] */
    @Override // com.bat.sdk.asav.handlers.IAsavResponseDiscoverer
    public Object interceptResponse(Continuation<? super AsavChannelResponse> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final IAsavContext iAsavContext = this.asavContext;
        final ?? r3 = new Function2<AsavStatus, BatDevice, Boolean>() { // from class: com.bat.sdk.asav.handlers.AsavBaseDiscoverer$interceptResponse$2$2
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(AsavStatus current, BatDevice device) {
                Intrinsics.checkNotNullParameter(current, "current");
                Intrinsics.checkNotNullParameter(device, "device");
                Boolean boolValueOf = Boolean.valueOf(this.this$0.isSessionDevice(device) && this.this$0.statuses.contains(current));
                AsavBaseDiscoverer asavBaseDiscoverer = this.this$0;
                boolean zBooleanValue = boolValueOf.booleanValue();
                AsavLog logger = AsavLogKt.getLogger();
                String str = IAsavResponseDiscovererKt.TAG;
                StringBuilder sb = new StringBuilder("[onDiscover] session device is ");
                BatDevice batDevice = asavBaseDiscoverer.batDevice;
                logger.console(str, sb.append(batDevice != null ? batDevice.getName() : null).toString());
                if (!zBooleanValue) {
                    AsavLogKt.getLogger().console(IAsavResponseDiscovererKt.TAG, "[onDiscovery] Skipping chunk from " + device.getName() + SafeJsonPrimitive.NULL_CHAR, "[expected status: " + asavBaseDiscoverer.requestStatus + SafeJsonPrimitive.NULL_CHAR + asavBaseDiscoverer.responseStatus, "actual status: " + current + ']');
                }
                return boolValueOf;
            }
        };
        this.callback = new FilteringScanCallback(cancellableContinuationImpl2, iAsavContext, r3) { // from class: com.bat.sdk.asav.handlers.AsavBaseDiscoverer$interceptResponse$2$1
            final /* synthetic */ CancellableContinuation<AsavChannelResponse> $continuation;

            /* JADX WARN: Multi-variable type inference failed */
            {
                AsavBaseDiscoverer$interceptResponse$2$2 asavBaseDiscoverer$interceptResponse$2$2 = r3;
            }

            @Override // com.bat.sdk.asav.handlers.FilteringScanCallback
            public void onFilteredData(String data, BatDevice batDevice) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(batDevice, "batDevice");
                AsavChannelResponse asavChannelResponseAssemble = this.this$0.getChunkAssembler().assemble(data, batDevice);
                Logger logger = Logger.INSTANCE;
                String str = IAsavResponseDiscovererKt.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                logger.log(str, "response:" + asavChannelResponseAssemble);
                if (asavChannelResponseAssemble != null) {
                    AsavBaseDiscoverer asavBaseDiscoverer = this.this$0;
                    CancellableContinuation<AsavChannelResponse> cancellableContinuation = this.$continuation;
                    if (!asavChannelResponseAssemble.getInputBucket().isEmpty()) {
                        asavBaseDiscoverer.batDevice = asavChannelResponseAssemble.getBatDevice();
                        getAsavContext().status(asavBaseDiscoverer.responseStatus);
                        asavBaseDiscoverer.getTimer().ping();
                        AsavLogKt.getLogger().console(IAsavResponseDiscovererKt.TAG, "[onDiscovery] chunk received from device@" + batDevice.getAddress());
                    }
                    if (asavChannelResponseAssemble.getInputBucket().isFull() && cancellableContinuation.isActive()) {
                        asavBaseDiscoverer.getTimer().ping();
                        AsavLogKt.getLogger().console(IAsavResponseDiscovererKt.TAG, "[onDiscovery] chunks fully received");
                        AsavLogKt.getLogger().console(IAsavResponseDiscovererKt.TAG, "[onDiscovery] Stopping scanner. chunks fully received");
                        getAsavContext().scanner().stop(this);
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m7233constructorimpl(asavChannelResponseAssemble));
                    }
                }
            }
        };
        try {
            final FilteringScanCallback filteringScanCallback = this.callback;
            if (filteringScanCallback != null) {
                cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.bat.sdk.asav.handlers.AsavBaseDiscoverer$interceptResponse$2$3$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        this.this$0.asavContext.scanner().stop(filteringScanCallback);
                    }
                });
                ScanSettings scanSettingsBuild = new ScanSettings.Builder().setScanMode(2).build();
                List<ScanFilter> listEmptyList = CollectionsKt.emptyList();
                BatScanner batScannerScanner = this.asavContext.scanner();
                Intrinsics.checkNotNull(scanSettingsBuild);
                batScannerScanner.start(scanSettingsBuild, listEmptyList, filteringScanCallback);
                batScannerScanner.flush(filteringScanCallback);
                AsavLogKt.getLogger().console(IAsavResponseDiscovererKt.TAG, "[onDiscovery] Starting scanner...");
            } else {
                AsavBaseDiscoverer asavBaseDiscoverer = this;
                AsavLogKt.getLogger().console(IAsavResponseDiscovererKt.TAG, "[onDiscovery] callback null");
            }
        } catch (Exception e) {
            AsavLog logger = AsavLogKt.getLogger();
            String str = IAsavResponseDiscovererKt.TAG;
            StringBuilder sb = new StringBuilder("[onDiscovery] Stopping scanner. Exception occurred ");
            e.printStackTrace();
            logger.console(str, sb.append(Unit.INSTANCE).toString());
            if (cancellableContinuationImpl2.isActive()) {
                FilteringScanCallback filteringScanCallback2 = this.callback;
                if (filteringScanCallback2 != null) {
                    this.asavContext.scanner().stop(filteringScanCallback2);
                }
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m7233constructorimpl(ResultKt.createFailure(e)));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
