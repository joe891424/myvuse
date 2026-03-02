package com.microblink.blinkid.secured;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IIllIIllll implements FileFilter {
    IIllIIllll() {
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
