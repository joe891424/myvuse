package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.common.p049ui.widgets.utils.StylingTransformation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(B9\u0012\b\b\u0001\u0010\u0019\u001a\u00020\r\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a\u0012\b\b\u0002\u0010!\u001a\u00020\u001e\u0012\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u001a¢\u0006\u0004\b%\u0010&B\u001d\b\u0016\u0012\b\b\u0001\u0010\u0019\u001a\u00020\r\u0012\b\b\u0002\u0010!\u001a\u00020\u001e¢\u0006\u0004\b%\u0010'J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u000fJ \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001c¨\u0006)"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "Landroid/content/Context;", "context", "", "getValue", "(Landroid/content/Context;)Ljava/lang/CharSequence;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "a", "I", "resId", "", "b", "Ljava/util/List;", "parameters", "Lcom/yoti/mobile/android/common/ui/widgets/StringTransformation;", "c", "Lcom/yoti/mobile/android/common/ui/widgets/StringTransformation;", "transformation", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation;", "d", "stylingTransformations", "<init>", "(ILjava/util/List;Lcom/yoti/mobile/android/common/ui/widgets/StringTransformation;Ljava/util/List;)V", "(ILcom/yoti/mobile/android/common/ui/widgets/StringTransformation;)V", "StringResId", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class CompoundTextResource implements Parcelable, Serializable {
    public static final Parcelable.Creator<CompoundTextResource> CREATOR = new Creator();

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int resId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final List<Serializable> parameters;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final StringTransformation transformation;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final List<StylingTransformation> stylingTransformations;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CompoundTextResource> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CompoundTextResource createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            int i = in.readInt();
            int i2 = in.readInt();
            ArrayList arrayList = new ArrayList(i2);
            while (i2 != 0) {
                arrayList.add(in.readSerializable());
                i2--;
            }
            StringTransformation stringTransformation = (StringTransformation) Enum.valueOf(StringTransformation.class, in.readString());
            int i3 = in.readInt();
            ArrayList arrayList2 = new ArrayList(i3);
            while (i3 != 0) {
                arrayList2.add((StylingTransformation) in.readParcelable(CompoundTextResource.class.getClassLoader()));
                i3--;
            }
            return new CompoundTextResource(i, arrayList, stringTransformation, arrayList2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CompoundTextResource[] newArray(int i) {
            return new CompoundTextResource[i];
        }
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0005J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0006\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005¨\u0006\u001e"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource$StringResId;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "", "component1", "()I", "resourceId", "copy", "(I)Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource$StringResId;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "a", "I", "getResourceId", "<init>", "(I)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final /* data */ class StringResId implements Parcelable, Serializable {
        public static final Parcelable.Creator<StringResId> CREATOR = new Creator();

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int resourceId;

        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<StringResId> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final StringResId createFromParcel(Parcel in) {
                Intrinsics.checkNotNullParameter(in, "in");
                return new StringResId(in.readInt());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final StringResId[] newArray(int i) {
                return new StringResId[i];
            }
        }

        public StringResId(int i) {
            this.resourceId = i;
        }

        public static /* synthetic */ StringResId copy$default(StringResId stringResId, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = stringResId.resourceId;
            }
            return stringResId.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getResourceId() {
            return this.resourceId;
        }

        public final StringResId copy(int resourceId) {
            return new StringResId(resourceId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StringResId) && this.resourceId == ((StringResId) other).resourceId;
            }
            return true;
        }

        public final int getResourceId() {
            return this.resourceId;
        }

        public int hashCode() {
            return Integer.hashCode(this.resourceId);
        }

        public String toString() {
            return "StringResId(resourceId=" + this.resourceId + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.resourceId);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompoundTextResource(int i, StringTransformation transformation) {
        this(i, CollectionsKt.emptyList(), transformation, null, 8, null);
        Intrinsics.checkNotNullParameter(transformation, "transformation");
    }

    public /* synthetic */ CompoundTextResource(int i, StringTransformation stringTransformation, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? StringTransformation.NONE : stringTransformation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompoundTextResource(int i, List<? extends Serializable> parameters, StringTransformation transformation, List<? extends StylingTransformation> stylingTransformations) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(transformation, "transformation");
        Intrinsics.checkNotNullParameter(stylingTransformations, "stylingTransformations");
        this.resId = i;
        this.parameters = parameters;
        this.transformation = transformation;
        this.stylingTransformations = stylingTransformations;
    }

    public /* synthetic */ CompoundTextResource(int i, List list, StringTransformation stringTransformation, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (List<? extends Serializable>) list, (i2 & 4) != 0 ? StringTransformation.NONE : stringTransformation, (List<? extends StylingTransformation>) ((i2 & 8) != 0 ? CollectionsKt.emptyList() : list2));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(CompoundTextResource.class, other != null ? other.getClass() : null)) {
            return false;
        }
        if (other == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.common.ui.widgets.CompoundTextResource");
        }
        CompoundTextResource compoundTextResource = (CompoundTextResource) other;
        return this.resId == compoundTextResource.resId && Intrinsics.areEqual(this.parameters, compoundTextResource.parameters) && this.transformation == compoundTextResource.transformation && Intrinsics.areEqual(this.stylingTransformations, compoundTextResource.stylingTransformations);
    }

    public final CharSequence getValue(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        List<Serializable> list = this.parameters;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Object value : list) {
            if (value instanceof StringResId) {
                value = context.getString(((StringResId) value).getResourceId());
            } else if (value instanceof CompoundTextResource) {
                value = ((CompoundTextResource) value).getValue(context);
            }
            arrayList.add(value);
        }
        int i = this.resId;
        Object[] array = arrayList.toArray(new Object[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String string = context.getString(i, Arrays.copyOf(array, array.length));
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resId, *params.toTypedArray())");
        String strTransform = CompoundTextResourceKt.transform(string, this.transformation);
        List<StylingTransformation> list2 = this.stylingTransformations;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof String) {
                arrayList2.add(obj);
            }
        }
        return CompoundTextResourceKt.m4390a(strTransform, list2, context, arrayList2);
    }

    public int hashCode() {
        return (((((this.resId * 31) + this.parameters.hashCode()) * 31) + this.transformation.hashCode()) * 31) + this.stylingTransformations.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.resId);
        List<Serializable> list = this.parameters;
        parcel.writeInt(list.size());
        Iterator<Serializable> it2 = list.iterator();
        while (it2.hasNext()) {
            parcel.writeSerializable(it2.next());
        }
        parcel.writeString(this.transformation.name());
        List<StylingTransformation> list2 = this.stylingTransformations;
        parcel.writeInt(list2.size());
        Iterator<StylingTransformation> it3 = list2.iterator();
        while (it3.hasNext()) {
            parcel.writeParcelable(it3.next(), flags);
        }
    }
}
