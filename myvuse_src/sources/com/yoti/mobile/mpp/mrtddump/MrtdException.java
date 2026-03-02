package com.yoti.mobile.mpp.mrtddump;

import com.newrelic.agent.android.agentdata.HexAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/MrtdException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", HexAttribute.HEX_ATTR_CAUSE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class MrtdException extends Exception {
    /* JADX WARN: Multi-variable type inference failed */
    public MrtdException() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MrtdException(String str, Throwable th) {
        super(str, th);
    }

    public /* synthetic */ MrtdException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
    }
}
