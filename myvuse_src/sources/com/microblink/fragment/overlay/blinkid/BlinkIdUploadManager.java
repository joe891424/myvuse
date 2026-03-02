package com.microblink.fragment.overlay.blinkid;

import android.content.Context;
import com.microblink.blinkid.secured.lIIlIIllII;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdRecognizer;
import com.microblink.recognition.Right;
import com.microblink.recognition.RightsManager;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class BlinkIdUploadManager implements ImageUploadManager {
    BlinkIdUploadManager() {
    }

    @Override // com.microblink.fragment.overlay.blinkid.ImageUploadManager
    public void setupUploadManager(Recognizer<?>[] recognizerArr) {
        if (RightsManager.llIIlIlIIl(Right.ALLOW_IMAGE_UPLOAD)) {
            for (Recognizer<?> recognizer : recognizerArr) {
                if (recognizer instanceof BlinkIdRecognizer) {
                    ((BlinkIdRecognizer) recognizer).setSaveCameraFrames(true);
                }
                if (recognizer instanceof BlinkIdCombinedRecognizer) {
                    ((BlinkIdCombinedRecognizer) recognizer).setSaveCameraFrames(true);
                }
            }
        }
    }

    @Override // com.microblink.fragment.overlay.blinkid.ImageUploadManager
    public void uploadImages(Context context, RecognizerBundle recognizerBundle) {
        lIIlIIllII.llIIlIlIIl(context).llIIlIlIIl(recognizerBundle);
    }
}
