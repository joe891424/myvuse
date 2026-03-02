package com.salesforce.marketingcloud.messages;

import com.salesforce.marketingcloud.messages.geofence.GeofenceMessageResponse;
import com.salesforce.marketingcloud.messages.proximity.ProximityMessageResponse;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes6.dex */
public interface RegionMessageManager {
    public static final String BUNDLE_KEY_MESSAGING_ENABLED = "com.salesforce.marketingcloud.messaging.ENABLED";

    public interface GeofenceMessageResponseListener {
        void onGeofenceMessageResponse(GeofenceMessageResponse geofenceMessageResponse);
    }

    public interface ProximityMessageResponseListener {
        void onProximityMessageResponse(ProximityMessageResponse proximityMessageResponse);
    }

    public interface RegionTransitionEventListener {
        public static final int TRANSITION_ENTERED = 1;
        public static final int TRANSITION_EXITED = 2;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.RegionMessageManager$RegionTransitionEventListener$a */
        @Retention(RetentionPolicy.SOURCE)
        public @interface InterfaceC4232a {
        }

        void onTransitionEvent(int i, Region region);
    }

    void disableGeofenceMessaging();

    void disableProximityMessaging();

    boolean enableGeofenceMessaging();

    boolean enableProximityMessaging();

    boolean isGeofenceMessagingEnabled();

    boolean isProximityMessagingEnabled();

    void registerGeofenceMessageResponseListener(GeofenceMessageResponseListener geofenceMessageResponseListener);

    void registerProximityMessageResponseListener(ProximityMessageResponseListener proximityMessageResponseListener);

    void registerRegionTransitionEventListener(RegionTransitionEventListener regionTransitionEventListener);

    void unregisterGeofenceMessageResponseListener(GeofenceMessageResponseListener geofenceMessageResponseListener);

    void unregisterProximityMessageResponseListener(ProximityMessageResponseListener proximityMessageResponseListener);

    void unregisterRegionTransitionEventListener(RegionTransitionEventListener regionTransitionEventListener);
}
