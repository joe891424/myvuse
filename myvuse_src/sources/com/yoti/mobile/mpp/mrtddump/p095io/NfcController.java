package com.yoti.mobile.mpp.mrtddump.p095io;

import com.yoti.mobile.mpp.smartcard.CommandAPDU;
import com.yoti.mobile.mpp.smartcard.ResponseAPDU;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0006H&J\u0011\u0010\u0007\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/io/NfcController;", "", "isConnected", "", "()Z", "closeConnection", "", "connect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTimeout", "timeoutMs", "", "transceive", "Lcom/yoti/mobile/mpp/smartcard/ResponseAPDU;", "dataToSend", "Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;", "(Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface NfcController {
    void closeConnection();

    Object connect(Continuation<? super Unit> continuation);

    boolean isConnected();

    void setTimeout(long timeoutMs);

    Object transceive(CommandAPDU commandAPDU, Continuation<? super ResponseAPDU> continuation);
}
