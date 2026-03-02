package com.bat.sdk.sync;

import com.bat.sdk.logging.Logger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EPenPuffValidator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/sync/EPenPuffValidator;", "", "<init>", "()V", "validate", "", "record", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class EPenPuffValidator {
    public final boolean validate(String record) {
        String record2 = record;
        Intrinsics.checkNotNullParameter(record2, "record");
        try {
            Logger.INSTANCE.log("validating " + record2);
            List listSplit$default = StringsKt.split$default((CharSequence) record2, new char[]{'\n'}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listSplit$default) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            List<String> listSubList = arrayList2.subList(4, arrayList2.size() - 1);
            int i = Integer.parseInt((String) StringsKt.split$default((CharSequence) arrayList2.get(1), new char[]{','}, false, 0, 6, (Object) null).get(1));
            List listSplit$default2 = StringsKt.split$default((CharSequence) arrayList2.get(3), new char[]{','}, false, 0, 6, (Object) null);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int i2 = 0; i2 < i; i2++) {
                linkedHashMap.put(Integer.valueOf(i2), false);
            }
            int length = record.length();
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (record2.charAt(i3) == '!') {
                    record2 = record2.substring(0, i3);
                    Intrinsics.checkNotNullExpressionValue(record2, "this as java.lang.String…ing(startIndex, endIndex)");
                    break;
                }
                i3++;
            }
            if (!new Regex("\\d+\\.csv").matches(record2)) {
                throw new IllegalStateException("filename format is wrong".toString());
            }
            for (String str : listSubList) {
                if (!StringsKt.startsWith$default(str, record2, false, 2, (Object) null)) {
                    throw new IllegalStateException("line does not start with filename".toString());
                }
                List listSplit$default3 = StringsKt.split$default((CharSequence) str, new char[]{','}, false, 0, 6, (Object) null);
                int i4 = Integer.parseInt((String) StringsKt.split$default((CharSequence) listSplit$default3.get(0), new char[]{'!'}, false, 0, 6, (Object) null).get(1));
                if (listSplit$default3.size() == listSplit$default2.size()) {
                    linkedHashMap.put(Integer.valueOf(i4), true);
                }
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int iIntValue = ((Number) entry.getKey()).intValue();
                if (!((Boolean) entry.getValue()).booleanValue()) {
                    throw new IllegalStateException((iIntValue + " is not valid").toString());
                }
            }
            return true;
        } catch (Throwable th) {
            Logger.INSTANCE.log("epen puff record is not valid, " + th.getMessage());
            return false;
        }
    }
}
