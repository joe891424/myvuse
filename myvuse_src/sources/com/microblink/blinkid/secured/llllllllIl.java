package com.microblink.blinkid.secured;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class llllllllIl {
    private final Map<IlIIlIIIll, lIlIIIIIll> llIIlIlIIl;

    llllllllIl(List<llIlIlIlII> list) {
        this.llIIlIlIIl = Collections.unmodifiableMap(llIIlIlIIl(list));
    }

    public boolean IlIllIlIIl() {
        if (this.llIIlIlIIl.isEmpty()) {
            return true;
        }
        Iterator<lIlIIIIIll> it2 = this.llIIlIlIIl.values().iterator();
        while (it2.hasNext()) {
            if (!it2.next().llIIIlllll()) {
                return false;
            }
        }
        return true;
    }

    public Map<IlIIlIIIll, lIlIIIIIll> llIIlIlIIl() {
        return this.llIIlIlIIl;
    }

    private static Map<IlIIlIIIll, lIlIIIIIll> llIIlIlIIl(List<llIlIlIlII> list) {
        HashMap map = new HashMap();
        for (llIlIlIlII llilililii : list) {
            if (map.containsKey(llilililii.IlIllIlIIl())) {
                lIlIIIIIll liliiiiill = (lIlIIIIIll) map.get(llilililii.IlIllIlIIl());
                lIlIIIIIll liliiiiillLlIIlIlIIl = llilililii.llIIlIlIIl();
                map.put(llilililii.IlIllIlIIl(), new lIlIIIIIll(liliiiiill.llIIlIlIIl() + liliiiiillLlIIlIlIIl.llIIlIlIIl(), liliiiiill.IllIIIllII() + liliiiiillLlIIlIlIIl.IllIIIllII(), liliiiiill.IlIllIlIIl() + liliiiiillLlIIlIlIIl.IlIllIlIIl()));
            } else {
                map.put(llilililii.IlIllIlIIl(), llilililii.llIIlIlIIl());
            }
        }
        return map;
    }

    static llllllllIl IlIllIlIIl(List<llllllllIl> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<llllllllIl> it2 = list.iterator();
        while (it2.hasNext()) {
            for (Map.Entry<IlIIlIIIll, lIlIIIIIll> entry : it2.next().llIIlIlIIl.entrySet()) {
                arrayList.add(new llIlIlIlII(entry.getKey(), entry.getValue()));
            }
        }
        return new llllllllIl(arrayList);
    }
}
