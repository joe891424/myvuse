package com.yoti.mobile.android.documentscan.domain.p059a.p063d;

import com.microblink.entities.recognizers.blinkid.generic.classinfo.Type;
import com.yoti.mobile.android.documentscan.model.result.RecognizedCoreDocumentType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.a.d.d */
/* JADX INFO: loaded from: classes5.dex */
public final class C4706d {
    /* JADX INFO: renamed from: a */
    public final RecognizedCoreDocumentType m4753a(Type from) {
        Intrinsics.checkParameterIsNotNull(from, "from");
        switch (C4705c.$EnumSwitchMapping$0[from.ordinal()]) {
            case 1:
            case 2:
                return RecognizedCoreDocumentType.PASSPORT;
            case 3:
            case 4:
            case 5:
            case 6:
                return RecognizedCoreDocumentType.DRIVING_LICENCE;
            case 7:
                return RecognizedCoreDocumentType.NATIONAL_ID;
            case 8:
                return RecognizedCoreDocumentType.PAN;
            case 9:
                return RecognizedCoreDocumentType.MYKAD;
            case 10:
                return RecognizedCoreDocumentType.SSS_ID_CARD;
            case 11:
                return RecognizedCoreDocumentType.POSTAL_ID;
            case 12:
            case 13:
                return RecognizedCoreDocumentType.RESIDENCE_PERMIT;
            case 14:
                return RecognizedCoreDocumentType.VOTED_ID;
            case 15:
                return RecognizedCoreDocumentType.PROFESSIONAL_ID;
            case 16:
                return RecognizedCoreDocumentType.NEXUS_CARD;
            case 17:
                return RecognizedCoreDocumentType.HEALTH_CARD;
            case 18:
                return RecognizedCoreDocumentType.FIREARMS_LICENCE;
            default:
                return RecognizedCoreDocumentType.UNDEFINED;
        }
    }
}
