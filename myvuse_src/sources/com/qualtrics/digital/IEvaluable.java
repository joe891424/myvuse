package com.qualtrics.digital;

/* JADX INFO: compiled from: LogicUtil.java */
/* JADX INFO: loaded from: classes6.dex */
interface IEvaluable {
    boolean evaluate();

    boolean hasAndConjunction();

    boolean hasOrConjunction();

    boolean isBaseCondition();
}
