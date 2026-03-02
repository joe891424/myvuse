package com.salesforce.marketingcloud.sfmcsdk.components.events;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EngagementEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0003\u000e\u000f\u0010¨\u0006\u0011"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/components/events/EngagementEvent;", "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event;", "name", "", "(Ljava/lang/String;)V", AnalyticsAttribute.EVENT_CATEGORY_ATTRIBUTE, "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Category;", "getCategory", "()Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Category;", "setCategory", "(Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Category;)V", C4352k.a.f5654h, "", "", "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/CartEvent;", "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/CatalogEvent;", "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/OrderEvent;", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class EngagementEvent extends Event {
    private Event.Category category;
    private final String name;

    public /* synthetic */ EngagementEvent(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private EngagementEvent(String str) {
        this.name = str;
        this.category = Event.Category.ENGAGEMENT;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.Event
    public Map<String, Object> attributes() {
        return MapsKt.emptyMap();
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.Event
    /* JADX INFO: renamed from: name, reason: from getter */
    public String getName() {
        return this.name;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.Event
    public Event.Category getCategory() {
        return this.category;
    }

    public void setCategory(Event.Category category) {
        Intrinsics.checkNotNullParameter(category, "<set-?>");
        this.category = category;
    }
}
