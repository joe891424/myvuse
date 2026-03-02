package com.qualtrics.digital;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.webkit.Profile;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.qualtrics.C3902R;
import com.qualtrics.digital.theming.embedded.EmbeddedAppFeedbackTheme;
import com.qualtrics.digital.theming.fonts.FontTheme;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
class EmbeddedFeedbackOrchestrator {
    String actionSetID;
    final ClientCallbackUtils clientCallbackUtils;
    Context context;
    String creativeID;
    String currentLangCode;
    EmbeddedAppFeedbackTheme embeddedAppFeedbackTheme;
    String[] fivePointQuestionDescriptions;
    EmbeddedFeedbackCreativeQuestion followupQuestion;
    BottomSheetDialog followupQuestionDialog;
    EmbeddedFeedbackCreativeQuestion initialQuestion;
    BottomSheetDialog initialQuestionDialog;
    String interceptID;
    int[] multipleChoiceIds;
    EmbeddedFeedbackCreativeQuestion multipleChoiceQuestion;
    List<RadioButton> multipleChoiceRadioButtons;
    int noButtonWidth;
    EmbeddedFeedbackCreativeOptions options;
    EmbeddedFeedbackResponseManager responseManager;
    SiteInterceptService siteInterceptService;
    BottomSheetDialog thankYouMessageDialog;
    ThemeApplier themeApplier;
    ThemingUtils themingUtils;
    String[] thumbsDescriptions;
    int yesButtonWidth;
    int[] fivePointQuestionIconIds = {C3902R.id.extremely_unhelpful, C3902R.id.somewhat_unhelpful, C3902R.id.neither_helpful_nor_unhelpful, C3902R.id.somewhat_helpful, C3902R.id.extremely_helpful};
    int[] thumbsButtonIDs = {C3902R.id.thumbs_up, C3902R.id.thumbs_down};
    int[] textButtonIDs = {C3902R.id.yes_button, C3902R.id.no_button};
    int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;

    EmbeddedFeedbackOrchestrator(Context context, EmbeddedFeedbackCreativeOptions embeddedFeedbackCreativeOptions, Properties properties, SiteInterceptService siteInterceptService, String str, String str2, String str3, EmbeddedFeedbackResponseManager embeddedFeedbackResponseManager, EmbeddedAppFeedbackTheme embeddedAppFeedbackTheme) {
        this.options = embeddedFeedbackCreativeOptions;
        this.context = context;
        this.themingUtils = new ThemingUtilsImpl(context);
        this.themeApplier = new ThemeApplier(this.themingUtils);
        String string = properties.getString("Q_Language");
        this.currentLangCode = string;
        if (string == null) {
            this.currentLangCode = Locale.getDefault().toLanguageTag() != null ? Locale.getDefault().toLanguageTag() : Profile.DEFAULT_PROFILE_NAME;
        }
        this.currentLangCode = this.currentLangCode.toUpperCase();
        this.fivePointQuestionDescriptions = new String[]{context.getResources().getString(C3902R.string.extremely_unhelpful), context.getResources().getString(C3902R.string.somewhat_unhelpful), context.getResources().getString(C3902R.string.neither_helpful_nor_unhelpful), context.getResources().getString(C3902R.string.somewhat_helpful), context.getResources().getString(C3902R.string.extremely_helpful)};
        this.thumbsDescriptions = new String[]{context.getResources().getString(C3902R.string.thumbs_up), context.getResources().getString(C3902R.string.thumbs_down)};
        this.responseManager = embeddedFeedbackResponseManager;
        TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(C3902R.array.multiple_choice_ids);
        this.multipleChoiceIds = new int[typedArrayObtainTypedArray.length()];
        for (int i = 0; i < typedArrayObtainTypedArray.length(); i++) {
            this.multipleChoiceIds[i] = typedArrayObtainTypedArray.getResourceId(i, 0);
        }
        typedArrayObtainTypedArray.recycle();
        this.siteInterceptService = siteInterceptService;
        this.actionSetID = str2;
        this.creativeID = str3;
        this.interceptID = str;
        this.clientCallbackUtils = ClientCallbackUtils.instance();
        this.embeddedAppFeedbackTheme = embeddedAppFeedbackTheme;
    }

    void display() {
        displayInitialQuestion();
        displayIcons();
    }

    private void displayIcons() {
        String str = this.options.Questions.get(0).Style;
        str.hashCode();
        switch (str) {
            case "embedded-feedback-question-style-yes-no":
                addYesNoButtonsToDialogView();
                break;
            case "embedded-feedback-question-style-emoji":
                addEmojisToDialogView();
                break;
            case "embedded-feedback-question-style-stars":
                addStarsToDialogView();
                break;
            case "embedded-feedback-question-style-thumbs":
                addThumbsToDialogView();
                break;
            default:
                QualtricsLog.logError("Qualtrics: Invalid question style");
                break;
        }
    }

    private ImageButton getDefaultEmojiButton(View view, String str, String str2) {
        ImageButton imageButton;
        imageButton = new ImageButton(view.getContext());
        str2.hashCode();
        switch (str2) {
            case "ExtremelyHelpful":
                imageButton.setImageResource(C3902R.drawable.extremely_helpful_default_emoji);
                break;
            case "SomewhatHelpful":
                imageButton.setImageResource(C3902R.drawable.somewhat_helpful_default_emoji);
                break;
            case "NeitherHelpfulNorUnhelpful":
                imageButton.setImageResource(C3902R.drawable.neither_helpful_nor_unhelpful_default_emoji);
                break;
            case "ExtremelyUnhelpful":
                imageButton.setImageResource(C3902R.drawable.extremely_unhelpful_default_emoji);
                break;
            case "SomewhatUnhelpful":
                imageButton.setImageResource(C3902R.drawable.somewhat_unhelpful_default_emoji);
                break;
            default:
                QualtricsLog.logError("Invalid buttonType received for default emoji");
                break;
        }
        imageButton.setContentDescription(str);
        imageButton.setPadding(0, 0, (this.screenWidth * 5) / 100, 0);
        imageButton.setBackgroundColor(0);
        return imageButton;
    }

