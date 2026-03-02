package com.yoti.mobile.android.liveness.zoom.view.capture;

import android.content.Context;
import android.util.Base64;
import com.facetec.sdk.FaceTecSessionResult;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.SinglesKt;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p099io.CloseableKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\"\u0010\b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f0\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0016\u0010\r\u001a\u00020\u0001*\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u001e\u0010\u000f\u001a\u00020\u0001*\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"FACEMAP_FILE_NAME", "", "FRAME_FILE_NAME", "faceMapFilePath", "Lio/reactivex/Single;", "Lcom/facetec/sdk/FaceTecSessionResult;", "context", "Landroid/content/Context;", "files", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecFiles;", "kotlin.jvm.PlatformType", "framesFilePath", "", "saveFaceMapToFile", "", "saveFrameToFile", "frameNumber", "", "liveness-zoom_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceTecSessionResultUtilsKt {
    private static final String FACEMAP_FILE_NAME = "facemap";
    private static final String FRAME_FILE_NAME = "frame_";

    private static final Single<String> faceMapFilePath(final FaceTecSessionResult faceTecSessionResult, final Context context) {
        Single<String> singleFromCallable = Single.fromCallable(new Callable() { // from class: com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecSessionResultUtilsKt$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FaceTecSessionResultUtilsKt.m6882faceMapFilePath$lambda2(faceTecSessionResult, context);
            }
        });
        Intrinsics.checkNotNullExpressionValue(singleFromCallable, "fromCallable {\n        r…eMapToFile(context)\n    }");
        return singleFromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: faceMapFilePath$lambda-2, reason: not valid java name */
    public static final String m6882faceMapFilePath$lambda2(FaceTecSessionResult this_faceMapFilePath, Context context) {
        Intrinsics.checkNotNullParameter(this_faceMapFilePath, "$this_faceMapFilePath");
        Intrinsics.checkNotNullParameter(context, "$context");
        return saveFaceMapToFile(this_faceMapFilePath.getFaceScan(), context);
    }

    public static final Single<FaceTecFiles> files(FaceTecSessionResult faceTecSessionResult, Context context) {
        Intrinsics.checkNotNullParameter(faceTecSessionResult, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Single<FaceTecFiles> singleOnErrorResumeNext = SinglesKt.zipWith(framesFilePath(faceTecSessionResult, context), faceMapFilePath(faceTecSessionResult, context)).map(new Function() { // from class: com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecSessionResultUtilsKt$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FaceTecSessionResultUtilsKt.m6883files$lambda0((Pair) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecSessionResultUtilsKt$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FaceTecSessionResultUtilsKt.m6884files$lambda1((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(singleOnErrorResumeNext, "this.framesFilePath(cont…ingle.error(it)\n        }");
        return singleOnErrorResumeNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: files$lambda-0, reason: not valid java name */
    public static final FaceTecFiles m6883files$lambda0(Pair it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        List list = (List) it2.getFirst();
        Object second = it2.getSecond();
        Intrinsics.checkNotNullExpressionValue(second, "it.second");
        return new FaceTecFiles(list, (String) second);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: files$lambda-1, reason: not valid java name */
    public static final SingleSource m6884files$lambda1(Throwable it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Single.error(it2);
    }

    private static final Single<List<String>> framesFilePath(final FaceTecSessionResult faceTecSessionResult, final Context context) {
        Single<List<String>> singleFromCallable = Single.fromCallable(new Callable() { // from class: com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecSessionResultUtilsKt$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FaceTecSessionResultUtilsKt.m6885framesFilePath$lambda4(faceTecSessionResult, context);
            }
        });
        Intrinsics.checkNotNullExpressionValue(singleFromCallable, "fromCallable {\n        v…mCallable frameList\n    }");
        return singleFromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: framesFilePath$lambda-4, reason: not valid java name */
    public static final List m6885framesFilePath$lambda4(FaceTecSessionResult this_framesFilePath, Context context) {
        Intrinsics.checkNotNullParameter(this_framesFilePath, "$this_framesFilePath");
        Intrinsics.checkNotNullParameter(context, "$context");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = FaceTecConstantsKt.getSELFIE_INDEXES().iterator();
        while (it2.hasNext()) {
            arrayList.add(saveFrameToFile(this_framesFilePath, context, ((Number) it2.next()).intValue()));
        }
        return arrayList;
    }

    private static final String saveFaceMapToFile(byte[] bArr, Context context) {
        if (bArr == null) {
            throw new IllegalArgumentException("facemap doesn't exist".toString());
        }
        File file = new File(context.getDir(FaceTecConstantsKt.TEMP_FILES_PATH, 0), FACEMAP_FILE_NAME);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            CloseableKt.closeFinally(bufferedOutputStream, null);
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            return absolutePath;
        } finally {
        }
    }

    private static final String saveFrameToFile(FaceTecSessionResult faceTecSessionResult, Context context, int i) {
        String[] auditTrailCompressedBase64;
        String str = (faceTecSessionResult == null || (auditTrailCompressedBase64 = faceTecSessionResult.getAuditTrailCompressedBase64()) == null) ? null : (String) ArraysKt.getOrNull(auditTrailCompressedBase64, i);
        if (str == null) {
            throw new IllegalArgumentException(("Cannot create frame " + i).toString());
        }
        File file = new File(context.getDir(FaceTecConstantsKt.TEMP_FILES_PATH, 0), FRAME_FILE_NAME + i + FaceTecConstantsKt.IMAGE_FILE_EXTENSION);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(Base64.decode(str, 0));
            fileOutputStream.flush();
            CloseableKt.closeFinally(fileOutputStream, null);
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            return absolutePath;
        } finally {
        }
    }
}
