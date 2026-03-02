package com.qualtrics.digital;

import com.yoti.mobile.android.remote.RemoteDefsKt;

/* JADX INFO: compiled from: Expressions.java */
/* JADX INFO: loaded from: classes6.dex */
class DateExpression extends Expression {
    private final String DATE_FORMAT;
    private String LeftOperand;
    private String TimeZone;

    DateExpression(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3);
        this.DATE_FORMAT = RemoteDefsKt.DATE_FORMAT;
        this.LeftOperand = str4;
        this.TimeZone = str5;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    @Override // com.qualtrics.digital.Expression, com.qualtrics.digital.IEvaluable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean evaluate() {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qualtrics.digital.DateExpression.evaluate():boolean");
    }
}
