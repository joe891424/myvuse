package com.qualtrics.digital;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class ViewCounter {
    private static ViewCounter mInstance;
    private HashMap<String, Integer> mViewsVisitedMap = new HashMap<>();

    ViewCounter() {
    }

    public static ViewCounter instance() {
        if (mInstance == null) {
            mInstance = new ViewCounter();
        }
        return mInstance;
    }

    void registerViewVisit(String str) {
        this.mViewsVisitedMap.put(str, Integer.valueOf((this.mViewsVisitedMap.containsKey(str) ? this.mViewsVisitedMap.get(str).intValue() : 0) + 1));
    }

    public int getTotalViewsVisited() {
        Iterator<Integer> it2 = this.mViewsVisitedMap.values().iterator();
        int iIntValue = 0;
        while (it2.hasNext()) {
            iIntValue += it2.next().intValue();
        }
        return iIntValue;
    }

    public int getUniqueViewsVisited() {
        return this.mViewsVisitedMap.keySet().size();
    }

    void reset() {
        this.mViewsVisitedMap = new HashMap<>();
    }
}
