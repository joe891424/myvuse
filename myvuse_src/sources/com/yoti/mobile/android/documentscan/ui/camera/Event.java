package com.yoti.mobile.android.documentscan.ui.camera;

import com.yoti.mobile.android.commons.image.ImageBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/camera/Event;", "", "()V", "OnManualCaptureClick", "OnPageReviewed", "OnReject", "ProcessFrame", "Lcom/yoti/mobile/android/documentscan/ui/camera/Event$OnManualCaptureClick;", "Lcom/yoti/mobile/android/documentscan/ui/camera/Event$OnPageReviewed;", "Lcom/yoti/mobile/android/documentscan/ui/camera/Event$OnReject;", "Lcom/yoti/mobile/android/documentscan/ui/camera/Event$ProcessFrame;", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public abstract class Event {

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.a$a */
    public static final class a extends Event {

        /* JADX INFO: renamed from: a */
        public static final a f7057a = new a();

        private a() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.a$b */
    public static final class b extends Event {

        /* JADX INFO: renamed from: a */
        public static final b f7058a = new b();

        private b() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.a$c */
    public static final class c extends Event {

        /* JADX INFO: renamed from: a */
        public static final c f7059a = new c();

        private c() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.a$d */
    public static final class d extends Event {

        /* JADX INFO: renamed from: a */
        private final ImageBuffer f7060a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ImageBuffer image) {
            super(null);
            Intrinsics.checkParameterIsNotNull(image, "image");
            this.f7060a = image;
        }

        /* JADX INFO: renamed from: a */
        public final ImageBuffer m4973a() {
            return this.f7060a;
        }
    }

    private Event() {
    }

    public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
