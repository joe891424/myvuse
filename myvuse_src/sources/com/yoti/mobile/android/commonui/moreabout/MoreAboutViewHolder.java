package com.yoti.mobile.android.commonui.moreabout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.common.p049ui.widgets.CommonYotiAppBar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAccordion;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.C4590R;
import com.yoti.mobile.android.commonui.moreabout.MoreAboutItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;

/* JADX INFO: compiled from: MoreAboutViewHolder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0006\u0012\u0013\u0014\u0015\u0016\u0017B\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0001\u0006\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "parent", "Landroid/view/ViewGroup;", "layout", "", "(Landroid/view/ViewGroup;I)V", "containerView", "Landroid/view/View;", "getContainerView", "()Landroid/view/View;", "getParent", "()Landroid/view/ViewGroup;", "bind", "", "item", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem;", "MoreAboutAccordionViewHolder", "MoreAboutAppbarViewHolder", "MoreAboutDescViewHolder", "MoreAboutSeparatorViewHolder", "MoreAboutTitleViewHolder", "MoreAboutYotiLogoViewHolder", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder$MoreAboutAppbarViewHolder;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder$MoreAboutTitleViewHolder;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder$MoreAboutDescViewHolder;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder$MoreAboutSeparatorViewHolder;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder$MoreAboutAccordionViewHolder;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder$MoreAboutYotiLogoViewHolder;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class MoreAboutViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    private final View containerView;
    private final ViewGroup parent;

    public /* synthetic */ MoreAboutViewHolder(ViewGroup viewGroup, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, i);
    }

    public abstract void bind(MoreAboutItem item);

    public final ViewGroup getParent() {
        return this.parent;
    }

    private MoreAboutViewHolder(ViewGroup viewGroup, int i) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false));
        this.parent = viewGroup;
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        this.containerView = itemView;
    }

    @Override // kotlinx.android.extensions.LayoutContainer
    public View getContainerView() {
        return this.containerView;
    }

    /* JADX INFO: compiled from: MoreAboutViewHolder.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder$MoreAboutAppbarViewHolder;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder;", "parent", "Landroid/view/ViewGroup;", "baseFragment", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "(Landroid/view/ViewGroup;Lcom/yoti/mobile/android/commonui/BaseFragment;)V", "bind", "", "item", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class MoreAboutAppbarViewHolder extends MoreAboutViewHolder {
        private final BaseFragment baseFragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MoreAboutAppbarViewHolder(ViewGroup parent, BaseFragment baseFragment) {
            super(parent, C4590R.layout.yds_item_more_about_appbar, null);
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(baseFragment, "baseFragment");
            this.baseFragment = baseFragment;
        }

        @Override // com.yoti.mobile.android.commonui.moreabout.MoreAboutViewHolder
        public void bind(MoreAboutItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            BaseFragment baseFragment = this.baseFragment;
            View viewFindViewById = this.itemView.findViewById(C4590R.id.appBar);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.id.appBar)");
            BaseFragment.configureAppBar$default(baseFragment, (CommonYotiAppBar) viewFindViewById, null, false, 0, 0, 0, 62, null);
        }
    }

    /* JADX INFO: compiled from: MoreAboutViewHolder.kt */
    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder$MoreAboutTitleViewHolder;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bind", "", "item", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class MoreAboutTitleViewHolder extends MoreAboutViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MoreAboutTitleViewHolder(ViewGroup parent) {
            super(parent, C4590R.layout.yds_item_more_about_title, null);
            Intrinsics.checkNotNullParameter(parent, "parent");
        }

        @Override // com.yoti.mobile.android.commonui.moreabout.MoreAboutViewHolder
        public void bind(MoreAboutItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            ((TextView) this.itemView.findViewById(C4590R.id.title)).setText(((MoreAboutItem.MoreAboutTitleItem) item).getResId());
        }
    }

    /* JADX INFO: compiled from: MoreAboutViewHolder.kt */
    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder$MoreAboutDescViewHolder;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bind", "", "item", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class MoreAboutDescViewHolder extends MoreAboutViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MoreAboutDescViewHolder(ViewGroup parent) {
            super(parent, C4590R.layout.yds_item_more_about_desc, null);
            Intrinsics.checkNotNullParameter(parent, "parent");
        }

        @Override // com.yoti.mobile.android.commonui.moreabout.MoreAboutViewHolder
        public void bind(MoreAboutItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            ((TextView) this.itemView.findViewById(C4590R.id.description)).setText(((MoreAboutItem.MoreAboutDescItem) item).getResId());
        }
    }

    /* JADX INFO: compiled from: MoreAboutViewHolder.kt */
    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder$MoreAboutSeparatorViewHolder;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bind", "", "item", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class MoreAboutSeparatorViewHolder extends MoreAboutViewHolder {
        @Override // com.yoti.mobile.android.commonui.moreabout.MoreAboutViewHolder
        public void bind(MoreAboutItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MoreAboutSeparatorViewHolder(ViewGroup parent) {
            super(parent, C4590R.layout.yds_item_more_about_separator, null);
            Intrinsics.checkNotNullParameter(parent, "parent");
        }
    }

    /* JADX INFO: compiled from: MoreAboutViewHolder.kt */
    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder$MoreAboutAccordionViewHolder;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bind", "", "item", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class MoreAboutAccordionViewHolder extends MoreAboutViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MoreAboutAccordionViewHolder(ViewGroup parent) {
            super(parent, C4590R.layout.yds_item_more_about_accordion, null);
            Intrinsics.checkNotNullParameter(parent, "parent");
        }

        @Override // com.yoti.mobile.android.commonui.moreabout.MoreAboutViewHolder
        public void bind(MoreAboutItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            MoreAboutItem.MoreAboutAccordionItem moreAboutAccordionItem = (MoreAboutItem.MoreAboutAccordionItem) item;
            YotiAccordion yotiAccordion = (YotiAccordion) this.itemView.findViewById(C4590R.id.accordion);
            yotiAccordion.setTitle(moreAboutAccordionItem.getTitleResId());
            yotiAccordion.setDescription(moreAboutAccordionItem.getMessageResId());
        }
    }

    /* JADX INFO: compiled from: MoreAboutViewHolder.kt */
    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder$MoreAboutYotiLogoViewHolder;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bind", "", "item", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class MoreAboutYotiLogoViewHolder extends MoreAboutViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MoreAboutYotiLogoViewHolder(ViewGroup parent) {
            super(parent, C4590R.layout.yds_item_more_about_logo, null);
            Intrinsics.checkNotNullParameter(parent, "parent");
        }

        @Override // com.yoti.mobile.android.commonui.moreabout.MoreAboutViewHolder
        public void bind(MoreAboutItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            ((ImageView) this.itemView.findViewById(C4590R.id.logo)).setImageResource(((MoreAboutItem.MoreAboutLogoItem) item).getLogo());
        }
    }
}
