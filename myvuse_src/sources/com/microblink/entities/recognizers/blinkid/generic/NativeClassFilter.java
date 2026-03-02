package com.microblink.entities.recognizers.blinkid.generic;

import com.microblink.entities.recognizers.blinkid.generic.classinfo.ClassInfo;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
final class NativeClassFilter {
    ClassFilter llIIlIlIIl;

    NativeClassFilter(ClassFilter classFilter) {
        this.llIIlIlIIl = classFilter;
    }

    boolean classFilter(long j) {
        ClassFilter classFilter = this.llIIlIlIIl;
        if (classFilter != null) {
            return classFilter.classFilter(new ClassInfo(j, null));
        }
        return true;
    }
}
