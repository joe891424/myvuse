package com.salesforce.marketingcloud.alarms;

import com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager;
import com.salesforce.marketingcloud.storage.C4374j;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractC4092a {

    /* JADX INFO: renamed from: a */
    private final String f4310a;

    /* JADX INFO: renamed from: b */
    private final long f4311b;

    /* JADX INFO: renamed from: c */
    private final double f4312c;

    /* JADX INFO: renamed from: d */
    private final long f4313d;

    /* JADX INFO: renamed from: e */
    private final String f4314e;

    /* JADX INFO: renamed from: f */
    private final int f4315f;

    /* JADX INFO: renamed from: g */
    private final boolean f4316g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a */
    public static abstract class a {

        /* JADX INFO: renamed from: b */
        public static final a f4317b = new C5996a("REGISTRATION", 0, 909100);

        /* JADX INFO: renamed from: c */
        public static final a f4318c = new b("ET_ANALYTICS", 1, 909102);

        /* JADX INFO: renamed from: d */
        public static final a f4319d = new c("FETCH_REGION_MESSAGES_DAILY", 2, 909111);

        /* JADX INFO: renamed from: e */
        public static final a f4320e = new d("FETCH_PUSH_TOKEN", 3, 909108);

        /* JADX INFO: renamed from: f */
        public static final a f4321f = new e("UPDATE_INBOX_MESSAGE_STATUS", 4, 909110);

        /* JADX INFO: renamed from: g */
        public static final a f4322g = new f("SYNC", 5, 909112);

        /* JADX INFO: renamed from: h */
        public static final a f4323h = new g("IAM_IMAGE_BATCH", 6, 909113);

        /* JADX INFO: renamed from: i */
        public static final a f4324i = new h("DEVICE_STATS", 7, 909114);

        /* JADX INFO: renamed from: j */
        public static final a f4325j = new i("EVENTS", 8, 909115);

        /* JADX INFO: renamed from: k */
        private static final /* synthetic */ a[] f4326k = m2850a();

        /* JADX INFO: renamed from: a */
        private final int f4327a;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$a, reason: collision with other inner class name */
        enum C5996a extends a {
            private C5996a(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.AbstractC4092a.a
            /* JADX INFO: renamed from: b */
            protected AbstractC4092a mo2852b() {
                return new i(m2853c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$b */
        enum b extends a {
            private b(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.AbstractC4092a.a
            /* JADX INFO: renamed from: b */
            protected AbstractC4092a mo2852b() {
                return new b(m2853c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$c */
        enum c extends a {
            private c(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.AbstractC4092a.a
            /* JADX INFO: renamed from: b */
            protected AbstractC4092a mo2852b() {
                return new f(m2853c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$d */
        enum d extends a {
            private d(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.AbstractC4092a.a
            /* JADX INFO: renamed from: b */
            protected AbstractC4092a mo2852b() {
                return new h(m2853c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$e */
        enum e extends a {
            private e(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.AbstractC4092a.a
            /* JADX INFO: renamed from: b */
            protected AbstractC4092a mo2852b() {
                return new j(m2853c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$f */
        enum f extends a {
            private f(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.AbstractC4092a.a
            /* JADX INFO: renamed from: b */
            protected AbstractC4092a mo2852b() {
                return new g(m2853c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$g */
        enum g extends a {
            private g(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.AbstractC4092a.a
            /* JADX INFO: renamed from: b */
            protected AbstractC4092a mo2852b() {
                return new e(m2853c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$h */
        enum h extends a {
            private h(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.AbstractC4092a.a
            /* JADX INFO: renamed from: b */
            protected AbstractC4092a mo2852b() {
                return new c(m2853c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$i */
        enum i extends a {
            private i(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.AbstractC4092a.a
            /* JADX INFO: renamed from: b */
            protected AbstractC4092a mo2852b() {
                return new d(m2853c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$j */
        static class j {

            /* JADX INFO: renamed from: a */
            static final int f4328a = 909115;

            /* JADX INFO: renamed from: b */
            static final int f4329b = 909114;

            /* JADX INFO: renamed from: c */
            static final int f4330c = 909113;

            /* JADX INFO: renamed from: d */
            static final int f4331d = 909112;

            /* JADX INFO: renamed from: e */
            static final int f4332e = 909110;

            /* JADX INFO: renamed from: f */
            static final int f4333f = 909109;

            /* JADX INFO: renamed from: g */
            static final int f4334g = 909108;

            /* JADX INFO: renamed from: h */
            static final int f4335h = 909111;

            /* JADX INFO: renamed from: i */
            static final int f4336i = 909102;

            /* JADX INFO: renamed from: j */
            static final int f4337j = 909101;

            /* JADX INFO: renamed from: k */
            static final int f4338k = 909100;

            j() {
            }
        }

        private a(String str, int i2, int i3) {
            this.f4327a = i3;
        }

        /* JADX INFO: renamed from: a */
        private static /* synthetic */ a[] m2850a() {
            return new a[]{f4317b, f4318c, f4319d, f4320e, f4321f, f4322g, f4323h, f4324i, f4325j};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f4326k.clone();
        }

        @Deprecated
        /* JADX INFO: renamed from: a */
        protected boolean m2851a(C4374j c4374j) {
            return true;
        }

        /* JADX INFO: renamed from: b */
        protected abstract AbstractC4092a mo2852b();

        /* JADX INFO: renamed from: c */
        public int m2853c() {
            return this.f4327a;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$b */
    private static final class b extends AbstractC4092a {
        b(int i) {
            this(i, "et_etanalytic_alarm_created_date", "et_etanalytic_next_alarm_interval", 60000L, 2.0d, NetworkManager.MAX_SERVER_RETRY, true);
        }

        private b(int i, String str, String str2, long j, double d, long j2, boolean z) {
            super(i, str, str2, j, d, j2, z);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$c */
    private static final class c extends AbstractC4092a {
        c(int i) {
            super(i, "et_device_stats_alarm_created_date", "et_device_stats_alarm_interval", 60000L, 2.0d, NetworkManager.MAX_SERVER_RETRY, false);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$d */
    private static final class d extends AbstractC4092a {
        d(int i) {
            super(i, "et_events_alarm_created_date", "et_events_alarm_interval", 60000L, 2.0d, NetworkManager.MAX_SERVER_RETRY, false);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$e */
    private static final class e extends AbstractC4092a {
        e(int i) {
            super(i, "et_iam_image_cache_route_alarm_created_date", "et_iam_image_cache_route_alarm_interval", 60000L, 2.0d, NetworkManager.MAX_SERVER_RETRY, false);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$f */
    private static final class f extends AbstractC4092a {
        f(int i) {
            this(i, "et_fetch_background_beacon_messages_alarm_created_date", "et_fetch_background_beacon_messages_next_alarm_interval", NetworkManager.MAX_SERVER_RETRY, 1.0d, NetworkManager.MAX_SERVER_RETRY, false);
        }

        private f(int i, String str, String str2, long j, double d, long j2, boolean z) {
            super(i, str, str2, j, d, j2, z);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$g */
    private static final class g extends AbstractC4092a {
        g(int i) {
            super(i, "et_sync_route_alarm_created_date", "et_sync_route_alarm_interval", 60000L, 2.0d, NetworkManager.MAX_SERVER_RETRY, false);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$h */
    private static final class h extends AbstractC4092a {
        h(int i) {
            this(i, "et_register_for_remote_notifications_alarm_created_date", "et_register_for_remote_notifications_next_alarm_interval", 60000L, 2.0d, NetworkManager.MAX_SERVER_RETRY, false);
        }

        private h(int i, String str, String str2, long j, double d, long j2, boolean z) {
            super(i, str, str2, j, d, j2, z);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$i */
    private static final class i extends AbstractC4092a {
        i(int i) {
            this(i, "et_registration_alarm_created_date", "et_registration_next_alarm_interval", 60000L, 2.0d, NetworkManager.MAX_SERVER_RETRY, false);
        }

        private i(int i, String str, String str2, long j, double d, long j2, boolean z) {
            super(i, str, str2, j, d, j2, z);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$j */
    private static final class j extends AbstractC4092a {
        j(int i) {
            this(i, "et_update_inbox_message_status_alarm_created_date", "et_update_inbox_message_status_next_alarm_interval", 60000L, 2.0d, NetworkManager.MAX_SERVER_RETRY, true);
        }

        private j(int i, String str, String str2, long j, double d, long j2, boolean z) {
            super(i, str, str2, j, d, j2, z);
        }
    }

    AbstractC4092a(int i2, String str, String str2, long j2, double d2, long j3, boolean z) {
        this.f4315f = i2;
        this.f4314e = str;
        this.f4310a = str2;
        this.f4311b = j2;
        this.f4312c = d2;
        this.f4313d = j3;
        this.f4316g = z;
    }

    /* JADX INFO: renamed from: a */
    final String m2843a() {
        return this.f4314e;
    }

    /* JADX INFO: renamed from: b */
    final int m2844b() {
        return this.f4315f;
    }

    /* JADX INFO: renamed from: c */
    final String m2845c() {
        return this.f4310a;
    }

    /* JADX INFO: renamed from: d */
    final long m2846d() {
        return this.f4311b;
    }

    /* JADX INFO: renamed from: e */
    final double m2847e() {
        return this.f4312c;
    }

    /* JADX INFO: renamed from: f */
    final long m2848f() {
        return this.f4313d;
    }

    /* JADX INFO: renamed from: g */
    final boolean m2849g() {
        return this.f4316g;
    }
}
