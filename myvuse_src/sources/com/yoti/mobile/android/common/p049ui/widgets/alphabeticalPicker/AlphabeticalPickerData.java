package com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0080\b\u0018\u00002\u00020\u0001B?\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005JJ\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R%\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0005R\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0005R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0005¨\u0006("}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerData;", "", "", "Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerModel;", "component1", "()Ljava/util/List;", "mainItems", "", "", "", "_indexMap", "_footerItems", "copy", "(Ljava/util/List;Ljava/util/Map;Ljava/util/List;)Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerData;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "f", "Ljava/util/List;", "a", "Ljava/util/Map;", "getIndexMap", "()Ljava/util/Map;", "indexMap", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "c", "getItems", FirebaseAnalytics.Param.ITEMS, "b", "getFooterItems", "footerItems", "d", "getMainItems", "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/util/List;)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final /* data */ class AlphabeticalPickerData {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Map<String, Integer> indexMap;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final List<AlphabeticalPickerModel> footerItems;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final List<AlphabeticalPickerModel> items;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final List<AlphabeticalPickerModel> mainItems;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Map<String, Integer> _indexMap;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final List<AlphabeticalPickerModel> _footerItems;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.Collection, java.util.List<? extends com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerModel>, java.util.List<com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerModel>] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List<? extends com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerModel>, java.util.List<com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerModel>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Iterable, java.util.List<com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerModel>] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.util.List<? extends com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerModel> to ?? for r4v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:138)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.inline(CodeShrinkVisitor.java:213)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:143)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:68)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:48)
        	at jadx.core.dex.visitors.regions.TernaryMod.replaceWithTernary(TernaryMod.java:347)
        	at jadx.core.dex.visitors.regions.TernaryMod.processOneBranchTernary(TernaryMod.java:273)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:77)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public AlphabeticalPickerData(java.util.List<? extends com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerModel> r2, java.util.Map<java.lang.String, java.lang.Integer> r3, java.util.List<? extends com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerModel> r4) {
        /*
            r1 = this;
            java.lang.String r0 = "mainItems"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r1.<init>()
            r1.mainItems = r2
            r1._indexMap = r3
            r1._footerItems = r4
            if (r3 == 0) goto L11
            goto L15
        L11:
            java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
        L15:
            r1.indexMap = r3
            if (r4 == 0) goto L1a
            goto L1e
        L1a:
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
        L1e:
            r1.footerItems = r4
            java.util.List r2 = kotlin.collections.CollectionsKt.plus(r2, r4)
            r1.items = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerData.<init>(java.util.List, java.util.Map, java.util.List):void");
    }

    public /* synthetic */ AlphabeticalPickerData(List list, Map map, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlphabeticalPickerData copy$default(AlphabeticalPickerData alphabeticalPickerData, List list, Map map, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = alphabeticalPickerData.mainItems;
        }
        if ((i & 2) != 0) {
            map = alphabeticalPickerData._indexMap;
        }
        if ((i & 4) != 0) {
            list2 = alphabeticalPickerData._footerItems;
        }
        return alphabeticalPickerData.copy(list, map, list2);
    }

    public final List<AlphabeticalPickerModel> component1() {
        return this.mainItems;
    }

    public final AlphabeticalPickerData copy(List<? extends AlphabeticalPickerModel> mainItems, Map<String, Integer> _indexMap, List<? extends AlphabeticalPickerModel> _footerItems) {
        Intrinsics.checkNotNullParameter(mainItems, "mainItems");
        return new AlphabeticalPickerData(mainItems, _indexMap, _footerItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlphabeticalPickerData)) {
            return false;
        }
        AlphabeticalPickerData alphabeticalPickerData = (AlphabeticalPickerData) other;
        return Intrinsics.areEqual(this.mainItems, alphabeticalPickerData.mainItems) && Intrinsics.areEqual(this._indexMap, alphabeticalPickerData._indexMap) && Intrinsics.areEqual(this._footerItems, alphabeticalPickerData._footerItems);
    }

    public final List<AlphabeticalPickerModel> getFooterItems() {
        return this.footerItems;
    }

    public final Map<String, Integer> getIndexMap() {
        return this.indexMap;
    }

    public final List<AlphabeticalPickerModel> getItems() {
        return this.items;
    }

    public final List<AlphabeticalPickerModel> getMainItems() {
        return this.mainItems;
    }

    public int hashCode() {
        List<AlphabeticalPickerModel> list = this.mainItems;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        Map<String, Integer> map = this._indexMap;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        List<AlphabeticalPickerModel> list2 = this._footerItems;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "AlphabeticalPickerData(mainItems=" + this.mainItems + ", _indexMap=" + this._indexMap + ", _footerItems=" + this._footerItems + ")";
    }
}
