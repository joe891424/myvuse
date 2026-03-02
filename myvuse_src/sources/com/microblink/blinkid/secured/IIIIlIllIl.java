package com.microblink.blinkid.secured;

import com.microblink.util.Log;
import com.microblink.view.surface.CameraSurface;
import com.microblink.view.surface.ICameraView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IIIIlIllIl {

    /* JADX INFO: compiled from: line */
    static /* synthetic */ class llIIlIlIIl {
        static final /* synthetic */ int[] llIIlIlIIl;

        static {
            int[] iArr = new int[CameraSurface.values().length];
            llIIlIlIIl = iArr;
            try {
                iArr[CameraSurface.SURFACE_SURFACE_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                llIIlIlIIl[CameraSurface.SURFACE_TEXTURE_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                llIIlIlIIl[CameraSurface.SURFACE_DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static ICameraView llIIlIlIIl(lIlIllIIlI lililliili, IIllllllll iIllllllll, llllllllll llllllllllVar) {
        if (lililliili.lIllIIlIIl()) {
            Log.m2711i(IIIIlIllIl.class, "Creating CameraTextureView because of device list rule", new Object[0]);
            return new com.microblink.view.surface.IlIllIlIIl(lililliili.llIIIlllll());
        }
        int i = llIIlIlIIl.llIIlIlIIl[iIllllllll.lIlIIIIlIl().ordinal()];
        if (i == 1) {
            Log.m2711i(IIIIlIllIl.class, "Creating CameraSurfaceView because explicitly asked to", new Object[0]);
            return new com.microblink.view.surface.llIIlIlIIl(lililliili.llIIIlllll());
        }
        if (i == 2) {
            Log.m2711i(IIIIlIllIl.class, "Creating CameraTextureView because explicitly asked to", new Object[0]);
            return new com.microblink.view.surface.IlIllIlIIl(lililliili.llIIIlllll());
        }
        if (llllllllllVar instanceof IlIlllllII) {
            Log.m2711i(IIIIlIllIl.class, "Defaulting to CameraTextureView", new Object[0]);
            return new com.microblink.view.surface.IlIllIlIIl(lililliili.llIIIlllll());
        }
        Log.m2711i(IIIIlIllIl.class, "Defaulting to CameraSurfaceView", new Object[0]);
        return new com.microblink.view.surface.llIIlIlIIl(lililliili.llIIIlllll());
    }
}
