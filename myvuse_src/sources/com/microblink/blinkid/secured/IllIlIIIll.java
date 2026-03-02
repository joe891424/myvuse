package com.microblink.blinkid.secured;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.Iterator;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IllIlIIIll extends AsyncTask<Void, Void, Boolean> implements TraceFieldInterface {
    protected Exception IlIllIlIIl;
    protected lIlIIlllII IllIIIIllI;
    protected IIIIIIllIl IllIIIllII;
    public Trace _nr_trace;
    protected llIllIlIII llIIIlllll;
    protected IIIlIIIIlI llIIlIlIIl;

    public IllIlIIIll(llIllIlIll llillilill, IIIIIIllIl iIIIIIllIl, IIIlIIIIlI iIIlIIIIlI, llIllIlIII llilliliii) {
        this.IllIIIllII = iIIIIIllIl;
        this.llIIlIlIIl = iIIlIIIIlI;
        this.llIIIlllll = llilliliii;
        this.IllIIIIllI = new lIlIIlllII(llilliliii, llillilill);
    }

    @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(Void[] voidArr) {
        Boolean bool;
        try {
            TraceMachine.enterMethod(this._nr_trace, "IllIlIIIll#doInBackground", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "IllIlIIIll#doInBackground", null);
        }
        if (this.llIIIlllll.IllIIIllII() != null && !this.llIIIlllll.IllIIIllII().isEmpty()) {
            Iterator<lllIIIlIlI> it2 = this.llIIIlllll.IllIIIllII().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    bool = Boolean.TRUE;
                    break;
                }
                if (!llIIlIlIIl(it2.next())) {
                    bool = Boolean.FALSE;
                    break;
                }
            }
        } else {
            bool = Boolean.FALSE;
        }
        TraceMachine.exitMethod();
        return bool;
    }

    abstract boolean llIIlIlIIl(lllIIIlIlI llliiilili);

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        IIIlIIIIlI iIIlIIIIlI = this.llIIlIlIIl;
        if (iIIlIIIIlI != null) {
            iIIlIIIIlI.llIIlIlIIl(this.IlIllIlIIl);
        }
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "IllIlIIIll#onPostExecute", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "IllIlIIIll#onPostExecute", null);
        }
        Boolean bool2 = bool;
        IIIlIIIIlI iIIlIIIIlI = this.llIIlIlIIl;
        if (iIIlIIIIlI != null) {
            iIIlIIIIlI.llIIlIlIIl(bool2);
        }
        TraceMachine.exitMethod();
    }
}
