package com.yoti.mobile.android.mrtd.view;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import com.yoti.mobile.android.mrtd.C4900R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdErrorFragmentArgs;", "Landroidx/navigation/NavArgs;", "headerImgResId", "", "contentResId", "buttonTextResId", "actionButtonIconResId", "(IIII)V", "getActionButtonIconResId", "()I", "getButtonTextResId", "getContentResId", "getHeaderImgResId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toString", "", "Companion", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class MrtdErrorFragmentArgs implements NavArgs {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int actionButtonIconResId;
    private final int buttonTextResId;
    private final int contentResId;
    private final int headerImgResId;

    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdErrorFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/yoti/mobile/android/mrtd/view/MrtdErrorFragmentArgs;", "bundle", "Landroid/os/Bundle;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MrtdErrorFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(MrtdErrorFragmentArgs.class.getClassLoader());
            return new MrtdErrorFragmentArgs(bundle.containsKey("headerImgResId") ? bundle.getInt("headerImgResId") : C4900R.drawable.yds_ic_error, bundle.containsKey("contentResId") ? bundle.getInt("contentResId") : C4900R.string.ios_android_yds_invalid_nfc_process_description, bundle.containsKey("buttonTextResId") ? bundle.getInt("buttonTextResId") : C4900R.string.ios_android_yds_invalid_nfc_process_primary_cta, bundle.containsKey("actionButtonIconResId") ? bundle.getInt("actionButtonIconResId") : C4900R.drawable.yds_ico_upload);
        }
    }

    public MrtdErrorFragmentArgs() {
        this(0, 0, 0, 0, 15, null);
    }

    public MrtdErrorFragmentArgs(int i, int i2, int i3, int i4) {
        this.headerImgResId = i;
        this.contentResId = i2;
        this.buttonTextResId = i3;
        this.actionButtonIconResId = i4;
    }

    public /* synthetic */ MrtdErrorFragmentArgs(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? C4900R.drawable.yds_ic_error : i, (i5 & 2) != 0 ? C4900R.string.ios_android_yds_invalid_nfc_process_description : i2, (i5 & 4) != 0 ? C4900R.string.ios_android_yds_invalid_nfc_process_primary_cta : i3, (i5 & 8) != 0 ? C4900R.drawable.yds_ico_upload : i4);
    }

    public static /* synthetic */ MrtdErrorFragmentArgs copy$default(MrtdErrorFragmentArgs mrtdErrorFragmentArgs, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = mrtdErrorFragmentArgs.headerImgResId;
        }
        if ((i5 & 2) != 0) {
            i2 = mrtdErrorFragmentArgs.contentResId;
        }
        if ((i5 & 4) != 0) {
            i3 = mrtdErrorFragmentArgs.buttonTextResId;
        }
        if ((i5 & 8) != 0) {
            i4 = mrtdErrorFragmentArgs.actionButtonIconResId;
        }
        return mrtdErrorFragmentArgs.copy(i, i2, i3, i4);
    }

    @JvmStatic
    public static final MrtdErrorFragmentArgs fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getHeaderImgResId() {
        return this.headerImgResId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getContentResId() {
        return this.contentResId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getButtonTextResId() {
        return this.buttonTextResId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getActionButtonIconResId() {
        return this.actionButtonIconResId;
    }

    public final MrtdErrorFragmentArgs copy(int headerImgResId, int contentResId, int buttonTextResId, int actionButtonIconResId) {
        return new MrtdErrorFragmentArgs(headerImgResId, contentResId, buttonTextResId, actionButtonIconResId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MrtdErrorFragmentArgs)) {
            return false;
        }
        MrtdErrorFragmentArgs mrtdErrorFragmentArgs = (MrtdErrorFragmentArgs) other;
        return this.headerImgResId == mrtdErrorFragmentArgs.headerImgResId && this.contentResId == mrtdErrorFragmentArgs.contentResId && this.buttonTextResId == mrtdErrorFragmentArgs.buttonTextResId && this.actionButtonIconResId == mrtdErrorFragmentArgs.actionButtonIconResId;
    }

    public final int getActionButtonIconResId() {
        return this.actionButtonIconResId;
    }

    public final int getButtonTextResId() {
        return this.buttonTextResId;
    }

    public final int getContentResId() {
        return this.contentResId;
    }

    public final int getHeaderImgResId() {
        return this.headerImgResId;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.headerImgResId) * 31) + Integer.hashCode(this.contentResId)) * 31) + Integer.hashCode(this.buttonTextResId)) * 31) + Integer.hashCode(this.actionButtonIconResId);
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("headerImgResId", this.headerImgResId);
        bundle.putInt("contentResId", this.contentResId);
        bundle.putInt("buttonTextResId", this.buttonTextResId);
        bundle.putInt("actionButtonIconResId", this.actionButtonIconResId);
        return bundle;
    }

    public String toString() {
        return "MrtdErrorFragmentArgs(headerImgResId=" + this.headerImgResId + ", contentResId=" + this.contentResId + ", buttonTextResId=" + this.buttonTextResId + ", actionButtonIconResId=" + this.actionButtonIconResId + ')';
    }
}
