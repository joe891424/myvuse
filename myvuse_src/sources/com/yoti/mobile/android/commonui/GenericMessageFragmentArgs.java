package com.yoti.mobile.android.commonui;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavArgs;
import com.yoti.mobile.android.commonui.GenericMessageFragment;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GenericMessageFragmentArgs.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 62\u00020\u0001:\u00016B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0085\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\u0006\u00103\u001a\u000204J\t\u00105\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u00067"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/GenericMessageFragmentArgs;", "Landroidx/navigation/NavArgs;", "headerImgResId", "", "titleResId", "title", "", "contentResId", "content", "buttonTextResId", "actionButtonText", "actionButtonIconResId", "secondaryActionButtonTextResId", "secondaryActionButtonText", "secondaryActionButtonIconResId", "customArgs", "Lcom/yoti/mobile/android/commonui/GenericMessageFragment$IGenericMessageCustomArgs;", "(IILjava/lang/String;ILjava/lang/String;ILjava/lang/String;IILjava/lang/String;ILcom/yoti/mobile/android/commonui/GenericMessageFragment$IGenericMessageCustomArgs;)V", "getActionButtonIconResId", "()I", "getActionButtonText", "()Ljava/lang/String;", "getButtonTextResId", "getContent", "getContentResId", "getCustomArgs", "()Lcom/yoti/mobile/android/commonui/GenericMessageFragment$IGenericMessageCustomArgs;", "getHeaderImgResId", "getSecondaryActionButtonIconResId", "getSecondaryActionButtonText", "getSecondaryActionButtonTextResId", "getTitle", "getTitleResId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toString", "Companion", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class GenericMessageFragmentArgs implements NavArgs {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int actionButtonIconResId;
    private final String actionButtonText;
    private final int buttonTextResId;
    private final String content;
    private final int contentResId;
    private final GenericMessageFragment.IGenericMessageCustomArgs customArgs;
    private final int headerImgResId;
    private final int secondaryActionButtonIconResId;
    private final String secondaryActionButtonText;
    private final int secondaryActionButtonTextResId;
    private final String title;
    private final int titleResId;

    @JvmStatic
    public static final GenericMessageFragmentArgs fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getHeaderImgResId() {
        return this.headerImgResId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSecondaryActionButtonText() {
        return this.secondaryActionButtonText;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getSecondaryActionButtonIconResId() {
        return this.secondaryActionButtonIconResId;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final GenericMessageFragment.IGenericMessageCustomArgs getCustomArgs() {
        return this.customArgs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTitleResId() {
        return this.titleResId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getContentResId() {
        return this.contentResId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getButtonTextResId() {
        return this.buttonTextResId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getActionButtonText() {
        return this.actionButtonText;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getActionButtonIconResId() {
        return this.actionButtonIconResId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getSecondaryActionButtonTextResId() {
        return this.secondaryActionButtonTextResId;
    }

    public final GenericMessageFragmentArgs copy(int headerImgResId, int titleResId, String title, int contentResId, String content, int buttonTextResId, String actionButtonText, int actionButtonIconResId, int secondaryActionButtonTextResId, String secondaryActionButtonText, int secondaryActionButtonIconResId, GenericMessageFragment.IGenericMessageCustomArgs customArgs) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(actionButtonText, "actionButtonText");
        return new GenericMessageFragmentArgs(headerImgResId, titleResId, title, contentResId, content, buttonTextResId, actionButtonText, actionButtonIconResId, secondaryActionButtonTextResId, secondaryActionButtonText, secondaryActionButtonIconResId, customArgs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GenericMessageFragmentArgs)) {
            return false;
        }
        GenericMessageFragmentArgs genericMessageFragmentArgs = (GenericMessageFragmentArgs) other;
        return this.headerImgResId == genericMessageFragmentArgs.headerImgResId && this.titleResId == genericMessageFragmentArgs.titleResId && Intrinsics.areEqual(this.title, genericMessageFragmentArgs.title) && this.contentResId == genericMessageFragmentArgs.contentResId && Intrinsics.areEqual(this.content, genericMessageFragmentArgs.content) && this.buttonTextResId == genericMessageFragmentArgs.buttonTextResId && Intrinsics.areEqual(this.actionButtonText, genericMessageFragmentArgs.actionButtonText) && this.actionButtonIconResId == genericMessageFragmentArgs.actionButtonIconResId && this.secondaryActionButtonTextResId == genericMessageFragmentArgs.secondaryActionButtonTextResId && Intrinsics.areEqual(this.secondaryActionButtonText, genericMessageFragmentArgs.secondaryActionButtonText) && this.secondaryActionButtonIconResId == genericMessageFragmentArgs.secondaryActionButtonIconResId && Intrinsics.areEqual(this.customArgs, genericMessageFragmentArgs.customArgs);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((Integer.hashCode(this.headerImgResId) * 31) + Integer.hashCode(this.titleResId)) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.contentResId)) * 31) + this.content.hashCode()) * 31) + Integer.hashCode(this.buttonTextResId)) * 31) + this.actionButtonText.hashCode()) * 31) + Integer.hashCode(this.actionButtonIconResId)) * 31) + Integer.hashCode(this.secondaryActionButtonTextResId)) * 31;
        String str = this.secondaryActionButtonText;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.secondaryActionButtonIconResId)) * 31;
        GenericMessageFragment.IGenericMessageCustomArgs iGenericMessageCustomArgs = this.customArgs;
        return iHashCode2 + (iGenericMessageCustomArgs != null ? iGenericMessageCustomArgs.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GenericMessageFragmentArgs(headerImgResId=");
        sb.append(this.headerImgResId).append(", titleResId=").append(this.titleResId).append(", title=").append(this.title).append(", contentResId=").append(this.contentResId).append(", content=").append(this.content).append(", buttonTextResId=").append(this.buttonTextResId).append(", actionButtonText=").append(this.actionButtonText).append(", actionButtonIconResId=").append(this.actionButtonIconResId).append(", secondaryActionButtonTextResId=").append(this.secondaryActionButtonTextResId).append(", secondaryActionButtonText=").append(this.secondaryActionButtonText).append(", secondaryActionButtonIconResId=").append(this.secondaryActionButtonIconResId).append(", customArgs=");
        sb.append(this.customArgs).append(')');
        return sb.toString();
    }

    public GenericMessageFragmentArgs(int i, int i2, String title, int i3, String content, int i4, String actionButtonText, int i5, int i6, String str, int i7, GenericMessageFragment.IGenericMessageCustomArgs iGenericMessageCustomArgs) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(actionButtonText, "actionButtonText");
        this.headerImgResId = i;
        this.titleResId = i2;
        this.title = title;
        this.contentResId = i3;
        this.content = content;
        this.buttonTextResId = i4;
        this.actionButtonText = actionButtonText;
        this.actionButtonIconResId = i5;
        this.secondaryActionButtonTextResId = i6;
        this.secondaryActionButtonText = str;
        this.secondaryActionButtonIconResId = i7;
        this.customArgs = iGenericMessageCustomArgs;
    }

    public /* synthetic */ GenericMessageFragmentArgs(int i, int i2, String str, int i3, String str2, int i4, String str3, int i5, int i6, String str4, int i7, GenericMessageFragment.IGenericMessageCustomArgs iGenericMessageCustomArgs, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i8 & 2) != 0 ? 0 : i2, (i8 & 4) != 0 ? "''" : str, (i8 & 8) != 0 ? 0 : i3, (i8 & 16) != 0 ? "''" : str2, (i8 & 32) != 0 ? 0 : i4, (i8 & 64) == 0 ? str3 : "''", (i8 & 128) != 0 ? 0 : i5, (i8 & 256) != 0 ? 0 : i6, (i8 & 512) != 0 ? null : str4, (i8 & 1024) == 0 ? i7 : 0, (i8 & 2048) == 0 ? iGenericMessageCustomArgs : null);
    }

    public final int getHeaderImgResId() {
        return this.headerImgResId;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getContentResId() {
        return this.contentResId;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getButtonTextResId() {
        return this.buttonTextResId;
    }

    public final String getActionButtonText() {
        return this.actionButtonText;
    }

    public final int getActionButtonIconResId() {
        return this.actionButtonIconResId;
    }

    public final int getSecondaryActionButtonTextResId() {
        return this.secondaryActionButtonTextResId;
    }

    public final String getSecondaryActionButtonText() {
        return this.secondaryActionButtonText;
    }

    public final int getSecondaryActionButtonIconResId() {
        return this.secondaryActionButtonIconResId;
    }

    public final GenericMessageFragment.IGenericMessageCustomArgs getCustomArgs() {
        return this.customArgs;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("headerImgResId", this.headerImgResId);
        bundle.putInt("titleResId", this.titleResId);
        bundle.putString("title", this.title);
        bundle.putInt("contentResId", this.contentResId);
        bundle.putString("content", this.content);
        bundle.putInt("buttonTextResId", this.buttonTextResId);
        bundle.putString("actionButtonText", this.actionButtonText);
        bundle.putInt("actionButtonIconResId", this.actionButtonIconResId);
        bundle.putInt("secondaryActionButtonTextResId", this.secondaryActionButtonTextResId);
        bundle.putString("secondaryActionButtonText", this.secondaryActionButtonText);
        bundle.putInt("secondaryActionButtonIconResId", this.secondaryActionButtonIconResId);
        if (Parcelable.class.isAssignableFrom(GenericMessageFragment.IGenericMessageCustomArgs.class)) {
            bundle.putParcelable("customArgs", this.customArgs);
        } else if (Serializable.class.isAssignableFrom(GenericMessageFragment.IGenericMessageCustomArgs.class)) {
            bundle.putSerializable("customArgs", (Serializable) this.customArgs);
        }
        return bundle;
    }

    /* JADX INFO: compiled from: GenericMessageFragmentArgs.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/GenericMessageFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/yoti/mobile/android/commonui/GenericMessageFragmentArgs;", "bundle", "Landroid/os/Bundle;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GenericMessageFragmentArgs fromBundle(Bundle bundle) {
            String string;
            String str;
            String str2;
            GenericMessageFragment.IGenericMessageCustomArgs iGenericMessageCustomArgs;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(GenericMessageFragmentArgs.class.getClassLoader());
            if (bundle.containsKey("headerImgResId")) {
                int i = bundle.getInt("headerImgResId");
                int i2 = bundle.containsKey("titleResId") ? bundle.getInt("titleResId") : 0;
                if (bundle.containsKey("title")) {
                    string = bundle.getString("title");
                    if (string == null) {
                        throw new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
                    }
                } else {
                    string = "''";
                }
                int i3 = bundle.containsKey("contentResId") ? bundle.getInt("contentResId") : 0;
                if (bundle.containsKey("content")) {
                    String string2 = bundle.getString("content");
                    if (string2 == null) {
                        throw new IllegalArgumentException("Argument \"content\" is marked as non-null but was passed a null value.");
                    }
                    str = string2;
                } else {
                    str = "''";
                }
                int i4 = bundle.containsKey("buttonTextResId") ? bundle.getInt("buttonTextResId") : 0;
                if (bundle.containsKey("actionButtonText")) {
                    String string3 = bundle.getString("actionButtonText");
                    if (string3 == null) {
                        throw new IllegalArgumentException("Argument \"actionButtonText\" is marked as non-null but was passed a null value.");
                    }
                    str2 = string3;
                } else {
                    str2 = "''";
                }
                int i5 = bundle.containsKey("actionButtonIconResId") ? bundle.getInt("actionButtonIconResId") : 0;
                int i6 = bundle.containsKey("secondaryActionButtonTextResId") ? bundle.getInt("secondaryActionButtonTextResId") : 0;
                String string4 = bundle.containsKey("secondaryActionButtonText") ? bundle.getString("secondaryActionButtonText") : null;
                int i7 = bundle.containsKey("secondaryActionButtonIconResId") ? bundle.getInt("secondaryActionButtonIconResId") : 0;
                if (!bundle.containsKey("customArgs")) {
                    iGenericMessageCustomArgs = null;
                } else if (Parcelable.class.isAssignableFrom(GenericMessageFragment.IGenericMessageCustomArgs.class) || Serializable.class.isAssignableFrom(GenericMessageFragment.IGenericMessageCustomArgs.class)) {
                    iGenericMessageCustomArgs = (GenericMessageFragment.IGenericMessageCustomArgs) bundle.get("customArgs");
                } else {
                    throw new UnsupportedOperationException(GenericMessageFragment.IGenericMessageCustomArgs.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                }
                return new GenericMessageFragmentArgs(i, i2, string, i3, str, i4, str2, i5, i6, string4, i7, iGenericMessageCustomArgs);
            }
            throw new IllegalArgumentException("Required argument \"headerImgResId\" is missing and does not have an android:defaultValue");
        }
    }
}
