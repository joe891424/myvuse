package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraInfoInternal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class CameraSelectionOptimizer {
    private CameraSelectionOptimizer() {
    }

    static List<String> getSelectedAvailableCameraIds(Camera2CameraFactory cameraFactory, CameraSelector availableCamerasSelector) throws InitializationException {
        try {
            ArrayList arrayList = new ArrayList();
            String[] cameraIdList = cameraFactory.getCameraManager().getCameraIdList();
            int i = 0;
            if (availableCamerasSelector == null) {
                int length = cameraIdList.length;
                while (i < length) {
                    arrayList.add(cameraIdList[i]);
                    i++;
                }
                return arrayList;
            }
            String strDecideSkippedCameraIdByHeuristic = decideSkippedCameraIdByHeuristic(cameraFactory.getCameraManager(), availableCamerasSelector.getLensFacing());
            ArrayList arrayList2 = new ArrayList();
            int length2 = cameraIdList.length;
            while (i < length2) {
                String str = cameraIdList[i];
                if (!str.equals(strDecideSkippedCameraIdByHeuristic)) {
                    arrayList2.add(cameraFactory.getCameraInfo(str));
                }
                i++;
            }
            Iterator<CameraInfo> it2 = availableCamerasSelector.filter(arrayList2).iterator();
            while (it2.hasNext()) {
                arrayList.add(((CameraInfoInternal) it2.next()).getCameraId());
            }
            return arrayList;
        } catch (CameraAccessExceptionCompat e) {
            throw new InitializationException(CameraUnavailableExceptionHelper.createFrom(e));
        } catch (CameraUnavailableException e2) {
            throw new InitializationException(e2);
        }
    }

    private static String decideSkippedCameraIdByHeuristic(CameraManagerCompat cameraManager, Integer lensFacingInteger) throws CameraAccessExceptionCompat {
        if (lensFacingInteger == null) {
            return null;
        }
        if (lensFacingInteger.intValue() == 1) {
            if (((Integer) cameraManager.getCameraCharacteristicsCompat("0").get(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                return "1";
            }
            return null;
        }
        if (lensFacingInteger.intValue() == 0 && ((Integer) cameraManager.getCameraCharacteristicsCompat("1").get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
            return "0";
        }
        return null;
    }
}
