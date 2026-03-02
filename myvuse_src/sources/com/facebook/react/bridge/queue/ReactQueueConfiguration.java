package com.facebook.react.bridge.queue;

/* JADX INFO: loaded from: classes3.dex */
public interface ReactQueueConfiguration {
    void destroy();

    MessageQueueThread getJSQueueThread();

    MessageQueueThread getNativeModulesQueueThread();

    MessageQueueThread getUIQueueThread();
}
