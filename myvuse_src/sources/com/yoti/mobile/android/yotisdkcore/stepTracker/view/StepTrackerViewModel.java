package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.commonui.SavedStateHandleHolder;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.yotidocs.common.SingleUseCase;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.view.FeatureLauncher;
import com.yoti.mobile.android.yotisdkcore.core.view.FeatureLauncherFactory;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.GetSessionConfigurationInteractor;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.FinishSessionHelper;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerNavigationEvent;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerViewEvent;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerViewModel;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerViewState;
import io.reactivex.observers.DisposableSingleObserver;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.r, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002:\u0001GB?\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0012J\b\u0010/\u001a\u000200H\u0012J\u0018\u00101\u001a\u0002002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0012J\b\u00106\u001a\u000200H\u0012J\u0010\u00107\u001a\u0002002\u0006\u00104\u001a\u000205H\u0012J\u0010\u00108\u001a\u0002002\u0006\u00104\u001a\u000205H\u0012J\b\u00109\u001a\u000200H\u0012J\b\u0010:\u001a\u000200H\u0014J\b\u0010;\u001a\u000200H\u0012J\b\u0010<\u001a\u000200H\u0012J\u0010\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020?H\u0012J\b\u0010@\u001a\u000200H\u0012J\u0010\u0010A\u001a\u0002002\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u000200H\u0012J\u0010\u0010E\u001a\u0002002\u0006\u0010F\u001a\u00020$H\u0016R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0092\u0004¢\u0006\u0002\n\u0000R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00138RX\u0092\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u000f\u001a\u00020\u0010X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8RX\u0092\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0092.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0092\u0004¢\u0006\u0002\n\u0000R#\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u00138RX\u0092\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001b\u001a\u0004\b'\u0010\u0019R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\"¨\u0006H"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/yoti/mobile/android/commonui/SavedStateHandleHolder;", "getSessionConfigurationInteractor", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/GetSessionConfigurationInteractor;", "finishSessionHelper", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper;", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "sessionConfigurationEntityToViewDataMapper", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SessionConfigurationEntityToViewDataMapper;", "featureLauncherFactory", "Lcom/yoti/mobile/android/yotisdkcore/core/view/FeatureLauncherFactory;", "errorToSessionStatusTypeMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;", "errorToFailureMapper", "Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/GetSessionConfigurationInteractor;Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SessionConfigurationEntityToViewDataMapper;Lcom/yoti/mobile/android/yotisdkcore/core/view/FeatureLauncherFactory;Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;)V", "_navigationEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerNavigationEvent;", "_viewState", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState;", "get_viewState", "()Landroidx/lifecycle/MutableLiveData;", "_viewState$delegate", "Lkotlin/Lazy;", "isSingleStepFlow", "", "()Z", "navigationEvent", "Landroidx/lifecycle/LiveData;", "getNavigationEvent", "()Landroidx/lifecycle/LiveData;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "stepTrackerViewData", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewData;", "getStepTrackerViewData", "stepTrackerViewData$delegate", "viewState", "getViewState", "createFeatureLauncher", "Lcom/yoti/mobile/android/yotisdkcore/core/view/FeatureLauncher;", "currentStep", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/Step;", "finishSession", "", "handleError", "throwable", "", HeaderParameterNames.AUTHENTICATION_TAG, "", "loadSessionConfiguration", "onActionCancelEvent", "onActionTryAgainEvent", "onCancelFlowEvent", "onCleared", "onFinishFlowEvent", "onGotItEvent", "onLaunchFeatureEvent", "fragment", "Landroidx/fragment/app/Fragment;", "onStepCompleteEvent", "onViewEvent", "viewEvent", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent;", "retrieveSessionConfiguration", "setSavedStateHandle", "handle", "SessionConfigurationLoadObserver", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class StepTrackerViewModel extends ViewModel implements SavedStateHandleHolder {

    /* JADX INFO: renamed from: a */
    private final GetSessionConfigurationInteractor f7851a;

    /* JADX INFO: renamed from: b */
    private final FinishSessionHelper f7852b;

    /* JADX INFO: renamed from: c */
    private final SessionStatus f7853c;

    /* JADX INFO: renamed from: d */
    private final SessionConfigurationEntityToViewDataMapper f7854d;

    /* JADX INFO: renamed from: e */
    private final FeatureLauncherFactory f7855e;

    /* JADX INFO: renamed from: f */
    private final ErrorToSessionStatusTypeMapper f7856f;

    /* JADX INFO: renamed from: g */
    private final ExceptionToFailureMapper f7857g;

    /* JADX INFO: renamed from: h */
    private final Lazy f7858h;

    /* JADX INFO: renamed from: i */
    private final Lazy f7859i;

    /* JADX INFO: renamed from: j */
    private final MutableLiveData<SingleEvent<StepTrackerNavigationEvent>> f7860j;

    /* JADX INFO: renamed from: k */
    private SavedStateHandle f7861k;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.r$a */
    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewModel$SessionConfigurationLoadObserver;", "Lio/reactivex/observers/DisposableSingleObserver;", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity;", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewModel;)V", "onError", "", "exception", "", "onSuccess", "sessionConfigurationEntity", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private final class a extends DisposableSingleObserver<SessionConfigurationEntity> {
        public a() {
        }

        @Override // io.reactivex.SingleObserver
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(SessionConfigurationEntity sessionConfigurationEntity) {
            Intrinsics.checkNotNullParameter(sessionConfigurationEntity, "sessionConfigurationEntity");
            StepTrackerViewData stepTrackerViewDataM5260a = StepTrackerViewModel.this.f7854d.map(sessionConfigurationEntity);
            StepTrackerViewModel.this.m5317c().setValue(stepTrackerViewDataM5260a);
            if (stepTrackerViewDataM5260a.m5294a()) {
                StepTrackerViewModel.this.m5309a();
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            StepTrackerViewModel.this.m5314a(exception, "SESSION_CONFIG_ERROR_TAG");
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.r$b */
    @Metadata(m5597d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, m5598d2 = {"<anonymous>", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState;", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    static final class b extends Lambda implements Function0<MediatorLiveData<StepTrackerViewState>> {
        b() {
            super(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public static final void m5335a(MediatorLiveData viewState, StepTrackerViewData stepTrackerViewData) {
            Intrinsics.checkNotNullParameter(viewState, "$viewState");
            viewState.setValue(stepTrackerViewData != null ? new StepTrackerViewState.c(stepTrackerViewData) : StepTrackerViewState.a.b.f7866a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public static final void m5336a(MediatorLiveData viewState, StepTrackerViewModel this$0, FinishSessionHelper.b bVar) {
            Intrinsics.checkNotNullParameter(viewState, "$viewState");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (Intrinsics.areEqual(bVar, FinishSessionHelper.b.C6027b.f7803a)) {
                if (Intrinsics.areEqual(viewState.getValue(), StepTrackerViewState.a.C6028a.f7865a)) {
                    this$0.m5327i();
                }
            } else if (bVar instanceof FinishSessionHelper.b.c) {
                this$0.m5314a(((FinishSessionHelper.b.c) bVar).getF7804a(), "SESSION_FINISH_ERROR_TAG");
            }
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MediatorLiveData<StepTrackerViewState> invoke() {
            final MediatorLiveData<StepTrackerViewState> mediatorLiveData = new MediatorLiveData<>();
            final StepTrackerViewModel stepTrackerViewModel = StepTrackerViewModel.this;
            mediatorLiveData.setValue(StepTrackerViewState.a.b.f7866a);
            mediatorLiveData.addSource(stepTrackerViewModel.m5317c(), new Observer() { // from class: com.yoti.mobile.android.yotisdkcore.stepTracker.view.r$b$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    StepTrackerViewModel.b.m5335a(mediatorLiveData, (StepTrackerViewData) obj);
                }
            });
            mediatorLiveData.addSource(stepTrackerViewModel.f7852b.m5237c(), new Observer() { // from class: com.yoti.mobile.android.yotisdkcore.stepTracker.view.r$b$$ExternalSyntheticLambda1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    StepTrackerViewModel.b.m5336a(mediatorLiveData, stepTrackerViewModel, (FinishSessionHelper.b) obj);
                }
            });
            return mediatorLiveData;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.r$c */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, m5598d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewData;", "kotlin.jvm.PlatformType", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    static final class c extends Lambda implements Function0<MutableLiveData<StepTrackerViewData>> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<StepTrackerViewData> invoke() {
            SavedStateHandle savedStateHandle = StepTrackerViewModel.this.f7861k;
            if (savedStateHandle == null) {
                Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
                savedStateHandle = null;
            }
            MutableLiveData<StepTrackerViewData> liveData = savedStateHandle.getLiveData("KEY_STEP_TRACKER_VIEW_DATA");
            StepTrackerViewModel stepTrackerViewModel = StepTrackerViewModel.this;
            if (liveData.getValue() == null) {
                stepTrackerViewModel.m5324g();
            }
            return liveData;
        }
    }

    @Inject
    public StepTrackerViewModel(GetSessionConfigurationInteractor getSessionConfigurationInteractor, FinishSessionHelper finishSessionHelper, SessionStatus sessionStatus, SessionConfigurationEntityToViewDataMapper sessionConfigurationEntityToViewDataMapper, FeatureLauncherFactory featureLauncherFactory, ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper, ExceptionToFailureMapper errorToFailureMapper) {
        Intrinsics.checkNotNullParameter(getSessionConfigurationInteractor, "getSessionConfigurationInteractor");
        Intrinsics.checkNotNullParameter(finishSessionHelper, "finishSessionHelper");
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        Intrinsics.checkNotNullParameter(sessionConfigurationEntityToViewDataMapper, "sessionConfigurationEntityToViewDataMapper");
        Intrinsics.checkNotNullParameter(featureLauncherFactory, "featureLauncherFactory");
        Intrinsics.checkNotNullParameter(errorToSessionStatusTypeMapper, "errorToSessionStatusTypeMapper");
        Intrinsics.checkNotNullParameter(errorToFailureMapper, "errorToFailureMapper");
        this.f7851a = getSessionConfigurationInteractor;
        this.f7852b = finishSessionHelper;
        this.f7853c = sessionStatus;
        this.f7854d = sessionConfigurationEntityToViewDataMapper;
        this.f7855e = featureLauncherFactory;
        this.f7856f = errorToSessionStatusTypeMapper;
        this.f7857g = errorToFailureMapper;
        this.f7858h = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new c());
        this.f7859i = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new b());
        this.f7860j = new MutableLiveData<>();
    }

    /* JADX INFO: renamed from: a */
    private FeatureLauncher m5308a(Step step) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        FeatureLauncher featureLauncherCreate = this.f7855e.create(step.getF7831d());
        featureLauncherCreate.configure(step.getF7829b());
        return featureLauncherCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m5309a() {
        this.f7852b.m5236b();
    }

    /* JADX INFO: renamed from: a */
    private void m5310a(Fragment fragment) {
        Step stepM5297d;
        StepTrackerViewData value = m5317c().getValue();
        if (value == null || (stepM5297d = value.m5297d()) == null) {
            return;
        }
        m5308a(stepM5297d).start(fragment);
    }

    /* JADX INFO: renamed from: a */
    private void m5313a(String str) {
        if (Intrinsics.areEqual(str, "SESSION_CONFIG_ERROR_TAG") ? true : Intrinsics.areEqual(str, "SESSION_FINISH_ERROR_TAG")) {
            this.f7860j.setValue(new SingleEvent<>(StepTrackerNavigationEvent.c.f7839a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m5314a(Throwable th, String str) {
        this.f7853c.setSessionStatus(this.f7856f.map(th));
        m5320e().setValue(new StepTrackerViewState.b(this.f7857g.map(th), str));
    }

    /* JADX INFO: renamed from: b */
    private void m5316b(String str) {
        if (Intrinsics.areEqual(str, "SESSION_CONFIG_ERROR_TAG")) {
            m5330l();
        } else if (Intrinsics.areEqual(str, "SESSION_FINISH_ERROR_TAG")) {
            m5320e().setValue(StepTrackerViewState.a.C6028a.f7865a);
            m5309a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public MutableLiveData<StepTrackerViewData> m5317c() {
        Object value = this.f7858h.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-stepTrackerViewData>(...)");
        return (MutableLiveData) value;
    }

    /* JADX INFO: renamed from: e */
    private MutableLiveData<StepTrackerViewState> m5320e() {
        return (MutableLiveData) this.f7859i.getValue();
    }

    /* JADX INFO: renamed from: f */
    private boolean m5323f() {
        List<Step> listM5299g;
        StepTrackerViewData value = m5317c().getValue();
        return (value == null || (listM5299g = value.m5299g()) == null || listM5299g.size() != 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m5324g() {
        this.f7851a.clear();
        SingleUseCase.execute$default(this.f7851a, new a(), null, 2, null);
    }

    /* JADX INFO: renamed from: h */
    private void m5326h() {
        if (m5323f()) {
            this.f7860j.setValue(new SingleEvent<>(StepTrackerNavigationEvent.b.f7838a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i */
    public void m5327i() {
        this.f7860j.setValue(new SingleEvent<>(StepTrackerNavigationEvent.a.f7837a));
    }

    /* JADX INFO: renamed from: j */
    private void m5328j() {
        FinishSessionHelper.b value = this.f7852b.m5237c().getValue();
        if (Intrinsics.areEqual(value, FinishSessionHelper.b.e.f7806a)) {
            m5320e().setValue(StepTrackerViewState.a.C6028a.f7865a);
            return;
        }
        if (Intrinsics.areEqual(value, FinishSessionHelper.b.a.f7802a)) {
            m5320e().setValue(StepTrackerViewState.a.C6028a.f7865a);
            m5309a();
        } else if (Intrinsics.areEqual(value, FinishSessionHelper.b.C6027b.f7803a)) {
            m5327i();
        }
    }

    /* JADX INFO: renamed from: k */
    private void m5329k() {
        MutableLiveData<StepTrackerViewData> mutableLiveDataM5317c = m5317c();
        StepTrackerViewData value = m5317c().getValue();
        if (value != null) {
            Step stepM5295b = value.m5295b();
            if (value.m5294a()) {
                m5309a();
            } else if (stepM5295b.getF7832e()) {
                m5330l();
            }
        } else {
            value = null;
        }
        mutableLiveDataM5317c.setValue(value);
    }

    /* JADX INFO: renamed from: l */
    private void m5330l() {
        m5317c().setValue(null);
        m5324g();
    }

    /* JADX INFO: renamed from: a */
    public void m5331a(StepTrackerViewEvent viewEvent) {
        Intrinsics.checkNotNullParameter(viewEvent, "viewEvent");
        if (viewEvent instanceof StepTrackerViewEvent.f) {
            m5310a(((StepTrackerViewEvent.f) viewEvent).getF7849a());
            return;
        }
        if (Intrinsics.areEqual(viewEvent, StepTrackerViewEvent.g.f7850a)) {
            m5329k();
            return;
        }
        if (viewEvent instanceof StepTrackerViewEvent.b) {
            m5316b(((StepTrackerViewEvent.b) viewEvent).getF7845a());
            return;
        }
        if (viewEvent instanceof StepTrackerViewEvent.a) {
            m5313a(((StepTrackerViewEvent.a) viewEvent).getF7844a());
            return;
        }
        if (Intrinsics.areEqual(viewEvent, StepTrackerViewEvent.e.f7848a)) {
            m5328j();
        } else if (Intrinsics.areEqual(viewEvent, StepTrackerViewEvent.d.f7847a)) {
            m5327i();
        } else if (Intrinsics.areEqual(viewEvent, StepTrackerViewEvent.c.f7846a)) {
            m5326h();
        }
    }

    /* JADX INFO: renamed from: b */
    public LiveData<SingleEvent<StepTrackerNavigationEvent>> m5332b() {
        return this.f7860j;
    }

    /* JADX INFO: renamed from: d */
    public LiveData<StepTrackerViewState> m5333d() {
        return m5320e();
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        this.f7851a.clear();
        this.f7852b.m5234a();
        super.onCleared();
    }

    @Override // com.yoti.mobile.android.commonui.SavedStateHandleHolder
    public void setSavedStateHandle(SavedStateHandle handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.f7861k = handle;
        FinishSessionHelper finishSessionHelper = this.f7852b;
        if (handle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            handle = null;
        }
        finishSessionHelper.m5235a(handle);
    }
}
