package com.yoti.mobile.mpp.mrtddump.crypto;

import com.yoti.mobile.mpp.mrtddump.EncryptionKey;
import com.yoti.mobile.mpp.mrtddump.MacKey;
import com.yoti.mobile.mpp.mrtddump.MrtdCryptoException;
import com.yoti.mobile.mpp.mrtddump.p096j.C5117a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.h, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0004J!\u0010\u0014\u001a\u00060\u0015j\u0002`\u00162\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u0018H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J)\u0010\u001a\u001a\u00060\u0015j\u0002`\u001b2\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/crypto/TripleDesModeBase;", "Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoMode;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "keyLengthBytes", "", "getKeyLengthBytes", "()I", "macLengthBytes", "getMacLengthBytes", "padder", "Lcom/yoti/mobile/mpp/mrtddump/crypto/Iso7816d4Padding;", "getPadder", "()Lcom/yoti/mobile/mpp/mrtddump/crypto/Iso7816d4Padding;", "get3DesEncryptionKey", "Lcom/yoti/mobile/mpp/mrtddump/EncryptionKey;", "key", "hash", "", "Lcom/yoti/mobile/mpp/mrtddump/Hash;", "data", "Lcom/yoti/mobile/mpp/mrtddump/GenericData;", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mac", "Lcom/yoti/mobile/mpp/mrtddump/Mac;", "macKey", "Lcom/yoti/mobile/mpp/mrtddump/MacKey;", "([BLcom/yoti/mobile/mpp/mrtddump/MacKey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class TripleDesModeBase implements CryptoMode {

    /* JADX INFO: renamed from: a */
    private final CoroutineDispatcher f8086a;

    /* JADX INFO: renamed from: b */
    private final Iso7816d4Padding f8087b;

    /* JADX INFO: renamed from: c */
    private final int f8088c;

    /* JADX INFO: renamed from: d */
    private final int f8089d;

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.h$a */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.crypto.TripleDesModeBase$hash$2", m5608f = "TripleDesModeBase.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {

        /* JADX INFO: renamed from: a */
        int f8090a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ byte[] f8091b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ TripleDesModeBase f8092c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(byte[] bArr, TripleDesModeBase tripleDesModeBase, Continuation<? super a> continuation) {
            super(2, continuation);
            this.f8091b = bArr;
            this.f8092c = tripleDesModeBase;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.f8091b, this.f8092c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f8090a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ArraysKt.sliceArray(C5111f.m5492a(this.f8091b), RangesKt.until(0, this.f8092c.getF8088c()));
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.h$b */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0003H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lcom/yoti/mobile/mpp/mrtddump/EncryptedData;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.crypto.TripleDesModeBase$mac$2", m5608f = "TripleDesModeBase.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {

        /* JADX INFO: renamed from: a */
        int f8093a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ MacKey f8094b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ TripleDesModeBase f8095c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ byte[] f8096d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(MacKey macKey, TripleDesModeBase tripleDesModeBase, byte[] bArr, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f8094b = macKey;
            this.f8095c = tripleDesModeBase;
            this.f8096d = bArr;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.f8094b, this.f8095c, this.f8096d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws MrtdCryptoException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f8093a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.f8094b.getF8010a().length != 16) {
                throw new MrtdCryptoException("For DES-based MAC the key must be 16 bytes", null, 2, null);
            }
            byte[] bArrM5485a = this.f8095c.getF8087b().m5485a(this.f8096d, 8);
            int length = bArrM5485a.length / 8;
            int i = 0;
            EncryptionKey encryptionKey = new EncryptionKey(ArraysKt.copyOfRange(this.f8094b.getF8010a(), 0, 8));
            EncryptionKey encryptionKey2 = new EncryptionKey(ArraysKt.copyOfRange(this.f8094b.getF8010a(), 8, 16));
            byte[] bArrM5495c = new byte[8];
            while (i < length) {
                int i2 = i + 1;
                int i3 = i * 8;
                bArrM5495c = C5111f.m5495c(C5117a.m5527c(ArraysKt.copyOfRange(bArrM5485a, i3, i3 + 8), bArrM5495c), encryptionKey);
                i = i2;
            }
            return C5111f.m5495c(C5111f.m5493a(bArrM5495c, encryptionKey2), encryptionKey);
        }
    }

    public TripleDesModeBase(CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.f8086a = dispatcher;
        this.f8087b = new Iso7816d4Padding();
        this.f8088c = 16;
        this.f8089d = 8;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ Object m5499a(TripleDesModeBase tripleDesModeBase, byte[] bArr, MacKey macKey, Continuation continuation) {
        return BuildersKt.withContext(tripleDesModeBase.getF8086a(), new b(macKey, tripleDesModeBase, bArr, null), continuation);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ Object m5500a(TripleDesModeBase tripleDesModeBase, byte[] bArr, Continuation continuation) {
        return BuildersKt.withContext(tripleDesModeBase.getF8086a(), new a(bArr, tripleDesModeBase, null), continuation);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.crypto.CryptoMode
    /* JADX INFO: renamed from: a, reason: from getter */
    public int getF8088c() {
        return this.f8088c;
    }

    /* JADX INFO: renamed from: a */
    protected final EncryptionKey m5501a(EncryptionKey key) throws MrtdCryptoException {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key.getF8010a().length != 16 && key.getF8010a().length != 24) {
            throw new MrtdCryptoException("For 3DES the key must be 16 bytes or 24 bytes", null, 2, null);
        }
        byte[] f8010a = key.getF8010a();
        if (key.getF8010a().length == 16) {
            f8010a = ArraysKt.plus(f8010a, ArraysKt.sliceArray(key.getF8010a(), RangesKt.until(0, 8)));
        }
        return new EncryptionKey(f8010a);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.crypto.CryptoMode
    /* JADX INFO: renamed from: a */
    public Object mo5481a(byte[] bArr, MacKey macKey, Continuation<? super byte[]> continuation) {
        return m5499a(this, bArr, macKey, continuation);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.crypto.CryptoMode
    /* JADX INFO: renamed from: a */
    public Object mo5482a(byte[] bArr, Continuation<? super byte[]> continuation) {
        return m5500a(this, bArr, continuation);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    protected final CoroutineDispatcher getF8086a() {
        return this.f8086a;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    protected final Iso7816d4Padding getF8087b() {
        return this.f8087b;
    }
}
