package com.microblink.blinkid.secured;

import android.content.Context;
import com.microblink.blinkid.secured.lIIlIIIlII;
import com.microblink.blinkid.secured.llIllIlIII;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdRecognizer;
import com.microblink.image.Image;
import java.util.ArrayList;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IlIllIlllI {
    /* JADX WARN: Multi-variable type inference failed */
    static llIllIlIII llIIlIlIIl(BlinkIdRecognizer blinkIdRecognizer, Context context) {
        BlinkIdRecognizer.Result result = (BlinkIdRecognizer.Result) blinkIdRecognizer.getResult();
        Image cameraFrame = result.getCameraFrame();
        Image barcodeCameraFrame = result.getBarcodeCameraFrame();
        ArrayList arrayList = new ArrayList();
        if (cameraFrame != null) {
            arrayList.add(lllIIIlIlI.llIIlIlIIl(cameraFrame, 1));
        }
        if (barcodeCameraFrame != null) {
            arrayList.add(lllIIIlIlI.llIIlIlIIl(barcodeCameraFrame, 3));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return llIIlIlIIl(context, blinkIdRecognizer.toSignedJson().getPayload(), arrayList, new lIIlIIIlII.llIIlIlIIl(result.getClassInfo(), result.getResultState(), result.getProcessingStatus(), result.getRecognitionMode()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static llIllIlIII llIIlIlIIl(BlinkIdCombinedRecognizer blinkIdCombinedRecognizer, Context context) {
        BlinkIdCombinedRecognizer.Result result = (BlinkIdCombinedRecognizer.Result) blinkIdCombinedRecognizer.getResult();
        Image frontCameraFrame = result.getFrontCameraFrame();
        Image backCameraFrame = result.getBackCameraFrame();
        Image barcodeCameraFrame = result.getBarcodeCameraFrame();
        ArrayList arrayList = new ArrayList();
        if (frontCameraFrame != null) {
            arrayList.add(lllIIIlIlI.llIIlIlIIl(frontCameraFrame, 1));
        }
        if (backCameraFrame != null) {
            arrayList.add(lllIIIlIlI.llIIlIlIIl(backCameraFrame, 2));
        }
        if (barcodeCameraFrame != null) {
            arrayList.add(lllIIIlIlI.llIIlIlIIl(barcodeCameraFrame, 3));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        lIIlIIIlII.llIIlIlIIl lliililiil = new lIIlIIIlII.llIIlIlIIl(result.getClassInfo(), result.getResultState(), result.getProcessingStatus(), result.getRecognitionMode());
        lliililiil.llIIlIlIIl(result.getDataMatchDetailedInfo());
        return llIIlIlIIl(context, blinkIdCombinedRecognizer.toSignedJson().getPayload(), arrayList, lliililiil);
    }

    private static llIllIlIII llIIlIlIIl(Context context, String str, ArrayList<lllIIIlIlI> arrayList, lIIlIIIlII.llIIlIlIIl lliililiil) {
        llIllIlIII.IlIllIlIIl ilIllIlIIl = new llIllIlIII.IlIllIlIIl();
        ilIllIlIIl.llIIlIlIIl("AndroidSDK");
        ilIllIlIIl.llIIlIlIIl(arrayList);
        ilIllIlIIl.IlIllIlIIl("1.0");
        ilIllIlIIl.IllIIIllII(str);
        ilIllIlIIl.llIIlIlIIl(lIIlIIIlII.llIIlIlIIl(context, lliililiil));
        return ilIllIlIIl.llIIlIlIIl();
    }
}
