package com.qualtrics.digital.resolvers;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.qualtrics.digital.Properties;
import com.qualtrics.digital.Qualtrics;
import java.util.Date;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class CustomPropertyResolver {
    private static Properties properties = Qualtrics.instance().properties;

    CustomPropertyResolver() {
        properties = Qualtrics.instance().properties;
    }

    public static boolean evaluateCustomProperty(String str, String str2, String str3, String str4) {
        str.hashCode();
        switch (str) {
            case "CustomPropertyDate":
                return evaluateCustomPropertyDate(str2, str3, str4);
            case "CustomPropertyText":
                return evaluateCustomPropertyText(str2, str3, str4);
            case "CustomPropertyNumber":
                return evaluateCustomPropertyNumber(str2, str3, str4);
            default:
                LogInstrumentation.m2728e("Qualtrics", "Error, unexpected custom property type: " + str);
                return false;
        }
    }

    public static boolean evaluateCustomPropertyText(String str, String str2, String str3) {
        str.hashCode();
        switch (str) {
            case "NOT_CONTAINS":
                String string = properties.getString(str2);
                return (string == null || string.contains(str3)) ? false : true;
            case "EQ":
                return getNumberOrTextEquality(str2, str3);
            case "NEQ":
                return getNumberOrTextInequality(str2, str3);
            case "REGEX":
                if (str3.length() == 0) {
                    return false;
                }
                try {
                    return Pattern.compile(str3).matcher(properties.getString(str2)).find();
                } catch (Exception unused) {
                    return false;
                }
            case "CONTAINS":
                String string2 = properties.getString(str2);
                if (string2 == null) {
                    return false;
                }
                return string2.contains(str3);
            case "NOT_EMPTY":
                return isNotEmpty(str2);
            case "IS_EMPTY":
                return isEmpty(str2);
            default:
                LogInstrumentation.m2728e("Qualtrics", "Error, unexpected variable operator: " + str);
                return false;
        }
    }

    public static boolean evaluateCustomPropertyNumber(String str, String str2, String str3) {
        str.hashCode();
        switch (str) {
            case "EQ":
                return getNumberOrTextEquality(str2, str3);
            case "GT":
                Double number = properties.getNumber(str2);
                if (number != null) {
                    return number.doubleValue() > Double.valueOf(Double.parseDouble(str3)).doubleValue();
                }
                return false;
            case "LT":
                Double number2 = properties.getNumber(str2);
                if (number2 != null) {
                    return number2.doubleValue() < Double.valueOf(Double.parseDouble(str3)).doubleValue();
                }
                return false;
            case "GTE":
                Double number3 = properties.getNumber(str2);
                if (number3 != null) {
                    return number3.doubleValue() >= Double.valueOf(Double.parseDouble(str3)).doubleValue();
                }
                return false;
            case "LTE":
                Double number4 = properties.getNumber(str2);
                if (number4 != null) {
                    return number4.doubleValue() <= Double.valueOf(Double.parseDouble(str3)).doubleValue();
                }
                return false;
            case "NEQ":
                return getNumberOrTextInequality(str2, str3);
            case "NOT_EMPTY":
                return isNotEmpty(str2);
            case "IS_EMPTY":
                return isEmpty(str2);
            default:
                LogInstrumentation.m2728e("Qualtrics", "Error, unexpected variable operator: " + str);
                return false;
        }
    }

    private static boolean getNumberOrTextEquality(String str, String str2) {
        String string = properties.getString(str);
        return string != null && string.equals(str2);
    }

    private static boolean getNumberOrTextInequality(String str, String str2) {
        String string = properties.getString(str);
        return (string == null || string.equals(str2)) ? false : true;
    }

    private static boolean isEmpty(String str) {
        return properties.getString(str) == null;
    }

    private static boolean isNotEmpty(String str) {
        return properties.getString(str) != null;
    }

    private static boolean evaluateCustomPropertyDate(String str, String str2, String str3) {
        str.hashCode();
        switch (str) {
            case "EQ":
                Long dateTime = properties.getDateTime(str2);
                if (dateTime != null) {
                    return getSecondsInDays(Long.valueOf((new Date().getTime() / 1000) - dateTime.longValue())) == Long.valueOf(Long.parseLong(str3)).longValue();
                }
                return false;
            case "GT":
                Long dateTime2 = properties.getDateTime(str2);
                if (dateTime2 != null) {
                    return (new Date().getTime() / 1000) - dateTime2.longValue() > getDaysInSeconds(Long.valueOf(Long.parseLong(str3))).longValue();
                }
                return false;
            case "LT":
                Long dateTime3 = properties.getDateTime(str2);
                if (dateTime3 != null) {
                    return (new Date().getTime() / 1000) - dateTime3.longValue() < getDaysInSeconds(Long.valueOf(Long.parseLong(str3))).longValue();
                }
                return false;
            case "NOT_EMPTY":
                return isNotEmpty(str2);
            case "IS_EMPTY":
                return isEmpty(str2);
            default:
                LogInstrumentation.m2728e("Qualtrics", "Error, unexpected variable operator: " + str);
                return false;
        }
    }

    private static long getSecondsInDays(Long l) {
        return ((l.longValue() / 60) / 60) / 24;
    }

    private static Long getDaysInSeconds(Long l) {
        return Long.valueOf(l.longValue() * 86400);
    }
}
