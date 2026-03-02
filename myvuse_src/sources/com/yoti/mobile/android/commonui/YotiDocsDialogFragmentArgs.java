package com.yoti.mobile.android.commonui;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavArgs;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YotiDocsDialogFragmentArgs.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/YotiDocsDialogFragmentArgs;", "Landroidx/navigation/NavArgs;", "ydsDialogTitle", "", "ydsDialogText", "ydsDialogPositiveButtonText", "ydsDialogNegativeButtonText", "ydsDialogType", "Lcom/yoti/mobile/android/commonui/DialogType;", "(IIIILcom/yoti/mobile/android/commonui/DialogType;)V", "getYdsDialogNegativeButtonText", "()I", "getYdsDialogPositiveButtonText", "getYdsDialogText", "getYdsDialogTitle", "getYdsDialogType", "()Lcom/yoti/mobile/android/commonui/DialogType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toString", "", "Companion", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class YotiDocsDialogFragmentArgs implements NavArgs {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int ydsDialogNegativeButtonText;
    private final int ydsDialogPositiveButtonText;
    private final int ydsDialogText;
    private final int ydsDialogTitle;
    private final DialogType ydsDialogType;

    public static /* synthetic */ YotiDocsDialogFragmentArgs copy$default(YotiDocsDialogFragmentArgs yotiDocsDialogFragmentArgs, int i, int i2, int i3, int i4, DialogType dialogType, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = yotiDocsDialogFragmentArgs.ydsDialogTitle;
        }
        if ((i5 & 2) != 0) {
            i2 = yotiDocsDialogFragmentArgs.ydsDialogText;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = yotiDocsDialogFragmentArgs.ydsDialogPositiveButtonText;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            i4 = yotiDocsDialogFragmentArgs.ydsDialogNegativeButtonText;
        }
        int i8 = i4;
        if ((i5 & 16) != 0) {
            dialogType = yotiDocsDialogFragmentArgs.ydsDialogType;
        }
        return yotiDocsDialogFragmentArgs.copy(i, i6, i7, i8, dialogType);
    }

    @JvmStatic
    public static final YotiDocsDialogFragmentArgs fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getYdsDialogTitle() {
        return this.ydsDialogTitle;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getYdsDialogText() {
        return this.ydsDialogText;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getYdsDialogPositiveButtonText() {
        return this.ydsDialogPositiveButtonText;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getYdsDialogNegativeButtonText() {
        return this.ydsDialogNegativeButtonText;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final DialogType getYdsDialogType() {
        return this.ydsDialogType;
    }

    public final YotiDocsDialogFragmentArgs copy(int ydsDialogTitle, int ydsDialogText, int ydsDialogPositiveButtonText, int ydsDialogNegativeButtonText, DialogType ydsDialogType) {
        Intrinsics.checkNotNullParameter(ydsDialogType, "ydsDialogType");
        return new YotiDocsDialogFragmentArgs(ydsDialogTitle, ydsDialogText, ydsDialogPositiveButtonText, ydsDialogNegativeButtonText, ydsDialogType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YotiDocsDialogFragmentArgs)) {
            return false;
        }
        YotiDocsDialogFragmentArgs yotiDocsDialogFragmentArgs = (YotiDocsDialogFragmentArgs) other;
        return this.ydsDialogTitle == yotiDocsDialogFragmentArgs.ydsDialogTitle && this.ydsDialogText == yotiDocsDialogFragmentArgs.ydsDialogText && this.ydsDialogPositiveButtonText == yotiDocsDialogFragmentArgs.ydsDialogPositiveButtonText && this.ydsDialogNegativeButtonText == yotiDocsDialogFragmentArgs.ydsDialogNegativeButtonText && this.ydsDialogType == yotiDocsDialogFragmentArgs.ydsDialogType;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.ydsDialogTitle) * 31) + Integer.hashCode(this.ydsDialogText)) * 31) + Integer.hashCode(this.ydsDialogPositiveButtonText)) * 31) + Integer.hashCode(this.ydsDialogNegativeButtonText)) * 31) + this.ydsDialogType.hashCode();
    }

    public String toString() {
        return "YotiDocsDialogFragmentArgs(ydsDialogTitle=" + this.ydsDialogTitle + ", ydsDialogText=" + this.ydsDialogText + ", ydsDialogPositiveButtonText=" + this.ydsDialogPositiveButtonText + ", ydsDialogNegativeButtonText=" + this.ydsDialogNegativeButtonText + ", ydsDialogType=" + this.ydsDialogType + ')';
    }

    public YotiDocsDialogFragmentArgs(int i, int i2, int i3, int i4, DialogType ydsDialogType) {
        Intrinsics.checkNotNullParameter(ydsDialogType, "ydsDialogType");
        this.ydsDialogTitle = i;
        this.ydsDialogText = i2;
        this.ydsDialogPositiveButtonText = i3;
        this.ydsDialogNegativeButtonText = i4;
        this.ydsDialogType = ydsDialogType;
    }

    public final int getYdsDialogTitle() {
        return this.ydsDialogTitle;
    }

    public final int getYdsDialogText() {
        return this.ydsDialogText;
    }

    public final int getYdsDialogPositiveButtonText() {
        return this.ydsDialogPositiveButtonText;
    }

    public final int getYdsDialogNegativeButtonText() {
        return this.ydsDialogNegativeButtonText;
    }

    public /* synthetic */ YotiDocsDialogFragmentArgs(int i, int i2, int i3, int i4, DialogType dialogType, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, i2, i3, (i5 & 8) != 0 ? 0 : i4, (i5 & 16) != 0 ? DialogType.DEFAULT : dialogType);
    }

    public final DialogType getYdsDialogType() {
        return this.ydsDialogType;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("ydsDialogTitle", this.ydsDialogTitle);
        bundle.putInt("ydsDialogText", this.ydsDialogText);
        bundle.putInt("ydsDialogPositiveButtonText", this.ydsDialogPositiveButtonText);
        bundle.putInt("ydsDialogNegativeButtonText", this.ydsDialogNegativeButtonText);
        if (Parcelable.class.isAssignableFrom(DialogType.class)) {
            bundle.putParcelable("ydsDialogType", (Parcelable) this.ydsDialogType);
        } else if (Serializable.class.isAssignableFrom(DialogType.class)) {
            bundle.putSerializable("ydsDialogType", this.ydsDialogType);
        }
        return bundle;
    }

    /* JADX INFO: compiled from: YotiDocsDialogFragmentArgs.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/YotiDocsDialogFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/yoti/mobile/android/commonui/YotiDocsDialogFragmentArgs;", "bundle", "Landroid/os/Bundle;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final YotiDocsDialogFragmentArgs fromBundle(Bundle bundle) {
            DialogType dialogType;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(YotiDocsDialogFragmentArgs.class.getClassLoader());
            int i = bundle.containsKey("ydsDialogTitle") ? bundle.getInt("ydsDialogTitle") : 0;
            if (bundle.containsKey("ydsDialogText")) {
                int i2 = bundle.getInt("ydsDialogText");
                if (bundle.containsKey("ydsDialogPositiveButtonText")) {
                    int i3 = bundle.getInt("ydsDialogPositiveButtonText");
                    int i4 = bundle.containsKey("ydsDialogNegativeButtonText") ? bundle.getInt("ydsDialogNegativeButtonText") : 0;
                    if (bundle.containsKey("ydsDialogType")) {
                        if (Parcelable.class.isAssignableFrom(DialogType.class) || Serializable.class.isAssignableFrom(DialogType.class)) {
                            dialogType = (DialogType) bundle.get("ydsDialogType");
                            if (dialogType == null) {
                                throw new IllegalArgumentException("Argument \"ydsDialogType\" is marked as non-null but was passed a null value.");
                            }
                        } else {
                            throw new UnsupportedOperationException(DialogType.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                        }
                    } else {
                        dialogType = DialogType.DEFAULT;
                    }
                    return new YotiDocsDialogFragmentArgs(i, i2, i3, i4, dialogType);
                }
                throw new IllegalArgumentException("Required argument \"ydsDialogPositiveButtonText\" is missing and does not have an android:defaultValue");
            }
            throw new IllegalArgumentException("Required argument \"ydsDialogText\" is missing and does not have an android:defaultValue");
        }
    }
}
