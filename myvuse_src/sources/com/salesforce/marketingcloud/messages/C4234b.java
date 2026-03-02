package com.salesforce.marketingcloud.messages;

import android.text.TextUtils;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.internal.C4183f;
import com.salesforce.marketingcloud.storage.InterfaceC4375k;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.Date;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.b */
/* JADX INFO: loaded from: classes6.dex */
public final class C4234b {

    /* JADX INFO: renamed from: a */
    private static final String f5145a = C4236d.f5148C;

    private C4234b() {
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3639a(Message message) {
        Date dateEndDateUtc = message.endDateUtc();
        return dateEndDateUtc == null || dateEndDateUtc.getTime() >= System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: b */
    private static int m3640b(Message message) {
        int iMessagesPerPeriod = message.messagesPerPeriod();
        if (iMessagesPerPeriod > 0 || message.numberOfPeriods() <= 0 || message.periodType() == 0) {
            return iMessagesPerPeriod;
        }
        return 1;
    }

    /* JADX INFO: renamed from: c */
    static boolean m3641c(Message message) {
        try {
            if (TextUtils.isEmpty(message.alert().trim())) {
                C4170g.m3202a(f5145a, "Message (%s) was tripped, but does not have an alert message", message.m3624id());
                return false;
            }
            Date date = new Date();
            if (message.endDateUtc() != null && message.endDateUtc().before(date)) {
                C4170g.m3202a(f5145a, "Message (%s) was tripped, but has expired.", message.m3624id());
                return false;
            }
            if (message.startDateUtc() != null && message.startDateUtc().after(date)) {
                C4170g.m3202a(f5145a, "Message (%s) was tripped, but has not started", message.m3624id());
                return false;
            }
            if (message.messageLimit() > -1 && C4183f.m3365e(message) >= message.messageLimit()) {
                C4170g.m3202a(f5145a, "Message (%s) was tripped, but has met its message limit.", message.m3624id());
                return false;
            }
            int iM3640b = m3640b(message);
            if (iM3640b > -1 && C4183f.m3364d(message) >= iM3640b && C4183f.m3359b(message) != null && date.before(C4183f.m3359b(message))) {
                C4170g.m3202a(f5145a, "Message (%s) was tripped, but has met its message per period limit", message.m3624id());
                return false;
            }
            if (C4183f.m3359b(message) == null || !date.before(C4183f.m3359b(message))) {
                return true;
            }
            C4170g.m3202a(f5145a, "Message (%s) was tripped, but was before its next allowed show time.", message.m3624id());
            return false;
        } catch (Exception e) {
            C4170g.m3207b(f5145a, e, "Failed to determine is message should be shown.", new Object[0]);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3638a(Message message, InterfaceC4375k interfaceC4375k, InterfaceC4384c interfaceC4384c) {
        Message messageMo4123a = interfaceC4375k.mo4123a(message.m3624id(), interfaceC4384c);
        if (messageMo4123a != null) {
            C4183f.m3358a(message, C4183f.m3356a(messageMo4123a));
            C4183f.m3363c(message, C4183f.m3365e(messageMo4123a));
            if (message.periodType() == messageMo4123a.periodType()) {
                C4183f.m3360b(message, C4183f.m3364d(messageMo4123a));
                C4183f.m3361b(message, C4183f.m3359b(messageMo4123a));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008e  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void m3637a(com.salesforce.marketingcloud.messages.Message r15, com.salesforce.marketingcloud.storage.C4374j r16) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.C4234b.m3637a(com.salesforce.marketingcloud.messages.Message, com.salesforce.marketingcloud.storage.j):void");
    }
}
