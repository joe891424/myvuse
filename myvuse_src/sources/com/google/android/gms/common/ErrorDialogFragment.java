package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class ErrorDialogFragment extends DialogFragment implements TraceFieldInterface {
    public Trace _nr_trace;
    private Dialog zaa;
    private DialogInterface.OnCancelListener zab;
    private Dialog zac;

    public static ErrorDialogFragment newInstance(Dialog dialog) {
        return newInstance(dialog, null);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.zab;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.zaa;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.zac == null) {
            this.zac = new AlertDialog.Builder((Context) Preconditions.checkNotNull(getActivity())).create();
        }
        return this.zac;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }

    public static ErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.checkNotNull(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        errorDialogFragment.zaa = dialog2;
        if (onCancelListener != null) {
            errorDialogFragment.zab = onCancelListener;
        }
        return errorDialogFragment;
    }
}
