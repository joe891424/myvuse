package com.yoti.mobile.android.liveness.view.upload;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.liveness.C4871R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadValidationFailure;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessUploadValidationFailure extends LivenessUploadFailureType {
    public static final LivenessUploadValidationFailure INSTANCE = new LivenessUploadValidationFailure();
    public static final Parcelable.Creator<LivenessUploadValidationFailure> CREATOR = new Creator();

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<LivenessUploadValidationFailure> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LivenessUploadValidationFailure createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return LivenessUploadValidationFailure.INSTANCE;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LivenessUploadValidationFailure[] newArray(int i) {
            return new LivenessUploadValidationFailure[i];
        }
    }

    private LivenessUploadValidationFailure() {
        super(0, 0, C4871R.drawable.yds_ic_warning, C4871R.string.ios_android_yds_liveness_retry_header, C4871R.string.ios_android_yds_liveness_retry_description, 3, null);
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
