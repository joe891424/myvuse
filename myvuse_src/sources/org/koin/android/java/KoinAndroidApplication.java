package org.koin.android.java;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.koin.android.ext.koin.KoinExtKt;
import org.koin.core.KoinApplication;
import org.koin.core.logger.Level;

/* JADX INFO: compiled from: KoinAndroidApplication.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, m5598d2 = {"Lorg/koin/android/java/KoinAndroidApplication;", "", "()V", "create", "Lorg/koin/core/KoinApplication;", "context", "Landroid/content/Context;", "androidLoggerLevel", "Lorg/koin/core/logger/Level;", "koin-android_release"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class KoinAndroidApplication {
    public static final KoinAndroidApplication INSTANCE = new KoinAndroidApplication();

    @JvmStatic
    public static final KoinApplication create(Context context) {
        return create$default(context, null, 2, null);
    }

    private KoinAndroidApplication() {
    }

    public static /* synthetic */ KoinApplication create$default(Context context, Level level, int i, Object obj) {
        if ((i & 2) != 0) {
            level = Level.INFO;
        }
        return create(context, level);
    }

    @JvmStatic
    public static final KoinApplication create(Context context, Level androidLoggerLevel) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(androidLoggerLevel, "androidLoggerLevel");
        return KoinExtKt.androidLogger(KoinExtKt.androidContext(KoinApplication.INSTANCE.init(), context), androidLoggerLevel);
    }
}
