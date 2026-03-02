package com.microblink.blinkid.secured;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class llIIIlIIII {
    private int llIIlIlIIl = -1;
    private int IlIllIlIIl = -1;
    private int IllIIIllII = -1;

    public llIIIlIIII(String str) {
        llIIlIlIIl(str);
    }

    private void llIIlIlIIl(String str) {
        if (str == null) {
            throw new NullPointerException("Cannot parse null version string!");
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length == 0) {
            throw new IllegalArgumentException("Invalid version string " + str);
        }
        if (strArrSplit.length >= 1) {
            this.llIIlIlIIl = Integer.parseInt(strArrSplit[0]);
            if (strArrSplit.length >= 2) {
                this.IlIllIlIIl = Integer.parseInt(strArrSplit[1]);
                if (strArrSplit.length >= 3) {
                    this.IllIIIllII = Integer.parseInt(strArrSplit[2]);
                }
            }
        }
    }

    public boolean IlIllIlIIl(llIIIlIIII lliiiliiii) {
        if (lliiiliiii == null) {
            throw new NullPointerException("Cannot compare with null version!");
        }
        int i = this.llIIlIlIIl;
        int i2 = lliiiliiii.llIIlIlIIl;
        if (i < i2) {
            return false;
        }
        if (i > i2) {
            return true;
        }
        int i3 = this.IlIllIlIIl;
        if (i3 == -1) {
            return false;
        }
        int i4 = lliiiliiii.IlIllIlIIl;
        if (i4 == -1) {
            return i3 != 0;
        }
        if (i3 < i4) {
            return false;
        }
        if (i3 > i4) {
            return true;
        }
        int i5 = this.IllIIIllII;
        if (i5 == -1) {
            return false;
        }
        int i6 = lliiiliiii.IllIIIllII;
        return i6 == -1 ? i5 != 0 : i5 > i6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.llIIlIlIIl);
        if (this.IlIllIlIIl != -1) {
            sb.append('.');
            sb.append(this.IlIllIlIIl);
            if (this.IllIIIllII != -1) {
                sb.append('.');
                sb.append(this.IllIIIllII);
            }
        }
        return sb.toString();
    }

    public boolean llIIlIlIIl(llIIIlIIII lliiiliiii) {
        if (lliiiliiii != null) {
            int i = this.llIIlIlIIl;
            int i2 = lliiiliiii.llIIlIlIIl;
            if (i < i2) {
                return false;
            }
            if (i > i2) {
                return true;
            }
            int i3 = this.IlIllIlIIl;
            if (i3 == -1) {
                int i4 = lliiiliiii.IlIllIlIIl;
                return i4 == -1 || i4 == 0;
            }
            int i5 = lliiiliiii.IlIllIlIIl;
            if (i5 == -1) {
                return true;
            }
            if (i3 < i5) {
                return false;
            }
            if (i3 > i5) {
                return true;
            }
            int i6 = this.IllIIIllII;
            if (i6 == -1) {
                int i7 = lliiiliiii.IllIIIllII;
                return i7 == -1 || i7 == 0;
            }
            int i8 = lliiiliiii.IllIIIllII;
            return i8 == -1 || i6 >= i8;
        }
        throw new NullPointerException("Cannot compare with null version!");
    }
}
