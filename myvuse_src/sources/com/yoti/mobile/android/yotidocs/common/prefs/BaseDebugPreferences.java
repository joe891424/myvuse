package com.yoti.mobile.android.yotidocs.common.prefs;

import android.content.SharedPreferences;
import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0004R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/prefs/BaseDebugPreferences;", "", "prefs", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "booleanProperty", "Lcom/yoti/mobile/android/yotidocs/common/prefs/BooleanPropertyDelegate;", "key", "", Constants.COLLATION_DEFAULT, "", "stringProperty", "Lcom/yoti/mobile/android/yotidocs/common/prefs/StringPropertyDelegate;", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class BaseDebugPreferences {

    /* JADX INFO: renamed from: a */
    private final SharedPreferences f7509a;

    public BaseDebugPreferences(SharedPreferences sharedPreferences) {
        this.f7509a = sharedPreferences;
    }

    protected final BooleanPropertyDelegate booleanProperty(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new BooleanPropertyDelegate(this.f7509a, key, z);
    }

    protected final StringPropertyDelegate stringProperty(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        return new StringPropertyDelegate(this.f7509a, key, str);
    }
}
