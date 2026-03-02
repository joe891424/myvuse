package com.reactnativenavigation.views.stack.topbar.titlebar;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.reactnativenavigation.options.Alignment;
import com.reactnativenavigation.options.FontOptions;
import com.reactnativenavigation.options.parsers.TypefaceLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TitleSubTitleLayout.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u000bH\u0007J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0007J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\t2\b\b\u0001\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\"\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010#\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010$\u001a\u00020\t2\b\b\u0001\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010%\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m5598d2 = {"Lcom/reactnativenavigation/views/stack/topbar/titlebar/TitleSubTitleLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "subTitleTextView", "Lcom/reactnativenavigation/views/stack/topbar/titlebar/SingleLineTextView;", "titleTextView", "clear", "", "getSubTitleTxtView", "Landroid/widget/TextView;", "getTitle", "", "getTitleTxtView", "setSubTitleAlignment", "alignment", "Lcom/reactnativenavigation/options/Alignment;", "setSubtitle", "subTitle", "", "setSubtitleFontSize", "size", "", "setSubtitleTextColor", "color", "", "setSubtitleTypeface", "typefaceLoader", "Lcom/reactnativenavigation/options/parsers/TypefaceLoader;", "font", "Lcom/reactnativenavigation/options/FontOptions;", "setTitle", "title", "setTitleAlignment", "setTitleFontSize", "setTitleTextColor", "setTitleTypeface", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class TitleSubTitleLayout extends LinearLayout {
    private final SingleLineTextView subTitleTextView;
    private final SingleLineTextView titleTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleSubTitleLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        SingleLineTextView singleLineTextView = new SingleLineTextView(context, 18.0f);
        this.titleTextView = singleLineTextView;
        SingleLineTextView singleLineTextView2 = new SingleLineTextView(context, 14.0f);
        this.subTitleTextView = singleLineTextView2;
        setOrientation(1);
        setVerticalGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388627;
        Unit unit = Unit.INSTANCE;
        addView(singleLineTextView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 8388627;
        layoutParams2.weight = 1.0f;
        Unit unit2 = Unit.INSTANCE;
        addView(singleLineTextView2, layoutParams2);
    }

    public final void setSubTitleAlignment(Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        if (alignment == Alignment.Center) {
            ViewGroup.LayoutParams layoutParams = this.subTitleTextView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams).gravity = 17;
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.subTitleTextView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams2).gravity = 8388627;
        }
    }

    public final void setTitleAlignment(Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        if (alignment == Alignment.Center) {
            ViewGroup.LayoutParams layoutParams = this.titleTextView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams).gravity = 17;
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.titleTextView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams2).gravity = 8388627;
        }
    }

    public final void setTitleFontSize(float size) {
        this.titleTextView.setTextSize(1, size);
    }

    public final void setSubtitleFontSize(float size) {
        this.subTitleTextView.setTextSize(1, size);
    }

    public final void setSubtitleTextColor(int color) {
        this.subTitleTextView.setTextColor(color);
    }

    public final void setTitleTextColor(int color) {
        this.titleTextView.setTextColor(color);
    }

    public final void setTitleTypeface(TypefaceLoader typefaceLoader, FontOptions font) {
        Intrinsics.checkNotNullParameter(typefaceLoader, "typefaceLoader");
        Intrinsics.checkNotNullParameter(font, "font");
        SingleLineTextView singleLineTextView = this.titleTextView;
        singleLineTextView.setTypeface(font.getTypeface(typefaceLoader, singleLineTextView.getTypeface()));
    }

    public final void setSubtitleTypeface(TypefaceLoader typefaceLoader, FontOptions font) {
        Intrinsics.checkNotNullParameter(typefaceLoader, "typefaceLoader");
        Intrinsics.checkNotNullParameter(font, "font");
        SingleLineTextView singleLineTextView = this.subTitleTextView;
        singleLineTextView.setTypeface(font.getTypeface(typefaceLoader, singleLineTextView.getTypeface()));
    }

    public final void setTitle(CharSequence title) {
        this.titleTextView.setText(title);
    }

    public final void setSubtitle(CharSequence subTitle) {
        this.subTitleTextView.setText(subTitle);
        if (subTitle == null || subTitle.length() == 0) {
            this.subTitleTextView.setVisibility(8);
        } else {
            this.subTitleTextView.setVisibility(0);
        }
    }

    public final String getTitle() {
        String text = this.titleTextView.getText();
        if (text == null) {
        }
        return text.toString();
    }

    public final void clear() {
        this.titleTextView.setText((CharSequence) null);
        setSubtitle(null);
    }

    public final TextView getTitleTxtView() {
        return this.titleTextView;
    }

    public final TextView getSubTitleTxtView() {
        return this.subTitleTextView;
    }
}
