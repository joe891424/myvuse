package com.yoti.mobile.android.liveness.view.biometric_consent;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.commonui.BulletTextLayout;
import com.yoti.mobile.android.liveness.databinding.YdsBiometricConsentBulletedParagraphListItemBinding;
import com.yoti.mobile.android.liveness.databinding.YdsBiometricConsentParagraphListItemBinding;
import com.yoti.mobile.android.liveness.databinding.YdsBiometricConsentWebLinkListItemBinding;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\f\r\u000eB%\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&\u0082\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "onClickAction", "Lkotlin/Function1;", "", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "bind", "item", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem;", "BulletedParagraphViewHolder", "ParagraphViewHolder", "WebLinkViewHolder", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentItemViewHolder$ParagraphViewHolder;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentItemViewHolder$BulletedParagraphViewHolder;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentItemViewHolder$WebLinkViewHolder;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class BiometricConsentItemViewHolder extends RecyclerView.ViewHolder {

    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentItemViewHolder$BulletedParagraphViewHolder;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentItemViewHolder;", "binding", "Lcom/yoti/mobile/android/liveness/databinding/YdsBiometricConsentBulletedParagraphListItemBinding;", "(Lcom/yoti/mobile/android/liveness/databinding/YdsBiometricConsentBulletedParagraphListItemBinding;)V", "getBinding", "()Lcom/yoti/mobile/android/liveness/databinding/YdsBiometricConsentBulletedParagraphListItemBinding;", "bind", "", "item", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class BulletedParagraphViewHolder extends BiometricConsentItemViewHolder {
        private final YdsBiometricConsentBulletedParagraphListItemBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public BulletedParagraphViewHolder(YdsBiometricConsentBulletedParagraphListItemBinding binding) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            BulletTextLayout root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            super(root, null, 0 == true ? 1 : 0);
            this.binding = binding;
        }

        @Override // com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentItemViewHolder
        public void bind(BiometricConsentViewData.ListItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.binding.bulletedParagraphText.setText(((BiometricConsentViewData.ListItem.BulletedParagraph) item).getTextId());
        }

        public final YdsBiometricConsentBulletedParagraphListItemBinding getBinding() {
            return this.binding;
        }
    }

    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentItemViewHolder$ParagraphViewHolder;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentItemViewHolder;", "binding", "Lcom/yoti/mobile/android/liveness/databinding/YdsBiometricConsentParagraphListItemBinding;", "(Lcom/yoti/mobile/android/liveness/databinding/YdsBiometricConsentParagraphListItemBinding;)V", "getBinding", "()Lcom/yoti/mobile/android/liveness/databinding/YdsBiometricConsentParagraphListItemBinding;", "bind", "", "item", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class ParagraphViewHolder extends BiometricConsentItemViewHolder {
        private final YdsBiometricConsentParagraphListItemBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public ParagraphViewHolder(YdsBiometricConsentParagraphListItemBinding binding) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            TextView root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            super(root, null, 0 == true ? 1 : 0);
            this.binding = binding;
        }

        @Override // com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentItemViewHolder
        public void bind(BiometricConsentViewData.ListItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.binding.paragraphText.setText(((BiometricConsentViewData.ListItem.Paragraph) item).getTextId());
        }

        public final YdsBiometricConsentParagraphListItemBinding getBinding() {
            return this.binding;
        }
    }

    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentItemViewHolder$WebLinkViewHolder;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentItemViewHolder;", "binding", "Lcom/yoti/mobile/android/liveness/databinding/YdsBiometricConsentWebLinkListItemBinding;", "onClickAction", "Lkotlin/Function1;", "", "", "(Lcom/yoti/mobile/android/liveness/databinding/YdsBiometricConsentWebLinkListItemBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/yoti/mobile/android/liveness/databinding/YdsBiometricConsentWebLinkListItemBinding;", "bind", "item", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class WebLinkViewHolder extends BiometricConsentItemViewHolder {
        private final YdsBiometricConsentWebLinkListItemBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public WebLinkViewHolder(YdsBiometricConsentWebLinkListItemBinding binding, Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            TextView root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            super(root, function1, null);
            this.binding = binding;
        }

        @Override // com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentItemViewHolder
        public void bind(BiometricConsentViewData.ListItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.binding.webLinkLabel.setText(((BiometricConsentViewData.ListItem.WebLink) item).getLabelId());
        }

        public final YdsBiometricConsentWebLinkListItemBinding getBinding() {
            return this.binding;
        }
    }

    private BiometricConsentItemViewHolder(View view, final Function1<? super Integer, Unit> function1) {
        super(view);
        if (function1 != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentItemViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BiometricConsentItemViewHolder.m6868lambda1$lambda0(function1, this, view2);
                }
            });
        }
    }

    public /* synthetic */ BiometricConsentItemViewHolder(View view, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda-1$lambda-0, reason: not valid java name */
    public static final void m6868lambda1$lambda0(Function1 it2, BiometricConsentItemViewHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(it2, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        it2.invoke(Integer.valueOf(this$0.getAdapterPosition()));
    }

    public abstract void bind(BiometricConsentViewData.ListItem item);
}
