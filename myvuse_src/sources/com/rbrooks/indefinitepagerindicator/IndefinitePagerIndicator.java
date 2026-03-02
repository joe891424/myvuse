package com.rbrooks.indefinitepagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.react.uimanager.ViewProps;
import com.surajit.rnrg.RadialGradientManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: IndefinitePagerIndicator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0003[\\]B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010'\u001a\u00020(2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010)\u001a\u00020(2\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010*\u001a\u00020(2\u0006\u0010%\u001a\u00020&J\u0010\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u00020\bH\u0002J&\u0010.\u001a\u00020\r2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020!2\b\b\u0001\u00102\u001a\u00020\bH\u0002J\b\u00103\u001a\u00020\bH\u0002J\u0010\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\bH\u0002J\b\u00106\u001a\u00020\bH\u0002J\b\u00107\u001a\u00020\bH\u0002J\u0010\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020\u0019H\u0002J\u0010\u0010:\u001a\u00020\b2\u0006\u00105\u001a\u00020\bH\u0002J\u0010\u0010;\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u0019H\u0002J\u001c\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190=2\u0006\u00109\u001a\u00020\u0019H\u0002J\b\u0010>\u001a\u00020!H\u0002J\u0010\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020AH\u0014J\u0018\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\bH\u0014J\u0010\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020\bH\u0016J \u0010G\u001a\u00020(2\u0006\u00105\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\bH\u0016J\u0010\u0010J\u001a\u00020(2\u0006\u00105\u001a\u00020\bH\u0016J\b\u0010K\u001a\u00020(H\u0002J\u0010\u0010L\u001a\u00020(2\b\b\u0001\u0010M\u001a\u00020\bJ\u000e\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u00020\bJ\u000e\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020\bJ\u000e\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020\bJ\u000e\u0010T\u001a\u00020(2\u0006\u0010O\u001a\u00020\bJ\u000e\u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020!J\u0010\u0010W\u001a\u00020(2\b\b\u0001\u0010X\u001a\u00020\bJ\u000e\u0010Y\u001a\u00020(2\u0006\u0010Q\u001a\u00020\bJ\u000e\u0010Z\u001a\u00020(2\u0006\u0010\"\u001a\u00020!R\u0012\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0018\u00010\u0013R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0018\u00010\u0015R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006^"}, m5598d2 = {"Lcom/rbrooks/indefinitepagerindicator/IndefinitePagerIndicator;", "Landroid/view/View;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dotColor", "dotCount", "dotPaint", "Landroid/graphics/Paint;", "dotRadiusPx", "dotSeparationDistancePx", "fadingDotCount", "intermediateSelectedItemPosition", "internalPageChangeCallback", "Lcom/rbrooks/indefinitepagerindicator/IndefinitePagerIndicator$InternalPageChangeCallback;", "internalRecyclerScrollListener", "Lcom/rbrooks/indefinitepagerindicator/IndefinitePagerIndicator$InternalRecyclerScrollListener;", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "offsetPercent", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "selectedDotColor", "selectedDotPaint", "selectedDotRadiusPx", "selectedItemPosition", "supportRtl", "", "verticalSupport", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "attachToRecyclerView", "", "attachToViewPager", "attachToViewPager2", "dpToPx", RsaJsonWebKey.FIRST_FACTOR_CRT_EXPONENT_MEMBER_NAME, "getCalculatedWidth", "getDefaultPaintConfig", "defaultStyle", "Landroid/graphics/Paint$Style;", "isAntiAliasDefault", "defaultColor", "getDistanceBetweenTheCenterOfTwoDots", "getDotCoordinate", ViewProps.POSITION, "getDotYCoordinate", "getItemCount", "getPaint", "coordinate", "getRTLPosition", "getRadius", "getXYPositionsByCoordinate", "Lkotlin/Pair;", "isRtl", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPageScrollStateChanged", "state", "onPageScrolled", "positionOffset", "positionOffsetPixels", "onPageSelected", "removeAllSources", "setDotColor", "newDotColor", "setDotCount", NewHtcHomeBadger.COUNT, "setDotRadius", RadialGradientManager.PROP_RADIUS, "setDotSeparationDistance", "distance", "setFadingDotCount", "setRTLSupport", "supportRTL", "setSelectedDotColor", "newSelectedDotColor", "setSelectedDotRadius", "setVerticalSupport", "Companion", "InternalPageChangeCallback", "InternalRecyclerScrollListener", "indefinitepagerindicator_release"}, m5599k = 1, m5600mv = {1, 4, 0})
public final class IndefinitePagerIndicator extends View implements ViewPager.OnPageChangeListener {
    private static final Companion Companion = new Companion(null);
    private static final int DEFAULT_DOT_COUNT = 5;
    private static final int DEFAULT_DOT_RADIUS_DP = 4;
    private static final int DEFAULT_DOT_SEPARATION_DISTANCE_DP = 10;
    private static final int DEFAULT_FADING_DOT_COUNT = 1;
    private static final float DEFAULT_SELECTED_DOT_RADIUS_DP = 5.5f;
    private HashMap _$_findViewCache;
    private int dotColor;
    private int dotCount;
    private Paint dotPaint;
    private int dotRadiusPx;
    private int dotSeparationDistancePx;
    private int fadingDotCount;
    private int intermediateSelectedItemPosition;
    private InternalPageChangeCallback internalPageChangeCallback;
    private InternalRecyclerScrollListener internalRecyclerScrollListener;
    private final DecelerateInterpolator interpolator;
    private float offsetPercent;
    private RecyclerView recyclerView;
    private int selectedDotColor;
    private Paint selectedDotPaint;
    private int selectedDotRadiusPx;
    private int selectedItemPosition;
    private boolean supportRtl;
    private boolean verticalSupport;
    private ViewPager viewPager;
    private ViewPager2 viewPager2;

