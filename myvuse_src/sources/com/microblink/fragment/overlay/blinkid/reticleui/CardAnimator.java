package com.microblink.fragment.overlay.blinkid.reticleui;

import android.widget.ImageView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
interface CardAnimator {
    public static final CardAnimator EMPTY = new CardAnimator() { // from class: com.microblink.fragment.overlay.blinkid.reticleui.CardAnimator.1
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.CardAnimator
        public void cancel() {
        }

        @Override // com.microblink.fragment.overlay.blinkid.reticleui.CardAnimator
        public void start(ImageView imageView, ReticleOverlayResources reticleOverlayResources) {
            imageView.setVisibility(8);
        }
    };

    void cancel();

    void start(ImageView imageView, ReticleOverlayResources reticleOverlayResources);
}
