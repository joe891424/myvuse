package com.salesforce.marketingcloud.http;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.http.d */
/* JADX INFO: loaded from: classes6.dex */
public final class C4175d implements Parcelable {

    /* JADX INFO: renamed from: a */
    private final int f4883a;

    /* JADX INFO: renamed from: b */
    private final String f4884b;

    /* JADX INFO: renamed from: c */
    private final String f4885c;

    /* JADX INFO: renamed from: d */
    private final long f4886d;

    /* JADX INFO: renamed from: e */
    private final long f4887e;

    /* JADX INFO: renamed from: f */
    private final Map<String, List<String>> f4888f;

    /* JADX INFO: renamed from: g */
    public static final b f4882g = new b(null);
    public static final Parcelable.Creator<C4175d> CREATOR = new c();

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.http.d$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        private int f4889a;

        /* JADX INFO: renamed from: b */
        private String f4890b;

        /* JADX INFO: renamed from: c */
        private String f4891c;

        /* JADX INFO: renamed from: d */
        private long f4892d;

        /* JADX INFO: renamed from: e */
        private long f4893e;

        /* JADX INFO: renamed from: f */
        private Map<String, ? extends List<String>> f4894f;

        /* JADX INFO: renamed from: a */
        public final a m3311a(String body) {
            Intrinsics.checkNotNullParameter(body, "body");
            this.f4890b = body;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public final a m3315b(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.f4891c = message;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final C4175d m3313a() {
            int i = this.f4889a;
            String str = this.f4890b;
            String str2 = this.f4891c;
            long j = this.f4892d;
            long j2 = this.f4893e;
            Map<String, ? extends List<String>> mapEmptyMap = this.f4894f;
            if (mapEmptyMap == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            return new C4175d(i, str, str2, j, j2, mapEmptyMap);
        }

        /* JADX INFO: renamed from: b */
        public final a m3314b(long j) {
            this.f4892d = j;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final a m3309a(int i) {
            this.f4889a = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final a m3310a(long j) {
            this.f4893e = j;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final a m3312a(Map<String, ? extends List<String>> headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.f4894f = headers;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.http.d$b */
    public static final class b {
        private b() {
        }

        /* JADX INFO: renamed from: a */
        public final a m3316a() {
            return new a();
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final C4175d m3317a(String message, int i) {
            Intrinsics.checkNotNullParameter(message, "message");
            long jCurrentTimeMillis = System.currentTimeMillis();
            return m3316a().m3309a(i).m3315b(message).m3314b(jCurrentTimeMillis).m3310a(jCurrentTimeMillis).m3313a();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.http.d$c */
    public static final class c implements Parcelable.Creator<C4175d> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C4175d createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            int i2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                linkedHashMap.put(parcel.readString(), parcel.createStringArrayList());
            }
            return new C4175d(i, string, string2, j, j2, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C4175d[] newArray(int i) {
            return new C4175d[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C4175d(int i, String str, String str2, long j, long j2, Map<String, ? extends List<String>> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f4883a = i;
        this.f4884b = str;
        this.f4885c = str2;
        this.f4886d = j;
        this.f4887e = j2;
        this.f4888f = headers;
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final C4175d m3300a(String str, int i) {
        return f4882g.m3317a(str, i);
    }

    /* JADX INFO: renamed from: b */
    public final int m3302b() {
        return this.f4883a;
    }

    /* JADX INFO: renamed from: c */
    public final long m3303c() {
        return this.f4887e;
    }

    /* JADX INFO: renamed from: d */
    public final Map<String, List<String>> m3304d() {
        return this.f4888f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: renamed from: e */
    public final String m3305e() {
        return this.f4885c;
    }

    /* JADX INFO: renamed from: f */
    public final long m3306f() {
        return this.f4886d;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m3307g() {
        int i = this.f4883a;
        return 200 <= i && i < 300;
    }

    /* JADX INFO: renamed from: h */
    public final long m3308h() {
        return this.f4887e - this.f4886d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.f4883a);
        out.writeString(this.f4884b);
        out.writeString(this.f4885c);
        out.writeLong(this.f4886d);
        out.writeLong(this.f4887e);
        Map<String, List<String>> map = this.f4888f;
        out.writeInt(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            out.writeStringList(entry.getValue());
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m3301a() {
        return this.f4884b;
    }
}
