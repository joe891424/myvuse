package com.salesforce.marketingcloud;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.salesforce.marketingcloud.behaviors.EnumC4138a;

/* JADX INFO: loaded from: classes6.dex */
public class MCReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    public static final String f4227a = "com.salesforce.marketingcloud.WAKE_FOR_ALARM";

    /* JADX INFO: renamed from: b */
    private static final String f4228b = "alarmName";

    /* JADX INFO: renamed from: c */
    private static final String f4229c = C4170g.m3197a("MCReceiver");

    /* JADX INFO: renamed from: a */
    public static Intent m2813a(Context context, String str) {
        return new Intent(context, (Class<?>) MCReceiver.class).setAction(context.getApplicationContext().getPackageName() + ".com.salesforce.marketingcloud.WAKE_FOR_ALARM").putExtra(f4228b, str);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String strReplaceFirst;
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            C4170g.m3202a(f4229c, "Action was empty %s", intent.toString());
        }
        strReplaceFirst = action.replaceFirst(context.getApplicationContext().getPackageName() + ".", "");
        C4170g.m3213d(f4229c, "onReceive with action: %s", strReplaceFirst);
        strReplaceFirst.hashCode();
        strReplaceFirst.hashCode();
        switch (strReplaceFirst) {
            case "android.intent.action.AIRPLANE_MODE":
            case "android.intent.action.TIMEZONE_CHANGED":
            case "android.intent.action.BOOT_COMPLETED":
            case "android.intent.action.MY_PACKAGE_REPLACED":
            case "android.intent.action.ACTION_SHUTDOWN":
                EnumC4138a enumC4138aM3033a = EnumC4138a.m3033a(strReplaceFirst);
                if (enumC4138aM3033a != null) {
                    MCService.m2814a(context, enumC4138aM3033a, intent.getExtras());
                    break;
                }
                break;
            case "com.salesforce.marketingcloud.WAKE_FOR_ALARM":
                MCService.m2816a(context, intent.getStringExtra(f4228b));
                break;
        }
    }
}
