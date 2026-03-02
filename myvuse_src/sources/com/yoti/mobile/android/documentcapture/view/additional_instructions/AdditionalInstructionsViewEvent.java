package com.yoti.mobile.android.documentcapture.view.additional_instructions;

import com.yoti.mobile.android.documentcapture.view.DocumentViewEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsViewEvent;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$AbstractDocumentViewEvent;", "()V", "OnBackOrExit", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsViewEvent$OnBackOrExit;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class AdditionalInstructionsViewEvent extends DocumentViewEvent.AbstractDocumentViewEvent {

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsViewEvent$OnBackOrExit;", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsViewEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class OnBackOrExit extends AdditionalInstructionsViewEvent {
        public static final OnBackOrExit INSTANCE = new OnBackOrExit();

        private OnBackOrExit() {
            super(null);
        }
    }

    private AdditionalInstructionsViewEvent() {
    }

    public /* synthetic */ AdditionalInstructionsViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
