package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public class zzjt extends IOException {
    static zzjs zza() {
        return new zzjs("Protocol message tag had invalid wire type.");
    }

    static zzjt zzb() {
        return new zzjt("Protocol message end-group tag did not match expected tag.");
    }

    static zzjt zzc() {
        return new zzjt("Protocol message contained an invalid tag (zero).");
    }

    static zzjt zzd() {
        return new zzjt("Protocol message had invalid UTF-8.");
    }

    static zzjt zze() {
        return new zzjt("CodedInputStream encountered a malformed varint.");
    }

    static zzjt zzf() {
        return new zzjt("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzjt zzg() {
        return new zzjt("Failed to parse the message.");
    }

    static zzjt zzh() {
        return new zzjt("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public zzjt(String str) {
        super(str);
    }
}
