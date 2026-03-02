package p000a.p001a.p002a.p003a.p014b.p023g;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.ViewProps;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000a.p001a.p002a.p003a.p014b.DataModels.BannerData;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0117k;
import p000a.p001a.p002a.p003a.p014b.p021e.C0124r;

/* JADX INFO: renamed from: a.a.a.a.b.g.d */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a0\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u001a\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u001a\u0014\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u001a\u001a\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011\u001a.\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u001c\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a4\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010#\u001a\u00020$\u001a.\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\"2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010%\u001a\u00020$2\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u0014\u0010&\u001a\u00020\u0001*\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u0007\u001a\u0014\u0010(\u001a\u00020\u0001*\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\u0007¨\u0006*"}, m5598d2 = {"applyLinkUnderline", "", "Landroid/widget/TextView;", "globalUIProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/OTGlobalUIProperty;", "applyTextPropertyFromButtonRules", OTUXParamsKeys.OT_UX_TEXT_COLOR, "", "buttonProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/ButtonProperty;", "otConfiguration", "Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;", "renderHtmlText", "html", "setAdditionalDescText", "text", "visibility", "", "setCustomActionDescriptionForLink", "actionDescription", "setGravity", ViewProps.LAYOUT_DIRECTION, OTUXParamsKeys.OT_UX_TEXT_ALIGNMENT, "setLinkViewProperty", "linkProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/LinkProperty;", "otGlobalUIProperty", "bannerData", "Lcom/onetrust/otpublishers/headless/UI/DataModels/BannerData;", "setOTTypeFace", "titleFontProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/FontProperty;", "setProperty", "titleProperty", "Lcom/onetrust/otpublishers/headless/UI/UIProperty/TextProperty;", "applyingText", "", "isTitle", "setTextAlignmentIfNotNullOrEmpty", "alignment", "setTextSizeIfNotNullOrEmpty", "size", "OTPublishersHeadlessSDK_release"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C0154d {
    /* JADX INFO: renamed from: a */
    public static final void m757a(TextView textView, C0124r c0124r) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (c0124r == null || c0124r.f800a) {
            textView.setPaintFlags(textView.getPaintFlags() | 8);
        }
    }

    /* JADX INFO: renamed from: b */
    public static final void m759b(TextView textView, String str) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (str == null || str.length() == 0) {
            return;
        }
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullParameter(context, "<this>");
        if ((context.getApplicationInfo().flags & 4194304) != 0) {
            textView.setTextAlignment(Integer.parseInt(str));
            return;
        }
        int layoutDirection = textView.getContext().getResources().getConfiguration().getLayoutDirection();
        int i = Integer.parseInt(str);
        Intrinsics.checkNotNullParameter(textView, "<this>");
        int i2 = GravityCompat.END;
        int i3 = GravityCompat.START;
        if (layoutDirection != 1) {
            i3 = 8388613;
            i2 = 8388611;
        }
        if (i == 2) {
            textView.setGravity(3);
            return;
        }
        if (i == 3) {
            textView.setGravity(5);
            return;
        }
        if (i == 4) {
            textView.setGravity(1);
        } else if (i == 5) {
            textView.setGravity(i2);
        } else {
            if (i != 6) {
                return;
            }
            textView.setGravity(i3);
        }
    }

    /* JADX INFO: renamed from: c */
    public static final void m760c(TextView textView, String str) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (str == null || str.length() == 0) {
            return;
        }
        textView.setTextSize(Float.parseFloat(str));
    }

    /* JADX INFO: renamed from: a */
    public static final void m758a(TextView textView, String str) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (str == null || str.length() == 0) {
            OTLogger.m2743a(3, "UIUtils", "renderHtmlText called with 'null' text content.");
            return;
        }
        if (!Pattern.compile(".*\\<[^>]+>.*", 32).matcher(str == null ? "" : str).matches()) {
            textView.setText(str);
            return;
        }
        OTLogger.m2743a(3, "UIUtils", "Rendering html content");
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Spanned spannedFromHtml = Html.fromHtml(str, 0);
        Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "{\n        Html.fromHtml(…M_HTML_MODE_LEGACY)\n    }");
        SpannableStringBuilder strBuilder = new SpannableStringBuilder(spannedFromHtml);
        URLSpan[] urls = (URLSpan[]) strBuilder.getSpans(0, spannedFromHtml.length(), URLSpan.class);
        Intrinsics.checkNotNullExpressionValue(urls, "urls");
        for (URLSpan span : urls) {
            Intrinsics.checkNotNullExpressionValue(span, "span");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(strBuilder, "strBuilder");
            Intrinsics.checkNotNullParameter(span, "span");
            strBuilder.setSpan(new C0152b(context, span), strBuilder.getSpanStart(span), strBuilder.getSpanEnd(span), strBuilder.getSpanFlags(span));
            strBuilder.removeSpan(span);
        }
        textView.setText(strBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: renamed from: a */
    public static final void m756a(TextView textView, C0117k linkProperty, C0124r c0124r, BannerData bannerData, OTConfiguration oTConfiguration) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(linkProperty, "linkProperty");
        Intrinsics.checkNotNullParameter(bannerData, "bannerData");
        C0106b0 textProperty = linkProperty.f755a;
        Intrinsics.checkNotNullExpressionValue(textProperty, "linkProperty.linkTextProperty");
        String linkColor = bannerData.f132l;
        if (linkColor == null) {
            linkColor = "";
        }
        Intrinsics.checkNotNullParameter(textProperty, "textProperty");
        Intrinsics.checkNotNullParameter(linkColor, "linkColor");
        String str = textProperty.f724c;
        boolean z = true;
        if (str == null || str.length() == 0) {
            str = null;
        }
        if (str == null) {
            String str2 = c0124r != null ? c0124r.f801b : null;
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            String str3 = z ? null : str2;
            if (str3 != null) {
                linkColor = str3;
            }
        } else {
            linkColor = str;
        }
        m754a(textView, textProperty, linkColor, false, oTConfiguration);
        m757a(textView, c0124r);
    }

    /* JADX INFO: renamed from: a */
    public static final void m755a(TextView textView, C0115i titleFontProperty, OTConfiguration oTConfiguration) {
        Typeface typeface;
        Typeface otTypeFaceMap;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(titleFontProperty, "titleFontProperty");
        String str = titleFontProperty.f753d;
        if (str != null && str.length() != 0 && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str)) != null) {
            textView.setTypeface(otTypeFaceMap);
            return;
        }
        int style = titleFontProperty.f752c;
        if (style == -1 && (typeface = textView.getTypeface()) != null) {
            style = typeface.getStyle();
        }
        String str2 = titleFontProperty.f750a;
        textView.setTypeface((str2 == null || str2.length() == 0) ? Typeface.create(textView.getTypeface(), style) : Typeface.create(titleFontProperty.f750a, style));
    }

    /* JADX INFO: renamed from: a */
    public static final void m754a(TextView textView, C0106b0 titleProperty, String str, boolean z, OTConfiguration oTConfiguration) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(titleProperty, "titleProperty");
        C0115i c0115i = titleProperty.f722a;
        Intrinsics.checkNotNullExpressionValue(c0115i, "titleProperty.fontProperty");
        m755a(textView, c0115i, oTConfiguration);
        m760c(textView, c0115i.f751b);
        m759b(textView, titleProperty.f723b);
        if (str != null && str.length() != 0) {
            textView.setTextColor(Color.parseColor(str));
        }
        ViewCompat.setAccessibilityHeading(textView, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m753a(TextView textView, C0106b0 titleProperty, String str, OTConfiguration oTConfiguration, boolean z, int i) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            oTConfiguration = null;
        }
        boolean z2 = true;
        if ((i & 8) != 0) {
            z = true;
        }
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(titleProperty, "titleProperty");
        C0115i c0115i = titleProperty.f722a;
        Intrinsics.checkNotNullExpressionValue(c0115i, "titleProperty.fontProperty");
        m755a(textView, c0115i, oTConfiguration);
        m760c(textView, c0115i.f751b);
        if (z) {
            textView.setText(titleProperty.f726e);
        }
        String str2 = titleProperty.f724c;
        if (str2 != null && str2.length() != 0) {
            z2 = false;
        }
        String str3 = z2 ? null : str2;
        if (str3 != null) {
            str = str3;
        }
        textView.setTextColor(Color.parseColor(str));
        m759b(textView, titleProperty.f723b);
    }
}
