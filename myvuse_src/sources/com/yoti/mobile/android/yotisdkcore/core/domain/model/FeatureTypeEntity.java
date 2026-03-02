package com.yoti.mobile.android.yotisdkcore.core.domain.model;

import com.yoti.mobile.android.yotidocs.common.error.YotiSDKDependencyNotFoundError;
import com.yoti.mobile.android.yotidocs.common.error.YotiSDKDocumentCaptureDependencyNotFoundError;
import com.yoti.mobile.android.yotidocs.common.error.YotiSDKFaceCaptureDependencyNotFoundError;
import com.yoti.mobile.android.yotidocs.common.error.YotiSDKSupplementaryDocumentCaptureDependencyNotFoundError;
import com.yoti.mobile.android.yotidocs.common.error.YotiSDKZoomLivenessDependencyNotFoundError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/FeatureTypeEntity;", "", "launcher", "", "notFoundException", "Ljava/lang/Class;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiSDKDependencyNotFoundError;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Class;)V", "getLauncher", "()Ljava/lang/String;", "getNotFoundException", "()Ljava/lang/Class;", "validate", "", "ID_DOCUMENT", "SUPPLEMENTARY_DOCUMENT", "ZOOM_LIVENESS", "FACE_CAPTURE", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public enum FeatureTypeEntity {
    ID_DOCUMENT("com.yoti.mobile.android.documentcapture.id.IdDocumentCaptureLauncher", YotiSDKDocumentCaptureDependencyNotFoundError.class),
    SUPPLEMENTARY_DOCUMENT("com.yoti.mobile.android.documentcapture.sup.SupDocumentCaptureLauncher", YotiSDKSupplementaryDocumentCaptureDependencyNotFoundError.class),
    ZOOM_LIVENESS("com.yoti.mobile.android.liveness.zoom.LivenessZoomLauncher", YotiSDKZoomLivenessDependencyNotFoundError.class),
    FACE_CAPTURE("com.yoti.mobile.android.facecapture.FaceCaptureLauncher", YotiSDKFaceCaptureDependencyNotFoundError.class);

    private final String launcher;
    private final Class<? extends YotiSDKDependencyNotFoundError> notFoundException;

    FeatureTypeEntity(String str, Class cls) {
        this.launcher = str;
        this.notFoundException = cls;
    }

    public final String getLauncher() {
        return this.launcher;
    }

    public final Class<? extends YotiSDKDependencyNotFoundError> getNotFoundException() {
        return this.notFoundException;
    }

    public final void validate() {
        try {
            Class.forName(this.launcher).getConstructor(new Class[0]);
        } catch (ClassNotFoundException e) {
            Object objNewInstance = this.notFoundException.getConstructors()[0].newInstance(e);
            if (objNewInstance != null) {
                throw ((YotiSDKDependencyNotFoundError) objNewInstance);
            }
            throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.yotidocs.common.error.YotiSDKDependencyNotFoundError");
        }
    }
}
