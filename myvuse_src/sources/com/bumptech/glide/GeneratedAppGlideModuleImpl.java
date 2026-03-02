package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule;
import com.dylanvann.fastimage.FastImageGlideModule;
import com.dylanvann.fastimage.FastImageOkHttpProgressGlideModule;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    private final FastImageGlideModule appGlideModule = new FastImageGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            LogInstrumentation.m2726d("Glide", "Discovered AppGlideModule from annotation: com.dylanvann.fastimage.FastImageGlideModule");
            LogInstrumentation.m2726d("Glide", "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule");
            LogInstrumentation.m2726d("Glide", "Discovered LibraryGlideModule from annotation: com.dylanvann.fastimage.FastImageOkHttpProgressGlideModule");
        }
    }

    @Override // com.bumptech.glide.module.AppGlideModule, com.bumptech.glide.module.AppliesOptions
    public void applyOptions(Context context, GlideBuilder glideBuilder) {
        this.appGlideModule.applyOptions(context, glideBuilder);
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(Context context, Glide glide, Registry registry) {
        new OkHttpLibraryGlideModule().registerComponents(context, glide, registry);
        new FastImageOkHttpProgressGlideModule().registerComponents(context, glide, registry);
        this.appGlideModule.registerComponents(context, glide, registry);
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public boolean isManifestParsingEnabled() {
        return this.appGlideModule.isManifestParsingEnabled();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public Set<Class<?>> getExcludedModuleClasses() {
        return Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public GeneratedRequestManagerFactory getRequestManagerFactory() {
        return new GeneratedRequestManagerFactory();
    }
}
