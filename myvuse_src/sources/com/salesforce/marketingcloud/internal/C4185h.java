package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.h */
/* JADX INFO: loaded from: classes6.dex */
public final class C4185h {

    /* JADX INFO: renamed from: a */
    public static final a f4905a = new a(null);

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.h$a */
    public static final class a {
        private a() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final NotificationMessage m3379a(Message message, Region region) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(region, "region");
            return NotificationMessage.INSTANCE.m3846a(message, region);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final NotificationMessage m3380a(Map<String, String> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return NotificationMessage.INSTANCE.m3847a(data);
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final void m3381a(NotificationMessage message, int i) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.setNotificationId$sdk_release(i);
        }
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final NotificationMessage m3376a(Message message, Region region) {
        return f4905a.m3379a(message, region);
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final NotificationMessage m3377a(Map<String, String> map) {
        return f4905a.m3380a(map);
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final void m3378a(NotificationMessage notificationMessage, int i) {
        f4905a.m3381a(notificationMessage, i);
    }
}
