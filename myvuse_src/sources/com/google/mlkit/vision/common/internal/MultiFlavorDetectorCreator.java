package com.google.mlkit.vision.common.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class MultiFlavorDetectorCreator {
    private final Map<Class<? extends DetectorOptions<?>>, Provider<? extends DetectorCreator<?, ?>>> zza = new HashMap();

    /* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
    public interface DetectorCreator<ResultT, OptionsT extends DetectorOptions<ResultT>> {
        MobileVisionBase<ResultT> create(OptionsT optionst);
    }

    /* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
    public interface DetectorOptions<ResultT> {
    }

    /* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
    public static class Registration {
        private final Class<? extends DetectorOptions<?>> zza;
        private final Provider<? extends DetectorCreator<?, ?>> zzb;
        private final int zzc;

        public <ResultT, OptionsT extends DetectorOptions<ResultT>> Registration(Class<? extends OptionsT> cls, Provider<? extends DetectorCreator<ResultT, OptionsT>> provider) {
            this(cls, provider, 100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <ResultT, OptionsT extends DetectorOptions<ResultT>> Registration(Class<? extends OptionsT> cls, Provider<? extends DetectorCreator<ResultT, OptionsT>> provider, int i) {
            this.zza = cls;
            this.zzb = provider;
            this.zzc = i;
        }

        final Class<? extends DetectorOptions<?>> zza() {
            return this.zza;
        }

        final Provider<? extends DetectorCreator<?, ?>> zzb() {
            return this.zzb;
        }

        final int zzc() {
            return this.zzc;
        }
    }

    MultiFlavorDetectorCreator(Set<Registration> set) {
        HashMap map = new HashMap();
        for (Registration registration : set) {
            Class<? extends DetectorOptions<?>> clsZza = registration.zza();
            if (!this.zza.containsKey(clsZza) || registration.zzc() >= ((Integer) Preconditions.checkNotNull((Integer) map.get(clsZza))).intValue()) {
                this.zza.put(clsZza, registration.zzb());
                map.put(clsZza, Integer.valueOf(registration.zzc()));
            }
        }
    }

    public static synchronized MultiFlavorDetectorCreator getInstance() {
        return (MultiFlavorDetectorCreator) MlKitContext.getInstance().get(MultiFlavorDetectorCreator.class);
    }

    public <ResultT, OptionsT extends DetectorOptions<ResultT>> MobileVisionBase<ResultT> create(OptionsT optionst) {
        return ((DetectorCreator) ((Provider) Preconditions.checkNotNull(this.zza.get(optionst.getClass()))).get()).create(optionst);
    }
}
