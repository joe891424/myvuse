package com.rnfs;

/* JADX INFO: loaded from: classes6.dex */
class IORejectionException extends Exception {
    private String code;

    public IORejectionException(String str, String str2) {
        super(str2);
        this.code = str;
    }

    public String getCode() {
        return this.code;
    }
}
