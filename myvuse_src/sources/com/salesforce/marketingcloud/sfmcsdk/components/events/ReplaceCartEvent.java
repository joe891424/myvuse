package com.salesforce.marketingcloud.sfmcsdk.components.events;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CartEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/components/events/ReplaceCartEvent;", "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/CartEvent;", "lineItems", "", "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/LineItem;", "(Ljava/util/List;)V", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ReplaceCartEvent extends CartEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplaceCartEvent(List<LineItem> lineItems) {
        super("Replace Cart", lineItems, null);
        Intrinsics.checkNotNullParameter(lineItems, "lineItems");
    }
}
