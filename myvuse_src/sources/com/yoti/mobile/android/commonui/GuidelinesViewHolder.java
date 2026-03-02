package com.yoti.mobile.android.commonui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GuidelinesListAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B'\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/GuidelinesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "root", "Landroid/view/View;", "itemImage", "Landroid/widget/ImageView;", "itemHeader", "Landroid/widget/TextView;", "itemText", "(Landroid/view/View;Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/widget/TextView;)V", "bind", "", "item", "Lcom/yoti/mobile/android/commonui/GuidelinesItem;", "Lcom/yoti/mobile/android/commonui/GuidelinesListViewHolder;", "Lcom/yoti/mobile/android/commonui/GuidelinesGridViewHolder;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class GuidelinesViewHolder extends RecyclerView.ViewHolder {
    private final TextView itemHeader;
    private final ImageView itemImage;
    private final TextView itemText;

    public /* synthetic */ GuidelinesViewHolder(View view, ImageView imageView, TextView textView, TextView textView2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, imageView, textView, textView2);
    }

    private GuidelinesViewHolder(View view, ImageView imageView, TextView textView, TextView textView2) {
        super(view);
        this.itemImage = imageView;
        this.itemHeader = textView;
        this.itemText = textView2;
    }

    public final void bind(GuidelinesItem item) {
        Unit unit;
        Intrinsics.checkNotNullParameter(item, "item");
        this.itemImage.setImageResource(item.getIcon());
        Integer header = item.getHeader();
        Unit unit2 = null;
        if (header != null) {
            this.itemHeader.setText(header.intValue());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.itemHeader.setVisibility(8);
        }
        CompoundTextResource text = item.getText();
        if (text != null) {
            Context context = this.itemImage.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemImage.context");
            CharSequence value = text.getValue(context);
            if (value != null) {
                this.itemText.setVisibility(0);
                this.itemText.setText(value);
                unit2 = Unit.INSTANCE;
            }
        }
        if (unit2 == null) {
            this.itemText.setVisibility(8);
        }
    }
}
