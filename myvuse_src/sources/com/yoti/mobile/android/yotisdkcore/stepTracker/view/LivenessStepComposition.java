package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.util.UriUtil;
import com.yoti.mobile.android.yotisdkcore.C4957R;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.LivenessResourceConfigEntity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.g, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\nHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/LivenessStepComposition;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/IStepComposition;", "livenessType", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$LivenessTypeEntity;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$LivenessTypeEntity;)V", "getLivenessType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$LivenessTypeEntity;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "getTitle", "", UriUtil.LOCAL_RESOURCE_SCHEME, "Landroid/content/res/Resources;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class LivenessStepComposition implements IStepComposition {
    public static final Parcelable.Creator<LivenessStepComposition> CREATOR = new a();

    /* JADX INFO: renamed from: a */
    private final LivenessResourceConfigEntity.LivenessTypeEntity f7814a;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.g$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a implements Parcelable.Creator<LivenessStepComposition> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LivenessStepComposition createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LivenessStepComposition(LivenessResourceConfigEntity.LivenessTypeEntity.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LivenessStepComposition[] newArray(int i) {
            return new LivenessStepComposition[i];
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.g$b */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f7815a;

        static {
            int[] iArr = new int[LivenessResourceConfigEntity.LivenessTypeEntity.values().length];
            iArr[LivenessResourceConfigEntity.LivenessTypeEntity.ZOOM.ordinal()] = 1;
            iArr[LivenessResourceConfigEntity.LivenessTypeEntity.STATIC.ordinal()] = 2;
            iArr[LivenessResourceConfigEntity.LivenessTypeEntity.FACE_CAPTURE.ordinal()] = 3;
            f7815a = iArr;
        }
    }

    public LivenessStepComposition(LivenessResourceConfigEntity.LivenessTypeEntity livenessType) {
        Intrinsics.checkNotNullParameter(livenessType, "livenessType");
        this.f7814a = livenessType;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.stepTracker.view.IStepComposition
    /* JADX INFO: renamed from: a */
    public String mo5250a(Resources res) {
        String string;
        String str;
        Intrinsics.checkNotNullParameter(res, "res");
        int i = b.f7815a[this.f7814a.ordinal()];
        if (i == 1) {
            string = res.getString(C4957R.string.yds_verification_context_multi_flow_liveness_content_description);
            str = "res.getString(R.string.y…ness_content_description)";
        } else {
            if (i != 2 && i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            string = res.getString(C4957R.string.f7519x46f386bc);
            str = "res.getString(R.string.y…ture_content_description)";
        }
        Intrinsics.checkNotNullExpressionValue(string, str);
        return string;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LivenessStepComposition) && this.f7814a == ((LivenessStepComposition) other).f7814a;
    }

    public int hashCode() {
        return this.f7814a.hashCode();
    }

    public String toString() {
        return "LivenessStepComposition(livenessType=" + this.f7814a + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.f7814a.name());
    }
}
