package com.facetec.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.facetec.sdk.FaceTecCancelButtonCustomization;
import com.facetec.sdk.FaceTecSDK;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: renamed from: com.facetec.sdk.av */
/* JADX INFO: loaded from: classes3.dex */
final class C2156av {

    /* JADX INFO: renamed from: B */
    static int f2631B = 15;

    /* JADX INFO: renamed from: C */
    static int f2632C = 130;
    static float Code = 1.1f;

    /* JADX INFO: renamed from: D */
    static int f2633D = 80;

    /* JADX INFO: renamed from: F */
    static int f2634F = 30;

    /* JADX INFO: renamed from: I */
    static int f2635I = 50;

    /* JADX INFO: renamed from: L */
    static int f2636L = -55;

    /* JADX INFO: renamed from: S */
    static int f2637S = 10;

    /* JADX INFO: renamed from: V */
    static int f2638V = 78;

    /* JADX INFO: renamed from: Z */
    static int f2639Z = 35;

    /* JADX INFO: renamed from: a */
    static int f2640a = 20;

    /* JADX INFO: renamed from: b */
    static int f2641b = 20;

    /* JADX INFO: renamed from: c */
    static int f2642c = 28;

    /* JADX INFO: renamed from: d */
    static int f2643d = 28;

    /* JADX INFO: renamed from: e */
    static int f2644e = 28;

    /* JADX INFO: renamed from: f */
    static int f2645f = 20;

    /* JADX INFO: renamed from: g */
    static int f2646g = 20;

    /* JADX INFO: renamed from: h */
    static int f2647h = 24;

    /* JADX INFO: renamed from: i */
    static int f2648i = 16;

    /* JADX INFO: renamed from: j */
    static int f2649j = 20;

    /* JADX INFO: renamed from: k */
    static int f2650k = 16;

    /* JADX INFO: renamed from: l */
    static int f2651l = 12;

    /* JADX INFO: renamed from: m */
    private static int f2652m = 28;

    /* JADX INFO: renamed from: n */
    static int f2653n = 20;

    /* JADX INFO: renamed from: com.facetec.sdk.av$B */
    enum B {
        COLOR,
        RESOURCE
    }

    /* JADX INFO: renamed from: C */
    static int m1631C() {
        return 10;
    }

    /* JADX INFO: renamed from: D */
    static int m1634D() {
        return -1;
    }

    /* JADX INFO: renamed from: aC */
    static int m1699aC() {
        return 255;
    }

    C2156av() {
    }

    /* JADX INFO: renamed from: aY */
    private static FaceTecCustomization m1721aY() {
        if (FaceTecSDK.m1408Z()) {
            return FaceTecSDK.f2234B;
        }
        if (FaceTecSDK.m1405I()) {
            return FaceTecSDK.Code;
        }
        return FaceTecSDK.f2235I;
    }

    /* JADX INFO: renamed from: Z */
    static void m1691Z() {
        FaceTecCustomization faceTecCustomization = FaceTecSDK.f2235I;
        if (faceTecCustomization.f2221c.progressRadialOffset == -1) {
            faceTecCustomization.f2221c.progressRadialOffset = m1764i() + m1762h();
        }
        FaceTecSDK.f2235I = faceTecCustomization;
    }

    /* JADX INFO: renamed from: I */
    static float m1644I() {
        return (Resources.getSystem().getDisplayMetrics().widthPixels / C2188cb.m1993V(340)) * (C2221j.m2231F() / 1.7777778f);
    }

