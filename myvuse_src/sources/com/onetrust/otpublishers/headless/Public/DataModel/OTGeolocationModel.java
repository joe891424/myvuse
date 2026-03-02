package com.onetrust.otpublishers.headless.Public.DataModel;

/* JADX INFO: loaded from: classes6.dex */
public class OTGeolocationModel {
    public String country;
    public String state;

    public boolean compareLocation(String str) {
        if (str == null) {
            return false;
        }
        return str.equalsIgnoreCase(this.country) || str.equalsIgnoreCase(this.state);
    }
}
