package com.microblink.fragment.overlay.blinkid.reticleui;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
enum StatusMessageMode {
    IMMEDIATE,
    DELAYED;

    public StatusMessageMode hurried() {
        return this == DELAYED ? IMMEDIATE : this;
    }
}
