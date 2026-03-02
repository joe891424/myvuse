package androidx.camera.core.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    static List<Quirk> loadQuirks() {
        ArrayList arrayList = new ArrayList();
        if (HuaweiMediaStoreLocationValidationQuirk.load()) {
            arrayList.add(new HuaweiMediaStoreLocationValidationQuirk());
        }
        if (IncompleteCameraListQuirk.load()) {
            arrayList.add(new IncompleteCameraListQuirk());
        }
        if (ImageCaptureRotationOptionQuirk.load()) {
            arrayList.add(new ImageCaptureRotationOptionQuirk());
        }
        return arrayList;
    }
}
