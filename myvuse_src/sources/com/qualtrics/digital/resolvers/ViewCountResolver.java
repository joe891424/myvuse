package com.qualtrics.digital.resolvers;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.qualtrics.digital.ViewCounter;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class ViewCountResolver {
    private static String TOTAL_VIEWS = "Total";
    private static String UNIQUE_VIEWS = "Unique";

    public static boolean evaluateViewCount(String str, String str2, String str3) {
        Integer numValueOf;
        HashMap map;
        Integer numValueOf2 = Integer.valueOf(ViewCounter.instance().getTotalViewsVisited());
        Integer numValueOf3 = Integer.valueOf(ViewCounter.instance().getUniqueViewsVisited());
        try {
            numValueOf = Integer.valueOf(Integer.parseInt(str2));
        } catch (Exception unused) {
            LogInstrumentation.m2728e("Qualtrics", "Error, unexpected variable rightValue: " + str2);
            numValueOf = null;
        }
        map = new HashMap();
        map.put(TOTAL_VIEWS, numValueOf2);
        map.put(UNIQUE_VIEWS, numValueOf3);
        str.hashCode();
        switch (str) {
            case "EQ":
                if (map.containsKey(str3)) {
                    break;
                }
                break;
            case "GT":
                if (!map.containsKey(str3) || ((Integer) map.get(str3)).intValue() <= numValueOf.intValue()) {
                    break;
                }
                break;
            case "LT":
                if (!map.containsKey(str3) || ((Integer) map.get(str3)).intValue() >= numValueOf.intValue()) {
                    break;
                }
                break;
            case "GTE":
                if (!map.containsKey(str3) || ((Integer) map.get(str3)).intValue() < numValueOf.intValue()) {
                    break;
                }
                break;
            case "LTE":
                if (!map.containsKey(str3) || ((Integer) map.get(str3)).intValue() > numValueOf.intValue()) {
                    break;
                }
                break;
            case "NEQ":
                if (!map.containsKey(str3) || ((Integer) map.get(str3)).equals(numValueOf)) {
                    break;
                }
                break;
            default:
                LogInstrumentation.m2728e("Qualtrics", "Error, unexpected variable operator: " + str);
                break;
        }
        return false;
    }
}
