package com.yoti.mobile.mpp.mrtddump.commands;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yoti.mobile.mpp.smartcard.CommandAPDU;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import com.yoti.mobile.mpp.smartcard.extensions.IntKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.g.g, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\t¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/commands/ReadBinaryCommand;", "Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;", TypedValues.CycleType.S_WAVE_OFFSET, "", "maxLength", "extendedMode", "", "(IIZ)V", "", "([BIZ)V", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ReadBinaryCommand extends CommandAPDU {
    public ReadBinaryCommand(int i, int i2, boolean z) {
        this(IntKt.toByteArray(i, 2), i2, z);
    }

    public /* synthetic */ ReadBinaryCommand(int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z);
    }

    private ReadBinaryCommand(byte[] bArr, int i, boolean z) {
        super(0, ISO7816Kt.INS_READ_BINARY, bArr[0] & 255, bArr[1] & 255, null, Integer.valueOf(i), z);
    }
}
