package org.greenrobot.eventbus.util;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;

/* JADX INFO: loaded from: classes6.dex */
public class ErrorDialogFragments {
    public static int ERROR_DIALOG_ICON;
    public static Class<?> EVENT_TYPE_ON_CLICK;

    public static Dialog createDialog(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString(ErrorDialogManager.KEY_TITLE));
        builder.setMessage(bundle.getString(ErrorDialogManager.KEY_MESSAGE));
        int i = ERROR_DIALOG_ICON;
        if (i != 0) {
            builder.setIcon(i);
        }
        builder.setPositiveButton(R.string.ok, onClickListener);
        return builder.create();
    }

    public static void handleOnClick(DialogInterface dialogInterface, int i, Activity activity, Bundle bundle) {
        Class<?> cls = EVENT_TYPE_ON_CLICK;
        if (cls != null) {
            try {
                ErrorDialogManager.factory.config.getEventBus().post(cls.newInstance());
            } catch (Exception e) {
                throw new RuntimeException("Event cannot be constructed", e);
            }
        }
        if (!bundle.getBoolean(ErrorDialogManager.KEY_FINISH_AFTER_DIALOG, false) || activity == null) {
            return;
        }
        activity.finish();
    }

    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener, TraceFieldInterface {
        public Trace _nr_trace;

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
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.handleOnClick(dialogInterface, i, getActivity(), getArguments());
        }
    }

    public static class Support extends androidx.fragment.app.DialogFragment implements DialogInterface.OnClickListener, TraceFieldInterface {
        public Trace _nr_trace;

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

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.handleOnClick(dialogInterface, i, getActivity(), getArguments());
        }
    }
}
