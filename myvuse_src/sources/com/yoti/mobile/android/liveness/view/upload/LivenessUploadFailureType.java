package com.yoti.mobile.android.liveness.view.upload;

import com.yoti.mobile.android.commonui.GenericMessageFragment;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0001\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$FeatureFailureType;", "Lcom/yoti/mobile/android/commonui/GenericMessageFragment$IGenericMessageCustomArgs;", "secondaryActionButtonText", "", "secondaryActionButtonIcon", "icon", "messageTitleId", "messageTextId", "(IIIII)V", "getSecondaryActionButtonIcon", "()I", "getSecondaryActionButtonText", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class LivenessUploadFailureType extends YdsFailureType.FeatureFailureType implements GenericMessageFragment.IGenericMessageCustomArgs {
    private final int secondaryActionButtonIcon;
    private final int secondaryActionButtonText;

    public /* synthetic */ LivenessUploadFailureType(int i, int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, i3, i4, i5);
    }

    public final int getSecondaryActionButtonIcon() {
        return this.secondaryActionButtonIcon;
    }

    public final int getSecondaryActionButtonText() {
        return this.secondaryActionButtonText;
    }

    public LivenessUploadFailureType(int i, int i2, int i3, int i4, int i5) {
        super(i3, i4, i5);
        this.secondaryActionButtonText = i;
        this.secondaryActionButtonIcon = i2;
    }
}
