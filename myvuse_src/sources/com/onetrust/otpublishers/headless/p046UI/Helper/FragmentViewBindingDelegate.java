package com.onetrust.otpublishers.headless.p046UI.Helper;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import com.onetrust.otpublishers.headless.p046UI.Helper.FragmentViewBindingDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\tJ\"\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00042\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0096\u0002¢\u0006\u0002\u0010\u0014R\u0012\u0010\n\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/Helper/FragmentViewBindingDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/viewbinding/ViewBinding;", "Lkotlin/properties/ReadOnlyProperty;", "Landroidx/fragment/app/Fragment;", "fragment", "viewBindingFactory", "Lkotlin/Function1;", "Landroid/view/View;", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function1;)V", "binding", "Landroidx/viewbinding/ViewBinding;", "getFragment", "()Landroidx/fragment/app/Fragment;", "getViewBindingFactory", "()Lkotlin/jvm/functions/Function1;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KProperty;)Landroidx/viewbinding/ViewBinding;", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FragmentViewBindingDelegate<T extends ViewBinding> implements ReadOnlyProperty<Fragment, T> {

    /* JADX INFO: renamed from: a */
    public final Fragment f4158a;

    /* JADX INFO: renamed from: b */
    public final Function1<View, T> f4159b;

    /* JADX INFO: renamed from: c */
    public T f4160c;

    /* JADX INFO: renamed from: com.onetrust.otpublishers.headless.UI.Helper.FragmentViewBindingDelegate$1 */
    @Metadata(m5597d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, m5598d2 = {"com/onetrust/otpublishers/headless/UI/Helper/FragmentViewBindingDelegate$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "viewLifecycleOwnerLiveDataObserver", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/LifecycleOwner;", "getViewLifecycleOwnerLiveDataObserver", "()Landroidx/lifecycle/Observer;", "onCreate", "", "owner", "onDestroy", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class C38971 implements DefaultLifecycleObserver {

        /* JADX INFO: renamed from: a */
        public final Observer<LifecycleOwner> f4161a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ FragmentViewBindingDelegate<T> f4162b;

        public C38971(final FragmentViewBindingDelegate<T> fragmentViewBindingDelegate) {
            this.f4162b = fragmentViewBindingDelegate;
            this.f4161a = new Observer() { // from class: com.onetrust.otpublishers.headless.UI.Helper.FragmentViewBindingDelegate$1$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FragmentViewBindingDelegate.C38971.m2786a(fragmentViewBindingDelegate, (LifecycleOwner) obj);
                }
            };
        }

        /* JADX INFO: renamed from: a */
        public static final void m2786a(final FragmentViewBindingDelegate this$0, LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (lifecycleOwner == null) {
                return;
            }
            lifecycleOwner.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: com.onetrust.otpublishers.headless.UI.Helper.FragmentViewBindingDelegate$1$viewLifecycleOwnerLiveDataObserver$1$1
                @Override // androidx.lifecycle.DefaultLifecycleObserver
                public void onDestroy(LifecycleOwner owner) {
                    Intrinsics.checkNotNullParameter(owner, "owner");
                    this$0.f4160c = null;
                }
            });
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onCreate(LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.f4162b.f4158a.getViewLifecycleOwnerLiveData().observeForever(this.f4161a);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onDestroy(LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.f4162b.f4158a.getViewLifecycleOwnerLiveData().removeObserver(this.f4161a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewBindingDelegate(Fragment fragment, Function1<? super View, ? extends T> viewBindingFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewBindingFactory, "viewBindingFactory");
        this.f4158a = fragment;
        this.f4159b = viewBindingFactory;
        fragment.getLifecycle().addObserver(new C38971(this));
    }

    @Override // kotlin.properties.ReadOnlyProperty
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public T getValue(Fragment thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        T t = this.f4160c;
        if (t != null) {
            return t;
        }
        Lifecycle lifecycle = this.f4158a.getViewLifecycleOwner().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "fragment.viewLifecycleOwner.lifecycle");
        if (!lifecycle.getState().isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw new IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.");
        }
        Function1<View, T> function1 = this.f4159b;
        View viewRequireView = thisRef.requireView();
        Intrinsics.checkNotNullExpressionValue(viewRequireView, "thisRef.requireView()");
        T tInvoke = function1.invoke(viewRequireView);
        this.f4160c = tInvoke;
        return tInvoke;
    }
}
