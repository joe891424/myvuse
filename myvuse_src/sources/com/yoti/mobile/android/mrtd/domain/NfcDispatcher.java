package com.yoti.mobile.android.mrtd.domain;

import android.app.Activity;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import com.yoti.mobile.android.mrtddump.p074io.AndroidNfcController;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/domain/NfcDispatcher;", "Lcom/yoti/mobile/android/mrtd/domain/INfcDispatcher;", "nfcAdapter", "Landroid/nfc/NfcAdapter;", "nfcTagProcessor", "Lcom/yoti/mobile/android/mrtd/domain/INfcTagProcessor;", "(Landroid/nfc/NfcAdapter;Lcom/yoti/mobile/android/mrtd/domain/INfcTagProcessor;)V", "disableDispatch", "", "activity", "Landroid/app/Activity;", "enableDispatch", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NfcDispatcher implements INfcDispatcher {
    private final NfcAdapter nfcAdapter;
    private final INfcTagProcessor nfcTagProcessor;

    /* JADX INFO: renamed from: com.yoti.mobile.android.mrtd.domain.NfcDispatcher$enableDispatch$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    /* synthetic */ class C49071 extends FunctionReferenceImpl implements Function1<Tag, Unit> {
        C49071(Object obj) {
            super(1, obj, INfcTagProcessor.class, "onTagDetected", "onTagDetected(Landroid/nfc/Tag;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tag tag) {
            invoke2(tag);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tag p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((INfcTagProcessor) this.receiver).onTagDetected(p0);
        }
    }

    @Inject
    public NfcDispatcher(NfcAdapter nfcAdapter, INfcTagProcessor nfcTagProcessor) {
        Intrinsics.checkNotNullParameter(nfcTagProcessor, "nfcTagProcessor");
        this.nfcAdapter = nfcAdapter;
        this.nfcTagProcessor = nfcTagProcessor;
    }

    @Override // com.yoti.mobile.android.mrtd.domain.INfcDispatcher
    public void disableDispatch(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AndroidNfcController.INSTANCE.disableDispatch(activity);
    }

    @Override // com.yoti.mobile.android.mrtd.domain.INfcDispatcher
    public void enableDispatch(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AndroidNfcController.Companion companion = AndroidNfcController.INSTANCE;
        NfcAdapter nfcAdapter = this.nfcAdapter;
        Intrinsics.checkNotNull(nfcAdapter);
        companion.enableDispatchWithCallback(activity, nfcAdapter, new C49071(this.nfcTagProcessor));
    }
}
