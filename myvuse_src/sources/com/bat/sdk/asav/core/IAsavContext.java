package com.bat.sdk.asav.core;

import com.bat.sdk.asav.response.IAsavResultListener;
import com.bat.sdk.ble.BatAdvertiser;
import com.bat.sdk.ble.BatScanner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetch;
import kotlin.Metadata;

/* JADX INFO: compiled from: IAsavContext.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\nH&¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/asav/core/IAsavContext;", "", "scanner", "Lcom/bat/sdk/ble/BatScanner;", "advertiser", "Lcom/bat/sdk/ble/BatAdvertiser;", "settings", "Lcom/bat/sdk/asav/core/AsavSettings;", "status", "Lcom/bat/sdk/asav/core/AsavStatus;", "", "timer", "Lcom/bat/sdk/asav/core/IAsavTimer;", "start", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bat/sdk/asav/response/IAsavResultListener;", BackgroundFetch.ACTION_STOP, "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface IAsavContext {
    BatAdvertiser advertiser();

    BatScanner scanner();

    AsavSettings settings();

    void start(IAsavResultListener listener);

    AsavStatus status();

    void status(AsavStatus status);

    void stop();

    IAsavTimer timer();
}
