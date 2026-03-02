package com.yoti.mobile.android.liveness.p071di;

import com.yoti.mobile.android.liveness.domain.ILivenessResourceCreationRepository;
import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigatorProvider;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/di/ILivenessEducationalDependeciesProvider;", "", "educationalNavigatorProvider", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigatorProvider;", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;", "getEducationalNavigatorProvider", "()Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigatorProvider;", "educationalViewConfiguration", "Lcom/yoti/mobile/android/liveness/view/educational/ILivenessEducationalViewConfiguration;", "getEducationalViewConfiguration", "()Lcom/yoti/mobile/android/liveness/view/educational/ILivenessEducationalViewConfiguration;", "guidelinesViewDataFactory", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "getGuidelinesViewDataFactory", "()Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "resourceCreationRepository", "Lcom/yoti/mobile/android/liveness/domain/ILivenessResourceCreationRepository;", "getResourceCreationRepository", "()Lcom/yoti/mobile/android/liveness/domain/ILivenessResourceCreationRepository;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ILivenessEducationalDependeciesProvider {
    ILivenessEducationalNavigatorProvider<ILivenessResourceEntity> getEducationalNavigatorProvider();

    ILivenessEducationalViewConfiguration getEducationalViewConfiguration();

    LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> getGuidelinesViewDataFactory();

    ILivenessResourceCreationRepository<ILivenessResourceEntity> getResourceCreationRepository();
}
