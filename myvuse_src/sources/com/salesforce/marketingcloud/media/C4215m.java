package com.salesforce.marketingcloud.media;

import android.os.Process;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.m */
/* JADX INFO: loaded from: classes6.dex */
public class C4215m extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a */
    private static final int f5059a = 2;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.m$a */
    class a implements ThreadFactory {

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.m$a$a, reason: collision with other inner class name */
        class C5997a extends Thread {
            C5997a(Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C5997a(runnable);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.m$b */
    private static class b extends FutureTask<RunnableC4207e> implements Comparable<Runnable> {
        b(RunnableC4207e runnableC4207e) {
            super(runnableC4207e, null);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Runnable runnable) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.m$c */
    private static class c extends FutureTask<RunnableC4216n> implements Comparable<Runnable> {

        /* JADX INFO: renamed from: a */
        private final RunnableC4216n f5061a;

        c(RunnableC4216n runnableC4216n) {
            super(runnableC4216n, null);
            this.f5061a = runnableC4216n;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Runnable runnable) {
            if (runnable instanceof c) {
                return ((c) runnable).f5061a.f5077l.ordinal() - this.f5061a.f5077l.ordinal();
            }
            return 0;
        }
    }

    C4215m() {
        super(2, 2, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a());
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        RunnableFuture cVar = runnable instanceof RunnableC4216n ? new c((RunnableC4216n) runnable) : new b((RunnableC4207e) runnable);
        execute(cVar);
        return cVar;
    }
}
