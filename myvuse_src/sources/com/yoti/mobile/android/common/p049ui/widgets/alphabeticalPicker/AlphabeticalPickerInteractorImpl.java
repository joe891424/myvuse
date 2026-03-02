package com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.yoti.mobile.android.common.p049ui.widgets.utils.StringUtilsKt;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0002¢\u0006\u0004\b\b\u0010\u0011J5\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00142\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerInteractorImpl;", "Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerInteractor;", "", "Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerModel;", "orderedItems", "Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerFooterInfo;", "footerInfo", "Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerData;", "a", "(Ljava/util/List;Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerFooterInfo;)Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerData;", FirebaseAnalytics.Param.ITEMS, "b", "(Ljava/util/List;)Ljava/util/List;", "", "", "", "", "(Ljava/util/List;)Ljava/util/Map;", "", "shouldShowIndexLetter", "Lio/reactivex/Single;", "processPickerItems", "(ZLjava/util/List;Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerFooterInfo;)Lio/reactivex/Single;", "<init>", "()V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class AlphabeticalPickerInteractorImpl implements AlphabeticalPickerInteractor {

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerInteractorImpl$a */
    static final class CallableC4536a<V> implements Callable<AlphabeticalPickerData> {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ List f6284b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ boolean f6285c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ AlphabeticalPickerFooterInfo f6286d;

        CallableC4536a(List list, boolean z, AlphabeticalPickerFooterInfo alphabeticalPickerFooterInfo) {
            this.f6284b = list;
            this.f6285c = z;
            this.f6286d = alphabeticalPickerFooterInfo;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AlphabeticalPickerData call() {
            List mutableList = CollectionsKt.toMutableList((Collection) this.f6284b);
            CollectionsKt.sort(mutableList);
            if (this.f6285c) {
                return AlphabeticalPickerInteractorImpl.this.m4587a(mutableList, this.f6286d);
            }
            AlphabeticalPickerFooterInfo alphabeticalPickerFooterInfo = this.f6286d;
            return new AlphabeticalPickerData(mutableList, null, alphabeticalPickerFooterInfo != null ? alphabeticalPickerFooterInfo.getItems() : null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final AlphabeticalPickerData m4587a(List<AlphabeticalPickerModel> orderedItems, AlphabeticalPickerFooterInfo footerInfo) {
        List<AlphabeticalPickerModel> listM4589b = m4589b(orderedItems);
        Map<String, Integer> mapM4588a = m4588a(listM4589b);
        ArrayList arrayList = null;
        if (footerInfo != null) {
            String strNormalize$default = StringUtilsKt.normalize$default(footerInfo.getTitle(), null, 1, null);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new AlphabeticalPickerLetter(strNormalize$default));
            arrayList2.addAll(footerInfo.getItems());
            if (strNormalize$default == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = strNormalize$default.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            mapM4588a.put(strSubstring, Integer.valueOf(listM4589b.size()));
            arrayList = arrayList2;
        }
        return new AlphabeticalPickerData(listM4589b, mapM4588a, arrayList);
    }

    /* JADX INFO: renamed from: a */
    private final Map<String, Integer> m4588a(List<? extends AlphabeticalPickerModel> items) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (Object obj : items) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String strNormalize$default = StringUtilsKt.normalize$default(((AlphabeticalPickerModel) obj).getLetter(), null, 1, null);
            if (strNormalize$default == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = strNormalize$default.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (linkedHashMap.get(strSubstring) == null) {
                linkedHashMap.put(strSubstring, Integer.valueOf(i));
            }
            i = i2;
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: b */
    private final List<AlphabeticalPickerModel> m4589b(List<AlphabeticalPickerModel> items) {
        ArrayList arrayList = new ArrayList();
        char c = 0;
        for (AlphabeticalPickerModel alphabeticalPickerModel : items) {
            char cCharAt = StringUtilsKt.normalize$default(alphabeticalPickerModel.getLetter(), null, 1, null).charAt(0);
            if (cCharAt != c) {
                arrayList.add(new AlphabeticalPickerLetter(String.valueOf(cCharAt)));
                c = cCharAt;
            }
            arrayList.add(alphabeticalPickerModel);
        }
        return arrayList;
    }

    @Override // com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerInteractor
    public Single<AlphabeticalPickerData> processPickerItems(boolean shouldShowIndexLetter, List<? extends AlphabeticalPickerModel> items, AlphabeticalPickerFooterInfo footerInfo) {
        Intrinsics.checkNotNullParameter(items, "items");
        Single<AlphabeticalPickerData> singleFromCallable = Single.fromCallable(new CallableC4536a(items, shouldShowIndexLetter, footerInfo));
        Intrinsics.checkNotNullExpressionValue(singleFromCallable, "Single.fromCallable {\n  …)\n            }\n        }");
        return singleFromCallable;
    }
}
