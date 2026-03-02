package com.yoti.mobile.android.documentscan.domain;

import com.microblink.entities.detectors.quad.mrtd.MrtdSpecification;
import com.microblink.entities.detectors.quad.mrtd.MrtdSpecificationPreset;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkid.generic.AnonymizationMode;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.entities.recognizers.blinkid.passport.PassportRecognizer;
import com.microblink.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\n\u001a\u0006\u0012\u0002\b\u00030\b*\u00020\u0004H\u0002¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/domain/BlinkIdRecognizerSettingsFactory;", "", "()V", "getFromName", "Lcom/yoti/mobile/android/documentscan/domain/BlinkIdRecognizerSettingsFactory$RecognizerType;", "name", "", "getRecognizer", "Lcom/microblink/entities/recognizers/Recognizer;", "recognizerId", "createRecognizerSetting", "RecognizerType", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class BlinkIdRecognizerSettingsFactory {

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.b$a */
    public enum a {
        PASSPORT("passport"),
        AADHAAR_QRCODE("aadhaar_qrcode"),
        USDL("us_dl"),
        MRTD3("mrtd_td3_passport"),
        BARCODE("id_barcode"),
        GENERIC("generic");


        /* JADX INFO: renamed from: h */
        private String f6887h;

        a(String str) {
            this.f6887h = str;
        }

        /* JADX INFO: renamed from: a */
        public final String m4779a() {
            return this.f6887h;
        }
    }

    /* JADX INFO: renamed from: a */
    private final Recognizer<?> m4776a(a aVar) {
        int i = C4714c.$EnumSwitchMapping$0[aVar.ordinal()];
        if (i == 1) {
            PassportRecognizer passportRecognizer = new PassportRecognizer();
            passportRecognizer.setReturnFullDocumentImage(true);
            passportRecognizer.setReturnFaceImage(true);
            return passportRecognizer;
        }
        if (i == 2) {
            UsdlCombinedRecognizer usdlCombinedRecognizer = new UsdlCombinedRecognizer();
            usdlCombinedRecognizer.setReturnFullDocumentImage(true);
            usdlCombinedRecognizer.setReturnFaceImage(true);
            return usdlCombinedRecognizer;
        }
        if (i == 3) {
            MrtdRecognizer mrtdRecognizer = new MrtdRecognizer();
            mrtdRecognizer.setReturnFullDocumentImage(true);
            mrtdRecognizer.setSpecifications(MrtdSpecification.createFromPreset(MrtdSpecificationPreset.MRTD_SPECIFICATION_TD3));
            return mrtdRecognizer;
        }
        if (i == 4) {
            return new IdBarcodeRecognizer();
        }
        BlinkIdCombinedRecognizer blinkIdCombinedRecognizer = new BlinkIdCombinedRecognizer();
        blinkIdCombinedRecognizer.setAnonymizationMode(AnonymizationMode.None);
        blinkIdCombinedRecognizer.setReturnFullDocumentImage(true);
        blinkIdCombinedRecognizer.setReturnFaceImage(true);
        blinkIdCombinedRecognizer.setSkipUnsupportedBack(true);
        return blinkIdCombinedRecognizer;
    }

    /* JADX INFO: renamed from: b */
    private final a m4777b(String str) {
        for (a aVar : a.values()) {
            if (Intrinsics.areEqual(aVar.m4779a(), str)) {
                return aVar;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final Recognizer<?> m4778a(String recognizerId) {
        Recognizer<?> recognizerM4776a;
        Intrinsics.checkParameterIsNotNull(recognizerId, "recognizerId");
        a aVarM4777b = m4777b(recognizerId);
        return (aVarM4777b == null || (recognizerM4776a = m4776a(aVarM4777b)) == null) ? m4776a(a.GENERIC) : recognizerM4776a;
    }
}
