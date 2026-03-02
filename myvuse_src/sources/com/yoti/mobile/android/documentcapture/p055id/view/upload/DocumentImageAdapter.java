package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ViewProps;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.p055id.databinding.YdsItemIdDocumentImageBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/DocumentImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/DocumentImageViewHolder;", "()V", "value", "", "Landroid/graphics/Bitmap;", "bitmaps", "getBitmaps", "()Ljava/util/List;", "setBitmaps", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", ViewProps.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentImageAdapter extends RecyclerView.Adapter<DocumentImageViewHolder> {
    private List<Bitmap> bitmaps = CollectionsKt.emptyList();

    public final List<Bitmap> getBitmaps() {
        return this.bitmaps;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.bitmaps.size();
    }

    public final void setBitmaps(List<Bitmap> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.bitmaps = value;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DocumentImageViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Bitmap bitmap = (Bitmap) CollectionsKt.getOrNull(this.bitmaps, position);
        if (bitmap != null) {
            holder.bind(bitmap);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DocumentImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        YdsItemIdDocumentImageBinding ydsItemIdDocumentImageBindingBind = YdsItemIdDocumentImageBinding.bind(LayoutInflater.from(parent.getContext()).inflate(C4608R.layout.yds_item_id_document_image, parent, false));
        Intrinsics.checkNotNullExpressionValue(ydsItemIdDocumentImageBindingBind, "bind(\n                  …ent, false)\n            )");
        return new DocumentImageViewHolder(ydsItemIdDocumentImageBindingBind);
    }
}
