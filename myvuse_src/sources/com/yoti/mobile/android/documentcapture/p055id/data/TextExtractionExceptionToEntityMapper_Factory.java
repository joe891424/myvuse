package com.yoti.mobile.android.documentcapture.p055id.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class TextExtractionExceptionToEntityMapper_Factory implements Factory<TextExtractionExceptionToEntityMapper> {

    private static final class InstanceHolder {
        private static final TextExtractionExceptionToEntityMapper_Factory INSTANCE = new TextExtractionExceptionToEntityMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static TextExtractionExceptionToEntityMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TextExtractionExceptionToEntityMapper newInstance() {
        return new TextExtractionExceptionToEntityMapper();
    }

    @Override // javax.inject.Provider
    public TextExtractionExceptionToEntityMapper get() {
        return newInstance();
    }
}
