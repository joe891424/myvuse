package com.yoti.mobile.android.documentscan.ui;

import com.yoti.mobile.android.documentscan.ui.PageState;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.z */
/* JADX INFO: loaded from: classes5.dex */
final class C4831z<T> implements Predicate<PageState> {

    /* JADX INFO: renamed from: a */
    public static final C4831z f7167a = new C4831z();

    C4831z() {
    }

    @Override // io.reactivex.functions.Predicate
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final boolean test(PageState it2) {
        Intrinsics.checkParameterIsNotNull(it2, "it");
        return Intrinsics.areEqual(it2, PageState.a.f7127a);
    }
}
