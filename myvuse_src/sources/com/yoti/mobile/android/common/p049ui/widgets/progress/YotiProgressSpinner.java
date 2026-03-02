package com.yoti.mobile.android.common.p049ui.widgets.progress;

import android.R;
import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yoti.mobile.android.common.p049ui.widgets.progress.ProgressSpinnerScheduler;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0015\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\tR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006!"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/progress/YotiProgressSpinner;", "", "", "showProgress", "()V", "hideProgress", "hideProgressImmediate", "Landroid/view/View;", "b", "Landroid/view/View;", "spinnerContainer", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "activityContainer", "Landroid/app/Activity;", "f", "Landroid/app/Activity;", "activity", "a", "progress", "com/yoti/mobile/android/common/ui/widgets/progress/YotiProgressSpinner$spinnerListener$1", "d", "Lcom/yoti/mobile/android/common/ui/widgets/progress/YotiProgressSpinner$spinnerListener$1;", "spinnerListener", "Lcom/yoti/mobile/android/common/ui/widgets/progress/ProgressSpinnerScheduler;", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "Lcom/yoti/mobile/android/common/ui/widgets/progress/ProgressSpinnerScheduler;", "progressSpinnerScheduler", "Landroid/os/Handler;", "mainThreadHandler", "<init>", "(Landroid/app/Activity;Landroid/os/Handler;)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class YotiProgressSpinner {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private View progress;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private View spinnerContainer;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private ViewGroup activityContainer;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final YotiProgressSpinner$spinnerListener$1 spinnerListener;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final ProgressSpinnerScheduler progressSpinnerScheduler;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final Activity activity;

    /* JADX WARN: Type inference failed for: r2v1, types: [com.yoti.mobile.android.common.ui.widgets.progress.ProgressSpinnerScheduler$d, com.yoti.mobile.android.common.ui.widgets.progress.YotiProgressSpinner$spinnerListener$1] */
    public YotiProgressSpinner(Activity activity, Handler mainThreadHandler) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mainThreadHandler, "mainThreadHandler");
        this.activity = activity;
        ?? r2 = new ProgressSpinnerScheduler.InterfaceC4561d() { // from class: com.yoti.mobile.android.common.ui.widgets.progress.YotiProgressSpinner$spinnerListener$1
            @Override // com.yoti.mobile.android.common.p049ui.widgets.progress.ProgressSpinnerScheduler.InterfaceC4561d
            public void addTransparentLayerForProgress() {
                if (this.f6479a.progress == null) {
                    YotiProgressSpinner yotiProgressSpinner = this.f6479a;
                    yotiProgressSpinner.progress = LayoutInflater.from(yotiProgressSpinner.activity).inflate(C4584R.layout.progress_bar, (ViewGroup) null);
                    YotiProgressSpinner yotiProgressSpinner2 = this.f6479a;
                    View view = yotiProgressSpinner2.progress;
                    Intrinsics.checkNotNull(view);
                    yotiProgressSpinner2.spinnerContainer = view.findViewById(C4584R.id.spinnerContainer);
                    YotiProgressSpinner yotiProgressSpinner3 = this.f6479a;
                    yotiProgressSpinner3.activityContainer = (ViewGroup) yotiProgressSpinner3.activity.findViewById(R.id.content);
                }
                View view2 = this.f6479a.progress;
                if ((view2 != null ? view2.getParent() : null) == null) {
                    ViewGroup viewGroup = this.f6479a.activityContainer;
                    if (viewGroup != null) {
                        viewGroup.addView(this.f6479a.progress, -1, -1);
                    }
                    View view3 = this.f6479a.progress;
                    if (view3 != null) {
                        view3.setVisibility(0);
                    }
                    View view4 = this.f6479a.spinnerContainer;
                    if (view4 != null) {
                        view4.setVisibility(4);
                    }
                }
            }

            @Override // com.yoti.mobile.android.common.p049ui.widgets.progress.ProgressSpinnerScheduler.InterfaceC4561d
            public void removeSpinnerProgress() {
                if (this.f6479a.progress != null) {
                    View view = this.f6479a.progress;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    ViewGroup viewGroup = this.f6479a.activityContainer;
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f6479a.progress);
                    }
                }
            }

            @Override // com.yoti.mobile.android.common.p049ui.widgets.progress.ProgressSpinnerScheduler.InterfaceC4561d
            public void showSpinnerProgress() {
                addTransparentLayerForProgress();
                View view = this.f6479a.spinnerContainer;
                if (view != null) {
                    view.setVisibility(0);
                }
            }
        };
        this.spinnerListener = r2;
        this.progressSpinnerScheduler = new ProgressSpinnerScheduler(r2, mainThreadHandler);
    }

    public /* synthetic */ YotiProgressSpinner(Activity activity, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i & 2) != 0 ? new Handler() : handler);
    }

    public final void hideProgress() {
        this.progressSpinnerScheduler.stopProgress();
    }

    public final void hideProgressImmediate() {
        this.progressSpinnerScheduler.stopProgressImmediate();
    }

    public final void showProgress() {
        this.progressSpinnerScheduler.startProgress();
    }
}
