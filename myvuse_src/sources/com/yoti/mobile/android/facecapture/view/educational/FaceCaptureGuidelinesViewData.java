package com.yoti.mobile.android.facecapture.view.educational;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.facecapture.C4832R;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u000b\f\r\u000e\u000fBK\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n\u0082\u0001\u0005\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData;", "descriptionFirst", "", "imageRowFirst", "Lkotlin/Pair;", "descriptionSecond", "imageRowSecond", "navigationIcon", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "(ILkotlin/Pair;ILkotlin/Pair;Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;)V", "FaceNotFound", "FacePosition", "ImageTooBright", "ImageTooDark", "MultipleFaces", "Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData$FaceNotFound;", "Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData$MultipleFaces;", "Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData$FacePosition;", "Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData$ImageTooBright;", "Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData$ImageTooDark;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class FaceCaptureGuidelinesViewData extends LivenessGuidelinesViewData {

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData$FaceNotFound;", "Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class FaceNotFound extends FaceCaptureGuidelinesViewData {
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
            super(C4832R.string.yds_facecapture_guidelines_first_decription, TuplesKt.m5605to(Integer.valueOf(C4832R.drawable.yds_liveness_position_correct), Integer.valueOf(C4832R.drawable.yds_liveness_position_incorrect)), C4832R.string.yds_facecapture_guidelines_second_description, TuplesKt.m5605to(Integer.valueOf(C4832R.drawable.yds_liveness_lighting_correct), Integer.valueOf(C4832R.drawable.yds_liveness_lighting_incorrect)), NavigationIcon.BACK_BLUE, null);
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

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData$FacePosition;", "Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class FacePosition extends FaceCaptureGuidelinesViewData {
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
            super(C4832R.string.yds_facecapture_guidelines_first_decription, TuplesKt.m5605to(Integer.valueOf(C4832R.drawable.yds_liveness_position_correct), Integer.valueOf(C4832R.drawable.yds_liveness_position_incorrect)), C4832R.string.yds_facecapture_guidelines_second_description, TuplesKt.m5605to(Integer.valueOf(C4832R.drawable.yds_liveness_lighting_correct), Integer.valueOf(C4832R.drawable.yds_liveness_lighting_incorrect)), NavigationIcon.BACK_BLUE, null);
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

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData$ImageTooBright;", "Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class ImageTooBright extends FaceCaptureGuidelinesViewData {
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
            super(C4832R.string.yds_facecapture_guidelines_second_description, TuplesKt.m5605to(Integer.valueOf(C4832R.drawable.yds_liveness_lighting_correct), Integer.valueOf(C4832R.drawable.yds_liveness_lighting_too_bright)), C4832R.string.yds_facecapture_guidelines_first_decription, TuplesKt.m5605to(Integer.valueOf(C4832R.drawable.yds_liveness_position_correct), Integer.valueOf(C4832R.drawable.yds_liveness_position_incorrect)), NavigationIcon.BACK_BLUE, null);
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

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData$ImageTooDark;", "Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class ImageTooDark extends FaceCaptureGuidelinesViewData {
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
            super(C4832R.string.yds_facecapture_guidelines_second_description, TuplesKt.m5605to(Integer.valueOf(C4832R.drawable.yds_liveness_lighting_correct), Integer.valueOf(C4832R.drawable.yds_liveness_lighting_incorrect)), C4832R.string.yds_facecapture_guidelines_first_decription, TuplesKt.m5605to(Integer.valueOf(C4832R.drawable.yds_liveness_position_correct), Integer.valueOf(C4832R.drawable.yds_liveness_position_incorrect)), NavigationIcon.BACK_BLUE, null);
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

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData$MultipleFaces;", "Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewData;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class MultipleFaces extends FaceCaptureGuidelinesViewData {
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
            super(C4832R.string.yds_face_capture_education_two_faces, TuplesKt.m5605to(Integer.valueOf(C4832R.drawable.yds_liveness_lighting_correct), Integer.valueOf(C4832R.drawable.yds_liveness_two_faces)), C4832R.string.yds_facecapture_guidelines_first_decription, TuplesKt.m5605to(Integer.valueOf(C4832R.drawable.yds_liveness_position_correct), Integer.valueOf(C4832R.drawable.yds_liveness_position_incorrect)), NavigationIcon.BACK_BLUE, null);
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

    private FaceCaptureGuidelinesViewData(int i, Pair<Integer, Integer> pair, int i2, Pair<Integer, Integer> pair2, NavigationIcon navigationIcon) {
        super(i, pair, i2, pair2, navigationIcon);
    }

    public /* synthetic */ FaceCaptureGuidelinesViewData(int i, Pair pair, int i2, Pair pair2, NavigationIcon navigationIcon, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, pair, i2, pair2, navigationIcon);
    }
}
