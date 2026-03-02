package com.yoti.mobile.android.mrtd.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.Tag;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.yoti.mobile.android.mrtd.domain.NfcBroadcastDefsKt;
import com.yoti.mobile.mpp.mrtddump.MrtdReader;
import com.yoti.mobile.mpp.mrtddump.p095io.NfcController;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u0018\u001a\u00020\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/data/MrtdReaderProducer;", "", "broadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "queueFactory", "Lcom/yoti/mobile/android/mrtd/data/ReaderQueueFactory;", "controllerFactory", "Lcom/yoti/mobile/android/mrtd/data/MrtdControllerFactory;", "readerFactory", "Lcom/yoti/mobile/android/mrtd/data/MrtdReaderFactory;", "(Landroidx/localbroadcastmanager/content/LocalBroadcastManager;Lcom/yoti/mobile/android/mrtd/data/ReaderQueueFactory;Lcom/yoti/mobile/android/mrtd/data/MrtdControllerFactory;Lcom/yoti/mobile/android/mrtd/data/MrtdReaderFactory;)V", "intentFilter", "Landroid/content/IntentFilter;", "readerAvailable", "", "getReaderAvailable$annotations", "()V", "getReaderAvailable", "()Z", "readerQueue", "Lkotlinx/coroutines/channels/Channel;", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReader;", "receiver", "Lcom/yoti/mobile/android/mrtd/data/MrtdReaderProducer$NfcIntentReceiver;", "getReader", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startReceiving", "", "stopReceiving", "NfcIntentReceiver", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdReaderProducer {
    private final LocalBroadcastManager broadcastManager;
    private final MrtdControllerFactory controllerFactory;
    private final IntentFilter intentFilter;
    private final ReaderQueueFactory queueFactory;
    private final MrtdReaderFactory readerFactory;
    private Channel<MrtdReader> readerQueue;
    private final NfcIntentReceiver receiver;

    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/data/MrtdReaderProducer$NfcIntentReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/yoti/mobile/android/mrtd/data/MrtdReaderProducer;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private final class NfcIntentReceiver extends BroadcastReceiver {
        public NfcIntentReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NfcController nfcControllerCreate;
            Channel channel;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Tag tag = (Tag) intent.getParcelableExtra(NfcBroadcastDefsKt.NFC_BROADCAST_INTENT_EXTRA);
            if (tag == null || (nfcControllerCreate = MrtdReaderProducer.this.controllerFactory.create(tag)) == null || (channel = MrtdReaderProducer.this.readerQueue) == null) {
                return;
            }
            ChannelResult.m8747boximpl(channel.mo8737trySendJP2dKIU(MrtdReaderProducer.this.readerFactory.create(nfcControllerCreate)));
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.mrtd.data.MrtdReaderProducer$getReader$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.mrtd.data.MrtdReaderProducer", m5608f = "MrtdReaderProducer.kt", m5609i = {}, m5610l = {57}, m5611m = "getReader", m5612n = {}, m5613s = {})
    static final class C49011 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C49011(Continuation<? super C49011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MrtdReaderProducer.this.getReader(this);
        }
    }

    @Inject
    public MrtdReaderProducer(LocalBroadcastManager broadcastManager, ReaderQueueFactory queueFactory, MrtdControllerFactory controllerFactory, MrtdReaderFactory readerFactory) {
        Intrinsics.checkNotNullParameter(broadcastManager, "broadcastManager");
        Intrinsics.checkNotNullParameter(queueFactory, "queueFactory");
        Intrinsics.checkNotNullParameter(controllerFactory, "controllerFactory");
        Intrinsics.checkNotNullParameter(readerFactory, "readerFactory");
        this.broadcastManager = broadcastManager;
        this.queueFactory = queueFactory;
        this.controllerFactory = controllerFactory;
        this.readerFactory = readerFactory;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NfcBroadcastDefsKt.NFC_BROADCAST_ACTION);
        this.intentFilter = intentFilter;
        this.receiver = new NfcIntentReceiver();
    }

    public static /* synthetic */ void getReaderAvailable$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getReader(kotlin.coroutines.Continuation<? super com.yoti.mobile.mpp.mrtddump.MrtdReader> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.yoti.mobile.android.mrtd.data.MrtdReaderProducer.C49011
            if (r0 == 0) goto L13
            r0 = r5
            com.yoti.mobile.android.mrtd.data.MrtdReaderProducer$getReader$1 r0 = (com.yoti.mobile.android.mrtd.data.MrtdReaderProducer.C49011) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.yoti.mobile.android.mrtd.data.MrtdReaderProducer$getReader$1 r0 = new com.yoti.mobile.android.mrtd.data.MrtdReaderProducer$getReader$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L41
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.coroutines.channels.Channel<com.yoti.mobile.mpp.mrtddump.MrtdReader> r5 = r4.readerQueue
            if (r5 == 0) goto L46
            r0.label = r3
            java.lang.Object r5 = r5.receive(r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            com.yoti.mobile.mpp.mrtddump.MrtdReader r5 = (com.yoti.mobile.mpp.mrtddump.MrtdReader) r5
            if (r5 == 0) goto L46
            return r5
        L46:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Must call startReceiving before getting reader"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.mrtd.data.MrtdReaderProducer.getReader(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean getReaderAvailable() {
        return !(this.readerQueue != null ? r0.isEmpty() : true);
    }

    public final void startReceiving() {
        this.readerQueue = this.queueFactory.create();
        this.broadcastManager.registerReceiver(this.receiver, this.intentFilter);
    }

    public final void stopReceiving() {
        this.broadcastManager.unregisterReceiver(this.receiver);
        Channel<MrtdReader> channel = this.readerQueue;
        if (channel != null) {
            SendChannel.DefaultImpls.close$default(channel, null, 1, null);
        }
        this.readerQueue = null;
    }
}
