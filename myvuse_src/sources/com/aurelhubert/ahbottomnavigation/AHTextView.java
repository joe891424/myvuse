package com.aurelhubert.ahbottomnavigation;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes.dex */
public class AHTextView extends AppCompatTextView {
    private Integer originalTextColor;

    public AHTextView(Context context) {
        super(context);
    }

    public AHTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AHTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setTextColor(Integer num) {
        saveOriginalTextColor();
        if (num == null) {
            super.setTextColor(this.originalTextColor.intValue());
        } else {
            super.setTextColor(num.intValue());
        }
    }

    private void saveOriginalTextColor() {
        if (this.originalTextColor == null) {
            this.originalTextColor = Integer.valueOf(getCurrentTextColor());
        }
    }
}
