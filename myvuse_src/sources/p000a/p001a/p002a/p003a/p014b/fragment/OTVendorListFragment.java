package p000a.p001a.p002a.p003a.p014b.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.C0261R;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTConsentInteractionType;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import com.onetrust.otpublishers.headless.p046UI.Helper.FragmentViewBindingDelegate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p004a.p007c.C0016k;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p014b.DataModels.VendorListData;
import p000a.p001a.p002a.p003a.p014b.InterfaceC0075c;
import p000a.p001a.p002a.p003a.p014b.adapter.OTVendorAdapter;
import p000a.p001a.p002a.p003a.p014b.adapter.OTVendorGeneralAdapter;
import p000a.p001a.p002a.p003a.p014b.adapter.OTVendorGoogleAdapter;
import p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0157c;
import p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0160f;
import p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0168n;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0104a0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0127u;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;
import p000a.p001a.p002a.p003a.p014b.viewmodel.OTVendorListViewModel;
import p000a.p001a.p002a.p003a.p027c.C0180c;
import p000a.p001a.p002a.p003a.p027c.C0185h;

/* JADX INFO: renamed from: a.a.a.a.b.h.m, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 f2\u00020\u0001:\u0001fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020&H\u0002J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00102\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020(2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00105\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00106\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00107\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J(\u00108\u001a\u00020&2\u0006\u0010.\u001a\u00020/2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:H\u0002J\b\u0010=\u001a\u00020&H\u0002J \u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020@2\u0006\u0010'\u001a\u00020(2\u0006\u0010A\u001a\u00020@H\u0002J\u0018\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0002J\u0010\u0010D\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010E\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\b\u0010F\u001a\u00020&H\u0002J\u001c\u0010G\u001a\u00020&2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020@0IH\u0002J\u0010\u0010J\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010K\u001a\u00020(2\u0006\u0010L\u001a\u00020,H\u0003J\b\u0010M\u001a\u00020&H\u0002J\u0012\u0010N\u001a\u00020&2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0012\u0010Q\u001a\u00020R2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J$\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010Y\u001a\u00020&H\u0016J\b\u0010Z\u001a\u00020&H\u0002J\b\u0010[\u001a\u00020&H\u0002J\u001a\u0010\\\u001a\u00020&2\u0006\u0010]\u001a\u00020T2\b\u0010O\u001a\u0004\u0018\u00010PH\u0017J\u000e\u0010^\u001a\u00020&2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010_\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010`\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010a\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010b\u001a\u00020&2\b\u0010c\u001a\u0004\u0018\u00010\u0012J\u000e\u0010d\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010e\u001a\u00020&H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"¨\u0006g"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/fragment/OTVendorListFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lcom/onetrust/otpublishers/headless/databinding/FragmentOtVendorsListBinding;", "getBinding", "()Lcom/onetrust/otpublishers/headless/databinding/FragmentOtVendorsListBinding;", "binding$delegate", "Lcom/onetrust/otpublishers/headless/UI/Helper/FragmentViewBindingDelegate;", "eventListenerSetter", "Lcom/onetrust/otpublishers/headless/Internal/Event/EventListenerSetter;", "generalVendorAdapter", "Lcom/onetrust/otpublishers/headless/UI/adapter/OTVendorGeneralAdapter;", "googleVendorAdapter", "Lcom/onetrust/otpublishers/headless/UI/adapter/OTVendorGoogleAdapter;", "iabVendorAdapter", "Lcom/onetrust/otpublishers/headless/UI/adapter/OTVendorAdapter;", "interactionListener", "Lcom/onetrust/otpublishers/headless/UI/OTInteractionListener;", "otConfiguration", "Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;", "otPublishersHeadlessSDK", "Lcom/onetrust/otpublishers/headless/Public/OTPublishersHeadlessSDK;", "purposeListFragment", "Lcom/onetrust/otpublishers/headless/UI/fragment/OTPurposeListFragment;", "uiUtils", "Lcom/onetrust/otpublishers/headless/UI/Helper/UIUtils;", "vendorsDetailsFragment", "Lcom/onetrust/otpublishers/headless/UI/fragment/OTVendorsDetailsFragment;", "vendorsGeneralDetailsFragment", "Lcom/onetrust/otpublishers/headless/UI/fragment/OTGeneralVendorsDetailsFragment;", "viewModel", "Lcom/onetrust/otpublishers/headless/UI/viewmodel/OTVendorListViewModel;", "getViewModel", "()Lcom/onetrust/otpublishers/headless/UI/viewmodel/OTVendorListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "allowAllOnClick", "", "isChecked", "", "closeSearchView", "closeViews", "interactionCloseUi", "", "configureAllConsentToggleColor", "vendorListData", "Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorListData;", "configureAllowAllConsentTitle", "configureButtons", "configureFilterIcon", "configureFilterIconColor", "isOn", "configureLayouts", "configurePageHeader", "configureSearchViewColors", "configureTabLayoutSelectedItem", "enabledButton", "Landroid/widget/Button;", "disabledButtonOne", "disabledButtonTwo", "configureTabLayoutVisibility", "handleItemToggleCheckedChange", "id", "", "vendorMode", "handleOnItemClicked", "vendorId", "initAdapters", "initializeClickListeners", "initializeFragments", "initializePurposeListFragment", "selectedFilterMapGV", "", "initializeSearchView", "initializeViewModel", "themeMode", "onBackButtonClicked", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onFilterVendorsClicked", "onVendorsConfirmChoicesButtonClicked", "onViewCreated", "view", "setEventListener", "setGeneralVendorAdapter", "setGoogleAdapter", "setIabAdapter", "setInteractionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOTInstance", "setSearchQuery", "Companion", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class OTVendorListFragment extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: a */
    public final FragmentViewBindingDelegate f1396a = C0026u.m161a(this, b.f1409a);

    /* JADX INFO: renamed from: b */
    public final Lazy f1397b;

    /* JADX INFO: renamed from: c */
    public C0002a f1398c;

    /* JADX INFO: renamed from: d */
    public OTConfiguration f1399d;

    /* JADX INFO: renamed from: e */
    public final C0074f f1400e;

    /* JADX INFO: renamed from: f */
    public InterfaceC0075c f1401f;

    /* JADX INFO: renamed from: g */
    public OTPublishersHeadlessSDK f1402g;

    /* JADX INFO: renamed from: h */
    public ViewOnClickListenerC0160f f1403h;

    /* JADX INFO: renamed from: i */
    public ViewOnClickListenerC0168n f1404i;

    /* JADX INFO: renamed from: j */
    public ViewOnClickListenerC0157c f1405j;

    /* JADX INFO: renamed from: k */
    public OTVendorAdapter f1406k;

    /* JADX INFO: renamed from: l */
    public OTVendorGoogleAdapter f1407l;

    /* JADX INFO: renamed from: m */
    public OTVendorGeneralAdapter f1408m;

    /* JADX INFO: renamed from: o */
    public static final /* synthetic */ KProperty<Object>[] f1395o = {Reflection.property1(new PropertyReference1Impl(OTVendorListFragment.class, "binding", "getBinding()Lcom/onetrust/otpublishers/headless/databinding/FragmentOtVendorsListBinding;", 0))};

    /* JADX INFO: renamed from: n */
    public static final a f1394n = new a();

    /* JADX INFO: renamed from: a.a.a.a.b.h.m$a */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/fragment/OTVendorListFragment$Companion;", "", "()V", "LOG_TAG", "", "newInstance", "Lcom/onetrust/otpublishers/headless/UI/fragment/OTVendorListFragment;", "fragmentTag", "eventListenerSetter", "Lcom/onetrust/otpublishers/headless/Internal/Event/EventListenerSetter;", "otConfiguration", "Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a {
        /* JADX INFO: renamed from: a */
        public final OTVendorListFragment m930a(String fragmentTag, C0002a c0002a, OTConfiguration oTConfiguration) {
            Intrinsics.checkNotNullParameter(fragmentTag, "fragmentTag");
            Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.m5605to(OTFragmentTags.FRAGMENT_TAG, fragmentTag));
            OTVendorListFragment oTVendorListFragment = new OTVendorListFragment();
            oTVendorListFragment.setArguments(bundleBundleOf);
            oTVendorListFragment.f1398c = c0002a;
            oTVendorListFragment.f1399d = oTConfiguration;
            return oTVendorListFragment;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.m$b */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, C0180c> {

        /* JADX INFO: renamed from: a */
        public static final b f1409a = new b();

        public b() {
            super(1, C0180c.class, "bind", "bind(Landroid/view/View;)Lcom/onetrust/otpublishers/headless/databinding/FragmentOtVendorsListBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0180c invoke(View view) {
            View viewFindViewById;
            View p0 = view;
            Intrinsics.checkNotNullParameter(p0, "p0");
            int i = C3896R.id.main_layout;
            View viewFindViewById2 = p0.findViewById(i);
            if (viewFindViewById2 == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(p0.getResources().getResourceName(i)));
            }
            int i2 = C3896R.id.VL_page_title;
            TextView textView = (TextView) viewFindViewById2.findViewById(i2);
            if (textView != null) {
                i2 = C3896R.id.all_consent_toggle;
                SwitchCompat switchCompat = (SwitchCompat) viewFindViewById2.findViewById(i2);
                if (switchCompat != null) {
                    i2 = C3896R.id.all_leg_int_toggle;
                    SwitchCompat switchCompat2 = (SwitchCompat) viewFindViewById2.findViewById(i2);
                    if (switchCompat2 != null) {
                        i2 = C3896R.id.allow_all_toggle;
                        SwitchCompat switchCompat3 = (SwitchCompat) viewFindViewById2.findViewById(i2);
                        if (switchCompat3 != null) {
                            i2 = C3896R.id.back_from_vendorlist;
                            ImageView imageView = (ImageView) viewFindViewById2.findViewById(i2);
                            if (imageView != null) {
                                i2 = C3896R.id.button_general_vendors;
                                AppCompatButton appCompatButton = (AppCompatButton) viewFindViewById2.findViewById(i2);
                                if (appCompatButton != null) {
                                    i2 = C3896R.id.button_google_vendors;
                                    AppCompatButton appCompatButton2 = (AppCompatButton) viewFindViewById2.findViewById(i2);
                                    if (appCompatButton2 != null) {
                                        i2 = C3896R.id.button_iab_vendors;
                                        AppCompatButton appCompatButton3 = (AppCompatButton) viewFindViewById2.findViewById(i2);
                                        if (appCompatButton3 != null) {
                                            i2 = C3896R.id.consent_text;
                                            TextView textView2 = (TextView) viewFindViewById2.findViewById(i2);
                                            if (textView2 != null) {
                                                i2 = C3896R.id.filter_vendors;
                                                ImageView imageView2 = (ImageView) viewFindViewById2.findViewById(i2);
                                                if (imageView2 != null) {
                                                    i2 = C3896R.id.footer_layout;
                                                    RelativeLayout relativeLayout = (RelativeLayout) viewFindViewById2.findViewById(i2);
                                                    if (relativeLayout != null) {
                                                        i2 = C3896R.id.leg_int_text;
                                                        TextView textView3 = (TextView) viewFindViewById2.findViewById(i2);
                                                        if (textView3 != null) {
                                                            i2 = C3896R.id.rv_vendors_list;
                                                            RecyclerView recyclerView = (RecyclerView) viewFindViewById2.findViewById(i2);
                                                            if (recyclerView != null) {
                                                                i2 = C3896R.id.search_bar_layout;
                                                                LinearLayout linearLayout = (LinearLayout) viewFindViewById2.findViewById(i2);
                                                                if (linearLayout != null) {
                                                                    i2 = C3896R.id.search_vendor;
                                                                    SearchView searchView = (SearchView) viewFindViewById2.findViewById(i2);
                                                                    if (searchView != null) {
                                                                        i2 = C3896R.id.tab_layout;
                                                                        CardView cardView = (CardView) viewFindViewById2.findViewById(i2);
                                                                        if (cardView != null) {
                                                                            i2 = C3896R.id.vendor_allow_all_title;
                                                                            TextView textView4 = (TextView) viewFindViewById2.findViewById(i2);
                                                                            if (textView4 != null) {
                                                                                i2 = C3896R.id.vendors_confirm_choices_btn;
                                                                                Button button = (Button) viewFindViewById2.findViewById(i2);
                                                                                if (button != null) {
                                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) viewFindViewById2;
                                                                                    i2 = C3896R.id.view2;
                                                                                    View viewFindViewById3 = viewFindViewById2.findViewById(i2);
                                                                                    if (viewFindViewById3 != null && (viewFindViewById = viewFindViewById2.findViewById((i2 = C3896R.id.view3))) != null) {
                                                                                        return new C0180c((CoordinatorLayout) p0, new C0185h(relativeLayout2, textView, switchCompat, switchCompat2, switchCompat3, imageView, appCompatButton, appCompatButton2, appCompatButton3, textView2, imageView2, relativeLayout, textView3, recyclerView, linearLayout, searchView, cardView, textView4, button, relativeLayout2, viewFindViewById3, viewFindViewById));
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById2.getResources().getResourceName(i2)));
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.m$c */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, m5598d2 = {"<anonymous>", "", "id", "", "isChecked", "", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class c extends Lambda implements Function2<String, Boolean, Unit> {
        public c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(String str, Boolean bool) {
            String id = str;
            boolean zBooleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(id, "id");
            OTVendorListFragment.m895a(OTVendorListFragment.this, id, zBooleanValue, OTVendorListMode.IAB);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.m$d */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m5598d2 = {"<anonymous>", "", "vendorId", "", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class d extends Lambda implements Function1<String, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String vendorId = str;
            Intrinsics.checkNotNullParameter(vendorId, "vendorId");
            OTVendorListFragment oTVendorListFragment = OTVendorListFragment.this;
            a aVar = OTVendorListFragment.f1394n;
            oTVendorListFragment.m915a(vendorId, OTVendorListMode.IAB);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.m$e */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, m5598d2 = {"<anonymous>", "", "id", "", "isChecked", "", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class e extends Lambda implements Function2<String, Boolean, Unit> {
        public e() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(String str, Boolean bool) {
            String id = str;
            boolean zBooleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(id, "id");
            OTVendorListFragment.m895a(OTVendorListFragment.this, id, zBooleanValue, OTVendorListMode.GOOGLE);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.m$f */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, m5598d2 = {"<anonymous>", "", "id", "", "isChecked", "", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class f extends Lambda implements Function2<String, Boolean, Unit> {
        public f() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(String str, Boolean bool) {
            String id = str;
            boolean zBooleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(id, "id");
            OTVendorListFragment.m895a(OTVendorListFragment.this, id, zBooleanValue, OTVendorListMode.GENERAL);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.m$g */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m5598d2 = {"<anonymous>", "", "vendorId", "", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class g extends Lambda implements Function1<String, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String vendorId = str;
            Intrinsics.checkNotNullParameter(vendorId, "vendorId");
            OTVendorListFragment oTVendorListFragment = OTVendorListFragment.this;
            a aVar = OTVendorListFragment.f1394n;
            oTVendorListFragment.m915a(vendorId, OTVendorListMode.GENERAL);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.m$h */
    @Metadata(m5597d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, m5598d2 = {"com/onetrust/otpublishers/headless/UI/fragment/OTVendorListFragment$initializeSearchView$1$1", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "onQueryTextChange", "", "newText", "", "onQueryTextSubmit", SearchIntents.EXTRA_QUERY, "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class h implements SearchView.OnQueryTextListener {
        public h() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String newText) {
            Intrinsics.checkNotNullParameter(newText, "newText");
            if (newText.length() == 0) {
                OTVendorListFragment oTVendorListFragment = OTVendorListFragment.this;
                a aVar = OTVendorListFragment.f1394n;
                oTVendorListFragment.m922c().m1017b("");
                return false;
            }
            OTVendorListFragment oTVendorListFragment2 = OTVendorListFragment.this;
            a aVar2 = OTVendorListFragment.f1394n;
            oTVendorListFragment2.m922c().m1017b(newText);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String query) {
            Intrinsics.checkNotNullParameter(query, "query");
            OTVendorListFragment oTVendorListFragment = OTVendorListFragment.this;
            a aVar = OTVendorListFragment.f1394n;
            oTVendorListFragment.m922c().m1017b(query);
            return false;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.m$i */
    @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$5"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class i extends Lambda implements Function0<Fragment> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Fragment f1416a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Fragment fragment) {
            super(0);
            this.f1416a = fragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public Fragment invoke() {
            return this.f1416a;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.m$j */
    @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStoreOwner;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$owner$4"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class j extends Lambda implements Function0<ViewModelStoreOwner> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Function0 f1417a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Function0 function0) {
            super(0);
            this.f1417a = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public ViewModelStoreOwner invoke() {
            return (ViewModelStoreOwner) this.f1417a.invoke();
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.m$k */
    @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$6"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class k extends Lambda implements Function0<ViewModelStore> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Lazy f1418a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(Lazy lazy) {
            super(0);
            this.f1418a = lazy;
        }

        @Override // kotlin.jvm.functions.Function0
        public ViewModelStore invoke() {
            ViewModelStore viewModelStore = FragmentViewModelLazyKt.m5792viewModels$lambda1(this.f1418a).getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner.viewModelStore");
            return viewModelStore;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.m$l */
    @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$7"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class l extends Lambda implements Function0<CreationExtras> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Lazy f1419a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(Function0 function0, Lazy lazy) {
            super(0);
            this.f1419a = lazy;
        }

        @Override // kotlin.jvm.functions.Function0
        public CreationExtras invoke() {
            ViewModelStoreOwner viewModelStoreOwnerM5792viewModels$lambda1 = FragmentViewModelLazyKt.m5792viewModels$lambda1(this.f1419a);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM5792viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM5792viewModels$lambda1 : null;
            CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
            return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.m$m */
    @Metadata(m5597d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m5598d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class m extends Lambda implements Function0<ViewModelProvider.Factory> {
        public m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            Application application = OTVendorListFragment.this.requireActivity().getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "requireActivity().application");
            return new OTVendorListViewModel.a(application);
        }
    }

    public OTVendorListFragment() {
        m mVar = new m();
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new j(new i(this)));
        this.f1397b = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OTVendorListViewModel.class), new k(lazy), new l(null, lazy), mVar);
        this.f1400e = new C0074f();
    }

    /* JADX INFO: renamed from: a */
    public static final void m887a(OTVendorListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m922c().m1023f();
    }

    /* JADX INFO: renamed from: a */
    public static final void m889a(OTVendorListFragment this$0, VendorListData vendorListData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(vendorListData, "$vendorListData");
        this$0.m928g(vendorListData);
    }

    /* JADX INFO: renamed from: a */
    public static final void m894a(OTVendorListFragment this$0, Boolean it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SwitchCompat switchCompat = this$0.m918b().f1612b.f1649c;
        Intrinsics.checkNotNullExpressionValue(it2, "it");
        switchCompat.setChecked(it2.booleanValue());
    }

    /* JADX INFO: renamed from: a */
    public static final void m895a(OTVendorListFragment oTVendorListFragment, String id, boolean z, String mode) {
        OTVendorListViewModel oTVendorListViewModelM922c = oTVendorListFragment.m922c();
        oTVendorListViewModelM922c.getClass();
        Intrinsics.checkNotNullParameter(mode, "vendorMode");
        Intrinsics.checkNotNullParameter(id, "id");
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = oTVendorListViewModelM922c.f1572d;
        if (oTPublishersHeadlessSDK != null) {
            oTPublishersHeadlessSDK.updateVendorConsent(mode, id, z);
        }
        oTVendorListViewModelM922c.m1014a(mode, id, z);
        C0003b c0003b = new C0003b(15);
        c0003b.f3b = id;
        c0003b.f4c = z ? 1 : 0;
        c0003b.f6e = mode;
        oTVendorListFragment.f1400e.m411a(c0003b, oTVendorListFragment.f1398c);
        oTVendorListFragment.f1400e.m411a(c0003b, oTVendorListFragment.f1398c);
        if (!z) {
            OTVendorListViewModel oTVendorListViewModelM922c2 = oTVendorListFragment.m922c();
            oTVendorListViewModelM922c2.getClass();
            Intrinsics.checkNotNullParameter(mode, "mode");
            if (Intrinsics.areEqual(mode, OTVendorListMode.IAB) ? oTVendorListViewModelM922c2.m1021d() : Intrinsics.areEqual(mode, OTVendorListMode.GOOGLE) ? oTVendorListViewModelM922c2.m1020c() : oTVendorListViewModelM922c2.m1018b()) {
                oTVendorListFragment.m918b().f1612b.f1649c.setChecked(z);
                return;
            }
            return;
        }
        OTVendorListViewModel oTVendorListViewModelM922c3 = oTVendorListFragment.m922c();
        oTVendorListViewModelM922c3.getClass();
        Intrinsics.checkNotNullParameter(mode, "mode");
        OTVendorUtils oTVendorUtils = oTVendorListViewModelM922c3.f1573e;
        if (oTVendorUtils != null) {
            oTVendorUtils.updateSelectAllButtonStatus(mode);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m896a(OTVendorListFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OTVendorAdapter oTVendorAdapter = this$0.f1406k;
        if (oTVendorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iabVendorAdapter");
            oTVendorAdapter = null;
        }
        oTVendorAdapter.submitList(list);
    }

    /* JADX INFO: renamed from: a */
    public static final void m898a(OTVendorListViewModel this_with, OTVendorListFragment this$0, Map it2) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this_with.m1021d()) {
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            this$0.m916a((Map<String, String>) it2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m899a(OTVendorListFragment this$0, DialogInterface dialogInterface, int i2, KeyEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "event");
        if (i2 != 4 || event.getAction() != 1) {
            return false;
        }
        this$0.f1400e.m411a(new C0003b(13), this$0.f1398c);
        this$0.m911a(3);
        return true;
    }

    /* JADX INFO: renamed from: b */
    public static final void m900b(OTVendorListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m922c().m1023f();
    }

    /* JADX INFO: renamed from: b */
    public static final void m901b(OTVendorListFragment this$0, VendorListData vendorListData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(vendorListData, "$vendorListData");
        this$0.m927f(vendorListData);
    }

    /* JADX INFO: renamed from: b */
    public static final void m903b(OTVendorListFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OTVendorGoogleAdapter oTVendorGoogleAdapter = this$0.f1407l;
        if (oTVendorGoogleAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleVendorAdapter");
            oTVendorGoogleAdapter = null;
        }
        oTVendorGoogleAdapter.submitList(list);
    }

    /* JADX INFO: renamed from: b */
    public static final void m904b(OTVendorListViewModel this_with, OTVendorListFragment this$0, Map it2) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this_with.m1021d()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it2, "it");
        this$0.m916a((Map<String, String>) it2);
    }

    /* JADX INFO: renamed from: c */
    public static final void m905c(OTVendorListFragment this$0, VendorListData vendorListData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(vendorListData, "$vendorListData");
        this$0.m926e(vendorListData);
    }

    /* JADX INFO: renamed from: c */
    public static final void m906c(OTVendorListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewOnClickListenerC0160f viewOnClickListenerC0160f = this$0.f1403h;
        ViewOnClickListenerC0160f viewOnClickListenerC0160f2 = null;
        if (viewOnClickListenerC0160f == null) {
            Intrinsics.throwUninitializedPropertyAccessException("purposeListFragment");
            viewOnClickListenerC0160f = null;
        }
        if (viewOnClickListenerC0160f.isAdded()) {
            return;
        }
        viewOnClickListenerC0160f.f1315q = (String) C0026u.m162a(this$0.m922c().f1575g);
        ViewOnClickListenerC0160f viewOnClickListenerC0160f3 = this$0.f1403h;
        if (viewOnClickListenerC0160f3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("purposeListFragment");
        } else {
            viewOnClickListenerC0160f2 = viewOnClickListenerC0160f3;
        }
        viewOnClickListenerC0160f2.show(this$0.getParentFragmentManager(), OTFragmentTags.OT_VENDOR_LIST_FILTER_FRAGMENT_TAG);
    }

    /* JADX INFO: renamed from: c */
    public static final void m907c(OTVendorListFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OTVendorGeneralAdapter oTVendorGeneralAdapter = this$0.f1408m;
        if (oTVendorGeneralAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("generalVendorAdapter");
            oTVendorGeneralAdapter = null;
        }
        oTVendorGeneralAdapter.submitList(list);
    }

    /* JADX INFO: renamed from: d */
    public static final void m909d(OTVendorListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m918b().f1612b.f1657k.setQuery(this$0.m922c().f1571c, true);
    }

    /* JADX INFO: renamed from: a */
    public final void m914a(OTPublishersHeadlessSDK otPublishersHeadlessSDK) {
        Intrinsics.checkNotNullParameter(otPublishersHeadlessSDK, "otPublishersHeadlessSDK");
        this.f1402g = otPublishersHeadlessSDK;
    }

    /* JADX INFO: renamed from: b */
    public final C0180c m918b() {
        return (C0180c) this.f1396a.getValue(this, f1395o[0]);
    }

    /* JADX INFO: renamed from: b */
    public final void m920b(boolean z, VendorListData vendorListData) {
        C0185h c0185h = m918b().f1612b;
        String str = z ? vendorListData.f208c : vendorListData.f209d;
        if (str == null) {
            return;
        }
        c0185h.f1654h.getDrawable().setTint(Color.parseColor(str));
    }

    /* JADX INFO: renamed from: c */
    public final OTVendorListViewModel m922c() {
        return (OTVendorListViewModel) this.f1397b.getValue();
    }

    /* JADX INFO: renamed from: c */
    public final void m923c(final VendorListData vendorListData) {
        final C0185h c0185h = m918b().f1612b;
        c0185h.f1649c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                OTVendorListFragment.m890a(this.f$0, vendorListData, compoundButton, z);
            }
        });
        c0185h.f1650d.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTVendorListFragment.m893a(this.f$0, view);
            }
        });
        c0185h.f1660n.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTVendorListFragment.m902b(this.f$0, view);
            }
        });
        c0185h.f1649c.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTVendorListFragment.m891a(this.f$0, c0185h, view);
            }
        });
        c0185h.f1654h.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTVendorListFragment.m906c(this.f$0, view);
            }
        });
        c0185h.f1653g.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTVendorListFragment.m889a(this.f$0, vendorListData, view);
            }
        });
        c0185h.f1652f.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTVendorListFragment.m901b(this.f$0, vendorListData, view);
            }
        });
        c0185h.f1651e.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTVendorListFragment.m905c(this.f$0, vendorListData, view);
            }
        });
    }

    /* JADX INFO: renamed from: d */
    public final void m924d() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                OTVendorListFragment.m909d(this.f$0);
            }
        });
    }

    /* JADX INFO: renamed from: d */
    public final void m925d(VendorListData vendorListData) {
        SearchView searchView = m918b().f1612b.f1657k;
        searchView.setIconifiedByDefault(false);
        searchView.onActionViewExpanded();
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new h());
        searchView.setOnCloseListener(new SearchView.OnCloseListener() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda9
            @Override // androidx.appcompat.widget.SearchView.OnCloseListener
            public final boolean onClose() {
                return OTVendorListFragment.m908c(this.f$0);
            }
        });
        m912a(vendorListData);
    }

    /* JADX INFO: renamed from: e */
    public final void m926e(VendorListData vendorListData) {
        C0185h c0185h = m918b().f1612b;
        m922c().m1019c(OTVendorListMode.GENERAL);
        m922c().m1023f();
        ImageView filterVendors = c0185h.f1654h;
        Intrinsics.checkNotNullExpressionValue(filterVendors, "filterVendors");
        filterVendors.setVisibility(0);
        SearchView searchVendor = c0185h.f1657k;
        Intrinsics.checkNotNullExpressionValue(searchVendor, "searchVendor");
        searchVendor.setVisibility(0);
        RecyclerView recyclerView = c0185h.f1656j;
        OTVendorGeneralAdapter oTVendorGeneralAdapter = this.f1408m;
        if (oTVendorGeneralAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("generalVendorAdapter");
            oTVendorGeneralAdapter = null;
        }
        recyclerView.setAdapter(oTVendorGeneralAdapter);
        boolean z = vendorListData.f218m;
        SwitchCompat allConsentToggle = c0185h.f1649c;
        Intrinsics.checkNotNullExpressionValue(allConsentToggle, "allConsentToggle");
        allConsentToggle.setVisibility(z ? 0 : 8);
        TextView vendorAllowAllTitle = c0185h.f1659m;
        Intrinsics.checkNotNullExpressionValue(vendorAllowAllTitle, "vendorAllowAllTitle");
        vendorAllowAllTitle.setVisibility(z ? 0 : 8);
        View view3 = c0185h.f1662p;
        Intrinsics.checkNotNullExpressionValue(view3, "view3");
        view3.setVisibility(z ? 0 : 8);
        AppCompatButton buttonGeneralVendors = c0185h.f1651e;
        Intrinsics.checkNotNullExpressionValue(buttonGeneralVendors, "buttonGeneralVendors");
        AppCompatButton buttonIabVendors = c0185h.f1653g;
        Intrinsics.checkNotNullExpressionValue(buttonIabVendors, "buttonIabVendors");
        AppCompatButton buttonGoogleVendors = c0185h.f1652f;
        Intrinsics.checkNotNullExpressionValue(buttonGoogleVendors, "buttonGoogleVendors");
        m913a(vendorListData, buttonGeneralVendors, buttonIabVendors, buttonGoogleVendors);
        m920b(!((Map) C0026u.m162a(m922c().f1578j)).isEmpty(), vendorListData);
    }

    /* JADX INFO: renamed from: f */
    public final void m927f(VendorListData vendorListData) {
        C0185h c0185h = m918b().f1612b;
        m922c().m1019c(OTVendorListMode.GOOGLE);
        m922c().m1023f();
        ImageView filterVendors = c0185h.f1654h;
        Intrinsics.checkNotNullExpressionValue(filterVendors, "filterVendors");
        filterVendors.setVisibility(8);
        SearchView searchVendor = c0185h.f1657k;
        Intrinsics.checkNotNullExpressionValue(searchVendor, "searchVendor");
        searchVendor.setVisibility(0);
        SwitchCompat allConsentToggle = c0185h.f1649c;
        Intrinsics.checkNotNullExpressionValue(allConsentToggle, "allConsentToggle");
        allConsentToggle.setVisibility(0);
        TextView vendorAllowAllTitle = c0185h.f1659m;
        Intrinsics.checkNotNullExpressionValue(vendorAllowAllTitle, "vendorAllowAllTitle");
        vendorAllowAllTitle.setVisibility(0);
        View view3 = c0185h.f1662p;
        Intrinsics.checkNotNullExpressionValue(view3, "view3");
        view3.setVisibility(0);
        RecyclerView recyclerView = c0185h.f1656j;
        OTVendorGoogleAdapter oTVendorGoogleAdapter = this.f1407l;
        if (oTVendorGoogleAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleVendorAdapter");
            oTVendorGoogleAdapter = null;
        }
        recyclerView.setAdapter(oTVendorGoogleAdapter);
        AppCompatButton buttonGoogleVendors = c0185h.f1652f;
        Intrinsics.checkNotNullExpressionValue(buttonGoogleVendors, "buttonGoogleVendors");
        AppCompatButton buttonIabVendors = c0185h.f1653g;
        Intrinsics.checkNotNullExpressionValue(buttonIabVendors, "buttonIabVendors");
        AppCompatButton buttonGeneralVendors = c0185h.f1651e;
        Intrinsics.checkNotNullExpressionValue(buttonGeneralVendors, "buttonGeneralVendors");
        m913a(vendorListData, buttonGoogleVendors, buttonIabVendors, buttonGeneralVendors);
    }

    /* JADX INFO: renamed from: g */
    public final void m928g(VendorListData vendorListData) {
        C0185h c0185h = m918b().f1612b;
        m922c().m1019c(OTVendorListMode.IAB);
        m922c().m1023f();
        ImageView filterVendors = c0185h.f1654h;
        Intrinsics.checkNotNullExpressionValue(filterVendors, "filterVendors");
        filterVendors.setVisibility(0);
        SearchView searchVendor = c0185h.f1657k;
        Intrinsics.checkNotNullExpressionValue(searchVendor, "searchVendor");
        searchVendor.setVisibility(0);
        SwitchCompat allConsentToggle = c0185h.f1649c;
        Intrinsics.checkNotNullExpressionValue(allConsentToggle, "allConsentToggle");
        allConsentToggle.setVisibility(0);
        TextView vendorAllowAllTitle = c0185h.f1659m;
        Intrinsics.checkNotNullExpressionValue(vendorAllowAllTitle, "vendorAllowAllTitle");
        vendorAllowAllTitle.setVisibility(0);
        View view3 = c0185h.f1662p;
        Intrinsics.checkNotNullExpressionValue(view3, "view3");
        view3.setVisibility(0);
        RecyclerView recyclerView = c0185h.f1656j;
        OTVendorAdapter oTVendorAdapter = this.f1406k;
        if (oTVendorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iabVendorAdapter");
            oTVendorAdapter = null;
        }
        recyclerView.setAdapter(oTVendorAdapter);
        AppCompatButton buttonIabVendors = c0185h.f1653g;
        Intrinsics.checkNotNullExpressionValue(buttonIabVendors, "buttonIabVendors");
        AppCompatButton buttonGeneralVendors = c0185h.f1651e;
        Intrinsics.checkNotNullExpressionValue(buttonGeneralVendors, "buttonGeneralVendors");
        AppCompatButton buttonGoogleVendors = c0185h.f1652f;
        Intrinsics.checkNotNullExpressionValue(buttonGoogleVendors, "buttonGoogleVendors");
        m913a(vendorListData, buttonIabVendors, buttonGeneralVendors, buttonGoogleVendors);
        m920b(m922c().m1022e(), vendorListData);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        OTVendorListViewModel oTVendorListViewModelM922c = m922c();
        Bundle arguments = getArguments();
        oTVendorListViewModelM922c.getClass();
        if (arguments != null) {
            oTVendorListViewModelM922c.m1019c((arguments.containsKey("generalVendors") && arguments.getBoolean("generalVendors")) ? OTVendorListMode.GENERAL : OTVendorListMode.IAB);
            String string = arguments.getString("PURPOSE_MAP");
            Map<String, String> value = (oTVendorListViewModelM922c.m1021d() ? oTVendorListViewModelM922c.f1577i : oTVendorListViewModelM922c.f1578j).getValue();
            if (value == null || value.isEmpty()) {
                Map<String, String> mapM1013a = oTVendorListViewModelM922c.m1013a(string);
                if (mapM1013a == null) {
                    mapM1013a = new LinkedHashMap<>();
                }
                oTVendorListViewModelM922c.m1015a(mapM1013a);
            }
        }
        FragmentActivity activity = getActivity();
        if (C0170b.m959a(activity, OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG)) {
            SharedPreferences sharedPreferences = activity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string2 = sharedPreferences.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (C0048h.m305b(string2)) {
                string2 = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            }
            if (!string2.equals(OTThemeConstants.OT_SDK_UI_THEME)) {
                String string3 = activity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
                if (!C0048h.m305b(string3)) {
                    str = string3;
                }
                if (!str.equals(OTThemeConstants.OT_THEME_APP_COMPACT_LIGHT_NO_ACTION_BAR_LANDSCAPE_FULL_SCREEN)) {
                    return;
                }
            }
            OTLogger.m2743a(3, "OneTrust", "set theme to OT defined theme ");
            setStyle(0, C3896R.style.OTSDKTheme);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(savedInstanceState)");
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                OTVendorListFragment.m892a(this.f$0, dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewM406a = this.f1400e.m406a(requireContext(), inflater, container, C3896R.layout.fragment_ot_vendors_list);
        Intrinsics.checkNotNullExpressionValue(viewM406a, "uiUtils.getOTView(requir…fragment_ot_vendors_list)");
        return viewM406a;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        OTVendorUtils oTVendorUtils = m922c().f1573e;
        if (oTVendorUtils != null) {
            oTVendorUtils.setSelectAllButtonListener(null);
        }
        this.f1398c = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (!m921b(C0074f.m394a(requireContext(), this.f1399d))) {
            dismiss();
            return;
        }
        OTConfiguration oTConfiguration = this.f1399d;
        ViewOnClickListenerC0168n viewOnClickListenerC0168n = new ViewOnClickListenerC0168n();
        Bundle bundle = new Bundle();
        bundle.putString(TypedValues.Custom.S_STRING, OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG);
        viewOnClickListenerC0168n.setArguments(bundle);
        viewOnClickListenerC0168n.f1440T = oTConfiguration;
        Intrinsics.checkNotNullExpressionValue(viewOnClickListenerC0168n, "newInstance(\n           …otConfiguration\n        )");
        this.f1404i = viewOnClickListenerC0168n;
        OTConfiguration oTConfiguration2 = this.f1399d;
        ViewOnClickListenerC0157c viewOnClickListenerC0157c = new ViewOnClickListenerC0157c();
        Bundle bundle2 = new Bundle();
        bundle2.putString(TypedValues.Custom.S_STRING, OTFragmentTags.OT_GENERAL_VENDOR_DETAILS_TAG);
        viewOnClickListenerC0157c.setArguments(bundle2);
        viewOnClickListenerC0157c.f1185z = oTConfiguration2;
        Intrinsics.checkNotNullExpressionValue(viewOnClickListenerC0157c, "newInstance(\n           …otConfiguration\n        )");
        this.f1405j = viewOnClickListenerC0157c;
        m924d();
    }

    /* JADX INFO: renamed from: b */
    public final void m919b(VendorListData vendorListData) {
        this.f1406k = new OTVendorAdapter(vendorListData, this.f1399d, new c(), new d());
        if (m922c().f1569a.m293o()) {
            this.f1407l = new OTVendorGoogleAdapter(vendorListData, this.f1399d, new e());
        }
        if (m922c().f1569a.f98b.m269b()) {
            C0016k c0016kM103a = new C0016k(requireContext()).m103a();
            Intrinsics.checkNotNullExpressionValue(c0016kM103a, "generalVendorHelper.vendorLabels");
            m918b().f1612b.f1651e.setText(c0016kM103a.f35a);
            if (!StringsKt.equals(m922c().f1569a.m290l(), "IAB2", true)) {
                m922c().m1019c(OTVendorListMode.GENERAL);
            }
            this.f1408m = new OTVendorGeneralAdapter(vendorListData, this.f1399d, m922c().f1569a.f98b.m270c(), new f(), new g());
        }
        OTVendorListViewModel oTVendorListViewModelM922c = m922c();
        if (oTVendorListViewModelM922c.m1018b()) {
            m926e(vendorListData);
        } else if (oTVendorListViewModelM922c.m1020c()) {
            m927f(vendorListData);
        } else {
            m928g(vendorListData);
        }
    }

    /* JADX INFO: renamed from: c */
    public static final boolean m908c(OTVendorListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m922c().m1017b("");
        return false;
    }

    /* JADX INFO: renamed from: b */
    public static final void m902b(OTVendorListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OTVendorListViewModel oTVendorListViewModelM922c = this$0.m922c();
        oTVendorListViewModelM922c.getClass();
        Intrinsics.checkNotNullParameter(OTConsentInteractionType.VENDOR_LIST_CONFIRM, OTVendorUtils.CONSENT_TYPE);
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = oTVendorListViewModelM922c.f1572d;
        if (oTPublishersHeadlessSDK != null) {
            oTPublishersHeadlessSDK.saveConsent(OTConsentInteractionType.VENDOR_LIST_CONFIRM);
        }
        this$0.f1400e.m411a(new C0003b(14), this$0.f1398c);
        C0003b c0003b = new C0003b(17);
        c0003b.f5d = OTConsentInteractionType.VENDOR_LIST_CONFIRM;
        this$0.f1400e.m411a(c0003b, this$0.f1398c);
        this$0.m911a(1);
    }

    /* JADX INFO: renamed from: a */
    public final void m911a(int i2) {
        dismiss();
        InterfaceC0075c interfaceC0075c = this.f1401f;
        if (interfaceC0075c != null) {
            interfaceC0075c.mo419a(i2);
        }
        ((Map) C0026u.m162a(m922c().f1577i)).clear();
    }

    /* JADX INFO: renamed from: a */
    public final void m917a(boolean z, VendorListData vendorListData) {
        C0074f c0074f;
        Context contextRequireContext;
        SwitchCompat switchCompat;
        String str;
        String str2;
        C0185h c0185h = m918b().f1612b;
        if (z) {
            c0074f = this.f1400e;
            contextRequireContext = requireContext();
            switchCompat = c0185h.f1649c;
            str = vendorListData.f211f;
            str2 = vendorListData.f212g;
        } else {
            c0074f = this.f1400e;
            contextRequireContext = requireContext();
            switchCompat = c0185h.f1649c;
            str = vendorListData.f211f;
            str2 = vendorListData.f213h;
        }
        c0074f.m413a(contextRequireContext, switchCompat, str, str2);
    }

    /* JADX INFO: renamed from: a */
    public final void m912a(VendorListData vendorListData) {
        SearchView searchView = m918b().f1612b.f1657k;
        C0104a0 c0104a0 = vendorListData.f219n;
        String str = c0104a0.f720i;
        Intrinsics.checkNotNullExpressionValue(str, "searchBarProperty.placeHolderText");
        if (str.length() > 0) {
            searchView.setQueryHint(c0104a0.f720i);
        }
        String str2 = c0104a0.f713b;
        if (str2 != null && str2.length() != 0) {
            ((EditText) searchView.findViewById(C0261R.id.search_src_text)).setTextColor(Color.parseColor(c0104a0.f713b));
        }
        String str3 = c0104a0.f714c;
        if (str3 != null && str3.length() != 0) {
            ((EditText) searchView.findViewById(C0261R.id.search_src_text)).setHintTextColor(Color.parseColor(c0104a0.f714c));
        }
        String str4 = c0104a0.f715d;
        if (str4 != null && str4.length() != 0) {
            ((ImageView) searchView.findViewById(C0261R.id.search_mag_icon)).setColorFilter(Color.parseColor(c0104a0.f715d), PorterDuff.Mode.SRC_IN);
        }
        String str5 = c0104a0.f717f;
        if (str5 != null && str5.length() != 0) {
            ((ImageView) searchView.findViewById(C0261R.id.search_close_btn)).setColorFilter(Color.parseColor(c0104a0.f717f), PorterDuff.Mode.SRC_IN);
        }
        searchView.findViewById(C0261R.id.search_edit_frame).setBackgroundResource(C3896R.drawable.ot_search_border);
        String str6 = c0104a0.f718g;
        String str7 = c0104a0.f716e;
        String str8 = c0104a0.f712a;
        String str9 = c0104a0.f719h;
        GradientDrawable gradientDrawable = new GradientDrawable();
        Intrinsics.checkNotNull(str6);
        gradientDrawable.setStroke(Integer.parseInt(str6), Color.parseColor(str7));
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor(str8));
        Intrinsics.checkNotNull(str9);
        gradientDrawable.setCornerRadius(Float.parseFloat(str9));
        searchView.findViewById(C0261R.id.search_edit_frame).setBackground(gradientDrawable);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m921b(int i2) {
        final OTVendorListViewModel oTVendorListViewModelM922c = m922c();
        if (this.f1402g == null) {
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            this.f1402g = new OTPublishersHeadlessSDK(context);
        }
        OTPublishersHeadlessSDK otPublishersHeadlessSDK = this.f1402g;
        Intrinsics.checkNotNull(otPublishersHeadlessSDK);
        oTVendorListViewModelM922c.getClass();
        Intrinsics.checkNotNullParameter(otPublishersHeadlessSDK, "otPublishersHeadlessSDK");
        oTVendorListViewModelM922c.f1572d = otPublishersHeadlessSDK;
        oTVendorListViewModelM922c.f1573e = otPublishersHeadlessSDK.getOtVendorUtils();
        if (!oTVendorListViewModelM922c.m1016a(i2)) {
            return false;
        }
        oTVendorListViewModelM922c.f1577i.observe(getViewLifecycleOwner(), new Observer() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda20
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OTVendorListFragment.m898a(oTVendorListViewModelM922c, this, (Map) obj);
            }
        });
        oTVendorListViewModelM922c.f1578j.observe(getViewLifecycleOwner(), new Observer() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda21
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OTVendorListFragment.m904b(oTVendorListViewModelM922c, this, (Map) obj);
            }
        });
        oTVendorListViewModelM922c.f1574f.observe(getViewLifecycleOwner(), new Observer() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OTVendorListFragment.m888a(this.f$0, (VendorListData) obj);
            }
        });
        oTVendorListViewModelM922c.f1579k.observe(getViewLifecycleOwner(), new Observer() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OTVendorListFragment.m896a(this.f$0, (List) obj);
            }
        });
        oTVendorListViewModelM922c.f1580l.observe(getViewLifecycleOwner(), new Observer() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OTVendorListFragment.m903b(this.f$0, (List) obj);
            }
        });
        oTVendorListViewModelM922c.f1581m.observe(getViewLifecycleOwner(), new Observer() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OTVendorListFragment.m907c(this.f$0, (List) obj);
            }
        });
        oTVendorListViewModelM922c.f1576h.observe(getViewLifecycleOwner(), new Observer() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OTVendorListFragment.m894a(this.f$0, (Boolean) obj);
            }
        });
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final void m913a(VendorListData vendorListData, Button button, Button button2, Button button3) {
        C0185h c0185h = m918b().f1612b;
        String str = vendorListData.f214i.f729b;
        OTVendorListViewModel oTVendorListViewModelM922c = m922c();
        String strMo378b = ((VendorListData) C0026u.m162a(oTVendorListViewModelM922c.f1574f)).f214i.mo378b();
        boolean z = true;
        if (strMo378b == null || strMo378b.length() == 0) {
            strMo378b = null;
        }
        if (strMo378b == null) {
            strMo378b = ((VendorListData) C0026u.m162a(oTVendorListViewModelM922c.f1574f)).f215j;
        }
        OTVendorListViewModel oTVendorListViewModelM922c2 = m922c();
        String str2 = ((VendorListData) C0026u.m162a(oTVendorListViewModelM922c2.f1574f)).f216k.f724c;
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        String str3 = z ? null : str2;
        if (str3 == null) {
            str3 = ((VendorListData) C0026u.m162a(oTVendorListViewModelM922c2.f1574f)).f217l;
        }
        C0026u.m174a(button, strMo378b);
        Intrinsics.checkNotNullParameter(button, "<this>");
        if (str != null && str.length() != 0) {
            button.setBackgroundColor(Color.parseColor(str));
        }
        C0026u.m174a(button2, str3);
        button2.setBackgroundColor(0);
        C0026u.m174a(button3, str3);
        button3.setBackgroundColor(0);
        c0185h.f1658l.setCardBackgroundColor(0);
    }

    /* JADX INFO: renamed from: a */
    public final void m910a() {
        C0185h c0185h = m918b().f1612b;
        if (StringsKt.equals("IAB2", m922c().f1569a.m290l(), true)) {
            boolean zM293o = m922c().f1569a.m293o();
            boolean zM269b = m922c().f1569a.f98b.m269b();
            CardView tabLayout = c0185h.f1658l;
            Intrinsics.checkNotNullExpressionValue(tabLayout, "tabLayout");
            tabLayout.setVisibility((zM293o || zM269b) ? 0 : 8);
            AppCompatButton buttonGeneralVendors = c0185h.f1651e;
            Intrinsics.checkNotNullExpressionValue(buttonGeneralVendors, "buttonGeneralVendors");
            buttonGeneralVendors.setVisibility(zM269b ? 0 : 8);
            AppCompatButton buttonGoogleVendors = c0185h.f1652f;
            Intrinsics.checkNotNullExpressionValue(buttonGoogleVendors, "buttonGoogleVendors");
            buttonGoogleVendors.setVisibility(zM293o ? 0 : 8);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m915a(String str, String str2) {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK;
        ViewOnClickListenerC0157c viewOnClickListenerC0157c = null;
        if (Intrinsics.areEqual(str2, OTVendorListMode.IAB)) {
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK2 = m922c().f1572d;
            if ((oTPublishersHeadlessSDK2 != null ? oTPublishersHeadlessSDK2.getVendorDetails(str2, str) : null) == null && (oTPublishersHeadlessSDK = m922c().f1572d) != null) {
                oTPublishersHeadlessSDK.reInitVendorArray();
            }
        }
        if (Intrinsics.areEqual(str2, OTVendorListMode.IAB)) {
            ViewOnClickListenerC0168n viewOnClickListenerC0168n = this.f1404i;
            if (viewOnClickListenerC0168n == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vendorsDetailsFragment");
                viewOnClickListenerC0168n = null;
            }
            if (viewOnClickListenerC0168n.isAdded() || getActivity() == null) {
                return;
            }
            ViewOnClickListenerC0168n viewOnClickListenerC0168n2 = this.f1404i;
            if (viewOnClickListenerC0168n2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vendorsDetailsFragment");
                viewOnClickListenerC0168n2 = null;
            }
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK3 = m922c().f1572d;
            if (oTPublishersHeadlessSDK3 != null) {
                viewOnClickListenerC0168n2.f1467v = oTPublishersHeadlessSDK3;
            }
            viewOnClickListenerC0168n2.f1443W = this.f1398c;
            viewOnClickListenerC0168n2.setArguments(BundleKt.bundleOf(TuplesKt.m5605to("vendorId", str)));
            viewOnClickListenerC0168n2.f1431K = new ViewOnClickListenerC0168n.b() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda7
                @Override // p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0168n.b
                /* JADX INFO: renamed from: a */
                public final void mo929a() {
                    OTVendorListFragment.m887a(this.f$0);
                }
            };
            viewOnClickListenerC0168n2.show(getParentFragmentManager(), OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG);
        }
        if (Intrinsics.areEqual(str2, OTVendorListMode.GENERAL)) {
            ViewOnClickListenerC0157c viewOnClickListenerC0157c2 = this.f1405j;
            if (viewOnClickListenerC0157c2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vendorsGeneralDetailsFragment");
                viewOnClickListenerC0157c2 = null;
            }
            if (viewOnClickListenerC0157c2.isAdded() || getActivity() == null) {
                return;
            }
            ViewOnClickListenerC0157c viewOnClickListenerC0157c3 = this.f1405j;
            if (viewOnClickListenerC0157c3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vendorsGeneralDetailsFragment");
            } else {
                viewOnClickListenerC0157c = viewOnClickListenerC0157c3;
            }
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK4 = m922c().f1572d;
            if (oTPublishersHeadlessSDK4 != null) {
                viewOnClickListenerC0157c.f1171l = oTPublishersHeadlessSDK4;
            }
            viewOnClickListenerC0157c.f1158E = this.f1398c;
            viewOnClickListenerC0157c.setArguments(BundleKt.bundleOf(TuplesKt.m5605to("vendorId", str)));
            viewOnClickListenerC0157c.f1178s = new ViewOnClickListenerC0157c.a() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda8
                @Override // p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0157c.a
                /* JADX INFO: renamed from: a */
                public final void mo801a() {
                    OTVendorListFragment.m900b(this.f$0);
                }
            };
            viewOnClickListenerC0157c.show(getParentFragmentManager(), OTFragmentTags.OT_GENERAL_VENDOR_DETAILS_TAG);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m890a(OTVendorListFragment this$0, VendorListData vendorListData, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(vendorListData, "$vendorListData");
        OTLogger.m2743a(3, "OneTrust", "onCreateViewSetOnCheckedChangeListener " + z);
        this$0.m917a(z, vendorListData);
    }

    /* JADX INFO: renamed from: a */
    public static final void m893a(OTVendorListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f1400e.m411a(new C0003b(13), this$0.f1398c);
        this$0.m911a(3);
    }

    /* JADX INFO: renamed from: a */
    public static final void m891a(OTVendorListFragment this$0, C0185h this_with, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        boolean zIsChecked = this_with.f1649c.isChecked();
        OTVendorListViewModel oTVendorListViewModelM922c = this$0.m922c();
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = oTVendorListViewModelM922c.f1572d;
        if (oTPublishersHeadlessSDK != null) {
            oTPublishersHeadlessSDK.updateAllVendorsConsentLocal((String) C0026u.m162a(oTVendorListViewModelM922c.f1575g), zIsChecked);
        }
        oTVendorListViewModelM922c.m1023f();
    }

    /* JADX INFO: renamed from: a */
    public final void m916a(Map<String, String> map) {
        OTConfiguration oTConfiguration = this.f1399d;
        String str = (String) C0026u.m162a(m922c().f1575g);
        ViewOnClickListenerC0160f viewOnClickListenerC0160f = new ViewOnClickListenerC0160f();
        Bundle bundle = new Bundle();
        bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_VENDOR_LIST_FILTER_FRAGMENT_TAG);
        viewOnClickListenerC0160f.setArguments(bundle);
        viewOnClickListenerC0160f.f1310l = map;
        viewOnClickListenerC0160f.f1309k = map;
        viewOnClickListenerC0160f.f1312n = oTConfiguration;
        viewOnClickListenerC0160f.f1315q = str;
        Intrinsics.checkNotNullExpressionValue(viewOnClickListenerC0160f, "newInstance(\n           …ireValue(),\n            )");
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = m922c().f1572d;
        if (oTPublishersHeadlessSDK != null) {
            viewOnClickListenerC0160f.f1307i = oTPublishersHeadlessSDK;
        }
        viewOnClickListenerC0160f.f1308j = new ViewOnClickListenerC0160f.a() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda10
            @Override // p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0160f.a
            /* JADX INFO: renamed from: a */
            public final void mo845a(Map map2) {
                OTVendorListFragment.m897a(this.f$0, map2);
            }
        };
        this.f1403h = viewOnClickListenerC0160f;
    }

    /* JADX INFO: renamed from: a */
    public static final void m897a(OTVendorListFragment this$0, Map selectedMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(selectedMap, "selectedMap");
        this$0.m922c().m1015a((Map<String, String>) selectedMap);
        this$0.m920b(!selectedMap.isEmpty(), (VendorListData) C0026u.m162a(this$0.m922c().f1574f));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0054  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m888a(p000a.p001a.p002a.p003a.p014b.fragment.OTVendorListFragment r11, p000a.p001a.p002a.p003a.p014b.DataModels.VendorListData r12) {
        /*
            Method dump skipped, instruction units count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.fragment.OTVendorListFragment.m888a(a.a.a.a.b.h.m, a.a.a.a.b.a.k):void");
    }

    /* JADX INFO: renamed from: a */
    public static final void m892a(final OTVendorListFragment this$0, DialogInterface dialogInterface) {
        C0127u c0127u;
        C0106b0 c0106b0;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogInterface, "dialogInterface");
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialogInterface;
        this$0.f1400e.m414a(this$0.requireActivity(), bottomSheetDialog);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setCanceledOnTouchOutside(false);
        VendorListData value = this$0.m922c().f1574f.getValue();
        if (value != null && (c0127u = value.f225t) != null && (c0106b0 = c0127u.f856a) != null) {
            bottomSheetDialog.setTitle(c0106b0.f726e);
        }
        bottomSheetDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: a.a.a.a.b.h.m$$ExternalSyntheticLambda13
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i2, KeyEvent keyEvent) {
                return OTVendorListFragment.m899a(this.f$0, dialogInterface2, i2, keyEvent);
            }
        });
    }
}
