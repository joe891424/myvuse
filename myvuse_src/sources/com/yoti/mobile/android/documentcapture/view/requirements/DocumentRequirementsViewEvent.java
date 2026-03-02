package com.yoti.mobile.android.documentcapture.view.requirements;

import com.yoti.mobile.android.documentcapture.view.DocumentViewEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewEvent;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$AbstractDocumentViewEvent;", "()V", "IncorrectDocument", "SeeScanningGuidelines", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewEvent$SeeScanningGuidelines;", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewEvent$IncorrectDocument;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class DocumentRequirementsViewEvent extends DocumentViewEvent.AbstractDocumentViewEvent {

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewEvent$IncorrectDocument;", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class IncorrectDocument extends DocumentRequirementsViewEvent {
        public static final IncorrectDocument INSTANCE = new IncorrectDocument();

        private IncorrectDocument() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewEvent$SeeScanningGuidelines;", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class SeeScanningGuidelines extends DocumentRequirementsViewEvent {
        public static final SeeScanningGuidelines INSTANCE = new SeeScanningGuidelines();

        private SeeScanningGuidelines() {
            super(null);
        }
    }

    private DocumentRequirementsViewEvent() {
    }

    public /* synthetic */ DocumentRequirementsViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