    private ImageButton getCustomEmojiButton(View view, String str, String str2) {
        Drawable[] drawableArr;
        ImageButton imageButton = new ImageButton(view.getContext());
        drawableArr = new Drawable[2];
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setSize(convertDpToPixel(40.0f), convertDpToPixel(40.0f));
        gradientDrawable.setStroke(convertDpToPixel(2.0f), Color.parseColor(this.options.Questions.get(0).Appearance.EmojiBorderColor));
        gradientDrawable.setColor(Color.parseColor(this.options.Questions.get(0).Appearance.EmojiFillColor));
        drawableArr[0] = gradientDrawable;
        str2.hashCode();
        switch (str2) {
            case "ExtremelyHelpful":
                drawableArr[1] = this.context.getResources().getDrawable(C3902R.drawable.extremely_helpful_custom_emoji);
                break;
            case "SomewhatHelpful":
                drawableArr[1] = this.context.getResources().getDrawable(C3902R.drawable.somewhat_helpful_custom_emoji);
                break;
            case "NeitherHelpfulNorUnhelpful":
                drawableArr[1] = this.context.getResources().getDrawable(C3902R.drawable.neither_helpful_nor_unhelpful_custom_emoji);
                break;
            case "ExtremelyUnhelpful":
                drawableArr[1] = this.context.getResources().getDrawable(C3902R.drawable.extremely_unhelpful_custom_emoji);
                break;
            case "SomewhatUnhelpful":
                drawableArr[1] = this.context.getResources().getDrawable(C3902R.drawable.somewhat_unhelpful_custom_emoji);
                break;
            default:
                QualtricsLog.logError("Invalid buttonType received for custom emoji");
                break;
        }
        drawableArr[1].setColorFilter(Color.parseColor(this.options.Questions.get(0).Appearance.EmojiTintColor), PorterDuff.Mode.SRC_ATOP);
        imageButton.setContentDescription(str);
        imageButton.setImageDrawable(new LayerDrawable(drawableArr));
        imageButton.setPadding(0, 0, (this.screenWidth * 5) / 100, 0);
        imageButton.setBackgroundColor(0);
        return imageButton;
    }

