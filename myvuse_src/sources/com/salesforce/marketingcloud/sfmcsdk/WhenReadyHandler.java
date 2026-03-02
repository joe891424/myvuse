package com.salesforce.marketingcloud.sfmcsdk;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WhenReadyHandler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/WhenReadyHandler;", "Landroid/os/Handler;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/salesforce/marketingcloud/sfmcsdk/SFMCSdkReadyListener;", "(Lcom/salesforce/marketingcloud/sfmcsdk/SFMCSdkReadyListener;)V", "getListener", "()Lcom/salesforce/marketingcloud/sfmcsdk/SFMCSdkReadyListener;", "deliverSdk", "", "sdk", "Lcom/salesforce/marketingcloud/sfmcsdk/SFMCSdk;", "execute", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class WhenReadyHandler extends Handler {
    private final SFMCSdkReadyListener listener;

    public final SFMCSdkReadyListener getListener() {
        return this.listener;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WhenReadyHandler(SFMCSdkReadyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Looper looperMyLooper = Looper.myLooper();
        super(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper);
        this.listener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: deliverSdk$lambda-0, reason: not valid java name */
    public static final void m6734deliverSdk$lambda0(WhenReadyHandler this$0, SFMCSdk sdk) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sdk, "$sdk");
        this$0.execute(sdk, this$0.listener);
    }

    public final void deliverSdk(final SFMCSdk sdk) {
        Intrinsics.checkNotNullParameter(sdk, "sdk");
        post(new Runnable() { // from class: com.salesforce.marketingcloud.sfmcsdk.WhenReadyHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WhenReadyHandler.m6734deliverSdk$lambda0(this.f$0, sdk);
            }
        });
    }

    private final void execute(SFMCSdk sdk, final SFMCSdkReadyListener listener) {
        try {
            listener.ready(sdk);
        } catch (Exception e) {
            SFMCSdkLogger.INSTANCE.mo3977e("~$WhenReadyHandler", e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.WhenReadyHandler.execute.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Error in " + listener.getClass().getName();
                }
            });
        }
    }
}
