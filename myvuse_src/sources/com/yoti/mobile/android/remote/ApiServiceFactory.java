package com.yoti.mobile.android.remote;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yoti.mobile.android.remote.authentication.KeyChainManager;
import com.yoti.mobile.android.remote.authentication.NetworkRequestMapper;
import com.yoti.mobile.android.remote.authentication.TokenProvider;
import com.yoti.mobile.android.remote.interceptor.IbvAuthenticationInterceptor;
import com.yoti.mobile.android.remote.interceptor.TokenAuthInterceptor;
import com.yoti.mobile.android.remote.interceptor.TypedInterceptor;
import com.yoti.mobile.android.remote.model.AuthenticationData;
import com.yoti.mobile.android.remote.model.IbvAuthenticationData;
import com.yoti.mobile.android.remote.model.TokenAuthenticationData;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: ApiServiceFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001e\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0018J2\u0010\u0019\u001a\u0002H\u001a\"\u0006\b\u0000\u0010\u001a\u0018\u00012\u0006\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0086\b¢\u0006\u0002\u0010\u001fJ\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0!2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\"H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006#"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/ApiServiceFactory;", "", "serviceLocation", "Lcom/yoti/mobile/android/remote/ServiceLocation;", "context", "Landroid/content/Context;", "(Lcom/yoti/mobile/android/remote/ServiceLocation;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getServiceLocation", "()Lcom/yoti/mobile/android/remote/ServiceLocation;", "makeAuthInterceptor", "Lcom/yoti/mobile/android/remote/interceptor/TypedInterceptor;", "authenticationData", "Lcom/yoti/mobile/android/remote/model/AuthenticationData;", "makeGson", "Lcom/google/gson/Gson;", "makeGsonBuilder", "Lcom/google/gson/GsonBuilder;", "makeLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "makeOkHttpClient", "Lokhttp3/OkHttpClient;", "interceptors", "", "makeService", ExifInterface.GPS_DIRECTION_TRUE, "okHttpClient", "gson", "callAdapterFactory", "Lretrofit2/CallAdapter$Factory;", "(Lokhttp3/OkHttpClient;Lcom/google/gson/Gson;Lretrofit2/CallAdapter$Factory;)Ljava/lang/Object;", "sortInterceptors", "", "", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ApiServiceFactory {
    private final Context context;
    private final ServiceLocation serviceLocation;

    @Inject
    public ApiServiceFactory(ServiceLocation serviceLocation, Context context) {
        Intrinsics.checkNotNullParameter(serviceLocation, "serviceLocation");
        Intrinsics.checkNotNullParameter(context, "context");
        this.serviceLocation = serviceLocation;
        this.context = context;
    }

    public final ServiceLocation getServiceLocation() {
        return this.serviceLocation;
    }

    public final Context getContext() {
        return this.context;
    }

    public static /* synthetic */ Object makeService$default(ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient, Gson gson, CallAdapter.Factory callAdapterFactory, int i, Object obj) {
        if ((i & 2) != 0) {
            gson = apiServiceFactory.makeGson();
        }
        if ((i & 4) != 0) {
            RxJava2CallAdapterFactory rxJava2CallAdapterFactoryCreate = RxJava2CallAdapterFactory.create();
            Intrinsics.checkNotNullExpressionValue(rxJava2CallAdapterFactoryCreate, "create()");
            callAdapterFactory = rxJava2CallAdapterFactoryCreate;
        }
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(callAdapterFactory, "callAdapterFactory");
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(apiServiceFactory.getServiceLocation().getUrl()).client(okHttpClient).addCallAdapterFactory(callAdapterFactory).addConverterFactory(GsonConverterFactory.create(gson)).build();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return retrofitBuild.create(Object.class);
    }

    public final /* synthetic */ <T> T makeService(OkHttpClient okHttpClient, Gson gson, CallAdapter.Factory callAdapterFactory) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(callAdapterFactory, "callAdapterFactory");
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(getServiceLocation().getUrl()).client(okHttpClient).addCallAdapterFactory(callAdapterFactory).addConverterFactory(GsonConverterFactory.create(gson)).build();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) retrofitBuild.create(Object.class);
    }

    public final OkHttpClient makeOkHttpClient(Set<? extends TypedInterceptor> interceptors) {
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Iterator<T> it2 = sortInterceptors(interceptors).iterator();
        while (it2.hasNext()) {
            builder.addInterceptor((TypedInterceptor) it2.next());
        }
        builder.connectTimeout(30L, TimeUnit.SECONDS);
        builder.readTimeout(62L, TimeUnit.SECONDS);
        builder.writeTimeout(62L, TimeUnit.SECONDS);
        return builder.build();
    }

    private final List<TypedInterceptor> sortInterceptors(Collection<? extends TypedInterceptor> interceptors) {
        return CollectionsKt.sortedWith(interceptors, new Comparator() { // from class: com.yoti.mobile.android.remote.ApiServiceFactory$sortInterceptors$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((TypedInterceptor) t).getType().getOrder()), Integer.valueOf(((TypedInterceptor) t2).getType().getOrder()));
            }
        });
    }

    public final Gson makeGson() {
        Gson gsonCreate = makeGsonBuilder().create();
        Intrinsics.checkNotNullExpressionValue(gsonCreate, "makeGsonBuilder()\n                .create()");
        return gsonCreate;
    }

    public final GsonBuilder makeGsonBuilder() {
        GsonBuilder gsonBuilderEnableComplexMapKeySerialization = new GsonBuilder().setLenient().setDateFormat(RemoteDefsKt.DATE_FORMAT).setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).enableComplexMapKeySerialization();
        Intrinsics.checkNotNullExpressionValue(gsonBuilderEnableComplexMapKeySerialization, "GsonBuilder()\n          …plexMapKeySerialization()");
        return gsonBuilderEnableComplexMapKeySerialization;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final HttpLoggingInterceptor makeLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, 0 == true ? 1 : 0);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
        return httpLoggingInterceptor;
    }

    public final TypedInterceptor makeAuthInterceptor(AuthenticationData authenticationData) {
        Intrinsics.checkNotNullParameter(authenticationData, "authenticationData");
        if (authenticationData instanceof TokenAuthenticationData) {
            return new TokenAuthInterceptor((TokenAuthenticationData) authenticationData);
        }
        if (authenticationData instanceof IbvAuthenticationData) {
            return new IbvAuthenticationInterceptor(new TokenProvider((IbvAuthenticationData) authenticationData, new KeyChainManager(this.context)), new NetworkRequestMapper());
        }
        throw new NoWhenBranchMatchedException();
    }
}
