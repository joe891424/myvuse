package com.salesforce.marketingcloud.sfmcsdk.components.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkExecutors.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/components/utils/SdkExecutors;", "", "diskIO", "Ljava/util/concurrent/ExecutorService;", "networkIO", "(Ljava/util/concurrent/ExecutorService;Ljava/util/concurrent/ExecutorService;)V", "getDiskIO", "()Ljava/util/concurrent/ExecutorService;", "getNetworkIO", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SdkExecutors {
    private final ExecutorService diskIO;
    private final ExecutorService networkIO;

    /* JADX WARN: Multi-variable type inference failed */
    public SdkExecutors() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public SdkExecutors(ExecutorService diskIO, ExecutorService networkIO) {
        Intrinsics.checkNotNullParameter(diskIO, "diskIO");
        Intrinsics.checkNotNullParameter(networkIO, "networkIO");
        this.diskIO = diskIO;
        this.networkIO = networkIO;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SdkExecutors(ExecutorService executorService, ExecutorService executorService2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            executorService = Executors.newSingleThreadExecutor();
            Intrinsics.checkNotNullExpressionValue(executorService, "newSingleThreadExecutor()");
        }
        if ((i & 2) != 0) {
            executorService2 = Executors.newFixedThreadPool(2);
            Intrinsics.checkNotNullExpressionValue(executorService2, "newFixedThreadPool(2)");
        }
        this(executorService, executorService2);
    }

    public final ExecutorService getDiskIO() {
        return this.diskIO;
    }

    public final ExecutorService getNetworkIO() {
        return this.networkIO;
    }
}
