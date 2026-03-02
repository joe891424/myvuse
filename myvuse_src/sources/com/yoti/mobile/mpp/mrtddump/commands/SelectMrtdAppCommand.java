package com.yoti.mobile.mpp.mrtddump.commands;

import com.yoti.mobile.mpp.smartcard.CommandAPDU;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import com.yoti.mobile.mpp.smartcard.extensions.StringKt;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.g.j, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/commands/SelectMrtdAppCommand;", "Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;", "()V", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SelectMrtdAppCommand extends CommandAPDU {
    public SelectMrtdAppCommand() {
        super(0, ISO7816Kt.INS_SELECT, 4, 12, StringKt.hexStringToByteArray("A0000002471001"), null, false, 64, null);
    }
}
