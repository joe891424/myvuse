package com.microblink.fragment.overlay.blinkid;

import android.content.Context;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface ImageUploadManager {
    void setupUploadManager(Recognizer<?>[] recognizerArr);

    void uploadImages(Context context, RecognizerBundle recognizerBundle);
}
