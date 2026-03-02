package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.measurement.zzdn;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdq extends zzdn.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Context zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ zzdn zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzdq(zzdn zzdnVar, String str, String str2, Context context, Bundle bundle) {
        super(zzdnVar);
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = bundle;
        this.zzg = zzdnVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdn.zzb
    public final void zza() {
        String str;
        String str2;
        String str3;
        try {
            if (this.zzg.zzc(this.zzc, this.zzd)) {
                str3 = this.zzd;
                str2 = this.zzc;
                str = this.zzg.zzc;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            Preconditions.checkNotNull(this.zze);
            zzdn zzdnVar = this.zzg;
            zzdnVar.zzj = zzdnVar.zza(this.zze, true);
            if (this.zzg.zzj == null) {
                LogInstrumentation.m2734w(this.zzg.zzc, "Failed to connect to measurement client.");
                return;
            }
            int localVersion = DynamiteModule.getLocalVersion(this.zze, ModuleDescriptor.MODULE_ID);
            ((zzdc) Preconditions.checkNotNull(this.zzg.zzj)).initialize(ObjectWrapper.wrap(this.zze), new zzdl(95001L, Math.max(localVersion, r0), DynamiteModule.getRemoteVersion(this.zze, ModuleDescriptor.MODULE_ID) < localVersion, str, str2, str3, this.zzf, com.google.android.gms.measurement.internal.zzhd.zza(this.zze)), this.zza);
        } catch (Exception e) {
            this.zzg.zza(e, true, false);
        }
    }
}
