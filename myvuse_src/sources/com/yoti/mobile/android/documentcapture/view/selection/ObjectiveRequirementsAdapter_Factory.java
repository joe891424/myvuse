package com.yoti.mobile.android.documentcapture.view.selection;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class ObjectiveRequirementsAdapter_Factory implements Factory<ObjectiveRequirementsAdapter> {

    private static final class InstanceHolder {
        private static final ObjectiveRequirementsAdapter_Factory INSTANCE = new ObjectiveRequirementsAdapter_Factory();

        private InstanceHolder() {
        }
    }

    public static ObjectiveRequirementsAdapter_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ObjectiveRequirementsAdapter newInstance() {
        return new ObjectiveRequirementsAdapter();
    }

    @Override // javax.inject.Provider
    public ObjectiveRequirementsAdapter get() {
        return newInstance();
    }
}
