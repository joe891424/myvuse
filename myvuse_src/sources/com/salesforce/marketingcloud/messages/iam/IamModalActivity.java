package com.salesforce.marketingcloud.messages.iam;

import android.R;
import android.os.Bundle;
import android.view.View;
import com.salesforce.marketingcloud.C4089R;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;

/* JADX INFO: loaded from: classes6.dex */
public class IamModalActivity extends AbstractViewOnClickListenerC4255f implements View.OnClickListener {

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.IamModalActivity$a */
    static /* synthetic */ class C4241a {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f5213a;

        static {
            int[] iArr = new int[InAppMessage.LayoutOrder.values().length];
            f5213a = iArr;
            try {
                iArr[InAppMessage.LayoutOrder.ImageTitleBody.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5213a[InAppMessage.LayoutOrder.TitleImageBody.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected int m3689a(InAppMessage inAppMessage) {
        int i = C4089R.layout.mcsdk_iam_modal_inset_itb;
        InAppMessage.Media media = inAppMessage.media();
        int i2 = C4241a.f5213a[inAppMessage.layoutOrder().ordinal()];
        return i2 != 1 ? i2 != 2 ? i : (media == null || media.size() != InAppMessage.Media.ImageSize.e2e) ? C4089R.layout.mcsdk_iam_modal_inset_tib : C4089R.layout.mcsdk_iam_modal_e2e_tib : (media == null || media.size() != InAppMessage.Media.ImageSize.e2e) ? C4089R.layout.mcsdk_iam_modal_inset_itb : C4089R.layout.mcsdk_iam_modal_e2e_itb;
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

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isFinishing()) {
            return;
        }
        setContentView(m3689a(m3746c().m3771d()));
        new C4261l(this, m3746c().m3777k()).m3735a(findViewById(R.id.content), m3746c());
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
