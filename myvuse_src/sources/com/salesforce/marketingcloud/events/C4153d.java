package com.salesforce.marketingcloud.events;

import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.events.d */
/* JADX INFO: loaded from: classes6.dex */
public final class C4153d {

    /* JADX INFO: renamed from: a */
    private static final String f4735a = C4170g.m3197a("EventUtilsKt");

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.d$a */
    static final class a extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ com.salesforce.marketingcloud.sfmcsdk.components.events.Event f4736a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.salesforce.marketingcloud.sfmcsdk.components.events.Event event) {
            super(0);
            this.f4736a = event;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "(" + this.f4736a + ") returned null during conversion to Push SDK Event.";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.d$b */
    static final class b extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ Object f4737a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Object obj) {
            super(0);
            this.f4737a = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to convert event '" + this.f4737a + "' to Push SDK Event.";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.d$c */
    static final class c extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ Event f4738a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Event event) {
            super(0);
            this.f4738a = event;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "(" + this.f4738a + ") returned null during conversion to SFMC SDK Event.";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.d$d */
    static final class d extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ Object f4739a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Object obj) {
            super(0);
            this.f4739a = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to convert event '" + this.f4739a + "' to SFMCSdk Event.";
        }
    }

    /* JADX INFO: renamed from: a */
    public static final Map<String, List<Object>> m3126a(Event event) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        return m3128a(new LinkedHashMap(), event.attributes(), (String) null, 4, (Object) null);
    }

    /* JADX INFO: renamed from: b */
    public static final com.salesforce.marketingcloud.sfmcsdk.components.events.Event m3137b(Event event) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        return EventManager.Companion.customEvent$default(com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager.INSTANCE, event.name(), event.attributes(), Event.Producer.PUSH, null, 8, null);
    }

    /* JADX INFO: renamed from: a */
    private static final Map<String, List<Object>> m3127a(Map<String, List<Object>> map, Object obj, String str) {
        try {
            if (obj instanceof List) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any>");
                return m3129a(map, (List<Object>) TypeIntrinsics.asMutableList(obj), str);
            }
            if (!(obj instanceof Map)) {
                return map;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.Any, kotlin.Any>");
            return m3130a(map, (Map<Object, Object>) TypeIntrinsics.asMutableMap(obj), str);
        } catch (Exception unused) {
            return map;
        }
    }

    /* JADX INFO: renamed from: b */
    public static final com.salesforce.marketingcloud.sfmcsdk.components.events.Event[] m3138b(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        return m3136a(objArr, null, 1, null);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ Map m3128a(Map map, Object obj, String str, int i, Object obj2) {
        if ((i & 4) != 0) {
            str = "";
        }
        return m3127a((Map<String, List<Object>>) map, obj, str);
    }

    /* JADX INFO: renamed from: b */
    public static final com.salesforce.marketingcloud.sfmcsdk.components.events.Event[] m3139b(Object[] objArr, EnumSet<Event.Producer> producers) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(producers, "producers");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                try {
                    Event event = (Event) obj;
                    if (producers.contains(event.getProducer())) {
                        com.salesforce.marketingcloud.sfmcsdk.components.events.Event eventM3137b = m3137b(event);
                        if ((eventM3137b != null ? Boolean.valueOf(arrayList.add(eventM3137b)) : null) == null) {
                            C4170g.m3209c(C4170g.f4785a, f4735a, null, new c(event), 2, null);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                } catch (Exception unused) {
                    C4170g.m3215e(C4170g.f4785a, f4735a, null, new d(obj), 2, null);
                }
            }
        }
        return (com.salesforce.marketingcloud.sfmcsdk.components.events.Event[]) arrayList.toArray(new com.salesforce.marketingcloud.sfmcsdk.components.events.Event[0]);
    }

    /* JADX INFO: renamed from: a */
    private static final boolean m3131a(Object obj) {
        if (obj instanceof Map) {
            return true;
        }
        if (obj instanceof List) {
            int i = 0;
            for (Object obj2 : (Iterable) obj) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (obj2 != null && m3131a(obj2)) {
                    return true;
                }
                i = i2;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private static final Map<String, List<Object>> m3129a(Map<String, List<Object>> map, List<Object> list, String str) {
        for (Object obj : list) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (obj != null) {
                if (m3131a(obj)) {
                    map.putAll(m3127a(map, obj, str));
                } else {
                    List<Object> list2 = map.get(lowerCase);
                    if (list2 == null || list2.isEmpty()) {
                        map.put(lowerCase, CollectionsKt.mutableListOf(obj));
                    } else {
                        List<Object> list3 = map.get(lowerCase);
                        if (list3 != null) {
                            list3.add(obj);
                        }
                    }
                }
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: a */
    private static final Map<String, List<Object>> m3130a(Map<String, List<Object>> map, Map<Object, Object> map2, String str) {
        String str2;
        for (Map.Entry<Object, Object> entry : map2.entrySet()) {
            if (StringsKt.isBlank(str)) {
                Object key = entry.getKey();
                Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.String");
                str2 = (String) key;
            } else {
                str2 = str + "." + entry.getKey();
            }
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (m3131a(entry.getValue())) {
                map.putAll(m3127a(map, entry.getValue(), lowerCase));
            } else {
                List<Object> list = map.get(lowerCase);
                if (list == null || list.isEmpty()) {
                    map.put(lowerCase, CollectionsKt.mutableListOf(entry.getValue()));
                } else {
                    List<Object> list2 = map.get(lowerCase);
                    if (list2 != null) {
                        list2.add(entry.getValue());
                    }
                }
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: a */
    public static final Event[] m3132a(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        return m3135a(objArr, (EnumSet) null, (EnumSet) null, 3, (Object) null);
    }

    /* JADX INFO: renamed from: a */
    public static final Event[] m3133a(Object[] objArr, EnumSet<Event.Producer> producers) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(producers, "producers");
        return m3135a(objArr, producers, (EnumSet) null, 2, (Object) null);
    }

    /* JADX INFO: renamed from: a */
    public static final Event[] m3134a(Object[] objArr, EnumSet<Event.Producer> producers, EnumSet<Event.Category> categories) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(producers, "producers");
        Intrinsics.checkNotNullParameter(categories, "categories");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                try {
                    com.salesforce.marketingcloud.sfmcsdk.components.events.Event event = (com.salesforce.marketingcloud.sfmcsdk.components.events.Event) obj;
                    if (producers.contains(event.getProducer()) && categories.contains(event.getCategory())) {
                        Event eventM3125a = m3125a(event);
                        if ((eventM3125a != null ? Boolean.valueOf(arrayList.add(eventM3125a)) : null) == null) {
                            C4170g.m3209c(C4170g.f4785a, f4735a, null, new a(event), 2, null);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                } catch (Exception unused) {
                    C4170g.m3205b(C4170g.f4785a, f4735a, null, new b(obj), 2, null);
                }
            }
        }
        return (Event[]) arrayList.toArray(new Event[0]);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ Event[] m3135a(Object[] objArr, EnumSet enumSet, EnumSet enumSet2, int i, Object obj) {
        if ((i & 1) != 0) {
            enumSet = EnumSet.allOf(Event.Producer.class);
            Intrinsics.checkNotNullExpressionValue(enumSet, "allOf(...)");
        }
        if ((i & 2) != 0) {
            enumSet2 = EnumSet.allOf(Event.Category.class);
            Intrinsics.checkNotNullExpressionValue(enumSet2, "allOf(...)");
        }
        return m3134a(objArr, (EnumSet<Event.Producer>) enumSet, (EnumSet<Event.Category>) enumSet2);
    }

    /* JADX INFO: renamed from: a */
    public static final Event m3125a(com.salesforce.marketingcloud.sfmcsdk.components.events.Event event) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        return EventManager.INSTANCE.customEvent(event.getName(), event.attributes(), event.getProducer());
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ com.salesforce.marketingcloud.sfmcsdk.components.events.Event[] m3136a(Object[] objArr, EnumSet enumSet, int i, Object obj) {
        if ((i & 1) != 0) {
            enumSet = EnumSet.allOf(Event.Producer.class);
            Intrinsics.checkNotNullExpressionValue(enumSet, "allOf(...)");
        }
        return m3139b(objArr, enumSet);
    }
}
