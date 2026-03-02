package p000a.p001a.p002a.p003a.p014b.DataModels;

import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000a.p001a.p002a.p003a.p014b.p021e.C0104a0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;
import p000a.p001a.p002a.p003a.p014b.p021e.C0128v;

/* JADX INFO: renamed from: a.a.a.a.b.a.h, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u000fHÆ\u0003J\t\u00102\u001a\u00020\u000fHÆ\u0003J\t\u00103\u001a\u00020\u0012HÆ\u0003J\t\u00104\u001a\u00020\u000fHÆ\u0003J\t\u00105\u001a\u00020\u0015HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J»\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001J\u0013\u0010@\u001a\u00020\u00032\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020CHÖ\u0001J\t\u0010D\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0013\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001c¨\u0006E"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/DataModels/SDKListData;", "", "showSdkDescription", "", OTUXParamsKeys.OT_UX_BACK_BUTTON_COLOR, "", "backgroundColor", OTUXParamsKeys.OT_UX_FILTER_COLOR_ON, OTUXParamsKeys.OT_UX_FILTER_COLOR_OFF, "dividerColor", OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_ON, OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_OFF, OTUXParamsKeys.OT_UX_TOGGLE_TRACK_COLOR, "consentLabel", "summaryTitle", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/TextProperty;", "summaryDescription", "searchBarProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/SearchBarProperty;", "allowAllToggleTextProperty", "otSdkListUIProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTSDKListUIProperty;", "otPCUIProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTPCUIProperty;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/onetrust/otpublishers/headless/UI/UIProperty/TextProperty;Lcom/onetrust/otpublishers/headless/UI/UIProperty/TextProperty;Lcom/onetrust/otpublishers/headless/UI/UIProperty/SearchBarProperty;Lcom/onetrust/otpublishers/headless/UI/UIProperty/TextProperty;Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTSDKListUIProperty;Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTPCUIProperty;)V", "getAllowAllToggleTextProperty", "()Lcom/onetrust/otpublishers/headless/UI/UIProperty/TextProperty;", "getBackButtonColor", "()Ljava/lang/String;", "getBackgroundColor", "getConsentLabel", "getDividerColor", "getFilterOffColor", "getFilterOnColor", "getOtPCUIProperty", "()Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTPCUIProperty;", "getOtSdkListUIProperty", "()Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTSDKListUIProperty;", "getSearchBarProperty", "()Lcom/onetrust/otpublishers/headless/UI/UIProperty/SearchBarProperty;", "getShowSdkDescription", "()Z", "getSummaryDescription", "getSummaryTitle", "getToggleThumbColorOff", "getToggleThumbColorOn", "getToggleTrackColor", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class SDKListData {

    /* JADX INFO: renamed from: a */
    public final boolean f182a;

    /* JADX INFO: renamed from: b */
    public final String f183b;

    /* JADX INFO: renamed from: c */
    public final String f184c;

    /* JADX INFO: renamed from: d */
    public final String f185d;

    /* JADX INFO: renamed from: e */
    public final String f186e;

    /* JADX INFO: renamed from: f */
    public final String f187f;

    /* JADX INFO: renamed from: g */
    public final String f188g;

    /* JADX INFO: renamed from: h */
    public final String f189h;

    /* JADX INFO: renamed from: i */
    public final String f190i;

    /* JADX INFO: renamed from: j */
    public final String f191j;

    /* JADX INFO: renamed from: k */
    public final C0106b0 f192k;

    /* JADX INFO: renamed from: l */
    public final C0106b0 f193l;

    /* JADX INFO: renamed from: m */
    public final C0104a0 f194m;

    /* JADX INFO: renamed from: n */
    public final C0106b0 f195n;

    /* JADX INFO: renamed from: o */
    public final C0128v f196o;

    /* JADX INFO: renamed from: p */
    public final C0126t f197p;

    public SDKListData(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String consentLabel, C0106b0 summaryTitle, C0106b0 summaryDescription, C0104a0 searchBarProperty, C0106b0 allowAllToggleTextProperty, C0128v otSdkListUIProperty, C0126t c0126t) {
        Intrinsics.checkNotNullParameter(consentLabel, "consentLabel");
        Intrinsics.checkNotNullParameter(summaryTitle, "summaryTitle");
        Intrinsics.checkNotNullParameter(summaryDescription, "summaryDescription");
        Intrinsics.checkNotNullParameter(searchBarProperty, "searchBarProperty");
        Intrinsics.checkNotNullParameter(allowAllToggleTextProperty, "allowAllToggleTextProperty");
        Intrinsics.checkNotNullParameter(otSdkListUIProperty, "otSdkListUIProperty");
        this.f182a = z;
        this.f183b = str;
        this.f184c = str2;
        this.f185d = str3;
        this.f186e = str4;
        this.f187f = str5;
        this.f188g = str6;
        this.f189h = str7;
        this.f190i = str8;
        this.f191j = consentLabel;
        this.f192k = summaryTitle;
        this.f193l = summaryDescription;
        this.f194m = searchBarProperty;
        this.f195n = allowAllToggleTextProperty;
        this.f196o = otSdkListUIProperty;
        this.f197p = c0126t;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SDKListData)) {
            return false;
        }
        SDKListData sDKListData = (SDKListData) other;
        return this.f182a == sDKListData.f182a && Intrinsics.areEqual(this.f183b, sDKListData.f183b) && Intrinsics.areEqual(this.f184c, sDKListData.f184c) && Intrinsics.areEqual(this.f185d, sDKListData.f185d) && Intrinsics.areEqual(this.f186e, sDKListData.f186e) && Intrinsics.areEqual(this.f187f, sDKListData.f187f) && Intrinsics.areEqual(this.f188g, sDKListData.f188g) && Intrinsics.areEqual(this.f189h, sDKListData.f189h) && Intrinsics.areEqual(this.f190i, sDKListData.f190i) && Intrinsics.areEqual(this.f191j, sDKListData.f191j) && Intrinsics.areEqual(this.f192k, sDKListData.f192k) && Intrinsics.areEqual(this.f193l, sDKListData.f193l) && Intrinsics.areEqual(this.f194m, sDKListData.f194m) && Intrinsics.areEqual(this.f195n, sDKListData.f195n) && Intrinsics.areEqual(this.f196o, sDKListData.f196o) && Intrinsics.areEqual(this.f197p, sDKListData.f197p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    public int hashCode() {
        boolean z = this.f182a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.f183b;
        int iHashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f184c;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f185d;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f186e;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f187f;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f188g;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f189h;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f190i;
        int iHashCode8 = (((((((((((((iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31) + this.f191j.hashCode()) * 31) + this.f192k.hashCode()) * 31) + this.f193l.hashCode()) * 31) + this.f194m.hashCode()) * 31) + this.f195n.hashCode()) * 31) + this.f196o.hashCode()) * 31;
        C0126t c0126t = this.f197p;
        return iHashCode8 + (c0126t != null ? c0126t.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SDKListData(showSdkDescription=");
        sb.append(this.f182a).append(", backButtonColor=").append(this.f183b).append(", backgroundColor=").append(this.f184c).append(", filterOnColor=").append(this.f185d).append(", filterOffColor=").append(this.f186e).append(", dividerColor=").append(this.f187f).append(", toggleThumbColorOn=").append(this.f188g).append(", toggleThumbColorOff=").append(this.f189h).append(", toggleTrackColor=").append(this.f190i).append(", consentLabel=").append(this.f191j).append(", summaryTitle=").append(this.f192k).append(", summaryDescription=");
        sb.append(this.f193l).append(", searchBarProperty=").append(this.f194m).append(", allowAllToggleTextProperty=").append(this.f195n).append(", otSdkListUIProperty=").append(this.f196o).append(", otPCUIProperty=").append(this.f197p).append(')');
        return sb.toString();
    }
}
