package com.yoti.mobile.android.documentcapture.sup.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.documentcapture.sup.C4653R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsActivityAutomationCaptureBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final Button selectImageButton;
    public final Button selectPdfButton;
    public final Button takePictureButton;

    private YdsActivityAutomationCaptureBinding(ConstraintLayout constraintLayout, Button button, Button button2, Button button3) {
        this.rootView = constraintLayout;
        this.selectImageButton = button;
        this.selectPdfButton = button2;
        this.takePictureButton = button3;
    }

    public static YdsActivityAutomationCaptureBinding bind(View view) {
        int i = C4653R.id.selectImageButton;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C4653R.id.selectPdfButton;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                i = C4653R.id.takePictureButton;
                Button button3 = (Button) view.findViewById(i);
                if (button3 != null) {
                    return new YdsActivityAutomationCaptureBinding((ConstraintLayout) view, button, button2, button3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsActivityAutomationCaptureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsActivityAutomationCaptureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4653R.layout.yds_activity_automation_capture, viewGroup, false);
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
