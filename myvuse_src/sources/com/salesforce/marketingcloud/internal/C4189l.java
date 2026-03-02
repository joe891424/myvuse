package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.C4170g;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.l */
/* JADX INFO: loaded from: classes6.dex */
public class C4189l {

    /* JADX INFO: renamed from: c */
    private static final String f4908c = "~!SdkExecutors";

    /* JADX INFO: renamed from: a */
    private final ExecutorService f4909a;

    /* JADX INFO: renamed from: b */
    private final ExecutorService f4910b;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.l$a */
    class a implements RejectedExecutionHandler {
        a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            C4170g.m3216e(C4189l.f4908c, "Fixed Thread Pool Task %s rejected.", runnable.toString());
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.l$b */
    class b implements RejectedExecutionHandler {
        b() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            C4170g.m3216e(C4189l.f4908c, "Cached Thread Pool Task %s rejected.", runnable.toString());
        }
    }

    public C4189l() {
        this(Executors.newFixedThreadPool(1), Executors.newCachedThreadPool());
    }

    /* JADX INFO: renamed from: a */
    public ExecutorService m3398a() {
        return this.f4910b;
    }

    /* JADX INFO: renamed from: b */
    public ExecutorService m3399b() {
        return this.f4909a;
    }

    /* JADX INFO: renamed from: c */
    public void m3400c() {
        List<Runnable> listShutdownNow;
        List<Runnable> listShutdownNow2;
        if (!this.f4909a.isShutdown()) {
            this.f4909a.shutdown();
        }
        if (!this.f4910b.isShutdown()) {
            this.f4910b.shutdown();
        }
        try {
            ExecutorService executorService = this.f4909a;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!executorService.awaitTermination(5L, timeUnit) && (listShutdownNow2 = this.f4909a.shutdownNow()) != null && !listShutdownNow2.isEmpty()) {
                C4170g.m3206b(f4908c, "Shutdown DiskIO executor with %d tasks pending", Integer.valueOf(listShutdownNow2.size()));
            }
            if (this.f4910b.awaitTermination(5L, timeUnit) || (listShutdownNow = this.f4910b.shutdownNow()) == null || listShutdownNow.isEmpty()) {
                return;
            }
            C4170g.m3206b(f4908c, "Shutdown CachedExecutor executor with %d tasks pending", Integer.valueOf(listShutdownNow.size()));
        } catch (InterruptedException e) {
            C4170g.m3207b(f4908c, e, "Unable to complete executors", new Object[0]);
        }
    }

    public C4189l(ExecutorService executorService, ExecutorService executorService2) {
        if (executorService instanceof ThreadPoolExecutor) {
            ((ThreadPoolExecutor) executorService).setRejectedExecutionHandler(new a());
        }
        this.f4909a = executorService;
        if (executorService2 instanceof ThreadPoolExecutor) {
            ((ThreadPoolExecutor) executorService2).setRejectedExecutionHandler(new b());
        }
        this.f4910b = executorService2;
    }
}
