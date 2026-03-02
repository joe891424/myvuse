package com.qualtrics.digital;

import android.R;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.Task;
import com.google.gson.Gson;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.qualtrics.C3902R;
import com.qualtrics.digital.QualtricsPopOverFragment;
import com.qualtrics.digital.theming.prompt.MobileAppPromptTheme;

/* JADX INFO: loaded from: classes6.dex */
public class QualtricsPopOverActivity extends AppCompatActivity implements QualtricsPopOverFragment.OnCreativeButtonPressedListener, TraceFieldInterface {
    public Trace _nr_trace;
    private boolean autoCloseAtEndOfSurvey;
    private String mActionSetID;
    private String mAppPackageName;
    private String mCreativeID;
    private FrameLayout mFragmentContainer;
    private String mInterceptID;
    private Fragment mPlaystoreFragment;
    private String mPlaystoreURL;
    private PopOverCreative mPopOverCreative;
    private Fragment mSurveyFragment;
    private String mURL;
    protected ReviewFactoryHelper reviewFactoryHelper;

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

    public final class IntentKeys {
        static final String ACTIONSETID = "actionSetID";
        static final String AUTO_CLOSE_AT_END_OF_SURVEY = "autoCloseAtEndOfSurvey";
        static final String CREATIVE = "creative";
        static final String CREATIVEID = "creativeID";
        static final String INTERCEPTID = "interceptID";
        static final String LAYOUT_FLAGS = "layoutFlags";
        static final String URL = "url";

        public IntentKeys() {
        }
    }

    public final class CreativeButtonActionKeys {
        static final String APP_REVIEWS = "appreviews";
        static final String DISMISS = "negative";
        static final String DISMISS_NAME = "dismiss";
        static final String TARGET = "positive";
        static final String TARGET_NAME = "target";

