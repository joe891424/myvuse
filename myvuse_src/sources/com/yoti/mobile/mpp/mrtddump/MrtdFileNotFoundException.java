package com.yoti.mobile.mpp.mrtddump;

import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import com.yoti.mobile.mpp.smartcard.extensions.IntKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/MrtdFileNotFoundException;", "Lcom/yoti/mobile/mpp/mrtddump/MrtdException;", "commandName", "", "file", "resultCode", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdFileNotFoundException extends MrtdException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MrtdFileNotFoundException(String commandName, String file, int i) {
        super("Could not " + commandName + " missing file " + file + " (" + IntKt.toStringHex(i) + ')', null, 2, null);
        Intrinsics.checkNotNullParameter(commandName, "commandName");
        Intrinsics.checkNotNullParameter(file, "file");
    }

    public /* synthetic */ MrtdFileNotFoundException(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? ISO7816Kt.SW_FILE_NOT_FOUND : i);
    }
}
