package com.yoti.mobile.android.common.p049ui.widgets.hologramview.p050ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.yoti.mobile.android.common.p049ui.widgets.hologramview.sensor.DeviceOrientation;
import com.yoti.mobile.android.common.p049ui.widgets.hologramview.sensor.SensorListener;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\nB+\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b!\u0010#J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006$"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/hologramview/ui/HologramView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", "a", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/drawable/Drawable;", "pattern", "setPattern", "(Landroid/graphics/drawable/Drawable;)V", "pause", "()V", "resume", "Lcom/yoti/mobile/android/common/ui/widgets/hologramview/ui/AnimatedMovableGradientTileDrawable;", "c", "Lcom/yoti/mobile/android/common/ui/widgets/hologramview/ui/AnimatedMovableGradientTileDrawable;", "movableGradientTileDrawable", "", "d", "[I", "topColorList", "Lcom/yoti/mobile/android/common/ui/widgets/hologramview/sensor/DeviceOrientation;", "Lcom/yoti/mobile/android/common/ui/widgets/hologramview/sensor/DeviceOrientation;", "deviceOrientation", "Lcom/yoti/mobile/android/common/ui/widgets/hologramview/ui/MovableGradientDrawable;", "b", "Lcom/yoti/mobile/android/common/ui/widgets/hologramview/ui/MovableGradientDrawable;", "foregroundGradient", "<init>", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class HologramView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private DeviceOrientation deviceOrientation;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private MovableGradientDrawable foregroundGradient;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private AnimatedMovableGradientTileDrawable movableGradientTileDrawable;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private int[] topColorList;

    /* JADX INFO: renamed from: e */
    private HashMap f6455e;

    public HologramView(Context context) {
        this(context, null, 0, 6, null);
    }

    public HologramView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HologramView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        m4670a(context, attributeSet, i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HologramView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        m4670a(context, attributeSet, i);
    }

    public /* synthetic */ HologramView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: renamed from: a */
    private final void m4670a(Context context, AttributeSet attrs, int defStyleAttr) {
        FrameLayout.inflate(context, C4584R.layout.view_hologram, this);
        int[] iArr = C4584R.styleable.HologramView;
        Intrinsics.checkNotNullExpressionValue(iArr, "R.styleable.HologramView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr, defStyleAttr, 0);
        Object systemService = context.getSystemService("sensor");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.hardware.SensorManager");
        }
        SensorManager sensorManager = (SensorManager) systemService;
        Object systemService2 = context.getSystemService("window");
        if (systemService2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        Display defaultDisplay = ((WindowManager) systemService2).getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "windowManager.defaultDisplay");
        this.deviceOrientation = new DeviceOrientation(sensorManager, defaultDisplay);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C4584R.styleable.HologramView_tileBackground);
        int[] intArray = typedArrayObtainStyledAttributes.getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(C4584R.styleable.HologramView_topColorList, 0));
        Intrinsics.checkNotNullExpressionValue(intArray, "resources.getIntArray(topColorListResId)");
        this.topColorList = intArray;
        int[] bottomColorList = typedArrayObtainStyledAttributes.getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(C4584R.styleable.HologramView_bottomColorList, 0));
        Intrinsics.checkNotNullExpressionValue(bottomColorList, "bottomColorList");
        this.foregroundGradient = new MovableGradientDrawable(40, bottomColorList);
        if (drawable != null) {
            setPattern(drawable);
        }
        View gradientView = _$_findCachedViewById(C4584R.id.gradientView);
        Intrinsics.checkNotNullExpressionValue(gradientView, "gradientView");
        MovableGradientDrawable movableGradientDrawable = this.foregroundGradient;
        if (movableGradientDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foregroundGradient");
        }
        gradientView.setBackground(movableGradientDrawable);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static final /* synthetic */ MovableGradientDrawable access$getForegroundGradient$p(HologramView hologramView) {
        MovableGradientDrawable movableGradientDrawable = hologramView.foregroundGradient;
        if (movableGradientDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foregroundGradient");
        }
        return movableGradientDrawable;
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6455e;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f6455e == null) {
            this.f6455e = new HashMap();
        }
        View view = (View) this.f6455e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f6455e.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void pause() {
        AnimatedMovableGradientTileDrawable animatedMovableGradientTileDrawable = this.movableGradientTileDrawable;
        if (animatedMovableGradientTileDrawable != null) {
            animatedMovableGradientTileDrawable.stop();
        }
        DeviceOrientation deviceOrientation = this.deviceOrientation;
        if (deviceOrientation != null) {
            deviceOrientation.stopListening();
        }
    }

    public final void resume() {
        AnimatedMovableGradientTileDrawable animatedMovableGradientTileDrawable = this.movableGradientTileDrawable;
        if (animatedMovableGradientTileDrawable != null) {
            animatedMovableGradientTileDrawable.start();
        }
        DeviceOrientation deviceOrientation = this.deviceOrientation;
        if (deviceOrientation != null) {
            deviceOrientation.startListening(new SensorListener() { // from class: com.yoti.mobile.android.common.ui.widgets.hologramview.ui.HologramView.resume.1
                @Override // com.yoti.mobile.android.common.p049ui.widgets.hologramview.sensor.SensorListener
                public void onOrientationChanged(float azimuth, float pitch, float roll) {
                    float f = 2;
                    float fCoerceIn = ((0.5f - ((RangesKt.coerceIn(roll, -75.0f, 75.0f) / 75.0f) / f)) + (0.5f - ((RangesKt.coerceIn(pitch, -75.0f, 75.0f) / 75.0f) / f))) / 2.0f;
                    HologramView.access$getForegroundGradient$p(HologramView.this).update(fCoerceIn);
                    AnimatedMovableGradientTileDrawable animatedMovableGradientTileDrawable2 = HologramView.this.movableGradientTileDrawable;
                    if (animatedMovableGradientTileDrawable2 != null) {
                        animatedMovableGradientTileDrawable2.update(Math.abs(1 - fCoerceIn));
                    }
                }
            });
        }
    }

    public final void setPattern(Drawable pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        int[] iArr = this.topColorList;
        if (iArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topColorList");
        }
        this.movableGradientTileDrawable = new AnimatedMovableGradientTileDrawable(pattern, iArr, 40, (Shader.TileMode) null, 8, (DefaultConstructorMarker) null);
        ImageView imageView = (ImageView) _$_findCachedViewById(C4584R.id.animatedImageView);
        AnimatedMovableGradientTileDrawable animatedMovableGradientTileDrawable = this.movableGradientTileDrawable;
        Intrinsics.checkNotNull(animatedMovableGradientTileDrawable);
        imageView.setImageDrawable(animatedMovableGradientTileDrawable);
    }
}
