package com.squareup.wire.internal;

import androidx.exifinterface.media.ExifInterface;
import com.squareup.wire.ProtoAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Internal.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001\u001a\u0016\u0010\t\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u000e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f\u001a\u0016\u0010\f\u001a\u00020\r2\u000e\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0011\u001a,\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\u00012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u000fH\u0007\u001a>\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0006\u0010\u0015\u001a\u00020\u00012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0018\u0018\u00010\u0011H\u0007\u001a \u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\u001a2\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\u001a\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u001a$\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u001aK\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040 \"\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010!\u001a\u001a\u0010\"\u001a\u00020#2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u001a(\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\u001a:\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0006\u0010\u0015\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\u001a:\u0010%\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0006\u0010\u0015\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\u001a!\u0010&\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010'\u001a\u0002H\u0014¢\u0006\u0002\u0010(\u001a'\u0010)\u001a\u00060*j\u0002`+2\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040 \"\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010-\u001a\u0012\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u0014\u001a\u001e\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018\u001a\u000e\u00100\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0001\u001a\u0014\u00100\u001a\u00020\u00012\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f\u001a1\u00102\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\"\u0004\b\u0000\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00140\u000f2\f\u00103\u001a\b\u0012\u0004\u0012\u0002H\u001404H\u0007¢\u0006\u0002\b5\u001aC\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u00112\f\u00103\u001a\b\u0012\u0004\u0012\u0002H\u001804H\u0007¢\u0006\u0002\b5\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\" \u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u00066"}, m5598d2 = {"ESCAPED_CHARS", "", "typeName", "Lkotlin/reflect/KClass;", "", "getTypeName$Internal__InternalKt", "(Ljava/lang/Object;)Lkotlin/reflect/KClass;", "boxedOneOfClassName", "oneOfName", "boxedOneOfKeyFieldName", "fieldName", "boxedOneOfKeysFieldName", "checkElementsNotNull", "", "list", "", "map", "", "copyOf", "", ExifInterface.GPS_DIRECTION_TRUE, "name", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "countNonNull", "", "a", "b", "c", "d", "rest", "", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)I", "equals", "", "immutableCopyOf", "immutableCopyOfMapWithStructValues", "immutableCopyOfStruct", "value", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "missingRequiredFields", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "args", "([Ljava/lang/Object;)Ljava/lang/IllegalStateException;", "newMutableList", "newMutableMap", "sanitize", "values", "redactElements", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "-redactElements", "wire-runtime"}, m5599k = 5, m5600mv = {1, 4, 0}, m5603xs = "com/squareup/wire/internal/Internal")
final /* synthetic */ class Internal__InternalKt {
    private static final String ESCAPED_CHARS = ",[]{}\\";

    public static final int countNonNull(Object obj, Object obj2) {
        return (obj != null ? 1 : 0) + (obj2 == null ? 0 : 1);
    }

    public static final int countNonNull(Object obj, Object obj2, Object obj3) {
        return (obj != null ? 1 : 0) + (obj2 != null ? 1 : 0) + (obj3 == null ? 0 : 1);
    }

    public static final <T> List<T> newMutableList() {
        return new MutableOnWriteList(CollectionsKt.emptyList());
    }

    public static final <K, V> Map<K, V> newMutableMap() {
        return new LinkedHashMap();
    }

    @Deprecated(message = "Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith = @ReplaceWith(expression = "com.squareup.internal.Internal.copyOf(list)", imports = {}))
    public static final <T> List<T> copyOf(String name, List<? extends T> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNull(list);
        return Internal.copyOf(list);
    }

    public static final <T> List<T> copyOf(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (list == CollectionsKt.emptyList() || (list instanceof ImmutableList)) {
            return new MutableOnWriteList(list);
        }
        return new ArrayList(list);
    }

    @Deprecated(message = "Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith = @ReplaceWith(expression = "com.squareup.internal.Internal.copyOf(map)", imports = {}))
    public static final <K, V> Map<K, V> copyOf(String name, Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNull(map);
        return Internal.copyOf(map);
    }

    public static final <K, V> Map<K, V> copyOf(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return new LinkedHashMap(map);
    }

    public static final <T> List<T> immutableCopyOf(String name, List<? extends T> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "list");
        if (list instanceof MutableOnWriteList) {
            list = (List<T>) ((MutableOnWriteList) list).getMutableList$wire_runtime();
        }
        if (list == CollectionsKt.emptyList() || (list instanceof ImmutableList)) {
            return (List<T>) list;
        }
        ImmutableList immutableList = new ImmutableList(list);
        if (immutableList.contains(null)) {
            throw new IllegalArgumentException((name + ".contains(null)").toString());
        }
        return immutableList;
    }

    public static final <K, V> Map<K, V> immutableCopyOf(String name, Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(map, "map");
        if (map.isEmpty()) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        Set<K> setKeySet = linkedHashMap.keySet();
        if (setKeySet == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Collection<K?>");
        }
        if (setKeySet.contains(null)) {
            throw new IllegalArgumentException((name + ".containsKey(null)").toString());
        }
        Collection<V> collectionValues = linkedHashMap.values();
        if (collectionValues == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Collection<V?>");
        }
        if (collectionValues.contains(null)) {
            throw new IllegalArgumentException((name + ".containsValue(null)").toString());
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "Collections.unmodifiableMap(this)");
        return mapUnmodifiableMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> immutableCopyOfMapWithStructValues(String name, Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (!(key != null)) {
                throw new IllegalArgumentException((name + ".containsKey(null)").toString());
            }
            linkedHashMap.put(key, Internal.immutableCopyOfStruct(name, value));
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "Collections.unmodifiableMap(this)");
        if (mapUnmodifiableMap != null) {
            return mapUnmodifiableMap;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    public static final <T> T immutableCopyOfStruct(String name, T t) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (t == null || (t instanceof Boolean) || (t instanceof Double) || (t instanceof String)) {
            return t;
        }
        if (t instanceof List) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = ((List) t).iterator();
            while (it2.hasNext()) {
                arrayList.add(Internal.immutableCopyOfStruct(name, it2.next()));
            }
            List listUnmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "Collections.unmodifiableList(this)");
            return (T) listUnmodifiableList;
        }
        if (t instanceof Map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : ((Map) t).entrySet()) {
                linkedHashMap.put(Internal.immutableCopyOfStruct(name, entry.getKey()), Internal.immutableCopyOfStruct(name, entry.getValue()));
            }
            Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
            Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "Collections.unmodifiableMap(this)");
            return (T) mapUnmodifiableMap;
        }
        throw new IllegalArgumentException("struct value " + name + " must be a JSON type (null, Boolean, Double, String, List, or Map) but was " + getTypeName$Internal__InternalKt(t) + ": " + t);
    }

    private static final KClass<? extends Object> getTypeName$Internal__InternalKt(Object obj) {
        return Reflection.getOrCreateKotlinClass(obj.getClass());
    }

    /* JADX INFO: renamed from: -redactElements, reason: not valid java name */
    public static final <T> List<T> m6746redactElements(List<? extends T> redactElements, ProtoAdapter<T> adapter) {
        Intrinsics.checkNotNullParameter(redactElements, "$this$redactElements");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        List<? extends T> list = redactElements;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(adapter.redact(it2.next()));
        }
        return arrayList;
    }

    public static final boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && Intrinsics.areEqual(obj, obj2));
    }

    public static final IllegalStateException missingRequiredFields(Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        StringBuilder sb = new StringBuilder();
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, args.length), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        String str = "";
        if (step < 0 ? first >= last : first <= last) {
            while (true) {
                if (args[first] == null) {
                    if (sb.length() > 0) {
                        str = "s";
                    }
                    sb.append("\n  ");
                    sb.append(args[first + 1]);
                }
                if (first == last) {
                    break;
                }
                first += step;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        throw new IllegalStateException("Required field" + str + " not set:" + string);
    }

    public static final void checkElementsNotNull(List<?> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == null) {
                throw new NullPointerException("Element at index " + i + " is null");
            }
        }
    }

    public static final void checkElementsNotNull(Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key == null) {
                throw new NullPointerException("map.containsKey(null)");
            }
            if (value == null) {
                throw new NullPointerException("Value for key " + key + " is null");
            }
        }
    }

    public static final int countNonNull(Object obj, Object obj2, Object obj3, Object obj4, Object... rest) {
        Intrinsics.checkNotNullParameter(rest, "rest");
        int i = obj != null ? 1 : 0;
        if (obj2 != null) {
            i++;
        }
        if (obj3 != null) {
            i++;
        }
        if (obj4 != null) {
            i++;
        }
        for (Object obj5 : rest) {
            if (obj5 != null) {
                i++;
            }
        }
        return i;
    }

    public static final String sanitize(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sb = new StringBuilder(value.length());
        String str = value;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (StringsKt.contains$default((CharSequence) ESCAPED_CHARS, cCharAt, false, 2, (Object) null)) {
                sb.append('\\');
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    /* JADX INFO: renamed from: com.squareup.wire.internal.Internal__InternalKt$sanitize$2 */
    /* JADX INFO: compiled from: Internal.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, m5598d2 = {"<anonymous>", "", "p1", "invoke"}, m5599k = 3, m5600mv = {1, 4, 0})
    static final /* synthetic */ class C44262 extends FunctionReference implements Function1<String, String> {
        public static final C44262 INSTANCE = new C44262();

        C44262() {
            super(1);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "sanitize";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinPackage(Internal.class, "wire-runtime");
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "sanitize(Ljava/lang/String;)Ljava/lang/String;";
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(String p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            return Internal.sanitize(p1);
        }
    }

    public static final String sanitize(List<String> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        return CollectionsKt.joinToString$default(values, null, "[", "]", 0, null, C44262.INSTANCE, 25, null);
    }

    public static final String boxedOneOfClassName(String oneOfName) {
        Intrinsics.checkNotNullParameter(oneOfName, "oneOfName");
        return StringsKt.capitalize(oneOfName);
    }

    public static final String boxedOneOfKeyFieldName(String oneOfName, String fieldName) {
        Intrinsics.checkNotNullParameter(oneOfName, "oneOfName");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        String str = oneOfName + "_" + fieldName;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = str.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    public static final String boxedOneOfKeysFieldName(String oneOfName) {
        Intrinsics.checkNotNullParameter(oneOfName, "oneOfName");
        String str = oneOfName + "_keys";
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = str.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: -redactElements, reason: not valid java name */
    public static final <K, V> Map<K, V> m6747redactElements(Map<K, ? extends V> redactElements, ProtoAdapter<V> adapter) {
        Intrinsics.checkNotNullParameter(redactElements, "$this$redactElements");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(redactElements.size()));
        Iterator<T> it2 = redactElements.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            linkedHashMap.put(entry.getKey(), adapter.redact(entry.getValue()));
        }
        return linkedHashMap;
    }
}
