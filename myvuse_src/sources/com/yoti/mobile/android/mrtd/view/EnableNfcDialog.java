package com.yoti.mobile.android.mrtd.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.mrtd.C4900R;
import com.yoti.mobile.android.mrtd.databinding.YdsDialogEnableNfcBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/EnableNfcDialog;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "()V", "binding", "Lcom/yoti/mobile/android/mrtd/databinding/YdsDialogEnableNfcBinding;", "getBinding", "()Lcom/yoti/mobile/android/mrtd/databinding/YdsDialogEnableNfcBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "host", "Lcom/yoti/mobile/android/mrtd/view/NfcDialogHost;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", "view", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class EnableNfcDialog extends AppCompatDialogFragment implements TraceFieldInterface {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(EnableNfcDialog.class, "binding", "getBinding()Lcom/yoti/mobile/android/mrtd/databinding/YdsDialogEnableNfcBinding;", 0))};
    public Trace _nr_trace;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding = FragmentKt.viewBindingLazy(this, new Function0<YdsDialogEnableNfcBinding>() { // from class: com.yoti.mobile.android.mrtd.view.EnableNfcDialog$binding$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final YdsDialogEnableNfcBinding invoke() {
            return YdsDialogEnableNfcBinding.bind(this.this$0.requireView());
        }
    });
    private NfcDialogHost host;

    private final YdsDialogEnableNfcBinding getBinding() {
        return (YdsDialogEnableNfcBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-3$lambda-1, reason: not valid java name */
    public static final void m6890onViewCreated$lambda3$lambda1(EnableNfcDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-3$lambda-2, reason: not valid java name */
    public static final void m6891onViewCreated$lambda3$lambda2(EnableNfcDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NfcDialogHost nfcDialogHost = this$0.host;
        if (nfcDialogHost == null) {
            Intrinsics.throwUninitializedPropertyAccessException("host");
            nfcDialogHost = null;
        }
        nfcDialogHost.startNfcSettings();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(context instanceof NfcDialogHost)) {
            throw new IllegalStateException("Host must implement NfcDialogHost".toString());
        }
        this.host = (NfcDialogHost) context;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "EnableNfcDialog#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "EnableNfcDialog#onCreateView", null);
        }
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(C4900R.layout.yds_dialog_enable_nfc, container, false);
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        NfcDialogHost nfcDialogHost = this.host;
        if (nfcDialogHost == null) {
            Intrinsics.throwUninitializedPropertyAccessException("host");
            nfcDialogHost = null;
        }
        nfcDialogHost.onNfcEnableDismissed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        YdsDialogEnableNfcBinding binding = getBinding();
        binding.dismissButton.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.mrtd.view.EnableNfcDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EnableNfcDialog.m6890onViewCreated$lambda3$lambda1(this.f$0, view2);
            }
        });
        binding.startSettingsButton.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.mrtd.view.EnableNfcDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EnableNfcDialog.m6891onViewCreated$lambda3$lambda2(this.f$0, view2);
            }
        });
    }
}
