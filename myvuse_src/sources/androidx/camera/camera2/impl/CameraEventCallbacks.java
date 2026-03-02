package androidx.camera.camera2.impl;

import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.MultiValueSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CameraEventCallbacks extends MultiValueSet<CameraEventCallback> {
    public CameraEventCallbacks(CameraEventCallback... callbacks) {
        addAll(Arrays.asList(callbacks));
    }

    public ComboCameraEventCallback createComboCallback() {
        return new ComboCameraEventCallback(getAllItems());
    }

    public static CameraEventCallbacks createEmptyCallback() {
        return new CameraEventCallbacks(new CameraEventCallback[0]);
    }

    @Override // androidx.camera.core.impl.MultiValueSet
    /* JADX INFO: renamed from: clone */
    public MultiValueSet<CameraEventCallback> mo5712clone() {
        CameraEventCallbacks cameraEventCallbacksCreateEmptyCallback = createEmptyCallback();
        cameraEventCallbacksCreateEmptyCallback.addAll(getAllItems());
        return cameraEventCallbacksCreateEmptyCallback;
    }

    public static final class ComboCameraEventCallback {
        private final List<CameraEventCallback> mCallbacks = new ArrayList();

        ComboCameraEventCallback(List<CameraEventCallback> callbacks) {
            Iterator<CameraEventCallback> it2 = callbacks.iterator();
            while (it2.hasNext()) {
                this.mCallbacks.add(it2.next());
            }
        }

        public List<CaptureConfig> onPresetSession() {
            ArrayList arrayList = new ArrayList();
            Iterator<CameraEventCallback> it2 = this.mCallbacks.iterator();
            while (it2.hasNext()) {
                CaptureConfig captureConfigOnPresetSession = it2.next().onPresetSession();
                if (captureConfigOnPresetSession != null) {
                    arrayList.add(captureConfigOnPresetSession);
                }
            }
            return arrayList;
        }

        public List<CaptureConfig> onEnableSession() {
            ArrayList arrayList = new ArrayList();
            Iterator<CameraEventCallback> it2 = this.mCallbacks.iterator();
            while (it2.hasNext()) {
                CaptureConfig captureConfigOnEnableSession = it2.next().onEnableSession();
                if (captureConfigOnEnableSession != null) {
                    arrayList.add(captureConfigOnEnableSession);
                }
            }
            return arrayList;
        }

        public List<CaptureConfig> onRepeating() {
            ArrayList arrayList = new ArrayList();
            Iterator<CameraEventCallback> it2 = this.mCallbacks.iterator();
            while (it2.hasNext()) {
                CaptureConfig captureConfigOnRepeating = it2.next().onRepeating();
                if (captureConfigOnRepeating != null) {
                    arrayList.add(captureConfigOnRepeating);
                }
            }
            return arrayList;
        }

        public List<CaptureConfig> onDisableSession() {
            ArrayList arrayList = new ArrayList();
            Iterator<CameraEventCallback> it2 = this.mCallbacks.iterator();
            while (it2.hasNext()) {
                CaptureConfig captureConfigOnDisableSession = it2.next().onDisableSession();
                if (captureConfigOnDisableSession != null) {
                    arrayList.add(captureConfigOnDisableSession);
                }
            }
            return arrayList;
        }

        public List<CameraEventCallback> getCallbacks() {
            return this.mCallbacks;
        }
    }
}
