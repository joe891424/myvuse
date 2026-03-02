package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.q, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent;", "", "()V", "OnActionCancel", "OnActionTryAgain", "OnCancelFlow", "OnFinishFlow", "OnGotIt", "OnLaunchFeature", "OnStepComplete", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent$OnLaunchFeature;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent$OnActionTryAgain;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent$OnActionCancel;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent$OnStepComplete;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent$OnGotIt;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent$OnFinishFlow;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent$OnCancelFlow;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class StepTrackerViewEvent {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.q$a */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent$OnActionCancel;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent;", HeaderParameterNames.AUTHENTICATION_TAG, "", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class a extends StepTrackerViewEvent {

        /* JADX INFO: renamed from: a */
        private final String f7844a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String tag) {
            super(null);
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.f7844a = tag;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final String getF7844a() {
            return this.f7844a;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof a) && Intrinsics.areEqual(this.f7844a, ((a) other).f7844a);
        }

        public int hashCode() {
            return this.f7844a.hashCode();
        }

        public String toString() {
            return "OnActionCancel(tag=" + this.f7844a + ')';
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.q$b */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent$OnActionTryAgain;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent;", HeaderParameterNames.AUTHENTICATION_TAG, "", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class b extends StepTrackerViewEvent {

        /* JADX INFO: renamed from: a */
        private final String f7845a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String tag) {
            super(null);
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.f7845a = tag;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final String getF7845a() {
            return this.f7845a;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof b) && Intrinsics.areEqual(this.f7845a, ((b) other).f7845a);
        }

        public int hashCode() {
            return this.f7845a.hashCode();
        }

        public String toString() {
            return "OnActionTryAgain(tag=" + this.f7845a + ')';
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.q$c */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent$OnCancelFlow;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent;", "()V", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class c extends StepTrackerViewEvent {

        /* JADX INFO: renamed from: a */
        public static final c f7846a = new c();

        private c() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.q$d */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent$OnFinishFlow;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent;", "()V", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class d extends StepTrackerViewEvent {

        /* JADX INFO: renamed from: a */
        public static final d f7847a = new d();

        private d() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.q$e */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent$OnGotIt;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent;", "()V", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class e extends StepTrackerViewEvent {

        /* JADX INFO: renamed from: a */
        public static final e f7848a = new e();

        private e() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.q$f */
    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent$OnLaunchFeature;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class f extends StepTrackerViewEvent {

        /* JADX INFO: renamed from: a */
        private final Fragment f7849a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment) {
            super(null);
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.f7849a = fragment;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final Fragment getF7849a() {
            return this.f7849a;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof f) && Intrinsics.areEqual(this.f7849a, ((f) other).f7849a);
        }

        public int hashCode() {
            return this.f7849a.hashCode();
        }

        public String toString() {
            return "OnLaunchFeature(fragment=" + this.f7849a + ')';
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.q$g */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent$OnStepComplete;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewEvent;", "()V", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class g extends StepTrackerViewEvent {

        /* JADX INFO: renamed from: a */
        public static final g f7850a = new g();

        private g() {
            super(null);
        }
    }

    private StepTrackerViewEvent() {
    }

    public /* synthetic */ StepTrackerViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
