package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zza extends AsyncTask implements TraceFieldInterface {
    public Trace _nr_trace;
    final /* synthetic */ Context zza;
    final /* synthetic */ ProviderInstaller.ProviderInstallListener zzb;

    zza(Context context, ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.zza = context;
        this.zzb = providerInstallListener;
    }

    @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        int iValueOf;
        try {
            TraceMachine.enterMethod(this._nr_trace, "zza#doInBackground", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "zza#doInBackground", null);
        }
        try {
            ProviderInstaller.installIfNeeded(this.zza);
            iValueOf = 0;
        } catch (GooglePlayServicesNotAvailableException e) {
            iValueOf = Integer.valueOf(e.errorCode);
        } catch (GooglePlayServicesRepairableException e2) {
            iValueOf = Integer.valueOf(e2.getConnectionStatusCode());
        }
        TraceMachine.exitMethod();
        return iValueOf;
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "zza#onPostExecute", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "zza#onPostExecute", null);
        }
        Integer num = (Integer) obj;
        if (num.intValue() == 0) {
            this.zzb.onProviderInstalled();
            TraceMachine.exitMethod();
        } else {
            this.zzb.onProviderInstallFailed(num.intValue(), ProviderInstaller.zza.getErrorResolutionIntent(this.zza, num.intValue(), ContextChain.TAG_PRODUCT_AND_INFRA));
            TraceMachine.exitMethod();
        }
    }
}
