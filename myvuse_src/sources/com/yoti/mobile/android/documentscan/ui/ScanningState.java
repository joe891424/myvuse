package com.yoti.mobile.android.documentscan.ui;

import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.G, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\n\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\n\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/ScanningState;", "", "()V", "AutomaticCaptureTimeout", "CaptureComplete", "CapturingHologram", "DocumentDetected", "DocumentNotDetected", "DocumentResultNotProcessed", "ReviewBack", "ReviewFront", "ScanBack", "ScanFront", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState$DocumentDetected;", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState$DocumentNotDetected;", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState$DocumentResultNotProcessed;", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState$AutomaticCaptureTimeout;", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState$ScanFront;", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState$ScanBack;", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState$CapturingHologram;", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState$ReviewFront;", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState$ReviewBack;", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState$CaptureComplete;", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public abstract class ScanningState {

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.G$a */
    public static final class a extends ScanningState {

        /* JADX INFO: renamed from: a */
        private final int f6989a;

        public a(int i) {
            super(null);
            this.f6989a = i;
        }

        /* JADX INFO: renamed from: a */
        public final int m4896a() {
            return this.f6989a;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof a) && this.f6989a == ((a) obj).f6989a;
            }
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.f6989a);
        }

        public String toString() {
            return "AutomaticCaptureTimeout(pageNumber=" + this.f6989a + ")";
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.G$b */
    public static final class b extends ScanningState {

        /* JADX INFO: renamed from: a */
        private final DocumentCaptureResult f6990a;

        /* JADX INFO: renamed from: b */
        private final DocumentCaptureResult f6991b;

        public b(DocumentCaptureResult documentCaptureResult, DocumentCaptureResult documentCaptureResult2) {
            super(null);
            this.f6990a = documentCaptureResult;
            this.f6991b = documentCaptureResult2;
        }

        /* JADX INFO: renamed from: a */
        public final DocumentCaptureResult m4897a() {
            return this.f6991b;
        }

        /* JADX INFO: renamed from: b */
        public final DocumentCaptureResult m4898b() {
            return this.f6990a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.f6990a, bVar.f6990a) && Intrinsics.areEqual(this.f6991b, bVar.f6991b);
        }

        public int hashCode() {
            DocumentCaptureResult documentCaptureResult = this.f6990a;
            int iHashCode = (documentCaptureResult != null ? documentCaptureResult.hashCode() : 0) * 31;
            DocumentCaptureResult documentCaptureResult2 = this.f6991b;
            return iHashCode + (documentCaptureResult2 != null ? documentCaptureResult2.hashCode() : 0);
        }

        public String toString() {
            return "CaptureComplete(resultFront=" + this.f6990a + ", resultBack=" + this.f6991b + ")";
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.G$c */
    public static final class c extends ScanningState {

        /* JADX INFO: renamed from: a */
        public static final c f6992a = new c();

        private c() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.G$d */
    public static final class d extends ScanningState {

        /* JADX INFO: renamed from: a */
        public static final d f6993a = new d();

        private d() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.G$e */
    public static final class e extends ScanningState {

        /* JADX INFO: renamed from: a */
        public static final e f6994a = new e();

        private e() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.G$f */
    public static final class f extends ScanningState {

        /* JADX INFO: renamed from: a */
        private final DocumentCaptureException f6995a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(DocumentCaptureException error) {
            super(null);
            Intrinsics.checkParameterIsNotNull(error, "error");
            this.f6995a = error;
        }

        /* JADX INFO: renamed from: a */
        public final DocumentCaptureException m4899a() {
            return this.f6995a;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof f) && Intrinsics.areEqual(this.f6995a, ((f) obj).f6995a);
            }
            return true;
        }

        public int hashCode() {
            DocumentCaptureException documentCaptureException = this.f6995a;
            if (documentCaptureException != null) {
                return documentCaptureException.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "DocumentResultNotProcessed(error=" + this.f6995a + ")";
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.G$g */
    public static final class g extends ScanningState {

        /* JADX INFO: renamed from: a */
        private final DocumentCaptureResult f6996a;

        public g(DocumentCaptureResult documentCaptureResult) {
            super(null);
            this.f6996a = documentCaptureResult;
        }

        /* JADX INFO: renamed from: a */
        public final DocumentCaptureResult m4900a() {
            return this.f6996a;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof g) && Intrinsics.areEqual(this.f6996a, ((g) obj).f6996a);
            }
            return true;
        }

        public int hashCode() {
            DocumentCaptureResult documentCaptureResult = this.f6996a;
            if (documentCaptureResult != null) {
                return documentCaptureResult.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "ReviewBack(captureResult=" + this.f6996a + ")";
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.G$h */
    public static final class h extends ScanningState {

        /* JADX INFO: renamed from: a */
        private final DocumentCaptureResult f6997a;

        public h(DocumentCaptureResult documentCaptureResult) {
            super(null);
            this.f6997a = documentCaptureResult;
        }

        /* JADX INFO: renamed from: a */
        public final DocumentCaptureResult m4901a() {
            return this.f6997a;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof h) && Intrinsics.areEqual(this.f6997a, ((h) obj).f6997a);
            }
            return true;
        }

        public int hashCode() {
            DocumentCaptureResult documentCaptureResult = this.f6997a;
            if (documentCaptureResult != null) {
                return documentCaptureResult.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "ReviewFront(captureResult=" + this.f6997a + ")";
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.G$i */
    public static final class i extends ScanningState {

        /* JADX INFO: renamed from: a */
        private final boolean f6998a;

        public i(boolean z) {
            super(null);
            this.f6998a = z;
        }

        /* JADX INFO: renamed from: a */
        public final boolean m4902a() {
            return this.f6998a;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof i) && this.f6998a == ((i) obj).f6998a;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.f6998a;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "ScanBack(ocrSupported=" + this.f6998a + ")";
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.G$j */
    public static final class j extends ScanningState {

        /* JADX INFO: renamed from: a */
        private final boolean f6999a;

        public j(boolean z) {
            super(null);
            this.f6999a = z;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof j) && this.f6999a == ((j) obj).f6999a;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.f6999a;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "ScanFront(ocrSupported=" + this.f6999a + ")";
        }
    }

    private ScanningState() {
    }

    public /* synthetic */ ScanningState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
