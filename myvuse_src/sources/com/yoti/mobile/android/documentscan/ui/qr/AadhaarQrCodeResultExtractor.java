package com.yoti.mobile.android.documentscan.ui.qr;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.imageutils.JfifUtil;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import com.yoti.mobile.android.documentscan.C4695R;
import com.yoti.mobile.android.documentscan.domain.p059a.aadhaar.AadhaarAddressFormatter;
import com.yoti.mobile.android.documentscan.domain.p059a.aadhaar.C4698b;
import com.yoti.mobile.android.documentscan.domain.utils.BlinkDateUtils;
import com.yoti.mobile.android.documentscan.model.result.Address;
import com.yoti.mobile.android.documentscan.model.result.Country;
import com.yoti.mobile.android.documentscan.model.result.DateResult;
import com.yoti.mobile.android.documentscan.model.result.DocumentData;
import com.yoti.mobile.android.documentscan.model.result.Gender;
import com.yoti.mobile.android.documentscan.model.result.Holder;
import com.yoti.mobile.android.documentscan.ui.DocumentCaptureException;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.qr.c, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0015H\u0002J,\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0017j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0015*\u00020\fH\u0002J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/qr/AadhaarQrCodeResultExtractor;", "", "xmlParser", "Lcom/yoti/mobile/android/documentscan/domain/extractors/aadhaar/XMLParser;", "blinkDateUtils", "Lcom/yoti/mobile/android/documentscan/domain/utils/BlinkDateUtils;", "aadhaarAddressFormatter", "Lcom/yoti/mobile/android/documentscan/domain/extractors/aadhaar/AadhaarAddressFormatter;", "(Lcom/yoti/mobile/android/documentscan/domain/extractors/aadhaar/XMLParser;Lcom/yoti/mobile/android/documentscan/domain/utils/BlinkDateUtils;Lcom/yoti/mobile/android/documentscan/domain/extractors/aadhaar/AadhaarAddressFormatter;)V", "extractAddressInformation", "Lcom/yoti/mobile/android/documentscan/model/result/Address;", "payload", "", "extractDocumentData", "Lcom/yoti/mobile/android/documentscan/model/result/DocumentData;", "extractHolderAliasInformation", "Lcom/yoti/mobile/android/documentscan/model/result/Holder;", "extractHolderInformation", "findBirthDate", "Lcom/yoti/mobile/android/documentscan/model/result/DateResult;", C4352k.a.f5654h, "", "parseAadhaarAttributes", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "document", "Lorg/w3c/dom/Document;", "toAttributes", "toGender", "Lcom/yoti/mobile/android/documentscan/model/result/Gender;", "Companion", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class AadhaarQrCodeResultExtractor {
    private static final String ATTR_GENDER = "gender";
    private static final String ATTR_NAME = "name";

    /* JADX INFO: renamed from: c */
    private final C4698b f7148c;

    /* JADX INFO: renamed from: d */
    private final BlinkDateUtils f7149d;

    /* JADX INFO: renamed from: e */
    private final AadhaarAddressFormatter f7150e;

    /* JADX INFO: renamed from: b */
    @Deprecated
    public static final a f7147b = new a(null);
    private static final String ATTR_UID = "uid";
    private static final String ATTR_YEAR_OF_BIRTH = "yob";
    private static final String ATTR_DATE_OF_BIRTH = "dob";

    /* JADX INFO: renamed from: a */
    private static final String[] f7146a = {ATTR_UID, "name", ATTR_YEAR_OF_BIRTH, ATTR_DATE_OF_BIRTH, "gender", "co", AadhaarAddressFormatter.ATTR_HOUSE, AadhaarAddressFormatter.ATTR_STREET, AadhaarAddressFormatter.ATTR_LANDMARK, AadhaarAddressFormatter.ATTR_LOCALITY, AadhaarAddressFormatter.ATTR_VILLAGE_TOWN_CITY, AadhaarAddressFormatter.ATTR_SUBDISTRICT, AadhaarAddressFormatter.ATTR_DISTRICT, "state", AadhaarAddressFormatter.ATTR_POSTAL_PIN_CODE, AadhaarAddressFormatter.ATTR_POST_OFFICE};

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.qr.c$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AadhaarQrCodeResultExtractor(C4698b xmlParser, BlinkDateUtils blinkDateUtils, AadhaarAddressFormatter aadhaarAddressFormatter) {
        Intrinsics.checkParameterIsNotNull(xmlParser, "xmlParser");
        Intrinsics.checkParameterIsNotNull(blinkDateUtils, "blinkDateUtils");
        Intrinsics.checkParameterIsNotNull(aadhaarAddressFormatter, "aadhaarAddressFormatter");
        this.f7148c = xmlParser;
        this.f7149d = blinkDateUtils;
        this.f7150e = aadhaarAddressFormatter;
    }

    /* JADX INFO: renamed from: a */
    private final DateResult m5019a(Map<String, String> map) {
        DateResult dateResultM4783a = this.f7149d.m4783a(map.get(ATTR_DATE_OF_BIRTH));
        if (dateResultM4783a != null) {
            return dateResultM4783a;
        }
        String str = map.get(ATTR_YEAR_OF_BIRTH);
        if (str != null) {
            return new DateResult(null, null, Integer.valueOf(Integer.parseInt(str)), null);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private final HashMap<String, String> m5020a(Document document) {
        Element documentElement = document.getDocumentElement();
        Intrinsics.checkExpressionValueIsNotNull(documentElement, "document.documentElement");
        NamedNodeMap attributes = documentElement.getAttributes();
        HashMap<String, String> map = new HashMap<>();
        for (String str : f7146a) {
            if (attributes.getNamedItem(str) != null) {
                Node namedItem = attributes.getNamedItem(str);
                Intrinsics.checkExpressionValueIsNotNull(namedItem, "map.getNamedItem(attributeKey)");
                String nodeValue = namedItem.getNodeValue();
                Intrinsics.checkExpressionValueIsNotNull(nodeValue, "map.getNamedItem(attributeKey).nodeValue");
                map.put(str, nodeValue);
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: e */
    private final Map<String, String> m5021e(String str) throws DocumentCaptureException.AadhaarQrCodeNotRecognizedException {
        Map<String, String> mapEmptyMap;
        Document documentM4727a = this.f7148c.m4727a(str);
        if (documentM4727a == null || (mapEmptyMap = m5020a(documentM4727a)) == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        if (mapEmptyMap.isEmpty()) {
            throw new DocumentCaptureException.AadhaarQrCodeNotRecognizedException(C4695R.string.loc_scan_tooltip_aadhaar_invalid_qr, null, null, 6, null);
        }
        return mapEmptyMap;
    }

    /* JADX INFO: renamed from: f */
    private final Gender m5022f(String str) {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != 70) {
                if (iHashCode != 77) {
                    if (iHashCode == 84 && str.equals(ExifInterface.GPS_DIRECTION_TRUE)) {
                        return Gender.TRANSGENDER;
                    }
                } else if (str.equals("M")) {
                    return Gender.MALE;
                }
            } else if (str.equals("F")) {
                return Gender.FEMALE;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final Address m5023a(String payload) throws DocumentCaptureException.AadhaarQrCodeNotRecognizedException {
        Intrinsics.checkParameterIsNotNull(payload, "payload");
        AadhaarAddressFormatter.a aVarM4711a = this.f7150e.m4711a(m5021e(payload));
        return new Address(CollectionsKt.listOfNotNull(aVarM4711a.m4724k()), aVarM4711a.m4726m(), aVarM4711a.m4720g(), aVarM4711a.m4723j(), aVarM4711a.m4721h(), new Country(aVarM4711a.m4715b()), aVarM4711a.m4714a(), aVarM4711a.m4719f(), aVarM4711a.m4717d(), aVarM4711a.m4725l(), aVarM4711a.m4722i(), aVarM4711a.m4718e(), aVarM4711a.m4716c());
    }

    /* JADX INFO: renamed from: b */
    public final DocumentData m5024b(String payload) {
        Intrinsics.checkParameterIsNotNull(payload, "payload");
        return new DocumentData(null, null, null, null, m5021e(payload).get(ATTR_UID), null, null, null, JfifUtil.MARKER_SOFn, null);
    }

    /* JADX INFO: renamed from: c */
    public final Holder m5025c(String payload) {
        Intrinsics.checkParameterIsNotNull(payload, "payload");
        return null;
    }

    /* JADX INFO: renamed from: d */
    public final Holder m5026d(String payload) throws DocumentCaptureException.AadhaarQrCodeNotRecognizedException {
        Intrinsics.checkParameterIsNotNull(payload, "payload");
        Map<String, String> mapM5021e = m5021e(payload);
        return new Holder(null, null, null, null, null, null, mapM5021e.get("name"), m5019a(mapM5021e), null, m5022f(mapM5021e.get("gender")), null);
    }
}
