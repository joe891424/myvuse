package com.qualtrics.digital;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: compiled from: Expressions.java */
/* JADX INFO: loaded from: classes6.dex */
class DayExpression extends Expression {
    private final String DATE_FORMAT;
    private String LeftOperand;
    private String TimeZone;

    DayExpression(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3);
        this.DATE_FORMAT = "EEE";
        this.LeftOperand = str4;
        this.TimeZone = str5;
    }

    @Override // com.qualtrics.digital.Expression, com.qualtrics.digital.IEvaluable
    public boolean evaluate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE");
        Calendar calendar = Calendar.getInstance();
        String str = this.TimeZone;
        if (str != null) {
            calendar.setTimeZone(TimeZone.getTimeZone(str));
            calendar.setTime(new Date());
        }
        boolean zEquals = simpleDateFormat.format(calendar.getTime()).equals(this.LeftOperand);
        if (getOperator().toLowerCase().equals("is")) {
            return zEquals;
        }
        if (getOperator().toLowerCase().equals("isnot")) {
            return !zEquals;
        }
        LogInstrumentation.m2728e("Qualtrics", "Unexpected day operator: " + getOperator());
        return false;
    }
}
