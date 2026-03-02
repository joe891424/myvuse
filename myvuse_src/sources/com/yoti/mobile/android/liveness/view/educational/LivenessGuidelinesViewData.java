package com.yoti.mobile.android.liveness.view.educational;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001:\u0001\u0013BI\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData;", "Landroid/os/Parcelable;", "descriptionFirst", "", "imageRowFirst", "Lkotlin/Pair;", "descriptionSecond", "imageRowSecond", "navigationIcon", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "(ILkotlin/Pair;ILkotlin/Pair;Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;)V", "getDescriptionFirst", "()I", "getDescriptionSecond", "getImageRowFirst", "()Lkotlin/Pair;", "getImageRowSecond", "getNavigationIcon", "()Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "Factory", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class LivenessGuidelinesViewData implements Parcelable {
    private final int descriptionFirst;
    private final int descriptionSecond;
    private final Pair<Integer, Integer> imageRowFirst;
    private final Pair<Integer, Integer> imageRowSecond;
    private final NavigationIcon navigationIcon;

    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", ExifInterface.LONGITUDE_EAST, "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "", "create", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData;", "failureType", "(Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;)Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public interface Factory<E extends LivenessUploadFailureType> {

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class DefaultImpls {
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ LivenessGuidelinesViewData create$default(Factory factory, LivenessUploadFailureType livenessUploadFailureType, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
                }
                if ((i & 1) != 0) {
                    livenessUploadFailureType = null;
                }
                return factory.create(livenessUploadFailureType);
            }
        }

        LivenessGuidelinesViewData create(E failureType);
    }

    public LivenessGuidelinesViewData(int i, Pair<Integer, Integer> imageRowFirst, int i2, Pair<Integer, Integer> imageRowSecond, NavigationIcon navigationIcon) {
        Intrinsics.checkNotNullParameter(imageRowFirst, "imageRowFirst");
        Intrinsics.checkNotNullParameter(imageRowSecond, "imageRowSecond");
        Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
        this.descriptionFirst = i;
        this.imageRowFirst = imageRowFirst;
        this.descriptionSecond = i2;
        this.imageRowSecond = imageRowSecond;
        this.navigationIcon = navigationIcon;
    }

    public final int getDescriptionFirst() {
        return this.descriptionFirst;
    }

    public final int getDescriptionSecond() {
        return this.descriptionSecond;
    }

    public final Pair<Integer, Integer> getImageRowFirst() {
        return this.imageRowFirst;
    }

    public final Pair<Integer, Integer> getImageRowSecond() {
        return this.imageRowSecond;
    }

    public final NavigationIcon getNavigationIcon() {
        return this.navigationIcon;
    }
}
