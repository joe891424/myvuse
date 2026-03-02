package com.salesforce.marketingcloud.sfmcsdk.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApplicationUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u0004\u0018\u0001H\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0005"}, m5598d2 = {"orElse", "R", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "sfmcsdk_release"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ApplicationUtilsKt {
    public static final <R> R orElse(R r, Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return r == null ? block.invoke() : r;
    }
}
