package com.yoti.mobile.android.yotisdkcore.core.view;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/view/FeatureLauncherFactory;", "", "()V", "create", "Lcom/yoti/mobile/android/yotisdkcore/core/view/FeatureLauncher;", "launcherPath", "", "createConstructor", "Ljava/lang/reflect/Constructor;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FeatureLauncherFactory {
    @Inject
    public FeatureLauncherFactory() {
    }

    private final Constructor<? extends Object> createConstructor(String launcherPath) throws NoSuchMethodException {
        Constructor constructor = Class.forName(launcherPath).getConstructor(new Class[0]);
        Intrinsics.checkNotNullExpressionValue(constructor, "forName(launcherPath).getConstructor()");
        return constructor;
    }

    public final FeatureLauncher create(String launcherPath) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(launcherPath, "launcherPath");
        Object objNewInstance = createConstructor(launcherPath).newInstance(new Object[0]);
        if (objNewInstance != null) {
            return (FeatureLauncher) objNewInstance;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.yotisdkcore.core.view.FeatureLauncher");
    }
}
