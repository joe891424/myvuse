package com.qualtrics.digital;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: LogicUtil.java */
/* JADX INFO: loaded from: classes6.dex */
abstract class LogicEvaluator {
    LogicEvaluator() {
    }

    boolean evaluateLogic(ArrayList<? extends IEvaluable> arrayList) {
        if (arrayList.size() == 0) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (IEvaluable iEvaluable : arrayList) {
            if (iEvaluable.isBaseCondition() || iEvaluable.hasAndConjunction()) {
                arrayList3.add(iEvaluable);
            } else {
                if (!iEvaluable.hasOrConjunction()) {
                    return false;
                }
                arrayList2.add(new ArrayList(arrayList3));
                arrayList3 = new ArrayList();
                arrayList3.add(iEvaluable);
            }
        }
        arrayList2.add(new ArrayList(arrayList3));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            if (evaluateClause((ArrayList) it2.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean evaluateClause(ArrayList<? extends IEvaluable> arrayList) {
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator<? extends IEvaluable> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (!it2.next().evaluate()) {
                return false;
            }
        }
        return true;
    }
}
