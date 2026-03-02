package com.yoti.mobile.android.scan.p076a;

import android.content.Context;
import com.yoti.mobile.android.commons.util.DeprecatedSharedPreferencesBase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.yoti.mobile.android.scan.a.a */
/* JADX INFO: loaded from: classes4.dex */
public class C4932a extends DeprecatedSharedPreferencesBase {
    public C4932a(Context context) {
        super(context, "ScanScreenPreferences.");
    }

    /* JADX INFO: renamed from: a */
    public int m5058a() {
        return getIntPreference("scan.SCAN_INSTRUCTIONS_COUNTER", 0);
    }

    /* JADX INFO: renamed from: a */
    public void m5059a(int i) {
        setIntPreference("scan.SCAN_INSTRUCTIONS_COUNTER", i);
    }

    @Override // com.yoti.mobile.android.commons.util.DeprecatedSharedPreferencesBase
    protected List<String> getDeprecatedPreferenceKeys() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add("scan.SCAN_INSTRUCTIONS_COUNTER");
        return arrayList;
    }

    @Override // com.yoti.mobile.android.commons.util.SharedPreferencesBase
    protected int getVersion() {
        return 1;
    }

    @Override // com.yoti.mobile.android.commons.util.SharedPreferencesBase
    protected void updateStoreData(int i) {
    }
}
