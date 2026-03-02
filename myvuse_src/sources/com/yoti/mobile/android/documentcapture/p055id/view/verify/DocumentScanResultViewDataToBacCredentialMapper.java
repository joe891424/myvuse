package com.yoti.mobile.android.documentcapture.p055id.view.verify;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultViewData;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.model.result.DateResult;
import com.yoti.mobile.android.documentscan.model.result.DocumentData;
import com.yoti.mobile.android.documentscan.model.result.Holder;
import com.yoti.mobile.android.mrtd.domain.model.BacCredential;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016JA\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000f\"\b\b\u0001\u0010\u000e*\u00020\u0010*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000f0\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u0001H\u000f\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\u0013H\u0002¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/verify/DocumentScanResultViewDataToBacCredentialMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;", "()V", "dateFormatter", "Ljava/text/SimpleDateFormat;", "formatDateToMrzStyle", "", "timestamp", "", "map", "from", "extractFirstNonNull", "R", ExifInterface.GPS_DIRECTION_TRUE, "", "", ViewProps.TRANSFORM, "Lkotlin/Function1;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentScanResultViewDataToBacCredentialMapper implements Mapper<DocumentScanResultViewData, BacCredential> {
    private final SimpleDateFormat dateFormatter;

    @Inject
    public DocumentScanResultViewDataToBacCredentialMapper() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.dateFormatter = simpleDateFormat;
    }

    private final <T, R> R extractFirstNonNull(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            R rInvoke = function1.invoke(it2.next());
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
        }
        return (R) CollectionsKt.first((List) arrayList);
    }

    private final String formatDateToMrzStyle(long timestamp) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"), Locale.ENGLISH);
        calendar.setTimeInMillis(timestamp * ((long) 1000));
        String str = this.dateFormatter.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(str, "dateFormatter.format(calendar.time)");
        return str;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public BacCredential map(DocumentScanResultViewData from) {
        Intrinsics.checkNotNullParameter(from, "from");
        String str = (String) extractFirstNonNull(from.getScanResults(), new Function1<DocumentCaptureResult, String>() { // from class: com.yoti.mobile.android.documentcapture.id.view.verify.DocumentScanResultViewDataToBacCredentialMapper.map.1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DocumentCaptureResult documentCaptureResult) {
                DocumentData documentData;
                if (documentCaptureResult == null || (documentData = documentCaptureResult.getDocumentData()) == null) {
                    return null;
                }
                return documentData.getDocumentNumber();
            }
        });
        Long timeStamp = ((DateResult) extractFirstNonNull(from.getScanResults(), new Function1<DocumentCaptureResult, DateResult>() { // from class: com.yoti.mobile.android.documentcapture.id.view.verify.DocumentScanResultViewDataToBacCredentialMapper.map.2
            @Override // kotlin.jvm.functions.Function1
            public final DateResult invoke(DocumentCaptureResult documentCaptureResult) {
                Holder holder;
                if (documentCaptureResult == null || (holder = documentCaptureResult.getHolder()) == null) {
                    return null;
                }
                return holder.getDateOfBirth();
            }
        })).getTimeStamp();
        Intrinsics.checkNotNull(timeStamp);
        String dateToMrzStyle = formatDateToMrzStyle(timeStamp.longValue());
        Long timeStamp2 = ((DateResult) extractFirstNonNull(from.getScanResults(), new Function1<DocumentCaptureResult, DateResult>() { // from class: com.yoti.mobile.android.documentcapture.id.view.verify.DocumentScanResultViewDataToBacCredentialMapper.map.3
            @Override // kotlin.jvm.functions.Function1
            public final DateResult invoke(DocumentCaptureResult documentCaptureResult) {
                DocumentData documentData;
                if (documentCaptureResult == null || (documentData = documentCaptureResult.getDocumentData()) == null) {
                    return null;
                }
                return documentData.getExpiryDate();
            }
        })).getTimeStamp();
        Intrinsics.checkNotNull(timeStamp2);
        return new BacCredential(str, dateToMrzStyle, formatDateToMrzStyle(timeStamp2.longValue()));
    }
}
