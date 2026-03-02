package com.yoti.mobile.android.scan.p078ui;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.scan.p076a.C4932a;
import com.yoti.mobile.android.scan.p077b.C4935a;
import com.yoti.mobile.android.scan.p077b.C4936b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.scan.ui.c */
/* JADX INFO: loaded from: classes4.dex */
public final class C4947c extends ViewModel {

    /* JADX INFO: renamed from: a */
    private final MutableLiveData<C4946b> f7438a;

    /* JADX INFO: renamed from: b */
    private final LiveData<C4946b> f7439b;

    /* JADX INFO: renamed from: c */
    private final C4936b f7440c;

    /* JADX INFO: renamed from: d */
    private final C4935a f7441d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C4947c(Context context) {
        this(new C4932a(context));
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C4947c(C4932a scanScreenPreferences) {
        this(new C4936b(scanScreenPreferences), new C4935a(scanScreenPreferences));
        Intrinsics.checkParameterIsNotNull(scanScreenPreferences, "scanScreenPreferences");
    }

    public C4947c(C4936b shouldShowInstructions, C4935a onHideScanInstructions) {
        Intrinsics.checkParameterIsNotNull(shouldShowInstructions, "shouldShowInstructions");
        Intrinsics.checkParameterIsNotNull(onHideScanInstructions, "onHideScanInstructions");
        this.f7440c = shouldShowInstructions;
        this.f7441d = onHideScanInstructions;
        MutableLiveData<C4946b> mutableLiveData = new MutableLiveData<>();
        this.f7438a = mutableLiveData;
        this.f7439b = mutableLiveData;
        mutableLiveData.setValue(new C4946b(shouldShowInstructions.m5065a()));
    }

    /* JADX INFO: renamed from: a */
    public final LiveData<C4946b> m5074a() {
        return this.f7439b;
    }

    /* JADX INFO: renamed from: b */
    public final void m5075b() {
        this.f7441d.m5064a();
        this.f7438a.setValue(new C4946b(false));
    }
}
