package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.a */
/* JADX INFO: loaded from: classes6.dex */
public final class C4178a {

    /* JADX INFO: renamed from: a */
    public static final a f4898a = new a(null);

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.a$a */
    public static final class a {
        private a() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final String m3328a(InAppMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getActivityInstanceId();
        }

        @JvmStatic
        /* JADX INFO: renamed from: b */
        public final JSONObject m3329b(InAppMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.m6643toJson();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final InAppMessage.CloseButton m3327a() {
            return InAppMessage.CloseButton.INSTANCE.m3694a();
        }
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final String m3325a(InAppMessage inAppMessage) {
        return f4898a.m3328a(inAppMessage);
    }

    @JvmStatic
    /* JADX INFO: renamed from: b */
    public static final JSONObject m3326b(InAppMessage inAppMessage) {
        return f4898a.m3329b(inAppMessage);
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final InAppMessage.CloseButton m3324a() {
        return f4898a.m3327a();
    }
}
