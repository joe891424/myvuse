package com.yoti.mobile.mpp.mrtddump.crypto;

import com.yoti.mobile.mpp.mrtddump.EncryptionKey;
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

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.e, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J)\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\n\u0010\t\u001a\u00060\u0007j\u0002`\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJ)\u0010\u000e\u001a\u00060\u0007j\u0002`\n2\n\u0010\u000f\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/crypto/TripleDesAuthMode;", "Lcom/yoti/mobile/mpp/mrtddump/crypto/TripleDesModeBase;", "Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoMode;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "decrypt", "", "Lcom/yoti/mobile/mpp/mrtddump/PlainData;", "encrypted", "Lcom/yoti/mobile/mpp/mrtddump/EncryptedData;", "key", "Lcom/yoti/mobile/mpp/mrtddump/EncryptionKey;", "([BLcom/yoti/mobile/mpp/mrtddump/EncryptionKey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "encrypt", "plainText", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TripleDesAuthMode extends TripleDesModeBase implements CryptoMode {

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.e$a */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0003H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lcom/yoti/mobile/mpp/mrtddump/GenericData;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.crypto.TripleDesAuthMode$decrypt$2", m5608f = "TripleDesAuthMode.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {

        /* JADX INFO: renamed from: a */
        int f8070a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ byte[] f8071b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ TripleDesAuthMode f8072c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ EncryptionKey f8073d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(byte[] bArr, TripleDesAuthMode tripleDesAuthMode, EncryptionKey encryptionKey, Continuation<? super a> continuation) {
            super(2, continuation);
            this.f8071b = bArr;
            this.f8072c = tripleDesAuthMode;
            this.f8073d = encryptionKey;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.f8071b, this.f8072c, this.f8073d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f8070a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return C5111f.m5494b(this.f8071b, this.f8072c.m5501a(this.f8073d));
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.e$b */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0003H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lcom/yoti/mobile/mpp/mrtddump/EncryptedData;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.crypto.TripleDesAuthMode$encrypt$2", m5608f = "TripleDesAuthMode.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {

        /* JADX INFO: renamed from: a */
        int f8074a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ byte[] f8075b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ TripleDesAuthMode f8076c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ EncryptionKey f8077d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(byte[] bArr, TripleDesAuthMode tripleDesAuthMode, EncryptionKey encryptionKey, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f8075b = bArr;
            this.f8076c = tripleDesAuthMode;
            this.f8077d = encryptionKey;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.f8075b, this.f8076c, this.f8077d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f8074a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return C5111f.m5496d(this.f8075b, this.f8076c.m5501a(this.f8077d));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TripleDesAuthMode(CoroutineDispatcher dispatcher) {
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
        return BuildersKt.withContext(getF8086a(), new b(bArr, this, encryptionKey, null), continuation);
    }
}
