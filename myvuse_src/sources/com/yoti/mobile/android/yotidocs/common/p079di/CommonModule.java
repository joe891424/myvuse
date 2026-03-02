package com.yoti.mobile.android.yotidocs.common.p079di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/di/CommonModule;", "", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public final class CommonModule {

    /* JADX INFO: renamed from: a */
    private final Context f7476a;

    public CommonModule(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.f7476a = applicationContext;
    }

    @Provides
    @Singleton
    /* JADX INFO: renamed from: applicationContext, reason: from getter */
    public final Context getF7476a() {
        return this.f7476a;
    }
}
