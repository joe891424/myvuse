package com.salesforce.marketingcloud.sfmcsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorType;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SFMCSdkReceiver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/SFMCSdkReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SFMCSdkReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        BehaviorType behaviorTypeFromString;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        String str = action;
        if (StringsKt.isBlank(str)) {
            return;
        }
        final String strReplaceFirst$default = StringsKt.replaceFirst$default(str, context.getApplicationContext().getPackageName() + new Regex("."), "", false, 4, (Object) null);
        SFMCSdkLogger.INSTANCE.mo3976d("~$SFMCSdkReceiver", new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdkReceiver.onReceive.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onReceive with action: " + strReplaceFirst$default;
            }
        });
        if (!Intrinsics.areEqual(strReplaceFirst$default, "android.intent.action.MY_PACKAGE_REPLACED") || (behaviorTypeFromString = BehaviorType.INSTANCE.fromString(strReplaceFirst$default)) == null) {
            return;
        }
        SFMCSdkJobIntentService.INSTANCE.enqueueSystemBehavior(context, behaviorTypeFromString, intent.getExtras());
    }
}
