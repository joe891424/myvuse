package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.yotisdkcore.core.view.CaptureObjectiveTypeViewData;
import com.yoti.mobile.android.yotisdkcore.core.view.IFeatureConfiguration;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.SignpostStep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.l, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003JE\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J\u0013\u0010%\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020$HÖ\u0001J\b\u0010)\u001a\u00020\u001bH\u0002J\t\u0010*\u001a\u00020\tHÖ\u0001J\u0019\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020$HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006/"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/Step;", "Landroid/os/Parcelable;", "signpostStep", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SignpostStep;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "objective", "Lcom/yoti/mobile/android/yotisdkcore/core/view/CaptureObjectiveTypeViewData;", "launcherPath", "", "shouldRefreshConfigurationAfterComplete", "", "isCompleted", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SignpostStep;Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;Lcom/yoti/mobile/android/yotisdkcore/core/view/CaptureObjectiveTypeViewData;Ljava/lang/String;ZZ)V", "getFeatureConfiguration", "()Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "()Z", "setCompleted", "(Z)V", "getLauncherPath", "()Ljava/lang/String;", "getObjective", "()Lcom/yoti/mobile/android/yotisdkcore/core/view/CaptureObjectiveTypeViewData;", "getShouldRefreshConfigurationAfterComplete", "getSignpostStep", "()Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SignpostStep;", "complete", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "setResources", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class Step implements Parcelable {
    public static final Parcelable.Creator<Step> CREATOR = new a();

    /* JADX INFO: renamed from: a */
    private final SignpostStep f7828a;

    /* JADX INFO: renamed from: b */
    private final IFeatureConfiguration f7829b;

    /* JADX INFO: renamed from: c */
    private final CaptureObjectiveTypeViewData f7830c;

    /* JADX INFO: renamed from: d */
    private final String f7831d;

    /* JADX INFO: renamed from: e */
    private final boolean f7832e;

    /* JADX INFO: renamed from: f */
    private boolean f7833f;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.l$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a implements Parcelable.Creator<Step> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Step createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Step(SignpostStep.CREATOR.createFromParcel(parcel), (IFeatureConfiguration) parcel.readParcelable(Step.class.getClassLoader()), CaptureObjectiveTypeViewData.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Step[] newArray(int i) {
            return new Step[i];
        }
    }

    public Step(SignpostStep signpostStep, IFeatureConfiguration featureConfiguration, CaptureObjectiveTypeViewData objective, String launcherPath, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(signpostStep, "signpostStep");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        Intrinsics.checkNotNullParameter(objective, "objective");
        Intrinsics.checkNotNullParameter(launcherPath, "launcherPath");
        this.f7828a = signpostStep;
        this.f7829b = featureConfiguration;
        this.f7830c = objective;
        this.f7831d = launcherPath;
        this.f7832e = z;
        this.f7833f = z2;
        m5273h();
    }

    public /* synthetic */ Step(SignpostStep signpostStep, IFeatureConfiguration iFeatureConfiguration, CaptureObjectiveTypeViewData captureObjectiveTypeViewData, String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(signpostStep, iFeatureConfiguration, captureObjectiveTypeViewData, str, (i & 16) != 0 ? false : z, z2);
    }

    /* JADX INFO: renamed from: h */
    private final void m5273h() {
        this.f7828a.m5262a(this.f7833f ? SignpostStep.b.COMPLETED : SignpostStep.b.INCOMPLETE);
    }

    /* JADX INFO: renamed from: a */
    public final void m5274a() {
        this.f7833f = true;
        m5273h();
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final IFeatureConfiguration getF7829b() {
        return this.f7829b;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getF7831d() {
        return this.f7831d;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final CaptureObjectiveTypeViewData getF7830c() {
        return this.f7830c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final boolean getF7832e() {
        return this.f7832e;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Step)) {
            return false;
        }
        Step step = (Step) other;
        return Intrinsics.areEqual(this.f7828a, step.f7828a) && Intrinsics.areEqual(this.f7829b, step.f7829b) && this.f7830c == step.f7830c && Intrinsics.areEqual(this.f7831d, step.f7831d) && this.f7832e == step.f7832e && this.f7833f == step.f7833f;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final SignpostStep getF7828a() {
        return this.f7828a;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final boolean getF7833f() {
        return this.f7833f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((this.f7828a.hashCode() * 31) + this.f7829b.hashCode()) * 31) + this.f7830c.hashCode()) * 31) + this.f7831d.hashCode()) * 31;
        boolean z = this.f7832e;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.f7833f;
        return i + (z2 ? 1 : z2);
    }

    public String toString() {
        return "Step(signpostStep=" + this.f7828a + ", featureConfiguration=" + this.f7829b + ", objective=" + this.f7830c + ", launcherPath=" + this.f7831d + ", shouldRefreshConfigurationAfterComplete=" + this.f7832e + ", isCompleted=" + this.f7833f + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.f7828a.writeToParcel(parcel, flags);
        parcel.writeParcelable(this.f7829b, flags);
        parcel.writeString(this.f7830c.name());
        parcel.writeString(this.f7831d);
        parcel.writeInt(this.f7832e ? 1 : 0);
        parcel.writeInt(this.f7833f ? 1 : 0);
    }
}
