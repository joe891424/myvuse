package com.salesforce.marketingcloud.messages.iam;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.UrlHandler;
import com.salesforce.marketingcloud.media.C4217o;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import java.util.Date;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.k */
/* JADX INFO: loaded from: classes6.dex */
class C4260k implements Parcelable {
    public static final Parcelable.Creator<C4260k> CREATOR = new a();

    /* JADX INFO: renamed from: g */
    private static final String f5254g = C4170g.m3197a("MessageHandler");

    /* JADX INFO: renamed from: a */
    private final InAppMessage f5255a;

    /* JADX INFO: renamed from: b */
    private InterfaceC4258i f5256b;

    /* JADX INFO: renamed from: c */
    private long f5257c;

    /* JADX INFO: renamed from: d */
    private long f5258d;

    /* JADX INFO: renamed from: e */
    private long f5259e;

    /* JADX INFO: renamed from: f */
    private boolean f5260f;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.k$a */
    class a implements Parcelable.Creator<C4260k> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C4260k createFromParcel(Parcel parcel) {
            return new C4260k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C4260k[] newArray(int i) {
            return new C4260k[i];
        }
    }

    protected C4260k(Parcel parcel) {
        this((InAppMessage) parcel.readParcelable(InAppMessage.class.getClassLoader()));
        this.f5257c = parcel.readLong();
        this.f5258d = parcel.readLong();
        this.f5260f = parcel.readInt() == 1;
    }

    /* JADX INFO: renamed from: h */
    private void m3765h() {
        if (this.f5260f) {
            this.f5258d += SystemClock.elapsedRealtime() - this.f5259e;
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m3768a() {
        InterfaceC4258i interfaceC4258i;
        InAppMessage inAppMessage = this.f5255a;
        return (inAppMessage == null || (interfaceC4258i = this.f5256b) == null || !interfaceC4258i.canDisplay(inAppMessage)) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    public long m3769b() {
        return this.f5258d;
    }

    /* JADX INFO: renamed from: c */
    Date m3770c() {
        return new Date(this.f5257c);
    }

    /* JADX INFO: renamed from: d */
    public InAppMessage m3771d() {
        return this.f5255a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: renamed from: e */
    public C4217o m3772e() {
        InterfaceC4258i interfaceC4258i = this.f5256b;
        if (interfaceC4258i != null) {
            return interfaceC4258i.imageHandler();
        }
        return null;
    }

    /* JADX INFO: renamed from: f */
    void m3773f() {
        m3765h();
    }

    /* JADX INFO: renamed from: g */
    void m3774g() {
        if (this.f5257c == -1) {
            this.f5257c = System.currentTimeMillis();
        }
        this.f5259e = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: renamed from: i */
    int m3775i() {
        InterfaceC4258i interfaceC4258i = this.f5256b;
        if (interfaceC4258i != null) {
            return interfaceC4258i.getStatusBarColor();
        }
        return 0;
    }

    /* JADX INFO: renamed from: j */
    void m3776j() {
        m3765h();
        this.f5260f = false;
    }

    /* JADX INFO: renamed from: k */
    public Typeface m3777k() {
        InterfaceC4258i interfaceC4258i = this.f5256b;
        if (interfaceC4258i != null) {
            return interfaceC4258i.getTypeface();
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f5255a, i);
        parcel.writeLong(this.f5257c);
        parcel.writeLong(this.f5258d);
        parcel.writeInt(this.f5260f ? 1 : 0);
    }

    C4260k(InAppMessage inAppMessage) {
        MarketingCloudSdk marketingCloudSdk;
        this.f5257c = -1L;
        this.f5260f = true;
        this.f5255a = inAppMessage;
        if ((MarketingCloudSdk.isInitializing() || MarketingCloudSdk.isReady()) && (marketingCloudSdk = MarketingCloudSdk.getInstance()) != null) {
            this.f5256b = (InterfaceC4258i) marketingCloudSdk.getInAppMessageManager();
        }
    }

    /* JADX INFO: renamed from: a */
    void m3767a(C4259j c4259j) {
        InterfaceC4258i interfaceC4258i = this.f5256b;
        if (interfaceC4258i != null) {
            InAppMessage inAppMessage = this.f5255a;
            if (c4259j == null) {
                c4259j = C4259j.m3758e();
            }
            interfaceC4258i.handleMessageFinished(inAppMessage, c4259j);
        }
    }

    /* JADX INFO: renamed from: a */
    PendingIntent m3766a(Context context, InAppMessage.Button button) {
        UrlHandler urlHandler;
        String strAction = button.action();
        if (button.actionType() == InAppMessage.Button.ActionType.url && strAction != null && (urlHandler = this.f5256b.urlHandler()) != null) {
            try {
                return urlHandler.handleUrl(context, strAction, UrlHandler.ACTION);
            } catch (Exception e) {
                C4170g.m3207b(f5254g, e, "Exception thrown by %s while handling url", urlHandler.getClass().getName());
            }
        }
        return null;
    }
}
