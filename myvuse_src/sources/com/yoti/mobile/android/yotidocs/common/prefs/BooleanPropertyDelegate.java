package com.yoti.mobile.android.yotidocs.common.prefs;

import android.content.SharedPreferences;
import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001f\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0086\u0002J'\u0010\u0013\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/prefs/BooleanPropertyDelegate;", "", "prefs", "Landroid/content/SharedPreferences;", "key", "", Constants.COLLATION_DEFAULT, "", "(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V", "getDefault", "()Z", "getKey", "()Ljava/lang/String;", "getPrefs", "()Landroid/content/SharedPreferences;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class BooleanPropertyDelegate {

    /* JADX INFO: renamed from: a */
    private final SharedPreferences f7510a;

    /* JADX INFO: renamed from: b */
    private final String f7511b;

    /* JADX INFO: renamed from: c */
    private final boolean f7512c;

    public BooleanPropertyDelegate(SharedPreferences sharedPreferences, String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f7510a = sharedPreferences;
        this.f7511b = key;
        this.f7512c = z;
    }

    /* JADX INFO: renamed from: getDefault, reason: from getter */
    public final boolean getF7512c() {
        return this.f7512c;
    }

    /* JADX INFO: renamed from: getKey, reason: from getter */
    public final String getF7511b() {
        return this.f7511b;
    }

    /* JADX INFO: renamed from: getPrefs, reason: from getter */
    public final SharedPreferences getF7510a() {
        return this.f7510a;
    }

    public final boolean getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        SharedPreferences sharedPreferences = this.f7510a;
        return sharedPreferences != null ? sharedPreferences.getBoolean(this.f7511b, this.f7512c) : this.f7512c;
    }

    public final void setValue(Object thisRef, KProperty<?> property, boolean value) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutBoolean;
        Intrinsics.checkNotNullParameter(property, "property");
        SharedPreferences sharedPreferences = this.f7510a;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null || (editorPutBoolean = editorEdit.putBoolean(this.f7511b, value)) == null) {
            return;
        }
        editorPutBoolean.apply();
    }
}
