package com.yoti.mobile.android.capture.face.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.view.PreviewView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.capture.face.C4465R;

/* JADX INFO: loaded from: classes5.dex */
public final class FaceCaptureBinding implements ViewBinding {
    public final PreviewView cameraPreview;
    private final View rootView;

    private FaceCaptureBinding(View view, PreviewView previewView) {
        this.rootView = view;
        this.cameraPreview = previewView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static FaceCaptureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(C4465R.layout.face_capture, viewGroup);
        return bind(viewGroup);
    }

    public static FaceCaptureBinding bind(View view) {
        int i = C4465R.id.cameraPreview;
        PreviewView previewView = (PreviewView) view.findViewById(i);
        if (previewView != null) {
            return new FaceCaptureBinding(view, previewView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
