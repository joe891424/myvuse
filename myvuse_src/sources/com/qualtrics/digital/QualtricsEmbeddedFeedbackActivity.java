package com.qualtrics.digital;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.reactnativenavigation.views.bottomtabs.BottomTabsContainerKt;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class QualtricsEmbeddedFeedbackActivity extends AppCompatActivity implements TraceFieldInterface {
    public Trace _nr_trace;
    private EmbeddedFeedbackCreative mEmbeddedFeedbackCreative;
    EmbeddedFeedbackOrchestrator orchestrator;
    SiteInterceptService siteInterceptService = SiteInterceptService.instance();

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
        static final String ACTION_SET_ID = "ACTION_SET_ID";
        static final String BASE_URL = "BASE_URL";
        static final String CREATIVE = "CREATIVE";
        static final String CREATIVE_ID = "CREATIVE_ID";
        static final String EMBEDDED_DATA = "EMBEDDED_DATA";
        static final String INTERCEPT_ID = "INTERCEPT_ID";
        static final String SURVEY_ID = "SURVEY_ID";

        public IntentKeys() {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Object objFromJson;
        TraceMachine.startTracing("QualtricsEmbeddedFeedbackActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "QualtricsEmbeddedFeedbackActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "QualtricsEmbeddedFeedbackActivity#onCreate", null);
        }
        super.onCreate(bundle);
        try {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(-1));
            getSupportActionBar().hide();
            getWindow().setSoftInputMode(16);
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra("SURVEY_ID");
            String stringExtra2 = intent.getStringExtra("ACTION_SET_ID");
            String stringExtra3 = intent.getStringExtra("INTERCEPT_ID");
            String stringExtra4 = intent.getStringExtra("CREATIVE_ID");
            String stringExtra5 = intent.getStringExtra("BASE_URL");
            Map map = (Map) intent.getSerializableExtra("EMBEDDED_DATA");
            String stringExtra6 = intent.getStringExtra("CREATIVE");
            Gson gson = new Gson();
            if (gson instanceof Gson) {
                objFromJson = GsonInstrumentation.fromJson(gson, stringExtra6, (Class<Object>) EmbeddedFeedbackCreative.class);
            } else {
                objFromJson = gson.fromJson(stringExtra6, (Class<Object>) EmbeddedFeedbackCreative.class);
            }
            this.mEmbeddedFeedbackCreative = (EmbeddedFeedbackCreative) objFromJson;
            ThemingUtilsImpl themingUtilsImpl = new ThemingUtilsImpl(getApplicationContext());
            ThemeApplier themeApplier = new ThemeApplier(themingUtilsImpl);
            spreadEmojisAndThumbsColors();
            spreadDefaultTheming(themingUtilsImpl);
            if (themeApplier.shouldEmbeddedFeedbackUseTheming(this.mEmbeddedFeedbackCreative.CreativeDefinition.Options)) {
                this.mEmbeddedFeedbackCreative.CreativeDefinition.Options = themeApplier.computeEmbeddedFeedbackCreativeOptionsTheming(this.mEmbeddedFeedbackCreative.CreativeDefinition.Options, Qualtrics.instance().creativeTheme);
            }
            EmbeddedFeedbackOrchestrator embeddedFeedbackOrchestrator = new EmbeddedFeedbackOrchestrator(this, this.mEmbeddedFeedbackCreative.CreativeDefinition.Options, Qualtrics.instance().properties, SiteInterceptService.instance(), stringExtra3, stringExtra2, stringExtra4, new EmbeddedFeedbackResponseManager(stringExtra3, stringExtra5, stringExtra, map, this.mEmbeddedFeedbackCreative.CreativeDefinition.Options.SurveyVersionId, SDKUtils.instance(), SiteInterceptService.instance(), Properties.instance(getApplicationContext())), Qualtrics.instance().creativeTheme.getEmbeddedAppFeedbackTheme());
            this.orchestrator = embeddedFeedbackOrchestrator;
            embeddedFeedbackOrchestrator.display();
        } catch (Exception e) {
            this.siteInterceptService.postErrorLog("Unable to start MEF Activity", true, e);
            finish();
        }
        TraceMachine.exitMethod();
    }

    private void spreadEmojisAndThumbsColors() {
        EmbeddedFeedbackCreativeOptions embeddedFeedbackCreativeOptions = this.mEmbeddedFeedbackCreative.CreativeDefinition.Options;
        embeddedFeedbackCreativeOptions.Questions.get(0).Appearance.ThumbUpBorderColor = embeddedFeedbackCreativeOptions.Questions.get(0).Appearance.BorderColor;
        embeddedFeedbackCreativeOptions.Questions.get(0).Appearance.ThumbDownBorderColor = embeddedFeedbackCreativeOptions.Questions.get(0).Appearance.BorderColor;
        embeddedFeedbackCreativeOptions.Questions.get(0).Appearance.ThumbUpFillColor = embeddedFeedbackCreativeOptions.Questions.get(0).Appearance.FillColor;
        embeddedFeedbackCreativeOptions.Questions.get(0).Appearance.ThumbDownFillColor = embeddedFeedbackCreativeOptions.Questions.get(0).Appearance.FillColor;
        embeddedFeedbackCreativeOptions.Questions.get(0).Appearance.EmojiBorderColor = embeddedFeedbackCreativeOptions.Questions.get(0).Appearance.BorderColor;
        embeddedFeedbackCreativeOptions.Questions.get(0).Appearance.EmojiFillColor = embeddedFeedbackCreativeOptions.Questions.get(0).Appearance.FillColor;
        embeddedFeedbackCreativeOptions.Questions.get(0).Appearance.EmojiTintColor = embeddedFeedbackCreativeOptions.Questions.get(0).Appearance.BorderColor;
    }

    private void spreadDefaultTheming(ThemingUtils themingUtils) {
        EmbeddedFeedbackCreativeOptions embeddedFeedbackCreativeOptions = this.mEmbeddedFeedbackCreative.CreativeDefinition.Options;
        embeddedFeedbackCreativeOptions.Questions.get(0).Appearance.RadioButtonUnselectedCircleColor = themingUtils.getHexColor(BottomTabsContainerKt.DEFAULT_TOP_OUTLINE_COLOR);
        for (EmbeddedFeedbackCreativeQuestion embeddedFeedbackCreativeQuestion : embeddedFeedbackCreativeOptions.Questions) {
            embeddedFeedbackCreativeQuestion.Appearance.NoButtonBorderColor = embeddedFeedbackCreativeQuestion.Appearance.ButtonBorderColor;
            embeddedFeedbackCreativeQuestion.Appearance.NoButtonFillColor = embeddedFeedbackCreativeQuestion.Appearance.ButtonFillColor;
            embeddedFeedbackCreativeQuestion.Appearance.NoButtonTextColor = embeddedFeedbackCreativeQuestion.Appearance.ButtonTextColor;
        }
    }
}
