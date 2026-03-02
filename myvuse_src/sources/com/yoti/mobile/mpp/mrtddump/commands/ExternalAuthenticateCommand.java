package com.yoti.mobile.mpp.mrtddump.commands;

import com.yoti.mobile.mpp.smartcard.CommandAPDU;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.g.d, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/commands/ExternalAuthenticateCommand;", "Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;", "hostCryptogram", "", "([B)V", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ExternalAuthenticateCommand extends CommandAPDU {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExternalAuthenticateCommand(byte[] hostCryptogram) {
        super(0, ISO7816Kt.INS_EXTERNAL_AUTHENTICATE, 0, 0, hostCryptogram, 0, false, 64, null);
        Intrinsics.checkNotNullParameter(hostCryptogram, "hostCryptogram");
    }
}
