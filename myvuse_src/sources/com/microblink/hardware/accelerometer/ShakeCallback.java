package com.microblink.hardware.accelerometer;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface ShakeCallback {
    public static final ShakeCallback EMPTY = new llIIlIlIIl();

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements ShakeCallback {
        llIIlIlIIl() {
        }

        @Override // com.microblink.hardware.accelerometer.ShakeCallback
        public void onShakingStarted() {
        }

        @Override // com.microblink.hardware.accelerometer.ShakeCallback
        public void onShakingStopped() {
        }
    }

    void onShakingStarted();

    void onShakingStopped();
}
