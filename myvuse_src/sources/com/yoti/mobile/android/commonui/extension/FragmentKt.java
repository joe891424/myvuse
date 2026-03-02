package com.yoti.mobile.android.commonui.extension;

import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: Fragment.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0006\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0002H\u0086\b¢\u0006\u0002\u0010\u0006\u001a*\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00050\b\"\u0004\b\u0000\u0010\u0005*\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\n\u001aL\u0010\u000b\u001a\u0002H\u0005\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\f*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0019\b\u0002\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\b\u0014H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aD\u0010\u000b\u001a\u0002H\u0005\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\f*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0019\b\u0002\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\b\u0014H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0016\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, m5598d2 = {"isCameraPermissionGranted", "", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Z", "findCallback", ExifInterface.GPS_DIRECTION_TRUE, "(Landroidx/fragment/app/Fragment;)Ljava/lang/Object;", "viewBindingLazy", "Lkotlin/properties/ReadOnlyProperty;", "initialise", "Lkotlin/Function0;", "viewModel", "Landroidx/lifecycle/ViewModel;", "activity", "Landroidx/fragment/app/FragmentActivity;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "body", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/FragmentActivity;Landroidx/lifecycle/ViewModelProvider$Factory;Lkotlin/jvm/functions/Function1;)Landroidx/lifecycle/ViewModel;", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;Lkotlin/jvm/functions/Function1;)Landroidx/lifecycle/ViewModel;", "commonUI_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FragmentKt {
    public static /* synthetic */ ViewModel viewModel$default(Fragment fragment, FragmentActivity activity, ViewModelProvider.Factory factory, Function1 body, int i, Object obj) {
        if ((i & 4) != 0) {
            Intrinsics.needClassReification();
            body = new Function1<T, Unit>() { // from class: com.yoti.mobile.android.commonui.extension.FragmentKt.viewModel.1
                /* JADX WARN: Incorrect types in method signature: (TT;)V */
                public final void invoke(ViewModel viewModel) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                    invoke((ViewModel) obj2);
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(body, "body");
        ViewModelProvider viewModelProvider = new ViewModelProvider(activity, factory);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ViewModel viewModel = viewModelProvider.get((Class<ViewModel>) ViewModel.class);
        body.invoke(viewModel);
        return viewModel;
    }

    public static final /* synthetic */ <T extends ViewModel> T viewModel(Fragment fragment, FragmentActivity activity, ViewModelProvider.Factory factory, Function1<? super T, Unit> body) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(body, "body");
        ViewModelProvider viewModelProvider = new ViewModelProvider(activity, factory);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ViewModel viewModel = viewModelProvider.get(ViewModel.class);
        body.invoke(viewModel);
        return viewModel;
    }

    public static /* synthetic */ ViewModel viewModel$default(Fragment fragment, ViewModelProvider.Factory factory, Function1 body, int i, Object obj) {
        if ((i & 2) != 0) {
            Intrinsics.needClassReification();
            body = new Function1<T, Unit>() { // from class: com.yoti.mobile.android.commonui.extension.FragmentKt.viewModel.2
                /* JADX WARN: Incorrect types in method signature: (TT;)V */
                public final void invoke(ViewModel viewModel) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                    invoke((ViewModel) obj2);
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(body, "body");
        ViewModelProvider viewModelProvider = new ViewModelProvider(fragment, factory);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ViewModel viewModel = viewModelProvider.get((Class<ViewModel>) ViewModel.class);
        body.invoke(viewModel);
        return viewModel;
    }

    public static final /* synthetic */ <T extends ViewModel> T viewModel(Fragment fragment, ViewModelProvider.Factory factory, Function1<? super T, Unit> body) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(body, "body");
        ViewModelProvider viewModelProvider = new ViewModelProvider(fragment, factory);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ViewModel viewModel = viewModelProvider.get(ViewModel.class);
        body.invoke(viewModel);
        return viewModel;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.yoti.mobile.android.commonui.extension.FragmentKt$viewBindingLazy$1 */
    /* JADX INFO: compiled from: Fragment.kt */
    @Metadata(m5597d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003J\"\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0096\u0002¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m5598d2 = {"com/yoti/mobile/android/commonui/extension/FragmentKt$viewBindingLazy$1", "Lkotlin/properties/ReadOnlyProperty;", "Landroidx/fragment/app/Fragment;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "binding", "Ljava/lang/Object;", "viewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "onDestroy", "", "owner", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class C45931<T> implements ReadOnlyProperty<Fragment, T>, DefaultLifecycleObserver {
        final /* synthetic */ Function0<T> $initialise;
        final /* synthetic */ Fragment $this_viewBindingLazy;
        private T binding;
        private LifecycleOwner viewLifecycleOwner;

        /* JADX WARN: Multi-variable type inference failed */
        C45931(Fragment fragment, Function0<? extends T> function0) {
            this.$this_viewBindingLazy = fragment;
            this.$initialise = function0;
            fragment.getViewLifecycleOwnerLiveData().observe(fragment, new Observer() { // from class: com.yoti.mobile.android.commonui.extension.FragmentKt$viewBindingLazy$1$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FragmentKt.C45931.m6795_init_$lambda1(this.f$0, (LifecycleOwner) obj);
                }
            });
        }

        @Override // kotlin.properties.ReadOnlyProperty
        public /* bridge */ /* synthetic */ Object getValue(Fragment fragment, KProperty kProperty) {
            return getValue2(fragment, (KProperty<?>) kProperty);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: _init_$lambda-1, reason: not valid java name */
        public static final void m6795_init_$lambda1(C45931 this$0, LifecycleOwner lifecycleOwner) {
            Lifecycle lifecycle;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            LifecycleOwner lifecycleOwner2 = this$0.viewLifecycleOwner;
            if (lifecycleOwner2 != null && (lifecycle = lifecycleOwner2.getLifecycle()) != null) {
                lifecycle.removeObserver(this$0);
            }
            lifecycleOwner.getLifecycle().addObserver(this$0);
            this$0.viewLifecycleOwner = lifecycleOwner;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onDestroy(LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            super.onDestroy(owner);
            this.binding = null;
        }

        /* JADX INFO: renamed from: getValue, reason: avoid collision after fix types in other method */
        public T getValue2(Fragment thisRef, KProperty<?> property) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter(property, "property");
            if (this.$this_viewBindingLazy.getView() == null) {
                throw new IllegalArgumentException("Attempted to use ViewBinding before onCreateView or after onDestroyView".toString());
            }
            T t = this.binding;
            if (t != null) {
                return t;
            }
            T tInvoke = this.$initialise.invoke();
            this.binding = tInvoke;
            return tInvoke;
        }
    }

    public static final <T> ReadOnlyProperty<Fragment, T> viewBindingLazy(Fragment fragment, Function0<? extends T> initialise) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(initialise, "initialise");
        return new C45931(fragment, initialise);
    }

    public static final /* synthetic */ <T> T findCallback(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Sequence sequencePlus = SequencesKt.plus((Sequence<? extends FragmentActivity>) SequencesKt.generateSequence(fragment, new Function1<Fragment, Fragment>() { // from class: com.yoti.mobile.android.commonui.extension.FragmentKt.findCallback.1
            @Override // kotlin.jvm.functions.Function1
            public final Fragment invoke(Fragment it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                return it2.getParentFragment();
            }
        }), fragment.getActivity());
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) SequencesKt.firstOrNull(SequencesKt.filterIsInstance(sequencePlus, Object.class));
    }

    public static final boolean isCameraPermissionGranted(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return ContextCompat.checkSelfPermission(fragment.requireContext(), "android.permission.CAMERA") == 0;
    }
}
