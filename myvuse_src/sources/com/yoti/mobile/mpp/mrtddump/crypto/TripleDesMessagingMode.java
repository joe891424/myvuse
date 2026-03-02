package com.yoti.mobile.mpp.mrtddump.crypto;

import com.yoti.mobile.mpp.mrtddump.EncryptionKey;
import com.yoti.mobile.mpp.mrtddump.MrtdCryptoException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.g, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J)\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\n\u0010\t\u001a\u00060\u0007j\u0002`\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJ)\u0010\u000e\u001a\u00060\u0007j\u0002`\n2\n\u0010\u000f\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/crypto/TripleDesMessagingMode;", "Lcom/yoti/mobile/mpp/mrtddump/crypto/TripleDesModeBase;", "Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoMode;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "decrypt", "", "Lcom/yoti/mobile/mpp/mrtddump/PlainData;", "encrypted", "Lcom/yoti/mobile/mpp/mrtddump/EncryptedData;", "key", "Lcom/yoti/mobile/mpp/mrtddump/EncryptionKey;", "([BLcom/yoti/mobile/mpp/mrtddump/EncryptionKey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "encrypt", "plainText", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TripleDesMessagingMode extends TripleDesModeBase implements CryptoMode {

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.g$a */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.crypto.TripleDesMessagingMode$decrypt$2", m5608f = "TripleDesMessagingMode.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {

        /* JADX INFO: renamed from: a */
        int f8078a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ byte[] f8079b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ TripleDesMessagingMode f8080c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ EncryptionKey f8081d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(byte[] bArr, TripleDesMessagingMode tripleDesMessagingMode, EncryptionKey encryptionKey, Continuation<? super a> continuation) {
            super(2, continuation);
            this.f8079b = bArr;
            this.f8080c = tripleDesMessagingMode;
            this.f8081d = encryptionKey;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.f8079b, this.f8080c, this.f8081d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws MrtdCryptoException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f8078a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return this.f8080c.getF8087b().m5484a(C5111f.m5494b(this.f8079b, this.f8080c.m5501a(this.f8081d)));
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.g$b */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0003H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lcom/yoti/mobile/mpp/mrtddump/EncryptedData;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.crypto.TripleDesMessagingMode$encrypt$2", m5608f = "TripleDesMessagingMode.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {

        /* JADX INFO: renamed from: a */
        int f8082a;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ byte[] f8084c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ EncryptionKey f8085d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(byte[] bArr, EncryptionKey encryptionKey, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f8084c = bArr;
            this.f8085d = encryptionKey;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TripleDesMessagingMode.this.new b(this.f8084c, this.f8085d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f8082a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return C5111f.m5496d(TripleDesMessagingMode.this.getF8087b().m5485a(this.f8084c, 8), TripleDesMessagingMode.this.m5501a(this.f8085d));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TripleDesMessagingMode(CoroutineDispatcher dispatcher) {
        super(dispatcher);
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
    }

    @Override // com.yoti.mobile.mpp.mrtddump.crypto.CryptoMode
    /* JADX INFO: renamed from: a */
    public Object mo5480a(byte[] bArr, EncryptionKey encryptionKey, Continuation<? super byte[]> continuation) {
        return BuildersKt.withContext(getF8086a(), new a(bArr, this, encryptionKey, null), continuation);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.crypto.CryptoMode
    /* JADX INFO: renamed from: b */
    public Object mo5483b(byte[] bArr, EncryptionKey encryptionKey, Continuation<? super byte[]> continuation) {
        return BuildersKt.withContext(getF8086a(), new b(bArr, encryptionKey, null), continuation);
    }
}
