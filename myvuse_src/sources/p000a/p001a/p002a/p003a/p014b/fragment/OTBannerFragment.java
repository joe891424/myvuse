package p000a.p001a.p002a.p003a.p014b.fragment;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.brentvatne.react.ReactVideoView;
import com.google.android.material.C2309R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTBannerHeightRatio;
import com.onetrust.otpublishers.headless.Public.OTConsentInteractionType;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import com.onetrust.otpublishers.headless.p046UI.Helper.FragmentViewBindingDelegate;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONException;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p014b.DataModels.BannerData;
import p000a.p001a.p002a.p003a.p014b.InterfaceC0075c;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0123q;
import p000a.p001a.p002a.p003a.p014b.p021e.C0124r;
import p000a.p001a.p002a.p003a.p014b.p023g.C0154d;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;
import p000a.p001a.p002a.p003a.p014b.viewmodel.OTBannerViewModel;
import p000a.p001a.p002a.p003a.p027c.C0178a;

/* JADX INFO: renamed from: a.a.a.a.b.h.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001`B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\"\u0010*\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0002J\u001a\u00100\u001a\u00020\"2\u0006\u0010.\u001a\u00020/2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0018\u00101\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\"\u00102\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0010\u00103\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u00104\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\"\u00105\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\"\u00106\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0010\u00107\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u00108\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u00109\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010:\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010;\u001a\u00020\"H\u0002J\u0010\u0010<\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010=\u001a\u00020\"H\u0002J\b\u0010>\u001a\u00020\"H\u0002J\u0018\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u00020A2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010B\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020\"H\u0002J\u0012\u0010G\u001a\u00020\"2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0012\u0010J\u001a\u00020K2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J$\u0010L\u001a\u00020\u00062\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010Q\u001a\u00020\"H\u0016J\u0010\u0010R\u001a\u00020\"2\u0006\u0010#\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010U\u001a\u00020\"H\u0002J\b\u0010V\u001a\u00020\"H\u0002J\u001a\u0010W\u001a\u00020\"2\u0006\u0010X\u001a\u00020\u00062\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u000e\u0010Y\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010Z\u001a\u00020\"2\u0006\u0010[\u001a\u00020SH\u0002J\u0014\u0010\\\u001a\u00020\"*\u00020]2\u0006\u0010^\u001a\u00020_H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u0006a"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/fragment/OTBannerFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/onetrust/otpublishers/headless/UI/OTInteractionListener;", "()V", "behaviour", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "binding", "Lcom/onetrust/otpublishers/headless/databinding/FragmentOtBannerBinding;", "getBinding", "()Lcom/onetrust/otpublishers/headless/databinding/FragmentOtBannerBinding;", "binding$delegate", "Lcom/onetrust/otpublishers/headless/UI/Helper/FragmentViewBindingDelegate;", "bottomSheet", "Landroid/widget/FrameLayout;", "bottomSheetDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "eventListenerSetter", "Lcom/onetrust/otpublishers/headless/Internal/Event/EventListenerSetter;", "otConfiguration", "Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;", "preferenceCenterFragment", "Lcom/onetrust/otpublishers/headless/UI/fragment/OTPCFragment;", "uiUtils", "Lcom/onetrust/otpublishers/headless/UI/Helper/UIUtils;", "vendorsListFragment", "Lcom/onetrust/otpublishers/headless/UI/fragment/OTVendorListFragment;", "viewModel", "Lcom/onetrust/otpublishers/headless/UI/viewmodel/OTBannerViewModel;", "getViewModel", "()Lcom/onetrust/otpublishers/headless/UI/viewmodel/OTBannerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "allSDKViewDismissed", "", "interactionType", "", "configureBannerAdditionalDescription", "bannerData", "Lcom/onetrust/otpublishers/headless/UI/DataModels/BannerData;", "otBannerUIProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTBannerUIProperty;", "configureBannerButtons", "otGlobalUIProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTGlobalUIProperty;", "configureBannerCloseButton", "closeButtonProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/CloseButtonProperty;", "configureBannerCloseButtonText", "configureBannerDescriptions", "configureBannerElements", "configureBannerLogo", "configureBannerTitles", "configureButtons", "configureCookiesButtons", "configureLayouts", "configureSmallBannerCloseButton", "configureSmallBannerElements", "configureSmallBannerTitle", "initializeFragments", "initializeOnClicks", "initializeViewModel", "onAcceptCookiesClicked", "onCloseBannerClicked", "saveDefaultState", "", "onCloseButtonClicked", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCookiesSettingClicked", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onInteraction", "", "onPrivacyClicked", "onRejectClicked", "onShowVendorsClicked", "onViewCreated", "view", "setEventListener", "setupFullHeight", ReactVideoView.EVENT_PROP_ORIENTATION, "showLogo", "Landroid/widget/ImageView;", "logoProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/LogoProperty;", "Companion", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class OTBannerFragment extends BottomSheetDialogFragment implements InterfaceC0075c {

    /* JADX INFO: renamed from: a */
    public final FragmentViewBindingDelegate f1138a = C0026u.m161a(this, b.f1148a);

    /* JADX INFO: renamed from: b */
    public final Lazy f1139b;

    /* JADX INFO: renamed from: c */
    public C0002a f1140c;

    /* JADX INFO: renamed from: d */
    public OTConfiguration f1141d;

    /* JADX INFO: renamed from: e */
    public OTVendorListFragment f1142e;

    /* JADX INFO: renamed from: f */
    public ViewOnClickListenerC0159e f1143f;

    /* JADX INFO: renamed from: g */
    public final C0074f f1144g;

    /* JADX INFO: renamed from: h */
    public BottomSheetBehavior<View> f1145h;

    /* JADX INFO: renamed from: i */
    public FrameLayout f1146i;

    /* JADX INFO: renamed from: j */
    public BottomSheetDialog f1147j;

    /* JADX INFO: renamed from: l */
    public static final /* synthetic */ KProperty<Object>[] f1137l = {Reflection.property1(new PropertyReference1Impl(OTBannerFragment.class, "binding", "getBinding()Lcom/onetrust/otpublishers/headless/databinding/FragmentOtBannerBinding;", 0))};

    /* JADX INFO: renamed from: k */
    public static final a f1136k = new a();

    /* JADX INFO: renamed from: a.a.a.a.b.h.b$a */
    @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/fragment/OTBannerFragment$Companion;", "", "()V", "INTERACTION_CLOSE_PC", "", "INTERACTION_CLOSE_UCP_OPTIONS", "INTERACTION_CLOSE_UI", "INTERACTION_CLOSE_VL", "INTERACTION_REFRESH_PC", "TAG", "", "newInstance", "Lcom/onetrust/otpublishers/headless/UI/fragment/OTBannerFragment;", "fragmentTag", "eventListenerSetter", "Lcom/onetrust/otpublishers/headless/Internal/Event/EventListenerSetter;", "otConfiguration", "Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a {
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.b$b */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, C0178a> {

        /* JADX INFO: renamed from: a */
        public static final b f1148a = new b();

        public b() {
            super(1, C0178a.class, "bind", "bind(Landroid/view/View;)Lcom/onetrust/otpublishers/headless/databinding/FragmentOtBannerBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0178a invoke(View view) {
            View p0 = view;
            Intrinsics.checkNotNullParameter(p0, "p0");
            int i = C3896R.id.alert_notice_text;
            TextView textView = (TextView) p0.findViewById(i);
            if (textView != null) {
                i = C3896R.id.banner_additional_desc_after_desc;
                TextView textView2 = (TextView) p0.findViewById(i);
                if (textView2 != null) {
                    i = C3896R.id.banner_additional_desc_after_dpd;
                    TextView textView3 = (TextView) p0.findViewById(i);
                    if (textView3 != null) {
                        i = C3896R.id.banner_additional_desc_after_title;
                        TextView textView4 = (TextView) p0.findViewById(i);
                        if (textView4 != null) {
                            i = C3896R.id.banner_IAB_desc;
                            TextView textView5 = (TextView) p0.findViewById(i);
                            if (textView5 != null) {
                                i = C3896R.id.banner_IAB_title;
                                TextView textView6 = (TextView) p0.findViewById(i);
                                if (textView6 != null) {
                                    RelativeLayout relativeLayout = (RelativeLayout) p0;
                                    i = C3896R.id.banner_logo;
                                    ImageView imageView = (ImageView) p0.findViewById(i);
                                    if (imageView != null) {
                                        i = C3896R.id.banner_title;
                                        TextView textView7 = (TextView) p0.findViewById(i);
                                        if (textView7 != null) {
                                            i = C3896R.id.banner_top_layout;
                                            LinearLayout linearLayout = (LinearLayout) p0.findViewById(i);
                                            if (linearLayout != null) {
                                                i = C3896R.id.btn_accept_cookies;
                                                Button button = (Button) p0.findViewById(i);
                                                if (button != null) {
                                                    i = C3896R.id.btn_reject_cookies;
                                                    Button button2 = (Button) p0.findViewById(i);
                                                    if (button2 != null) {
                                                        i = C3896R.id.button_layout;
                                                        LinearLayout linearLayout2 = (LinearLayout) p0.findViewById(i);
                                                        if (linearLayout2 != null) {
                                                            i = C3896R.id.close_banner;
                                                            ImageView imageView2 = (ImageView) p0.findViewById(i);
                                                            if (imageView2 != null) {
                                                                i = C3896R.id.close_banner_button;
                                                                Button button3 = (Button) p0.findViewById(i);
                                                                if (button3 != null) {
                                                                    i = C3896R.id.close_banner_text;
                                                                    TextView textView8 = (TextView) p0.findViewById(i);
                                                                    if (textView8 != null) {
                                                                        i = C3896R.id.cookie_policy_banner;
                                                                        TextView textView9 = (TextView) p0.findViewById(i);
                                                                        if (textView9 != null) {
                                                                            i = C3896R.id.cookies_setting;
                                                                            TextView textView10 = (TextView) p0.findViewById(i);
                                                                            if (textView10 != null) {
                                                                                i = C3896R.id.cookies_setting_button;
                                                                                Button button4 = (Button) p0.findViewById(i);
                                                                                if (button4 != null) {
                                                                                    i = C3896R.id.cookies_text_layout;
                                                                                    ScrollView scrollView = (ScrollView) p0.findViewById(i);
                                                                                    if (scrollView != null) {
                                                                                        i = C3896R.id.floating_button_layout;
                                                                                        LinearLayout linearLayout3 = (LinearLayout) p0.findViewById(i);
                                                                                        if (linearLayout3 != null) {
                                                                                            i = C3896R.id.show_vendors_list;
                                                                                            TextView textView11 = (TextView) p0.findViewById(i);
                                                                                            if (textView11 != null) {
                                                                                                i = C3896R.id.small_banner_close;
                                                                                                ImageView imageView3 = (ImageView) p0.findViewById(i);
                                                                                                if (imageView3 != null) {
                                                                                                    i = C3896R.id.small_banner_title;
                                                                                                    TextView textView12 = (TextView) p0.findViewById(i);
                                                                                                    if (textView12 != null) {
                                                                                                        i = C3896R.id.small_banner_top_layout;
                                                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) p0.findViewById(i);
                                                                                                        if (relativeLayout2 != null) {
                                                                                                            return new C0178a(relativeLayout, textView, textView2, textView3, textView4, textView5, textView6, relativeLayout, imageView, textView7, linearLayout, button, button2, linearLayout2, imageView2, button3, textView8, textView9, textView10, button4, scrollView, linearLayout3, textView11, imageView3, textView12, relativeLayout2);
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
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(p0.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.b$c */
    @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$5"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class c extends Lambda implements Function0<Fragment> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Fragment f1149a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.f1149a = fragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public Fragment invoke() {
            return this.f1149a;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.b$d */
    @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStoreOwner;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$owner$4"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class d extends Lambda implements Function0<ViewModelStoreOwner> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Function0 f1150a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Function0 function0) {
            super(0);
            this.f1150a = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ViewModelStoreOwner invoke() {
            return (ViewModelStoreOwner) this.f1150a.invoke();
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.b$e */
    @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$6"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class e extends Lambda implements Function0<ViewModelStore> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Lazy f1151a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Lazy lazy) {
            super(0);
            this.f1151a = lazy;
        }

        @Override // kotlin.jvm.functions.Function0
        public ViewModelStore invoke() {
            ViewModelStore viewModelStore = FragmentViewModelLazyKt.m5792viewModels$lambda1(this.f1151a).getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner.viewModelStore");
            return viewModelStore;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.b$f */
    @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$7"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class f extends Lambda implements Function0<CreationExtras> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Lazy f1152a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Function0 function0, Lazy lazy) {
            super(0);
            this.f1152a = lazy;
        }

        @Override // kotlin.jvm.functions.Function0
        public CreationExtras invoke() {
            ViewModelStoreOwner viewModelStoreOwnerM5792viewModels$lambda1 = FragmentViewModelLazyKt.m5792viewModels$lambda1(this.f1152a);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM5792viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM5792viewModels$lambda1 : null;
            CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
            return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.b$g */
    @Metadata(m5597d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m5598d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class g extends Lambda implements Function0<ViewModelProvider.Factory> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            Application application = OTBannerFragment.this.requireActivity().getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "requireActivity().application");
            return new OTBannerViewModel.a(application);
        }
    }

    public OTBannerFragment() {
        g gVar = new g();
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new d(new c(this)));
        this.f1139b = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OTBannerViewModel.class), new e(lazy), new f(null, lazy), gVar);
        this.f1144g = new C0074f();
    }

    /* JADX INFO: renamed from: a */
    public static final void m769a(final OTBannerFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogInterface, "dialogInterface");
        this$0.f1147j = (BottomSheetDialog) dialogInterface;
        if (C0170b.m959a(this$0.getContext(), "OT_BANNERonCreateDialog")) {
            this$0.m786b(this$0.getResources().getConfiguration().orientation);
        }
        BottomSheetDialog bottomSheetDialog = this$0.f1147j;
        this$0.f1146i = bottomSheetDialog != null ? (FrameLayout) bottomSheetDialog.findViewById(C2309R.id.design_bottom_sheet) : null;
        BottomSheetDialog bottomSheetDialog2 = this$0.f1147j;
        if (bottomSheetDialog2 != null) {
            bottomSheetDialog2.setCancelable(false);
        }
        BottomSheetDialog bottomSheetDialog3 = this$0.f1147j;
        if (bottomSheetDialog3 != null) {
            bottomSheetDialog3.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: a.a.a.a.b.h.b$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface2, int i, KeyEvent keyEvent) {
                    return OTBannerFragment.m771a(this.f$0, dialogInterface2, i, keyEvent);
                }
            });
        }
    }

    /* JADX INFO: renamed from: b */
    public static final void m772b(OTBannerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m784a(true, OTConsentInteractionType.BANNER_CLOSE);
    }

    /* JADX INFO: renamed from: c */
    public static final void m773c(OTBannerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m784a(true, OTConsentInteractionType.BANNER_CONTINUE_WITHOUT_ACCEPTING);
    }

    /* JADX INFO: renamed from: d */
    public static final void m774d(OTBannerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m784a(true, OTConsentInteractionType.BANNER_CONTINUE_WITHOUT_ACCEPTING);
    }

    /* JADX INFO: renamed from: e */
    public static final void m775e(OTBannerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m785b().m1001a(OTConsentInteractionType.BANNER_ALLOW_ALL);
        this$0.f1144g.m411a(new C0003b(3), this$0.f1140c);
        this$0.m783a(OTConsentInteractionType.BANNER_ALLOW_ALL);
    }

    /* JADX INFO: renamed from: f */
    public static final void m776f(OTBannerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m788d();
    }

    /* JADX INFO: renamed from: g */
    public static final void m777g(OTBannerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m788d();
    }

    /* JADX INFO: renamed from: h */
    public static final void m778h(OTBannerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OTVendorListFragment oTVendorListFragment = this$0.f1142e;
        OTVendorListFragment oTVendorListFragment2 = null;
        if (oTVendorListFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vendorsListFragment");
            oTVendorListFragment = null;
        }
        if (oTVendorListFragment.isAdded() || this$0.getActivity() == null) {
            return;
        }
        OTVendorListFragment oTVendorListFragment3 = this$0.f1142e;
        if (oTVendorListFragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vendorsListFragment");
            oTVendorListFragment3 = null;
        }
        oTVendorListFragment3.setArguments(BundleKt.bundleOf(TuplesKt.m5605to("IS_FILTERED_VENDOR_LIST", Boolean.FALSE)));
        OTVendorListFragment oTVendorListFragment4 = this$0.f1142e;
        if (oTVendorListFragment4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vendorsListFragment");
        } else {
            oTVendorListFragment2 = oTVendorListFragment4;
        }
        oTVendorListFragment2.show(this$0.requireActivity().getSupportFragmentManager(), OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG);
        this$0.f1144g.m411a(new C0003b(12), this$0.f1140c);
    }

    /* JADX INFO: renamed from: i */
    public static final void m779i(OTBannerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m785b().m1001a(OTConsentInteractionType.BANNER_REJECT_ALL);
        this$0.f1144g.m411a(new C0003b(4), this$0.f1140c);
        this$0.m783a(OTConsentInteractionType.BANNER_REJECT_ALL);
    }

    /* JADX INFO: renamed from: a */
    public final C0178a m780a() {
        return (C0178a) this.f1138a.getValue(this, f1137l[0]);
    }

    /* JADX INFO: renamed from: a */
    public final void m782a(final C0123q c0123q) {
        C0178a c0178aM780a = m780a();
        c0178aM780a.f1594l.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.b$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTBannerFragment.m775e(this.f$0, view);
            }
        });
        c0178aM780a.f1602t.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.b$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTBannerFragment.m776f(this.f$0, view);
            }
        });
        c0178aM780a.f1601s.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.b$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTBannerFragment.m777g(this.f$0, view);
            }
        });
        c0178aM780a.f1604v.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.b$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTBannerFragment.m778h(this.f$0, view);
            }
        });
        c0178aM780a.f1595m.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.b$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTBannerFragment.m779i(this.f$0, view);
            }
        });
        c0178aM780a.f1600r.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.b$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTBannerFragment.m768a(this.f$0, c0123q, view);
            }
        });
        c0178aM780a.f1605w.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.b$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTBannerFragment.m770a(this.f$0, view);
            }
        });
        c0178aM780a.f1597o.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.b$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTBannerFragment.m772b(this.f$0, view);
            }
        });
        c0178aM780a.f1599q.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.b$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTBannerFragment.m773c(this.f$0, view);
            }
        });
        c0178aM780a.f1598p.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.b$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OTBannerFragment.m774d(this.f$0, view);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final void m783a(String str) {
        C0003b c0003b = new C0003b(17);
        c0003b.f5d = str;
        this.f1144g.m411a(c0003b, this.f1140c);
        dismiss();
    }

    /* JADX INFO: renamed from: a */
    public final void m784a(boolean z, String str) {
        if (z) {
            m785b().m1001a(str);
        }
        this.f1144g.m411a(new C0003b(2), this.f1140c);
        m783a(str);
    }

    /* JADX INFO: renamed from: b */
    public final OTBannerViewModel m785b() {
        return (OTBannerViewModel) this.f1139b.getValue();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        OTLogger.m2743a(3, "OTSDKBanner", "onConfigurationChanged:");
        if (this.f1147j == null && getActivity() != null) {
            OTLogger.m2743a(3, "OTSDKBanner", "onConfigurationChanged: null instance found, recreating bottomSheetDialog");
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            SharedPreferences sharedPreferences = activity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string = sharedPreferences.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (!C0048h.m305b(string)) {
                str = string;
            }
            this.f1147j = str.equals(OTThemeConstants.OT_SDK_UI_THEME) ? new BottomSheetDialog(requireActivity(), C3896R.style.OTSDKTheme) : new BottomSheetDialog(requireActivity());
        }
        m786b(newConfig.orientation);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Context context = getContext();
        if (C0170b.m959a(context, OTFragmentTags.OT_BANNER_FRAGMENT_TAG)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string = sharedPreferences.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (C0048h.m305b(string)) {
                string = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            }
            if (!string.equals(OTThemeConstants.OT_SDK_UI_THEME)) {
                String string2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: a.a.a.a.b.h.b$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                OTBannerFragment.m769a(this.f$0, dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewM406a = this.f1144g.m406a(requireContext(), inflater, container, C3896R.layout.fragment_ot_banner);
        Intrinsics.checkNotNullExpressionValue(viewM406a, "uiUtils.getOTView(requir…ayout.fragment_ot_banner)");
        return viewM406a;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f1140c = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws JSONException {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        m787c();
        ViewOnClickListenerC0159e viewOnClickListenerC0159eM829a = ViewOnClickListenerC0159e.m829a(OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG, this.f1140c, this.f1141d);
        Intrinsics.checkNotNullExpressionValue(viewOnClickListenerC0159eM829a, "newInstance(\n           …otConfiguration\n        )");
        viewOnClickListenerC0159eM829a.f1252A = this;
        viewOnClickListenerC0159eM829a.f1295x = m785b().f1545a;
        this.f1143f = viewOnClickListenerC0159eM829a;
        OTVendorListFragment oTVendorListFragmentM930a = OTVendorListFragment.f1394n.m930a(OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG, this.f1140c, this.f1141d);
        oTVendorListFragmentM930a.f1401f = this;
        oTVendorListFragmentM930a.m914a(m785b().f1545a);
        this.f1142e = oTVendorListFragmentM930a;
    }

    /* JADX INFO: renamed from: b */
    public final void m786b(int i) {
        int height;
        C0123q c0123q;
        BottomSheetDialog bottomSheetDialog = this.f1147j;
        String str = null;
        FrameLayout frameLayout = bottomSheetDialog != null ? (FrameLayout) bottomSheetDialog.findViewById(C3896R.id.design_bottom_sheet) : null;
        this.f1146i = frameLayout;
        if (frameLayout != null) {
            this.f1145h = BottomSheetBehavior.from(frameLayout);
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "it.layoutParams");
            Context context = getContext();
            if (Build.VERSION.SDK_INT >= 30) {
                WindowMetrics currentWindowMetrics = ((Activity) Objects.requireNonNull(context)).getWindowManager().getCurrentWindowMetrics();
                Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars() | WindowInsets.Type.displayCutout());
                int i2 = insetsIgnoringVisibility.right + insetsIgnoringVisibility.left;
                int i3 = insetsIgnoringVisibility.top + insetsIgnoringVisibility.bottom;
                Rect bounds = currentWindowMetrics.getBounds();
                height = new Size(bounds.width() - i2, bounds.height() - i3).getHeight();
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((Activity) Objects.requireNonNull(context)).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                height = displayMetrics.heightPixels;
            }
            layoutParams.height = height;
            BannerData value = m785b().f1547c.getValue();
            if (value != null && (c0123q = value.f140t) != null) {
                str = c0123q.f786b;
            }
            double d2 = 1.0d;
            if (str != null && str.length() != 0) {
                int iHashCode = str.hashCode();
                if (iHashCode != 288473524) {
                    if (iHashCode != 1945285198) {
                        if (iHashCode == 2002049644 && str.equals(OTBannerHeightRatio.ONE_HALF)) {
                            d2 = 0.5d;
                        }
                    } else if (str.equals(OTBannerHeightRatio.ONE_THIRD)) {
                        d2 = 0.33d;
                    }
                } else if (str.equals(OTBannerHeightRatio.TWO_THIRD)) {
                    d2 = 0.66d;
                }
            }
            if (2 != i) {
                layoutParams.height = (int) (((double) height) * d2);
            }
            frameLayout.setLayoutParams(layoutParams);
            BottomSheetBehavior<View> bottomSheetBehavior = this.f1145h;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setPeekHeight(height);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03aa  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m787c() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 1140
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.fragment.OTBannerFragment.m787c():void");
    }

    /* JADX INFO: renamed from: d */
    public final void m788d() {
        ViewOnClickListenerC0159e viewOnClickListenerC0159e = this.f1143f;
        ViewOnClickListenerC0159e viewOnClickListenerC0159e2 = null;
        if (viewOnClickListenerC0159e == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferenceCenterFragment");
            viewOnClickListenerC0159e = null;
        }
        if (viewOnClickListenerC0159e.isAdded() || getActivity() == null) {
            return;
        }
        ViewOnClickListenerC0159e viewOnClickListenerC0159e3 = this.f1143f;
        if (viewOnClickListenerC0159e3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferenceCenterFragment");
        } else {
            viewOnClickListenerC0159e2 = viewOnClickListenerC0159e3;
        }
        viewOnClickListenerC0159e2.show(requireActivity().getSupportFragmentManager(), OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG);
        OTUIDisplayReason oTUIDisplayReason = new OTUIDisplayReason(OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_SHOW_PC_CALLED, OTUIDisplayReason.getResponseMessage(OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_SHOW_PC_CALLED));
        C0003b c0003b = new C0003b(5);
        c0003b.f7f = oTUIDisplayReason;
        this.f1144g.m411a(c0003b, this.f1140c);
    }

    /* JADX INFO: renamed from: a */
    public final void m781a(BannerData bannerData, C0123q c0123q, C0124r c0124r) {
        String str;
        String str2;
        String str3;
        String str4;
        C0123q c0123q2;
        C0107c c0107c;
        C0123q c0123q3;
        C0107c c0107c2;
        C0123q c0123q4;
        C0107c c0107c3;
        C0123q c0123q5;
        C0107c c0107c4;
        C0123q c0123q6;
        C0107c c0107c5;
        C0123q c0123q7;
        C0107c c0107c6;
        String str5;
        C0178a c0178aM780a = m780a();
        Button button = c0178aM780a.f1594l;
        C0107c c0107c7 = c0123q.f793i;
        Intrinsics.checkNotNullExpressionValue(c0107c7, "otBannerUIProperty.acceptAllButtonProperty");
        button.setText(bannerData.f122b);
        Intrinsics.checkNotNullExpressionValue(button, "");
        button.setVisibility((!bannerData.f133m || (str5 = bannerData.f122b) == null || str5.length() == 0) ? 8 : 0);
        OTBannerViewModel oTBannerViewModelM785b = m785b();
        BannerData value = oTBannerViewModelM785b.f1547c.getValue();
        String str6 = (value == null || (c0123q7 = value.f140t) == null || (c0107c6 = c0123q7.f793i) == null) ? null : c0107c6.f729b;
        boolean z = true;
        if (str6 == null || str6.length() == 0) {
            str6 = null;
        }
        if (str6 == null) {
            BannerData value2 = oTBannerViewModelM785b.f1547c.getValue();
            str = value2 != null ? value2.f129i : null;
        } else {
            str = str6;
        }
        OTBannerViewModel oTBannerViewModelM785b2 = m785b();
        BannerData value3 = oTBannerViewModelM785b2.f1547c.getValue();
        String strMo378b = (value3 == null || (c0123q6 = value3.f140t) == null || (c0107c5 = c0123q6.f793i) == null) ? null : c0107c5.mo378b();
        if (strMo378b == null || strMo378b.length() == 0) {
            strMo378b = null;
        }
        if (strMo378b == null) {
            BannerData value4 = oTBannerViewModelM785b2.f1547c.getValue();
            str2 = value4 != null ? value4.f130j : null;
        } else {
            str2 = strMo378b;
        }
        C0026u.m172a(button, c0107c7, str, str2, c0107c7.f731d, this.f1141d);
        Button button2 = c0178aM780a.f1595m;
        C0107c c0107c8 = c0123q.f794j;
        Intrinsics.checkNotNullExpressionValue(c0107c8, "otBannerUIProperty.rejectAllButtonProperty");
        Intrinsics.checkNotNullExpressionValue(button2, "");
        button2.setVisibility(bannerData.f123c ? 0 : 8);
        button2.setText(bannerData.f124d);
        OTBannerViewModel oTBannerViewModelM785b3 = m785b();
        BannerData value5 = oTBannerViewModelM785b3.f1547c.getValue();
        String str7 = (value5 == null || (c0123q5 = value5.f140t) == null || (c0107c4 = c0123q5.f794j) == null) ? null : c0107c4.f729b;
        if (str7 == null || str7.length() == 0) {
            str7 = null;
        }
        if (str7 == null) {
            BannerData value6 = oTBannerViewModelM785b3.f1547c.getValue();
            str3 = value6 != null ? value6.f129i : null;
        } else {
            str3 = str7;
        }
        OTBannerViewModel oTBannerViewModelM785b4 = m785b();
        BannerData value7 = oTBannerViewModelM785b4.f1547c.getValue();
        String strMo378b2 = (value7 == null || (c0123q4 = value7.f140t) == null || (c0107c3 = c0123q4.f794j) == null) ? null : c0107c3.mo378b();
        if (strMo378b2 == null || strMo378b2.length() == 0) {
            strMo378b2 = null;
        }
        if (strMo378b2 == null) {
            BannerData value8 = oTBannerViewModelM785b4.f1547c.getValue();
            str4 = value8 != null ? value8.f130j : null;
        } else {
            str4 = strMo378b2;
        }
        C0026u.m172a(button2, c0107c8, str3, str4, c0107c8.f731d, this.f1141d);
        C0178a c0178aM780a2 = m780a();
        C0107c buttonProperty = c0123q.f795k;
        Intrinsics.checkNotNullExpressionValue(buttonProperty, "otBannerUIProperty.showPreferencesButtonProperty");
        Button button3 = c0178aM780a2.f1602t;
        button3.setText(bannerData.f121a);
        Intrinsics.checkNotNullExpressionValue(button3, "");
        button3.setVisibility(bannerData.m375a(1) ? 0 : 8);
        OTBannerViewModel oTBannerViewModelM785b5 = m785b();
        BannerData value9 = oTBannerViewModelM785b5.f1547c.getValue();
        String str8 = (value9 == null || (c0123q3 = value9.f140t) == null || (c0107c2 = c0123q3.f795k) == null) ? null : c0107c2.f729b;
        if (str8 == null || str8.length() == 0) {
            str8 = null;
        }
        if (str8 == null) {
            BannerData value10 = oTBannerViewModelM785b5.f1547c.getValue();
            str8 = value10 != null ? value10.f126f : null;
        }
        String strM1003c = m785b().m1003c();
        OTBannerViewModel oTBannerViewModelM785b6 = m785b();
        BannerData value11 = oTBannerViewModelM785b6.f1547c.getValue();
        String str9 = (value11 == null || (c0123q2 = value11.f140t) == null || (c0107c = c0123q2.f795k) == null) ? null : c0107c.f731d;
        if (str9 != null && str9.length() != 0) {
            z = false;
        }
        if (z) {
            str9 = null;
        }
        if (str9 == null) {
            BannerData value12 = oTBannerViewModelM785b6.f1547c.getValue();
            str9 = value12 != null ? value12.f127g : null;
        }
        C0026u.m172a(button3, buttonProperty, str8, strM1003c, str9, this.f1141d);
        TextView textView = c0178aM780a2.f1601s;
        textView.setText(bannerData.f121a);
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(bannerData.m375a(0) ? 0 : 8);
        String strM1003c2 = m785b().m1003c();
        OTConfiguration oTConfiguration = this.f1141d;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(buttonProperty, "buttonProperty");
        C0115i c0115i = buttonProperty.f728a;
        Intrinsics.checkNotNullExpressionValue(c0115i, "buttonProperty.fontProperty");
        C0154d.m755a(textView, c0115i, oTConfiguration);
        String str10 = c0115i.f751b;
        if (str10 != null && str10.length() != 0) {
            String str11 = c0115i.f751b;
            Intrinsics.checkNotNull(str11);
            textView.setTextSize(Float.parseFloat(str11));
        }
        if (strM1003c2 != null && strM1003c2.length() != 0) {
            textView.setTextColor(Color.parseColor(strM1003c2));
        }
        C0154d.m757a(textView, c0124r);
    }

    /* JADX INFO: renamed from: a */
    public static final void m770a(OTBannerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m784a(true, OTConsentInteractionType.BANNER_CLOSE);
    }

    /* JADX INFO: renamed from: a */
    public static final void m768a(OTBannerFragment this$0, C0123q otBannerUIProperty, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(otBannerUIProperty, "$otBannerUIProperty");
        C0048h.m304b(this$0.requireContext(), otBannerUIProperty.f796l.f756b);
    }

    /* JADX WARN: Removed duplicated region for block: B:323:0x0554 A[PHI: r11
      0x0554: PHI (r11v33 java.lang.String) = (r11v32 java.lang.String), (r11v40 java.lang.String) binds: [B:300:0x0518, B:318:0x0540] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x069b  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m767a(p000a.p001a.p002a.p003a.p014b.fragment.OTBannerFragment r23, p000a.p001a.p002a.p003a.p014b.DataModels.BannerData r24) {
        /*
            Method dump skipped, instruction units count: 2022
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.fragment.OTBannerFragment.m767a(a.a.a.a.b.h.b, a.a.a.a.b.a.a):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean m771a(p000a.p001a.p002a.p003a.p014b.fragment.OTBannerFragment r1, android.content.DialogInterface r2, int r3, android.view.KeyEvent r4) {
        /*
            java.lang.String r2 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            r2 = 4
            r0 = 0
            if (r3 != r2) goto L56
            int r2 = r4.getAction()
            r3 = 1
            if (r2 != r3) goto L56
            com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r2 = r1.f1141d
            java.lang.String r4 = "Banner - Back"
            if (r2 == 0) goto L46
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r2 = r2.isBannerBackButtonDisabled()
            if (r2 == 0) goto L26
            goto L46
        L26:
            com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r2 = r1.f1141d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r2 = r2.isBannerBackButtonDisMissUI()
            if (r2 == 0) goto L35
            r1.m784a(r0, r4)
            return r3
        L35:
            com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r2 = r1.f1141d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r2 = r2.isBannerBackButtonCloseBanner()
            if (r2 == 0) goto L56
            java.lang.String r2 = "Banner - Close"
            r1.m784a(r3, r2)
            return r3
        L46:
            a.a.a.a.a.b.b r2 = new a.a.a.a.a.b.b
            r3 = 18
            r2.<init>(r3)
            r2.f5d = r4
            a.a.a.a.b.b.f r3 = r1.f1144g
            a.a.a.a.a.b.a r1 = r1.f1140c
            r3.m411a(r2, r1)
        L56:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.fragment.OTBannerFragment.m771a(a.a.a.a.b.h.b, android.content.DialogInterface, int, android.view.KeyEvent):boolean");
    }

    @Override // p000a.p001a.p002a.p003a.p014b.InterfaceC0075c
    /* JADX INFO: renamed from: a */
    public void mo419a(int i) {
        if (i == 1) {
            dismiss();
            return;
        }
        if (i == 2) {
            ViewOnClickListenerC0159e viewOnClickListenerC0159eM829a = ViewOnClickListenerC0159e.m829a(OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG, this.f1140c, this.f1141d);
            Intrinsics.checkNotNullExpressionValue(viewOnClickListenerC0159eM829a, "newInstance(\n           …nfiguration\n            )");
            viewOnClickListenerC0159eM829a.f1252A = this;
            viewOnClickListenerC0159eM829a.f1295x = m785b().f1545a;
            this.f1143f = viewOnClickListenerC0159eM829a;
            return;
        }
        if (i != 3) {
            return;
        }
        OTVendorListFragment oTVendorListFragmentM930a = OTVendorListFragment.f1394n.m930a(OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG, this.f1140c, this.f1141d);
        oTVendorListFragmentM930a.m914a(m785b().f1545a);
        oTVendorListFragmentM930a.f1401f = this;
        this.f1142e = oTVendorListFragmentM930a;
    }
}
