package com.yoti.mobile.android.scan.p078ui;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.scan.ui.a */
/* JADX INFO: loaded from: classes4.dex */
public final class C4945a implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: a */
    private final Context f7436a;

    public C4945a(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f7436a = context;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkParameterIsNotNull(modelClass, "modelClass");
        if (Intrinsics.areEqual(modelClass, C4947c.class)) {
            return new C4947c(this.f7436a);
        }
        throw new IllegalArgumentException("Can't instantiate " + modelClass);
    }
}
