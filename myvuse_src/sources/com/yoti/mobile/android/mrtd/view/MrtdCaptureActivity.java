package com.yoti.mobile.android.mrtd.view;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.commonui.extension.FragmentActivityKt;
import com.yoti.mobile.android.commonui.extension.LifecycleKt;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.mrtd.C4900R;
import com.yoti.mobile.android.mrtd.MrtdCaptureLauncherKt;
import com.yoti.mobile.android.mrtd.MrtdCaptureSession;
import com.yoti.mobile.android.mrtd.domain.INfcDispatcher;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015j\u0002`\u0018H\u0002J\u0016\u0010\u0019\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\"\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010 H\u0014J\u0012\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u0013H\u0016J\b\u0010%\u001a\u00020\u0013H\u0014J\b\u0010&\u001a\u00020\u0013H\u0014J\b\u0010'\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006("}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdCaptureActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/yoti/mobile/android/mrtd/view/NfcDialogHost;", "()V", "mrtdViewModel", "Lcom/yoti/mobile/android/mrtd/view/MrtdScanViewModel;", "nfcDispatcher", "Lcom/yoti/mobile/android/mrtd/domain/INfcDispatcher;", "getNfcDispatcher", "()Lcom/yoti/mobile/android/mrtd/domain/INfcDispatcher;", "setNfcDispatcher", "(Lcom/yoti/mobile/android/mrtd/domain/INfcDispatcher;)V", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;)V", "handleChipRead", "", "data", "", "", "", "Lcom/yoti/mobile/android/mrtd/ChipData;", "navigateTo", "screen", "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/mrtd/view/MrtdScreen;", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNfcEnableDismissed", "onPause", "onResume", "startNfcSettings", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdCaptureActivity extends AppCompatActivity implements NfcDialogHost, TraceFieldInterface {
    public Trace _nr_trace;
    private MrtdScanViewModel mrtdViewModel;

    @Inject
    public INfcDispatcher nfcDispatcher;

    @Inject
    public ViewModelFactory viewModelFactory;

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleChipRead(Map<Integer, byte[]> data) {
        Intent intent = new Intent();
        intent.putExtra(MrtdCaptureLauncherKt.CHIP_DATA_EXTRA, new HashMap(data));
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateTo(SingleEvent<? extends MrtdScreen> screen) {
        screen.getContentIfNotHandled(new Function1<MrtdScreen, Unit>() { // from class: com.yoti.mobile.android.mrtd.view.MrtdCaptureActivity.navigateTo.1

            /* JADX INFO: renamed from: com.yoti.mobile.android.mrtd.view.MrtdCaptureActivity$navigateTo$1$WhenMappings */
            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[MrtdScreen.values().length];
                    iArr[MrtdScreen.EDUCATION.ordinal()] = 1;
                    iArr[MrtdScreen.ENABLE_PROMPT.ordinal()] = 2;
                    iArr[MrtdScreen.SCAN_START.ordinal()] = 3;
                    iArr[MrtdScreen.SCAN_PROGRESS.ordinal()] = 4;
                    iArr[MrtdScreen.SCAN_COMPLETE.ordinal()] = 5;
                    iArr[MrtdScreen.ERROR_DETECT.ordinal()] = 6;
                    iArr[MrtdScreen.FAIL_DETECT.ordinal()] = 7;
                    iArr[MrtdScreen.ERROR_READ.ordinal()] = 8;
                    iArr[MrtdScreen.FAIL_READ.ordinal()] = 9;
                    iArr[MrtdScreen.ABORTED.ordinal()] = 10;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MrtdScreen mrtdScreen) {
                invoke2(mrtdScreen);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MrtdScreen it2) {
                int i;
                Intrinsics.checkNotNullParameter(it2, "it");
                NavController navControllerFindNavController = ActivityKt.findNavController(MrtdCaptureActivity.this, C4900R.id.mrtdNavigationFragment);
                switch (WhenMappings.$EnumSwitchMapping$0[it2.ordinal()]) {
                    case 1:
                        i = C4900R.id.action_restart_flow;
                        NavigationKt.navigateSafe$default(navControllerFindNavController, i, null, null, null, 14, null);
                    case 2:
                        i = C4900R.id.action_enable_nfc;
                        NavigationKt.navigateSafe$default(navControllerFindNavController, i, null, null, null, 14, null);
                    case 3:
                        MrtdCaptureActivity.this.getNfcDispatcher().enableDispatch(MrtdCaptureActivity.this);
                        break;
                    case 4:
                    case 5:
                        break;
                    case 6:
                        i = C4900R.id.action_nfc_detect_error;
                        NavigationKt.navigateSafe$default(navControllerFindNavController, i, null, null, null, 14, null);
                    case 7:
                        i = C4900R.id.action_nfc_detect_failed;
                        NavigationKt.navigateSafe$default(navControllerFindNavController, i, null, null, null, 14, null);
                    case 8:
                        i = C4900R.id.action_nfc_read_error;
                        NavigationKt.navigateSafe$default(navControllerFindNavController, i, null, null, null, 14, null);
                    case 9:
                        i = C4900R.id.action_nfc_read_failed;
                        NavigationKt.navigateSafe$default(navControllerFindNavController, i, null, null, null, 14, null);
                    case 10:
                        FragmentActivityKt.finishWithResult(MrtdCaptureActivity.this, 1);
                        return;
                    default:
                        return;
                }
                i = C4900R.id.action_read_nfc;
                NavigationKt.navigateSafe$default(navControllerFindNavController, i, null, null, null, 14, null);
            }
        });
    }

    public final INfcDispatcher getNfcDispatcher() {
        INfcDispatcher iNfcDispatcher = this.nfcDispatcher;
        if (iNfcDispatcher != null) {
            return iNfcDispatcher;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nfcDispatcher");
        return null;
    }

    public final ViewModelFactory getViewModelFactory() {
        ViewModelFactory viewModelFactory = this.viewModelFactory;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != 1009) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        MrtdScanViewModel mrtdScanViewModel = this.mrtdViewModel;
        if (mrtdScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mrtdViewModel");
            mrtdScanViewModel = null;
        }
        mrtdScanViewModel.checkScanStatus();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        TraceMachine.startTracing("MrtdCaptureActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "MrtdCaptureActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "MrtdCaptureActivity#onCreate", null);
        }
        MrtdCaptureSession.INSTANCE.getInstance().initComponent(this, savedInstanceState).inject(this);
        super.onCreate(savedInstanceState);
        setContentView(C4900R.layout.yds_activity_mrtd_capture);
        MrtdScanViewModel mrtdScanViewModel = (MrtdScanViewModel) new ViewModelProvider(this, getViewModelFactory()).get(MrtdScanViewModel.class);
        LifecycleKt.observe(this, mrtdScanViewModel.getCurrentScreen(), new MrtdCaptureActivity$onCreate$1$1(this));
        LifecycleKt.observe(this, mrtdScanViewModel.getChipData(), new MrtdCaptureActivity$onCreate$1$2(this));
        this.mrtdViewModel = mrtdScanViewModel;
        TraceMachine.exitMethod();
    }

    @Override // com.yoti.mobile.android.mrtd.view.NfcDialogHost
    public void onNfcEnableDismissed() {
        MrtdScanViewModel mrtdScanViewModel = this.mrtdViewModel;
        if (mrtdScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mrtdViewModel");
            mrtdScanViewModel = null;
        }
        mrtdScanViewModel.checkScanStatus();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        getNfcDispatcher().disableDispatch(this);
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        getNfcDispatcher().enableDispatch(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public final void setNfcDispatcher(INfcDispatcher iNfcDispatcher) {
        Intrinsics.checkNotNullParameter(iNfcDispatcher, "<set-?>");
        this.nfcDispatcher = iNfcDispatcher;
    }

    public final void setViewModelFactory(ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "<set-?>");
        this.viewModelFactory = viewModelFactory;
    }

    @Override // com.yoti.mobile.android.mrtd.view.NfcDialogHost
    public void startNfcSettings() {
        Object next;
        Iterator it2 = SequencesKt.map(MrtdCaptureActivityKt.SETTINGS_ACTIONS, new Function1<String, Intent>() { // from class: com.yoti.mobile.android.mrtd.view.MrtdCaptureActivity$startNfcSettings$intent$1
            @Override // kotlin.jvm.functions.Function1
            public final Intent invoke(String action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Intent(action);
            }
        }).iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (getPackageManager().resolveActivity((Intent) next, 0) != null) {
                break;
            }
        }
        Intent intent = (Intent) next;
        if (intent == null) {
            intent = new Intent("android.settings.SETTINGS");
        }
        startActivityForResult(intent, PointerIconCompat.TYPE_VERTICAL_TEXT);
    }
}
