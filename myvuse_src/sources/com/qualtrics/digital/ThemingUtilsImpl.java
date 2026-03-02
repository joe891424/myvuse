package com.qualtrics.digital;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.content.ContextCompat;

/* JADX INFO: compiled from: ThemingUtils.java */
/* JADX INFO: loaded from: classes6.dex */
class ThemingUtilsImpl implements ThemingUtils {
    Integer FALLBACK_COLOR = -16777216;
    private Context context;

    public ThemingUtilsImpl(Context context) {
        this.context = context;
    }

    @Override // com.qualtrics.digital.ThemingUtils
    public String getHexColor(int i) {
        return String.format("#%08X", Integer.valueOf(i));
    }

    @Override // com.qualtrics.digital.ThemingUtils
    public int getColorByResource(int i) {
        try {
            return ContextCompat.getColor(this.context, i);
        } catch (Resources.NotFoundException unused) {
            return this.FALLBACK_COLOR.intValue();
        }
    }
}
