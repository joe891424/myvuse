package com.microblink.entities.recognizers.blinkid.generic;

import android.os.Parcelable;
import com.microblink.entities.recognizers.blinkid.generic.classinfo.ClassInfo;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface ClassFilter extends Parcelable {
    boolean classFilter(ClassInfo classInfo);
}
