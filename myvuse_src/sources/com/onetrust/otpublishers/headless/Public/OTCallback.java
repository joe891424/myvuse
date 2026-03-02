package com.onetrust.otpublishers.headless.Public;

import com.onetrust.otpublishers.headless.Public.Response.OTResponse;

/* JADX INFO: loaded from: classes6.dex */
public interface OTCallback {
    void onFailure(OTResponse oTResponse);

    void onSuccess(OTResponse oTResponse);
}
