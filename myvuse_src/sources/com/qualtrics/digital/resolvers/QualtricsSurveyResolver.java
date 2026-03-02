package com.qualtrics.digital.resolvers;

import com.qualtrics.digital.Properties;
import com.qualtrics.digital.Qualtrics;

/* JADX INFO: loaded from: classes6.dex */
public class QualtricsSurveyResolver {
    static final long TIME_BETWEEN_SURVEYS = 15552000000L;
    String mSurveyID;
    private final Properties properties = Qualtrics.instance().properties;

    public QualtricsSurveyResolver(String str) {
        this.mSurveyID = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean evaluateQualtricsSurvey(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "Qualtrics"
            java.lang.String r1 = "Unexpected variable operator: "
            r2 = 0
            com.qualtrics.digital.Properties r3 = r8.properties     // Catch: java.lang.NullPointerException -> L52
            java.lang.String r4 = r8.mSurveyID     // Catch: java.lang.NullPointerException -> L52
            long r3 = r3.getSurveyHasBeenTaken(r4)     // Catch: java.lang.NullPointerException -> L52
            int r5 = r9.hashCode()     // Catch: java.lang.NullPointerException -> L52
            r6 = -1959833159(0xffffffff8b2f51b9, float:-3.3765255E-32)
            r7 = 1
            if (r5 == r6) goto L27
            r6 = 673079365(0x281e6045, float:8.791637E-15)
            if (r5 == r6) goto L1d
            goto L31
        L1d:
            java.lang.String r5 = "HAS_NOT_BEEN_TAKEN"
            boolean r5 = r9.equals(r5)     // Catch: java.lang.NullPointerException -> L52
            if (r5 == 0) goto L31
            r5 = r7
            goto L32
        L27:
            java.lang.String r5 = "HAS_BEEN_TAKEN"
            boolean r5 = r9.equals(r5)     // Catch: java.lang.NullPointerException -> L52
            if (r5 == 0) goto L31
            r5 = r2
            goto L32
        L31:
            r5 = -1
        L32:
            if (r5 == 0) goto L4d
            if (r5 == r7) goto L47
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.NullPointerException -> L52
            r3.<init>(r1)     // Catch: java.lang.NullPointerException -> L52
            java.lang.StringBuilder r9 = r3.append(r9)     // Catch: java.lang.NullPointerException -> L52
            java.lang.String r9 = r9.toString()     // Catch: java.lang.NullPointerException -> L52
            com.newrelic.agent.android.instrumentation.LogInstrumentation.m2728e(r0, r9)     // Catch: java.lang.NullPointerException -> L52
            return r2
        L47:
            boolean r9 = r8.surveyHasBeenTaken(r3)     // Catch: java.lang.NullPointerException -> L52
            r9 = r9 ^ r7
            return r9
        L4d:
            boolean r9 = r8.surveyHasBeenTaken(r3)     // Catch: java.lang.NullPointerException -> L52
            return r9
        L52:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r1 = "Unable to evaluate Qualtrics Survey Expression for "
            r9.<init>(r1)
            java.lang.String r1 = r8.mSurveyID
            java.lang.StringBuilder r9 = r9.append(r1)
            java.lang.String r9 = r9.toString()
            com.newrelic.agent.android.instrumentation.LogInstrumentation.m2728e(r0, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qualtrics.digital.resolvers.QualtricsSurveyResolver.evaluateQualtricsSurvey(java.lang.String):boolean");
    }

    private boolean surveyHasBeenTaken(long j) {
        if (j == 0 || j + 15552000000L > System.currentTimeMillis()) {
            return j != 0;
        }
        this.properties.removeSurveyHasBeenTaken(this.mSurveyID);
        return false;
    }
}
