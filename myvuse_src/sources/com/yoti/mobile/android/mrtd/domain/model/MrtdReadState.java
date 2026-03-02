package com.yoti.mobile.android.mrtd.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\b\u0003\u0004\u0005\u0006\u0007\b\t\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/domain/model/MrtdReadState;", "", "()V", "Lcom/yoti/mobile/android/mrtd/domain/model/StateWaitingForChip;", "Lcom/yoti/mobile/android/mrtd/domain/model/StateChipFound;", "Lcom/yoti/mobile/android/mrtd/domain/model/StateReadingProgress;", "Lcom/yoti/mobile/android/mrtd/domain/model/StateReadingComplete;", "Lcom/yoti/mobile/android/mrtd/domain/model/StateReadFailed;", "Lcom/yoti/mobile/android/mrtd/domain/model/StateReadFailedFinal;", "Lcom/yoti/mobile/android/mrtd/domain/model/StateTimeout;", "Lcom/yoti/mobile/android/mrtd/domain/model/StateTimeoutFinal;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class MrtdReadState {
    private MrtdReadState() {
    }

    public /* synthetic */ MrtdReadState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
