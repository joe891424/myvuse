package com.qualtrics.digital;

import com.qualtrics.digital.resolvers.CustomPropertyResolver;
import com.qualtrics.digital.resolvers.DateTimeTypeResolvers;
import com.qualtrics.digital.resolvers.QualtricsSurveyResolver;
import com.qualtrics.digital.resolvers.SamplingResolver;
import com.qualtrics.digital.resolvers.TimeSpentInAppResolver;
import com.qualtrics.digital.resolvers.ViewCountResolver;

/* JADX INFO: compiled from: InterceptJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class ComparatorNode {
    ComparatorNode() {
    }

    public static boolean evaluate(String str, String str2, Object obj, String str3) {
        if (obj == null) {
            obj = "";
        }
        str.hashCode();
        switch (str) {
            case "TimeSpentInApp":
                return new TimeSpentInAppResolver().evaluateTimeSpentInApp(str3, obj.toString());
            case "CustomPropertyDate":
            case "CustomPropertyText":
            case "CustomPropertyNumber":
                return CustomPropertyResolver.evaluateCustomProperty(str, str3, str2, obj.toString());
            case "QualtricsSurvey":
                return new QualtricsSurveyResolver(str2).evaluateQualtricsSurvey(str3);
            case "ViewCount":
                new ViewCountResolver();
                return ViewCountResolver.evaluateViewCount(str3, obj.toString(), str2);
            case "DateTimeDate":
            case "DateTimeTime":
            case "DateTimeDay":
                return DateTimeTypeResolvers.evaluateDateTime(str, str3, obj.toString(), str2);
            case "Sampling":
                return new SamplingResolver().evaluateSampling(str2);
            default:
                return false;
        }
    }
}
