package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.commonui.extension.ImageViewLoadAnimationKt;
import com.yoti.mobile.android.documentcapture.p055id.databinding.YdsItemIdDocumentImageBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/DocumentImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsItemIdDocumentImageBinding;", "(Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsItemIdDocumentImageBinding;)V", "bind", "", "bitmap", "Landroid/graphics/Bitmap;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentImageViewHolder extends RecyclerView.ViewHolder {
    private final YdsItemIdDocumentImageBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentImageViewHolder(YdsItemIdDocumentImageBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void bind(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        ImageView imageView = this.binding.documentImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.documentImage");
        ImageViewLoadAnimationKt.showBitmapSoftly(imageView, bitmap);
    }
}
