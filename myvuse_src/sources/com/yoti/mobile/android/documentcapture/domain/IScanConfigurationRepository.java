package com.yoti.mobile.android.documentcapture.domain;

import androidx.exifinterface.media.ExifInterface;
import com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/IScanConfigurationRepository;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/documentcapture/domain/model/IScanConfigurationEntity;", "", "getScanConfiguration", "Lio/reactivex/Single;", "countryIso3Code", "", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IScanConfigurationRepository<T extends IScanConfigurationEntity> {
    Single<T> getScanConfiguration(String countryIso3Code, DocumentResourceConfigEntity.DocumentTypeEntity documentType);
}
