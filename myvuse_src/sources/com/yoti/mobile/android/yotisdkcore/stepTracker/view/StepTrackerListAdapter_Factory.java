package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class StepTrackerListAdapter_Factory implements Factory<StepTrackerListAdapter> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerListAdapter_Factory$a */
    private static final class C5023a {

        /* JADX INFO: renamed from: a */
        private static final StepTrackerListAdapter_Factory f7779a = new StepTrackerListAdapter_Factory();
    }

    public static StepTrackerListAdapter_Factory create() {
        return C5023a.f7779a;
    }

    public static StepTrackerListAdapter newInstance() {
        return new StepTrackerListAdapter();
    }

    @Override // javax.inject.Provider
    public StepTrackerListAdapter get() {
        return newInstance();
    }
}
