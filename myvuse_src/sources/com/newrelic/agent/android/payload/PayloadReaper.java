package com.newrelic.agent.android.payload;

import com.newrelic.agent.android.payload.PayloadSender;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
class PayloadReaper implements Callable<PayloadSender> {
    final PayloadSender.CompletionHandler handler;
    final PayloadSender sender;

    public PayloadReaper(PayloadSender payloadSender, PayloadSender.CompletionHandler completionHandler) {
        if (payloadSender == null) {
            throw new NullPointerException("Must provide payload sender!");
        }
        this.sender = payloadSender;
        this.handler = completionHandler;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public PayloadSender call() throws Exception {
        try {
            PayloadSender payloadSenderCall = this.sender.call();
            PayloadSender.CompletionHandler completionHandler = this.handler;
            if (completionHandler != null) {
                completionHandler.onResponse(payloadSenderCall);
            }
            return payloadSenderCall;
        } catch (Exception e) {
            PayloadSender.CompletionHandler completionHandler2 = this.handler;
            if (completionHandler2 == null) {
                return null;
            }
            completionHandler2.onException(this.sender, e);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayloadReaper) {
            return this.sender.payload.equals(((PayloadReaper) obj).sender.payload);
        }
        return false;
    }

    public String getUuid() {
        return this.sender.getPayload().getUuid();
    }
}
