package com.yoti.mobile.android.liveness.domain;

import androidx.exifinterface.media.ExifInterface;
import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/domain/ILivenessResourceCreationRepository;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;", "", "createLivenessResource", "Lio/reactivex/Single;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ILivenessResourceCreationRepository<T extends ILivenessResourceEntity> {
    Single<T> createLivenessResource();
}
