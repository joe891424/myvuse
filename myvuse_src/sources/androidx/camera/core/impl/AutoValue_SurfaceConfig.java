package androidx.camera.core.impl;

import androidx.camera.core.impl.SurfaceConfig;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_SurfaceConfig extends SurfaceConfig {
    private final SurfaceConfig.ConfigSize configSize;
    private final SurfaceConfig.ConfigType configType;

    AutoValue_SurfaceConfig(SurfaceConfig.ConfigType configType, SurfaceConfig.ConfigSize configSize) {
        if (configType == null) {
            throw new NullPointerException("Null configType");
        }
        this.configType = configType;
        if (configSize == null) {
            throw new NullPointerException("Null configSize");
        }
        this.configSize = configSize;
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    public SurfaceConfig.ConfigType getConfigType() {
        return this.configType;
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    public SurfaceConfig.ConfigSize getConfigSize() {
        return this.configSize;
    }

    public String toString() {
        return "SurfaceConfig{configType=" + this.configType + ", configSize=" + this.configSize + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SurfaceConfig)) {
            return false;
        }
        SurfaceConfig surfaceConfig = (SurfaceConfig) o;
        return this.configType.equals(surfaceConfig.getConfigType()) && this.configSize.equals(surfaceConfig.getConfigSize());
    }

    public int hashCode() {
        return ((this.configType.hashCode() ^ 1000003) * 1000003) ^ this.configSize.hashCode();
    }
}
