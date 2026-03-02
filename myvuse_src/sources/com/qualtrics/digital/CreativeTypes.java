package com.qualtrics.digital;

/* JADX INFO: compiled from: CreativeJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class CreativeTypes {
    static final String MOBILE_EMBEDDED_FEEDBACK = "MobileEmbeddedFeedback";
    static final String NOTIFICATION = "MobileNotification";
    static final String POPOVER = "MobilePopOver";

    CreativeTypes() {
    }

    static CreativeType getCreativeTypeFromName(String str) {
        str.hashCode();
        switch (str) {
            case "MobileEmbeddedFeedback":
                return CreativeType.MobileEmbeddedFeedback;
            case "MobileNotification":
                return CreativeType.MobileNotification;
            case "MobilePopOver":
                return CreativeType.MobilePopOver;
            default:
                QualtricsLog.logError("Creative JSON contains invalid type");
                return null;
        }
    }
}
