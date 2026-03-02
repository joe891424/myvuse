package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.facebook.react.C1848R;

/* JADX INFO: loaded from: classes3.dex */
public class LogBoxDialog extends Dialog {
    public LogBoxDialog(Activity activity, View view) {
        super(activity, C1848R.style.Theme_Catalyst_LogBox);
        requestWindowFeature(1);
        setContentView(view);
    }
}
