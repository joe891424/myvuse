package com.yoti.mobile.android.documentcapture.view;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect;", "", "()V", "HideCtaLoading", "ShowCtaLoading", "Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect$ShowCtaLoading;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect$HideCtaLoading;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class DocumentSideEffect {

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect$HideCtaLoading;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class HideCtaLoading extends DocumentSideEffect {
        public static final HideCtaLoading INSTANCE = new HideCtaLoading();

        private HideCtaLoading() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect$ShowCtaLoading;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class ShowCtaLoading extends DocumentSideEffect {
        public static final ShowCtaLoading INSTANCE = new ShowCtaLoading();

        private ShowCtaLoading() {
            super(null);
        }
    }

    private DocumentSideEffect() {
    }

    public /* synthetic */ DocumentSideEffect(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
