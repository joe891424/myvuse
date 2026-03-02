package com.salesforce.marketingcloud.sfmcsdk.components.events;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdk;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import com.salesforce.marketingcloud.sfmcsdk.components.identity.Identity;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import com.salesforce.marketingcloud.sfmcsdk.components.utils.SdkExecutors;
import com.salesforce.marketingcloud.sfmcsdk.components.utils.SdkExecutorsKt;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleIdentifier;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EventManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001f\u0010\t\u001a\u00020\u00062\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/components/events/EventManager;", "", "moduleName", "", "(Ljava/lang/String;)V", "subscribe", "", "subscriber", "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/EventSubscriber;", "track", "events", "", "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event;", "([Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event;)V", "unsubscribe", "Companion", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class EventManager {
    public static final String TAG = "~$EventManager";
    private final String moduleName;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<EventSubscriber> subscribers = new ArrayList();

    @JvmStatic
    public static final Event customEvent(String str) {
        return INSTANCE.customEvent(str);
    }

    @JvmStatic
    public static final Event customEvent(String str, Map<String, ? extends Object> map) {
        return INSTANCE.customEvent(str, map);
    }

    @JvmStatic
    public static final Event customEvent(String str, Map<String, ? extends Object> map, Event.Producer producer) {
        return INSTANCE.customEvent(str, map, producer);
    }

    @JvmStatic
    public static final Event customEvent(String str, Map<String, ? extends Object> map, Event.Producer producer, Event.Category category) {
        return INSTANCE.customEvent(str, map, producer, category);
    }

    public EventManager(String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        this.moduleName = moduleName;
    }

    /* JADX INFO: compiled from: EventManager.kt */
    @Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00042\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0002J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0002J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\b\u0016J/\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u001c\"\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0018H\u0000¢\u0006\u0002\b R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/components/events/EventManager$Companion;", "", "()V", "TAG", "", "subscribers", "", "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/EventSubscriber;", "customEvent", "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event;", "name", C4352k.a.f5654h, "", "producer", "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Producer;", AnalyticsAttribute.EVENT_CATEGORY_ATTRIBUTE, "Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event$Category;", "getValidatedAttributeKey", "input", "prefix", "getValidatedName", "identityEvent", "identityEvent$sfmcsdk_release", "publish", "", "executors", "Lcom/salesforce/marketingcloud/sfmcsdk/components/utils/SdkExecutors;", "events", "", "publish$sfmcsdk_release", "(Lcom/salesforce/marketingcloud/sfmcsdk/components/utils/SdkExecutors;[Lcom/salesforce/marketingcloud/sfmcsdk/components/events/Event;)V", "staticTearDown", "staticTearDown$sfmcsdk_release", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Event customEvent(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return customEvent$default(this, name, null, null, null, 14, null);
        }

        @JvmStatic
        public final Event customEvent(String name, Map<String, ? extends Object> attributes) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            return customEvent$default(this, name, attributes, null, null, 12, null);
        }

        @JvmStatic
        public final Event customEvent(String name, Map<String, ? extends Object> attributes, Event.Producer producer) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(producer, "producer");
            return customEvent$default(this, name, attributes, producer, null, 8, null);
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Event customEvent$default(Companion companion, String str, Map map, Event.Producer producer, Event.Category category, int i, Object obj) {
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            if ((i & 4) != 0) {
                producer = Event.Producer.SFMC_SDK;
            }
            if ((i & 8) != 0) {
                category = Event.Category.ENGAGEMENT;
            }
            return companion.customEvent(str, map, producer, category);
        }

        @JvmStatic
        public final Event customEvent(String name, Map<String, ? extends Object> attributes, Event.Producer producer, Event.Category category) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(producer, "producer");
            Intrinsics.checkNotNullParameter(category, "category");
            String validatedName$default = getValidatedName$default(this, name, null, 2, null);
            if (validatedName$default == null) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Object> entry : attributes.entrySet()) {
                String validatedAttributeKey$default = getValidatedAttributeKey$default(EventManager.INSTANCE, entry.getKey(), null, 2, null);
                if (validatedAttributeKey$default != null) {
                    linkedHashMap.put(validatedAttributeKey$default, entry.getValue());
                }
            }
            return new CustomEvent(validatedName$default, linkedHashMap, producer, category);
        }

        public final void publish$sfmcsdk_release(SdkExecutors executors, final Event... events) {
            Intrinsics.checkNotNullParameter(executors, "executors");
            Intrinsics.checkNotNullParameter(events, "events");
            if (ArraysKt.filterNotNull(events).isEmpty()) {
                return;
            }
            synchronized (EventManager.subscribers) {
                for (final EventSubscriber eventSubscriber : EventManager.subscribers) {
                    try {
                        SFMCSdkLogger.INSTANCE.mo3976d(EventManager.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager$Companion$publish$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                StringBuilder sb = new StringBuilder("Publishing events: ");
                                String str = "";
                                for (Event event : ArraysKt.filterNotNull(events)) {
                                    str = str + (StringsKt.isBlank(str) ? "" : ", ") + Reflection.getOrCreateKotlinClass(event.getClass()).getSimpleName() + "( " + event.getName() + " )";
                                }
                                return sb.append(str).append(" to subscriber: ").append(eventSubscriber).toString();
                            }
                        });
                    } catch (Exception unused) {
                    }
                    try {
                        ExecutorService diskIO = executors.getDiskIO();
                        String name = eventSubscriber.getClass().getName();
                        Intrinsics.checkNotNullExpressionValue(name, "subscriber::class.java.name");
                        SdkExecutorsKt.namedRunnable(diskIO, name, new Function0<Unit>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager$Companion$publish$1$1$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                EventSubscriber eventSubscriber2 = eventSubscriber;
                                Event[] eventArr = events;
                                eventSubscriber2.onEventPublished((Event[]) Arrays.copyOf(eventArr, eventArr.length));
                            }
                        });
                    } catch (Exception unused2) {
                        SFMCSdkLogger.INSTANCE.mo3978e(EventManager.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager$Companion$publish$1$1$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to publish event(s) " + events + " to subscriber " + eventSubscriber + '.';
                            }
                        });
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void staticTearDown$sfmcsdk_release() {
            synchronized (EventManager.subscribers) {
                EventManager.subscribers.clear();
                Unit unit = Unit.INSTANCE;
            }
        }

        static /* synthetic */ String getValidatedAttributeKey$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "Attribute Key";
            }
            return companion.getValidatedAttributeKey(str, str2);
        }

        private final String getValidatedAttributeKey(final String input, final String prefix) {
            if (StringsKt.contains$default((CharSequence) input, (CharSequence) ".", false, 2, (Object) null)) {
                SFMCSdkLogger.INSTANCE.mo3980w(EventManager.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager$Companion$getValidatedAttributeKey$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return prefix + " '" + input + "' contains a \".\" and will be dropped.";
                    }
                });
                return null;
            }
            return getValidatedName(input, prefix);
        }

        static /* synthetic */ String getValidatedName$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "Event Name";
            }
            return companion.getValidatedName(str, str2);
        }

        private final String getValidatedName(final String input, final String prefix) {
            String string = StringsKt.trim((CharSequence) input).toString();
            String str = string;
            if (!StringsKt.isBlank(str) && !StringsKt.startsWith$default(string, "$", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) "\r", false, 2, (Object) null)) {
                return string;
            }
            SFMCSdkLogger.INSTANCE.mo3980w(EventManager.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager$Companion$getValidatedName$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return prefix + " '" + input + "' is null, blank, starts with a \"$\", or contains a line break and will be dropped.";
                }
            });
            return null;
        }

        public final Event identityEvent$sfmcsdk_release() {
            return customEvent$default(this, "IdentityUpdate", Identity.INSTANCE.toEvent$sfmcsdk_release(), null, Event.Category.IDENTITY, 4, null);
        }
    }

    public final void track(Event... events) {
        Event.Producer producer;
        Intrinsics.checkNotNullParameter(events, "events");
        String str = this.moduleName;
        if (Intrinsics.areEqual(str, ModuleIdentifier.PUSH.name())) {
            producer = Event.Producer.PUSH;
        } else {
            producer = Intrinsics.areEqual(str, ModuleIdentifier.CDP.name()) ? Event.Producer.CDP : Event.Producer.SFMC_SDK;
        }
        ArrayList arrayList = new ArrayList();
        for (Event event : events) {
            Event eventCustomEvent$default = Companion.customEvent$default(INSTANCE, event.getName(), event.attributes(), producer, null, 8, null);
            if (eventCustomEvent$default != null) {
                arrayList.add(eventCustomEvent$default);
            }
        }
        SFMCSdk.Companion companion = SFMCSdk.INSTANCE;
        Object[] array = arrayList.toArray(new Event[0]);
        if (array != null) {
            Event[] eventArr = (Event[]) array;
            companion.track((Event[]) Arrays.copyOf(eventArr, eventArr.length));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final void subscribe(EventSubscriber subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        List<EventSubscriber> list = subscribers;
        synchronized (list) {
            list.add(subscriber);
        }
    }

    public final void unsubscribe(EventSubscriber subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        List<EventSubscriber> list = subscribers;
        synchronized (list) {
            list.remove(subscriber);
        }
    }
}
