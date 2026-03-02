package com.qualtrics.digital;

/* JADX INFO: compiled from: InterceptJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class ActionOptions {
    private String actionSetSampleRate;

    ActionOptions() {
    }

    Double getActionSetSampleRate() {
        String str = this.actionSetSampleRate;
        if (str == null) {
            return Double.valueOf(0.0d);
        }
        return Double.valueOf(Double.parseDouble(str));
    }
}
