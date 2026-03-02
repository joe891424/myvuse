package com.yoti.mobile.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.remote.ServiceLocation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Session.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/model/Session;", "Landroid/os/Parcelable;", "id", "", "authData", "Lcom/yoti/mobile/android/remote/model/AuthenticationData;", "serviceLocation", "Lcom/yoti/mobile/android/remote/ServiceLocation;", "clientType", "Lcom/yoti/mobile/android/remote/model/ClientType;", "(Ljava/lang/String;Lcom/yoti/mobile/android/remote/model/AuthenticationData;Lcom/yoti/mobile/android/remote/ServiceLocation;Lcom/yoti/mobile/android/remote/model/ClientType;)V", "getAuthData", "()Lcom/yoti/mobile/android/remote/model/AuthenticationData;", "getClientType", "()Lcom/yoti/mobile/android/remote/model/ClientType;", "getId", "()Ljava/lang/String;", "getServiceLocation", "()Lcom/yoti/mobile/android/remote/ServiceLocation;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class Session implements Parcelable {
    public static final Parcelable.Creator<Session> CREATOR = new Creator();
    private final AuthenticationData authData;
    private final ClientType clientType;
    private final String id;
    private final ServiceLocation serviceLocation;

    /* JADX INFO: compiled from: Session.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<Session> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Session createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Session(parcel.readString(), (AuthenticationData) parcel.readParcelable(Session.class.getClassLoader()), ServiceLocation.valueOf(parcel.readString()), ClientType.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Session[] newArray(int i) {
            return new Session[i];
        }
    }

    public static /* synthetic */ Session copy$default(Session session, String str, AuthenticationData authenticationData, ServiceLocation serviceLocation, ClientType clientType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = session.id;
        }
        if ((i & 2) != 0) {
            authenticationData = session.authData;
        }
        if ((i & 4) != 0) {
            serviceLocation = session.serviceLocation;
        }
        if ((i & 8) != 0) {
            clientType = session.clientType;
        }
        return session.copy(str, authenticationData, serviceLocation, clientType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AuthenticationData getAuthData() {
        return this.authData;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ServiceLocation getServiceLocation() {
        return this.serviceLocation;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ClientType getClientType() {
        return this.clientType;
    }

    public final Session copy(String id, AuthenticationData authData, ServiceLocation serviceLocation, ClientType clientType) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(authData, "authData");
        Intrinsics.checkNotNullParameter(serviceLocation, "serviceLocation");
        Intrinsics.checkNotNullParameter(clientType, "clientType");
        return new Session(id, authData, serviceLocation, clientType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Session)) {
            return false;
        }
        Session session = (Session) other;
        return Intrinsics.areEqual(this.id, session.id) && Intrinsics.areEqual(this.authData, session.authData) && this.serviceLocation == session.serviceLocation && this.clientType == session.clientType;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.authData.hashCode()) * 31) + this.serviceLocation.hashCode()) * 31) + this.clientType.hashCode();
    }

    public String toString() {
        return "Session(id=" + this.id + ", authData=" + this.authData + ", serviceLocation=" + this.serviceLocation + ", clientType=" + this.clientType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeParcelable(this.authData, flags);
        parcel.writeString(this.serviceLocation.name());
        parcel.writeString(this.clientType.name());
    }

    public Session(String id, AuthenticationData authData, ServiceLocation serviceLocation, ClientType clientType) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(authData, "authData");
        Intrinsics.checkNotNullParameter(serviceLocation, "serviceLocation");
        Intrinsics.checkNotNullParameter(clientType, "clientType");
        this.id = id;
        this.authData = authData;
        this.serviceLocation = serviceLocation;
        this.clientType = clientType;
    }

    public final String getId() {
        return this.id;
    }

    public final AuthenticationData getAuthData() {
        return this.authData;
    }

    public /* synthetic */ Session(String str, AuthenticationData authenticationData, ServiceLocation serviceLocation, ClientType clientType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, authenticationData, (i & 4) != 0 ? ServiceLocation.DEFAULT : serviceLocation, (i & 8) != 0 ? ClientType.ANDROID : clientType);
    }

    public final ServiceLocation getServiceLocation() {
        return this.serviceLocation;
    }

    public final ClientType getClientType() {
        return this.clientType;
    }
}
