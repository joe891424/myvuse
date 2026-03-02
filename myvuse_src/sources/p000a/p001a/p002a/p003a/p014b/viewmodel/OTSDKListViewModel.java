package p000a.p001a.p002a.p003a.p014b.viewmodel;

import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.gms.actions.SearchIntents;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.p007c.C0006b;
import p000a.p001a.p002a.p003a.p004a.p007c.C0015j;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p007c.C0028w;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p014b.DataModels.SDKItem;
import p000a.p001a.p002a.p003a.p014b.DataModels.SDKItemConsentState;
import p000a.p001a.p002a.p003a.p014b.DataModels.SDKListData;

/* JADX INFO: renamed from: a.a.a.a.b.j.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 h2\u00020\u0001:\u0002hiB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010A\u001a\u00020BJ\b\u0010C\u001a\u00020BH\u0002J\u0010\u0010D\u001a\u00020B2\b\u0010E\u001a\u0004\u0018\u00010FJ\u0018\u0010G\u001a\u00020B2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0002J\u000e\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0012J\n\u0010O\u001a\u0004\u0018\u00010\u0012H\u0002J\u0006\u00101\u001a\u00020BJ(\u0010P\u001a\u00020M2\u0006\u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020M2\u0006\u0010U\u001a\u00020\tH\u0002J\u0010\u0010V\u001a\u00020\t2\u0006\u0010W\u001a\u00020MH\u0007J\u0006\u0010X\u001a\u00020\tJ\u0012\u0010Y\u001a\u00020\t2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0012J\u0010\u0010Z\u001a\u00020B2\b\b\u0002\u0010[\u001a\u00020\u0012J\u0014\u0010\\\u001a\u00020B2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00120\rJ\b\u0010^\u001a\u00020BH\u0002J\u0018\u0010_\u001a\u00020B2\u0006\u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020SH\u0002J\u000e\u0010`\u001a\u00020B2\u0006\u0010+\u001a\u00020\u000bJ\u0012\u0010a\u001a\u00020B2\b\u0010b\u001a\u0004\u0018\u00010\u0012H\u0002J\u000e\u0010c\u001a\u00020B2\u0006\u0010d\u001a\u00020\tJ\u0006\u0010e\u001a\u00020BJ\u0016\u0010f\u001a\u00020B2\u0006\u0010g\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\tR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0#8F¢\u0006\u0006\u001a\u0004\b\"\u0010$R\u001a\u0010%\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\u0013\u0010+\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001d\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0#8F¢\u0006\u0006\u001a\u0004\b1\u0010$R\u001c\u00102\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0019\"\u0004\b4\u0010\u001bR\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00100#8F¢\u0006\u0006\u001a\u0004\b6\u0010$R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00109\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b:\u0010\u0019R\u001d\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0#8F¢\u0006\u0006\u001a\u0004\b<\u0010$R \u0010=\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120@X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006j"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/viewmodel/OTSDKListViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "otSharedPreferenceUtils", "Lcom/onetrust/otpublishers/headless/Internal/Preferences/OTSharedPreferenceUtils;", "(Landroid/app/Application;Lcom/onetrust/otpublishers/headless/Internal/Preferences/OTSharedPreferenceUtils;)V", "_isAllSdksGranted", "Landroidx/lifecycle/MutableLiveData;", "", "_otPublishersHeadlessSDK", "Lcom/onetrust/otpublishers/headless/Public/OTPublishersHeadlessSDK;", "_sdkItems", "", "Lcom/onetrust/otpublishers/headless/UI/DataModels/SDKItem;", "_sdkListData", "Lcom/onetrust/otpublishers/headless/UI/DataModels/SDKListData;", "_searchQuery", "", "_selectedCategories", "allCategories", "", "[Ljava/lang/String;", "alwaysActiveText", "getAlwaysActiveText", "()Ljava/lang/String;", "setAlwaysActiveText", "(Ljava/lang/String;)V", "alwaysActiveTextColor", "getAlwaysActiveTextColor", "setAlwaysActiveTextColor", OTUXParamsKeys.OT_UX_CHILD_GROUP, "customGroupDetails", "Lcom/onetrust/otpublishers/headless/Internal/Helper/CustomGroupDetails;", "isAllSdksGranted", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "isEmptySelectionOnFilter", "()Z", "setEmptySelectionOnFilter", "(Z)V", "isFilteredSDKList", "setFilteredSDKList", "otPublishersHeadlessSDK", "getOtPublishersHeadlessSDK", "()Lcom/onetrust/otpublishers/headless/Public/OTPublishersHeadlessSDK;", "getOtSharedPreferenceUtils", "()Lcom/onetrust/otpublishers/headless/Internal/Preferences/OTSharedPreferenceUtils;", "sdkItems", "getSdkItems", "sdkLevelOptOut", "getSdkLevelOptOut", "setSdkLevelOptOut", "sdkListData", "getSdkListData", "sdkListHelper", "Lcom/onetrust/otpublishers/headless/Internal/Helper/SdkListHelper;", "searchQuery", "getSearchQuery", "selectedCategories", "getSelectedCategories", "selectedGroups", "", "selectedSdkItems", "", "clearSelectedCategories", "", "determineGroupsToBeUpdated", "extractArgumentsData", "arguments", "Landroid/os/Bundle;", "extractingPCData", "pcData", "Lorg/json/JSONObject;", "otSdkListUIProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTSDKListUIProperty;", "getConsentStatus", "", "sdkId", "getParentId", "getStatusCount", "groupId", "sdkIds", "Lorg/json/JSONArray;", "statusCount", "status", "initializeData", "themeMode", "isAllowAllVisible", "isAlwaysActiveGroup", "onSearchQueryChanged", SearchIntents.EXTRA_QUERY, "onSelectedCategoriesChanged", "selectedList", "refreshGrantAll", "sdkGroupLengthCheck", "setOTInstance", "setSelectedCategories", "selectedCategoriesText", "updateAllSdkConsents", "isChecked", "updateCategoryConsentBasedOnSDK", "updateSDKConsentStatus", "id", "Companion", "Factory", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class OTSDKListViewModel extends AndroidViewModel {

    /* JADX INFO: renamed from: a */
    public final C0046e f1550a;

    /* JADX INFO: renamed from: b */
    public OTPublishersHeadlessSDK f1551b;

    /* JADX INFO: renamed from: c */
    public boolean f1552c;

    /* JADX INFO: renamed from: d */
    public String f1553d;

    /* JADX INFO: renamed from: e */
    public String f1554e;

    /* JADX INFO: renamed from: f */
    public String f1555f;

    /* JADX INFO: renamed from: g */
    public boolean f1556g;

    /* JADX INFO: renamed from: h */
    public String f1557h;

    /* JADX INFO: renamed from: i */
    public String f1558i;

    /* JADX INFO: renamed from: j */
    public final C0028w f1559j;

    /* JADX INFO: renamed from: k */
    public final C0015j f1560k;

    /* JADX INFO: renamed from: l */
    public final List<String> f1561l;

    /* JADX INFO: renamed from: m */
    public final Map<String, List<String>> f1562m;

    /* JADX INFO: renamed from: n */
    public String[] f1563n;

    /* JADX INFO: renamed from: o */
    public final MutableLiveData<List<String>> f1564o;

    /* JADX INFO: renamed from: p */
    public final MutableLiveData<List<SDKItem>> f1565p;

    /* JADX INFO: renamed from: q */
    public final MutableLiveData<SDKListData> f1566q;

    /* JADX INFO: renamed from: r */
    public final MutableLiveData<Boolean> f1567r;

    /* JADX INFO: renamed from: a.a.a.a.b.j.b$a */
    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/viewmodel/OTSDKListViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a implements ViewModelProvider.Factory {

        /* JADX INFO: renamed from: a */
        public final Application f1568a;

        public a(Application application) {
            Intrinsics.checkNotNullParameter(application, "application");
            this.f1568a = application;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new OTSDKListViewModel(this.f1568a, new C0046e(this.f1568a));
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.j.b$b */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<String, Integer> {
        public b(Object obj) {
            super(1, obj, OTSDKListViewModel.class, "getConsentStatus", "getConsentStatus(Ljava/lang/String;)I", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Integer invoke(String str) {
            String sdkId = str;
            Intrinsics.checkNotNullParameter(sdkId, "p0");
            OTSDKListViewModel oTSDKListViewModel = (OTSDKListViewModel) this.receiver;
            oTSDKListViewModel.getClass();
            Intrinsics.checkNotNullParameter(sdkId, "sdkId");
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = oTSDKListViewModel.f1551b;
            Intrinsics.checkNotNull(oTPublishersHeadlessSDK);
            return Integer.valueOf(oTPublishersHeadlessSDK.getConsentStatusForSDKId(sdkId));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTSDKListViewModel(Application application, C0046e otSharedPreferenceUtils) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(otSharedPreferenceUtils, "otSharedPreferenceUtils");
        this.f1550a = otSharedPreferenceUtils;
        this.f1552c = true;
        this.f1558i = "";
        this.f1559j = new C0028w(getApplication());
        this.f1560k = new C0015j(getApplication());
        this.f1561l = new ArrayList();
        this.f1562m = new LinkedHashMap();
        this.f1563n = new String[0];
        this.f1564o = new MutableLiveData<>(CollectionsKt.emptyList());
        this.f1565p = new MutableLiveData<>(CollectionsKt.emptyList());
        this.f1566q = new MutableLiveData<>();
        this.f1567r = new MutableLiveData<>();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1004a(OTSDKListViewModel oTSDKListViewModel, String str, int i) {
        boolean z = true;
        if ((i & 1) != 0) {
            String str2 = oTSDKListViewModel.f1557h;
            if (str2 == null) {
                str = str2;
            } else {
                try {
                    C0015j c0015j = oTSDKListViewModel.f1560k;
                    Intrinsics.checkNotNull(str2);
                    String strM84a = c0015j.m84a(str2);
                    if (strM84a != null && strM84a.length() != 0) {
                        z = false;
                    }
                    str = z ? null : strM84a;
                    if (str == null) {
                        str = oTSDKListViewModel.f1557h;
                    }
                } catch (Exception e) {
                    OTLogger.m2743a(6, "OTSDKListFragment", "Error on getting parent child JSON. Error message = " + e.getMessage());
                    str = "";
                }
            }
        }
        if (str == null) {
            return false;
        }
        return oTSDKListViewModel.f1550a.m277b(str);
    }

    /* JADX INFO: renamed from: a */
    public final void m1005a() {
        this.f1564o.setValue(CollectionsKt.emptyList());
    }

    /* JADX INFO: renamed from: a */
    public final void m1006a(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.f1558i = query;
        m1007b();
    }

    /* JADX INFO: renamed from: b */
    public final void m1007b() {
        JSONObject preferenceCenterData;
        C0006b c0006b = new C0006b(getApplication());
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f1551b;
        if (oTPublishersHeadlessSDK == null || (preferenceCenterData = oTPublishersHeadlessSDK.getPreferenceCenterData()) == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Intrinsics.checkNotNullParameter(preferenceCenterData, "<this>");
        Intrinsics.checkNotNullParameter("Groups", "key");
        Intrinsics.checkNotNullParameter(jSONArray, "default");
        try {
            JSONArray jSONArray2 = preferenceCenterData.getJSONArray("Groups");
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "{\n        getJSONArray(key)\n    }");
            jSONArray = jSONArray2;
        } catch (Exception unused) {
        }
        if (jSONArray == null) {
            return;
        }
        JSONArray jSONArrayM21a = c0006b.m21a((List<String>) C0026u.m162a(this.f1564o), jSONArray);
        b getSdkConsentStatus = new b(this);
        Intrinsics.checkNotNullParameter(getSdkConsentStatus, "getSdkConsentStatus");
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayM21a.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArrayM21a.getJSONObject(i);
            Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(i)");
            String strM165a = C0026u.m165a(jSONObject, "SdkId", "-1");
            int iIntValue = getSdkConsentStatus.invoke(strM165a).intValue();
            arrayList.add(new SDKItem(strM165a, C0026u.m166a(jSONObject, "Name", (String) null, 2), C0026u.m186b(jSONObject, "Description"), iIntValue != 0 ? iIntValue != 1 ? SDKItemConsentState.NoToggle : SDKItemConsentState.Grant : SDKItemConsentState.Deny));
        }
        MutableLiveData<List<SDKItem>> mutableLiveData = this.f1565p;
        if (this.f1558i.length() > 0) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (StringsKt.contains((CharSequence) ((SDKItem) obj).f174b, (CharSequence) this.f1558i, true)) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        mutableLiveData.setValue(arrayList);
        m1010d();
    }

    /* JADX INFO: renamed from: b */
    public final void m1008b(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(str, "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
        int length = strReplace$default.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) strReplace$default.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        this.f1563n = (String[]) StringsKt.split$default((CharSequence) strReplace$default.subSequence(i, length + 1).toString(), new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
        ArrayList arrayList = new ArrayList();
        for (String str2 : this.f1563n) {
            int length2 = str2.length() - 1;
            int i2 = 0;
            boolean z3 = false;
            while (i2 <= length2) {
                boolean z4 = Intrinsics.compare((int) str2.charAt(!z3 ? i2 : length2), 32) <= 0;
                if (z3) {
                    if (!z4) {
                        break;
                    } else {
                        length2--;
                    }
                } else if (z4) {
                    i2++;
                } else {
                    z3 = true;
                }
            }
            arrayList.add(str2.subSequence(i2, length2 + 1).toString());
            int length3 = str2.length() - 1;
            int i3 = 0;
            boolean z5 = false;
            while (i3 <= length3) {
                boolean z6 = Intrinsics.compare((int) str2.charAt(!z5 ? i3 : length3), 32) <= 0;
                if (z5) {
                    if (!z6) {
                        break;
                    } else {
                        length3--;
                    }
                } else if (z6) {
                    i3++;
                } else {
                    z5 = true;
                }
            }
            this.f1557h = str2.subSequence(i3, length3 + 1).toString();
        }
        this.f1564o.setValue(arrayList);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m1009c() {
        List<String> list;
        List<String> value = this.f1564o.getValue();
        if (value == null || value.isEmpty()) {
            list = ArraysKt.toList(this.f1563n);
        } else {
            List<String> value2 = this.f1564o.getValue();
            Intrinsics.checkNotNull(value2);
            Intrinsics.checkNotNullExpressionValue(value2, "{\n            _selectedC…egories.value!!\n        }");
            list = value2;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!this.f1550a.m277b(list.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    public final void m1010d() {
        boolean z;
        MutableLiveData<Boolean> mutableLiveData = this.f1567r;
        Object objM162a = C0026u.m162a(this.f1565p);
        Intrinsics.checkNotNullExpressionValue(objM162a, "_sdkItems.requireValue()");
        Iterable iterable = (Iterable) objM162a;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            z = false;
        } else {
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                if (((SDKItem) it2.next()).f176d == SDKItemConsentState.Deny) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        mutableLiveData.setValue(Boolean.valueOf(!z));
    }
}
