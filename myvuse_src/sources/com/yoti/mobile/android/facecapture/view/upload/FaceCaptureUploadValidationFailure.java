package com.yoti.mobile.android.facecapture.view.upload;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.facecapture.C4832R;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB%\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006\u0082\u0001\u0005\f\r\u000e\u000f\u0010¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "icon", "", "messageTitleId", "messageTextId", "(III)V", "FaceNotFound", "FacePosition", "ImageTooBright", "ImageTooDark", "MultipleFaces", "Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure$FaceNotFound;", "Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure$MultipleFaces;", "Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure$FacePosition;", "Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure$ImageTooBright;", "Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure$ImageTooDark;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class FaceCaptureUploadValidationFailure extends LivenessUploadFailureType {

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure$FaceNotFound;", "Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class FaceNotFound extends FaceCaptureUploadValidationFailure {
        public static final FaceNotFound INSTANCE = new FaceNotFound();
        public static final Parcelable.Creator<FaceNotFound> CREATOR = new Creator();

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<FaceNotFound> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FaceNotFound createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return FaceNotFound.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FaceNotFound[] newArray(int i) {
                return new FaceNotFound[i];
            }
        }

        private FaceNotFound() {
            super(C4832R.drawable.yds_ic_warning_triangle, C4832R.string.yds_face_capture_error_scan_error_header, C4832R.string.yds_face_capture_error_scan_error_face_not_found_description, null);
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

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure$FacePosition;", "Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class FacePosition extends FaceCaptureUploadValidationFailure {
        public static final FacePosition INSTANCE = new FacePosition();
        public static final Parcelable.Creator<FacePosition> CREATOR = new Creator();

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<FacePosition> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FacePosition createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return FacePosition.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FacePosition[] newArray(int i) {
                return new FacePosition[i];
            }
        }

        private FacePosition() {
            super(C4832R.drawable.yds_ic_warning_triangle, C4832R.string.yds_face_capture_error_scan_error_header, C4832R.string.yds_face_capture_error_scan_error_face_position_description, null);
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

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure$ImageTooBright;", "Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class ImageTooBright extends FaceCaptureUploadValidationFailure {
        public static final ImageTooBright INSTANCE = new ImageTooBright();
        public static final Parcelable.Creator<ImageTooBright> CREATOR = new Creator();

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<ImageTooBright> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ImageTooBright createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return ImageTooBright.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ImageTooBright[] newArray(int i) {
                return new ImageTooBright[i];
            }
        }

        private ImageTooBright() {
            super(C4832R.drawable.yds_ic_warning_triangle, C4832R.string.yds_face_capture_error_scan_error_header, C4832R.string.yds_face_capture_error_scan_error_too_bright_description, null);
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

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure$ImageTooDark;", "Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class ImageTooDark extends FaceCaptureUploadValidationFailure {
        public static final ImageTooDark INSTANCE = new ImageTooDark();
        public static final Parcelable.Creator<ImageTooDark> CREATOR = new Creator();

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<ImageTooDark> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ImageTooDark createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return ImageTooDark.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ImageTooDark[] newArray(int i) {
                return new ImageTooDark[i];
            }
        }

        private ImageTooDark() {
            super(C4832R.drawable.yds_ic_warning_triangle, C4832R.string.yds_face_capture_error_scan_error_header, C4832R.string.yds_face_capture_error_scan_error_too_dark_description, null);
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

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure$MultipleFaces;", "Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class MultipleFaces extends FaceCaptureUploadValidationFailure {
        public static final MultipleFaces INSTANCE = new MultipleFaces();
        public static final Parcelable.Creator<MultipleFaces> CREATOR = new Creator();

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<MultipleFaces> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MultipleFaces createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return MultipleFaces.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MultipleFaces[] newArray(int i) {
                return new MultipleFaces[i];
            }
        }

        private MultipleFaces() {
            super(C4832R.drawable.yds_ic_warning_triangle, C4832R.string.yds_face_capture_error_scan_error_header, C4832R.string.yds_face_capture_error_scan_error_multiple_faces_description, null);
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

    private FaceCaptureUploadValidationFailure(int i, int i2, int i3) {
        super(C4832R.string.yds_face_capture_error_see_guidelines, C4832R.drawable.yds_ic_ico_chevron_right, i, i2, i3);
    }

    public /* synthetic */ FaceCaptureUploadValidationFailure(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }
}
