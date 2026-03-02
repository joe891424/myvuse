package it.sephiroth.android.library.xtooltip;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.IBinder;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.facebook.react.uimanager.ViewProps;
import com.surajit.rnrg.RadialGradientManager;
import io.branch.rnbranch.RNBranchModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.EllipticCurveJsonWebKey;
import timber.log.Timber;

/* JADX INFO: compiled from: Tooltip.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\n\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010]\u001a\u00020;2\u0006\u0010^\u001a\u00020;H\u0002J\u0010\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020bH\u0003J\u0006\u0010c\u001a\u00020-J+\u0010d\u001a\u00020\u00002#\u0010e\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010)J+\u0010f\u001a\u00020\u00002#\u0010e\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010)J+\u0010g\u001a\u00020\u00002#\u0010e\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010)J\u0010\u0010h\u001a\u00020-2\u0006\u0010i\u001a\u00020\u0018H\u0002J\u0010\u0010j\u001a\u00020-2\u0006\u0010i\u001a\u00020\u0018H\u0002JD\u0010k\u001a\u0004\u0018\u00010$2\u0006\u0010l\u001a\u00020\n2\b\u0010m\u001a\u0004\u0018\u00010\n2\u0006\u0010n\u001a\u00020\u001b2\f\u0010o\u001a\b\u0012\u0004\u0012\u0002030p2\u0006\u0010q\u001a\u00020`2\b\b\u0002\u0010r\u001a\u00020\u0011H\u0002J\u0006\u0010s\u001a\u00020-J\u0014\u0010t\u001a\u0004\u0018\u00010\u00002\b\u0010u\u001a\u0004\u0018\u00010$H\u0002J\u0018\u0010v\u001a\u00020-2\u0006\u0010w\u001a\u00020;2\u0006\u0010x\u001a\u00020;H\u0002J\u0018\u0010y\u001a\u00020-2\u0006\u0010q\u001a\u00020`2\u0006\u0010z\u001a\u000203H\u0002J\b\u0010{\u001a\u00020-H\u0002J\u0012\u0010|\u001a\u00020-2\b\u0010}\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010~\u001a\u00020-2\u0006\u0010z\u001a\u000203H\u0002J\u0010\u0010\u007f\u001a\u00020-2\u0006\u0010}\u001a\u00020\nH\u0002J!\u0010\u0080\u0001\u001a\u00020-2\u0006\u0010l\u001a\u00020\n2\u0006\u0010z\u001a\u0002032\b\b\u0002\u0010r\u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010(\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020302X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R+\u00107\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0004\n\u0002\u0010<R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0018\u00010CR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010G\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020;X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020;X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0086\u0001"}, m5598d2 = {"Lit/sephiroth/android/library/xtooltip/Tooltip;", "", "context", "Landroid/content/Context;", "builder", "Lit/sephiroth/android/library/xtooltip/Tooltip$Builder;", "(Landroid/content/Context;Lit/sephiroth/android/library/xtooltip/Tooltip$Builder;)V", "activateRunnable", "Ljava/lang/Runnable;", "<set-?>", "Landroid/view/View;", "contentView", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "hideRunnable", "", "isShowing", "()Z", "setShowing", "(Z)V", "isVisible", "mActivateDelay", "", "mActivated", "mAnchorPoint", "Landroid/graphics/Point;", "mAnchorView", "Ljava/lang/ref/WeakReference;", "mAnimator", "Landroid/animation/ValueAnimator;", "mClosePolicy", "Lit/sephiroth/android/library/xtooltip/ClosePolicy;", "mContentView", "mCurrentPosition", "Lit/sephiroth/android/library/xtooltip/Tooltip$Positions;", "mDrawable", "Lit/sephiroth/android/library/xtooltip/TooltipTextDrawable;", "mFadeDuration", "mFailureFunc", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tooltip", "", "mFloatingAnimation", "Lit/sephiroth/android/library/xtooltip/Tooltip$Animation;", "mFollowAnchor", "mGravities", "", "Lit/sephiroth/android/library/xtooltip/Tooltip$Gravity;", "mHandler", "Landroid/os/Handler;", "mHasAnchorView", "mHiddenFunc", "mIsCustomView", "mLayoutInsetDecor", "mMaxWidth", "", "Ljava/lang/Integer;", "mNewLocation", "", "mOldLocation", "mOverlayStyle", "mPadding", "mPopupView", "Lit/sephiroth/android/library/xtooltip/Tooltip$TooltipViewContainer;", "mShowArrow", "mShowDuration", "mShowOverlay", "mShownFunc", "mSizeTolerance", "", "mSoftInputMode", "mText", "", "mTextAppearance", "mTextGravity", "mTextView", "Landroid/widget/TextView;", "mTextViewElevation", "mTextViewIdRes", "mTooltipLayoutIdRes", "mTypeface", "Landroid/graphics/Typeface;", "mViewOverlay", "Lit/sephiroth/android/library/xtooltip/TooltipOverlay;", "mWindowLayoutType", "predrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "windowManager", "Landroid/view/WindowManager;", "computeFlags", "curFlags", "createPopupLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "token", "Landroid/os/IBinder;", "dismiss", "doOnFailure", "func", "doOnHidden", "doOnShown", "fadeIn", "fadeDuration", "fadeOut", "findPosition", "parent", "anchor", TypedValues.CycleType.S_WAVE_OFFSET, "gravities", "Ljava/util/ArrayList;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "fitToScreen", "hide", "invokePopup", "positions", "offsetBy", "xoff", "yoff", "preparePopup", "gravity", "removeCallbacks", "removeListeners", "anchorView", "setupAnimation", "setupListeners", "show", "Animation", "Builder", "Gravity", "Positions", "TooltipViewContainer", "xtooltip_release"}, m5599k = 1, m5600mv = {1, 1, 13})
public final class Tooltip {
    private final Runnable activateRunnable;
    private View contentView;
    private final Context context;
    private final Runnable hideRunnable;
    private boolean isShowing;
    private boolean isVisible;
    private long mActivateDelay;
    private boolean mActivated;
    private Point mAnchorPoint;
    private WeakReference<View> mAnchorView;
    private ValueAnimator mAnimator;
    private ClosePolicy mClosePolicy;
    private View mContentView;
    private Positions mCurrentPosition;
    private TooltipTextDrawable mDrawable;
    private long mFadeDuration;
    private Function1<? super Tooltip, Unit> mFailureFunc;
    private Animation mFloatingAnimation;
    private boolean mFollowAnchor;
    private final List<Gravity> mGravities;
    private final Handler mHandler;
    private boolean mHasAnchorView;
    private Function1<? super Tooltip, Unit> mHiddenFunc;
    private boolean mIsCustomView;
    private final boolean mLayoutInsetDecor;
    private Integer mMaxWidth;
    private int[] mNewLocation;
    private int[] mOldLocation;
    private int mOverlayStyle;
    private int mPadding;
    private TooltipViewContainer mPopupView;
    private boolean mShowArrow;
    private long mShowDuration;
    private boolean mShowOverlay;
    private Function1<? super Tooltip, Unit> mShownFunc;
    private final float mSizeTolerance;
    private final int mSoftInputMode;
    private CharSequence mText;
    private int mTextAppearance;
    private int mTextGravity;
    private TextView mTextView;
    private float mTextViewElevation;
    private int mTextViewIdRes;
    private int mTooltipLayoutIdRes;
    private Typeface mTypeface;
    private TooltipOverlay mViewOverlay;
    private final int mWindowLayoutType;
    private ViewTreeObserver.OnPreDrawListener predrawListener;
    private final WindowManager windowManager;

    /* JADX INFO: compiled from: Tooltip.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m5598d2 = {"Lit/sephiroth/android/library/xtooltip/Tooltip$Gravity;", "", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "TOP", "BOTTOM", "CENTER", "xtooltip_release"}, m5599k = 1, m5600mv = {1, 1, 13})
    public enum Gravity {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        CENTER
    }

    @Metadata(m5596bv = {1, 0, 3}, m5599k = 3, m5600mv = {1, 1, 13})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[Gravity.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Gravity.LEFT.ordinal()] = 1;
            iArr[Gravity.RIGHT.ordinal()] = 2;
            iArr[Gravity.TOP.ordinal()] = 3;
            iArr[Gravity.BOTTOM.ordinal()] = 4;
            iArr[Gravity.CENTER.ordinal()] = 5;
            int[] iArr2 = new int[Gravity.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Gravity.LEFT.ordinal()] = 1;
            iArr2[Gravity.TOP.ordinal()] = 2;
            iArr2[Gravity.RIGHT.ordinal()] = 3;
            iArr2[Gravity.BOTTOM.ordinal()] = 4;
            iArr2[Gravity.CENTER.ordinal()] = 5;
            int[] iArr3 = new int[Gravity.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[Gravity.LEFT.ordinal()] = 1;
            iArr3[Gravity.RIGHT.ordinal()] = 2;
            iArr3[Gravity.TOP.ordinal()] = 3;
            iArr3[Gravity.BOTTOM.ordinal()] = 4;
            iArr3[Gravity.CENTER.ordinal()] = 5;
        }
    }

    private Tooltip(Context context, Builder builder) {
        this.context = context;
        Object systemService = context.getSystemService("window");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        this.windowManager = (WindowManager) systemService;
        Gravity[] gravityArrValues = Gravity.values();
        ArrayList arrayList = new ArrayList();
        for (Gravity gravity : gravityArrValues) {
            if (gravity != Gravity.CENTER) {
                arrayList.add(gravity);
            }
        }
        this.mGravities = arrayList;
        Resources resources = this.context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        this.mSizeTolerance = resources.getDisplayMetrics().density * 10;
        this.mLayoutInsetDecor = true;
        this.mWindowLayoutType = 1000;
        this.mSoftInputMode = 2;
        this.mHandler = new Handler();
        this.mTooltipLayoutIdRes = C5487R.layout.textview;
        this.mTextViewIdRes = android.R.id.text1;
        this.hideRunnable = new Runnable() { // from class: it.sephiroth.android.library.xtooltip.Tooltip$hideRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                this.this$0.hide();
            }
        };
        this.activateRunnable = new Runnable() { // from class: it.sephiroth.android.library.xtooltip.Tooltip$activateRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                this.this$0.mActivated = true;
            }
        };
        this.predrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: it.sephiroth.android.library.xtooltip.Tooltip$predrawListener$1
            /* JADX WARN: Removed duplicated region for block: B:34:0x00b3  */
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final boolean onPreDraw() {
                /*
                    Method dump skipped, instruction units count: 227
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.xtooltip.Tooltip$predrawListener$1.onPreDraw():boolean");
            }
        };
        TypedArray typedArrayObtainStyledAttributes = this.context.getTheme().obtainStyledAttributes(null, C5487R.styleable.TooltipLayout, builder.getDefStyleAttr(), builder.getDefStyleRes());
        this.mPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(C5487R.styleable.TooltipLayout_ttlm_padding, 30);
        this.mTextAppearance = typedArrayObtainStyledAttributes.getResourceId(C5487R.styleable.TooltipLayout_android_textAppearance, 0);
        this.mTextGravity = typedArrayObtainStyledAttributes.getInt(C5487R.styleable.TooltipLayout_android_gravity, 8388659);
        this.mTextViewElevation = typedArrayObtainStyledAttributes.getDimension(C5487R.styleable.TooltipLayout_ttlm_elevation, 0.0f);
        this.mOverlayStyle = typedArrayObtainStyledAttributes.getResourceId(C5487R.styleable.TooltipLayout_ttlm_overlayStyle, C5487R.style.ToolTipOverlayDefaultStyle);
        String string = typedArrayObtainStyledAttributes.getString(C5487R.styleable.TooltipLayout_ttlm_font);
        typedArrayObtainStyledAttributes.recycle();
        this.mText = builder.getText();
        this.mActivateDelay = builder.getActivateDelay();
        Point point = builder.getPoint();
        if (point == null) {
            Intrinsics.throwNpe();
        }
        this.mAnchorPoint = point;
        this.mClosePolicy = builder.getClosePolicy();
        this.mMaxWidth = builder.getMaxWidth();
        this.mFloatingAnimation = builder.getFloatingAnimation();
        this.mShowDuration = builder.getShowDuration();
        this.mFadeDuration = builder.getFadeDuration();
        this.mShowOverlay = builder.getOverlay();
        this.mShowArrow = builder.getShowArrow() && builder.getLayoutId() == null;
        View anchorView = builder.getAnchorView();
        if (anchorView != null) {
            this.mAnchorView = new WeakReference<>(anchorView);
            this.mHasAnchorView = true;
            this.mFollowAnchor = builder.getFollowAnchor();
        }
        Integer layoutId = builder.getLayoutId();
        if (layoutId != null) {
            layoutId.intValue();
            Integer textId = builder.getTextId();
            if (textId == null) {
                Intrinsics.throwNpe();
            }
            this.mTextViewIdRes = textId.intValue();
            Integer layoutId2 = builder.getLayoutId();
            if (layoutId2 == null) {
                Intrinsics.throwNpe();
            }
            this.mTooltipLayoutIdRes = layoutId2.intValue();
            this.mIsCustomView = true;
        } else {
            this.mDrawable = new TooltipTextDrawable(this.context, builder);
        }
        Typeface typeface = builder.getTypeface();
        if (typeface != null) {
            this.mTypeface = typeface;
        } else if (string != null) {
            this.mTypeface = Typefaces.INSTANCE.get(this.context, string);
        }
        this.mNewLocation = new int[]{0, 0};
    }

    public /* synthetic */ Tooltip(Context context, Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, builder);
    }

    public static final /* synthetic */ TextView access$getMTextView$p(Tooltip tooltip) {
        TextView textView = tooltip.mTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        }
        return textView;
    }

    private final void setShowing(boolean z) {
        this.isShowing = z;
    }

    /* JADX INFO: renamed from: isShowing, reason: from getter */
    public final boolean getIsShowing() {
        return this.isShowing;
    }

    private final void setContentView(View view) {
        this.contentView = view;
    }

    public final View getContentView() {
        View view = this.mContentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        }
        return view;
    }

    public final Tooltip doOnFailure(Function1<? super Tooltip, Unit> func) {
        this.mFailureFunc = func;
        return this;
    }

    public final Tooltip doOnShown(Function1<? super Tooltip, Unit> func) {
        this.mShownFunc = func;
        return this;
    }

    public final Tooltip doOnHidden(Function1<? super Tooltip, Unit> func) {
        this.mHiddenFunc = func;
        return this;
    }

    private final WindowManager.LayoutParams createPopupLayoutParams(IBinder token) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.flags = computeFlags(layoutParams.flags);
        layoutParams.type = this.mWindowLayoutType;
        layoutParams.token = token;
        layoutParams.softInputMode = this.mSoftInputMode;
        layoutParams.setTitle("ToolTip:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    private final int computeFlags(int curFlags) {
        int i = (this.mClosePolicy.inside() || this.mClosePolicy.outside()) ? (curFlags | 32) & (-9) : curFlags | 40;
        if (!this.mClosePolicy.consume()) {
            i |= 16;
        }
        return i | 459520;
    }

    private final void preparePopup(WindowManager.LayoutParams params, Gravity gravity) {
        TooltipViewContainer tooltipViewContainer = this.mPopupView;
        if (tooltipViewContainer != null) {
            if (this.mViewOverlay == null || gravity != Gravity.CENTER) {
                return;
            }
            tooltipViewContainer.removeView(this.mViewOverlay);
            this.mViewOverlay = null;
            return;
        }
        TooltipViewContainer tooltipViewContainer2 = new TooltipViewContainer(this, this.context);
        if (this.mShowOverlay && this.mViewOverlay == null) {
            TooltipOverlay tooltipOverlay = new TooltipOverlay(this.context, 0, this.mOverlayStyle);
            this.mViewOverlay = tooltipOverlay;
            tooltipOverlay.setAdjustViewBounds(true);
            tooltipOverlay.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        View contentView = LayoutInflater.from(this.context).inflate(this.mTooltipLayoutIdRes, (ViewGroup) tooltipViewContainer2, false);
        Animation animation = this.mFloatingAnimation;
        if (animation != null) {
            Intrinsics.checkExpressionValueIsNotNull(contentView, "contentView");
            int radius = animation.getRadius();
            contentView.setPadding(radius, radius, radius, radius);
        }
        View viewFindViewById = contentView.findViewById(this.mTextViewIdRes);
        Intrinsics.checkExpressionValueIsNotNull(viewFindViewById, "contentView.findViewById(mTextViewIdRes)");
        TextView textView = (TextView) viewFindViewById;
        this.mTextView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        }
        TooltipTextDrawable tooltipTextDrawable = this.mDrawable;
        if (tooltipTextDrawable != null) {
            textView.setBackground(tooltipTextDrawable);
        }
        if (this.mShowArrow) {
            int i = this.mPadding;
            textView.setPadding(i, i, i, i);
        } else {
            int i2 = this.mPadding;
            textView.setPadding(i2 / 2, i2 / 2, i2 / 2, i2 / 2);
        }
        if (this.mTextAppearance != 0) {
            textView.setTextAppearance(textView.getContext(), this.mTextAppearance);
        }
        if (!this.mIsCustomView && this.mTextViewElevation > 0) {
            textView.setElevation(this.mTextViewElevation);
            textView.setTranslationZ(this.mTextViewElevation);
            textView.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        }
        textView.setGravity(this.mTextGravity);
        Spanned spannedFromHtml = this.mText;
        if (!(spannedFromHtml instanceof Spannable)) {
            CharSequence charSequence = this.mText;
            if (charSequence == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            spannedFromHtml = Html.fromHtml((String) charSequence);
        }
        textView.setText(spannedFromHtml);
        Integer num = this.mMaxWidth;
        if (num != null) {
            textView.setMaxWidth(num.intValue());
        }
        Typeface typeface = this.mTypeface;
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
        TooltipOverlay tooltipOverlay2 = this.mViewOverlay;
        if (tooltipOverlay2 != null) {
            tooltipViewContainer2.addView(tooltipOverlay2, new FrameLayout.LayoutParams(-2, -2));
        }
        tooltipViewContainer2.addView(contentView, new FrameLayout.LayoutParams(-2, -2));
        tooltipViewContainer2.setMeasureAllChildren(true);
        tooltipViewContainer2.measure(0, 0);
        Timber.m5656i("viewContainer size: " + tooltipViewContainer2.getMeasuredWidth() + ", " + tooltipViewContainer2.getMeasuredHeight(), new Object[0]);
        StringBuilder sb = new StringBuilder("contentView size: ");
        Intrinsics.checkExpressionValueIsNotNull(contentView, "contentView");
        Timber.m5656i(sb.append(contentView.getMeasuredWidth()).append(", ").append(contentView.getMeasuredHeight()).toString(), new Object[0]);
        TextView textView2 = this.mTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        }
        AttachStateChangeListener attachStateChangeListener = new AttachStateChangeListener();
        attachStateChangeListener.onViewAttachedToWindow(new Function2<View, View.OnAttachStateChangeListener, Unit>() { // from class: it.sephiroth.android.library.xtooltip.Tooltip$$special$$inlined$addOnAttachStateChangeListener$lambda$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, View.OnAttachStateChangeListener onAttachStateChangeListener) {
                invoke2(view, onAttachStateChangeListener);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view, View.OnAttachStateChangeListener onAttachStateChangeListener) {
                Intrinsics.checkParameterIsNotNull(onAttachStateChangeListener, "<anonymous parameter 1>");
                ValueAnimator valueAnimator = this.$this_run$inlined.mAnimator;
                if (valueAnimator != null) {
                    valueAnimator.start();
                }
                if (this.$this_run$inlined.mShowDuration > 0) {
                    this.$this_run$inlined.mHandler.removeCallbacks(this.$this_run$inlined.hideRunnable);
                    this.$this_run$inlined.mHandler.postDelayed(this.$this_run$inlined.hideRunnable, this.$this_run$inlined.mShowDuration);
                }
                this.$this_run$inlined.mHandler.removeCallbacks(this.$this_run$inlined.activateRunnable);
                this.$this_run$inlined.mHandler.postDelayed(this.$this_run$inlined.activateRunnable, this.$this_run$inlined.mActivateDelay);
            }
        });
        attachStateChangeListener.onViewDetachedFromWindow(new Function2<View, View.OnAttachStateChangeListener, Unit>() { // from class: it.sephiroth.android.library.xtooltip.Tooltip$$special$$inlined$addOnAttachStateChangeListener$lambda$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, View.OnAttachStateChangeListener onAttachStateChangeListener) {
                invoke2(view, onAttachStateChangeListener);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view, View.OnAttachStateChangeListener listener) {
                Intrinsics.checkParameterIsNotNull(listener, "listener");
                if (view != null) {
                    view.removeOnAttachStateChangeListener(listener);
                }
                ValueAnimator valueAnimator = this.$this_run$inlined.mAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                this.$this_run$inlined.removeCallbacks();
            }
        });
        textView2.addOnAttachStateChangeListener(attachStateChangeListener);
        this.mContentView = contentView;
        this.mPopupView = tooltipViewContainer2;
    }

    static /* synthetic */ Positions findPosition$default(Tooltip tooltip, View view, View view2, Point point, ArrayList arrayList, WindowManager.LayoutParams layoutParams, boolean z, int i, Object obj) {
        if ((i & 32) != 0) {
            z = false;
        }
        return tooltip.findPosition(view, view2, point, arrayList, layoutParams, z);
    }

    private final Positions findPosition(View parent, View anchor, Point offset, ArrayList<Gravity> gravities, WindowManager.LayoutParams params, boolean fitToScreen) {
        TooltipOverlay tooltipOverlay;
        if (this.mPopupView == null || gravities.isEmpty()) {
            return null;
        }
        Gravity gravityRemove = gravities.remove(0);
        Intrinsics.checkExpressionValueIsNotNull(gravityRemove, "gravities.removeAt(0)");
        Gravity gravity = gravityRemove;
        Timber.m5656i("findPosition. " + gravity + ", offset: " + offset, new Object[0]);
        Rect rect = new Rect();
        int[] iArr = {0, 0};
        Point point = new Point(offset);
        parent.getWindowVisibleDisplayFrame(rect);
        if (anchor != null) {
            anchor.getLocationOnScreen(iArr);
            point.x += iArr[0] + (anchor.getWidth() / 2);
            point.y += iArr[1] + (anchor.getHeight() / 2);
            int i = WhenMappings.$EnumSwitchMapping$0[gravity.ordinal()];
            if (i == 1) {
                iArr[1] = iArr[1] + (anchor.getHeight() / 2);
            } else if (i == 2) {
                iArr[0] = iArr[0] + anchor.getWidth();
                iArr[1] = iArr[1] + (anchor.getHeight() / 2);
            } else if (i == 3) {
                iArr[0] = iArr[0] + (anchor.getWidth() / 2);
            } else if (i == 4) {
                iArr[0] = iArr[0] + (anchor.getWidth() / 2);
                iArr[1] = iArr[1] + anchor.getHeight();
            } else if (i == 5) {
                iArr[0] = iArr[0] + (anchor.getWidth() / 2);
                iArr[1] = iArr[1] + (anchor.getHeight() / 2);
            }
        }
        iArr[0] = iArr[0] + offset.x;
        iArr[1] = iArr[1] + offset.y;
        Timber.m5650d("anchorPosition: " + iArr[0] + ", " + iArr[1], new Object[0]);
        Timber.m5650d("centerPosition: " + point, new Object[0]);
        Timber.m5650d("displayFrame: " + rect, new Object[0]);
        View view = this.mContentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        }
        int measuredWidth = view.getMeasuredWidth();
        View view2 = this.mContentView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        }
        int measuredHeight = view2.getMeasuredHeight();
        Timber.m5659v("contentView size: " + measuredWidth + ", " + measuredHeight, new Object[0]);
        Point point2 = new Point();
        Point point3 = new Point();
        Animation animation = this.mFloatingAnimation;
        int radius = animation != null ? animation.getRadius() : 0;
        int i2 = WhenMappings.$EnumSwitchMapping$1[gravity.ordinal()];
        if (i2 == 1) {
            point2.x = iArr[0] - measuredWidth;
            int i3 = measuredHeight / 2;
            point2.y = iArr[1] - i3;
            point3.y = (i3 - (this.mPadding / 2)) - radius;
        } else if (i2 == 2) {
            int i4 = measuredWidth / 2;
            point2.x = iArr[0] - i4;
            point2.y = iArr[1] - measuredHeight;
            point3.x = (i4 - (this.mPadding / 2)) - radius;
        } else if (i2 == 3) {
            point2.x = iArr[0];
            int i5 = measuredHeight / 2;
            point2.y = iArr[1] - i5;
            point3.y = (i5 - (this.mPadding / 2)) - radius;
        } else if (i2 == 4) {
            int i6 = measuredWidth / 2;
            point2.x = iArr[0] - i6;
            point2.y = iArr[1];
            point3.x = (i6 - (this.mPadding / 2)) - radius;
        } else if (i2 == 5) {
            point2.x = iArr[0] - (measuredWidth / 2);
            point2.y = iArr[1] - (measuredHeight / 2);
        }
        if (anchor == null && (tooltipOverlay = this.mViewOverlay) != null) {
            int i7 = WhenMappings.$EnumSwitchMapping$2[gravity.ordinal()];
            if (i7 == 1) {
                point2.x -= tooltipOverlay.getMeasuredWidth() / 2;
            } else if (i7 == 2) {
                point2.x += tooltipOverlay.getMeasuredWidth() / 2;
            } else if (i7 == 3) {
                point2.y -= tooltipOverlay.getMeasuredHeight() / 2;
            } else if (i7 == 4) {
                point2.y += tooltipOverlay.getMeasuredHeight() / 2;
            }
        }
        Timber.m5650d("arrowPosition: " + point3, new Object[0]);
        Timber.m5650d("centerPosition: " + point, new Object[0]);
        Timber.m5650d("contentPosition: " + point2, new Object[0]);
        if (fitToScreen) {
            Rect rect2 = new Rect(point2.x, point2.y, point2.x + measuredWidth, point2.y + measuredHeight);
            int i8 = (int) this.mSizeTolerance;
            if (!rect.contains(rect2.left + i8, rect2.top + i8, rect2.right - i8, rect2.bottom - i8)) {
                Timber.m5653e("content won't fit! " + rect + ", " + rect2, new Object[0]);
                return findPosition(parent, anchor, offset, gravities, params, fitToScreen);
            }
        }
        return new Positions(rect, point3, point, point2, gravity, params);
    }

    private final Tooltip invokePopup(Positions positions) {
        if (positions != null) {
            this.isShowing = true;
            this.mCurrentPosition = positions;
            setupAnimation(positions.getGravity());
            if (this.mHasAnchorView) {
                WeakReference<View> weakReference = this.mAnchorView;
                if ((weakReference != null ? weakReference.get() : null) != null) {
                    WeakReference<View> weakReference2 = this.mAnchorView;
                    if (weakReference2 == null) {
                        Intrinsics.throwNpe();
                    }
                    View view = weakReference2.get();
                    if (view == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(view, "mAnchorView!!.get()!!");
                    setupListeners(view);
                }
            }
            TooltipTextDrawable tooltipTextDrawable = this.mDrawable;
            if (tooltipTextDrawable != null) {
                Gravity gravity = positions.getGravity();
                boolean z = this.mShowArrow;
                tooltipTextDrawable.setAnchor(gravity, !z ? 0 : this.mPadding / 2, z ? new Point(positions.getArrowPointX(), positions.getArrowPointY()) : null);
            }
            offsetBy(0, 0);
            positions.getParams().packageName = this.context.getPackageName();
            TooltipViewContainer tooltipViewContainer = this.mPopupView;
            if (tooltipViewContainer != null) {
                tooltipViewContainer.setFitsSystemWindows(this.mLayoutInsetDecor);
            }
            this.windowManager.addView(this.mPopupView, positions.getParams());
            Timber.m5659v("windowManager.addView: " + this.mPopupView, new Object[0]);
            fadeIn(this.mFadeDuration);
            return this;
        }
        Function1<? super Tooltip, Unit> function1 = this.mFailureFunc;
        if (function1 != null) {
            function1.invoke(this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void offsetBy(int xoff, int yoff) {
        if (!this.isShowing || this.mPopupView == null || this.mCurrentPosition == null) {
            return;
        }
        Timber.m5656i("offsetBy(" + xoff + ", " + yoff + ')', new Object[0]);
        View view = this.mContentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        }
        if (this.mCurrentPosition == null) {
            Intrinsics.throwNpe();
        }
        float f = xoff;
        view.setTranslationX(r2.getContentPointX() + f);
        View view2 = this.mContentView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        }
        if (this.mCurrentPosition == null) {
            Intrinsics.throwNpe();
        }
        float f2 = yoff;
        view2.setTranslationY(r1.getContentPointY() + f2);
        TooltipOverlay tooltipOverlay = this.mViewOverlay;
        if (tooltipOverlay != null) {
            if (this.mCurrentPosition == null) {
                Intrinsics.throwNpe();
            }
            tooltipOverlay.setTranslationX((r1.getCenterPointX() - (tooltipOverlay.getMeasuredWidth() / 2)) + f);
            if (this.mCurrentPosition == null) {
                Intrinsics.throwNpe();
            }
            tooltipOverlay.setTranslationY((r4.getCenterPointY() - (tooltipOverlay.getMeasuredHeight() / 2)) + f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeListeners(View anchorView) {
        ViewTreeObserver viewTreeObserver;
        if (!this.mFollowAnchor || anchorView == null || (viewTreeObserver = anchorView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.removeOnPreDrawListener(this.predrawListener);
    }

    private final void setupAnimation(Gravity gravity) {
        Animation animation;
        int direction;
        TextView textView = this.mTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        }
        View view = this.mContentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        }
        if (textView == view || (animation = this.mFloatingAnimation) == null) {
            return;
        }
        if (animation == null) {
            Intrinsics.throwNpe();
        }
        int radius = animation.getRadius();
        Animation animation2 = this.mFloatingAnimation;
        if (animation2 == null) {
            Intrinsics.throwNpe();
        }
        long duration = animation2.getDuration();
        Animation animation3 = this.mFloatingAnimation;
        if (animation3 == null) {
            Intrinsics.throwNpe();
        }
        if (animation3.getDirection() == 0) {
            direction = (gravity == Gravity.TOP || gravity == Gravity.BOTTOM) ? 2 : 1;
        } else {
            Animation animation4 = this.mFloatingAnimation;
            if (animation4 == null) {
                Intrinsics.throwNpe();
            }
            direction = animation4.getDirection();
        }
        String str = direction == 2 ? "translationY" : "translationX";
        TextView textView2 = this.mTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        }
        float f = radius;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView2, str, -f, f);
        this.mAnimator = objectAnimatorOfFloat;
        if (objectAnimatorOfFloat == null) {
            Intrinsics.throwNpe();
        }
        objectAnimatorOfFloat.setDuration(duration);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(2);
    }

    public static /* synthetic */ void show$default(Tooltip tooltip, View view, Gravity gravity, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        tooltip.show(view, gravity, z);
    }

    public final void show(View parent, Gravity gravity, boolean fitToScreen) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        Intrinsics.checkParameterIsNotNull(gravity, "gravity");
        if (this.isShowing) {
            return;
        }
        if (this.mHasAnchorView) {
            WeakReference<View> weakReference = this.mAnchorView;
            if ((weakReference != null ? weakReference.get() : null) == null) {
                return;
            }
        }
        this.isVisible = false;
        IBinder windowToken = parent.getWindowToken();
        Intrinsics.checkExpressionValueIsNotNull(windowToken, "parent.windowToken");
        WindowManager.LayoutParams layoutParamsCreatePopupLayoutParams = createPopupLayoutParams(windowToken);
        preparePopup(layoutParamsCreatePopupLayoutParams, gravity);
        ArrayList<Gravity> arrayList = (ArrayList) CollectionsKt.toCollection(this.mGravities, new ArrayList());
        arrayList.remove(gravity);
        arrayList.add(0, gravity);
        WeakReference<View> weakReference2 = this.mAnchorView;
        invokePopup(findPosition(parent, weakReference2 != null ? weakReference2.get() : null, this.mAnchorPoint, arrayList, layoutParamsCreatePopupLayoutParams, fitToScreen));
    }

    public final void hide() {
        Timber.m5656i("hide", new Object[0]);
        if (this.isShowing) {
            fadeOut(this.mFadeDuration);
        }
    }

    public final void dismiss() {
        if (!this.isShowing || this.mPopupView == null) {
            return;
        }
        WeakReference<View> weakReference = this.mAnchorView;
        removeListeners(weakReference != null ? weakReference.get() : null);
        removeCallbacks();
        this.windowManager.removeView(this.mPopupView);
        Timber.m5659v("dismiss: " + this.mPopupView, new Object[0]);
        this.mPopupView = null;
        this.isShowing = false;
        this.isVisible = false;
        Function1<? super Tooltip, Unit> function1 = this.mHiddenFunc;
        if (function1 != null) {
            function1.invoke(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeCallbacks() {
        this.mHandler.removeCallbacks(this.hideRunnable);
        this.mHandler.removeCallbacks(this.activateRunnable);
    }

    private final void fadeIn(long fadeDuration) {
        TooltipViewContainer tooltipViewContainer;
        if (!this.isShowing || this.isVisible) {
            return;
        }
        this.isVisible = true;
        if (fadeDuration > 0 && (tooltipViewContainer = this.mPopupView) != null) {
            if (tooltipViewContainer == null) {
                Intrinsics.throwNpe();
            }
            tooltipViewContainer.setAlpha(0.0f);
            TooltipViewContainer tooltipViewContainer2 = this.mPopupView;
            if (tooltipViewContainer2 == null) {
                Intrinsics.throwNpe();
            }
            tooltipViewContainer2.animate().setDuration(this.mFadeDuration).alpha(1.0f).start();
        }
        Function1<? super Tooltip, Unit> function1 = this.mShownFunc;
        if (function1 != null) {
            function1.invoke(this);
        }
    }

    private final void fadeOut(final long fadeDuration) {
        if (this.isShowing && this.isVisible) {
            this.isVisible = false;
            removeCallbacks();
            Timber.m5656i("fadeOut(" + fadeDuration + ')', new Object[0]);
            if (fadeDuration > 0) {
                final TooltipViewContainer tooltipViewContainer = this.mPopupView;
                if (tooltipViewContainer != null) {
                    tooltipViewContainer.clearAnimation();
                    ViewPropertyAnimator duration = tooltipViewContainer.animate().alpha(0.0f).setDuration(fadeDuration);
                    Intrinsics.checkExpressionValueIsNotNull(duration, "popupView.animate()\n    …setDuration(fadeDuration)");
                    AnimationListener animationListener = new AnimationListener();
                    animationListener.onAnimationEnd(new Function1<Animator, Unit>() { // from class: it.sephiroth.android.library.xtooltip.Tooltip$fadeOut$$inlined$let$lambda$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
                            invoke2(animator);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Animator it2) {
                            Intrinsics.checkParameterIsNotNull(it2, "it");
                            tooltipViewContainer.setVisibility(4);
                            this.dismiss();
                        }
                    });
                    duration.setListener(animationListener);
                    duration.start();
                    return;
                }
                return;
            }
            dismiss();
        }
    }

    /* JADX INFO: compiled from: Tooltip.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J0\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J(\u0010\u0017\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0014J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001bH\u0017R@\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m5598d2 = {"Lit/sephiroth/android/library/xtooltip/Tooltip$TooltipViewContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Lit/sephiroth/android/library/xtooltip/Tooltip;Landroid/content/Context;)V", "sizeChange", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "w", "h", "", "dispatchKeyEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", ViewProps.ON_LAYOUT, "changed", ViewProps.LEFT, ViewProps.TOP, ViewProps.RIGHT, ViewProps.BOTTOM, "onSizeChanged", "oldw", "oldh", "onTouchEvent", "Landroid/view/MotionEvent;", "xtooltip_release"}, m5599k = 1, m5600mv = {1, 1, 13})
    public final class TooltipViewContainer extends FrameLayout {
        private HashMap _$_findViewCache;
        private Function2<? super Integer, ? super Integer, Unit> sizeChange;
        final /* synthetic */ Tooltip this$0;

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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TooltipViewContainer(Tooltip tooltip, Context context) {
            super(context);
            Intrinsics.checkParameterIsNotNull(context, "context");
            this.this$0 = tooltip;
            setClipChildren(false);
            setClipToPadding(false);
        }

        @Override // android.view.View
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            Function2<? super Integer, ? super Integer, Unit> function2 = this.sizeChange;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(w), Integer.valueOf(h));
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            super.onLayout(changed, left, top, right, bottom);
            if (changed) {
                int[] iArr = {-1, -1};
                getLocationOnScreen(iArr);
                Timber.m5659v("globalVisibleRect: " + iArr[0] + ", " + iArr[1], new Object[0]);
                offsetTopAndBottom(-iArr[1]);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent event) {
            KeyEvent.DispatcherState keyDispatcherState;
            Intrinsics.checkParameterIsNotNull(event, "event");
            if (!this.this$0.getIsShowing() || !this.this$0.isVisible || !this.this$0.mActivated) {
                return super.dispatchKeyEvent(event);
            }
            if (event.getKeyCode() == 4) {
                if (getKeyDispatcherState() == null) {
                    return super.dispatchKeyEvent(event);
                }
                if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.startTracking(event, this);
                    }
                    return true;
                }
                if (event.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(event) && !event.isCanceled()) {
                    Timber.m5659v("Back pressed, close the tooltip", new Object[0]);
                    this.this$0.hide();
                    return true;
                }
                return super.dispatchKeyEvent(event);
            }
            return super.dispatchKeyEvent(event);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            Intrinsics.checkParameterIsNotNull(event, "event");
            if (!this.this$0.getIsShowing() || !this.this$0.isVisible || !this.this$0.mActivated) {
                return false;
            }
            Timber.m5656i("onTouchEvent: " + event, new Object[0]);
            Timber.m5650d("event position: " + event.getX() + ", " + event.getY(), new Object[0]);
            Rect rect = new Rect();
            Tooltip.access$getMTextView$p(this.this$0).getGlobalVisibleRect(rect);
            boolean zContains = rect.contains((int) event.getX(), (int) event.getY());
            if (!this.this$0.mClosePolicy.anywhere()) {
                if (!this.this$0.mClosePolicy.inside() || !zContains) {
                    if (this.this$0.mClosePolicy.outside() && !zContains) {
                        this.this$0.hide();
                    }
                } else {
                    this.this$0.hide();
                }
            } else {
                this.this$0.hide();
            }
            return this.this$0.mClosePolicy.consume();
        }
    }

    /* JADX INFO: compiled from: Tooltip.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003JE\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0010HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0016\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0018\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u0011\u0010\u001b\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u001d\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00062"}, m5598d2 = {"Lit/sephiroth/android/library/xtooltip/Tooltip$Positions;", "", "displayFrame", "Landroid/graphics/Rect;", "arrowPoint", "Landroid/graphics/Point;", "centerPoint", "contentPoint", "gravity", "Lit/sephiroth/android/library/xtooltip/Tooltip$Gravity;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "Landroid/view/WindowManager$LayoutParams;", "(Landroid/graphics/Rect;Landroid/graphics/Point;Landroid/graphics/Point;Landroid/graphics/Point;Lit/sephiroth/android/library/xtooltip/Tooltip$Gravity;Landroid/view/WindowManager$LayoutParams;)V", "getArrowPoint", "()Landroid/graphics/Point;", "arrowPointX", "", "getArrowPointX", "()I", "arrowPointY", "getArrowPointY", "getCenterPoint", "centerPointX", "getCenterPointX", "centerPointY", "getCenterPointY", "getContentPoint", "contentPointX", "getContentPointX", "contentPointY", "getContentPointY", "getDisplayFrame", "()Landroid/graphics/Rect;", "getGravity", "()Lit/sephiroth/android/library/xtooltip/Tooltip$Gravity;", "getParams", "()Landroid/view/WindowManager$LayoutParams;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "xtooltip_release"}, m5599k = 1, m5600mv = {1, 1, 13})
    private static final /* data */ class Positions {
        private final Point arrowPoint;
        private final int arrowPointX;
        private final int arrowPointY;
        private final Point centerPoint;
        private final int centerPointX;
        private final int centerPointY;
        private final Point contentPoint;
        private final int contentPointX;
        private final int contentPointY;
        private final Rect displayFrame;
        private final Gravity gravity;
        private final WindowManager.LayoutParams params;

        public static /* synthetic */ Positions copy$default(Positions positions, Rect rect, Point point, Point point2, Point point3, Gravity gravity, WindowManager.LayoutParams layoutParams, int i, Object obj) {
            if ((i & 1) != 0) {
                rect = positions.displayFrame;
            }
            if ((i & 2) != 0) {
                point = positions.arrowPoint;
            }
            Point point4 = point;
            if ((i & 4) != 0) {
                point2 = positions.centerPoint;
            }
            Point point5 = point2;
            if ((i & 8) != 0) {
                point3 = positions.contentPoint;
            }
            Point point6 = point3;
            if ((i & 16) != 0) {
                gravity = positions.gravity;
            }
            Gravity gravity2 = gravity;
            if ((i & 32) != 0) {
                layoutParams = positions.params;
            }
            return positions.copy(rect, point4, point5, point6, gravity2, layoutParams);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Rect getDisplayFrame() {
            return this.displayFrame;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Point getArrowPoint() {
            return this.arrowPoint;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Point getCenterPoint() {
            return this.centerPoint;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Point getContentPoint() {
            return this.contentPoint;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Gravity getGravity() {
            return this.gravity;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final WindowManager.LayoutParams getParams() {
            return this.params;
        }

        public final Positions copy(Rect displayFrame, Point arrowPoint, Point centerPoint, Point contentPoint, Gravity gravity, WindowManager.LayoutParams params) {
            Intrinsics.checkParameterIsNotNull(displayFrame, "displayFrame");
            Intrinsics.checkParameterIsNotNull(arrowPoint, "arrowPoint");
            Intrinsics.checkParameterIsNotNull(centerPoint, "centerPoint");
            Intrinsics.checkParameterIsNotNull(contentPoint, "contentPoint");
            Intrinsics.checkParameterIsNotNull(gravity, "gravity");
            Intrinsics.checkParameterIsNotNull(params, "params");
            return new Positions(displayFrame, arrowPoint, centerPoint, contentPoint, gravity, params);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Positions)) {
                return false;
            }
            Positions positions = (Positions) other;
            return Intrinsics.areEqual(this.displayFrame, positions.displayFrame) && Intrinsics.areEqual(this.arrowPoint, positions.arrowPoint) && Intrinsics.areEqual(this.centerPoint, positions.centerPoint) && Intrinsics.areEqual(this.contentPoint, positions.contentPoint) && Intrinsics.areEqual(this.gravity, positions.gravity) && Intrinsics.areEqual(this.params, positions.params);
        }

        public int hashCode() {
            Rect rect = this.displayFrame;
            int iHashCode = (rect != null ? rect.hashCode() : 0) * 31;
            Point point = this.arrowPoint;
            int iHashCode2 = (iHashCode + (point != null ? point.hashCode() : 0)) * 31;
            Point point2 = this.centerPoint;
            int iHashCode3 = (iHashCode2 + (point2 != null ? point2.hashCode() : 0)) * 31;
            Point point3 = this.contentPoint;
            int iHashCode4 = (iHashCode3 + (point3 != null ? point3.hashCode() : 0)) * 31;
            Gravity gravity = this.gravity;
            int iHashCode5 = (iHashCode4 + (gravity != null ? gravity.hashCode() : 0)) * 31;
            WindowManager.LayoutParams layoutParams = this.params;
            return iHashCode5 + (layoutParams != null ? layoutParams.hashCode() : 0);
        }

        public String toString() {
            return "Positions(displayFrame=" + this.displayFrame + ", arrowPoint=" + this.arrowPoint + ", centerPoint=" + this.centerPoint + ", contentPoint=" + this.contentPoint + ", gravity=" + this.gravity + ", params=" + this.params + ")";
        }

        public Positions(Rect displayFrame, Point arrowPoint, Point centerPoint, Point contentPoint, Gravity gravity, WindowManager.LayoutParams params) {
            Intrinsics.checkParameterIsNotNull(displayFrame, "displayFrame");
            Intrinsics.checkParameterIsNotNull(arrowPoint, "arrowPoint");
            Intrinsics.checkParameterIsNotNull(centerPoint, "centerPoint");
            Intrinsics.checkParameterIsNotNull(contentPoint, "contentPoint");
            Intrinsics.checkParameterIsNotNull(gravity, "gravity");
            Intrinsics.checkParameterIsNotNull(params, "params");
            this.displayFrame = displayFrame;
            this.arrowPoint = arrowPoint;
            this.centerPoint = centerPoint;
            this.contentPoint = contentPoint;
            this.gravity = gravity;
            this.params = params;
            this.centerPointX = centerPoint.x;
            this.centerPointY = centerPoint.y;
            this.arrowPointX = arrowPoint.x;
            this.arrowPointY = arrowPoint.y;
            this.contentPointX = contentPoint.x;
            this.contentPointY = contentPoint.y;
        }

        public final Rect getDisplayFrame() {
            return this.displayFrame;
        }

        public final Point getArrowPoint() {
            return this.arrowPoint;
        }

        public final Point getCenterPoint() {
            return this.centerPoint;
        }

        public final Point getContentPoint() {
            return this.contentPoint;
        }

        public final Gravity getGravity() {
            return this.gravity;
        }

        public final WindowManager.LayoutParams getParams() {
            return this.params;
        }

        public final int getCenterPointX() {
            return this.centerPointX;
        }

        public final int getCenterPointY() {
            return this.centerPointY;
        }

        public final int getArrowPointX() {
            return this.arrowPointX;
        }

        public final int getArrowPointY() {
            return this.arrowPointY;
        }

        public final int getContentPointX() {
            return this.contentPointX;
        }

        public final int getContentPointY() {
            return this.contentPointY;
        }
    }

    /* JADX INFO: compiled from: Tooltip.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, m5598d2 = {"Lit/sephiroth/android/library/xtooltip/Tooltip$Animation;", "", RadialGradientManager.PROP_RADIUS, "", "direction", "duration", "", "(IIJ)V", "getDirection", "()I", "getDuration", "()J", "getRadius", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "xtooltip_release"}, m5599k = 1, m5600mv = {1, 1, 13})
    public static final /* data */ class Animation {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Animation DEFAULT = new Animation(8, 0, 400);
        private static final Animation SLOW = new Animation(4, 0, 600);
        private final int direction;
        private final long duration;
        private final int radius;

        public static /* synthetic */ Animation copy$default(Animation animation, int i, int i2, long j, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = animation.radius;
            }
            if ((i3 & 2) != 0) {
                i2 = animation.direction;
            }
            if ((i3 & 4) != 0) {
                j = animation.duration;
            }
            return animation.copy(i, i2, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getRadius() {
            return this.radius;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getDirection() {
            return this.direction;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        public final Animation copy(int radius, int direction, long duration) {
            return new Animation(radius, direction, duration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Animation)) {
                return false;
            }
            Animation animation = (Animation) other;
            return this.radius == animation.radius && this.direction == animation.direction && this.duration == animation.duration;
        }

        public int hashCode() {
            int i = ((this.radius * 31) + this.direction) * 31;
            long j = this.duration;
            return i + ((int) (j ^ (j >>> 32)));
        }

        public String toString() {
            return "Animation(radius=" + this.radius + ", direction=" + this.direction + ", duration=" + this.duration + ")";
        }

        public Animation(int i, int i2, long j) {
            this.radius = i;
            this.direction = i2;
            this.duration = j;
        }

        public final int getDirection() {
            return this.direction;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final int getRadius() {
            return this.radius;
        }

        /* JADX INFO: compiled from: Tooltip.kt */
        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, m5598d2 = {"Lit/sephiroth/android/library/xtooltip/Tooltip$Animation$Companion;", "", "()V", "DEFAULT", "Lit/sephiroth/android/library/xtooltip/Tooltip$Animation;", "getDEFAULT", "()Lit/sephiroth/android/library/xtooltip/Tooltip$Animation;", "SLOW", "getSLOW", "xtooltip_release"}, m5599k = 1, m5600mv = {1, 1, 13})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Animation getDEFAULT() {
                return Animation.DEFAULT;
            }

            public final Animation getSLOW() {
                return Animation.SLOW;
            }
        }
    }

    /* JADX INFO: compiled from: Tooltip.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0006J,\u0010W\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\f2\b\b\u0002\u0010Y\u001a\u00020\u00182\b\b\u0002\u0010Z\u001a\u00020\u00182\b\b\u0002\u0010[\u001a\u00020*J\u0016\u0010W\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020\u00182\u0006\u0010]\u001a\u00020\u0018J\u000e\u0010^\u001a\u00020\u00002\u0006\u0010V\u001a\u00020*J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010_\u001a\u00020\u0012J\u0006\u0010`\u001a\u00020aJ\u001a\u0010b\u001a\u00020\u00002\b\b\u0001\u0010/\u001a\u00020\u00182\b\b\u0001\u0010M\u001a\u00020\u0018J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0006J\u0010\u0010#\u001a\u00020\u00002\b\u0010V\u001a\u0004\u0018\u00010$J\u000e\u00105\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u0018J\u000e\u00108\u001a\u00020\u00002\u0006\u0010V\u001a\u00020*J\u000e\u0010D\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0006J\u0017\u0010d\u001a\u00020\u00002\n\b\u0001\u0010d\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010eJ\u000e\u0010G\u001a\u00020\u00002\u0006\u0010G\u001a\u00020HJ\u0010\u0010G\u001a\u00020\u00002\b\b\u0001\u0010G\u001a\u00020\u0018J)\u0010G\u001a\u00020\u00002\b\b\u0001\u0010G\u001a\u00020\u00182\u0012\u0010f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010g\"\u00020\u0001¢\u0006\u0002\u0010hJ\u0010\u0010P\u001a\u00020\u00002\b\u0010V\u001a\u0004\u0018\u00010QR\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\nR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0081\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00105\u001a\u0004\u0018\u00010\u0018X\u0080\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b6\u00101\"\u0004\b7\u00103R\u001a\u00108\u001a\u00020*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010,\"\u0004\b:\u0010.R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010,\"\u0004\bC\u0010.R\u001a\u0010D\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\b\"\u0004\bF\u0010\nR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010M\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0081\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\bN\u00101\"\u0004\bO\u00103R\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U¨\u0006i"}, m5598d2 = {"Lit/sephiroth/android/library/xtooltip/Tooltip$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activateDelay", "", "getActivateDelay$xtooltip_release", "()J", "setActivateDelay$xtooltip_release", "(J)V", "anchorView", "Landroid/view/View;", "getAnchorView$xtooltip_release", "()Landroid/view/View;", "setAnchorView$xtooltip_release", "(Landroid/view/View;)V", "closePolicy", "Lit/sephiroth/android/library/xtooltip/ClosePolicy;", "getClosePolicy$xtooltip_release", "()Lit/sephiroth/android/library/xtooltip/ClosePolicy;", "setClosePolicy$xtooltip_release", "(Lit/sephiroth/android/library/xtooltip/ClosePolicy;)V", "defStyleAttr", "", "getDefStyleAttr$xtooltip_release", "()I", "setDefStyleAttr$xtooltip_release", "(I)V", "defStyleRes", "getDefStyleRes$xtooltip_release", "setDefStyleRes$xtooltip_release", "fadeDuration", "getFadeDuration$xtooltip_release", "setFadeDuration$xtooltip_release", "floatingAnimation", "Lit/sephiroth/android/library/xtooltip/Tooltip$Animation;", "getFloatingAnimation$xtooltip_release", "()Lit/sephiroth/android/library/xtooltip/Tooltip$Animation;", "setFloatingAnimation$xtooltip_release", "(Lit/sephiroth/android/library/xtooltip/Tooltip$Animation;)V", "followAnchor", "", "getFollowAnchor$xtooltip_release", "()Z", "setFollowAnchor$xtooltip_release", "(Z)V", "layoutId", "getLayoutId$xtooltip_release", "()Ljava/lang/Integer;", "setLayoutId$xtooltip_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", ViewProps.MAX_WIDTH, "getMaxWidth$xtooltip_release", "setMaxWidth$xtooltip_release", "overlay", "getOverlay$xtooltip_release", "setOverlay$xtooltip_release", "point", "Landroid/graphics/Point;", "getPoint$xtooltip_release", "()Landroid/graphics/Point;", "setPoint$xtooltip_release", "(Landroid/graphics/Point;)V", "showArrow", "getShowArrow$xtooltip_release", "setShowArrow$xtooltip_release", "showDuration", "getShowDuration$xtooltip_release", "setShowDuration$xtooltip_release", "text", "", "getText$xtooltip_release", "()Ljava/lang/CharSequence;", "setText$xtooltip_release", "(Ljava/lang/CharSequence;)V", "textId", "getTextId$xtooltip_release", "setTextId$xtooltip_release", "typeface", "Landroid/graphics/Typeface;", "getTypeface$xtooltip_release", "()Landroid/graphics/Typeface;", "setTypeface$xtooltip_release", "(Landroid/graphics/Typeface;)V", "value", "anchor", "view", "xoff", "yoff", "follow", EllipticCurveJsonWebKey.X_MEMBER_NAME, EllipticCurveJsonWebKey.Y_MEMBER_NAME, "arrow", "policy", "create", "Lit/sephiroth/android/library/xtooltip/Tooltip;", "customView", "w", "styleId", "(Ljava/lang/Integer;)Lit/sephiroth/android/library/xtooltip/Tooltip$Builder;", "args", "", "(I[Ljava/lang/Object;)Lit/sephiroth/android/library/xtooltip/Tooltip$Builder;", "xtooltip_release"}, m5599k = 1, m5600mv = {1, 1, 13})
    public static final class Builder {
        private long activateDelay;
        private View anchorView;
        private ClosePolicy closePolicy;
        private final Context context;
        private int defStyleAttr;
        private int defStyleRes;
        private long fadeDuration;
        private Animation floatingAnimation;
        private boolean followAnchor;
        private Integer layoutId;
        private Integer maxWidth;
        private boolean overlay;
        private Point point;
        private boolean showArrow;
        private long showDuration;
        private CharSequence text;
        private Integer textId;
        private Typeface typeface;

        public Builder(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            this.context = context;
            this.closePolicy = ClosePolicy.INSTANCE.getTOUCH_INSIDE_CONSUME();
            this.defStyleRes = C5487R.style.ToolTipLayoutDefaultStyle;
            this.defStyleAttr = C5487R.attr.ttlm_defaultStyle;
            this.overlay = true;
            this.fadeDuration = 100L;
            this.showArrow = true;
        }

        /* JADX INFO: renamed from: getPoint$xtooltip_release, reason: from getter */
        public final Point getPoint() {
            return this.point;
        }

        public final void setPoint$xtooltip_release(Point point) {
            this.point = point;
        }

        /* JADX INFO: renamed from: getClosePolicy$xtooltip_release, reason: from getter */
        public final ClosePolicy getClosePolicy() {
            return this.closePolicy;
        }

        public final void setClosePolicy$xtooltip_release(ClosePolicy closePolicy) {
            Intrinsics.checkParameterIsNotNull(closePolicy, "<set-?>");
            this.closePolicy = closePolicy;
        }

        /* JADX INFO: renamed from: getText$xtooltip_release, reason: from getter */
        public final CharSequence getText() {
            return this.text;
        }

        public final void setText$xtooltip_release(CharSequence charSequence) {
            this.text = charSequence;
        }

        /* JADX INFO: renamed from: getAnchorView$xtooltip_release, reason: from getter */
        public final View getAnchorView() {
            return this.anchorView;
        }

        public final void setAnchorView$xtooltip_release(View view) {
            this.anchorView = view;
        }

        /* JADX INFO: renamed from: getMaxWidth$xtooltip_release, reason: from getter */
        public final Integer getMaxWidth() {
            return this.maxWidth;
        }

        public final void setMaxWidth$xtooltip_release(Integer num) {
            this.maxWidth = num;
        }

        /* JADX INFO: renamed from: getDefStyleRes$xtooltip_release, reason: from getter */
        public final int getDefStyleRes() {
            return this.defStyleRes;
        }

        public final void setDefStyleRes$xtooltip_release(int i) {
            this.defStyleRes = i;
        }

        /* JADX INFO: renamed from: getDefStyleAttr$xtooltip_release, reason: from getter */
        public final int getDefStyleAttr() {
            return this.defStyleAttr;
        }

        public final void setDefStyleAttr$xtooltip_release(int i) {
            this.defStyleAttr = i;
        }

        /* JADX INFO: renamed from: getTypeface$xtooltip_release, reason: from getter */
        public final Typeface getTypeface() {
            return this.typeface;
        }

        public final void setTypeface$xtooltip_release(Typeface typeface) {
            this.typeface = typeface;
        }

        /* JADX INFO: renamed from: getOverlay$xtooltip_release, reason: from getter */
        public final boolean getOverlay() {
            return this.overlay;
        }

        public final void setOverlay$xtooltip_release(boolean z) {
            this.overlay = z;
        }

        /* JADX INFO: renamed from: getFloatingAnimation$xtooltip_release, reason: from getter */
        public final Animation getFloatingAnimation() {
            return this.floatingAnimation;
        }

        public final void setFloatingAnimation$xtooltip_release(Animation animation) {
            this.floatingAnimation = animation;
        }

        /* JADX INFO: renamed from: getShowDuration$xtooltip_release, reason: from getter */
        public final long getShowDuration() {
            return this.showDuration;
        }

        public final void setShowDuration$xtooltip_release(long j) {
            this.showDuration = j;
        }

        /* JADX INFO: renamed from: getFadeDuration$xtooltip_release, reason: from getter */
        public final long getFadeDuration() {
            return this.fadeDuration;
        }

        public final void setFadeDuration$xtooltip_release(long j) {
            this.fadeDuration = j;
        }

        /* JADX INFO: renamed from: getShowArrow$xtooltip_release, reason: from getter */
        public final boolean getShowArrow() {
            return this.showArrow;
        }

        public final void setShowArrow$xtooltip_release(boolean z) {
            this.showArrow = z;
        }

        /* JADX INFO: renamed from: getActivateDelay$xtooltip_release, reason: from getter */
        public final long getActivateDelay() {
            return this.activateDelay;
        }

        public final void setActivateDelay$xtooltip_release(long j) {
            this.activateDelay = j;
        }

        /* JADX INFO: renamed from: getFollowAnchor$xtooltip_release, reason: from getter */
        public final boolean getFollowAnchor() {
            return this.followAnchor;
        }

        public final void setFollowAnchor$xtooltip_release(boolean z) {
            this.followAnchor = z;
        }

        /* JADX INFO: renamed from: getLayoutId$xtooltip_release, reason: from getter */
        public final Integer getLayoutId() {
            return this.layoutId;
        }

        public final void setLayoutId$xtooltip_release(Integer num) {
            this.layoutId = num;
        }

        /* JADX INFO: renamed from: getTextId$xtooltip_release, reason: from getter */
        public final Integer getTextId() {
            return this.textId;
        }

        public final void setTextId$xtooltip_release(Integer num) {
            this.textId = num;
        }

        public final Builder typeface(Typeface value) {
            this.typeface = value;
            return this;
        }

        public final Builder styleId(Integer styleId) {
            if (styleId != null) {
                int iIntValue = styleId.intValue();
                this.defStyleAttr = 0;
                this.defStyleRes = iIntValue;
            } else {
                this.defStyleRes = C5487R.style.ToolTipLayoutDefaultStyle;
                this.defStyleAttr = C5487R.attr.ttlm_defaultStyle;
            }
            return this;
        }

        public final Builder customView(int layoutId, int textId) {
            this.layoutId = Integer.valueOf(layoutId);
            this.textId = Integer.valueOf(textId);
            return this;
        }

        public final Builder activateDelay(long value) {
            this.activateDelay = value;
            return this;
        }

        public final Builder arrow(boolean value) {
            this.showArrow = value;
            return this;
        }

        public final Builder fadeDuration(long value) {
            this.fadeDuration = value;
            return this;
        }

        public final Builder showDuration(long value) {
            this.showDuration = value;
            return this;
        }

        public final Builder floatingAnimation(Animation value) {
            this.floatingAnimation = value;
            return this;
        }

        public final Builder maxWidth(int w) {
            this.maxWidth = Integer.valueOf(w);
            return this;
        }

        public final Builder overlay(boolean value) {
            this.overlay = value;
            return this;
        }

        public final Builder anchor(int x, int y) {
            this.anchorView = null;
            this.point = new Point(x, y);
            return this;
        }

        public static /* synthetic */ Builder anchor$default(Builder builder, View view, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            if ((i3 & 8) != 0) {
                z = false;
            }
            return builder.anchor(view, i, i2, z);
        }

        public final Builder anchor(View view, int xoff, int yoff, boolean follow) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            this.anchorView = view;
            this.followAnchor = follow;
            this.point = new Point(xoff, yoff);
            return this;
        }

        public final Builder text(CharSequence text) {
            Intrinsics.checkParameterIsNotNull(text, "text");
            this.text = text;
            return this;
        }

        public final Builder text(int text) {
            this.text = this.context.getString(text);
            return this;
        }

        public final Builder text(int text, Object... args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.text = this.context.getString(text, args);
            return this;
        }

        public final Builder closePolicy(ClosePolicy policy) {
            Intrinsics.checkParameterIsNotNull(policy, "policy");
            this.closePolicy = policy;
            Timber.m5659v("closePolicy: " + policy, new Object[0]);
            return this;
        }

        public final Tooltip create() {
            if (this.anchorView == null && this.point == null) {
                throw new IllegalArgumentException("missing anchor point or anchor view");
            }
            return new Tooltip(this.context, this, null);
        }
    }

    private final void setupListeners(View anchorView) {
        AttachStateChangeListener attachStateChangeListener = new AttachStateChangeListener();
        attachStateChangeListener.onViewDetachedFromWindow(new Function2<View, View.OnAttachStateChangeListener, Unit>() { // from class: it.sephiroth.android.library.xtooltip.Tooltip$setupListeners$$inlined$addOnAttachStateChangeListener$lambda$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, View.OnAttachStateChangeListener onAttachStateChangeListener) {
                invoke2(view, onAttachStateChangeListener);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view, View.OnAttachStateChangeListener listener) {
                Intrinsics.checkParameterIsNotNull(listener, "listener");
                Timber.m5656i("anchorView detached from parent", new Object[0]);
                if (view != null) {
                    view.removeOnAttachStateChangeListener(listener);
                }
                this.this$0.dismiss();
            }
        });
        anchorView.addOnAttachStateChangeListener(attachStateChangeListener);
        if (this.mFollowAnchor) {
            anchorView.getViewTreeObserver().addOnPreDrawListener(this.predrawListener);
        }
    }
}