    private void addEmojisToDialogView() {
        ImageButton customEmojiButton;
        LinearLayout linearLayout = (LinearLayout) this.initialQuestionDialog.findViewById(C3902R.id.icon_view);
        for (final int i = 0; i < this.fivePointQuestionDescriptions.length; i++) {
            if (this.options.Questions.get(0).Appearance.Style.equals(EmbeddedFeedbackUtils.QUESTION_STYLE_DEFAULT)) {
                customEmojiButton = getDefaultEmojiButton(linearLayout, EmbeddedFeedbackUtils.getFivePointChoiceTranslation(i, this.fivePointQuestionDescriptions[i], this.currentLangCode), EmbeddedFeedbackUtils.FIVE_POINT_QUESTION_OPTIONS[i]);
            } else {
                customEmojiButton = getCustomEmojiButton(linearLayout, EmbeddedFeedbackUtils.getFivePointChoiceTranslation(i, this.fivePointQuestionDescriptions[i], this.currentLangCode), EmbeddedFeedbackUtils.FIVE_POINT_QUESTION_OPTIONS[i]);
            }
            customEmojiButton.setOnClickListener(new View.OnClickListener() { // from class: com.qualtrics.digital.EmbeddedFeedbackOrchestrator.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EmbeddedFeedbackOrchestrator.this.onInitialQuestionAnswered(i);
                }
            });
            customEmojiButton.setId(this.fivePointQuestionIconIds[i]);
            linearLayout.addView(customEmojiButton);
        }
        linearLayout.setGravity(17);
    }

    private ImageButton getStarButton(View view, String str) {
        int color;
        int color2 = Color.parseColor(this.options.Questions.get(0).Appearance.StarsColor);
        Drawable[] drawableArr = new Drawable[2];
        drawableArr[0] = this.context.getResources().getDrawable(C3902R.drawable.star_fill);
        if (this.themeApplier.shouldEmbeddedFeedbackUseTheming(this.options)) {
            color = this.embeddedAppFeedbackTheme.getDialogBackgroundColor(this.themingUtils);
        } else {
            color = ContextCompat.getColor(this.context, C3902R.color.qualtricsDefaultBackground);
        }
        drawableArr[0].setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        Drawable drawable = this.context.getResources().getDrawable(C3902R.drawable.star_border);
        drawableArr[1] = drawable;
        drawable.setColorFilter(color2, PorterDuff.Mode.SRC_ATOP);
        ImageButton imageButton = new ImageButton(view.getContext());
        imageButton.setContentDescription(str);
        imageButton.setImageDrawable(new LayerDrawable(drawableArr));
        imageButton.setPadding(0, 0, (this.screenWidth * 5) / 100, 0);
        imageButton.setBackgroundColor(0);
        return imageButton;
    }

    private void addStarsToDialogView() {
        LinearLayout linearLayout = (LinearLayout) this.initialQuestionDialog.findViewById(C3902R.id.icon_view);
        final int i = 0;
        while (true) {
            String[] strArr = this.fivePointQuestionDescriptions;
            if (i < strArr.length) {
                ImageButton starButton = getStarButton(linearLayout, EmbeddedFeedbackUtils.getFivePointChoiceTranslation(i, strArr[i], this.currentLangCode));
                starButton.setId(this.fivePointQuestionIconIds[i]);
                starButton.setOnClickListener(new View.OnClickListener() { // from class: com.qualtrics.digital.EmbeddedFeedbackOrchestrator.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EmbeddedFeedbackOrchestrator.this.onInitialQuestionAnswered(i);
                    }
                });
                linearLayout.addView(starButton);
                i++;
            } else {
                linearLayout.setGravity(17);
                return;
            }
        }
    }

    private Drawable createTextButtonDrawable(String str, boolean z) {
        String str2;
        String str3;
        if (z) {
            str2 = this.options.Questions.get(0).Appearance.ButtonBorderColor;
        } else {
            str2 = this.options.Questions.get(0).Appearance.NoButtonBorderColor;
        }
        int color = Color.parseColor(str2);
        if (z) {
            str3 = this.options.Questions.get(0).Appearance.ButtonFillColor;
        } else {
            str3 = this.options.Questions.get(0).Appearance.NoButtonFillColor;
        }
        int color2 = Color.parseColor(str3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(color2);
        gradientDrawable.setCornerRadius(convertDpToPixel(4.0f));
        gradientDrawable.setStroke(convertDpToPixel(2.0f), color);
        return gradientDrawable;
    }

    private void configureCloseButton(View view, final BottomSheetDialog bottomSheetDialog, final boolean z) {
        int color;
        ImageButton imageButton = (ImageButton) view.findViewById(C3902R.id.close_button);
        if (this.themeApplier.shouldEmbeddedFeedbackUseTheming(this.options)) {
            color = this.embeddedAppFeedbackTheme.getCloseButtonColor(this.themingUtils);
        } else {
            color = ContextCompat.getColor(this.context, C3902R.color.qualtricsDefaultCloseButton);
        }
        int closeButtonBackgroundColor = this.themeApplier.shouldEmbeddedFeedbackUseTheming(this.options) ? this.embeddedAppFeedbackTheme.getCloseButtonBackgroundColor(this.themingUtils) : 0;
        imageButton.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        imageButton.setBackgroundColor(closeButtonBackgroundColor);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.qualtrics.digital.EmbeddedFeedbackOrchestrator.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EmbeddedFeedbackOrchestrator.this.closeDialog(bottomSheetDialog, z);
                EmbeddedFeedbackOrchestrator.this.notifyListenerOfDialogClose();
            }
        });
        imageButton.setContentDescription(EmbeddedFeedbackUtils.getCloseTranslation("Close", this.currentLangCode));
    }

    private Button createYesNoButton(View view, String str, boolean z) {
        String str2;
        if (z) {
            str2 = this.options.Questions.get(0).Appearance.ButtonTextColor;
        } else {
            str2 = this.options.Questions.get(0).Appearance.NoButtonTextColor;
        }
        int color = Color.parseColor(str2);
        Button button = new Button(view.getContext());
        button.setText(str);
        button.setContentDescription(str);
        button.setTextColor(color);
        FontTheme buttonFontTheme = EmbeddedFeedbackUtils.getButtonFontTheme(this.embeddedAppFeedbackTheme, z);
        if (buttonFontTheme != null) {
            if (buttonFontTheme.hasCustomTypeface()) {
                setTypefaceIfSupported(button, buttonFontTheme.getFontRes());
            }
            button.setTextSize(2, buttonFontTheme.getSize());
        } else {
            button.setTextSize(16.0f);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = convertDpToPixel(10.0f);
        layoutParams.leftMargin = convertDpToPixel(10.0f);
        button.setLayoutParams(layoutParams);
        button.setGravity(17);
        button.setPadding(convertDpToPixel(12.0f), 0, convertDpToPixel(12.0f), 0);
        button.setBackground(createTextButtonDrawable(str, z));
        return button;
    }

    private void addYesNoButtonsToDialogView() {
        LinearLayout linearLayout = (LinearLayout) this.initialQuestionDialog.findViewById(C3902R.id.icon_view);
        linearLayout.setGravity(17);
        final Button buttonCreateYesNoButton = createYesNoButton(linearLayout, EmbeddedFeedbackUtils.getTranslation(this.options.Questions.get(0).Choices.get(0).Display, this.options.Translations, this.currentLangCode, EmbeddedFeedbackUtils.YES_BUTTON_KEY), true);
        buttonCreateYesNoButton.setId(this.textButtonIDs[0]);
        buttonCreateYesNoButton.setOnClickListener(new View.OnClickListener() { // from class: com.qualtrics.digital.EmbeddedFeedbackOrchestrator.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmbeddedFeedbackOrchestrator.this.onInitialQuestionAnswered(0);
            }
        });
        final Button buttonCreateYesNoButton2 = createYesNoButton(linearLayout, EmbeddedFeedbackUtils.getTranslation(this.options.Questions.get(0).Choices.get(1).Display, this.options.Translations, this.currentLangCode, EmbeddedFeedbackUtils.NO_BUTTON_KEY), false);
        buttonCreateYesNoButton2.setId(this.textButtonIDs[1]);
        buttonCreateYesNoButton2.setOnClickListener(new View.OnClickListener() { // from class: com.qualtrics.digital.EmbeddedFeedbackOrchestrator.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmbeddedFeedbackOrchestrator.this.onInitialQuestionAnswered(1);
            }
        });
        buttonCreateYesNoButton.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.qualtrics.digital.EmbeddedFeedbackOrchestrator.6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                EmbeddedFeedbackOrchestrator.this.yesButtonWidth = buttonCreateYesNoButton.getWidth();
                buttonCreateYesNoButton.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        buttonCreateYesNoButton2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.qualtrics.digital.EmbeddedFeedbackOrchestrator.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                EmbeddedFeedbackOrchestrator.this.noButtonWidth = buttonCreateYesNoButton2.getWidth();
                if (EmbeddedFeedbackOrchestrator.this.yesButtonWidth > EmbeddedFeedbackOrchestrator.this.noButtonWidth) {
                    buttonCreateYesNoButton2.setWidth(EmbeddedFeedbackOrchestrator.this.yesButtonWidth);
                } else {
                    buttonCreateYesNoButton.setWidth(EmbeddedFeedbackOrchestrator.this.noButtonWidth);
                }
                buttonCreateYesNoButton2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        linearLayout.addView(buttonCreateYesNoButton);
        linearLayout.addView(buttonCreateYesNoButton2);
    }

    private ImageButton createThumbButton(View view, String str, String str2) {
        int color = Color.parseColor(this.options.Questions.get(0).Appearance.ThumbUpBorderColor);
        int color2 = Color.parseColor(this.options.Questions.get(0).Appearance.ThumbUpFillColor);
        int color3 = Color.parseColor(this.options.Questions.get(0).Appearance.ThumbDownBorderColor);
        int color4 = Color.parseColor(this.options.Questions.get(0).Appearance.ThumbDownFillColor);
        Drawable[] drawableArr = new Drawable[2];
        ImageButton imageButton = new ImageButton(view.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(convertDpToPixel(52.0f), convertDpToPixel(44.0f));
        str2.hashCode();
        if (str2.equals(EmbeddedFeedbackUtils.THUMBS_DOWN)) {
            drawableArr[0] = this.context.getResources().getDrawable(C3902R.drawable.thumbs_down_background);
            drawableArr[1] = this.context.getResources().getDrawable(C3902R.drawable.thumbs_down_border);
            drawableArr[0].setColorFilter(color4, PorterDuff.Mode.SRC_ATOP);
            drawableArr[1].setColorFilter(color3, PorterDuff.Mode.SRC_ATOP);
        } else if (str2.equals(EmbeddedFeedbackUtils.THUMBS_UP)) {
            drawableArr[0] = this.context.getResources().getDrawable(C3902R.drawable.thumbs_up_background);
            drawableArr[1] = this.context.getResources().getDrawable(C3902R.drawable.thumbs_up_border);
            drawableArr[0].setColorFilter(color2, PorterDuff.Mode.SRC_ATOP);
            drawableArr[1].setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            layoutParams.setMargins(0, 0, convertDpToPixel(32.0f), 0);
        }
        imageButton.setContentDescription(str);
        imageButton.setImageDrawable(new LayerDrawable(drawableArr));
        imageButton.setScaleType(ImageView.ScaleType.CENTER);
        imageButton.setLayoutParams(layoutParams);
        imageButton.setBackgroundColor(0);
        return imageButton;
    }

    private void addThumbsToDialogView() {
        LinearLayout linearLayout = (LinearLayout) this.initialQuestionDialog.findViewById(C3902R.id.icon_view);
        linearLayout.setGravity(17);
        ImageButton imageButtonCreateThumbButton = createThumbButton(linearLayout, EmbeddedFeedbackUtils.getThumbsUpTranslation(this.thumbsDescriptions[0], this.currentLangCode), EmbeddedFeedbackUtils.THUMBS_UP);
        imageButtonCreateThumbButton.setId(this.thumbsButtonIDs[0]);
        imageButtonCreateThumbButton.setOnClickListener(new View.OnClickListener() { // from class: com.qualtrics.digital.EmbeddedFeedbackOrchestrator.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmbeddedFeedbackOrchestrator.this.onInitialQuestionAnswered(0);
            }
        });
        linearLayout.addView(imageButtonCreateThumbButton);
        ImageButton imageButtonCreateThumbButton2 = createThumbButton(linearLayout, EmbeddedFeedbackUtils.getThumbsDownTranslation(this.thumbsDescriptions[1], this.currentLangCode), EmbeddedFeedbackUtils.THUMBS_DOWN);
        imageButtonCreateThumbButton2.setId(this.thumbsButtonIDs[1]);
        imageButtonCreateThumbButton2.setOnClickListener(new View.OnClickListener() { // from class: com.qualtrics.digital.EmbeddedFeedbackOrchestrator.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmbeddedFeedbackOrchestrator.this.onInitialQuestionAnswered(1);
            }
        });
        linearLayout.addView(imageButtonCreateThumbButton2);
    }

    LinearLayout.LayoutParams getInitialQuestionLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(convertDpToPixel(16.0f), convertDpToPixel(8.0f), convertDpToPixel(16.0f), convertDpToPixel(16.0f));
        return layoutParams;
    }

    private void displayInitialQuestion() {
        int color;
        EmbeddedFeedbackCreativeQuestion embeddedFeedbackCreativeQuestion = this.options.Questions.get(0);
        this.initialQuestion = embeddedFeedbackCreativeQuestion;
        String translation = EmbeddedFeedbackUtils.getTranslation(embeddedFeedbackCreativeQuestion.QuestionText, this.options.Translations, this.currentLangCode, EmbeddedFeedbackUtils.MAIN_QUESTION_KEY);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.context, C3902R.style.BottomSheetDialog);
        this.initialQuestionDialog = bottomSheetDialog;
        bottomSheetDialog.setCancelable(false);
        View viewInflate = ((Activity) this.context).getLayoutInflater().inflate(C3902R.layout.embedded_feedback_initial_question, (ViewGroup) null);
        configureCloseButton(viewInflate, this.initialQuestionDialog, false);
        Drawable drawable = this.context.getDrawable(C3902R.drawable.embedded_feedback_modal_border);
        if (this.themeApplier.shouldEmbeddedFeedbackUseTheming(this.options)) {
            color = this.embeddedAppFeedbackTheme.getDialogBackgroundColor(this.themingUtils);
        } else {
            color = ContextCompat.getColor(this.context, C3902R.color.qualtricsDefaultBackground);
        }
        drawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
        viewInflate.setBackground(drawable);
        TextView textView = (TextView) viewInflate.findViewById(C3902R.id.question_text);
        FontTheme initialQuestion = shouldThemeFonts(this.options, this.embeddedAppFeedbackTheme) ? this.embeddedAppFeedbackTheme.getInitialQuestionTheme().getInitialQuestion() : null;
        if (initialQuestion != null) {
            if (initialQuestion.hasDefaultTypeface()) {
                textView.setTypeface(null, 1);
            } else {
                setTypefaceIfSupported(textView, initialQuestion.getFontRes());
            }
            textView.setTextSize(2, initialQuestion.getSize());
        } else {
            textView.setTypeface(null, 1);
        }
        textView.setText(translation);
        textView.setTextColor(Color.parseColor(this.options.Questions.get(0).Appearance.QuestionTextColor));
        textView.setContentDescription(translation);
        textView.setLayoutParams(getInitialQuestionLayoutParams());
        this.initialQuestionDialog.setContentView(viewInflate);
        this.initialQuestionDialog.setTitle(C3902R.string.qualtrics_dialog_text);
        viewInflate.measure(0, 0);
        if (viewInflate.getMeasuredHeight() < ((double) this.screenHeight) * 0.3d) {
            viewInflate.getLayoutParams().height = (this.screenHeight * 30) / 100;
            viewInflate.requestLayout();
        }
        this.initialQuestionDialog.show();
    }

    protected View getFollowupQuestionDialogView() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.context, C3902R.style.BottomSheetDialog);
        this.followupQuestionDialog = bottomSheetDialog;
        bottomSheetDialog.setCancelable(false);
        View viewInflate = ((Activity) this.context).getLayoutInflater().inflate(C3902R.layout.embedded_feedback_followup_question, (ViewGroup) null);
        configureCloseButton(viewInflate, this.followupQuestionDialog, true);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRadioButtonClicked(int i, int i2, View view) {
        EditText editText = (EditText) view.findViewById(C3902R.id.other_option_edit_text);
        if (editText != null) {
            editText.setEnabled(false);
            int[] iArr = this.multipleChoiceIds;
            if (i2 == iArr[iArr.length - 1]) {
                editText.setEnabled(true);
            }
        }
        for (int i3 = 0; i3 < this.multipleChoiceRadioButtons.size(); i3++) {
            RadioButton radioButton = this.multipleChoiceRadioButtons.get(i3);
            if (radioButton.getId() == i2) {
                if (this.themeApplier.shouldEmbeddedFeedbackUseTheming(this.options)) {
                    radioButton.setBackgroundColor(this.embeddedAppFeedbackTheme.getMultipleChoiceTheme().getRadioButtonsTheme().getSelectedBackgroundColor(this.themingUtils));
                } else {
                    radioButton.setBackgroundColor(i);
                    radioButton.getBackground().setAlpha(50);
                }
            } else if (this.themeApplier.shouldEmbeddedFeedbackUseTheming(this.options)) {
                radioButton.setBackgroundColor(this.embeddedAppFeedbackTheme.getDialogBackgroundColor(this.themingUtils));
            } else {
                radioButton.setBackgroundColor(ContextCompat.getColor(this.context, C3902R.color.qualtricsDefaultBackground));
            }
        }
    }

    private RadioButton getMultipleChoiceRadioButton(String str, int i, int i2, int i3, int i4, int i5) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, convertDpToPixel(10.0f));
        RadioButton radioButton = new RadioButton(this.context);
        radioButton.setText(str);
        FontTheme textFont = shouldThemeFonts(this.options, this.embeddedAppFeedbackTheme) ? this.embeddedAppFeedbackTheme.getMultipleChoiceTheme().getRadioButtonsTheme().getTextFont() : null;
        if (textFont != null) {
            if (textFont.hasCustomTypeface()) {
                setTypefaceIfSupported(radioButton, textFont.getFontRes());
            }
            radioButton.setTextSize(2, textFont.getSize());
        } else {
            radioButton.setTextSize(2, 18.0f);
        }
        radioButton.setTextColor(i);
        radioButton.setId(i4);
        radioButton.setTag(Integer.valueOf(i5));
        radioButton.setLayoutParams(layoutParams);
        radioButton.setButtonTintList(EmbeddedFeedbackUtils.getRadioButtonColorList(i2, i3));
        radioButton.setPadding(0, convertDpToPixel(10.0f), 0, convertDpToPixel(10.0f));
        return radioButton;
    }

    private EditText getOtherOptionEditText() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(convertDpToPixel(30.0f), 0, convertDpToPixel(20.0f), 0);
        EditText editText = new EditText(this.context);
        editText.setId(C3902R.id.other_option_edit_text);
        editText.setHeight(convertDpToPixel(40.0f));
        editText.setLayoutParams(layoutParams);
        editText.setEnabled(false);
        editText.setVisibility(0);
        editText.setImeOptions(6);
        editText.setRawInputType(1);
        editText.setBackgroundResource(C3902R.drawable.rounded_rectangle);
        int color = ContextCompat.getColor(this.context, C3902R.color.qualtricsDefaultTextInput);
        int color2 = ContextCompat.getColor(this.context, C3902R.color.qualtricsDefaultTextInputBackground);
        if (this.themeApplier.shouldEmbeddedFeedbackUseTheming(this.options)) {
            color = this.embeddedAppFeedbackTheme.getMultipleChoiceTheme().getOtherAnswerTextColor(this.themingUtils);
            color2 = this.embeddedAppFeedbackTheme.getMultipleChoiceTheme().getOtherAnswerBackgroundColor(this.themingUtils);
        }
        FontTheme otherAnswerTextFont = shouldThemeFonts(this.options, this.embeddedAppFeedbackTheme) ? this.embeddedAppFeedbackTheme.getMultipleChoiceTheme().getOtherAnswerTextFont() : null;
        if (otherAnswerTextFont != null) {
            if (otherAnswerTextFont.hasCustomTypeface()) {
                setTypefaceIfSupported(editText, otherAnswerTextFont.getFontRes());
            }
            editText.setTextSize(2, otherAnswerTextFont.getSize());
        }
        editText.setTextColor(color);
        editText.getBackground().setColorFilter(color2, PorterDuff.Mode.SRC_ATOP);
        return editText;
    }

    protected void configureMultipleChoiceQuestionViews(final View view, EmbeddedFeedbackCreativeQuestion embeddedFeedbackCreativeQuestion) {
        String translation = EmbeddedFeedbackUtils.getTranslation(embeddedFeedbackCreativeQuestion.QuestionText, this.options.Translations, this.currentLangCode, EmbeddedFeedbackUtils.MULTIPLE_CHOICE_QUESTION_KEY);
        int color = Color.parseColor(this.options.Questions.get(0).Appearance.QuestionTextColor);
        final int color2 = Color.parseColor(embeddedFeedbackCreativeQuestion.Appearance.RadioButtonFillColor);
        TextView textView = (TextView) view.findViewById(C3902R.id.multiple_choice_question_text);
        textView.setVisibility(0);
        FontTheme questionTextFont = shouldThemeFonts(this.options, this.embeddedAppFeedbackTheme) ? this.embeddedAppFeedbackTheme.getMultipleChoiceTheme().getQuestionTextFont() : null;
        if (questionTextFont != null) {
            if (questionTextFont.hasDefaultTypeface()) {
                textView.setTypeface(null, 1);
            } else {
                setTypefaceIfSupported(textView, questionTextFont.getFontRes());
            }
            textView.setTextSize(2, questionTextFont.getSize());
        } else {
            textView.setTypeface(null, 1);
        }
        textView.setText(translation);
        textView.setTextColor(color);
        textView.setContentDescription(translation);
        textView.setPadding(0, 0, 0, 10);
        List<String> activeLocalizedMultipleChoices = EmbeddedFeedbackUtilsJava.getActiveLocalizedMultipleChoices(embeddedFeedbackCreativeQuestion, this.options.Translations, this.currentLangCode);
        this.multipleChoiceRadioButtons = new ArrayList();
        RadioGroup radioGroup = (RadioGroup) view.findViewById(C3902R.id.multiple_choice_radio_group);
        radioGroup.setPadding(18, convertDpToPixel(10.0f), 0, convertDpToPixel(EmbeddedFeedbackUtilsJava.getRadioGroupBottomPadding(this.options.Questions)));
        radioGroup.setVisibility(0);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.qualtrics.digital.EmbeddedFeedbackOrchestrator.10
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup2, int i) {
                EmbeddedFeedbackOrchestrator.this.onRadioButtonClicked(color2, i, view);
            }
        });
        for (int i = 0; i < activeLocalizedMultipleChoices.size(); i++) {
            RadioButton multipleChoiceRadioButton = getMultipleChoiceRadioButton(activeLocalizedMultipleChoices.get(i), color, color2, Color.parseColor(this.options.Questions.get(0).Appearance.RadioButtonUnselectedCircleColor), this.multipleChoiceIds[i], i);
            this.multipleChoiceRadioButtons.add(multipleChoiceRadioButton);
            radioGroup.addView(multipleChoiceRadioButton);
        }
        String translatedMultipleChoiceOtherOption = EmbeddedFeedbackUtilsJava.getTranslatedMultipleChoiceOtherOption(embeddedFeedbackCreativeQuestion, this.options.Translations, this.currentLangCode);
        if (translatedMultipleChoiceOtherOption != null) {
            int color3 = Color.parseColor(this.options.Questions.get(0).Appearance.RadioButtonUnselectedCircleColor);
            int[] iArr = this.multipleChoiceIds;
            RadioButton multipleChoiceRadioButton2 = getMultipleChoiceRadioButton(translatedMultipleChoiceOtherOption, color, color2, color3, iArr[iArr.length - 1], activeLocalizedMultipleChoices.size());
            this.multipleChoiceRadioButtons.add(multipleChoiceRadioButton2);
            radioGroup.addView(multipleChoiceRadioButton2);
            radioGroup.addView(getOtherOptionEditText());
        }
    }

    protected void configureSubmitButton(View view) {
        Button button = (Button) view.findViewById(C3902R.id.submit_button);
        EmbeddedFeedbackSubmitButtonAppearance embeddedFeedbackSubmitButtonAppearance = this.options.SubmitButtonAppearance;
        button.setText(EmbeddedFeedbackUtils.getTranslation(embeddedFeedbackSubmitButtonAppearance.ButtonText, this.options.Translations, this.currentLangCode, EmbeddedFeedbackUtils.SUBMIT_BUTTON_TEXT_KEY));
        FontTheme font = shouldThemeFonts(this.options, this.embeddedAppFeedbackTheme) ? this.embeddedAppFeedbackTheme.getSubmitButtonTheme().getFont() : null;
        if (font != null) {
            if (font.hasCustomTypeface()) {
                setTypefaceIfSupported(button, font.getFontRes());
            }
            button.setTextSize(2, font.getSize());
        }
        button.setTextColor(Color.parseColor(embeddedFeedbackSubmitButtonAppearance.ButtonTextColor));
        button.setBackgroundColor(Color.parseColor(embeddedFeedbackSubmitButtonAppearance.ButtonFillColor));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.qualtrics.digital.EmbeddedFeedbackOrchestrator.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EmbeddedFeedbackOrchestrator.this.submitButtonPressed();
            }
        });
    }

    protected void displayMultipleChoiceQuestion() {
        int color;
        this.multipleChoiceQuestion = EmbeddedFeedbackUtilsJava.getMultipleChoiceQuestion(this.options.Questions);
        View followupQuestionDialogView = getFollowupQuestionDialogView();
        configureMultipleChoiceQuestionViews(followupQuestionDialogView, this.multipleChoiceQuestion);
        configureSubmitButton(followupQuestionDialogView);
        this.followupQuestionDialog.setContentView(followupQuestionDialogView);
        this.followupQuestionDialog.setTitle(C3902R.string.qualtrics_dialog_text);
        Drawable drawable = this.context.getDrawable(C3902R.drawable.embedded_feedback_modal_border);
        if (this.themeApplier.shouldEmbeddedFeedbackUseTheming(this.options)) {
            color = this.embeddedAppFeedbackTheme.getDialogBackgroundColor(this.themingUtils);
        } else {
            color = ContextCompat.getColor(this.context, C3902R.color.qualtricsDefaultBackground);
        }
        drawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
        followupQuestionDialogView.setBackground(drawable);
        followupQuestionDialogView.measure(0, 0);
        if (followupQuestionDialogView.getMeasuredHeight() < ((double) this.screenHeight) * 0.3d) {
            followupQuestionDialogView.getLayoutParams().height = (this.screenHeight * 30) / 100;
            followupQuestionDialogView.requestLayout();
        }
        this.followupQuestionDialog.getBehavior().setPeekHeight(this.screenHeight);
        this.followupQuestionDialog.show();
    }

    protected void displayFollowupQuestion() {
        int color;
        this.followupQuestion = EmbeddedFeedbackUtilsJava.getFollowupQuestion(this.options.Questions);
        this.multipleChoiceQuestion = EmbeddedFeedbackUtilsJava.getMultipleChoiceQuestion(this.options.Questions);
        View followupQuestionDialogView = getFollowupQuestionDialogView();
        Drawable drawable = this.context.getDrawable(C3902R.drawable.embedded_feedback_modal_border);
        if (this.themeApplier.shouldEmbeddedFeedbackUseTheming(this.options)) {
            color = this.embeddedAppFeedbackTheme.getDialogBackgroundColor(this.themingUtils);
        } else {
            color = ContextCompat.getColor(this.context, C3902R.color.qualtricsDefaultBackground);
        }
        drawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
        followupQuestionDialogView.setBackground(drawable);
        EmbeddedFeedbackCreativeQuestion embeddedFeedbackCreativeQuestion = this.multipleChoiceQuestion;
        if (embeddedFeedbackCreativeQuestion != null) {
            configureMultipleChoiceQuestionViews(followupQuestionDialogView, embeddedFeedbackCreativeQuestion);
        }
        configureFollowupQuestionLookAndFeelViews(followupQuestionDialogView, this.followupQuestion);
        configureSubmitButton(followupQuestionDialogView);
        this.followupQuestionDialog.setContentView(followupQuestionDialogView);
        this.followupQuestionDialog.setTitle(C3902R.string.qualtrics_dialog_text);
        followupQuestionDialogView.measure(0, 0);
        double measuredHeight = followupQuestionDialogView.getMeasuredHeight();
        if (measuredHeight < ((double) this.screenHeight) * 0.3d) {
            followupQuestionDialogView.getLayoutParams().height = (this.screenHeight * 30) / 100;
            followupQuestionDialogView.requestLayout();
        }
        if (measuredHeight > ((double) this.screenHeight) * 0.9d) {
            followupQuestionDialogView.getLayoutParams().height = (this.screenHeight * 90) / 100;
            followupQuestionDialogView.requestLayout();
        }
        this.followupQuestionDialog.getBehavior().setPeekHeight(this.screenHeight);
        this.followupQuestionDialog.show();
    }

    protected void displayThankYouMessage() {
        int color;
        EmbeddedFeedbackCreativeQuestion thankYouMessage = EmbeddedFeedbackUtilsJava.getThankYouMessage(this.options.Questions);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.context, C3902R.style.BottomSheetDialog);
        this.thankYouMessageDialog = bottomSheetDialog;
        bottomSheetDialog.setCancelable(false);
        View viewInflate = ((Activity) this.context).getLayoutInflater().inflate(C3902R.layout.embedded_feedback_thank_you_message, (ViewGroup) null);
        configureCloseButton(viewInflate, this.thankYouMessageDialog, false);
        Drawable drawable = this.context.getDrawable(C3902R.drawable.embedded_feedback_modal_border);
        if (this.themeApplier.shouldEmbeddedFeedbackUseTheming(this.options)) {
            color = this.embeddedAppFeedbackTheme.getDialogBackgroundColor(this.themingUtils);
        } else {
            color = ContextCompat.getColor(this.context, C3902R.color.qualtricsDefaultBackground);
        }
        drawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
        viewInflate.setBackground(drawable);
        String translation = EmbeddedFeedbackUtils.getTranslation(thankYouMessage.QuestionText, this.options.Translations, this.currentLangCode, EmbeddedFeedbackUtils.THANK_YOU_KEY);
        TextView textView = (TextView) viewInflate.findViewById(C3902R.id.thank_you_message);
        FontTheme thankYouTextFont = shouldThemeFonts(this.options, this.embeddedAppFeedbackTheme) ? this.embeddedAppFeedbackTheme.getThankYouTheme().getThankYouTextFont() : null;
        if (thankYouTextFont != null) {
            if (thankYouTextFont.hasCustomTypeface()) {
                setTypefaceIfSupported(textView, thankYouTextFont.getFontRes());
            } else {
                textView.setTypeface(null, 1);
            }
            textView.setTextSize(2, this.embeddedAppFeedbackTheme.getThankYouTheme().getThankYouTextFont().getSize());
        } else {
            textView.setTypeface(null, 1);
        }
        textView.setText(translation);
        textView.setTextColor(Color.parseColor(this.options.Questions.get(0).Appearance.QuestionTextColor));
        textView.setContentDescription(translation);
        textView.setGravity(17);
        this.thankYouMessageDialog.setContentView(viewInflate);
        this.thankYouMessageDialog.setTitle(C3902R.string.qualtrics_dialog_text);
        viewInflate.measure(0, 0);
        if (viewInflate.getMeasuredHeight() < ((double) this.screenHeight) * 0.3d) {
            viewInflate.getLayoutParams().height = (this.screenHeight * 30) / 100;
            viewInflate.requestLayout();
        }
        this.thankYouMessageDialog.show();
    }

    private void configureFollowupQuestionLookAndFeelViews(View view, EmbeddedFeedbackCreativeQuestion embeddedFeedbackCreativeQuestion) {
        CharSequence translation = EmbeddedFeedbackUtils.getTranslation(embeddedFeedbackCreativeQuestion.QuestionText, this.options.Translations, this.currentLangCode, EmbeddedFeedbackUtils.FOLLOW_UP_QUESTION_KEY);
        TextView textView = (TextView) view.findViewById(C3902R.id.followup_question_text);
        FontTheme followupQuestionFont = shouldThemeFonts(this.options, this.embeddedAppFeedbackTheme) ? this.embeddedAppFeedbackTheme.getFollowupQuestionTheme().getFollowupQuestionFont() : null;
        if (followupQuestionFont != null) {
            if (followupQuestionFont.hasCustomTypeface()) {
                setTypefaceIfSupported(textView, followupQuestionFont.getFontRes());
            } else {
                textView.setTypeface(null, 1);
            }
            textView.setTextSize(2, followupQuestionFont.getSize());
        } else {
            textView.setTypeface(null, 1);
        }
        textView.setText(translation);
        textView.setTextColor(Color.parseColor(embeddedFeedbackCreativeQuestion.Appearance.QuestionTextColor));
        textView.setContentDescription(translation);
        textView.setVisibility(0);
        EditText editText = (EditText) view.findViewById(C3902R.id.open_text_input);
        editText.setImeOptions(6);
        editText.setRawInputType(1);
        int color = ContextCompat.getColor(this.context, C3902R.color.qualtricsDefaultTextInput);
        int color2 = ContextCompat.getColor(this.context, C3902R.color.qualtricsDefaultTextInputBackground);
        if (this.themeApplier.shouldEmbeddedFeedbackUseTheming(this.options)) {
            color = this.embeddedAppFeedbackTheme.getTextInputTheme().getMultilineTextInputColor(this.themingUtils);
            color2 = this.embeddedAppFeedbackTheme.getTextInputTheme().getMultilineTextInputBackgroundColor(this.themingUtils);
        }
        editText.setTextColor(color);
        editText.getBackground().setColorFilter(color2, PorterDuff.Mode.SRC_ATOP);
        editText.setHint(translation);
        FontTheme followupQuestionTextInputFont = shouldThemeFonts(this.options, this.embeddedAppFeedbackTheme) ? this.embeddedAppFeedbackTheme.getFollowupQuestionTheme().getFollowupQuestionTextInputFont() : null;
        if (followupQuestionTextInputFont != null) {
            if (followupQuestionTextInputFont.hasCustomTypeface()) {
                setTypefaceIfSupported(editText, followupQuestionTextInputFont.getFontRes());
            }
            editText.setTextSize(2, followupQuestionTextInputFont.getSize());
        }
        editText.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeDialog(BottomSheetDialog bottomSheetDialog, boolean z) {
        if (z) {
            checkAndSubmitResponse();
        }
        if (bottomSheetDialog != null) {
            bottomSheetDialog.cancel();
        }
    }

    void submitButtonPressed() {
        closeDialog(this.followupQuestionDialog, false);
        checkAndSubmitResponse();
        if (EmbeddedFeedbackUtilsJava.getThankYouMessage(this.options.Questions) != null) {
            displayThankYouMessage();
        } else {
            notifyListenerOfDialogClose();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void checkAndSubmitResponse() {
        /*
            r5 = this;
            com.qualtrics.digital.EmbeddedFeedbackCreativeQuestion r0 = r5.followupQuestion
            if (r0 == 0) goto L1f
            com.google.android.material.bottomsheet.BottomSheetDialog r0 = r5.followupQuestionDialog
            int r1 = com.qualtrics.C3902R.id.open_text_input
            android.view.View r0 = r0.findViewById(r1)
            android.widget.EditText r0 = (android.widget.EditText) r0
            com.qualtrics.digital.EmbeddedFeedbackResponseManager r1 = r5.responseManager
            com.qualtrics.digital.EmbeddedFeedbackCreativeQuestion r2 = r5.followupQuestion
            java.lang.String r2 = r2.SurveyQuestionId
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r1.addToResponse(r2, r0)
        L1f:
            com.qualtrics.digital.EmbeddedFeedbackCreativeQuestion r0 = r5.multipleChoiceQuestion
            if (r0 == 0) goto La1
            com.google.android.material.bottomsheet.BottomSheetDialog r0 = r5.followupQuestionDialog
            int r1 = com.qualtrics.C3902R.id.multiple_choice_radio_group
            android.view.View r0 = r0.findViewById(r1)
            android.widget.RadioGroup r0 = (android.widget.RadioGroup) r0
            com.google.android.material.bottomsheet.BottomSheetDialog r1 = r5.followupQuestionDialog
            int r0 = r0.getCheckedRadioButtonId()
            android.view.View r0 = r1.findViewById(r0)
            android.widget.RadioButton r0 = (android.widget.RadioButton) r0
            java.lang.String r1 = "%s"
            if (r0 == 0) goto L7e
            int r2 = r0.getId()
            int[] r3 = r5.multipleChoiceIds
            int r4 = r3.length
            int r4 = r4 + (-1)
            r3 = r3[r4]
            if (r2 != r3) goto L7e
            com.google.android.material.bottomsheet.BottomSheetDialog r2 = r5.followupQuestionDialog
            int r3 = com.qualtrics.C3902R.id.other_option_edit_text
            android.view.View r2 = r2.findViewById(r3)
            android.widget.EditText r2 = (android.widget.EditText) r2
            com.qualtrics.digital.EmbeddedFeedbackResponseManager r3 = r5.responseManager
            com.qualtrics.digital.EmbeddedFeedbackCreativeQuestion r4 = r5.multipleChoiceQuestion
            java.lang.String r4 = r4.SurveyQuestionId
            java.lang.Object r0 = r0.getTag()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r0 = r0 + 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r0 = java.lang.String.format(r1, r0)
            android.text.Editable r1 = r2.getText()
            java.lang.String r1 = r1.toString()
            r3.addMultipleChoiceTextResponse(r4, r0, r1)
            goto La1
        L7e:
            if (r0 == 0) goto La1
            com.qualtrics.digital.EmbeddedFeedbackResponseManager r2 = r5.responseManager
            com.qualtrics.digital.EmbeddedFeedbackCreativeQuestion r3 = r5.multipleChoiceQuestion
            java.lang.String r3 = r3.SurveyQuestionId
            java.lang.Object r0 = r0.getTag()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r0 = r0 + 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r2.addToResponse(r3, r0)
        La1:
            com.qualtrics.digital.EmbeddedFeedbackResponseManager r0 = r5.responseManager
            r0.postResponse()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qualtrics.digital.EmbeddedFeedbackOrchestrator.checkAndSubmitResponse():void");
    }

    private int convertDpToPixel(float f) {
        return DisplayUtils.convertDpToPixel(f, this.context.getResources());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInitialQuestionAnswered(int i) {
        this.siteInterceptService.recordClick(this.interceptID, this.creativeID, this.actionSetID);
        this.responseManager.addToResponse(this.initialQuestion.SurveyQuestionId, String.format("%s", Integer.valueOf(i + 1)));
        String str = this.options.Questions.get(0).Style;
        str.hashCode();
        switch (str) {
            case "embedded-feedback-question-style-yes-no":
                ((Button) this.initialQuestionDialog.findViewById(this.textButtonIDs[i])).setBackgroundColor(ColorUtils.blendARGB(Color.parseColor(this.options.Questions.get(0).Appearance.ButtonFillColor), -16777216, 0.3f));
                break;
            case "embedded-feedback-emoji-style-custom":
            case "embedded-feedback-question-style-emoji":
            case "embedded-feedback-question-style-thumbs":
                break;
            case "embedded-feedback-question-style-stars":
                int color = Color.parseColor(this.options.Questions.get(0).Appearance.StarsColor);
                for (int i2 = 0; i2 < i; i2++) {
                    ((LayerDrawable) ((ImageButton) this.initialQuestionDialog.findViewById(this.fivePointQuestionIconIds[i2])).getDrawable()).getDrawable(0).setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
                }
                break;
            default:
                QualtricsLog.logError("Qualtrics: Invalid question style");
                break;
        }
        closeDialog(this.initialQuestionDialog, false);
        String str2 = this.options.Questions.get(0).Choices.get(i).NextAction;
        str2.hashCode();
        switch (str2) {
            case "embedded-feedback-question-id-multiple-choice-question":
                displayMultipleChoiceQuestion();
                break;
            case "embedded-feedback-question-id-thank-you-message":
                checkAndSubmitResponse();
                displayThankYouMessage();
                break;
            case "embedded-feedback-question-id-follow-up-question":
                displayFollowupQuestion();
                break;
            case "End":
                checkAndSubmitResponse();
                notifyListenerOfDialogClose();
                break;
            default:
                checkAndSubmitResponse();
                notifyListenerOfDialogClose();
                QualtricsLog.logError("Qualtrics: Invalid question choice");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListenerOfDialogClose() {
        this.clientCallbackUtils.callEmbeddedFeedbackOnCloseListener();
        Activity activity = (Activity) this.context;
        if (activity instanceof QualtricsEmbeddedFeedbackActivity) {
            activity.finish();
        }
    }

    private Typeface getTypeface(int i) {
        if (i == 0) {
            return Typeface.DEFAULT;
        }
        return this.context.getResources().getFont(i);
    }

    private void setTypefaceIfSupported(TextView textView, int i) {
        textView.setTypeface(getTypeface(i));
    }

    private boolean shouldThemeFonts(EmbeddedFeedbackCreativeOptions embeddedFeedbackCreativeOptions, EmbeddedAppFeedbackTheme embeddedAppFeedbackTheme) {
        return this.themeApplier.shouldEmbeddedFeedbackUseTheming(embeddedFeedbackCreativeOptions) && this.embeddedAppFeedbackTheme != null;
    }
}
