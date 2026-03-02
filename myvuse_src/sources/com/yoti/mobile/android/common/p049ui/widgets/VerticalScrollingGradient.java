package com.yoti.mobile.android.common.p049ui.widgets;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.EllipticCurveJsonWebKey;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b%\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0003Z[\\B\u0011\b\u0016\u0012\u0006\u0010R\u001a\u00020Q¢\u0006\u0004\bS\u0010TB\u001b\b\u0016\u0012\u0006\u0010R\u001a\u00020Q\u0012\b\u0010V\u001a\u0004\u0018\u00010U¢\u0006\u0004\bS\u0010WB#\b\u0016\u0012\u0006\u0010R\u001a\u00020Q\u0012\b\u0010V\u001a\u0004\u0018\u00010U\u0012\u0006\u0010X\u001a\u00020\b¢\u0006\u0004\bS\u0010YJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u000b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0012\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u001f\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u0005J\u001b\u0010\u001d\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\u0004\b\u001d\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u0005J\r\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010\u0005J\u0015\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020 ¢\u0006\u0004\b%\u0010#J+\u0010)\u001a\u00020\u00032\b\b\u0001\u0010&\u001a\u00020\b2\b\b\u0001\u0010'\u001a\u00020\b2\b\b\u0001\u0010(\u001a\u00020\b¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\b¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0003¢\u0006\u0004\b.\u0010\u0005R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\"\u00104\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u00109\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00103R\u001e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010+\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00100R\u0016\u0010?\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00100R\u0016\u0010$\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010;R\u0016\u0010E\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u00100R\u0016\u0010H\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010GR\u0016\u0010J\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010AR\u0016\u0010L\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u00103R\u001c\u0010P\u001a\b\u0018\u00010MR\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006]"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/VerticalScrollingGradient;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "", "a", "()V", "Landroid/graphics/SurfaceTexture;", "surface", "", "width", "height", "onSurfaceTextureSizeChanged", "(Landroid/graphics/SurfaceTexture;II)V", "onSurfaceTextureUpdated", "(Landroid/graphics/SurfaceTexture;)V", "", "onSurfaceTextureDestroyed", "(Landroid/graphics/SurfaceTexture;)Z", "onSurfaceTextureAvailable", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAnimationRepeatListener", "(Lkotlin/jvm/functions/Function0;)V", "removeAnimationRepeatListener", "setHalfAnimationListener", "removeHalfAnimationListener", "stopAnimation", "", "durationMs", "setDuration", "(J)V", "loopPauseDurationMs", "setLoopPauseDuration", "startColor", "midColor", "endColor", "setGradientColors", "(III)V", "repeatMode", "setRepeatMode", "(I)V", "startAnimation", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "I", "gradientMidColor", "m", "Z", "isRunning", "()Z", "setRunning", "(Z)V", "j", "shouldStart", ContextChain.TAG_INFRA, "Lkotlin/jvm/functions/Function0;", "halfAnimationListener", "l", "d", "gradientStartColor", "c", "J", "h", "animationRepeatListener", "f", "gradientEndColor", "", "F", "gradientHeightInPx", "b", "loopDurationMs", OctetSequenceJsonWebKey.KEY_VALUE_MEMBER_NAME, "isSurfaceAvailable", "Lcom/yoti/mobile/android/common/ui/widgets/VerticalScrollingGradient$RenderingThread;", "g", "Lcom/yoti/mobile/android/common/ui/widgets/VerticalScrollingGradient$RenderingThread;", "renderingThread", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "RenderingThread", "SpeedMultiplier", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class VerticalScrollingGradient extends TextureView implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private float gradientHeightInPx;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private long loopDurationMs;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private long loopPauseDurationMs;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private int gradientStartColor;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private int gradientMidColor;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private int gradientEndColor;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private RenderingThread renderingThread;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private Function0<Unit> animationRepeatListener;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private Function0<Unit> halfAnimationListener;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private boolean shouldStart;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private boolean isSurfaceAvailable;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private int repeatMode;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private volatile boolean isRunning;

    /* JADX INFO: renamed from: n */
    private HashMap f5984n;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0007J\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\u0007R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\f8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0016\u0010\u001e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u000eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/VerticalScrollingGradient$RenderingThread;", "Ljava/lang/Thread;", "", "b", "()I", "", "a", "()V", "d", "c", "run", "stopRendering", "", "f", "F", "currentSpeed", "", "[I", "gradientColors", "I", "surfaceHeight", EllipticCurveJsonWebKey.Y_MEMBER_NAME, "", "g", "Z", "hasAnimationLooped", "h", "hasDirectionChanged", EllipticCurveJsonWebKey.X_MEMBER_NAME, RsaJsonWebKey.EXPONENT_MEMBER_NAME, "verticalSpeed", "Landroid/view/TextureView;", "j", "Landroid/view/TextureView;", "surface", "Landroid/graphics/Paint;", ContextChain.TAG_INFRA, "Landroid/graphics/Paint;", "paint", "<init>", "(Lcom/yoti/mobile/android/common/ui/widgets/VerticalScrollingGradient;Landroid/view/TextureView;)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public final class RenderingThread extends Thread {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int surfaceHeight;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final float x;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private float y;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private int[] gradientColors;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private float verticalSpeed;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private float currentSpeed;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        private boolean hasAnimationLooped;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        private boolean hasDirectionChanged;

        /* JADX INFO: renamed from: i, reason: from kotlin metadata */
        private final Paint paint;

        /* JADX INFO: renamed from: j, reason: from kotlin metadata */
        private final TextureView surface;

        /* JADX INFO: renamed from: k */
        final /* synthetic */ VerticalScrollingGradient f5995k;

        /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.VerticalScrollingGradient$RenderingThread$a */
        static final class RunnableC4478a implements Runnable {
            RunnableC4478a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                Function0 function0 = RenderingThread.this.f5995k.halfAnimationListener;
                if (function0 != null) {
                }
            }
        }

        /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.VerticalScrollingGradient$RenderingThread$b */
        static final class RunnableC4479b implements Runnable {
            RunnableC4479b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                Function0 function0 = RenderingThread.this.f5995k.animationRepeatListener;
                if (function0 != null) {
                }
            }
        }

        public RenderingThread(VerticalScrollingGradient verticalScrollingGradient, TextureView surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            this.f5995k = verticalScrollingGradient;
            this.surface = surface;
            int height = surface.getHeight();
            this.surfaceHeight = height;
            this.y = -verticalScrollingGradient.gradientHeightInPx;
            this.gradientColors = new int[]{verticalScrollingGradient.gradientStartColor, verticalScrollingGradient.gradientMidColor, verticalScrollingGradient.gradientEndColor};
            float fM4402b = ((height + verticalScrollingGradient.gradientHeightInPx) * m4402b()) / verticalScrollingGradient.loopDurationMs;
            this.verticalSpeed = fM4402b;
            this.currentSpeed = fM4402b;
            this.paint = new Paint();
        }

        /* JADX INFO: renamed from: a */
        private final void m4401a() {
            Canvas canvasLockCanvas = this.surface.lockCanvas();
            if (canvasLockCanvas == null) {
                stopRendering();
                return;
            }
            try {
                float f = this.x;
                float f2 = this.y;
                this.paint.setShader(new LinearGradient(f, f2, f, f2 + this.f5995k.gradientHeightInPx, this.gradientColors, (float[]) null, Shader.TileMode.MIRROR));
                canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvasLockCanvas.drawRect(this.x, this.y, canvasLockCanvas.getWidth(), this.f5995k.gradientHeightInPx + this.y, this.paint);
            } finally {
                this.surface.unlockCanvasAndPost(canvasLockCanvas);
            }
        }

        /* JADX INFO: renamed from: b */
        private final int m4402b() {
            return (this.f5995k.repeatMode == 2 ? SpeedMultiplier.DOUBLE : SpeedMultiplier.NORMAL).getValue();
        }

        /* JADX INFO: renamed from: c */
        private final void m4403c() {
            Context context = this.f5995k.getContext();
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
            ((Activity) context).runOnUiThread(new RunnableC4478a());
        }

        /* JADX INFO: renamed from: d */
        private final void m4404d() {
            Context context = this.f5995k.getContext();
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
            ((Activity) context).runOnUiThread(new RunnableC4479b());
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x006c A[Catch: InterruptedException -> 0x0004, TryCatch #0 {InterruptedException -> 0x0004, blocks: (B:8:0x0015, B:10:0x002d, B:12:0x0039, B:22:0x0068, B:24:0x006c, B:26:0x0078, B:13:0x0046, B:14:0x0049, B:21:0x0065, B:15:0x004c, B:17:0x0057, B:19:0x005d, B:20:0x0062), top: B:31:0x0015 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0089 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r10 = this;
                long r0 = java.lang.System.currentTimeMillis()
            L4:
                com.yoti.mobile.android.common.ui.widgets.VerticalScrollingGradient r2 = r10.f5995k
                boolean r2 = r2.getIsRunning()
                if (r2 == 0) goto L8c
                boolean r2 = r10.isInterrupted()
                if (r2 != 0) goto L8c
                r10.m4401a()
                long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.InterruptedException -> L4
                long r4 = r2 - r0
                float r6 = r10.y     // Catch: java.lang.InterruptedException -> L4
                float r7 = r10.currentSpeed     // Catch: java.lang.InterruptedException -> L4
                float r4 = (float) r4     // Catch: java.lang.InterruptedException -> L4
                float r7 = r7 * r4
                float r6 = r6 + r7
                r10.y = r6     // Catch: java.lang.InterruptedException -> L4
                int r4 = r10.surfaceHeight     // Catch: java.lang.InterruptedException -> L4
                float r4 = (float) r4     // Catch: java.lang.InterruptedException -> L4
                int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                r5 = 0
                r7 = 1
                if (r4 < 0) goto L4c
                r10.hasAnimationLooped = r5     // Catch: java.lang.InterruptedException -> L4
                r10.hasDirectionChanged = r7     // Catch: java.lang.InterruptedException -> L4
                com.yoti.mobile.android.common.ui.widgets.VerticalScrollingGradient r4 = r10.f5995k     // Catch: java.lang.InterruptedException -> L4
                int r4 = com.yoti.mobile.android.common.p049ui.widgets.VerticalScrollingGradient.access$getRepeatMode$p(r4)     // Catch: java.lang.InterruptedException -> L4
                if (r4 != r7) goto L46
                com.yoti.mobile.android.common.ui.widgets.VerticalScrollingGradient r4 = r10.f5995k     // Catch: java.lang.InterruptedException -> L4
                float r4 = com.yoti.mobile.android.common.p049ui.widgets.VerticalScrollingGradient.access$getGradientHeightInPx$p(r4)     // Catch: java.lang.InterruptedException -> L4
                float r4 = -r4
                r10.y = r4     // Catch: java.lang.InterruptedException -> L4
                r10.m4404d()     // Catch: java.lang.InterruptedException -> L4
                goto L68
            L46:
                float r4 = r10.verticalSpeed     // Catch: java.lang.InterruptedException -> L4
                float r4 = -r4
            L49:
                r10.currentSpeed = r4     // Catch: java.lang.InterruptedException -> L4
                goto L65
            L4c:
                com.yoti.mobile.android.common.ui.widgets.VerticalScrollingGradient r4 = r10.f5995k     // Catch: java.lang.InterruptedException -> L4
                float r4 = com.yoti.mobile.android.common.p049ui.widgets.VerticalScrollingGradient.access$getGradientHeightInPx$p(r4)     // Catch: java.lang.InterruptedException -> L4
                float r4 = -r4
                int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r4 > 0) goto L68
                r10.hasDirectionChanged = r7     // Catch: java.lang.InterruptedException -> L4
                boolean r4 = r10.hasAnimationLooped     // Catch: java.lang.InterruptedException -> L4
                if (r4 != 0) goto L62
                r10.hasAnimationLooped = r7     // Catch: java.lang.InterruptedException -> L4
                r10.m4404d()     // Catch: java.lang.InterruptedException -> L4
            L62:
                float r4 = r10.verticalSpeed     // Catch: java.lang.InterruptedException -> L4
                goto L49
            L65:
                r10.m4403c()     // Catch: java.lang.InterruptedException -> L4
            L68:
                boolean r4 = r10.hasDirectionChanged     // Catch: java.lang.InterruptedException -> L4
                if (r4 == 0) goto L89
                com.yoti.mobile.android.common.ui.widgets.VerticalScrollingGradient r4 = r10.f5995k     // Catch: java.lang.InterruptedException -> L4
                long r6 = com.yoti.mobile.android.common.p049ui.widgets.VerticalScrollingGradient.access$getLoopPauseDurationMs$p(r4)     // Catch: java.lang.InterruptedException -> L4
                r8 = 0
                int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r4 <= 0) goto L89
                r10.hasDirectionChanged = r5     // Catch: java.lang.InterruptedException -> L4
                com.yoti.mobile.android.common.ui.widgets.VerticalScrollingGradient r2 = r10.f5995k     // Catch: java.lang.InterruptedException -> L4
                long r2 = com.yoti.mobile.android.common.p049ui.widgets.VerticalScrollingGradient.access$getLoopPauseDurationMs$p(r2)     // Catch: java.lang.InterruptedException -> L4
                java.lang.Thread.sleep(r2)     // Catch: java.lang.InterruptedException -> L4
                long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.InterruptedException -> L4
                goto L4
            L89:
                r0 = r2
                goto L4
            L8c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.common.ui.widgets.VerticalScrollingGradient.RenderingThread.run():void");
        }

        public final void stopRendering() {
            interrupt();
            this.f5995k.setRunning(false);
        }
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/VerticalScrollingGradient$SpeedMultiplier;", "", "", "a", "I", "getValue", "()I", "value", "<init>", "(Ljava/lang/String;II)V", "NORMAL", "DOUBLE", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public enum SpeedMultiplier {
        NORMAL(1),
        DOUBLE(2);


        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int value;

        SpeedMultiplier(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerticalScrollingGradient(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerticalScrollingGradient(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalScrollingGradient(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.repeatMode = 2;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C4584R.styleable.VerticalScrollingGradient, 0, 0);
        this.gradientHeightInPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4584R.styleable.VerticalScrollingGradient_verticalScrollingGradientHeightInDp, 500);
        this.loopDurationMs = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.f6580xe979e47d, (int) 1000);
        this.loopPauseDurationMs = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.f6581x222704ad, (int) 0);
        this.gradientStartColor = typedArrayObtainStyledAttributes.getColor(C4584R.styleable.VerticalScrollingGradient_verticalScrollingGradientStartColor, 0);
        this.gradientMidColor = typedArrayObtainStyledAttributes.getColor(C4584R.styleable.VerticalScrollingGradient_verticalScrollingGradientMidColor, SupportMenu.CATEGORY_MASK);
        this.gradientEndColor = typedArrayObtainStyledAttributes.getColor(C4584R.styleable.VerticalScrollingGradient_verticalScrollingGradientEndColor, 0);
        this.repeatMode = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.VerticalScrollingGradient_verticalScrollingGradientRepeatMode, 2);
        typedArrayObtainStyledAttributes.recycle();
        setOpaque(false);
        setSurfaceTextureListener(this);
    }

    /* JADX INFO: renamed from: a */
    private final void m4400a() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        RenderingThread renderingThread = new RenderingThread(this, this);
        renderingThread.start();
        this.renderingThread = renderingThread;
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f5984n;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5984n == null) {
            this.f5984n = new HashMap();
        }
        View view = (View) this.f5984n.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5984n.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    /* JADX INFO: renamed from: isRunning, reason: from getter */
    public final boolean getIsRunning() {
        return this.isRunning;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        this.isSurfaceAvailable = true;
        if (this.shouldStart) {
            m4400a();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        stopAnimation();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }

    @Override // android.view.TextureView, android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility != 0) {
            stopAnimation();
        } else {
            startAnimation();
        }
    }

    public final void removeAnimationRepeatListener() {
        this.animationRepeatListener = null;
    }

    public final void removeHalfAnimationListener() {
        this.halfAnimationListener = null;
    }

    public final void setAnimationRepeatListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.animationRepeatListener = listener;
    }

    public final void setDuration(long durationMs) {
        this.loopDurationMs = durationMs;
    }

    public final void setGradientColors(int startColor, int midColor, int endColor) {
        this.gradientStartColor = startColor;
        this.gradientMidColor = midColor;
        this.gradientEndColor = endColor;
    }

    public final void setHalfAnimationListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.halfAnimationListener = listener;
    }

    public final void setLoopPauseDuration(long loopPauseDurationMs) {
        this.loopPauseDurationMs = loopPauseDurationMs;
    }

    public final void setRepeatMode(int repeatMode) {
        this.repeatMode = repeatMode;
    }

    public final void setRunning(boolean z) {
        this.isRunning = z;
    }

    public final void startAnimation() {
        this.shouldStart = true;
        if (this.isSurfaceAvailable) {
            m4400a();
        }
    }

    public final void stopAnimation() {
        this.shouldStart = false;
        removeAnimationRepeatListener();
        removeHalfAnimationListener();
        RenderingThread renderingThread = this.renderingThread;
        if (renderingThread != null) {
            renderingThread.stopRendering();
        }
    }
}
