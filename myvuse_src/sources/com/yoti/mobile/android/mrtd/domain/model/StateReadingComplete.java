package com.yoti.mobile.android.mrtd.domain.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/domain/model/StateReadingComplete;", "Lcom/yoti/mobile/android/mrtd/domain/model/MrtdReadState;", "result", "", "", "", "Lcom/yoti/mobile/android/mrtd/ChipData;", "(Ljava/util/Map;)V", "getResult", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class StateReadingComplete extends MrtdReadState {
    private final Map<Integer, byte[]> result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateReadingComplete(Map<Integer, byte[]> result) {
        super(null);
        Intrinsics.checkNotNullParameter(result, "result");
        this.result = result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StateReadingComplete copy$default(StateReadingComplete stateReadingComplete, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = stateReadingComplete.result;
        }
        return stateReadingComplete.copy(map);
    }

    public final Map<Integer, byte[]> component1() {
        return this.result;
    }

    public final StateReadingComplete copy(Map<Integer, byte[]> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return new StateReadingComplete(result);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StateReadingComplete) && Intrinsics.areEqual(this.result, ((StateReadingComplete) other).result);
    }

    public final Map<Integer, byte[]> getResult() {
        return this.result;
    }

    public int hashCode() {
        return this.result.hashCode();
    }

    public String toString() {
        return "StateReadingComplete(result=" + this.result + ')';
    }
}
