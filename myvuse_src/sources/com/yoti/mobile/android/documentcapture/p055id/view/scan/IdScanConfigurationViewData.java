package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedPageConfig;
import com.yoti.mobile.android.documentscan.ui.IScanViewConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b*\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\t\u0010;\u001a\u00020\u0004HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010=\u001a\u00020\u0004HÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010%J\t\u0010A\u001a\u00020\u0004HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010C\u001a\u00020\u0010HÆ\u0003J\t\u0010D\u001a\u00020\u0010HÆ\u0003J~\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010FJ\t\u0010G\u001a\u00020\fHÖ\u0001J\u0013\u0010H\u001a\u00020\u00102\b\u0010I\u001a\u0004\u0018\u00010JHÖ\u0003J\u0016\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\fJ\u0016\u0010O\u001a\u00020\u00042\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\fJ\t\u0010P\u001a\u00020\fHÖ\u0001J\t\u0010Q\u001a\u00020\u0004HÖ\u0001J\u0019\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\fHÖ\u0001R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u001c\u0010'\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001c\u00102\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010)\u001a\u0004\b4\u0010+R\u001c\u00105\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010)\u001a\u0004\b7\u0010+R\u001c\u00108\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010)\u001a\u0004\b:\u0010+¨\u0006W"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "Lcom/yoti/mobile/android/documentcapture/view/scan/IScanConfigurationViewData;", "Lcom/yoti/mobile/android/documentscan/ui/IScanViewConfiguration;", "resourceId", "", "countryIso3Code", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "scanConfigurations", "", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedPageConfig;", "logo", "", "blinkIdKey", "blinkIdLicensee", "ocrRequired", "", "nfcAvailable", OTVendorUtils.CONSENT_TYPE, "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ConsentViewData;", "(Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZZLcom/yoti/mobile/android/documentcapture/id/view/scan/ConsentViewData;)V", "getBlinkIdKey", "()Ljava/lang/String;", "setBlinkIdKey", "(Ljava/lang/String;)V", "getBlinkIdLicensee", "setBlinkIdLicensee", "getConsent", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/ConsentViewData;", "getCountryIso3Code", "documentRatio", "", "getDocumentRatio", "()F", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "getLogo", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "manualCaptureSubtitle", "getManualCaptureSubtitle$annotations", "()V", "getManualCaptureSubtitle", "()I", "getNfcAvailable", "()Z", "getOcrRequired", "getResourceId", "getScanConfigurations", "()Ljava/util/List;", "scanSubTitle", "getScanSubTitle$annotations", "getScanSubTitle", "scanTimedOutSubtitle", "getScanTimedOutSubtitle$annotations", "getScanTimedOutSubtitle", "scanTimedOutTitle", "getScanTimedOutTitle$annotations", "getScanTimedOutTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZZLcom/yoti/mobile/android/documentcapture/id/view/scan/ConsentViewData;)Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "describeContents", "equals", "other", "", "getManualCaptureTitle", "context", "Landroid/content/Context;", "pageNumber", "getScanTitle", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class IdScanConfigurationViewData implements IScanConfigurationViewData, IScanViewConfiguration {
    public static final Parcelable.Creator<IdScanConfigurationViewData> CREATOR = new Creator();
    private String blinkIdKey;
    private String blinkIdLicensee;
    private final ConsentViewData consent;
    private final String countryIso3Code;
    private final DocumentTypeViewData documentType;
    private final Integer logo;
    private final int manualCaptureSubtitle;
    private final boolean nfcAvailable;
    private final boolean ocrRequired;
    private final String resourceId;
    private final List<DocumentScanDetailedPageConfig> scanConfigurations;
    private final int scanSubTitle;
    private final int scanTimedOutSubtitle;
    private final int scanTimedOutTitle;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<IdScanConfigurationViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IdScanConfigurationViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            DocumentTypeViewData documentTypeViewData = (DocumentTypeViewData) parcel.readParcelable(IdScanConfigurationViewData.class.getClassLoader());
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(parcel.readParcelable(IdScanConfigurationViewData.class.getClassLoader()));
            }
            return new IdScanConfigurationViewData(string, string2, documentTypeViewData, arrayList, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0 ? ConsentViewData.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IdScanConfigurationViewData[] newArray(int i) {
            return new IdScanConfigurationViewData[i];
        }
    }

    public IdScanConfigurationViewData(String resourceId, String countryIso3Code, DocumentTypeViewData documentType, List<DocumentScanDetailedPageConfig> scanConfigurations, Integer num, String blinkIdKey, String str, boolean z, boolean z2, ConsentViewData consentViewData) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(scanConfigurations, "scanConfigurations");
        Intrinsics.checkNotNullParameter(blinkIdKey, "blinkIdKey");
        this.resourceId = resourceId;
        this.countryIso3Code = countryIso3Code;
        this.documentType = documentType;
        this.scanConfigurations = scanConfigurations;
        this.logo = num;
        this.blinkIdKey = blinkIdKey;
        this.blinkIdLicensee = str;
        this.ocrRequired = z;
        this.nfcAvailable = z2;
        this.consent = consentViewData;
        this.scanSubTitle = C4608R.string.ios_android_yds_document_capture_automatic_capture_description;
        this.scanTimedOutTitle = C4608R.string.ios_android_yds_document_capture_manual_capture_header;
        this.scanTimedOutSubtitle = C4608R.string.ios_android_yds_document_capture_manual_capture_description;
        this.manualCaptureSubtitle = C4608R.string.f6700xe556ffc4;
    }

    public static /* synthetic */ void getManualCaptureSubtitle$annotations() {
    }

    public static /* synthetic */ void getScanSubTitle$annotations() {
    }

    public static /* synthetic */ void getScanTimedOutSubtitle$annotations() {
    }

    public static /* synthetic */ void getScanTimedOutTitle$annotations() {
    }

    public final String component1() {
        return getResourceId();
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final ConsentViewData getConsent() {
        return this.consent;
    }

    public final String component2() {
        return getCountryIso3Code();
    }

    public final DocumentTypeViewData component3() {
        return getDocumentType();
    }

    public final List<DocumentScanDetailedPageConfig> component4() {
        return this.scanConfigurations;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getLogo() {
        return this.logo;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getBlinkIdKey() {
        return this.blinkIdKey;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getBlinkIdLicensee() {
        return this.blinkIdLicensee;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getOcrRequired() {
        return this.ocrRequired;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getNfcAvailable() {
        return this.nfcAvailable;
    }

    public final IdScanConfigurationViewData copy(String resourceId, String countryIso3Code, DocumentTypeViewData documentType, List<DocumentScanDetailedPageConfig> scanConfigurations, Integer logo, String blinkIdKey, String blinkIdLicensee, boolean ocrRequired, boolean nfcAvailable, ConsentViewData consent) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(scanConfigurations, "scanConfigurations");
        Intrinsics.checkNotNullParameter(blinkIdKey, "blinkIdKey");
        return new IdScanConfigurationViewData(resourceId, countryIso3Code, documentType, scanConfigurations, logo, blinkIdKey, blinkIdLicensee, ocrRequired, nfcAvailable, consent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdScanConfigurationViewData)) {
            return false;
        }
        IdScanConfigurationViewData idScanConfigurationViewData = (IdScanConfigurationViewData) other;
        return Intrinsics.areEqual(getResourceId(), idScanConfigurationViewData.getResourceId()) && Intrinsics.areEqual(getCountryIso3Code(), idScanConfigurationViewData.getCountryIso3Code()) && getDocumentType() == idScanConfigurationViewData.getDocumentType() && Intrinsics.areEqual(this.scanConfigurations, idScanConfigurationViewData.scanConfigurations) && Intrinsics.areEqual(this.logo, idScanConfigurationViewData.logo) && Intrinsics.areEqual(this.blinkIdKey, idScanConfigurationViewData.blinkIdKey) && Intrinsics.areEqual(this.blinkIdLicensee, idScanConfigurationViewData.blinkIdLicensee) && this.ocrRequired == idScanConfigurationViewData.ocrRequired && this.nfcAvailable == idScanConfigurationViewData.nfcAvailable && Intrinsics.areEqual(this.consent, idScanConfigurationViewData.consent);
    }

    public final String getBlinkIdKey() {
        return this.blinkIdKey;
    }

    public final String getBlinkIdLicensee() {
        return this.blinkIdLicensee;
    }

    public final ConsentViewData getConsent() {
        return this.consent;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData
    public String getCountryIso3Code() {
        return this.countryIso3Code;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData
    public int getDocumentName() {
        return IScanConfigurationViewData.DefaultImpls.getDocumentName(this);
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanViewConfiguration
    /* JADX INFO: renamed from: getDocumentRatio */
    public float getF6988a() {
        return this.scanConfigurations.get(0).getDocumentRatio();
    }

    @Override // com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData
    public DocumentTypeViewData getDocumentType() {
        return this.documentType;
    }

    public final Integer getLogo() {
        return this.logo;
    }

    public final int getManualCaptureSubtitle() {
        return this.manualCaptureSubtitle;
    }

    public final String getManualCaptureTitle(Context context, int pageNumber) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (getDocumentType() == DocumentTypeViewData.PASSPORT) {
            String string = context.getString(C4608R.string.f6701xf776c14c);
            Intrinsics.checkNotNullExpressionValue(string, "{\n                contex…r_passport)\n            }");
            return string;
        }
        if (this.scanConfigurations.size() == 1) {
            String string2 = context.getString(getDocumentName());
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(documentName)");
            String string3 = context.getString(C4608R.string.f6703xed90e99a, string2);
            Intrinsics.checkNotNullExpressionValue(string3, "{\n                val do…          )\n            }");
            return string3;
        }
        if (pageNumber == 0) {
            String string4 = context.getString(getDocumentName());
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(documentName)");
            String string5 = context.getString(C4608R.string.f6699xfaaa796a, string4);
            Intrinsics.checkNotNullExpressionValue(string5, "{\n                val do…          )\n            }");
            return string5;
        }
        String string6 = context.getString(getDocumentName());
        Intrinsics.checkNotNullExpressionValue(string6, "context.getString(documentName)");
        String string7 = context.getString(C4608R.string.f6697xda108030, string6);
        Intrinsics.checkNotNullExpressionValue(string7, "{\n                val do…          )\n            }");
        return string7;
    }

    public final boolean getNfcAvailable() {
        return this.nfcAvailable;
    }

    public final boolean getOcrRequired() {
        return this.ocrRequired;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData
    public String getResourceId() {
        return this.resourceId;
    }

    public final List<DocumentScanDetailedPageConfig> getScanConfigurations() {
        return this.scanConfigurations;
    }

    public final int getScanSubTitle() {
        return this.scanSubTitle;
    }

    public final int getScanTimedOutSubtitle() {
        return this.scanTimedOutSubtitle;
    }

    public final int getScanTimedOutTitle() {
        return this.scanTimedOutTitle;
    }

    public final String getScanTitle(Context context, int pageNumber) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (getDocumentType() == DocumentTypeViewData.PASSPORT) {
            String string = context.getString(C4608R.string.ios_android_yds_document_capture_header_passport);
            Intrinsics.checkNotNullExpressionValue(string, "{\n                contex…r_passport)\n            }");
            return string;
        }
        if (this.scanConfigurations.size() == 1) {
            String string2 = context.getString(getDocumentName());
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(documentName)");
            String string3 = context.getString(C4608R.string.f6702x530f6489, string2);
            Intrinsics.checkNotNullExpressionValue(string3, "{\n                val do…          )\n            }");
            return string3;
        }
        if (pageNumber == 0) {
            String string4 = context.getString(getDocumentName());
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(documentName)");
            String string5 = context.getString(C4608R.string.f6698x2a9862b9, string4);
            Intrinsics.checkNotNullExpressionValue(string5, "{\n                val do…          )\n            }");
            return string5;
        }
        String string6 = context.getString(getDocumentName());
        Intrinsics.checkNotNullExpressionValue(string6, "context.getString(documentName)");
        String string7 = context.getString(C4608R.string.f6696xa450d233, string6);
        Intrinsics.checkNotNullExpressionValue(string7, "{\n                val do…          )\n            }");
        return string7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iHashCode = ((((((getResourceId().hashCode() * 31) + getCountryIso3Code().hashCode()) * 31) + getDocumentType().hashCode()) * 31) + this.scanConfigurations.hashCode()) * 31;
        Integer num = this.logo;
        int iHashCode2 = (((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.blinkIdKey.hashCode()) * 31;
        String str = this.blinkIdLicensee;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z = this.ocrRequired;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode3 + r1) * 31;
        boolean z2 = this.nfcAvailable;
        int i2 = (i + (z2 ? 1 : z2)) * 31;
        ConsentViewData consentViewData = this.consent;
        return i2 + (consentViewData != null ? consentViewData.hashCode() : 0);
    }

    public final void setBlinkIdKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.blinkIdKey = str;
    }

    public final void setBlinkIdLicensee(String str) {
        this.blinkIdLicensee = str;
    }

    public String toString() {
        return "IdScanConfigurationViewData(resourceId=" + getResourceId() + ", countryIso3Code=" + getCountryIso3Code() + ", documentType=" + getDocumentType() + ", scanConfigurations=" + this.scanConfigurations + ", logo=" + this.logo + ", blinkIdKey=" + this.blinkIdKey + ", blinkIdLicensee=" + this.blinkIdLicensee + ", ocrRequired=" + this.ocrRequired + ", nfcAvailable=" + this.nfcAvailable + ", consent=" + this.consent + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.resourceId);
        parcel.writeString(this.countryIso3Code);
        parcel.writeParcelable(this.documentType, flags);
        List<DocumentScanDetailedPageConfig> list = this.scanConfigurations;
        parcel.writeInt(list.size());
        Iterator<DocumentScanDetailedPageConfig> it2 = list.iterator();
        while (it2.hasNext()) {
            parcel.writeParcelable(it2.next(), flags);
        }
        Integer num = this.logo;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.blinkIdKey);
        parcel.writeString(this.blinkIdLicensee);
        parcel.writeInt(this.ocrRequired ? 1 : 0);
        parcel.writeInt(this.nfcAvailable ? 1 : 0);
        ConsentViewData consentViewData = this.consent;
        if (consentViewData == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            consentViewData.writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ IdScanConfigurationViewData(String str, String str2, DocumentTypeViewData documentTypeViewData, List list, Integer num, String str3, String str4, boolean z, boolean z2, ConsentViewData consentViewData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, documentTypeViewData, list, (i & 16) != 0 ? null : num, str3, str4, z, z2, consentViewData);
    }
}
