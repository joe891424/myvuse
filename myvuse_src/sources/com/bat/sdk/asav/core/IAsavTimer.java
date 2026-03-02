package com.bat.sdk.asav.core;

import com.bat.sdk.asav.response.IAsavResultListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* JADX INFO: compiled from: IAsavTimer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/asav/core/IAsavTimer;", "", "attach", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bat/sdk/asav/response/IAsavResultListener;", "ping", "clear", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface IAsavTimer {
    void attach(IAsavResultListener listener);

    void clear();

    void ping();
}
