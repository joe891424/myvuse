package com.salesforce.marketingcloud.messages.iam;

import android.R;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.salesforce.marketingcloud.C4089R;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;

/* JADX INFO: loaded from: classes6.dex */
public class IamBannerActivity extends AbstractViewOnClickListenerC4255f {

    /* JADX INFO: renamed from: i */
    private static final String f5203i = C4170g.m3197a("IamBaseActivity");

    /* JADX INFO: renamed from: f */
    private AbstractCountDownTimerC4250a f5204f;

    /* JADX INFO: renamed from: g */
    private boolean f5205g;

    /* JADX INFO: renamed from: h */
    private long f5206h;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.IamBannerActivity$a */
    class CountDownTimerC4239a extends AbstractCountDownTimerC4250a {
        CountDownTimerC4239a(long j, long j2) {
            super(j, j2);
        }

        @Override // com.salesforce.marketingcloud.messages.iam.AbstractCountDownTimerC4250a, android.os.CountDownTimer
        public void onFinish() {
            IamBannerActivity.this.m3686h();
        }
    }

    /* JADX INFO: renamed from: a */
    private int m3682a(InAppMessage inAppMessage) {
        return inAppMessage.type() == InAppMessage.Type.bannerTop ? C4089R.anim.mcsdk_iam_slide_in_from_top : C4089R.anim.mcsdk_iam_slide_in_from_bottom;
    }

    /* JADX INFO: renamed from: b */
    private int m3684b(InAppMessage inAppMessage) {
        return inAppMessage.type() == InAppMessage.Type.bannerTop ? C4089R.anim.mcsdk_iam_slide_out_from_top : C4089R.anim.mcsdk_iam_slide_out_from_bottom;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, android.app.Activity
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    /* JADX INFO: renamed from: h */
    void m3686h() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment fragmentFindFragmentById = supportFragmentManager.findFragmentById(R.id.content);
        if (fragmentFindFragmentById != null) {
            supportFragmentManager.beginTransaction().setCustomAnimations(0, m3684b(m3746c().m3771d())).remove(fragmentFindFragmentById).commitAllowingStateLoss();
        }
        m3744a(C4259j.m3755a(m3746c().m3770c(), m3743a()));
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
        C4260k c4260kM3746c = m3746c();
        InAppMessage inAppMessageM3771d = c4260kM3746c.m3771d();
        findViewById(R.id.content).setBackgroundDrawable(new ColorDrawable(C4256g.m3747a(this, inAppMessageM3771d.windowColor(), C4089R.color.mcsdk_iam_default_window_background)));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentById(R.id.content) == null) {
            this.f5205g = true;
            supportFragmentManager.beginTransaction().setCustomAnimations(m3682a(inAppMessageM3771d), 0).add(R.id.content, C4252c.m3723a(c4260kM3746c)).commit();
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, com.salesforce.marketingcloud.messages.iam.SwipeDismissConstraintLayout.SwipeDismissListener
    public /* bridge */ /* synthetic */ void onDismissed() {
        super.onDismissed();
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        AbstractCountDownTimerC4250a abstractCountDownTimerC4250a = this.f5204f;
        if (abstractCountDownTimerC4250a != null) {
            abstractCountDownTimerC4250a.cancel();
            this.f5204f = null;
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        long jDisplayDuration = m3745b().displayDuration();
        long integer = this.f5205g ? (long) (((double) getResources().getInteger(C4089R.integer.mcsdk_iam_banner_animation_duration)) * (-1.0d)) : 0L;
        this.f5205g = false;
        m3683a(jDisplayDuration, integer);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, com.salesforce.marketingcloud.messages.iam.SwipeDismissConstraintLayout.SwipeDismissListener
    public void onSwipeStarted() {
        super.onSwipeStarted();
        AbstractCountDownTimerC4250a abstractCountDownTimerC4250a = this.f5204f;
        if (abstractCountDownTimerC4250a != null) {
            abstractCountDownTimerC4250a.cancel();
            this.f5206h = this.f5204f.m3704a();
            this.f5204f = null;
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f, com.salesforce.marketingcloud.messages.iam.SwipeDismissConstraintLayout.SwipeDismissListener
    public void onViewSettled() {
        super.onViewSettled();
        m3683a(m3745b().displayDuration(), this.f5206h);
    }

    /* JADX INFO: renamed from: a */
    private void m3683a(long j, long j2) {
        if (j > 0) {
            C4170g.m3213d(f5203i, "Banner dismiss timer set.  Will auto dismiss in %dms", Long.valueOf(j - j2));
            CountDownTimerC4239a countDownTimerC4239a = new CountDownTimerC4239a(j, j2);
            this.f5204f = countDownTimerC4239a;
            countDownTimerC4239a.start();
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractViewOnClickListenerC4255f
    /* JADX INFO: renamed from: b */
    public /* bridge */ /* synthetic */ void mo3685b(InAppMessage.Button button) {
        super.mo3685b(button);
    }
}
