package com.salesforce.marketingcloud.messages.iam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.salesforce.marketingcloud.C4089R;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import com.salesforce.marketingcloud.messages.iam.SwipeDismissConstraintLayout;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.c */
/* JADX INFO: loaded from: classes6.dex */
public class C4252c extends Fragment implements TraceFieldInterface {
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    private C4260k f5227a;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.c$a */
    class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ boolean f5228a;

        a(boolean z) {
            this.f5228a = z;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            FragmentActivity activity;
            View view = C4252c.this.getView();
            if (view != null) {
                view.setLayerType(0, null);
            }
            if (this.f5228a || (activity = C4252c.this.getActivity()) == null) {
                return;
            }
            activity.finish();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: renamed from: a */
    private int m3722a(InAppMessage inAppMessage) {
        return inAppMessage.type() == InAppMessage.Type.bannerTop ? C4089R.layout.mcsdk_iam_banner_top : C4089R.layout.mcsdk_iam_banner_bottom;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("c");
        try {
            TraceMachine.enterMethod(this._nr_trace, "c#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "c#onCreate", null);
        }
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f5227a = (C4260k) getArguments().getParcelable("messageHandler");
        }
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        View view;
        Animation animationOnCreateAnimation = super.onCreateAnimation(i, z, i2);
        if (animationOnCreateAnimation == null && i2 != 0) {
            animationOnCreateAnimation = AnimationUtils.loadAnimation(getActivity(), i2);
        }
        if (animationOnCreateAnimation != null && (view = getView()) != null) {
            view.setLayerType(2, null);
            animationOnCreateAnimation.setAnimationListener(new a(z));
        }
        return animationOnCreateAnimation;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "c#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "c#onCreateView", null);
        }
        C4260k c4260k = this.f5227a;
        if (c4260k == null) {
            TraceMachine.exitMethod();
            return null;
        }
        View viewInflate = layoutInflater.inflate(m3722a(c4260k.m3771d()), viewGroup, false);
        C4251b c4251b = new C4251b(getActivity() instanceof View.OnClickListener ? (View.OnClickListener) getActivity() : null, this.f5227a.m3777k());
        c4251b.m3735a(viewInflate, this.f5227a);
        SwipeDismissConstraintLayout swipeDismissConstraintLayout = (SwipeDismissConstraintLayout) viewInflate.findViewById(c4251b.mo3720g());
        if (swipeDismissConstraintLayout != null && (getActivity() instanceof SwipeDismissConstraintLayout.SwipeDismissListener)) {
            swipeDismissConstraintLayout.setListener((SwipeDismissConstraintLayout.SwipeDismissListener) getActivity());
        }
        TraceMachine.exitMethod();
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: renamed from: a */
    public static C4252c m3723a(C4260k c4260k) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("messageHandler", c4260k);
        C4252c c4252c = new C4252c();
        c4252c.setArguments(bundle);
        return c4252c;
    }
}