    public IndefinitePagerIndicator(Context context) {
        this(context, null, 0, 6, null);
    }

    public IndefinitePagerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ IndefinitePagerIndicator(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != 0) {
            attributeSet = null;
        }
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndefinitePagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.interpolator = new DecelerateInterpolator();
        this.dotCount = 5;
        this.fadingDotCount = 1;
        this.selectedDotRadiusPx = dpToPx(DEFAULT_SELECTED_DOT_RADIUS_DP);
        this.dotRadiusPx = dpToPx(4);
        this.dotSeparationDistancePx = dpToPx(10);
        this.dotColor = ContextCompat.getColor(context, C3939R.color.default_dot_color);
        this.selectedDotColor = ContextCompat.getColor(context, C3939R.color.default_selected_dot_color);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C3939R.styleable.IndefinitePagerIndicator, 0, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…          0\n            )");
            this.dotCount = typedArrayObtainStyledAttributes.getInteger(C3939R.styleable.IndefinitePagerIndicator_dotCount, 5);
            this.fadingDotCount = typedArrayObtainStyledAttributes.getInt(C3939R.styleable.IndefinitePagerIndicator_fadingDotCount, 1);
            this.dotRadiusPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3939R.styleable.IndefinitePagerIndicator_dotRadius, this.dotRadiusPx);
            this.selectedDotRadiusPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3939R.styleable.IndefinitePagerIndicator_selectedDotRadius, this.selectedDotRadiusPx);
            this.dotColor = typedArrayObtainStyledAttributes.getColor(C3939R.styleable.IndefinitePagerIndicator_dotColor, this.dotColor);
            this.selectedDotColor = typedArrayObtainStyledAttributes.getColor(C3939R.styleable.IndefinitePagerIndicator_selectedDotColor, this.selectedDotColor);
            this.dotSeparationDistancePx = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3939R.styleable.IndefinitePagerIndicator_dotSeparation, this.dotSeparationDistancePx);
            this.supportRtl = typedArrayObtainStyledAttributes.getBoolean(C3939R.styleable.IndefinitePagerIndicator_supportRTL, false);
            this.verticalSupport = typedArrayObtainStyledAttributes.getBoolean(C3939R.styleable.IndefinitePagerIndicator_verticalSupport, false);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.selectedDotPaint = getDefaultPaintConfig$default(this, null, false, this.selectedDotColor, 3, null);
        this.dotPaint = getDefaultPaintConfig$default(this, null, false, this.dotColor, 3, null);
    }

    /* JADX INFO: compiled from: IndefinitePagerIndicator.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/rbrooks/indefinitepagerindicator/IndefinitePagerIndicator$Companion;", "", "()V", "DEFAULT_DOT_COUNT", "", "DEFAULT_DOT_RADIUS_DP", "DEFAULT_DOT_SEPARATION_DISTANCE_DP", "DEFAULT_FADING_DOT_COUNT", "DEFAULT_SELECTED_DOT_RADIUS_DP", "", "indefinitepagerindicator_release"}, m5599k = 1, m5600mv = {1, 4, 0})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        IntRange intRangeUntil = RangesKt.until(0, getItemCount());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it2 = intRangeUntil.iterator();
        while (it2.hasNext()) {
            arrayList.add(Float.valueOf(getDotCoordinate(((IntIterator) it2).nextInt())));
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            float fFloatValue = ((Number) it3.next()).floatValue();
            Pair<Float, Float> xYPositionsByCoordinate = getXYPositionsByCoordinate(fFloatValue);
            canvas.drawCircle(xYPositionsByCoordinate.component1().floatValue(), xYPositionsByCoordinate.component2().floatValue(), getRadius(fFloatValue), getPaint(fFloatValue));
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = this.selectedDotRadiusPx * 2;
        if (this.verticalSupport) {
            setMeasuredDimension(i, getCalculatedWidth());
        } else {
            setMeasuredDimension(getCalculatedWidth(), i);
        }
    }

    public final void attachToRecyclerView(RecyclerView recyclerView) {
        removeAllSources();
        this.recyclerView = recyclerView;
        InternalRecyclerScrollListener internalRecyclerScrollListener = new InternalRecyclerScrollListener();
        this.internalRecyclerScrollListener = internalRecyclerScrollListener;
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.addOnScrollListener(internalRecyclerScrollListener);
        }
    }

    public final void attachToViewPager(ViewPager viewPager) {
        removeAllSources();
        this.viewPager = viewPager;
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(this);
        }
        this.selectedItemPosition = viewPager != null ? viewPager.getCurrentItem() : 0;
    }

    public final void attachToViewPager2(ViewPager2 viewPager2) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        removeAllSources();
        this.viewPager2 = viewPager2;
        InternalPageChangeCallback internalPageChangeCallback = new InternalPageChangeCallback();
        this.internalPageChangeCallback = internalPageChangeCallback;
        ViewPager2 viewPager22 = this.viewPager2;
        if (viewPager22 != null) {
            viewPager22.registerOnPageChangeCallback(internalPageChangeCallback);
        }
        ViewPager2 viewPager23 = this.viewPager2;
        this.selectedItemPosition = viewPager23 != null ? viewPager23.getCurrentItem() : 0;
    }

    public final void setDotCount(int count) {
        this.dotCount = count;
        invalidate();
    }

    public final void setFadingDotCount(int count) {
        this.fadingDotCount = count;
        invalidate();
    }

    public final void setSelectedDotRadius(int radius) {
        this.selectedDotRadiusPx = dpToPx(radius);
        invalidate();
    }

    public final void setDotRadius(int radius) {
        this.dotRadiusPx = dpToPx(radius);
        invalidate();
    }

    public final void setDotSeparationDistance(int distance) {
        this.dotSeparationDistancePx = dpToPx(distance);
        invalidate();
    }

    public final void setRTLSupport(boolean supportRTL) {
        this.supportRtl = supportRTL;
        invalidate();
    }

    public final void setVerticalSupport(boolean verticalSupport) {
        this.verticalSupport = verticalSupport;
        invalidate();
    }

    public final void setDotColor(int newDotColor) {
        this.dotColor = newDotColor;
        this.dotPaint.setColor(newDotColor);
        invalidate();
    }

    public final void setSelectedDotColor(int newSelectedDotColor) {
        this.selectedDotColor = newSelectedDotColor;
        this.selectedDotPaint.setColor(newSelectedDotColor);
        invalidate();
    }

    static /* synthetic */ Paint getDefaultPaintConfig$default(IndefinitePagerIndicator indefinitePagerIndicator, Paint.Style style, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            style = Paint.Style.FILL;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return indefinitePagerIndicator.getDefaultPaintConfig(style, z, i);
    }

    private final Paint getDefaultPaintConfig(Paint.Style defaultStyle, boolean isAntiAliasDefault, int defaultColor) {
        Paint paint = new Paint();
        paint.setStyle(defaultStyle);
        paint.setAntiAlias(isAntiAliasDefault);
        paint.setColor(defaultColor);
        return paint;
    }

    private final Pair<Float, Float> getXYPositionsByCoordinate(float coordinate) {
        float width;
        float selectedDotRadiusPx;
        if (this.verticalSupport) {
            width = getSelectedDotRadiusPx();
            selectedDotRadiusPx = (getHeight() / 2) + coordinate;
        } else {
            width = (getWidth() / 2) + coordinate;
            selectedDotRadiusPx = getSelectedDotRadiusPx();
        }
        return new Pair<>(Float.valueOf(width), Float.valueOf(selectedDotRadiusPx));
    }

    private final float getDotCoordinate(int position) {
        return ((position - this.intermediateSelectedItemPosition) * getDistanceBetweenTheCenterOfTwoDots()) + (getDistanceBetweenTheCenterOfTwoDots() * this.offsetPercent);
    }

    /* JADX INFO: renamed from: getDotYCoordinate, reason: from getter */
    private final int getSelectedDotRadiusPx() {
        return this.selectedDotRadiusPx;
    }

    private final int getDistanceBetweenTheCenterOfTwoDots() {
        return (this.dotRadiusPx * 2) + this.dotSeparationDistancePx;
    }

    private final float getRadius(float coordinate) {
        int i;
        float fAbs = Math.abs(coordinate);
        float distanceBetweenTheCenterOfTwoDots = (this.dotCount / 2) * getDistanceBetweenTheCenterOfTwoDots();
        if (fAbs < getDistanceBetweenTheCenterOfTwoDots() / 2) {
            i = this.selectedDotRadiusPx;
        } else if (fAbs <= distanceBetweenTheCenterOfTwoDots) {
            i = this.dotRadiusPx;
        } else {
            return this.interpolator.getInterpolation(1 - ((fAbs - distanceBetweenTheCenterOfTwoDots) / ((getCalculatedWidth() / 2.01f) - distanceBetweenTheCenterOfTwoDots))) * this.dotRadiusPx;
        }
        return i;
    }

    private final Paint getPaint(float coordinate) {
        return Math.abs(coordinate) < ((float) (getDistanceBetweenTheCenterOfTwoDots() / 2)) ? this.selectedDotPaint : this.dotPaint;
    }

    private final int getCalculatedWidth() {
        return (((this.dotCount + (this.fadingDotCount * 2)) - 1) * getDistanceBetweenTheCenterOfTwoDots()) + (this.dotRadiusPx * 2);
    }

    private final int dpToPx(float dp) {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) (dp * (resources.getDisplayMetrics().densityDpi / 160));
    }

    private final void removeAllSources() {
        ViewPager2 viewPager2;
        RecyclerView recyclerView;
        InternalRecyclerScrollListener internalRecyclerScrollListener = this.internalRecyclerScrollListener;
        if (internalRecyclerScrollListener != null && (recyclerView = this.recyclerView) != null) {
            recyclerView.removeOnScrollListener(internalRecyclerScrollListener);
        }
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(this);
        }
        InternalPageChangeCallback internalPageChangeCallback = this.internalPageChangeCallback;
        if (internalPageChangeCallback != null && (viewPager2 = this.viewPager2) != null) {
            viewPager2.unregisterOnPageChangeCallback(internalPageChangeCallback);
        }
        this.recyclerView = null;
        this.viewPager = null;
        this.viewPager2 = null;
    }

    private final int getItemCount() {
        RecyclerView.Adapter adapter;
        PagerAdapter adapter2;
        RecyclerView.Adapter adapter3;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            if (recyclerView == null || (adapter3 = recyclerView.getAdapter()) == null) {
                return 0;
            }
            return adapter3.getItemCount();
        }
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            if (viewPager == null || (adapter2 = viewPager.getAdapter()) == null) {
                return 0;
            }
            return adapter2.getCount();
        }
        ViewPager2 viewPager2 = this.viewPager2;
        if (viewPager2 == null || viewPager2 == null || (adapter = viewPager2.getAdapter()) == null) {
            return 0;
        }
        return adapter.getItemCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRtl() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getRTLPosition(int position) {
        return (getItemCount() - position) - 1;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (this.supportRtl && isRtl()) {
            int rTLPosition = getRTLPosition(position);
            this.selectedItemPosition = rTLPosition;
            this.intermediateSelectedItemPosition = rTLPosition;
            this.offsetPercent = positionOffset * 1;
        } else {
            this.selectedItemPosition = position;
            this.intermediateSelectedItemPosition = position;
            this.offsetPercent = positionOffset * (-1);
        }
        invalidate();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
        this.intermediateSelectedItemPosition = this.selectedItemPosition;
        if (this.supportRtl && isRtl()) {
            position = getRTLPosition(position);
        }
        this.selectedItemPosition = position;
        invalidate();
    }

    /* JADX INFO: compiled from: IndefinitePagerIndicator.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lcom/rbrooks/indefinitepagerindicator/IndefinitePagerIndicator$InternalRecyclerScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "(Lcom/rbrooks/indefinitepagerindicator/IndefinitePagerIndicator;)V", "previousMostVisibleChild", "Landroid/view/View;", "calculatePercentVisible", "", "child", "getMostVisibleChild", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "setIntermediateSelectedItemPosition", "mostVisibleChild", "indefinitepagerindicator_release"}, m5599k = 1, m5600mv = {1, 4, 0})
    public final class InternalRecyclerScrollListener extends RecyclerView.OnScrollListener {
        private View previousMostVisibleChild;

        public InternalRecyclerScrollListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            View mostVisibleChild = getMostVisibleChild();
            if (mostVisibleChild != null) {
                setIntermediateSelectedItemPosition(mostVisibleChild);
                IndefinitePagerIndicator.this.offsetPercent = mostVisibleChild.getLeft() / mostVisibleChild.getMeasuredWidth();
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (this.previousMostVisibleChild != linearLayoutManager.findViewByPosition(dx >= 0 ? linearLayoutManager.findLastVisibleItemPosition() : linearLayoutManager.findFirstVisibleItemPosition())) {
                IndefinitePagerIndicator indefinitePagerIndicator = IndefinitePagerIndicator.this;
                indefinitePagerIndicator.selectedItemPosition = indefinitePagerIndicator.intermediateSelectedItemPosition;
            }
            this.previousMostVisibleChild = mostVisibleChild;
            IndefinitePagerIndicator.this.invalidate();
        }

        private final View getMostVisibleChild() {
            RecyclerView.LayoutManager layoutManager;
            RecyclerView.LayoutManager layoutManager2;
            RecyclerView recyclerView = IndefinitePagerIndicator.this.recyclerView;
            Integer numValueOf = (recyclerView == null || (layoutManager2 = recyclerView.getLayoutManager()) == null) ? null : Integer.valueOf(layoutManager2.getChildCount());
            Intrinsics.checkNotNull(numValueOf);
            float f = 0.0f;
            View view = null;
            for (int iIntValue = numValueOf.intValue() - 1; iIntValue >= 0; iIntValue--) {
                RecyclerView recyclerView2 = IndefinitePagerIndicator.this.recyclerView;
                View childAt = (recyclerView2 == null || (layoutManager = recyclerView2.getLayoutManager()) == null) ? null : layoutManager.getChildAt(iIntValue);
                if (childAt != null) {
                    float fCalculatePercentVisible = calculatePercentVisible(childAt);
                    if (fCalculatePercentVisible >= f) {
                        view = childAt;
                        f = fCalculatePercentVisible;
                    }
                }
            }
            return view;
        }

        private final float calculatePercentVisible(View child) {
            int left = child.getLeft();
            int right = child.getRight();
            int width = child.getWidth();
            if (left >= 0) {
                if (right <= IndefinitePagerIndicator.this.getWidth()) {
                    return 1.0f;
                }
                right = IndefinitePagerIndicator.this.getWidth() - left;
            }
            return right / width;
        }

        private final void setIntermediateSelectedItemPosition(View mostVisibleChild) {
            RecyclerView.ViewHolder viewHolderFindContainingViewHolder;
            RecyclerView recyclerView = IndefinitePagerIndicator.this.recyclerView;
            if (recyclerView == null || (viewHolderFindContainingViewHolder = recyclerView.findContainingViewHolder(mostVisibleChild)) == null) {
                return;
            }
            int adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition();
            IndefinitePagerIndicator indefinitePagerIndicator = IndefinitePagerIndicator.this;
            if (indefinitePagerIndicator.isRtl() && !IndefinitePagerIndicator.this.verticalSupport) {
                adapterPosition = IndefinitePagerIndicator.this.getRTLPosition(adapterPosition);
            }
            indefinitePagerIndicator.intermediateSelectedItemPosition = adapterPosition;
        }
    }

    /* JADX INFO: compiled from: IndefinitePagerIndicator.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, m5598d2 = {"Lcom/rbrooks/indefinitepagerindicator/IndefinitePagerIndicator$InternalPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "(Lcom/rbrooks/indefinitepagerindicator/IndefinitePagerIndicator;)V", "onPageScrolled", "", ViewProps.POSITION, "", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "indefinitepagerindicator_release"}, m5599k = 1, m5600mv = {1, 4, 0})
    public final class InternalPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        public InternalPageChangeCallback() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            IndefinitePagerIndicator.this.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            IndefinitePagerIndicator.this.onPageSelected(position);
        }
    }
}
