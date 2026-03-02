package com.yoti.mobile.android.commonui.moreabout;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavArgs;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MoreAboutFragmentArgs.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentArgs;", "Landroidx/navigation/NavArgs;", "moreAboutFragmentContent", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentContent;", "(Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentContent;)V", "getMoreAboutFragmentContent", "()Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentContent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toString", "", "Companion", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class MoreAboutFragmentArgs implements NavArgs {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MoreAboutFragmentContent moreAboutFragmentContent;

    public static /* synthetic */ MoreAboutFragmentArgs copy$default(MoreAboutFragmentArgs moreAboutFragmentArgs, MoreAboutFragmentContent moreAboutFragmentContent, int i, Object obj) {
        if ((i & 1) != 0) {
            moreAboutFragmentContent = moreAboutFragmentArgs.moreAboutFragmentContent;
        }
        return moreAboutFragmentArgs.copy(moreAboutFragmentContent);
    }

    @JvmStatic
    public static final MoreAboutFragmentArgs fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MoreAboutFragmentContent getMoreAboutFragmentContent() {
        return this.moreAboutFragmentContent;
    }

    public final MoreAboutFragmentArgs copy(MoreAboutFragmentContent moreAboutFragmentContent) {
        Intrinsics.checkNotNullParameter(moreAboutFragmentContent, "moreAboutFragmentContent");
        return new MoreAboutFragmentArgs(moreAboutFragmentContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MoreAboutFragmentArgs) && Intrinsics.areEqual(this.moreAboutFragmentContent, ((MoreAboutFragmentArgs) other).moreAboutFragmentContent);
    }

    public int hashCode() {
        return this.moreAboutFragmentContent.hashCode();
    }

    public String toString() {
        return "MoreAboutFragmentArgs(moreAboutFragmentContent=" + this.moreAboutFragmentContent + ')';
    }

    public MoreAboutFragmentArgs(MoreAboutFragmentContent moreAboutFragmentContent) {
        Intrinsics.checkNotNullParameter(moreAboutFragmentContent, "moreAboutFragmentContent");
        this.moreAboutFragmentContent = moreAboutFragmentContent;
    }

    public final MoreAboutFragmentContent getMoreAboutFragmentContent() {
        return this.moreAboutFragmentContent;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (Parcelable.class.isAssignableFrom(MoreAboutFragmentContent.class)) {
            bundle.putParcelable("moreAboutFragmentContent", this.moreAboutFragmentContent);
        } else if (Serializable.class.isAssignableFrom(MoreAboutFragmentContent.class)) {
            bundle.putSerializable("moreAboutFragmentContent", (Serializable) this.moreAboutFragmentContent);
        } else {
            throw new UnsupportedOperationException(MoreAboutFragmentContent.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
        return bundle;
    }

    /* JADX INFO: compiled from: MoreAboutFragmentArgs.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentArgs;", "bundle", "Landroid/os/Bundle;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MoreAboutFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(MoreAboutFragmentArgs.class.getClassLoader());
            if (bundle.containsKey("moreAboutFragmentContent")) {
                if (Parcelable.class.isAssignableFrom(MoreAboutFragmentContent.class) || Serializable.class.isAssignableFrom(MoreAboutFragmentContent.class)) {
                    MoreAboutFragmentContent moreAboutFragmentContent = (MoreAboutFragmentContent) bundle.get("moreAboutFragmentContent");
                    if (moreAboutFragmentContent == null) {
                        throw new IllegalArgumentException("Argument \"moreAboutFragmentContent\" is marked as non-null but was passed a null value.");
                    }
                    return new MoreAboutFragmentArgs(moreAboutFragmentContent);
                }
                throw new UnsupportedOperationException(MoreAboutFragmentContent.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
            throw new IllegalArgumentException("Required argument \"moreAboutFragmentContent\" is missing and does not have an android:defaultValue");
        }
    }
}
