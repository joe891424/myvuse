package com.salesforce.marketingcloud.messages.iam;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.UrlHandler;
import com.salesforce.marketingcloud.alarms.AbstractC4092a;
import com.salesforce.marketingcloud.alarms.C4093b;
import com.salesforce.marketingcloud.analytics.InterfaceC4111f;
import com.salesforce.marketingcloud.config.C4143a;
import com.salesforce.marketingcloud.events.C4152c;
import com.salesforce.marketingcloud.events.InterfaceC4155f;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.media.C4204b;
import com.salesforce.marketingcloud.media.C4217o;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import com.salesforce.marketingcloud.messages.iam.InAppMessageManager;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.storage.InterfaceC4340c;
import com.salesforce.marketingcloud.storage.InterfaceC4371g;
import com.salesforce.marketingcloud.storage.p047db.C4350i;
import com.salesforce.marketingcloud.util.C4393l;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.m */
/* JADX INFO: loaded from: classes6.dex */
class C4262m implements InAppMessageManager, InterfaceC4258i, C4093b.b, C4204b.a, InterfaceC4155f {

    /* JADX INFO: renamed from: A */
    private static final String f5262A = "minDurationBetweenMessages";

    /* JADX INFO: renamed from: v */
    private static final int f5263v = 1;

    /* JADX INFO: renamed from: w */
    private static final int f5264w = 111;

    /* JADX INFO: renamed from: x */
    static final String f5265x = C4170g.m3197a("InAppMessageManager");

    /* JADX INFO: renamed from: y */
    private static final String f5266y = "messagesAttemptedInSession";

    /* JADX INFO: renamed from: z */
    private static final String f5267z = "maxMessagesPerSession";

    /* JADX INFO: renamed from: d */
    private final C4093b f5268d;

    /* JADX INFO: renamed from: e */
    private final UrlHandler f5269e;

    /* JADX INFO: renamed from: f */
    private final C4189l f5270f;

    /* JADX INFO: renamed from: g */
    final Context f5271g;

    /* JADX INFO: renamed from: h */
    final C4374j f5272h;

    /* JADX INFO: renamed from: i */
    final InterfaceC4111f f5273i;

    /* JADX INFO: renamed from: j */
    final Object f5274j = new Object();

    /* JADX INFO: renamed from: k */
    private final C4143a f5275k;

    /* JADX INFO: renamed from: l */
    private Typeface f5276l;

    /* JADX INFO: renamed from: m */
    private int f5277m;

    /* JADX INFO: renamed from: n */
    private C4204b f5278n;

    /* JADX INFO: renamed from: o */
    private InAppMessage f5279o;

    /* JADX INFO: renamed from: p */
    private final AtomicInteger f5280p;

    /* JADX INFO: renamed from: q */
    final AtomicInteger f5281q;

    /* JADX INFO: renamed from: r */
    final Handler f5282r;

    /* JADX INFO: renamed from: s */
    private final Handler f5283s;

    /* JADX INFO: renamed from: t */
    InAppMessageManager.EventListener f5284t;

