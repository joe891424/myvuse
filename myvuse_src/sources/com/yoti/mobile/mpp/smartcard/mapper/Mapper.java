package com.yoti.mobile.mpp.smartcard.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Mapper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007J\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/mpp/smartcard/mapper/Mapper;", "T1", "T2", "", "()V", "map", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "values", "smartcard-common"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class Mapper<T1, T2> {
    public abstract T2 map(T1 value);

    /* JADX WARN: Multi-variable type inference failed */
    public final Collection<T2> map(Collection<? extends T1> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        Collection<? extends T1> collection = values;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(map(it2.next()));
        }
        return CollectionsKt.toList(arrayList);
    }
}
