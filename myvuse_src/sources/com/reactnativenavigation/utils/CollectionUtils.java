package com.reactnativenavigation.utils;

import androidx.core.util.Pair;
import com.reactnativenavigation.utils.Functions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class CollectionUtils {

    public interface Apply<T> {
        /* JADX INFO: renamed from: on */
        void mo2796on(T t);
    }

    public interface Comparator<T> {
        boolean compare(T t, T t2);
    }

    public interface Filter<T> {
        boolean filter(T t);
    }

    public interface KeyBy<K, V> {
        /* JADX INFO: renamed from: by */
        K mo2797by(V v);
    }

    public interface Mapper<T, S> {
        S map(T t);
    }

    public interface Reducer<S, T> {
        S reduce(T t, S s);
    }

    @SafeVarargs
    public static <T> List<T> asList(T... tArr) {
        final ArrayList arrayList = new ArrayList();
        forEach(tArr, new Apply() { // from class: com.reactnativenavigation.utils.CollectionUtils$$ExternalSyntheticLambda1
            @Override // com.reactnativenavigation.utils.CollectionUtils.Apply
            /* JADX INFO: renamed from: on */
            public final void mo2796on(Object obj) {
                CollectionUtils.lambda$asList$0(arrayList, obj);
            }
        });
        return arrayList;
    }

    static /* synthetic */ void lambda$asList$0(ArrayList arrayList, Object obj) {
        if (obj != null) {
            arrayList.add(obj);
        }
    }

    public static boolean isNullOrEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static <K, V> Map<K, V> keyBy(Collection<V> collection, KeyBy<K, V> keyBy) {
        HashMap map = new HashMap();
        for (V v : collection) {
            map.put(keyBy.mo2797by(v), v);
        }
        return map;
    }

    public static <T, S> ArrayList<S> map(Collection<T> collection, Mapper<T, S> mapper) {
        if (collection == null) {
            return null;
        }
        ArrayList<S> arrayList = new ArrayList<>();
        Iterator<T> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(mapper.map(it2.next()));
        }
        return arrayList;
    }

    public static <T> List<T> filter(Collection<T> collection, Filter<T> filter) {
        ArrayList arrayList = new ArrayList();
        for (T t : collection) {
            if (filter.filter(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static <K, V> V getOrDefault(Map<K, V> map, K k, Functions.FuncR<V> funcR) {
        if (map == null) {
            return funcR.run();
        }
        return map.containsKey(k) ? map.get(k) : funcR.run();
    }

    public static <T> List<T> merge(Collection<T> collection, Collection<T> collection2, List<T> list) {
        ArrayList arrayListMerge = merge(collection, collection2);
        return arrayListMerge == null ? list : arrayListMerge;
    }

    public static <T> ArrayList<T> merge(Collection<T> collection, Collection<T> collection2) {
        if (collection == null && collection2 == null) {
            return null;
        }
        ArrayList<T> arrayList = new ArrayList<>((Collection<? extends T>) get(collection));
        arrayList.addAll(get(collection2));
        return arrayList;
    }

    public static <T> List<T> difference(Collection<T> collection, final Collection<T> collection2, final Comparator<T> comparator) {
        if (collection2 == null) {
            return new ArrayList(collection);
        }
        final ArrayList arrayList = new ArrayList();
        forEach(collection, new Apply() { // from class: com.reactnativenavigation.utils.CollectionUtils$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.CollectionUtils.Apply
            /* JADX INFO: renamed from: on */
            public final void mo2796on(Object obj) {
                CollectionUtils.lambda$difference$1(collection2, comparator, arrayList, obj);
            }
        });
        return arrayList;
    }

    static /* synthetic */ void lambda$difference$1(Collection collection, Comparator comparator, ArrayList arrayList, Object obj) {
        if (contains(collection, obj, comparator)) {
            return;
        }
        arrayList.add(obj);
    }

    private static <T> boolean contains(Collection<T> collection, T t, Comparator<T> comparator) {
        Iterator<T> it2 = collection.iterator();
        while (it2.hasNext()) {
            if (comparator.compare(it2.next(), t)) {
                return true;
            }
        }
        return false;
    }

    public static <T> void forEach(Collection<T> collection, Apply<T> apply) {
        if (collection != null) {
            forEach(new ArrayList(collection), 0, apply);
        }
    }

    public static <T> void forEach(T[] tArr, Apply<T> apply) {
        if (tArr == null) {
            return;
        }
        for (T t : tArr) {
            apply.mo2796on(t);
        }
    }

    public static <T> void forEach(List<T> list, Apply<T> apply) {
        forEach(list, 0, apply);
    }

    public static <T> void forEach(List<T> list, int i, Apply<T> apply) {
        if (list == null) {
            return;
        }
        while (i < list.size()) {
            apply.mo2796on(list.get(i));
            i++;
        }
    }

    public static <T> void forEachIndexed(List<T> list, Functions.Func2<T, Integer> func2) {
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            func2.run(list.get(i), Integer.valueOf(i));
        }
    }

    public static <T> T first(Collection<T> collection, Filter<T> filter) {
        if (isNullOrEmpty(collection)) {
            return null;
        }
        for (T t : collection) {
            if (filter.filter(t)) {
                return t;
            }
        }
        return null;
    }

    public static <T> T first(Collection<T> collection, Filter<T> filter, Functions.Func1<T> func1) {
        if (isNullOrEmpty(collection)) {
            return null;
        }
        for (T t : collection) {
            if (filter.filter(t)) {
                func1.run(t);
                return t;
            }
        }
        return null;
    }

    public static <T> T last(List<T> list) {
        if (isNullOrEmpty(list)) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T> T requireLast(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> T removeLast(List<T> list) {
        return list.remove(list.size() - 1);
    }

    public static <S, T> S reduce(Collection<T> collection, S s, Reducer<S, T> reducer) {
        Iterator<T> it2 = collection.iterator();
        while (it2.hasNext()) {
            s = reducer.reduce(it2.next(), s);
        }
        return s;
    }

    public static <T> Boolean reduce(Collection<T> collection, boolean z, Functions.FuncR1<T, Boolean> funcR1) {
        if (isNullOrEmpty(collection)) {
            return Boolean.valueOf(z);
        }
        Iterator<T> it2 = collection.iterator();
        while (it2.hasNext()) {
            z &= funcR1.run(it2.next()).booleanValue();
            if (!z) {
                return false;
            }
        }
        return Boolean.valueOf(z);
    }

    public static <T> Collection<T> get(Collection<T> collection) {
        return collection == null ? Collections.emptyList() : collection;
    }

    public static <T> Collection<T> get(Map<?, T> map) {
        return map == null ? Collections.emptyList() : map.values();
    }

    public static <T> boolean equals(Collection<T> collection, Collection<T> collection2) {
        if (size(collection) != size(collection2)) {
            return false;
        }
        return ((Boolean) reduce(zip(collection, collection2), true, (Reducer<boolean, T>) new Reducer() { // from class: com.reactnativenavigation.utils.CollectionUtils$$ExternalSyntheticLambda2
            @Override // com.reactnativenavigation.utils.CollectionUtils.Reducer
            public final Object reduce(Object obj, Object obj2) {
                Pair pair = (Pair) obj;
                return Boolean.valueOf(((Boolean) obj2).booleanValue() && Objects.equals(pair.first, pair.second));
            }
        })).booleanValue();
    }

    public static int size(Collection collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public static <T> Collection<Pair<T, T>> zip(Collection<T> collection, Collection<T> collection2) {
        if (collection == null || collection2 == null) {
            return new ArrayList();
        }
        Iterator<T> it2 = collection.iterator();
        Iterator<T> it3 = collection2.iterator();
        ArrayList arrayList = new ArrayList();
        while (it2.hasNext() && it3.hasNext()) {
            arrayList.add(new Pair(it2.next(), it3.next()));
        }
        return arrayList;
    }

    public static <T> T safeGet(List<T> list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }
}
