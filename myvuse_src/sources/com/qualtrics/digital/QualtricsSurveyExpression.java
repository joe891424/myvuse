package com.qualtrics.digital;

/* JADX INFO: compiled from: Expressions.java */
/* JADX INFO: loaded from: classes6.dex */
class QualtricsSurveyExpression extends Expression {
    public static final long TIME_BETWEEN_SURVEYS = 15552000000L;
    private String SurveyID;
    private Properties properties;

    QualtricsSurveyExpression(String str, String str2, String str3, String str4) {
        super(str, str2, str3);
        this.SurveyID = str4;
        this.properties = Qualtrics.instance().properties;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059 A[Catch: NullPointerException -> 0x005e, TRY_LEAVE, TryCatch #0 {NullPointerException -> 0x005e, blocks: (B:3:0x0005, B:17:0x003e, B:18:0x0053, B:20:0x0059, B:8:0x0025, B:11:0x002f), top: B:24:0x0005 }] */
    @Override // com.qualtrics.digital.Expression, com.qualtrics.digital.IEvaluable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean evaluate() {
        /*
            r9 = this;
            java.lang.String r0 = "Qualtrics"
            java.lang.String r1 = "Unexpected variable operator: "
            r2 = 0
            com.qualtrics.digital.Properties r3 = r9.properties     // Catch: java.lang.NullPointerException -> L5e
            java.lang.String r4 = r9.SurveyID     // Catch: java.lang.NullPointerException -> L5e
            long r3 = r3.getSurveyHasBeenTaken(r4)     // Catch: java.lang.NullPointerException -> L5e
            java.lang.String r5 = r9.getOperator()     // Catch: java.lang.NullPointerException -> L5e
            java.lang.String r5 = r5.toLowerCase()     // Catch: java.lang.NullPointerException -> L5e
            int r6 = r5.hashCode()     // Catch: java.lang.NullPointerException -> L5e
            r7 = -1493909823(0xffffffffa6f4bec1, float:-1.6982605E-15)
            r8 = 1
            if (r6 == r7) goto L2f
            r7 = 686969410(0x28f25242, float:2.690307E-14)
            if (r6 == r7) goto L25
            goto L39
        L25:
            java.lang.String r6 = "hasnotbeentaken"
            boolean r5 = r5.equals(r6)     // Catch: java.lang.NullPointerException -> L5e
            if (r5 == 0) goto L39
            r5 = r8
            goto L3a
        L2f:
            java.lang.String r6 = "hasbeentaken"
            boolean r5 = r5.equals(r6)     // Catch: java.lang.NullPointerException -> L5e
            if (r5 == 0) goto L39
            r5 = r2
            goto L3a
        L39:
            r5 = -1
        L3a:
            if (r5 == 0) goto L59
            if (r5 == r8) goto L53
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.NullPointerException -> L5e
            r3.<init>(r1)     // Catch: java.lang.NullPointerException -> L5e
            java.lang.String r1 = r9.getOperator()     // Catch: java.lang.NullPointerException -> L5e
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch: java.lang.NullPointerException -> L5e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.NullPointerException -> L5e
            com.newrelic.agent.android.instrumentation.LogInstrumentation.m2728e(r0, r1)     // Catch: java.lang.NullPointerException -> L5e
            goto L72
        L53:
            boolean r0 = r9.surveyHasBeenTaken(r3)     // Catch: java.lang.NullPointerException -> L5e
            r0 = r0 ^ r8
            return r0
        L59:
            boolean r0 = r9.surveyHasBeenTaken(r3)     // Catch: java.lang.NullPointerException -> L5e
            return r0
        L5e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Unable to evaluate QualtricsSurveyExpression for "
            r1.<init>(r3)
            java.lang.String r3 = r9.SurveyID
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.newrelic.agent.android.instrumentation.LogInstrumentation.m2728e(r0, r1)
        L72:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qualtrics.digital.QualtricsSurveyExpression.evaluate():boolean");
    }

    private boolean surveyHasBeenTaken(long j) {
        if (j == 0 || j + TIME_BETWEEN_SURVEYS > System.currentTimeMillis()) {
            return j != 0;
        }
        this.properties.removeSurveyHasBeenTaken(this.SurveyID);
        return false;
    }
}