    /* JADX INFO: renamed from: u */
    C4217o f5285u;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.m$a */
    class a extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f5286b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, String str2) {
            super(str, objArr);
            this.f5286b = str2;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            InAppMessage inAppMessageMo4079a = C4262m.this.f5272h.m4239p().mo4079a(Collections.singletonList(this.f5286b), C4262m.this.f5272h.mo4218b());
            if (inAppMessageMo4079a != null) {
                C4262m.this.m3793d(inAppMessageMo4079a);
            } else {
                C4170g.m3202a(C4262m.f5265x, "Unable to find InAppMessage for message id [%s]", this.f5286b);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.m$b */
    class b extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ InAppMessage f5288b;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.m$b$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                C4262m.this.f5284t.didShowMessage(bVar.f5288b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, InAppMessage inAppMessage) {
            super(str, objArr);
            this.f5288b = inAppMessage;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4262m.this.f5272h.m4239p().mo4080a(this.f5288b);
            C4262m.this.f5273i.mo2934a(this.f5288b);
            C4262m.this.m3792d();
            synchronized (C4262m.this.f5274j) {
                if (C4262m.this.f5284t != null) {
                    try {
                        new Handler(Looper.getMainLooper()).post(new a());
                    } catch (Exception e) {
                        C4170g.m3207b(C4262m.f5265x, e, "InAppMessage EventListener threw an exception", new Object[0]);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.m$c */
    class c extends AbstractRunnableC4184g {
        c(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4262m c4262m = C4262m.this;
            c4262m.m3783a(c4262m.f5272h.m4239p().mo4083e(C4262m.this.f5272h.mo4218b()));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.m$d */
    class d implements Runnable {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ InAppMessage f5292a;

        d(InAppMessage inAppMessage) {
            this.f5292a = inAppMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C4262m.this.f5274j) {
                InAppMessageManager.EventListener eventListener = C4262m.this.f5284t;
                if (eventListener != null) {
                    try {
                        if (!eventListener.shouldShowMessage(this.f5292a)) {
                            C4170g.m3202a(C4262m.f5265x, "InAppMessage EventListener[%s] returned false for shouldShowMessage [%s]", C4262m.this.f5284t.getClass().getName(), this.f5292a.m3690id());
                            return;
                        }
                    } catch (Exception e) {
                        C4170g.m3207b(C4262m.f5265x, e, "InAppMessage EventListener threw exception during shouldShowMessage", new Object[0]);
                    }
                }
                try {
                    Class<? extends AbstractViewOnClickListenerC4255f> clsM3781a = C4262m.this.m3781a(this.f5292a);
                    if (clsM3781a != null) {
                        C4262m c4262m = C4262m.this;
                        if (c4262m.m3785a(clsM3781a, this.f5292a, c4262m.f5271g)) {
                            C4262m.this.f5271g.startActivity(new Intent(C4262m.this.f5271g, clsM3781a).setFlags(276889600).putExtra("messageHandler", new C4260k(this.f5292a)));
                        }
                    } else {
                        C4170g.m3202a(C4262m.f5265x, "Not supported", new Object[0]);
                    }
                } catch (Exception e2) {
                    C4170g.m3207b(C4262m.f5265x, e2, "Failed to display InAppMessage [%s]", this.f5292a.m3690id());
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.m$e */
    static /* synthetic */ class e {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f5294a;

        static {
            int[] iArr = new int[InAppMessage.Type.values().length];
            f5294a = iArr;
            try {
                iArr[InAppMessage.Type.bannerTop.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5294a[InAppMessage.Type.bannerBottom.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5294a[InAppMessage.Type.modal.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5294a[InAppMessage.Type.fullImageFill.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5294a[InAppMessage.Type.full.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    C4262m(Context context, C4374j c4374j, C4093b c4093b, C4217o c4217o, UrlHandler urlHandler, C4189l c4189l, InterfaceC4111f interfaceC4111f, Handler handler, C4143a c4143a) {
        this.f5271g = context;
        this.f5272h = c4374j;
        this.f5268d = c4093b;
        this.f5285u = c4217o;
        this.f5269e = urlHandler;
        this.f5273i = interfaceC4111f;
        this.f5270f = c4189l;
        this.f5275k = c4143a;
        c4093b.m2861a(this, AbstractC4092a.a.f4323h);
        this.f5281q = new AtomicInteger();
        this.f5280p = new AtomicInteger();
        this.f5282r = new Handler(Looper.getMainLooper());
        this.f5283s = handler;
    }

    /* JADX INFO: renamed from: a */
    JSONObject m3782a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C4350i.f5612e, this.f5272h.m4239p().mo4082d(this.f5272h.mo4218b()));
            InAppMessageManager.EventListener eventListener = this.f5284t;
            if (eventListener != null) {
                jSONObject.put("eventListener", eventListener.getClass().getName());
            }
            jSONObject.put("subscriberToken", this.f5272h.mo4220c().mo3931b(InterfaceC4340c.f5568j, "null"));
            jSONObject.put("custom_font_set", this.f5276l != null);
            jSONObject.put("status_bar_color", this.f5277m);
        } catch (Exception e2) {
            C4170g.m3207b(f5265x, e2, "Unable to compile componentState for InAppMessageManager", new Object[0]);
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: b */
    void m3788b(InAppMessage inAppMessage) {
        try {
            this.f5273i.mo2938b(inAppMessage);
        } catch (Exception e2) {
            C4170g.m3207b(f5265x, e2, "Failed to log download analytics for IAM %s", inAppMessage.m3690id());
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3790c() {
        this.f5283s.removeCallbacksAndMessages(null);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InterfaceC4258i
    public boolean canDisplay(InAppMessage inAppMessage) {
        InAppMessage inAppMessage2 = this.f5279o;
        if (inAppMessage2 == null) {
            this.f5270f.m3399b().execute(new b("can_display", new Object[0], inAppMessage));
            this.f5279o = inAppMessage;
        } else if (inAppMessage != inAppMessage2) {
            C4170g.m3202a(f5265x, "In App Message [%s] not displayed because [%s] is currently being displayed", inAppMessage.m3690id(), this.f5279o.m3690id());
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: d */
    void m3793d(InAppMessage inAppMessage) {
        if (inAppMessage == null || m3791c(inAppMessage)) {
            return;
        }
        this.f5283s.postDelayed(new d(inAppMessage), TimeUnit.SECONDS.toMillis(inAppMessage.messageDelaySec()));
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InterfaceC4258i
    public int getStatusBarColor() {
        return this.f5277m;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InterfaceC4258i
    public Typeface getTypeface() {
        return this.f5276l;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InterfaceC4258i
    public void handleMessageFinished(InAppMessage inAppMessage, C4259j c4259j) {
        InAppMessage inAppMessage2 = this.f5279o;
        if (inAppMessage2 != null && inAppMessage2.m3690id().equals(inAppMessage.m3690id())) {
            InterfaceC4111f interfaceC4111f = this.f5273i;
            if (interfaceC4111f != null) {
                interfaceC4111f.mo2935a(inAppMessage, c4259j);
            }
            synchronized (this.f5274j) {
                InAppMessageManager.EventListener eventListener = this.f5284t;
                if (eventListener != null) {
                    try {
                        eventListener.didCloseMessage(inAppMessage);
                    } catch (Exception e2) {
                        C4170g.m3207b(f5265x, e2, "InAppMessageEventListener threw an exception", new Object[0]);
                    }
                }
            }
        }
        this.f5279o = null;
    }

    @Override // com.salesforce.marketingcloud.events.InterfaceC4155f
    public void handleOutcomes(Collection<String> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        String str = f5265x;
        C4170g.m3213d(str, "Resolving IAM from outcomes %s", collection.toString());
        InAppMessage inAppMessageMo4079a = this.f5272h.m4239p().mo4079a(collection, this.f5272h.mo4218b());
        if (inAppMessageMo4079a == null) {
            C4170g.m3213d(str, "No message resolved.", new Object[0]);
        } else {
            C4170g.m3213d(str, "Outcomes resolved to message[%s]", inAppMessageMo4079a.m3690id());
            m3793d(inAppMessageMo4079a);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InterfaceC4258i
    public C4217o imageHandler() {
        return this.f5285u;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InAppMessageManager
    public void setInAppMessageListener(InAppMessageManager.EventListener eventListener) {
        synchronized (this.f5274j) {
            this.f5284t = eventListener;
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InAppMessageManager
    public void setStatusBarColor(int i) {
        this.f5277m = i;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InAppMessageManager
    public void setTypeface(Typeface typeface) {
        this.f5276l = typeface;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InAppMessageManager
    public void showMessage(String str) {
        if (str == null) {
            return;
        }
        this.f5270f.m3399b().execute(new a("iam_showMessage", new Object[0], str));
    }

    @Override // com.salesforce.marketingcloud.messages.iam.InterfaceC4258i
    public UrlHandler urlHandler() {
        return this.f5269e;
    }

    /* JADX INFO: renamed from: a */
    Class<? extends AbstractViewOnClickListenerC4255f> m3781a(InAppMessage inAppMessage) {
        int i = e.f5294a[inAppMessage.type().ordinal()];
        if (i == 1 || i == 2) {
            return IamBannerActivity.class;
        }
        if (i == 3) {
            return IamModalActivity.class;
        }
        if (i == 4) {
            return IamFullImageFillActivity.class;
        }
        if (i != 5) {
            return null;
        }
        return IamFullscreenActivity.class;
    }

    /* JADX INFO: renamed from: b */
    void m3787b() {
        this.f5281q.set(0);
        this.f5280p.set(0);
        this.f5282r.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: renamed from: c */
    boolean m3791c(InAppMessage inAppMessage) {
        JSONObject jSONObject;
        int i;
        String str;
        AtomicInteger atomicInteger;
        boolean z = false;
        if (inAppMessage.displayLimitOverride()) {
            C4170g.m3202a(f5265x, "InAppMessage [%s] has displayLimit Override set. The message will not honour displayLimit settings", inAppMessage.m3690id());
            return false;
        }
        int i2 = this.f5272h.mo4222f().getInt(C4152c.f4705s, Integer.MAX_VALUE);
        try {
            jSONObject = new JSONObject();
            i = this.f5281q.get();
            str = f5267z;
            try {
            } catch (Exception e2) {
                e = e2;
                z = true;
                C4170g.m3207b(f5265x, e, "Failed to log message Debug Analytics for IAM %s", inAppMessage.m3690id());
            }
        } catch (Exception e3) {
            e = e3;
        }
        if (i < i2) {
            if (this.f5282r.hasMessages(111)) {
                jSONObject.put(f5262A, this.f5272h.mo4222f().getInt(C4152c.f4706t, 0));
                atomicInteger = this.f5280p;
            }
            if (z && this.f5275k.m3075h()) {
                this.f5273i.mo2936a(inAppMessage, jSONObject);
            }
            return z;
        }
        jSONObject.put(f5267z, this.f5272h.mo4222f().getInt(C4152c.f4705s, 0));
        str = f5266y;
        atomicInteger = this.f5280p;
        jSONObject.put(str, atomicInteger.incrementAndGet());
        z = true;
        if (z) {
            this.f5273i.mo2936a(inAppMessage, jSONObject);
        }
        return z;
    }

    /* JADX INFO: renamed from: d */
    void m3792d() {
        this.f5281q.incrementAndGet();
        int i = this.f5272h.mo4222f().getInt(C4152c.f4706t, 0);
        if (i > 0) {
            this.f5282r.sendMessageDelayed(this.f5282r.obtainMessage(111), TimeUnit.SECONDS.toMillis(i));
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3780a(String str) {
        try {
            C4393l.m4353f(str);
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: renamed from: b */
    void m3789b(boolean z) {
        this.f5268d.m2869e(AbstractC4092a.a.f4323h);
        this.f5282r.removeCallbacksAndMessages(null);
        C4204b c4204b = this.f5278n;
        if (c4204b != null) {
            c4204b.m3511b();
        }
        if (z) {
            InterfaceC4371g interfaceC4371gM4239p = this.f5272h.m4239p();
            this.f5285u.m3572a((Collection<String>) interfaceC4371gM4239p.mo4083e(this.f5272h.mo4218b()));
            interfaceC4371gM4239p.mo4077a(Collections.emptyList());
        }
    }

    @Override // com.salesforce.marketingcloud.alarms.C4093b.b
    /* JADX INFO: renamed from: a */
    public void mo2870a(AbstractC4092a.a aVar) {
        if (aVar == AbstractC4092a.a.f4323h) {
            this.f5270f.m3399b().execute(new c("iam_image_cache", new Object[0]));
        }
    }

    /* JADX INFO: renamed from: b */
    String m3786b(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("id");
        String strOptString2 = jSONObject.optString("activityInstanceId");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return "";
        }
        String strOptString3 = jSONObject.optString("endDateUtc", null);
        if (strOptString3 != null) {
            try {
                if (C4393l.m4353f(strOptString3).getTime() < System.currentTimeMillis()) {
                    return "ExpiredMessage";
                }
            } catch (Exception unused) {
                return "InvalidDate";
            }
        }
        String strOptString4 = jSONObject.optString("startDateUtc", null);
        if (strOptString4 != null && m3780a(strOptString4)) {
            return "InvalidDate";
        }
        String strOptString5 = jSONObject.optString("modifiedDateUtc", null);
        if (strOptString5 == null) {
            return "NoModifiedDate";
        }
        if (m3780a(strOptString5)) {
            return "InvalidDate";
        }
        try {
            InAppMessage.Type.valueOf(jSONObject.getString("type"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("media");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("title");
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("body");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(OTUXParamsKeys.OT_UX_BUTTONS);
            if (jSONObjectOptJSONObject == null && jSONObjectOptJSONObject2 == null && jSONObjectOptJSONObject3 == null && (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0)) {
                return "NoContent";
            }
            if (jSONObjectOptJSONObject != null) {
                Object objOpt = jSONObjectOptJSONObject.opt("url");
                if (!(objOpt instanceof String) || TextUtils.isEmpty((String) objOpt)) {
                    return "InvalidMedia";
                }
            }
            if (jSONObjectOptJSONObject2 != null && TextUtils.isEmpty(jSONObjectOptJSONObject2.optString("text", null))) {
                return "InvalidTitle";
            }
            if (jSONObjectOptJSONObject3 != null && TextUtils.isEmpty(jSONObjectOptJSONObject3.optString("text", null))) {
                return "InvalidBody";
            }
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject4 == null || TextUtils.isEmpty(jSONObjectOptJSONObject4.optString("id")) || TextUtils.isEmpty(jSONObjectOptJSONObject4.optString("text"))) {
                        return "InvalidButton";
                    }
                }
            }
            return null;
        } catch (Exception unused2) {
            return "NoMessageType";
        }
    }

    @Override // com.salesforce.marketingcloud.media.C4204b.a
    /* JADX INFO: renamed from: a */
    public void mo3512a(boolean z) {
        if (z) {
            this.f5268d.m2868d(AbstractC4092a.a.f4323h);
        } else {
            this.f5268d.m2865b(AbstractC4092a.a.f4323h);
        }
    }

    /* JADX INFO: renamed from: a */
    void m3784a(JSONObject jSONObject) {
        if (jSONObject.optInt("version") != 1) {
            C4170g.m3206b(f5265x, "Unable to handle sync payload due to version mismatch", new Object[0]);
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(FirebaseAnalytics.Param.ITEMS);
            int length = jSONArray.length();
            C4170g.m3202a(f5265x, "%d in app message(s) received from sync.", Integer.valueOf(length));
            TreeSet treeSet = new TreeSet();
            InterfaceC4371g interfaceC4371gM4239p = this.f5272h.m4239p();
            InterfaceC4384c interfaceC4384cMo4218b = this.f5272h.mo4218b();
            List<String> listMo4083e = interfaceC4371gM4239p.mo4083e(interfaceC4384cMo4218b);
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String strM3786b = m3786b(jSONObject2);
                    if (strM3786b == null) {
                        InAppMessage inAppMessage = new InAppMessage(jSONObject2);
                        if (interfaceC4371gM4239p.mo4076a(inAppMessage, interfaceC4384cMo4218b) == 1) {
                            m3788b(inAppMessage);
                        }
                        interfaceC4371gM4239p.mo4081b(inAppMessage.m3690id(), jSONObject2.optInt("displayCount", 0));
                        treeSet.add(inAppMessage.m3690id());
                    } else if (!strM3786b.isEmpty()) {
                        this.f5273i.mo2937a(jSONObject2.optString("id"), jSONObject2.optString("activityInstanceId"), Collections.singletonList(strM3786b));
                    }
                } catch (Exception e2) {
                    C4170g.m3207b(f5265x, e2, "Unable to parse in app message payload", new Object[0]);
                }
            }
            interfaceC4371gM4239p.mo4077a(treeSet);
            List<String> listMo4083e2 = interfaceC4371gM4239p.mo4083e(interfaceC4384cMo4218b);
            m3783a(listMo4083e2);
            TreeSet treeSet2 = new TreeSet(listMo4083e);
            treeSet2.removeAll(listMo4083e2);
            this.f5285u.m3572a((Collection<String>) treeSet2);
        } catch (JSONException e3) {
            C4170g.m3207b(f5265x, e3, "Unable to get InAppMessages from sync payload", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m3785a(Class<? extends AbstractViewOnClickListenerC4255f> cls, InAppMessage inAppMessage, Context context) throws ClassNotFoundException {
        return (cls == Class.forName(IamFullscreenActivity.class.getName()) && inAppMessage.type() == InAppMessage.Type.fullImageFill && context.getResources().getConfiguration().orientation != 1) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    void m3783a(List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        C4204b c4204b = this.f5278n;
        if (c4204b != null) {
            c4204b.m3511b();
        }
        C4204b c4204bM3565a = this.f5285u.m3565a(list);
        this.f5278n = c4204bM3565a;
        c4204bM3565a.m3509a(this);
    }
}
