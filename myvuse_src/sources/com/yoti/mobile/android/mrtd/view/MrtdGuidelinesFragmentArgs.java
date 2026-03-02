package com.yoti.mobile.android.mrtd.view;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdGuidelinesFragmentArgs;", "Landroidx/navigation/NavArgs;", "titleResId", "", "(I)V", "getTitleResId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toString", "", "Companion", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class MrtdGuidelinesFragmentArgs implements NavArgs {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int titleResId;

    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdGuidelinesFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/yoti/mobile/android/mrtd/view/MrtdGuidelinesFragmentArgs;", "bundle", "Landroid/os/Bundle;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MrtdGuidelinesFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(MrtdGuidelinesFragmentArgs.class.getClassLoader());
            if (bundle.containsKey("titleResId")) {
                return new MrtdGuidelinesFragmentArgs(bundle.getInt("titleResId"));
            }
            throw new IllegalArgumentException("Required argument \"titleResId\" is missing and does not have an android:defaultValue");
        }
    }

    public MrtdGuidelinesFragmentArgs(int i) {
        this.titleResId = i;
    }

    public static /* synthetic */ MrtdGuidelinesFragmentArgs copy$default(MrtdGuidelinesFragmentArgs mrtdGuidelinesFragmentArgs, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mrtdGuidelinesFragmentArgs.titleResId;
        }
        return mrtdGuidelinesFragmentArgs.copy(i);
    }

    @JvmStatic
    public static final MrtdGuidelinesFragmentArgs fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTitleResId() {
        return this.titleResId;
    }

    public final MrtdGuidelinesFragmentArgs copy(int titleResId) {
        return new MrtdGuidelinesFragmentArgs(titleResId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MrtdGuidelinesFragmentArgs) && this.titleResId == ((MrtdGuidelinesFragmentArgs) other).titleResId;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public int hashCode() {
        return Integer.hashCode(this.titleResId);
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("titleResId", this.titleResId);
        return bundle;
    }

    public String toString() {
        return "MrtdGuidelinesFragmentArgs(titleResId=" + this.titleResId + ')';
    }
}
