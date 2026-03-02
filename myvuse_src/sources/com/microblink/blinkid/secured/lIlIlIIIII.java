package com.microblink.blinkid.secured;

import kotlin.text.Typography;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lIlIlIIIII {
    private llIIIlIIII IlIllIlIIl;
    private boolean IllIIIIllI;
    private boolean IllIIIllII;
    private boolean llIIIlllll;
    private llIIIlIIII llIIlIlIIl;

    public lIlIlIIIII(String str) {
        this.llIIlIlIIl = null;
        this.IlIllIlIIl = null;
        this.IllIIIllII = false;
        this.llIIIlllll = true;
        this.IllIIIIllI = true;
        if (str == null || str.length() == 0) {
            throw new NullPointerException("Interval expression cannot be null nor empty!");
        }
        String strTrim = str.trim();
        if ("*".equals(strTrim)) {
            this.IllIIIllII = true;
            return;
        }
        if (strTrim.charAt(0) == '[') {
            this.llIIIlllll = true;
        } else {
            if (strTrim.charAt(0) != '<') {
                throw new IllegalArgumentException("Invalid version interval: " + strTrim);
            }
            this.llIIIlllll = false;
        }
        int length = strTrim.length() - 1;
        if (strTrim.charAt(length) == ']') {
            this.IllIIIIllI = true;
        } else {
            if (strTrim.charAt(length) != '>') {
                throw new IllegalArgumentException("Invalid version interval: " + strTrim);
            }
            this.IllIIIIllI = false;
        }
        String[] strArrSplit = strTrim.substring(1, length).split(",");
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Invalid version interval: " + strTrim);
        }
        if (!"*".equals(strArrSplit[0])) {
            this.llIIlIlIIl = new llIIIlIIII(strArrSplit[0]);
        }
        if ("*".equals(strArrSplit[1])) {
            return;
        }
        this.IlIllIlIIl = new llIIIlIIII(strArrSplit[1]);
    }

    public boolean llIIlIlIIl(llIIIlIIII lliiiliiii) {
        if (this.IllIIIllII) {
            return true;
        }
        llIIIlIIII lliiiliiii2 = this.llIIlIlIIl;
        if (lliiiliiii2 != null && (!this.llIIIlllll ? lliiiliiii.IlIllIlIIl(lliiiliiii2) : lliiiliiii.llIIlIlIIl(lliiiliiii2))) {
            return false;
        }
        llIIIlIIII lliiiliiii3 = this.IlIllIlIIl;
        if (lliiiliiii3 == null) {
            return true;
        }
        if (this.IllIIIIllI) {
            if (lliiiliiii3.llIIlIlIIl(lliiiliiii)) {
                return true;
            }
        } else if (lliiiliiii3.IlIllIlIIl(lliiiliiii)) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.IllIIIllII) {
            sb.append('*');
        } else {
            if (this.llIIIlllll) {
                sb.append('[');
            } else {
                sb.append(Typography.less);
            }
            llIIIlIIII lliiiliiii = this.llIIlIlIIl;
            if (lliiiliiii != null) {
                sb.append(lliiiliiii.toString());
            } else {
                sb.append('*');
            }
            sb.append(',');
            llIIIlIIII lliiiliiii2 = this.IlIllIlIIl;
            if (lliiiliiii2 != null) {
                sb.append(lliiiliiii2.toString());
            } else {
                sb.append('*');
            }
            if (this.IllIIIIllI) {
                sb.append(']');
            } else {
                sb.append(Typography.greater);
            }
        }
        return sb.toString();
    }
}
