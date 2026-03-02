package com.salesforce.marketingcloud.internal;

import java.util.Locale;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.g */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractRunnableC4184g implements Runnable {

    /* JADX INFO: renamed from: a */
    public final String f4904a;

    public AbstractRunnableC4184g(String str, Object... objArr) {
        this.f4904a = "mcsdk_" + String.format(Locale.US, str, objArr);
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo2882a();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f4904a);
        try {
            mo2882a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
