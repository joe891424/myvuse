package com.yoti.mobile.mpp.mrtddump.commands;

import com.yoti.mobile.mpp.smartcard.CommandAPDU;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import com.yoti.mobile.mpp.smartcard.extensions.IntKt;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.g.i, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/commands/SelectFileCommand;", "Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;", "fileId", "", "(I)V", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SelectFileCommand extends CommandAPDU {
    public SelectFileCommand(int i) {
        super(0, ISO7816Kt.INS_SELECT, 2, 12, IntKt.toByteArray(i, 2), null, false, 64, null);
    }
}
