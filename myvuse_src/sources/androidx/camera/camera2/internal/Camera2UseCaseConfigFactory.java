package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.util.Size;
import android.view.WindowManager;
import androidx.camera.camera2.internal.compat.workaround.PreviewPixelHDRnet;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2UseCaseConfigFactory implements UseCaseConfigFactory {
    private static final Size MAX_PREVIEW_SIZE = new Size(1920, 1080);
    final WindowManager mWindowManager;

    public Camera2UseCaseConfigFactory(Context context) {
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    @Override // androidx.camera.core.impl.UseCaseConfigFactory
    public Config getConfig(UseCaseConfigFactory.CaptureType captureType) {
        MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
        SessionConfig.Builder builder = new SessionConfig.Builder();
        builder.setTemplateType(1);
        if (captureType == UseCaseConfigFactory.CaptureType.PREVIEW) {
            PreviewPixelHDRnet.setHDRnet(builder);
        }
        mutableOptionsBundleCreate.insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, builder.build());
        mutableOptionsBundleCreate.insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, Camera2SessionOptionUnpacker.INSTANCE);
        CaptureConfig.Builder builder2 = new CaptureConfig.Builder();
        int i = C03931.f1706x65b8d150[captureType.ordinal()];
        if (i == 1) {
            builder2.setTemplateType(2);
        } else if (i == 2 || i == 3 || i == 4) {
            builder2.setTemplateType(1);
        }
        mutableOptionsBundleCreate.insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, builder2.build());
        mutableOptionsBundleCreate.insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, captureType == UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE ? ImageCaptureOptionUnpacker.INSTANCE : Camera2CaptureOptionUnpacker.INSTANCE);
        if (captureType == UseCaseConfigFactory.CaptureType.PREVIEW) {
            mutableOptionsBundleCreate.insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, getPreviewSize());
        }
        mutableOptionsBundleCreate.insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(this.mWindowManager.getDefaultDisplay().getRotation()));
        return OptionsBundle.from(mutableOptionsBundleCreate);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.Camera2UseCaseConfigFactory$1 */
    static /* synthetic */ class C03931 {

        /* JADX INFO: renamed from: $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType */
        static final /* synthetic */ int[] f1706x65b8d150;

        static {
            int[] iArr = new int[UseCaseConfigFactory.CaptureType.values().length];
            f1706x65b8d150 = iArr;
            try {
                iArr[UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1706x65b8d150[UseCaseConfigFactory.CaptureType.PREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1706x65b8d150[UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1706x65b8d150[UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private Size getPreviewSize() {
        Size size;
        Point point = new Point();
        this.mWindowManager.getDefaultDisplay().getRealSize(point);
        if (point.x > point.y) {
            size = new Size(point.x, point.y);
        } else {
            size = new Size(point.y, point.x);
        }
        int width = size.getWidth() * size.getHeight();
        Size size2 = MAX_PREVIEW_SIZE;
        return width > size2.getWidth() * size2.getHeight() ? size2 : size;
    }
}
