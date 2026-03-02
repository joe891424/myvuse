package com.qualtrics.digital;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: compiled from: Expressions.java */
/* JADX INFO: loaded from: classes6.dex */
class VariableExpression extends Expression {
    private String Key;
    private String PropertyType;
    private String RightOperand;
    private Properties properties;

    private double getDaysInMilliseconds(double d) {
        return d * 24.0d * 60.0d * 60.0d * 1000.0d;
    }

    VariableExpression(String str, String str2, String str3, String str4, String str5, String str6) {
        super(str, str2, str3);
        this.Key = str4;
        this.RightOperand = str5;
        this.PropertyType = str6;
        this.properties = Qualtrics.instance().properties;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x009b  */
    @Override // com.qualtrics.digital.Expression, com.qualtrics.digital.IEvaluable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean evaluate() {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qualtrics.digital.VariableExpression.evaluate():boolean");
    }

    private boolean evaluateDatePropertyType() {
        Long dateTime;
        dateTime = this.properties.getDateTime(this.Key);
        String lowerCase = getOperator().toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "equalto":
                if (dateTime == null || getMillisecondsInDays(System.currentTimeMillis() - dateTime.longValue()) != Double.parseDouble(this.RightOperand)) {
                }
                break;
            case "empty":
                if (dateTime != null) {
                    break;
                }
                break;
            case "greaterthan":
                if (dateTime == null || System.currentTimeMillis() - dateTime.longValue() <= getDaysInMilliseconds(Double.parseDouble(this.RightOperand))) {
                }
                break;
            case "notempty":
                if (dateTime == null) {
                    break;
                }
                break;
            case "lessthan":
                if (dateTime == null || System.currentTimeMillis() - dateTime.longValue() >= getDaysInMilliseconds(Double.parseDouble(this.RightOperand))) {
                }
                break;
            default:
                LogInstrumentation.m2728e("Qualtrics", "Unexpected variable operator: " + getOperator());
                break;
        }
        return false;
    }

    private double getMillisecondsInDays(double d) {
        return Math.floor((((((((d * 1.0d) / 1000.0d) * 1.0d) / 60.0d) * 1.0d) / 60.0d) * 1.0d) / 24.0d);
    }
}
