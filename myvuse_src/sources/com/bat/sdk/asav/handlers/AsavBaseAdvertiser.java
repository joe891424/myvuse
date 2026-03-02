package com.bat.sdk.asav.handlers;

import com.bat.sdk.asav.core.AsavLogKt;
import com.bat.sdk.asav.core.AsavStatus;
import com.bat.sdk.asav.core.IAsavContext;
import com.bat.sdk.asav.request.AsavChannelRequest;
import com.bat.sdk.ble.BatAdvertiser;
import com.bat.sdk.logging.Logger;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IAsavRequestAdvertiser.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0016\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m5598d2 = {"Lcom/bat/sdk/asav/handlers/AsavBaseAdvertiser;", "Lcom/bat/sdk/asav/handlers/IAsavRequestAdvertiser;", "asavContext", "Lcom/bat/sdk/asav/core/IAsavContext;", "requestStatus", "Lcom/bat/sdk/asav/core/AsavStatus;", "responseStatus", "<init>", "(Lcom/bat/sdk/asav/core/IAsavContext;Lcom/bat/sdk/asav/core/AsavStatus;Lcom/bat/sdk/asav/core/AsavStatus;)V", "advertise", "", "request", "Lcom/bat/sdk/asav/request/AsavChannelRequest;", "(Lcom/bat/sdk/asav/request/AsavChannelRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keepAdvertising", "", "asavStatus", "onAdvertisingChunkSent", "chunk", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public class AsavBaseAdvertiser implements IAsavRequestAdvertiser {
    private final IAsavContext asavContext;
    private final AsavStatus requestStatus;
    private final AsavStatus responseStatus;

    /* JADX INFO: renamed from: com.bat.sdk.asav.handlers.AsavBaseAdvertiser$advertise$1 */
    /* JADX INFO: compiled from: IAsavRequestAdvertiser.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.asav.handlers.AsavBaseAdvertiser", m5608f = "IAsavRequestAdvertiser.kt", m5609i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m5610l = {43, 45}, m5611m = "advertise$suspendImpl", m5612n = {"$this", "request", "advertiser", "incr", BackgroundFetch.ACTION_STOP, "nextChunk", "$this", "request", "advertiser", "incr", BackgroundFetch.ACTION_STOP}, m5613s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C14901 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C14901(Continuation<? super C14901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsavBaseAdvertiser.advertise$suspendImpl(AsavBaseAdvertiser.this, null, this);
        }
    }

    @Override // com.bat.sdk.asav.handlers.IAsavRequestAdvertiser
    public Object advertise(AsavChannelRequest asavChannelRequest, Continuation<? super Unit> continuation) {
        return advertise$suspendImpl(this, asavChannelRequest, continuation);
    }

    public Object onAdvertisingChunkSent(String str, Continuation<? super Unit> continuation) {
        return onAdvertisingChunkSent$suspendImpl(this, str, continuation);
    }

    public AsavBaseAdvertiser(IAsavContext asavContext, AsavStatus requestStatus, AsavStatus responseStatus) {
        Intrinsics.checkNotNullParameter(asavContext, "asavContext");
        Intrinsics.checkNotNullParameter(requestStatus, "requestStatus");
        Intrinsics.checkNotNullParameter(responseStatus, "responseStatus");
        this.asavContext = asavContext;
        this.requestStatus = requestStatus;
        this.responseStatus = responseStatus;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x01d9 -> B:43:0x01dc). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:27:0x00b7
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object advertise$suspendImpl(com.bat.sdk.asav.handlers.AsavBaseAdvertiser r13, com.bat.sdk.asav.request.AsavChannelRequest r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instruction units count: 578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.asav.handlers.AsavBaseAdvertiser.advertise$suspendImpl(com.bat.sdk.asav.handlers.AsavBaseAdvertiser, com.bat.sdk.asav.request.AsavChannelRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean keepAdvertising(AsavStatus asavStatus) {
        Intrinsics.checkNotNullParameter(asavStatus, "asavStatus");
        return Intrinsics.areEqual(asavStatus, this.requestStatus);
    }

    static /* synthetic */ Object onAdvertisingChunkSent$suspendImpl(AsavBaseAdvertiser asavBaseAdvertiser, String str, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.bat.sdk.asav.handlers.IAsavRequestAdvertiser
    public void reset() {
        Logger logger = Logger.INSTANCE;
        String str = IAsavRequestAdvertiserKt.TAG;
        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
        logger.log(str, "[onAdvertising] reset invoked. Stopping advertising");
        AsavLogKt.getLogger().console(IAsavRequestAdvertiserKt.TAG, "[onAdvertising] reset invoked. Stopping advertising");
        BatAdvertiser.stopAdvertising$default(this.asavContext.advertiser(), null, 1, null);
    }
}
