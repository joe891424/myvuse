package com.salesforce.marketingcloud.sfmcsdk.components.events;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdk;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Event.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000eH&J\b\u0010\u000f\u001a\u00020\bH&J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event;", "", "()V", AnalyticsAttribute.EVENT_CATEGORY_ATTRIBUTE, "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Category;", "getCategory", "()Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Category;", "id", "", "producer", "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Producer;", "getProducer", "()Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Producer;", C4352k.a.f5654h, "", "name", "toJson", "Lorg/json/JSONObject;", "track", "", "Category", "Producer", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class Event {
    private final Category category;
    public final String id;
    private final Producer producer;

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Category;", "", "(Ljava/lang/String;I)V", "APPLICATION", "ENGAGEMENT", "IDENTITY", "SYSTEM", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum Category {
        APPLICATION,
        ENGAGEMENT,
        IDENTITY,
        SYSTEM
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Producer;", "", "(Ljava/lang/String;I)V", "APP", "SFMC_SDK", "PUSH", "CDP", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum Producer {
        APP,
        SFMC_SDK,
        PUSH,
        CDP
    }

    public abstract Map<String, Object> attributes();

    public abstract String name();

    public Event() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.id = string;
        this.producer = Producer.SFMC_SDK;
        this.category = Category.ENGAGEMENT;
    }

    public Producer getProducer() {
        return this.producer;
    }

    public Category getCategory() {
        return this.category;
    }

    public final void track() {
        SFMCSdk.INSTANCE.track(this);
    }

    public final JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", name());
        jSONObject.put("id", this.id);
        jSONObject.put("producer", getProducer());
        jSONObject.put(AnalyticsAttribute.EVENT_CATEGORY_ATTRIBUTE, getCategory());
        JSONObject jSONObject2 = new JSONObject();
        Iterator<T> it2 = attributes().entrySet().iterator();
        while (it2.hasNext()) {
            final Map.Entry entry = (Map.Entry) it2.next();
            try {
                Object value = entry.getValue();
                if (value instanceof SFMCSdkEvent) {
                    jSONObject2.put((String) entry.getKey(), ((SFMCSdkEvent) entry.getValue()).toJson());
                } else {
                    boolean z = true;
                    if (!(value instanceof Number ? true : value instanceof String ? true : value instanceof Character)) {
                        z = value instanceof Boolean;
                    }
                    if (z) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    } else {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                }
            } catch (Exception unused) {
                SFMCSdkLogger sFMCSdkLogger = SFMCSdkLogger.INSTANCE;
                String name = jSONObject2.getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "this::class.java.name");
                sFMCSdkLogger.mo3980w(name, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.events.Event$toJson$1$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Could not convert attribute (" + entry + ") to JSON.";
                    }
                });
            }
        }
        Unit unit = Unit.INSTANCE;
        jSONObject.put(C4352k.a.f5654h, jSONObject2);
        return jSONObject;
    }
}
