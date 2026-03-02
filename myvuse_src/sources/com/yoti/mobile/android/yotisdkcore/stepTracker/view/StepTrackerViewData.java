package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.yotisdkcore.C4957R;
import com.yoti.mobile.android.yotisdkcore.core.view.CaptureObjectiveTypeViewData;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.SignpostStep;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.p, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0004J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\u0013\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\b\u0010#\u001a\u0004\u0018\u00010\u0004J\u0006\u0010$\u001a\u00020\u001bJ\t\u0010%\u001a\u00020\u0007HÖ\u0001J\u0006\u0010&\u001a\u00020\u001bJ\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0002J\b\u0010*\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020(H\u0002J\t\u0010-\u001a\u00020.HÖ\u0001J\u0019\u0010/\u001a\u00020(2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0007HÖ\u0001R&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR&\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f¨\u00063"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewData;", "Landroid/os/Parcelable;", "steps", "", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/Step;", "(Ljava/util/List;)V", "<set-?>", "", "buttonContinueText", "getButtonContinueText$annotations", "()V", "getButtonContinueText", "()I", "message", "getMessage$annotations", "getMessage", "objective", "Lcom/yoti/mobile/android/yotisdkcore/core/view/CaptureObjectiveTypeViewData;", "getObjective$annotations", "getObjective", "()Lcom/yoti/mobile/android/yotisdkcore/core/view/CaptureObjectiveTypeViewData;", "getSteps", "()Ljava/util/List;", "title", "getTitle$annotations", "getTitle", "allStepsCompleted", "", "completeStep", "component1", "copy", "describeContents", "equals", "other", "", "getCurrentStep", "hasCompletedSteps", "hashCode", "isSingleFlow", "setCurrentStepResources", "", "setMessageResources", "setTitleResources", "setTrackerResources", "setUpButtonText", "toString", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class StepTrackerViewData implements Parcelable {
    public static final Parcelable.Creator<StepTrackerViewData> CREATOR = new a();

    /* JADX INFO: renamed from: a */
    private final List<Step> f7840a;

    /* JADX INFO: renamed from: b */
    private int f7841b;

    /* JADX INFO: renamed from: c */
    private int f7842c;

    /* JADX INFO: renamed from: d */
    private int f7843d;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.p$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a implements Parcelable.Creator<StepTrackerViewData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final StepTrackerViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(Step.CREATOR.createFromParcel(parcel));
            }
            return new StepTrackerViewData(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final StepTrackerViewData[] newArray(int i) {
            return new StepTrackerViewData[i];
        }
    }

    public StepTrackerViewData(List<Step> steps) {
        Intrinsics.checkNotNullParameter(steps, "steps");
        this.f7840a = steps;
        m5289k();
        m5292n();
    }

    /* JADX INFO: renamed from: f */
    private final CaptureObjectiveTypeViewData m5288f() {
        List<Step> list = this.f7840a;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (((Step) it2.next()).getF7830c() != ((Step) CollectionsKt.first((List) this.f7840a)).getF7830c()) {
                    return null;
                }
            }
        }
        return ((Step) CollectionsKt.first((List) this.f7840a)).getF7830c();
    }

    /* JADX INFO: renamed from: k */
    private final void m5289k() {
        if (m5294a()) {
            return;
        }
        List<Step> list = this.f7840a;
        Iterator<Step> it2 = list.iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            } else if (!it2.next().getF7833f()) {
                break;
            } else {
                i++;
            }
        }
        list.get(i).getF7828a().m5262a(SignpostStep.b.CURRENT);
    }

    /* JADX INFO: renamed from: l */
    private final void m5290l() {
        int stepTrackerMessageStepsCompleted;
        boolean zM5294a = m5294a();
        if (zM5294a) {
            CaptureObjectiveTypeViewData captureObjectiveTypeViewDataM5288f = m5288f();
            stepTrackerMessageStepsCompleted = captureObjectiveTypeViewDataM5288f != null ? captureObjectiveTypeViewDataM5288f.getStepTrackerMessageStepsCompleted() : C4957R.string.yds_verification_context_multi_flow_completion_description;
        } else {
            if (zM5294a) {
                throw new NoWhenBranchMatchedException();
            }
            stepTrackerMessageStepsCompleted = m5302j() ? C4957R.string.yds_verification_context_single_flow_description : C4957R.string.yds_verification_context_multi_flow_description;
        }
        this.f7842c = stepTrackerMessageStepsCompleted;
    }

    /* JADX INFO: renamed from: m */
    private final void m5291m() {
        int stepTrackerTitle;
        if (m5294a()) {
            stepTrackerTitle = C4957R.string.yds_verification_context_multi_flow_completion_header;
        } else {
            CaptureObjectiveTypeViewData captureObjectiveTypeViewDataM5288f = m5288f();
            stepTrackerTitle = captureObjectiveTypeViewDataM5288f != null ? captureObjectiveTypeViewDataM5288f.getStepTrackerTitle() : C4957R.string.yds_verification_context_header;
        }
        this.f7841b = stepTrackerTitle;
    }

    /* JADX INFO: renamed from: n */
    private final void m5292n() {
        m5291m();
        m5290l();
        m5293o();
    }

    /* JADX INFO: renamed from: o */
    private final void m5293o() {
        this.f7843d = m5301i() ? C4957R.string.yds_common_continue : C4957R.string.yds_verification_context_first_flow_primary_cta;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m5294a() {
        List<Step> list = this.f7840a;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (!((Step) it2.next()).getF7833f()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    public final Step m5295b() {
        for (Step step : this.f7840a) {
            if (!step.getF7833f()) {
                step.m5274a();
                m5289k();
                m5292n();
                return step;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getF7843d() {
        return this.f7843d;
    }

    /* JADX INFO: renamed from: d */
    public final Step m5297d() {
        Object next;
        Iterator<T> it2 = this.f7840a.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (!((Step) next).getF7833f()) {
                break;
            }
        }
        return (Step) next;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getF7842c() {
        return this.f7842c;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StepTrackerViewData) && Intrinsics.areEqual(this.f7840a, ((StepTrackerViewData) other).f7840a);
    }

    /* JADX INFO: renamed from: g */
    public final List<Step> m5299g() {
        return this.f7840a;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final int getF7841b() {
        return this.f7841b;
    }

    public int hashCode() {
        return this.f7840a.hashCode();
    }

    /* JADX INFO: renamed from: i */
    public final boolean m5301i() {
        List<Step> list = this.f7840a;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (((Step) it2.next()).getF7833f()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: j */
    public final boolean m5302j() {
        return this.f7840a.size() == 1;
    }

    public String toString() {
        return "StepTrackerViewData(steps=" + this.f7840a + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<Step> list = this.f7840a;
        parcel.writeInt(list.size());
        Iterator<Step> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
    }
}
