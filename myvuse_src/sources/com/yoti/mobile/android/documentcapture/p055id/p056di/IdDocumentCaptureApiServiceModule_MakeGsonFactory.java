package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.MrzSerializer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocumentCaptureApiServiceModule_MakeGsonFactory implements Factory<Gson> {
    private final Provider<GsonBuilder> gsonBuilderProvider;
    private final IdDocumentCaptureApiServiceModule module;
    private final Provider<MrzSerializer> mrzSerializerProvider;

    public IdDocumentCaptureApiServiceModule_MakeGsonFactory(IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule, Provider<GsonBuilder> provider, Provider<MrzSerializer> provider2) {
        this.module = idDocumentCaptureApiServiceModule;
        this.gsonBuilderProvider = provider;
        this.mrzSerializerProvider = provider2;
    }

    public static IdDocumentCaptureApiServiceModule_MakeGsonFactory create(IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule, Provider<GsonBuilder> provider, Provider<MrzSerializer> provider2) {
        return new IdDocumentCaptureApiServiceModule_MakeGsonFactory(idDocumentCaptureApiServiceModule, provider, provider2);
    }

    public static Gson makeGson(IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule, GsonBuilder gsonBuilder, MrzSerializer mrzSerializer) {
        return (Gson) Preconditions.checkNotNullFromProvides(idDocumentCaptureApiServiceModule.makeGson(gsonBuilder, mrzSerializer));
    }

    @Override // javax.inject.Provider
    public Gson get() {
        return makeGson(this.module, this.gsonBuilderProvider.get(), this.mrzSerializerProvider.get());
    }
}
