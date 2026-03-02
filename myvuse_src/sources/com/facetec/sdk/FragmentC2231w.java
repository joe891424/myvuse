package com.facetec.sdk;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facetec.sdk.w */
/* JADX INFO: loaded from: classes3.dex */
public final class FragmentC2231w extends Fragment implements View.OnTouchListener, TraceFieldInterface {

    /* JADX INFO: renamed from: B */
    protected EditText f3574B;

    /* JADX INFO: renamed from: C */
    private boolean f3575C = false;
    protected ScrollView Code;

    /* JADX INFO: renamed from: D */
    private TextView f3576D;

    /* JADX INFO: renamed from: F */
    private View f3577F;

    /* JADX INFO: renamed from: I */
    JSONObject f3578I;

    /* JADX INFO: renamed from: L */
    private View f3579L;

    /* JADX INFO: renamed from: S */
    private View f3580S;

    /* JADX INFO: renamed from: V */
    protected C2162bb f3581V;

    /* JADX INFO: renamed from: Z */
    protected LinearLayout f3582Z;
    public Trace _nr_trace;

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

    /* JADX INFO: renamed from: V */
    static FragmentC2231w m2299V(JSONObject jSONObject) {
        FragmentC2231w fragmentC2231w = new FragmentC2231w();
        Bundle bundle = new Bundle();
        bundle.putString("ocrDataJSONString", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        fragmentC2231w.setArguments(bundle);
        return fragmentC2231w;
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        TraceMachine.startTracing("w");
        try {
            TraceMachine.enterMethod(this._nr_trace, "w#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "w#onCreate", null);
        }
        super.onCreate(bundle);
        TraceMachine.exitMethod();
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "w#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "w#onCreateView", null);
        }
        View viewInflate = layoutInflater.inflate(C2130R.layout.facetec_ocr_confirmation_fragment, viewGroup, false);
        this.f3577F = viewInflate;
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // android.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        String string;
        super.onViewCreated(view, bundle);
        Activity activity = getActivity();
        try {
            if (getArguments() != null && (string = getArguments().getString("ocrDataJSONString")) != null) {
                this.f3578I = new JSONObject(string);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.f3579L = view.findViewById(C2130R.id.backgroundView);
        this.f3581V = (C2162bb) view.findViewById(C2130R.id.confirmButton);
        this.Code = (ScrollView) view.findViewById(C2130R.id.mainContentScrollView);
        this.f3582Z = (LinearLayout) view.findViewById(C2130R.id.scrollableContentLayout);
        this.f3576D = (TextView) view.findViewById(C2130R.id.mainHeaderTextView);
        this.f3580S = view.findViewById(C2130R.id.mainHeaderDividerLineView);
        float fM1644I = C2156av.m1644I();
        float fCode = C2156av.Code();
        float f = fM1644I * fCode;
        int iM1675V = C2156av.m1675V();
        int iRound = Math.round(C2156av.f2653n * f);
        Typeface typeface = FaceTecSDK.f2235I.f2217V.mainHeaderFont;
        int iM1647I = C2156av.m1647I(activity, C2156av.m1730ah());
        int iRound2 = Math.round(C2188cb.m1993V(C2156av.m1756e()));
        int iMax = Math.max(iRound2 == 0 ? 0 : 1, Math.round(iRound2 * fCode));
        int iM1647I2 = C2156av.m1647I(activity, C2156av.m1733ak());
        C2157aw.Code(this.f3576D, C2130R.string.FaceTec_idscan_ocr_confirmation_main_header);
        this.f3576D.setTextColor(iM1647I);
        this.f3576D.setTypeface(typeface);
        this.f3576D.setTextSize(iRound);
        ((LinearLayout.LayoutParams) this.f3576D.getLayoutParams()).setMargins(0, 0, 0, iM1675V);
        this.f3580S.getLayoutParams().height = iMax;
        ((LinearLayout.LayoutParams) this.f3580S.getLayoutParams()).setMargins(iM1675V, 0, iM1675V, 0);
        this.f3580S.setBackgroundColor(iM1647I2);
        int iRound3 = Math.round(C2188cb.m1993V(C2156av.f2635I) * f);
        ((RelativeLayout.LayoutParams) this.f3581V.getLayoutParams()).setMargins(iM1675V, 0, iM1675V, iM1675V);
        this.f3581V.getLayoutParams().height = iRound3;
        C2157aw.Code(this.f3581V, C2130R.string.FaceTec_action_confirm);
        this.f3581V.setEnabled(true);
        this.f3581V.setupButtonForOCRConfirmation();
        this.f3581V.setOnClickListenerRunnable(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.w.3
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            final void Code() {
                FragmentC2231w.this.f3581V.setEnabled(false, true);
                final FragmentC2231w fragmentC2231w = FragmentC2231w.this;
                final AbstractRunnableC2150ap abstractRunnableC2150ap = new AbstractRunnableC2150ap(FragmentC2231w.this) { // from class: com.facetec.sdk.w.3.2
                    @Override // com.facetec.sdk.AbstractRunnableC2150ap
                    public final void Code() {
                        AbstractActivityC2219g abstractActivityC2219g = (AbstractActivityC2219g) FragmentC2231w.this.getActivity();
                        if (abstractActivityC2219g != null) {
                            abstractActivityC2219g.Code(FragmentC2231w.this.f3578I);
                        }
                    }
                };
                fragmentC2231w.getActivity().runOnUiThread(new AbstractRunnableC2150ap(fragmentC2231w) { // from class: com.facetec.sdk.w.5
                    @Override // com.facetec.sdk.AbstractRunnableC2150ap
                    final void Code() {
                        FragmentC2231w.this.f3581V.animate().alpha(0.0f).setDuration(500L).setListener(null).start();
                        FragmentC2231w.this.Code.animate().alpha(0.0f).setDuration(500L).setListener(null).withEndAction(new AbstractRunnableC2150ap(FragmentC2231w.this) { // from class: com.facetec.sdk.w.5.5
                            @Override // com.facetec.sdk.AbstractRunnableC2150ap
                            final void Code() {
                                if (abstractRunnableC2150ap != null) {
                                    abstractRunnableC2150ap.Code();
                                }
                            }
                        }).start();
                    }
                });
            }
        });
        ((RelativeLayout.LayoutParams) this.Code.getLayoutParams()).setMargins(0, iM1675V, 0, (iM1675V << 1) + iRound3);
        C2156av.m1681V(this.f3579L);
        this.f3579L.getBackground().setAlpha(C2156av.m1699aC());
        Drawable drawable = ContextCompat.getDrawable(activity, C2130R.drawable.facetec_scrollbar_vertical_track);
        Drawable drawable2 = ContextCompat.getDrawable(activity, C2130R.drawable.facetec_scrollbar_vertical_thumb);
        int iM1620B = C2156av.m1620B(iM1647I, 128);
        int iRound4 = Math.round(C2188cb.m1993V(10) * f);
        int iRound5 = Math.round(C2188cb.m1993V(5) * f);
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        gradientDrawable.setColor(0);
        GradientDrawable gradientDrawable2 = (GradientDrawable) drawable2;
        gradientDrawable2.setColor(iM1620B);
        float f2 = iRound5;
        gradientDrawable.setCornerRadius(f2);
        gradientDrawable2.setCornerRadius(f2);
        this.f3582Z.setScrollBarSize(iRound4);
        if (Build.VERSION.SDK_INT >= 29) {
            this.f3582Z.setVerticalScrollbarTrackDrawable(drawable);
            this.f3582Z.setVerticalScrollbarThumbDrawable(drawable2);
        }
        this.f3582Z.setOnTouchListener(this);
        final JSONObject jSONObject = this.f3578I;
        final Activity activity2 = getActivity();
        getActivity().runOnUiThread(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.w.1
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            public final void Code() {
                JSONArray jSONArrayOptJSONArray;
                String str;
                String str2;
                String str3;
                JSONArray jSONArray;
                int i;
                final int i2;
                int i3;
                Typeface typeface2;
                int i4;
                LayerDrawable layerDrawable;
                int i5;
                Typeface typeface3;
                int i6;
                int i7;
                int i8;
                String str4;
                String str5;
                int i9;
                int i10;
                Typeface typeface4;
                LayerDrawable layerDrawable2;
                int i11;
                int i12;
                int i13;
                String str6 = "uiFieldDescriptionText";
                String str7 = "fieldFriendlyName";
                String str8 = "groupFriendlyName";
                float fM1644I2 = C2156av.m1644I();
                float fCode2 = C2156av.Code();
                float f3 = fM1644I2 * fCode2;
                int iM1675V2 = C2156av.m1675V();
                int iRound6 = Math.round(C2188cb.m1993V(C2156av.f2634F) * f3);
                int iRound7 = Math.round(C2188cb.m1993V(OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SHOW_BANNER_CALLED) * f3);
                int iRound8 = Math.round(C2156av.f2650k * f3);
                int iRound9 = Math.round(C2156av.f2651l * f3);
                Typeface typeface5 = FaceTecSDK.f2235I.f2217V.sectionHeaderFont;
                int iM1647I3 = C2156av.m1647I(activity2, C2156av.m1734al());
                Typeface typeface6 = FaceTecSDK.f2235I.f2217V.fieldLabelFont;
                int iM1647I4 = C2156av.m1647I(activity2, C2156av.m1731ai());
                FaceTecCustomization faceTecCustomization = FaceTecSDK.f2235I;
                C2156av.m1647I(activity2, C2156av.m1732aj());
                Typeface typeface7 = FaceTecSDK.f2235I.f2217V.inputFieldFont;
                int iM1647I5 = C2156av.m1647I(activity2, C2156av.m1738ap());
                FaceTecCustomization faceTecCustomization2 = FaceTecSDK.f2235I;
                Context context = activity2;
                int i14 = iM1647I5;
                int iM1647I6 = C2156av.m1647I(context, C2156av.Code(context));
                int iRound10 = Math.round(C2188cb.m1993V(C2156av.m1754d()));
                int i15 = iM1647I6;
                int iMax2 = Math.max(iRound10 == 0 ? 0 : 1, Math.round(iRound10 * fCode2));
                int iRound11 = Math.round(C2188cb.m1993V(C2156av.m1777t()));
                int i16 = iRound6;
                int iMax3 = Math.max(iRound11 == 0 ? 0 : 1, Math.round(iRound11 * fCode2));
                int iM1647I7 = C2156av.m1647I(activity2, C2156av.m1735am());
                Typeface typeface8 = typeface6;
                int iM1647I8 = C2156av.m1647I(activity2, C2156av.m1736an());
                int i17 = iM1647I4;
                LayerDrawable layerDrawable3 = (LayerDrawable) ContextCompat.getDrawable(activity2, C2130R.drawable.facetec_ocr_input_background);
                if (layerDrawable3 != null) {
                    GradientDrawable gradientDrawable3 = (GradientDrawable) layerDrawable3.findDrawableByLayerId(C2130R.id.gradientDrawable);
                    gradientDrawable3.setStroke(iMax2, iM1647I7);
                    gradientDrawable3.setCornerRadius(iMax3);
                    gradientDrawable3.setColor(iM1647I8);
                    if (FaceTecSDK.f2235I.f2217V.showInputFieldBottomBorderOnly) {
                        int i18 = -iMax2;
                        layerDrawable3.setLayerInset(0, i18, i18, i18, 0);
                        gradientDrawable3.setCornerRadius(0.0f);
                    }
                }
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("groups");
                    if (jSONArrayOptJSONArray2 == null) {
                        return;
                    }
                    int i19 = 0;
                    while (i19 < jSONArrayOptJSONArray2.length()) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i19);
                        if (jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("fields")) == null) {
                            return;
                        }
                        if (jSONArrayOptJSONArray.length() > 0) {
                            jSONArray = jSONArrayOptJSONArray2;
                            String strOptString = jSONObjectOptJSONObject.optString("groupKey");
                            i2 = i19;
                            LayerDrawable layerDrawable4 = layerDrawable3;
                            String strM2301Z = FragmentC2231w.this.m2301Z(strOptString, null, str8, jSONObjectOptJSONObject.optString(str8));
                            TextView textView = new TextView(activity2);
                            str3 = str8;
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.setMargins(iM1675V2, iM1675V2, iM1675V2, Math.round(iM1675V2 / 2.0f));
                            layoutParams.gravity = 17;
                            textView.setLayoutParams(layoutParams);
                            textView.setTextSize(iRound8);
                            textView.setText(strM2301Z);
                            textView.setTextColor(iM1647I3);
                            textView.setTypeface(typeface5);
                            FragmentC2231w.this.f3582Z.addView(textView);
                            int i20 = 0;
                            int i21 = 0;
                            while (i20 < jSONArrayOptJSONArray.length()) {
                                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i20);
                                int i22 = iRound8;
                                String strOptString2 = jSONObject2.optString("fieldKey");
                                Typeface typeface9 = typeface5;
                                int i23 = iM1647I3;
                                String strM2301Z2 = FragmentC2231w.this.m2301Z(strOptString, strOptString2, str7, jSONObject2.optString(str7));
                                String str9 = str7;
                                String strM2301Z3 = FragmentC2231w.this.m2301Z(strOptString, strOptString2, str6, jSONObject2.optString(str6));
                                String upperCase = jSONObject2.optString("scannedValue").toUpperCase(FragmentC2231w.this.getResources().getConfiguration().locale);
                                if (jSONObject2.optBoolean("uiEditable")) {
                                    LinearLayout linearLayout = new LinearLayout(activity2);
                                    linearLayout.setOrientation(0);
                                    str4 = str6;
                                    str5 = strOptString;
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                                    layoutParams2.setMargins(iM1675V2, iM1675V2 / 4, iM1675V2, iM1675V2 / 4);
                                    linearLayout.setLayoutParams(layoutParams2);
                                    TextView textView2 = new TextView(activity2);
                                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(iRound7, -2);
                                    layoutParams3.setMargins(0, 0, 0, 0);
                                    layoutParams3.setMarginEnd(iM1675V2 / 2);
                                    textView2.setLayoutParams(layoutParams3);
                                    float f4 = iRound9;
                                    textView2.setTextSize(f4);
                                    textView2.setText(strM2301Z2);
                                    int i24 = i17;
                                    textView2.setTextColor(i24);
                                    typeface4 = typeface8;
                                    textView2.setTypeface(typeface4);
                                    i11 = iRound7;
                                    textView2.setMaxLines(1);
                                    textView2.setSingleLine(true);
                                    textView2.setEllipsize(TextUtils.TruncateAt.END);
                                    textView2.setTextDirection(5);
                                    arrayList.add(textView2);
                                    linearLayout.addView(textView2);
                                    final EditText editText = new EditText(activity2);
                                    int i25 = iM1675V2 / 4;
                                    i9 = iM1675V2;
                                    int i26 = i25 << 1;
                                    editText.setPadding(i25, i26, i25, i26);
                                    i12 = i16;
                                    i13 = i24;
                                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, i12);
                                    layoutParams4.setMargins(0, 0, 0, 0);
                                    editText.setLayoutParams(layoutParams4);
                                    int i27 = i14;
                                    editText.setTextColor(i27);
                                    editText.setTextSize(f4);
                                    int i28 = i15;
                                    editText.setHintTextColor(i28);
                                    editText.setText(upperCase);
                                    editText.setHint(strM2301Z3);
                                    Typeface typeface10 = typeface7;
                                    editText.setTypeface(typeface10);
                                    layerDrawable2 = layerDrawable4;
                                    editText.setBackground(layerDrawable2);
                                    editText.setTextDirection(5);
                                    InputFilter[] filters = editText.getFilters();
                                    typeface7 = typeface10;
                                    InputFilter[] inputFilterArr = new InputFilter[filters.length + 1];
                                    i15 = i28;
                                    i10 = i27;
                                    System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
                                    inputFilterArr[filters.length] = new InputFilter.AllCaps();
                                    editText.setFilters(inputFilterArr);
                                    editText.setInputType(4096);
                                    editText.setImeOptions(6);
                                    final FragmentC2231w fragmentC2231w = FragmentC2231w.this;
                                    final Typeface typeface11 = FaceTecSDK.f2235I.f2217V.inputFieldFont;
                                    final Typeface typeface12 = FaceTecSDK.f2235I.f2217V.inputFieldPlaceholderFont;
                                    final boolean z = typeface11 != typeface12;
                                    final int i29 = i20;
                                    editText.addTextChangedListener(new TextWatcher() { // from class: com.facetec.sdk.w.2
                                        @Override // android.text.TextWatcher
                                        public final void afterTextChanged(Editable editable) {
                                        }

                                        @Override // android.text.TextWatcher
                                        public final void beforeTextChanged(CharSequence charSequence, int i30, int i31, int i32) {
                                        }

                                        @Override // android.text.TextWatcher
                                        public final void onTextChanged(CharSequence charSequence, int i30, int i31, int i32) {
                                            if (z) {
                                                if (charSequence.length() == 0) {
                                                    editText.setTypeface(typeface12);
                                                } else {
                                                    Typeface typeface13 = editText.getTypeface();
                                                    Typeface typeface14 = typeface11;
                                                    if (typeface13 != typeface14) {
                                                        editText.setTypeface(typeface14);
                                                    }
                                                }
                                            }
                                            try {
                                                FragmentC2231w.this.f3578I.optJSONArray("groups").optJSONObject(i2).optJSONArray("fields").optJSONObject(i29).putOpt("userUpdatedValue", charSequence.toString());
                                            } catch (JSONException e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    });
                                    final FragmentC2231w fragmentC2231w2 = FragmentC2231w.this;
                                    editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.facetec.sdk.w.9
                                        @Override // android.view.View.OnFocusChangeListener
                                        public final void onFocusChange(View view2, boolean z2) {
                                            EditText editText2 = editText;
                                            if (editText2 == null) {
                                                return;
                                            }
                                            if (z2) {
                                                FragmentC2231w.this.f3574B = editText2;
                                                editText.setCursorVisible(true);
                                            } else {
                                                FragmentC2231w.this.f3574B = null;
                                                editText.setCursorVisible(false);
                                            }
                                        }
                                    });
                                    final FragmentC2231w fragmentC2231w3 = FragmentC2231w.this;
                                    editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.facetec.sdk.w.6
                                        @Override // android.widget.TextView.OnEditorActionListener
                                        public final boolean onEditorAction(TextView textView3, int i30, KeyEvent keyEvent) {
                                            EditText editText2 = editText;
                                            if (editText2 == null) {
                                                return false;
                                            }
                                            editText2.setCursorVisible(false);
                                            if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                                                FragmentC2231w.this.m2303Z(textView3);
                                            }
                                            return false;
                                        }
                                    });
                                    linearLayout.addView(editText);
                                    FragmentC2231w.this.f3582Z.addView(linearLayout);
                                    i21++;
                                } else {
                                    str4 = str6;
                                    str5 = strOptString;
                                    i9 = iM1675V2;
                                    i10 = i14;
                                    typeface4 = typeface8;
                                    layerDrawable2 = layerDrawable4;
                                    i11 = iRound7;
                                    i12 = i16;
                                    i13 = i17;
                                }
                                i20++;
                                layerDrawable4 = layerDrawable2;
                                i14 = i10;
                                i17 = i13;
                                iRound8 = i22;
                                typeface5 = typeface9;
                                iM1647I3 = i23;
                                str7 = str9;
                                str6 = str4;
                                strOptString = str5;
                                iM1675V2 = i9;
                                i16 = i12;
                                iRound7 = i11;
                                typeface8 = typeface4;
                            }
                            str = str6;
                            str2 = str7;
                            i = iM1675V2;
                            i3 = iRound8;
                            typeface2 = typeface5;
                            i4 = iM1647I3;
                            i5 = i14;
                            typeface3 = typeface8;
                            layerDrawable = layerDrawable4;
                            i6 = iRound7;
                            i7 = i16;
                            i8 = i17;
                            if (i21 == 0) {
                                FragmentC2231w.this.f3582Z.removeView(textView);
                            }
                        } else {
                            str = str6;
                            str2 = str7;
                            str3 = str8;
                            jSONArray = jSONArrayOptJSONArray2;
                            i = iM1675V2;
                            i2 = i19;
                            i3 = iRound8;
                            typeface2 = typeface5;
                            i4 = iM1647I3;
                            layerDrawable = layerDrawable3;
                            i5 = i14;
                            typeface3 = typeface8;
                            i6 = iRound7;
                            i7 = i16;
                            i8 = i17;
                        }
                        i19 = i2 + 1;
                        i14 = i5;
                        i17 = i8;
                        jSONArrayOptJSONArray2 = jSONArray;
                        str8 = str3;
                        typeface5 = typeface2;
                        iM1647I3 = i4;
                        str7 = str2;
                        str6 = str;
                        iM1675V2 = i;
                        i16 = i7;
                        iRound7 = i6;
                        typeface8 = typeface3;
                        layerDrawable3 = layerDrawable;
                        iRound8 = i3;
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                int iRound12 = Math.round(C2188cb.m1986B(iRound9));
                int iRound13 = Math.round(C2188cb.m1993V(120) * f3);
                int iMax4 = 0;
                for (int i30 = 0; i30 < arrayList.size(); i30++) {
                    iMax4 = Math.max(iMax4, C2188cb.m1991I(((TextView) arrayList.get(i30)).getText().toString(), iRound12, FaceTecSDK.f2235I.f2217V.fieldLabelFont).Code());
                }
                int iMin = Math.min(iRound13, iMax4);
                for (int i31 = 0; i31 < arrayList.size(); i31++) {
                    ((TextView) arrayList.get(i31)).getLayoutParams().width = iMin;
                }
            }
        });
        getActivity().runOnUiThread(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.w.4
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            final void Code() {
                FragmentC2231w.this.f3581V.animate().alpha(1.0f).setDuration(500L).setStartDelay(1000L).setListener(null).start();
                FragmentC2231w.this.Code.animate().alpha(1.0f).setDuration(500L).setStartDelay(1000L).setListener(null).start();
            }
        });
    }

    /* JADX INFO: renamed from: Z */
    private void m2302Z(String str) {
        if (this.f3575C) {
            return;
        }
        C2131S.m1431V(str);
    }

    /* JADX INFO: renamed from: B */
    private static String m2298B(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String m2301Z(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instruction units count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.FragmentC2231w.m2301Z(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX INFO: renamed from: Z */
    public final void m2303Z(View view) {
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        if (motionEvent.getAction() == 0 && (editText = this.f3574B) != null && editText.isFocused()) {
            Rect rect = new Rect();
            this.f3574B.getGlobalVisibleRect(rect);
            if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                this.f3574B.clearFocus();
                m2303Z(view);
            }
        }
        return false;
    }
}
