package com.microblink.fragment.overlay.components.statusmsg;

import android.widget.TextView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface StatusTextStyler {

    /* JADX INFO: compiled from: line */
    public static class Default implements StatusTextStyler {
        int llIIlIlIIl;

        public Default(int i) {
            this.llIIlIlIIl = i;
        }

        @Override // com.microblink.fragment.overlay.components.statusmsg.StatusTextStyler
        public void applyStyle(TextView textView) {
            textView.setTextAppearance(textView.getContext(), this.llIIlIlIIl);
        }
    }

    void applyStyle(TextView textView);
}
