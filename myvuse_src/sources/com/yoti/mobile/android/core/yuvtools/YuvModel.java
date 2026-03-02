package com.yoti.mobile.android.core.yuvtools;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001e"}, m5598d2 = {"Lcom/yoti/mobile/android/core/yuvtools/YuvModel;", "", "header", "", "gzipY", "", "gzipX", "height", "", "width", "(Ljava/lang/String;[B[BII)V", "getGzipX", "()[B", "getGzipY", "getHeader", "()Ljava/lang/String;", "getHeight", "()I", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "lib_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class YuvModel {

    /* JADX INFO: renamed from: a */
    private final String f6629a;

    /* JADX INFO: renamed from: b */
    private final byte[] f6630b;

    /* JADX INFO: renamed from: c */
    private final byte[] f6631c;

    /* JADX INFO: renamed from: d */
    private final int f6632d;

    /* JADX INFO: renamed from: e */
    private final int f6633e;

    public YuvModel(String header, byte[] gzipY, byte[] gzipX, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(header, "header");
        Intrinsics.checkParameterIsNotNull(gzipY, "gzipY");
        Intrinsics.checkParameterIsNotNull(gzipX, "gzipX");
        this.f6629a = header;
        this.f6630b = gzipY;
        this.f6631c = gzipX;
        this.f6632d = i;
        this.f6633e = i2;
    }

    public static /* synthetic */ YuvModel copy$default(YuvModel yuvModel, String str, byte[] bArr, byte[] bArr2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = yuvModel.f6629a;
        }
        if ((i3 & 2) != 0) {
            bArr = yuvModel.f6630b;
        }
        byte[] bArr3 = bArr;
        if ((i3 & 4) != 0) {
            bArr2 = yuvModel.f6631c;
        }
        byte[] bArr4 = bArr2;
        if ((i3 & 8) != 0) {
            i = yuvModel.f6632d;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = yuvModel.f6633e;
        }
        return yuvModel.copy(str, bArr3, bArr4, i4, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getF6629a() {
        return this.f6629a;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final byte[] getF6630b() {
        return this.f6630b;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final byte[] getF6631c() {
        return this.f6631c;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getF6632d() {
        return this.f6632d;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getF6633e() {
        return this.f6633e;
    }

    public final YuvModel copy(String header, byte[] gzipY, byte[] gzipX, int height, int width) {
        Intrinsics.checkParameterIsNotNull(header, "header");
        Intrinsics.checkParameterIsNotNull(gzipY, "gzipY");
        Intrinsics.checkParameterIsNotNull(gzipX, "gzipX");
        return new YuvModel(header, gzipY, gzipX, height, width);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YuvModel)) {
            return false;
        }
        YuvModel yuvModel = (YuvModel) other;
        return Intrinsics.areEqual(this.f6629a, yuvModel.f6629a) && Intrinsics.areEqual(this.f6630b, yuvModel.f6630b) && Intrinsics.areEqual(this.f6631c, yuvModel.f6631c) && this.f6632d == yuvModel.f6632d && this.f6633e == yuvModel.f6633e;
    }

    public final byte[] getGzipX() {
        return this.f6631c;
    }

    public final byte[] getGzipY() {
        return this.f6630b;
    }

    public final String getHeader() {
        return this.f6629a;
    }

    public final int getHeight() {
        return this.f6632d;
    }

    public final int getWidth() {
        return this.f6633e;
    }

    public int hashCode() {
        String str = this.f6629a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        byte[] bArr = this.f6630b;
        int iHashCode2 = (iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        byte[] bArr2 = this.f6631c;
        return ((((iHashCode2 + (bArr2 != null ? Arrays.hashCode(bArr2) : 0)) * 31) + this.f6632d) * 31) + this.f6633e;
    }

    public String toString() {
        return "YuvModel(header=" + this.f6629a + ", gzipY=" + Arrays.toString(this.f6630b) + ", gzipX=" + Arrays.toString(this.f6631c) + ", height=" + this.f6632d + ", width=" + this.f6633e + ")";
    }
}
