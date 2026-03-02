package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzg;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.LocalModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class LocalModelLoader {
    private MappedByteBuffer zza;
    private final Context zzb;
    private final LocalModel zzc;

    public LocalModelLoader(Context context, LocalModel localModel) {
        this.zzb = context;
        this.zzc = localModel;
    }

    public LocalModel getLocalModel() {
        return this.zzc;
    }

    public MappedByteBuffer load() throws MlKitException {
        Preconditions.checkNotNull(this.zzb, "Context can not be null");
        Preconditions.checkNotNull(this.zzc, "Model source can not be null");
        MappedByteBuffer mappedByteBuffer = this.zza;
        if (mappedByteBuffer != null) {
            return mappedByteBuffer;
        }
        String absoluteFilePath = this.zzc.getAbsoluteFilePath();
        String assetFilePath = this.zzc.getAssetFilePath();
        Uri uri = this.zzc.getUri();
        if (absoluteFilePath != null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(absoluteFilePath, RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME);
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    this.zza = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    randomAccessFile.close();
                    return this.zza;
                } finally {
                }
            } catch (IOException e) {
                String strValueOf = String.valueOf(this.zzc.getAbsoluteFilePath());
                throw new MlKitException(strValueOf.length() != 0 ? "Can not open the local file: ".concat(strValueOf) : new String("Can not open the local file: "), 14, e);
            }
        }
        if (assetFilePath != null) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenFd = this.zzb.getAssets().openFd(assetFilePath);
                try {
                    this.zza = new FileInputStream(assetFileDescriptorOpenFd.getFileDescriptor()).getChannel().map(FileChannel.MapMode.READ_ONLY, assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getDeclaredLength());
                    if (assetFileDescriptorOpenFd != null) {
                        assetFileDescriptorOpenFd.close();
                    }
                    return this.zza;
                } finally {
                }
            } catch (IOException e2) {
                StringBuilder sb = new StringBuilder(assetFilePath.length() + 186);
                sb.append("Can not load the file from asset: ");
                sb.append(assetFilePath);
                sb.append(". Please double check your asset file name and ensure it's not compressed. See documentation for details how to use aaptOptions to skip file compression");
                throw new MlKitException(sb.toString(), 14, e2);
            }
        }
        if (uri == null) {
            throw new MlKitException("Can not load the model. One of filePath, assetFilePath or URI must be set for the model.", 14);
        }
        try {
            AssetFileDescriptor assetFileDescriptorZza = zzg.zza(this.zzb, uri, RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME);
            try {
                this.zza = assetFileDescriptorZza.createInputStream().getChannel().map(FileChannel.MapMode.READ_ONLY, assetFileDescriptorZza.getStartOffset(), assetFileDescriptorZza.getLength());
                if (assetFileDescriptorZza != null) {
                    assetFileDescriptorZza.close();
                }
                return this.zza;
            } finally {
            }
        } catch (IOException e3) {
            String strValueOf2 = String.valueOf(uri);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 32);
            sb2.append("Can not load the file from URI: ");
            sb2.append(strValueOf2);
            throw new MlKitException(sb2.toString(), 14, e3);
        }
    }
}
