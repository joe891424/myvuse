package com.microblink.blinkid.secured;

import android.content.Context;
import android.os.AsyncTask;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdRecognizer;
import com.microblink.util.Log;
import com.microblink.util.UserIdProvider;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
final class lIIllllIII implements IIlIIlIIII, IIIlIIIIlI {
    IIIIIIllIl IlIllIlIIl = new IIIllllllI();
    Context llIIlIlIIl;

    lIIllllIII(Context context) {
        this.llIIlIlIIl = context;
    }

    @Override // com.microblink.blinkid.secured.IIlIIlIIII
    public void llIIlIlIIl(RecognizerBundle recognizerBundle) {
        llIllIlIII llilliliiiLlIIlIlIIl;
        try {
            llIllIlIll llillilill = new llIllIlIll(UserIdProvider.getUserId(this.llIIlIlIIl));
            Recognizer<Recognizer.Result>[] recognizers = recognizerBundle.getRecognizers();
            int length = recognizers.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    llilliliiiLlIIlIlIIl = null;
                    break;
                }
                Recognizer<Recognizer.Result> recognizer = recognizers[i];
                if (recognizer instanceof BlinkIdRecognizer) {
                    llilliliiiLlIIlIlIIl = IlIllIlllI.llIIlIlIIl((BlinkIdRecognizer) recognizer, this.llIIlIlIIl);
                    break;
                } else {
                    if (recognizer instanceof BlinkIdCombinedRecognizer) {
                        llilliliiiLlIIlIlIIl = IlIllIlllI.llIIlIlIIl((BlinkIdCombinedRecognizer) recognizer, this.llIIlIlIIl);
                        break;
                    }
                    i++;
                }
            }
            llIllIlIII llilliliii = llilliliiiLlIIlIlIIl;
            if (llilliliii != null) {
                IIIlIIllII iIIlIIllII = new IIIlIIllII(this.llIIlIlIIl, this.IlIllIlIIl, llillilill, this, llilliliii);
                Void[] voidArr = new Void[0];
                if (iIIlIIllII instanceof AsyncTask) {
                    AsyncTaskInstrumentation.execute(iIIlIIllII, voidArr);
                } else {
                    iIIlIIllII.execute(voidArr);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.microblink.blinkid.secured.IIIlIIIIlI
    public void llIIlIlIIl(Boolean bool) {
        Log.m2707d(lIIllllIII.class, IIllIllIIl.llIIlIlIIl("Image upload done, successfully uploaded:").append(bool.toString()).toString(), new Object[0]);
    }

    @Override // com.microblink.blinkid.secured.IIIlIIIIlI
    public void llIIlIlIIl(Exception exc) {
        Log.m2707d(lIIllllIII.class, "Upload of image failed", exc.getMessage());
    }
}
