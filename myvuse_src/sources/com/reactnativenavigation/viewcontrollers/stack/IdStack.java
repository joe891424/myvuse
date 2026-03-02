package com.reactnativenavigation.viewcontrollers.stack;

import com.reactnativenavigation.utils.CollectionUtils;
import com.reactnativenavigation.utils.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class IdStack<E> implements Iterable<String> {
    private final ArrayList<String> deque = new ArrayList<>();
    private final Map<String, E> map = new HashMap();

    public void push(String str, E e) {
        this.deque.add(str);
        this.map.put(str, e);
    }

    public void set(String str, E e, int i) {
        this.deque.add(i, str);
        this.map.put(str, e);
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.map.get(CollectionUtils.last(this.deque));
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return this.map.remove(CollectionUtils.removeLast(this.deque));
    }

    public boolean isEmpty() {
        return this.deque.isEmpty();
    }

    public int size() {
        return this.deque.size();
    }

    public String peekId() {
        return (String) CollectionUtils.last(this.deque);
    }

    public void clear() {
        this.deque.clear();
        this.map.clear();
    }

    public E get(String str) {
        return this.map.get(str);
    }

    public E get(int i) {
        return this.map.get(this.deque.get(i));
    }

    public boolean containsId(String str) {
        return this.deque.contains(str);
    }

    public E remove(String str) {
        if (!containsId(str)) {
            return null;
        }
        this.deque.remove(str);
        return this.map.remove(str);
    }

    public boolean isTop(String str) {
        return StringUtils.isEqual(str, peekId());
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.deque.iterator();
    }

    public List<E> values() {
        ArrayList<String> arrayList = this.deque;
        final Map<String, E> map = this.map;
        Objects.requireNonNull(map);
        return CollectionUtils.map(arrayList, new CollectionUtils.Mapper() { // from class: com.reactnativenavigation.viewcontrollers.stack.IdStack$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.CollectionUtils.Mapper
            public final Object map(Object obj) {
                return map.get((String) obj);
            }
        });
    }

    public void remove(Iterator<String> it2, String str) {
        it2.remove();
        this.map.remove(str);
    }
}
