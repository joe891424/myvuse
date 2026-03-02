package com.facetec.sdk;

import android.graphics.Rect;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: classes3.dex */
public final class FaceTecCancelButtonCustomization {
    public int customImage = 0;

    /* JADX INFO: renamed from: Z */
    ButtonLocation f2205Z = ButtonLocation.TOP_LEFT;

    /* JADX INFO: renamed from: I */
    Rect f2204I = null;

    public enum ButtonLocation {
        TOP_LEFT("Top Left"),
        TOP_RIGHT("Top Right"),
        CUSTOM(TypedValues.Custom.NAME),
        DISABLED("Disabled");


        /* JADX INFO: renamed from: Z */
        private final String f2207Z;

        ButtonLocation(String str) {
            this.f2207Z = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.f2207Z;
        }
    }

    public final void setCustomLocation(Rect rect) {
        this.f2204I = rect;
    }

    public final Rect getCustomLocation() {
        return this.f2204I;
    }

    public final void setLocation(ButtonLocation buttonLocation) {
        if (buttonLocation == null) {
            buttonLocation = ButtonLocation.TOP_LEFT;
        }
        this.f2205Z = buttonLocation;
    }

    public final ButtonLocation getLocation() {
        return this.f2205Z;
    }
}
