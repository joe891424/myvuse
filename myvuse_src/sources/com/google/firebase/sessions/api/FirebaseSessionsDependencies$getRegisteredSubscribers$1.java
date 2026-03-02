package com.google.firebase.sessions.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: FirebaseSessionsDependencies.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m5599k = 3, m5600mv = {1, 8, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.google.firebase.sessions.api.FirebaseSessionsDependencies", m5608f = "FirebaseSessionsDependencies.kt", m5609i = {0, 0, 0}, m5610l = {124}, m5611m = "getRegisteredSubscribers$com_google_firebase_firebase_sessions", m5612n = {"destination$iv$iv", "subscriberName", "$this$withLock_u24default$iv"}, m5613s = {"L$0", "L$2", "L$3"})
final class FirebaseSessionsDependencies$getRegisteredSubscribers$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FirebaseSessionsDependencies this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FirebaseSessionsDependencies$getRegisteredSubscribers$1(FirebaseSessionsDependencies firebaseSessionsDependencies, Continuation<? super FirebaseSessionsDependencies$getRegisteredSubscribers$1> continuation) {
        super(continuation);
        this.this$0 = firebaseSessionsDependencies;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
    }
}
