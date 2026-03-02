package p000a.p001a.p002a.p003a.p014b.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.C0261R;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p014b.DataModels.SDKItem;
import p000a.p001a.p002a.p003a.p014b.DataModels.SDKListData;
import p000a.p001a.p002a.p003a.p014b.adapter.InterfaceC0138f;
import p000a.p001a.p002a.p003a.p014b.adapter.OTSDKAdapter;
import p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0164j;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0104a0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0114h;
import p000a.p001a.p002a.p003a.p014b.p021e.C0128v;
import p000a.p001a.p002a.p003a.p014b.p021e.C0130x;
import p000a.p001a.p002a.p003a.p014b.p021e.C0132z;
import p000a.p001a.p002a.p003a.p014b.p025i.C0169a;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;
import p000a.p001a.p002a.p003a.p014b.p025i.C0171c;
import p000a.p001a.p002a.p003a.p014b.p025i.C0174f;
import p000a.p001a.p002a.p003a.p014b.viewmodel.OTSDKListViewModel;
import p000a.p001a.p002a.p003a.p027c.C0179b;
import p000a.p001a.p002a.p003a.p027c.C0183f;

/* JADX INFO: renamed from: a.a.a.a.b.h.g, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 S2\u00020\u0001:\u0001SB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001fH\u0002J\u0019\u0010(\u001a\u00020\u001d2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001fH\u0002J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010.\u001a\u00020\u001dH\u0002J\u0010\u0010/\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u00100\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u00101\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0002J\b\u00102\u001a\u00020\u001dH\u0002J\u0016\u00103\u001a\u00020\u001d2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0002J\b\u00107\u001a\u00020\u001dH\u0002J\u0010\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:H\u0003J\u0010\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020=H\u0016J\u0012\u0010>\u001a\u00020\u001d2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010A\u001a\u00020B2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J$\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010I\u001a\u00020\u001dH\u0016J\u0010\u0010J\u001a\u00020\u001d2\u0006\u0010K\u001a\u00020@H\u0016J\u001a\u0010L\u001a\u00020\u001d2\u0006\u0010M\u001a\u00020D2\b\u0010?\u001a\u0004\u0018\u00010@H\u0017J\u000e\u0010N\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020\u0013J\b\u0010Q\u001a\u00020\u001dH\u0002J\b\u0010R\u001a\u00020\u001dH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006T"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/fragment/OTSDKListFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "_binding", "Lcom/onetrust/otpublishers/headless/databinding/FragmentOtSdkListBinding;", "binding", "getBinding", "()Lcom/onetrust/otpublishers/headless/databinding/FragmentOtSdkListBinding;", "bottomSheetDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "otConfiguration", "Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;", "otPublishersHeadlessSDK", "Lcom/onetrust/otpublishers/headless/Public/OTPublishersHeadlessSDK;", "otSdkListFilterFragment", "Lcom/onetrust/otpublishers/headless/UI/fragment/OTSdkListFilterFragment;", "sdkAdapter", "Lcom/onetrust/otpublishers/headless/UI/adapter/OTSDKAdapter;", "sdkListener", "Lcom/onetrust/otpublishers/headless/UI/adapter/OTSDKListItemAdapter$OTSdkListener;", "uiUtils", "Lcom/onetrust/otpublishers/headless/UI/Helper/UIUtils;", "viewModel", "Lcom/onetrust/otpublishers/headless/UI/viewmodel/OTSDKListViewModel;", "getViewModel", "()Lcom/onetrust/otpublishers/headless/UI/viewmodel/OTSDKListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "allowAllOnClick", "", "isChecked", "", "closeSearchView", "closeViews", "configureAllowAllToggle", "sdkListData", "Lcom/onetrust/otpublishers/headless/UI/DataModels/SDKListData;", "configureAllowAllToggleColor", "configureAllowAllVisibility", "isVisible", "configureFilterButton", "isEmptySelected", "(Ljava/lang/Boolean;)V", "configureFilterButtonColor", "isOn", "configureHeaderElements", "configureSearchBar", "configureSearchbarColors", "configureUIElements", "initializeAdapter", "initializeClickListeners", "initializeOtSdkListFilterFragment", "currentSelectedCategories", "", "", "initializeRecyclerview", "initializeViewModel", "themeMode", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onSaveInstanceState", "outState", "onViewCreated", "view", "setOTInstance", "setSdkClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSearchQuery", "showOTSdkListFilterFragment", "Companion", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class OTSDKListFragment extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: j */
    public static final a f1316j = new a();

    /* JADX INFO: renamed from: a */
    public C0179b f1317a;

    /* JADX INFO: renamed from: b */
    public final Lazy f1318b;

    /* JADX INFO: renamed from: c */
    public OTPublishersHeadlessSDK f1319c;

    /* JADX INFO: renamed from: d */
    public OTConfiguration f1320d;

    /* JADX INFO: renamed from: e */
    public final C0074f f1321e;

    /* JADX INFO: renamed from: f */
    public InterfaceC0138f f1322f;

    /* JADX INFO: renamed from: g */
    public OTSDKAdapter f1323g;

    /* JADX INFO: renamed from: h */
    public BottomSheetDialog f1324h;

    /* JADX INFO: renamed from: i */
    public ViewOnClickListenerC0164j f1325i;

    /* JADX INFO: renamed from: a.a.a.a.b.h.g$a */
    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/fragment/OTSDKListFragment$Companion;", "", "()V", "LOG_TAG", "", "newInstance", "Lcom/onetrust/otpublishers/headless/UI/fragment/OTSDKListFragment;", "fragmentTag", "otConfiguration", "Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a {
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.g$b */
    @Metadata(m5597d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, m5598d2 = {"com/onetrust/otpublishers/headless/UI/fragment/OTSDKListFragment$configureSearchBar$1$1", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "onQueryTextChange", "", "newText", "", "onQueryTextSubmit", SearchIntents.EXTRA_QUERY, "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class b implements SearchView.OnQueryTextListener {
        public b() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String newText) {
            Intrinsics.checkNotNullParameter(newText, "newText");
            if (newText.length() == 0) {
                OTSDKListFragment.this.m869c().m1006a("");
                return false;
            }
            OTSDKListFragment.this.m869c().m1006a(newText);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String query) {
            Intrinsics.checkNotNullParameter(query, "query");
            OTSDKListFragment.this.m869c().m1006a(query);
            return false;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.g$c */
    @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$5"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class c extends Lambda implements Function0<Fragment> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Fragment f1327a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.f1327a = fragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public Fragment invoke() {
            return this.f1327a;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.g$d */
    @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStoreOwner;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$owner$4"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class d extends Lambda implements Function0<ViewModelStoreOwner> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Function0 f1328a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Function0 function0) {
            super(0);
            this.f1328a = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public ViewModelStoreOwner invoke() {
            return (ViewModelStoreOwner) this.f1328a.invoke();
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.g$e */
    @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$6"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class e extends Lambda implements Function0<ViewModelStore> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Lazy f1329a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Lazy lazy) {
            super(0);
            this.f1329a = lazy;
        }

        @Override // kotlin.jvm.functions.Function0
        public ViewModelStore invoke() {
            ViewModelStore viewModelStore = FragmentViewModelLazyKt.m5792viewModels$lambda1(this.f1329a).getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner.viewModelStore");
            return viewModelStore;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.g$f */
    @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$7"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class f extends Lambda implements Function0<CreationExtras> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Lazy f1330a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Function0 function0, Lazy lazy) {
            super(0);
            this.f1330a = lazy;
        }

        @Override // kotlin.jvm.functions.Function0
        public CreationExtras invoke() {
            ViewModelStoreOwner viewModelStoreOwnerM5792viewModels$lambda1 = FragmentViewModelLazyKt.m5792viewModels$lambda1(this.f1330a);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM5792viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM5792viewModels$lambda1 : null;
            CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
            return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.g$g */
    @Metadata(m5597d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m5598d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class g extends Lambda implements Function0<ViewModelProvider.Factory> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            Application application = OTSDKListFragment.this.requireActivity().getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "requireActivity().application");
            return new OTSDKListViewModel.a(application);
        }
    }

    public OTSDKListFragment() {
        g gVar = new g();
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new d(new c(this)));
        this.f1318b = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OTSDKListViewModel.class), new e(lazy), new f(null, lazy), gVar);
        this.f1321e = new C0074f();
    }

    /* JADX INFO: renamed from: a */
    public static final void m847a(OTSDKListFragment this$0, SDKListData sdkListData, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sdkListData, "$sdkListData");
        this$0.m864a(z, sdkListData);
    }

    /* JADX INFO: renamed from: a */
    public static final void m849a(final OTSDKListFragment this$0, DialogInterface dialogInterface) {
        BottomSheetDialog bottomSheetDialog;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogInterface, "dialogInterface");
        this$0.f1324h = (BottomSheetDialog) dialogInterface;
        this$0.f1321e.m414a(this$0.getActivity(), this$0.f1324h);
        BottomSheetDialog bottomSheetDialog2 = this$0.f1324h;
        if (bottomSheetDialog2 != null) {
            bottomSheetDialog2.setCancelable(false);
        }
        BottomSheetDialog bottomSheetDialog3 = this$0.f1324h;
        if (bottomSheetDialog3 != null) {
            bottomSheetDialog3.setCanceledOnTouchOutside(false);
        }
        if (this$0.requireArguments().containsKey("SDK_LIST_VIEW_TITLE") && (bottomSheetDialog = this$0.f1324h) != null && bottomSheetDialog != null) {
            bottomSheetDialog.setTitle(this$0.requireArguments().getString("SDK_LIST_VIEW_TITLE"));
        }
        BottomSheetDialog bottomSheetDialog4 = this$0.f1324h;
        if (bottomSheetDialog4 != null) {
            bottomSheetDialog4.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: a.a.a.a.b.h.g$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface2, int i, KeyEvent keyEvent) {
                    return OTSDKListFragment.m855a(this.f$0, dialogInterface2, i, keyEvent);
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m850a(OTSDKListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m859a();
    }

    /* JADX INFO: renamed from: a */
    public static final void m852a(OTSDKListFragment this$0, List it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it2, "it");
        this$0.m862a((List<String>) it2);
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m855a(OTSDKListFragment this$0, DialogInterface dialogInterface, int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "event");
        if (i != 4 || event.getAction() != 1) {
            return false;
        }
        this$0.m859a();
        return true;
    }

    /* JADX INFO: renamed from: b */
    public static final void m858b(OTSDKListFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OTSDKAdapter oTSDKAdapter = this$0.f1323g;
        if (oTSDKAdapter != null) {
            oTSDKAdapter.submitList(list);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m859a() {
        dismiss();
        m869c().m1005a();
        OTSDKListViewModel oTSDKListViewModelM869c = m869c();
        for (String str : oTSDKListViewModelM869c.f1562m.keySet()) {
            JSONArray it2 = oTSDKListViewModelM869c.f1559j.m193b(str);
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            int length = it2.length();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                String string = it2.get(i3).toString();
                OTPublishersHeadlessSDK oTPublishersHeadlessSDK = oTSDKListViewModelM869c.f1551b;
                if (oTPublishersHeadlessSDK == null || oTPublishersHeadlessSDK.getConsentStatusForSDKId(string) != 0) {
                    OTPublishersHeadlessSDK oTPublishersHeadlessSDK2 = oTSDKListViewModelM869c.f1551b;
                    if (oTPublishersHeadlessSDK2 != null && 1 == oTPublishersHeadlessSDK2.getConsentStatusForSDKId(string) && (i2 = i2 + 1) == it2.length()) {
                        OTPublishersHeadlessSDK oTPublishersHeadlessSDK3 = oTSDKListViewModelM869c.f1551b;
                        if (oTPublishersHeadlessSDK3 != null) {
                            oTPublishersHeadlessSDK3.updatePurposeConsent(str, true, true);
                        }
                        i2 = 0;
                    }
                } else {
                    i++;
                    if (i == it2.length()) {
                        OTPublishersHeadlessSDK oTPublishersHeadlessSDK4 = oTSDKListViewModelM869c.f1551b;
                        if (oTPublishersHeadlessSDK4 != null) {
                            oTPublishersHeadlessSDK4.updatePurposeConsent(str, false, true);
                        }
                        i = 0;
                    }
                }
            }
        }
        InterfaceC0138f interfaceC0138f = this.f1322f;
        if (interfaceC0138f != null) {
            interfaceC0138f.mo711a();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m868b(boolean z) {
        C0179b c0179b = this.f1317a;
        Intrinsics.checkNotNull(c0179b);
        ImageView imageView = c0179b.f1609b.f1631c;
        if (m869c().f1566q.getValue() == null) {
            return;
        }
        String str = z ? ((SDKListData) C0026u.m162a(m869c().f1566q)).f185d : ((SDKListData) C0026u.m162a(m869c().f1566q)).f186e;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        C0026u.m175a(imageView, str);
    }

    /* JADX INFO: renamed from: c */
    public final OTSDKListViewModel m869c() {
        return (OTSDKListViewModel) this.f1318b.getValue();
    }

    /* JADX INFO: renamed from: d */
    public final void m870d() {
        C0179b c0179b = this.f1317a;
        Intrinsics.checkNotNull(c0179b);
        final C0183f c0183f = c0179b.f1609b;
        c0183f.f1630b.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.g$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTSDKListFragment.m850a(this.f$0, view);
            }
        });
        c0183f.f1631c.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.g$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTSDKListFragment.m857b(this.f$0, view);
            }
        });
        c0183f.f1634f.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.g$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTSDKListFragment.m848a(this.f$0, c0183f, view);
            }
        });
    }

    /* JADX INFO: renamed from: e */
    public final void m871e() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: a.a.a.a.b.h.g$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OTSDKListFragment.m856b(this.f$0);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.f1321e.m414a(requireActivity(), this.f1324h);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        OTSDKListViewModel oTSDKListViewModelM869c = m869c();
        Bundle arguments = getArguments();
        oTSDKListViewModelM869c.getClass();
        if (arguments != null) {
            oTSDKListViewModelM869c.f1554e = arguments.getString("ALWAYS_ACTIVE_TEXT", "Always Active");
            oTSDKListViewModelM869c.f1555f = arguments.getString("ALWAYS_ACTIVE_TEXT_COLOR");
            oTSDKListViewModelM869c.f1553d = arguments.getString("sdkLevelOptOutShow");
            oTSDKListViewModelM869c.m1008b(arguments.getString("OT_GROUP_ID_LIST"));
        }
        FragmentActivity activity = getActivity();
        if (C0170b.m959a(activity, OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG)) {
            SharedPreferences sharedPreferences = activity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string = sharedPreferences.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (C0048h.m305b(string)) {
                string = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            }
            if (!string.equals(OTThemeConstants.OT_SDK_UI_THEME)) {
                String string2 = activity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
                if (!C0048h.m305b(string2)) {
                    str = string2;
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: a.a.a.a.b.h.g$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                OTSDKListFragment.m849a(this.f$0, dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewFindViewById;
        View viewFindViewById2;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewM406a = this.f1321e.m406a(requireContext(), inflater, container, C3896R.layout.fragment_ot_sdk_list);
        int i = C3896R.id.main_layout;
        View viewFindViewById3 = viewM406a.findViewById(i);
        if (viewFindViewById3 == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewM406a.getResources().getResourceName(i)));
        }
        int i2 = C3896R.id.back_from_sdklist;
        ImageView imageView = (ImageView) viewFindViewById3.findViewById(i2);
        if (imageView != null) {
            i2 = C3896R.id.filter_sdk;
            ImageView imageView2 = (ImageView) viewFindViewById3.findViewById(i2);
            if (imageView2 != null) {
                i2 = C3896R.id.rv_sdk_list;
                RecyclerView recyclerView = (RecyclerView) viewFindViewById3.findViewById(i2);
                if (recyclerView != null) {
                    i2 = C3896R.id.sdk_allow_all_title;
                    TextView textView = (TextView) viewFindViewById3.findViewById(i2);
                    if (textView != null) {
                        i2 = C3896R.id.sdk_allow_all_toggle;
                        SwitchCompat switchCompat = (SwitchCompat) viewFindViewById3.findViewById(i2);
                        if (switchCompat != null) {
                            i2 = C3896R.id.sdk_list_page_title;
                            TextView textView2 = (TextView) viewFindViewById3.findViewById(i2);
                            if (textView2 != null) {
                                RelativeLayout relativeLayout = (RelativeLayout) viewFindViewById3;
                                i2 = C3896R.id.sdk_title;
                                TextView textView3 = (TextView) viewFindViewById3.findViewById(i2);
                                if (textView3 != null) {
                                    i2 = C3896R.id.search_sdk;
                                    SearchView searchView = (SearchView) viewFindViewById3.findViewById(i2);
                                    if (searchView != null && (viewFindViewById = viewFindViewById3.findViewById((i2 = C3896R.id.view2))) != null && (viewFindViewById2 = viewFindViewById3.findViewById((i2 = C3896R.id.view3))) != null) {
                                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewM406a;
                                        C0179b c0179b = new C0179b(coordinatorLayout, new C0183f(relativeLayout, imageView, imageView2, recyclerView, textView, switchCompat, textView2, relativeLayout, textView3, searchView, viewFindViewById, viewFindViewById2), coordinatorLayout);
                                        this.f1317a = c0179b;
                                        Intrinsics.checkNotNull(c0179b);
                                        CoordinatorLayout coordinatorLayout2 = c0179b.f1608a;
                                        Intrinsics.checkNotNullExpressionValue(coordinatorLayout2, "binding.root");
                                        return coordinatorLayout2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById3.getResources().getResourceName(i2)));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f1317a = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putInt("NAV_FROM_PCDETAILS", !m869c().f1556g ? 1 : 0);
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("NAV_FROM_PCDETAILS")) {
            int i = savedInstanceState.getInt("NAV_FROM_PCDETAILS");
            m869c().f1552c = i == 1;
            savedInstanceState.remove("NAV_FROM_PCDETAILS");
        }
        if (!m865a(C0074f.m394a(requireContext(), this.f1320d))) {
            dismiss();
            return;
        }
        m870d();
        C0179b c0179b = this.f1317a;
        Intrinsics.checkNotNull(c0179b);
        c0179b.f1609b.f1632d.setLayoutManager(new LinearLayoutManager(requireContext()));
        m871e();
    }

    /* JADX INFO: renamed from: b */
    public final void m866b() {
        C0179b c0179b = this.f1317a;
        Intrinsics.checkNotNull(c0179b);
        SearchView searchView = c0179b.f1609b.f1638j;
        searchView.setIconifiedByDefault(false);
        searchView.onActionViewExpanded();
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new b());
        searchView.setOnCloseListener(new SearchView.OnCloseListener() { // from class: a.a.a.a.b.h.g$$ExternalSyntheticLambda5
            @Override // androidx.appcompat.widget.SearchView.OnCloseListener
            public final boolean onClose() {
                return OTSDKListFragment.m854a(this.f$0);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final void m860a(final SDKListData sDKListData) {
        C0179b c0179b = this.f1317a;
        Intrinsics.checkNotNull(c0179b);
        SwitchCompat switchCompat = c0179b.f1609b.f1634f;
        switchCompat.setContentDescription(sDKListData.f191j);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.h.g$$ExternalSyntheticLambda6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                OTSDKListFragment.m847a(this.f$0, sDKListData, compoundButton, z);
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public final void m867b(SDKListData sDKListData) {
        C0179b c0179b = this.f1317a;
        Intrinsics.checkNotNull(c0179b);
        SearchView searchView = c0179b.f1609b.f1638j;
        String str = sDKListData.f194m.f720i;
        Intrinsics.checkNotNullExpressionValue(str, "sdkListData.searchBarProperty.placeHolderText");
        if (str.length() > 0) {
            searchView.setQueryHint(sDKListData.f194m.f720i);
        }
        EditText editText = (EditText) searchView.findViewById(C0261R.id.search_src_text);
        String str2 = sDKListData.f194m.f713b;
        if (str2 != null && str2.length() != 0) {
            editText.setTextColor(Color.parseColor(sDKListData.f194m.f713b));
        }
        String str3 = sDKListData.f194m.f714c;
        if (str3 != null && str3.length() != 0) {
            editText.setHintTextColor(Color.parseColor(sDKListData.f194m.f714c));
        }
        String str4 = sDKListData.f194m.f715d;
        if (str4 != null && str4.length() != 0) {
            ((ImageView) searchView.findViewById(C0261R.id.search_mag_icon)).setColorFilter(Color.parseColor(sDKListData.f194m.f715d), PorterDuff.Mode.SRC_IN);
        }
        String str5 = sDKListData.f194m.f717f;
        if (str5 != null && str5.length() != 0) {
            ((ImageView) searchView.findViewById(C0261R.id.search_close_btn)).setColorFilter(Color.parseColor(sDKListData.f194m.f717f), PorterDuff.Mode.SRC_IN);
        }
        View viewFindViewById = searchView.findViewById(C0261R.id.search_edit_frame);
        viewFindViewById.setBackgroundResource(C3896R.drawable.ot_search_border);
        C0104a0 c0104a0 = sDKListData.f194m;
        String str6 = c0104a0.f718g;
        boolean z = true;
        if (str6 == null || str6.length() == 0) {
            str6 = null;
        }
        if (str6 == null) {
            str6 = "0";
        }
        Intrinsics.checkNotNullExpressionValue(str6, "searchBarProperty.border….isNullOrEmpty() } ?: \"0\"");
        String str7 = c0104a0.f716e;
        if (str7 == null || str7.length() == 0) {
            str7 = null;
        }
        if (str7 == null) {
            str7 = sDKListData.f184c;
        }
        String str8 = c0104a0.f712a;
        if (str8 == null || str8.length() == 0) {
            str8 = null;
        }
        if (str8 == null) {
            str8 = "#2D6B6767";
        }
        Intrinsics.checkNotNullExpressionValue(str8, "searchBarProperty.backGr…nstants.TRANSPARENT_COLOR");
        String str9 = c0104a0.f719h;
        if (str9 != null && str9.length() != 0) {
            z = false;
        }
        String str10 = z ? null : str9;
        if (str10 == null) {
            str10 = "20";
        }
        Intrinsics.checkNotNullExpressionValue(str10, "searchBarProperty.border…isNullOrEmpty() } ?: \"20\"");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(Integer.parseInt(str6), Color.parseColor(str7));
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor(str8));
        gradientDrawable.setCornerRadius(Float.parseFloat(str10));
        viewFindViewById.setBackground(gradientDrawable);
    }

    /* JADX INFO: renamed from: a */
    public final void m864a(boolean z, SDKListData sDKListData) {
        C0074f c0074f;
        Context contextRequireContext;
        SwitchCompat switchCompat;
        String str;
        String str2;
        C0179b c0179b = this.f1317a;
        Intrinsics.checkNotNull(c0179b);
        C0183f c0183f = c0179b.f1609b;
        if (z) {
            c0074f = this.f1321e;
            contextRequireContext = requireContext();
            switchCompat = c0183f.f1634f;
            str = sDKListData.f190i;
            str2 = sDKListData.f188g;
        } else {
            c0074f = this.f1321e;
            contextRequireContext = requireContext();
            switchCompat = c0183f.f1634f;
            str = sDKListData.f190i;
            str2 = sDKListData.f189h;
        }
        c0074f.m413a(contextRequireContext, switchCompat, str, str2);
    }

    /* JADX INFO: renamed from: a */
    public final void m863a(boolean z) {
        C0179b c0179b = this.f1317a;
        Intrinsics.checkNotNull(c0179b);
        C0183f c0183f = c0179b.f1609b;
        SwitchCompat sdkAllowAllToggle = c0183f.f1634f;
        Intrinsics.checkNotNullExpressionValue(sdkAllowAllToggle, "sdkAllowAllToggle");
        sdkAllowAllToggle.setVisibility(z ? 0 : 8);
        TextView sdkAllowAllTitle = c0183f.f1633e;
        Intrinsics.checkNotNullExpressionValue(sdkAllowAllTitle, "sdkAllowAllTitle");
        sdkAllowAllTitle.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: renamed from: a */
    public final void m861a(Boolean bool) {
        C0179b c0179b = this.f1317a;
        Intrinsics.checkNotNull(c0179b);
        C0183f c0183f = c0179b.f1609b;
        C0114h c0114h = ((SDKListData) C0026u.m162a(m869c().f1566q)).f196o.f871o;
        Intrinsics.checkNotNullExpressionValue(c0114h, "viewModel.sdkListData.re…operty.filterIconProperty");
        if (bool == null) {
            m868b(m869c().f1552c);
            String strM646b = m869c().f1552c ? c0114h.m646b() : c0114h.m647c();
            Intrinsics.checkNotNullExpressionValue(strM646b, "if (viewModel.isFiltered…ARIALabelStatus\n        }");
            c0183f.f1631c.setContentDescription(strM646b + c0114h.m645a());
            return;
        }
        bool.booleanValue();
        m868b(bool.booleanValue());
        String strM647c = bool.booleanValue() ? c0114h.m647c() : c0114h.m646b();
        Intrinsics.checkNotNullExpressionValue(strM647c, "if (isEmptySelected) {\n …LabelStatus\n            }");
        c0183f.f1631c.setContentDescription(strM647c + c0114h.m645a());
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m854a(OTSDKListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m869c().m1006a("");
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static final void m848a(OTSDKListFragment this$0, C0183f this_with, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        boolean zIsChecked = this_with.f1634f.isChecked();
        OTSDKListViewModel oTSDKListViewModelM869c = this$0.m869c();
        oTSDKListViewModelM869c.f1561l.clear();
        oTSDKListViewModelM869c.f1562m.clear();
        Object objM162a = C0026u.m162a(oTSDKListViewModelM869c.f1565p);
        Intrinsics.checkNotNullExpressionValue(objM162a, "_sdkItems.requireValue()");
        for (SDKItem sDKItem : (Iterable) objM162a) {
            oTSDKListViewModelM869c.f1561l.add(sDKItem.f173a);
            String groupId = oTSDKListViewModelM869c.f1559j.m191a(sDKItem.f173a);
            if (groupId != null) {
                Map<String, List<String>> map = oTSDKListViewModelM869c.f1562m;
                Intrinsics.checkNotNullExpressionValue(groupId, "groupId");
                map.put(groupId, oTSDKListViewModelM869c.f1561l);
            }
        }
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = oTSDKListViewModelM869c.f1551b;
        if (oTPublishersHeadlessSDK != null) {
            List<String> list = oTSDKListViewModelM869c.f1561l;
            Intrinsics.checkNotNullParameter(list, "<this>");
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                jSONArray.put((String) it2.next());
            }
            oTPublishersHeadlessSDK.updateAllSDKConsentStatus(jSONArray, zIsChecked);
        }
        oTSDKListViewModelM869c.m1007b();
    }

    /* JADX INFO: renamed from: a */
    public final void m862a(List<String> list) {
        OTConfiguration oTConfiguration = this.f1320d;
        ViewOnClickListenerC0164j viewOnClickListenerC0164j = new ViewOnClickListenerC0164j();
        Bundle bundle = new Bundle();
        bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_SDK_LIST_FILTER_FRAGMENT_TAG);
        viewOnClickListenerC0164j.setArguments(bundle);
        viewOnClickListenerC0164j.f1344k = Collections.unmodifiableList(list);
        viewOnClickListenerC0164j.f1345l = Collections.unmodifiableList(list);
        viewOnClickListenerC0164j.f1348o = oTConfiguration;
        Intrinsics.checkNotNullExpressionValue(viewOnClickListenerC0164j, "newInstance(\n           …figuration,\n            )");
        this.f1325i = viewOnClickListenerC0164j;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = m869c().f1551b;
        ViewOnClickListenerC0164j viewOnClickListenerC0164j2 = null;
        if (oTPublishersHeadlessSDK != null) {
            ViewOnClickListenerC0164j viewOnClickListenerC0164j3 = this.f1325i;
            if (viewOnClickListenerC0164j3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otSdkListFilterFragment");
                viewOnClickListenerC0164j3 = null;
            }
            viewOnClickListenerC0164j3.f1342i = oTPublishersHeadlessSDK;
        }
        ViewOnClickListenerC0164j viewOnClickListenerC0164j4 = this.f1325i;
        if (viewOnClickListenerC0164j4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otSdkListFilterFragment");
        } else {
            viewOnClickListenerC0164j2 = viewOnClickListenerC0164j4;
        }
        viewOnClickListenerC0164j2.f1343j = new ViewOnClickListenerC0164j.a() { // from class: a.a.a.a.b.h.g$$ExternalSyntheticLambda3
            @Override // p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0164j.a
            /* JADX INFO: renamed from: a */
            public final void mo872a(List list2, boolean z) {
                OTSDKListFragment.m853a(this.f$0, list2, z);
            }
        };
    }

    /* JADX INFO: renamed from: b */
    public static final void m857b(OTSDKListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewOnClickListenerC0164j viewOnClickListenerC0164j = this$0.f1325i;
        ViewOnClickListenerC0164j viewOnClickListenerC0164j2 = null;
        if (viewOnClickListenerC0164j == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otSdkListFilterFragment");
            viewOnClickListenerC0164j = null;
        }
        if (viewOnClickListenerC0164j.isAdded()) {
            return;
        }
        ViewOnClickListenerC0164j viewOnClickListenerC0164j3 = this$0.f1325i;
        if (viewOnClickListenerC0164j3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otSdkListFilterFragment");
        } else {
            viewOnClickListenerC0164j2 = viewOnClickListenerC0164j3;
        }
        viewOnClickListenerC0164j2.show(this$0.requireActivity().getSupportFragmentManager(), OTFragmentTags.OT_SDK_LIST_FILTER_FRAGMENT_TAG);
    }

    /* JADX INFO: renamed from: b */
    public static final void m856b(OTSDKListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C0179b c0179b = this$0.f1317a;
        Intrinsics.checkNotNull(c0179b);
        c0179b.f1609b.f1638j.setQuery(this$0.m869c().f1558i, true);
    }

    /* JADX INFO: renamed from: a */
    public static final void m853a(OTSDKListFragment this$0, List selectedList, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(selectedList, "selectedCategories");
        OTSDKListViewModel oTSDKListViewModelM869c = this$0.m869c();
        oTSDKListViewModelM869c.getClass();
        Intrinsics.checkNotNullParameter(selectedList, "selectedList");
        oTSDKListViewModelM869c.f1564o.setValue(selectedList);
        this$0.m869c().f1556g = z;
        this$0.m869c().m1007b();
        this$0.m861a(Boolean.valueOf(z));
        boolean zM1009c = this$0.m869c().m1009c();
        if (!Boolean.parseBoolean(this$0.m869c().f1553d)) {
            zM1009c = false;
        }
        this$0.m863a(zM1009c);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m865a(int i) {
        MutableLiveData<SDKListData> mutableLiveData;
        String strM950a;
        OTSDKListViewModel oTSDKListViewModel;
        String strM950a2;
        String str;
        String strM950a3;
        String str2;
        JSONObject jSONObject;
        String strM950a4;
        OTSDKListViewModel oTSDKListViewModelM869c = m869c();
        if (this.f1319c == null) {
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            this.f1319c = new OTPublishersHeadlessSDK(context);
        }
        OTPublishersHeadlessSDK otPublishersHeadlessSDK = this.f1319c;
        Intrinsics.checkNotNull(otPublishersHeadlessSDK);
        oTSDKListViewModelM869c.getClass();
        Intrinsics.checkNotNullParameter(otPublishersHeadlessSDK, "otPublishersHeadlessSDK");
        oTSDKListViewModelM869c.f1551b = otPublishersHeadlessSDK;
        JSONObject pcData = otPublishersHeadlessSDK != null ? otPublishersHeadlessSDK.getPreferenceCenterData() : null;
        if (pcData != null) {
            C0130x c0130x = new C0130x(oTSDKListViewModelM869c.getApplication());
            C0128v otSdkListUIProperty = c0130x.m674b(i);
            Intrinsics.checkNotNullExpressionValue(otSdkListUIProperty, "otUIProperty.getOTSDKListProperty(themeMode)");
            C0114h c0114h = otSdkListUIProperty.f871o;
            Intrinsics.checkNotNullExpressionValue(c0114h, "otSdkListUIProperty.filterIconProperty");
            if (pcData.has("PCenterCookieListFilterAria")) {
                c0114h.f747a = C0026u.m166a(pcData, "PCenterCookieListFilterAria", (String) null, 2);
            }
            if (pcData.has("PCVendorListFilterUnselectedAriaLabel")) {
                c0114h.f749c = C0026u.m166a(pcData, "PCVendorListFilterUnselectedAriaLabel", (String) null, 2);
            }
            if (pcData.has("PCVendorListFilterSelectedAriaLabel")) {
                c0114h.f748b = C0026u.m166a(pcData, "PCVendorListFilterSelectedAriaLabel", (String) null, 2);
            }
            if (pcData.has("PCenterCookieListSearch")) {
                otSdkListUIProperty.f865i.f720i = C0026u.m166a(pcData, "PCenterCookieListSearch", (String) null, 2);
            }
            if (pcData.has("PCenterBackText")) {
                otSdkListUIProperty.f870n.f754a = C0026u.m166a(pcData, "PCenterBackText", (String) null, 2);
            }
            C0171c pcDataConfig = new C0171c();
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = oTSDKListViewModelM869c.f1551b;
            if (oTPublishersHeadlessSDK == null || pcDataConfig.m973a(oTPublishersHeadlessSDK, oTSDKListViewModelM869c.getApplication(), i)) {
                C0169a otDataConfigUtils = new C0169a(i);
                C0132z c0132zM676c = c0130x.m676c(i);
                C0174f vlDataConfig = new C0174f();
                Intrinsics.checkNotNullParameter(pcData, "pcData");
                Intrinsics.checkNotNullParameter(otDataConfigUtils, "otDataConfigUtils");
                Intrinsics.checkNotNullParameter(otSdkListUIProperty, "otSdkListUIProperty");
                Intrinsics.checkNotNullParameter(vlDataConfig, "vlDataConfig");
                Intrinsics.checkNotNullParameter(pcDataConfig, "pcDataConfig");
                MutableLiveData<SDKListData> mutableLiveData2 = oTSDKListViewModelM869c.f1566q;
                boolean zM183a = C0026u.m183a(pcData, "PCShowCookieDescription", false, 2);
                String str3 = otSdkListUIProperty.f861e;
                if (str3 == null || str3.length() == 0) {
                    mutableLiveData = mutableLiveData2;
                    strM950a = null;
                } else {
                    String str4 = otSdkListUIProperty.f861e;
                    Intrinsics.checkNotNull(str4);
                    mutableLiveData = mutableLiveData2;
                    strM950a = otDataConfigUtils.m950a(str4, C0026u.m166a(pcData, "PcTextColor", (String) null, 2), "#696969", "#FFFFFF");
                }
                String str5 = otSdkListUIProperty.f857a;
                if (str5 == null || str5.length() == 0) {
                    oTSDKListViewModel = oTSDKListViewModelM869c;
                    strM950a2 = null;
                } else {
                    String str6 = otSdkListUIProperty.f857a;
                    Intrinsics.checkNotNull(str6);
                    oTSDKListViewModel = oTSDKListViewModelM869c;
                    strM950a2 = otDataConfigUtils.m950a(str6, C0026u.m166a(pcData, "PcBackgroundColor", (String) null, 2), "#696969", "#FFFFFF");
                }
                String str7 = otSdkListUIProperty.f859c;
                if (str7 == null || str7.length() == 0) {
                    str = strM950a2;
                    strM950a3 = null;
                } else {
                    String str8 = otSdkListUIProperty.f859c;
                    Intrinsics.checkNotNull(str8);
                    str = strM950a2;
                    strM950a3 = otDataConfigUtils.m950a(str8, C0026u.m166a(pcData, "PcButtonColor", (String) null, 2), "#6CC04A", "#80BE5A");
                }
                String str9 = otSdkListUIProperty.f860d;
                if (str9 == null || str9.length() == 0) {
                    str2 = strM950a3;
                    jSONObject = null;
                    strM950a4 = null;
                } else {
                    String str10 = otSdkListUIProperty.f860d;
                    Intrinsics.checkNotNull(str10);
                    str2 = strM950a3;
                    jSONObject = null;
                    strM950a4 = otDataConfigUtils.m950a(str10, C0026u.m166a(pcData, "PcTextColor", (String) null, 2), "#696969", "#FFFFFF");
                }
                String strM951a = otDataConfigUtils.m951a(otSdkListUIProperty.f858b, "PcTextColor", jSONObject);
                String str11 = c0132zM676c != null ? c0132zM676c.f899c : null;
                String str12 = c0132zM676c != null ? c0132zM676c.f900d : null;
                String str13 = c0132zM676c != null ? c0132zM676c.f901e : null;
                String strM166a = C0026u.m166a(pcData, "BConsentText", (String) null, 2);
                C0106b0 c0106b0M997a = vlDataConfig.m997a(pcData, otSdkListUIProperty.f862f, "Name", true);
                Intrinsics.checkNotNullExpressionValue(c0106b0M997a, "vlDataConfig.getTextProp…           true\n        )");
                C0106b0 c0106b0M997a2 = vlDataConfig.m997a(pcData, otSdkListUIProperty.f863g, "Description", true);
                Intrinsics.checkNotNullExpressionValue(c0106b0M997a2, "vlDataConfig.getTextProp…SCRIPTION, true\n        )");
                C0104a0 c0104a0M996a = vlDataConfig.m996a(otSdkListUIProperty.f865i, otSdkListUIProperty.f857a);
                Intrinsics.checkNotNullExpressionValue(c0104a0M996a, "vlDataConfig.getSearchBa…ackgroundColor,\n        )");
                C0106b0 c0106b0M997a3 = vlDataConfig.m997a(pcData, otSdkListUIProperty.f864h, "PCenterAllowAllConsentText", false);
                Intrinsics.checkNotNullExpressionValue(c0106b0M997a3, "vlDataConfig.getTextProp…ENT_TEXT, false\n        )");
                mutableLiveData.setValue(new SDKListData(zM183a, strM950a, str, str2, strM950a4, strM951a, str11, str12, str13, strM166a, c0106b0M997a, c0106b0M997a2, c0104a0M996a, c0106b0M997a3, otSdkListUIProperty, pcDataConfig.f1506u));
                oTSDKListViewModel.m1007b();
                OTSDKListViewModel oTSDKListViewModel2 = oTSDKListViewModel;
                oTSDKListViewModel2.f1564o.observe(getViewLifecycleOwner(), new Observer() { // from class: a.a.a.a.b.h.g$$ExternalSyntheticLambda10
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        OTSDKListFragment.m852a(this.f$0, (List) obj);
                    }
                });
                oTSDKListViewModel2.f1566q.observe(getViewLifecycleOwner(), new Observer() { // from class: a.a.a.a.b.h.g$$ExternalSyntheticLambda11
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        OTSDKListFragment.m846a(this.f$0, (SDKListData) obj);
                    }
                });
                oTSDKListViewModel2.f1565p.observe(getViewLifecycleOwner(), new Observer() { // from class: a.a.a.a.b.h.g$$ExternalSyntheticLambda12
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        OTSDKListFragment.m858b(this.f$0, (List) obj);
                    }
                });
                oTSDKListViewModel2.f1567r.observe(getViewLifecycleOwner(), new Observer() { // from class: a.a.a.a.b.h.g$$ExternalSyntheticLambda1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        OTSDKListFragment.m851a(this.f$0, (Boolean) obj);
                    }
                });
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static final void m846a(OTSDKListFragment this$0, SDKListData it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it2, "it");
        this$0.f1323g = new OTSDKAdapter(it2, this$0.f1320d, this$0.m869c().f1553d, this$0.m869c().f1554e, this$0.m869c().f1555f, new C0162h(this$0), new C0163i(this$0));
        C0179b c0179b = this$0.f1317a;
        Intrinsics.checkNotNull(c0179b);
        c0179b.f1609b.f1632d.setAdapter(this$0.f1323g);
        C0179b c0179b2 = this$0.f1317a;
        Intrinsics.checkNotNull(c0179b2);
        c0179b2.f1609b.f1632d.setItemAnimator(null);
        this$0.m860a(it2);
        C0179b c0179b3 = this$0.f1317a;
        Intrinsics.checkNotNull(c0179b3);
        CoordinatorLayout parentSdkList = c0179b3.f1610c;
        Intrinsics.checkNotNullExpressionValue(parentSdkList, "parentSdkList");
        C0026u.m171a(parentSdkList, it2.f184c);
        RelativeLayout relativeLayout = c0179b3.f1609b.f1636h;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mainLayout.sdkParentLayout");
        C0026u.m171a(relativeLayout, it2.f184c);
        c0179b3.f1609b.f1633e.setText(it2.f195n.f726e);
        if (!C0048h.m305b(it2.f195n.f724c)) {
            c0179b3.f1609b.f1633e.setTextColor(Color.parseColor(it2.f195n.f724c));
        }
        this$0.m864a(c0179b3.f1609b.f1634f.isChecked(), it2);
        OTSDKListViewModel oTSDKListViewModelM869c = this$0.m869c();
        boolean z = false;
        if (Boolean.parseBoolean(oTSDKListViewModelM869c.f1553d) && (!OTSDKListViewModel.m1004a(oTSDKListViewModelM869c, null, 1) || oTSDKListViewModelM869c.m1009c())) {
            z = true;
        }
        this$0.m863a(z);
        C0179b c0179b4 = this$0.f1317a;
        Intrinsics.checkNotNull(c0179b4);
        C0183f c0183f = c0179b4.f1609b;
        c0183f.f1637i.setBackgroundColor(Color.parseColor(it2.f184c));
        c0183f.f1635g.setTextColor(Color.parseColor(it2.f192k.f724c));
        TextView sdkListPageTitle = c0183f.f1635g;
        Intrinsics.checkNotNullExpressionValue(sdkListPageTitle, "sdkListPageTitle");
        C0026u.m171a(sdkListPageTitle, it2.f184c);
        c0183f.f1630b.setContentDescription(it2.f196o.f870n.m648a());
        ImageView backFromSdklist = c0183f.f1630b;
        Intrinsics.checkNotNullExpressionValue(backFromSdklist, "backFromSdklist");
        C0026u.m175a(backFromSdklist, it2.f183b);
        this$0.m861a((Boolean) null);
        this$0.m866b();
        this$0.m867b(it2);
    }

    /* JADX INFO: renamed from: a */
    public static final void m851a(OTSDKListFragment this$0, Boolean it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C0179b c0179b = this$0.f1317a;
        Intrinsics.checkNotNull(c0179b);
        SwitchCompat switchCompat = c0179b.f1609b.f1634f;
        Intrinsics.checkNotNullExpressionValue(it2, "it");
        switchCompat.setChecked(it2.booleanValue());
    }
}
