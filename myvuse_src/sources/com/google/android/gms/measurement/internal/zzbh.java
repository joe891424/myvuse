package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.work.WorkRequest;
import com.google.android.gms.internal.measurement.zzny;
import com.google.android.gms.internal.measurement.zznz;
import com.google.android.gms.internal.measurement.zzoe;
import com.google.android.gms.internal.measurement.zzof;
import com.google.android.gms.internal.measurement.zzok;
import com.google.android.gms.internal.measurement.zzol;
import com.google.android.gms.internal.measurement.zzoq;
import com.google.android.gms.internal.measurement.zzor;
import com.google.android.gms.internal.measurement.zzow;
import com.google.android.gms.internal.measurement.zzox;
import com.google.android.gms.internal.measurement.zzpc;
import com.google.android.gms.internal.measurement.zzpd;
import com.google.android.gms.internal.measurement.zzpi;
import com.google.android.gms.internal.measurement.zzpj;
import com.google.android.gms.internal.measurement.zzpo;
import com.google.android.gms.internal.measurement.zzpp;
import com.google.android.gms.internal.measurement.zzpu;
import com.google.android.gms.internal.measurement.zzpv;
import com.heanoria.library.reactnative.locationenabler.AndroidLocationEnablerModule;
import com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbh {
    public static final zzfn<Long> zza;
    public static final zzfn<Long> zzaa;
    public static final zzfn<Long> zzab;
    public static final zzfn<Integer> zzac;
    public static final zzfn<Long> zzad;
    public static final zzfn<Integer> zzae;
    public static final zzfn<Integer> zzaf;
    public static final zzfn<Integer> zzag;
    public static final zzfn<Integer> zzah;
    public static final zzfn<Integer> zzai;
    public static final zzfn<Long> zzaj;
    public static final zzfn<Boolean> zzak;
    public static final zzfn<String> zzal;
    public static final zzfn<Long> zzam;
    public static final zzfn<Integer> zzan;
    public static final zzfn<Double> zzao;
    public static final zzfn<Integer> zzap;
    public static final zzfn<Integer> zzaq;
    public static final zzfn<Integer> zzar;
    public static final zzfn<Integer> zzas;
    public static final zzfn<Long> zzat;
    public static final zzfn<Long> zzau;
    public static final zzfn<Integer> zzav;
    public static final zzfn<Integer> zzaw;
    public static final zzfn<String> zzax;
    public static final zzfn<String> zzay;
    public static final zzfn<String> zzaz;
    public static final zzfn<Long> zzb;
    public static final zzfn<Long> zzba;
    public static final zzfn<String> zzbb;
    public static final zzfn<String> zzbc;
    public static final zzfn<String> zzbd;
    public static final zzfn<String> zzbe;
    public static final zzfn<Boolean> zzbf;
    public static final zzfn<Boolean> zzbg;
    public static final zzfn<Boolean> zzbh;
    public static final zzfn<Boolean> zzbi;
    public static final zzfn<Boolean> zzbj;
    public static final zzfn<Boolean> zzbk;
    public static final zzfn<Boolean> zzbl;
    public static final zzfn<Boolean> zzbm;
    public static final zzfn<Boolean> zzbn;
    public static final zzfn<Boolean> zzbo;
    public static final zzfn<Integer> zzbp;
    public static final zzfn<Boolean> zzbq;
    public static final zzfn<Boolean> zzbr;
    public static final zzfn<Boolean> zzbs;
    public static final zzfn<Boolean> zzbt;
    public static final zzfn<Boolean> zzbu;
    public static final zzfn<Boolean> zzbv;
    public static final zzfn<String> zzbw;
    public static final zzfn<Boolean> zzbx;
    public static final zzfn<Boolean> zzby;
    public static final zzfn<Boolean> zzbz;
    public static final zzfn<Long> zzc;
    public static final zzfn<Boolean> zzca;
    public static final zzfn<Boolean> zzcb;
    public static final zzfn<Boolean> zzcc;
    public static final zzfn<Boolean> zzcd;
    public static final zzfn<Boolean> zzce;
    public static final zzfn<Boolean> zzcf;
    public static final zzfn<Boolean> zzcg;
    public static final zzfn<Boolean> zzch;
    public static final zzfn<Boolean> zzci;
    public static final zzfn<Boolean> zzcj;
    public static final zzfn<Boolean> zzck;
    public static final zzfn<Boolean> zzcl;
    public static final zzfn<Boolean> zzcm;
    public static final zzfn<Boolean> zzcn;
    public static final zzfn<Boolean> zzco;
    public static final zzfn<Boolean> zzcp;
    public static final zzfn<Boolean> zzcq;
    public static final zzfn<Boolean> zzcr;
    public static zzfn<Boolean> zzcs;
    public static final zzfn<Boolean> zzct;
    public static final zzfn<Boolean> zzcu;
    public static final zzfn<Boolean> zzcv;
    public static final zzfn<Boolean> zzcw;
    public static final zzfn<Boolean> zzcx;
    public static final zzfn<Boolean> zzcy;
    public static final zzfn<Boolean> zzcz;
    public static final zzfn<Long> zzd;
    public static final zzfn<Boolean> zzda;
    public static final zzfn<Boolean> zzdb;
    public static final zzfn<Boolean> zzdc;
    public static final zzfn<Boolean> zzdd;
    public static final zzfn<Boolean> zzde;
    private static final List<zzfn<?>> zzdf = Collections.synchronizedList(new ArrayList());
    public static final zzfn<String> zze;
    public static final zzfn<String> zzf;
    public static final zzfn<Integer> zzg;
    public static final zzfn<Integer> zzh;
    public static final zzfn<Integer> zzi;
    public static final zzfn<Integer> zzj;
    public static final zzfn<Integer> zzk;
    public static final zzfn<Integer> zzl;
    public static final zzfn<Integer> zzm;
    public static final zzfn<Integer> zzn;
    public static final zzfn<Integer> zzo;
    public static final zzfn<Integer> zzp;
    public static final zzfn<String> zzq;
    public static final zzfn<Long> zzr;
    public static final zzfn<Long> zzs;
    public static final zzfn<Long> zzt;
    public static final zzfn<Long> zzu;
    public static final zzfn<Long> zzv;
    public static final zzfn<Long> zzw;
    public static final zzfn<Long> zzx;
    public static final zzfn<Long> zzy;
    public static final zzfn<Long> zzz;

    private static <V> zzfn<V> zza(String str, V v, V v2, zzfl<V> zzflVar) {
        zzfn<V> zzfnVar = new zzfn<>(str, v, v2, zzflVar);
        zzdf.add(zzfnVar);
        return zzfnVar;
    }

    static /* synthetic */ Long zzci() {
        zzad zzadVar = zzfk.zza;
        return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzd());
    }

    public static Map<String, String> zza(Context context) {
        com.google.android.gms.internal.measurement.zzgh zzghVarZza = com.google.android.gms.internal.measurement.zzgh.zza(context.getContentResolver(), com.google.android.gms.internal.measurement.zzgx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbg
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.gms.internal.measurement.zzgw.zzc();
            }
        });
        return zzghVarZza == null ? Collections.emptyMap() : zzghVarZza.zza();
    }

    static {
        Collections.synchronizedSet(new HashSet());
        Long lValueOf = Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS);
        zza = zza("measurement.ad_id_cache_time", lValueOf, lValueOf, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbj
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zza());
            }
        });
        zzb = zza("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L, 3600000L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbz
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzb());
            }
        });
        Long lValueOf2 = Long.valueOf(NetworkManager.MAX_SERVER_RETRY);
        zzc = zza("measurement.monitoring.sample_period_millis", lValueOf2, lValueOf2, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcl
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzq());
            }
        });
        zzd = zza("measurement.config.cache_time", lValueOf2, 3600000L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcw
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return zzbh.zzci();
            }
        });
        zze = zza("measurement.config.url_scheme", "https", "https", new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdi
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return com.google.android.gms.internal.measurement.zzna.zzao();
            }
        });
        zzf = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdu
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return com.google.android.gms.internal.measurement.zzna.zzan();
            }
        });
        zzg = zza("measurement.upload.max_bundles", 100, 100, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzeg
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzab());
            }
        });
        zzh = zza("measurement.upload.max_batch_size", 65536, 65536, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzes
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzaj());
            }
        });
        zzi = zza("measurement.upload.max_bundle_size", 65536, 65536, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzfe
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzaa());
            }
        });
        zzj = zza("measurement.upload.max_events_per_bundle", 1000, 1000, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbr
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzae());
            }
        });
        zzk = zza("measurement.upload.max_events_per_day", 100000, 100000, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzep
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzaf());
            }
        });
        zzl = zza("measurement.upload.max_error_events_per_day", 1000, 1000, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzey
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzad());
            }
        });
        zzm = zza("measurement.upload.max_public_events_per_day", 50000, 50000, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbi
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzag());
            }
        });
        Integer numValueOf = Integer.valueOf(AndroidLocationEnablerModule.DEFAULT_INTERVAL_DURATION);
        zzn = zza("measurement.upload.max_conversions_per_day", numValueOf, numValueOf, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbq
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzac());
            }
        });
        zzo = zza("measurement.upload.max_realtime_events_per_day", 10, 10, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbt
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzai());
            }
        });
        zzp = zza("measurement.store.max_stored_events_per_app", 100000, 100000, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbs
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzj());
            }
        });
        zzq = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbv
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return com.google.android.gms.internal.measurement.zzna.zzaw();
            }
        });
        zzr = zza("measurement.upload.backoff_period", 43200000L, 43200000L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbu
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzx());
            }
        });
        zzs = zza("measurement.upload.window_interval", 3600000L, 3600000L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbx
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzam());
            }
        });
        zzt = zza("measurement.upload.interval", 3600000L, 3600000L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbw
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzz());
            }
        });
        zzu = zza("measurement.upload.realtime_upload_interval", lValueOf, lValueOf, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzby
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzr());
            }
        });
        zzv = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzca
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zze());
            }
        });
        zzw = zza("measurement.upload.minimum_delay", 500L, 500L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcd
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzp());
            }
        });
        zzx = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcc
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzo());
            }
        });
        zzy = zza("measurement.upload.stale_data_deletion_interval", lValueOf2, lValueOf2, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcf
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzu());
            }
        });
        zzz = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzce
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzs());
            }
        });
        zzaa = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzch
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzy());
            }
        });
        zzab = zza("measurement.upload.retry_time", 1800000L, 1800000L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcg
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzal());
            }
        });
        zzac = zza("measurement.upload.retry_count", 6, 6, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcj
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzak());
            }
        });
        zzad = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzci
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzah());
            }
        });
        zzae = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcn
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzg());
            }
        });
        zzaf = zza("measurement.audience.filter_result_max_count", 200, 200, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcm
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzl());
            }
        });
        zzag = zza("measurement.upload.max_public_user_properties", 25, 25, null);
        zzah = zza("measurement.upload.max_event_name_cardinality", 500, 500, null);
        zzai = zza("measurement.upload.max_public_event_params", 25, 25, null);
        zzaj = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcp
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzt());
            }
        });
        zzak = zza("measurement.test.boolean_flag", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzco
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzox.zze());
            }
        });
        zzal = zza("measurement.test.string_flag", "---", "---", new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcr
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return zzox.zzd();
            }
        });
        zzam = zza("measurement.test.long_flag", -1L, -1L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcq
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(zzox.zzc());
            }
        });
        zzan = zza("measurement.test.int_flag", -2, -2, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzct
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) zzox.zzb());
            }
        });
        Double dValueOf = Double.valueOf(-3.0d);
        zzao = zza("measurement.test.double_flag", dValueOf, dValueOf, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcs
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Double.valueOf(zzox.zza());
            }
        });
        zzap = zza("measurement.experiment.max_ids", 50, 50, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcv
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzk());
            }
        });
        zzaq = zza("measurement.upload.max_item_scoped_custom_parameters", 27, 27, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcu
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzm());
            }
        });
        zzar = zza("measurement.upload.max_event_parameter_value_length", 100, 100, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcz
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzi());
            }
        });
        zzas = zza("measurement.max_bundles_per_iteration", 100, 100, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcy
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzc());
            }
        });
        zzat = zza("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdb
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzv());
            }
        });
        zzau = zza("measurement.redaction.app_instance_id.ttl", 7200000L, 7200000L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzda
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzw());
            }
        });
        zzav = zza("measurement.rb.attribution.client.min_ad_services_version", 7, 7, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdd
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzn());
            }
        });
        zzaw = zza("measurement.dma_consent.max_daily_dcu_realtime_events", 1, 1, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdc
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzna.zzh());
            }
        });
        zzax = zza("measurement.rb.attribution.uri_scheme", "https", "https", new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdf
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return com.google.android.gms.internal.measurement.zzna.zzav();
            }
        });
        zzay = zza("measurement.rb.attribution.uri_authority", "google-analytics.com", "google-analytics.com", new zzfl() { // from class: com.google.android.gms.measurement.internal.zzde
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return com.google.android.gms.internal.measurement.zzna.zzas();
            }
        });
        zzaz = zza("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion", "privacy-sandbox/register-app-conversion", new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdh
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return com.google.android.gms.internal.measurement.zzna.zzat();
            }
        });
        zzba = zza("measurement.session.engagement_interval", 3600000L, 3600000L, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdj
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Long.valueOf(com.google.android.gms.internal.measurement.zzna.zzf());
            }
        });
        zzbb = zza("measurement.rb.attribution.app_allowlist", "com.labpixies.flood,com.sofascore.results,games.spearmint.triplecrush,com.block.juggle,io.supercent.linkedcubic,com.cdtg.gunsound,com.corestudios.storemanagementidle,com.cdgames.fidget3d,io.supercent.burgeridle,io.supercent.pizzaidle,jp.ne.ibis.ibispaintx.app,com.dencreak.dlcalculator,com.ebay.kleinanzeigen,de.wetteronline.wetterapp,com.game.shape.shift,com.champion.cubes,bubbleshooter.orig,com.wolt.android,com.master.hotelmaster,com.games.bus.arrival,com.playstrom.dop2,com.huuuge.casino.slots,com.ig.spider.fighting,com.jura.coloring.page,com.rikkogame.ragdoll2,com.ludo.king,com.sigma.prank.sound.haircut,com.crazy.block.robo.monster.cliffs.craft,com.fugo.wow,com.maps.locator.gps.gpstracker.phone,com.gamovation.tileclub,com.pronetis.ironball2,com.meesho.supply,pdf.pdfreader.viewer.editor.free,com.dino.race.master,com.ig.moto.racing,ai.photo.enhancer.photoclear,com.duolingo,com.candle.magic_piano,com.free.vpn.super.hotspot.open,sg.bigo.live,com.cdg.tictactoe,com.zhiliaoapp.musically.go,com.wildspike.wormszone,com.mast.status.video.edit,com.vyroai.photoeditorone,com.pujiagames.deeeersimulator,com.superbinogo.jungleboyadventure,com.trustedapp.pdfreaderpdfviewer,com.artimind.aiart.artgenerator.artavatar,de.cellular.ottohybrid,com.zeptolab.cats.google,in.crossy.daily_crossword", "com.labpixies.flood,com.sofascore.results,games.spearmint.triplecrush,com.block.juggle,io.supercent.linkedcubic,com.cdtg.gunsound,com.corestudios.storemanagementidle,com.cdgames.fidget3d,io.supercent.burgeridle,io.supercent.pizzaidle,jp.ne.ibis.ibispaintx.app,com.dencreak.dlcalculator,com.ebay.kleinanzeigen,de.wetteronline.wetterapp,com.game.shape.shift,com.champion.cubes,bubbleshooter.orig,com.wolt.android,com.master.hotelmaster,com.games.bus.arrival,com.playstrom.dop2,com.huuuge.casino.slots,com.ig.spider.fighting,com.jura.coloring.page,com.rikkogame.ragdoll2,com.ludo.king,com.sigma.prank.sound.haircut,com.crazy.block.robo.monster.cliffs.craft,com.fugo.wow,com.maps.locator.gps.gpstracker.phone,com.gamovation.tileclub,com.pronetis.ironball2,com.meesho.supply,pdf.pdfreader.viewer.editor.free,com.dino.race.master,com.ig.moto.racing,ai.photo.enhancer.photoclear,com.duolingo,com.candle.magic_piano,com.free.vpn.super.hotspot.open,sg.bigo.live,com.cdg.tictactoe,com.zhiliaoapp.musically.go,com.wildspike.wormszone,com.mast.status.video.edit,com.vyroai.photoeditorone,com.pujiagames.deeeersimulator,com.superbinogo.jungleboyadventure,com.trustedapp.pdfreaderpdfviewer,com.artimind.aiart.artgenerator.artavatar,de.cellular.ottohybrid,com.zeptolab.cats.google,in.crossy.daily_crossword", new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdl
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return com.google.android.gms.internal.measurement.zzna.zzaq();
            }
        });
        zzbc = zza("measurement.rb.attribution.user_properties", "_npa,npa", "_npa,npa", new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdk
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return com.google.android.gms.internal.measurement.zzna.zzax();
            }
        });
        zzbd = zza("measurement.rb.attribution.event_params", "value|currency", "value|currency", new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdn
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return com.google.android.gms.internal.measurement.zzna.zzap();
            }
        });
        zzbe = zza("measurement.rb.attribution.query_parameters_to_remove", "", "", new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdm
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return com.google.android.gms.internal.measurement.zzna.zzau();
            }
        });
        zzbf = zza("measurement.collection.log_event_and_bundle_v2", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdp
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpc.zza());
            }
        });
        zzbg = zza("measurement.quality.checksum", false, false, null);
        zzbh = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdo
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zznz.zzc());
            }
        });
        zzbi = zza("measurement.audience.refresh_event_count_filters_timestamp", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdr
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zznz.zzb());
            }
        });
        zzbj = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdq
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zznz.zzd());
            }
        });
        zzbk = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzds
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzow.zzb());
            }
        });
        zzbl = zza("measurement.sdk.collection.deep_link_gclid.client.dev", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdv
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzow.zza());
            }
        });
        zzbm = zza("measurement.sdk.collection.market_referrer_gclid.service", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdx
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzow.zzc());
            }
        });
        zzbn = zza("measurement.integration.disable_firebase_instance_id", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdw
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpu.zzb());
            }
        });
        zzbo = zza("measurement.collection.service.update_with_analytics_fix", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdz
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpv.zza());
            }
        });
        zzbp = zza("measurement.service.storage_consent_support_version", 203600, 203600, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdy
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Integer.valueOf((int) com.google.android.gms.internal.measurement.zzng.zza());
            }
        });
        zzbq = zza("measurement.service.store_null_safelist", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzeb
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zznt.zzb());
            }
        });
        zzbr = zza("measurement.service.store_safelist", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzea
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zznt.zzc());
            }
        });
        zzbs = zza("measurement.collection.enable_session_stitching_token.first_open_fix", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzed
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpi.zzb());
            }
        });
        zzbt = zza("measurement.session_stitching_token_enabled", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzef
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpi.zzc());
            }
        });
        zzbu = zza("measurement.sgtm.service", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzee
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpo.zzc());
            }
        });
        zzbv = zza("measurement.sgtm.preview_mode_enabled", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzeh
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpo.zzb());
            }
        });
        zzbw = zza("measurement.sgtm.app_allowlist", "de.zalando.mobile.internal,de.zalando.mobile.internal.debug,de.zalando.lounge.dev,grit.storytel.app,com.rbc.mobile.android,com.rbc.mobile.android,com.dylvian.mango.activities,com.home24.android,com.home24.android.staging,se.lf.mobile.android,se.lf.mobile.android.beta,se.lf.mobile.android.rc,se.lf.mobile.android.test,se.lf.mobile.android.test.debug,com.boots.flagship.android,com.boots.flagshiproi.android,de.zalando.mobile,com.trivago,com.getyourguide.android,es.mobail.meliarewards,se.nansen.coop.debug,se.nansen.coop,se.coop.coop.qa", "de.zalando.mobile.internal,de.zalando.mobile.internal.debug,de.zalando.lounge.dev,grit.storytel.app,com.rbc.mobile.android,com.rbc.mobile.android,com.dylvian.mango.activities,com.home24.android,com.home24.android.staging,se.lf.mobile.android,se.lf.mobile.android.beta,se.lf.mobile.android.rc,se.lf.mobile.android.test,se.lf.mobile.android.test.debug,com.boots.flagship.android,com.boots.flagshiproi.android,de.zalando.mobile,com.trivago,com.getyourguide.android,es.mobail.meliarewards,se.nansen.coop.debug,se.nansen.coop,se.coop.coop.qa", new zzfl() { // from class: com.google.android.gms.measurement.internal.zzej
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return com.google.android.gms.internal.measurement.zzna.zzar();
            }
        });
        zzbx = zza("measurement.gmscore_feature_tracking", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzei
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzol.zzb());
            }
        });
        zzby = zza("measurement.fix_health_monitor_stack_trace", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzel
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzof.zzb());
            }
        });
        zzbz = zza("measurement.item_scoped_custom_parameters.client", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzek
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzor.zzb());
            }
        });
        zzca = zza("measurement.item_scoped_custom_parameters.service", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzen
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzor.zzc());
            }
        });
        zzcb = zza("measurement.rb.attribution.service", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzem
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpd.zze());
            }
        });
        zzcc = zza("measurement.rb.attribution.client2", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzeo
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpd.zzb());
            }
        });
        zzcd = zza("measurement.rb.attribution.uuid_generation", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzer
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpd.zzg());
            }
        });
        zzce = zza("measurement.rb.attribution.enable_trigger_redaction", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzeq
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpd.zzf());
            }
        });
        zza("measurement.rb.attribution.followup1.service", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzet
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpd.zzc());
            }
        });
        zzcf = zza("measurement.rb.attribution.registration_regardless_consent", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzev
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpd.zzd());
            }
        });
        zzcg = zza("measurement.rb.attribution.improved_retry", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzeu
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpd.zzh());
            }
        });
        zzch = zza("measurement.client.sessions.enable_fix_background_engagement", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzex
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpj.zza());
            }
        });
        zzci = zza("measurement.client.sessions.enable_pause_engagement_in_background", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzew
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpj.zzb());
            }
        });
        zzcj = zza("measurement.dma_consent.service_dcu_event2", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzez
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzns.zzc());
            }
        });
        zzck = zza("measurement.dma_consent.services_database_update_fix", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzfb
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzns.zzb());
            }
        });
        zzcl = zza("measurement.dma_consent.separate_service_calls_fix", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzfa
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzns.zza());
            }
        });
        zzcm = zza("measurement.dma_consent.set_consent_inline_on_worker", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzfd
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzns.zzd());
            }
        });
        zzcn = zza("measurement.service.deferred_first_open", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzfc
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zznm.zzb());
            }
        });
        zzco = zza("measurement.gbraid_campaign.gbraid.client.dev", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzff
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzok.zzc());
            }
        });
        zzcp = zza("measurement.gbraid_campaign.gbraid.service", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzfh
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzok.zzd());
            }
        });
        zzcq = zza("measurement.gbraid_campaign.deep_link_gbraid.client.dev", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzfg
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzok.zzb());
            }
        });
        zzcr = zza("measurement.gbraid_campaign.market_referrer_gbraid.service", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzfj
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzok.zze());
            }
        });
        zzcs = zza("measurement.increase_param_lengths", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzfi
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzoq.zzb());
            }
        });
        zzct = zza("measurement.disable_npa_for_dasher_and_unicorn", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbl
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zznn.zzb());
            }
        });
        zzcu = zza("measurement.tcf.client", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbk
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpp.zzb());
            }
        });
        zzcv = zza("measurement.tcf.service", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbn
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzpp.zzc());
            }
        });
        zzcw = zza("measurement.consent_regional_defaults.service", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbm
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zznb.zzc());
            }
        });
        zzcx = zza("measurement.consent_regional_defaults.client", false, false, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbp
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zznb.zzb());
            }
        });
        zzcy = zza("measurement.service.consent.pfo_on_fx", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzbo
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzny.zzc());
            }
        });
        zzcz = zza("measurement.service.consent.params_on_fx", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcb
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzny.zzb());
            }
        });
        zzda = zza("measurement.service.consent.app_start_fix", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzck
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzny.zza());
            }
        });
        zzdb = zza("measurement.consent.stop_reset_on_storage_denied.client", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzcx
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zznh.zzb());
            }
        });
        zzdc = zza("measurement.consent.stop_reset_on_storage_denied.service", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdg
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zznh.zzc());
            }
        });
        zzdd = zza("measurement.consent.scrub_audience_data_analytics_consent", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzdt
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zznh.zzd());
            }
        });
        zzde = zza("measurement.fix_engagement_on_reset_analytics_data", true, true, new zzfl() { // from class: com.google.android.gms.measurement.internal.zzec
            @Override // com.google.android.gms.measurement.internal.zzfl
            public final Object zza() {
                return Boolean.valueOf(zzoe.zza());
            }
        });
    }
}
