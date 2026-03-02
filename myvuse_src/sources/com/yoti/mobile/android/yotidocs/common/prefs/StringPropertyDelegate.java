package com.yoti.mobile.android.yotidocs.common.prefs;

import android.content.SharedPreferences;
import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u001f\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0086\u0002J'\u0010\u0011\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0013\u001a\u00020\u0005H\u0086\u0002R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/prefs/StringPropertyDelegate;", "", "prefs", "Landroid/content/SharedPreferences;", "key", "", Constants.COLLATION_DEFAULT, "(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V", "getDefault", "()Ljava/lang/String;", "getKey", "getPrefs", "()Landroid/content/SharedPreferences;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class StringPropertyDelegate {

    /* JADX INFO: renamed from: a */
    private final SharedPreferences f7513a;

    /* JADX INFO: renamed from: b */
    private final String f7514b;

    /* JADX INFO: renamed from: c */
    private final String f7515c;

    public StringPropertyDelegate(SharedPreferences sharedPreferences, String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        this.f7513a = sharedPreferences;
        this.f7514b = key;
        this.f7515c = str;
    }

    /* JADX INFO: renamed from: getDefault, reason: from getter */
    public final String getF7515c() {
        return this.f7515c;
    }

    /* JADX INFO: renamed from: getKey, reason: from getter */
    public final String getF7514b() {
        return this.f7514b;
    }

    /* JADX INFO: renamed from: getPrefs, reason: from getter */
    public final SharedPreferences getF7513a() {
        return this.f7513a;
    }

    public final String getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        SharedPreferences sharedPreferences = this.f7513a;
        String string = sharedPreferences != null ? sharedPreferences.getString(this.f7514b, this.f7515c) : null;
        return string == null ? this.f7515c : string;
    }

    public final void setValue(Object thisRef, KProperty<?> property, String value) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences sharedPreferences = this.f7513a;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null || (editorPutString = editorEdit.putString(this.f7514b, value)) == null) {
            return;
        }
        editorPutString.apply();
    }
}
