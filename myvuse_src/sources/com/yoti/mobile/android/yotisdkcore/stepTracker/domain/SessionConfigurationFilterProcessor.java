package com.yoti.mobile.android.yotisdkcore.stepTracker.domain;

import com.yoti.mobile.android.yotidocs.common.error.YotiDocsUnexpectedError;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SourceTypeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.domain.d, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\bB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/SessionConfigurationFilterProcessor;", "", "filterOptions", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/SessionConfigurationFilterProcessor$FilterProcessorOptions;", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/SessionConfigurationFilterProcessor$FilterProcessorOptions;)V", "filter", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity;", "sessionConfiguration", "FilterProcessorOptions", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SessionConfigurationFilterProcessor {

    /* JADX INFO: renamed from: a */
    private final a f7689a;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.domain.d$a */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/SessionConfigurationFilterProcessor$FilterProcessorOptions;", "", "allowedSource", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SourceTypeEntity;", "(Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SourceTypeEntity;)V", "getAllowedSource", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SourceTypeEntity;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a */
        private final SourceTypeEntity f7690a;

        public a(SourceTypeEntity allowedSource) {
            Intrinsics.checkNotNullParameter(allowedSource, "allowedSource");
            this.f7690a = allowedSource;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final SourceTypeEntity getF7690a() {
            return this.f7690a;
        }
    }

    @Inject
    public SessionConfigurationFilterProcessor(a filterOptions) {
        Intrinsics.checkNotNullParameter(filterOptions, "filterOptions");
        this.f7689a = filterOptions;
    }

    /* JADX INFO: renamed from: a */
    public final SessionConfigurationEntity m5171a(SessionConfigurationEntity sessionConfiguration) throws YotiDocsUnexpectedError {
        Intrinsics.checkNotNullParameter(sessionConfiguration, "sessionConfiguration");
        List<ResourceConfigurationEntity> steps = sessionConfiguration.getSteps();
        ArrayList arrayList = new ArrayList();
        for (Object obj : steps) {
            if (((ResourceConfigurationEntity) obj).isResourceCreationEnabled(this.f7689a.getF7690a())) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new YotiDocsUnexpectedError(new IllegalStateException("Step filtering returns an empty list, origin " + sessionConfiguration.getSteps()));
        }
        return SessionConfigurationEntity.copy$default(sessionConfiguration, 0, null, arrayList, null, null, null, 59, null);
    }
}
