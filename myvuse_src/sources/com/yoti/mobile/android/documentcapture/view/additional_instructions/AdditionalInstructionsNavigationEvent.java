package com.yoti.mobile.android.documentcapture.view.additional_instructions;

import com.yoti.mobile.android.documentcapture.view.DocumentNavigationEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsNavigationEvent;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$AbstractDocumentNavigationEvent;", "()V", "BackToSelection", "CloseSdk", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsNavigationEvent$BackToSelection;", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsNavigationEvent$CloseSdk;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class AdditionalInstructionsNavigationEvent extends DocumentNavigationEvent.AbstractDocumentNavigationEvent {

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsNavigationEvent$BackToSelection;", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsNavigationEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class BackToSelection extends AdditionalInstructionsNavigationEvent {
        public static final BackToSelection INSTANCE = new BackToSelection();

        private BackToSelection() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsNavigationEvent$CloseSdk;", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsNavigationEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class CloseSdk extends AdditionalInstructionsNavigationEvent {
        public static final CloseSdk INSTANCE = new CloseSdk();

        private CloseSdk() {
            super(null);
        }
    }

    private AdditionalInstructionsNavigationEvent() {
    }

    public /* synthetic */ AdditionalInstructionsNavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
