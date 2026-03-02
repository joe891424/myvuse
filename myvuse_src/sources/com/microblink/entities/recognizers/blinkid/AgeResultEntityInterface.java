package com.microblink.entities.recognizers.blinkid;

import com.microblink.results.date.Date;
import com.microblink.results.date.DateResult;
import com.microblink.results.date.DateUtils;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class AgeResultEntityInterface {
    public static final String CLASS_NAME = "com.microblink.entities.recognizers.blinkid.AgeResultEntityInterface";

    public int getAge() {
        Date date = getDateOfBirth().getDate();
        if (date == null) {
            return -1;
        }
        return DateUtils.yearsPassedFrom(date);
    }

    public AgeLimitStatus getAgeLimitStatus(int i) {
        int age = getAge();
        return age == -1 ? AgeLimitStatus.NotAvailable : age >= i ? AgeLimitStatus.OverAgeLimit : AgeLimitStatus.BelowAgeLimit;
    }

    public DateResult getDateOfBirth() {
        return null;
    }
}
