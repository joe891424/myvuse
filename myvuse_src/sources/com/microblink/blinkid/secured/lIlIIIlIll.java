package com.microblink.blinkid.secured;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.microblink.hardware.camera.CameraType;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lIlIIIlIll {
    private int IlIllIlIIl = -1;
    private CameraType llIIlIlIIl;

    public void IlIllIlIIl() {
        this.llIIlIlIIl = null;
    }

    public int IllIIIllII() {
        return this.IlIllIlIIl;
    }

    public CameraType llIIIlllll() {
        return this.llIIlIlIIl;
    }

    public boolean llIIlIlIIl() {
        return this.IlIllIlIIl == 270;
    }

    public String llIIlIlIIl(CameraManager cameraManager, CameraType cameraType) throws CameraAccessException {
        String str;
        int iIntValue;
        int iIntValue2;
        String[] cameraIdList = cameraManager.getCameraIdList();
        Log.m2711i(this, IIllIllIIl.llIIlIlIIl("Available camera count: ").append(cameraIdList.length).toString(), new Object[0]);
        int length = cameraIdList.length;
        int i = -1;
        int i2 = 0;
        int i3 = -1;
        String str2 = null;
        String str3 = null;
        Boolean boolValueOf = null;
        Boolean boolValueOf2 = null;
        while (i2 < length) {
            String str4 = cameraIdList[i2];
            CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str4);
            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            if (num == null) {
                throw new RuntimeException("Device returned null for lens facing of camera '" + str4 + "'. This is a bug in device, as it does not implement Camera API as it is supposed to.");
            }
            String[] strArr = cameraIdList;
            int i4 = length;
            if (num.intValue() == 0) {
                if (str3 == null) {
                    Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                    if (num2 == null) {
                        throw new RuntimeException("Device returned null for sensor orientation of camera '" + str4 + "'. This is a bug in device, as it does not implement Camera API as it is supposed to.");
                    }
                    iIntValue2 = num2.intValue();
                    Log.m2711i(this, "Front facing orientation is {}", Integer.valueOf(iIntValue2));
                    Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
                    boolValueOf = Boolean.valueOf((f == null || f.floatValue() == 0.0f) ? false : true);
                } else if (boolValueOf.booleanValue()) {
                    Log.m2715w(this, "Handling multiple front cameras with autofocus currently not supported! Will use the first found '{}'", str3);
                } else {
                    Float f2 = (Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
                    if (f2 != null && f2.floatValue() != 0.0f) {
                        Integer num3 = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                        if (num3 == null) {
                            throw new RuntimeException("Device returned null for sensor orientation of camera '" + str4 + "'. This is a bug in device, as it does not implement Camera API as it is supposed to.");
                        }
                        iIntValue2 = num3.intValue();
                        Log.m2711i(this, "Front facing orientation is {}", Integer.valueOf(iIntValue2));
                        boolValueOf = Boolean.TRUE;
                    }
                }
                i3 = iIntValue2;
                str3 = str4;
            } else if (num.intValue() == 1) {
                Log.m2711i(this, "Back face camera found", new Object[0]);
                if (str2 == null) {
                    Integer num4 = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                    if (num4 == null) {
                        throw new RuntimeException("Device returned null for sensor orientation of camera '" + str4 + "'. This is a bug in device, as it does not implement Camera API as it is supposed to.");
                    }
                    iIntValue = num4.intValue();
                    Log.m2711i(this, "Back facing orientation is {}", Integer.valueOf(iIntValue));
                    Float f3 = (Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
                    boolValueOf2 = Boolean.valueOf((f3 == null || f3.floatValue() == 0.0f) ? false : true);
                } else if (boolValueOf2.booleanValue()) {
                    Log.m2715w(this, "Handling multiple back cameras with autofocus currently not supported. Will use the first found '{}'", str2);
                } else {
                    Float f4 = (Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
                    if (f4 != null && f4.floatValue() != 0.0f) {
                        Integer num5 = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                        if (num5 == null) {
                            throw new RuntimeException("Device returned null for sensor orientation of camera '" + str4 + "'. This is a bug in device, as it does not implement Camera API as it is supposed to.");
                        }
                        iIntValue = num5.intValue();
                        Log.m2711i(this, "Back facing orientation is {}", Integer.valueOf(iIntValue));
                        boolValueOf2 = Boolean.TRUE;
                    }
                }
                i = iIntValue;
                str2 = str4;
            } else {
                continue;
            }
            i2++;
            cameraIdList = strArr;
            length = i4;
        }
        if (cameraType == CameraType.CAMERA_DEFAULT) {
            if (str2 != null) {
                this.llIIlIlIIl = CameraType.CAMERA_BACKFACE;
                this.IlIllIlIIl = i;
            } else {
                this.llIIlIlIIl = CameraType.CAMERA_FRONTFACE;
                this.IlIllIlIIl = i3;
                str2 = str3;
            }
            if (str2 == null) {
                this.llIIlIlIIl = null;
                throw new RuntimeException("Device does not have cameras!");
            }
        } else {
            CameraType cameraType2 = CameraType.CAMERA_BACKFACE;
            if (cameraType != cameraType2) {
                CameraType cameraType3 = CameraType.CAMERA_FRONTFACE;
                if (cameraType == cameraType3) {
                    this.llIIlIlIIl = cameraType3;
                    this.IlIllIlIIl = i3;
                    if (str3 == null) {
                        this.llIIlIlIIl = null;
                        throw new RuntimeException("Device does not have front facing camera!");
                    }
                    str = str3;
                } else {
                    str = null;
                }
                Log.m2711i(this, "Selected camera ID is {}", str);
                Log.m2711i(this, "Camera sensor orientation is {}", Integer.valueOf(this.IlIllIlIIl));
                return str;
            }
            this.llIIlIlIIl = cameraType2;
            this.IlIllIlIIl = i;
            if (str2 == null) {
                this.llIIlIlIIl = null;
                throw new RuntimeException("Device does not have back facing camera!");
            }
        }
        str = str2;
        Log.m2711i(this, "Selected camera ID is {}", str);
        Log.m2711i(this, "Camera sensor orientation is {}", Integer.valueOf(this.IlIllIlIIl));
        return str;
    }
}
