package com.salesforce.marketingcloud.messages.iam;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.salesforce.marketingcloud.C4137b;
import com.salesforce.marketingcloud.C4193k;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.InterfaceC4147e;
import com.salesforce.marketingcloud.UrlHandler;
import com.salesforce.marketingcloud.alarms.C4093b;
import com.salesforce.marketingcloud.analytics.InterfaceC4111f;
import com.salesforce.marketingcloud.behaviors.C4140c;
import com.salesforce.marketingcloud.behaviors.EnumC4138a;
import com.salesforce.marketingcloud.behaviors.InterfaceC4139b;
import com.salesforce.marketingcloud.config.C4143a;
import com.salesforce.marketingcloud.events.InterfaceC4155f;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.media.C4217o;
import com.salesforce.marketingcloud.messages.iam.InAppMessageManager;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents;
import com.salesforce.marketingcloud.sfmcsdk.components.behaviors.Behavior;
import com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorListener;
import com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorType;
import com.salesforce.marketingcloud.storage.C4374j;
import java.util.Collection;
import java.util.EnumSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class InAppMessageComponent implements InterfaceC4147e, InAppMessageManager, InterfaceC4258i, C4193k.e, InterfaceC4155f, InterfaceC4139b, BehaviorListener {
    static final String EXTRA_MESSAGE_HANDLER = "messageHandler";
    private final C4093b alarmScheduler;
    private final InterfaceC4111f analyticsListener;
    private final C4140c behaviorManager;
    private C4143a configComponent;
    private final Context context;
    private C4189l executors;
    private C4217o imageHandler;
    private final Handler messageDelayHandler;
    C4262m realInAppMessageComponent;
    private final C4374j storage;
    private final C4193k syncRouteComponent;
    private SFMCSdkComponents uSdkComponents;
    private final UrlHandler urlHandler;

    public InAppMessageComponent(Context context, C4374j c4374j, C4093b c4093b, C4193k c4193k, C4140c c4140c, C4217o c4217o, UrlHandler urlHandler, C4189l c4189l, InterfaceC4111f interfaceC4111f, C4143a c4143a) {
        this(context, c4374j, c4093b, c4193k, c4140c, c4217o, urlHandler, c4189l, interfaceC4111f, null, c4143a);
    }

    private void subscribeForBehaviours() {
        SFMCSdkComponents sFMCSdkComponents = this.uSdkComponents;
        if (sFMCSdkComponents != null) {
            sFMCSdkComponents.getBehaviorManager().registerForBehaviors(EnumSet.of(BehaviorType.APPLICATION_FOREGROUNDED, BehaviorType.APPLICATION_BACKGROUNDED), this);
        } else {
            this.behaviorManager.m3037a(this, EnumSet.of(EnumC4138a.BEHAVIOR_APP_FOREGROUNDED, EnumC4138a.BEHAVIOR_APP_BACKGROUNDED));
        }
    }

    private void unSubscribeForBehaviours() {
        SFMCSdkComponents sFMCSdkComponents = this.uSdkComponents;
        if (sFMCSdkComponents != null) {
            sFMCSdkComponents.getBehaviorManager().unregisterForAllBehaviors(this);
        }
        C4140c c4140c = this.behaviorManager;
        if (c4140c != null) {
            c4140c.m3036a(this);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InterfaceC4258i
    public boolean canDisplay(InAppMessage inAppMessage) {
        C4262m c4262m = this.realInAppMessageComponent;
        return c4262m != null && c4262m.canDisplay(inAppMessage);
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public String componentName() {
        return "InAppMessageManager";
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public JSONObject componentState() {
        C4262m c4262m = this.realInAppMessageComponent;
        if (c4262m != null) {
            return c4262m.m3782a();
        }
        return null;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public void controlChannelInit(int i) {
        if (!C4137b.m3024a(i, 4096)) {
            if (this.realInAppMessageComponent == null) {
                this.realInAppMessageComponent = new C4262m(this.context, this.storage, this.alarmScheduler, this.imageHandler, this.urlHandler, this.executors, this.analyticsListener, this.messageDelayHandler, this.configComponent);
            }
            subscribeForBehaviours();
            this.syncRouteComponent.m3444a(C4193k.d.inAppMessages, this);
            return;
        }
        this.syncRouteComponent.m3444a(C4193k.d.inAppMessages, (C4193k.e) null);
        unSubscribeForBehaviours();
        C4262m c4262m = this.realInAppMessageComponent;
        if (c4262m != null) {
            c4262m.m3789b(C4137b.m3027c(i, 4096));
            this.realInAppMessageComponent = null;
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InterfaceC4258i
    public int getStatusBarColor() {
        C4262m c4262m = this.realInAppMessageComponent;
        if (c4262m != null) {
            return c4262m.getStatusBarColor();
        }
        return 0;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InterfaceC4258i
    public Typeface getTypeface() {
        C4262m c4262m = this.realInAppMessageComponent;
        if (c4262m != null) {
            return c4262m.getTypeface();
        }
        return null;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InterfaceC4258i
    public void handleMessageFinished(InAppMessage inAppMessage, C4259j c4259j) {
        C4262m c4262m = this.realInAppMessageComponent;
        if (c4262m != null) {
            c4262m.handleMessageFinished(inAppMessage, c4259j);
        }
    }

    @Override // com.salesforce.marketingcloud.events.InterfaceC4155f
    public void handleOutcomes(Collection<String> collection) {
        C4262m c4262m = this.realInAppMessageComponent;
        if (c4262m != null) {
            c4262m.handleOutcomes(collection);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InterfaceC4258i
    public C4217o imageHandler() {
        C4262m c4262m = this.realInAppMessageComponent;
        return c4262m != null ? c4262m.imageHandler() : this.imageHandler;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public void init(InitializationStatus.C4081a c4081a, int i) {
        if (C4137b.m3026b(i, 4096)) {
            this.syncRouteComponent.m3444a(C4193k.d.inAppMessages, this);
            this.realInAppMessageComponent = new C4262m(this.context, this.storage, this.alarmScheduler, this.imageHandler, this.urlHandler, this.executors, this.analyticsListener, this.messageDelayHandler, this.configComponent);
            subscribeForBehaviours();
        }
    }

    @Override // com.salesforce.marketingcloud.behaviors.InterfaceC4139b
    public void onBehavior(EnumC4138a enumC4138a, Bundle bundle) {
        C4262m c4262m = this.realInAppMessageComponent;
        if (c4262m != null) {
            if (enumC4138a == EnumC4138a.BEHAVIOR_APP_FOREGROUNDED) {
                c4262m.m3787b();
            } else if (enumC4138a == EnumC4138a.BEHAVIOR_APP_BACKGROUNDED) {
                c4262m.m3790c();
            }
        }
    }

    @Override // com.salesforce.marketingcloud.C4193k.e
    public void onSyncReceived(C4193k.d dVar, JSONObject jSONObject) {
        C4262m c4262m = this.realInAppMessageComponent;
        if (c4262m == null || dVar != C4193k.d.inAppMessages) {
            return;
        }
        c4262m.m3784a(jSONObject);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InAppMessageManager
    public void setInAppMessageListener(InAppMessageManager.EventListener eventListener) {
        C4262m c4262m = this.realInAppMessageComponent;
        if (c4262m != null) {
            c4262m.setInAppMessageListener(eventListener);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InAppMessageManager
    public void setStatusBarColor(int i) {
        C4262m c4262m = this.realInAppMessageComponent;
        if (c4262m != null) {
            c4262m.setStatusBarColor(i);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InAppMessageManager
    public void setTypeface(Typeface typeface) {
        C4262m c4262m = this.realInAppMessageComponent;
        if (c4262m != null) {
            c4262m.setTypeface(typeface);
        }
    }

    void showMessage(InAppMessage inAppMessage) {
        C4262m c4262m = this.realInAppMessageComponent;
        if (c4262m != null) {
            c4262m.m3793d(inAppMessage);
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public void tearDown(boolean z) {
        C4262m c4262m = this.realInAppMessageComponent;
        if (c4262m != null) {
            c4262m.m3789b(false);
            this.realInAppMessageComponent = null;
        }
        C4193k c4193k = this.syncRouteComponent;
        if (c4193k != null) {
            c4193k.m3444a(C4193k.d.inAppMessages, (C4193k.e) null);
        }
        unSubscribeForBehaviours();
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InterfaceC4258i
    public UrlHandler urlHandler() {
        C4262m c4262m = this.realInAppMessageComponent;
        return c4262m != null ? c4262m.urlHandler() : this.urlHandler;
    }

    public InAppMessageComponent(Context context, C4374j c4374j, C4093b c4093b, C4193k c4193k, C4140c c4140c, C4217o c4217o, UrlHandler urlHandler, C4189l c4189l, InterfaceC4111f interfaceC4111f, SFMCSdkComponents sFMCSdkComponents, C4143a c4143a) {
        this.messageDelayHandler = new Handler(Looper.getMainLooper());
        this.context = context;
        this.storage = c4374j;
        this.alarmScheduler = c4093b;
        this.syncRouteComponent = c4193k;
        this.behaviorManager = c4140c;
        this.imageHandler = c4217o;
        this.urlHandler = urlHandler;
        this.analyticsListener = interfaceC4111f;
        this.executors = c4189l;
        this.uSdkComponents = sFMCSdkComponents;
        this.configComponent = c4143a;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorListener
    public void onBehavior(Behavior behavior) {
        C4262m c4262m = this.realInAppMessageComponent;
        if (c4262m != null) {
            if (behavior instanceof Behavior.AppForegrounded) {
                c4262m.m3787b();
            } else if (behavior instanceof Behavior.AppBackgrounded) {
                c4262m.m3790c();
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InAppMessageManager
    public void showMessage(String str) {
        C4262m c4262m = this.realInAppMessageComponent;
        if (c4262m != null) {
            c4262m.showMessage(str);
        }
    }

    InAppMessageComponent(C4262m c4262m) {
        this(null, null, null, null, null, null, null, null, null, null);
        this.realInAppMessageComponent = c4262m;
    }
}
