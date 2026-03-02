package com.yoti.mobile.android.common.p049ui.widgets;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.yoti.mobile.android.common.p049ui.widgets.utils.UiWidgetExtensionsKt;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0001?B'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0005\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0005\u0010\u000eJ\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0007\u0010\u000eJ\u001b\u0010\u0005\u001a\u00020\u0002*\u00020\u000f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0005\u0010\u0010J\u001b\u0010\u0003\u001a\u00020\u0002*\u00020\u000f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0003\u0010\u0010J\u001b\u0010\u0007\u001a\u00020\u0002*\u00020\u000f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0007\u0010\u0010J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0005\u0010\u0012J'\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0005\u0010\u0018J\u0013\u0010\u0007\u001a\u00020\u0002*\u00020\u000fH\u0002¢\u0006\u0004\b\u0007\u0010\u0019J\u0013\u0010\u0005\u001a\u00020\u0006*\u00020\u000fH\u0002¢\u0006\u0004\b\u0005\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u0015\u0010\u001c\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u000bJ\u0015\u0010\u001d\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u000eJ\u0015\u0010\u001e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001e\u0010\u000eR$\u0010%\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R2\u0010+\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020'0&j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020'`(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R$\u00102\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R2\u00106\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f03j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f`48\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00105¨\u0006@"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiFeedbackContainer;", "Landroid/widget/LinearLayout;", "", "c", "()V", "a", "", "b", "()Z", "", AnalyticsAttribute.UUID_ATTRIBUTE, "(Ljava/lang/String;)V", "Lcom/yoti/mobile/android/common/ui/widgets/FeedbackItem;", "feedbackItem", "(Lcom/yoti/mobile/android/common/ui/widgets/FeedbackItem;)V", "Landroid/view/View;", "(Landroid/view/View;Lcom/yoti/mobile/android/common/ui/widgets/FeedbackItem;)V", "view", "(Lcom/yoti/mobile/android/common/ui/widgets/FeedbackItem;Landroid/view/View;)V", "Landroid/widget/TextSwitcher;", "messageView", "Lcom/airbnb/lottie/LottieAnimationView;", "statusAnimationView", "newText", "(Landroid/widget/TextSwitcher;Lcom/airbnb/lottie/LottieAnimationView;Ljava/lang/String;)V", "(Landroid/view/View;)V", "(Landroid/view/View;)Z", "clearFeedbackItems", "removeFeedbackItem", "addFeedbackItem", "updateFeedbackItem", "Lcom/yoti/mobile/android/common/ui/widgets/OnFeedbackVisibilityUpdate;", "Lcom/yoti/mobile/android/common/ui/widgets/OnFeedbackVisibilityUpdate;", "getFeedbackVisibilityListener", "()Lcom/yoti/mobile/android/common/ui/widgets/OnFeedbackVisibilityUpdate;", "setFeedbackVisibilityListener", "(Lcom/yoti/mobile/android/common/ui/widgets/OnFeedbackVisibilityUpdate;)V", "feedbackVisibilityListener", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "eventToProcess", "Lcom/yoti/mobile/android/common/ui/widgets/OnFeedbackInteraction;", "Lcom/yoti/mobile/android/common/ui/widgets/OnFeedbackInteraction;", "getFeedbackListener", "()Lcom/yoti/mobile/android/common/ui/widgets/OnFeedbackInteraction;", "setFeedbackListener", "(Lcom/yoti/mobile/android/common/ui/widgets/OnFeedbackInteraction;)V", "feedbackListener", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "feedbackUuidViewMap", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class YotiFeedbackContainer extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private OnFeedbackInteraction feedbackListener;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private OnFeedbackVisibilityUpdate feedbackVisibilityListener;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final HashMap<String, View> feedbackUuidViewMap;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final ArrayList<Function0<Unit>> eventToProcess;

    /* JADX INFO: renamed from: e */
    private HashMap f6107e;

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$a */
    static final class C4500a extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ FeedbackItem f6109b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4500a(FeedbackItem feedbackItem) {
            super(0);
            this.f6109b = feedbackItem;
        }

        /* JADX INFO: renamed from: a */
        public final void m4511a() {
            YotiFeedbackContainer.this.m4501a(this.f6109b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            m4511a();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$b */
    static final class ViewOnClickListenerC4501b implements View.OnClickListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ YotiFeedbackContainer f6110a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ FeedbackItem f6111b;

        ViewOnClickListenerC4501b(int i, YotiFeedbackContainer yotiFeedbackContainer, View view, FeedbackItem feedbackItem) {
            this.f6110a = yotiFeedbackContainer;
            this.f6111b = feedbackItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            OnFeedbackInteraction feedbackListener = this.f6110a.getFeedbackListener();
            if (feedbackListener != null) {
                feedbackListener.onPrimaryClicked(this.f6111b.getUuid());
            }
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$c */
    static final class ViewOnClickListenerC4502c implements View.OnClickListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ YotiFeedbackContainer f6112a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ FeedbackItem f6113b;

        ViewOnClickListenerC4502c(int i, YotiFeedbackContainer yotiFeedbackContainer, View view, FeedbackItem feedbackItem) {
            this.f6112a = yotiFeedbackContainer;
            this.f6113b = feedbackItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            OnFeedbackInteraction feedbackListener = this.f6112a.getFeedbackListener();
            if (feedbackListener != null) {
                feedbackListener.onSecondaryClicked(this.f6113b.getUuid());
            }
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$d */
    static final class RunnableC4503d implements Runnable {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ View f6115b;

        /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$d$a */
        static final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                YotiFeedbackContainer.this.m4498a();
            }
        }

        RunnableC4503d(View view) {
            this.f6115b = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f6115b.animate().translationXBy(-8.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(187L).withEndAction(new a()).start();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$e */
    static final class C4504e implements ViewSwitcher.ViewFactory {
        C4504e() {
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public final View makeView() {
            TextView textView = new TextView(YotiFeedbackContainer.this.getContext());
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Resources.Theme theme = context.getTheme();
            Intrinsics.checkNotNullExpressionValue(theme, "context.theme");
            int colorFromAttribute = UiWidgetExtensionsKt.getColorFromAttribute(theme, C4584R.attr.typography_neutral_contrast);
            TextViewCompat.setTextAppearance(textView, C4584R.style.Yoti_v3_Font_Small);
            textView.setTextColor(colorFromAttribute);
            return textView;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$f */
    static final class C4505f extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f6119b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4505f(String str) {
            super(0);
            this.f6119b = str;
        }

        /* JADX INFO: renamed from: a */
        public final void m4512a() {
            YotiFeedbackContainer.this.m4503a(this.f6119b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            m4512a();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$g */
    static final class C4506g extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ FeedbackItem f6121b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4506g(FeedbackItem feedbackItem) {
            super(0);
            this.f6121b = feedbackItem;
        }

        /* JADX INFO: renamed from: a */
        public final void m4513a() {
            YotiFeedbackContainer.this.m4507b(this.f6121b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            m4513a();
            return Unit.INSTANCE;
        }
    }

    public YotiFeedbackContainer(Context context) {
        this(context, null, 0, 6, null);
    }

    public YotiFeedbackContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiFeedbackContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.feedbackUuidViewMap = new HashMap<>();
        this.eventToProcess = new ArrayList<>();
        getLayoutTransition().enableTransitionType(4);
    }

    public /* synthetic */ YotiFeedbackContainer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m4498a() {
        if (this.eventToProcess.size() > 0) {
            this.eventToProcess.remove(0);
        }
        if (this.eventToProcess.size() > 0) {
            m4509c();
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m4499a(View view, FeedbackItem feedbackItem) {
        if (feedbackItem.getIcon() != null) {
            ConstraintLayout feedbackIconLayout = (ConstraintLayout) view.findViewById(C4584R.id.feedbackIconLayout);
            Intrinsics.checkNotNullExpressionValue(feedbackIconLayout, "feedbackIconLayout");
            feedbackIconLayout.setVisibility(0);
            ((ImageView) view.findViewById(C4584R.id.feedbackIcon)).setImageResource(feedbackItem.getIcon().intValue());
        } else {
            ConstraintLayout feedbackIconLayout2 = (ConstraintLayout) view.findViewById(C4584R.id.feedbackIconLayout);
            Intrinsics.checkNotNullExpressionValue(feedbackIconLayout2, "feedbackIconLayout");
            feedbackIconLayout2.setVisibility(8);
            YotiButton feedbackButtonPrimary = (YotiButton) view.findViewById(C4584R.id.feedbackButtonPrimary);
            Intrinsics.checkNotNullExpressionValue(feedbackButtonPrimary, "feedbackButtonPrimary");
            feedbackButtonPrimary.setPaddingRelative(0, feedbackButtonPrimary.getPaddingTop(), feedbackButtonPrimary.getPaddingEnd(), feedbackButtonPrimary.getPaddingBottom());
        }
        if (feedbackItem.getIconColor() == null) {
            ImageView feedbackIcon = (ImageView) view.findViewById(C4584R.id.feedbackIcon);
            Intrinsics.checkNotNullExpressionValue(feedbackIcon, "feedbackIcon");
            feedbackIcon.setColorFilter((ColorFilter) null);
        } else {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Resources.Theme theme = context.getTheme();
            Intrinsics.checkNotNullExpressionValue(theme, "context.theme");
            ((ImageView) view.findViewById(C4584R.id.feedbackIcon)).setColorFilter(UiWidgetExtensionsKt.getColorFromAttribute(theme, feedbackItem.getIconColor().intValue()));
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m4500a(final TextSwitcher messageView, final LottieAnimationView statusAnimationView, String newText) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(250L);
        messageView.setInAnimation(alphaAnimation);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(250L);
        messageView.setOutAnimation(alphaAnimation2);
        messageView.getOutAnimation().setAnimationListener(new Animation.AnimationListener() { // from class: com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$startAnimation$3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                this.f6128a.m4505b(messageView);
                statusAnimationView.setVisibility(0);
                statusAnimationView.playAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        messageView.setText(newText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m4501a(final FeedbackItem feedbackItem) {
        final View view = LayoutInflater.from(getContext()).inflate(C4584R.layout.view_yoti_feedback_item, (ViewGroup) this, false);
        addView(view, 0);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        m4499a(view, feedbackItem);
        m4510c(view, feedbackItem);
        ((TextSwitcher) view.findViewById(C4584R.id.feedbackMessage)).setFactory(new C4504e());
        m4502a(feedbackItem, view);
        this.feedbackUuidViewMap.put(feedbackItem.getUuid(), view);
        OnFeedbackVisibilityUpdate onFeedbackVisibilityUpdate = this.feedbackVisibilityListener;
        if (onFeedbackVisibilityUpdate != null) {
            onFeedbackVisibilityUpdate.notifyFeedbackCountChanges(getChildCount());
        }
        if (feedbackItem.getShouldAnimate()) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$processAddFeedbackItem$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    Intrinsics.checkParameterIsNotNull(view2, "view");
                    view2.removeOnLayoutChangeListener(this);
                    YotiFeedbackContainer yotiFeedbackContainer = this.f6122a;
                    View view3 = view;
                    Intrinsics.checkNotNullExpressionValue(view3, "view");
                    yotiFeedbackContainer.m4506b(view3, feedbackItem);
                }
            });
        } else {
            m4506b(view, feedbackItem);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0026  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m4502a(com.yoti.mobile.android.common.p049ui.widgets.FeedbackItem r6, android.view.View r7) {
        /*
            r5 = this;
            java.lang.Integer r0 = r6.getButtonPrimaryText()
            r1 = 0
            r2 = 8
            if (r0 == 0) goto L26
            int r0 = r0.intValue()
            int r3 = com.yoti.mobile.android.commons.p051ui.widgets.C4584R.id.feedbackButtonPrimary
            android.view.View r3 = r7.findViewById(r3)
            com.yoti.mobile.android.common.ui.widgets.YotiButton r3 = (com.yoti.mobile.android.common.p049ui.widgets.YotiButton) r3
            r3.setText(r0)
            com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$b r4 = new com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$b
            r4.<init>(r0, r5, r7, r6)
            r3.setOnClickListener(r4)
            r3.setVisibility(r1)
            if (r3 == 0) goto L26
            goto L31
        L26:
            int r0 = com.yoti.mobile.android.commons.p051ui.widgets.C4584R.id.feedbackButtonPrimary
            android.view.View r0 = r7.findViewById(r0)
            com.yoti.mobile.android.common.ui.widgets.YotiButton r0 = (com.yoti.mobile.android.common.p049ui.widgets.YotiButton) r0
            r0.setVisibility(r2)
        L31:
            java.lang.Integer r0 = r6.getButtonSecondaryText()
            if (r0 == 0) goto L54
            int r0 = r0.intValue()
            int r3 = com.yoti.mobile.android.commons.p051ui.widgets.C4584R.id.feedbackButtonSecondary
            android.view.View r3 = r7.findViewById(r3)
            com.yoti.mobile.android.common.ui.widgets.YotiButton r3 = (com.yoti.mobile.android.common.p049ui.widgets.YotiButton) r3
            r3.setText(r0)
            com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$c r4 = new com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$c
            r4.<init>(r0, r5, r7, r6)
            r3.setOnClickListener(r4)
            r3.setVisibility(r1)
            if (r3 == 0) goto L54
            goto L5f
        L54:
            int r6 = com.yoti.mobile.android.commons.p051ui.widgets.C4584R.id.feedbackButtonSecondary
            android.view.View r6 = r7.findViewById(r6)
            com.yoti.mobile.android.common.ui.widgets.YotiButton r6 = (com.yoti.mobile.android.common.p049ui.widgets.YotiButton) r6
            r6.setVisibility(r2)
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.common.p049ui.widgets.YotiFeedbackContainer.m4502a(com.yoti.mobile.android.common.ui.widgets.FeedbackItem, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m4503a(final String uuid) {
        View it2 = this.feedbackUuidViewMap.get(uuid);
        if (it2 != null) {
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            ConstraintLayout constraintLayout = (ConstraintLayout) it2.findViewById(C4584R.id.feedbackIconLayout);
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "it.feedbackIconLayout");
            constraintLayout.setVisibility(4);
            TextSwitcher textSwitcher = (TextSwitcher) it2.findViewById(C4584R.id.feedbackMessage);
            Intrinsics.checkNotNullExpressionValue(textSwitcher, "it.feedbackMessage");
            textSwitcher.setVisibility(4);
            ImageView imageView = (ImageView) it2.findViewById(C4584R.id.feedbackStatus);
            Intrinsics.checkNotNullExpressionValue(imageView, "it.feedbackStatus");
            imageView.setVisibility(4);
            YotiButton yotiButton = (YotiButton) it2.findViewById(C4584R.id.feedbackButtonPrimary);
            Intrinsics.checkNotNullExpressionValue(yotiButton, "it.feedbackButtonPrimary");
            yotiButton.setVisibility(4);
            YotiButton yotiButton2 = (YotiButton) it2.findViewById(C4584R.id.feedbackButtonSecondary);
            Intrinsics.checkNotNullExpressionValue(yotiButton2, "it.feedbackButtonSecondary");
            yotiButton2.setVisibility(4);
            removeView(it2);
            this.feedbackUuidViewMap.remove(uuid);
            OnFeedbackVisibilityUpdate onFeedbackVisibilityUpdate = this.feedbackVisibilityListener;
            if (onFeedbackVisibilityUpdate != null) {
                onFeedbackVisibilityUpdate.notifyFeedbackCountChanges(getChildCount());
            }
            if (m4504a(it2)) {
                if (!ViewCompat.isLaidOut(this) || isLayoutRequested()) {
                    addOnLayoutChangeListener(new View.OnLayoutChangeListener(uuid) { // from class: com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$processRemove$$inlined$let$lambda$2
                        @Override // android.view.View.OnLayoutChangeListener
                        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                            Intrinsics.checkParameterIsNotNull(view, "view");
                            view.removeOnLayoutChangeListener(this);
                            this.f6126a.getLayoutTransition().addTransitionListener(new LayoutTransition.TransitionListener() { // from class: com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$processRemove$$inlined$let$lambda$2.1
                                @Override // android.animation.LayoutTransition.TransitionListener
                                public void endTransition(LayoutTransition transition, ViewGroup container, View view2, int transitionType) {
                                    YotiFeedbackContainer$processRemove$$inlined$let$lambda$2.this.f6126a.m4498a();
                                }

                                @Override // android.animation.LayoutTransition.TransitionListener
                                public void startTransition(LayoutTransition transition, ViewGroup container, View view2, int transitionType) {
                                }
                            });
                        }
                    });
                    return;
                } else {
                    getLayoutTransition().addTransitionListener(new LayoutTransition.TransitionListener(uuid) { // from class: com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$processRemove$$inlined$let$lambda$1
                        @Override // android.animation.LayoutTransition.TransitionListener
                        public void endTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
                            this.f6125a.m4498a();
                        }

                        @Override // android.animation.LayoutTransition.TransitionListener
                        public void startTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
                        }
                    });
                    return;
                }
            }
        }
        m4498a();
    }

    /* JADX INFO: renamed from: a */
    private final boolean m4504a(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m4505b(View view) {
        view.animate().translationXBy(8.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(187L).withEndAction(new RunnableC4503d(view)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m4506b(android.view.View r5, com.yoti.mobile.android.common.p049ui.widgets.FeedbackItem r6) {
        /*
            r4 = this;
            java.lang.Integer r0 = r6.getMessage()
            java.lang.String r1 = "feedbackStatusAnimation"
            java.lang.String r2 = "feedbackMessage"
            if (r0 == 0) goto L5e
            int r0 = r0.intValue()
            boolean r3 = r6.getShouldAnimate()
            if (r3 == 0) goto L47
            java.lang.String r6 = r6.getStatusAnimation()
            if (r6 == 0) goto L47
            boolean r6 = r4.m4504a(r5)
            if (r6 == 0) goto L47
            int r6 = com.yoti.mobile.android.commons.p051ui.widgets.C4584R.id.feedbackMessage
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextSwitcher r6 = (android.widget.TextSwitcher) r6
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            int r3 = com.yoti.mobile.android.commons.p051ui.widgets.C4584R.id.feedbackStatusAnimation
            android.view.View r3 = r5.findViewById(r3)
            com.airbnb.lottie.LottieAnimationView r3 = (com.airbnb.lottie.LottieAnimationView) r3
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            android.content.Context r1 = r5.getContext()
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r1 = "context.getString(it)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        L43:
            r4.m4500a(r6, r3, r0)
            goto L96
        L47:
            int r6 = com.yoti.mobile.android.commons.p051ui.widgets.C4584R.id.feedbackMessage
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextSwitcher r6 = (android.widget.TextSwitcher) r6
            android.content.Context r1 = r5.getContext()
            java.lang.String r0 = r1.getString(r0)
        L57:
            r6.setText(r0)
            r4.m4498a()
            goto L96
        L5e:
            java.lang.String r0 = r6.getMessageText()
            if (r0 == 0) goto La8
            boolean r3 = r6.getShouldAnimate()
            if (r3 == 0) goto L8d
            java.lang.String r6 = r6.getStatusAnimation()
            if (r6 == 0) goto L8d
            boolean r6 = r4.m4504a(r5)
            if (r6 == 0) goto L8d
            int r6 = com.yoti.mobile.android.commons.p051ui.widgets.C4584R.id.feedbackMessage
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextSwitcher r6 = (android.widget.TextSwitcher) r6
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            int r3 = com.yoti.mobile.android.commons.p051ui.widgets.C4584R.id.feedbackStatusAnimation
            android.view.View r3 = r5.findViewById(r3)
            com.airbnb.lottie.LottieAnimationView r3 = (com.airbnb.lottie.LottieAnimationView) r3
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            goto L43
        L8d:
            int r6 = com.yoti.mobile.android.commons.p051ui.widgets.C4584R.id.feedbackMessage
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextSwitcher r6 = (android.widget.TextSwitcher) r6
            goto L57
        L96:
            int r6 = com.yoti.mobile.android.commons.p051ui.widgets.C4584R.id.feedbackMessage
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextSwitcher r6 = (android.widget.TextSwitcher) r6
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            r0 = 0
            r6.setVisibility(r0)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            goto La9
        La8:
            r6 = 0
        La9:
            if (r6 == 0) goto Lac
            goto Lb9
        Lac:
            int r6 = com.yoti.mobile.android.commons.p051ui.widgets.C4584R.id.feedbackMessage
            android.view.View r5 = r5.findViewById(r6)
            android.widget.TextSwitcher r5 = (android.widget.TextSwitcher) r5
            r6 = 8
            r5.setVisibility(r6)
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.common.p049ui.widgets.YotiFeedbackContainer.m4506b(android.view.View, com.yoti.mobile.android.common.ui.widgets.FeedbackItem):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m4507b(FeedbackItem feedbackItem) {
        View view = this.feedbackUuidViewMap.get(feedbackItem.getUuid());
        if (view == null) {
            m4498a();
            return;
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        m4499a(view, feedbackItem);
        m4510c(view, feedbackItem);
        m4506b(view, feedbackItem);
        m4502a(feedbackItem, view);
    }

    /* JADX INFO: renamed from: b */
    private final boolean m4508b() {
        return this.eventToProcess.size() == 1;
    }

    /* JADX INFO: renamed from: c */
    private final void m4509c() {
        if (this.eventToProcess.size() > 0) {
            ((Function0) CollectionsKt.first((List) this.eventToProcess)).invoke();
        }
    }

    /* JADX INFO: renamed from: c */
    private final void m4510c(final View view, final FeedbackItem feedbackItem) {
        Integer status = feedbackItem.getStatus();
        if (status != null) {
            final int iIntValue = status.intValue();
            if (feedbackItem.getShouldAnimate() && feedbackItem.getStatusAnimation() != null) {
                ((LottieAnimationView) view.findViewById(C4584R.id.feedbackStatusAnimation)).setAnimation(feedbackItem.getStatusAnimation());
                ((LottieAnimationView) view.findViewById(C4584R.id.feedbackStatusAnimation)).addAnimatorListener(new Animator.AnimatorListener(iIntValue, view, feedbackItem) { // from class: com.yoti.mobile.android.common.ui.widgets.YotiFeedbackContainer$updateStatusIcon$$inlined$let$lambda$1

                    /* JADX INFO: renamed from: a */
                    final /* synthetic */ int f6131a;

                    /* JADX INFO: renamed from: b */
                    final /* synthetic */ View f6132b;

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        ((ImageView) this.f6132b.findViewById(C4584R.id.feedbackStatus)).setImageResource(this.f6131a);
                        LottieAnimationView feedbackStatusAnimation = (LottieAnimationView) this.f6132b.findViewById(C4584R.id.feedbackStatusAnimation);
                        Intrinsics.checkNotNullExpressionValue(feedbackStatusAnimation, "feedbackStatusAnimation");
                        feedbackStatusAnimation.setVisibility(8);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        ((ImageView) this.f6132b.findViewById(C4584R.id.feedbackStatus)).setImageResource(this.f6131a);
                        LottieAnimationView feedbackStatusAnimation = (LottieAnimationView) this.f6132b.findViewById(C4584R.id.feedbackStatusAnimation);
                        Intrinsics.checkNotNullExpressionValue(feedbackStatusAnimation, "feedbackStatusAnimation");
                        feedbackStatusAnimation.setVisibility(8);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animation) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation) {
                        LottieAnimationView feedbackStatusAnimation = (LottieAnimationView) this.f6132b.findViewById(C4584R.id.feedbackStatusAnimation);
                        Intrinsics.checkNotNullExpressionValue(feedbackStatusAnimation, "feedbackStatusAnimation");
                        feedbackStatusAnimation.setVisibility(0);
                    }
                });
            } else {
                ((ImageView) view.findViewById(C4584R.id.feedbackStatus)).setImageResource(iIntValue);
                LottieAnimationView feedbackStatusAnimation = (LottieAnimationView) view.findViewById(C4584R.id.feedbackStatusAnimation);
                Intrinsics.checkNotNullExpressionValue(feedbackStatusAnimation, "feedbackStatusAnimation");
                feedbackStatusAnimation.setVisibility(8);
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6107e;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f6107e == null) {
            this.f6107e = new HashMap();
        }
        View view = (View) this.f6107e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f6107e.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void addFeedbackItem(FeedbackItem feedbackItem) {
        Intrinsics.checkNotNullParameter(feedbackItem, "feedbackItem");
        this.eventToProcess.add(new C4500a(feedbackItem));
        if (m4508b()) {
            m4509c();
        }
    }

    public final void clearFeedbackItems() {
        removeAllViews();
        this.feedbackUuidViewMap.clear();
        this.eventToProcess.clear();
        OnFeedbackVisibilityUpdate onFeedbackVisibilityUpdate = this.feedbackVisibilityListener;
        if (onFeedbackVisibilityUpdate != null) {
            onFeedbackVisibilityUpdate.notifyFeedbackCountChanges(getChildCount());
        }
    }

    public final OnFeedbackInteraction getFeedbackListener() {
        return this.feedbackListener;
    }

    public final OnFeedbackVisibilityUpdate getFeedbackVisibilityListener() {
        return this.feedbackVisibilityListener;
    }

    public final void removeFeedbackItem(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.eventToProcess.add(new C4505f(uuid));
        if (m4508b()) {
            m4509c();
        }
    }

    public final void setFeedbackListener(OnFeedbackInteraction onFeedbackInteraction) {
        this.feedbackListener = onFeedbackInteraction;
    }

    public final void setFeedbackVisibilityListener(OnFeedbackVisibilityUpdate onFeedbackVisibilityUpdate) {
        this.feedbackVisibilityListener = onFeedbackVisibilityUpdate;
    }

    public final void updateFeedbackItem(FeedbackItem feedbackItem) {
        Intrinsics.checkNotNullParameter(feedbackItem, "feedbackItem");
        this.eventToProcess.add(new C4506g(feedbackItem));
        if (m4508b()) {
            m4509c();
        }
    }
}
