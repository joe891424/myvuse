package com.facebook.common.closeables;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AutoCleanupDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0004"}, m5598d2 = {"closeableCleanupFunction", "Lkotlin/Function1;", "Ljava/io/Closeable;", "", "fbcore_release"}, m5599k = 2, m5600mv = {1, 8, 0}, m5602xi = 48)
public final class AutoCleanupDelegateKt {
    private static final Function1<Closeable, Unit> closeableCleanupFunction = new Function1<Closeable, Unit>() { // from class: com.facebook.common.closeables.AutoCleanupDelegateKt$closeableCleanupFunction$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Closeable closeable) throws IOException {
            invoke2(closeable);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Closeable it2) throws IOException {
            Intrinsics.checkNotNullParameter(it2, "it");
            it2.close();
        }
    };
}
