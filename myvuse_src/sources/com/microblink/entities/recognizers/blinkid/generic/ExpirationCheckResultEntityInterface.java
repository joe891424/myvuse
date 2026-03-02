package com.microblink.entities.recognizers.blinkid.generic;

import com.microblink.results.date.Date;
import com.microblink.results.date.DateResult;
import com.microblink.results.date.DateUtils;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class ExpirationCheckResultEntityInterface {
    public static final String CLASS_NAME = "com.microblink.entities.recognizers.blinkid.generic.ExpirationCheckResultEntityInterface";

    public DateResult getDateOfExpiry() {
        return null;
    }

    public boolean isDateOfExpiryPermanent() {
        return false;
    }

    public boolean isExpired() {
        Date date;
        if (isDateOfExpiryPermanent() || (date = getDateOfExpiry().getDate()) == null) {
            return false;
        }
        return DateUtils.isDatePassed(date);
    }
}
