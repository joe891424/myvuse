package com.google.mlkit.common.model;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzt;
import com.google.android.gms.internal.mlkit_common.zzu;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.BaseModel;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class RemoteModel {
    private final String zzb;
    private final BaseModel zzc;
    private final ModelType zzd;
    private String zzf;
    private static final Map<BaseModel, String> zze = new EnumMap(BaseModel.class);
    public static final Map<BaseModel, String> zza = new EnumMap(BaseModel.class);

    protected RemoteModel(String str, BaseModel baseModel, ModelType modelType) {
        Preconditions.checkArgument(TextUtils.isEmpty(str) == (baseModel != null), "One of cloud model name and base model cannot be empty");
        this.zzb = str;
        this.zzc = baseModel;
        this.zzd = modelType;
    }

    public boolean baseModelHashMatches(String str) {
        BaseModel baseModel = this.zzc;
        if (baseModel == null) {
            return false;
        }
        return str.equals(zze.get(baseModel));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemoteModel)) {
            return false;
        }
        RemoteModel remoteModel = (RemoteModel) obj;
        return Objects.equal(this.zzb, remoteModel.zzb) && Objects.equal(this.zzc, remoteModel.zzc) && Objects.equal(this.zzd, remoteModel.zzd);
    }

    public String getModelHash() {
        return this.zzf;
    }

    public String getModelName() {
        return this.zzb;
    }

    public String getModelNameForBackend() {
        String str = this.zzb;
        return str != null ? str : zza.get(this.zzc);
    }

    public ModelType getModelType() {
        return this.zzd;
    }

    public String getUniqueModelNameForPersist() {
        String str = this.zzb;
        if (str != null) {
            return str;
        }
        String strValueOf = String.valueOf(zza.get(this.zzc));
        return strValueOf.length() != 0 ? "COM.GOOGLE.BASE_".concat(strValueOf) : new String("COM.GOOGLE.BASE_");
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, this.zzc, this.zzd);
    }

    public boolean isBaseModel() {
        return this.zzc != null;
    }

    public void setModelHash(String str) {
        this.zzf = str;
    }

    public String toString() {
        zzt zztVarZzb = zzu.zzb("RemoteModel");
        zztVarZzb.zza("modelName", this.zzb);
        zztVarZzb.zza("baseModel", this.zzc);
        zztVarZzb.zza("modelType", this.zzd);
        return zztVarZzb.toString();
    }
}
