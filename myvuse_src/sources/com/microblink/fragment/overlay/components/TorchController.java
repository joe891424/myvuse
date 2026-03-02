package com.microblink.fragment.overlay.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.microblink.fragment.overlay.verification.OverlayTorchStateListener;
import com.microblink.hardware.SuccessCallback;
import com.microblink.library.C3714R;
import com.microblink.util.Log;
import com.microblink.view.recognition.RecognizerRunnerView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class TorchController {
    private RecognizerRunnerView IlIllIlIIl;
    private boolean IllIIIIllI;
    private Drawable IllIIIllII;
    private OverlayTorchStateListener lIlIIIIlIl;
    private Drawable llIIIlllll;
    private ImageView llIIlIlIIl;

    /* JADX INFO: renamed from: com.microblink.fragment.overlay.components.TorchController$2 */
    /* JADX INFO: compiled from: line */
    class ViewOnClickListenerC36972 implements View.OnClickListener {
        ViewOnClickListenerC36972() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TorchController.this.updateTorchState(!r2.IllIIIIllI);
        }
    }

    public void onTorchSupportStatusAvailable() {
        RecognizerRunnerView recognizerRunnerView = this.IlIllIlIIl;
        if (recognizerRunnerView == null) {
            return;
        }
        boolean z = this.IllIIIIllI;
        this.IllIIIIllI = false;
        boolean zIsCameraTorchSupported = recognizerRunnerView.isCameraTorchSupported();
        ImageView imageView = this.llIIlIlIIl;
        if (imageView != null) {
            if (zIsCameraTorchSupported) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        if (zIsCameraTorchSupported) {
            ImageView imageView2 = this.llIIlIlIIl;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new ViewOnClickListenerC36972());
            }
            llIIlIlIIl();
        }
        OverlayTorchStateListener overlayTorchStateListener = this.lIlIIIIlIl;
        if (overlayTorchStateListener != null) {
            overlayTorchStateListener.onTorchStateInitialised(zIsCameraTorchSupported);
            if (z) {
                this.lIlIIIIlIl.onTorchStateChanged(this.IllIIIIllI);
            }
        }
    }

    public void setTorchStateListener(OverlayTorchStateListener overlayTorchStateListener) {
        this.lIlIIIIlIl = overlayTorchStateListener;
    }

    public void setup(RecognizerRunnerView recognizerRunnerView) {
        setup(null, recognizerRunnerView);
    }

    public void toggleTorchState() {
        updateTorchState(!this.IllIIIIllI);
    }

    public void updateTorchState(final boolean z) {
        RecognizerRunnerView recognizerRunnerView = this.IlIllIlIIl;
        if (recognizerRunnerView == null) {
            return;
        }
        recognizerRunnerView.setTorchState(z, new SuccessCallback() { // from class: com.microblink.fragment.overlay.components.TorchController.1
            @Override // com.microblink.hardware.SuccessCallback
            public void onOperationDone(boolean z2) {
                Log.m2707d(this, "Setting torch to {}. Success: {}", Boolean.valueOf(z), Boolean.valueOf(z2));
                if (z2) {
                    TorchController.this.IllIIIIllI = z;
                    TorchController.this.llIIlIlIIl();
                    if (TorchController.this.lIlIIIIlIl != null) {
                        TorchController.this.lIlIIIIlIl.onTorchStateChanged(TorchController.this.IllIIIIllI);
                    }
                }
            }
        });
    }

    public void setup(ImageView imageView, RecognizerRunnerView recognizerRunnerView) {
        if (imageView == null) {
            setup(null, recognizerRunnerView, null, null);
        } else {
            Context context = imageView.getContext();
            setup(imageView, recognizerRunnerView, ContextCompat.getDrawable(context, C3714R.drawable.mb_ic_flash_off_24dp), ContextCompat.getDrawable(context, C3714R.drawable.mb_ic_flash_on_24dp));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void llIIlIlIIl() {
        ImageView imageView = this.llIIlIlIIl;
        if (imageView == null) {
            return;
        }
        imageView.post(new Runnable() { // from class: com.microblink.fragment.overlay.components.TorchController.3
            @Override // java.lang.Runnable
            public void run() {
                if (TorchController.this.IllIIIIllI) {
                    TorchController.this.llIIlIlIIl.setImageDrawable(TorchController.this.llIIIlllll);
                } else {
                    TorchController.this.llIIlIlIIl.setImageDrawable(TorchController.this.IllIIIllII);
                }
                TorchController.this.llIIlIlIIl.requestLayout();
            }
        });
    }

    public void setup(ImageView imageView, RecognizerRunnerView recognizerRunnerView, Drawable drawable, Drawable drawable2) {
        if (recognizerRunnerView == null) {
            return;
        }
        this.llIIlIlIIl = imageView;
        this.IlIllIlIIl = recognizerRunnerView;
        this.IllIIIllII = drawable;
        this.llIIIlllll = drawable2;
        boolean zIsCameraTorchSupported = recognizerRunnerView.isCameraTorchSupported();
        ImageView imageView2 = this.llIIlIlIIl;
        if (imageView2 != null) {
            if (zIsCameraTorchSupported) {
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
        }
        if (zIsCameraTorchSupported) {
            ImageView imageView3 = this.llIIlIlIIl;
            if (imageView3 != null) {
                imageView3.setOnClickListener(new ViewOnClickListenerC36972());
            }
        } else {
            this.IllIIIIllI = false;
        }
        llIIlIlIIl();
    }
}
