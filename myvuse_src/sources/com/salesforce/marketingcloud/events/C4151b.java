package com.salesforce.marketingcloud.events;

import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.events.b */
/* JADX INFO: loaded from: classes6.dex */
public final class C4151b implements Event {

    /* JADX INFO: renamed from: a */
    private final String f4701a;

    /* JADX INFO: renamed from: b */
    private final Map<String, Object> f4702b;

    /* JADX INFO: renamed from: c */
    private final Event.Producer f4703c;

    public C4151b(String name, Map<String, ? extends Object> attributes, Event.Producer producer) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(producer, "producer");
        this.f4701a = name;
        this.f4702b = attributes;
        this.f4703c = producer;
    }

    /* JADX INFO: renamed from: a */
    public final Map<String, Object> m3113a() {
        return this.f4702b;
    }

    @Override // com.salesforce.marketingcloud.events.Event
    public Map<String, Object> attributes() {
        return this.f4702b;
    }

    @Override // com.salesforce.marketingcloud.events.Event
    public Event.Producer getProducer() {
        return this.f4703c;
    }

    @Override // com.salesforce.marketingcloud.events.Event
    public String name() {
        return this.f4701a;
    }

    public /* synthetic */ C4151b(String str, Map map, Event.Producer producer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? Event.Producer.PUSH : producer);
    }
}
