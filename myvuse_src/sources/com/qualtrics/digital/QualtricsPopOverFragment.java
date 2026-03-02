package com.qualtrics.digital;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.hermes.intl.Constants;
import com.google.gson.Gson;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.onetrust.otpublishers.headless.Public.OTBannerHeightRatio;
import com.qualtrics.C3902R;
import com.qualtrics.digital.theming.fonts.FontTheme;
import com.qualtrics.digital.theming.prompt.MobileAppPromptTheme;

/* JADX INFO: loaded from: classes6.dex */
public class QualtricsPopOverFragment extends Fragment implements TraceFieldInterface {
    public static final String CLOSE_DIALOG = "Close Dialog";
    private static final String CREATIVE_DEFINITION_KEY = "CREATIVE_DEFINITION";
    private static final String CREATIVE_THEME_KEY = "CREATIVE_THEME";
    private static final int DIALOG_WIDTH = 260;
    private static final String WIDTH_KEY = "WIDTH";
    public Trace _nr_trace;
    OnCreativeButtonPressedListener mButtonPressListener;

    public interface OnCreativeButtonPressedListener {
        void onCreativeButtonPressed(String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    public static QualtricsPopOverFragment newInstance(String str, int i, String str2) {
        QualtricsPopOverFragment qualtricsPopOverFragment = new QualtricsPopOverFragment();
        Bundle bundle = new Bundle();
        bundle.putString(CREATIVE_DEFINITION_KEY, str);
        bundle.putString(CREATIVE_THEME_KEY, str2);
        bundle.putInt(WIDTH_KEY, i);
        qualtricsPopOverFragment.setArguments(bundle);
        return qualtricsPopOverFragment;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        setButtonPressListener(activity);
    }

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        setButtonPressListener(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setButtonPressListener(Context context) {
        try {
            this.mButtonPressListener = (OnCreativeButtonPressedListener) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must implement OnCreativeButtonPressListener");
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "QualtricsPopOverFragment#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "QualtricsPopOverFragment#onCreateView", null);
        }
        String string = getArguments().getString(CREATIVE_DEFINITION_KEY);
        String string2 = getArguments().getString(CREATIVE_THEME_KEY);
        if (string == null) {
            LogInstrumentation.m2728e("Qualtrics", "Error getting creative definition in pop over fragment. Display aborted.");
            TraceMachine.exitMethod();
            return null;
        }
        int i = getArguments().getInt(WIDTH_KEY);
        Gson gson = new Gson();
        boolean z = gson instanceof Gson;
        PopOverCreative popOverCreative = (PopOverCreative) (!z ? gson.fromJson(string, PopOverCreative.class) : GsonInstrumentation.fromJson(gson, string, PopOverCreative.class));
        MobileAppPromptTheme mobileAppPromptTheme = (MobileAppPromptTheme) (!z ? gson.fromJson(string2, MobileAppPromptTheme.class) : GsonInstrumentation.fromJson(gson, string2, MobileAppPromptTheme.class));
        RelativeLayout dialogContainer = getDialogContainer(popOverCreative);
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setId(C3902R.id.popOverBody);
        int dialogWidth = getDialogWidth(i);
        convertDpToPixel(16.0f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setColor(Color.parseColor(popOverCreative.CreativeDefinition.Options.Divider.Color));
        shapeDrawable.setIntrinsicHeight(convertDpToPixel(popOverCreative.CreativeDefinition.Options.SizeAndStyle.getContentSpacing()));
        shapeDrawable.setIntrinsicWidth(dialogWidth);
        linearLayout.setDividerDrawable(shapeDrawable);
        buildDialogLayout(linearLayout, dialogWidth, popOverCreative);
        dialogContainer.addView(linearLayout);
        buildCloseButton(linearLayout, popOverCreative);
        TextView messageTitle = getMessageTitle(popOverCreative, mobileAppPromptTheme != null ? mobileAppPromptTheme.getHeadlineFont() : null);
        buildMessageSection(linearLayout, messageTitle, getMessageDescription(convertDpToPixel(18.0f), messageTitle, popOverCreative, mobileAppPromptTheme != null ? mobileAppPromptTheme.getDescriptionFont() : null));
        LinearLayout buttonLayout = getButtonLayout(popOverCreative.CreativeDefinition.Options.Buttons.ButtonStyle.equals(OTBannerHeightRatio.FULL), shapeDrawable.getIntrinsicHeight());
        LinearLayout linearLayout2 = new LinearLayout(getActivity());
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(getActivity());
        textView.setTextSize(2, 18.0f);
        textView.setText(popOverCreative.CreativeDefinition.Options.Buttons.ButtonOne.Text);
        boolean zAreButtonsMultiline = areButtonsMultiline(dialogWidth, textView, popOverCreative);
        if (zAreButtonsMultiline) {
            buttonLayout.setOrientation(1);
        }
        linearLayout2.addView(buttonLayout);
        TextView textViewConfigureButton = configureButton(textView, popOverCreative.CreativeDefinition.Options.Buttons, popOverCreative.CreativeDefinition.Options.Buttons.ButtonOne, zAreButtonsMultiline, true, buttonLayout, mobileAppPromptTheme != null ? mobileAppPromptTheme.getButtonOneTheme().getFont() : null);
        textViewConfigureButton.setContentDescription(popOverCreative.CreativeDefinition.Options.Buttons.ButtonOne.Text + " button");
        textViewConfigureButton.setId(C3902R.id.popOverButtonOne);
        if (popOverCreative.CreativeDefinition.Options.Buttons.Number == 2) {
            TextView textView2 = new TextView(getActivity());
            textView2.setContentDescription(popOverCreative.CreativeDefinition.Options.Buttons.ButtonTwo.Text + " button");
            textView2.setId(C3902R.id.popOverButtonTwo);
            textView2.setText(popOverCreative.CreativeDefinition.Options.Buttons.ButtonTwo.Text);
            View viewConfigureButton = configureButton(textView2, popOverCreative.CreativeDefinition.Options.Buttons, popOverCreative.CreativeDefinition.Options.Buttons.ButtonTwo, zAreButtonsMultiline, false, buttonLayout, mobileAppPromptTheme != null ? mobileAppPromptTheme.getButtonTwoTheme().getFont() : null);
            if (zAreButtonsMultiline) {
                buttonLayout.addView(viewConfigureButton);
                buttonLayout.addView(textViewConfigureButton);
            } else {
                buttonLayout.addView(textViewConfigureButton);
                buttonLayout.addView(viewConfigureButton);
            }
        } else {
            buttonLayout.addView(textViewConfigureButton);
        }
        linearLayout.addView(linearLayout2);
        TraceMachine.exitMethod();
        return dialogContainer;
    }

    private void buildCloseButton(LinearLayout linearLayout, PopOverCreative popOverCreative) {
        if (!shouldShowCloseButton(popOverCreative.CreativeDefinition.Options.Buttons)) {
            linearLayout.setShowDividers(3);
            return;
        }
        linearLayout.setShowDividers(2);
        LinearLayout linearLayout2 = new LinearLayout(getActivity());
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = convertDpToPixel(20.0f);
        layoutParams.rightMargin = convertDpToPixel(20.0f);
        linearLayout2.setLayoutParams(layoutParams);
        View view = new View(getActivity());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, 0);
        layoutParams2.weight = 1.0f;
        view.setLayoutParams(layoutParams2);
        linearLayout2.addView(view);
        String str = popOverCreative.CreativeDefinition.Options.Buttons.CloseButtonColor;
        String str2 = popOverCreative.CreativeDefinition.Options.Buttons.CloseButtonBackgroundColor;
        ImageView imageView = new ImageView(getActivity());
        imageView.setContentDescription(CLOSE_DIALOG);
        imageView.setId(C3902R.id.dialogCloseButton);
        imageView.setImageResource(C3902R.drawable.ic_close_black_24dp);
        imageView.setColorFilter(Color.parseColor(str));
        imageView.setBackgroundColor(Color.parseColor(str2));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11);
        imageView.setLayoutParams(layoutParams3);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qualtrics.digital.QualtricsPopOverFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (QualtricsPopOverFragment.this.mButtonPressListener != null) {
                    QualtricsPopOverFragment.this.mButtonPressListener.onCreativeButtonPressed("negative");
                } else {
                    QualtricsPopOverFragment.this.getActivity().finish();
                }
            }
        });
        linearLayout2.addView(imageView);
        linearLayout.addView(linearLayout2);
    }

    private boolean shouldShowCloseButton(Buttons buttons) {
        return buttons.hasCloseButton();
    }

    private RelativeLayout getDialogContainer(PopOverCreative popOverCreative) {
        RelativeLayout relativeLayout = new RelativeLayout(getActivity());
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(popOverCreative.CreativeDefinition.Options.SizeAndStyle.getShadowBoxColor());
        relativeLayout.setClipToOutline(true);
        return relativeLayout;
    }

    private int getDialogWidth(int i) {
        int iConvertDpToPixel = convertDpToPixel(260.0f);
        return i < iConvertDpToPixel - convertDpToPixel(40.0f) ? i - convertDpToPixel(40.0f) : iConvertDpToPixel;
    }

    int convertDpToPixel(float f) {
        return DisplayUtils.convertDpToPixel(f, getResources());
    }

    private void buildDialogLayout(LinearLayout linearLayout, int i, PopOverCreative popOverCreative) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, -2);
        layoutParams.addRule(13);
        layoutParams.topMargin = convertDpToPixel(40.0f);
        layoutParams.bottomMargin = convertDpToPixel(40.0f);
        linearLayout.setPadding(0, convertDpToPixel(16.0f), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor(popOverCreative.CreativeDefinition.Options.SizeAndStyle.InterceptColor));
        gradientDrawable.setCornerRadius(convertDpToPixel(popOverCreative.CreativeDefinition.Options.SizeAndStyle.BorderRadius));
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setElevation(popOverCreative.CreativeDefinition.Options.SizeAndStyle.getDropShadow());
    }

    private void buildMessageSection(LinearLayout linearLayout, TextView textView, TextView textView2) {
        if (!textView.getText().equals("")) {
            linearLayout.addView(textView);
        }
        if (textView2.getText().equals("")) {
            return;
        }
        linearLayout.addView(textView2);
    }

    private TextView getMessageTitle(PopOverCreative popOverCreative, FontTheme fontTheme) {
        TextView textView = new TextView(getActivity());
        textView.setContentDescription(popOverCreative.CreativeDefinition.Options.Title.Text);
        textView.setId(C3902R.id.popOverTitle);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = convertDpToPixel(20.0f);
        layoutParams.rightMargin = convertDpToPixel(20.0f);
        layoutParams.gravity = 17;
        textView.setLayoutParams(layoutParams);
        textView.setText(popOverCreative.CreativeDefinition.Options.Title.Text);
        textView.setTextColor(Color.parseColor(popOverCreative.CreativeDefinition.Options.Title.Color));
        if (fontTheme != null) {
            textView.setTypeface(getTypefaceForFontRes(fontTheme.getFontRes()));
            textView.setTextSize(2, fontTheme.getSize());
            textView.setTypeface(textView.getTypeface(), 1);
        } else {
            textView.setTextSize(2, popOverCreative.CreativeDefinition.Options.Title.getTextSize());
            if (popOverCreative.CreativeDefinition.Options.Title.Bold) {
                textView.setTypeface(textView.getTypeface(), 1);
            }
        }
        textView.setTextAlignment(popOverCreative.CreativeDefinition.Options.Title.getAlignment());
        return textView;
    }

    private Typeface getTypefaceForFontRes(int i) {
        if (i == 0) {
            return Typeface.DEFAULT;
        }
        return getResources().getFont(i);
    }

    private TextView getMessageDescription(int i, TextView textView, PopOverCreative popOverCreative, FontTheme fontTheme) {
        TextView textView2 = new TextView(getActivity());
        textView2.setContentDescription(popOverCreative.CreativeDefinition.Options.Description.Text);
        textView2.setId(C3902R.id.popOverDescription);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = convertDpToPixel(20.0f);
        layoutParams.rightMargin = convertDpToPixel(20.0f);
        int i2 = i / 2;
        layoutParams.topMargin = i2;
        layoutParams.bottomMargin = i2;
        textView2.setLayoutParams(layoutParams);
        textView2.setText(popOverCreative.CreativeDefinition.Options.Description.Text);
        textView2.setTextColor(Color.parseColor(popOverCreative.CreativeDefinition.Options.Description.Color));
        if (fontTheme != null) {
            textView2.setTypeface(getTypefaceForFontRes(fontTheme.getFontRes()));
            textView2.setTextSize(2, fontTheme.getSize());
        } else {
            textView2.setTextSize(2, popOverCreative.CreativeDefinition.Options.Description.getTextSize());
            if (popOverCreative.CreativeDefinition.Options.Description.Bold) {
                textView2.setTypeface(textView.getTypeface(), 1);
            }
        }
        textView2.setTextAlignment(popOverCreative.CreativeDefinition.Options.Description.getAlignment());
        return textView2;
    }

    private LinearLayout getButtonLayout(boolean z, int i) {
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int iConvertDpToPixel = convertDpToPixel(25.0f);
        layoutParams.topMargin = (iConvertDpToPixel / 2) + i;
        if (!z) {
            layoutParams.bottomMargin = iConvertDpToPixel;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        return linearLayout;
    }

    private boolean areButtonsMultiline(int i, TextView textView, PopOverCreative popOverCreative) {
        float fMeasureText;
        Paint paint = new Paint();
        paint.setTextSize(textView.getTextSize());
        float fMeasureText2 = paint.measureText(popOverCreative.CreativeDefinition.Options.Buttons.ButtonOne.Text);
        if (popOverCreative.CreativeDefinition.Options.Buttons.Number != 2) {
            return false;
        }
        fMeasureText = paint.measureText(popOverCreative.CreativeDefinition.Options.Buttons.ButtonTwo.Text);
        String str = popOverCreative.CreativeDefinition.Options.Buttons.ButtonStyle;
        str.hashCode();
        switch (str) {
            case "full":
                float fConvertDpToPixel = (i / 2) - (convertDpToPixel(16.0f) * 2);
                if (fMeasureText2 < fConvertDpToPixel && fMeasureText < fConvertDpToPixel) {
                    return false;
                }
                break;
            case "link":
                if (fMeasureText2 + fMeasureText + (convertDpToPixel(20.0f) * 2) <= i) {
                    return false;
                }
                break;
            case "standard":
                if (fMeasureText2 + fMeasureText + (convertDpToPixel(20.0f) * 2) + (convertDpToPixel(16.0f) * 4) + convertDpToPixel(20.0f) <= i) {
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    private TextView configureButton(TextView textView, Buttons buttons, final ButtonOptions buttonOptions, boolean z, boolean z2, LinearLayout linearLayout, FontTheme fontTheme) {
        if (buttons.ButtonStyle.equals("link")) {
            textView.setTextColor(Color.parseColor(buttonOptions.Color));
            textView.setTypeface(textView.getTypeface(), 1);
            if (buttons.LinkAlignment != null) {
                String str = buttons.LinkAlignment;
                str.hashCode();
                switch (str) {
                    case "center":
                        textView.setGravity(17);
                        linearLayout.setGravity(17);
                        break;
                    case "left":
                        textView.setGravity(3);
                        linearLayout.setGravity(3);
                        break;
                    case "right":
                        textView.setGravity(5);
                        linearLayout.setGravity(5);
                        break;
                }
            } else {
                textView.setTextAlignment(4);
                textView.setGravity(17);
                linearLayout.setGravity(17);
            }
        } else {
            textView.setTextColor(Color.parseColor(buttonOptions.Color));
            textView.setTextAlignment(4);
            textView.setGravity(17);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(Color.parseColor(buttonOptions.BackgroundColor));
            if (buttons.ButtonStyle.equals(OTBannerHeightRatio.FULL)) {
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
                if (buttonOptions.BorderColor != null) {
                    shapeDrawable.getPaint().setColor(Color.parseColor(buttonOptions.BorderColor));
                } else {
                    shapeDrawable.getPaint().setColor(Color.parseColor(buttonOptions.BackgroundColor));
                }
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, gradientDrawable});
                layerDrawable.setLayerInset(0, 0, 0, 0, 0);
                layerDrawable.setLayerInset(1, 0, 3, 0, 0);
                textView.setBackground(layerDrawable);
            } else {
                if (buttonOptions.BorderColor != null) {
                    gradientDrawable.setStroke(3, Color.parseColor(buttonOptions.BorderColor));
                }
                gradientDrawable.setCornerRadius(convertDpToPixel(buttons.BorderRadius));
                textView.setBackground(gradientDrawable);
            }
            textView.setGravity(17);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        int iConvertDpToPixel = convertDpToPixel(20.0f);
        if (!buttons.ButtonStyle.equals(OTBannerHeightRatio.FULL)) {
            layoutParams.width = -2;
            if (z || buttons.Number == 1) {
                layoutParams.width = -1;
                layoutParams.leftMargin = iConvertDpToPixel;
                layoutParams.rightMargin = iConvertDpToPixel;
                if (!z2) {
                    layoutParams.bottomMargin = convertDpToPixel(8.0f);
                }
            } else {
                layoutParams.leftMargin = z2 ? iConvertDpToPixel : 0;
                layoutParams.rightMargin = z2 ? convertDpToPixel(16.0f) : iConvertDpToPixel;
                if (buttons.ButtonStyle.equals("link")) {
                    layoutParams.rightMargin = iConvertDpToPixel;
                }
            }
            if (buttons.ButtonStyle.equals(Constants.COLLATION_STANDARD)) {
                layoutParams.weight = 1.0f;
                textView.setMinimumWidth(convertDpToPixel(35.0f));
            }
        } else if (z) {
            layoutParams.width = -1;
        } else {
            layoutParams.weight = 1.0f;
        }
        if (fontTheme != null) {
            if (fontTheme.hasCustomTypeface()) {
                textView.setTypeface(getTypefaceForFontRes(fontTheme.getFontRes()));
            }
            textView.setTextSize(2, fontTheme.getSize());
        } else {
            textView.setTextSize(2, 18.0f);
        }
        textView.setLayoutParams(layoutParams);
        float f = buttons.ButtonStyle.equals("link") ? 0 : 16;
        textView.setPadding(convertDpToPixel(f), 27, convertDpToPixel(f), 27);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qualtrics.digital.QualtricsPopOverFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QualtricsPopOverFragment.this.mButtonPressListener != null) {
                    QualtricsPopOverFragment.this.mButtonPressListener.onCreativeButtonPressed(buttonOptions.Action);
                } else {
                    QualtricsPopOverFragment.this.getActivity().finish();
                }
            }
        });
        return textView;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
    }
}
