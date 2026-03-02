package com.yoti.mobile.android.documentscan.domain.p059a.p061b;

import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrzResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.a.b.b */
/* JADX INFO: loaded from: classes5.dex */
public final class C4700b {
    /* JADX INFO: renamed from: a */
    public static final String m4740a(BlinkIdCombinedRecognizer.Result extractFamilyName) {
        String primaryId;
        Intrinsics.checkParameterIsNotNull(extractFamilyName, "$this$extractFamilyName");
        MrzResult mrzResult = extractFamilyName.getMrzResult();
        Intrinsics.checkExpressionValueIsNotNull(mrzResult, "mrzResult");
        String primaryId2 = mrzResult.getPrimaryId();
        Intrinsics.checkExpressionValueIsNotNull(primaryId2, "mrzResult.primaryId");
        if (primaryId2.length() == 0) {
            primaryId = extractFamilyName.getLastName();
        } else {
            MrzResult mrzResult2 = extractFamilyName.getMrzResult();
            Intrinsics.checkExpressionValueIsNotNull(mrzResult2, "mrzResult");
            primaryId = mrzResult2.getPrimaryId();
        }
        Intrinsics.checkExpressionValueIsNotNull(primaryId, "if (mrzResult.primaryId.…esult.primaryId\n        }");
        return primaryId;
    }

    /* JADX INFO: renamed from: b */
    public static final String m4741b(BlinkIdCombinedRecognizer.Result extractFirstName) {
        String secondaryId;
        Intrinsics.checkParameterIsNotNull(extractFirstName, "$this$extractFirstName");
        MrzResult mrzResult = extractFirstName.getMrzResult();
        Intrinsics.checkExpressionValueIsNotNull(mrzResult, "mrzResult");
        String secondaryId2 = mrzResult.getSecondaryId();
        Intrinsics.checkExpressionValueIsNotNull(secondaryId2, "mrzResult.secondaryId");
        if (secondaryId2.length() == 0) {
            secondaryId = extractFirstName.getFirstName();
        } else {
            MrzResult mrzResult2 = extractFirstName.getMrzResult();
            Intrinsics.checkExpressionValueIsNotNull(mrzResult2, "mrzResult");
            secondaryId = mrzResult2.getSecondaryId();
        }
        Intrinsics.checkExpressionValueIsNotNull(secondaryId, "if (mrzResult.secondaryI…ult.secondaryId\n        }");
        return secondaryId;
    }

    /* JADX INFO: renamed from: c */
    public static final String m4742c(BlinkIdCombinedRecognizer.Result extractGivenNames) {
        String secondaryId;
        Intrinsics.checkParameterIsNotNull(extractGivenNames, "$this$extractGivenNames");
        MrzResult mrzResult = extractGivenNames.getMrzResult();
        Intrinsics.checkExpressionValueIsNotNull(mrzResult, "mrzResult");
        String secondaryId2 = mrzResult.getSecondaryId();
        Intrinsics.checkExpressionValueIsNotNull(secondaryId2, "mrzResult.secondaryId");
        if (secondaryId2.length() == 0) {
            secondaryId = extractGivenNames.getFirstName();
        } else {
            MrzResult mrzResult2 = extractGivenNames.getMrzResult();
            Intrinsics.checkExpressionValueIsNotNull(mrzResult2, "mrzResult");
            secondaryId = mrzResult2.getSecondaryId();
        }
        Intrinsics.checkExpressionValueIsNotNull(secondaryId, "if (mrzResult.secondaryI…ult.secondaryId\n        }");
        return secondaryId;
    }
}
