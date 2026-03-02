package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentDocumentEducationalSuccessStateBinding implements ViewBinding {
    public final YotiButton buttonMoreAboutVerification;
    public final CardView cardVideoContainer;
    public final VideoView documentEducationalVideo;
    public final YdsIdentityCheckBubbleBinding identityCheckLayout;
    public final RecyclerView objectiveRequirementList;
    private final ConstraintLayout rootView;
    public final TextView textViewEducationalMessage;
    public final TextView textViewEducationalTitle;

    private YdsFragmentDocumentEducationalSuccessStateBinding(ConstraintLayout constraintLayout, YotiButton yotiButton, CardView cardView, VideoView videoView, YdsIdentityCheckBubbleBinding ydsIdentityCheckBubbleBinding, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.buttonMoreAboutVerification = yotiButton;
        this.cardVideoContainer = cardView;
        this.documentEducationalVideo = videoView;
        this.identityCheckLayout = ydsIdentityCheckBubbleBinding;
        this.objectiveRequirementList = recyclerView;
        this.textViewEducationalMessage = textView;
        this.textViewEducationalTitle = textView2;
    }

    public static YdsFragmentDocumentEducationalSuccessStateBinding bind(View view) {
        View viewFindViewById;
        int i = C4597R.id.buttonMoreAboutVerification;
        YotiButton yotiButton = (YotiButton) view.findViewById(i);
        if (yotiButton != null) {
            i = C4597R.id.cardVideoContainer;
            CardView cardView = (CardView) view.findViewById(i);
            if (cardView != null) {
                i = C4597R.id.documentEducationalVideo;
                VideoView videoView = (VideoView) view.findViewById(i);
                if (videoView != null && (viewFindViewById = view.findViewById((i = C4597R.id.identityCheckLayout))) != null) {
                    YdsIdentityCheckBubbleBinding ydsIdentityCheckBubbleBindingBind = YdsIdentityCheckBubbleBinding.bind(viewFindViewById);
                    i = C4597R.id.objectiveRequirementList;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
                    if (recyclerView != null) {
                        i = C4597R.id.textViewEducationalMessage;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            i = C4597R.id.textViewEducationalTitle;
                            TextView textView2 = (TextView) view.findViewById(i);
                            if (textView2 != null) {
                                return new YdsFragmentDocumentEducationalSuccessStateBinding((ConstraintLayout) view, yotiButton, cardView, videoView, ydsIdentityCheckBubbleBindingBind, recyclerView, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentDocumentEducationalSuccessStateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentDocumentEducationalSuccessStateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_fragment_document_educational_success_state, viewGroup, false);
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
