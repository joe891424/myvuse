package com.yoti.mobile.android.common.p049ui.widgets;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.expandable.ExpandableWidget;
import com.yoti.mobile.android.common.p049ui.widgets.utils.AnimationUtils;
import com.yoti.mobile.android.common.p049ui.widgets.utils.UiWidgetExtensionsKt;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001EB'\b\u0007\u0012\u0006\u0010A\u001a\u00020@\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010B\u001a\u00020\u000e¢\u0006\u0004\bC\u0010DJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\tJ\u0019\u0010\u0010\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0006\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\tJ\r\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\tJ\u0017\u0010\u0018\u001a\u00020\u00052\b\b\u0001\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0011J\u0015\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0019¢\u0006\u0004\b\u0018\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u0011J\u0015\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0010\u0010\u0014J\u0017\u0010\u001d\u001a\u00020\u00052\b\b\u0001\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u0011J\u0015\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001aJ\u0015\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010\tJ\u0017\u0010$\u001a\u00020\u00052\b\b\u0001\u0010#\u001a\u00020\u000e¢\u0006\u0004\b$\u0010\u0011J\u0017\u0010&\u001a\u00020\u00052\b\b\u0001\u0010%\u001a\u00020\u000e¢\u0006\u0004\b&\u0010\u0011J\u0015\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000e¢\u0006\u0004\b(\u0010\u0011J\u0017\u0010*\u001a\u00020\u00052\b\b\u0001\u0010)\u001a\u00020\u000e¢\u0006\u0004\b*\u0010\u0011J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020+2\u0006\u0010.\u001a\u00020+H\u0016¢\u0006\u0004\b/\u00100R*\u00106\u001a\u00020+2\u0006\u00101\u001a\u00020+8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u00102\u001a\u0004\b3\u0010-\"\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0016\u0010<\u001a\u0002078B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010=R*\u00101\u001a\u00020+2\u0006\u0010\u0017\u001a\u00020+8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u00102\u001a\u0004\b?\u0010-\"\u0004\b/\u00105¨\u0006F"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiAccordion;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/google/android/material/expandable/ExpandableWidget;", "Landroid/util/AttributeSet;", "attrs", "", "a", "(Landroid/util/AttributeSet;)V", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "()V", "g", "f", "c", "b", "", "layoutId", "setAccordionChildView", "(I)V", "Landroid/view/View;", "childView", "(Landroid/view/View;)V", "d", "toggle", "value", "setTitle", "", "(Ljava/lang/String;)V", "textAppearanceResId", "setTitleAppearance", "setDescription", "Lcom/yoti/mobile/android/common/ui/widgets/YotiAccordion$ExpansionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setExpansionListener", "(Lcom/yoti/mobile/android/common/ui/widgets/YotiAccordion$ExpansionListener;)V", "removeExpansionListener", "drawableRes", "setExpandIcon", "tintColorRes", "setExpandIconTint", "tint", "setExpandIconColorTint", "paddingRes", "setHeaderPadding", "", "isExpanded", "()Z", "expand", "setExpanded", "(Z)Z", "expanded", "Z", "getAlwaysExpanded", "setAlwaysExpanded", "(Z)V", "alwaysExpanded", "", "getCollapseRotation", "()F", "collapseRotation", "getExpandRotation", "expandRotation", "Lcom/yoti/mobile/android/common/ui/widgets/YotiAccordion$ExpansionListener;", "expansionListener", "getExpanded", "Landroid/content/Context;", "context", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ExpansionListener", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class YotiAccordion extends ConstraintLayout implements ExpandableWidget {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private ExpansionListener expansionListener;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private boolean alwaysExpanded;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private boolean expanded;

    /* JADX INFO: renamed from: d */
    private HashMap f6003d;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiAccordion$ExpansionListener;", "", "", "expanded", "", "onExpansionChanged", "(Z)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public interface ExpansionListener {
        void onExpansionChanged(boolean expanded);
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextIconStrategy.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TextIconStrategy.EXPANDED.ordinal()] = 1;
            iArr[TextIconStrategy.WRAP.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiAccordion$a */
    static final class ViewOnClickListenerC4480a implements View.OnClickListener {
        ViewOnClickListenerC4480a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            YotiAccordion.this.toggle();
        }
    }

    public YotiAccordion(Context context) {
        this(context, null, 0, 6, null);
    }

    public YotiAccordion(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiAccordion(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout.inflate(context, C4584R.layout.view_accordion, this);
        m4411e();
        m4406a(attributeSet);
    }

    public /* synthetic */ YotiAccordion(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m4405a() {
        Context context;
        int i;
        StringBuilder sb = new StringBuilder();
        TextView title = (TextView) _$_findCachedViewById(C4584R.id.title);
        Intrinsics.checkNotNullExpressionValue(title, "title");
        StringBuilder sbAppend = sb.append(title.getText()).append(". ");
        if (this.expanded) {
            context = getContext();
            i = C4584R.string.loc_accordion_expand_state_accessibility;
        } else {
            context = getContext();
            i = C4584R.string.loc_accordion_collapse_state_accessibility;
        }
        announceForAccessibility(sbAppend.append(context.getString(i)).toString());
    }

    /* JADX INFO: renamed from: a */
    private final void m4406a(AttributeSet attrs) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, C4584R.styleable.YotiAccordion, 0, 0);
        try {
            String string = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiAccordion_yotiAccordionTitle);
            if (string != null) {
                TextView title = (TextView) _$_findCachedViewById(C4584R.id.title);
                Intrinsics.checkNotNullExpressionValue(title, "title");
                title.setText(string);
            }
            TextViewCompat.setTextAppearance((TextView) _$_findCachedViewById(C4584R.id.title), typedArrayObtainStyledAttributes.getResourceId(C4584R.styleable.YotiAccordion_yotiAccordionTitleTextAppearance, C4584R.style.Yoti_v3_Font_TitleSmall_Accordion));
            int dimension = (int) typedArrayObtainStyledAttributes.getResources().getDimension(typedArrayObtainStyledAttributes.getResourceId(C4584R.styleable.YotiAccordion_yotiAccordionTitleDescriptionMargin, C4584R.dimen.accordion_description_top_margin));
            TextView description = (TextView) _$_findCachedViewById(C4584R.id.description);
            Intrinsics.checkNotNullExpressionValue(description, "description");
            ViewGroup.LayoutParams layoutParams = description.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = dimension;
            TextView description2 = (TextView) _$_findCachedViewById(C4584R.id.description);
            Intrinsics.checkNotNullExpressionValue(description2, "description");
            description2.setLayoutParams(marginLayoutParams);
            int i = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.YotiAccordion_yotiAccordionTitleIconTextStrategy, TextIconStrategy.EXPANDED.m4399a());
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone((ConstraintLayout) _$_findCachedViewById(C4584R.id.titleBar));
            int i2 = WhenMappings.$EnumSwitchMapping$0[TextIconStrategy.f5969e.fromAttributeValue(i).ordinal()];
            if (i2 == 1) {
                constraintSet.constrainDefaultWidth(C4584R.id.title, 0);
            } else if (i2 == 2) {
                constraintSet.constrainDefaultWidth(C4584R.id.title, 1);
            }
            constraintSet.applyTo((ConstraintLayout) _$_findCachedViewById(C4584R.id.titleBar));
            String string2 = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiAccordion_yotiAccordionDescription);
            if (string2 != null) {
                TextView description3 = (TextView) _$_findCachedViewById(C4584R.id.description);
                Intrinsics.checkNotNullExpressionValue(description3, "description");
                description3.setText(string2);
            }
            if (typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiAccordion_yotiAccordionExpanded, false)) {
                m4413g();
            } else {
                m4412f();
            }
            ((ImageView) _$_findCachedViewById(C4584R.id.expandImage)).setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(C4584R.styleable.YotiAccordion_yotiAccordionExpandedIcon));
            int i3 = C4584R.styleable.YotiAccordion_yotiAccordionExpandedIconTint;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            Resources.Theme theme = context2.getTheme();
            Intrinsics.checkNotNullExpressionValue(theme, "context.theme");
            setExpandIconColorTint(typedArrayObtainStyledAttributes.getColor(i3, UiWidgetExtensionsKt.getColorFromAttribute(theme, YotiAccordionKt.f6010a)));
            setAccordionChildView(typedArrayObtainStyledAttributes.getResourceId(C4584R.styleable.YotiAccordion_yotiAccordionChildLayout, 0));
            Float fValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(C4584R.styleable.YotiAccordion_yotiAccordionHeaderPadding, -1.0f));
            if (Float.compare(fValueOf.floatValue(), -1.0f) < 0) {
                fValueOf = null;
            }
            if (fValueOf != null) {
                int iFloatValue = (int) fValueOf.floatValue();
                ((ConstraintLayout) _$_findCachedViewById(C4584R.id.titleBar)).setPaddingRelative(iFloatValue, iFloatValue, iFloatValue, iFloatValue);
            }
            setAlwaysExpanded(typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiAccordion_yotiAccordionAlwaysExpanded, false));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m4407a(View childView) {
        ((FrameLayout) _$_findCachedViewById(C4584R.id.accordionChildView)).removeAllViews();
        ((FrameLayout) _$_findCachedViewById(C4584R.id.accordionChildView)).addView(childView);
    }

    /* JADX INFO: renamed from: b */
    private final void m4408b() {
        if (!this.expanded || this.alwaysExpanded) {
            return;
        }
        ((FrameLayout) _$_findCachedViewById(C4584R.id.accordionChildView)).animate().setListener(new AnimationUtils.OnAnimationEnd() { // from class: com.yoti.mobile.android.common.ui.widgets.YotiAccordion$collapseAccordion$1
            @Override // com.yoti.mobile.android.common.ui.widgets.utils.AnimationUtils.OnAnimationEnd, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrameLayout accordionChildView = (FrameLayout) this.f6005a._$_findCachedViewById(C4584R.id.accordionChildView);
                Intrinsics.checkNotNullExpressionValue(accordionChildView, "accordionChildView");
                accordionChildView.setVisibility(8);
                this.f6005a.setExpanded(false);
                this.f6005a.m4405a();
            }
        }).setDuration(333L).alpha(0.0f).start();
        ((ImageView) _$_findCachedViewById(C4584R.id.expandImage)).animate().setDuration(333L).rotation(getCollapseRotation()).start();
    }

    /* JADX INFO: renamed from: c */
    private final void m4409c() {
        if (this.expanded) {
            return;
        }
        setExpanded(true);
        ((FrameLayout) _$_findCachedViewById(C4584R.id.accordionChildView)).animate().setListener(new AnimationUtils.OnAnimationStart() { // from class: com.yoti.mobile.android.common.ui.widgets.YotiAccordion$expandAccordion$1
            @Override // com.yoti.mobile.android.common.ui.widgets.utils.AnimationUtils.OnAnimationStart, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                FrameLayout accordionChildView = (FrameLayout) this.f6006a._$_findCachedViewById(C4584R.id.accordionChildView);
                Intrinsics.checkNotNullExpressionValue(accordionChildView, "accordionChildView");
                accordionChildView.setVisibility(0);
                this.f6006a.m4405a();
            }
        }).setDuration(333L).alpha(1.0f).start();
        ((ImageView) _$_findCachedViewById(C4584R.id.expandImage)).animate().setDuration(333L).rotation(getExpandRotation()).start();
    }

    /* JADX INFO: renamed from: d */
    private final void m4410d() {
        ViewCompat.setAccessibilityDelegate((ConstraintLayout) _$_findCachedViewById(C4584R.id.titleBar), new AccessibilityDelegateCompat() { // from class: com.yoti.mobile.android.common.ui.widgets.YotiAccordion$setAccessibilityDelegate$1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                super.onInitializeAccessibilityEvent(host, event);
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                Context context;
                int i;
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                ConstraintLayout titleBar = (ConstraintLayout) this.f6007a._$_findCachedViewById(C4584R.id.titleBar);
                Intrinsics.checkNotNullExpressionValue(titleBar, "titleBar");
                StringBuilder sb = new StringBuilder();
                TextView title = (TextView) this.f6007a._$_findCachedViewById(C4584R.id.title);
                Intrinsics.checkNotNullExpressionValue(title, "title");
                titleBar.setContentDescription(sb.append(title.getText()).append(". ").append(this.f6007a.getContext().getString(C4584R.string.loc_button_accessibility)).toString());
                if (this.f6007a.getAlwaysExpanded()) {
                    info.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
                    info.setClickable(false);
                    return;
                }
                if (this.f6007a.getExpanded()) {
                    context = this.f6007a.getContext();
                    i = C4584R.string.loc_accordion_collapse_accessibility;
                } else {
                    context = this.f6007a.getContext();
                    i = C4584R.string.loc_accordion_expand_accessibility;
                }
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, context.getString(i)));
            }
        });
    }

    /* JADX INFO: renamed from: e */
    private final void m4411e() {
        ((ConstraintLayout) _$_findCachedViewById(C4584R.id.titleBar)).setOnClickListener(new ViewOnClickListenerC4480a());
        m4412f();
        m4410d();
    }

    /* JADX INFO: renamed from: f */
    private final void m4412f() {
        setExpanded(false);
        FrameLayout accordionChildView = (FrameLayout) _$_findCachedViewById(C4584R.id.accordionChildView);
        Intrinsics.checkNotNullExpressionValue(accordionChildView, "accordionChildView");
        accordionChildView.setVisibility(8);
        if (!ViewCompat.isLaidOut(this) || isLayoutRequested()) {
            addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yoti.mobile.android.common.ui.widgets.YotiAccordion$startCollapsed$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    Intrinsics.checkParameterIsNotNull(view, "view");
                    view.removeOnLayoutChangeListener(this);
                    ImageView expandImage = (ImageView) this.f6008a._$_findCachedViewById(C4584R.id.expandImage);
                    Intrinsics.checkNotNullExpressionValue(expandImage, "expandImage");
                    expandImage.setRotation(this.f6008a.getCollapseRotation());
                }
            });
            return;
        }
        ImageView expandImage = (ImageView) _$_findCachedViewById(C4584R.id.expandImage);
        Intrinsics.checkNotNullExpressionValue(expandImage, "expandImage");
        expandImage.setRotation(getCollapseRotation());
    }

    /* JADX INFO: renamed from: g */
    private final void m4413g() {
        setExpanded(true);
        FrameLayout accordionChildView = (FrameLayout) _$_findCachedViewById(C4584R.id.accordionChildView);
        Intrinsics.checkNotNullExpressionValue(accordionChildView, "accordionChildView");
        accordionChildView.setVisibility(0);
        if (!ViewCompat.isLaidOut(this) || isLayoutRequested()) {
            addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yoti.mobile.android.common.ui.widgets.YotiAccordion$startExpanded$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    Intrinsics.checkParameterIsNotNull(view, "view");
                    view.removeOnLayoutChangeListener(this);
                    ImageView expandImage = (ImageView) this.f6009a._$_findCachedViewById(C4584R.id.expandImage);
                    Intrinsics.checkNotNullExpressionValue(expandImage, "expandImage");
                    expandImage.setRotation(this.f6009a.getExpandRotation());
                }
            });
            return;
        }
        ImageView expandImage = (ImageView) _$_findCachedViewById(C4584R.id.expandImage);
        Intrinsics.checkNotNullExpressionValue(expandImage, "expandImage");
        expandImage.setRotation(getExpandRotation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getCollapseRotation() {
        return getLayoutDirection() == 0 ? 90.0f : -90.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getExpandRotation() {
        return getLayoutDirection() == 0 ? -90.0f : 90.0f;
    }

    private final void setAccordionChildView(int layoutId) {
        if (layoutId != 0) {
            View childView = LayoutInflater.from(getContext()).inflate(layoutId, (ViewGroup) _$_findCachedViewById(C4584R.id.accordionChildView), false);
            Intrinsics.checkNotNullExpressionValue(childView, "childView");
            m4407a(childView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setExpanded(boolean z) {
        this.expanded = z;
        ExpansionListener expansionListener = this.expansionListener;
        if (expansionListener != null) {
            expansionListener.onExpansionChanged(z);
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6003d;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f6003d == null) {
            this.f6003d = new HashMap();
        }
        View view = (View) this.f6003d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f6003d.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final boolean getAlwaysExpanded() {
        return this.alwaysExpanded;
    }

    public final boolean getExpanded() {
        return this.expanded;
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public boolean isExpanded() {
        return this.expanded;
    }

    public final void removeExpansionListener() {
        this.expansionListener = null;
    }

    public final void setAccordionChildView(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        m4407a(childView);
    }

    public final void setAlwaysExpanded(boolean z) {
        this.alwaysExpanded = z;
        if (z) {
            m4409c();
        }
    }

    public final void setDescription(int value) {
        ((TextView) _$_findCachedViewById(C4584R.id.description)).setText(value);
    }

    public final void setDescription(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        TextView description = (TextView) _$_findCachedViewById(C4584R.id.description);
        Intrinsics.checkNotNullExpressionValue(description, "description");
        description.setText(value);
    }

    public final void setExpandIcon(int drawableRes) {
        ((ImageView) _$_findCachedViewById(C4584R.id.expandImage)).setImageResource(drawableRes);
    }

    public final void setExpandIconColorTint(int tint) {
        ImageView expandImage = (ImageView) _$_findCachedViewById(C4584R.id.expandImage);
        Intrinsics.checkNotNullExpressionValue(expandImage, "expandImage");
        expandImage.setImageTintList(ColorStateList.valueOf(tint));
    }

    public final void setExpandIconTint(int tintColorRes) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setExpandIconColorTint(context.getResources().getColor(tintColorRes));
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    /* JADX INFO: renamed from: setExpanded, reason: collision with other method in class */
    public boolean mo6779setExpanded(boolean expand) {
        if (expand) {
            m4409c();
            return true;
        }
        m4408b();
        return true;
    }

    public final void setExpansionListener(ExpansionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.expansionListener = listener;
    }

    public final void setHeaderPadding(int paddingRes) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int dimension = (int) context.getResources().getDimension(paddingRes);
        ((ConstraintLayout) _$_findCachedViewById(C4584R.id.titleBar)).setPaddingRelative(dimension, dimension, dimension, dimension);
    }

    public final void setTitle(int value) {
        ((TextView) _$_findCachedViewById(C4584R.id.title)).setText(value);
    }

    public final void setTitle(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        TextView title = (TextView) _$_findCachedViewById(C4584R.id.title);
        Intrinsics.checkNotNullExpressionValue(title, "title");
        title.setText(value);
    }

    public final void setTitleAppearance(int textAppearanceResId) {
        TextViewCompat.setTextAppearance((TextView) _$_findCachedViewById(C4584R.id.title), textAppearanceResId);
    }

    public final void toggle() {
        if (this.expanded) {
            m4408b();
        } else {
            m4409c();
        }
    }
}
