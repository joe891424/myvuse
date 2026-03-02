package com.yoti.mobile.mpp.mrtddump.session;

import com.yoti.mobile.mpp.mrtddump.commands.CommandBuilder;
import com.yoti.mobile.mpp.mrtddump.p095io.NfcController;
import com.yoti.mobile.mpp.mrtddump.p096j.C5119c;
import com.yoti.mobile.mpp.mrtddump.p096j.C5120d;
import com.yoti.mobile.mpp.smartcard.CommandAPDU;
import com.yoti.mobile.mpp.smartcard.ResponseAPDU;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.i.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0017B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;", "", "controller", "Lcom/yoti/mobile/mpp/mrtddump/io/NfcController;", "commandBuilder", "Lcom/yoti/mobile/mpp/mrtddump/commands/CommandBuilder;", "(Lcom/yoti/mobile/mpp/mrtddump/io/NfcController;Lcom/yoti/mobile/mpp/mrtddump/commands/CommandBuilder;)V", "getCommandBuilder$mrtddump_release", "()Lcom/yoti/mobile/mpp/mrtddump/commands/CommandBuilder;", "getController$mrtddump_release", "()Lcom/yoti/mobile/mpp/mrtddump/io/NfcController;", "prepare", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareCommand", "Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;", "command", "(Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processResponse", "Lcom/yoti/mobile/mpp/smartcard/ResponseAPDU;", "response", "(Lcom/yoti/mobile/mpp/smartcard/ResponseAPDU;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendCommand", "Factory", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class MessagingSession {

    /* JADX INFO: renamed from: a */
    private final NfcController f8097a;

    /* JADX INFO: renamed from: b */
    private final CommandBuilder f8098b;

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.i.a$a */
    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession$Factory;", "", "commandBuilder", "Lcom/yoti/mobile/mpp/mrtddump/commands/CommandBuilder;", "(Lcom/yoti/mobile/mpp/mrtddump/commands/CommandBuilder;)V", "getCommandBuilder", "()Lcom/yoti/mobile/mpp/mrtddump/commands/CommandBuilder;", "create", "Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;", "controller", "Lcom/yoti/mobile/mpp/mrtddump/io/NfcController;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a */
        private final CommandBuilder f8099a;

        public a(CommandBuilder commandBuilder) {
            Intrinsics.checkNotNullParameter(commandBuilder, "commandBuilder");
            this.f8099a = commandBuilder;
        }

        /* JADX INFO: renamed from: a */
        public final MessagingSession m5514a(NfcController controller) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            return new MessagingSession(controller, this.f8099a);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.i.a$b */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.session.MessagingSession", m5608f = "MessagingSession.kt", m5609i = {0, 1}, m5610l = {48, 50, 52}, m5611m = "sendCommand", m5612n = {"this", "this"}, m5613s = {"L$0", "L$0"})
    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f8100a;

        /* JADX INFO: renamed from: b */
        /* synthetic */ Object f8101b;

        /* JADX INFO: renamed from: d */
        int f8103d;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8101b = obj;
            this.f8103d |= Integer.MIN_VALUE;
            return MessagingSession.this.m5513b(null, this);
        }
    }

    public MessagingSession(NfcController controller, CommandBuilder commandBuilder) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(commandBuilder, "commandBuilder");
        this.f8097a = controller;
        this.f8098b = commandBuilder;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ Object m5506a(MessagingSession messagingSession, CommandAPDU commandAPDU, Continuation continuation) {
        return commandAPDU;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ Object m5507a(MessagingSession messagingSession, ResponseAPDU responseAPDU, Continuation continuation) {
        return responseAPDU;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final CommandBuilder getF8098b() {
        return this.f8098b;
    }

    /* JADX INFO: renamed from: a */
    protected Object mo5509a(CommandAPDU commandAPDU, Continuation<? super CommandAPDU> continuation) {
        return m5506a(this, commandAPDU, continuation);
    }

    /* JADX INFO: renamed from: a */
    protected Object mo5510a(ResponseAPDU responseAPDU, Continuation<? super ResponseAPDU> continuation) {
        return m5507a(this, responseAPDU, continuation);
    }

    /* JADX INFO: renamed from: a */
    public final Object m5511a(Continuation<? super Unit> continuation) {
        if (getF8097a().isConnected()) {
            return Unit.INSTANCE;
        }
        if (C5120d.m5539a() <= 1) {
            C5119c.m5531a("MessagingSession", "Controller is not connected, connecting...");
        }
        Object objConnect = getF8097a().connect(continuation);
        return objConnect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objConnect : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final NfcController getF8097a() {
        return this.f8097a;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5513b(com.yoti.mobile.mpp.smartcard.CommandAPDU r10, kotlin.coroutines.Continuation<? super com.yoti.mobile.mpp.smartcard.ResponseAPDU> r11) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.session.MessagingSession.m5513b(com.yoti.mobile.mpp.smartcard.CommandAPDU, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