    static float Code() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float f = displayMetrics.widthPixels;
        float f2 = displayMetrics.heightPixels;
        float f3 = ((double) C2221j.m2231F()) < 1.4d ? 0.94f : 0.88f;
        float f4 = f * f3;
        float f5 = displayMetrics.density * 340.0f;
        if (f4 > f5) {
            f3 = f5 / f;
            f4 = f5;
        }
        int identifier = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? Resources.getSystem().getDimensionPixelSize(identifier) : 0;
        int identifier2 = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
        int dimensionPixelSize2 = identifier2 > 0 ? Resources.getSystem().getDimensionPixelSize(identifier2) : 0;
        float fM2231F = C2221j.m2231F() * f4;
        float f6 = (((f2 - ((displayMetrics.density * 10.0f) * 3.0f)) - 10.0f) - dimensionPixelSize2) - dimensionPixelSize;
        return fM2231F > f6 ? f6 / (C2221j.m2231F() * f) : f3;
    }

    /* JADX INFO: renamed from: V */
    static int m1675V() {
        return Math.round(C2188cb.m1993V(f2631B) * m1644I() * Code());
    }

    /* JADX INFO: renamed from: B */
    static int m1619B() {
        return Math.round((f2652m + (C2157aw.m1784I(C2130R.string.FaceTec_idscan_type_selection_header).length() > 36 ? -4 : 0)) * m1644I() * Code());
    }

    /* JADX INFO: renamed from: L */
    static FaceTecSize m1660L() {
        return new FaceTecSize(Math.round(C2188cb.m1989I(Resources.getSystem().getDisplayMetrics().widthPixels) - ((f2637S << 1) * m1644I())), Math.round(m1644I() * 60.0f));
    }

    /* JADX INFO: renamed from: F */
    static int m1639F() {
        int i = FaceTecSDK.f2235I.f2212D.borderWidth == -1 ? 2 : FaceTecSDK.f2235I.f2212D.borderWidth;
        return Math.max(i == 0 ? 0 : 1, Math.round(i * m1644I()));
    }

    /* JADX INFO: renamed from: S */
    static int m1668S() {
        int i = FaceTecSDK.f2235I.f2215L.retryScreenImageBorderWidth == -1 ? 1 : FaceTecSDK.f2235I.f2215L.retryScreenImageBorderWidth;
        return Math.max(i == 0 ? 0 : 1, Math.round(i * m1644I()));
    }

    /* JADX INFO: renamed from: a */
    static int m1694a() {
        int i = FaceTecSDK.f2235I.f2215L.buttonBorderWidth == -1 ? 0 : FaceTecSDK.f2235I.f2215L.buttonBorderWidth;
        return Math.max(i != 0 ? 1 : 0, Math.round(i * m1644I()));
    }

    /* JADX INFO: renamed from: b */
    static int m1749b() {
        int i = FaceTecSDK.f2235I.f2214I.buttonBorderWidth == -1 ? 0 : FaceTecSDK.f2235I.f2214I.buttonBorderWidth;
        return Math.max(i != 0 ? 1 : 0, Math.round(i * m1644I()));
    }

    /* JADX INFO: renamed from: c */
    static int m1752c() {
        int i = FaceTecSDK.f2235I.f2217V.buttonBorderWidth == -1 ? 0 : FaceTecSDK.f2235I.f2217V.buttonBorderWidth;
        return Math.max(i != 0 ? 1 : 0, Math.round(i * m1644I()));
    }

    /* JADX INFO: renamed from: e */
    static int m1756e() {
        int i = FaceTecSDK.f2235I.f2217V.mainHeaderDividerLineWidth == -1 ? 2 : FaceTecSDK.f2235I.f2217V.mainHeaderDividerLineWidth;
        return Math.max(i == 0 ? 0 : 1, Math.round(i * m1644I()));
    }

    /* JADX INFO: renamed from: d */
    static int m1754d() {
        int i = FaceTecSDK.f2235I.f2217V.inputFieldBorderWidth == -1 ? 1 : FaceTecSDK.f2235I.f2217V.inputFieldBorderWidth;
        return Math.max(i == 0 ? 0 : 1, Math.round(i * m1644I()));
    }

    /* JADX INFO: renamed from: j */
    static int m1766j() {
        int i = FaceTecSDK.f2235I.f2214I.captureScreenTextBackgroundBorderWidth == -1 ? 0 : FaceTecSDK.f2235I.f2214I.captureScreenTextBackgroundBorderWidth;
        return Math.max(i != 0 ? 1 : 0, Math.round(i * m1644I()));
    }

    /* JADX INFO: renamed from: g */
    static int m1760g() {
        int i = FaceTecSDK.f2235I.f2214I.reviewScreenTextBackgroundBorderWidth == -1 ? 0 : FaceTecSDK.f2235I.f2214I.reviewScreenTextBackgroundBorderWidth;
        return Math.max(i != 0 ? 1 : 0, Math.round(i * m1644I()));
    }

    /* JADX INFO: renamed from: f */
    static int m1758f() {
        int i = FaceTecSDK.f2235I.f2214I.captureFrameStrokeWidth == -1 ? 2 : FaceTecSDK.f2235I.f2214I.captureFrameStrokeWidth;
        return Math.max(i == 0 ? 0 : 1, Math.round(i * m1644I()));
    }

    /* JADX INFO: renamed from: i */
    static int m1764i() {
        int i = FaceTecSDK.f2235I.f2221c.strokeWidth == -1 ? 6 : FaceTecSDK.f2235I.f2221c.strokeWidth;
        return Math.max(i == 0 ? 0 : 1, Math.round(i * m1644I()));
    }

    /* JADX INFO: renamed from: h */
    static int m1762h() {
        int i = FaceTecSDK.f2235I.f2221c.progressStrokeWidth == -1 ? 6 : FaceTecSDK.f2235I.f2221c.progressStrokeWidth;
        return Math.max(i == 0 ? 0 : 1, Math.round(i * m1644I()));
    }

    /* JADX INFO: renamed from: l */
    static int m1769l() {
        return Math.round((FaceTecSDK.f2235I.f2212D.cornerRadius == -1 ? 20 : FaceTecSDK.f2235I.f2212D.cornerRadius) * m1644I());
    }

    /* JADX INFO: renamed from: m */
    static int m1770m() {
        return Math.round((FaceTecSDK.f2235I.f2215L.readyScreenTextBackgroundCornerRadius == -1 ? 6 : FaceTecSDK.f2235I.f2215L.readyScreenTextBackgroundCornerRadius) * m1644I());
    }

    /* JADX INFO: renamed from: o */
    static int m1772o() {
        return Math.round((FaceTecSDK.f2235I.f2215L.retryScreenImageCornerRadius == -1 ? 10 : FaceTecSDK.f2235I.f2215L.retryScreenImageCornerRadius) * m1644I());
    }

    /* JADX INFO: renamed from: n */
    static int m1771n() {
        return Math.round((FaceTecSDK.f2235I.f2214I.captureScreenTextBackgroundCornerRadius == -1 ? 6 : FaceTecSDK.f2235I.f2214I.captureScreenTextBackgroundCornerRadius) * m1644I());
    }

    /* JADX INFO: renamed from: k */
    static int m1768k() {
        return Math.round((FaceTecSDK.f2235I.f2214I.reviewScreenTextBackgroundCornerRadius == -1 ? 6 : FaceTecSDK.f2235I.f2214I.reviewScreenTextBackgroundCornerRadius) * m1644I());
    }

    /* JADX INFO: renamed from: p */
    static int m1773p() {
        return Math.round((FaceTecSDK.f2235I.f2215L.buttonCornerRadius == -1 ? 8 : FaceTecSDK.f2235I.f2215L.buttonCornerRadius) * m1644I());
    }

    /* JADX INFO: renamed from: r */
    static int m1775r() {
        return Math.round((FaceTecSDK.f2235I.f2214I.buttonCornerRadius == -1 ? 8 : FaceTecSDK.f2235I.f2214I.buttonCornerRadius) * m1644I());
    }

    /* JADX INFO: renamed from: q */
    static int m1774q() {
        return Math.round((FaceTecSDK.f2235I.f2217V.buttonCornerRadius == -1 ? 8 : FaceTecSDK.f2235I.f2217V.buttonCornerRadius) * m1644I());
    }

    /* JADX INFO: renamed from: t */
    static int m1777t() {
        return Math.round((FaceTecSDK.f2235I.f2217V.inputFieldCornerRadius == -1 ? 3 : FaceTecSDK.f2235I.f2217V.inputFieldCornerRadius) * m1644I());
    }

    /* JADX INFO: renamed from: s */
    static int m1776s() {
        return Math.round((FaceTecSDK.f2235I.f2214I.captureFrameCornerRadius == -1 ? 12 : FaceTecSDK.f2235I.f2214I.captureFrameCornerRadius) * m1644I());
    }

    /* JADX INFO: renamed from: x */
    static Typeface m1781x() {
        Typeface typeface = FaceTecSDK.f2235I.f2215L.readyScreenHeaderFont;
        return typeface == null ? FaceTecSDK.f2235I.f2215L.headerFont : typeface;
    }

    /* JADX INFO: renamed from: w */
    static Typeface m1780w() {
        Typeface typeface = FaceTecSDK.f2235I.f2215L.readyScreenSubtextFont;
        return typeface == null ? FaceTecSDK.f2235I.f2215L.subtextFont : typeface;
    }

    /* JADX INFO: renamed from: u */
    static Typeface m1778u() {
        Typeface typeface = FaceTecSDK.f2235I.f2215L.retryScreenHeaderFont;
        return typeface == null ? FaceTecSDK.f2235I.f2215L.headerFont : typeface;
    }

    /* JADX INFO: renamed from: y */
    static Typeface m1782y() {
        Typeface typeface = FaceTecSDK.f2235I.f2215L.retryScreenSubtextFont;
        return typeface == null ? FaceTecSDK.f2235I.f2215L.subtextFont : typeface;
    }

    /* JADX INFO: renamed from: I */
    static FaceTecCustomization m1649I(FaceTecCustomization faceTecCustomization) {
        Typeface typeface = Typeface.DEFAULT_BOLD;
        Typeface typeface2 = Typeface.DEFAULT;
        if (faceTecCustomization.f2216S.textFont == null) {
            faceTecCustomization.f2216S.textFont = typeface2;
        }
        if (faceTecCustomization.f2215L.headerFont == null) {
            faceTecCustomization.f2215L.headerFont = typeface;
        }
        if (faceTecCustomization.f2215L.subtextFont == null) {
            faceTecCustomization.f2215L.subtextFont = typeface2;
        }
        if (faceTecCustomization.f2215L.buttonFont == null) {
            faceTecCustomization.f2215L.buttonFont = typeface2;
        }
        if (faceTecCustomization.f2213F.messageFont == null) {
            faceTecCustomization.f2213F.messageFont = typeface2;
        }
        if (faceTecCustomization.f2214I.headerFont == null) {
            faceTecCustomization.f2214I.headerFont = typeface;
        }
        if (faceTecCustomization.f2214I.subtextFont == null) {
            faceTecCustomization.f2214I.subtextFont = typeface2;
        }
        if (faceTecCustomization.f2214I.buttonFont == null) {
            faceTecCustomization.f2214I.buttonFont = typeface2;
        }
        if (faceTecCustomization.f2214I.captureScreenFocusMessageFont == null) {
            faceTecCustomization.f2214I.captureScreenFocusMessageFont = typeface2;
        }
        if (faceTecCustomization.f2217V.buttonFont == null) {
            faceTecCustomization.f2217V.buttonFont = typeface2;
        }
        if (faceTecCustomization.f2217V.mainHeaderFont == null) {
            faceTecCustomization.f2217V.mainHeaderFont = typeface;
        }
        if (faceTecCustomization.f2217V.sectionHeaderFont == null) {
            faceTecCustomization.f2217V.sectionHeaderFont = typeface;
        }
        if (faceTecCustomization.f2217V.fieldLabelFont == null) {
            faceTecCustomization.f2217V.fieldLabelFont = typeface2;
        }
        if (faceTecCustomization.f2217V.fieldValueFont == null) {
            faceTecCustomization.f2217V.fieldValueFont = typeface2;
        }
        if (faceTecCustomization.f2217V.inputFieldFont == null) {
            faceTecCustomization.f2217V.inputFieldFont = faceTecCustomization.f2217V.fieldValueFont;
        }
        if (faceTecCustomization.f2217V.inputFieldPlaceholderFont == null) {
            faceTecCustomization.f2217V.inputFieldPlaceholderFont = faceTecCustomization.f2217V.inputFieldFont;
        }
        return faceTecCustomization;
    }

    private static B Code(Context context, int i) {
        try {
            context.getResources().getValue(i, new TypedValue(), true);
            return B.RESOURCE;
        } catch (Exception unused) {
            return B.COLOR;
        }
    }

    /* JADX INFO: renamed from: I */
    static int m1647I(Context context, int i) {
        if (AnonymousClass4.f2656V[Code(context, i).ordinal()] != 1) {
            return i;
        }
        try {
            return ContextCompat.getColor(context, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    /* JADX INFO: renamed from: I */
    private static int m1645I(int i) {
        if (FaceTecSDK.f2236Z == FaceTecSDK.EnumC2125B.LOW_LIGHT) {
            return -1;
        }
        if (FaceTecSDK.f2236Z == FaceTecSDK.EnumC2125B.BRIGHT_LIGHT) {
            return -16777216;
        }
        return i;
    }

    /* JADX INFO: renamed from: v */
    static int m1779v() {
        return m1721aY().f2213F.foregroundColor;
    }

    /* JADX INFO: renamed from: H */
    static int m1643H() {
        return m1645I(FaceTecSDK.f2235I.f2215L.backgroundColors);
    }

    /* JADX INFO: renamed from: aW */
    private static int m1719aW() {
        return m1721aY().f2215L.foregroundColor;
    }

    /* JADX INFO: renamed from: bb */
    private static int m1751bb() {
        return m1645I(FaceTecSDK.f2235I.f2212D.backgroundColor);
    }

    /* JADX INFO: renamed from: A */
    static int m1618A() {
        return m1721aY().f2215L.readyScreenTextBackgroundColor;
    }

    /* JADX INFO: renamed from: z */
    static int m1783z() {
        return m1645I(FaceTecSDK.f2235I.f2211C.backgroundColor);
    }

    /* JADX INFO: renamed from: G */
    static int m1642G() {
        return m1721aY().f2213F.activityIndicatorColor;
    }

    /* JADX INFO: renamed from: E */
    static int m1638E() {
        return m1721aY().f2215L.buttonTextNormalColor;
    }

    /* JADX INFO: renamed from: M */
    static int m1662M() {
        return m1721aY().f2215L.buttonTextHighlightColor;
    }

    /* JADX INFO: renamed from: N */
    static int m1663N() {
        return m1721aY().f2215L.buttonTextDisabledColor;
    }

    /* JADX INFO: renamed from: J */
    static int m1657J() {
        return m1721aY().f2215L.buttonBackgroundNormalColor;
    }

    /* JADX INFO: renamed from: K */
    static int m1658K() {
        return m1721aY().f2215L.buttonBackgroundHighlightColor;
    }

    /* JADX INFO: renamed from: O */
    static int m1664O() {
        return m1721aY().f2215L.buttonBackgroundDisabledColor;
    }

    /* JADX INFO: renamed from: R */
    static int m1667R() {
        return m1721aY().f2215L.buttonBorderColor;
    }

    /* JADX INFO: renamed from: T */
    static int m1673T() {
        return m1721aY().f2214I.buttonTextNormalColor;
    }

    /* JADX INFO: renamed from: Q */
    static int m1666Q() {
        return m1721aY().f2214I.buttonTextHighlightColor;
    }

    /* JADX INFO: renamed from: U */
    static int m1674U() {
        return m1721aY().f2214I.buttonTextDisabledColor;
    }

    /* JADX INFO: renamed from: P */
    static int m1665P() {
        return m1721aY().f2214I.buttonBackgroundNormalColor;
    }

    /* JADX INFO: renamed from: ab */
    static int m1724ab() {
        return m1721aY().f2214I.buttonBackgroundHighlightColor;
    }

    /* JADX INFO: renamed from: X */
    static int m1686X() {
        return m1721aY().f2214I.buttonBackgroundDisabledColor;
    }

    /* JADX INFO: renamed from: Y */
    static int m1687Y() {
        return m1721aY().f2214I.buttonBorderColor;
    }

    /* JADX INFO: renamed from: aa */
    static int m1723aa() {
        return m1721aY().f2217V.buttonTextNormalColor;
    }

    /* JADX INFO: renamed from: W */
    static int m1685W() {
        return m1721aY().f2217V.buttonTextHighlightColor;
    }

    /* JADX INFO: renamed from: af */
    static int m1728af() {
        return m1721aY().f2217V.buttonTextDisabledColor;
    }

    /* JADX INFO: renamed from: ag */
    static int m1729ag() {
        return m1721aY().f2217V.buttonBackgroundNormalColor;
    }

    /* JADX INFO: renamed from: ac */
    static int m1725ac() {
        return m1721aY().f2217V.buttonBackgroundHighlightColor;
    }

    /* JADX INFO: renamed from: ad */
    static int m1726ad() {
        return m1721aY().f2217V.buttonBackgroundDisabledColor;
    }

    /* JADX INFO: renamed from: ae */
    static int m1727ae() {
        return m1721aY().f2217V.buttonBorderColor;
    }

    /* JADX INFO: renamed from: ak */
    static int m1733ak() {
        return m1721aY().f2217V.mainHeaderDividerLineColor;
    }

    /* JADX INFO: renamed from: ah */
    static int m1730ah() {
        return m1721aY().f2217V.mainHeaderTextColor;
    }

    /* JADX INFO: renamed from: al */
    static int m1734al() {
        return m1721aY().f2217V.sectionHeaderTextColor;
    }

    /* JADX INFO: renamed from: ai */
    static int m1731ai() {
        return m1721aY().f2217V.fieldLabelTextColor;
    }

    /* JADX INFO: renamed from: aj */
    static int m1732aj() {
        return m1721aY().f2217V.fieldValueTextColor;
    }

    /* JADX INFO: renamed from: ap */
    static int m1738ap() {
        int i = m1721aY().f2217V.inputFieldTextColor;
        return i == 0 ? m1732aj() : i;
    }

    static int Code(Context context) {
        int i = m1721aY().f2217V.inputFieldPlaceholderTextColor;
        return i == 0 ? m1620B(m1647I(context, m1738ap()), 102) : i;
    }

    /* JADX INFO: renamed from: an */
    static int m1736an() {
        return m1721aY().f2217V.inputFieldBackgroundColor;
    }

    /* JADX INFO: renamed from: am */
    static int m1735am() {
        return m1721aY().f2217V.inputFieldBorderColor;
    }

    /* JADX INFO: renamed from: aq */
    static int m1739aq() {
        return m1721aY().f2214I.reviewScreenTextBackgroundColor;
    }

    /* JADX INFO: renamed from: ao */
    static int m1737ao() {
        return m1721aY().f2214I.reviewScreenTextBackgroundBorderColor;
    }

    /* JADX INFO: renamed from: av */
    static int m1744av() {
        return m1721aY().f2214I.captureScreenTextBackgroundColor;
    }

    /* JADX INFO: renamed from: at */
    static int m1742at() {
        return m1721aY().f2214I.captureScreenTextBackgroundBorderColor;
    }

    /* JADX INFO: renamed from: ar */
    static int m1740ar() {
        int i = m1721aY().f2211C.brandingImage;
        return i == 0 ? FaceTecSDK.f2235I.f2211C.brandingImage : i;
    }

    /* JADX INFO: renamed from: as */
    static int m1741as() {
        int i = m1721aY().f2214I.inactiveTorchButtonImage;
        return i == 0 ? FaceTecSDK.f2235I.f2214I.inactiveTorchButtonImage : i;
    }

    /* JADX INFO: renamed from: au */
    static int m1743au() {
        int i = m1721aY().f2214I.activeTorchButtonImage;
        return i == 0 ? FaceTecSDK.f2235I.f2214I.activeTorchButtonImage : i;
    }

    /* JADX INFO: renamed from: ax */
    static int m1746ax() {
        int i = m1721aY().f2214I.selectionScreenBrandingImage;
        return i == 0 ? FaceTecSDK.f2235I.f2214I.selectionScreenBrandingImage : i;
    }

    /* JADX INFO: renamed from: aw */
    static int m1745aw() {
        int i = m1721aY().f2214I.selectionScreenDocumentImage;
        return i == 0 ? FaceTecSDK.f2235I.f2214I.selectionScreenDocumentImage : i;
    }

    /* JADX INFO: renamed from: az */
    static int m1748az() {
        int i = m1721aY().f2222d.customImage;
        return i == 0 ? FaceTecSDK.f2235I.f2222d.customImage : i;
    }

    /* JADX INFO: renamed from: ay */
    static int m1747ay() {
        int i = m1721aY().f2213F.customActivityIndicatorImage;
        return i == 0 ? FaceTecSDK.f2235I.f2213F.customActivityIndicatorImage : i;
    }

    /* JADX INFO: renamed from: aA */
    static int m1697aA() {
        int i = m1721aY().f2213F.resultAnimationSuccessBackgroundImage;
        return i == 0 ? FaceTecSDK.f2235I.f2213F.resultAnimationSuccessBackgroundImage : i;
    }

    /* JADX INFO: renamed from: aB */
    static int m1698aB() {
        int i = m1721aY().f2213F.resultAnimationUnsuccessBackgroundImage;
        return i == 0 ? FaceTecSDK.f2235I.f2213F.resultAnimationUnsuccessBackgroundImage : i;
    }

    /* JADX INFO: renamed from: aE */
    static int[] m1701aE() {
        int[] iArr = m1721aY().f2215L.retryScreenSlideshowImages;
        return iArr.length == 0 ? FaceTecSDK.f2235I.f2215L.retryScreenSlideshowImages : iArr;
    }

    /* JADX INFO: renamed from: V */
    static int m1677V(Context context) {
        int i = m1721aY().f2215L.retryScreenIdealImage;
        if (i == 0) {
            i = FaceTecSDK.f2235I.f2215L.retryScreenIdealImage;
        }
        return i == 0 ? m1648I(context, "facetec_ideal_pose_image", C2130R.drawable.facetec_internal_ideal) : i;
    }

    /* JADX INFO: renamed from: Z */
    static int m1688Z(Context context) {
        int i = FaceTecSDK.f2235I.f2215L.cameraPermissionsScreenImage;
        return i == 0 ? m1648I(context, "facetec_camera", C2130R.drawable.facetec_internal_camera) : i;
    }

    /* JADX INFO: renamed from: I */
    static int m1648I(Context context, String str, int i) {
        int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        return identifier == 0 ? i : identifier;
    }

    static void Code(View view) {
        int iM1751bb = m1751bb();
        int i = AnonymousClass4.f2656V[Code(view.getContext(), iM1751bb).ordinal()];
        if (i == 1) {
            view.setBackgroundResource(iM1751bb);
        } else {
            if (i != 2) {
                return;
            }
            view.setBackgroundColor(iM1751bb);
        }
    }

    /* JADX INFO: renamed from: i */
    private static int m1765i(Context context) {
        return m1647I(context, m1719aW());
    }

    /* JADX INFO: renamed from: Z */
    static void m1693Z(TextView textView) {
        Context context = textView.getContext();
        int iM1719aW = m1719aW();
        int i = AnonymousClass4.f2656V[Code(context, iM1719aW).ordinal()];
        if (i == 1) {
            textView.setTextColor(ContextCompat.getColor(context, iM1719aW));
        } else {
            if (i != 2) {
                return;
            }
            textView.setTextColor(iM1719aW);
        }
    }

    /* JADX INFO: renamed from: B */
    static void m1629B(View view) {
        int iM1783z = m1783z();
        int i = AnonymousClass4.f2656V[Code(view.getContext(), iM1783z).ordinal()];
        if (i == 1) {
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(), iM1783z));
        } else if (i == 2) {
            view.setBackgroundColor(iM1783z);
        } else {
            view.setBackgroundColor(0);
        }
    }

    /* JADX INFO: renamed from: Z */
    static void m1692Z(View view) {
        int iM1643H = m1643H();
        int i = AnonymousClass4.f2656V[Code(view.getContext(), iM1643H).ordinal()];
        if (i == 1) {
            view.setBackgroundResource(iM1643H);
        } else if (i == 2) {
            view.setBackgroundColor(iM1643H);
        } else {
            view.setBackgroundColor(0);
        }
    }

    /* JADX INFO: renamed from: c */
    static int m1753c(Context context) {
        return m1620B(m1647I(context, m1751bb()), 255);
    }

    /* JADX INFO: renamed from: h */
    static Drawable m1763h(Context context) {
        int iM1643H = m1643H();
        if (AnonymousClass4.f2656V[Code(context, iM1643H).ordinal()] == 1) {
            if (ContextCompat.getDrawable(context, iM1643H) != null) {
                Drawable drawableMutate = ContextCompat.getDrawable(context, iM1643H).mutate();
                if (drawableMutate instanceof ShapeDrawable) {
                    ((ShapeDrawable) drawableMutate).getPaint().setAlpha(255);
                    return drawableMutate;
                }
                if (drawableMutate instanceof GradientDrawable) {
                    return m1622B(context, (GradientDrawable) drawableMutate);
                }
                if (drawableMutate instanceof ColorDrawable) {
                    drawableMutate.setAlpha(255);
                    return drawableMutate;
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(m1620B(ContextCompat.getColor(context, iM1643H), 255));
                return gradientDrawable;
            }
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(m1620B(iM1643H, 255));
        return gradientDrawable2;
    }

    /* JADX INFO: renamed from: B */
    private static GradientDrawable m1622B(Context context, GradientDrawable gradientDrawable) {
        int[] colors = gradientDrawable.getColors();
        if (colors != null) {
            for (int i = 0; i < colors.length; i++) {
                int i2 = AnonymousClass4.f2656V[Code(context, colors[i]).ordinal()];
                if (i2 == 1) {
                    colors[i] = m1620B(ContextCompat.getColor(context, colors[i]), 255);
                } else if (i2 == 2) {
                    colors[i] = m1620B(colors[i], 255);
                }
            }
        }
        gradientDrawable.setColors(colors);
        return gradientDrawable;
    }

    /* JADX INFO: renamed from: V */
    static int m1678V(Context context, int i) {
        int color;
        int i2 = AnonymousClass4.f2656V[Code(context, i).ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return 255;
            }
            return (i >> 24) & 255;
        }
        Drawable drawable = ContextCompat.getDrawable(context, i);
        if (drawable != null) {
            if (drawable instanceof ShapeDrawable) {
                return ((ShapeDrawable) drawable).getPaint().getAlpha();
            }
            if (drawable instanceof GradientDrawable) {
                int[] colors = ((GradientDrawable) drawable).getColors();
                if (colors == null) {
                    return 255;
                }
                int i3 = 0;
                for (int i4 = 0; i4 < colors.length; i4++) {
                    int i5 = AnonymousClass4.f2656V[Code(context, colors[i4]).ordinal()];
                    if (i5 == 1) {
                        color = ContextCompat.getColor(context, colors[i4]);
                    } else if (i5 == 2) {
                        color = colors[i4];
                    }
                    i3 += (color >> 24) & 255;
                }
                return i3 / colors.length;
            }
            if (drawable instanceof ColorDrawable) {
                return drawable.getAlpha();
            }
            return 255;
        }
        return 255 & (ContextCompat.getColor(context, i) >> 24);
    }

    private static void Code(View view, int i) {
        int i2 = AnonymousClass4.f2656V[Code(view.getContext(), i).ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            view.setBackgroundColor(m1620B(i, 255));
        } else {
            if (ContextCompat.getDrawable(view.getContext(), i) != null) {
                Drawable drawableMutate = ContextCompat.getDrawable(view.getContext(), i).mutate();
                if (drawableMutate instanceof ShapeDrawable) {
                    ((ShapeDrawable) drawableMutate).getPaint().setAlpha(255);
                } else if (drawableMutate instanceof GradientDrawable) {
                    drawableMutate = m1622B(view.getContext(), (GradientDrawable) drawableMutate);
                } else if (drawableMutate instanceof ColorDrawable) {
                    drawableMutate.setAlpha(255);
                }
                view.setBackground(drawableMutate);
                return;
            }
            view.setBackgroundColor(m1620B(ContextCompat.getColor(view.getContext(), i), 255));
        }
    }

    static void Code(TextView textView) {
        int iM1779v = m1779v();
        int i = AnonymousClass4.f2656V[Code(textView.getContext(), iM1779v).ordinal()];
        if (i == 1) {
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), iM1779v));
        } else {
            if (i != 2) {
                return;
            }
            textView.setTextColor(iM1779v);
        }
    }

    /* JADX INFO: renamed from: I */
    static void m1651I(Drawable drawable, int i) {
        if (drawable instanceof ShapeDrawable) {
            ((ShapeDrawable) drawable).getPaint().setColor(i);
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(i);
        } else if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable).setColor(i);
        }
    }

    /* JADX INFO: renamed from: B */
    static void m1628B(Drawable drawable, int i, int i2, double d) {
        if (drawable instanceof GradientDrawable) {
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            gradientDrawable.setStroke(i2, i);
            gradientDrawable.setCornerRadius((float) d);
        }
    }

    /* JADX INFO: renamed from: B */
    static void m1626B(Context context, TextView textView, Drawable drawable, int i) {
        int i2 = AnonymousClass4.f2656V[Code(textView.getContext(), i).ordinal()];
        if (i2 == 1) {
            if (drawable instanceof ShapeDrawable) {
                ((ShapeDrawable) drawable).getPaint().setColor(ContextCompat.getColor(context, i));
                return;
            } else if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setColor(ContextCompat.getColor(context, i));
                return;
            } else {
                if (drawable instanceof ColorDrawable) {
                    ((ColorDrawable) drawable).setColor(ContextCompat.getColor(context, i));
                    return;
                }
                return;
            }
        }
        if (i2 != 2) {
            return;
        }
        if (drawable instanceof ShapeDrawable) {
            ((ShapeDrawable) drawable).getPaint().setColor(i);
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(i);
        } else if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable).setColor(i);
        }
    }

    /* JADX INFO: renamed from: B */
    static void m1627B(Context context, TextView textView, Drawable drawable, int i, int i2, double d) {
        int i3 = AnonymousClass4.f2656V[Code(textView.getContext(), i).ordinal()];
        if (i3 == 1) {
            if (drawable instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) drawable;
                gradientDrawable.setStroke(i2, ContextCompat.getColor(context, i));
                gradientDrawable.setCornerRadius((float) d);
                return;
            }
            return;
        }
        if (i3 == 2 && (drawable instanceof GradientDrawable)) {
            GradientDrawable gradientDrawable2 = (GradientDrawable) drawable;
            gradientDrawable2.setStroke(i2, i);
            gradientDrawable2.setCornerRadius((float) d);
        }
    }

    /* JADX INFO: renamed from: I */
    static void m1653I(Button button, int i) {
        button.setTextColor(i);
    }

    /* JADX INFO: renamed from: B */
    static void m1625B(Context context, Drawable drawable, int i) {
        int i2 = AnonymousClass4.f2656V[Code(context, i).ordinal()];
        if (i2 == 1) {
            if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setColor(ContextCompat.getColor(context, i));
            }
        } else if (i2 == 2 && (drawable instanceof GradientDrawable)) {
            ((GradientDrawable) drawable).setColor(i);
        }
    }

    /* JADX INFO: renamed from: j */
    static GradientDrawable m1767j(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        int i = m1721aY().f2216S.backgroundColors;
        int i2 = AnonymousClass4.f2656V[Code(context, i).ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                gradientDrawable.setColor(i);
            }
        } else if (ContextCompat.getDrawable(context, i) instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(context, i);
        } else {
            gradientDrawable.setColor(ContextCompat.getColor(context, i));
        }
        if (gradientDrawable != null) {
            gradientDrawable.setCornerRadius(C2188cb.m1993V((int) (Math.round((FaceTecSDK.f2235I.f2216S.cornerRadius == -1 ? 3 : FaceTecSDK.f2235I.f2216S.cornerRadius) * m1644I()) * Code())));
        }
        return gradientDrawable;
    }

    /* JADX INFO: renamed from: V */
    public static int m1676V(int i, float f) {
        return Color.argb(Math.round(Color.alpha(i) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    /* JADX INFO: renamed from: B */
    public static int m1620B(int i, int i2) {
        return Color.argb(i2, Color.red(i), Color.green(i), Color.blue(i));
    }

    /* JADX INFO: renamed from: I */
    static void m1655I(TextView textView, String str) {
        textView.setText(Html.fromHtml(str.replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "<br/>"), 63));
    }

    static String Code(boolean z) {
        String strM1784I = FaceTecSDK.f2235I.f2215L.readyScreenHeaderAttributedString;
        if (!strM1784I.isEmpty() && strM1784I.contains(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
            strM1784I = strM1784I.substring(0, strM1784I.indexOf(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE));
        }
        if (strM1784I.isEmpty()) {
            strM1784I = C2157aw.m1784I(C2130R.string.FaceTec_instructions_header_ready_1);
            if (strM1784I.contains(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
                strM1784I = strM1784I.substring(0, strM1784I.indexOf(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE));
            }
        }
        return (!z || FaceTecSDK.f2235I.f2210B || strM1784I.length() <= 30) ? strM1784I : strM1784I.substring(0, 30);
    }

    /* JADX INFO: renamed from: I */
    static String m1650I(boolean z) {
        String strM1784I = FaceTecSDK.f2235I.f2215L.readyScreenHeaderAttributedString;
        if (!strM1784I.isEmpty() && strM1784I.contains(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
            strM1784I = strM1784I.substring(strM1784I.indexOf(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE) + 1);
        }
        if (strM1784I.isEmpty()) {
            strM1784I = C2157aw.m1784I(C2130R.string.FaceTec_instructions_header_ready_2);
            if (strM1784I.contains(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
                strM1784I = strM1784I.substring(strM1784I.indexOf(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE) + 1);
            }
        }
        return (!z || FaceTecSDK.f2235I.f2210B || strM1784I.length() <= 30) ? strM1784I : strM1784I.substring(0, 30);
    }

    /* JADX INFO: renamed from: V */
    static String m1680V(boolean z) {
        String strM1784I = FaceTecSDK.f2235I.f2215L.readyScreenSubtextAttributedString;
        if (!strM1784I.isEmpty() && strM1784I.contains(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
            strM1784I = strM1784I.substring(0, strM1784I.indexOf(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE));
        }
        if (strM1784I.isEmpty()) {
            strM1784I = C2157aw.m1784I(C2130R.string.FaceTec_instructions_message_ready_1);
            if (strM1784I.contains(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
                strM1784I = strM1784I.substring(0, strM1784I.indexOf(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE));
            }
        }
        return (!z || FaceTecSDK.f2235I.f2210B || strM1784I.length() <= 50) ? strM1784I : strM1784I.substring(0, 50);
    }

    /* JADX INFO: renamed from: Z */
    static String m1690Z(boolean z) {
        String strM1784I = FaceTecSDK.f2235I.f2215L.readyScreenSubtextAttributedString;
        if (!strM1784I.isEmpty() && strM1784I.contains(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
            strM1784I = strM1784I.substring(strM1784I.indexOf(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE) + 1);
        }
        if (strM1784I.isEmpty()) {
            strM1784I = C2157aw.m1784I(C2130R.string.FaceTec_instructions_message_ready_2);
            if (strM1784I.contains(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
                strM1784I = strM1784I.substring(strM1784I.indexOf(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE) + 1);
            }
        }
        return (!z || FaceTecSDK.f2235I.f2210B || strM1784I.length() <= 50) ? strM1784I : strM1784I.substring(0, 50);
    }

    /* JADX INFO: renamed from: B */
    static String m1624B(boolean z) {
        String strM1784I = FaceTecSDK.f2235I.f2215L.retryScreenHeaderAttributedString;
        if (strM1784I.isEmpty()) {
            strM1784I = C2157aw.m1784I(C2130R.string.FaceTec_retry_header);
        }
        return (!z || FaceTecSDK.f2235I.f2210B || strM1784I.length() <= 30) ? strM1784I : strM1784I.substring(0, 30);
    }

    /* JADX INFO: renamed from: L */
    static String m1661L(boolean z) {
        String strM1784I = FaceTecSDK.f2235I.f2215L.retryScreenSubtextAttributedString;
        if (strM1784I.isEmpty()) {
            strM1784I = C2157aw.m1784I(C2130R.string.FaceTec_retry_subheader_message);
        }
        return (!z || FaceTecSDK.f2235I.f2210B || strM1784I.length() <= 40) ? strM1784I : strM1784I.substring(0, 40);
    }

    /* JADX INFO: renamed from: S */
    static String m1670S(boolean z) {
        String strM1784I = C2157aw.m1784I(C2130R.string.FaceTec_retry_instruction_message_1);
        return (!z || FaceTecSDK.f2235I.f2210B || strM1784I.length() <= 40) ? strM1784I : strM1784I.substring(0, 40);
    }

    /* JADX INFO: renamed from: F */
    static String m1641F(boolean z) {
        String strM1784I = C2157aw.m1784I(C2130R.string.FaceTec_retry_instruction_message_2);
        return (!z || FaceTecSDK.f2235I.f2210B || strM1784I.length() <= 40) ? strM1784I : strM1784I.substring(0, 40);
    }

    /* JADX INFO: renamed from: D */
    static String m1636D(boolean z) {
        String strM1784I = C2157aw.m1784I(C2130R.string.FaceTec_retry_instruction_message_3);
        return (!z || FaceTecSDK.f2235I.f2210B || strM1784I.length() <= 40) ? strM1784I : strM1784I.substring(0, 40);
    }

    /* JADX INFO: renamed from: C */
    static String m1633C(boolean z) {
        String strM1784I = C2157aw.m1784I(C2130R.string.FaceTec_retry_ideal_image_label);
        return (!z || FaceTecSDK.f2235I.f2210B || strM1784I.length() <= 20) ? strM1784I : strM1784I.substring(0, 20);
    }

    /* JADX INFO: renamed from: a */
    static String m1696a(boolean z) {
        String strM1784I = C2157aw.m1784I(C2130R.string.FaceTec_retry_your_image_label);
        return (!z || FaceTecSDK.f2235I.f2210B || strM1784I.length() <= 20) ? strM1784I : strM1784I.substring(0, 20);
    }

    /* JADX INFO: renamed from: aD */
    static int m1700aD() {
        return m1721aY().f2214I.customNFCStartingAnimation;
    }

    /* JADX INFO: renamed from: aF */
    static int m1702aF() {
        return m1721aY().f2214I.customNFCScanningAnimation;
    }

    /* JADX INFO: renamed from: aG */
    static int m1703aG() {
        return m1721aY().f2214I.customNFCCardStartingAnimation;
    }

    /* JADX INFO: renamed from: aH */
    static int m1704aH() {
        return m1721aY().f2214I.customNFCCardScanningAnimation;
    }

    /* JADX INFO: renamed from: aI */
    static int m1705aI() {
        return m1721aY().f2214I.customNFCSkipOrErrorAnimation;
    }

    /* JADX INFO: renamed from: aJ */
    static int m1706aJ() {
        return m1721aY().f2214I.customStaticNFCStartingAnimation;
    }

    /* JADX INFO: renamed from: aK */
    static int m1707aK() {
        return m1721aY().f2214I.customStaticNFCScanningAnimation;
    }

    /* JADX INFO: renamed from: aO */
    static int m1711aO() {
        return m1721aY().f2214I.customStaticNFCSkipOrErrorAnimation;
    }

    /* JADX INFO: renamed from: aM */
    static int m1709aM() {
        return m1721aY().f2213F.customActivityIndicatorAnimation;
    }

    /* JADX INFO: renamed from: aL */
    static int m1708aL() {
        return m1721aY().f2213F.customResultAnimationSuccess;
    }

    /* JADX INFO: renamed from: aP */
    static int m1712aP() {
        return m1721aY().f2213F.customResultAnimationUnsuccess;
    }

    /* JADX INFO: renamed from: aN */
    static int m1710aN() {
        return m1721aY().f2213F.customStaticResultAnimationSuccess;
    }

    /* JADX INFO: renamed from: aQ */
    static int m1713aQ() {
        return m1721aY().f2213F.customStaticResultAnimationUnsuccess;
    }

    /* JADX INFO: renamed from: aT */
    static float m1716aT() {
        return Math.min(Math.max(FaceTecSDK.f2235I.f2213F.animationRelativeScale, 0.5f), 2.0f);
    }

    /* JADX INFO: renamed from: Z */
    static String m1689Z(EnumC2144aj enumC2144aj) {
        HashMap<EnumC2144aj, String> map = FaceTecCustomization.f2209g;
        String str = map != null ? map.get(enumC2144aj) : null;
        if (str != null) {
            return str;
        }
        switch (AnonymousClass4.f2654B[enumC2144aj.ordinal()]) {
            case 1:
                return C2157aw.m1784I(C2130R.string.FaceTec_result_idscan_unsuccess_message);
            case 2:
                return C2157aw.m1784I(C2130R.string.FaceTec_result_idscan_retry_face_did_not_match_message);
            case 3:
                return C2157aw.m1784I(C2130R.string.FaceTec_result_idscan_retry_id_not_fully_visible_message);
            case 4:
                return C2157aw.m1784I(C2130R.string.FaceTec_result_idscan_retry_ocr_results_not_good_enough_message);
            case 5:
                return C2157aw.m1784I(C2130R.string.FaceTec_result_idscan_retry_id_type_not_supported_message);
            case 6:
            default:
                return str;
            case 7:
                return C2157aw.m1784I(C2130R.string.FaceTec_result_idscan_skip_or_error_nfc_message);
            case 8:
                return C2157aw.m1784I(C2130R.string.FaceTec_result_idscan_success_front_side_message);
            case 9:
                return C2157aw.m1784I(C2130R.string.FaceTec_result_idscan_success_front_side_back_next_message);
            case 10:
                return C2157aw.m1784I(C2130R.string.FaceTec_result_idscan_success_back_side_message);
            case 11:
                return C2157aw.m1784I(C2130R.string.FaceTec_result_idscan_success_user_confirmation_message);
            case 12:
                return C2157aw.m1784I(C2130R.string.FaceTec_result_idscan_success_nfc_message);
        }
    }

    /* JADX INFO: renamed from: B */
    static String m1623B(EnumC2163bc enumC2163bc) {
        if (FaceTecCustomization.f2208f != null) {
            return FaceTecCustomization.f2208f.get(enumC2163bc);
        }
        return null;
    }

    /* JADX INFO: renamed from: com.facetec.sdk.av$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: B */
        static final /* synthetic */ int[] f2654B;

        /* JADX INFO: renamed from: I */
        static final /* synthetic */ int[] f2655I;

        /* JADX INFO: renamed from: V */
        static final /* synthetic */ int[] f2656V;

        static {
            int[] iArr = new int[EnumC2233y.values().length];
            f2655I = iArr;
            try {
                iArr[EnumC2233y.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2655I[EnumC2233y.STARTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2655I[EnumC2233y.SCANNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2655I[EnumC2233y.WEAK_CONNECTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2655I[EnumC2233y.FINISHED_WITH_SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2655I[EnumC2233y.FINISHED_WITH_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2655I[EnumC2233y.SKIPPED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2655I[EnumC2233y.DISABLED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[EnumC2144aj.values().length];
            f2654B = iArr2;
            try {
                iArr2[EnumC2144aj.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2654B[EnumC2144aj.IDSCAN_RETRY_FACE_DID_NOT_MATCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2654B[EnumC2144aj.IDSCAN_RETRY_ID_NOT_FULLY_VISIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2654B[EnumC2144aj.IDSCAN_RETRY_OCR_RESULTS_NOT_GOOD_ENOUGH.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f2654B[EnumC2144aj.IDSCAN_RETRY_ID_TYPE_NOT_SUPPORTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f2654B[EnumC2144aj.IDSCAN_RETRY_USER_CONFIRMATION.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f2654B[EnumC2144aj.IDSCAN_SKIP_OR_ERROR_NFC.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f2654B[EnumC2144aj.IDSCAN_SUCCESS_FRONT_SIDE.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f2654B[EnumC2144aj.IDSCAN_SUCCESS_FRONT_SIDE_BACK_NEXT.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f2654B[EnumC2144aj.IDSCAN_SUCCESS_BACK_SIDE.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f2654B[EnumC2144aj.IDSCAN_SUCCESS_USER_CONFIRMATION.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f2654B[EnumC2144aj.IDSCAN_SUCCESS_NFC.ordinal()] = 12;
            } catch (NoSuchFieldError unused20) {
            }
            int[] iArr3 = new int[B.values().length];
            f2656V = iArr3;
            try {
                iArr3[B.RESOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f2656V[B.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    /* JADX INFO: renamed from: V */
    static String m1679V(EnumC2233y enumC2233y, boolean z) {
        switch (AnonymousClass4.f2655I[enumC2233y.ordinal()]) {
            case 1:
                return "";
            case 2:
                if (z) {
                    return C2157aw.m1784I(C2130R.string.FaceTec_idscan_nfc_card_status_starting_message);
                }
                return C2157aw.m1784I(C2130R.string.FaceTec_idscan_nfc_status_starting_message);
            case 3:
                return C2157aw.m1784I(C2130R.string.FaceTec_idscan_nfc_status_scanning_message);
            case 4:
                return C2157aw.m1784I(C2130R.string.FaceTec_idscan_nfc_status_weak_connection_message);
            case 5:
                return C2157aw.m1784I(C2130R.string.FaceTec_idscan_nfc_status_finished_with_success_message);
            case 6:
                if (z) {
                    return C2157aw.m1784I(C2130R.string.FaceTec_idscan_nfc_card_status_finished_with_error_message);
                }
                return C2157aw.m1784I(C2130R.string.FaceTec_idscan_nfc_status_finished_with_error_message);
            case 7:
                return C2157aw.m1784I(C2130R.string.FaceTec_idscan_nfc_status_skipped_message);
            case 8:
                return C2157aw.m1784I(C2130R.string.FaceTec_idscan_nfc_status_disabled_message);
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: aU */
    static boolean m1717aU() {
        return (FaceTecSDK.f2235I.f2222d.f2205Z == FaceTecCancelButtonCustomization.ButtonLocation.DISABLED || FaceTecSDK.f2235I.f2222d.f2205Z == FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM) ? false : true;
    }

    /* JADX INFO: renamed from: aR */
    static void m1714aR() {
        m1715aS();
        m1718aV();
        m1720aX();
        m1722aZ();
        String strM1670S = m1670S(false);
        String strM1641F = m1641F(false);
        String strM1636D = m1636D(false);
        if (strM1670S != null && strM1670S.length() > 40) {
            m1684V("Retry Screen Instruction Message 1");
        }
        if (strM1641F != null && strM1641F.length() > 40) {
            m1684V("Retry Screen Instruction Message 2");
        }
        if (strM1636D != null && strM1636D.length() > 40) {
            m1684V("Retry Screen Instruction Message 3");
        }
        String strM1696a = m1696a(false);
        String strM1633C = m1633C(false);
        if (strM1696a != null && strM1696a.length() > 20) {
            m1684V("Retry Screen Your Image Label");
        }
        if (strM1633C == null || strM1633C.length() <= 20) {
            return;
        }
        m1684V("Retry Screen Ideal Image Label");
    }

    /* JADX INFO: renamed from: aS */
    static void m1715aS() {
        String strCode = Code(false);
        String strM1650I = m1650I(false);
        if (strCode.length() > 30) {
            m1684V("Ready Screen Header Line 1");
        }
        if (strM1650I.length() > 30) {
            m1684V("Ready Screen Header Line 2");
        }
    }

    /* JADX INFO: renamed from: aV */
    static void m1718aV() {
        String strM1680V = m1680V(false);
        String strM1690Z = m1690Z(false);
        if (strM1680V.length() > 50) {
            m1684V("Ready Screen Subtext Line 1");
        }
        if (strM1690Z.length() > 50) {
            m1684V("Ready Screen Subtext Line 2");
        }
    }

    /* JADX INFO: renamed from: aX */
    static void m1720aX() {
        String strM1624B = m1624B(false);
        if (strM1624B.length() > 30) {
            m1684V("Retry Screen Header");
        } else if (strM1624B.length() > 20) {
            m1656I("Retry Screen Header");
        }
    }

    /* JADX INFO: renamed from: aZ */
    static void m1722aZ() {
        if (m1661L(false).length() > 40) {
            m1684V("Retry Screen Sub-Header Message");
        }
    }

    /* JADX INFO: renamed from: I */
    private static void m1656I(String str) {
        C2131S.m1431V(String.format(Locale.getDefault(), "Your %s text has been configured to use more than %d characters.  %d or less characters is recommended for this text in order to render well on all devices and OS versions.", str, 20, 20));
    }

    /* JADX INFO: renamed from: V */
    private static void m1684V(String str) {
        C2131S.m1431V(String.format(Locale.getDefault(), "FaceTec SDK Text Customization Alert: Your text is too long for the %s text element to render correctly on a significant portion of supported devices. Please update this text string to short, concise text, based on our default text element for optimal User Experience and Success Rates. If you continue with too many characters, the FaceTec SDK will not show the excess characters, and this will likely impact User Experience and Success Rates. These character limitations must be in place to ensure compatibility with the 1,000,000+ Device/Model/Platform/Version/Screen Size/Camera Res combinations that FaceTec supports.", str));
    }

    /* JADX INFO: renamed from: B */
    static int m1621B(Context context) {
        return m1647I(context, m1721aY().f2214I.captureFrameStrokeColor);
    }

    /* JADX INFO: renamed from: I */
    static int m1646I(Context context) {
        return m1647I(context, m1645I(FaceTecSDK.f2235I.f2214I.captureScreenBackgroundColor));
    }

    /* JADX INFO: renamed from: F */
    static int m1640F(Context context) {
        return m1647I(context, m1721aY().f2212D.borderColor);
    }

    /* JADX INFO: renamed from: D */
    static int m1635D(Context context) {
        int iM1647I = m1647I(context, m1721aY().f2215L.readyScreenHeaderTextColor);
        return iM1647I == 0 ? m1765i(context) : iM1647I;
    }

    /* JADX INFO: renamed from: C */
    static int m1632C(Context context) {
        int iM1647I = m1647I(context, m1721aY().f2215L.readyScreenSubtextTextColor);
        return iM1647I == 0 ? m1765i(context) : iM1647I;
    }

    /* JADX INFO: renamed from: L */
    static int m1659L(Context context) {
        int iM1647I = m1647I(context, m1721aY().f2215L.retryScreenHeaderTextColor);
        return iM1647I == 0 ? m1765i(context) : iM1647I;
    }

    /* JADX INFO: renamed from: S */
    static int m1669S(Context context) {
        int iM1647I = m1647I(context, m1721aY().f2215L.retryScreenSubtextTextColor);
        return iM1647I == 0 ? m1765i(context) : iM1647I;
    }

    /* JADX INFO: renamed from: V */
    static void m1681V(View view) {
        int iM1645I = m1645I(FaceTecSDK.f2235I.f2217V.backgroundColors);
        int i = AnonymousClass4.f2656V[Code(view.getContext(), iM1645I).ordinal()];
        if (i == 1) {
            view.setBackgroundResource(iM1645I);
        } else if (i == 2) {
            view.setBackgroundColor(iM1645I);
        } else {
            view.setBackgroundColor(0);
        }
    }

    /* JADX INFO: renamed from: b */
    static int m1750b(Context context) {
        return m1620B(m1647I(context, m1721aY().f2221c.strokeColor), 255);
    }

    /* JADX INFO: renamed from: e */
    static int m1757e(Context context) {
        return m1647I(context, m1721aY().f2215L.readyScreenOvalFillColor);
    }

    /* JADX INFO: renamed from: a */
    static int m1695a(Context context) {
        return m1647I(context, m1721aY().f2213F.resultAnimationBackgroundColor);
    }

    /* JADX INFO: renamed from: d */
    static int m1755d(Context context) {
        return m1647I(context, m1721aY().f2213F.resultAnimationForegroundColor);
    }

    /* JADX INFO: renamed from: g */
    static int m1761g(Context context) {
        return m1647I(context, m1721aY().f2215L.retryScreenImageBorderColor);
    }

    /* JADX INFO: renamed from: f */
    static int m1759f(Context context) {
        return m1647I(context, m1721aY().f2215L.retryScreenOvalStrokeColor);
    }

    /* JADX INFO: renamed from: I */
    static void m1652I(View view) {
        Code(view, m1645I(FaceTecSDK.f2235I.f2213F.backgroundColors));
    }

    /* JADX INFO: renamed from: V */
    static void m1682V(ProgressBar progressBar, Drawable drawable) {
        int i = m1721aY().f2213F.uploadProgressTrackColor;
        int i2 = AnonymousClass4.f2656V[Code(progressBar.getContext(), i).ordinal()];
        if (i2 == 1) {
            ((GradientDrawable) drawable).setColor(ContextCompat.getColor(progressBar.getContext(), i));
        } else {
            if (i2 != 2) {
                return;
            }
            ((GradientDrawable) drawable).setColor(i);
        }
    }

    static void Code(ProgressBar progressBar, Drawable drawable, Drawable drawable2) {
        int i = m1721aY().f2213F.uploadProgressFillColor;
        int i2 = AnonymousClass4.f2656V[Code(progressBar.getContext(), i).ordinal()];
        if (i2 == 1) {
            ((GradientDrawable) drawable).setColor(ContextCompat.getColor(progressBar.getContext(), i));
            ((GradientDrawable) drawable2).setColor(m1676V(ContextCompat.getColor(progressBar.getContext(), i), 0.5f));
        } else {
            if (i2 != 2) {
                return;
            }
            ((GradientDrawable) drawable).setColor(i);
            ((GradientDrawable) drawable2).setColor(m1676V(i, 0.5f));
        }
    }

    /* JADX INFO: renamed from: I */
    static void m1654I(TextView textView) {
        int i = m1721aY().f2216S.textColor;
        int i2 = AnonymousClass4.f2656V[Code(textView.getContext(), i).ordinal()];
        if (i2 == 1) {
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), i));
        } else {
            if (i2 != 2) {
                return;
            }
            textView.setTextColor(i);
        }
    }

    /* JADX INFO: renamed from: S */
    static void m1671S(View view) {
        Code(view, m1645I(FaceTecSDK.f2235I.f2214I.selectionScreenBackgroundColors));
    }

    /* JADX INFO: renamed from: B */
    static void m1630B(TextView textView) {
        int i = m1721aY().f2214I.selectionScreenForegroundColor;
        int i2 = AnonymousClass4.f2656V[Code(textView.getContext(), i).ordinal()];
        if (i2 == 1) {
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), i));
        } else {
            if (i2 != 2) {
                return;
            }
            textView.setTextColor(i);
        }
    }

    /* JADX INFO: renamed from: V */
    static void m1683V(TextView textView) {
        int i = m1721aY().f2214I.reviewScreenForegroundColor;
        int i2 = AnonymousClass4.f2656V[Code(textView.getContext(), i).ordinal()];
        if (i2 == 1) {
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), i));
        } else {
            if (i2 != 2) {
                return;
            }
            textView.setTextColor(i);
        }
    }

    /* JADX INFO: renamed from: S */
    static void m1672S(TextView textView) {
        int i = m1721aY().f2214I.captureScreenForegroundColor;
        int i2 = AnonymousClass4.f2656V[Code(textView.getContext(), i).ordinal()];
        if (i2 == 1) {
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), i));
        } else {
            if (i2 != 2) {
                return;
            }
            textView.setTextColor(i);
        }
    }

    /* JADX INFO: renamed from: D */
    static void m1637D(TextView textView) {
        int i = m1721aY().f2214I.captureScreenFocusMessageTextColor;
        int i2 = AnonymousClass4.f2656V[Code(textView.getContext(), i).ordinal()];
        if (i2 == 1) {
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), i));
        } else {
            if (i2 != 2) {
                return;
            }
            textView.setTextColor(i);
        }
    }
}
