package com.salesforce.marketingcloud.sfmcsdk.components.events;

import kotlin.Metadata;

/* JADX INFO: compiled from: EventManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H&¢\u0006\u0002\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/components/events/EventSubscriber;", "", "onEventPublished", "", "events", "", "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event;", "([Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event;)V", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface EventSubscriber {
    void onEventPublished(Event... events);
}
