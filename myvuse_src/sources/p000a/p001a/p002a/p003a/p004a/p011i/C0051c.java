package p000a.p001a.p002a.p003a.p004a.p011i;

import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTCallback;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.Response.OTResponse;

/* JADX INFO: renamed from: a.a.a.a.a.i.c */
/* JADX INFO: loaded from: classes.dex */
public class C0051c implements OTCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ OTCallback f105a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f106b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ OTPublishersHeadlessSDK f107c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C0052d f108d;

    public C0051c(C0052d c0052d, OTCallback oTCallback, String str, OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        this.f108d = c0052d;
        this.f105a = oTCallback;
        this.f106b = str;
        this.f107c = oTPublishersHeadlessSDK;
    }

    @Override // com.onetrust.otpublishers.headless.Public.OTCallback
    public void onFailure(OTResponse oTResponse) {
        this.f108d.m332a(this.f106b, this.f107c, this.f105a);
    }

    @Override // com.onetrust.otpublishers.headless.Public.OTCallback
    public void onSuccess(OTResponse oTResponse) {
        OTLogger.m2743a(3, "MultiprofileConsent", "Switch profile with data download successful, returning app callback.");
        OTCallback oTCallback = this.f105a;
        if (oTCallback != null) {
            oTCallback.onSuccess(oTResponse);
        }
    }
}
