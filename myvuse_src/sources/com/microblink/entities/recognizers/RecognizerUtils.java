package com.microblink.entities.recognizers;

import java.util.ArrayList;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class RecognizerUtils {
    public static Recognizer[] filterOutRecognizersThatRequireAutofocus(Recognizer[] recognizerArr) {
        ArrayList arrayList = new ArrayList();
        for (Recognizer recognizer : recognizerArr) {
            if (recognizer != null && !recognizer.requiresAutofocus()) {
                arrayList.add(recognizer);
            }
        }
        Recognizer[] recognizerArr2 = new Recognizer[arrayList.size()];
        arrayList.toArray(recognizerArr2);
        return recognizerArr2;
    }
}
