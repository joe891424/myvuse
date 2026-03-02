package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;

/* JADX INFO: loaded from: classes5.dex */
public class YotiHighlightedText extends ConstraintLayout {

    /* JADX INFO: renamed from: a */
    private String f6133a;

    /* JADX INFO: renamed from: b */
    private String f6134b;

    /* JADX INFO: renamed from: c */
    private int f6135c;

    public YotiHighlightedText(Context context) {
        super(context);
    }

    public YotiHighlightedText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4515a(attributeSet);
        m4514a();
    }

    public YotiHighlightedText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4515a(attributeSet);
        m4514a();
    }

    /* JADX INFO: renamed from: a */
    private void m4514a() {
        ConstraintLayout.inflate(getContext(), C4584R.layout.item_highlighted_text, this);
        ((TextView) findViewById(C4584R.id.highlight_title)).setText(this.f6133a);
        ((TextView) findViewById(C4584R.id.highlight_message)).setText(this.f6134b);
        findViewById(C4584R.id.highlight_color).setBackgroundColor(this.f6135c);
    }

    /* JADX INFO: renamed from: a */
    private void m4515a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, C4584R.styleable.YotiHighlightedText, 0, 0);
        try {
            this.f6133a = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiHighlightedText_title);
            this.f6134b = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiHighlightedText_message);
            this.f6135c = typedArrayObtainStyledAttributes.getColor(C4584R.styleable.YotiHighlightedText_highlightColor, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setHighlightColor(int i) {
        this.f6135c = i;
        ((TextView) findViewById(C4584R.id.message)).setText(this.f6134b);
    }

    public void setMessage(String str) {
        this.f6134b = str;
        ((TextView) findViewById(C4584R.id.message)).setText(this.f6134b);
    }

    public void setTitle(String str) {
        this.f6133a = str;
        ((TextView) findViewById(C4584R.id.title)).setText(this.f6133a);
    }
}
