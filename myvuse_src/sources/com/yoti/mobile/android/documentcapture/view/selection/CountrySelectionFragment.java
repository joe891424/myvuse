package com.yoti.mobile.android.documentcapture.view.selection;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerFooterInfo;
import com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerModel;
import com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerView;
import com.yoti.mobile.android.commons.navigation.NavigationCoordinatorHost;
import com.yoti.mobile.android.commons.navigation.NavigationUtilsKt;
import com.yoti.mobile.android.commons.navigation.NavigationViewModel;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.documentcapture.databinding.YdsFragmentCountrySelectionBinding;
import com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreSession;
import com.yoti.mobile.android.documentcapture.p054di.ForDocumentSelection;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewEvent;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001/B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(H\u0016J\u0012\u0010)\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00060\u0019R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u00060"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "Lcom/yoti/mobile/android/commons/navigation/NavigationCoordinatorHost;", "()V", "binding", "Lcom/yoti/mobile/android/documentcapture/databinding/YdsFragmentCountrySelectionBinding;", "getBinding", "()Lcom/yoti/mobile/android/documentcapture/databinding/YdsFragmentCountrySelectionBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "coordinator", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionCoordinator;", "getCoordinator", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionCoordinator;", "setCoordinator", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionCoordinator;)V", "factory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewModel;", "getFactory$annotations", "getFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "setFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;)V", "pickerViewWrapper", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionFragment$PickerViewWrapper;", "viewModel", "getCountrySelectionListItem", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionListItem;", "option", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;", "handleSuccess", "", "viewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewData;", "handleViewState", "viewState", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "PickerViewWrapper", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class CountrySelectionFragment extends BaseFragment implements NavigationCoordinatorHost {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CountrySelectionFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/documentcapture/databinding/YdsFragmentCountrySelectionBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;

    @Inject
    public DocumentSelectionCoordinator coordinator;

    @Inject
    public SavedStateViewModelFactory<DocumentSelectionViewModel> factory;
    private PickerViewWrapper pickerViewWrapper;
    private DocumentSelectionViewModel viewModel;

    @Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionFragment$PickerViewWrapper;", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/ViewGroup;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionFragment;Landroid/content/Context;Landroid/view/ViewGroup;)V", "pickerView", "Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerView;", "selectedCountryOption", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;", "setPickerData", "", "pickerItems", "", "Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerModel;", "footerInfo", "Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerFooterInfo;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private final class PickerViewWrapper {
        private final AlphabeticalPickerView pickerView;
        private CountrySelectionOptionViewData selectedCountryOption;
        final /* synthetic */ CountrySelectionFragment this$0;

        public PickerViewWrapper(final CountrySelectionFragment countrySelectionFragment, Context context, ViewGroup rootView) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.this$0 = countrySelectionFragment;
            AlphabeticalPickerView alphabeticalPickerView = new AlphabeticalPickerView(context, rootView, true, false, C4597R.string.ios_android_yds_common_done);
            this.pickerView = alphabeticalPickerView;
            alphabeticalPickerView.setListener(new AlphabeticalPickerView.PickerViewListener<CountrySelectionListItem>() { // from class: com.yoti.mobile.android.documentcapture.view.selection.CountrySelectionFragment.PickerViewWrapper.1
                @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerView.PickerViewListener
                public void onItemsLoaded() {
                    CountrySelectionOptionViewData countrySelectionOptionViewData = PickerViewWrapper.this.selectedCountryOption;
                    if (countrySelectionOptionViewData != null) {
                        PickerViewWrapper.this.pickerView.setItemAsSelected(countrySelectionFragment.getCountrySelectionListItem(countrySelectionOptionViewData));
                    }
                }

                @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerView.PickerViewListener
                public void onItemSelected(CountrySelectionListItem listItem) {
                    Intrinsics.checkNotNullParameter(listItem, "listItem");
                    DocumentSelectionViewModel documentSelectionViewModel = null;
                    PickerViewWrapper.this.pickerView.setListener(null);
                    DocumentSelectionViewModel documentSelectionViewModel2 = countrySelectionFragment.viewModel;
                    if (documentSelectionViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        documentSelectionViewModel = documentSelectionViewModel2;
                    }
                    documentSelectionViewModel.handleViewEvent(new DocumentSelectionViewEvent.CountrySelected(listItem.getOption()));
                }
            });
        }

        public final void setPickerData(List<? extends AlphabeticalPickerModel> pickerItems, AlphabeticalPickerFooterInfo footerInfo, CountrySelectionOptionViewData selectedCountryOption) {
            Intrinsics.checkNotNullParameter(pickerItems, "pickerItems");
            this.selectedCountryOption = selectedCountryOption;
            this.pickerView.setItems(pickerItems, footerInfo);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.selection.CountrySelectionFragment$onViewCreated$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.selection.CountrySelectionFragment$onViewCreated$1", m5608f = "CountrySelectionFragment.kt", m5609i = {}, m5610l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.selection.CountrySelectionFragment$onViewCreated$1$1, reason: invalid class name */
        @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.selection.CountrySelectionFragment$onViewCreated$1$1", m5608f = "CountrySelectionFragment.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CountrySelectionFragment this$0;

            /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.selection.CountrySelectionFragment$onViewCreated$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.selection.CountrySelectionFragment$onViewCreated$1$1$1", m5608f = "CountrySelectionFragment.kt", m5609i = {}, m5610l = {68}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
            static final class C60101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ CountrySelectionFragment this$0;

                /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.selection.CountrySelectionFragment$onViewCreated$1$1$1$1, reason: invalid class name and collision with other inner class name */
                @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                /* synthetic */ class C60111 implements FlowCollector, FunctionAdapter {
                    final /* synthetic */ CountrySelectionFragment $tmp0;

                    C60111(CountrySelectionFragment countrySelectionFragment) {
                        this.$tmp0 = countrySelectionFragment;
                    }

                    public final Object emit(DocumentSelectionViewState documentSelectionViewState, Continuation<? super Unit> continuation) {
                        Object objInvokeSuspend$handleViewState = C60101.invokeSuspend$handleViewState(this.$tmp0, documentSelectionViewState, continuation);
                        return objInvokeSuspend$handleViewState == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvokeSuspend$handleViewState : Unit.INSTANCE;
                    }

                    public final boolean equals(Object obj) {
                        if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                        }
                        return false;
                    }

                    @Override // kotlin.jvm.internal.FunctionAdapter
                    public final Function<?> getFunctionDelegate() {
                        return new AdaptedFunctionReference(2, this.$tmp0, CountrySelectionFragment.class, "handleViewState", "handleViewState(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState;)V", 4);
                    }

                    public final int hashCode() {
                        return getFunctionDelegate().hashCode();
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                        return emit((DocumentSelectionViewState) obj, (Continuation<? super Unit>) continuation);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C60101(CountrySelectionFragment countrySelectionFragment, Continuation<? super C60101> continuation) {
                    super(2, continuation);
                    this.this$0 = countrySelectionFragment;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ Object invokeSuspend$handleViewState(CountrySelectionFragment countrySelectionFragment, DocumentSelectionViewState documentSelectionViewState, Continuation continuation) {
                    countrySelectionFragment.handleViewState(documentSelectionViewState);
                    return Unit.INSTANCE;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C60101(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C60101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        DocumentSelectionViewModel documentSelectionViewModel = this.this$0.viewModel;
                        if (documentSelectionViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            documentSelectionViewModel = null;
                        }
                        Flow<DocumentSelectionViewState> viewState = documentSelectionViewModel.getViewState();
                        C60111 c60111 = new C60111(this.this$0);
                        this.label = 1;
                        if (viewState.collect(c60111, this) == coroutine_suspended) {
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(CountrySelectionFragment countrySelectionFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = countrySelectionFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new C60101(this.this$0, null), 3, null);
                return Unit.INSTANCE;
            }
        }

        C46861(Continuation<? super C46861> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CountrySelectionFragment.this.new C46861(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = CountrySelectionFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(CountrySelectionFragment.this, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, state, anonymousClass1, this) == coroutine_suspended) {
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

    public CountrySelectionFragment() {
        super(C4597R.layout.yds_fragment_country_selection);
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentCountrySelectionBinding>() { // from class: com.yoti.mobile.android.documentcapture.view.selection.CountrySelectionFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentCountrySelectionBinding invoke() {
                return YdsFragmentCountrySelectionBinding.bind(this.this$0.requireView());
            }
        });
    }

    private final YdsFragmentCountrySelectionBinding getBinding() {
        return (YdsFragmentCountrySelectionBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CountrySelectionListItem getCountrySelectionListItem(CountrySelectionOptionViewData option) {
        if (option instanceof CountryViewData) {
            return new CountrySelectionListItem(((CountryViewData) option).getLocalizedName(), option);
        }
        if (!(option instanceof CountryNotListedViewData)) {
            throw new NoWhenBranchMatchedException();
        }
        String string = getString(((CountryNotListedViewData) option).getOptionLabelId());
        Intrinsics.checkNotNullExpressionValue(string, "getString(option.optionLabelId)");
        return new CountrySelectionListItem(string, option);
    }

    @ForDocumentSelection
    public static /* synthetic */ void getFactory$annotations() {
    }

    private final void handleSuccess(DocumentSelectionViewData viewData) {
        AlphabeticalPickerFooterInfo alphabeticalPickerFooterInfo;
        List<CountryViewData> countries = viewData.getCountries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(countries, 10));
        Iterator<T> it2 = countries.iterator();
        while (it2.hasNext()) {
            arrayList.add(getCountrySelectionListItem((CountryViewData) it2.next()));
        }
        CountryNotListedViewData countryNotListedOption = viewData.getCountryNotListedOption();
        PickerViewWrapper pickerViewWrapper = null;
        if (countryNotListedOption != null) {
            alphabeticalPickerFooterInfo = new AlphabeticalPickerFooterInfo(countryNotListedOption.getSectionTitle(), CollectionsKt.listOf(getCountrySelectionListItem(countryNotListedOption)));
        } else {
            alphabeticalPickerFooterInfo = null;
        }
        PickerViewWrapper pickerViewWrapper2 = this.pickerViewWrapper;
        if (pickerViewWrapper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickerViewWrapper");
        } else {
            pickerViewWrapper = pickerViewWrapper2;
        }
        pickerViewWrapper.setPickerData(arrayList, alphabeticalPickerFooterInfo, viewData.getSelectedCountryOption());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleViewState(DocumentSelectionViewState viewState) {
        if (!(viewState instanceof DocumentSelectionViewState.Success)) {
            throw new IllegalStateException("Country Selection should not be launched unless viewState == Success!!".toString());
        }
        handleSuccess(((DocumentSelectionViewState.Success) viewState).getViewData());
    }

    public final SavedStateViewModelFactory<DocumentSelectionViewModel> getFactory() {
        SavedStateViewModelFactory<DocumentSelectionViewModel> savedStateViewModelFactory = this.factory;
        if (savedStateViewModelFactory != null) {
            return savedStateViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DocumentCaptureCoreSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SavedStateViewModelFactory<DocumentSelectionViewModel> factory = getFactory();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        this.viewModel = (DocumentSelectionViewModel) factory.create(fragmentActivityRequireActivity);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getCoordinator().bind(this, 0);
        DocumentSelectionViewModel documentSelectionViewModel = this.viewModel;
        if (documentSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentSelectionViewModel = null;
        }
        NavigationUtilsKt.bindNavigationViewModel((Fragment) this, (NavigationViewModel) documentSelectionViewModel);
        YotiAppbar appBar = getBinding().appBar;
        int i = C4597R.string.yds_country_selection_title;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        BaseFragment.configureAppBar$default(this, appBar, null, false, i, 0, 0, 50, null);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FrameLayout frameLayout = getBinding().countryPickerContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.countryPickerContainer");
        this.pickerViewWrapper = new PickerViewWrapper(this, contextRequireContext, frameLayout);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C46861(null), 3, null);
    }

    public void setCoordinator(DocumentSelectionCoordinator documentSelectionCoordinator) {
        Intrinsics.checkNotNullParameter(documentSelectionCoordinator, "<set-?>");
        this.coordinator = documentSelectionCoordinator;
    }

    public final void setFactory(SavedStateViewModelFactory<DocumentSelectionViewModel> savedStateViewModelFactory) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactory, "<set-?>");
        this.factory = savedStateViewModelFactory;
    }

    @Override // com.yoti.mobile.android.commons.navigation.NavigationCoordinatorHost
    public DocumentSelectionCoordinator getCoordinator() {
        DocumentSelectionCoordinator documentSelectionCoordinator = this.coordinator;
        if (documentSelectionCoordinator != null) {
            return documentSelectionCoordinator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coordinator");
        return null;
    }
}
