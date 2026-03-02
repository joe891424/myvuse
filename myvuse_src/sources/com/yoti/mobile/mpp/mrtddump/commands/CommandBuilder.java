package com.yoti.mobile.mpp.mrtddump.commands;

import com.yoti.mobile.mpp.mrtddump.p096j.C5117a;
import com.yoti.mobile.mpp.smartcard.CommandAPDU;
import com.yoti.mobile.mpp.smartcard.ResponseAPDU;
import com.yoti.mobile.mpp.smartcard.extensions.IntKt;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.g.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bJ \u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/commands/CommandBuilder;", "", "()V", "createCommand", "Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;", "cla", "", "ins", "p1", "p2", "commandData", "", "le", "extended", "", "(IIII[BLjava/lang/Integer;Z)Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;", "createResponse", "Lcom/yoti/mobile/mpp/smartcard/ResponseAPDU;", "data", "sw1", "sw2", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class CommandBuilder {
    /* JADX INFO: renamed from: a */
    public final CommandAPDU m5468a(int i, int i2, int i3, int i4, byte[] bArr, Integer num, boolean z) {
        return new CommandAPDU(i, i2, i3, i4, bArr, num, z);
    }

    /* JADX INFO: renamed from: a */
    public final ResponseAPDU m5469a(byte[] bArr, int i, int i2) {
        return new ResponseAPDU(C5117a.m5525b(bArr, IntKt.toByteArray(i), IntKt.toByteArray(i2)));
    }
}
