package com.yoti.mobile.android.commonui.moreabout;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ViewProps;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.moreabout.MoreAboutViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MoreAboutAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder;", "itemList", "", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem;", "baseFragment", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "(Ljava/util/List;Lcom/yoti/mobile/android/commonui/BaseFragment;)V", "getItemCount", "", "getItemViewType", ViewProps.POSITION, "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MoreAboutAdapter extends RecyclerView.Adapter<MoreAboutViewHolder> {
    private final BaseFragment baseFragment;
    private final List<MoreAboutItem> itemList;

    /* JADX WARN: Multi-variable type inference failed */
    public MoreAboutAdapter(List<? extends MoreAboutItem> itemList, BaseFragment baseFragment) {
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Intrinsics.checkNotNullParameter(baseFragment, "baseFragment");
        this.itemList = itemList;
        this.baseFragment = baseFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.itemList.get(position).getItemType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MoreAboutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == MoreAboutItemType.APPBAR.ordinal()) {
            return new MoreAboutViewHolder.MoreAboutAppbarViewHolder(parent, this.baseFragment);
        }
        if (viewType == MoreAboutItemType.TITLE.ordinal()) {
            return new MoreAboutViewHolder.MoreAboutTitleViewHolder(parent);
        }
        if (viewType == MoreAboutItemType.DESCRIPTION.ordinal()) {
            return new MoreAboutViewHolder.MoreAboutDescViewHolder(parent);
        }
        if (viewType == MoreAboutItemType.SEPARATOR.ordinal()) {
            return new MoreAboutViewHolder.MoreAboutSeparatorViewHolder(parent);
        }
        if (viewType == MoreAboutItemType.ACCORDION.ordinal()) {
            return new MoreAboutViewHolder.MoreAboutAccordionViewHolder(parent);
        }
        return new MoreAboutViewHolder.MoreAboutYotiLogoViewHolder(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MoreAboutViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.itemList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemList.size();
    }
}
