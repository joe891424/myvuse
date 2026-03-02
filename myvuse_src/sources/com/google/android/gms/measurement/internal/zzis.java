package com.google.android.gms.measurement.internal;

import com.android.vending.expansion.zipfile.APEZProvider;
import com.google.firebase.messaging.Constants;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.yoti.mobile.android.remote.RemoteDefsKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzis {
    public static final String[] zza = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "last_advertising_id_reset", "first_open_after_install", "lifetime_user_engagement", "session_user_engagement", "non_personalized_ads", "ga_session_number", "ga_session_id", "last_gclid", "deep_link_gclid", "market_referrer_gclid", "gbraid", "deep_link_gbraid", "market_referrer_gbraid", "session_number", RemoteDefsKt.PATH_SESSION_ID_KEY};
    public static final String[] zzb = {Constants.ScionAnalytics.USER_PROPERTY_FIREBASE_LAST_NOTIFICATION, "_fot", "_fvt", "_ldl", APEZProvider.FILEID, "_lair", "_fi", "_lte", "_se", "_npa", "_sno", NotificationMessage.NOTIF_KEY_SID, "_lgclid", "_dl_gclid", "_mr_gclid", "_gbraid", "_dl_gbraid", "_mr_gbraid", "_sno", NotificationMessage.NOTIF_KEY_SID};

    public static String zza(String str) {
        return zzkq.zza(str, zza, zzb);
    }
}
