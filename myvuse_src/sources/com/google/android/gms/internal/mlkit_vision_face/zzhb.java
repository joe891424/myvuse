package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzhb {
    NO_ERROR(0),
    INCOMPATIBLE_INPUT(1),
    INCOMPATIBLE_OUTPUT(2),
    INCOMPATIBLE_TFLITE_VERSION(3),
    MISSING_OP(4),
    DATA_TYPE_ERROR(6),
    TFLITE_INTERNAL_ERROR(7),
    TFLITE_UNKNOWN_ERROR(8),
    MEDIAPIPE_ERROR(9),
    TIME_OUT_FETCHING_MODEL_METADATA(5),
    MODEL_NOT_DOWNLOADED(100),
    URI_EXPIRED(101),
    NO_NETWORK_CONNECTION(102),
    METERED_NETWORK(103),
    DOWNLOAD_FAILED(104),
    MODEL_INFO_DOWNLOAD_UNSUCCESSFUL_HTTP_STATUS(105),
    MODEL_INFO_DOWNLOAD_NO_HASH(106),
    MODEL_INFO_DOWNLOAD_CONNECTION_FAILED(107),
    NO_VALID_MODEL(108),
    LOCAL_MODEL_INVALID(109),
    REMOTE_MODEL_INVALID(OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SHOW_BANNER_CALLED),
    REMOTE_MODEL_LOADER_ERROR(OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_NEW_GROUP_ADDED),
    REMOTE_MODEL_LOADER_LOADS_NO_MODEL(112),
    SMART_REPLY_LANG_ID_DETECTAION_FAILURE(113),
    MODEL_NOT_REGISTERED(114),
    MODEL_TYPE_MISUSE(ModuleDescriptor.MODULE_VERSION),
    MODEL_HASH_MISMATCH(116),
    UNKNOWN_ERROR(9999);

    zzhb(int i) {
    }
}
