package com.qualtrics.digital;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: Expressions.java */
/* JADX INFO: loaded from: classes6.dex */
class TimeExpression extends Expression {
    private String LeftOperand;
    private String TimeZone;

    TimeExpression(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3);
        this.LeftOperand = str4;
        this.TimeZone = str5;
    }

    @Override // com.qualtrics.digital.Expression, com.qualtrics.digital.IEvaluable
    public boolean evaluate() {
        try {
            String[] strArrSplit = this.LeftOperand.split(":");
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(11, Integer.parseInt(strArrSplit[0]));
            calendar2.set(12, Integer.parseInt(strArrSplit[1]));
            String str = this.TimeZone;
            if (str != null) {
                calendar2.setTimeZone(TimeZone.getTimeZone(str));
            }
            long timeInMillis = calendar2.getTimeInMillis() - calendar.getTimeInMillis();
            if (getOperator().toLowerCase().equals("isbefore")) {
                return timeInMillis > 1000;
            }
            if (getOperator().toLowerCase().equals("isafter")) {
                return timeInMillis < -1000;
            }
            LogInstrumentation.m2728e("Qualtrics", "Unexpected time operator: " + getOperator());
        } catch (NumberFormatException unused) {
            LogInstrumentation.m2728e("Qualtrics", "Unexpected time number format: " + this.LeftOperand);
        }
        return false;
    }
}
