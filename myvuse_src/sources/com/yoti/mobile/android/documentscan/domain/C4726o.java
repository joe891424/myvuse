package com.yoti.mobile.android.documentscan.domain;

import com.yoti.mobile.android.commons.util.FileManager;
import com.yoti.mobile.android.documentcapture.p055id.IdDocumentCaptureConstantsKt;
import io.reactivex.functions.Action;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.o */
/* JADX INFO: loaded from: classes5.dex */
final class C4726o implements Action {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4727p f6926a;

    C4726o(C4727p c4727p) {
        this.f6926a = c4727p;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        FileManager.deleteDir(this.f6926a.f6928b.getDir(IdDocumentCaptureConstantsKt.TEMP_FILES_PATH, 0));
    }
}
