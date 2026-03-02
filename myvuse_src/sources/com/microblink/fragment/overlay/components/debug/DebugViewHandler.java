package com.microblink.fragment.overlay.components.debug;

import android.app.Activity;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.microblink.library.C3714R;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.metadata.text.DebugTextCallback;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class DebugViewHandler {
    private Handler IlIllIlIIl = new Handler();
    private TextView llIIlIlIIl;

    public void initialize(Activity activity, ViewGroup viewGroup, MetadataCallbacks metadataCallbacks) {
        ViewGroup.LayoutParams layoutParams;
        TextView textView = new TextView(activity);
        this.llIIlIlIIl = textView;
        textView.setGravity(21);
        this.llIIlIlIIl.setBackgroundResource(C3714R.drawable.mb_rounded_border);
        this.llIIlIlIIl.setPadding(6, 6, 6, 6);
        this.llIIlIlIIl.setTextColor(activity.getResources().getColor(C3714R.color.mb_status_foreground));
        this.llIIlIlIIl.setTextSize(14.0f);
        this.llIIlIlIIl.setVisibility(0);
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            layoutParams = layoutParams2;
        } else {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 17;
            layoutParams = layoutParams3;
        }
        viewGroup.addView(this.llIIlIlIIl, layoutParams);
        metadataCallbacks.setDebugTextCallback(new DebugTextCallback() { // from class: com.microblink.fragment.overlay.components.debug.DebugViewHandler.1
            @Override // com.microblink.metadata.text.DebugTextCallback
            public void onDebugText(final String str) {
                DebugViewHandler.this.IlIllIlIIl.post(new Runnable() { // from class: com.microblink.fragment.overlay.components.debug.DebugViewHandler.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DebugViewHandler.this.llIIlIlIIl == null || DebugViewHandler.this.llIIlIlIIl.getText().equals(str)) {
                            return;
                        }
                        DebugViewHandler.this.llIIlIlIIl.setText(str);
                    }
                });
            }
        });
    }
}
