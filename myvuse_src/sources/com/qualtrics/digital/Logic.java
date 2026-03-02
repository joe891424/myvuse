package com.qualtrics.digital;

import java.util.ArrayList;

/* JADX INFO: compiled from: InterceptJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class Logic extends LogicEvaluator {
    ArrayList<LogicSet> LogicSets;
    String Type;

    Logic(String str, ArrayList<LogicSet> arrayList) {
        this.Type = str;
        this.LogicSets = arrayList;
    }

    boolean evaluate() {
        ArrayList<LogicSet> arrayList = this.LogicSets;
        return arrayList == null || arrayList.size() == 0 || evaluateLogic(this.LogicSets);
    }
}
