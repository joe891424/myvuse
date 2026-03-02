package com.microblink.licence.exception;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class LicenceLockedException extends LicenceKeyException {
    public LicenceLockedException() {
        super("Active licence has been remotely locked");
    }
}
