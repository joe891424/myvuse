package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.messages.Message;
import java.util.Date;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.f */
/* JADX INFO: loaded from: classes6.dex */
public final class C4183f {

    /* JADX INFO: renamed from: a */
    public static final a f4903a = new a(null);

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.f$a */
    public static final class a {
        private a() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final Date m3366a(Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getLastShownDate();
        }

        @JvmStatic
        /* JADX INFO: renamed from: b */
        public final Date m3369b(Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getNextAllowedShow();
        }

        @JvmStatic
        /* JADX INFO: renamed from: c */
        public final int m3372c(Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getNotificationId();
        }

        @JvmStatic
        /* JADX INFO: renamed from: d */
        public final int m3374d(Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getPeriodShowCount();
        }

        @JvmStatic
        /* JADX INFO: renamed from: e */
        public final int m3375e(Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getShowCount();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final void m3368a(Message message, Date date) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.m6593lastShownDate(date);
        }

        @JvmStatic
        /* JADX INFO: renamed from: b */
        public final void m3371b(Message message, Date date) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.m6595nextAllowedShow(date);
        }

        @JvmStatic
        /* JADX INFO: renamed from: c */
        public final void m3373c(Message message, int i) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.m6601showCount(i);
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final void m3367a(Message message, int i) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.m6597notificationId(i);
        }

        @JvmStatic
        /* JADX INFO: renamed from: b */
        public final void m3370b(Message message, int i) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.m6599periodShowCount(i);
        }
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final Date m3356a(Message message) {
        return f4903a.m3366a(message);
    }

    @JvmStatic
    /* JADX INFO: renamed from: b */
    public static final Date m3359b(Message message) {
        return f4903a.m3369b(message);
    }

    @JvmStatic
    /* JADX INFO: renamed from: c */
    public static final int m3362c(Message message) {
        return f4903a.m3372c(message);
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final int m3364d(Message message) {
        return f4903a.m3374d(message);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final int m3365e(Message message) {
        return f4903a.m3375e(message);
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final void m3358a(Message message, Date date) {
        f4903a.m3368a(message, date);
    }

    @JvmStatic
    /* JADX INFO: renamed from: b */
    public static final void m3361b(Message message, Date date) {
        f4903a.m3371b(message, date);
    }

    @JvmStatic
    /* JADX INFO: renamed from: c */
    public static final void m3363c(Message message, int i) {
        f4903a.m3373c(message, i);
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final void m3357a(Message message, int i) {
        f4903a.m3367a(message, i);
    }

    @JvmStatic
    /* JADX INFO: renamed from: b */
    public static final void m3360b(Message message, int i) {
        f4903a.m3370b(message, i);
    }
}
