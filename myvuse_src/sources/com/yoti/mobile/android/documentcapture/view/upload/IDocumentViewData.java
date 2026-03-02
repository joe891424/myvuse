package com.yoti.mobile.android.documentcapture.view.upload;

import android.os.Parcelable;
import com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadableViewData;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u00012\u00020\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;", "Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadableViewData;", "Landroid/os/Parcelable;", "countryIso3Code", "", "getCountryIso3Code", "()Ljava/lang/String;", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "resourceId", "getResourceId", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IDocumentViewData extends UploadableViewData, Parcelable {
    String getCountryIso3Code();

    DocumentTypeViewData getDocumentType();

    String getResourceId();
}
