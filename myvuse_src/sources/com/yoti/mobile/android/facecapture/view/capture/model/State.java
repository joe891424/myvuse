package com.yoti.mobile.android.facecapture.view.capture.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/State;", "", "()V", "Complete", "Created", "Initial", "Scanning", "WaitingForFlash", "WaitingForNextFrame", "WaitingForNextValidFrame", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State$Created;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State$Initial;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State$Scanning;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State$WaitingForNextValidFrame;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State$WaitingForNextFrame;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State$WaitingForFlash;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State$Complete;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class State {

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/State$Complete;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Complete extends State {
        public static final Complete INSTANCE = new Complete();

        private Complete() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/State$Created;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Created extends State {
        public static final Created INSTANCE = new Created();

        private Created() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/State$Initial;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State;", "readyToCapture", "", "(Z)V", "getReadyToCapture", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Initial extends State {
        private final boolean readyToCapture;

        public Initial(boolean z) {
            super(null);
            this.readyToCapture = z;
        }

        public static /* synthetic */ Initial copy$default(Initial initial, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = initial.readyToCapture;
            }
            return initial.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getReadyToCapture() {
            return this.readyToCapture;
        }

        public final Initial copy(boolean readyToCapture) {
            return new Initial(readyToCapture);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Initial) && this.readyToCapture == ((Initial) other).readyToCapture;
        }

        public final boolean getReadyToCapture() {
            return this.readyToCapture;
        }

        public int hashCode() {
            boolean z = this.readyToCapture;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "Initial(readyToCapture=" + this.readyToCapture + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/State$Scanning;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State;", "readyToCapture", "", "feedback", "Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedbackType;", "(ZLcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedbackType;)V", "getFeedback", "()Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedbackType;", "getReadyToCapture", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Scanning extends State {
        private final ScanFeedbackType feedback;
        private final boolean readyToCapture;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Scanning(boolean z, ScanFeedbackType feedback) {
            super(null);
            Intrinsics.checkNotNullParameter(feedback, "feedback");
            this.readyToCapture = z;
            this.feedback = feedback;
        }

        public static /* synthetic */ Scanning copy$default(Scanning scanning, boolean z, ScanFeedbackType scanFeedbackType, int i, Object obj) {
            if ((i & 1) != 0) {
                z = scanning.readyToCapture;
            }
            if ((i & 2) != 0) {
                scanFeedbackType = scanning.feedback;
            }
            return scanning.copy(z, scanFeedbackType);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getReadyToCapture() {
            return this.readyToCapture;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ScanFeedbackType getFeedback() {
            return this.feedback;
        }

        public final Scanning copy(boolean readyToCapture, ScanFeedbackType feedback) {
            Intrinsics.checkNotNullParameter(feedback, "feedback");
            return new Scanning(readyToCapture, feedback);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Scanning)) {
                return false;
            }
            Scanning scanning = (Scanning) other;
            return this.readyToCapture == scanning.readyToCapture && this.feedback == scanning.feedback;
        }

        public final ScanFeedbackType getFeedback() {
            return this.feedback;
        }

        public final boolean getReadyToCapture() {
            return this.readyToCapture;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z = this.readyToCapture;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return (r0 * 31) + this.feedback.hashCode();
        }

        public String toString() {
            return "Scanning(readyToCapture=" + this.readyToCapture + ", feedback=" + this.feedback + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/State$WaitingForFlash;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State;", "readyToCapture", "", "(Z)V", "getReadyToCapture", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class WaitingForFlash extends State {
        private final boolean readyToCapture;

        public WaitingForFlash(boolean z) {
            super(null);
            this.readyToCapture = z;
        }

        public static /* synthetic */ WaitingForFlash copy$default(WaitingForFlash waitingForFlash, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = waitingForFlash.readyToCapture;
            }
            return waitingForFlash.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getReadyToCapture() {
            return this.readyToCapture;
        }

        public final WaitingForFlash copy(boolean readyToCapture) {
            return new WaitingForFlash(readyToCapture);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WaitingForFlash) && this.readyToCapture == ((WaitingForFlash) other).readyToCapture;
        }

        public final boolean getReadyToCapture() {
            return this.readyToCapture;
        }

        public int hashCode() {
            boolean z = this.readyToCapture;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "WaitingForFlash(readyToCapture=" + this.readyToCapture + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/State$WaitingForNextFrame;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State;", "readyToCapture", "", "(Z)V", "getReadyToCapture", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class WaitingForNextFrame extends State {
        private final boolean readyToCapture;

        public WaitingForNextFrame(boolean z) {
            super(null);
            this.readyToCapture = z;
        }

        public static /* synthetic */ WaitingForNextFrame copy$default(WaitingForNextFrame waitingForNextFrame, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = waitingForNextFrame.readyToCapture;
            }
            return waitingForNextFrame.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getReadyToCapture() {
            return this.readyToCapture;
        }

        public final WaitingForNextFrame copy(boolean readyToCapture) {
            return new WaitingForNextFrame(readyToCapture);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WaitingForNextFrame) && this.readyToCapture == ((WaitingForNextFrame) other).readyToCapture;
        }

        public final boolean getReadyToCapture() {
            return this.readyToCapture;
        }

        public int hashCode() {
            boolean z = this.readyToCapture;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "WaitingForNextFrame(readyToCapture=" + this.readyToCapture + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/State$WaitingForNextValidFrame;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State;", "readyToCapture", "", "(Z)V", "getReadyToCapture", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class WaitingForNextValidFrame extends State {
        private final boolean readyToCapture;

        public WaitingForNextValidFrame(boolean z) {
            super(null);
            this.readyToCapture = z;
        }

        public static /* synthetic */ WaitingForNextValidFrame copy$default(WaitingForNextValidFrame waitingForNextValidFrame, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = waitingForNextValidFrame.readyToCapture;
            }
            return waitingForNextValidFrame.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getReadyToCapture() {
            return this.readyToCapture;
        }

        public final WaitingForNextValidFrame copy(boolean readyToCapture) {
            return new WaitingForNextValidFrame(readyToCapture);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WaitingForNextValidFrame) && this.readyToCapture == ((WaitingForNextValidFrame) other).readyToCapture;
        }

        public final boolean getReadyToCapture() {
            return this.readyToCapture;
        }

        public int hashCode() {
            boolean z = this.readyToCapture;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "WaitingForNextValidFrame(readyToCapture=" + this.readyToCapture + ')';
        }
    }

    private State() {
    }

    public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
