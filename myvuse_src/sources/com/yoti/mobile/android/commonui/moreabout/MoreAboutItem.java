package com.yoti.mobile.android.commonui.moreabout;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MoreAboutItem.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem;", "", "itemType", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItemType;", "(Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItemType;)V", "getItemType", "()Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItemType;", "AppbarItem", "MoreAboutAccordionItem", "MoreAboutDescItem", "MoreAboutLogoItem", "MoreAboutSeparatorItem", "MoreAboutTitleItem", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$AppbarItem;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutTitleItem;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutDescItem;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutSeparatorItem;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutAccordionItem;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutLogoItem;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class MoreAboutItem {
    private final MoreAboutItemType itemType;

    public /* synthetic */ MoreAboutItem(MoreAboutItemType moreAboutItemType, DefaultConstructorMarker defaultConstructorMarker) {
        this(moreAboutItemType);
    }

    private MoreAboutItem(MoreAboutItemType moreAboutItemType) {
        this.itemType = moreAboutItemType;
    }

    public final MoreAboutItemType getItemType() {
        return this.itemType;
    }

    /* JADX INFO: compiled from: MoreAboutItem.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005HÖ\u0001¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$AppbarItem;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem;", "Landroid/os/Parcelable;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class AppbarItem extends MoreAboutItem implements Parcelable {
        public static final AppbarItem INSTANCE = new AppbarItem();
        public static final Parcelable.Creator<AppbarItem> CREATOR = new Creator();

        /* JADX INFO: compiled from: MoreAboutItem.kt */
        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<AppbarItem> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AppbarItem createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return AppbarItem.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AppbarItem[] newArray(int i) {
                return new AppbarItem[i];
            }
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

        private AppbarItem() {
            super(MoreAboutItemType.APPBAR, null);
        }
    }

    /* JADX INFO: compiled from: MoreAboutItem.kt */
    @Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutTitleItem;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem;", "Landroid/os/Parcelable;", "resId", "", "(I)V", "getResId", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class MoreAboutTitleItem extends MoreAboutItem implements Parcelable {
        public static final Parcelable.Creator<MoreAboutTitleItem> CREATOR = new Creator();
        private final int resId;

        /* JADX INFO: compiled from: MoreAboutItem.kt */
        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<MoreAboutTitleItem> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MoreAboutTitleItem createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new MoreAboutTitleItem(parcel.readInt());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MoreAboutTitleItem[] newArray(int i) {
                return new MoreAboutTitleItem[i];
            }
        }

        public static /* synthetic */ MoreAboutTitleItem copy$default(MoreAboutTitleItem moreAboutTitleItem, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = moreAboutTitleItem.resId;
            }
            return moreAboutTitleItem.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getResId() {
            return this.resId;
        }

        public final MoreAboutTitleItem copy(int resId) {
            return new MoreAboutTitleItem(resId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MoreAboutTitleItem) && this.resId == ((MoreAboutTitleItem) other).resId;
        }

        public int hashCode() {
            return Integer.hashCode(this.resId);
        }

        public String toString() {
            return "MoreAboutTitleItem(resId=" + this.resId + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.resId);
        }

        public final int getResId() {
            return this.resId;
        }

        public MoreAboutTitleItem(int i) {
            super(MoreAboutItemType.TITLE, null);
            this.resId = i;
        }
    }

    /* JADX INFO: compiled from: MoreAboutItem.kt */
    @Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutDescItem;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem;", "Landroid/os/Parcelable;", "resId", "", "(I)V", "getResId", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class MoreAboutDescItem extends MoreAboutItem implements Parcelable {
        public static final Parcelable.Creator<MoreAboutDescItem> CREATOR = new Creator();
        private final int resId;

        /* JADX INFO: compiled from: MoreAboutItem.kt */
        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<MoreAboutDescItem> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MoreAboutDescItem createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new MoreAboutDescItem(parcel.readInt());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MoreAboutDescItem[] newArray(int i) {
                return new MoreAboutDescItem[i];
            }
        }

        public static /* synthetic */ MoreAboutDescItem copy$default(MoreAboutDescItem moreAboutDescItem, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = moreAboutDescItem.resId;
            }
            return moreAboutDescItem.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getResId() {
            return this.resId;
        }

        public final MoreAboutDescItem copy(int resId) {
            return new MoreAboutDescItem(resId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MoreAboutDescItem) && this.resId == ((MoreAboutDescItem) other).resId;
        }

        public int hashCode() {
            return Integer.hashCode(this.resId);
        }

        public String toString() {
            return "MoreAboutDescItem(resId=" + this.resId + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.resId);
        }

        public final int getResId() {
            return this.resId;
        }

        public MoreAboutDescItem(int i) {
            super(MoreAboutItemType.DESCRIPTION, null);
            this.resId = i;
        }
    }

    /* JADX INFO: compiled from: MoreAboutItem.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005HÖ\u0001¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutSeparatorItem;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem;", "Landroid/os/Parcelable;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class MoreAboutSeparatorItem extends MoreAboutItem implements Parcelable {
        public static final MoreAboutSeparatorItem INSTANCE = new MoreAboutSeparatorItem();
        public static final Parcelable.Creator<MoreAboutSeparatorItem> CREATOR = new Creator();

        /* JADX INFO: compiled from: MoreAboutItem.kt */
        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<MoreAboutSeparatorItem> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MoreAboutSeparatorItem createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return MoreAboutSeparatorItem.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MoreAboutSeparatorItem[] newArray(int i) {
                return new MoreAboutSeparatorItem[i];
            }
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

        private MoreAboutSeparatorItem() {
            super(MoreAboutItemType.SEPARATOR, null);
        }
    }

    /* JADX INFO: compiled from: MoreAboutItem.kt */
    @Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutAccordionItem;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem;", "Landroid/os/Parcelable;", "titleResId", "", "messageResId", "(II)V", "getMessageResId", "()I", "getTitleResId", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class MoreAboutAccordionItem extends MoreAboutItem implements Parcelable {
        public static final Parcelable.Creator<MoreAboutAccordionItem> CREATOR = new Creator();
        private final int messageResId;
        private final int titleResId;

        /* JADX INFO: compiled from: MoreAboutItem.kt */
        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<MoreAboutAccordionItem> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MoreAboutAccordionItem createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new MoreAboutAccordionItem(parcel.readInt(), parcel.readInt());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MoreAboutAccordionItem[] newArray(int i) {
                return new MoreAboutAccordionItem[i];
            }
        }

        public static /* synthetic */ MoreAboutAccordionItem copy$default(MoreAboutAccordionItem moreAboutAccordionItem, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = moreAboutAccordionItem.titleResId;
            }
            if ((i3 & 2) != 0) {
                i2 = moreAboutAccordionItem.messageResId;
            }
            return moreAboutAccordionItem.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTitleResId() {
            return this.titleResId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getMessageResId() {
            return this.messageResId;
        }

        public final MoreAboutAccordionItem copy(int titleResId, int messageResId) {
            return new MoreAboutAccordionItem(titleResId, messageResId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MoreAboutAccordionItem)) {
                return false;
            }
            MoreAboutAccordionItem moreAboutAccordionItem = (MoreAboutAccordionItem) other;
            return this.titleResId == moreAboutAccordionItem.titleResId && this.messageResId == moreAboutAccordionItem.messageResId;
        }

        public int hashCode() {
            return (Integer.hashCode(this.titleResId) * 31) + Integer.hashCode(this.messageResId);
        }

        public String toString() {
            return "MoreAboutAccordionItem(titleResId=" + this.titleResId + ", messageResId=" + this.messageResId + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.titleResId);
            parcel.writeInt(this.messageResId);
        }

        public final int getTitleResId() {
            return this.titleResId;
        }

        public final int getMessageResId() {
            return this.messageResId;
        }

        public MoreAboutAccordionItem(int i, int i2) {
            super(MoreAboutItemType.ACCORDION, null);
            this.titleResId = i;
            this.messageResId = i2;
        }
    }

    /* JADX INFO: compiled from: MoreAboutItem.kt */
    @Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutLogoItem;", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem;", "Landroid/os/Parcelable;", "logo", "", "(I)V", "getLogo", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class MoreAboutLogoItem extends MoreAboutItem implements Parcelable {
        public static final Parcelable.Creator<MoreAboutLogoItem> CREATOR = new Creator();
        private final int logo;

        /* JADX INFO: compiled from: MoreAboutItem.kt */
        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<MoreAboutLogoItem> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MoreAboutLogoItem createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new MoreAboutLogoItem(parcel.readInt());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MoreAboutLogoItem[] newArray(int i) {
                return new MoreAboutLogoItem[i];
            }
        }

        public static /* synthetic */ MoreAboutLogoItem copy$default(MoreAboutLogoItem moreAboutLogoItem, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = moreAboutLogoItem.logo;
            }
            return moreAboutLogoItem.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getLogo() {
            return this.logo;
        }

        public final MoreAboutLogoItem copy(int logo) {
            return new MoreAboutLogoItem(logo);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MoreAboutLogoItem) && this.logo == ((MoreAboutLogoItem) other).logo;
        }

        public int hashCode() {
            return Integer.hashCode(this.logo);
        }

        public String toString() {
            return "MoreAboutLogoItem(logo=" + this.logo + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.logo);
        }

        public MoreAboutLogoItem(int i) {
            super(MoreAboutItemType.LOGO, null);
            this.logo = i;
        }

        public final int getLogo() {
            return this.logo;
        }
    }
}
