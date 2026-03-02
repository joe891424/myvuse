package com.yoti.mobile.mpp.mrtddump.auth;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.yoti.mobile.mpp.mrtddump.EncryptionKey;
import com.yoti.mobile.mpp.mrtddump.MacKey;
import com.yoti.mobile.mpp.mrtddump.MrtdAuthException;
import com.yoti.mobile.mpp.mrtddump.crypto.CryptoHelper;
import com.yoti.mobile.mpp.mrtddump.crypto.CryptoMode;
import com.yoti.mobile.mpp.mrtddump.crypto.KeyDerivationFunction;
import com.yoti.mobile.mpp.mrtddump.p096j.C5117a;
import com.yoti.mobile.mpp.mrtddump.p096j.C5121e;
import io.ktor.utils.p098io.charsets.CharsetJVMKt;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.auth.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ-\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\f\u0010\u001a\u001a\u00060\u0017j\u0002`\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\u0015\u0010\u001d\u001a\u00060\u0017j\u0002`\u001bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u0011J\u001d\u0010$\u001a\u00020\u00112\n\u0010%\u001a\u00060\u0017j\u0002`\u001bH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0012\u0010'\u001a\u00020\u00112\n\u0010(\u001a\u00060\u0017j\u0002`)R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/auth/BacEngine;", "", "dob", "", "doe", "documentNumber", "crypto", "Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoMode;", "randomGenerator", "Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoHelper;", "keyDerivationFactory", "Lcom/yoti/mobile/mpp/mrtddump/crypto/KeyDerivationFunction$Factory;", "state", "Lcom/yoti/mobile/mpp/mrtddump/auth/BacState;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoMode;Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoHelper;Lcom/yoti/mobile/mpp/mrtddump/crypto/KeyDerivationFunction$Factory;Lcom/yoti/mobile/mpp/mrtddump/auth/BacState;)V", "asyncInit", "Lkotlinx/coroutines/Deferred;", "", "encryptKey", "Lcom/yoti/mobile/mpp/mrtddump/EncryptionKey;", "macKey", "Lcom/yoti/mobile/mpp/mrtddump/MacKey;", "deriveBacKeySeed", "", "Lcom/yoti/mobile/mpp/mrtddump/KeySeed;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateKeySeed", "Lcom/yoti/mobile/mpp/mrtddump/GenericData;", "generateRandomData", "getAuthDataPayload", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInitialSsc", "", "getSessionKeyGenerator", "Lcom/yoti/mobile/mpp/mrtddump/crypto/KeyDerivationFunction;", "reset", "setAuthResponseData", "responseData", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setChallenge", "challengeResponse", "Lcom/yoti/mobile/mpp/mrtddump/Nonce;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class BacEngine {

    /* JADX INFO: renamed from: a */
    private final String f7982a;

    /* JADX INFO: renamed from: b */
    private final String f7983b;

    /* JADX INFO: renamed from: c */
    private final String f7984c;

    /* JADX INFO: renamed from: d */
    private final CryptoMode f7985d;

    /* JADX INFO: renamed from: e */
    private final CryptoHelper f7986e;

    /* JADX INFO: renamed from: f */
    private final KeyDerivationFunction.a f7987f;

    /* JADX INFO: renamed from: g */
    private final BacState f7988g;

    /* JADX INFO: renamed from: h */
    private EncryptionKey f7989h;

    /* JADX INFO: renamed from: i */
    private MacKey f7990i;

    /* JADX INFO: renamed from: j */
    private final Deferred<Unit> f7991j;

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.auth.a$a */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.auth.BacEngine$asyncInit$1", m5608f = "BacEngine.kt", m5609i = {1}, m5610l = {48, ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, 50}, m5611m = "invokeSuspend", m5612n = {"keyGenerator"}, m5613s = {"L$0"})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        Object f7992a;

        /* JADX INFO: renamed from: b */
        Object f7993b;

        /* JADX INFO: renamed from: c */
        int f7994c;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BacEngine.this.new a(continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0097 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0098  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.f7994c
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L3a
                if (r1 == r4) goto L2e
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                java.lang.Object r0 = r10.f7992a
                com.yoti.mobile.mpp.mrtddump.auth.a r0 = (com.yoti.mobile.mpp.mrtddump.auth.BacEngine) r0
                kotlin.ResultKt.throwOnFailure(r11)
                goto L9a
            L1a:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L22:
                java.lang.Object r1 = r10.f7993b
                com.yoti.mobile.mpp.mrtddump.auth.a r1 = (com.yoti.mobile.mpp.mrtddump.auth.BacEngine) r1
                java.lang.Object r3 = r10.f7992a
                com.yoti.mobile.mpp.mrtddump.h.d r3 = (com.yoti.mobile.mpp.mrtddump.crypto.KeyDerivationFunction) r3
                kotlin.ResultKt.throwOnFailure(r11)
                goto L83
            L2e:
                java.lang.Object r1 = r10.f7993b
                com.yoti.mobile.mpp.mrtddump.h.b r1 = (com.yoti.mobile.mpp.mrtddump.crypto.CryptoMode) r1
                java.lang.Object r4 = r10.f7992a
                com.yoti.mobile.mpp.mrtddump.h.d$a r4 = (com.yoti.mobile.mpp.mrtddump.crypto.KeyDerivationFunction.a) r4
                kotlin.ResultKt.throwOnFailure(r11)
                goto L6b
            L3a:
                kotlin.ResultKt.throwOnFailure(r11)
                com.yoti.mobile.mpp.mrtddump.auth.a r11 = com.yoti.mobile.mpp.mrtddump.auth.BacEngine.this
                com.yoti.mobile.mpp.mrtddump.h.d$a r11 = com.yoti.mobile.mpp.mrtddump.auth.BacEngine.m5397e(r11)
                com.yoti.mobile.mpp.mrtddump.auth.a r1 = com.yoti.mobile.mpp.mrtddump.auth.BacEngine.this
                com.yoti.mobile.mpp.mrtddump.h.b r1 = com.yoti.mobile.mpp.mrtddump.auth.BacEngine.m5387a(r1)
                com.yoti.mobile.mpp.mrtddump.auth.a r5 = com.yoti.mobile.mpp.mrtddump.auth.BacEngine.this
                java.lang.String r6 = com.yoti.mobile.mpp.mrtddump.auth.BacEngine.m5393b(r5)
                com.yoti.mobile.mpp.mrtddump.auth.a r7 = com.yoti.mobile.mpp.mrtddump.auth.BacEngine.this
                java.lang.String r7 = com.yoti.mobile.mpp.mrtddump.auth.BacEngine.m5396d(r7)
                com.yoti.mobile.mpp.mrtddump.auth.a r8 = com.yoti.mobile.mpp.mrtddump.auth.BacEngine.this
                java.lang.String r8 = com.yoti.mobile.mpp.mrtddump.auth.BacEngine.m5395c(r8)
                r10.f7992a = r11
                r10.f7993b = r1
                r10.f7994c = r4
                java.lang.Object r4 = com.yoti.mobile.mpp.mrtddump.auth.BacEngine.m5388a(r5, r6, r7, r8, r10)
                if (r4 != r0) goto L68
                return r0
            L68:
                r9 = r4
                r4 = r11
                r11 = r9
            L6b:
                byte[] r11 = (byte[]) r11
                com.yoti.mobile.mpp.mrtddump.h.d r11 = r4.m5489a(r1, r11)
                com.yoti.mobile.mpp.mrtddump.auth.a r1 = com.yoti.mobile.mpp.mrtddump.auth.BacEngine.this
                r10.f7992a = r11
                r10.f7993b = r1
                r10.f7994c = r3
                java.lang.Object r3 = r11.m5487a(r10)
                if (r3 != r0) goto L80
                return r0
            L80:
                r9 = r3
                r3 = r11
                r11 = r9
            L83:
                com.yoti.mobile.mpp.mrtddump.a r11 = (com.yoti.mobile.mpp.mrtddump.EncryptionKey) r11
                com.yoti.mobile.mpp.mrtddump.auth.BacEngine.m5390a(r1, r11)
                com.yoti.mobile.mpp.mrtddump.auth.a r11 = com.yoti.mobile.mpp.mrtddump.auth.BacEngine.this
                r10.f7992a = r11
                r1 = 0
                r10.f7993b = r1
                r10.f7994c = r2
                java.lang.Object r1 = r3.m5488b(r10)
                if (r1 != r0) goto L98
                return r0
            L98:
                r0 = r11
                r11 = r1
            L9a:
                com.yoti.mobile.mpp.mrtddump.c r11 = (com.yoti.mobile.mpp.mrtddump.MacKey) r11
                com.yoti.mobile.mpp.mrtddump.auth.BacEngine.m5391a(r0, r11)
                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.auth.BacEngine.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.auth.a$b */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.auth.BacEngine", m5608f = "BacEngine.kt", m5609i = {0, 1, 2}, m5610l = {97, 103, 105}, m5611m = "getAuthDataPayload", m5612n = {"this", "this", "eIfd"}, m5613s = {"L$0", "L$0", "L$0"})
    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f7996a;

        /* JADX INFO: renamed from: b */
        /* synthetic */ Object f7997b;

        /* JADX INFO: renamed from: d */
        int f7999d;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7997b = obj;
            this.f7999d |= Integer.MIN_VALUE;
            return BacEngine.this.m5398a(this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.auth.a$c */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.auth.BacEngine", m5608f = "BacEngine.kt", m5609i = {0, 0, 1, 1, 1, 2}, m5610l = {120, 129, 138}, m5611m = "setAuthResponseData", m5612n = {"this", "responseData", "this", "eIc", "mIc", "this"}, m5613s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0"})
    static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f8000a;

        /* JADX INFO: renamed from: b */
        Object f8001b;

        /* JADX INFO: renamed from: c */
        Object f8002c;

        /* JADX INFO: renamed from: d */
        /* synthetic */ Object f8003d;

        /* JADX INFO: renamed from: f */
        int f8005f;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8003d = obj;
            this.f8005f |= Integer.MIN_VALUE;
            return BacEngine.this.m5399a((byte[]) null, this);
        }
    }

    public BacEngine(String dob, String doe, String documentNumber, CryptoMode crypto, CryptoHelper randomGenerator, KeyDerivationFunction.a keyDerivationFactory, BacState state) {
        Intrinsics.checkNotNullParameter(dob, "dob");
        Intrinsics.checkNotNullParameter(doe, "doe");
        Intrinsics.checkNotNullParameter(documentNumber, "documentNumber");
        Intrinsics.checkNotNullParameter(crypto, "crypto");
        Intrinsics.checkNotNullParameter(randomGenerator, "randomGenerator");
        Intrinsics.checkNotNullParameter(keyDerivationFactory, "keyDerivationFactory");
        Intrinsics.checkNotNullParameter(state, "state");
        this.f7982a = dob;
        this.f7983b = doe;
        this.f7984c = documentNumber;
        this.f7985d = crypto;
        this.f7986e = randomGenerator;
        this.f7987f = keyDerivationFactory;
        this.f7988g = state;
        this.f7991j = BuildersKt.async(GlobalScope.INSTANCE, Dispatchers.getUnconfined(), CoroutineStart.LAZY, new a(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final Object m5389a(String str, String str2, String str3, Continuation<? super byte[]> continuation) {
        CharsetEncoder charsetEncoderNewEncoder = Charsets.UTF_8.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
        byte[] bArrEncodeToByteArray = CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder, str3, 0, str3.length());
        CharsetEncoder charsetEncoderNewEncoder2 = Charsets.UTF_8.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder2, "charset.newEncoder()");
        byte[] bArrEncodeToByteArray2 = CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder2, str, 0, str.length());
        CharsetEncoder charsetEncoderNewEncoder3 = Charsets.UTF_8.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder3, "charset.newEncoder()");
        return this.f7985d.mo5482a(C5117a.m5525b(bArrEncodeToByteArray, bArrEncodeToByteArray2, CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder3, str2, 0, str2.length())), continuation);
    }

    /* JADX INFO: renamed from: a */
    private final byte[] m5392a() {
        return C5117a.m5527c(this.f7988g.m5414f(), this.f7988g.m5413e());
    }

    /* JADX INFO: renamed from: b */
    private final void m5394b() {
        this.f7988g.m5411d(this.f7986e.m5478a(8));
        this.f7988g.m5407b(this.f7986e.m5478a(this.f7985d.getF8088c()));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5398a(kotlin.coroutines.Continuation<? super byte[]> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.yoti.mobile.mpp.mrtddump.auth.BacEngine.b
            if (r0 == 0) goto L13
            r0 = r10
            com.yoti.mobile.mpp.mrtddump.auth.a$b r0 = (com.yoti.mobile.mpp.mrtddump.auth.BacEngine.b) r0
            int r1 = r0.f7999d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7999d = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.auth.a$b r0 = new com.yoti.mobile.mpp.mrtddump.auth.a$b
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f7997b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f7999d
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L4d
            if (r2 == r6) goto L45
            if (r2 == r5) goto L3d
            if (r2 != r4) goto L35
            java.lang.Object r0 = r0.f7996a
            byte[] r0 = (byte[]) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lab
        L35:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3d:
            java.lang.Object r2 = r0.f7996a
            com.yoti.mobile.mpp.mrtddump.auth.a r2 = (com.yoti.mobile.mpp.mrtddump.auth.BacEngine) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L8e
        L45:
            java.lang.Object r2 = r0.f7996a
            com.yoti.mobile.mpp.mrtddump.auth.a r2 = (com.yoti.mobile.mpp.mrtddump.auth.BacEngine) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L5e
        L4d:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.Deferred<kotlin.Unit> r10 = r9.f7991j
            r0.f7996a = r9
            r0.f7999d = r6
            java.lang.Object r10 = r10.await(r0)
            if (r10 != r1) goto L5d
            return r1
        L5d:
            r2 = r9
        L5e:
            r2.m5394b()
            com.yoti.mobile.mpp.mrtddump.auth.b r10 = r2.f7988g
            byte[] r10 = r10.m5416h()
            com.yoti.mobile.mpp.mrtddump.auth.b r6 = r2.f7988g
            byte[] r6 = r6.m5415g()
            com.yoti.mobile.mpp.mrtddump.auth.b r7 = r2.f7988g
            byte[] r7 = r7.m5414f()
            byte[] r10 = com.yoti.mobile.mpp.mrtddump.p096j.C5117a.m5525b(r10, r6, r7)
            com.yoti.mobile.mpp.mrtddump.h.b r6 = r2.f7985d
            com.yoti.mobile.mpp.mrtddump.a r7 = r2.f7989h
            if (r7 != 0) goto L83
            java.lang.String r7 = "encryptKey"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r7 = r3
        L83:
            r0.f7996a = r2
            r0.f7999d = r5
            java.lang.Object r10 = r6.mo5483b(r10, r7, r0)
            if (r10 != r1) goto L8e
            return r1
        L8e:
            byte[] r10 = (byte[]) r10
            com.yoti.mobile.mpp.mrtddump.h.b r5 = r2.f7985d
            com.yoti.mobile.mpp.mrtddump.c r2 = r2.f7990i
            if (r2 != 0) goto L9c
            java.lang.String r2 = "macKey"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L9d
        L9c:
            r3 = r2
        L9d:
            r0.f7996a = r10
            r0.f7999d = r4
            java.lang.Object r0 = r5.mo5481a(r10, r3, r0)
            if (r0 != r1) goto La8
            return r1
        La8:
            r8 = r0
            r0 = r10
            r10 = r8
        Lab:
            byte[] r10 = (byte[]) r10
            byte[] r10 = com.yoti.mobile.mpp.mrtddump.p096j.C5117a.m5524b(r0, r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.auth.BacEngine.m5398a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5399a(byte[] r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws com.yoti.mobile.mpp.mrtddump.MrtdAuthException {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.auth.BacEngine.m5399a(byte[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: a */
    public final void m5400a(byte[] challengeResponse) {
        Intrinsics.checkNotNullParameter(challengeResponse, "challengeResponse");
        if (challengeResponse.length != 8) {
            throw new MrtdAuthException("Unexpected challenge length (" + challengeResponse.length + ')', null, 2, null);
        }
        this.f7988g.m5409c(challengeResponse);
    }

    /* JADX INFO: renamed from: c */
    public final long m5401c() {
        byte[] bArr = new byte[8];
        ArraysKt.copyInto(this.f7988g.m5415g(), bArr, 0, 4, 8);
        ArraysKt.copyInto(this.f7988g.m5416h(), bArr, 4, 4, 8);
        return C5121e.m5542a(bArr);
    }

    /* JADX INFO: renamed from: d */
    public final KeyDerivationFunction m5402d() {
        return this.f7987f.m5489a(this.f7985d, m5392a());
    }

    /* JADX INFO: renamed from: e */
    public final void m5403e() {
        this.f7988g.m5409c(null);
        this.f7988g.m5411d(null);
        this.f7988g.m5405a(null);
        this.f7988g.m5407b(null);
    }
}
