package p000a.p001a.p002a.p003a.p014b.adapter;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000a.p001a.p002a.p003a.p014b.DataModels.VendorItem;

/* JADX INFO: renamed from: a.a.a.a.b.f.n, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/adapter/OTVendorDiffCallBack;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class OTVendorDiffCallBack extends DiffUtil.ItemCallback<VendorItem> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areContentsTheSame(VendorItem vendorItem, VendorItem vendorItem2) {
        VendorItem oldItem = vendorItem;
        VendorItem newItem = vendorItem2;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem.f199b, newItem.f199b) && oldItem.f200c == newItem.f200c;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areItemsTheSame(VendorItem vendorItem, VendorItem vendorItem2) {
        VendorItem oldItem = vendorItem;
        VendorItem newItem = vendorItem2;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem.f198a, newItem.f198a);
    }
}
