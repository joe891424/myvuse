package com.yoti.mobile.android.mrtd.data;

import com.yoti.mobile.android.mrtd.domain.model.MrtdError;
import com.yoti.mobile.android.mrtd.domain.model.MrtdReadState;
import com.yoti.mobile.android.mrtd.domain.model.StateReadFailed;
import com.yoti.mobile.android.mrtd.domain.model.StateReadingComplete;
import com.yoti.mobile.android.mrtd.domain.model.StateReadingProgress;
import com.yoti.mobile.mpp.mrtddump.MrtdAuthException;
import com.yoti.mobile.mpp.mrtddump.MrtdCommunicationException;
import com.yoti.mobile.mpp.mrtddump.MrtdException;
import com.yoti.mobile.mpp.mrtddump.MrtdFileNotFoundException;
import com.yoti.mobile.mpp.mrtddump.MrtdReaderEvent;
import com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException;
import com.yoti.mobile.mpp.mrtddump.ReadComplete;
import com.yoti.mobile.mpp.mrtddump.ReadError;
import com.yoti.mobile.mpp.mrtddump.ReadProgressEvent;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0003J\u0019\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/data/NfcEventMapper;", "", "()V", "map", "Lcom/yoti/mobile/android/mrtd/domain/model/MrtdReadState;", "readEvent", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderEvent;", "mapError", "Lcom/yoti/mobile/android/mrtd/domain/model/MrtdError;", "error", "Lcom/yoti/mobile/mpp/mrtddump/MrtdException;", "mapSuspendable", "(Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NfcEventMapper {
    @Inject
    public NfcEventMapper() {
    }

    private final MrtdError mapError(MrtdException error) {
        return error instanceof MrtdAuthException ? MrtdError.BAD_AUTH : ((error instanceof MrtdFileNotFoundException) || (error instanceof MrtdUnexpectedDataFormatException)) ? MrtdError.INVALID_DATA : error instanceof MrtdCommunicationException ? MrtdError.CHIP_LOST : MrtdError.OTHER;
    }

    public final MrtdReadState map(MrtdReaderEvent readEvent) {
        Intrinsics.checkNotNullParameter(readEvent, "readEvent");
        if (readEvent instanceof ReadProgressEvent) {
            return new StateReadingProgress(((ReadProgressEvent) readEvent).getProgressPercentage());
        }
        if (readEvent instanceof ReadComplete) {
            return new StateReadingComplete(((ReadComplete) readEvent).getResult().getFilesById());
        }
        if (readEvent instanceof ReadError) {
            return new StateReadFailed(mapError(((ReadError) readEvent).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Object mapSuspendable(MrtdReaderEvent mrtdReaderEvent, Continuation<? super MrtdReadState> continuation) {
        return map(mrtdReaderEvent);
    }
}
