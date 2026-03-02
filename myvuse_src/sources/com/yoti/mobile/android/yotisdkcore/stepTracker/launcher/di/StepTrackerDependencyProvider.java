package com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di;

import com.yoti.mobile.android.yotisdkcore.core.data.SessionConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SourceTypeEntity;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.CaptureCameraProperties;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.DocumentCaptureProperties;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.UiSessionProperties;
import com.yoti.mobile.android.yotisdkcore.stepTracker.data.SessionTokenRepository;
import com.yoti.mobile.android.yotisdkcore.stepTracker.di.IStepTrackerCoreDependencyProvider;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.ISessionTokenRepository;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.SessionConfigurationFilterProcessor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di.c, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/di/StepTrackerDependencyProvider;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/IStepTrackerCoreDependencyProvider;", "ydsTokenRepository", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/data/SessionTokenRepository;", "ydsStepRepository", "Lcom/yoti/mobile/android/yotisdkcore/core/data/SessionConfigurationRepository;", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/data/SessionTokenRepository;Lcom/yoti/mobile/android/yotisdkcore/core/data/SessionConfigurationRepository;)V", "documentCaptureProperties", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/DocumentCaptureProperties;", "getDocumentCaptureProperties", "()Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/DocumentCaptureProperties;", "faceCaptureCameraProperties", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/CaptureCameraProperties;", "getFaceCaptureCameraProperties", "()Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/CaptureCameraProperties;", "sessionConfigurationFilterOptions", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/SessionConfigurationFilterProcessor$FilterProcessorOptions;", "getSessionConfigurationFilterOptions", "()Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/SessionConfigurationFilterProcessor$FilterProcessorOptions;", "stepRepository", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionConfigurationRepository;", "getStepRepository", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionConfigurationRepository;", "tokenRepository", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/ISessionTokenRepository;", "getTokenRepository", "()Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/ISessionTokenRepository;", "uiSessionProperties", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/UiSessionProperties;", "getUiSessionProperties", "()Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/UiSessionProperties;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class StepTrackerDependencyProvider implements IStepTrackerCoreDependencyProvider {

    /* JADX INFO: renamed from: a */
    private final ISessionConfigurationRepository f7745a;

    /* JADX INFO: renamed from: b */
    private final SessionConfigurationFilterProcessor.a f7746b;

    /* JADX INFO: renamed from: c */
    private final ISessionTokenRepository f7747c;

    /* JADX INFO: renamed from: d */
    private final CaptureCameraProperties f7748d;

    /* JADX INFO: renamed from: e */
    private final DocumentCaptureProperties f7749e;

    /* JADX INFO: renamed from: f */
    private final UiSessionProperties f7750f;

    @Inject
    public StepTrackerDependencyProvider(SessionTokenRepository ydsTokenRepository, SessionConfigurationRepository ydsStepRepository) {
        Intrinsics.checkNotNullParameter(ydsTokenRepository, "ydsTokenRepository");
        Intrinsics.checkNotNullParameter(ydsStepRepository, "ydsStepRepository");
        this.f7745a = ydsStepRepository;
        this.f7746b = new SessionConfigurationFilterProcessor.a(SourceTypeEntity.END_USER);
        this.f7747c = ydsTokenRepository;
        this.f7748d = new CaptureCameraProperties(false, false, 2, null);
        this.f7749e = new DocumentCaptureProperties(true);
        this.f7750f = new UiSessionProperties(true, true);
    }

    @Override // com.yoti.mobile.android.yotisdkcore.stepTracker.di.IStepTrackerCoreDependencyProvider
    /* JADX INFO: renamed from: a, reason: from getter */
    public ISessionTokenRepository getF7747c() {
        return this.f7747c;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.stepTracker.di.IStepTrackerCoreDependencyProvider
    /* JADX INFO: renamed from: b, reason: from getter */
    public UiSessionProperties getF7750f() {
        return this.f7750f;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.stepTracker.di.IStepTrackerCoreDependencyProvider
    /* JADX INFO: renamed from: c, reason: from getter */
    public DocumentCaptureProperties getF7749e() {
        return this.f7749e;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.stepTracker.di.IStepTrackerCoreDependencyProvider
    /* JADX INFO: renamed from: d, reason: from getter */
    public SessionConfigurationFilterProcessor.a getF7746b() {
        return this.f7746b;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.stepTracker.di.IStepTrackerCoreDependencyProvider
    /* JADX INFO: renamed from: e, reason: from getter */
    public CaptureCameraProperties getF7748d() {
        return this.f7748d;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.stepTracker.di.IStepTrackerCoreDependencyProvider
    /* JADX INFO: renamed from: f, reason: from getter */
    public ISessionConfigurationRepository getF7745a() {
        return this.f7745a;
    }
}
