package com.yoti.mobile.mpp.mrtddump.commands;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yoti.mobile.mpp.smartcard.CommandAPDU;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.g.h, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/commands/ReadFileCommand;", "Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;", "shortFileId", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "length", "extendedMode", "", "(BIIZ)V", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ReadFileCommand extends CommandAPDU {
    public ReadFileCommand(byte b, int i, int i2, boolean z) {
        super(0, ISO7816Kt.INS_READ_BINARY, b | 128, i, null, Integer.valueOf(i2), z);
    }

    public /* synthetic */ ReadFileCommand(byte b, int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(b, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? false : z);
    }
}
