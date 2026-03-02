package com.yoti.mobile.android.liveness.view.biometric_consent;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yoti.mobile.android.liveness.databinding.YdsBiometricConsentBulletedParagraphListItemBinding;
import com.yoti.mobile.android.liveness.databinding.YdsBiometricConsentParagraphListItemBinding;
import com.yoti.mobile.android.liveness.databinding.YdsBiometricConsentWebLinkListItemBinding;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentItemViewHolder;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewData;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000eH\u0002R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentItemViewHolder;", "viewModel", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel;", "(Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel;)V", "listItems", "", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem;", "getListItems", "()Ljava/util/List;", "setListItems", "(Ljava/util/List;)V", "getItemCount", "", "getItemViewType", ViewProps.POSITION, "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onWebLinkClicked", FirebaseAnalytics.Param.INDEX, "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class BiometricConsentListAdapter extends RecyclerView.Adapter<BiometricConsentItemViewHolder> {
    private List<? extends BiometricConsentViewData.ListItem> listItems;
    private final BiometricConsentViewModel viewModel;

    public BiometricConsentListAdapter(BiometricConsentViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        this.listItems = CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onWebLinkClicked(int index) {
        BiometricConsentViewData.ListItem listItem = (BiometricConsentViewData.ListItem) CollectionsKt.getOrNull(this.listItems, index);
        if (listItem instanceof BiometricConsentViewData.ListItem.WebLink.PrivacyPolicy) {
            this.viewModel.handleViewEvent(BiometricConsentViewModel.BiometricConsentViewEvent.OnPrivacyPolicyLinkClick.INSTANCE);
        } else if (listItem instanceof BiometricConsentViewData.ListItem.WebLink.BiometricPolicyUs) {
            this.viewModel.handleViewEvent(BiometricConsentViewModel.BiometricConsentViewEvent.OnBiometricPolicyUsLinkClick.INSTANCE);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getTotalPages() {
        return this.listItems.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        BiometricConsentViewData.ListItem listItem = (BiometricConsentViewData.ListItem) CollectionsKt.getOrNull(this.listItems, position);
        if (listItem != null) {
            return listItem.getViewTypeId();
        }
        return 0;
    }

    public final List<BiometricConsentViewData.ListItem> getListItems() {
        return this.listItems;
    }

    public final void setListItems(List<? extends BiometricConsentViewData.ListItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.listItems = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BiometricConsentItemViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BiometricConsentViewData.ListItem listItem = (BiometricConsentViewData.ListItem) CollectionsKt.getOrNull(this.listItems, position);
        if (listItem != null) {
            holder.bind(listItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BiometricConsentItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            YdsBiometricConsentBulletedParagraphListItemBinding ydsBiometricConsentBulletedParagraphListItemBindingInflate = YdsBiometricConsentBulletedParagraphListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(ydsBiometricConsentBulletedParagraphListItemBindingInflate, "inflate(\n               …  false\n                )");
            return new BiometricConsentItemViewHolder.BulletedParagraphViewHolder(ydsBiometricConsentBulletedParagraphListItemBindingInflate);
        }
        if (viewType != 2) {
            YdsBiometricConsentParagraphListItemBinding ydsBiometricConsentParagraphListItemBindingInflate = YdsBiometricConsentParagraphListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(ydsBiometricConsentParagraphListItemBindingInflate, "inflate(\n               …  false\n                )");
            return new BiometricConsentItemViewHolder.ParagraphViewHolder(ydsBiometricConsentParagraphListItemBindingInflate);
        }
        YdsBiometricConsentWebLinkListItemBinding ydsBiometricConsentWebLinkListItemBindingInflate = YdsBiometricConsentWebLinkListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(ydsBiometricConsentWebLinkListItemBindingInflate, "inflate(\n               …  false\n                )");
        return new BiometricConsentItemViewHolder.WebLinkViewHolder(ydsBiometricConsentWebLinkListItemBindingInflate, new Function1<Integer, Unit>() { // from class: com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentListAdapter.onCreateViewHolder.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                BiometricConsentListAdapter.this.onWebLinkClicked(i);
            }
        });
    }
}
