package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.b */
/* JADX INFO: loaded from: classes6.dex */
public final class C4179b {

    /* JADX INFO: renamed from: a */
    public static final a f4899a = new a(null);

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.b$a */
    public static final class a {
        private a() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final String m3336a(InboxMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getMessageHash();
        }

        @JvmStatic
        /* JADX INFO: renamed from: b */
        public final String m3338b(InboxMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getRequestId();
        }

        @JvmStatic
        /* JADX INFO: renamed from: c */
        public final void m3341c(InboxMessage message, boolean z) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.m6688read(z);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final void m3337a(InboxMessage message, boolean z) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.m6670deleted(z);
        }

        @JvmStatic
        /* JADX INFO: renamed from: b */
        public final void m3339b(InboxMessage message, boolean z) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.m6685dirty(z);
        }

        @JvmStatic
        /* JADX INFO: renamed from: c */
        public final int m3340c(InboxMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getViewCount();
        }
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final String m3330a(InboxMessage inboxMessage) {
        return f4899a.m3336a(inboxMessage);
    }

    @JvmStatic
    /* JADX INFO: renamed from: b */
    public static final String m3332b(InboxMessage inboxMessage) {
        return f4899a.m3338b(inboxMessage);
    }

    @JvmStatic
    /* JADX INFO: renamed from: c */
    public static final void m3335c(InboxMessage inboxMessage, boolean z) {
        f4899a.m3341c(inboxMessage, z);
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final void m3331a(InboxMessage inboxMessage, boolean z) {
        f4899a.m3337a(inboxMessage, z);
    }

    @JvmStatic
    /* JADX INFO: renamed from: b */
    public static final void m3333b(InboxMessage inboxMessage, boolean z) {
        f4899a.m3339b(inboxMessage, z);
    }

    @JvmStatic
    /* JADX INFO: renamed from: c */
    public static final int m3334c(InboxMessage inboxMessage) {
        return f4899a.m3340c(inboxMessage);
    }
}
