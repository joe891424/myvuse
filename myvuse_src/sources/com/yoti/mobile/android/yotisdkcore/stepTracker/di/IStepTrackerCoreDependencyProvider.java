package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.CaptureCameraProperties;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.DocumentCaptureProperties;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.UiSessionProperties;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.ISessionTokenRepository;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.SessionConfigurationFilterProcessor;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.di.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/IStepTrackerCoreDependencyProvider;", "", "documentCaptureProperties", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/DocumentCaptureProperties;", "getDocumentCaptureProperties", "()Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/DocumentCaptureProperties;", "faceCaptureCameraProperties", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/CaptureCameraProperties;", "getFaceCaptureCameraProperties", "()Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/CaptureCameraProperties;", "sessionConfigurationFilterOptions", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/SessionConfigurationFilterProcessor$FilterProcessorOptions;", "getSessionConfigurationFilterOptions", "()Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/SessionConfigurationFilterProcessor$FilterProcessorOptions;", "stepRepository", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionConfigurationRepository;", "getStepRepository", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionConfigurationRepository;", "tokenRepository", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/ISessionTokenRepository;", "getTokenRepository", "()Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/ISessionTokenRepository;", "uiSessionProperties", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/UiSessionProperties;", "getUiSessionProperties", "()Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/UiSessionProperties;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IStepTrackerCoreDependencyProvider {
    /* JADX INFO: renamed from: a */
    ISessionTokenRepository mo5143a();

    /* JADX INFO: renamed from: b */
    UiSessionProperties mo5144b();

    /* JADX INFO: renamed from: c */
    DocumentCaptureProperties mo5145c();

    /* JADX INFO: renamed from: d */
    SessionConfigurationFilterProcessor.a mo5146d();

    /* JADX INFO: renamed from: e */
    CaptureCameraProperties mo5147e();

    /* JADX INFO: renamed from: f */
    ISessionConfigurationRepository mo5148f();
}
