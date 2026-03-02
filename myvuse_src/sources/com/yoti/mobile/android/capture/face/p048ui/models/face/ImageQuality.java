package com.yoti.mobile.android.capture.face.p048ui.models.face;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ImageQuality.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/ImageQuality;", "", "quality", "", "(Ljava/lang/String;II)V", "getQuality", "()I", "HIGH", "MEDIUM", "LOW", "Companion", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
public enum ImageQuality {
    HIGH(100),
    MEDIUM(96),
    LOW(90);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private static final ImageQuality f8375default;
    private final int quality;

    ImageQuality(int i) {
        this.quality = i;
    }

    public final int getQuality() {
        return this.quality;
    }

    static {
        ImageQuality imageQuality = MEDIUM;
        INSTANCE = new Companion(null);
        f8375default = imageQuality;
    }

    /* JADX INFO: compiled from: ImageQuality.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/ImageQuality$Companion;", "", "()V", Constants.COLLATION_DEFAULT, "Lcom/yoti/mobile/android/capture/face/ui/models/face/ImageQuality;", "getDefault", "()Lcom/yoti/mobile/android/capture/face/ui/models/face/ImageQuality;", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImageQuality getDefault() {
            return ImageQuality.f8375default;
        }
    }
}
