package dagger.android.support;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DaggerAppCompatActivity extends AppCompatActivity implements HasAndroidInjector, TraceFieldInterface {
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public DaggerAppCompatActivity() {
    }

    public DaggerAppCompatActivity(int i) {
        super(i);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        TraceMachine.startTracing("DaggerAppCompatActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "DaggerAppCompatActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "DaggerAppCompatActivity#onCreate", null);
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
