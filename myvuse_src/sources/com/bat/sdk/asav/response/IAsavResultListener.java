package com.bat.sdk.asav.response;

import com.bat.sdk.asav.core.AsavException;
import com.bat.sdk.ble.BatDevice;
import kotlin.Metadata;

/* JADX INFO: compiled from: IAsavResultListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001e\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, m5598d2 = {"Lcom/bat/sdk/asav/response/IAsavResultListener;", "", "onSuccess", "", "batDevice", "Lcom/bat/sdk/ble/BatDevice;", "onFailure", "exception", "Lcom/bat/sdk/asav/core/AsavException;", "onTimeout", "onAlreadyUnlocked", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface IAsavResultListener {
    void onAlreadyUnlocked();

    void onFailure(BatDevice batDevice, AsavException exception);

    void onSuccess(BatDevice batDevice);

    void onTimeout();

    /* JADX INFO: compiled from: IAsavResultListener.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class DefaultImpls {
        public static void onAlreadyUnlocked(IAsavResultListener iAsavResultListener) {
        }

        public static void onFailure(IAsavResultListener iAsavResultListener, BatDevice batDevice, AsavException asavException) {
        }

        public static void onSuccess(IAsavResultListener iAsavResultListener, BatDevice batDevice) {
        }

        public static void onTimeout(IAsavResultListener iAsavResultListener) {
        }

        public static /* synthetic */ void onFailure$default(IAsavResultListener iAsavResultListener, BatDevice batDevice, AsavException asavException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailure");
            }
            if ((i & 2) != 0) {
                asavException = null;
            }
            iAsavResultListener.onFailure(batDevice, asavException);
        }
    }
}
