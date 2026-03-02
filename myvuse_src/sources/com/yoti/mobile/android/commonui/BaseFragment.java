package com.yoti.mobile.android.commonui;

import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.FragmentKt;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController;
import com.newrelic.agent.android.tracing.Trace;
import com.yoti.mobile.android.common.p049ui.widgets.AppBarDescription;
import com.yoti.mobile.android.common.p049ui.widgets.CommonYotiAppBar;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.commons.util.C4588L;
import com.yoti.mobile.android.commonui.YotiDocsDialogFragment;
import com.yoti.mobile.android.commonui.extension.FragmentActivityKt;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001/B\u000f\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ@\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0003\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0003\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\fJ\u0006\u0010\u0018\u001a\u00020\fJ\b\u0010\u0019\u001a\u00020\fH\u0014J\b\u0010\u001a\u001a\u00020\fH\u0014J\b\u0010\u001b\u001a\u00020\fH\u0014J\b\u0010\u001c\u001a\u00020\fH\u0004J\u001a\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$H\u0004JI\u0010%\u001a\u00020\f2\b\b\u0003\u0010\u0014\u001a\u00020\u00042\b\b\u0001\u0010&\u001a\u00020\u00042\b\b\u0001\u0010'\u001a\u00020\u00042\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\t¢\u0006\u0002\u0010,J\u0018\u0010-\u001a\u00020\f2\u0006\u0010#\u001a\u00020.2\u0006\u0010+\u001a\u00020\tH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/yoti/mobile/android/commonui/YotiDocsDialogFragment$DialogListener;", "contentLayoutId", "", "(I)V", "dialog", "Lcom/yoti/mobile/android/commonui/YotiDocsDialogFragment;", "logTag", "", "kotlin.jvm.PlatformType", "cancelFlow", "", "configureAppBar", "Lcom/yoti/mobile/android/common/ui/widgets/CommonYotiAppBar;", "appBar", "navigationIcon", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "hideSeparator", "", "title", "titleGravity", "logoRes", "finishFlow", "finishSdk", "handleNavigationIconClicked", "handleOnBackPressed", "navigateBack", "navigateBackInBackStack", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showDeadEndFailure", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "showDialog", "text", "positiveButton", "negativeButton", "dialogType", "Lcom/yoti/mobile/android/commonui/DialogType;", "dialogTag", "(IIILjava/lang/Integer;Lcom/yoti/mobile/android/commonui/DialogType;Ljava/lang/String;)V", "showFailure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "BaseFragmentOnBackPressedCallback", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class BaseFragment extends Fragment implements YotiDocsDialogFragment.DialogListener, TraceFieldInterface {
    public Trace _nr_trace;
    private YotiDocsDialogFragment dialog;
    private final String logTag;

    public BaseFragment() {
        this(0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    public BaseFragment(int i) {
        super(i);
        this.logTag = getClass().getSimpleName();
    }

    public /* synthetic */ BaseFragment(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    @Override // com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onNegativeButtonClick(String str) {
        YotiDocsDialogFragment.DialogListener.DefaultImpls.onNegativeButtonClick(this, str);
    }

    @Override // com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onPositiveButtonClick(String str) {
        YotiDocsDialogFragment.DialogListener.DefaultImpls.onPositiveButtonClick(this, str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new BaseFragmentOnBackPressedCallback());
    }

    public void showFailure(YdsFailure failure, String dialogTag) {
        Intrinsics.checkNotNullParameter(failure, "failure");
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        String logTag = this.logTag;
        Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
        C4588L.logError(logTag, "showFailure() - failure: " + failure + ", dialogTag: " + dialogTag, failure.getCause());
        if (failure.isRetryAllowed()) {
            showDialog$default(this, failure.getFailureType().getF7489b(), failure.getFailureType().getF7490c(), C4590R.string.yds_common_try_again, Integer.valueOf(C4590R.string.ios_android_yds_common_cancel), null, dialogTag, 16, null);
        } else {
            showDeadEndFailure(failure.getFailureType());
        }
    }

    public final void cancelFlow() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        FragmentActivityKt.finishWithResult(fragmentActivityRequireActivity, FragmentActivityKt.getRESULT_FLOW_CANCELED());
    }

    public final void finishFlow() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        FragmentActivityKt.finishWithResult(fragmentActivityRequireActivity, -1);
    }

    protected void navigateBack() {
        navigateBackInBackStack();
    }

    protected final void navigateBackInBackStack() {
        NavController navControllerFindNavController = FragmentKt.findNavController(this);
        if (!(navControllerFindNavController instanceof NavHostController) ? navControllerFindNavController.popBackStack() : NavigationController.popBackStack((NavHostController) navControllerFindNavController)) {
            return;
        }
        requireActivity().finish();
    }

    public final void finishSdk() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        FragmentActivityKt.closeYotiDocSDK(fragmentActivityRequireActivity);
    }

    public static /* synthetic */ CommonYotiAppBar configureAppBar$default(BaseFragment baseFragment, CommonYotiAppBar commonYotiAppBar, NavigationIcon navigationIcon, boolean z, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: configureAppBar");
        }
        if ((i4 & 2) != 0) {
            navigationIcon = NavigationIcon.CLOSE_BLUE;
        }
        NavigationIcon navigationIcon2 = navigationIcon;
        if ((i4 & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        int i5 = (i4 & 8) != 0 ? 0 : i;
        if ((i4 & 16) != 0) {
            i2 = GravityCompat.START;
        }
        return baseFragment.configureAppBar(commonYotiAppBar, navigationIcon2, z2, i5, i2, (i4 & 32) != 0 ? 0 : i3);
    }

    public final CommonYotiAppBar configureAppBar(CommonYotiAppBar appBar, NavigationIcon navigationIcon, boolean hideSeparator, int title, int titleGravity, int logoRes) {
        Intrinsics.checkNotNullParameter(appBar, "appBar");
        Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
        appBar.updateAppBar(new AppBarDescription(navigationIcon, title, null, titleGravity, false, null, null, Boolean.valueOf(hideSeparator), false, logoRes, 0, 1396, null));
        if (navigationIcon != NavigationIcon.NONE && navigationIcon != NavigationIcon.INVISBLE) {
            appBar.getToolbar().setNavigationOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.commonui.BaseFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseFragment.m6782configureAppBar$lambda1$lambda0(this.f$0, view);
                }
            });
        }
        return appBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: configureAppBar$lambda-1$lambda-0, reason: not valid java name */
    public static final void m6782configureAppBar$lambda1$lambda0(BaseFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleNavigationIconClicked();
    }

    protected final void showDeadEndFailure(YdsFailureType failure) {
        Intrinsics.checkNotNullParameter(failure, "failure");
        NavigationKt.navigateSafeToNavGraph(FragmentKt.findNavController(this), C4590R.navigation.yds_dead_end_nav_graph, new GenericMessageFragmentArgs(failure.getF7488a(), failure.getF7489b(), null, failure.getF7490c(), null, C4590R.string.yds_common_exit, null, 0, 0, null, 0, null, 4052, null).toBundle());
    }

    public static /* synthetic */ void showDialog$default(BaseFragment baseFragment, int i, int i2, int i3, Integer num, DialogType dialogType, String str, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDialog");
        }
        if ((i4 & 1) != 0) {
            i = 0;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            num = null;
        }
        Integer num2 = num;
        if ((i4 & 16) != 0) {
            dialogType = DialogType.DEFAULT;
        }
        DialogType dialogType2 = dialogType;
        if ((i4 & 32) != 0) {
            str = "";
        }
        baseFragment.showDialog(i5, i2, i3, num2, dialogType2, str);
    }

    public final void showDialog(int title, int text, int positiveButton, Integer negativeButton, DialogType dialogType, String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogType, "dialogType");
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        YotiDocsDialogFragment yotiDocsDialogFragment = this.dialog;
        if (yotiDocsDialogFragment != null) {
            yotiDocsDialogFragment.dismiss();
        }
        YotiDocsDialogFragment yotiDocsDialogFragmentNewInstance = YotiDocsDialogFragment.INSTANCE.newInstance(title, text, positiveButton, negativeButton, dialogType);
        yotiDocsDialogFragmentNewInstance.show(getChildFragmentManager(), dialogTag);
        this.dialog = yotiDocsDialogFragmentNewInstance;
    }

    protected void handleNavigationIconClicked() {
        navigateBack();
    }

    protected void handleOnBackPressed() {
        navigateBack();
    }

    /* JADX INFO: compiled from: BaseFragment.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/BaseFragment$BaseFragmentOnBackPressedCallback;", "Landroidx/activity/OnBackPressedCallback;", "(Lcom/yoti/mobile/android/commonui/BaseFragment;)V", "handleOnBackPressed", "", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private final class BaseFragmentOnBackPressedCallback extends OnBackPressedCallback {
        public BaseFragmentOnBackPressedCallback() {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            BaseFragment.this.handleOnBackPressed();
        }
    }
}
