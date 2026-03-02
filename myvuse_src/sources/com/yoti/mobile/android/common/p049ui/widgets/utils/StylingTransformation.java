package com.yoti.mobile.android.common.p049ui.widgets.utils;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.google.android.material.color.MaterialColors;
import io.branch.rnbranch.RNBranchModule;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0019\u001a\u001bB\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u000e\u001a\u00020\r*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0004¢\u0006\u0004\b\u000e\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0001\u0002\u001c\u001d¨\u0006\u001e"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation;", "Landroid/os/Parcelable;", "", "target", "", "", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "Landroid/content/Context;", "context", "execute", "(Ljava/lang/CharSequence;Ljava/util/List;Landroid/content/Context;)Ljava/lang/CharSequence;", "Landroid/text/SpannableString;", "substring", "", "a", "(Landroid/text/SpannableString;Ljava/lang/String;Landroid/content/Context;)V", "", "span", "(Landroid/text/SpannableString;Ljava/lang/String;Ljava/lang/Object;)V", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope;", "getScope", "()Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope;", "scope", "<init>", "()V", "ColorTransformation", "Scope", "WeightTransformation", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$ColorTransformation;", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$WeightTransformation;", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public abstract class StylingTransformation implements Parcelable {

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b(\u0010)J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\rJ\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001d\u0010\rJ \u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0012\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b'\u0010\r¨\u0006*"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$ColorTransformation;", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation;", "Landroid/text/SpannableString;", "target", "", "substring", "Landroid/content/Context;", "context", "", "a", "(Landroid/text/SpannableString;Ljava/lang/String;Landroid/content/Context;)V", "", "component1", "()I", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope;", "component2", "()Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope;", "colorAttrResId", "scope", "copy", "(ILcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope;)Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$ColorTransformation;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "b", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope;", "getScope", "I", "getColorAttrResId", "<init>", "(ILcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope;)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final /* data */ class ColorTransformation extends StylingTransformation {
        public static final Parcelable.Creator<ColorTransformation> CREATOR = new Creator();

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int colorAttrResId;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final Scope scope;

        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ColorTransformation> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ColorTransformation createFromParcel(Parcel in) {
                Intrinsics.checkNotNullParameter(in, "in");
                return new ColorTransformation(in.readInt(), (Scope) in.readParcelable(ColorTransformation.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ColorTransformation[] newArray(int i) {
                return new ColorTransformation[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ColorTransformation(int i, Scope scope) {
            super(null);
            Intrinsics.checkNotNullParameter(scope, "scope");
            this.colorAttrResId = i;
            this.scope = scope;
        }

        public static /* synthetic */ ColorTransformation copy$default(ColorTransformation colorTransformation, int i, Scope scope, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = colorTransformation.colorAttrResId;
            }
            if ((i2 & 2) != 0) {
                scope = colorTransformation.getScope();
            }
            return colorTransformation.copy(i, scope);
        }

        @Override // com.yoti.mobile.android.common.p049ui.widgets.utils.StylingTransformation
        /* JADX INFO: renamed from: a */
        protected void mo4680a(SpannableString target, String substring, Context context) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(substring, "substring");
            Intrinsics.checkNotNullParameter(context, "context");
            m4681a(target, substring, new ForegroundColorSpan(MaterialColors.getColor(context, this.colorAttrResId, "Invalid color attr res id")));
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getColorAttrResId() {
            return this.colorAttrResId;
        }

        public final Scope component2() {
            return getScope();
        }

        public final ColorTransformation copy(int colorAttrResId, Scope scope) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            return new ColorTransformation(colorAttrResId, scope);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ColorTransformation)) {
                return false;
            }
            ColorTransformation colorTransformation = (ColorTransformation) other;
            return this.colorAttrResId == colorTransformation.colorAttrResId && Intrinsics.areEqual(getScope(), colorTransformation.getScope());
        }

        public final int getColorAttrResId() {
            return this.colorAttrResId;
        }

        @Override // com.yoti.mobile.android.common.p049ui.widgets.utils.StylingTransformation
        public Scope getScope() {
            return this.scope;
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.colorAttrResId) * 31;
            Scope scope = getScope();
            return iHashCode + (scope != null ? scope.hashCode() : 0);
        }

        public String toString() {
            return "ColorTransformation(colorAttrResId=" + this.colorAttrResId + ", scope=" + getScope() + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.colorAttrResId);
            parcel.writeParcelable(this.scope, flags);
        }
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope;", "Landroid/os/Parcelable;", "<init>", "()V", "Full", "StringParams", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope$Full;", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope$StringParams;", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static abstract class Scope implements Parcelable {

        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope$Full;", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
        public static final class Full extends Scope {
            public static final Full INSTANCE = new Full();
            public static final Parcelable.Creator<Full> CREATOR = new Creator();

            @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Full> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final Full createFromParcel(Parcel in) {
                    Intrinsics.checkNotNullParameter(in, "in");
                    if (in.readInt() != 0) {
                        return Full.INSTANCE;
                    }
                    return null;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final Full[] newArray(int i) {
                    return new Full[i];
                }
            }

            private Full() {
                super(null);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeInt(1);
            }
        }

        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005¨\u0006\u001f"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope$StringParams;", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope;", "", "", "component1", "()Ljava/util/Set;", "indexFilter", "copy", "(Ljava/util/Set;)Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope$StringParams;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "a", "Ljava/util/Set;", "getIndexFilter", "<init>", "(Ljava/util/Set;)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
        public static final /* data */ class StringParams extends Scope {
            public static final Parcelable.Creator<StringParams> CREATOR = new Creator();

            /* JADX INFO: renamed from: a, reason: from kotlin metadata */
            private final Set<Integer> indexFilter;

            @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<StringParams> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final StringParams createFromParcel(Parcel in) {
                    Intrinsics.checkNotNullParameter(in, "in");
                    int i = in.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(i);
                    while (i != 0) {
                        linkedHashSet.add(Integer.valueOf(in.readInt()));
                        i--;
                    }
                    return new StringParams(linkedHashSet);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final StringParams[] newArray(int i) {
                    return new StringParams[i];
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public StringParams() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StringParams(Set<Integer> indexFilter) {
                super(null);
                Intrinsics.checkNotNullParameter(indexFilter, "indexFilter");
                this.indexFilter = indexFilter;
            }

            public /* synthetic */ StringParams(Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? SetsKt.emptySet() : set);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ StringParams copy$default(StringParams stringParams, Set set, int i, Object obj) {
                if ((i & 1) != 0) {
                    set = stringParams.indexFilter;
                }
                return stringParams.copy(set);
            }

            public final Set<Integer> component1() {
                return this.indexFilter;
            }

            public final StringParams copy(Set<Integer> indexFilter) {
                Intrinsics.checkNotNullParameter(indexFilter, "indexFilter");
                return new StringParams(indexFilter);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof StringParams) && Intrinsics.areEqual(this.indexFilter, ((StringParams) other).indexFilter);
                }
                return true;
            }

            public final Set<Integer> getIndexFilter() {
                return this.indexFilter;
            }

            public int hashCode() {
                Set<Integer> set = this.indexFilter;
                if (set != null) {
                    return set.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "StringParams(indexFilter=" + this.indexFilter + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Set<Integer> set = this.indexFilter;
                parcel.writeInt(set.size());
                Iterator<Integer> it2 = set.iterator();
                while (it2.hasNext()) {
                    parcel.writeInt(it2.next().intValue());
                }
            }
        }

        private Scope() {
        }

        public /* synthetic */ Scope(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001:\u0001,B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0019J \u0010#\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b#\u0010$R\u001c\u0010\u0012\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010(\u001a\u0004\b)\u0010\r¨\u0006-"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$WeightTransformation;", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation;", "Landroid/text/SpannableString;", "target", "", "substring", "Landroid/content/Context;", "context", "", "a", "(Landroid/text/SpannableString;Ljava/lang/String;Landroid/content/Context;)V", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$WeightTransformation$Weight;", "component1", "()Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$WeightTransformation$Weight;", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope;", "component2", "()Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope;", "weight", "scope", "copy", "(Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$WeightTransformation$Weight;Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope;)Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$WeightTransformation;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "b", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope;", "getScope", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$WeightTransformation$Weight;", "getWeight", "<init>", "(Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$WeightTransformation$Weight;Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$Scope;)V", "Weight", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final /* data */ class WeightTransformation extends StylingTransformation {
        public static final Parcelable.Creator<WeightTransformation> CREATOR = new Creator();

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final Weight weight;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final Scope scope;

        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<WeightTransformation> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final WeightTransformation createFromParcel(Parcel in) {
                Intrinsics.checkNotNullParameter(in, "in");
                return new WeightTransformation((Weight) Enum.valueOf(Weight.class, in.readString()), (Scope) in.readParcelable(WeightTransformation.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final WeightTransformation[] newArray(int i) {
                return new WeightTransformation[i];
            }
        }

        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation$WeightTransformation$Weight;", "", "<init>", "(Ljava/lang/String;I)V", "BOLD", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
        public enum Weight {
            BOLD
        }

        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Weight.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[Weight.BOLD.ordinal()] = 1;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WeightTransformation(Weight weight, Scope scope) {
            super(null);
            Intrinsics.checkNotNullParameter(weight, "weight");
            Intrinsics.checkNotNullParameter(scope, "scope");
            this.weight = weight;
            this.scope = scope;
        }

        public static /* synthetic */ WeightTransformation copy$default(WeightTransformation weightTransformation, Weight weight, Scope scope, int i, Object obj) {
            if ((i & 1) != 0) {
                weight = weightTransformation.weight;
            }
            if ((i & 2) != 0) {
                scope = weightTransformation.getScope();
            }
            return weightTransformation.copy(weight, scope);
        }

        @Override // com.yoti.mobile.android.common.p049ui.widgets.utils.StylingTransformation
        /* JADX INFO: renamed from: a */
        protected void mo4680a(SpannableString target, String substring, Context context) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(substring, "substring");
            Intrinsics.checkNotNullParameter(context, "context");
            if (WhenMappings.$EnumSwitchMapping$0[this.weight.ordinal()] != 1) {
                throw new NoWhenBranchMatchedException();
            }
            m4681a(target, substring, new StyleSpan(1));
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Weight getWeight() {
            return this.weight;
        }

        public final Scope component2() {
            return getScope();
        }

        public final WeightTransformation copy(Weight weight, Scope scope) {
            Intrinsics.checkNotNullParameter(weight, "weight");
            Intrinsics.checkNotNullParameter(scope, "scope");
            return new WeightTransformation(weight, scope);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WeightTransformation)) {
                return false;
            }
            WeightTransformation weightTransformation = (WeightTransformation) other;
            return Intrinsics.areEqual(this.weight, weightTransformation.weight) && Intrinsics.areEqual(getScope(), weightTransformation.getScope());
        }

        @Override // com.yoti.mobile.android.common.p049ui.widgets.utils.StylingTransformation
        public Scope getScope() {
            return this.scope;
        }

        public final Weight getWeight() {
            return this.weight;
        }

        public int hashCode() {
            Weight weight = this.weight;
            int iHashCode = (weight != null ? weight.hashCode() : 0) * 31;
            Scope scope = getScope();
            return iHashCode + (scope != null ? scope.hashCode() : 0);
        }

        public String toString() {
            return "WeightTransformation(weight=" + this.weight + ", scope=" + getScope() + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.weight.name());
            parcel.writeParcelable(this.scope, flags);
        }
    }

    private StylingTransformation() {
    }

    public /* synthetic */ StylingTransformation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo4680a(SpannableString target, String substring, Context context);

    /* JADX INFO: renamed from: a */
    protected final void m4681a(SpannableString setSubstringSpan, String substring, Object span) {
        Intrinsics.checkNotNullParameter(setSubstringSpan, "$this$setSubstringSpan");
        Intrinsics.checkNotNullParameter(substring, "substring");
        Intrinsics.checkNotNullParameter(span, "span");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) setSubstringSpan, substring, 0, false, 6, (Object) null);
        setSubstringSpan.setSpan(span, iIndexOf$default, substring.length() + iIndexOf$default, 33);
    }

    public final CharSequence execute(CharSequence target, List<String> params, Context context) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(context, "context");
        SpannableString spannableString = new SpannableString(target);
        Scope scope = getScope();
        if (Intrinsics.areEqual(scope, Scope.Full.INSTANCE)) {
            mo4680a(spannableString, target.toString(), context);
        } else if (scope instanceof Scope.StringParams) {
            int i = 0;
            for (Object obj : params) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str = (String) obj;
                Scope.StringParams stringParams = (Scope.StringParams) scope;
                if (stringParams.getIndexFilter().isEmpty() || stringParams.getIndexFilter().contains(Integer.valueOf(i))) {
                    mo4680a(spannableString, str, context);
                }
                i = i2;
            }
        }
        return spannableString;
    }

    public abstract Scope getScope();
}
