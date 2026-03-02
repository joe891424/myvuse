package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.s, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState;", "", "()V", "Loading", "ShowError", "ShowStepTracker", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState$Loading;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState$ShowStepTracker;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState$ShowError;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class StepTrackerViewState {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.s$a */
    @Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState$Loading;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState;", "()V", "Cta", "Fullscreen", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState$Loading$Fullscreen;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState$Loading$Cta;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class a extends StepTrackerViewState {

        /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.s$a$a, reason: collision with other inner class name */
        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState$Loading$Cta;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState$Loading;", "()V", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class C6028a extends a {

            /* JADX INFO: renamed from: a */
            public static final C6028a f7865a = new C6028a();

            private C6028a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.s$a$b */
        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState$Loading$Fullscreen;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState$Loading;", "()V", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class b extends a {

            /* JADX INFO: renamed from: a */
            public static final b f7866a = new b();

            private b() {
                super(null);
            }
        }

        private a() {
            super(null);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.s$b */
    @Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState$ShowError;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState;", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", HeaderParameterNames.AUTHENTICATION_TAG, "", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;Ljava/lang/String;)V", "getFailure", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "getTag", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class b extends StepTrackerViewState {

        /* JADX INFO: renamed from: a */
        private final YdsFailure f7867a;

        /* JADX INFO: renamed from: b */
        private final String f7868b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(YdsFailure failure, String tag) {
            super(null);
            Intrinsics.checkNotNullParameter(failure, "failure");
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.f7867a = failure;
            this.f7868b = tag;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final YdsFailure getF7867a() {
            return this.f7867a;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getF7868b() {
            return this.f7868b;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            return Intrinsics.areEqual(this.f7867a, bVar.f7867a) && Intrinsics.areEqual(this.f7868b, bVar.f7868b);
        }

        public int hashCode() {
            return (this.f7867a.hashCode() * 31) + this.f7868b.hashCode();
        }

        public String toString() {
            return "ShowError(failure=" + this.f7867a + ", tag=" + this.f7868b + ')';
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.s$c */
    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState$ShowStepTracker;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState;", "stepTrackerViewData", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewData;", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewData;)V", "getStepTrackerViewData", "()Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class c extends StepTrackerViewState {

        /* JADX INFO: renamed from: a */
        private final StepTrackerViewData f7869a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(StepTrackerViewData stepTrackerViewData) {
            super(null);
            Intrinsics.checkNotNullParameter(stepTrackerViewData, "stepTrackerViewData");
            this.f7869a = stepTrackerViewData;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final StepTrackerViewData getF7869a() {
            return this.f7869a;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof c) && Intrinsics.areEqual(this.f7869a, ((c) other).f7869a);
        }

        public int hashCode() {
            return this.f7869a.hashCode();
        }

        public String toString() {
            return "ShowStepTracker(stepTrackerViewData=" + this.f7869a + ')';
        }
    }

    private StepTrackerViewState() {
    }

    public /* synthetic */ StepTrackerViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
