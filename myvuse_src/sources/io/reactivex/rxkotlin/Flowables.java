package io.reactivex.rxkotlin;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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

/* JADX INFO: compiled from: Flowables.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u00050\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0004H\u0007Je\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\n0\fH\u0087\bJh\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e0\r0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0007J\u0083\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042 \b\u0004\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\n0\u0010H\u0087\bJ¡\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042&\b\u0004\u0010\u000b\u001a \u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\n0\u0013H\u0087\bJ¿\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042,\b\u0004\u0010\u000b\u001a&\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n0\u0016H\u0087\bJÝ\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000422\b\u0004\u0010\u000b\u001a,\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\n0\u0019H\u0087\bJû\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u000428\b\u0004\u0010\u000b\u001a2\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\n0\u001cH\u0087\bJ\u0099\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\u001d*\u00020\u0001\"\b\b\b\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00042>\b\u0004\u0010\u000b\u001a8\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\n0\u001fH\u0087\bJ·\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\u001d*\u00020\u0001\"\b\b\b\u0010 *\u00020\u0001\"\b\b\t\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u00042D\b\u0004\u0010\u000b\u001a>\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\n0\"H\u0087\bJ=\u0010#\u001a\b\u0012\u0004\u0012\u0002H$0\u0004\"\b\b\u0000\u0010$*\u00020\u00012\u0006\u0010%\u001a\u00020&2\u001a\b\u0004\u0010'\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H$0)\u0012\u0004\u0012\u00020*0(H\u0087\bJJ\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u00050\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0004H\u0007Je\u0010+\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\n0\fH\u0087\bJh\u0010+\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e0\r0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0007J\u0083\u0001\u0010+\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042 \b\u0004\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\n0\u0010H\u0087\bJ¡\u0001\u0010+\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042&\b\u0004\u0010\u000b\u001a \u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\n0\u0013H\u0087\bJ¿\u0001\u0010+\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042,\b\u0004\u0010\u000b\u001a&\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n0\u0016H\u0087\bJÝ\u0001\u0010+\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000422\b\u0004\u0010\u000b\u001a,\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\n0\u0019H\u0087\bJû\u0001\u0010+\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u000428\b\u0004\u0010\u000b\u001a2\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\n0\u001cH\u0087\bJ\u0099\u0002\u0010+\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\u001d*\u00020\u0001\"\b\b\b\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00042>\b\u0004\u0010\u000b\u001a8\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\n0\u001fH\u0087\bJ·\u0002\u0010+\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\u001d*\u00020\u0001\"\b\b\b\u0010 *\u00020\u0001\"\b\b\t\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u00042D\b\u0004\u0010\u000b\u001a>\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\n0\"H\u0087\b¨\u0006,"}, m5598d2 = {"Lio/reactivex/rxkotlin/Flowables;", "", "()V", "combineLatest", "Lio/reactivex/Flowable;", "Lkotlin/Pair;", "T1", "T2", "source1", "source2", "R", "combineFunction", "Lkotlin/Function2;", "Lkotlin/Triple;", "T3", "source3", "Lkotlin/Function3;", "T4", "source4", "Lkotlin/Function4;", "T5", "source5", "Lkotlin/Function5;", "T6", "source6", "Lkotlin/Function6;", "T7", "source7", "Lkotlin/Function7;", "T8", "source8", "Lkotlin/Function8;", "T9", "source9", "Lkotlin/Function9;", "create", ExifInterface.GPS_DIRECTION_TRUE, "mode", "Lio/reactivex/BackpressureStrategy;", "source", "Lkotlin/Function1;", "Lio/reactivex/FlowableEmitter;", "", HeaderParameterNames.ZIP, "rxkotlin"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class Flowables {
    public static final Flowables INSTANCE = new Flowables();

    private Flowables() {
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, R> Flowable<R> combineLatest(Flowable<T1> source1, Flowable<T2> source2, final Function2<? super T1, ? super T2, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Flowable<R> flowableCombineLatest = Flowable.combineLatest(source1, source2, new BiFunction<T1, T2, R>() { // from class: io.reactivex.rxkotlin.Flowables.combineLatest.1
            @Override // io.reactivex.functions.BiFunction
            public final R apply(T1 t1, T2 t2) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                return (R) combineFunction.invoke(t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableCombineLatest, "Flowable.combineLatest(s…ombineFunction(t1, t2) })");
        return flowableCombineLatest;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2> Flowable<Pair<T1, T2>> combineLatest(Flowable<T1> source1, Flowable<T2> source2) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Flowable<Pair<T1, T2>> flowableCombineLatest = Flowable.combineLatest(source1, source2, new BiFunction<T1, T2, Pair<? extends T1, ? extends T2>>() { // from class: io.reactivex.rxkotlin.Flowables.combineLatest.2
            @Override // io.reactivex.functions.BiFunction
            public final Pair<T1, T2> apply(T1 t1, T2 t2) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                return TuplesKt.m5605to(t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableCombineLatest, "Flowable.combineLatest(s…> { t1, t2 -> t1 to t2 })");
        return flowableCombineLatest;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, R> Flowable<R> combineLatest(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3, final Function3<? super T1, ? super T2, ? super T3, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Flowable<R> flowableCombineLatest = Flowable.combineLatest(source1, source2, source3, new io.reactivex.functions.Function3<T1, T2, T3, R>() { // from class: io.reactivex.rxkotlin.Flowables.combineLatest.3
            @Override // io.reactivex.functions.Function3
            public final R apply(T1 t1, T2 t2, T3 t3) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                return (R) combineFunction.invoke(t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableCombineLatest, "Flowable.combineLatest(s…neFunction(t1, t2, t3) })");
        return flowableCombineLatest;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3> Flowable<Triple<T1, T2, T3>> combineLatest(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Flowable<Triple<T1, T2, T3>> flowableCombineLatest = Flowable.combineLatest(source1, source2, source3, new io.reactivex.functions.Function3<T1, T2, T3, Triple<? extends T1, ? extends T2, ? extends T3>>() { // from class: io.reactivex.rxkotlin.Flowables.combineLatest.4
            @Override // io.reactivex.functions.Function3
            public final Triple<T1, T2, T3> apply(T1 t1, T2 t2, T3 t3) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                return new Triple<>(t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableCombineLatest, "Flowable.combineLatest(s… -> Triple(t1, t2, t3) })");
        return flowableCombineLatest;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Flowable<R> combineLatest(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3, Flowable<T4> source4, final Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Flowable<R> flowableCombineLatest = Flowable.combineLatest(source1, source2, source3, source4, new io.reactivex.functions.Function4<T1, T2, T3, T4, R>() { // from class: io.reactivex.rxkotlin.Flowables.combineLatest.5
            @Override // io.reactivex.functions.Function4
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                return (R) combineFunction.invoke(t1, t2, t3, t4);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableCombineLatest, "Flowable.combineLatest(s…nction(t1, t2, t3, t4) })");
        return flowableCombineLatest;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, R> Flowable<R> combineLatest(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3, Flowable<T4> source4, Flowable<T5> source5, final Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Flowable<R> flowableCombineLatest = Flowable.combineLatest(source1, source2, source3, source4, source5, new io.reactivex.functions.Function5<T1, T2, T3, T4, T5, R>() { // from class: io.reactivex.rxkotlin.Flowables.combineLatest.6
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
        Intrinsics.checkExpressionValueIsNotNull(flowableCombineLatest, "Flowable.combineLatest(s…on(t1, t2, t3, t4, t5) })");
        return flowableCombineLatest;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, R> Flowable<R> combineLatest(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3, Flowable<T4> source4, Flowable<T5> source5, Flowable<T6> source6, final Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(source6, "source6");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Flowable<R> flowableCombineLatest = Flowable.combineLatest(source1, source2, source3, source4, source5, source6, new io.reactivex.functions.Function6<T1, T2, T3, T4, T5, T6, R>() { // from class: io.reactivex.rxkotlin.Flowables.combineLatest.7
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
        Intrinsics.checkExpressionValueIsNotNull(flowableCombineLatest, "Flowable.combineLatest(s…1, t2, t3, t4, t5, t6) })");
        return flowableCombineLatest;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> combineLatest(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3, Flowable<T4> source4, Flowable<T5> source5, Flowable<T6> source6, Flowable<T7> source7, final Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(source6, "source6");
        Intrinsics.checkParameterIsNotNull(source7, "source7");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Flowable<R> flowableCombineLatest = Flowable.combineLatest(source1, source2, source3, source4, source5, source6, source7, new io.reactivex.functions.Function7<T1, T2, T3, T4, T5, T6, T7, R>() { // from class: io.reactivex.rxkotlin.Flowables.combineLatest.8
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
        Intrinsics.checkExpressionValueIsNotNull(flowableCombineLatest, "Flowable.combineLatest(s…2, t3, t4, t5, t6, t7) })");
        return flowableCombineLatest;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> combineLatest(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3, Flowable<T4> source4, Flowable<T5> source5, Flowable<T6> source6, Flowable<T7> source7, Flowable<T8> source8, final Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(source6, "source6");
        Intrinsics.checkParameterIsNotNull(source7, "source7");
        Intrinsics.checkParameterIsNotNull(source8, "source8");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Flowable<R> flowableCombineLatest = Flowable.combineLatest(source1, source2, source3, source4, source5, source6, source7, source8, new io.reactivex.functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>() { // from class: io.reactivex.rxkotlin.Flowables.combineLatest.9
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
        Intrinsics.checkExpressionValueIsNotNull(flowableCombineLatest, "Flowable.combineLatest(s…3, t4, t5, t6, t7, t8) })");
        return flowableCombineLatest;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> combineLatest(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3, Flowable<T4> source4, Flowable<T5> source5, Flowable<T6> source6, Flowable<T7> source7, Flowable<T8> source8, Flowable<T9> source9, final Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> combineFunction) {
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
        Flowable<R> flowableCombineLatest = Flowable.combineLatest(source1, source2, source3, source4, source5, source6, source7, source8, source9, new io.reactivex.functions.Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>() { // from class: io.reactivex.rxkotlin.Flowables.combineLatest.10
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
        Intrinsics.checkExpressionValueIsNotNull(flowableCombineLatest, "Flowable.combineLatest(s…4, t5, t6, t7, t8, t9) })");
        return flowableCombineLatest;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final <T> Flowable<T> create(BackpressureStrategy mode, final Function1<? super FlowableEmitter<T>, Unit> source) {
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        Intrinsics.checkParameterIsNotNull(source, "source");
        Flowable<T> flowableCreate = Flowable.create(new FlowableOnSubscribe<T>() { // from class: io.reactivex.rxkotlin.Flowables.create.1
            @Override // io.reactivex.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter<T> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                source.invoke(it2);
            }
        }, mode);
        Intrinsics.checkExpressionValueIsNotNull(flowableCreate, "Flowable.create({ source(it) }, mode)");
        return flowableCreate;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, R> Flowable<R> zip(Flowable<T1> source1, Flowable<T2> source2, final Function2<? super T1, ? super T2, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Flowable<R> flowableZip = Flowable.zip(source1, source2, new BiFunction<T1, T2, R>() { // from class: io.reactivex.rxkotlin.Flowables.zip.1
            @Override // io.reactivex.functions.BiFunction
            public final R apply(T1 t1, T2 t2) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                return (R) combineFunction.invoke(t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableZip, "Flowable.zip(source1, so…ombineFunction(t1, t2) })");
        return flowableZip;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2> Flowable<Pair<T1, T2>> zip(Flowable<T1> source1, Flowable<T2> source2) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Flowable<Pair<T1, T2>> flowableZip = Flowable.zip(source1, source2, new BiFunction<T1, T2, Pair<? extends T1, ? extends T2>>() { // from class: io.reactivex.rxkotlin.Flowables.zip.2
            @Override // io.reactivex.functions.BiFunction
            public final Pair<T1, T2> apply(T1 t1, T2 t2) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                return TuplesKt.m5605to(t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableZip, "Flowable.zip(source1, so…> { t1, t2 -> t1 to t2 })");
        return flowableZip;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, R> Flowable<R> zip(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3, final Function3<? super T1, ? super T2, ? super T3, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Flowable<R> flowableZip = Flowable.zip(source1, source2, source3, new io.reactivex.functions.Function3<T1, T2, T3, R>() { // from class: io.reactivex.rxkotlin.Flowables.zip.3
            @Override // io.reactivex.functions.Function3
            public final R apply(T1 t1, T2 t2, T3 t3) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                return (R) combineFunction.invoke(t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableZip, "Flowable.zip(source1, so…neFunction(t1, t2, t3) })");
        return flowableZip;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3> Flowable<Triple<T1, T2, T3>> zip(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Flowable<Triple<T1, T2, T3>> flowableZip = Flowable.zip(source1, source2, source3, new io.reactivex.functions.Function3<T1, T2, T3, Triple<? extends T1, ? extends T2, ? extends T3>>() { // from class: io.reactivex.rxkotlin.Flowables.zip.4
            @Override // io.reactivex.functions.Function3
            public final Triple<T1, T2, T3> apply(T1 t1, T2 t2, T3 t3) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                return new Triple<>(t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableZip, "Flowable.zip(source1, so… -> Triple(t1, t2, t3) })");
        return flowableZip;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Flowable<R> zip(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3, Flowable<T4> source4, final Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Flowable<R> flowableZip = Flowable.zip(source1, source2, source3, source4, new io.reactivex.functions.Function4<T1, T2, T3, T4, R>() { // from class: io.reactivex.rxkotlin.Flowables.zip.5
            @Override // io.reactivex.functions.Function4
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                return (R) combineFunction.invoke(t1, t2, t3, t4);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableZip, "Flowable.zip(source1, so…nction(t1, t2, t3, t4) })");
        return flowableZip;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, R> Flowable<R> zip(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3, Flowable<T4> source4, Flowable<T5> source5, final Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Flowable<R> flowableZip = Flowable.zip(source1, source2, source3, source4, source5, new io.reactivex.functions.Function5<T1, T2, T3, T4, T5, R>() { // from class: io.reactivex.rxkotlin.Flowables.zip.6
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
        Intrinsics.checkExpressionValueIsNotNull(flowableZip, "Flowable.zip(source1, so…on(t1, t2, t3, t4, t5) })");
        return flowableZip;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, R> Flowable<R> zip(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3, Flowable<T4> source4, Flowable<T5> source5, Flowable<T6> source6, final Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(source6, "source6");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Flowable<R> flowableZip = Flowable.zip(source1, source2, source3, source4, source5, source6, new io.reactivex.functions.Function6<T1, T2, T3, T4, T5, T6, R>() { // from class: io.reactivex.rxkotlin.Flowables.zip.7
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
        Intrinsics.checkExpressionValueIsNotNull(flowableZip, "Flowable.zip(source1, so…1, t2, t3, t4, t5, t6) })");
        return flowableZip;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> zip(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3, Flowable<T4> source4, Flowable<T5> source5, Flowable<T6> source6, Flowable<T7> source7, final Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(source6, "source6");
        Intrinsics.checkParameterIsNotNull(source7, "source7");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Flowable<R> flowableZip = Flowable.zip(source1, source2, source3, source4, source5, source6, source7, new io.reactivex.functions.Function7<T1, T2, T3, T4, T5, T6, T7, R>() { // from class: io.reactivex.rxkotlin.Flowables.zip.8
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
        Intrinsics.checkExpressionValueIsNotNull(flowableZip, "Flowable.zip(source1, so…2, t3, t4, t5, t6, t7) })");
        return flowableZip;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> zip(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3, Flowable<T4> source4, Flowable<T5> source5, Flowable<T6> source6, Flowable<T7> source7, Flowable<T8> source8, final Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(source1, "source1");
        Intrinsics.checkParameterIsNotNull(source2, "source2");
        Intrinsics.checkParameterIsNotNull(source3, "source3");
        Intrinsics.checkParameterIsNotNull(source4, "source4");
        Intrinsics.checkParameterIsNotNull(source5, "source5");
        Intrinsics.checkParameterIsNotNull(source6, "source6");
        Intrinsics.checkParameterIsNotNull(source7, "source7");
        Intrinsics.checkParameterIsNotNull(source8, "source8");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Flowable<R> flowableZip = Flowable.zip(source1, source2, source3, source4, source5, source6, source7, source8, new io.reactivex.functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>() { // from class: io.reactivex.rxkotlin.Flowables.zip.9
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
        Intrinsics.checkExpressionValueIsNotNull(flowableZip, "Flowable.zip(source1, so…3, t4, t5, t6, t7, t8) })");
        return flowableZip;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> zip(Flowable<T1> source1, Flowable<T2> source2, Flowable<T3> source3, Flowable<T4> source4, Flowable<T5> source5, Flowable<T6> source6, Flowable<T7> source7, Flowable<T8> source8, Flowable<T9> source9, final Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> combineFunction) {
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
        Flowable<R> flowableZip = Flowable.zip(source1, source2, source3, source4, source5, source6, source7, source8, source9, new io.reactivex.functions.Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>() { // from class: io.reactivex.rxkotlin.Flowables.zip.10
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
        Intrinsics.checkExpressionValueIsNotNull(flowableZip, "Flowable.zip(source1, so…4, t5, t6, t7, t8, t9) })");
        return flowableZip;
    }
}
