package com.yoti.mobile.android.facecapture.view.capture;

import com.tinder.StateMachine;
import com.yoti.mobile.android.facecapture.view.capture.model.Event;
import com.yoti.mobile.android.facecapture.view.capture.model.SideEffect;
import com.yoti.mobile.android.facecapture.view.capture.model.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00032(\b\u0002\u0010\u0007\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH&JD\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00032(\b\u0002\u0010\u0007\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH&JD\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00032(\b\u0002\u0010\u0007\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH&¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/IFaceCaptureStateMachineFactory;", "", "getAutoCaptureStateMachine", "Lcom/tinder/StateMachine;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect;", "transitionListener", "Lkotlin/Function1;", "Lcom/tinder/StateMachine$Transition;", "", "getFallbackStateMachine", "getManualCaptureStateMachine", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IFaceCaptureStateMachineFactory {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StateMachine getAutoCaptureStateMachine$default(IFaceCaptureStateMachineFactory iFaceCaptureStateMachineFactory, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAutoCaptureStateMachine");
            }
            if ((i & 1) != 0) {
                function1 = null;
            }
            return iFaceCaptureStateMachineFactory.getAutoCaptureStateMachine(function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StateMachine getFallbackStateMachine$default(IFaceCaptureStateMachineFactory iFaceCaptureStateMachineFactory, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFallbackStateMachine");
            }
            if ((i & 1) != 0) {
                function1 = null;
            }
            return iFaceCaptureStateMachineFactory.getFallbackStateMachine(function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StateMachine getManualCaptureStateMachine$default(IFaceCaptureStateMachineFactory iFaceCaptureStateMachineFactory, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getManualCaptureStateMachine");
            }
            if ((i & 1) != 0) {
                function1 = null;
            }
            return iFaceCaptureStateMachineFactory.getManualCaptureStateMachine(function1);
        }
    }

    StateMachine<State, Event, SideEffect> getAutoCaptureStateMachine(Function1<? super StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect>, Unit> transitionListener);

    StateMachine<State, Event, SideEffect> getFallbackStateMachine(Function1<? super StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect>, Unit> transitionListener);

    StateMachine<State, Event, SideEffect> getManualCaptureStateMachine(Function1<? super StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect>, Unit> transitionListener);
}
