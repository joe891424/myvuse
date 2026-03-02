package com.salesforce.marketingcloud.sfmcsdk.components.events;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/components/events/CustomEvent;", "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event;", "name", "", C4352k.a.f5654h, "", "", "producer", "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Producer;", AnalyticsAttribute.EVENT_CATEGORY_ATTRIBUTE, "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Category;", "(Ljava/lang/String;Ljava/util/Map;Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Producer;Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Category;)V", "getCategory", "()Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Category;", "getProducer", "()Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Producer;", "toString", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class CustomEvent extends Event {
    private final Map<String, Object> attributes;
    private final Event.Category category;
    private final String name;
    private final Event.Producer producer;

    public /* synthetic */ CustomEvent(String str, Map map, Event.Producer producer, Event.Category category, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, (i & 4) != 0 ? Event.Producer.SFMC_SDK : producer, (i & 8) != 0 ? Event.Category.ENGAGEMENT : category);
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.Event
    public Event.Producer getProducer() {
        return this.producer;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.Event
    public Event.Category getCategory() {
        return this.category;
    }

    public CustomEvent(String name, Map<String, ? extends Object> attributes, Event.Producer producer, Event.Category category) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(producer, "producer");
        Intrinsics.checkNotNullParameter(category, "category");
        this.name = name;
        this.attributes = attributes;
        this.producer = producer;
        this.category = category;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.Event
    /* JADX INFO: renamed from: name, reason: from getter */
    public String getName() {
        return this.name;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.Event
    public Map<String, Object> attributes() {
        return this.attributes;
    }

    public String toString() {
        return "CustomEvent(name='" + this.name + "', producer=" + getProducer() + ", category=" + getCategory() + ", attributes=" + this.attributes + ')';
    }
}
