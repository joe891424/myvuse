package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003/01B'\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010,\u001a\u00020\u0010¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0007\u0010\nJ/\u0010\u0006\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0006\u0010\u0013J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0006\u0010\u0015J\u001f\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0007\u0010\u0018J\u001f\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0006\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010!\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001f¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0002¢\u0006\u0004\b#\u0010\u0004R\u0018\u0010%\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010$R\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010&R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010'¨\u00062"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiCoachMark;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "c", "()V", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "a", "b", "Lcom/yoti/mobile/android/common/ui/widgets/YotiCoachMark$CoachView;", "target", "(Lcom/yoti/mobile/android/common/ui/widgets/YotiCoachMark$CoachView;)V", "d", "Lcom/yoti/mobile/android/common/ui/widgets/YotiCoachMark$HorizontalPosition;", "viewHorizontalPosition", "", "isViewBottomScreen", "", "viewY", "viewHeight", "(Lcom/yoti/mobile/android/common/ui/widgets/YotiCoachMark$HorizontalPosition;ZII)V", "viewCentrePoint", "(IZ)V", "yPosition", "screenHeight", "(II)Z", "screenWidth", "(II)Lcom/yoti/mobile/android/common/ui/widgets/YotiCoachMark$HorizontalPosition;", "Lcom/yoti/mobile/android/common/ui/widgets/YotiCoachMark$CoachMarkListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/yoti/mobile/android/common/ui/widgets/YotiCoachMark$CoachMarkListener;)V", "Ljava/util/Queue;", "targets", "show", "(Ljava/util/Queue;)V", "dismiss", "Lcom/yoti/mobile/android/common/ui/widgets/YotiCoachMark$CoachView;", "drawTargetWhenReady", "Ljava/util/Queue;", "Lcom/yoti/mobile/android/common/ui/widgets/YotiCoachMark$CoachMarkListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CoachMarkListener", "CoachView", "HorizontalPosition", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class YotiCoachMark extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private CoachView drawTargetWhenReady;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private Queue<CoachView> targets;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private CoachMarkListener listener;

    /* JADX INFO: renamed from: d */
    private HashMap f6024d;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiCoachMark$CoachMarkListener;", "", "", "onCoachMarkComplete", "()V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public interface CoachMarkListener {
        void onCoachMarkComplete();
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007JL\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0003\u0010\r\u001a\u00020\u00052\b\b\u0003\u0010\u000e\u001a\u00020\u00052\b\b\u0003\u0010\u000f\u001a\u00020\u00052\b\b\u0003\u0010\u0010\u001a\u00020\u00052\b\b\u0003\u0010\u0011\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u0007¨\u0006,"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiCoachMark$CoachView;", "", "Landroid/view/View;", "component1", "()Landroid/view/View;", "", "component2", "()I", "component3", "component4", "component5", "component6", "view", "titleResId", "descriptionResId", "nextResId", "gotItResId", "skipResId", "copy", "(Landroid/view/View;IIIII)Lcom/yoti/mobile/android/common/ui/widgets/YotiCoachMark$CoachView;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "I", "getTitleResId", "c", "getDescriptionResId", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "getGotItResId", "a", "Landroid/view/View;", "getView", "d", "getNextResId", "f", "getSkipResId", "<init>", "(Landroid/view/View;IIIII)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final /* data */ class CoachView {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final View view;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final int titleResId;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final int descriptionResId;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private final int nextResId;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private final int gotItResId;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private final int skipResId;

        public CoachView(View view, int i, int i2, int i3, int i4, int i5) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            this.titleResId = i;
            this.descriptionResId = i2;
            this.nextResId = i3;
            this.gotItResId = i4;
            this.skipResId = i5;
        }

        public /* synthetic */ CoachView(View view, int i, int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, i, i2, i3, i4, (i6 & 32) != 0 ? 0 : i5);
        }

        public static /* synthetic */ CoachView copy$default(CoachView coachView, View view, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                view = coachView.view;
            }
            if ((i6 & 2) != 0) {
                i = coachView.titleResId;
            }
            int i7 = i;
            if ((i6 & 4) != 0) {
                i2 = coachView.descriptionResId;
            }
            int i8 = i2;
            if ((i6 & 8) != 0) {
                i3 = coachView.nextResId;
            }
            int i9 = i3;
            if ((i6 & 16) != 0) {
                i4 = coachView.gotItResId;
            }
            int i10 = i4;
            if ((i6 & 32) != 0) {
                i5 = coachView.skipResId;
            }
            return coachView.copy(view, i7, i8, i9, i10, i5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final View getView() {
            return this.view;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTitleResId() {
            return this.titleResId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getDescriptionResId() {
            return this.descriptionResId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getNextResId() {
            return this.nextResId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getGotItResId() {
            return this.gotItResId;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getSkipResId() {
            return this.skipResId;
        }

        public final CoachView copy(View view, int titleResId, int descriptionResId, int nextResId, int gotItResId, int skipResId) {
            Intrinsics.checkNotNullParameter(view, "view");
            return new CoachView(view, titleResId, descriptionResId, nextResId, gotItResId, skipResId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CoachView)) {
                return false;
            }
            CoachView coachView = (CoachView) other;
            return Intrinsics.areEqual(this.view, coachView.view) && this.titleResId == coachView.titleResId && this.descriptionResId == coachView.descriptionResId && this.nextResId == coachView.nextResId && this.gotItResId == coachView.gotItResId && this.skipResId == coachView.skipResId;
        }

        public final int getDescriptionResId() {
            return this.descriptionResId;
        }

        public final int getGotItResId() {
            return this.gotItResId;
        }

        public final int getNextResId() {
            return this.nextResId;
        }

        public final int getSkipResId() {
            return this.skipResId;
        }

        public final int getTitleResId() {
            return this.titleResId;
        }

        public final View getView() {
            return this.view;
        }

        public int hashCode() {
            View view = this.view;
            return ((((((((((view != null ? view.hashCode() : 0) * 31) + Integer.hashCode(this.titleResId)) * 31) + Integer.hashCode(this.descriptionResId)) * 31) + Integer.hashCode(this.nextResId)) * 31) + Integer.hashCode(this.gotItResId)) * 31) + Integer.hashCode(this.skipResId);
        }

        public String toString() {
            return "CoachView(view=" + this.view + ", titleResId=" + this.titleResId + ", descriptionResId=" + this.descriptionResId + ", nextResId=" + this.nextResId + ", gotItResId=" + this.gotItResId + ", skipResId=" + this.skipResId + ")";
        }
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiCoachMark$HorizontalPosition;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "CENTER", "RIGHT", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public enum HorizontalPosition {
        LEFT,
        CENTER,
        RIGHT
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HorizontalPosition.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[HorizontalPosition.LEFT.ordinal()] = 1;
            iArr[HorizontalPosition.CENTER.ordinal()] = 2;
            iArr[HorizontalPosition.RIGHT.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiCoachMark$a */
    static final class ViewTreeObserverOnGlobalLayoutListenerC4482a implements ViewTreeObserver.OnGlobalLayoutListener {
        ViewTreeObserverOnGlobalLayoutListenerC4482a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            YotiCoachMark.this.m4429d();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiCoachMark$b */
    static final class ViewOnClickListenerC4483b implements View.OnClickListener {
        ViewOnClickListenerC4483b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            YotiCoachMark.this.m4428c();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiCoachMark$c */
    static final class ViewOnClickListenerC4484c implements View.OnClickListener {
        ViewOnClickListenerC4484c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            YotiCoachMark.this.m4430e();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiCoachMark$d */
    static final class RunnableC4485d implements Runnable {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ CoachView f6036b;

        RunnableC4485d(CoachView coachView) {
            this.f6036b = coachView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            YotiCoachMark.this.m4426b(this.f6036b);
        }
    }

    public YotiCoachMark(Context context) {
        this(context, null, 0, 6, null);
    }

    public YotiCoachMark(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiCoachMark(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout.inflate(context, C4584R.layout.yoti_coachmark, this);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC4482a());
        ((YotiButton) _$_findCachedViewById(C4584R.id.coachMarkNext)).setOnClickListener(new ViewOnClickListenerC4483b());
        ((YotiButton) _$_findCachedViewById(C4584R.id.coachMarkSkip)).setOnClickListener(new ViewOnClickListenerC4484c());
    }

    public /* synthetic */ YotiCoachMark(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: renamed from: a */
    private final HorizontalPosition m4420a(int viewCentrePoint, int screenWidth) {
        float f = viewCentrePoint;
        float f2 = screenWidth;
        return f < 0.475f * f2 ? HorizontalPosition.LEFT : f > f2 * 0.525f ? HorizontalPosition.RIGHT : HorizontalPosition.CENTER;
    }

    /* JADX INFO: renamed from: a */
    private final void m4421a() {
        CoachMarkListener coachMarkListener = this.listener;
        if (coachMarkListener != null) {
            coachMarkListener.onCoachMarkComplete();
        }
        m4425b();
    }

    /* JADX INFO: renamed from: a */
    private final void m4422a(int viewCentrePoint, boolean isViewBottomScreen) {
        View coachMarkPointerTop;
        float f;
        View coachMarkPointerTop2;
        if (isViewBottomScreen) {
            View coachMarkPointerTop3 = _$_findCachedViewById(C4584R.id.coachMarkPointerTop);
            Intrinsics.checkNotNullExpressionValue(coachMarkPointerTop3, "coachMarkPointerTop");
            coachMarkPointerTop3.setVisibility(8);
            View coachMarkPointerBottom = _$_findCachedViewById(C4584R.id.coachMarkPointerBottom);
            Intrinsics.checkNotNullExpressionValue(coachMarkPointerBottom, "coachMarkPointerBottom");
            coachMarkPointerBottom.setVisibility(0);
            coachMarkPointerTop = _$_findCachedViewById(C4584R.id.coachMarkPointerBottom);
            Intrinsics.checkNotNullExpressionValue(coachMarkPointerTop, "coachMarkPointerBottom");
            f = viewCentrePoint;
            coachMarkPointerTop2 = _$_findCachedViewById(C4584R.id.coachMarkPointerBottom);
            Intrinsics.checkNotNullExpressionValue(coachMarkPointerTop2, "coachMarkPointerBottom");
        } else {
            View coachMarkPointerTop4 = _$_findCachedViewById(C4584R.id.coachMarkPointerTop);
            Intrinsics.checkNotNullExpressionValue(coachMarkPointerTop4, "coachMarkPointerTop");
            coachMarkPointerTop4.setVisibility(0);
            View coachMarkPointerBottom2 = _$_findCachedViewById(C4584R.id.coachMarkPointerBottom);
            Intrinsics.checkNotNullExpressionValue(coachMarkPointerBottom2, "coachMarkPointerBottom");
            coachMarkPointerBottom2.setVisibility(8);
            coachMarkPointerTop = _$_findCachedViewById(C4584R.id.coachMarkPointerTop);
            Intrinsics.checkNotNullExpressionValue(coachMarkPointerTop, "coachMarkPointerTop");
            f = viewCentrePoint;
            coachMarkPointerTop2 = _$_findCachedViewById(C4584R.id.coachMarkPointerTop);
            Intrinsics.checkNotNullExpressionValue(coachMarkPointerTop2, "coachMarkPointerTop");
        }
        coachMarkPointerTop.setX(f - (coachMarkPointerTop2.getWidth() / 2.0f));
    }

    /* JADX INFO: renamed from: a */
    private final void m4423a(CoachView target) {
        if (!target.getView().isShown()) {
            this.drawTargetWhenReady = target;
            return;
        }
        Resources resources = getResources();
        TextView coachMarkTitle = (TextView) _$_findCachedViewById(C4584R.id.coachMarkTitle);
        Intrinsics.checkNotNullExpressionValue(coachMarkTitle, "coachMarkTitle");
        coachMarkTitle.setText(resources.getString(target.getTitleResId()));
        TextView coachMarkDescription = (TextView) _$_findCachedViewById(C4584R.id.coachMarkDescription);
        Intrinsics.checkNotNullExpressionValue(coachMarkDescription, "coachMarkDescription");
        coachMarkDescription.setText(resources.getString(target.getDescriptionResId()));
        Queue<CoachView> queue = this.targets;
        if ((queue != null ? queue.size() : 0) != 0) {
            YotiButton coachMarkNext = (YotiButton) _$_findCachedViewById(C4584R.id.coachMarkNext);
            Intrinsics.checkNotNullExpressionValue(coachMarkNext, "coachMarkNext");
            coachMarkNext.setText(resources.getString(target.getNextResId()));
            if (target.getSkipResId() != 0) {
                YotiButton coachMarkSkip = (YotiButton) _$_findCachedViewById(C4584R.id.coachMarkSkip);
                Intrinsics.checkNotNullExpressionValue(coachMarkSkip, "coachMarkSkip");
                coachMarkSkip.setText(resources.getString(target.getSkipResId()));
                YotiButton coachMarkSkip2 = (YotiButton) _$_findCachedViewById(C4584R.id.coachMarkSkip);
                Intrinsics.checkNotNullExpressionValue(coachMarkSkip2, "coachMarkSkip");
                coachMarkSkip2.setVisibility(0);
            }
            post(new RunnableC4485d(target));
        }
        YotiButton coachMarkNext2 = (YotiButton) _$_findCachedViewById(C4584R.id.coachMarkNext);
        Intrinsics.checkNotNullExpressionValue(coachMarkNext2, "coachMarkNext");
        coachMarkNext2.setText(resources.getString(target.getGotItResId()));
        YotiButton coachMarkSkip3 = (YotiButton) _$_findCachedViewById(C4584R.id.coachMarkSkip);
        Intrinsics.checkNotNullExpressionValue(coachMarkSkip3, "coachMarkSkip");
        coachMarkSkip3.setVisibility(8);
        post(new RunnableC4485d(target));
    }

    /* JADX INFO: renamed from: a */
    private final void m4424a(HorizontalPosition viewHorizontalPosition, boolean isViewBottomScreen, int viewY, int viewHeight) {
        float height;
        float f;
        if (isViewBottomScreen) {
            float f2 = viewY;
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            height = (f2 - (((ViewGroup.MarginLayoutParams) (layoutParams instanceof ViewGroup.MarginLayoutParams ? layoutParams : null)) != null ? r1.bottomMargin : 0)) - getHeight();
        } else {
            float f3 = viewY;
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            height = (f3 - (((ViewGroup.MarginLayoutParams) (layoutParams2 instanceof ViewGroup.MarginLayoutParams ? layoutParams2 : null)) != null ? r1.bottomMargin : 0)) + viewHeight;
        }
        setY(height);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone((ConstraintLayout) _$_findCachedViewById(C4584R.id.coachMarkParentLayout));
        int i = C4584R.id.coachMarkInnerParentLayout;
        int i2 = WhenMappings.$EnumSwitchMapping$0[viewHorizontalPosition.ordinal()];
        if (i2 == 1) {
            f = 0.0f;
        } else if (i2 == 2) {
            f = 0.5f;
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            f = 1.0f;
        }
        constraintSet.setHorizontalBias(i, f);
        constraintSet.applyTo((ConstraintLayout) _$_findCachedViewById(C4584R.id.coachMarkParentLayout));
    }

    /* JADX INFO: renamed from: b */
    private final void m4425b() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m4426b(CoachView target) {
        int[] iArr = new int[2];
        target.getView().getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int width = target.getView().getWidth();
        int height = target.getView().getHeight();
        int i3 = i + (width / 2);
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        int i4 = system.getDisplayMetrics().heightPixels;
        Resources system2 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system2, "Resources.getSystem()");
        int i5 = system2.getDisplayMetrics().widthPixels;
        boolean zM4427b = m4427b(i2, i4);
        HorizontalPosition horizontalPositionM4420a = m4420a(i3, i5);
        m4422a(i3, zM4427b);
        m4424a(horizontalPositionM4420a, zM4427b, i2, height);
    }

    /* JADX INFO: renamed from: b */
    private final boolean m4427b(int yPosition, int screenHeight) {
        return yPosition > screenHeight / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public final void m4428c() {
        Queue<CoachView> queue = this.targets;
        CoachView coachViewPoll = queue != null ? queue.poll() : null;
        if (coachViewPoll != null) {
            m4423a(coachViewPoll);
        } else {
            m4421a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public final void m4429d() {
        CoachView coachView = this.drawTargetWhenReady;
        if (coachView != null) {
            this.drawTargetWhenReady = null;
            m4423a(coachView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public final void m4430e() {
        Queue<CoachView> queue = this.targets;
        if (queue != null) {
            queue.clear();
        }
        m4421a();
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6024d;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f6024d == null) {
            this.f6024d = new HashMap();
        }
        View view = (View) this.f6024d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f6024d.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void dismiss() {
        m4430e();
    }

    public final void setListener(CoachMarkListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void show(Queue<CoachView> targets) {
        Intrinsics.checkNotNullParameter(targets, "targets");
        this.targets = targets;
        m4428c();
    }
}
