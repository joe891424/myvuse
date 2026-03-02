package p000a.p001a.p002a.p003a.p014b.viewmodel;

import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p014b.DataModels.VendorItem;
import p000a.p001a.p002a.p003a.p014b.DataModels.VendorListData;

/* JADX INFO: renamed from: a.a.a.a.b.j.c, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b%\u0018\u00002\u00020\u0001:\u0001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u00108\u001a\u0004\u0018\u000109¢\u0006\u0002\u0010:J\u0006\u0010;\u001a\u000209J\u0010\u0010<\u001a\u0002092\b\u0010=\u001a\u0004\u0018\u00010>J\b\u0010\u001f\u001a\u00020?H\u0002J\b\u0010!\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020?H\u0002J\b\u0010A\u001a\u0004\u0018\u00010\u0012J\u0006\u0010B\u001a\u00020\u0012J\b\u0010C\u001a\u0004\u0018\u00010\u0012J\b\u0010D\u001a\u0004\u0018\u00010\u0012J\u0010\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u000203H\u0007J\u0006\u0010G\u001a\u00020\tJ\u0006\u0010H\u001a\u00020\tJ\u0006\u0010I\u001a\u00020\tJ\u0006\u0010J\u001a\u00020\tJ\u0006\u0010K\u001a\u00020\tJ\u000e\u0010L\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u0012J\u0010\u0010M\u001a\u0002092\b\b\u0002\u0010N\u001a\u00020\u0012J\u001a\u0010O\u001a\u0002092\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0014J\u000e\u0010Q\u001a\u0002092\u0006\u0010R\u001a\u00020\u0012J\u0010\u0010S\u001a\u0002092\b\u0010T\u001a\u0004\u0018\u00010\u0012J\u0010\u0010U\u001a\u0002092\u0006\u0010F\u001a\u00020\u0012H\u0002J\u0006\u0010V\u001a\u000209J\u000e\u0010W\u001a\u0002092\u0006\u0010X\u001a\u00020\u0012J\u000e\u0010Y\u001a\u0002092\u0006\u0010$\u001a\u00020\u0010J\u000e\u0010Z\u001a\u0002092\u0006\u0010[\u001a\u00020\tJ\u0015\u0010\\\u001a\u0004\u0018\u0001092\u0006\u0010F\u001a\u00020\u0012¢\u0006\u0002\u0010]J\u001e\u0010^\u001a\u0002092\u0006\u00106\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\tJ\u001e\u0010a\u001a\u0002092\u0006\u00106\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\tJ\u001c\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014*\u0004\u0018\u00010\u0012H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00140\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00140\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00120\u00120\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u001b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u001b8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u001b8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001dR\u0013\u0010$\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b,\u0010-R#\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00140\u001b8F¢\u0006\u0006\u001a\u0004\b/\u0010\u001dR#\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00140\u001b8F¢\u0006\u0006\u001a\u0004\b1\u0010\u001dR\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u00170\u001b8F¢\u0006\u0006\u001a\u0004\b5\u0010\u001dR\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b8F¢\u0006\u0006\u001a\u0004\b7\u0010\u001d¨\u0006d"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/viewmodel/OTVendorListViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "otSharedPreferenceUtils", "Lcom/onetrust/otpublishers/headless/Internal/Preferences/OTSharedPreferenceUtils;", "(Landroid/app/Application;Lcom/onetrust/otpublishers/headless/Internal/Preferences/OTSharedPreferenceUtils;)V", "_allConsentGranted", "Landroidx/lifecycle/MutableLiveData;", "", "_generalVendors", "", "Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorItem;", "_googleVendors", "_iabVendors", "_otPublishersHeadlessSDK", "Lcom/onetrust/otpublishers/headless/Public/OTPublishersHeadlessSDK;", "_searchQuery", "", "_selectedFilterMap", "", "_selectedFilterMapGV", "_vendorListData", "Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorListData;", "_vendorMode", "kotlin.jvm.PlatformType", "allConsentGranted", "Landroidx/lifecycle/LiveData;", "getAllConsentGranted", "()Landroidx/lifecycle/LiveData;", "generalVendors", "getGeneralVendors", "googleVendors", "getGoogleVendors", "iabVendors", "getIabVendors", "otPublishersHeadlessSDK", "getOtPublishersHeadlessSDK", "()Lcom/onetrust/otpublishers/headless/Public/OTPublishersHeadlessSDK;", "getOtSharedPreferenceUtils", "()Lcom/onetrust/otpublishers/headless/Internal/Preferences/OTSharedPreferenceUtils;", "otVendorUtils", "Lcom/onetrust/otpublishers/headless/Public/uiutils/OTVendorUtils;", "searchQuery", "getSearchQuery", "()Ljava/lang/String;", "selectedFilterMap", "getSelectedFilterMap", "selectedFilterMapGV", "getSelectedFilterMapGV", "themeMode", "", "vendorListData", "getVendorListData", "vendorMode", "getVendorMode", "clearSelectAllButtonListener", "", "()Lkotlin/Unit;", "clearSelectedMapFilter", "extractArgumentsData", "arguments", "Landroid/os/Bundle;", "Lorg/json/JSONObject;", "getIABVendors", "getNotSelectedButtonTextColor", "getPCBackgroundColor", "getSelectedButtonTextColor", "getVendorsConfirmButtonBackgroundColor", "initializeData", "mode", "isGeneralVendorModeEnabled", "isGoogleVendorModeEnabled", "isIABVendorModeEnabled", "isSelectedFilterMapGVNotEmpty", "isSelectedFilterMapNotEmpty", "isVendorModeEnabled", "onSearchQueryChanged", "newSearchQuery", "onSelectedMapChanged", "selectedMap", "onVendorModeChanged", "newMode", "populateSelectedMap", "purposeMapString", "refreshGrantAll", "refreshVendors", "saveConsent", OTVendorUtils.CONSENT_TYPE, "setOTInstance", "updateAllVendorsConsentLocal", "isSelected", "updateSelectAllButtonStatus", "(Ljava/lang/String;)Lkotlin/Unit;", "updateVendorConsent", "id", "isChecked", "updateVendorDataForAdapter", "convertStringToMap", "Factory", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class OTVendorListViewModel extends AndroidViewModel {

    /* JADX INFO: renamed from: a */
    public final C0046e f1569a;

    /* JADX INFO: renamed from: b */
    public int f1570b;

    /* JADX INFO: renamed from: c */
    public String f1571c;

    /* JADX INFO: renamed from: d */
    public OTPublishersHeadlessSDK f1572d;

    /* JADX INFO: renamed from: e */
    public OTVendorUtils f1573e;

    /* JADX INFO: renamed from: f */
    public final MutableLiveData<VendorListData> f1574f;

    /* JADX INFO: renamed from: g */
    public final MutableLiveData<String> f1575g;

    /* JADX INFO: renamed from: h */
    public final MutableLiveData<Boolean> f1576h;

    /* JADX INFO: renamed from: i */
    public final MutableLiveData<Map<String, String>> f1577i;

    /* JADX INFO: renamed from: j */
    public final MutableLiveData<Map<String, String>> f1578j;

    /* JADX INFO: renamed from: k */
    public final MutableLiveData<List<VendorItem>> f1579k;

    /* JADX INFO: renamed from: l */
    public final MutableLiveData<List<VendorItem>> f1580l;

    /* JADX INFO: renamed from: m */
    public final MutableLiveData<List<VendorItem>> f1581m;

    /* JADX INFO: renamed from: a.a.a.a.b.j.c$a */
    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/viewmodel/OTVendorListViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a implements ViewModelProvider.Factory {

        /* JADX INFO: renamed from: a */
        public final Application f1582a;

        public a(Application application) {
            Intrinsics.checkNotNullParameter(application, "application");
            this.f1582a = application;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new OTVendorListViewModel(this.f1582a, new C0046e(this.f1582a));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTVendorListViewModel(Application application, C0046e otSharedPreferenceUtils) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(otSharedPreferenceUtils, "otSharedPreferenceUtils");
        this.f1569a = otSharedPreferenceUtils;
        this.f1571c = "";
        this.f1574f = new MutableLiveData<>();
        this.f1575g = new MutableLiveData<>(OTVendorListMode.IAB);
        this.f1576h = new MutableLiveData<>();
        this.f1577i = new MutableLiveData<>(new LinkedHashMap());
        this.f1578j = new MutableLiveData<>(new LinkedHashMap());
        this.f1579k = new MutableLiveData<>();
        this.f1580l = new MutableLiveData<>();
        this.f1581m = new MutableLiveData<>();
    }

    /* JADX INFO: renamed from: a */
    public final String m1012a() {
        String str = ((VendorListData) C0026u.m162a(this.f1574f)).f206a;
        if (str == null || str.length() == 0) {
            str = null;
        }
        return str == null ? this.f1570b == 11 ? "#2F2F2F" : "#FFFFFF" : str;
    }

    /* JADX INFO: renamed from: a */
    public final Map<String, String> m1013a(String str) {
        if (str == null || str.length() == 0 || Intrinsics.areEqual(str, "{}")) {
            return null;
        }
        String strSubstring = str.substring(1, str.length() - 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String[] strArr = (String[]) StringsKt.split$default((CharSequence) strSubstring, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str2 : strArr) {
            String[] strArr2 = (String[]) StringsKt.split$default((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
            String str3 = strArr2[0];
            int length = str3.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str3.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            String string = str3.subSequence(i, length + 1).toString();
            String str4 = strArr2[1];
            int length2 = str4.length() - 1;
            int i2 = 0;
            boolean z3 = false;
            while (i2 <= length2) {
                boolean z4 = Intrinsics.compare((int) str4.charAt(!z3 ? i2 : length2), 32) <= 0;
                if (z3) {
                    if (!z4) {
                        break;
                    }
                    length2--;
                } else if (z4) {
                    i2++;
                } else {
                    z3 = true;
                }
            }
            linkedHashMap.put(string, str4.subSequence(i2, length2 + 1).toString());
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: a */
    public final void m1015a(Map<String, String> selectedMap) {
        Intrinsics.checkNotNullParameter(selectedMap, "selectedMap");
        (m1021d() ? this.f1577i : this.f1578j).setValue(selectedMap);
        m1023f();
    }

    /* JADX INFO: renamed from: b */
    public final void m1017b(String newSearchQuery) {
        Intrinsics.checkNotNullParameter(newSearchQuery, "newSearchQuery");
        this.f1571c = newSearchQuery;
        m1023f();
    }

    /* JADX INFO: renamed from: b */
    public final boolean m1018b() {
        return StringsKt.equals(OTVendorListMode.GENERAL, (String) C0026u.m162a(this.f1575g), true);
    }

    /* JADX INFO: renamed from: c */
    public final void m1019c(String newMode) {
        Intrinsics.checkNotNullParameter(newMode, "newMode");
        this.f1575g.setValue(newMode);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m1020c() {
        return StringsKt.equals(OTVendorListMode.GOOGLE, (String) C0026u.m162a(this.f1575g), true);
    }

    /* JADX INFO: renamed from: d */
    public final boolean m1021d() {
        return StringsKt.equals(OTVendorListMode.IAB, (String) C0026u.m162a(this.f1575g), true);
    }

    /* JADX INFO: renamed from: e */
    public final boolean m1022e() {
        Intrinsics.checkNotNullExpressionValue(C0026u.m162a(this.f1577i), "_selectedFilterMap.requireValue()");
        return !((Map) r0).isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m1023f() {
        /*
            Method dump skipped, instruction units count: 592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.viewmodel.OTVendorListViewModel.m1023f():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x02b7  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m1016a(int r39) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 789
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.viewmodel.OTVendorListViewModel.m1016a(int):boolean");
    }

    /* JADX INFO: renamed from: a */
    public static final void m1011a(OTVendorListViewModel this$0, String vendorMode, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(vendorMode, "vendorMode");
        if (Intrinsics.areEqual(C0026u.m162a(this$0.f1575g), vendorMode)) {
            this$0.f1576h.setValue(Boolean.valueOf(z));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m1014a(java.lang.String r6, java.lang.String r7, boolean r8) {
        /*
            r5 = this;
            java.lang.String r0 = "vendorMode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int r0 = r6.hashCode()
            r1 = -1240244679(0xffffffffb6135e39, float:-2.1959552E-6)
            r2 = 0
            if (r0 == r1) goto L38
            r1 = -80148248(0xfffffffffb3908e8, float:-9.6075556E35)
            if (r0 == r1) goto L2c
            r1 = 104010(0x1964a, float:1.45749E-40)
            if (r0 == r1) goto L20
            goto L40
        L20:
            java.lang.String r0 = "iab"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L29
            goto L40
        L29:
            androidx.lifecycle.MutableLiveData<java.util.List<a.a.a.a.b.a.i>> r6 = r5.f1579k
            goto L44
        L2c:
            java.lang.String r0 = "general"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L35
            goto L40
        L35:
            androidx.lifecycle.MutableLiveData<java.util.List<a.a.a.a.b.a.i>> r6 = r5.f1581m
            goto L44
        L38:
            java.lang.String r0 = "google"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L42
        L40:
            r6 = r2
            goto L44
        L42:
            androidx.lifecycle.MutableLiveData<java.util.List<a.a.a.a.b.a.i>> r6 = r5.f1580l
        L44:
            if (r6 == 0) goto L96
            java.lang.Object r0 = r6.getValue()
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L59
            java.lang.String r1 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r0)
            goto L5a
        L59:
            r0 = r2
        L5a:
            if (r0 == 0) goto L78
            java.util.Iterator r1 = r0.iterator()
        L60:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L76
            java.lang.Object r3 = r1.next()
            r4 = r3
            a.a.a.a.b.a.i r4 = (p000a.p001a.p002a.p003a.p014b.DataModels.VendorItem) r4
            java.lang.String r4 = r4.f198a
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r7)
            if (r4 == 0) goto L60
            r2 = r3
        L76:
            a.a.a.a.b.a.i r2 = (p000a.p001a.p002a.p003a.p014b.DataModels.VendorItem) r2
        L78:
            if (r2 != 0) goto L7b
            goto L8c
        L7b:
            r7 = 1
            if (r8 != r7) goto L81
            a.a.a.a.b.a.j r7 = p000a.p001a.p002a.p003a.p014b.DataModels.VendorItemConsentState.Grant
            goto L85
        L81:
            if (r8 != 0) goto L90
            a.a.a.a.b.a.j r7 = p000a.p001a.p002a.p003a.p014b.DataModels.VendorItemConsentState.Deny
        L85:
            java.lang.String r8 = "<set-?>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            r2.f200c = r7
        L8c:
            r6.setValue(r0)
            goto L96
        L90:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.viewmodel.OTVendorListViewModel.m1014a(java.lang.String, java.lang.String, boolean):void");
    }
}
