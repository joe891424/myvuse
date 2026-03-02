package com.yoti.mobile.android.documentcapture.sup.view.review;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.collection.LruCache;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ViewProps;
import com.github.chrisbanes.photoview.PhotoView;
import com.yoti.mobile.android.common.p049ui.widgets.YotiBadge;
import com.yoti.mobile.android.commonui.extension.ImageViewLoadAnimationKt;
import com.yoti.mobile.android.documentcapture.sup.databinding.YdsItemDocumentImageBinding;
import com.yoti.mobile.android.documentcapture.sup.view.review.DocumentImageAdapter;
import com.yoti.mobile.android.documentcapture.sup.view.review.transformer.ICaptureToBitmapTransformer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001d\u001eB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u0004H\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J(\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentImageAdapter$ImagePreviewViewHolder;", "totalPages", "", "previewImageSize", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer$TransformOptions$Size;", "viewModel", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel;", "(ILcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer$TransformOptions$Size;Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel;)V", "documentImageCache", "Landroidx/collection/LruCache;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentImageAdapter$DocumentImage;", "getItemCount", "onBindViewHolder", "", "holder", ViewProps.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "showPage", "bitmap", "Landroid/graphics/Bitmap;", "pageNumberIndicator", "", "rotationEnabled", "", "DocumentImage", "ImagePreviewViewHolder", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentImageAdapter extends RecyclerView.Adapter<ImagePreviewViewHolder> {
    private final LruCache<Integer, DocumentImage> documentImageCache;
    private final ICaptureToBitmapTransformer.TransformOptions.Size previewImageSize;
    private final int totalPages;
    private final DocumentReviewViewModel viewModel;

    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentImageAdapter$DocumentImage;", "", "bitmap", "Landroid/graphics/Bitmap;", "pageNumberIndicator", "", "rotationEnabled", "", "(Landroid/graphics/Bitmap;Ljava/lang/String;Z)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getPageNumberIndicator", "()Ljava/lang/String;", "getRotationEnabled", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class DocumentImage {
        private final Bitmap bitmap;
        private final String pageNumberIndicator;
        private final boolean rotationEnabled;

        public DocumentImage(Bitmap bitmap, String str, boolean z) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            this.bitmap = bitmap;
            this.pageNumberIndicator = str;
            this.rotationEnabled = z;
        }

        public static /* synthetic */ DocumentImage copy$default(DocumentImage documentImage, Bitmap bitmap, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                bitmap = documentImage.bitmap;
            }
            if ((i & 2) != 0) {
                str = documentImage.pageNumberIndicator;
            }
            if ((i & 4) != 0) {
                z = documentImage.rotationEnabled;
            }
            return documentImage.copy(bitmap, str, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPageNumberIndicator() {
            return this.pageNumberIndicator;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getRotationEnabled() {
            return this.rotationEnabled;
        }

        public final DocumentImage copy(Bitmap bitmap, String pageNumberIndicator, boolean rotationEnabled) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            return new DocumentImage(bitmap, pageNumberIndicator, rotationEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DocumentImage)) {
                return false;
            }
            DocumentImage documentImage = (DocumentImage) other;
            return Intrinsics.areEqual(this.bitmap, documentImage.bitmap) && Intrinsics.areEqual(this.pageNumberIndicator, documentImage.pageNumberIndicator) && this.rotationEnabled == documentImage.rotationEnabled;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final String getPageNumberIndicator() {
            return this.pageNumberIndicator;
        }

        public final boolean getRotationEnabled() {
            return this.rotationEnabled;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            int iHashCode = this.bitmap.hashCode() * 31;
            String str = this.pageNumberIndicator;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            boolean z = this.rotationEnabled;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public String toString() {
            return "DocumentImage(bitmap=" + this.bitmap + ", pageNumberIndicator=" + this.pageNumberIndicator + ", rotationEnabled=" + this.rotationEnabled + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentImageAdapter$ImagePreviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yoti/mobile/android/documentcapture/sup/databinding/YdsItemDocumentImageBinding;", "(Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentImageAdapter;Lcom/yoti/mobile/android/documentcapture/sup/databinding/YdsItemDocumentImageBinding;)V", "bind", "", "documentImage", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentImageAdapter$DocumentImage;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public final class ImagePreviewViewHolder extends RecyclerView.ViewHolder {
        private final YdsItemDocumentImageBinding binding;
        final /* synthetic */ DocumentImageAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImagePreviewViewHolder(final DocumentImageAdapter documentImageAdapter, YdsItemDocumentImageBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = documentImageAdapter;
            this.binding = binding;
            binding.buttonRotate.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.sup.view.review.DocumentImageAdapter$ImagePreviewViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocumentImageAdapter.ImagePreviewViewHolder.m6829_init_$lambda1(this.f$0, documentImageAdapter, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: _init_$lambda-1, reason: not valid java name */
        public static final void m6829_init_$lambda1(ImagePreviewViewHolder this$0, DocumentImageAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int adapterPosition = this$0.getAdapterPosition();
            DocumentImage documentImage = (DocumentImage) this$1.documentImageCache.get(Integer.valueOf(adapterPosition));
            if (documentImage != null) {
                this$1.viewModel.rotateImage(documentImage.getBitmap(), adapterPosition);
            }
        }

        public final void bind(DocumentImage documentImage) {
            Unit unit;
            Intrinsics.checkNotNullParameter(documentImage, "documentImage");
            YdsItemDocumentImageBinding ydsItemDocumentImageBinding = this.binding;
            ydsItemDocumentImageBinding.buttonRotate.setEnabled(documentImage.getRotationEnabled());
            YotiBadge yotiBadge = ydsItemDocumentImageBinding.pageIndicator;
            String pageNumberIndicator = documentImage.getPageNumberIndicator();
            if (pageNumberIndicator != null) {
                yotiBadge.setText(pageNumberIndicator);
                Intrinsics.checkNotNullExpressionValue(yotiBadge, "");
                yotiBadge.setVisibility(0);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                Intrinsics.checkNotNullExpressionValue(yotiBadge, "");
                yotiBadge.setVisibility(8);
            }
            PhotoView photoView = ydsItemDocumentImageBinding.ivPreview;
            photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            photoView.setImageDrawable(null);
            photoView.setAlpha(0.0f);
            Intrinsics.checkNotNullExpressionValue(photoView, "");
            ImageViewLoadAnimationKt.showBitmapSoftly(photoView, documentImage.getBitmap());
        }
    }

    public DocumentImageAdapter(int i, ICaptureToBitmapTransformer.TransformOptions.Size previewImageSize, DocumentReviewViewModel viewModel) {
        Intrinsics.checkNotNullParameter(previewImageSize, "previewImageSize");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.totalPages = i;
        this.previewImageSize = previewImageSize;
        this.viewModel = viewModel;
        this.documentImageCache = new LruCache<>(5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount, reason: from getter */
    public int getTotalPages() {
        return this.totalPages;
    }

    public final void showPage(int position, Bitmap bitmap, String pageNumberIndicator, boolean rotationEnabled) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.documentImageCache.put(Integer.valueOf(position), new DocumentImage(bitmap, pageNumberIndicator, rotationEnabled));
        notifyItemChanged(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ImagePreviewViewHolder holder, int position) {
        Unit unit;
        Intrinsics.checkNotNullParameter(holder, "holder");
        DocumentImage documentImage = this.documentImageCache.get(Integer.valueOf(position));
        if (documentImage != null) {
            holder.bind(documentImage);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.viewModel.loadImage(position, this.previewImageSize);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ImagePreviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        YdsItemDocumentImageBinding ydsItemDocumentImageBindingInflate = YdsItemDocumentImageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(ydsItemDocumentImageBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ImagePreviewViewHolder(this, ydsItemDocumentImageBindingInflate);
    }
}
