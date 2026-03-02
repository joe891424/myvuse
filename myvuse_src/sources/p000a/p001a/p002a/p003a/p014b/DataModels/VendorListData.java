package p000a.p001a.p002a.p003a.p014b.DataModels;

import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000a.p001a.p002a.p003a.p014b.p021e.C0104a0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;
import p000a.p001a.p002a.p003a.p014b.p021e.C0127u;
import p000a.p001a.p002a.p003a.p014b.p021e.C0132z;

/* JADX INFO: renamed from: a.a.a.a.b.a.k, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u0010\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010!J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0010HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0013HÆ\u0003J\t\u0010E\u001a\u00020\u0015HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u001cHÆ\u0003J\t\u0010M\u001a\u00020\u0010HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010V\u001a\u00020\rHÆ\u0003J\u008f\u0002\u0010W\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010X\u001a\u00020\u00132\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020[HÖ\u0001J\t\u0010\\\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u001d\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010.R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b?\u0010#¨\u0006]"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorListData;", "", "pcBackgroundColor", "", "vendorListUIProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTVendorListUIProperty;", OTUXParamsKeys.OT_UX_FILTER_COLOR_ON, OTUXParamsKeys.OT_UX_FILTER_COLOR_OFF, "dividerColor", OTUXParamsKeys.OT_UX_TOGGLE_TRACK_COLOR, "toggleThumbOnColor", "toggleThumbOffColor", "confirmMyChoiceProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/ButtonProperty;", "pcButtonTextColor", "vlTitleTextProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/TextProperty;", "pcTextColor", "isGeneralVendorToggleEnabled", "", "searchBarProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/SearchBarProperty;", "iabVendorsTitle", "googleVendorsTitle", "consentLabel", OTUXParamsKeys.OT_UX_BACK_BUTTON_COLOR, "pcButtonColor", "vlPageHeaderTitle", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTPageHeaderProperty;", "allowAllToggleTextProperty", "otPCUIProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTPCUIProperty;", OTUXParamsKeys.OT_UX_RIGHT_CHEVRON_COLOR, "(Ljava/lang/String;Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTVendorListUIProperty;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/onetrust/otpublishers/headless/UI/UIProperty/ButtonProperty;Ljava/lang/String;Lcom/onetrust/otpublishers/headless/UI/UIProperty/TextProperty;Ljava/lang/String;ZLcom/onetrust/otpublishers/headless/UI/UIProperty/SearchBarProperty;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTPageHeaderProperty;Lcom/onetrust/otpublishers/headless/UI/UIProperty/TextProperty;Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTPCUIProperty;Ljava/lang/String;)V", "getAllowAllToggleTextProperty", "()Lcom/onetrust/otpublishers/headless/UI/UIProperty/TextProperty;", "getBackButtonColor", "()Ljava/lang/String;", "getConfirmMyChoiceProperty", "()Lcom/onetrust/otpublishers/headless/UI/UIProperty/ButtonProperty;", "getConsentLabel", "getDividerColor", "getFilterOffColor", "getFilterOnColor", "getGoogleVendorsTitle", "getIabVendorsTitle", "()Z", "getOtPCUIProperty", "()Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTPCUIProperty;", "getPcBackgroundColor", "getPcButtonColor", "getPcButtonTextColor", "getPcTextColor", "getRightChevronColor", "getSearchBarProperty", "()Lcom/onetrust/otpublishers/headless/UI/UIProperty/SearchBarProperty;", "getToggleThumbOffColor", "getToggleThumbOnColor", "getToggleTrackColor", "getVendorListUIProperty", "()Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTVendorListUIProperty;", "getVlPageHeaderTitle", "()Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTPageHeaderProperty;", "getVlTitleTextProperty", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class VendorListData {

    /* JADX INFO: renamed from: a */
    public final String f206a;

    /* JADX INFO: renamed from: b */
    public final C0132z f207b;

    /* JADX INFO: renamed from: c */
    public final String f208c;

    /* JADX INFO: renamed from: d */
    public final String f209d;

    /* JADX INFO: renamed from: e */
    public final String f210e;

    /* JADX INFO: renamed from: f */
    public final String f211f;

    /* JADX INFO: renamed from: g */
    public final String f212g;

    /* JADX INFO: renamed from: h */
    public final String f213h;

    /* JADX INFO: renamed from: i */
    public final C0107c f214i;

    /* JADX INFO: renamed from: j */
    public final String f215j;

    /* JADX INFO: renamed from: k */
    public final C0106b0 f216k;

    /* JADX INFO: renamed from: l */
    public final String f217l;

    /* JADX INFO: renamed from: m */
    public final boolean f218m;

    /* JADX INFO: renamed from: n */
    public final C0104a0 f219n;

    /* JADX INFO: renamed from: o */
    public final String f220o;

    /* JADX INFO: renamed from: p */
    public final String f221p;

    /* JADX INFO: renamed from: q */
    public final String f222q;

    /* JADX INFO: renamed from: r */
    public final String f223r;

    /* JADX INFO: renamed from: s */
    public final String f224s;

    /* JADX INFO: renamed from: t */
    public final C0127u f225t;

    /* JADX INFO: renamed from: u */
    public final C0106b0 f226u;

    /* JADX INFO: renamed from: v */
    public final C0126t f227v;

    /* JADX INFO: renamed from: w */
    public final String f228w;

    public VendorListData(String str, C0132z vendorListUIProperty, String str2, String str3, String str4, String str5, String str6, String str7, C0107c confirmMyChoiceProperty, String str8, C0106b0 vlTitleTextProperty, String str9, boolean z, C0104a0 searchBarProperty, String str10, String str11, String str12, String str13, String str14, C0127u vlPageHeaderTitle, C0106b0 allowAllToggleTextProperty, C0126t c0126t, String str15) {
        Intrinsics.checkNotNullParameter(vendorListUIProperty, "vendorListUIProperty");
        Intrinsics.checkNotNullParameter(confirmMyChoiceProperty, "confirmMyChoiceProperty");
        Intrinsics.checkNotNullParameter(vlTitleTextProperty, "vlTitleTextProperty");
        Intrinsics.checkNotNullParameter(searchBarProperty, "searchBarProperty");
        Intrinsics.checkNotNullParameter(vlPageHeaderTitle, "vlPageHeaderTitle");
        Intrinsics.checkNotNullParameter(allowAllToggleTextProperty, "allowAllToggleTextProperty");
        this.f206a = str;
        this.f207b = vendorListUIProperty;
        this.f208c = str2;
        this.f209d = str3;
        this.f210e = str4;
        this.f211f = str5;
        this.f212g = str6;
        this.f213h = str7;
        this.f214i = confirmMyChoiceProperty;
        this.f215j = str8;
        this.f216k = vlTitleTextProperty;
        this.f217l = str9;
        this.f218m = z;
        this.f219n = searchBarProperty;
        this.f220o = str10;
        this.f221p = str11;
        this.f222q = str12;
        this.f223r = str13;
        this.f224s = str14;
        this.f225t = vlPageHeaderTitle;
        this.f226u = allowAllToggleTextProperty;
        this.f227v = c0126t;
        this.f228w = str15;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VendorListData)) {
            return false;
        }
        VendorListData vendorListData = (VendorListData) other;
        return Intrinsics.areEqual(this.f206a, vendorListData.f206a) && Intrinsics.areEqual(this.f207b, vendorListData.f207b) && Intrinsics.areEqual(this.f208c, vendorListData.f208c) && Intrinsics.areEqual(this.f209d, vendorListData.f209d) && Intrinsics.areEqual(this.f210e, vendorListData.f210e) && Intrinsics.areEqual(this.f211f, vendorListData.f211f) && Intrinsics.areEqual(this.f212g, vendorListData.f212g) && Intrinsics.areEqual(this.f213h, vendorListData.f213h) && Intrinsics.areEqual(this.f214i, vendorListData.f214i) && Intrinsics.areEqual(this.f215j, vendorListData.f215j) && Intrinsics.areEqual(this.f216k, vendorListData.f216k) && Intrinsics.areEqual(this.f217l, vendorListData.f217l) && this.f218m == vendorListData.f218m && Intrinsics.areEqual(this.f219n, vendorListData.f219n) && Intrinsics.areEqual(this.f220o, vendorListData.f220o) && Intrinsics.areEqual(this.f221p, vendorListData.f221p) && Intrinsics.areEqual(this.f222q, vendorListData.f222q) && Intrinsics.areEqual(this.f223r, vendorListData.f223r) && Intrinsics.areEqual(this.f224s, vendorListData.f224s) && Intrinsics.areEqual(this.f225t, vendorListData.f225t) && Intrinsics.areEqual(this.f226u, vendorListData.f226u) && Intrinsics.areEqual(this.f227v, vendorListData.f227v) && Intrinsics.areEqual(this.f228w, vendorListData.f228w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v72 */
    public int hashCode() {
        String str = this.f206a;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.f207b.hashCode()) * 31;
        String str2 = this.f208c;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f209d;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f210e;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f211f;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f212g;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f213h;
        int iHashCode7 = (((iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.f214i.hashCode()) * 31;
        String str8 = this.f215j;
        int iHashCode8 = (((iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31) + this.f216k.hashCode()) * 31;
        String str9 = this.f217l;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        boolean z = this.f218m;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int iHashCode10 = (((iHashCode9 + r2) * 31) + this.f219n.hashCode()) * 31;
        String str10 = this.f220o;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.f221p;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.f222q;
        int iHashCode13 = (iHashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.f223r;
        int iHashCode14 = (iHashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.f224s;
        int iHashCode15 = (((((iHashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31) + this.f225t.hashCode()) * 31) + this.f226u.hashCode()) * 31;
        C0126t c0126t = this.f227v;
        int iHashCode16 = (iHashCode15 + (c0126t == null ? 0 : c0126t.hashCode())) * 31;
        String str15 = this.f228w;
        return iHashCode16 + (str15 != null ? str15.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VendorListData(pcBackgroundColor=");
        sb.append(this.f206a).append(", vendorListUIProperty=").append(this.f207b).append(", filterOnColor=").append(this.f208c).append(", filterOffColor=").append(this.f209d).append(", dividerColor=").append(this.f210e).append(", toggleTrackColor=").append(this.f211f).append(", toggleThumbOnColor=").append(this.f212g).append(", toggleThumbOffColor=").append(this.f213h).append(", confirmMyChoiceProperty=").append(this.f214i).append(", pcButtonTextColor=").append(this.f215j).append(", vlTitleTextProperty=").append(this.f216k).append(", pcTextColor=");
        sb.append(this.f217l).append(", isGeneralVendorToggleEnabled=").append(this.f218m).append(", searchBarProperty=").append(this.f219n).append(", iabVendorsTitle=").append(this.f220o).append(", googleVendorsTitle=").append(this.f221p).append(", consentLabel=").append(this.f222q).append(", backButtonColor=").append(this.f223r).append(", pcButtonColor=").append(this.f224s).append(", vlPageHeaderTitle=").append(this.f225t).append(", allowAllToggleTextProperty=").append(this.f226u).append(", otPCUIProperty=").append(this.f227v).append(", rightChevronColor=").append(this.f228w);
        sb.append(')');
        return sb.toString();
    }
}
