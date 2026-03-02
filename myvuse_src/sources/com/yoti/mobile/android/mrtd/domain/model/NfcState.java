package com.yoti.mobile.android.mrtd.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/domain/model/NfcState;", "", "hasAdapter", "", "adapterEnabled", "(Ljava/lang/String;IZZ)V", "getAdapterEnabled", "()Z", "getHasAdapter", "NONE", "DISABLED", "ACTIVE", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public enum NfcState {
    NONE(false, false, 2, null),
    DISABLED(true, false),
    ACTIVE(true, true);

    private final boolean adapterEnabled;
    private final boolean hasAdapter;

    NfcState(boolean z, boolean z2) {
        this.hasAdapter = z;
        this.adapterEnabled = z2;
    }

    /* synthetic */ NfcState(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? false : z2);
    }

    public final boolean getAdapterEnabled() {
        return this.adapterEnabled;
    }

    public final boolean getHasAdapter() {
        return this.hasAdapter;
    }
}