        public CreativeButtonActionKeys() {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Object objFromJson;
        String json;
        String json2;
        TraceMachine.startTracing("QualtricsPopOverActivity");
        MobileAppPromptTheme mobileAppPromptTheme = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "QualtricsPopOverActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "QualtricsPopOverActivity#onCreate", null);
        }
        try {
            super.onCreate(bundle);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(-1));
            getSupportActionBar().hide();
            getWindow().setSoftInputMode(16);
            getWindow().addFlags(getIntent().getIntExtra("layoutFlags", 0));
            setTitle(C3902R.string.qualtrics_dialog_text);
            this.mAppPackageName = getPackageName();
            String stringExtra = getIntent().getStringExtra("creative");
            Gson gson = new Gson();
            if (gson instanceof Gson) {
                objFromJson = GsonInstrumentation.fromJson(gson, stringExtra, (Class<Object>) PopOverCreative.class);
            } else {
                objFromJson = gson.fromJson(stringExtra, (Class<Object>) PopOverCreative.class);
            }
            this.mPopOverCreative = (PopOverCreative) objFromJson;
            this.mURL = getIntent().getStringExtra("url");
            this.mInterceptID = getIntent().getStringExtra("interceptID");
            this.mCreativeID = getIntent().getStringExtra("creativeID");
            this.mActionSetID = getIntent().getStringExtra("actionSetID");
            this.autoCloseAtEndOfSurvey = getIntent().getBooleanExtra("autoCloseAtEndOfSurvey", false);
            this.mPlaystoreURL = "https://play.google.com/store/apps/details?id=" + this.mAppPackageName;
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            FrameLayout frameLayout = new FrameLayout(this);
            this.mFragmentContainer = frameLayout;
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mFragmentContainer.setId(View.generateViewId());
            linearLayout.addView(this.mFragmentContainer);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            this.mPlaystoreFragment = QualtricsSurveyFragment.newInstance(this.mPlaystoreURL, this.mInterceptID, this.mCreativeID, this.mActionSetID, this.mAppPackageName, this.autoCloseAtEndOfSurvey);
            this.mSurveyFragment = QualtricsSurveyFragment.newInstance(this.mURL, this.mInterceptID, this.mCreativeID, this.mActionSetID, this.mAppPackageName, this.autoCloseAtEndOfSurvey);
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().add(this.mFragmentContainer.getId(), this.mSurveyFragment).hide(this.mSurveyFragment).commit();
            setColorsForLinkButtons();
            ThemeApplier themeApplier = new ThemeApplier(new ThemingUtilsImpl(getApplicationContext()));
            if (themeApplier.shouldPopOverUseTheming(this.mPopOverCreative.CreativeDefinition.Options)) {
                this.mPopOverCreative.CreativeDefinition.Options = themeApplier.computePopOverOptionsTheming(this.mPopOverCreative.CreativeDefinition.Options, Qualtrics.instance().creativeTheme);
                mobileAppPromptTheme = Qualtrics.instance().creativeTheme.getMobileAppPromptTheme();
            }
            Gson gson2 = new Gson();
            PopOverCreative popOverCreative = this.mPopOverCreative;
            if (gson2 instanceof Gson) {
                json = GsonInstrumentation.toJson(gson2, popOverCreative);
            } else {
                json = gson2.toJson(popOverCreative);
            }
            Gson gson3 = new Gson();
            if (gson3 instanceof Gson) {
                json2 = GsonInstrumentation.toJson(gson3, mobileAppPromptTheme);
            } else {
                json2 = gson3.toJson(mobileAppPromptTheme);
            }
            fragmentManager.beginTransaction().add(this.mFragmentContainer.getId(), QualtricsPopOverFragment.newInstance(json, i, json2)).commit();
            setContentView(linearLayout);
            overridePendingTransition(R.anim.fade_in, 0);
            this.reviewFactoryHelper = new ReviewFactoryHelper();
        } catch (Throwable th) {
            CrashReporter.logCrash(th);
            finish();
        }
        TraceMachine.exitMethod();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        finish();
        overridePendingTransition(0, R.anim.fade_out);
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, R.anim.fade_out);
    }

    @Override // com.qualtrics.digital.QualtricsPopOverFragment.OnCreativeButtonPressedListener
    public void onCreativeButtonPressed(String str) {
        if ((str.toLowerCase().equals("positive") || str.toLowerCase().equals("target")) && this.mURL != null) {
            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fade_in, 0).replace(this.mFragmentContainer.getId(), this.mSurveyFragment).show(this.mSurveyFragment).commit();
            setCustomPropertyForButtonPressed("target");
            return;
        }
        if (str.toLowerCase().equals("appreviews")) {
            SiteInterceptService.instance().recordClick(this.mInterceptID, this.mCreativeID, this.mActionSetID);
            int nativeAppReviewCount = Qualtrics.instance().properties.getNativeAppReviewCount();
            if (Qualtrics.instance().properties.shouldDisplayNativeAppReviews() && nativeAppReviewCount < 3) {
                Qualtrics.instance().properties.setNativeAppReviewCount(nativeAppReviewCount + 1);
                final ReviewManager reviewManager = this.reviewFactoryHelper.getReviewManager(getApplicationContext());
                reviewManager.requestReviewFlow().addOnCompleteListener(new OnCompleteListener() { // from class: com.qualtrics.digital.QualtricsPopOverActivity$$ExternalSyntheticLambda0
                    public final void onComplete(Task task) {
                        this.f$0.m2791xb9fda33d(reviewManager, task);
                    }
                });
                return;
            } else {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.mAppPackageName));
                intent.addFlags(1208483840);
                try {
                    startActivity(intent);
                    finish();
                } catch (Exception unused) {
                    getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fade_in, 0).replace(this.mFragmentContainer.getId(), this.mPlaystoreFragment).commit();
                }
                setCustomPropertyForButtonPressed("appreviews");
                return;
            }
        }
        finish();
        setCustomPropertyForButtonPressed("dismiss");
    }

    /* JADX INFO: renamed from: lambda$onCreativeButtonPressed$0$com-qualtrics-digital-QualtricsPopOverActivity */
    /* synthetic */ void m2791xb9fda33d(ReviewManager reviewManager, Task task) {
        if (task.isSuccessful()) {
            reviewManager.launchReviewFlow((Activity) this, (ReviewInfo) task.getResult()).addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.qualtrics.digital.QualtricsPopOverActivity.1
                public void onComplete(Task<Void> task2) {
                    QualtricsPopOverActivity.this.finish();
                }
            });
        }
    }

    private void setCustomPropertyForButtonPressed(String str) {
        Qualtrics.instance().properties.setCreativeActionButtonPressed(this.mInterceptID, this.mPopOverCreative.CreativeDefinition.CreativeID, str);
    }

    private void setColorsForLinkButtons() {
        Buttons buttons = this.mPopOverCreative.CreativeDefinition.Options.Buttons;
        if (buttons.ButtonStyle.equals("link")) {
            String str = buttons.LinkColor;
            buttons.ButtonOne.Color = str;
            buttons.ButtonTwo.Color = str;
        }
    }
}
