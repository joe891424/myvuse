package com.salesforce.marketingcloud.messages.iam;

import android.R;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.salesforce.marketingcloud.C4089R;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;

/* JADX INFO: loaded from: classes6.dex */
public class IamFullscreenActivity extends AbstractViewOnClickListenerC4255f {

    /* JADX INFO: renamed from: f */
    protected View f5208f;

    /* JADX INFO: renamed from: g */
    private C4260k f5209g;

    /* JADX INFO: renamed from: h */
    private InAppMessage f5210h;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.IamFullscreenActivity$a */
    static /* synthetic */ class C4240a {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f5211a;

        /* JADX INFO: renamed from: b */
        static final /* synthetic */ int[] f5212b;

        static {
            int[] iArr = new int[InAppMessage.Type.values().length];
            f5212b = iArr;
            try {
                iArr[InAppMessage.Type.full.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5212b[InAppMessage.Type.fullImageFill.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[InAppMessage.LayoutOrder.values().length];
            f5211a = iArr2;
            try {
                iArr2[InAppMessage.LayoutOrder.ImageTitleBody.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5211a[InAppMessage.LayoutOrder.TitleImageBody.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private int m3688a(InAppMessage inAppMessage) {
        int i = C4089R.layout.mcsdk_iam_full_inset_itb;
        int i2 = C4240a.f5212b[inAppMessage.type().ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? i : (inAppMessage.media() == null || inAppMessage.media().size() != InAppMessage.Media.ImageSize.e2e) ? C4089R.layout.mcsdk_iam_fif_inset_itb : C4089R.layout.mcsdk_iam_fif_e2e_itb;
        }
        int i3 = C4240a.f5211a[inAppMessage.layoutOrder().ordinal()];
        return i3 != 1 ? i3 != 2 ? i : (inAppMessage.media() == null || inAppMessage.media().size() != InAppMessage.Media.ImageSize.e2e) ? C4089R.layout.mcsdk_iam_full_inset_tib : C4089R.layout.mcsdk_iam_full_e2e_tib : (inAppMessage.media() == null || inAppMessage.media().size() != InAppMessage.Media.ImageSize.e2e) ? C4089R.layout.mcsdk_iam_full_inset_itb : C4089R.layout.mcsdk_iam_full_e2e_itb;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f
    /* JADX INFO: renamed from: b */
    public /* bridge */ /* synthetic */ void mo3685b(InAppMessage.Button button) {
        super.mo3685b(button);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, android.app.Activity
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, androidx.activity.ComponentActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(View view) {
        super.onClick(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C4260k c4260k;
        super.onConfigurationChanged(configuration);
        InAppMessage inAppMessage = this.f5210h;
        if (inAppMessage == null || inAppMessage.type() != InAppMessage.Type.fullImageFill || configuration.orientation != 2 || (c4260k = this.f5209g) == null) {
            return;
        }
        c4260k.m3767a(C4259j.m3755a(c4260k.m3770c(), this.f5209g.m3769b()));
        finish();
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isFinishing()) {
            return;
        }
        this.f5208f = findViewById(R.id.content);
        C4260k c4260kM3746c = m3746c();
        this.f5209g = c4260kM3746c;
        InAppMessage inAppMessageM3771d = c4260kM3746c.m3771d();
        this.f5210h = inAppMessageM3771d;
        setContentView(m3688a(inAppMessageM3771d));
        new C4254e(this, this.f5209g.m3777k()).m3735a(this.f5208f, this.f5209g);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        View view = this.f5208f;
        if (view != null) {
            ViewCompat.setOnApplyWindowInsetsListener(view, null);
        }
        super.onDestroy();
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, com.salesforce.marketingcloud.messages.iam.SwipeDismissConstraintLayout.SwipeDismissListener
    public /* bridge */ /* synthetic */ void onDismissed() {
        super.onDismissed();
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, com.salesforce.marketingcloud.messages.iam.SwipeDismissConstraintLayout.SwipeDismissListener
    public /* bridge */ /* synthetic */ void onSwipeStarted() {
        super.onSwipeStarted();
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, com.salesforce.marketingcloud.messages.iam.SwipeDismissConstraintLayout.SwipeDismissListener
    public /* bridge */ /* synthetic */ void onViewSettled() {
        super.onViewSettled();
    }
}
