package com.microblink.blinkid.secured;

import android.graphics.Point;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import android.view.Display;
import android.view.WindowManager;
import com.microblink.blinkid.secured.IlIIIlIIIl;
import com.microblink.hardware.camera.VideoResolutionPreset;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IIlIlIIlll {
    private lIlIllIIlI IlIllIlIIl;
    private int IllIIIIllI;
    private Size IllIIIllII;
    private Size llIIIlllll;
    private CameraCharacteristics llIIlIlIIl;

    IIlIlIIlll(lIlIllIIlI lililliili) {
        this.IlIllIlIIl = lililliili;
    }

    Size IlIllIlIIl() {
        return this.llIIIlllll;
    }

    Size IllIIIllII() {
        return this.IllIIIllII;
    }

    lIllllIlll llIIIlllll() {
        Size size = this.IllIIIllII;
        if (size == null) {
            return null;
        }
        return new lIllllIlll(size.getWidth(), this.IllIIIllII.getHeight());
    }

    void llIIlIlIIl(CameraCharacteristics cameraCharacteristics, IIllllllll iIllllllll) {
        Size sizeLlIIlIlIIl;
        this.llIIlIlIIl = cameraCharacteristics;
        VideoResolutionPreset videoResolutionPresetIIlIIIllIl = iIllllllll.IIlIIIllIl();
        int iIllIIIIllI = iIllllllll.IllIIIIllI();
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.llIIlIlIIl.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            throw new RuntimeException("Unable to obtain scaler stream configuration map. This is a bug in device!");
        }
        for (int i : streamConfigurationMap.getOutputFormats()) {
            if (i == 35) {
                Size[] outputSizes = streamConfigurationMap.getOutputSizes(35);
                if (videoResolutionPresetIIlIIIllIl == VideoResolutionPreset.VIDEO_RESOLUTION_MAX_AVAILABLE) {
                    sizeLlIIlIlIIl = llIIlIlIIl(35);
                } else {
                    Size size = outputSizes[0];
                    Integer num = (Integer) this.llIIlIlIIl.get(CameraCharacteristics.LENS_FACING);
                    IlIIIlIIIl.llIIlIlIIl lliililiilIllIIlIIII = (num == null || num.intValue() != 1) ? (num == null || num.intValue() != 0) ? null : this.IlIllIlIIl.IllIIlIIII() : this.IlIllIlIIl.lllIlIlIIl();
                    VideoResolutionPreset videoResolutionPreset = VideoResolutionPreset.VIDEO_RESOLUTION_DEFAULT;
                    if (videoResolutionPresetIIlIIIllIl != videoResolutionPreset || lliililiilIllIIlIIII == null) {
                        Display defaultDisplay = ((WindowManager) this.IlIllIlIIl.llIIIlllll().getSystemService("window")).getDefaultDisplay();
                        Point point = new Point();
                        defaultDisplay.getSize(point);
                        int iMax = Math.max(point.x, point.y);
                        int iMin = Math.min(point.x, point.y);
                        double d = videoResolutionPresetIIlIIIllIl == videoResolutionPreset ? ((double) iMax) / ((double) iMin) : 1.7777777777777777d;
                        Log.m2711i(this, "Expected camera frame aspect ratio is {}", Double.valueOf(d));
                        int idealHeight = videoResolutionPresetIIlIIIllIl.getIdealHeight();
                        long jRound = Math.round(((double) idealHeight) * d);
                        Log.m2711i(this, "Attempting to choose resolution most similar to {}x{} (screen is {}x{})", Long.valueOf(jRound), Integer.valueOf(idealHeight), Integer.valueOf(iMax), Integer.valueOf(iMin));
                        long j = jRound * ((long) idealHeight);
                        double dLlIIlIlIIl = llIIlIlIIl(size, d, j, iIllIIIIllI);
                        for (int i2 = 1; i2 < outputSizes.length; i2++) {
                            Log.m2707d(this, "Available preview size is {}", outputSizes[i2]);
                            double dLlIIlIlIIl2 = llIIlIlIIl(outputSizes[i2], d, j, iIllIIIIllI);
                            Log.m2713v(this, "Compatibility for size {} is {}", outputSizes[i2], Double.valueOf(dLlIIlIlIIl2));
                            if (dLlIIlIlIIl2 < dLlIIlIlIIl) {
                                size = outputSizes[i2];
                                dLlIIlIlIIl = dLlIIlIlIIl2;
                            }
                        }
                        sizeLlIIlIlIIl = size;
                    } else {
                        Size size2 = new Size(lliililiilIllIIlIIII.IlIllIlIIl(), lliililiilIllIIlIIII.llIIlIlIIl());
                        Log.m2711i(this, "This device will use special preview size because normal default appears to be buggy", size2);
                        sizeLlIIlIlIIl = size2;
                    }
                }
                Log.m2711i(this, "For preset {}, selected preview size is {}", videoResolutionPresetIIlIIIllIl, sizeLlIIlIlIIl);
                Log.m2711i(this, "Output stall duration is {}", Long.valueOf(streamConfigurationMap.getOutputStallDuration(35, sizeLlIIlIlIIl)));
                Log.m2711i(this, "Output min frame duration is {}", Long.valueOf(streamConfigurationMap.getOutputMinFrameDuration(35, sizeLlIIlIlIIl)));
                this.IllIIIllII = sizeLlIIlIlIIl;
                Size sizeLlIIlIlIIl2 = llIIlIlIIl(35);
                Size sizeLlIIlIlIIl3 = llIIlIlIIl(256);
                if (sizeLlIIlIlIIl2.getHeight() * sizeLlIIlIlIIl2.getWidth() >= sizeLlIIlIlIIl3.getHeight() * sizeLlIIlIlIIl3.getWidth()) {
                    this.IllIIIIllI = 35;
                } else {
                    this.IllIIIIllI = 256;
                    sizeLlIIlIlIIl2 = sizeLlIIlIlIIl3;
                }
                this.llIIIlllll = sizeLlIIlIlIIl2;
                return;
            }
        }
        throw new RuntimeException("Expected preview format not supported!");
    }

    int llIIlIlIIl() {
        return this.IllIIIIllI;
    }

    private Size llIIlIlIIl(int i) {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.llIIlIlIIl.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            for (int i2 : streamConfigurationMap.getOutputFormats()) {
                if (i2 == i) {
                    Size[] outputSizes = streamConfigurationMap.getOutputSizes(i);
                    Size size = outputSizes[0];
                    int width = size.getWidth() * size.getHeight();
                    for (int i3 = 1; i3 < outputSizes.length; i3++) {
                        int height = outputSizes[i3].getHeight() * outputSizes[i3].getWidth();
                        if (height > width) {
                            size = outputSizes[i3];
                            width = height;
                        }
                    }
                    return size;
                }
            }
            throw new RuntimeException("Expected preview format not supported!");
        }
        throw new RuntimeException("Unable to obtain scaler stream configuration map. This is a bug in device!");
    }

    private double llIIlIlIIl(Size size, double d, long j, int i) {
        if (size.getWidth() * size.getHeight() <= i) {
            return Double.POSITIVE_INFINITY;
        }
        return (Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - d) * 1100.0d) + (Math.abs(((((double) size.getWidth()) * ((double) size.getHeight())) / j) - 1.0d) * 1200.0d);
    }
}
