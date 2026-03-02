package com.yoti.mobile.android.documentscan.domain.p059a.p064e;

import com.microblink.entities.recognizers.blinkid.mrtd.MrzResult;
import com.yoti.mobile.android.documentscan.model.result.MrzData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.a.e.b */
/* JADX INFO: loaded from: classes5.dex */
public final class C4708b {
    /* JADX INFO: renamed from: a */
    public static final MrzData m4761a(MrzResult getMrzData) {
        Intrinsics.checkParameterIsNotNull(getMrzData, "$this$getMrzData");
        return new MrzData(getMrzData.getMrzText(), Boolean.valueOf(getMrzData.isMrzParsed()), Boolean.valueOf(getMrzData.isMrzVerified()));
    }
}
