package com.microblink.fragment.overlay;

import android.os.Parcelable;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkid.CombinedDataMatchResult;
import com.microblink.entities.recognizers.blinkid.CombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.CombinedResult;
import com.microblink.entities.recognizers.blinkid.DataMatchResult;
import com.microblink.entities.recognizers.framegrabber.FrameGrabberRecognizer;
import com.microblink.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;
import com.microblink.image.CurrentImageListener;
import com.microblink.recognition.RecognitionSuccessType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentRecognizerManager {
    private CurrentImageListener IlIllIlIIl;
    private Map<Class<?>, ConcreteRecognizerExtractor> IllIIIllII = new HashMap();
    private RecognizerBundle llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    public interface ConcreteRecognizerExtractor {
        Recognizer<?> getConcreteRecognizer(Recognizer<?> recognizer);

        Class<?> getWrapperRecognizerClass();
    }

    public void addConcreteRecognizerExtractor(ConcreteRecognizerExtractor concreteRecognizerExtractor) {
        this.IllIIIllII.put(concreteRecognizerExtractor.getWrapperRecognizerClass(), concreteRecognizerExtractor);
    }

    public RecognizerBundle buildRecognizerBundle(DocumentSide documentSide) {
        RecognizerBundle recognizerBundle = new RecognizerBundle(getRecognizersFor(documentSide));
        recognizerBundle.setNumMsBeforeTimeout(getTimeoutMs());
        recognizerBundle.setAllowMultipleScanResultsOnSingleImage(this.llIIlIlIIl.shouldAllowMultipleScanResultsOnSingleImage());
        recognizerBundle.setFrameQualityEstimationMode(this.llIIlIlIIl.getFrameQualityEstimationMode());
        recognizerBundle.setRecognitionDebugMode(this.llIIlIlIIl.getRecognitionDebugMode());
        return recognizerBundle;
    }

    public boolean canScanDocument() {
        return this.llIIlIlIIl != null;
    }

    public void clearBundleState() {
        RecognizerBundle recognizerBundle = this.llIIlIlIIl;
        if (recognizerBundle != null) {
            recognizerBundle.clearSavedState();
        }
    }

    public Recognizer<?> getConcreteRecognizer(Recognizer recognizer) {
        if (recognizer instanceof SuccessFrameGrabberRecognizer) {
            return ((SuccessFrameGrabberRecognizer) recognizer).getSlaveRecognizer();
        }
        ConcreteRecognizerExtractor concreteRecognizerExtractor = this.IllIIIllII.get(recognizer.getClass());
        return concreteRecognizerExtractor != null ? concreteRecognizerExtractor.getConcreteRecognizer(recognizer) : recognizer;
    }

    public RecognizerBundle.RecognitionDebugMode getRecognitionDebugMode() {
        return this.llIIlIlIIl.getRecognitionDebugMode();
    }

    public List<Recognizer> getRecognizersFor(DocumentSide documentSide) {
        ArrayList arrayList = new ArrayList();
        if (documentSide == DocumentSide.FIRST_SIDE) {
            Collections.addAll(arrayList, this.llIIlIlIIl.getRecognizers());
        } else {
            Recognizer<Recognizer.Result>[] recognizers = this.llIIlIlIIl.getRecognizers();
            arrayList = new ArrayList();
            for (Recognizer<Recognizer.Result> recognizer : recognizers) {
                Parcelable concreteRecognizer = getConcreteRecognizer(recognizer);
                if ((concreteRecognizer instanceof CombinedRecognizer) && ((CombinedRecognizer) concreteRecognizer).getCombinedResult().isScanningFirstSideDone()) {
                    arrayList.add(recognizer);
                }
            }
        }
        if (this.IlIllIlIIl != null) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (it2.next() instanceof FrameGrabberRecognizer) {
                    it2.remove();
                    break;
                }
            }
            arrayList.add(new FrameGrabberRecognizer(this.IlIllIlIIl));
        }
        return arrayList;
    }

    public RecognitionSuccessType getScanSuccessType() {
        RecognizerBundle recognizerBundle = this.llIIlIlIIl;
        if (recognizerBundle == null) {
            return RecognitionSuccessType.SUCCESSFUL;
        }
        boolean z = false;
        for (Recognizer<Recognizer.Result> recognizer : recognizerBundle.getRecognizers()) {
            Recognizer.Result.State resultState = recognizer.getResult().getResultState();
            if (resultState == Recognizer.Result.State.Valid) {
                return RecognitionSuccessType.SUCCESSFUL;
            }
            if (resultState == Recognizer.Result.State.StageValid) {
                z = true;
            }
        }
        return z ? RecognitionSuccessType.STAGE_SUCCESSFUL : RecognitionSuccessType.PARTIAL;
    }

    public int getTimeoutMs() {
        return this.llIIlIlIIl.getNumMsBeforeTimeout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean hasInvalidDocumentDataMatch() {
        CombinedDataMatchResult combinedDataMatchResult = null;
        for (Recognizer<Recognizer.Result> recognizer : this.llIIlIlIIl.getRecognizers()) {
            Recognizer.Result result = (Recognizer.Result) getConcreteRecognizer(recognizer).getResult();
            Recognizer.Result.State resultState = result.getResultState();
            if (resultState == Recognizer.Result.State.Valid) {
                return (result instanceof CombinedDataMatchResult) && ((CombinedDataMatchResult) result).getDocumentDataMatch() == DataMatchResult.Failed;
            }
            if (resultState != Recognizer.Result.State.Empty && (result instanceof CombinedResult) && combinedDataMatchResult == null) {
                combinedDataMatchResult = (CombinedDataMatchResult) result;
            }
        }
        return combinedDataMatchResult != null && combinedDataMatchResult.getDocumentDataMatch() == DataMatchResult.Failed;
    }

    public void saveBundleState() {
        RecognizerBundle recognizerBundle = this.llIIlIlIIl;
        if (recognizerBundle != null) {
            recognizerBundle.saveState();
        }
    }

    public void setup(RecognizerBundle recognizerBundle, CurrentImageListener currentImageListener) {
        this.llIIlIlIIl = recognizerBundle;
        this.IlIllIlIIl = currentImageListener;
    }
}
