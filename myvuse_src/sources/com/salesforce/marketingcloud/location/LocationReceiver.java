package com.salesforce.marketingcloud.location;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.location.LocationResult;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.util.C4389h;
import com.salesforce.marketingcloud.util.C4393l;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class LocationReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    private static final String f4962a = "com.salesforce.marketingcloud.LOCATION_UPDATE";

    /* JADX INFO: renamed from: b */
    private static final String f4963b = "com.salesforce.marketingcloud.GEOFENCE_TRIGGERED";

    /* JADX INFO: renamed from: c */
    private static final String f4964c = C4170g.m3197a("LocationReceiver");

    /* JADX INFO: renamed from: a */
    static boolean m3453a(Context context) {
        return C4389h.m4321a(context.getPackageManager(), new Intent(context, (Class<?>) LocationReceiver.class));
    }

    /* JADX INFO: renamed from: b */
    static PendingIntent m3454b(Context context) {
        return PendingIntent.getBroadcast(context, 1, new Intent(context, (Class<?>) LocationReceiver.class).setAction(f4963b), C4393l.m4345b(134217728));
    }

    /* JADX INFO: renamed from: c */
    static PendingIntent m3455c(Context context) {
        return PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) LocationReceiver.class).setAction(f4962a), C4393l.m4345b(134217728));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String str = f4964c;
        C4170g.m3213d(str, "onReceive - %s", intent.getAction());
        if (!C4393l.m4342a(500L, 50L) || MarketingCloudSdk.getInstance() == null) {
            C4170g.m3216e(str, "MarketingCloudSdk#init must be called in your application's onCreate", new Object[0]);
            return;
        }
        String action = intent.getAction();
        action.hashCode();
        if (action.equals(f4963b)) {
            m3451a(context, GeofencingEvent.fromIntent(intent));
        } else if (action.equals(f4962a)) {
            m3452a(context, LocationResult.extractResult(intent));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3451a(Context context, GeofencingEvent geofencingEvent) {
        LocalBroadcastManager localBroadcastManager;
        Intent intentM3487a;
        if (geofencingEvent == null) {
            C4170g.m3213d(f4964c, "Geofencing event was null.", new Object[0]);
            return;
        }
        if (geofencingEvent.hasError()) {
            String statusCodeString = GeofenceStatusCodes.getStatusCodeString(geofencingEvent.getErrorCode());
            C4170g.m3202a(f4964c, "Geofencing event contained error: %s", statusCodeString);
            localBroadcastManager = LocalBroadcastManager.getInstance(context);
            intentM3487a = AbstractC4200f.m3486a(geofencingEvent.getErrorCode(), statusCodeString);
        } else {
            if (geofencingEvent.getTriggeringGeofences() == null || geofencingEvent.getTriggeringGeofences().isEmpty()) {
                C4170g.m3202a(f4964c, "GeofencingEvent without triggering geofences.", new Object[0]);
                return;
            }
            int geofenceTransition = geofencingEvent.getGeofenceTransition();
            C4170g.m3213d(f4964c, "Geofencing event transition: %d", Integer.valueOf(geofenceTransition));
            ArrayList arrayList = new ArrayList();
            for (Geofence geofence : geofencingEvent.getTriggeringGeofences()) {
                C4170g.m3213d(f4964c, "Triggered fence id: %s", geofence.getRequestId());
                arrayList.add(geofence.getRequestId());
            }
            localBroadcastManager = LocalBroadcastManager.getInstance(context);
            intentM3487a = AbstractC4200f.m3487a(m3450a(geofenceTransition), arrayList, geofencingEvent.getTriggeringLocation());
        }
        localBroadcastManager.sendBroadcast(intentM3487a);
    }

    /* JADX INFO: renamed from: a */
    private static void m3452a(Context context, LocationResult locationResult) {
        if (locationResult == null) {
            C4170g.m3213d(f4964c, "LocationResult was null.", new Object[0]);
            return;
        }
        Location lastLocation = locationResult.getLastLocation();
        if (lastLocation == null) {
            C4170g.m3213d(f4964c, "LastLocation was null.", new Object[0]);
        } else {
            LocalBroadcastManager.getInstance(context).sendBroadcast(AbstractC4200f.m3488a(lastLocation));
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m3450a(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 4;
                if (i != 4) {
                    C4170g.m3213d(f4964c, "Unknown geofence transition %d", Integer.valueOf(i));
                    return -1;
                }
            }
        }
        return i2;
    }
}
