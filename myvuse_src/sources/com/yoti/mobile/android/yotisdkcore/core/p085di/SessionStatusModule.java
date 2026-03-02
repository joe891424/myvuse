package com.yoti.mobile.android.yotisdkcore.core.p085di;

import android.content.Context;
import android.content.SharedPreferences;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionStatusRepositoryKt;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/di/SessionStatusModule;", "", "()V", "sessionStatusPreferences", "Landroid/content/SharedPreferences;", "applicationContext", "Landroid/content/Context;", "sessionStatusRepository", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionStatusRepository;", "repository", "Lcom/yoti/mobile/android/yotisdkcore/core/data/SessionStatusRepository;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module(includes = {CommonModule.class})
public final class SessionStatusModule {
    @SessionStatus
    @Provides
    public final SharedPreferences sessionStatusPreferences(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(SessionStatusRepositoryKt.PREFS_SESSION_STATUS, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "applicationContext.getSh…US, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    @Provides
    public final ISessionStatusRepository sessionStatusRepository(SessionStatusRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return repository;
    }
}
