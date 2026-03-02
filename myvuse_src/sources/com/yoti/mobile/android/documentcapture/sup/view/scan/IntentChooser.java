package com.yoti.mobile.android.documentcapture.sup.view.scan;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/IntentChooser;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/ICaptureChooser;", "fileProvider", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentFileProvider;", "captureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "(Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentFileProvider;Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;)V", "createCameraIntent", "Landroid/content/Intent;", "outputFile", "Landroid/net/Uri;", "createFilePickerIntent", "showCameraAndFilePickerChooser", "activity", "Landroid/app/Activity;", "showChooser", "", "showFilePicker", "showNativeCamera", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IntentChooser implements ICaptureChooser {
    private final DocumentCaptureConfiguration captureConfiguration;
    private final SupDocumentFileProvider fileProvider;

    @Inject
    public IntentChooser(SupDocumentFileProvider fileProvider, DocumentCaptureConfiguration captureConfiguration) {
        Intrinsics.checkNotNullParameter(fileProvider, "fileProvider");
        Intrinsics.checkNotNullParameter(captureConfiguration, "captureConfiguration");
        this.fileProvider = fileProvider;
        this.captureConfiguration = captureConfiguration;
    }

    private final Intent createCameraIntent(Uri outputFile) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.setFlags(1);
        intent.putExtra("output", outputFile);
        return intent;
    }

    private final Intent createFilePickerIntent() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/pdf", "image/jpeg", "image/png"});
        return intent;
    }

    private final void showChooser(Activity activity, Uri outputFile) {
        Intent intentCreateChooser = Intent.createChooser(createFilePickerIntent(), null);
        Object[] array = CollectionsKt.listOf(createCameraIntent(outputFile)).toArray(new Intent[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) array);
        activity.startActivityForResult(intentCreateChooser, 2);
    }

    private final void showNativeCamera(Activity activity, Uri outputFile) throws Throwable {
        Object objM7233constructorimpl;
        try {
            activity.startActivityForResult(createCameraIntent(outputFile), 2);
            objM7233constructorimpl = Result.m7233constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            objM7233constructorimpl = Result.m7233constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7236exceptionOrNullimpl = Result.m7236exceptionOrNullimpl(objM7233constructorimpl);
        if (thM7236exceptionOrNullimpl != null && !(thM7236exceptionOrNullimpl instanceof ActivityNotFoundException)) {
            throw thM7236exceptionOrNullimpl;
        }
    }

    @Override // com.yoti.mobile.android.documentcapture.sup.view.scan.ICaptureChooser
    public Uri showCameraAndFilePickerChooser(Activity activity) throws Throwable {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Uri uriCreateFileUri = this.fileProvider.createFileUri(activity);
        if (this.captureConfiguration.getIsSupplementaryDocumentUploadAllowed()) {
            showChooser(activity, uriCreateFileUri);
        } else {
            showNativeCamera(activity, uriCreateFileUri);
        }
        return uriCreateFileUri;
    }

    @Override // com.yoti.mobile.android.documentcapture.sup.view.scan.ICaptureChooser
    public void showFilePicker(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.startActivityForResult(createFilePickerIntent(), 2);
    }
}
