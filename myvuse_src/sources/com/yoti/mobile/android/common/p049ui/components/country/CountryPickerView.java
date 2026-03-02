package com.yoti.mobile.android.common.p049ui.components.country;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.yoti.mobile.android.common.p049ui.components.utils.LocaleCountryCodeHelper;
import com.yoti.mobile.android.common.p049ui.components.utils.ResourcesDemonymProvider;
import com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerView;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\b\b\u0003\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001a\u0012\b\b\u0002\u0010 \u001a\u00020\u001a¢\u0006\u0004\b!\u0010\"B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b!\u0010#J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u001d\u0010\n\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0005R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006$"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/components/country/CountryPickerView;", "Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerView;", "Lcom/yoti/mobile/android/common/ui/components/country/b;", "", "loadCountries", "()V", "clear", "", "Lcom/yoti/mobile/android/common/ui/components/country/Country;", "countryList", "setCountries", "(Ljava/util/List;)V", "country", "showCountryAsSelected", "(Lcom/yoti/mobile/android/common/ui/components/country/Country;)V", "", "countryIsoCode", "selectCountryByCode", "(Ljava/lang/String;)V", "selectDefaultCountry", "Lcom/yoti/mobile/android/common/ui/components/country/a;", "a", "Lcom/yoti/mobile/android/common/ui/components/country/a;", "presenter", "Landroid/content/Context;", "context", "", "isTickAndConfirmMode", "shouldShowSubText", "", "confirmButtonResourceIdRes", "shouldShowIndexLetter", "shouldShowIndexLayout", "<init>", "(Landroid/content/Context;ZZIZZ)V", "(Landroid/content/Context;)V", "uiComponents_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class CountryPickerView extends AlphabeticalPickerView implements InterfaceC4472b {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private InterfaceC4471a presenter;

    /* JADX INFO: renamed from: b */
    private HashMap f5884b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CountryPickerView(Context context) {
        this(context, false, false, 0, false, false, 56, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountryPickerView(Context context, boolean z, boolean z2, int i, boolean z3, boolean z4) {
        super(context, null, z, z2, z3, z4, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CountryPickerView(Context context, boolean z, boolean z2, int i, boolean z3, boolean z4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z, z2, (i2 & 8) != 0 ? -1 : i, (i2 & 16) != 0 ? true : z3, (i2 & 32) != 0 ? true : z4);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f5884b;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5884b == null) {
            this.f5884b = new HashMap();
        }
        View view = (View) this.f5884b.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5884b.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerView
    public void clear() {
        super.clear();
        InterfaceC4471a interfaceC4471a = this.presenter;
        if (interfaceC4471a == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        interfaceC4471a.mo4374c();
    }

    public final void loadCountries() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ResourcesDemonymProvider resourcesDemonymProvider = new ResourcesDemonymProvider(context);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        C4474d c4474d = new C4474d(this, new LocaleCountryCodeHelper(resources, resourcesDemonymProvider));
        this.presenter = c4474d;
        c4474d.mo4373b();
    }

    public final void selectCountryByCode(String countryIsoCode) {
        Intrinsics.checkNotNullParameter(countryIsoCode, "countryIsoCode");
        InterfaceC4471a interfaceC4471a = this.presenter;
        if (interfaceC4471a == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        interfaceC4471a.mo4372a(countryIsoCode);
    }

    public final void selectDefaultCountry() {
        InterfaceC4471a interfaceC4471a = this.presenter;
        if (interfaceC4471a == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        interfaceC4471a.mo4371a();
    }

    @Override // com.yoti.mobile.android.common.p049ui.components.country.InterfaceC4472b
    public void setCountries(List<? extends Country> countryList) {
        Intrinsics.checkNotNullParameter(countryList, "countryList");
        super.setItems(countryList);
    }

    @Override // com.yoti.mobile.android.common.p049ui.components.country.InterfaceC4472b
    public void showCountryAsSelected(Country country) {
        Intrinsics.checkNotNullParameter(country, "country");
        super.setItemAsSelected(country);
    }
}
