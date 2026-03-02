package com.salesforce.marketingcloud;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.PowerManager;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.c */
/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractServiceC4142c extends Service {

    /* JADX INFO: renamed from: h */
    static final String f4605h = C4170g.m3197a("JobIntentService");

    /* JADX INFO: renamed from: i */
    static final Object f4606i = new Object();

    /* JADX INFO: renamed from: j */
    static final HashMap<ComponentName, h> f4607j = new HashMap<>();

    /* JADX INFO: renamed from: a */
    b f4608a;

    /* JADX INFO: renamed from: b */
    h f4609b;

    /* JADX INFO: renamed from: c */
    a f4610c;

    /* JADX INFO: renamed from: d */
    boolean f4611d;

    /* JADX INFO: renamed from: e */
    boolean f4612e;

    /* JADX INFO: renamed from: f */
    boolean f4613f;

    /* JADX INFO: renamed from: g */
    final ArrayList<d> f4614g = null;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.c$a */
    final class a extends AsyncTask<Void, Void, Void> implements TraceFieldInterface {
        public Trace _nr_trace;

        a() {
        }

        @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: renamed from: a */
        protected Void m3045a(Void... voidArr) {
            e eVarM3041a;
            try {
                C4170g.m3202a(AbstractServiceC4142c.f4605h, "Starting to dequeue work...", new Object[0]);
                while (!isCancelled() && (eVarM3041a = AbstractServiceC4142c.this.m3041a()) != null) {
                    String str = AbstractServiceC4142c.f4605h;
                    C4170g.m3202a(str, "Processing next work: %s", eVarM3041a);
                    AbstractServiceC4142c.this.mo2824a(eVarM3041a.mo3055b());
                    C4170g.m3202a(str, "Completing work: %s", eVarM3041a);
                    eVarM3041a.mo3054a();
                }
                C4170g.m3202a(AbstractServiceC4142c.f4605h, "Done processing work!", new Object[0]);
                return null;
            } catch (Exception e) {
                C4170g.m3207b(AbstractServiceC4142c.f4605h, e, "Exception thrown by JobIntentService", new Object[0]);
                return null;
            }
        }

        /* JADX INFO: renamed from: b */
        protected void m3047b(Void r1) {
            AbstractServiceC4142c.this.m3044e();
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] voidArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "c$a#doInBackground", null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod(null, "c$a#doInBackground", null);
            }
            Void voidM3045a = m3045a(voidArr);
            TraceMachine.exitMethod();
            return voidM3045a;
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r4) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "c$a#onPostExecute", null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod(null, "c$a#onPostExecute", null);
            }
            m3047b(r4);
            TraceMachine.exitMethod();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r1) {
            AbstractServiceC4142c.this.m3044e();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.c$b */
    interface b {
        /* JADX INFO: renamed from: a */
        e mo3048a();

        /* JADX INFO: renamed from: b */
        IBinder mo3049b();
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.c$c */
    static final class c extends h {

        /* JADX INFO: renamed from: d */
        private final Context f4616d;

        /* JADX INFO: renamed from: e */
        private final PowerManager.WakeLock f4617e;

        /* JADX INFO: renamed from: f */
        private final PowerManager.WakeLock f4618f;

        /* JADX INFO: renamed from: g */
        boolean f4619g;

        /* JADX INFO: renamed from: h */
        boolean f4620h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f4616d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f4617e = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f4618f = wakeLockNewWakeLock2;
            wakeLockNewWakeLock2.setReferenceCounted(false);
        }

        @Override // com.salesforce.marketingcloud.AbstractServiceC4142c.h
        /* JADX INFO: renamed from: a */
        void mo3051a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f4632a);
            C4170g.m3202a(AbstractServiceC4142c.f4605h, "Starting service for work: %s", intent);
            if (this.f4616d.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.f4619g) {
                        this.f4619g = true;
                        if (!this.f4620h) {
                            this.f4617e.acquire(60000L);
                        }
                    }
                }
            }
        }

        @Override // com.salesforce.marketingcloud.AbstractServiceC4142c.h
        /* JADX INFO: renamed from: b */
        public void mo3052b() {
            synchronized (this) {
                if (!this.f4620h) {
                    this.f4620h = true;
                    this.f4618f.acquire(600000L);
                    this.f4617e.release();
                }
            }
        }

        @Override // com.salesforce.marketingcloud.AbstractServiceC4142c.h
        /* JADX INFO: renamed from: c */
        public void mo3053c() {
            synchronized (this) {
                this.f4619g = false;
            }
        }

        @Override // com.salesforce.marketingcloud.AbstractServiceC4142c.h
        /* JADX INFO: renamed from: a */
        public void mo3050a() {
            synchronized (this) {
                if (this.f4620h) {
                    if (this.f4619g) {
                        this.f4617e.acquire(60000L);
                    }
                    this.f4620h = false;
                    this.f4618f.release();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.c$d */
    final class d implements e {

        /* JADX INFO: renamed from: a */
        final Intent f4621a;

        /* JADX INFO: renamed from: b */
        final int f4622b;

        d(Intent intent, int i) {
            this.f4621a = intent;
            this.f4622b = i;
        }

        @Override // com.salesforce.marketingcloud.AbstractServiceC4142c.e
        /* JADX INFO: renamed from: a */
        public void mo3054a() {
            C4170g.m3202a(AbstractServiceC4142c.f4605h, "Stopping self: #%d", Integer.valueOf(this.f4622b));
            AbstractServiceC4142c.this.stopSelf(this.f4622b);
        }

        @Override // com.salesforce.marketingcloud.AbstractServiceC4142c.e
        /* JADX INFO: renamed from: b */
        public Intent mo3055b() {
            return this.f4621a;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.c$e */
    interface e {
        /* JADX INFO: renamed from: a */
        void mo3054a();

        /* JADX INFO: renamed from: b */
        Intent mo3055b();
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.c$f */
    static final class f extends JobServiceEngine implements b {

        /* JADX INFO: renamed from: d */
        static final String f4624d = C4170g.m3197a("JobServiceEngineImpl");

        /* JADX INFO: renamed from: a */
        final AbstractServiceC4142c f4625a;

        /* JADX INFO: renamed from: b */
        final Object f4626b;

        /* JADX INFO: renamed from: c */
        JobParameters f4627c;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.c$f$a */
        final class a implements e {

            /* JADX INFO: renamed from: a */
            final JobWorkItem f4628a;

            a(JobWorkItem jobWorkItem) {
                this.f4628a = jobWorkItem;
            }

            @Override // com.salesforce.marketingcloud.AbstractServiceC4142c.e
            /* JADX INFO: renamed from: a */
            public void mo3054a() {
                synchronized (f.this.f4626b) {
                    JobParameters jobParameters = f.this.f4627c;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.f4628a);
                    }
                }
            }

            @Override // com.salesforce.marketingcloud.AbstractServiceC4142c.e
            /* JADX INFO: renamed from: b */
            public Intent mo3055b() {
                return this.f4628a.getIntent();
            }
        }

        f(AbstractServiceC4142c abstractServiceC4142c) {
            super(abstractServiceC4142c);
            this.f4626b = new Object();
            this.f4625a = abstractServiceC4142c;
        }

        @Override // com.salesforce.marketingcloud.AbstractServiceC4142c.b
        /* JADX INFO: renamed from: a */
        public e mo3048a() {
            synchronized (this.f4626b) {
                JobParameters jobParameters = this.f4627c;
                if (jobParameters == null) {
                    return null;
                }
                JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                if (jobWorkItemDequeueWork == null) {
                    return null;
                }
                jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f4625a.getClassLoader());
                return new a(jobWorkItemDequeueWork);
            }
        }

        @Override // com.salesforce.marketingcloud.AbstractServiceC4142c.b
        /* JADX INFO: renamed from: b */
        public IBinder mo3049b() {
            return getBinder();
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            C4170g.m3202a(f4624d, "onStartJob: %s", jobParameters);
            this.f4627c = jobParameters;
            this.f4625a.m3042a(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            C4170g.m3202a(f4624d, "onStartJob: %s", jobParameters);
            boolean zM3043b = this.f4625a.m3043b();
            synchronized (this.f4626b) {
                this.f4627c = null;
            }
            return zM3043b;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.c$g */
    static final class g extends h {

        /* JADX INFO: renamed from: d */
        private final JobInfo f4630d;

        /* JADX INFO: renamed from: e */
        private final JobScheduler f4631e;

        g(Context context, ComponentName componentName, int i) {
            super(componentName);
            m3056a(i);
            this.f4630d = new JobInfo.Builder(i, this.f4632a).setOverrideDeadline(0L).build();
            this.f4631e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // com.salesforce.marketingcloud.AbstractServiceC4142c.h
        /* JADX INFO: renamed from: a */
        void mo3051a(Intent intent) {
            C4170g.m3202a(AbstractServiceC4142c.f4605h, "Enqueueing work: %s", intent);
            try {
                this.f4631e.enqueue(this.f4630d, new JobWorkItem(intent));
            } catch (Exception e) {
                C4170g.m3207b(AbstractServiceC4142c.f4605h, e, "Unable to enqueue %s for work %s", Integer.valueOf(this.f4634c), intent);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.c$h */
    static abstract class h {

        /* JADX INFO: renamed from: a */
        final ComponentName f4632a;

        /* JADX INFO: renamed from: b */
        boolean f4633b;

        /* JADX INFO: renamed from: c */
        int f4634c;

        h(ComponentName componentName) {
            this.f4632a = componentName;
        }

        /* JADX INFO: renamed from: a */
        public void mo3050a() {
        }

        /* JADX INFO: renamed from: a */
        void m3056a(int i) {
            if (this.f4633b) {
                if (this.f4634c != i) {
                    throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.f4634c);
                }
            } else {
                this.f4633b = true;
                this.f4634c = i;
            }
        }

        /* JADX INFO: renamed from: a */
        abstract void mo3051a(Intent intent);

        /* JADX INFO: renamed from: b */
        public void mo3052b() {
        }

        /* JADX INFO: renamed from: c */
        public void mo3053c() {
        }
    }

    /* JADX INFO: renamed from: a */
    e m3041a() {
        b bVar = this.f4608a;
        if (bVar != null) {
            return bVar.mo3048a();
        }
        synchronized (this.f4614g) {
            if (this.f4614g.size() <= 0) {
                return null;
            }
            return this.f4614g.remove(0);
        }
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo2824a(Intent intent);

    /* JADX INFO: renamed from: b */
    boolean m3043b() {
        a aVar = this.f4610c;
        if (aVar != null) {
            aVar.cancel(this.f4611d);
        }
        this.f4612e = true;
        return mo2827d();
    }

    /* JADX INFO: renamed from: c */
    public boolean mo2826c() {
        return this.f4612e;
    }

    /* JADX INFO: renamed from: d */
    public boolean mo2827d() {
        return true;
    }

    /* JADX INFO: renamed from: e */
    void m3044e() {
        ArrayList<d> arrayList = this.f4614g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f4610c = null;
                ArrayList<d> arrayList2 = this.f4614g;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    m3042a(false);
                } else if (!this.f4613f) {
                    this.f4609b.mo3050a();
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.f4608a;
        if (bVar == null) {
            return null;
        }
        IBinder iBinderMo3049b = bVar.mo3049b();
        C4170g.m3202a(f4605h, "Returning engine: %s", iBinderMo3049b);
        return iBinderMo3049b;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C4170g.m3202a(f4605h, "CREATING: %s", this);
        this.f4608a = new f(this);
        this.f4609b = null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        ArrayList<d> arrayList = this.f4614g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f4613f = true;
                this.f4609b.mo3050a();
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.f4614g == null) {
            C4170g.m3202a(f4605h, "Ignoring start command: %s", intent);
            return 2;
        }
        this.f4609b.mo3053c();
        C4170g.m3202a(f4605h, "Received compat start command #%d: %s", Integer.valueOf(i2), intent);
        synchronized (this.f4614g) {
            ArrayList<d> arrayList = this.f4614g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i2));
            m3042a(true);
        }
        return 3;
    }

    /* JADX INFO: renamed from: a */
    public static void m3039a(Context context, ComponentName componentName, int i, Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (f4606i) {
            h hVarM3038a = m3038a(context, componentName, true, i);
            hVarM3038a.m3056a(i);
            hVarM3038a.mo3051a(intent);
        }
    }

    /* JADX INFO: renamed from: b */
    public void mo2825b(boolean z) {
        this.f4611d = z;
    }

    /* JADX INFO: renamed from: a */
    public static void m3040a(Context context, Class cls, int i, Intent intent) {
        m3039a(context, new ComponentName(context, (Class<?>) cls), i, intent);
    }

    /* JADX INFO: renamed from: a */
    void m3042a(boolean z) {
        if (this.f4610c == null) {
            this.f4610c = new a();
            h hVar = this.f4609b;
            if (hVar != null && z) {
                hVar.mo3052b();
            }
            C4170g.m3202a(f4605h, "Starting processor: %s", this.f4610c);
            a aVar = this.f4610c;
            Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
            Void[] voidArr = new Void[0];
            if (aVar instanceof AsyncTask) {
                AsyncTaskInstrumentation.executeOnExecutor(aVar, executor, voidArr);
            } else {
                aVar.executeOnExecutor(executor, voidArr);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static h m3038a(Context context, ComponentName componentName, boolean z, int i) {
        HashMap<ComponentName, h> map = f4607j;
        h hVar = map.get(componentName);
        if (hVar != null) {
            return hVar;
        }
        if (!z) {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        g gVar = new g(context, componentName, i);
        map.put(componentName, gVar);
        return gVar;
    }
}
