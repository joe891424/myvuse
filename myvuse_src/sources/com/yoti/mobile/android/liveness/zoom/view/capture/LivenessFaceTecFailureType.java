package com.yoti.mobile.android.liveness.zoom.view.capture;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.liveness.C4871R;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB%\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecFailureType;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$FeatureFailureType;", "icon", "", "messageTitleId", "messageTextId", "(III)V", "FaceTecFaceCaptureFailure", "FaceTecSessionCancelledFailure", "NoLocalAttemptsFailure", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecFailureType$FaceTecSessionCancelledFailure;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecFailureType$FaceTecFaceCaptureFailure;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecFailureType$NoLocalAttemptsFailure;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class LivenessFaceTecFailureType extends YdsFailureType.FeatureFailureType {

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecFailureType$FaceTecFaceCaptureFailure;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecFailureType;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class FaceTecFaceCaptureFailure extends LivenessFaceTecFailureType {
        public static final FaceTecFaceCaptureFailure INSTANCE = new FaceTecFaceCaptureFailure();
        public static final Parcelable.Creator<FaceTecFaceCaptureFailure> CREATOR = new Creator();

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<FaceTecFaceCaptureFailure> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FaceTecFaceCaptureFailure createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return FaceTecFaceCaptureFailure.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FaceTecFaceCaptureFailure[] newArray(int i) {
                return new FaceTecFaceCaptureFailure[i];
            }
        }

        private FaceTecFaceCaptureFailure() {
            super(C4871R.drawable.yds_ic_error, C4871R.string.yds_invalid_liveness_attempt_header, C4871R.string.yds_invalid_liveness_attempt_description, null);
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

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecFailureType$FaceTecSessionCancelledFailure;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecFailureType;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class FaceTecSessionCancelledFailure extends LivenessFaceTecFailureType {
        public static final FaceTecSessionCancelledFailure INSTANCE = new FaceTecSessionCancelledFailure();
        public static final Parcelable.Creator<FaceTecSessionCancelledFailure> CREATOR = new Creator();

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<FaceTecSessionCancelledFailure> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FaceTecSessionCancelledFailure createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return FaceTecSessionCancelledFailure.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FaceTecSessionCancelledFailure[] newArray(int i) {
                return new FaceTecSessionCancelledFailure[i];
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private FaceTecSessionCancelledFailure() {
            int i = 0;
            super(i, i, i, null);
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

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecFailureType$NoLocalAttemptsFailure;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecFailureType;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class NoLocalAttemptsFailure extends LivenessFaceTecFailureType {
        public static final NoLocalAttemptsFailure INSTANCE = new NoLocalAttemptsFailure();
        public static final Parcelable.Creator<NoLocalAttemptsFailure> CREATOR = new Creator();

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<NoLocalAttemptsFailure> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NoLocalAttemptsFailure createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return NoLocalAttemptsFailure.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NoLocalAttemptsFailure[] newArray(int i) {
                return new NoLocalAttemptsFailure[i];
            }
        }

        private NoLocalAttemptsFailure() {
            super(C4871R.drawable.yds_ic_blocked, C4871R.string.yds_invalid_liveness_capture_header, C4871R.string.yds_invalid_liveness_capture_description, null);
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

    private LivenessFaceTecFailureType(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public /* synthetic */ LivenessFaceTecFailureType(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }
}
