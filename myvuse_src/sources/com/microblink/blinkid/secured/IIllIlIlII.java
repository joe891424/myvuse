package com.microblink.blinkid.secured;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.intent.MBIntentTransferable;
import com.microblink.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IIllIlIlII {
    private static volatile IIllIlIlII IllIIIllII;
    private Map<String, MBIntentTransferable> IlIllIlIIl = new HashMap();
    private lIIlIIlIll llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    class IlIllIlIIl implements Runnable {
        final /* synthetic */ boolean IlIllIlIIl;
        final /* synthetic */ String IllIIIllII;
        final /* synthetic */ Context llIIlIlIIl;

        IlIllIlIIl(Context context, boolean z, String str) {
            this.llIIlIlIIl = context;
            this.IlIllIlIIl = z;
            this.IllIIIllII = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = new File(this.llIIlIlIIl.getFilesDir(), "microblink_intent_data");
            if (!this.IlIllIlIIl) {
                File file2 = new File(file, this.IllIIIllII);
                if (file2.exists()) {
                    file2.delete();
                    return;
                }
                return;
            }
            for (File file3 : file.listFiles()) {
                if (!IIllIlIlII.this.IlIllIlIIl.containsKey(file3.getName())) {
                    file3.delete();
                }
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class IllIIIllII implements Runnable {
        final /* synthetic */ String IlIllIlIIl;
        final /* synthetic */ Context llIIlIlIIl;

        IllIIIllII(Context context, String str) {
            this.llIIlIlIIl = context;
            this.IlIllIlIIl = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            File filesDir = this.llIIlIlIIl.getFilesDir();
            IIllIlIlII iIllIlIlII = IIllIlIlII.this;
            String str = this.IlIllIlIIl;
            iIllIlIlII.getClass();
            new File(filesDir, "microblink_intent_data/" + str).delete();
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Runnable {
        final /* synthetic */ String IlIllIlIIl;
        final /* synthetic */ MBIntentTransferable IllIIIllII;
        final /* synthetic */ Context llIIlIlIIl;

        llIIlIlIIl(IIllIlIlII iIllIlIlII, Context context, String str, MBIntentTransferable mBIntentTransferable) {
            this.llIIlIlIIl = context;
            this.IlIllIlIIl = str;
            this.IllIIIllII = mBIntentTransferable;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = new File(this.llIIlIlIIl.getFilesDir(), "microblink_intent_data");
            file.mkdirs();
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(file, this.IlIllIlIIl)));
                Parcel parcelObtain = Parcel.obtain();
                this.IllIIIllII.writeToParcel(parcelObtain, 0);
                byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                bufferedOutputStream.write(bArrMarshall);
                bufferedOutputStream.close();
            } catch (IOException unused) {
                Log.m2715w(this, "Error while storing intent transferable data.", new Object[0]);
            }
        }
    }

    private IIllIlIlII() {
        this.llIIlIlIIl = null;
        lIIlIIlIll liiliilill = new lIIlIIlIll("IntentDataIO");
        this.llIIlIlIIl = liiliilill;
        liiliilill.start();
    }

    public static IIllIlIlII llIIlIlIIl() {
        if (IllIIIllII == null) {
            synchronized (IIllIlIlII.class) {
                if (IllIIIllII == null) {
                    IllIIIllII = new IIllIlIlII();
                }
            }
        }
        return IllIIIllII;
    }

    public void llIIlIlIIl(Context context, String str, MBIntentTransferable mBIntentTransferable, boolean z) {
        this.IlIllIlIIl.put(str, mBIntentTransferable);
        if (z) {
            this.llIIlIlIIl.llIIlIlIIl(new llIIlIlIIl(this, context, str, mBIntentTransferable));
        }
    }

    public <T extends MBIntentTransferable> T llIIlIlIIl(Context context, String str, Parcelable.Creator<T> creator, boolean z) {
        try {
            T t = (T) this.IlIllIlIIl.get(str);
            boolean z2 = !this.IlIllIlIIl.isEmpty();
            this.IlIllIlIIl.remove(str);
            if (z) {
                if (t == null) {
                    File file = new File(context.getFilesDir(), "microblink_intent_data/" + str);
                    byte[] bArr = null;
                    if (file.exists()) {
                        try {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int i = bufferedInputStream.read(bArr2);
                                if (i == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, i);
                            }
                            byteArrayOutputStream.flush();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            bufferedInputStream.close();
                            byteArrayOutputStream.close();
                            bArr = byteArray;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (bArr != null) {
                        Parcel parcelObtain = Parcel.obtain();
                        parcelObtain.unmarshall(bArr, 0, bArr.length);
                        parcelObtain.setDataPosition(0);
                        T tCreateFromParcel = creator.createFromParcel(parcelObtain);
                        parcelObtain.recycle();
                        t = tCreateFromParcel;
                    }
                }
                this.llIIlIlIIl.llIIlIlIIl(new IlIllIlIIl(context, z2, str));
            }
            return t;
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Previously stored transferable data is of unexpected type!");
        }
    }

    public void llIIlIlIIl(Context context, String str, boolean z) {
        this.IlIllIlIIl.remove(str);
        if (z) {
            this.llIIlIlIIl.llIIlIlIIl(new IllIIIllII(context, str));
        }
    }
}
