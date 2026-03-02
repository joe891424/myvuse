package com.yoti.mobile.android.common.p049ui.widgets.utils;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5598d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/fragment/app/Fragment;", "Lkotlin/Function0;", "initialise", "Lkotlin/properties/ReadOnlyProperty;", "viewBindingLazy", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function0;)Lkotlin/properties/ReadOnlyProperty;", "uiWidgets_release"}, m5599k = 2, m5600mv = {1, 4, 2})
public final class ViewBindingLazyKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.utils.ViewBindingLazyKt$viewBindingLazy$1 */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\n\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00022\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, m5598d2 = {"com/yoti/mobile/android/common/ui/widgets/utils/ViewBindingLazyKt$viewBindingLazy$1", "Lkotlin/properties/ReadOnlyProperty;", "Landroidx/fragment/app/Fragment;", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroy", "()V", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "b", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "a", "Ljava/lang/Object;", "binding", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final class C45641<T> implements ReadOnlyProperty<Fragment, T>, LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private T binding;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private LifecycleOwner viewLifecycleOwner;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ Fragment f6493c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ Function0 f6494d;

        /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.utils.ViewBindingLazyKt$viewBindingLazy$1$a */
        static final class a<T> implements Observer<LifecycleOwner> {
            a() {
            }

            @Override // androidx.lifecycle.Observer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(LifecycleOwner it2) {
                Lifecycle lifecycle;
                LifecycleOwner lifecycleOwner = C45641.this.viewLifecycleOwner;
                if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                    lifecycle.removeObserver(C45641.this);
                }
                C45641 c45641 = C45641.this;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                it2.getLifecycle().addObserver(C45641.this);
                c45641.viewLifecycleOwner = it2;
            }
        }

        C45641(Fragment fragment, Function0 function0) {
            this.f6493c = fragment;
            this.f6494d = function0;
            fragment.getViewLifecycleOwnerLiveData().observe(fragment, new a());
        }

        /* JADX INFO: renamed from: getValue, reason: avoid collision after fix types in other method */
        public T getValue2(Fragment thisRef, KProperty<?> property) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter(property, "property");
            if (this.f6493c.getView() == null) {
                throw new IllegalArgumentException("Attempted to use ViewBinding before onCreateView or after onDestroyView".toString());
            }
            T t = this.binding;
            if (t != null) {
                return t;
            }
            T t2 = (T) this.f6494d.invoke();
            this.binding = t2;
            return t2;
        }

        @Override // kotlin.properties.ReadOnlyProperty
        public /* bridge */ /* synthetic */ Object getValue(Fragment fragment, KProperty kProperty) {
            return getValue2(fragment, (KProperty<?>) kProperty);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            this.binding = null;
        }
    }

    public static final <T> ReadOnlyProperty<Fragment, T> viewBindingLazy(Fragment viewBindingLazy, Function0<? extends T> initialise) {
        Intrinsics.checkNotNullParameter(viewBindingLazy, "$this$viewBindingLazy");
        Intrinsics.checkNotNullParameter(initialise, "initialise");
        return new C45641(viewBindingLazy, initialise);
    }
}
