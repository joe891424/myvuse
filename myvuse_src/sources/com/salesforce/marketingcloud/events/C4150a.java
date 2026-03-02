package com.salesforce.marketingcloud.events;

import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.events.a */
/* JADX INFO: loaded from: classes6.dex */
public final class C4150a implements Event {
    @Override // com.salesforce.marketingcloud.events.Event
    public Map<String, Object> attributes() {
        return MapsKt.emptyMap();
    }

    @Override // com.salesforce.marketingcloud.events.Event
    public String name() {
        return "$appOpen";
    }
}
