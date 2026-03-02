package com.yoti.mobile.android.documentcapture.domain;

import androidx.exifinterface.media.ExifInterface;
import com.yoti.mobile.android.documentcapture.domain.model.IDocumentEntity;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/IDocumentRepository;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/documentcapture/domain/model/IDocumentEntity;", "", "setAssessmentsResults", "Lio/reactivex/Completable;", "resourceId", "", "ibvClientAssessments", "", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$IbvClientAssessmentEntity;", "upload", "Lio/reactivex/Flowable;", "", "document", "(Lcom/yoti/mobile/android/documentcapture/domain/model/IDocumentEntity;)Lio/reactivex/Flowable;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IDocumentRepository<T extends IDocumentEntity> {
    Completable setAssessmentsResults(String resourceId, List<DocumentResourceConfigEntity.IbvClientAssessmentEntity> ibvClientAssessments);

    Flowable<Double> upload(T document);
}
