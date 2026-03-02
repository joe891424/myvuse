package com.yoti.mobile.android.liveness.domain;

import androidx.exifinterface.media.ExifInterface;
import com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity;
import io.reactivex.Flowable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/domain/ILivenessCaptureRepository;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessCaptureEntity;", "", "upload", "Lio/reactivex/Flowable;", "", "livenessCapture", "(Lcom/yoti/mobile/android/liveness/domain/model/ILivenessCaptureEntity;)Lio/reactivex/Flowable;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ILivenessCaptureRepository<T extends ILivenessCaptureEntity> {
    Flowable<Double> upload(T livenessCapture);
}
