package com.microblink.fragment.overlay.components;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class ScanSoundPlayer {
    private int IlIllIlIIl = -1;
    private SoundPool llIIlIlIIl;

    public void clear() {
        SoundPool soundPool = this.llIIlIlIIl;
        if (soundPool != null) {
            try {
                soundPool.release();
            } catch (IllegalStateException unused) {
            }
            this.llIIlIlIIl = null;
            this.IlIllIlIIl = -1;
        }
    }

    public void play() {
        int i;
        SoundPool soundPool = this.llIIlIlIIl;
        if (soundPool == null || (i = this.IlIllIlIIl) == -1) {
            return;
        }
        soundPool.play(i, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void initialize(Context context, int i) {
        if (i > 0) {
            SoundPool soundPoolBuild = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).build();
            this.llIIlIlIIl = soundPoolBuild;
            this.IlIllIlIIl = soundPoolBuild.load(context, i, 1);
        }
    }
}
