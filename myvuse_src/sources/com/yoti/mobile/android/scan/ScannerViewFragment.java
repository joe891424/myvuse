package com.yoti.mobile.android.scan;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.airbnb.lottie.LottieAnimationView;
import com.yoti.mobile.android.scan.p078ui.C4945a;
import com.yoti.mobile.android.scan.p078ui.C4946b;
import com.yoti.mobile.android.scan.p078ui.C4947c;
import com.yoti.mobile.android.scan.p078ui.FocusView;
import it.sephiroth.android.library.xtooltip.ClosePolicy;
import it.sephiroth.android.library.xtooltip.Tooltip;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u0000 82\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0016J\u001a\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\u001a2\b\b\u0001\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0010\u0010-\u001a\u00020\u001a2\b\b\u0001\u0010.\u001a\u00020*J\b\u0010/\u001a\u00020\u001aH\u0002J\u0006\u00100\u001a\u00020\u001aJ\b\u00101\u001a\u00020\u001aH\u0002J \u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000206H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u00069"}, m5598d2 = {"Lcom/yoti/mobile/android/scan/ScannerViewFragment;", "Lcom/yoti/mobile/android/scan/ScannerViewBaseFragment;", "()V", "focusContainerView", "Landroid/view/View;", "focusView", "Lcom/yoti/mobile/android/scan/ui/FocusView;", "hideScanningInstructionsButton", "Landroid/widget/Button;", "parentContainerView", "scanningInstructionsView", "Landroid/widget/TextView;", "toolTipBuilder", "Lit/sephiroth/android/library/xtooltip/Tooltip$Builder;", "tooltip", "Lit/sephiroth/android/library/xtooltip/Tooltip;", "viewModel", "Lcom/yoti/mobile/android/scan/ui/ScannerViewModel;", "viewModelProvider", "Landroidx/lifecycle/ViewModelProvider;", "calculateFocusAreaCoordinates", "Landroid/graphics/Rect;", "getTooltip", "text", "", "handleArguments", "", "rootView", "handleViewDataChanged", "viewData", "Lcom/yoti/mobile/android/scan/ui/ScannerViewData;", "hideFocusArea", "hideScanningInstructions", "onAttach", "activity", "Landroid/content/Context;", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "setScanningInstructionsMessage", "textId", "", "setStatusText", "setupViews", "showFailureFeedback", "feedbackText", "showFocusArea", "showNoFeedback", "showScanningInstructions", "updateScanningInstructionsAnimation", "lottieAnimationView", "Lcom/airbnb/lottie/LottieAnimationView;", "scanningInstructionAnimationFolder", "", "scanningInstructionAnimationJsonFile", "Companion", "scan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public class ScannerViewFragment extends ScannerViewBaseFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: g */
    private Tooltip f7405g;

    /* JADX INFO: renamed from: h */
    private Tooltip.Builder f7406h;

    /* JADX INFO: renamed from: i */
    private View f7407i;

    /* JADX INFO: renamed from: j */
    private View f7408j;

    /* JADX INFO: renamed from: k */
    private Button f7409k;

    /* JADX INFO: renamed from: l */
    private TextView f7410l;

    /* JADX INFO: renamed from: m */
    private FocusView f7411m;

    /* JADX INFO: renamed from: n */
    private ViewModelProvider f7412n;

    /* JADX INFO: renamed from: o */
    private C4947c f7413o;

    /* JADX INFO: renamed from: p */
    private HashMap f7414p;

    /* JADX INFO: renamed from: com.yoti.mobile.android.scan.ScannerViewFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ ScannerViewFragment m5056a(Companion companion, int i, String str, String str2, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = -1;
            }
            if ((i2 & 2) != 0) {
                str = null;
            }
            if ((i2 & 4) != 0) {
                str2 = null;
            }
            if ((i2 & 8) != 0) {
                z = false;
            }
            return companion.m5057a(i, str, str2, z);
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final ScannerViewFragment m5057a(int i, String str, String str2, boolean z) {
            ScannerViewFragment scannerViewFragment = new ScannerViewFragment();
            Bundle bundle = new Bundle();
            ScannerViewBaseFragment.INSTANCE.m5044a(bundle, z);
            bundle.putInt(C4944j.f7430b, i);
            bundle.putString(C4944j.f7431c, str);
            bundle.putString(C4944j.f7432d, str2);
            scannerViewFragment.setArguments(bundle);
            return scannerViewFragment;
        }
    }

    public ScannerViewFragment() {
        super(C4928R.layout.yoti_lib_scan_view_fragment);
    }

    /* JADX INFO: renamed from: a */
    private final Tooltip m5045a(CharSequence charSequence) {
        Tooltip.Builder builder = this.f7406h;
        if (builder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolTipBuilder");
        }
        View view = this.f7408j;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("focusContainerView");
        }
        Tooltip.Builder.anchor$default(builder, view, 0, 0, false, 14, null);
        builder.text(charSequence);
        return builder.create();
    }

    /* JADX INFO: renamed from: a */
    private final void m5046a(int i) {
        if (i != -1) {
            TextView textView = this.f7410l;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanningInstructionsView");
            }
            textView.setText(i);
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m5047a(View view) {
        Bundle arguments = getArguments();
        if (arguments == null) {
            throw new IllegalArgumentException("Missing required fragment arguments");
        }
        m5046a(arguments.getInt(C4944j.f7430b, -1));
        String string = arguments.getString(C4944j.f7431c);
        String string2 = arguments.getString(C4944j.f7432d);
        if (string == null || string.length() == 0 || string2 == null || string2.length() == 0) {
            return;
        }
        View viewFindViewById = view.findViewById(C4928R.id.animation_view);
        if (viewFindViewById == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        }
        m5048a((LottieAnimationView) viewFindViewById, string, string2);
    }

    /* JADX INFO: renamed from: a */
    private final void m5048a(LottieAnimationView lottieAnimationView, String str, String str2) {
        lottieAnimationView.setImageAssetsFolder(str);
        lottieAnimationView.setAnimation(str2);
        lottieAnimationView.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m5049a(C4946b c4946b) {
        if (c4946b.m5073a()) {
            m5055f();
        } else {
            m5053d();
        }
    }

    public static final /* synthetic */ View access$getFocusContainerView$p(ScannerViewFragment scannerViewFragment) {
        View view = scannerViewFragment.f7408j;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("focusContainerView");
        }
        return view;
    }

    public static final /* synthetic */ C4947c access$getViewModel$p(ScannerViewFragment scannerViewFragment) {
        C4947c c4947c = scannerViewFragment.f7413o;
        if (c4947c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return c4947c;
    }

    /* JADX INFO: renamed from: b */
    private final void m5050b(int i) {
        Tooltip tooltip = this.f7405g;
        if (tooltip != null) {
            if (!tooltip.getIsShowing()) {
                tooltip = null;
            }
            if (tooltip != null) {
                tooltip.hide();
            }
        }
        if (i != -1) {
            String string = getString(i);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(textId)");
            Tooltip tooltipM5045a = m5045a((CharSequence) string);
            View view = this.f7407i;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parentContainerView");
            }
            tooltipM5045a.show(view, Tooltip.Gravity.BOTTOM, true);
            this.f7405g = tooltipM5045a;
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m5051b(View view) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkExpressionValueIsNotNull(contextRequireContext, "requireContext()");
        this.f7406h = new Tooltip.Builder(contextRequireContext).closePolicy(ClosePolicy.INSTANCE.getTOUCH_NONE()).showDuration(TimeUnit.SECONDS.toMillis(3L)).arrow(true).styleId(Integer.valueOf(C4928R.style.Yoti_DefaultToolTipStyle)).overlay(false);
        View viewFindViewById = view.findViewById(C4928R.id.relativeLayoutScannerView);
        Intrinsics.checkExpressionValueIsNotNull(viewFindViewById, "rootView.findViewById(R.…elativeLayoutScannerView)");
        this.f7407i = viewFindViewById;
        View viewFindViewById2 = view.findViewById(C4928R.id.focus_container);
        Intrinsics.checkExpressionValueIsNotNull(viewFindViewById2, "rootView.findViewById(R.id.focus_container)");
        this.f7408j = viewFindViewById2;
        View viewFindViewById3 = view.findViewById(C4928R.id.hide_instructions_button);
        Intrinsics.checkExpressionValueIsNotNull(viewFindViewById3, "rootView.findViewById(R.…hide_instructions_button)");
        this.f7409k = (Button) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(C4928R.id.scanning_instructions_view);
        Intrinsics.checkExpressionValueIsNotNull(viewFindViewById4, "rootView.findViewById(R.…anning_instructions_view)");
        this.f7410l = (TextView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(C4928R.id.focus_view);
        Intrinsics.checkExpressionValueIsNotNull(viewFindViewById5, "rootView.findViewById(R.id.focus_view)");
        this.f7411m = (FocusView) viewFindViewById5;
        Button button = this.f7409k;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hideScanningInstructionsButton");
        }
        button.setOnClickListener(new ViewOnClickListenerC4942h(this));
        View view2 = this.f7408j;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("focusContainerView");
        }
        view2.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC4943i(this));
    }

    /* JADX INFO: renamed from: c */
    private final Rect m5052c() {
        Rect rect = new Rect();
        View view = this.f7408j;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("focusContainerView");
        }
        view.getLocalVisibleRect(rect);
        int[] iArr = new int[2];
        View view2 = this.f7408j;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("focusContainerView");
        }
        view2.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        requireView().getLocationInWindow(iArr2);
        int i = iArr[0] - iArr2[0];
        int i2 = iArr[1] - iArr2[1];
        int iWidth = rect.width() + i;
        int iHeight = rect.height() + i2;
        Rect rect2 = new Rect();
        rect2.set(i, i2, iWidth, iHeight);
        return rect2;
    }

    /* JADX INFO: renamed from: d */
    private final void m5053d() {
        View view = this.f7408j;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("focusContainerView");
        }
        if (view.getVisibility() == 0) {
            Button button = this.f7409k;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hideScanningInstructionsButton");
            }
            button.setVisibility(4);
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC4940f(this));
            View view2 = this.f7408j;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("focusContainerView");
            }
            view2.startAnimation(animationLoadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public final void m5054e() {
        Rect rectM5052c = m5052c();
        int i = rectM5052c.right - rectM5052c.left;
        Tooltip.Builder builder = this.f7406h;
        if (builder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolTipBuilder");
        }
        builder.maxWidth(i);
        FocusView focusView = this.f7411m;
        if (focusView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("focusView");
        }
        focusView.m5072a(rectM5052c);
    }

    /* JADX INFO: renamed from: f */
    private final void m5055f() {
        View view = this.f7408j;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("focusContainerView");
        }
        view.setVisibility(0);
        Button button = this.f7409k;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hideScanningInstructionsButton");
        }
        button.setVisibility(0);
    }

    @JvmStatic
    public static final ScannerViewFragment init() {
        return Companion.m5056a(INSTANCE, 0, null, null, false, 15, null);
    }

    @JvmStatic
    public static final ScannerViewFragment init(int i) {
        return Companion.m5056a(INSTANCE, i, null, null, false, 14, null);
    }

    @JvmStatic
    public static final ScannerViewFragment init(int i, String str) {
        return Companion.m5056a(INSTANCE, i, str, null, false, 12, null);
    }

    @JvmStatic
    public static final ScannerViewFragment init(int i, String str, String str2) {
        return Companion.m5056a(INSTANCE, i, str, str2, false, 8, null);
    }

    @JvmStatic
    public static final ScannerViewFragment init(int i, String str, String str2, boolean z) {
        return INSTANCE.m5057a(i, str, str2, z);
    }

    @Override // com.yoti.mobile.android.scan.ScannerViewBaseFragment
    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f7414p;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.yoti.mobile.android.scan.ScannerViewBaseFragment
    public View _$_findCachedViewById(int i) {
        if (this.f7414p == null) {
            this.f7414p = new HashMap();
        }
        View view = (View) this.f7414p.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View viewFindViewById = view2.findViewById(i);
        this.f7414p.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // com.yoti.mobile.android.scan.ScannerViewBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        super.onAttach(activity);
        Context contextRequireContext = requireContext();
        Intrinsics.checkExpressionValueIsNotNull(contextRequireContext, "requireContext()");
        this.f7412n = new ViewModelProvider(this, new C4945a(contextRequireContext));
    }

    @Override // com.yoti.mobile.android.scan.ScannerViewBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.yoti.mobile.android.scan.ScannerViewBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, savedInstanceState);
        m5051b(view);
        m5047a(view);
        ViewModelProvider viewModelProvider = this.f7412n;
        if (viewModelProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
        }
        ViewModel viewModel = viewModelProvider.get((Class<ViewModel>) C4947c.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "get(VM::class.java)");
        C4947c c4947c = (C4947c) viewModel;
        this.f7413o = c4947c;
        if (c4947c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LiveData<C4946b> liveDataM5074a = c4947c.m5074a();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkExpressionValueIsNotNull(viewLifecycleOwner, "viewLifecycleOwner");
        liveDataM5074a.observe(viewLifecycleOwner, new C4941g(this));
    }

    public final void showFailureFeedback(int feedbackText) {
        m5050b(feedbackText);
    }

    public final void showNoFeedback() {
        m5050b(-1);
    }
}
