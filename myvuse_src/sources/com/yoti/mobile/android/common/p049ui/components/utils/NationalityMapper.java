package com.yoti.mobile.android.common.p049ui.components.utils;

import android.content.res.Resources;
import com.yoti.mobile.android.common.p049ui.components.C4469R;
import com.yoti.mobile.android.common.p049ui.widgets.utils.INationalityMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class NationalityMapper implements INationalityMapper {
    public final String TAG = "NationalityMapper";

    /* JADX INFO: renamed from: a */
    private Resources f5895a;

    /* JADX INFO: renamed from: b */
    private Map<String, String> f5896b;

    public NationalityMapper(Resources resources) {
        this.f5895a = resources;
    }

    /* JADX INFO: renamed from: a */
    private void m4386a() {
        this.f5896b = new HashMap();
        InputStream inputStreamOpenRawResource = null;
        try {
            inputStreamOpenRawResource = this.f5895a.openRawResource(C4469R.raw.country_code_to_nationality);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] strArrSplit = line.split("\t");
                this.f5896b.put(strArrSplit[0], strArrSplit[2]);
            }
            if (inputStreamOpenRawResource == null) {
                return;
            }
        } catch (IOException unused) {
            if (inputStreamOpenRawResource == null) {
                return;
            }
        } catch (Throwable th) {
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
        try {
            inputStreamOpenRawResource.close();
        } catch (Throwable unused3) {
        }
    }

    @Override // com.yoti.mobile.android.common.p049ui.widgets.utils.INationalityMapper
    public String getNationality(String str, Locale locale) {
        if (this.f5896b == null) {
            m4386a();
        }
        return this.f5896b.get(str);
    }
}
