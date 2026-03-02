package com.yoti.mobile.mpp.mrtddump;

import com.yoti.mobile.mpp.smartcard.extensions.IntKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/MrtdCommandFailedException;", "Lcom/yoti/mobile/mpp/mrtddump/MrtdException;", "commandName", "", "resultCode", "", "(Ljava/lang/String;I)V", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdCommandFailedException extends MrtdException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MrtdCommandFailedException(String commandName, int i) {
        super("Command " + commandName + " returned SW " + IntKt.toStringHex(i), null, 2, null);
        Intrinsics.checkNotNullParameter(commandName, "commandName");
    }
}
