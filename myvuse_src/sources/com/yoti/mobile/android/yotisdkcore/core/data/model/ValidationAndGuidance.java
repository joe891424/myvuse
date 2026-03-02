package com.yoti.mobile.android.yotisdkcore.core.data.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance;", "", "validationConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$EducationalConfiguration;", "guidanceConfiguration", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$EducationalConfiguration;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$EducationalConfiguration;)V", "getGuidanceConfiguration", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$EducationalConfiguration;", "getValidationConfiguration", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CompoundText", "DynamicValueType", "EducationalConfiguration", "EducationalItem", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class ValidationAndGuidance {

    @SerializedName("guideline_resources")
    private final EducationalConfiguration guidanceConfiguration;

    @SerializedName("educational_resources")
    private final EducationalConfiguration validationConfiguration;

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ4\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$CompoundText;", "", "stringRes", "", "dynamicValues", "", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$DynamicValueType;", "colorAttrRes", "(ILjava/util/List;Ljava/lang/Integer;)V", "getColorAttrRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDynamicValues", "()Ljava/util/List;", "getStringRes", "()I", "component1", "component2", "component3", "copy", "(ILjava/util/List;Ljava/lang/Integer;)Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$CompoundText;", "equals", "", "other", "hashCode", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class CompoundText {

        @SerializedName("colorAttrRes")
        private final Integer colorAttrRes;

        @SerializedName("dynamicValues")
        private final List<DynamicValueType> dynamicValues;

        @SerializedName("stringRes")
        private final int stringRes;

        /* JADX WARN: Multi-variable type inference failed */
        public CompoundText(int i, List<? extends DynamicValueType> dynamicValues, Integer num) {
            Intrinsics.checkNotNullParameter(dynamicValues, "dynamicValues");
            this.stringRes = i;
            this.dynamicValues = dynamicValues;
            this.colorAttrRes = num;
        }

        public /* synthetic */ CompoundText(int i, List list, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? null : num);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CompoundText copy$default(CompoundText compoundText, int i, List list, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = compoundText.stringRes;
            }
            if ((i2 & 2) != 0) {
                list = compoundText.dynamicValues;
            }
            if ((i2 & 4) != 0) {
                num = compoundText.colorAttrRes;
            }
            return compoundText.copy(i, list, num);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getStringRes() {
            return this.stringRes;
        }

        public final List<DynamicValueType> component2() {
            return this.dynamicValues;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getColorAttrRes() {
            return this.colorAttrRes;
        }

        public final CompoundText copy(int stringRes, List<? extends DynamicValueType> dynamicValues, Integer colorAttrRes) {
            Intrinsics.checkNotNullParameter(dynamicValues, "dynamicValues");
            return new CompoundText(stringRes, dynamicValues, colorAttrRes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CompoundText)) {
                return false;
            }
            CompoundText compoundText = (CompoundText) other;
            return this.stringRes == compoundText.stringRes && Intrinsics.areEqual(this.dynamicValues, compoundText.dynamicValues) && Intrinsics.areEqual(this.colorAttrRes, compoundText.colorAttrRes);
        }

        public final Integer getColorAttrRes() {
            return this.colorAttrRes;
        }

        public final List<DynamicValueType> getDynamicValues() {
            return this.dynamicValues;
        }

        public final int getStringRes() {
            return this.stringRes;
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.stringRes) * 31) + this.dynamicValues.hashCode()) * 31;
            Integer num = this.colorAttrRes;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "CompoundText(stringRes=" + this.stringRes + ", dynamicValues=" + this.dynamicValues + ", colorAttrRes=" + this.colorAttrRes + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$DynamicValueType;", "", "(Ljava/lang/String;I)V", "DOCUMENT_NAME", "COUNTRY_NAME", "APPLICANT_FULL_NAME", "APPLICANT_ADDRESS", "APPLICANT_DATE_OF_BIRTH", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum DynamicValueType {
        DOCUMENT_NAME,
        COUNTRY_NAME,
        APPLICANT_FULL_NAME,
        APPLICANT_ADDRESS,
        APPLICANT_DATE_OF_BIRTH
    }

    @Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cB)\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB%\u0012\u0006\u0010\u0002\u001a\u00020\n\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\nHÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\n2\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$EducationalConfiguration;", "", "title", "", FirebaseAnalytics.Param.ITEMS, "", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$EducationalItem;", "layoutType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$EducationalConfiguration$LayoutType;", "(ILjava/util/List;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$EducationalConfiguration$LayoutType;)V", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$CompoundText;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$CompoundText;Ljava/util/List;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$EducationalConfiguration$LayoutType;)V", "getItems", "()Ljava/util/List;", "getLayoutType", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$EducationalConfiguration$LayoutType;", "getTitle", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$CompoundText;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "LayoutType", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class EducationalConfiguration {

        @SerializedName(FirebaseAnalytics.Param.ITEMS)
        private final List<EducationalItem> items;

        @SerializedName("layout_type")
        private final LayoutType layoutType;

        @SerializedName("title")
        private final CompoundText title;

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$EducationalConfiguration$LayoutType;", "", "(Ljava/lang/String;I)V", "GRID", "LIST", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public enum LayoutType {
            GRID,
            LIST
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public EducationalConfiguration(int i, List<EducationalItem> items, LayoutType layoutType) {
            this(new CompoundText(i, null, null, 6, null), items, layoutType);
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(layoutType, "layoutType");
        }

        public /* synthetic */ EducationalConfiguration(int i, List list, LayoutType layoutType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (List<EducationalItem>) list, (i2 & 4) != 0 ? LayoutType.LIST : layoutType);
        }

        public EducationalConfiguration(CompoundText title, List<EducationalItem> items, LayoutType layoutType) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(layoutType, "layoutType");
            this.title = title;
            this.items = items;
            this.layoutType = layoutType;
        }

        public /* synthetic */ EducationalConfiguration(CompoundText compoundText, List list, LayoutType layoutType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(compoundText, (List<EducationalItem>) list, (i & 4) != 0 ? LayoutType.LIST : layoutType);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EducationalConfiguration copy$default(EducationalConfiguration educationalConfiguration, CompoundText compoundText, List list, LayoutType layoutType, int i, Object obj) {
            if ((i & 1) != 0) {
                compoundText = educationalConfiguration.title;
            }
            if ((i & 2) != 0) {
                list = educationalConfiguration.items;
            }
            if ((i & 4) != 0) {
                layoutType = educationalConfiguration.layoutType;
            }
            return educationalConfiguration.copy(compoundText, list, layoutType);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CompoundText getTitle() {
            return this.title;
        }

        public final List<EducationalItem> component2() {
            return this.items;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final LayoutType getLayoutType() {
            return this.layoutType;
        }

        public final EducationalConfiguration copy(CompoundText title, List<EducationalItem> items, LayoutType layoutType) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(layoutType, "layoutType");
            return new EducationalConfiguration(title, items, layoutType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EducationalConfiguration)) {
                return false;
            }
            EducationalConfiguration educationalConfiguration = (EducationalConfiguration) other;
            return Intrinsics.areEqual(this.title, educationalConfiguration.title) && Intrinsics.areEqual(this.items, educationalConfiguration.items) && this.layoutType == educationalConfiguration.layoutType;
        }

        public final List<EducationalItem> getItems() {
            return this.items;
        }

        public final LayoutType getLayoutType() {
            return this.layoutType;
        }

        public final CompoundText getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((this.title.hashCode() * 31) + this.items.hashCode()) * 31) + this.layoutType.hashCode();
        }

        public String toString() {
            return "EducationalConfiguration(title=" + this.title + ", items=" + this.items + ", layoutType=" + this.layoutType + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$EducationalItem;", "", "icon", "", "title", "text", "textSecondary", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$CompoundText;", "(IIILcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$CompoundText;)V", "(IILcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$CompoundText;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$CompoundText;)V", "getIcon", "()I", "getText", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$CompoundText;", "getTextSecondary", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class EducationalItem {

        @SerializedName("icon")
        private final int icon;

        @SerializedName("text")
        private final CompoundText text;

        @SerializedName("text_secondary")
        private final CompoundText textSecondary;

        @SerializedName("title")
        private final int title;

        public EducationalItem(int i, int i2, int i3, CompoundText compoundText) {
            this(i, i2, new CompoundText(i3, null, null, 6, null), compoundText);
        }

        public /* synthetic */ EducationalItem(int i, int i2, int i3, CompoundText compoundText, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, i3, (i4 & 8) != 0 ? null : compoundText);
        }

        public EducationalItem(int i, int i2, CompoundText compoundText, CompoundText compoundText2) {
            this.icon = i;
            this.title = i2;
            this.text = compoundText;
            this.textSecondary = compoundText2;
        }

        public /* synthetic */ EducationalItem(int i, int i2, CompoundText compoundText, CompoundText compoundText2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i3 & 4) != 0 ? null : compoundText, (i3 & 8) != 0 ? null : compoundText2);
        }

        public static /* synthetic */ EducationalItem copy$default(EducationalItem educationalItem, int i, int i2, CompoundText compoundText, CompoundText compoundText2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = educationalItem.icon;
            }
            if ((i3 & 2) != 0) {
                i2 = educationalItem.title;
            }
            if ((i3 & 4) != 0) {
                compoundText = educationalItem.text;
            }
            if ((i3 & 8) != 0) {
                compoundText2 = educationalItem.textSecondary;
            }
            return educationalItem.copy(i, i2, compoundText, compoundText2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getIcon() {
            return this.icon;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CompoundText getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final CompoundText getTextSecondary() {
            return this.textSecondary;
        }

        public final EducationalItem copy(int icon, int title, CompoundText text, CompoundText textSecondary) {
            return new EducationalItem(icon, title, text, textSecondary);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EducationalItem)) {
                return false;
            }
            EducationalItem educationalItem = (EducationalItem) other;
            return this.icon == educationalItem.icon && this.title == educationalItem.title && Intrinsics.areEqual(this.text, educationalItem.text) && Intrinsics.areEqual(this.textSecondary, educationalItem.textSecondary);
        }

        public final int getIcon() {
            return this.icon;
        }

        public final CompoundText getText() {
            return this.text;
        }

        public final CompoundText getTextSecondary() {
            return this.textSecondary;
        }

        public final int getTitle() {
            return this.title;
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.icon) * 31) + Integer.hashCode(this.title)) * 31;
            CompoundText compoundText = this.text;
            int iHashCode2 = (iHashCode + (compoundText == null ? 0 : compoundText.hashCode())) * 31;
            CompoundText compoundText2 = this.textSecondary;
            return iHashCode2 + (compoundText2 != null ? compoundText2.hashCode() : 0);
        }

        public String toString() {
            return "EducationalItem(icon=" + this.icon + ", title=" + this.title + ", text=" + this.text + ", textSecondary=" + this.textSecondary + ')';
        }
    }

    public ValidationAndGuidance(EducationalConfiguration validationConfiguration, EducationalConfiguration guidanceConfiguration) {
        Intrinsics.checkNotNullParameter(validationConfiguration, "validationConfiguration");
        Intrinsics.checkNotNullParameter(guidanceConfiguration, "guidanceConfiguration");
        this.validationConfiguration = validationConfiguration;
        this.guidanceConfiguration = guidanceConfiguration;
    }

    public static /* synthetic */ ValidationAndGuidance copy$default(ValidationAndGuidance validationAndGuidance, EducationalConfiguration educationalConfiguration, EducationalConfiguration educationalConfiguration2, int i, Object obj) {
        if ((i & 1) != 0) {
            educationalConfiguration = validationAndGuidance.validationConfiguration;
        }
        if ((i & 2) != 0) {
            educationalConfiguration2 = validationAndGuidance.guidanceConfiguration;
        }
        return validationAndGuidance.copy(educationalConfiguration, educationalConfiguration2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EducationalConfiguration getValidationConfiguration() {
        return this.validationConfiguration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final EducationalConfiguration getGuidanceConfiguration() {
        return this.guidanceConfiguration;
    }

    public final ValidationAndGuidance copy(EducationalConfiguration validationConfiguration, EducationalConfiguration guidanceConfiguration) {
        Intrinsics.checkNotNullParameter(validationConfiguration, "validationConfiguration");
        Intrinsics.checkNotNullParameter(guidanceConfiguration, "guidanceConfiguration");
        return new ValidationAndGuidance(validationConfiguration, guidanceConfiguration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ValidationAndGuidance)) {
            return false;
        }
        ValidationAndGuidance validationAndGuidance = (ValidationAndGuidance) other;
        return Intrinsics.areEqual(this.validationConfiguration, validationAndGuidance.validationConfiguration) && Intrinsics.areEqual(this.guidanceConfiguration, validationAndGuidance.guidanceConfiguration);
    }

    public final EducationalConfiguration getGuidanceConfiguration() {
        return this.guidanceConfiguration;
    }

    public final EducationalConfiguration getValidationConfiguration() {
        return this.validationConfiguration;
    }

    public int hashCode() {
        return (this.validationConfiguration.hashCode() * 31) + this.guidanceConfiguration.hashCode();
    }

    public String toString() {
        return "ValidationAndGuidance(validationConfiguration=" + this.validationConfiguration + ", guidanceConfiguration=" + this.guidanceConfiguration + ')';
    }
}
