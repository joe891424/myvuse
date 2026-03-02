package com.microblink.blinkid.secured;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class llIllIlIII {
    private String IlIllIlIIl;
    private String IllIIIIllI;
    private JSONObject IllIIIllII;
    private List<lllIIIlIlI> llIIIlllll;
    private String llIIlIlIIl;

    public String IlIllIlIIl() {
        return this.IlIllIlIIl;
    }

    public String IllIIIIllI() {
        return this.IllIIIIllI;
    }

    public List<lllIIIlIlI> IllIIIllII() {
        return this.llIIIlllll;
    }

    public JSONObject llIIIlllll() {
        return this.IllIIIllII;
    }

    public String llIIlIlIIl() {
        return this.llIIlIlIIl;
    }

    private llIllIlIII(String str, String str2, String str3, JSONObject jSONObject, List<lllIIIlIlI> list, String str4) {
        this.llIIlIlIIl = str;
        this.IlIllIlIIl = str2;
        this.IllIIIllII = jSONObject;
        this.llIIIlllll = list;
        this.IllIIIIllI = str4;
    }

    /* JADX INFO: compiled from: line */
    public static class IlIllIlIIl {
        private String IlIllIlIIl;
        private List<lllIIIlIlI> IllIIIIllI = new ArrayList();
        private JSONObject IllIIIllII;
        private String llIIIlllll;
        private String llIIlIlIIl;

        public IlIllIlIIl IlIllIlIIl(String str) {
            this.IlIllIlIIl = str;
            return this;
        }

        public IlIllIlIIl IllIIIllII(String str) {
            this.llIIIlllll = str;
            return this;
        }

        public llIllIlIII llIIlIlIIl() {
            String str = this.llIIlIlIIl;
            if (str == null || str.length() == 0) {
                throw new NullPointerException("App name not set!");
            }
            String str2 = this.IlIllIlIIl;
            if (str2 == null || str2.length() == 0) {
                throw new NullPointerException("App version not set!");
            }
            List<lllIIIlIlI> list = this.IllIIIIllI;
            if (list == null || list.isEmpty()) {
                throw new NullPointerException("Bitmaps not set!");
            }
            return new llIllIlIII(this.llIIlIlIIl, this.IlIllIlIIl, "JPEG", this.IllIIIllII, this.IllIIIIllI, this.llIIIlllll);
        }

        public IlIllIlIIl llIIlIlIIl(String str) {
            this.llIIlIlIIl = str;
            return this;
        }

        public IlIllIlIIl llIIlIlIIl(JSONObject jSONObject) {
            this.IllIIIllII = jSONObject;
            return this;
        }

        public IlIllIlIIl llIIlIlIIl(List<lllIIIlIlI> list) {
            this.IllIIIIllI.clear();
            this.IllIIIIllI.addAll(list);
            return this;
        }
    }
}
