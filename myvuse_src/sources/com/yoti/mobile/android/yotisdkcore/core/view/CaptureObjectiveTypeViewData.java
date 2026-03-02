package com.yoti.mobile.android.yotisdkcore.core.view;

import com.yoti.mobile.android.yotisdkcore.C4957R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/view/CaptureObjectiveTypeViewData;", "", "stepTrackerTitle", "", "stepTrackerMessageStepsCompleted", "stepTrackerMessage", "(Ljava/lang/String;IIII)V", "getStepTrackerMessage", "()I", "getStepTrackerMessageStepsCompleted", "getStepTrackerTitle", "PROOF_OF_IDENTITY", "PROOF_OF_ADDRESS", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public enum CaptureObjectiveTypeViewData {
    PROOF_OF_IDENTITY(C4957R.string.yds_verification_context_header, C4957R.string.yds_verification_context_multi_flow_completion_description, C4957R.string.f7520x4ecbb538),
    PROOF_OF_ADDRESS(C4957R.string.yds_verification_context_non_id_single_flow_header, C4957R.string.f7522x15bb3a39, C4957R.string.f7538xfae240eb);

    private final int stepTrackerMessage;
    private final int stepTrackerMessageStepsCompleted;
    private final int stepTrackerTitle;

    CaptureObjectiveTypeViewData(int i, int i2, int i3) {
        this.stepTrackerTitle = i;
        this.stepTrackerMessageStepsCompleted = i2;
        this.stepTrackerMessage = i3;
    }

    public final int getStepTrackerMessage() {
        return this.stepTrackerMessage;
    }

    public final int getStepTrackerMessageStepsCompleted() {
        return this.stepTrackerMessageStepsCompleted;
    }

    public final int getStepTrackerTitle() {
        return this.stepTrackerTitle;
    }
}
