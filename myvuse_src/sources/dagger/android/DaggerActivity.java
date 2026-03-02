package dagger.android;

import android.app.Activity;
import android.os.Bundle;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DaggerActivity extends Activity implements HasAndroidInjector, TraceFieldInterface {
    public Trace _nr_trace;

    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        TraceMachine.startTracing("DaggerActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "DaggerActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "DaggerActivity#onCreate", null);
        }
        AndroidInjection.inject(this);
        super.onCreate(bundle);
        TraceMachine.exitMethod();
    }

    @Override // dagger.android.HasAndroidInjector
    public AndroidInjector<Object> androidInjector() {
        return this.androidInjector;
    }
}
