package com.yoti.mobile.mpp.mrtddump.crypto;

import com.yoti.mobile.mpp.mrtddump.EncryptionKey;
import com.yoti.mobile.mpp.mrtddump.MacKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00060\tj\u0002`\n2\n\u0010\u000b\u001a\u00060\tj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ)\u0010\u0010\u001a\u00060\tj\u0002`\f2\n\u0010\u0011\u001a\u00060\tj\u0002`\n2\u0006\u0010\r\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0012\u001a\u00060\tj\u0002`\u00132\n\u0010\u0014\u001a\u00060\tj\u0002`\u0015H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J)\u0010\u0017\u001a\u00060\tj\u0002`\u00182\n\u0010\u0014\u001a\u00060\tj\u0002`\u00152\u0006\u0010\u0019\u001a\u00020\u001aH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoMode;", "", "keyLengthBytes", "", "getKeyLengthBytes", "()I", "macLengthBytes", "getMacLengthBytes", "decrypt", "", "Lcom/yoti/mobile/mpp/mrtddump/PlainData;", "encrypted", "Lcom/yoti/mobile/mpp/mrtddump/EncryptedData;", "key", "Lcom/yoti/mobile/mpp/mrtddump/EncryptionKey;", "([BLcom/yoti/mobile/mpp/mrtddump/EncryptionKey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "encrypt", "plainText", "hash", "Lcom/yoti/mobile/mpp/mrtddump/Hash;", "data", "Lcom/yoti/mobile/mpp/mrtddump/GenericData;", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mac", "Lcom/yoti/mobile/mpp/mrtddump/Mac;", "macKey", "Lcom/yoti/mobile/mpp/mrtddump/MacKey;", "([BLcom/yoti/mobile/mpp/mrtddump/MacKey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface CryptoMode {
    /* JADX INFO: renamed from: a */
    int mo5479a();

    /* JADX INFO: renamed from: a */
    Object mo5480a(byte[] bArr, EncryptionKey encryptionKey, Continuation<? super byte[]> continuation);

    /* JADX INFO: renamed from: a */
    Object mo5481a(byte[] bArr, MacKey macKey, Continuation<? super byte[]> continuation);

    /* JADX INFO: renamed from: a */
    Object mo5482a(byte[] bArr, Continuation<? super byte[]> continuation);

    /* JADX INFO: renamed from: b */
    Object mo5483b(byte[] bArr, EncryptionKey encryptionKey, Continuation<? super byte[]> continuation);
}
