package com.yoti.mobile.android.facecapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.yoti.mobile.android.capture.face.p048ui.FaceCapture;
import com.yoti.mobile.android.common.p049ui.widgets.VerticalScrollingGradient;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.facecapture.C4832R;
import com.yoti.mobile.android.facecapture.view.capture.view.MaskableFrameLayout;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsFragmentFaceCaptureBinding implements ViewBinding {
    public final MaskableFrameLayout animatedFrameBorder;
    public final VerticalScrollingGradient animatedFrameGradient;
    public final YotiAppbar appBar;
    public final ShapeableImageView cameraFaceBackground;
    public final FaceCapture captureCameraView;
    public final View flashView;
    public final Guideline guidelineCaptureButton;
    public final FloatingActionButton manualCaptureButton;
    private final ConstraintLayout rootView;
    public final ImageView staticFrameBorder;
    public final TextView tooltip;

    private YdsFragmentFaceCaptureBinding(ConstraintLayout constraintLayout, MaskableFrameLayout maskableFrameLayout, VerticalScrollingGradient verticalScrollingGradient, YotiAppbar yotiAppbar, ShapeableImageView shapeableImageView, FaceCapture faceCapture, View view, Guideline guideline, FloatingActionButton floatingActionButton, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.animatedFrameBorder = maskableFrameLayout;
        this.animatedFrameGradient = verticalScrollingGradient;
        this.appBar = yotiAppbar;
        this.cameraFaceBackground = shapeableImageView;
        this.captureCameraView = faceCapture;
        this.flashView = view;
        this.guidelineCaptureButton = guideline;
        this.manualCaptureButton = floatingActionButton;
        this.staticFrameBorder = imageView;
        this.tooltip = textView;
    }

    public static YdsFragmentFaceCaptureBinding bind(View view) {
        View viewFindViewById;
        int i = C4832R.id.animatedFrameBorder;
        MaskableFrameLayout maskableFrameLayout = (MaskableFrameLayout) view.findViewById(i);
        if (maskableFrameLayout != null) {
            i = C4832R.id.animatedFrameGradient;
            VerticalScrollingGradient verticalScrollingGradient = (VerticalScrollingGradient) view.findViewById(i);
            if (verticalScrollingGradient != null) {
                i = C4832R.id.appBar;
                YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
                if (yotiAppbar != null) {
                    i = C4832R.id.cameraFaceBackground;
                    ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(i);
                    if (shapeableImageView != null) {
                        i = C4832R.id.captureCameraView;
                        FaceCapture faceCapture = (FaceCapture) view.findViewById(i);
                        if (faceCapture != null && (viewFindViewById = view.findViewById((i = C4832R.id.flashView))) != null) {
                            i = C4832R.id.guidelineCaptureButton;
                            Guideline guideline = (Guideline) view.findViewById(i);
                            if (guideline != null) {
                                i = C4832R.id.manualCaptureButton;
                                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(i);
                                if (floatingActionButton != null) {
                                    i = C4832R.id.staticFrameBorder;
                                    ImageView imageView = (ImageView) view.findViewById(i);
                                    if (imageView != null) {
                                        i = C4832R.id.tooltip;
                                        TextView textView = (TextView) view.findViewById(i);
                                        if (textView != null) {
                                            return new YdsFragmentFaceCaptureBinding((ConstraintLayout) view, maskableFrameLayout, verticalScrollingGradient, yotiAppbar, shapeableImageView, faceCapture, viewFindViewById, guideline, floatingActionButton, imageView, textView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentFaceCaptureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentFaceCaptureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4832R.layout.yds_fragment_face_capture, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
