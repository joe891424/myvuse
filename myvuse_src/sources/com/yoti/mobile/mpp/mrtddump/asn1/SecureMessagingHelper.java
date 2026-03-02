package com.yoti.mobile.mpp.mrtddump.asn1;

import com.yoti.mobile.mpp.mrtddump.EncryptionKey;
import com.yoti.mobile.mpp.mrtddump.MacKey;
import com.yoti.mobile.mpp.mrtddump.crypto.CryptoMode;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import com.yoti.mobile.mpp.smartcard.extensions.IntKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.e.c, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ-\u0010\u000b\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0012JE\u0010\u0013\u001a\u00060\fj\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u000e\u0010\u0019\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ)\u0010\u001b\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\u00142\u000e\u0010\u001c\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001e\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010 J-\u0010!\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r2\n\u0010\"\u001a\u00060\fj\u0002`\u00142\u0006\u0010#\u001a\u00020\u0010H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020&H\u0002J0\u0010'\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`(2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J-\u0010)\u001a\u00020&2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u0006\u0010*\u001a\u00020\u0010H\u0083@ø\u0001\u0000¢\u0006\u0002\u0010+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/asn1/SecureMessagingHelper;", "", "crypto", "Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoMode;", "encryptKey", "Lcom/yoti/mobile/mpp/mrtddump/EncryptionKey;", "macKey", "Lcom/yoti/mobile/mpp/mrtddump/MacKey;", "state", "Lcom/yoti/mobile/mpp/mrtddump/asn1/MessagingState;", "(Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoMode;Lcom/yoti/mobile/mpp/mrtddump/EncryptionKey;Lcom/yoti/mobile/mpp/mrtddump/MacKey;Lcom/yoti/mobile/mpp/mrtddump/asn1/MessagingState;)V", "decryptResponseDataBlock", "", "Lcom/yoti/mobile/mpp/mrtddump/PlainData;", "dataBlocks", "", "", "Lcom/yoti/mobile/mpp/mrtddump/asn1/PartialTlvObject;", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateChecksumBlock", "Lcom/yoti/mobile/mpp/mrtddump/SecureMessagingData;", "cla", "ins", "p1", "p2", "commandData", "(IIII[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateEncryptedDataBlock", "data", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateWrappedLeBlock", "le", "(Ljava/lang/Integer;)[B", "getDecryptedResponseData", "encryptedData", "expectedResponseStatus", "([BILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementSsc", "", "padControlBytesForMac", "Lcom/yoti/mobile/mpp/mrtddump/GenericData;", "validateResponseData", "expectedStatus", "(Ljava/util/Map;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SecureMessagingHelper {

    /* JADX INFO: renamed from: a */
    private final CryptoMode f8014a;

    /* JADX INFO: renamed from: b */
    private final EncryptionKey f8015b;

    /* JADX INFO: renamed from: c */
    private final MacKey f8016c;

    /* JADX INFO: renamed from: d */
    private final MessagingState f8017d;

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.e.c$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper", m5608f = "SecureMessagingHelper.kt", m5609i = {}, m5610l = {ISO7816Kt.INS_READ_BINARY, 186}, m5611m = "decryptResponseDataBlock", m5612n = {}, m5613s = {})
    static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        /* synthetic */ Object f8018a;

        /* JADX INFO: renamed from: c */
        int f8020c;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8018a = obj;
            this.f8020c |= Integer.MIN_VALUE;
            return SecureMessagingHelper.this.m5427a((Map<Integer, PartialTlvObject>) null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.e.c$b */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper", m5608f = "SecureMessagingHelper.kt", m5609i = {}, m5610l = {78}, m5611m = "generateChecksumBlock", m5612n = {}, m5613s = {})
    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        /* synthetic */ Object f8021a;

        /* JADX INFO: renamed from: c */
        int f8023c;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8021a = obj;
            this.f8023c |= Integer.MIN_VALUE;
            return SecureMessagingHelper.this.m5430a(0, 0, 0, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.e.c$c */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper", m5608f = "SecureMessagingHelper.kt", m5609i = {}, m5610l = {37}, m5611m = "generateEncryptedDataBlock", m5612n = {}, m5613s = {})
    static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        /* synthetic */ Object f8024a;

        /* JADX INFO: renamed from: c */
        int f8026c;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8024a = obj;
            this.f8026c |= Integer.MIN_VALUE;
            return SecureMessagingHelper.this.m5432a((byte[]) null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.e.c$d */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper", m5608f = "SecureMessagingHelper.kt", m5609i = {0, 0}, m5610l = {129, 131}, m5611m = "getDecryptedResponseData", m5612n = {"this", "smBlocks"}, m5613s = {"L$0", "L$1"})
    static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f8027a;

        /* JADX INFO: renamed from: b */
        Object f8028b;

        /* JADX INFO: renamed from: c */
        /* synthetic */ Object f8029c;

        /* JADX INFO: renamed from: e */
        int f8031e;

        d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8029c = obj;
            this.f8031e |= Integer.MIN_VALUE;
            return SecureMessagingHelper.this.m5431a((byte[]) null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.e.c$e */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper", m5608f = "SecureMessagingHelper.kt", m5609i = {0}, m5610l = {166}, m5611m = "validateResponseData", m5612n = {"expectedMac"}, m5613s = {"L$0"})
    static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f8032a;

        /* JADX INFO: renamed from: b */
        /* synthetic */ Object f8033b;

        /* JADX INFO: renamed from: d */
        int f8035d;

        e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8033b = obj;
            this.f8035d |= Integer.MIN_VALUE;
            return SecureMessagingHelper.this.m5426a((Map<Integer, PartialTlvObject>) null, 0, this);
        }
    }

    public SecureMessagingHelper(CryptoMode crypto, EncryptionKey encryptKey, MacKey macKey, MessagingState state) {
        Intrinsics.checkNotNullParameter(crypto, "crypto");
        Intrinsics.checkNotNullParameter(encryptKey, "encryptKey");
        Intrinsics.checkNotNullParameter(macKey, "macKey");
        Intrinsics.checkNotNullParameter(state, "state");
        this.f8014a = crypto;
        this.f8015b = encryptKey;
        this.f8016c = macKey;
        this.f8017d = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5426a(java.util.Map<java.lang.Integer, com.yoti.mobile.mpp.mrtddump.asn1.PartialTlvObject> r11, int r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws com.yoti.mobile.mpp.mrtddump.MrtdCryptoException {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper.m5426a(java.util.Map, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5427a(java.util.Map<java.lang.Integer, com.yoti.mobile.mpp.mrtddump.asn1.PartialTlvObject> r6, kotlin.coroutines.Continuation<? super byte[]> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper.a
            if (r0 == 0) goto L13
            r0 = r7
            com.yoti.mobile.mpp.mrtddump.e.c$a r0 = (com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper.a) r0
            int r1 = r0.f8020c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8020c = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.e.c$a r0 = new com.yoti.mobile.mpp.mrtddump.e.c$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f8018a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8020c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L89
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5a
        L38:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = 133(0x85, float:1.86E-43)
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            java.lang.Object r7 = r6.get(r7)
            com.yoti.mobile.mpp.mrtddump.e.b r7 = (com.yoti.mobile.mpp.mrtddump.asn1.PartialTlvObject) r7
            if (r7 == 0) goto L5b
            com.yoti.mobile.mpp.mrtddump.h.b r6 = r5.f8014a
            byte[] r7 = r7.getF8037b()
            com.yoti.mobile.mpp.mrtddump.a r2 = r5.f8015b
            r0.f8020c = r4
            java.lang.Object r7 = r6.mo5480a(r7, r2, r0)
            if (r7 != r1) goto L5a
            return r1
        L5a:
            return r7
        L5b:
            r7 = 135(0x87, float:1.89E-43)
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            java.lang.Object r6 = r6.get(r7)
            com.yoti.mobile.mpp.mrtddump.e.b r6 = (com.yoti.mobile.mpp.mrtddump.asn1.PartialTlvObject) r6
            if (r6 != 0) goto L6b
            r6 = 0
            goto L8c
        L6b:
            byte[] r7 = r6.getF8037b()
            byte[] r6 = r6.getF8037b()
            int r6 = r6.length
            kotlin.ranges.IntRange r6 = kotlin.ranges.RangesKt.until(r4, r6)
            byte[] r6 = kotlin.collections.ArraysKt.sliceArray(r7, r6)
            com.yoti.mobile.mpp.mrtddump.h.b r7 = r5.f8014a
            com.yoti.mobile.mpp.mrtddump.a r2 = r5.f8015b
            r0.f8020c = r3
            java.lang.Object r7 = r7.mo5480a(r6, r2, r0)
            if (r7 != r1) goto L89
            return r1
        L89:
            r6 = r7
            byte[] r6 = (byte[]) r6
        L8c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper.m5427a(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: a */
    private final void m5428a() {
        MessagingState messagingState = this.f8017d;
        messagingState.m5420a(messagingState.getF8012a() + 1);
    }

    /* JADX INFO: renamed from: a */
    private final byte[] m5429a(int i, int i2, int i3, int i4) {
        if ((i & 12) == 0) {
            return null;
        }
        return new byte[]{(byte) (i & 255), (byte) (i2 & 255), (byte) (i3 & 255), (byte) (i4 & 255), -128, 0, 0, 0};
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5430a(int r5, int r6, int r7, int r8, byte[] r9, kotlin.coroutines.Continuation<? super byte[]> r10) {
        /*
            r4 = this;
            boolean r0 = r10 instanceof com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper.b
            if (r0 == 0) goto L13
            r0 = r10
            com.yoti.mobile.mpp.mrtddump.e.c$b r0 = (com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper.b) r0
            int r1 = r0.f8023c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8023c = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.e.c$b r0 = new com.yoti.mobile.mpp.mrtddump.e.c$b
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f8021a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8023c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r10)
            goto L52
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r10)
            r4.m5428a()
            com.yoti.mobile.mpp.mrtddump.e.a r10 = r4.f8017d
            byte[] r10 = r10.m5421b()
            byte[] r5 = r4.m5429a(r5, r6, r7, r8)
            byte[] r5 = com.yoti.mobile.mpp.mrtddump.p096j.C5117a.m5525b(r10, r5, r9)
            com.yoti.mobile.mpp.mrtddump.h.b r6 = r4.f8014a
            com.yoti.mobile.mpp.mrtddump.c r7 = r4.f8016c
            r0.f8023c = r3
            java.lang.Object r10 = r6.mo5481a(r5, r7, r0)
            if (r10 != r1) goto L52
            return r1
        L52:
            byte[] r10 = (byte[]) r10
            com.yoti.mobile.mpp.mrtddump.e.d r5 = new com.yoti.mobile.mpp.mrtddump.e.d
            r6 = 142(0x8e, float:1.99E-43)
            r5.<init>(r6, r10)
            byte[] r5 = r5.m5440b()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper.m5430a(int, int, int, int, byte[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5431a(byte[] r6, int r7, kotlin.coroutines.Continuation<? super byte[]> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper.d
            if (r0 == 0) goto L13
            r0 = r8
            com.yoti.mobile.mpp.mrtddump.e.c$d r0 = (com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper.d) r0
            int r1 = r0.f8031e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8031e = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.e.c$d r0 = new com.yoti.mobile.mpp.mrtddump.e.c$d
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f8029c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8031e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)
            goto L68
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.f8028b
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r7 = r0.f8027a
            com.yoti.mobile.mpp.mrtddump.e.c r7 = (com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5a
        L40:
            kotlin.ResultKt.throwOnFailure(r8)
            com.yoti.mobile.mpp.mrtddump.e.e r8 = new com.yoti.mobile.mpp.mrtddump.e.e
            r8.<init>(r6)
            java.util.Map r6 = r8.m5448c()
            r0.f8027a = r5
            r0.f8028b = r6
            r0.f8031e = r4
            java.lang.Object r7 = r5.m5426a(r6, r7, r0)
            if (r7 != r1) goto L59
            return r1
        L59:
            r7 = r5
        L5a:
            r8 = 0
            r0.f8027a = r8
            r0.f8028b = r8
            r0.f8031e = r3
            java.lang.Object r8 = r7.m5427a(r6, r0)
            if (r8 != r1) goto L68
            return r1
        L68:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper.m5431a(byte[], int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5432a(byte[] r12, kotlin.coroutines.Continuation<? super byte[]> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper.c
            if (r0 == 0) goto L13
            r0 = r13
            com.yoti.mobile.mpp.mrtddump.e.c$c r0 = (com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper.c) r0
            int r1 = r0.f8026c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8026c = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.e.c$c r0 = new com.yoti.mobile.mpp.mrtddump.e.c$c
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.f8024a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8026c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r13)
            goto L45
        L29:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L31:
            kotlin.ResultKt.throwOnFailure(r13)
            if (r12 != 0) goto L38
            r12 = 0
            return r12
        L38:
            com.yoti.mobile.mpp.mrtddump.h.b r13 = r11.f8014a
            com.yoti.mobile.mpp.mrtddump.a r2 = r11.f8015b
            r0.f8026c = r3
            java.lang.Object r13 = r13.mo5483b(r12, r2, r0)
            if (r13 != r1) goto L45
            return r1
        L45:
            r4 = r13
            byte[] r4 = (byte[]) r4
            int r12 = r4.length
            int r12 = r12 + r3
            byte[] r12 = new byte[r12]
            r13 = 0
            r12[r13] = r3
            r9 = 12
            r10 = 0
            r6 = 1
            r7 = 0
            r8 = 0
            r5 = r12
            kotlin.collections.ArraysKt.copyInto$default(r4, r5, r6, r7, r8, r9, r10)
            com.yoti.mobile.mpp.mrtddump.e.d r13 = new com.yoti.mobile.mpp.mrtddump.e.d
            r0 = 135(0x87, float:1.89E-43)
            r13.<init>(r0, r12)
            byte[] r12 = r13.m5440b()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.asn1.SecureMessagingHelper.m5432a(byte[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: a */
    public final byte[] m5433a(Integer num) {
        if (num == null) {
            return null;
        }
        return new TlvObject(151, IntKt.toByteArray(num.intValue())).m5440b();
    }
}
