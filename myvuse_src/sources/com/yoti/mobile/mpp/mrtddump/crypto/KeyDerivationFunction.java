package com.yoti.mobile.mpp.mrtddump.crypto;

import com.yoti.mobile.mpp.mrtddump.p096j.C5117a;
import com.yoti.mobile.mpp.smartcard.extensions.IntKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.d, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0012B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007J)\u0010\b\u001a\u00060\u0005j\u0002`\t2\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/crypto/KeyDerivationFunction;", "", "crypto", "Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoMode;", "seed", "", "Lcom/yoti/mobile/mpp/mrtddump/KeySeed;", "(Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoMode;[B)V", "deriveKey", "Lcom/yoti/mobile/mpp/mrtddump/Hash;", "counter", "", "([BILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateEncryptionKey", "Lcom/yoti/mobile/mpp/mrtddump/EncryptionKey;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateMacKey", "Lcom/yoti/mobile/mpp/mrtddump/MacKey;", "Factory", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class KeyDerivationFunction {

    /* JADX INFO: renamed from: a */
    private final CryptoMode f8062a;

    /* JADX INFO: renamed from: b */
    private final byte[] f8063b;

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.d$a */
    @Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\t¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/crypto/KeyDerivationFunction$Factory;", "", "()V", "create", "Lcom/yoti/mobile/mpp/mrtddump/crypto/KeyDerivationFunction;", "crypto", "Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoMode;", "seed", "", "Lcom/yoti/mobile/mpp/mrtddump/KeySeed;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a {
        /* JADX INFO: renamed from: a */
        public final KeyDerivationFunction m5489a(CryptoMode crypto, byte[] seed) {
            Intrinsics.checkNotNullParameter(crypto, "crypto");
            Intrinsics.checkNotNullParameter(seed, "seed");
            return new KeyDerivationFunction(crypto, seed);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.d$b */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.crypto.KeyDerivationFunction", m5608f = "KeyDerivationFunction.kt", m5609i = {}, m5610l = {27}, m5611m = "generateEncryptionKey", m5612n = {}, m5613s = {})
    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        /* synthetic */ Object f8064a;

        /* JADX INFO: renamed from: c */
        int f8066c;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8064a = obj;
            this.f8066c |= Integer.MIN_VALUE;
            return KeyDerivationFunction.this.m5487a(this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.d$c */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.crypto.KeyDerivationFunction", m5608f = "KeyDerivationFunction.kt", m5609i = {}, m5610l = {34}, m5611m = "generateMacKey", m5612n = {}, m5613s = {})
    static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        /* synthetic */ Object f8067a;

        /* JADX INFO: renamed from: c */
        int f8069c;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8067a = obj;
            this.f8069c |= Integer.MIN_VALUE;
            return KeyDerivationFunction.this.m5488b(this);
        }
    }

    public KeyDerivationFunction(CryptoMode crypto, byte[] seed) {
        Intrinsics.checkNotNullParameter(crypto, "crypto");
        Intrinsics.checkNotNullParameter(seed, "seed");
        this.f8062a = crypto;
        this.f8063b = seed;
    }

    /* JADX INFO: renamed from: a */
    private final Object m5486a(byte[] bArr, int i, Continuation<? super byte[]> continuation) {
        return this.f8062a.mo5482a(C5117a.m5524b(bArr, IntKt.toByteArray(i, 4)), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5487a(kotlin.coroutines.Continuation<? super com.yoti.mobile.mpp.mrtddump.EncryptionKey> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.yoti.mobile.mpp.mrtddump.crypto.KeyDerivationFunction.b
            if (r0 == 0) goto L13
            r0 = r5
            com.yoti.mobile.mpp.mrtddump.h.d$b r0 = (com.yoti.mobile.mpp.mrtddump.crypto.KeyDerivationFunction.b) r0
            int r1 = r0.f8066c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8066c = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.h.d$b r0 = new com.yoti.mobile.mpp.mrtddump.h.d$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f8064a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8066c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            byte[] r5 = r4.f8063b
            r0.f8066c = r3
            java.lang.Object r5 = r4.m5486a(r5, r3, r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            byte[] r5 = (byte[]) r5
            com.yoti.mobile.mpp.mrtddump.a r0 = new com.yoti.mobile.mpp.mrtddump.a
            r0.<init>(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.crypto.KeyDerivationFunction.m5487a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5488b(kotlin.coroutines.Continuation<? super com.yoti.mobile.mpp.mrtddump.MacKey> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.yoti.mobile.mpp.mrtddump.crypto.KeyDerivationFunction.c
            if (r0 == 0) goto L13
            r0 = r5
            com.yoti.mobile.mpp.mrtddump.h.d$c r0 = (com.yoti.mobile.mpp.mrtddump.crypto.KeyDerivationFunction.c) r0
            int r1 = r0.f8069c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8069c = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.h.d$c r0 = new com.yoti.mobile.mpp.mrtddump.h.d$c
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f8067a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8069c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L40
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            byte[] r5 = r4.f8063b
            r0.f8069c = r3
            r2 = 2
            java.lang.Object r5 = r4.m5486a(r5, r2, r0)
            if (r5 != r1) goto L40
            return r1
        L40:
            byte[] r5 = (byte[]) r5
            com.yoti.mobile.mpp.mrtddump.c r0 = new com.yoti.mobile.mpp.mrtddump.c
            r0.<init>(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.crypto.KeyDerivationFunction.m5488b(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
