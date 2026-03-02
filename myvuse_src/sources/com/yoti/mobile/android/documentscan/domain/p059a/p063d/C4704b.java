package com.yoti.mobile.android.documentscan.domain.p059a.p063d;

import com.microblink.entities.recognizers.blinkid.mrtd.MrtdDocumentType;
import com.yoti.mobile.android.documentscan.model.result.RecognizedCoreDocumentType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.a.d.b */
/* JADX INFO: loaded from: classes5.dex */
public final class C4704b {
    /* JADX INFO: renamed from: a */
    public final RecognizedCoreDocumentType m4752a(MrtdDocumentType from) {
        Intrinsics.checkParameterIsNotNull(from, "from");
        int i = C4703a.$EnumSwitchMapping$0[from.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? RecognizedCoreDocumentType.UNDEFINED : RecognizedCoreDocumentType.NATIONAL_ID : RecognizedCoreDocumentType.DRIVING_LICENCE : RecognizedCoreDocumentType.PASSPORT;
    }
}
