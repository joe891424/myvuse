package com.yoti.mobile.android.remote.p075di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.remote.ServiceLocation;
import com.yoti.mobile.android.remote.interceptor.MetadataInterceptor;
import com.yoti.mobile.android.remote.interceptor.SessionIdInterceptor;
import com.yoti.mobile.android.remote.interceptor.TypedInterceptor;
import com.yoti.mobile.android.remote.interceptor.TypedLoggingInterceptor;
import com.yoti.mobile.android.remote.model.Session;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.util.Set;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: RemoteModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\b\tJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0012H\u0001¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\bH\u0007J#\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\b2\u0011\u0010\u001a\u001a\r\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b\u001c0\u001bH\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\u001f\u001a\u00020\u0003H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m5598d2 = {"Lcom/yoti/mobile/android/remote/di/RemoteModule;", "", "session", "Lcom/yoti/mobile/android/remote/model/Session;", "(Lcom/yoti/mobile/android/remote/model/Session;)V", "provideAuthInterceptor", "Lcom/yoti/mobile/android/remote/interceptor/TypedInterceptor;", "apiServiceFactory", "Lcom/yoti/mobile/android/remote/ApiServiceFactory;", "provideAuthInterceptor$remote_productionRelease", "provideLoggingInterceptor", "actual", "Lcom/yoti/mobile/android/remote/interceptor/TypedLoggingInterceptor;", "provideLoggingInterceptor$remote_productionRelease", "provideMetadataInterceptor", "Lcom/yoti/mobile/android/remote/interceptor/MetadataInterceptor;", "provideMetadataInterceptor$remote_productionRelease", "provideSessionInterceptor", "Lcom/yoti/mobile/android/remote/interceptor/SessionIdInterceptor;", "provideSessionInterceptor$remote_productionRelease", "providesGson", "Lcom/google/gson/Gson;", "providesGsonBuilder", "Lcom/google/gson/GsonBuilder;", "providesOkHttpClient", "Lokhttp3/OkHttpClient;", "interceptors", "", "Lkotlin/jvm/JvmSuppressWildcards;", "providesServiceLocation", "Lcom/yoti/mobile/android/remote/ServiceLocation;", "providesSession", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module(includes = {IpTrackingModule.class, RemoteDebugModule.class})
public class RemoteModule {
    private final Session session;

    public RemoteModule(Session session) {
        Intrinsics.checkNotNullParameter(session, "session");
        this.session = session;
    }

    @Provides
    public final ServiceLocation providesServiceLocation() {
        return this.session.getServiceLocation();
    }

    @Provides
    @Singleton
    /* JADX INFO: renamed from: providesSession, reason: from getter */
    public final Session getSession() {
        return this.session;
    }

    @Provides
    @Singleton
    public final Gson providesGson(ApiServiceFactory apiServiceFactory) {
        Intrinsics.checkNotNullParameter(apiServiceFactory, "apiServiceFactory");
        return apiServiceFactory.makeGson();
    }

    @Provides
    @Singleton
    public final GsonBuilder providesGsonBuilder(ApiServiceFactory apiServiceFactory) {
        Intrinsics.checkNotNullParameter(apiServiceFactory, "apiServiceFactory");
        return apiServiceFactory.makeGsonBuilder();
    }

    @Provides
    @Singleton
    public final OkHttpClient providesOkHttpClient(ApiServiceFactory apiServiceFactory, Set<TypedInterceptor> interceptors) {
        Intrinsics.checkNotNullParameter(apiServiceFactory, "apiServiceFactory");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        return apiServiceFactory.makeOkHttpClient(interceptors);
    }

    @Provides
    @IntoSet
    public final TypedInterceptor provideLoggingInterceptor$remote_productionRelease(TypedLoggingInterceptor actual) {
        Intrinsics.checkNotNullParameter(actual, "actual");
        return actual;
    }

    @Provides
    @IntoSet
    public final TypedInterceptor provideSessionInterceptor$remote_productionRelease(SessionIdInterceptor actual) {
        Intrinsics.checkNotNullParameter(actual, "actual");
        return actual;
    }

    @Provides
    @IntoSet
    public final TypedInterceptor provideMetadataInterceptor$remote_productionRelease(MetadataInterceptor actual) {
        Intrinsics.checkNotNullParameter(actual, "actual");
        return actual;
    }

    @Provides
    @IntoSet
    public final TypedInterceptor provideAuthInterceptor$remote_productionRelease(ApiServiceFactory apiServiceFactory, Session session) {
        Intrinsics.checkNotNullParameter(apiServiceFactory, "apiServiceFactory");
        Intrinsics.checkNotNullParameter(session, "session");
        return apiServiceFactory.makeAuthInterceptor(session.getAuthData());
    }
}
