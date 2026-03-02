package com.qualtrics.digital;

/* JADX INFO: compiled from: InterceptJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class DisplayOptions {
    String displayRate;
    boolean hasRandomization;
    String noshow;

    DisplayOptions() {
    }

    double getSamplingRate() {
        String str = this.displayRate;
        if (str == null) {
            return 0.0d;
        }
        return Double.parseDouble(str);
    }

    double getPreventRepeatedDisplayInDays() {
        String str = this.noshow;
        if (str == null) {
            return 0.0d;
        }
        return Double.parseDouble(str);
    }

    boolean getHasActionSetRandomization() {
        return this.hasRandomization;
    }
}
