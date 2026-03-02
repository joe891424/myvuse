package com.yoti.mobile.android.commonui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavArgsLazy;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: YotiDocsDialogFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/YotiDocsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "fragmentArgs", "Lcom/yoti/mobile/android/commonui/YotiDocsDialogFragmentArgs;", "getFragmentArgs", "()Lcom/yoti/mobile/android/commonui/YotiDocsDialogFragmentArgs;", "fragmentArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "getAlertDialogTheme", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "DialogListener", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class YotiDocsDialogFragment extends DialogFragment implements TraceFieldInterface {
    private static final String ARG_DIALOG_TYPE = "ydsDialogType";
    private static final String ARG_NEGATIVE_BUTTON_TEXT = "ydsDialogNegativeButtonText";
    private static final String ARG_POSITIVE_BUTTON_TEXT = "ydsDialogPositiveButtonText";
    private static final String ARG_TEXT = "ydsDialogText";
    private static final String ARG_TITLE = "ydsDialogTitle";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int NO_TEXT = 0;
    public Trace _nr_trace;

    /* JADX INFO: renamed from: fragmentArgs$delegate, reason: from kotlin metadata */
    private final NavArgsLazy fragmentArgs;

    /* JADX INFO: compiled from: YotiDocsDialogFragment.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/YotiDocsDialogFragment$DialogListener;", "", "onNegativeButtonClick", "", "dialogTag", "", "onPositiveButtonClick", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public interface DialogListener {

        /* JADX INFO: compiled from: YotiDocsDialogFragment.kt */
        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class DefaultImpls {
            public static void onNegativeButtonClick(DialogListener dialogListener, String dialogTag) {
                Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
            }

            public static void onPositiveButtonClick(DialogListener dialogListener, String dialogTag) {
                Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
            }
        }

        void onNegativeButtonClick(String dialogTag);

        void onPositiveButtonClick(String dialogTag);
    }

    /* JADX INFO: compiled from: YotiDocsDialogFragment.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DialogType.values().length];
            iArr[DialogType.DEFAULT.ordinal()] = 1;
            iArr[DialogType.DESTRUCTIVE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
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

    public YotiDocsDialogFragment() {
        final YotiDocsDialogFragment yotiDocsDialogFragment = this;
        this.fragmentArgs = new NavArgsLazy(Reflection.getOrCreateKotlinClass(YotiDocsDialogFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.commonui.YotiDocsDialogFragment$special$$inlined$navArgs$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bundle invoke() {
                Bundle arguments = yotiDocsDialogFragment.getArguments();
                if (arguments != null) {
                    return arguments;
                }
                throw new IllegalStateException("Fragment " + yotiDocsDialogFragment + " has null arguments");
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final YotiDocsDialogFragmentArgs getFragmentArgs() {
        return (YotiDocsDialogFragmentArgs) this.fragmentArgs.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final DialogListener dialogListener;
        ActivityResultCaller parentFragment;
        try {
            parentFragment = getParentFragment();
        } catch (ClassCastException unused) {
            KeyEventDispatcher.Component activity = getActivity();
            if (activity == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener");
            }
            dialogListener = (DialogListener) activity;
        }
        if (parentFragment == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener");
        }
        dialogListener = (DialogListener) parentFragment;
        setCancelable(false);
        YotiDocsDialogFragmentArgs fragmentArgs = getFragmentArgs();
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext(), getAlertDialogTheme());
        Integer numValueOf = Integer.valueOf(fragmentArgs.getYdsDialogTitle());
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            builder.setTitle(getString(numValueOf.intValue()));
        }
        builder.setMessage(getString(fragmentArgs.getYdsDialogText()));
        builder.setPositiveButton(getString(fragmentArgs.getYdsDialogPositiveButtonText()), new DialogInterface.OnClickListener() { // from class: com.yoti.mobile.android.commonui.YotiDocsDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                YotiDocsDialogFragment.m6793onCreateDialog$lambda7$lambda6$lambda2(dialogListener, this, dialogInterface, i);
            }
        });
        Integer numValueOf2 = Integer.valueOf(fragmentArgs.getYdsDialogNegativeButtonText());
        Integer num = numValueOf2.intValue() != 0 ? numValueOf2 : null;
        if (num != null) {
            builder.setNegativeButton(num.intValue(), new DialogInterface.OnClickListener() { // from class: com.yoti.mobile.android.commonui.YotiDocsDialogFragment$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    YotiDocsDialogFragment.m6794onCreateDialog$lambda7$lambda6$lambda5$lambda4(dialogListener, this, dialogInterface, i);
                }
            });
        }
        AlertDialog alertDialogCreate = builder.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "with(fragmentArgs) {\n   …)\n            }\n        }");
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onCreateDialog$lambda-7$lambda-6$lambda-2, reason: not valid java name */
    public static final void m6793onCreateDialog$lambda7$lambda6$lambda2(DialogListener listener, YotiDocsDialogFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String tag = this$0.getTag();
        if (tag == null) {
            tag = "";
        }
        listener.onPositiveButtonClick(tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onCreateDialog$lambda-7$lambda-6$lambda-5$lambda-4, reason: not valid java name */
    public static final void m6794onCreateDialog$lambda7$lambda6$lambda5$lambda4(DialogListener listener, YotiDocsDialogFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String tag = this$0.getTag();
        if (tag == null) {
            tag = "";
        }
        listener.onNegativeButtonClick(tag);
    }

    private final int getAlertDialogTheme() {
        int i = WhenMappings.$EnumSwitchMapping$0[getFragmentArgs().getYdsDialogType().ordinal()];
        if (i == 1) {
            return C4590R.style.Yds_AlertDialogTheme;
        }
        if (i == 2) {
            return C4590R.style.Yds_AlertDialogTheme_DestructiveAction;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: YotiDocsDialogFragment.kt */
    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J?\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u000f\u001a\u00020\n2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/YotiDocsDialogFragment$Companion;", "", "()V", "ARG_DIALOG_TYPE", "", "ARG_NEGATIVE_BUTTON_TEXT", "ARG_POSITIVE_BUTTON_TEXT", "ARG_TEXT", "ARG_TITLE", "NO_TEXT", "", "newInstance", "Lcom/yoti/mobile/android/commonui/YotiDocsDialogFragment;", "title", "text", "positiveButtonText", "negativeButtonText", "dialogType", "Lcom/yoti/mobile/android/commonui/DialogType;", "(IIILjava/lang/Integer;Lcom/yoti/mobile/android/commonui/DialogType;)Lcom/yoti/mobile/android/commonui/YotiDocsDialogFragment;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ YotiDocsDialogFragment newInstance$default(Companion companion, int i, int i2, int i3, Integer num, DialogType dialogType, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = 0;
            }
            int i5 = i;
            if ((i4 & 8) != 0) {
                num = null;
            }
            Integer num2 = num;
            if ((i4 & 16) != 0) {
                dialogType = DialogType.DEFAULT;
            }
            return companion.newInstance(i5, i2, i3, num2, dialogType);
        }

        public final YotiDocsDialogFragment newInstance(int title, int text, int positiveButtonText, Integer negativeButtonText, DialogType dialogType) {
            Intrinsics.checkNotNullParameter(dialogType, "dialogType");
            YotiDocsDialogFragment yotiDocsDialogFragment = new YotiDocsDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(YotiDocsDialogFragment.ARG_TITLE, title);
            bundle.putInt(YotiDocsDialogFragment.ARG_TEXT, text);
            bundle.putInt(YotiDocsDialogFragment.ARG_POSITIVE_BUTTON_TEXT, positiveButtonText);
            if (negativeButtonText != null) {
                bundle.putInt(YotiDocsDialogFragment.ARG_NEGATIVE_BUTTON_TEXT, negativeButtonText.intValue());
            }
            bundle.putSerializable(YotiDocsDialogFragment.ARG_DIALOG_TYPE, dialogType);
            yotiDocsDialogFragment.setArguments(bundle);
            return yotiDocsDialogFragment;
        }
    }
}
