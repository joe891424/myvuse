package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.di.SelectionModule_ProvideDocumentFeatureErrorToFailureMapperFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4602x1c0ef2e1 implements Factory<Mapper<Throwable, YdsFailure>> {
    private final SelectionModule module;

    public C4602x1c0ef2e1(SelectionModule selectionModule) {
        this.module = selectionModule;
    }

    public static C4602x1c0ef2e1 create(SelectionModule selectionModule) {
        return new C4602x1c0ef2e1(selectionModule);
    }

    public static Mapper<Throwable, YdsFailure> provideDocumentFeatureErrorToFailureMapper(SelectionModule selectionModule) {
        return (Mapper) Preconditions.checkNotNullFromProvides(selectionModule.provideDocumentFeatureErrorToFailureMapper());
    }

    @Override // javax.inject.Provider
    public Mapper<Throwable, YdsFailure> get() {
        return provideDocumentFeatureErrorToFailureMapper(this.module);
    }
}
