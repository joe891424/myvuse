package com.yoti.mobile.android.documentcapture.sup.view.review.transformer;

import android.graphics.Bitmap;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001:\u0001\nJ\b\u0010\u0002\u001a\u00020\u0003H&J)\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer;", "Ljava/lang/AutoCloseable;", "getPageCount", "", ViewProps.TRANSFORM, "Landroid/graphics/Bitmap;", "pageNumber", "transformOptions", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer$TransformOptions;", "(ILcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer$TransformOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TransformOptions", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ICaptureToBitmapTransformer extends AutoCloseable {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object transform$default(ICaptureToBitmapTransformer iCaptureToBitmapTransformer, int i, TransformOptions transformOptions, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transform");
            }
            if ((i2 & 1) != 0) {
                i = 0;
            }
            if ((i2 & 2) != 0) {
                transformOptions = null;
            }
            return iCaptureToBitmapTransformer.transform(i, transformOptions, continuation);
        }
    }

    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer$TransformOptions;", "", "size", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer$TransformOptions$Size;", "applyCenterCrop", "", "(Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer$TransformOptions$Size;Z)V", "getApplyCenterCrop", "()Z", "getSize", "()Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer$TransformOptions$Size;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "Size", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class TransformOptions {
        private final boolean applyCenterCrop;
        private final Size size;

        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer$TransformOptions$Size;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class Size {
            private final int height;
            private final int width;

            public Size(int i, int i2) {
                this.width = i;
                this.height = i2;
            }

            public static /* synthetic */ Size copy$default(Size size, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = size.width;
                }
                if ((i3 & 2) != 0) {
                    i2 = size.height;
                }
                return size.copy(i, i2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getWidth() {
                return this.width;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getHeight() {
                return this.height;
            }

            public final Size copy(int width, int height) {
                return new Size(width, height);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Size)) {
                    return false;
                }
                Size size = (Size) other;
                return this.width == size.width && this.height == size.height;
            }

            public final int getHeight() {
                return this.height;
            }

            public final int getWidth() {
                return this.width;
            }

            public int hashCode() {
                return (Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height);
            }

            public String toString() {
                return "Size(width=" + this.width + ", height=" + this.height + ')';
            }
        }

        public TransformOptions(Size size, boolean z) {
            Intrinsics.checkNotNullParameter(size, "size");
            this.size = size;
            this.applyCenterCrop = z;
        }

        public static /* synthetic */ TransformOptions copy$default(TransformOptions transformOptions, Size size, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                size = transformOptions.size;
            }
            if ((i & 2) != 0) {
                z = transformOptions.applyCenterCrop;
            }
            return transformOptions.copy(size, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Size getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getApplyCenterCrop() {
            return this.applyCenterCrop;
        }

        public final TransformOptions copy(Size size, boolean applyCenterCrop) {
            Intrinsics.checkNotNullParameter(size, "size");
            return new TransformOptions(size, applyCenterCrop);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TransformOptions)) {
                return false;
            }
            TransformOptions transformOptions = (TransformOptions) other;
            return Intrinsics.areEqual(this.size, transformOptions.size) && this.applyCenterCrop == transformOptions.applyCenterCrop;
        }

        public final boolean getApplyCenterCrop() {
            return this.applyCenterCrop;
        }

        public final Size getSize() {
            return this.size;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            int iHashCode = this.size.hashCode() * 31;
            boolean z = this.applyCenterCrop;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            return "TransformOptions(size=" + this.size + ", applyCenterCrop=" + this.applyCenterCrop + ')';
        }

        public /* synthetic */ TransformOptions(Size size, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(size, (i & 2) != 0 ? false : z);
        }
    }

    int getPageCount();

    Object transform(int i, TransformOptions transformOptions, Continuation<? super Bitmap> continuation);
}
