package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.salesforce.marketingcloud.config.C4143a;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcp implements ObjectEncoder<zzfa> {
    static final zzcp zza = new zzcp();

    private zzcp() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzfa zzfaVar = (zzfa) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("systemInfo", zzfaVar.zza());
        objectEncoderContext2.add(C4143a.f4653h, zzfaVar.zzb());
        objectEncoderContext2.add("isThickClient", (Object) null);
        objectEncoderContext2.add("modelDownloadLogEvent", (Object) null);
        objectEncoderContext2.add("customModelLoadLogEvent", (Object) null);
        objectEncoderContext2.add("customModelInferenceLogEvent", (Object) null);
        objectEncoderContext2.add("customModelCreateLogEvent", (Object) null);
        objectEncoderContext2.add("onDeviceFaceDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("onDeviceTextDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("onDeviceBarcodeDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("onDeviceImageLabelCreateLogEvent", (Object) null);
        objectEncoderContext2.add("onDeviceImageLabelLoadLogEvent", (Object) null);
        objectEncoderContext2.add("onDeviceImageLabelDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("onDeviceObjectCreateLogEvent", (Object) null);
        objectEncoderContext2.add("onDeviceObjectLoadLogEvent", (Object) null);
        objectEncoderContext2.add("onDeviceObjectInferenceLogEvent", (Object) null);
        objectEncoderContext2.add("onDevicePoseDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("onDeviceSegmentationLogEvent", (Object) null);
        objectEncoderContext2.add("onDeviceSmartReplyLogEvent", (Object) null);
        objectEncoderContext2.add("onDeviceLanguageIdentificationLogEvent", (Object) null);
        objectEncoderContext2.add("onDeviceTranslationLogEvent", (Object) null);
        objectEncoderContext2.add("cloudFaceDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("cloudCropHintDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("cloudDocumentTextDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("cloudImagePropertiesDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("cloudImageLabelDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("cloudLandmarkDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("cloudLogoDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("cloudSafeSearchDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("cloudTextDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("cloudWebSearchDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("automlImageLabelingCreateLogEvent", (Object) null);
        objectEncoderContext2.add("automlImageLabelingLoadLogEvent", (Object) null);
        objectEncoderContext2.add("automlImageLabelingInferenceLogEvent", (Object) null);
        objectEncoderContext2.add("isModelDownloadedLogEvent", (Object) null);
        objectEncoderContext2.add("deleteModelLogEvent", (Object) null);
        objectEncoderContext2.add("aggregatedAutomlImageLabelingInferenceLogEvent", (Object) null);
        objectEncoderContext2.add("aggregatedCustomModelInferenceLogEvent", (Object) null);
        objectEncoderContext2.add("aggregatedOnDeviceFaceDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("aggregatedOnDeviceBarcodeDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("aggregatedOnDeviceImageLabelDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("aggregatedOnDeviceObjectInferenceLogEvent", (Object) null);
        objectEncoderContext2.add("aggregatedOnDeviceTextDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("aggregatedOnDevicePoseDetectionLogEvent", (Object) null);
        objectEncoderContext2.add("aggregatedOnDeviceSegmentationLogEvent", (Object) null);
        objectEncoderContext2.add("remoteConfigLogEvent", (Object) null);
        objectEncoderContext2.add("inputImageConstructionLogEvent", zzfaVar.zzc());
        objectEncoderContext2.add("leakedHandleEvent", (Object) null);
    }
}
