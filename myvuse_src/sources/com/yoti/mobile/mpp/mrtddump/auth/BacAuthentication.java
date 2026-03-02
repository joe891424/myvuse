package com.yoti.mobile.mpp.mrtddump.auth;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.reactnativenavigation.BuildConfig;
import com.yoti.mobile.mpp.mrtddump.commands.CommandBuilder;
import com.yoti.mobile.mpp.mrtddump.commands.ICommandGenerator;
import com.yoti.mobile.mpp.mrtddump.crypto.CryptoHelper;
import com.yoti.mobile.mpp.mrtddump.crypto.CryptoMode;
import com.yoti.mobile.mpp.mrtddump.crypto.KeyDerivationFunction;
import com.yoti.mobile.mpp.mrtddump.crypto.TripleDesAuthMode;
import com.yoti.mobile.mpp.mrtddump.crypto.TripleDesMessagingMode;
import com.yoti.mobile.mpp.mrtddump.p096j.C5118b;
import com.yoti.mobile.mpp.mrtddump.p096j.C5122f;
import com.yoti.mobile.mpp.mrtddump.session.MessagingSession;
import com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\rJ#\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J!\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0083@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J!\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0083@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/auth/BacAuthentication;", "Lcom/yoti/mobile/mpp/mrtddump/auth/MrtdAuthentication;", "bacEngine", "Lcom/yoti/mobile/mpp/mrtddump/auth/BacEngine;", "messagingCrypto", "Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoMode;", "secureMessagingFactory", "Lcom/yoti/mobile/mpp/mrtddump/session/SecureMessagingSession$Factory;", "(Lcom/yoti/mobile/mpp/mrtddump/auth/BacEngine;Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoMode;Lcom/yoti/mobile/mpp/mrtddump/session/SecureMessagingSession$Factory;)V", "createSecureSession", "Lcom/yoti/mobile/mpp/mrtddump/session/SecureMessagingSession;", "session", "Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;", "(Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onApplicationSelected", "commandGenerator", "Lcom/yoti/mobile/mpp/mrtddump/commands/ICommandGenerator;", "(Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;Lcom/yoti/mobile/mpp/mrtddump/commands/ICommandGenerator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onChipConnected", "sendAuthenticate", "", "sendGetChallenge", "Companion", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class BacAuthentication implements MrtdAuthentication {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a */
    private final BacEngine f7963a;

    /* JADX INFO: renamed from: b */
    private final CryptoMode f7964b;

    /* JADX INFO: renamed from: c */
    private final SecureMessagingSession.a f7965c;

    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/auth/BacAuthentication$Companion;", "", "()V", "create", "Lcom/yoti/mobile/mpp/mrtddump/auth/BacAuthentication;", "dob", "", "doe", "documentNumber", "createRaw", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BacAuthentication create(String dob, String doe, String documentNumber) {
            Intrinsics.checkNotNullParameter(dob, "dob");
            Intrinsics.checkNotNullParameter(doe, "doe");
            Intrinsics.checkNotNullParameter(documentNumber, "documentNumber");
            return createRaw(C5122f.m5545a(dob), C5122f.m5545a(doe), C5122f.m5545a(C5122f.m5546a(documentNumber, 9)));
        }

        public final BacAuthentication createRaw(String dob, String doe, String documentNumber) {
            Intrinsics.checkNotNullParameter(dob, "dob");
            Intrinsics.checkNotNullParameter(doe, "doe");
            Intrinsics.checkNotNullParameter(documentNumber, "documentNumber");
            if (dob.length() != 7) {
                throw new IllegalArgumentException("Wrong DOB length".toString());
            }
            if (doe.length() != 7) {
                throw new IllegalArgumentException("Wrong DOE length".toString());
            }
            if (documentNumber.length() == 10) {
                return new BacAuthentication(new BacEngine(dob, doe, documentNumber, new TripleDesAuthMode(C5118b.m5528a()), new CryptoHelper(), new KeyDerivationFunction.a(), new BacState(null, null, null, null, 15, null)), new TripleDesMessagingMode(C5118b.m5528a()), new SecureMessagingSession.a(new CommandBuilder()));
            }
            throw new IllegalArgumentException("Wrong Document Number length".toString());
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication", m5608f = "BacAuthentication.kt", m5609i = {0, 0, 0, 1, 1}, m5610l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF, 57, 59}, m5611m = "onApplicationSelected", m5612n = {"this", "session", "commandGenerator", "this", "session"}, m5613s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    static final class C5076a extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f7966a;

        /* JADX INFO: renamed from: b */
        Object f7967b;

        /* JADX INFO: renamed from: c */
        Object f7968c;

        /* JADX INFO: renamed from: d */
        /* synthetic */ Object f7969d;

        /* JADX INFO: renamed from: f */
        int f7971f;

        C5076a(Continuation<? super C5076a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7969d = obj;
            this.f7971f |= Integer.MIN_VALUE;
            return BacAuthentication.this.onApplicationSelected(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication$b */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication", m5608f = "BacAuthentication.kt", m5609i = {0, 0, 0, 1}, m5610l = {87, 90, 102}, m5611m = "sendAuthenticate", m5612n = {"this", "session", "commandGenerator", "this"}, m5613s = {"L$0", "L$1", "L$2", "L$0"})
    static final class C5077b extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f7972a;

        /* JADX INFO: renamed from: b */
        Object f7973b;

        /* JADX INFO: renamed from: c */
        Object f7974c;

        /* JADX INFO: renamed from: d */
        /* synthetic */ Object f7975d;

        /* JADX INFO: renamed from: f */
        int f7977f;

        C5077b(Continuation<? super C5077b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7975d = obj;
            this.f7977f |= Integer.MIN_VALUE;
            return BacAuthentication.this.m5383a(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication$c */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication", m5608f = "BacAuthentication.kt", m5609i = {0}, m5610l = {BuildConfig.REACT_NATVE_VERSION_MINOR}, m5611m = "sendGetChallenge", m5612n = {"this"}, m5613s = {"L$0"})
    static final class C5078c extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f7978a;

        /* JADX INFO: renamed from: b */
        /* synthetic */ Object f7979b;

        /* JADX INFO: renamed from: d */
        int f7981d;

        C5078c(Continuation<? super C5078c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7979b = obj;
            this.f7981d |= Integer.MIN_VALUE;
            return BacAuthentication.this.m5386b(null, null, this);
        }
    }

    public BacAuthentication(BacEngine bacEngine, CryptoMode messagingCrypto, SecureMessagingSession.a secureMessagingFactory) {
        Intrinsics.checkNotNullParameter(bacEngine, "bacEngine");
        Intrinsics.checkNotNullParameter(messagingCrypto, "messagingCrypto");
        Intrinsics.checkNotNullParameter(secureMessagingFactory, "secureMessagingFactory");
        this.f7963a = bacEngine;
        this.f7964b = messagingCrypto;
        this.f7965c = secureMessagingFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5383a(com.yoti.mobile.mpp.mrtddump.session.MessagingSession r8, com.yoti.mobile.mpp.mrtddump.commands.ICommandGenerator r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) throws com.yoti.mobile.mpp.mrtddump.MrtdInvalidAuthDataException, com.yoti.mobile.mpp.mrtddump.MrtdCommandFailedException {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication.C5077b
            if (r0 == 0) goto L13
            r0 = r10
            com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication$b r0 = (com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication.C5077b) r0
            int r1 = r0.f7977f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7977f = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication$b r0 = new com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication$b
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f7975d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f7977f
            r3 = 3
            r4 = 1
            r5 = 2
            r6 = 0
            if (r2 == 0) goto L52
            if (r2 == r4) goto L41
            if (r2 == r5) goto L39
            if (r2 != r3) goto L31
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lbe
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            java.lang.Object r8 = r0.f7972a
            com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication r8 = (com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L7d
        L41:
            java.lang.Object r8 = r0.f7974c
            r9 = r8
            com.yoti.mobile.mpp.mrtddump.g.f r9 = (com.yoti.mobile.mpp.mrtddump.commands.ICommandGenerator) r9
            java.lang.Object r8 = r0.f7973b
            com.yoti.mobile.mpp.mrtddump.i.a r8 = (com.yoti.mobile.mpp.mrtddump.session.MessagingSession) r8
            java.lang.Object r2 = r0.f7972a
            com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication r2 = (com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L67
        L52:
            kotlin.ResultKt.throwOnFailure(r10)
            com.yoti.mobile.mpp.mrtddump.auth.a r10 = r7.f7963a
            r0.f7972a = r7
            r0.f7973b = r8
            r0.f7974c = r9
            r0.f7977f = r4
            java.lang.Object r10 = r10.m5398a(r0)
            if (r10 != r1) goto L66
            return r1
        L66:
            r2 = r7
        L67:
            byte[] r10 = (byte[]) r10
            com.yoti.mobile.mpp.smartcard.CommandAPDU r9 = r9.mo5475a(r10)
            r0.f7972a = r2
            r0.f7973b = r6
            r0.f7974c = r6
            r0.f7977f = r5
            java.lang.Object r10 = r8.m5513b(r9, r0)
            if (r10 != r1) goto L7c
            return r1
        L7c:
            r8 = r2
        L7d:
            com.yoti.mobile.mpp.smartcard.ResponseAPDU r10 = (com.yoti.mobile.mpp.smartcard.ResponseAPDU) r10
            boolean r9 = r10.getIsSuccess()
            if (r9 != 0) goto Lad
            int r8 = r10.getSW1()
            r9 = 99
            if (r8 != r9) goto La1
            com.yoti.mobile.mpp.mrtddump.MrtdInvalidAuthDataException r8 = new com.yoti.mobile.mpp.mrtddump.MrtdInvalidAuthDataException
            int r9 = r10.getSW1SW2()
            java.lang.String r9 = com.yoti.mobile.mpp.smartcard.extensions.IntKt.toStringHex(r9)
            java.lang.String r10 = "Invalid auth data for BAC: "
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r9)
            r8.<init>(r9, r6, r5, r6)
            throw r8
        La1:
            com.yoti.mobile.mpp.mrtddump.MrtdCommandFailedException r8 = new com.yoti.mobile.mpp.mrtddump.MrtdCommandFailedException
            int r9 = r10.getSW1SW2()
            java.lang.String r10 = "EXTERNAL AUTHENTICATE"
            r8.<init>(r10, r9)
            throw r8
        Lad:
            com.yoti.mobile.mpp.mrtddump.auth.a r8 = r8.f7963a
            byte[] r9 = r10.getData()
            r0.f7972a = r6
            r0.f7977f = r3
            java.lang.Object r8 = r8.m5399a(r9, r0)
            if (r8 != r1) goto Lbe
            return r1
        Lbe:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication.m5383a(com.yoti.mobile.mpp.mrtddump.i.a, com.yoti.mobile.mpp.mrtddump.g.f, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: a */
    private final Object m5384a(MessagingSession messagingSession, Continuation<? super SecureMessagingSession> continuation) {
        return this.f7965c.m5520a(messagingSession, this.f7964b, this.f7963a.m5402d(), this.f7963a.m5401c(), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5386b(com.yoti.mobile.mpp.mrtddump.session.MessagingSession r5, com.yoti.mobile.mpp.mrtddump.commands.ICommandGenerator r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws com.yoti.mobile.mpp.mrtddump.MrtdCommandFailedException {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication.C5078c
            if (r0 == 0) goto L13
            r0 = r7
            com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication$c r0 = (com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication.C5078c) r0
            int r1 = r0.f7981d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7981d = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication$c r0 = new com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f7979b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f7981d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f7978a
            com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication r5 = (com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L48
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            com.yoti.mobile.mpp.smartcard.CommandAPDU r6 = r6.mo5470a()
            r0.f7978a = r4
            r0.f7981d = r3
            java.lang.Object r7 = r5.m5513b(r6, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            r5 = r4
        L48:
            com.yoti.mobile.mpp.smartcard.ResponseAPDU r7 = (com.yoti.mobile.mpp.smartcard.ResponseAPDU) r7
            boolean r6 = r7.getIsSuccess()
            if (r6 == 0) goto L5c
            com.yoti.mobile.mpp.mrtddump.auth.a r5 = r5.f7963a
            byte[] r6 = r7.getData()
            r5.m5400a(r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L5c:
            com.yoti.mobile.mpp.mrtddump.MrtdCommandFailedException r5 = new com.yoti.mobile.mpp.mrtddump.MrtdCommandFailedException
            int r6 = r7.getSW1SW2()
            java.lang.String r7 = "GET CHALLENGE"
            r5.<init>(r7, r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication.m5386b(com.yoti.mobile.mpp.mrtddump.i.a, com.yoti.mobile.mpp.mrtddump.g.f, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008c A[PHI: r10
      0x008c: PHI (r10v8 java.lang.Object) = (r10v7 java.lang.Object), (r10v1 java.lang.Object) binds: [B:26:0x0089, B:13:0x002c] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.yoti.mobile.mpp.mrtddump.auth.MrtdAuthentication
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object onApplicationSelected(com.yoti.mobile.mpp.mrtddump.session.MessagingSession r8, com.yoti.mobile.mpp.mrtddump.commands.ICommandGenerator r9, kotlin.coroutines.Continuation<? super com.yoti.mobile.mpp.mrtddump.session.SecureMessagingSession> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication.C5076a
            if (r0 == 0) goto L13
            r0 = r10
            com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication$a r0 = (com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication.C5076a) r0
            int r1 = r0.f7971f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7971f = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication$a r0 = new com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f7969d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f7971f
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L57
            if (r2 == r5) goto L44
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            kotlin.ResultKt.throwOnFailure(r10)
            goto L8c
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            java.lang.Object r8 = r0.f7967b
            com.yoti.mobile.mpp.mrtddump.i.a r8 = (com.yoti.mobile.mpp.mrtddump.session.MessagingSession) r8
            java.lang.Object r9 = r0.f7966a
            com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication r9 = (com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L7f
        L44:
            java.lang.Object r8 = r0.f7968c
            r9 = r8
            com.yoti.mobile.mpp.mrtddump.g.f r9 = (com.yoti.mobile.mpp.mrtddump.commands.ICommandGenerator) r9
            java.lang.Object r8 = r0.f7967b
            com.yoti.mobile.mpp.mrtddump.i.a r8 = (com.yoti.mobile.mpp.mrtddump.session.MessagingSession) r8
            java.lang.Object r2 = r0.f7966a
            com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication r2 = (com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication) r2
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            r9 = r2
            goto L70
        L57:
            kotlin.ResultKt.throwOnFailure(r10)
            com.yoti.mobile.mpp.mrtddump.auth.a r10 = r7.f7963a
            r10.m5403e()
            r0.f7966a = r7
            r0.f7967b = r8
            r0.f7968c = r9
            r0.f7971f = r5
            java.lang.Object r10 = r7.m5386b(r8, r9, r0)
            if (r10 != r1) goto L6e
            return r1
        L6e:
            r10 = r9
            r9 = r7
        L70:
            r0.f7966a = r9
            r0.f7967b = r8
            r0.f7968c = r6
            r0.f7971f = r4
            java.lang.Object r10 = r9.m5383a(r8, r10, r0)
            if (r10 != r1) goto L7f
            return r1
        L7f:
            r0.f7966a = r6
            r0.f7967b = r6
            r0.f7971f = r3
            java.lang.Object r10 = r9.m5384a(r8, r0)
            if (r10 != r1) goto L8c
            return r1
        L8c:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.auth.BacAuthentication.onApplicationSelected(com.yoti.mobile.mpp.mrtddump.i.a, com.yoti.mobile.mpp.mrtddump.g.f, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.yoti.mobile.mpp.mrtddump.auth.MrtdAuthentication
    public Object onChipConnected(MessagingSession messagingSession, ICommandGenerator iCommandGenerator, Continuation<? super SecureMessagingSession> continuation) {
        return null;
    }
}
