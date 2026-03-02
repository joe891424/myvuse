package com.google.android.gms.common.data;

import java.util.ArrayList;
import java.util.Iterator;
import org.jose4j.json.internal.json_simple.JSONArray;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        JSONArray jSONArray = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            jSONArray.add(arrayList.get(i).freeze());
        }
        return jSONArray;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        JSONArray jSONArray = (ArrayList<T>) new ArrayList();
        Iterator<E> it2 = iterable.iterator();
        while (it2.hasNext()) {
            jSONArray.add(it2.next().freeze());
        }
        return jSONArray;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        JSONArray jSONArray = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            jSONArray.add(e.freeze());
        }
        return jSONArray;
    }
}
