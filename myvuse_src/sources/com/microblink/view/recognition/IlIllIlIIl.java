package com.microblink.view.recognition;

import android.content.DialogInterface;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IlIllIlIIl implements DialogInterface.OnClickListener {
    final /* synthetic */ RecognizerRunnerView llIIlIlIIl;

    IlIllIlIIl(RecognizerRunnerView recognizerRunnerView) {
        this.llIIlIlIIl = recognizerRunnerView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.llIIlIlIIl.lIIIIIllIl.set(false);
        RecognizerRunnerView.IlIllIlIIl(this.llIIlIlIIl, true);
    }
}
