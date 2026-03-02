package com.yoti.mobile.mpp.mrtddump.session;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper;
import com.yoti.mobile.mpp.mrtddump.commands.CommandBuilder;
import com.yoti.mobile.mpp.mrtddump.p095io.NfcController;
import com.yoti.mobile.mpp.smartcard.CommandAPDU;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import com.yoti.mobile.mpp.smartcard.ResponseAPDU;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.i.c, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/session/SecureMessagingSession;", "Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;", "controller", "Lcom/yoti/mobile/mpp/mrtddump/io/NfcController;", "commandGenerator", "Lcom/yoti/mobile/mpp/mrtddump/commands/CommandBuilder;", "messagingHelper", "Lcom/yoti/mobile/mpp/mrtddump/asn1/SecureMessagingHelper;", "(Lcom/yoti/mobile/mpp/mrtddump/io/NfcController;Lcom/yoti/mobile/mpp/mrtddump/commands/CommandBuilder;Lcom/yoti/mobile/mpp/mrtddump/asn1/SecureMessagingHelper;)V", "addCommandMac", "Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;", "encryptedCommand", "(Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "encryptCommand", "command", "prepareCommand", "processResponse", "Lcom/yoti/mobile/mpp/smartcard/ResponseAPDU;", "response", "(Lcom/yoti/mobile/mpp/smartcard/ResponseAPDU;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SecureMessagingSession extends MessagingSession {

    /* JADX INFO: renamed from: c */
    private final SecureMessagingHelper f8105c;

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.i.c$a */
    @Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J1\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/session/SecureMessagingSession$Factory;", "", "commandGenerator", "Lcom/yoti/mobile/mpp/mrtddump/commands/CommandBuilder;", "(Lcom/yoti/mobile/mpp/mrtddump/commands/CommandBuilder;)V", "wrap", "Lcom/yoti/mobile/mpp/mrtddump/session/SecureMessagingSession;", "session", "Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;", "crypto", "Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoMode;", "keyDerivation", "Lcom/yoti/mobile/mpp/mrtddump/crypto/KeyDerivationFunction;", "ssc", "", "(Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoMode;Lcom/yoti/mobile/mpp/mrtddump/crypto/KeyDerivationFunction;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a */
        private final CommandBuilder f8106a;

        /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.i.c$a$a, reason: collision with other inner class name */
        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession$Factory", m5608f = "SecureMessagingSession.kt", m5609i = {0, 0, 1}, m5610l = {97, ISO7816Kt.SW1_WARNING_UNCHANGED}, m5611m = "wrap", m5612n = {"keyDerivation", "ssc", "ssc"}, m5613s = {"L$0", "J$0", "J$0"})
        static final class C6030a extends ContinuationImpl {

            /* JADX INFO: renamed from: a */
            Object f8107a;

            /* JADX INFO: renamed from: b */
            Object f8108b;

            /* JADX INFO: renamed from: c */
            Object f8109c;

            /* JADX INFO: renamed from: d */
            Object f8110d;

            /* JADX INFO: renamed from: e */
            long f8111e;

            /* JADX INFO: renamed from: f */
            /* synthetic */ Object f8112f;

            /* JADX INFO: renamed from: h */
            int f8114h;

            C6030a(Continuation<? super C6030a> continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f8112f = obj;
                this.f8114h |= Integer.MIN_VALUE;
                return a.this.m5520a(null, null, null, 0L, this);
            }
        }

        public a(CommandBuilder commandGenerator) {
            Intrinsics.checkNotNullParameter(commandGenerator, "commandGenerator");
            this.f8106a = commandGenerator;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object m5520a(com.yoti.mobile.mpp.mrtddump.session.MessagingSession r9, com.yoti.mobile.mpp.mrtddump.crypto.CryptoMode r10, com.yoti.mobile.mpp.mrtddump.crypto.KeyDerivationFunction r11, long r12, kotlin.coroutines.Continuation<? super com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession> r14) {
            /*
                r8 = this;
                boolean r0 = r14 instanceof com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession.a.C6030a
                if (r0 == 0) goto L13
                r0 = r14
                com.yoti.mobile.mpp.mrtddump.i.c$a$a r0 = (com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession.a.C6030a) r0
                int r1 = r0.f8114h
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f8114h = r1
                goto L18
            L13:
                com.yoti.mobile.mpp.mrtddump.i.c$a$a r0 = new com.yoti.mobile.mpp.mrtddump.i.c$a$a
                r0.<init>(r14)
            L18:
                java.lang.Object r14 = r0.f8112f
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.f8114h
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L61
                if (r2 == r4) goto L47
                if (r2 != r3) goto L3f
                long r9 = r0.f8111e
                java.lang.Object r11 = r0.f8110d
                com.yoti.mobile.mpp.mrtddump.a r11 = (com.yoti.mobile.mpp.mrtddump.EncryptionKey) r11
                java.lang.Object r12 = r0.f8109c
                com.yoti.mobile.mpp.mrtddump.h.b r12 = (com.yoti.mobile.mpp.mrtddump.crypto.CryptoMode) r12
                java.lang.Object r13 = r0.f8108b
                com.yoti.mobile.mpp.mrtddump.g.a r13 = (com.yoti.mobile.mpp.mrtddump.commands.CommandBuilder) r13
                java.lang.Object r0 = r0.f8107a
                com.yoti.mobile.mpp.mrtddump.io.NfcController r0 = (com.yoti.mobile.mpp.mrtddump.p095io.NfcController) r0
                kotlin.ResultKt.throwOnFailure(r14)
                goto L9e
            L3f:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L47:
                long r12 = r0.f8111e
                java.lang.Object r9 = r0.f8110d
                r10 = r9
                com.yoti.mobile.mpp.mrtddump.h.b r10 = (com.yoti.mobile.mpp.mrtddump.crypto.CryptoMode) r10
                java.lang.Object r9 = r0.f8109c
                com.yoti.mobile.mpp.mrtddump.g.a r9 = (com.yoti.mobile.mpp.mrtddump.commands.CommandBuilder) r9
                java.lang.Object r11 = r0.f8108b
                com.yoti.mobile.mpp.mrtddump.io.NfcController r11 = (com.yoti.mobile.mpp.mrtddump.p095io.NfcController) r11
                java.lang.Object r2 = r0.f8107a
                com.yoti.mobile.mpp.mrtddump.h.d r2 = (com.yoti.mobile.mpp.mrtddump.crypto.KeyDerivationFunction) r2
                kotlin.ResultKt.throwOnFailure(r14)
                r5 = r2
                r2 = r11
                r11 = r5
                goto L81
            L61:
                kotlin.ResultKt.throwOnFailure(r14)
                com.yoti.mobile.mpp.mrtddump.io.NfcController r9 = r9.getF8097a()
                com.yoti.mobile.mpp.mrtddump.g.a r14 = r8.f8106a
                r0.f8107a = r11
                r0.f8108b = r9
                r0.f8109c = r14
                r0.f8110d = r10
                r0.f8111e = r12
                r0.f8114h = r4
                java.lang.Object r2 = r11.m5487a(r0)
                if (r2 != r1) goto L7d
                return r1
            L7d:
                r5 = r2
                r2 = r9
                r9 = r14
                r14 = r5
            L81:
                com.yoti.mobile.mpp.mrtddump.a r14 = (com.yoti.mobile.mpp.mrtddump.EncryptionKey) r14
                r0.f8107a = r2
                r0.f8108b = r9
                r0.f8109c = r10
                r0.f8110d = r14
                r0.f8111e = r12
                r0.f8114h = r3
                java.lang.Object r11 = r11.m5488b(r0)
                if (r11 != r1) goto L96
                return r1
            L96:
                r0 = r2
                r5 = r12
                r13 = r9
                r12 = r10
                r9 = r5
                r7 = r14
                r14 = r11
                r11 = r7
            L9e:
                com.yoti.mobile.mpp.mrtddump.c r14 = (com.yoti.mobile.mpp.mrtddump.MacKey) r14
                com.yoti.mobile.mpp.mrtddump.e.a r1 = new com.yoti.mobile.mpp.mrtddump.e.a
                r1.<init>(r9)
                com.yoti.mobile.mpp.mrtddump.e.c r9 = new com.yoti.mobile.mpp.mrtddump.e.c
                r9.<init>(r12, r11, r14, r1)
                com.yoti.mobile.mpp.mrtddump.i.c r10 = new com.yoti.mobile.mpp.mrtddump.i.c
                r10.<init>(r0, r13, r9)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession.a.m5520a(com.yoti.mobile.mpp.mrtddump.i.a, com.yoti.mobile.mpp.mrtddump.h.b, com.yoti.mobile.mpp.mrtddump.h.d, long, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.i.c$b */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession", m5608f = "SecureMessagingSession.kt", m5609i = {0, 0}, m5610l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m5611m = "addCommandMac", m5612n = {"this", "encryptedCommand"}, m5613s = {"L$0", "L$1"})
    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f8115a;

        /* JADX INFO: renamed from: b */
        Object f8116b;

        /* JADX INFO: renamed from: c */
        /* synthetic */ Object f8117c;

        /* JADX INFO: renamed from: e */
        int f8119e;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8117c = obj;
            this.f8119e |= Integer.MIN_VALUE;
            return SecureMessagingSession.this.m5518c(null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.i.c$c */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession", m5608f = "SecureMessagingSession.kt", m5609i = {0, 0}, m5610l = {43}, m5611m = "encryptCommand", m5612n = {"this", "command"}, m5613s = {"L$0", "L$1"})
    static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f8120a;

        /* JADX INFO: renamed from: b */
        Object f8121b;

        /* JADX INFO: renamed from: c */
        /* synthetic */ Object f8122c;

        /* JADX INFO: renamed from: e */
        int f8124e;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8122c = obj;
            this.f8124e |= Integer.MIN_VALUE;
            return SecureMessagingSession.this.m5519d(null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.i.c$d */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession", m5608f = "SecureMessagingSession.kt", m5609i = {0}, m5610l = {26, 27}, m5611m = "prepareCommand", m5612n = {"this"}, m5613s = {"L$0"})
    static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f8125a;

        /* JADX INFO: renamed from: b */
        /* synthetic */ Object f8126b;

        /* JADX INFO: renamed from: d */
        int f8128d;

        d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8126b = obj;
            this.f8128d |= Integer.MIN_VALUE;
            return SecureMessagingSession.this.mo5509a((CommandAPDU) null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.i.c$e */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession", m5608f = "SecureMessagingSession.kt", m5609i = {0, 0}, m5610l = {33}, m5611m = "processResponse", m5612n = {"this", "response"}, m5613s = {"L$0", "L$1"})
    static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f8129a;

        /* JADX INFO: renamed from: b */
        Object f8130b;

        /* JADX INFO: renamed from: c */
        /* synthetic */ Object f8131c;

        /* JADX INFO: renamed from: e */
        int f8133e;

        e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8131c = obj;
            this.f8133e |= Integer.MIN_VALUE;
            return SecureMessagingSession.this.mo5510a((ResponseAPDU) null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SecureMessagingSession(NfcController controller, CommandBuilder commandGenerator, SecureMessagingHelper messagingHelper) {
        super(controller, commandGenerator);
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(commandGenerator, "commandGenerator");
        Intrinsics.checkNotNullParameter(messagingHelper, "messagingHelper");
        this.f8105c = messagingHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5518c(com.yoti.mobile.mpp.smartcard.CommandAPDU r11, kotlin.coroutines.Continuation<? super com.yoti.mobile.mpp.smartcard.CommandAPDU> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession.b
            if (r0 == 0) goto L13
            r0 = r12
            com.yoti.mobile.mpp.mrtddump.i.c$b r0 = (com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession.b) r0
            int r1 = r0.f8119e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8119e = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.i.c$b r0 = new com.yoti.mobile.mpp.mrtddump.i.c$b
            r0.<init>(r12)
        L18:
            r7 = r0
            java.lang.Object r12 = r7.f8117c
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f8119e
            r2 = 1
            if (r1 == 0) goto L3a
            if (r1 != r2) goto L32
            java.lang.Object r11 = r7.f8116b
            com.yoti.mobile.mpp.smartcard.CommandAPDU r11 = (com.yoti.mobile.mpp.smartcard.CommandAPDU) r11
            java.lang.Object r0 = r7.f8115a
            com.yoti.mobile.mpp.mrtddump.i.c r0 = (com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L62
        L32:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3a:
            kotlin.ResultKt.throwOnFailure(r12)
            com.yoti.mobile.mpp.mrtddump.e.c r1 = r10.f8105c
            int r12 = r11.getCla()
            int r3 = r11.getIns()
            int r4 = r11.getP1()
            int r5 = r11.getP2()
            byte[] r6 = r11.getData()
            r7.f8115a = r10
            r7.f8116b = r11
            r7.f8119e = r2
            r2 = r12
            java.lang.Object r12 = r1.m5430a(r2, r3, r4, r5, r6, r7)
            if (r12 != r0) goto L61
            return r0
        L61:
            r0 = r10
        L62:
            byte[] r12 = (byte[]) r12
            byte[] r1 = r11.getData()
            byte[] r7 = com.yoti.mobile.mpp.mrtddump.p096j.C5117a.m5521a(r1, r12)
            com.yoti.mobile.mpp.mrtddump.g.a r2 = r0.getF8098b()
            int r3 = r11.getCla()
            int r4 = r11.getIns()
            int r5 = r11.getP1()
            int r6 = r11.getP2()
            java.lang.Integer r8 = r11.getLe()
            boolean r9 = r11.getExtendedMode()
            com.yoti.mobile.mpp.smartcard.CommandAPDU r11 = r2.m5468a(r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession.m5518c(com.yoti.mobile.mpp.smartcard.CommandAPDU, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5519d(com.yoti.mobile.mpp.smartcard.CommandAPDU r11, kotlin.coroutines.Continuation<? super com.yoti.mobile.mpp.smartcard.CommandAPDU> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession.c
            if (r0 == 0) goto L13
            r0 = r12
            com.yoti.mobile.mpp.mrtddump.i.c$c r0 = (com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession.c) r0
            int r1 = r0.f8124e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8124e = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.i.c$c r0 = new com.yoti.mobile.mpp.mrtddump.i.c$c
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.f8122c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8124e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r11 = r0.f8121b
            com.yoti.mobile.mpp.smartcard.CommandAPDU r11 = (com.yoti.mobile.mpp.smartcard.CommandAPDU) r11
            java.lang.Object r0 = r0.f8120a
            com.yoti.mobile.mpp.mrtddump.i.c r0 = (com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L50
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            kotlin.ResultKt.throwOnFailure(r12)
            com.yoti.mobile.mpp.mrtddump.e.c r12 = r10.f8105c
            byte[] r2 = r11.getData()
            r0.f8120a = r10
            r0.f8121b = r11
            r0.f8124e = r3
            java.lang.Object r12 = r12.m5432a(r2, r0)
            if (r12 != r1) goto L4f
            return r1
        L4f:
            r0 = r10
        L50:
            byte[] r12 = (byte[]) r12
            com.yoti.mobile.mpp.mrtddump.e.c r1 = r0.f8105c
            java.lang.Integer r2 = r11.getLe()
            byte[] r1 = r1.m5433a(r2)
            byte[] r7 = com.yoti.mobile.mpp.mrtddump.p096j.C5117a.m5521a(r12, r1)
            com.yoti.mobile.mpp.mrtddump.g.a r2 = r0.getF8098b()
            int r12 = r11.getCla()
            r3 = r12 | 12
            int r4 = r11.getIns()
            int r5 = r11.getP1()
            int r6 = r11.getP2()
            r12 = 0
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r12)
            boolean r9 = r11.getExtendedMode()
            com.yoti.mobile.mpp.smartcard.CommandAPDU r11 = r2.m5468a(r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession.m5519d(com.yoti.mobile.mpp.smartcard.CommandAPDU, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.yoti.mobile.mpp.mrtddump.session.MessagingSession
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Object mo5509a(com.yoti.mobile.mpp.smartcard.CommandAPDU r6, kotlin.coroutines.Continuation<? super com.yoti.mobile.mpp.smartcard.CommandAPDU> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession.d
            if (r0 == 0) goto L13
            r0 = r7
            com.yoti.mobile.mpp.mrtddump.i.c$d r0 = (com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession.d) r0
            int r1 = r0.f8128d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8128d = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.i.c$d r0 = new com.yoti.mobile.mpp.mrtddump.i.c$d
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f8126b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8128d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L59
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.f8125a
            com.yoti.mobile.mpp.mrtddump.i.c r6 = (com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4b
        L3c:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.f8125a = r5
            r0.f8128d = r4
            java.lang.Object r7 = r5.m5519d(r6, r0)
            if (r7 != r1) goto L4a
            return r1
        L4a:
            r6 = r5
        L4b:
            com.yoti.mobile.mpp.smartcard.CommandAPDU r7 = (com.yoti.mobile.mpp.smartcard.CommandAPDU) r7
            r2 = 0
            r0.f8125a = r2
            r0.f8128d = r3
            java.lang.Object r7 = r6.m5518c(r7, r0)
            if (r7 != r1) goto L59
            return r1
        L59:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession.mo5509a(com.yoti.mobile.mpp.smartcard.CommandAPDU, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.yoti.mobile.mpp.mrtddump.session.MessagingSession
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Object mo5510a(com.yoti.mobile.mpp.smartcard.ResponseAPDU r6, kotlin.coroutines.Continuation<? super com.yoti.mobile.mpp.smartcard.ResponseAPDU> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession.e
            if (r0 == 0) goto L13
            r0 = r7
            com.yoti.mobile.mpp.mrtddump.i.c$e r0 = (com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession.e) r0
            int r1 = r0.f8133e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8133e = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.i.c$e r0 = new com.yoti.mobile.mpp.mrtddump.i.c$e
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f8131c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8133e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.f8130b
            com.yoti.mobile.mpp.smartcard.ResponseAPDU r6 = (com.yoti.mobile.mpp.smartcard.ResponseAPDU) r6
            java.lang.Object r0 = r0.f8129a
            com.yoti.mobile.mpp.mrtddump.i.c r0 = (com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L54
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            com.yoti.mobile.mpp.mrtddump.e.c r7 = r5.f8105c
            byte[] r2 = r6.getData()
            int r4 = r6.getSW1SW2()
            r0.f8129a = r5
            r0.f8130b = r6
            r0.f8133e = r3
            java.lang.Object r7 = r7.m5431a(r2, r4, r0)
            if (r7 != r1) goto L53
            return r1
        L53:
            r0 = r5
        L54:
            byte[] r7 = (byte[]) r7
            com.yoti.mobile.mpp.mrtddump.g.a r0 = r0.getF8098b()
            int r1 = r6.getSW1()
            int r6 = r6.getSW2()
            com.yoti.mobile.mpp.smartcard.ResponseAPDU r6 = r0.m5469a(r7, r1, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession.mo5510a(com.yoti.mobile.mpp.smartcard.ResponseAPDU, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
