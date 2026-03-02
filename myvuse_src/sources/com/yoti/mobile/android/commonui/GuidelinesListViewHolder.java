package com.yoti.mobile.android.commonui;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.yoti.mobile.android.commonui.databinding.YdsGuidelinesListCellBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GuidelinesListAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/GuidelinesListViewHolder;", "Lcom/yoti/mobile/android/commonui/GuidelinesViewHolder;", "binding", "Lcom/yoti/mobile/android/commonui/databinding/YdsGuidelinesListCellBinding;", "(Lcom/yoti/mobile/android/commonui/databinding/YdsGuidelinesListCellBinding;)V", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class GuidelinesListViewHolder extends GuidelinesViewHolder {
    /* JADX WARN: Illegal instructions before constructor call */
    public GuidelinesListViewHolder(YdsGuidelinesListCellBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        ConstraintLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ImageView imageView = binding.guidelinesItemImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.guidelinesItemImage");
        TextView textView = binding.guidelinesItemHeader;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.guidelinesItemHeader");
        TextView textView2 = binding.guidelinesItemText;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.guidelinesItemText");
        super(root, imageView, textView, textView2, null);
    }
}
