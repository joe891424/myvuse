package com.microblink.view.exception;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class CalledFromWrongThreadException extends RuntimeException {
    public CalledFromWrongThreadException(String str) {
        super(str);
    }

    public CalledFromWrongThreadException(String str, Throwable th) {
        super(str, th);
    }
}
