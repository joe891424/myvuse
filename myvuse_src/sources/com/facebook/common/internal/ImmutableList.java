package com.facebook.common.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ImmutableList<E> extends ArrayList<E> {
    private ImmutableList(int i) {
        super(i);
    }

    private ImmutableList(List<E> list) {
        super(list);
    }

    public static <E> ImmutableList<E> copyOf(List<E> list) {
        return new ImmutableList<>(list);
    }

    /* JADX INFO: renamed from: of */
    public static <E> ImmutableList<E> m1247of(E... eArr) {
        ImmutableList<E> immutableList = new ImmutableList<>(eArr.length);
        Collections.addAll(immutableList, eArr);
        return immutableList;
    }
}
