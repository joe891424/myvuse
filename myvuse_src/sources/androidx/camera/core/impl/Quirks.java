package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Quirks {
    private final List<Quirk> mQuirks;

    public Quirks(final List<Quirk> quirks) {
        this.mQuirks = new ArrayList(quirks);
    }

    public <T extends Quirk> T get(final Class<T> quirkClass) {
        Iterator<Quirk> it2 = this.mQuirks.iterator();
        while (it2.hasNext()) {
            T t = (T) it2.next();
            if (t.getClass() == quirkClass) {
                return t;
            }
        }
        return null;
    }

    public boolean contains(Class<? extends Quirk> quirkClass) {
        Iterator<Quirk> it2 = this.mQuirks.iterator();
        while (it2.hasNext()) {
            if (quirkClass.isAssignableFrom(it2.next().getClass())) {
                return true;
            }
        }
        return false;
    }
}
