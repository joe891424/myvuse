package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import dagger.MembersInjector;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.m */
/* JADX INFO: loaded from: classes4.dex */
public final class C5036m implements MembersInjector<StepTrackerFragment> {
    /* JADX INFO: renamed from: a */
    public static void m5283a(StepTrackerFragment stepTrackerFragment, SavedStateViewModelFactory<StepTrackerViewModel> savedStateViewModelFactory) {
        stepTrackerFragment.f7772b = savedStateViewModelFactory;
    }

    /* JADX INFO: renamed from: a */
    public static void m5284a(StepTrackerFragment stepTrackerFragment, StepTrackerListAdapter stepTrackerListAdapter) {
        stepTrackerFragment.f7771a = stepTrackerListAdapter;
    }
}
