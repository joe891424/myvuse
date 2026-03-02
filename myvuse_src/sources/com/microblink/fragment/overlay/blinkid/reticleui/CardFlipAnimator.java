package com.microblink.fragment.overlay.blinkid.reticleui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.widget.ImageView;
import com.microblink.library.C3714R;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class CardFlipAnimator implements CardAnimator {
    private AnimatorSet llIIlIlIIl;

    CardFlipAnimator() {
    }

    @Override // com.microblink.fragment.overlay.blinkid.reticleui.CardAnimator
    public void cancel() {
        AnimatorSet animatorSet = this.llIIlIlIIl;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.llIIlIlIIl.end();
            this.llIIlIlIIl.cancel();
        }
    }

    @Override // com.microblink.fragment.overlay.blinkid.reticleui.CardAnimator
    public void start(final ImageView imageView, final ReticleOverlayResources reticleOverlayResources) {
        final Context context = imageView.getContext();
        imageView.setVisibility(0);
        imageView.setImageDrawable(reticleOverlayResources.lllIIIlIlI);
        imageView.setRotationX(0.0f);
        imageView.setRotationY(0.0f);
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(context, C3714R.animator.mb_card_flip_blinkid_1);
        this.llIIlIlIIl = animatorSet;
        animatorSet.setTarget(imageView);
        this.llIIlIlIIl.start();
        this.llIIlIlIIl.addListener(new AnimationEndListener() { // from class: com.microblink.fragment.overlay.blinkid.reticleui.CardFlipAnimator.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CardFlipAnimator.this.llIIlIlIIl.removeAllListeners();
                imageView.setImageDrawable(reticleOverlayResources.IlIllIlllI);
                CardFlipAnimator.this.llIIlIlIIl = (AnimatorSet) AnimatorInflater.loadAnimator(context, C3714R.animator.mb_card_flip_blinkid_2);
                CardFlipAnimator.this.llIIlIlIIl.setTarget(imageView);
                CardFlipAnimator.this.llIIlIlIIl.start();
            }
        });
    }
}
