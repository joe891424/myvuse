package com.yoti.mobile.android.liveness.data.remote.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/data/remote/model/LivenessValidationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "attemptsLeft", "", "(I)V", "getAttemptsLeft", "()I", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class LivenessValidationException extends Exception {
    private final int attemptsLeft;

    public LivenessValidationException(int i) {
        super("An error occurred with the liveness verification and there are " + i + " attempts left");
        this.attemptsLeft = i;
    }

    public final int getAttemptsLeft() {
        return this.attemptsLeft;
    }
}
