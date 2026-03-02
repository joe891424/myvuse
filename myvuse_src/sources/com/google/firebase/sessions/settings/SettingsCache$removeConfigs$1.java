package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: SettingsCache.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m5599k = 3, m5600mv = {1, 8, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.google.firebase.sessions.settings.SettingsCache", m5608f = "SettingsCache.kt", m5609i = {}, m5610l = {103}, m5611m = "removeConfigs$com_google_firebase_firebase_sessions", m5612n = {}, m5613s = {})
final class SettingsCache$removeConfigs$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SettingsCache$removeConfigs$1(SettingsCache settingsCache, Continuation<? super SettingsCache$removeConfigs$1> continuation) {
        super(continuation);
        this.this$0 = settingsCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeConfigs$com_google_firebase_firebase_sessions(this);
    }
}
