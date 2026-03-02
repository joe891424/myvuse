package androidx.camera.core.impl;

import androidx.camera.core.impl.UseCaseConfigFactory;

/* JADX INFO: loaded from: classes.dex */
public class CameraConfigs {
    private static final CameraConfig EMPTY_CONFIG = new EmptyCameraConfig();

    public static CameraConfig emptyConfig() {
        return EMPTY_CONFIG;
    }

    static final class EmptyCameraConfig implements CameraConfig {
        private final UseCaseConfigFactory mUseCaseConfigFactory = new UseCaseConfigFactory() { // from class: androidx.camera.core.impl.CameraConfigs.EmptyCameraConfig.1
            @Override // androidx.camera.core.impl.UseCaseConfigFactory
            public Config getConfig(UseCaseConfigFactory.CaptureType captureType) {
                return null;
            }
        };

        EmptyCameraConfig() {
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public UseCaseConfigFactory getUseCaseConfigFactory() {
            return this.mUseCaseConfigFactory;
        }

        @Override // androidx.camera.core.impl.ReadableConfig
        public Config getConfig() {
            return OptionsBundle.emptyBundle();
        }
    }

    private CameraConfigs() {
    }
}
