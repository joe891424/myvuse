package p000a.p001a.p002a.p003a.p014b.viewmodel;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p014b.DataModels.BannerData;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0123q;

/* JADX INFO: renamed from: a.a.a.a.b.j.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0013J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013J\b\u0010 \u001a\u0004\u0018\u00010\u0013J\b\u0010!\u001a\u0004\u0018\u00010\u0013J\b\u0010\"\u001a\u0004\u0018\u00010\u0013J\b\u0010#\u001a\u0004\u0018\u00010\u0013J\b\u0010$\u001a\u0004\u0018\u00010\u0013J\b\u0010%\u001a\u0004\u0018\u00010\u0013J\b\u0010&\u001a\u0004\u0018\u00010\u0013J\b\u0010'\u001a\u0004\u0018\u00010\u0013J\b\u0010(\u001a\u0004\u0018\u00010\u0013J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020*J\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020*J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0013R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/viewmodel/OTBannerViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "otPublishersHeadlessSDK", "Lcom/onetrust/otpublishers/headless/Public/OTPublishersHeadlessSDK;", "otSharedPreference", "Landroid/content/SharedPreferences;", "(Landroid/app/Application;Lcom/onetrust/otpublishers/headless/Public/OTPublishersHeadlessSDK;Landroid/content/SharedPreferences;)V", "_bannerData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/onetrust/otpublishers/headless/UI/DataModels/BannerData;", "bannerData", "Landroidx/lifecycle/LiveData;", "getBannerData", "()Landroidx/lifecycle/LiveData;", "getOtPublishersHeadlessSDK", "()Lcom/onetrust/otpublishers/headless/Public/OTPublishersHeadlessSDK;", "getAcceptButtonBackgroundColor", "", "getAcceptButtonTextColor", "getAdditionalDescriptionTextColor", "getAlertNoticeTextColor", "getBannerHeightRatio", "", "getBannerIABDescriptionText", "getBannerIABDescriptionTextColor", "getBannerIABTitleTextColor", "getBannerLayoutBackgroundColor", "getBannerTitleColor", "getCloseBannerButtonBackgroundColor", "getCloseBannerButtonTextColor", "getCloseBannerColor", "getCloseBannerTextColor", "getPreferenceCenterButtonBackgroundColor", "getPreferenceCenterButtonBorderColor", "getPreferenceCenterButtonTextColor", "getRejectButtonBackgroundColor", "getRejectButtonTextColor", "getSmallBannerTitleColor", "getSmallCloseButtonColor", "initializeData", "", "themeMode", "", "isBannerLogoVisible", "isBannerTopLayoutVisible", "isSmallBannerTopLayoutVisible", "onSaveConsent", "", "type", "Factory", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class OTBannerViewModel extends AndroidViewModel {

    /* JADX INFO: renamed from: a */
    public final OTPublishersHeadlessSDK f1545a;

    /* JADX INFO: renamed from: b */
    public final SharedPreferences f1546b;

    /* JADX INFO: renamed from: c */
    public final MutableLiveData<BannerData> f1547c;

    /* JADX INFO: renamed from: d */
    public final LiveData<BannerData> f1548d;

    /* JADX INFO: renamed from: a.a.a.a.b.j.a$a */
    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/viewmodel/OTBannerViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a implements ViewModelProvider.Factory {

        /* JADX INFO: renamed from: a */
        public final Application f1549a;

        public a(Application application) {
            Intrinsics.checkNotNullParameter(application, "application");
            this.f1549a = application;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            SharedPreferencesC0047f sharedPreferencesC0047f;
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Application application = this.f1549a;
            boolean z = false;
            SharedPreferences sharedPreferences = application.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (C0026u.m181a(new C0045d(application, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f = new SharedPreferencesC0047f(application, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z = true;
            } else {
                sharedPreferencesC0047f = null;
            }
            if (z) {
                sharedPreferences = sharedPreferencesC0047f;
            }
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "OTSharedPreference(\n    …      ).sharedPreferences");
            return new OTBannerViewModel(this.f1549a, new OTPublishersHeadlessSDK(this.f1549a), sharedPreferences);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTBannerViewModel(Application application, OTPublishersHeadlessSDK otPublishersHeadlessSDK, SharedPreferences otSharedPreference) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(otPublishersHeadlessSDK, "otPublishersHeadlessSDK");
        Intrinsics.checkNotNullParameter(otSharedPreference, "otSharedPreference");
        this.f1545a = otPublishersHeadlessSDK;
        this.f1546b = otSharedPreference;
        MutableLiveData<BannerData> mutableLiveData = new MutableLiveData<>();
        this.f1547c = mutableLiveData;
        this.f1548d = mutableLiveData;
    }

    /* JADX INFO: renamed from: a */
    public final String m1000a() {
        C0123q c0123q;
        C0106b0 c0106b0;
        BannerData value = this.f1547c.getValue();
        String str = (value == null || (c0123q = value.f140t) == null || (c0106b0 = c0123q.f791g) == null) ? null : c0106b0.f724c;
        if (str == null || str.length() == 0) {
            str = null;
        }
        if (str != null) {
            return str;
        }
        BannerData value2 = this.f1547c.getValue();
        if (value2 != null) {
            return value2.f128h;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final void m1001a(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.f1545a.saveConsent(type);
    }

    /* JADX INFO: renamed from: b */
    public final String m1002b() {
        String str;
        BannerData value = this.f1547c.getValue();
        if (value == null || (str = value.f139s) == null) {
            return "";
        }
        BannerData value2 = this.f1547c.getValue();
        String str2 = value2 != null ? value2.f139s : null;
        if (!Pattern.compile(".*\\<[^>]+>.*", 32).matcher(str2 != null ? str2 : "").matches()) {
            BannerData value3 = this.f1547c.getValue();
            if (value3 != null) {
                return value3.m373a(str);
            }
            return null;
        }
        BannerData value4 = this.f1547c.getValue();
        String str3 = value4 != null ? value4.f139s : null;
        Intrinsics.checkNotNull(str3);
        String strReplace$default = StringsKt.replace$default(str3, "\\/", "/", false, 4, (Object) null);
        if (!StringsKt.startsWith$default(strReplace$default, "[", false, 2, (Object) null) && !StringsKt.endsWith$default(strReplace$default, "]", false, 2, (Object) null)) {
            return strReplace$default;
        }
        BannerData value5 = this.f1547c.getValue();
        if (value5 != null) {
            return value5.m373a(strReplace$default);
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final String m1003c() {
        C0123q c0123q;
        C0107c c0107c;
        BannerData value = this.f1547c.getValue();
        String strMo378b = (value == null || (c0123q = value.f140t) == null || (c0107c = c0123q.f795k) == null) ? null : c0107c.mo378b();
        if (strMo378b == null || strMo378b.length() == 0) {
            strMo378b = null;
        }
        if (strMo378b != null) {
            return strMo378b;
        }
        BannerData value2 = this.f1547c.getValue();
        if (value2 != null) {
            return value2.f127g;
        }
        return null;
    }
}
