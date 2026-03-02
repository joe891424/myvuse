package com.yoti.mobile.android.commons.navigation;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: NavigationViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/navigation/NavigationViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/yoti/mobile/android/commons/navigation/NavigationEvent;", NotificationCompat.CATEGORY_EVENT, "", "sendCoordinatorEvent", "(Lcom/yoti/mobile/android/commons/navigation/NavigationEvent;)V", "Lkotlinx/coroutines/channels/Channel;", "a", "Lkotlinx/coroutines/channels/Channel;", "_navigationEvent", "Lkotlinx/coroutines/flow/Flow;", "b", "Lkotlinx/coroutines/flow/Flow;", "getNavigationEvents", "()Lkotlinx/coroutines/flow/Flow;", "navigationEvents", "<init>", "()V", "commons-navigation_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public class NavigationViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Channel<NavigationEvent> _navigationEvent;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Flow<NavigationEvent> navigationEvents;

    /* JADX INFO: renamed from: com.yoti.mobile.android.commons.navigation.NavigationViewModel$a */
    /* JADX INFO: compiled from: NavigationViewModel.kt */
    @DebugMetadata(m5607c = "com.yoti.mobile.android.commons.navigation.NavigationViewModel$sendCoordinatorEvent$1", m5608f = "NavigationViewModel.kt", m5609i = {}, m5610l = {23}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C4581a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        int f6549a;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ NavigationEvent f6551c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4581a(NavigationEvent navigationEvent, Continuation continuation) {
            super(2, continuation);
            this.f6551c = navigationEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return NavigationViewModel.this.new C4581a(this.f6551c, completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C4581a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6549a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Channel channel = NavigationViewModel.this._navigationEvent;
                NavigationEvent navigationEvent = this.f6551c;
                this.f6549a = 1;
                if (channel.send(navigationEvent, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public NavigationViewModel() {
        Channel<NavigationEvent> channelChannel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._navigationEvent = channelChannel$default;
        this.navigationEvents = FlowKt.receiveAsFlow(channelChannel$default);
    }

    public final Flow<NavigationEvent> getNavigationEvents() {
        return this.navigationEvents;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void sendCoordinatorEvent(NavigationEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C4581a(event, null), 3, null);
    }
}
