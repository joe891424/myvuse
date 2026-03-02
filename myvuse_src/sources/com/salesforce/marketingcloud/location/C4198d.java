package com.salesforce.marketingcloud.location;

import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.salesforce.marketingcloud.C4170g;
import java.util.List;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.location.d */
/* JADX INFO: loaded from: classes6.dex */
class C4198d implements OnFailureListener {

    /* JADX INFO: renamed from: e */
    static final String f4979e = C4170g.m3197a("GmsLocationProvider");

    /* JADX INFO: renamed from: a */
    private final Context f4980a;

    /* JADX INFO: renamed from: b */
    volatile boolean f4981b;

    /* JADX INFO: renamed from: c */
    int f4982c;

    /* JADX INFO: renamed from: d */
    String f4983d;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.location.d$a */
    class a implements OnCompleteListener<Void> {
        a() {
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(Task<Void> task) {
            C4170g.m3213d(C4198d.f4979e, "Location request completed.", new Object[0]);
            C4198d.this.f4981b = false;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.location.d$b */
    class b implements OnCompleteListener<Void> {
        b() {
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(Task<Void> task) {
            C4170g.m3213d(C4198d.f4979e, "Add Geofences request completed.", new Object[0]);
        }
    }

    C4198d(Context context) throws IllegalStateException {
        this.f4980a = context;
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context);
        this.f4982c = iIsGooglePlayServicesAvailable;
        this.f4983d = googleApiAvailability.getErrorString(iIsGooglePlayServicesAvailable);
        int i = this.f4982c;
        if (i == 0 || googleApiAvailability.isUserResolvableError(i)) {
            return;
        }
        int i2 = this.f4982c;
        throw new C4201g(i2, googleApiAvailability.getErrorString(i2));
    }

    /* JADX INFO: renamed from: a */
    void m3480a(C4196b... c4196bArr) throws SecurityException {
        if (c4196bArr == null || c4196bArr.length == 0) {
            C4170g.m3213d(f4979e, "No GeofenceRegions provided", new Object[0]);
            return;
        }
        PendingIntent pendingIntentM3454b = LocationReceiver.m3454b(this.f4980a);
        GeofencingRequest.Builder initialTrigger = new GeofencingRequest.Builder().setInitialTrigger(1);
        for (C4196b c4196b : c4196bArr) {
            C4170g.m3213d(f4979e, "Adding %s to geofence request", c4196b.m3470f());
            initialTrigger.addGeofence(m3477a(c4196b));
        }
        try {
            LocationServices.getGeofencingClient(this.f4980a).addGeofences(initialTrigger.build(), pendingIntentM3454b).addOnFailureListener(this).addOnCompleteListener(new b());
        } catch (SecurityException e) {
            C4170g.m3207b(f4979e, e, "ACCESS_FINE_LOCATION needed to request location.", new Object[0]);
            throw e;
        }
    }

    /* JADX INFO: renamed from: b */
    String m3481b() {
        return this.f4983d;
    }

    /* JADX INFO: renamed from: c */
    int m3482c() {
        return this.f4982c;
    }

    /* JADX INFO: renamed from: d */
    boolean m3483d() {
        return this.f4982c == 0;
    }

    /* JADX INFO: renamed from: e */
    void m3484e() throws SecurityException {
        synchronized (this) {
            if (this.f4981b) {
                C4170g.m3213d(f4979e, "Location request already being made.", new Object[0]);
                return;
            }
            this.f4981b = true;
            try {
                LocationServices.getFusedLocationProviderClient(this.f4980a).requestLocationUpdates(LocationRequest.create().setNumUpdates(1).setPriority(100), LocationReceiver.m3455c(this.f4980a)).addOnFailureListener(this).addOnCompleteListener(new a());
            } catch (SecurityException e) {
                C4170g.m3207b(f4979e, e, "ACCESS_FINE_LOCATION needed to request location.", new Object[0]);
                this.f4981b = false;
                throw e;
            }
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        C4170g.m3207b(f4979e, exc, "LocationServices failure", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    void m3478a() {
        LocationServices.getGeofencingClient(this.f4980a).removeGeofences(LocationReceiver.m3454b(this.f4980a)).addOnFailureListener(this);
    }

    /* JADX INFO: renamed from: a */
    void m3479a(List<String> list) {
        if (list == null || list.size() == 0) {
            C4170g.m3213d(f4979e, "No GeofenceRegions provided", new Object[0]);
        } else {
            LocationServices.getGeofencingClient(this.f4980a).removeGeofences(list).addOnFailureListener(this);
        }
    }

    /* JADX INFO: renamed from: a */
    private static Geofence m3477a(C4196b c4196b) {
        int i = (c4196b.m3474j() & 1) != 1 ? 0 : 1;
        if ((c4196b.m3474j() & 2) == 2) {
            i |= 2;
        }
        if ((c4196b.m3474j() & 4) == 4) {
            i |= 4;
        }
        return new Geofence.Builder().setRequestId(c4196b.m3470f()).setCircularRegion(c4196b.m3471g(), c4196b.m3472h(), c4196b.m3473i()).setTransitionTypes(i).setExpirationDuration(-1L).build();
    }
}
