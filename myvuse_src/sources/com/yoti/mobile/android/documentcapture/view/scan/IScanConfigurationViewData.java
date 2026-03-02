package com.yoti.mobile.android.documentcapture.view.scan;

import android.os.Parcelable;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u00078WX\u0096\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/scan/IScanConfigurationViewData;", "Landroid/os/Parcelable;", "countryIso3Code", "", "getCountryIso3Code", "()Ljava/lang/String;", "documentName", "", "getDocumentName$annotations", "()V", "getDocumentName", "()I", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "resourceId", "getResourceId", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IScanConfigurationViewData extends Parcelable {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DefaultImpls {
        public static int getDocumentName(IScanConfigurationViewData iScanConfigurationViewData) {
            return iScanConfigurationViewData.getDocumentType().getDocumentName(iScanConfigurationViewData.getCountryIso3Code()).getLowercaseName();
        }

        public static /* synthetic */ void getDocumentName$annotations() {
        }
    }

    String getCountryIso3Code();

    int getDocumentName();

    DocumentTypeViewData getDocumentType();

    String getResourceId();
}
