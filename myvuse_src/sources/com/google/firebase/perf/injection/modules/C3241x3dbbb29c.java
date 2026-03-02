package com.google.firebase.perf.injection.modules;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory */
/* JADX INFO: loaded from: classes2.dex */
public final class C3241x3dbbb29c implements Factory<Provider<TransportFactory>> {
    private final FirebasePerformanceModule module;

    public C3241x3dbbb29c(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    @Override // javax.inject.Provider
    public Provider<TransportFactory> get() {
        return providesTransportFactoryProvider(this.module);
    }

    public static C3241x3dbbb29c create(FirebasePerformanceModule firebasePerformanceModule) {
        return new C3241x3dbbb29c(firebasePerformanceModule);
    }

    public static Provider<TransportFactory> providesTransportFactoryProvider(FirebasePerformanceModule firebasePerformanceModule) {
        return (Provider) Preconditions.checkNotNull(firebasePerformanceModule.providesTransportFactoryProvider(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
