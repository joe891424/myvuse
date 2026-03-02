package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.yoti.mobile.android.common.p049ui.widgets.utils.UiWidgetExtensionsKt;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.JsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ1\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010 *\u00020!2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00028\u00000\"H\u0086\bø\u0001\u0000¢\u0006\u0004\b$\u0010%\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006-"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiFeedbackButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "nbOfFeedbackDisplayed", "", "a", "(I)V", "", "mainText", "setText", "(Ljava/lang/CharSequence;)V", "subText", "setSubText", "", "show", "showRightIcon", "(Z)V", "showEndIcon", "clearFeedbackItems", "()V", "", AnalyticsAttribute.UUID_ATTRIBUTE, "removeFeedbackItem", "(Ljava/lang/String;)V", "Lcom/yoti/mobile/android/common/ui/widgets/FeedbackItem;", "feedbackItem", "addFeedbackItem", "(Lcom/yoti/mobile/android/common/ui/widgets/FeedbackItem;)V", "updateFeedbackItem", "Lcom/yoti/mobile/android/common/ui/widgets/YotiFeedbackContainer;", "getFeedbackContainer", "()Lcom/yoti/mobile/android/common/ui/widgets/YotiFeedbackContainer;", "R", "Landroid/content/res/TypedArray;", "Lkotlin/Function1;", "block", JsonWebKey.USE_PARAMETER, "(Landroid/content/res/TypedArray;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class YotiFeedbackButton extends ConstraintLayout {

    /* JADX INFO: renamed from: a */
    private HashMap f6101a;

    public YotiFeedbackButton(Context context) {
        this(context, null, 0, 6, null);
    }

    public YotiFeedbackButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiFeedbackButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, C4584R.layout.view_yoti_feedback_button, this);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, C4584R.styleable.YotiFeedbackButton, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArray, "typedArray");
        Drawable drawable = typedArray.getDrawable(C4584R.styleable.YotiFeedbackButton_drawableStart);
        drawable = drawable == null ? typedArray.getDrawable(C4584R.styleable.YotiFeedbackButton_drawableLeft) : drawable;
        String string = typedArray.getString(C4584R.styleable.YotiFeedbackButton_text);
        string = string == null ? "" : string;
        String string2 = typedArray.getString(C4584R.styleable.YotiFeedbackButton_subtext);
        String str = string2 != null ? string2 : "";
        Integer styleableResIfPresent = UiWidgetExtensionsKt.getStyleableResIfPresent(typedArray, C4584R.styleable.YotiFeedbackButton_showEndIcon, C4584R.styleable.YotiFeedbackButton_showRightIcon);
        boolean z = styleableResIfPresent != null ? typedArray.getBoolean(styleableResIfPresent.intValue(), true) : true;
        typedArray.recycle();
        ((YotiFeedbackContainer) _$_findCachedViewById(C4584R.id.feedbackContainer)).setFeedbackVisibilityListener(new OnFeedbackVisibilityUpdate() { // from class: com.yoti.mobile.android.common.ui.widgets.YotiFeedbackButton.2
            @Override // com.yoti.mobile.android.common.p049ui.widgets.OnFeedbackVisibilityUpdate
            public void notifyFeedbackCountChanges(int nbOfFeedbackDisplayed) {
                YotiFeedbackButton.this.m4497a(nbOfFeedbackDisplayed);
            }
        });
        setClickable(true);
        ((ImageView) _$_findCachedViewById(C4584R.id.startIcon)).setImageDrawable(drawable);
        setText(string);
        setSubText(str);
        showEndIcon(z);
    }

    public /* synthetic */ YotiFeedbackButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m4497a(int nbOfFeedbackDisplayed) {
        View view_$_findCachedViewById;
        int i;
        if (nbOfFeedbackDisplayed == 0) {
            view_$_findCachedViewById = _$_findCachedViewById(C4584R.id.backgroundView);
            i = C4584R.drawable.feedback_button_top_bg;
        } else {
            view_$_findCachedViewById = _$_findCachedViewById(C4584R.id.backgroundView);
            i = C4584R.drawable.feedback_button_top_bg_expanded;
        }
        view_$_findCachedViewById.setBackgroundResource(i);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6101a;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f6101a == null) {
            this.f6101a = new HashMap();
        }
        View view = (View) this.f6101a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f6101a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void addFeedbackItem(FeedbackItem feedbackItem) {
        Intrinsics.checkNotNullParameter(feedbackItem, "feedbackItem");
        ((YotiFeedbackContainer) _$_findCachedViewById(C4584R.id.feedbackContainer)).addFeedbackItem(feedbackItem);
    }

    public final void clearFeedbackItems() {
        ((YotiFeedbackContainer) _$_findCachedViewById(C4584R.id.feedbackContainer)).clearFeedbackItems();
    }

    public final YotiFeedbackContainer getFeedbackContainer() {
        YotiFeedbackContainer feedbackContainer = (YotiFeedbackContainer) _$_findCachedViewById(C4584R.id.feedbackContainer);
        Intrinsics.checkNotNullExpressionValue(feedbackContainer, "feedbackContainer");
        return feedbackContainer;
    }

    public final void removeFeedbackItem(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        ((YotiFeedbackContainer) _$_findCachedViewById(C4584R.id.feedbackContainer)).removeFeedbackItem(uuid);
    }

    public final void setSubText(CharSequence subText) {
        TextView subTextView = (TextView) _$_findCachedViewById(C4584R.id.subTextView);
        Intrinsics.checkNotNullExpressionValue(subTextView, "subTextView");
        subTextView.setText(subText);
        TextView subTextView2 = (TextView) _$_findCachedViewById(C4584R.id.subTextView);
        Intrinsics.checkNotNullExpressionValue(subTextView2, "subTextView");
        subTextView2.setVisibility((subText == null || subText.length() == 0) ? 8 : 0);
    }

    public final void setText(CharSequence mainText) {
        Intrinsics.checkNotNullParameter(mainText, "mainText");
        TextView mainTextView = (TextView) _$_findCachedViewById(C4584R.id.mainTextView);
        Intrinsics.checkNotNullExpressionValue(mainTextView, "mainTextView");
        mainTextView.setText(mainText);
    }

    public final void showEndIcon(boolean show) {
        ImageView endIcon = (ImageView) _$_findCachedViewById(C4584R.id.endIcon);
        Intrinsics.checkNotNullExpressionValue(endIcon, "endIcon");
        endIcon.setVisibility(show ? 0 : 8);
    }

    @Deprecated(message = "Functionality moved to showEndIcon()", replaceWith = @ReplaceWith(expression = "YotiFeedbackButton.showEndIcon()", imports = {}))
    public final void showRightIcon(boolean show) {
        showEndIcon(show);
    }

    public final void updateFeedbackItem(FeedbackItem feedbackItem) {
        Intrinsics.checkNotNullParameter(feedbackItem, "feedbackItem");
        ((YotiFeedbackContainer) _$_findCachedViewById(C4584R.id.feedbackContainer)).updateFeedbackItem(feedbackItem);
    }

    public final <R> R use(TypedArray use, Function1<? super TypedArray, ? extends R> block) {
        Intrinsics.checkNotNullParameter(use, "$this$use");
        Intrinsics.checkNotNullParameter(block, "block");
        R rInvoke = block.invoke(use);
        use.recycle();
        return rInvoke;
    }
}
