package com.newrelic.agent.android.analytics;

import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
class AnalyticsEventFactory {

    /* JADX INFO: renamed from: com.newrelic.agent.android.analytics.AnalyticsEventFactory$1 */
    static /* synthetic */ class C37361 {

        /* JADX INFO: renamed from: $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory */
        static final /* synthetic */ int[] f4033x9155d312;

        static {
            int[] iArr = new int[AnalyticsEventCategory.values().length];
            f4033x9155d312 = iArr;
            try {
                iArr[AnalyticsEventCategory.Session.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4033x9155d312[AnalyticsEventCategory.RequestError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4033x9155d312[AnalyticsEventCategory.Interaction.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4033x9155d312[AnalyticsEventCategory.Crash.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4033x9155d312[AnalyticsEventCategory.Custom.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4033x9155d312[AnalyticsEventCategory.Breadcrumb.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4033x9155d312[AnalyticsEventCategory.NetworkRequest.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4033x9155d312[AnalyticsEventCategory.UserAction.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4033x9155d312[AnalyticsEventCategory.ApplicationExit.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    static AnalyticsEvent createEvent(String str, AnalyticsEventCategory analyticsEventCategory, String str2, Set<AnalyticsAttribute> set) {
        switch (C37361.f4033x9155d312[analyticsEventCategory.ordinal()]) {
            case 1:
                return new SessionEvent(set);
            case 2:
                return new NetworkRequestErrorEvent(set);
            case 3:
                return new InteractionEvent(str, set);
            case 4:
                return new CrashEvent(str, set);
            case 5:
                return new CustomEvent(str, str2, set);
            case 6:
                return new BreadcrumbEvent(str, set);
            case 7:
                return new NetworkRequestEvent(set);
            case 8:
                return new UserActionEvent(str, set);
            case 9:
                return new ApplicationExitEvent(str, set);
            default:
                return null;
        }
    }

    private AnalyticsEventFactory() {
    }
}
