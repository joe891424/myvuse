package com.yoti.mobile.android.core.image;

import com.facebook.imagepipeline.common.RotationOptions;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import com.yoti.mobile.android.core.yuvtools.YuvTools;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\r\u001a\u00020\u0001H\u0086\u0002J\t\u0010\u000e\u001a\u00020\u0004H\u0086\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/core/image/RotationBuffer;", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "raw", "rotationDegrees", "", "(Lcom/yoti/mobile/android/commons/image/ImageBuffer;I)V", "flipDimensions", "", "height", "getHeight", "()I", "width", "getWidth", "component1", "component2", "fillData", "", "dest", "", "lib_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class RotationBuffer implements ImageBuffer {

    /* JADX INFO: renamed from: a */
    private final boolean f6624a;

    /* JADX INFO: renamed from: b */
    private final int f6625b;

    /* JADX INFO: renamed from: c */
    private final int f6626c;

    /* JADX INFO: renamed from: d */
    private final ImageBuffer f6627d;

    /* JADX INFO: renamed from: e */
    private final int f6628e;

    public RotationBuffer(ImageBuffer raw, int i) {
        Intrinsics.checkParameterIsNotNull(raw, "raw");
        this.f6627d = raw;
        this.f6628e = i;
        boolean z = i % RotationOptions.ROTATE_180 != 0;
        this.f6624a = z;
        this.f6625b = z ? raw.getF6626c() : raw.getF6625b();
        this.f6626c = z ? raw.getF6625b() : raw.getF6626c();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ImageBuffer getF6627d() {
        return this.f6627d;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getF6628e() {
        return this.f6628e;
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    public void fillData(byte[] dest) {
        Intrinsics.checkParameterIsNotNull(dest, "dest");
        int i = this.f6628e;
        if (i == 0) {
            this.f6627d.fillData(dest);
        } else {
            YuvTools.yuvRotate(this.f6627d, dest, i);
        }
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    public byte[] getData() {
        return ImageBuffer.DefaultImpls.getData(this);
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    /* JADX INFO: renamed from: getHeight, reason: from getter */
    public int getF6625b() {
        return this.f6625b;
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    /* JADX INFO: renamed from: getWidth, reason: from getter */
    public int getF6626c() {
        return this.f6626c;
    }
}
