package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: compiled from: Observables.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u00050\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0004H\u0007Je\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\n0\fH\u0087\bJh\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e0\r0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0007J\u0083\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042 \b\u0004\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\n0\u0010H\u0087\bJ¡\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042&\b\u0004\u0010\u000b\u001a \u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\n0\u0013H\u0087\bJ¿\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042,\b\u0004\u0010\u000b\u001a&\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n0\u0016H\u0087\bJÝ\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000422\b\u0004\u0010\u000b\u001a,\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\n0\u0019H\u0087\bJû\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u000428\b\u0004\u0010\u000b\u001a2\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\n0\u001cH\u0087\bJ\u0099\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\u001d*\u00020\u0001\"\b\b\b\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00042>\b\u0004\u0010\u000b\u001a8\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\n0\u001fH\u0087\bJ·\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\u001d*\u00020\u0001\"\b\b\b\u0010 *\u00020\u0001\"\b\b\t\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u00042D\b\u0004\u0010\u000b\u001a>\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\n0\"H\u0087\bJJ\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u00050\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0004H\u0007Je\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\n0\fH\u0087\bJh\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e0\r0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0007J\u0083\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042 \b\u0004\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\n0\u0010H\u0087\bJ¡\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042&\b\u0004\u0010\u000b\u001a \u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\n0\u0013H\u0087\bJ¿\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042,\b\u0004\u0010\u000b\u001a&\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n0\u0016H\u0087\bJÝ\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000422\b\u0004\u0010\u000b\u001a,\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\n0\u0019H\u0087\bJû\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u000428\b\u0004\u0010\u000b\u001a2\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\n0\u001cH\u0087\bJ\u0099\u0002\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\u001d*\u00020\u0001\"\b\b\b\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00042>\b\u0004\u0010\u000b\u001a8\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\n0\u001fH\u0087\bJ·\u0002\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\u001d*\u00020\u0001\"\b\b\b\u0010 *\u00020\u0001\"\b\b\t\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u00042D\b\u0004\u0010\u000b\u001a>\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\n0\"H\u0087\b¨\u0006$"}, m5598d2 = {"Lio/reactivex/rxkotlin/Observables;", "", "()V", "combineLatest", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "T1", "T2", "source1", "source2", "R", "combineFunction", "Lkotlin/Function2;", "Lkotlin/Triple;", "T3", "source3", "Lkotlin/Function3;", "T4", "source4", "Lkotlin/Function4;", "T5", "source5", "Lkotlin/Function5;", "T6", "source6", "Lkotlin/Function6;", "T7", "source7", "Lkotlin/Function7;", "T8", "source8", "Lkotlin/Function8;", "T9", "source9", "Lkotlin/Function9;", HeaderParameterNames.ZIP, "rxkotlin"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class Observables {
    public static final Observables INSTANCE = new Observables();

    private Observables() {
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, R> Observable<R> combineLatest(Observable<T1> source1, Observable<T2> source2, final Function2<? super T1, ? super T2, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableCombineLatest = Observable.combineLatest(source1, source2, new BiFunction<T1, T2, R>() { // from class: io.reactivex.rxkotlin.Observables.combineLatest.1
            @Override // io.reactivex.functions.BiFunction
            public final R apply(T1 t1, T2 t2) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                return (R) combineFunction.invoke(t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableCombineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        return observableCombineLatest;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2> Observable<Pair<T1, T2>> combineLatest(Observable<T1> source1, Observable<T2> source2) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Observable<Pair<T1, T2>> observableCombineLatest = Observable.combineLatest(source1, source2, new BiFunction<T1, T2, Pair<? extends T1, ? extends T2>>() { // from class: io.reactivex.rxkotlin.Observables.combineLatest.2
            @Override // io.reactivex.functions.BiFunction
            public final Pair<T1, T2> apply(T1 t1, T2 t2) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                return TuplesKt.m5605to(t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableCombineLatest, "Observable.combineLatest…> { t1, t2 -> t1 to t2 })");
        return observableCombineLatest;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, R> Observable<R> combineLatest(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3, final Function3<? super T1, ? super T2, ? super T3, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableCombineLatest = Observable.combineLatest(source1, source2, source3, new io.reactivex.functions.Function3<T1, T2, T3, R>() { // from class: io.reactivex.rxkotlin.Observables.combineLatest.3
            @Override // io.reactivex.functions.Function3
            public final R apply(T1 t1, T2 t2, T3 t3) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                return (R) combineFunction.invoke(t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableCombineLatest, "Observable.combineLatest…neFunction(t1, t2, t3) })");
        return observableCombineLatest;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3> Observable<Triple<T1, T2, T3>> combineLatest(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Observable<Triple<T1, T2, T3>> observableCombineLatest = Observable.combineLatest(source1, source2, source3, new io.reactivex.functions.Function3<T1, T2, T3, Triple<? extends T1, ? extends T2, ? extends T3>>() { // from class: io.reactivex.rxkotlin.Observables.combineLatest.4
            @Override // io.reactivex.functions.Function3
            public final Triple<T1, T2, T3> apply(T1 t1, T2 t2, T3 t3) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                return new Triple<>(t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableCombineLatest, "Observable.combineLatest… -> Triple(t1, t2, t3) })");
        return observableCombineLatest;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Observable<R> combineLatest(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3, Observable<T4> source4, final Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableCombineLatest = Observable.combineLatest(source1, source2, source3, source4, new io.reactivex.functions.Function4<T1, T2, T3, T4, R>() { // from class: io.reactivex.rxkotlin.Observables.combineLatest.5
            @Override // io.reactivex.functions.Function4
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                return (R) combineFunction.invoke(t1, t2, t3, t4);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableCombineLatest, "Observable.combineLatest…nction(t1, t2, t3, t4) })");
        return observableCombineLatest;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3, Observable<T4> source4, Observable<T5> source5, final Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableCombineLatest = Observable.combineLatest(source1, source2, source3, source4, source5, new io.reactivex.functions.Function5<T1, T2, T3, T4, T5, R>() { // from class: io.reactivex.rxkotlin.Observables.combineLatest.6
            @Override // io.reactivex.functions.Function5
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                return (R) combineFunction.invoke(t1, t2, t3, t4, t5);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableCombineLatest, "Observable.combineLatest…on(t1, t2, t3, t4, t5) })");
        return observableCombineLatest;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3, Observable<T4> source4, Observable<T5> source5, Observable<T6> source6, final Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(source6, "source6");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableCombineLatest = Observable.combineLatest(source1, source2, source3, source4, source5, source6, new io.reactivex.functions.Function6<T1, T2, T3, T4, T5, T6, R>() { // from class: io.reactivex.rxkotlin.Observables.combineLatest.7
            @Override // io.reactivex.functions.Function6
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t6, "t6");
                return (R) combineFunction.invoke(t1, t2, t3, t4, t5, t6);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableCombineLatest, "Observable.combineLatest…1, t2, t3, t4, t5, t6) })");
        return observableCombineLatest;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3, Observable<T4> source4, Observable<T5> source5, Observable<T6> source6, Observable<T7> source7, final Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(source6, "source6");
        Intrinsics.checkParameterIsNotNull(source7, "source7");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableCombineLatest = Observable.combineLatest(source1, source2, source3, source4, source5, source6, source7, new io.reactivex.functions.Function7<T1, T2, T3, T4, T5, T6, T7, R>() { // from class: io.reactivex.rxkotlin.Observables.combineLatest.8
            @Override // io.reactivex.functions.Function7
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t6, "t6");
                Intrinsics.checkParameterIsNotNull(t7, "t7");
                return (R) combineFunction.invoke(t1, t2, t3, t4, t5, t6, t7);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableCombineLatest, "Observable.combineLatest…2, t3, t4, t5, t6, t7) })");
        return observableCombineLatest;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3, Observable<T4> source4, Observable<T5> source5, Observable<T6> source6, Observable<T7> source7, Observable<T8> source8, final Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(source6, "source6");
        Intrinsics.checkParameterIsNotNull(source7, "source7");
        Intrinsics.checkParameterIsNotNull(source8, "source8");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableCombineLatest = Observable.combineLatest(source1, source2, source3, source4, source5, source6, source7, source8, new io.reactivex.functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>() { // from class: io.reactivex.rxkotlin.Observables.combineLatest.9
            @Override // io.reactivex.functions.Function8
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t6, "t6");
                Intrinsics.checkParameterIsNotNull(t7, "t7");
                Intrinsics.checkParameterIsNotNull(t8, "t8");
                return (R) combineFunction.invoke(t1, t2, t3, t4, t5, t6, t7, t8);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableCombineLatest, "Observable.combineLatest…3, t4, t5, t6, t7, t8) })");
        return observableCombineLatest;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3, Observable<T4> source4, Observable<T5> source5, Observable<T6> source6, Observable<T7> source7, Observable<T8> source8, Observable<T9> source9, final Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(source6, "source6");
        Intrinsics.checkParameterIsNotNull(source7, "source7");
        Intrinsics.checkParameterIsNotNull(source8, "source8");
        Intrinsics.checkParameterIsNotNull(source9, "source9");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableCombineLatest = Observable.combineLatest(source1, source2, source3, source4, source5, source6, source7, source8, source9, new io.reactivex.functions.Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>() { // from class: io.reactivex.rxkotlin.Observables.combineLatest.10
            @Override // io.reactivex.functions.Function9
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t6, "t6");
                Intrinsics.checkParameterIsNotNull(t7, "t7");
                Intrinsics.checkParameterIsNotNull(t8, "t8");
                Intrinsics.checkParameterIsNotNull(t9, "t9");
                return (R) combineFunction.invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableCombineLatest, "Observable.combineLatest…4, t5, t6, t7, t8, t9) })");
        return observableCombineLatest;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, R> Observable<R> zip(Observable<T1> source1, Observable<T2> source2, final Function2<? super T1, ? super T2, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableZip = Observable.zip(source1, source2, new BiFunction<T1, T2, R>() { // from class: io.reactivex.rxkotlin.Observables.zip.1
            @Override // io.reactivex.functions.BiFunction
            public final R apply(T1 t1, T2 t2) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                return (R) combineFunction.invoke(t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableZip, "Observable.zip(source1, …ombineFunction(t1, t2) })");
        return observableZip;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2> Observable<Pair<T1, T2>> zip(Observable<T1> source1, Observable<T2> source2) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Observable<Pair<T1, T2>> observableZip = Observable.zip(source1, source2, new BiFunction<T1, T2, Pair<? extends T1, ? extends T2>>() { // from class: io.reactivex.rxkotlin.Observables.zip.2
            @Override // io.reactivex.functions.BiFunction
            public final Pair<T1, T2> apply(T1 t1, T2 t2) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                return TuplesKt.m5605to(t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableZip, "Observable.zip(source1, …> { t1, t2 -> t1 to t2 })");
        return observableZip;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, R> Observable<R> zip(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3, final Function3<? super T1, ? super T2, ? super T3, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableZip = Observable.zip(source1, source2, source3, new io.reactivex.functions.Function3<T1, T2, T3, R>() { // from class: io.reactivex.rxkotlin.Observables.zip.3
            @Override // io.reactivex.functions.Function3
            public final R apply(T1 t1, T2 t2, T3 t3) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                return (R) combineFunction.invoke(t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableZip, "Observable.zip(source1, …neFunction(t1, t2, t3) })");
        return observableZip;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3> Observable<Triple<T1, T2, T3>> zip(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Observable<Triple<T1, T2, T3>> observableZip = Observable.zip(source1, source2, source3, new io.reactivex.functions.Function3<T1, T2, T3, Triple<? extends T1, ? extends T2, ? extends T3>>() { // from class: io.reactivex.rxkotlin.Observables.zip.4
            @Override // io.reactivex.functions.Function3
            public final Triple<T1, T2, T3> apply(T1 t1, T2 t2, T3 t3) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                return new Triple<>(t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableZip, "Observable.zip(source1, … -> Triple(t1, t2, t3) })");
        return observableZip;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Observable<R> zip(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3, Observable<T4> source4, final Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableZip = Observable.zip(source1, source2, source3, source4, new io.reactivex.functions.Function4<T1, T2, T3, T4, R>() { // from class: io.reactivex.rxkotlin.Observables.zip.5
            @Override // io.reactivex.functions.Function4
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                return (R) combineFunction.invoke(t1, t2, t3, t4);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableZip, "Observable.zip(source1, …nction(t1, t2, t3, t4) })");
        return observableZip;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, R> Observable<R> zip(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3, Observable<T4> source4, Observable<T5> source5, final Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableZip = Observable.zip(source1, source2, source3, source4, source5, new io.reactivex.functions.Function5<T1, T2, T3, T4, T5, R>() { // from class: io.reactivex.rxkotlin.Observables.zip.6
            @Override // io.reactivex.functions.Function5
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                return (R) combineFunction.invoke(t1, t2, t3, t4, t5);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableZip, "Observable.zip(source1, …on(t1, t2, t3, t4, t5) })");
        return observableZip;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3, Observable<T4> source4, Observable<T5> source5, Observable<T6> source6, final Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(source6, "source6");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableZip = Observable.zip(source1, source2, source3, source4, source5, source6, new io.reactivex.functions.Function6<T1, T2, T3, T4, T5, T6, R>() { // from class: io.reactivex.rxkotlin.Observables.zip.7
            @Override // io.reactivex.functions.Function6
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t6, "t6");
                return (R) combineFunction.invoke(t1, t2, t3, t4, t5, t6);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableZip, "Observable.zip(source1, …1, t2, t3, t4, t5, t6) })");
        return observableZip;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3, Observable<T4> source4, Observable<T5> source5, Observable<T6> source6, Observable<T7> source7, final Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(source6, "source6");
        Intrinsics.checkParameterIsNotNull(source7, "source7");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableZip = Observable.zip(source1, source2, source3, source4, source5, source6, source7, new io.reactivex.functions.Function7<T1, T2, T3, T4, T5, T6, T7, R>() { // from class: io.reactivex.rxkotlin.Observables.zip.8
            @Override // io.reactivex.functions.Function7
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t6, "t6");
                Intrinsics.checkParameterIsNotNull(t7, "t7");
                return (R) combineFunction.invoke(t1, t2, t3, t4, t5, t6, t7);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableZip, "Observable.zip(source1, …2, t3, t4, t5, t6, t7) })");
        return observableZip;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3, Observable<T4> source4, Observable<T5> source5, Observable<T6> source6, Observable<T7> source7, Observable<T8> source8, final Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(source6, "source6");
        Intrinsics.checkParameterIsNotNull(source7, "source7");
        Intrinsics.checkParameterIsNotNull(source8, "source8");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableZip = Observable.zip(source1, source2, source3, source4, source5, source6, source7, source8, new io.reactivex.functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>() { // from class: io.reactivex.rxkotlin.Observables.zip.9
            @Override // io.reactivex.functions.Function8
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t6, "t6");
                Intrinsics.checkParameterIsNotNull(t7, "t7");
                Intrinsics.checkParameterIsNotNull(t8, "t8");
                return (R) combineFunction.invoke(t1, t2, t3, t4, t5, t6, t7, t8);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableZip, "Observable.zip(source1, …3, t4, t5, t6, t7, t8) })");
        return observableZip;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(Observable<T1> source1, Observable<T2> source2, Observable<T3> source3, Observable<T4> source4, Observable<T5> source5, Observable<T6> source6, Observable<T7> source7, Observable<T8> source8, Observable<T9> source9, final Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(source6, "source6");
        Intrinsics.checkParameterIsNotNull(source7, "source7");
        Intrinsics.checkParameterIsNotNull(source8, "source8");
        Intrinsics.checkParameterIsNotNull(source9, "source9");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableZip = Observable.zip(source1, source2, source3, source4, source5, source6, source7, source8, source9, new io.reactivex.functions.Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>() { // from class: io.reactivex.rxkotlin.Observables.zip.10
            @Override // io.reactivex.functions.Function9
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t6, "t6");
                Intrinsics.checkParameterIsNotNull(t7, "t7");
                Intrinsics.checkParameterIsNotNull(t8, "t8");
                Intrinsics.checkParameterIsNotNull(t9, "t9");
                return (R) combineFunction.invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableZip, "Observable.zip(source1, …4, t5, t6, t7, t8, t9) })");
        return observableZip;
    }
}
