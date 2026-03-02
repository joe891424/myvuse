package com.yoti.mobile.android.liveness.view.educational;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.liveness.C4871R;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/DefaultLivenessGuidelinesViewData;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DefaultLivenessGuidelinesViewData extends LivenessGuidelinesViewData {
    public static final DefaultLivenessGuidelinesViewData INSTANCE = new DefaultLivenessGuidelinesViewData();
    public static final Parcelable.Creator<DefaultLivenessGuidelinesViewData> CREATOR = new Creator();

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<DefaultLivenessGuidelinesViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DefaultLivenessGuidelinesViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return DefaultLivenessGuidelinesViewData.INSTANCE;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DefaultLivenessGuidelinesViewData[] newArray(int i) {
            return new DefaultLivenessGuidelinesViewData[i];
        }
    }

    private DefaultLivenessGuidelinesViewData() {
        super(C4871R.string.ios_android_yds_liveness_guidelines_first_content_description, TuplesKt.m5605to(Integer.valueOf(C4871R.drawable.yds_liveness_position_correct), Integer.valueOf(C4871R.drawable.yds_liveness_position_incorrect)), C4871R.string.yds_liveness_guidelines_second_content_description, TuplesKt.m5605to(Integer.valueOf(C4871R.drawable.yds_liveness_lighting_correct), Integer.valueOf(C4871R.drawable.yds_liveness_lighting_incorrect)), NavigationIcon.CLOSE_BLUE);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
