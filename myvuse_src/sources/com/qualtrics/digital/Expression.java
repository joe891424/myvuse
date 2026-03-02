package com.qualtrics.digital;

/* JADX INFO: compiled from: Expressions.java */
/* JADX INFO: loaded from: classes6.dex */
abstract class Expression implements IEvaluable {
    private String Conjunction;
    private String Operator;
    private String Type;

    @Override // com.qualtrics.digital.IEvaluable
    public abstract boolean evaluate();

    Expression(String str, String str2, String str3) {
        this.Operator = str;
        this.Type = str2;
        this.Conjunction = str3;
    }

    String getOperator() {
        return this.Operator;
    }

    String getType() {
        return this.Type;
    }

    @Override // com.qualtrics.digital.IEvaluable
    public boolean hasAndConjunction() {
        return this.Conjunction.toLowerCase().equals("and");
    }

    @Override // com.qualtrics.digital.IEvaluable
    public boolean hasOrConjunction() {
        return this.Conjunction.toLowerCase().equals("or");
    }

    @Override // com.qualtrics.digital.IEvaluable
    public boolean isBaseCondition() {
        return this.Conjunction == null;
    }
}
