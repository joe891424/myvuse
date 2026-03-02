package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.salesforce.marketingcloud.storage.p047db.C4350i;
import com.yoti.mobile.android.remote.debug.RemoteDebugPreferencesKt;
import com.yoti.mobile.android.yotisdkcore.C4957R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.j, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001*B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\bHÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006+"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SignpostStep;", "Landroid/os/Parcelable;", "stepComposition", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/IStepComposition;", "bulletPointNumber", "", C4350i.f5612e, "", "", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/IStepComposition;Ljava/lang/String;Ljava/util/List;)V", "getBulletPointNumber", "()Ljava/lang/String;", "setBulletPointNumber", "(Ljava/lang/String;)V", "getMessages", "()Ljava/util/List;", "state", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SignpostStep$State;", "getState$annotations", "()V", "getState", "()Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SignpostStep$State;", "setState", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SignpostStep$State;)V", "getStepComposition", "()Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/IStepComposition;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "State", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class SignpostStep implements Parcelable {
    public static final Parcelable.Creator<SignpostStep> CREATOR = new a();

    /* JADX INFO: renamed from: a */
    private final IStepComposition f7820a;

    /* JADX INFO: renamed from: b */
    private String f7821b;

    /* JADX INFO: renamed from: c */
    private final List<Integer> f7822c;

    /* JADX INFO: renamed from: d */
    public b f7823d;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.j$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a implements Parcelable.Creator<SignpostStep> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SignpostStep createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            IStepComposition iStepComposition = (IStepComposition) parcel.readParcelable(SignpostStep.class.getClassLoader());
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(Integer.valueOf(parcel.readInt()));
            }
            return new SignpostStep(iStepComposition, string, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SignpostStep[] newArray(int i) {
            return new SignpostStep[i];
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.j$b */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SignpostStep$State;", "", "bulletPointStyle", "", "bulletPointDrawable", "verticalLineColor", "(Ljava/lang/String;IIII)V", "getBulletPointDrawable", "()I", "getBulletPointStyle", "getVerticalLineColor", RemoteDebugPreferencesKt.DEBUG_OPTIONS_REMOTE_BEHAVIOUR_COMPLETED, "CURRENT", "INCOMPLETE", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum b {
        COMPLETED(C4957R.style.Yds_Text_StepTracker_Num_Completed, C4957R.drawable.yds_steptracker_step_done, C4957R.color.yds_theme_border_focus),
        CURRENT(C4957R.style.Yds_Text_StepTracker_Num_Current, C4957R.drawable.yds_steptracker_step_current, C4957R.color.yds_theme_border_default),
        INCOMPLETE(C4957R.style.Yds_Text_StepTracker_Num_Incomplete, C4957R.drawable.yds_steptracker_step_incomplete, C4957R.color.yds_theme_border_default);


        /* JADX INFO: renamed from: a */
        private final int f7825a;

        /* JADX INFO: renamed from: b */
        private final int f7826b;

        /* JADX INFO: renamed from: c */
        private final int f7827c;

        b(int i, int i2, int i3) {
            this.f7825a = i;
            this.f7826b = i2;
            this.f7827c = i3;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getF7826b() {
            return this.f7826b;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final int getF7825a() {
            return this.f7825a;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final int getF7827c() {
            return this.f7827c;
        }
    }

    public SignpostStep(IStepComposition stepComposition, String bulletPointNumber, List<Integer> messages) {
        Intrinsics.checkNotNullParameter(stepComposition, "stepComposition");
        Intrinsics.checkNotNullParameter(bulletPointNumber, "bulletPointNumber");
        Intrinsics.checkNotNullParameter(messages, "messages");
        this.f7820a = stepComposition;
        this.f7821b = bulletPointNumber;
        this.f7822c = messages;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getF7821b() {
        return this.f7821b;
    }

    /* JADX INFO: renamed from: a */
    public final void m5262a(b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.f7823d = bVar;
    }

    /* JADX INFO: renamed from: b */
    public final List<Integer> m5263b() {
        return this.f7822c;
    }

    /* JADX INFO: renamed from: c */
    public final b m5264c() {
        b bVar = this.f7823d;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("state");
        return null;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final IStepComposition getF7820a() {
        return this.f7820a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignpostStep)) {
            return false;
        }
        SignpostStep signpostStep = (SignpostStep) other;
        return Intrinsics.areEqual(this.f7820a, signpostStep.f7820a) && Intrinsics.areEqual(this.f7821b, signpostStep.f7821b) && Intrinsics.areEqual(this.f7822c, signpostStep.f7822c);
    }

    public int hashCode() {
        return (((this.f7820a.hashCode() * 31) + this.f7821b.hashCode()) * 31) + this.f7822c.hashCode();
    }

    public String toString() {
        return "SignpostStep(stepComposition=" + this.f7820a + ", bulletPointNumber=" + this.f7821b + ", messages=" + this.f7822c + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.f7820a, flags);
        parcel.writeString(this.f7821b);
        List<Integer> list = this.f7822c;
        parcel.writeInt(list.size());
        Iterator<Integer> it2 = list.iterator();
        while (it2.hasNext()) {
            parcel.writeInt(it2.next().intValue());
        }
    }
}
