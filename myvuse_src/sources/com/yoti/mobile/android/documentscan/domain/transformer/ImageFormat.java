package com.yoti.mobile.android.documentscan.domain.transformer;

import android.content.Context;
import com.yoti.mobile.android.documentscan.domain.C4724m;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/domain/transformer/ImageFormat;", "", "fileExtension", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getFileExtension", "()Ljava/lang/String;", "getScanResultToImageTransformer", "Lcom/yoti/mobile/android/documentscan/domain/transformer/IScanResultToImageTransformer;", "context", "Landroid/content/Context;", "frameStore", "Lcom/yoti/mobile/android/documentscan/domain/PreviewFrameStore;", "getScanResultToImageTransformer$documentscan_release", "JPEG", "YUV", "Companion", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public enum ImageFormat {
    JPEG(".jpeg"),
    YUV(".yuv");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: b */
    private final String f6937b;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.transformer.ImageFormat$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: a */
        public final ImageFormat m4840a() {
            return ImageFormat.YUV;
        }
    }

    ImageFormat(String str) {
        this.f6937b = str;
    }

    /* JADX INFO: renamed from: getFileExtension, reason: from getter */
    public final String getF6937b() {
        return this.f6937b;
    }

    public final InterfaceC4730a getScanResultToImageTransformer$documentscan_release(Context context, C4724m frameStore) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(frameStore, "frameStore");
        int i = C4731b.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return new C4733d(context, frameStore, null, 4, null);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return new C4734e(context, frameStore, null, 4, null);
    }
}
