package io.ktor.utils.p098io;

import androidx.concurrent.futures.C0526xc40028dd;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.onetrust.otpublishers.headless.Public.OTCCPAGeolocationConstants;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.core.Buffer;
import io.ktor.utils.p098io.core.BufferPrimitivesJvmKt;
import io.ktor.utils.p098io.core.ByteOrder;
import io.ktor.utils.p098io.core.BytePacketBuilder;
import io.ktor.utils.p098io.core.ByteReadPacket;
import io.ktor.utils.p098io.core.ExperimentalIoApi;
import io.ktor.utils.p098io.core.IoBuffer;
import io.ktor.utils.p098io.core.OutputArraysJVMKt;
import io.ktor.utils.p098io.core.PacketJVMKt;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.UnsafeKt;
import io.ktor.utils.p098io.internal.CancellableReusableContinuation;
import io.ktor.utils.p098io.internal.ClosedElement;
import io.ktor.utils.p098io.internal.FailedLookAhead;
import io.ktor.utils.p098io.internal.JoiningState;
import io.ktor.utils.p098io.internal.ObjectPoolKt;
import io.ktor.utils.p098io.internal.ReadSessionImpl;
import io.ktor.utils.p098io.internal.ReadWriteBufferState;
import io.ktor.utils.p098io.internal.RingBufferCapacity;
import io.ktor.utils.p098io.internal.TerminatedLookAhead;
import io.ktor.utils.p098io.internal.WriteSessionImpl;
import io.ktor.utils.p098io.pool.ObjectPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;
import net.lingala.zip4j.util.InternalZipConstants;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: ByteBufferChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\bJ\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0010\u0018\u0000 \u008d\u00032\u00030\u008f\u00032\u00030\u0090\u00032\u00030\u0091\u00032\u00020n2\u00030\u0092\u00032\u00030\u0093\u0003:\u0002\u008d\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004B)\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0003\u0010\fJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u0013\u0010\u001b\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u0014H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001cJ\u0013\u0010\u001e\u001a\u00020\u0014H\u0097@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001cJ/\u0010\"\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H\u0082@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0011\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b%\u0010&J'\u0010*\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\nH\u0000¢\u0006\u0004\b(\u0010)J\u0019\u0010-\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u0019\u0010/\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b/\u0010.JK\u00105\u001a\u00020\u001426\u00104\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u000500H\u0087@ø\u0001\u0000¢\u0006\u0004\b5\u00106JP\u00107\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000526\u00104\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u000500H\u0082\b¢\u0006\u0004\b7\u00108JK\u00109\u001a\u00020\u001426\u00104\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u000500H\u0082@ø\u0001\u0000¢\u0006\u0004\b9\u00106J\u0017\u0010:\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b:\u0010;J-\u0010C\u001a\u00020=2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010>\u001a\u00020=2\b\u0010@\u001a\u0004\u0018\u00010?H\u0080@ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u000f\u0010G\u001a\u00020DH\u0000¢\u0006\u0004\bE\u0010FJ,\u0010J\u001a\u00020\u00142\u0017\u0010I\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bHH\u0082Hø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ4\u0010L\u001a\u00020\u00142\u0006\u0010@\u001a\u00020?2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bHH\u0082Hø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\u001b\u0010O\u001a\u00020=2\u0006\u0010N\u001a\u00020=H\u0096@ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ#\u0010R\u001a\u00020=2\u0006\u0010Q\u001a\u00020=2\u0006\u0010N\u001a\u00020=H\u0082@ø\u0001\u0000¢\u0006\u0004\bR\u0010SJA\u0010V\u001a\u00020\u00142\u0006\u0010T\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0017\u0010U\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bHH\u0082\b¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020\u0014H\u0016¢\u0006\u0004\bX\u0010YJ\u0017\u0010[\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\nH\u0016¢\u0006\u0004\b[\u0010;J\u0017\u0010\\\u001a\u00020\u00142\u0006\u0010@\u001a\u00020?H\u0002¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\u0014H\u0016¢\u0006\u0004\b^\u0010YJ\u0017\u0010`\u001a\u00020\u00142\u0006\u0010_\u001a\u00020\nH\u0002¢\u0006\u0004\b`\u0010;J\u0011\u0010c\u001a\u0004\u0018\u00010?H\u0000¢\u0006\u0004\ba\u0010bJ#\u0010g\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u00002\u0006\u0010d\u001a\u00020\u0005H\u0080@ø\u0001\u0000¢\u0006\u0004\be\u0010fJ+\u0010h\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u00002\u0006\u0010d\u001a\u00020\u00052\u0006\u0010@\u001a\u00020?H\u0082@ø\u0001\u0000¢\u0006\u0004\bh\u0010iJ.\u0010l\u001a\u00028\u0000\"\u0004\b\u0000\u0010j2\u0017\u00104\u001a\u0013\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00028\u00000 ¢\u0006\u0002\bHH\u0016¢\u0006\u0004\bl\u0010mJB\u0010q\u001a\u00028\u0000\"\u0004\b\u0000\u0010j2'\u00104\u001a#\b\u0001\u0012\u0004\u0012\u00020n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000o\u0012\u0006\u0012\u0004\u0018\u00010p00¢\u0006\u0002\bHH\u0096@ø\u0001\u0000¢\u0006\u0004\bq\u00106J\u000f\u0010r\u001a\u00020\bH\u0002¢\u0006\u0004\br\u0010sJ>\u0010z\u001a\u00020=2\u0006\u0010u\u001a\u00020t2\u0006\u0010v\u001a\u00020=2\u0006\u0010w\u001a\u00020=2\u0006\u0010\u001f\u001a\u00020=2\u0006\u0010N\u001a\u00020=H\u0096@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bx\u0010yJ\u001f\u0010~\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010{\u001a\u00020\nH\u0000¢\u0006\u0004\b|\u0010}J1\u0010\u0080\u0001\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010\u007f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H\u0096@ø\u0001\u0000¢\u0006\u0005\b\u0080\u0001\u0010#J0\u0010\u0083\u0001\u001a\u00020\n2\b\u0010\u0082\u0001\u001a\u00030\u0081\u00012\b\b\u0002\u0010:\u001a\u00020\n2\b\b\u0002\u0010N\u001a\u00020\nH\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001b\u0010\u0083\u0001\u001a\u00020\n2\u0007\u0010\u0082\u0001\u001a\u00020\u0001H\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0085\u0001J-\u0010\u0083\u0001\u001a\u00020\n2\b\u0010\u0082\u0001\u001a\u00030\u0086\u00012\u0006\u0010w\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0088\u0001J \u0010\u008a\u0001\u001a\u00020\n2\b\u0010\u0082\u0001\u001a\u00030\u0089\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u001f\u0010\u008a\u0001\u001a\u00020\n2\u0007\u0010\u0082\u0001\u001a\u00020\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u008c\u0001J1\u0010\u008a\u0001\u001a\u00020\n2\b\u0010\u0082\u0001\u001a\u00030\u0086\u00012\u0006\u0010w\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u008d\u0001J.\u0010\u008a\u0001\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H\u0016¢\u0006\u0006\b\u008a\u0001\u0010\u008e\u0001J \u0010\u008f\u0001\u001a\u00020\n2\b\u0010\u0082\u0001\u001a\u00030\u0089\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u008b\u0001J\u001f\u0010\u008f\u0001\u001a\u00020\n2\u0007\u0010\u0082\u0001\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u008c\u0001J1\u0010\u008f\u0001\u001a\u00020\n2\b\u0010\u0082\u0001\u001a\u00030\u0086\u00012\u0006\u0010w\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u008d\u0001J1\u0010\u0090\u0001\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H\u0082@ø\u0001\u0000¢\u0006\u0005\b\u0090\u0001\u0010#J\u0015\u0010\u0091\u0001\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0091\u0001\u0010\u001cJ\u0016\u0010\u0093\u0001\u001a\u00030\u0092\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0093\u0001\u0010\u001cJ\u0016\u0010\u0095\u0001\u001a\u00030\u0094\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0095\u0001\u0010\u001cJ\u0016\u0010\u0097\u0001\u001a\u00030\u0096\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0097\u0001\u0010\u001cJ(\u0010\u0098\u0001\u001a\u00020\u00142\b\u0010\u0082\u0001\u001a\u00030\u0089\u00012\u0006\u0010\u0017\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u001f\u0010\u0098\u0001\u001a\u00020\n2\u0007\u0010\u0082\u0001\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0006\b\u0098\u0001\u0010\u008c\u0001J1\u0010\u0098\u0001\u001a\u00020\u00142\b\u0010\u0082\u0001\u001a\u00030\u0086\u00012\u0006\u0010w\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0006\b\u0098\u0001\u0010\u008d\u0001J(\u0010\u009a\u0001\u001a\u00020\u00142\b\u0010\u0082\u0001\u001a\u00030\u0089\u00012\u0006\u0010\u0017\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u0099\u0001J(\u0010\u009a\u0001\u001a\u00020\n2\u0007\u0010\u0082\u0001\u001a\u00020\u00012\u0007\u0010\u009b\u0001\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u009c\u0001J1\u0010\u009a\u0001\u001a\u00020\u00142\b\u0010\u0082\u0001\u001a\u00030\u0086\u00012\u0006\u0010w\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u008d\u0001J\u0015\u0010\u009d\u0001\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u009d\u0001\u0010\u001cJ\u0015\u0010\u009e\u0001\u001a\u00020=H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u009e\u0001\u0010\u001cJ(\u0010¡\u0001\u001a\u00030 \u00012\u0006\u0010T\u001a\u00020\n2\u0007\u0010\u009f\u0001\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0006\b¡\u0001\u0010¢\u0001J1\u0010¥\u0001\u001a\u00030 \u00012\u0006\u0010T\u001a\u00020\n2\b\u0010¤\u0001\u001a\u00030£\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\b¥\u0001\u0010¦\u0001JC\u0010ª\u0001\u001a\u00028\u0000\"\n\b\u0000\u0010¨\u0001*\u00030§\u00012\u0006\u0010T\u001a\u00020\n2\u0018\u0010©\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000 ¢\u0006\u0002\bHH\u0082Hø\u0001\u0000¢\u0006\u0005\bª\u0001\u0010#J(\u0010«\u0001\u001a\u00030 \u00012\u0006\u0010>\u001a\u00020=2\u0007\u0010\u009f\u0001\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0006\b«\u0001\u0010¬\u0001J(\u0010\u00ad\u0001\u001a\u00030 \u00012\u0006\u0010>\u001a\u00020=2\u0007\u0010\u009f\u0001\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\b\u00ad\u0001\u0010¬\u0001J,\u0010¯\u0001\u001a\u00020\u00142\u0018\u0010\u007f\u001a\u0014\u0012\u0005\u0012\u00030®\u0001\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bHH\u0017¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u0016\u0010²\u0001\u001a\u00030±\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b²\u0001\u0010\u001cJ\u001d\u0010³\u0001\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0005\b³\u0001\u0010\u0019J\u001d\u0010´\u0001\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0005\b´\u0001\u0010\u0019J\u001d\u0010µ\u0001\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0005\bµ\u0001\u0010\u0019J\u001b\u0010¶\u0001\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\nH\u0082\b¢\u0006\u0006\b¶\u0001\u0010·\u0001J?\u0010¹\u0001\u001a\u00020\u00142(\u0010\u007f\u001a$\b\u0001\u0012\u0005\u0012\u00030¸\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140o\u0012\u0006\u0012\u0004\u0018\u00010p00¢\u0006\u0002\bHH\u0097@ø\u0001\u0000¢\u0006\u0005\b¹\u0001\u00106J \u0010»\u0001\u001a\u0005\u0018\u00010º\u00012\u0006\u0010>\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0005\b»\u0001\u0010\u0019J8\u0010À\u0001\u001a\u00020\u0005\"\u000f\b\u0000\u0010¾\u0001*\b0¼\u0001j\u0003`½\u00012\u0007\u0010¿\u0001\u001a\u00028\u00002\u0006\u0010>\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J-\u0010Â\u0001\u001a\u00020\u00052\r\u0010¿\u0001\u001a\b0¼\u0001j\u0003`½\u00012\u0006\u0010>\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\bÂ\u0001\u0010Á\u0001JJ\u0010È\u0001\u001a\u00020\u00052\r\u0010¿\u0001\u001a\b0¼\u0001j\u0003`½\u00012\u0006\u0010>\u001a\u00020\n2\b\u0010Ä\u0001\u001a\u00030Ã\u00012\b\u0010Æ\u0001\u001a\u00030Å\u00012\u0007\u0010Ç\u0001\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\bÈ\u0001\u0010É\u0001J2\u0010Ê\u0001\u001a\u00020\u00052\u001d\u0010!\u001a\u0019\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000500¢\u0006\u0002\bHH\u0082\b¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J\u001a\u0010Ì\u0001\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J$\u0010Î\u0001\u001a\u00030 \u00012\u0006\u0010>\u001a\u00020=2\u0007\u0010\u009f\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\bÎ\u0001\u0010Ï\u0001J&\u0010Ò\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010Ð\u0001\u001a\u00020\n2\u0007\u0010Ñ\u0001\u001a\u00020\nH\u0016¢\u0006\u0006\bÒ\u0001\u0010Ó\u0001J\u0012\u0010Ö\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J&\u0010Ù\u0001\u001a\u0004\u0018\u00010\u00002\u0007\u0010×\u0001\u001a\u00020\u00002\u0007\u0010Ø\u0001\u001a\u00020?H\u0002¢\u0006\u0006\bÙ\u0001\u0010Ú\u0001J\u0011\u0010Û\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0005\bÛ\u0001\u0010YJ\u0011\u0010Ý\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0005\bÜ\u0001\u0010YJ\u001c\u0010Þ\u0001\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0006\bÞ\u0001\u0010ß\u0001J\u0011\u0010à\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0005\bà\u0001\u0010YJ#\u0010à\u0001\u001a\u00020\u00142\u000e\u0010â\u0001\u001a\t\u0012\u0004\u0012\u00020+0á\u0001H\u0082\b¢\u0006\u0006\bà\u0001\u0010ã\u0001J\u0011\u0010ä\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0005\bä\u0001\u0010YJ#\u0010æ\u0001\u001a\u00020?2\u0007\u0010å\u0001\u001a\u00020\u00002\u0006\u0010d\u001a\u00020\u0005H\u0002¢\u0006\u0006\bæ\u0001\u0010ç\u0001J\u0014\u0010è\u0001\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0006\bè\u0001\u0010é\u0001J\u0014\u0010ë\u0001\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0006\bê\u0001\u0010é\u0001J\u0012\u0010ì\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0006\bì\u0001\u0010í\u0001J\u0013\u0010î\u0001\u001a\u00030¸\u0001H\u0016¢\u0006\u0006\bî\u0001\u0010ï\u0001J(\u0010ñ\u0001\u001a\u00020p2\u0006\u0010T\u001a\u00020\n2\r\u0010ð\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050oH\u0002¢\u0006\u0005\bñ\u0001\u0010\u0019J\u0013\u0010ò\u0001\u001a\u00030º\u0001H\u0016¢\u0006\u0006\bò\u0001\u0010ó\u0001J\u001a\u0010ô\u0001\u001a\u00020\u00052\u0006\u0010@\u001a\u00020?H\u0002¢\u0006\u0006\bô\u0001\u0010õ\u0001J\u001b\u0010÷\u0001\u001a\u00020\u00052\u0007\u0010ö\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0006\b÷\u0001\u0010ø\u0001J\u0012\u0010ú\u0001\u001a\u00020\u0005H\u0000¢\u0006\u0006\bù\u0001\u0010í\u0001J\u001c\u0010ü\u0001\u001a\u00020\n2\b\u0010û\u0001\u001a\u00030 \u0001H\u0002¢\u0006\u0006\bü\u0001\u0010ý\u0001J\u001d\u0010ÿ\u0001\u001a\u00020\u00142\u0006\u0010T\u001a\u00020\nH\u0080@ø\u0001\u0000¢\u0006\u0005\bþ\u0001\u0010\u0019J1\u0010\u0080\u0002\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H\u0096@ø\u0001\u0000¢\u0006\u0005\b\u0080\u0002\u0010#J\u001b\u0010\u0081\u0002\u001a\u00020\n2\u0007\u0010<\u001a\u00030\u0081\u0001H\u0002¢\u0006\u0006\b\u0081\u0002\u0010\u0082\u0002J\u001a\u0010\u0081\u0002\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u0001H\u0002¢\u0006\u0006\b\u0081\u0002\u0010\u0085\u0001J,\u0010\u0081\u0002\u001a\u00020\n2\u0007\u0010<\u001a\u00030\u0086\u00012\u0006\u0010w\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\b\u0081\u0002\u0010\u0088\u0001J\u001f\u0010\u0083\u0002\u001a\u00020\n2\u0007\u0010<\u001a\u00030\u0089\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0083\u0002\u0010\u008b\u0001J\u001e\u0010\u0083\u0002\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0083\u0002\u0010\u008c\u0001J0\u0010\u0083\u0002\u001a\u00020\n2\u0007\u0010<\u001a\u00030\u0086\u00012\u0006\u0010w\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0083\u0002\u0010\u008d\u0001J.\u0010\u0083\u0002\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H\u0016¢\u0006\u0006\b\u0083\u0002\u0010\u008e\u0001J\u001f\u0010\u0084\u0002\u001a\u00020\n2\u0007\u0010<\u001a\u00030\u0089\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\b\u0084\u0002\u0010\u008b\u0001J\u001e\u0010\u0084\u0002\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\b\u0084\u0002\u0010\u008c\u0001J \u0010\u0086\u0002\u001a\u00020\u00142\b\u0010\u0085\u0002\u001a\u00030\u0092\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0086\u0002\u0010\u0087\u0002J \u0010\u0089\u0002\u001a\u00020\u00142\b\u0010\u0088\u0002\u001a\u00030\u0094\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0089\u0002\u0010\u008a\u0002J \u0010\u008c\u0002\u001a\u00020\u00142\b\u0010\u008b\u0002\u001a\u00030\u0096\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u008c\u0002\u0010\u008d\u0002J4\u0010\u0093\u0002\u001a\u00020\u00142\u0007\u0010\u008e\u0002\u001a\u00020t2\u0007\u0010\u008f\u0002\u001a\u00020\n2\u0007\u0010\u0090\u0002\u001a\u00020\nH\u0096@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0006\b\u0091\u0002\u0010\u0092\u0002J\u001f\u0010\u0093\u0002\u001a\u00020\u00142\u0007\u0010<\u001a\u00030\u0081\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0093\u0002\u0010\u0094\u0002J\u001f\u0010\u0093\u0002\u001a\u00020\u00142\u0007\u0010<\u001a\u00030\u0089\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0093\u0002\u0010\u008b\u0001J\u001e\u0010\u0093\u0002\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0093\u0002\u0010\u008c\u0001J0\u0010\u0093\u0002\u001a\u00020\u00142\u0007\u0010<\u001a\u00030\u0086\u00012\u0006\u0010w\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0093\u0002\u0010\u008d\u0001J\u001f\u0010\u0095\u0002\u001a\u00020\u00142\u0007\u0010<\u001a\u00030\u0089\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\b\u0095\u0002\u0010\u008b\u0001J\u001e\u0010\u0095\u0002\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\b\u0095\u0002\u0010\u008c\u0001J0\u0010\u0095\u0002\u001a\u00020\u00142\u0007\u0010<\u001a\u00030\u0086\u00012\u0006\u0010w\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\b\u0095\u0002\u0010\u008d\u0001J\u001e\u0010\u0097\u0002\u001a\u00020\u00142\u0007\u0010\u0096\u0002\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0005\b\u0097\u0002\u0010\u0019J\u001e\u0010\u0099\u0002\u001a\u00020\u00142\u0007\u0010\u0098\u0002\u001a\u00020=H\u0096@ø\u0001\u0000¢\u0006\u0005\b\u0099\u0002\u0010PJ \u0010\u009a\u0002\u001a\u00020\u00142\b\u0010û\u0001\u001a\u00030 \u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u009a\u0002\u0010\u009b\u0002J \u0010\u009c\u0002\u001a\u00020\u00142\b\u0010û\u0001\u001a\u00030 \u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\b\u009c\u0002\u0010\u009b\u0002JQ\u0010\u009e\u0002\u001a\u00020\u00142\u0006\u0010T\u001a\u00020\n2\u0017\u0010I\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bH2\u0018\u0010\u009d\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bHH\u0082Hø\u0001\u0000¢\u0006\u0006\b\u009e\u0002\u0010\u009f\u0002J \u0010¡\u0002\u001a\u00020\u00142\b\u0010 \u0002\u001a\u00030±\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b¡\u0002\u0010¢\u0002J0\u0010£\u0002\u001a\u00020\n2\u0007\u0010<\u001a\u00030\u0086\u00012\u0006\u0010w\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\b£\u0002\u0010\u008d\u0001J\u001d\u0010£\u0002\u001a\u00020\u00142\u0006\u0010T\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0005\b£\u0002\u0010\u0019J\u001a\u0010¤\u0002\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\nH\u0002¢\u0006\u0006\b¤\u0002\u0010·\u0001J>\u0010¥\u0002\u001a\u00020\u00142'\u00104\u001a#\b\u0001\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140o\u0012\u0006\u0012\u0004\u0018\u00010p00¢\u0006\u0002\bHH\u0097@ø\u0001\u0000¢\u0006\u0005\b¥\u0002\u00106J)\u0010¦\u0002\u001a\u00020\u00142\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050 H\u0096@ø\u0001\u0000¢\u0006\u0005\b¦\u0002\u0010KJ7\u0010§\u0002\u001a\u00020\u00052\u0007\u0010\u0082\u0001\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050 H\u0002¢\u0006\u0006\b§\u0002\u0010¨\u0002J&\u0010©\u0002\u001a\u00020\u00052\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050 H\u0002¢\u0006\u0006\b©\u0002\u0010ª\u0002J)\u0010«\u0002\u001a\u00020\u00142\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050 H\u0082@ø\u0001\u0000¢\u0006\u0005\b«\u0002\u0010KJ9\u0010\u00ad\u0002\u001a\u00020\u00142$\u0010!\u001a \u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00140¬\u0002¢\u0006\u0002\bHH\u0082\b¢\u0006\u0006\b\u00ad\u0002\u0010®\u0002J%\u0010¯\u0002\u001a\u00020\u0014*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\nH\u0002¢\u0006\u0005\b¯\u0002\u0010)J%\u0010°\u0002\u001a\u00020\u0014*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\nH\u0002¢\u0006\u0005\b°\u0002\u0010)J\u0015\u0010±\u0002\u001a\u00020\u0014*\u00020\u0001H\u0002¢\u0006\u0005\b±\u0002\u0010\u0004J\u001f\u0010³\u0002\u001a\u00020\n*\u00020\u00012\u0007\u0010²\u0002\u001a\u00020\nH\u0002¢\u0006\u0006\b³\u0002\u0010´\u0002J2\u0010¹\u0002\u001a\u00020\u0014*\u00020\u00012\b\u0010¶\u0002\u001a\u00030µ\u00022\u0007\u0010·\u0002\u001a\u00020\n2\u0007\u0010¸\u0002\u001a\u00020\nH\u0002¢\u0006\u0006\b¹\u0002\u0010º\u0002Jy\u0010¾\u0002\u001a\u00020\u0005*\u00020k2\r\u0010¿\u0001\u001a\b0¼\u0001j\u0003`½\u00012\b\u0010Ä\u0001\u001a\u00030Ã\u00012\b\u0010Æ\u0001\u001a\u00030Å\u00012\u0013\u0010»\u0002\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050 2\u0013\u0010¼\u0002\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00140 2\u0013\u0010½\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020=0 H\u0082\b¢\u0006\u0006\b¾\u0002\u0010¿\u0002J\u001d\u0010À\u0002\u001a\u00020\u0014*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0005\bÀ\u0002\u0010}J@\u0010Á\u0002\u001a\u00020\u0005*\u00020\u00012\u0006\u0010T\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0017\u0010U\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bHH\u0082\b¢\u0006\u0006\bÁ\u0002\u0010Â\u0002J]\u0010Ã\u0002\u001a\u00020\u0014*\u00020\u00012\u0006\u0010T\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0017\u0010I\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bH2\u0018\u0010\u009d\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bHH\u0082Hø\u0001\u0000¢\u0006\u0006\bÃ\u0002\u0010Ä\u0002R\u001b\u0010Å\u0002\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0002\u0010Æ\u0002R\u001d\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u0006\u0010Ç\u0002\u001a\u0006\bÈ\u0002\u0010í\u0001R\u0017\u0010Ë\u0002\u001a\u00020\n8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÉ\u0002\u0010Ê\u0002R\u0017\u0010Í\u0002\u001a\u00020\n8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÌ\u0002\u0010Ê\u0002R0\u0010Ô\u0002\u001a\u0005\u0018\u00010Î\u00022\n\u0010Ï\u0002\u001a\u0005\u0018\u00010Î\u00028B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\bÐ\u0002\u0010Ñ\u0002\"\u0006\bÒ\u0002\u0010Ó\u0002R\u0019\u0010×\u0002\u001a\u0004\u0018\u00010+8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÕ\u0002\u0010Ö\u0002R\u0017\u0010Ø\u0002\u001a\u00020\u00058VX\u0096\u0004¢\u0006\b\u001a\u0006\bØ\u0002\u0010í\u0001R\u0017\u0010Ù\u0002\u001a\u00020\u00058VX\u0096\u0004¢\u0006\b\u001a\u0006\bÙ\u0002\u0010í\u0001R\u001b\u0010Ø\u0001\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010Ú\u0002R\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\t\u0010Û\u0002R1\u0010Ü\u0002\u001a\u00030µ\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u001f\n\u0006\bÜ\u0002\u0010Ý\u0002\u0012\u0005\bâ\u0002\u0010Y\u001a\u0006\bÞ\u0002\u0010ß\u0002\"\u0006\bà\u0002\u0010á\u0002R:\u0010ç\u0002\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010o2\u000f\u0010Ï\u0002\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010o8B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\bã\u0002\u0010ä\u0002\"\u0006\bå\u0002\u0010æ\u0002R\u0019\u0010è\u0002\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0002\u0010é\u0002R\u001f\u0010¯\u0001\u001a\u00030ê\u00028\u0002X\u0082\u0004¢\u0006\u000f\n\u0006\b¯\u0001\u0010ë\u0002\u0012\u0005\bì\u0002\u0010YR\u001e\u0010î\u0002\u001a\t\u0012\u0004\u0012\u00020\u00050í\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bî\u0002\u0010ï\u0002R\u001d\u0010\u000b\u001a\u00020\n8\u0000X\u0080\u0004¢\u0006\u000f\n\u0005\b\u000b\u0010é\u0002\u001a\u0006\bð\u0002\u0010Ê\u0002R\u0016\u0010ò\u0002\u001a\u00020D8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bñ\u0002\u0010FR2\u0010ô\u0002\u001a\u00020=2\u0007\u0010ó\u0002\u001a\u00020=8\u0016@PX\u0096\u000e¢\u0006\u0018\n\u0006\bô\u0002\u0010õ\u0002\u001a\u0006\bö\u0002\u0010÷\u0002\"\u0006\bø\u0002\u0010ù\u0002R2\u0010ú\u0002\u001a\u00020=2\u0007\u0010ó\u0002\u001a\u00020=8\u0016@PX\u0096\u000e¢\u0006\u0018\n\u0006\bú\u0002\u0010õ\u0002\u001a\u0006\bû\u0002\u0010÷\u0002\"\u0006\bü\u0002\u0010ù\u0002R;\u0010þ\u0002\u001a\u00030µ\u00022\b\u0010ý\u0002\u001a\u00030µ\u00028\u0016@VX\u0097\u000e¢\u0006\u001f\n\u0006\bþ\u0002\u0010Ý\u0002\u0012\u0005\b\u0081\u0003\u0010Y\u001a\u0006\bÿ\u0002\u0010ß\u0002\"\u0006\b\u0080\u0003\u0010á\u0002R:\u0010\u0084\u0003\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010o2\u000f\u0010Ï\u0002\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010o8B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\b\u0082\u0003\u0010ä\u0002\"\u0006\b\u0083\u0003\u0010æ\u0002R\u0019\u0010\u0085\u0003\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0003\u0010é\u0002R\u0018\u0010\u0087\u0003\u001a\u00030\u0086\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0003\u0010\u0088\u0003R\u001e\u0010\u0089\u0003\u001a\t\u0012\u0004\u0012\u00020\u00140í\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0003\u0010ï\u0002R)\u0010\u008a\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140o\u0012\u0004\u0012\u00020p0 8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0003\u0010\u008b\u0003R\u0019\u0010\u008c\u0003\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0003\u0010é\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u008e\u0003"}, m5598d2 = {"Lio/ktor/utils/io/ByteBufferChannel;", "Ljava/nio/ByteBuffer;", "content", "<init>", "(Ljava/nio/ByteBuffer;)V", "", "autoFlush", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "pool", "", "reservedSize", "(ZLio/ktor/utils/io/pool/ObjectPool;I)V", "buffer", "Lio/ktor/utils/io/internal/RingBufferCapacity;", "capacity", "afterBufferVisited", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/internal/RingBufferCapacity;)I", "Lkotlinx/coroutines/Job;", "job", "", "attachJob", "(Lkotlinx/coroutines/Job;)V", RsaJsonWebKey.MODULUS_MEMBER_NAME, "awaitAtLeast", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAtLeastSuspend", "awaitClose", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitContent", "awaitFreeSpace", "min", "Lkotlin/Function1;", "block", "awaitFreeSpaceOrDelegate", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/WriterSuspendSession;", "beginWriteSession", "()Lio/ktor/utils/io/WriterSuspendSession;", NewHtcHomeBadger.COUNT, "bytesWrittenFromSession$ktor_io", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/internal/RingBufferCapacity;I)V", "bytesWrittenFromSession", "", HexAttribute.HEX_ATTR_CAUSE, "cancel", "(Ljava/lang/Throwable;)Z", "close", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "last", "visitor", "consumeEachBufferRange", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeEachBufferRangeFast", "(ZLkotlin/jvm/functions/Function2;)Z", "consumeEachBufferRangeSuspend", "consumed", "(I)V", ReactVideoViewManager.PROP_SRC, "", "limit", "Lio/ktor/utils/io/internal/JoiningState;", "joined", "copyDirect$ktor_io", "(Lio/ktor/utils/io/ByteBufferChannel;JLio/ktor/utils/io/internal/JoiningState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyDirect", "Lio/ktor/utils/io/internal/ReadWriteBufferState;", "currentState$ktor_io", "()Lio/ktor/utils/io/internal/ReadWriteBufferState;", "currentState", "Lkotlin/ExtensionFunctionType;", "channelWriter", "delegatePrimitive", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delegateSuspend", "(Lio/ktor/utils/io/internal/JoiningState;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "max", "discard", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discarded0", "discardSuspend", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "size", "writer", "doWritePrimitive", "(ILjava/nio/ByteBuffer;Lio/ktor/utils/io/internal/RingBufferCapacity;Lkotlin/jvm/functions/Function1;)V", "endReadSession", "()V", "written", "endWriteSession", "ensureClosedJoined", "(Lio/ktor/utils/io/internal/JoiningState;)V", "flush", "minWriteSize", "flushImpl", "getJoining$ktor_io", "()Lio/ktor/utils/io/internal/JoiningState;", "getJoining", "delegateClose", "joinFrom$ktor_io", "(Lio/ktor/utils/io/ByteBufferChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinFrom", "joinFromSuspend", "(Lio/ktor/utils/io/ByteBufferChannel;ZLio/ktor/utils/io/internal/JoiningState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "Lio/ktor/utils/io/LookAheadSession;", "lookAhead", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/coroutines/Continuation;", "", "lookAheadSuspend", "newBuffer", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "Lio/ktor/utils/io/bits/Memory;", FirebaseAnalytics.Param.DESTINATION, "destinationOffset", TypedValues.CycleType.S_WAVE_OFFSET, "peekTo-vHUFkk8", "(Ljava/nio/ByteBuffer;JJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peekTo", "lockedSpace", "prepareWriteBuffer$ktor_io", "(Ljava/nio/ByteBuffer;I)V", "prepareWriteBuffer", "consumer", "read", "Lio/ktor/utils/io/core/Buffer;", C4352k.a.f5652f, "readAsMuchAsPossible", "(Lio/ktor/utils/io/core/Buffer;II)I", "(Ljava/nio/ByteBuffer;)I", "", "length", "([BII)I", "Lio/ktor/utils/io/core/IoBuffer;", "readAvailable", "(Lio/ktor/utils/io/core/IoBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(ILkotlin/jvm/functions/Function1;)I", "readAvailableSuspend", "readBlockSuspend", "readBoolean", "", "readByte", "", "readDouble", "", "readFloat", "readFully", "(Lio/ktor/utils/io/core/IoBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFullySuspend", "rc0", "(Ljava/nio/ByteBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readInt", "readLong", "headerSizeHint", "Lio/ktor/utils/io/core/ByteReadPacket;", "readPacket", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/core/BytePacketBuilder;", "builder", "readPacketSuspend", "(ILio/ktor/utils/io/core/BytePacketBuilder;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", ExifInterface.GPS_DIRECTION_TRUE, "getter", "readPrimitive", "readRemaining", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRemainingSuspend", "Lio/ktor/utils/io/ReadSession;", "readSession", "(Lkotlin/jvm/functions/Function1;)V", "", "readShort", "readSuspend", "readSuspendImpl", "readSuspendLoop", "readSuspendPredicate", "(I)Z", "Lio/ktor/utils/io/SuspendableReadSession;", "readSuspendableSession", "", "readUTF8Line", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "out", "readUTF8LineTo", "(Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readUTF8LineToAscii", "", OTCCPAGeolocationConstants.f4105CA, "Ljava/nio/CharBuffer;", "cb", "consumed0", "readUTF8LineToUtf8Suspend", "(Ljava/lang/Appendable;I[CLjava/nio/CharBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reading", "(Lkotlin/jvm/functions/Function2;)Z", "releaseBuffer", "(Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;)V", "remainingPacket", "(JI)Lio/ktor/utils/io/core/ByteReadPacket;", "skip", "atLeast", "request", "(II)Ljava/nio/ByteBuffer;", "resolveChannelInstance$ktor_io", "()Lio/ktor/utils/io/ByteBufferChannel;", "resolveChannelInstance", "current", "joining", "resolveDelegation", "(Lio/ktor/utils/io/ByteBufferChannel;Lio/ktor/utils/io/internal/JoiningState;)Lio/ktor/utils/io/ByteBufferChannel;", "restoreStateAfterRead", "restoreStateAfterWrite$ktor_io", "restoreStateAfterWrite", "resumeClosed", "(Ljava/lang/Throwable;)V", "resumeReadOp", "Lkotlin/Function0;", "exception", "(Lkotlin/jvm/functions/Function0;)V", "resumeWriteOp", "delegate", "setupDelegateTo", "(Lio/ktor/utils/io/ByteBufferChannel;Z)Lio/ktor/utils/io/internal/JoiningState;", "setupStateForRead", "()Ljava/nio/ByteBuffer;", "setupStateForWrite$ktor_io", "setupStateForWrite", "shouldResumeReadOp", "()Z", "startReadSession", "()Lio/ktor/utils/io/SuspendableReadSession;", "continuation", "suspensionForSize", "toString", "()Ljava/lang/String;", "tryCompleteJoining", "(Lio/ktor/utils/io/internal/JoiningState;)Z", "forceTermination", "tryReleaseBuffer", "(Z)Z", "tryTerminate$ktor_io", "tryTerminate", "packet", "tryWritePacketPart", "(Lio/ktor/utils/io/core/ByteReadPacket;)I", "tryWriteSuspend$ktor_io", "tryWriteSuspend", "write", "writeAsMuchAsPossible", "(Lio/ktor/utils/io/core/Buffer;)I", "writeAvailable", "writeAvailableSuspend", "b", "writeByte", "(BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "writeDouble", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "writeFloat", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memory", "startIndex", "endIndex", "writeFully-rGWNHyQ", "(Ljava/nio/ByteBuffer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "(Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFullySuspend", ContextChain.TAG_INFRA, "writeInt", "l", "writeLong", "writePacket", "(Lio/ktor/utils/io/core/ByteReadPacket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePacketSuspend", "bufferWriter", "writePrimitive", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "writeShort", "(SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeSuspend", "writeSuspendPredicate", "writeSuspendSession", "writeWhile", "writeWhileLoop", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/internal/RingBufferCapacity;Lkotlin/jvm/functions/Function1;)Z", "writeWhileNoSuspend", "(Lkotlin/jvm/functions/Function1;)Z", "writeWhileSuspend", "Lkotlin/Function3;", "writing", "(Lkotlin/jvm/functions/Function3;)V", "bytesRead", "bytesWritten", "carry", "idx", "carryIndex", "(Ljava/nio/ByteBuffer;I)I", "Lio/ktor/utils/io/core/ByteOrder;", "order", ViewProps.POSITION, "available", "prepareBuffer", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/core/ByteOrder;II)V", "await", "addConsumed", "decode", "readLineLoop", "(Lio/ktor/utils/io/LookAheadSession;Ljava/lang/Appendable;[CLjava/nio/CharBuffer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Z", "rollBytes", "tryWritePrimitive", "(Ljava/nio/ByteBuffer;ILio/ktor/utils/io/internal/RingBufferCapacity;Lkotlin/jvm/functions/Function1;)Z", "writeSuspendPrimitive", "(Ljava/nio/ByteBuffer;ILio/ktor/utils/io/internal/RingBufferCapacity;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "attachedJob", "Lkotlinx/coroutines/Job;", "Z", "getAutoFlush", "getAvailableForRead", "()I", "availableForRead", "getAvailableForWrite", "availableForWrite", "Lio/ktor/utils/io/internal/ClosedElement;", "value", "getClosed", "()Lio/ktor/utils/io/internal/ClosedElement;", "setClosed", "(Lio/ktor/utils/io/internal/ClosedElement;)V", "closed", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForRead", "isClosedForWrite", "Lio/ktor/utils/io/internal/JoiningState;", "Lio/ktor/utils/io/pool/ObjectPool;", "readByteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "getReadByteOrder", "()Lio/ktor/utils/io/core/ByteOrder;", "setReadByteOrder", "(Lio/ktor/utils/io/core/ByteOrder;)V", "getReadByteOrder$annotations", "getReadOp", "()Lkotlin/coroutines/Continuation;", "setReadOp", "(Lkotlin/coroutines/Continuation;)V", "readOp", "readPosition", "I", "Lio/ktor/utils/io/internal/ReadSessionImpl;", "Lio/ktor/utils/io/internal/ReadSessionImpl;", "getReadSession$annotations", "Lio/ktor/utils/io/internal/CancellableReusableContinuation;", "readSuspendContinuationCache", "Lio/ktor/utils/io/internal/CancellableReusableContinuation;", "getReservedSize$ktor_io", "getState", "state", "<set-?>", "totalBytesRead", "J", "getTotalBytesRead", "()J", "setTotalBytesRead$ktor_io", "(J)V", "totalBytesWritten", "getTotalBytesWritten", "setTotalBytesWritten$ktor_io", "newOrder", "writeByteOrder", "getWriteByteOrder", "setWriteByteOrder", "getWriteByteOrder$annotations", "getWriteOp", "setWriteOp", "writeOp", "writePosition", "Lio/ktor/utils/io/internal/WriteSessionImpl;", "writeSession", "Lio/ktor/utils/io/internal/WriteSessionImpl;", "writeSuspendContinuationCache", "writeSuspension", "Lkotlin/jvm/functions/Function1;", "writeSuspensionSize", "Companion", "ktor-io", "Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/utils/io/HasReadSession;", "Lio/ktor/utils/io/HasWriteSession;"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public class ByteBufferChannel implements ByteChannel, ByteReadChannel, ByteWriteChannel, LookAheadSuspendSession, HasReadSession, HasWriteSession {
    private static final int ReservedLongIndex = -8;
    private volatile /* synthetic */ Object _closed;
    volatile /* synthetic */ Object _readOp;
    private volatile /* synthetic */ Object _state;
    volatile /* synthetic */ Object _writeOp;
    private volatile Job attachedJob;
    private final boolean autoFlush;
    private volatile JoiningState joining;
    private final ObjectPool<ReadWriteBufferState.Initial> pool;
    private ByteOrder readByteOrder;
    private int readPosition;
    private final ReadSessionImpl readSession;
    private final CancellableReusableContinuation<Boolean> readSuspendContinuationCache;
    private final int reservedSize;
    private volatile long totalBytesRead;
    private volatile long totalBytesWritten;
    private ByteOrder writeByteOrder;
    private int writePosition;
    private final WriteSessionImpl writeSession;
    private final CancellableReusableContinuation<Unit> writeSuspendContinuationCache;
    private final Function1<Continuation<? super Unit>, Object> writeSuspension;
    private volatile int writeSuspensionSize;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_state");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _closed$FU = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_closed");
    static final /* synthetic */ AtomicReferenceFieldUpdater _readOp$FU = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_readOp");
    static final /* synthetic */ AtomicReferenceFieldUpdater _writeOp$FU = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_writeOp");

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0}, m5610l = {1901}, m5611m = "awaitAtLeastSuspend", m5612n = {"this"}, m5613s = {"L$0"})
    static final class C52171 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52171(Continuation<? super C52171> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.awaitAtLeastSuspend(0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0}, m5610l = {1533, 1534}, m5611m = "awaitFreeSpaceOrDelegate", m5612n = {"this", "block", "min"}, m5613s = {"L$0", "L$1", "I$0"})
    static final class C52181 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52181(Continuation<? super C52181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.awaitFreeSpaceOrDelegate(0, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$consumeEachBufferRangeSuspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0}, m5610l = {1961}, m5611m = "consumeEachBufferRangeSuspend", m5612n = {"this", "visitor", "last"}, m5613s = {"L$0", "L$1", "I$0"})
    static final class C52191 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52191(Continuation<? super C52191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.consumeEachBufferRangeSuspend(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$discardSuspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0}, m5610l = {1723}, m5611m = "discardSuspend", m5612n = {"this", "discarded", "max"}, m5613s = {"L$0", "L$1", "J$0"})
    static final class C52201 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52201(Continuation<? super C52201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.discardSuspend(0L, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$joinFromSuspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0}, m5610l = {1175, 1183}, m5611m = "joinFromSuspend", m5612n = {"this", ReactVideoViewManager.PROP_SRC, "delegateClose"}, m5613s = {"L$0", "L$1", "Z$0"})
    static final class C52211 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C52211(Continuation<? super C52211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.joinFromSuspend(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$lookAheadSuspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {2, 2, 2, 2, 5, 5}, m5610l = {1820, 1822, 1827, 1832, 1834, 1838}, m5611m = "lookAheadSuspend$suspendImpl", m5612n = {"this", "visitor", "result", "this_$iv", "this", "result"}, m5613s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
    static final class C52221<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C52221(Continuation<? super C52221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.lookAheadSuspend$suspendImpl(ByteBufferChannel.this, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0, 0}, m5610l = {732, 736}, m5611m = "readAvailableSuspend", m5612n = {"this", C4352k.a.f5652f, TypedValues.CycleType.S_WAVE_OFFSET, "length"}, m5613s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C52231 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52231(Continuation<? super C52231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readAvailableSuspend(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0}, m5610l = {740, 744}, m5611m = "readAvailableSuspend", m5612n = {"this", C4352k.a.f5652f}, m5613s = {"L$0", "L$1"})
    static final class C52242 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52242(Continuation<? super C52242> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readAvailableSuspend((ByteBuffer) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0}, m5610l = {748, 752}, m5611m = "readAvailableSuspend", m5612n = {"this", C4352k.a.f5652f}, m5613s = {"L$0", "L$1"})
    static final class C52253 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52253(Continuation<? super C52253> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readAvailableSuspend((IoBuffer) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0}, m5610l = {1731, 1739}, m5611m = "readBlockSuspend", m5612n = {"this", "block", "min"}, m5613s = {"L$0", "L$1", "I$0"})
    static final class C52261 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52261(Continuation<? super C52261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readBlockSuspend(0, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readBoolean$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {}, m5610l = {821}, m5611m = "readBoolean", m5612n = {}, m5613s = {})
    static final class C52271 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C52271(Continuation<? super C52271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readBoolean(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readByte$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0}, m5610l = {2484}, m5611m = "readByte", m5612n = {"this_$iv", "size$iv"}, m5613s = {"L$0", "I$0"})
    static final class C52281 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52281(Continuation<? super C52281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readByte(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readDouble$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0}, m5610l = {2484}, m5611m = "readDouble", m5612n = {"this_$iv", "size$iv"}, m5613s = {"L$0", "I$0"})
    static final class C52291 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52291(Continuation<? super C52291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readDouble(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readFloat$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0}, m5610l = {2484}, m5611m = "readFloat", m5612n = {"this_$iv", "size$iv"}, m5613s = {"L$0", "I$0"})
    static final class C52301 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52301(Continuation<? super C52301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readFloat(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0}, m5610l = {594}, m5611m = "readFullySuspend", m5612n = {"this", C4352k.a.f5652f, "copied"}, m5613s = {"L$0", "L$1", "I$0"})
    static final class C52311 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52311(Continuation<? super C52311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readFullySuspend((ByteBuffer) null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readFullySuspend$2 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0, 0}, m5610l = {617}, m5611m = "readFullySuspend", m5612n = {"this", C4352k.a.f5652f, RsaJsonWebKey.MODULUS_MEMBER_NAME, "copied"}, m5613s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C52322 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52322(Continuation<? super C52322> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readFullySuspend((IoBuffer) null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0, 0, 0}, m5610l = {631}, m5611m = "readFullySuspend", m5612n = {"this", C4352k.a.f5652f, "currentOffset", "currentLength", "consumed"}, m5613s = {"L$0", "L$1", "I$0", "I$1", "I$2"})
    static final class C52333 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52333(Continuation<? super C52333> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readFullySuspend(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readInt$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0}, m5610l = {2484}, m5611m = "readInt", m5612n = {"this_$iv", "size$iv"}, m5613s = {"L$0", "I$0"})
    static final class C52341 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52341(Continuation<? super C52341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readInt(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readLong$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0}, m5610l = {2484}, m5611m = "readLong", m5612n = {"this_$iv", "size$iv"}, m5613s = {"L$0", "I$0"})
    static final class C52351 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52351(Continuation<? super C52351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readLong(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0, 0}, m5610l = {803}, m5611m = "readPacketSuspend", m5612n = {"this", "builder", "buffer", "remaining"}, m5613s = {"L$0", "L$1", "L$2", "I$0"})
    static final class C52361 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C52361(Continuation<? super C52361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readPacketSuspend(0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0, 0, 0}, m5610l = {2157}, m5611m = "readRemainingSuspend", m5612n = {"this", "builder$iv", "remaining", "$this$writeWhile$iv", "tail$iv"}, m5613s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C52371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C52371(Continuation<? super C52371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readRemainingSuspend(0L, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readShort$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0}, m5610l = {2484}, m5611m = "readShort", m5612n = {"this_$iv", "size$iv"}, m5613s = {"L$0", "I$0"})
    static final class C52391 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52391(Continuation<? super C52391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readShort(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0}, m5610l = {2249}, m5611m = "readSuspendLoop", m5612n = {"this", "size"}, m5613s = {"L$0", "I$0"})
    static final class C52401 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52401(Continuation<? super C52401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readSuspendLoop(0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0}, m5610l = {2118}, m5611m = "readUTF8Line$suspendImpl", m5612n = {"sb"}, m5613s = {"L$0"})
    static final class C52421 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52421(Continuation<? super C52421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.readUTF8Line$suspendImpl(ByteBufferChannel.this, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0}, m5610l = {2077}, m5611m = "readUTF8LineToUtf8Suspend", m5612n = {"result"}, m5613s = {"L$0"})
    static final class C52441 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52441(Continuation<? super C52441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.readUTF8LineToUtf8Suspend(null, 0, null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$write$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0}, m5610l = {1528}, m5611m = "write$suspendImpl", m5612n = {"this", "block", "min"}, m5613s = {"L$0", "L$1", "I$0"})
    static final class C52461 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52461(Continuation<? super C52461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.write$suspendImpl(ByteBufferChannel.this, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0}, m5610l = {1076, 1078, 1080}, m5611m = "writeAvailableSuspend", m5612n = {"this", ReactVideoViewManager.PROP_SRC}, m5613s = {"L$0", "L$1"})
    static final class C52471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52471(Continuation<? super C52471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.writeAvailableSuspend((ByteBuffer) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$3 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0}, m5610l = {1084, 1086, 1088}, m5611m = "writeAvailableSuspend", m5612n = {"this", ReactVideoViewManager.PROP_SRC}, m5613s = {"L$0", "L$1"})
    static final class C52483 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52483(Continuation<? super C52483> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.writeAvailableSuspend((IoBuffer) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$writeByte$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {3, 3, 3, 4, 4, 4, 4, 4, 7, 7, 7}, m5610l = {939, 939, 939, 2473, 2528, 939, 939, 2555}, m5611m = "writeByte$suspendImpl", m5612n = {"joined$iv$iv", "this_$iv$iv$iv", "b", "capacity$iv", "this_$iv$iv", "$this$writeSuspendPrimitive$iv$iv", "b", "size$iv", "joined$iv$iv$iv", "this_$iv$iv$iv$iv", "b"}, m5613s = {"L$0", "L$1", "B$0", "L$0", "L$1", "L$2", "B$0", "I$0", "L$0", "L$1", "B$0"})
    static final class C52491 extends ContinuationImpl {
        byte B$0;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C52491(Continuation<? super C52491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.writeByte$suspendImpl(ByteBufferChannel.this, (byte) 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$writeFully$3 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0}, m5610l = {1102}, m5611m = "writeFully$suspendImpl", m5612n = {"this", ReactVideoViewManager.PROP_SRC}, m5613s = {"L$0", "L$1"})
    static final class C52503 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52503(Continuation<? super C52503> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.writeFully$suspendImpl(ByteBufferChannel.this, (Buffer) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0}, m5610l = {1125, 1127}, m5611m = "writeFullySuspend", m5612n = {"this", ReactVideoViewManager.PROP_SRC}, m5613s = {"L$0", "L$1"})
    static final class C52521 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52521(Continuation<? super C52521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.writeFullySuspend((ByteBuffer) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0}, m5610l = {1135, 1137}, m5611m = "writeFullySuspend", m5612n = {"this", ReactVideoViewManager.PROP_SRC}, m5613s = {"L$0", "L$1"})
    static final class C52533 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52533(Continuation<? super C52533> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.writeFullySuspend((IoBuffer) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0, 0}, m5610l = {1442}, m5611m = "writeFullySuspend", m5612n = {"this", ReactVideoViewManager.PROP_SRC, "currentOffset", "currentLength"}, m5613s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C52545 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52545(Continuation<? super C52545> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.writeFullySuspend(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$writeInt$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {3, 3, 3, 4, 4, 4, 4, 4, 7, 7, 7}, m5610l = {947, 947, 947, 2473, 2528, 947, 947, 2555}, m5611m = "writeInt$suspendImpl", m5612n = {"joined$iv$iv", "this_$iv$iv$iv", ContextChain.TAG_INFRA, "capacity$iv", "this_$iv$iv", "$this$writeSuspendPrimitive$iv$iv", ContextChain.TAG_INFRA, "size$iv", "joined$iv$iv$iv", "this_$iv$iv$iv$iv", ContextChain.TAG_INFRA}, m5613s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "I$0"})
    static final class C52551 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C52551(Continuation<? super C52551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.writeInt$suspendImpl(ByteBufferChannel.this, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$writeLong$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {3, 3, 3, 4, 4, 4, 4, 4, 7, 7, 7}, m5610l = {951, 951, 951, 2473, 2528, 951, 951, 2555}, m5611m = "writeLong$suspendImpl", m5612n = {"joined$iv$iv", "this_$iv$iv$iv", "l", "capacity$iv", "this_$iv$iv", "$this$writeSuspendPrimitive$iv$iv", "l", "size$iv", "joined$iv$iv$iv", "this_$iv$iv$iv$iv", "l"}, m5613s = {"L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0", "I$0", "L$0", "L$1", "J$0"})
    static final class C52561 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C52561(Continuation<? super C52561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.writeLong$suspendImpl(ByteBufferChannel.this, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 1}, m5610l = {1763, 1765}, m5611m = "writePacketSuspend", m5612n = {"this", "packet", "packet"}, m5613s = {"L$0", "L$1", "L$0"})
    static final class C52571 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52571(Continuation<? super C52571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.writePacketSuspend(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$writeShort$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {3, 3, 3, 4, 4, 4, 4, 4, 7, 7, 7}, m5610l = {943, 943, 943, 2473, 2528, 943, 943, 2555}, m5611m = "writeShort$suspendImpl", m5612n = {"joined$iv$iv", "this_$iv$iv$iv", "s", "capacity$iv", "this_$iv$iv", "$this$writeSuspendPrimitive$iv$iv", "s", "size$iv", "joined$iv$iv$iv", "this_$iv$iv$iv$iv", "s"}, m5613s = {"L$0", "L$1", "S$0", "L$0", "L$1", "L$2", "S$0", "I$0", "L$0", "L$1", "S$0"})
    static final class C52581 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        short S$0;
        int label;
        /* synthetic */ Object result;

        C52581(Continuation<? super C52581> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.writeShort$suspendImpl(ByteBufferChannel.this, (short) 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$writeSuspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0, 0}, m5610l = {1459, 1461}, m5611m = "writeSuspend", m5612n = {"this", ReactVideoViewManager.PROP_SRC, TypedValues.CycleType.S_WAVE_OFFSET, "length"}, m5613s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C52591 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52591(Continuation<? super C52591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.writeSuspend(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$writeSuspend$3 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0}, m5610l = {2459}, m5611m = "writeSuspend", m5612n = {"this", "size"}, m5613s = {"L$0", "I$0"})
    static final class C52603 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52603(Continuation<? super C52603> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.writeSuspend(0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0}, m5610l = {1865}, m5611m = "writeSuspendSession$suspendImpl", m5612n = {"session"}, m5613s = {"L$0"})
    static final class C52611 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52611(Continuation<? super C52611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.writeSuspendSession$suspendImpl(ByteBufferChannel.this, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$writeWhileSuspend$1 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m5610l = {1558, 1570}, m5611m = "writeWhileSuspend", m5612n = {"this", "block", "continueWriting", "this_$iv", "capacity$iv", "current$iv", "capacity", C4352k.a.f5652f, "$this$writeWhileSuspend_u24lambda_u2d99", "before$iv"}, m5613s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0"})
    static final class C52621 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C52621(Continuation<? super C52621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteBufferChannel.this.writeWhileSuspend(null, this);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Setting byte order is no longer supported. Read/write in big endian and use reverseByteOrder() extensions.")
    public static /* synthetic */ void getReadByteOrder$annotations() {
    }

    private static /* synthetic */ void getReadSession$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Setting byte order is no longer supported. Read/write in big endian and use reverseByteOrder() extensions.")
    public static /* synthetic */ void getWriteByteOrder$annotations() {
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object awaitContent(Continuation<? super Unit> continuation) {
        return awaitContent$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    @ExperimentalIoApi
    public Object awaitFreeSpace(Continuation<? super Unit> continuation) {
        return awaitFreeSpace$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object discard(long j, Continuation<? super Long> continuation) {
        return discard$suspendImpl(this, j, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public <R> Object lookAheadSuspend(Function2<? super LookAheadSuspendSession, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return lookAheadSuspend$suspendImpl(this, function2, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    /* JADX INFO: renamed from: peekTo-vHUFkk8, reason: not valid java name */
    public Object mo6940peekTovHUFkk8(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, Continuation<? super Long> continuation) {
        return m6938peekTovHUFkk8$suspendImpl(this, byteBuffer, j, j2, j3, j4, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object read(int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        return read$suspendImpl(this, i, function1, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readAvailable(IoBuffer ioBuffer, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, ioBuffer, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, byteBuffer, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readFully(IoBuffer ioBuffer, int i, Continuation<? super Unit> continuation) {
        return readFully$suspendImpl(this, ioBuffer, i, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readPacket(int i, int i2, Continuation<? super ByteReadPacket> continuation) {
        return readPacket$suspendImpl(this, i, i2, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readRemaining(long j, int i, Continuation<? super ByteReadPacket> continuation) {
        return readRemaining$suspendImpl(this, j, i, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    @ExperimentalIoApi
    public Object readSuspendableSession(Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return readSuspendableSession$suspendImpl(this, function2, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readUTF8Line(int i, Continuation<? super String> continuation) {
        return readUTF8Line$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public <A extends Appendable> Object readUTF8LineTo(A a2, int i, Continuation<? super Boolean> continuation) {
        return readUTF8LineToAscii(a2, i, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object write(int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        return write$suspendImpl(this, i, function1, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeAvailable(IoBuffer ioBuffer, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, ioBuffer, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, byteBuffer, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeByte(byte b, Continuation<? super Unit> continuation) {
        return writeByte$suspendImpl(this, b, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeDouble(double d, Continuation<? super Unit> continuation) {
        return writeDouble$suspendImpl(this, d, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeFloat(float f, Continuation<? super Unit> continuation) {
        return writeFloat$suspendImpl(this, f, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeFully(Buffer buffer, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, buffer, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeFully(IoBuffer ioBuffer, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, ioBuffer, (Continuation) continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeFully(ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, byteBuffer, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    /* JADX INFO: renamed from: writeFully-rGWNHyQ, reason: not valid java name */
    public Object mo6941writeFullyrGWNHyQ(ByteBuffer byteBuffer, int i, int i2, Continuation<? super Unit> continuation) {
        return m6939writeFullyrGWNHyQ$suspendImpl(this, byteBuffer, i, i2, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeInt(int i, Continuation<? super Unit> continuation) {
        return writeInt$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeLong(long j, Continuation<? super Unit> continuation) {
        return writeLong$suspendImpl(this, j, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writePacket(ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation) {
        return writePacket$suspendImpl(this, byteReadPacket, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeShort(short s, Continuation<? super Unit> continuation) {
        return writeShort$suspendImpl(this, s, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    @ExperimentalIoApi
    public Object writeSuspendSession(Function2<? super WriterSuspendSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return writeSuspendSession$suspendImpl(this, function2, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeWhile(Function1<? super ByteBuffer, Boolean> function1, Continuation<? super Unit> continuation) {
        return writeWhile$suspendImpl(this, function1, continuation);
    }

    public ByteBufferChannel(boolean z, ObjectPool<ReadWriteBufferState.Initial> pool, int i) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.autoFlush = z;
        this.pool = pool;
        this.reservedSize = i;
        this._state = ReadWriteBufferState.IdleEmpty.INSTANCE;
        this._closed = null;
        this._readOp = null;
        this._writeOp = null;
        this.readByteOrder = ByteOrder.BIG_ENDIAN;
        this.writeByteOrder = ByteOrder.BIG_ENDIAN;
        this.readSession = new ReadSessionImpl(this);
        this.writeSession = new WriteSessionImpl(this);
        this.readSuspendContinuationCache = new CancellableReusableContinuation<>();
        this.writeSuspendContinuationCache = new CancellableReusableContinuation<>();
        this.writeSuspension = new Function1<Continuation<? super Unit>, Object>() { // from class: io.ktor.utils.io.ByteBufferChannel$writeSuspension$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> ucont) throws Throwable {
                Throwable sendException;
                Intrinsics.checkNotNullParameter(ucont, "ucont");
                int i2 = this.this$0.writeSuspensionSize;
                while (true) {
                    ClosedElement closed = this.this$0.getClosed();
                    if (closed != null && (sendException = closed.getSendException()) != null) {
                        ByteBufferChannelKt.rethrowClosed(sendException);
                        throw new KotlinNothingValueException();
                    }
                    if (!this.this$0.writeSuspendPredicate(i2)) {
                        Unit unit = Unit.INSTANCE;
                        Result.Companion companion = Result.INSTANCE;
                        ucont.resumeWith(Result.m7233constructorimpl(unit));
                        break;
                    }
                    ByteBufferChannel byteBufferChannel = this.this$0;
                    Continuation continuationIntercepted = IntrinsicsKt.intercepted(ucont);
                    ByteBufferChannel byteBufferChannel2 = this.this$0;
                    while (true) {
                        if (byteBufferChannel.getWriteOp() == null) {
                            if (byteBufferChannel2.writeSuspendPredicate(i2)) {
                                if (C0526xc40028dd.m1169m(ByteBufferChannel._writeOp$FU, byteBufferChannel, null, continuationIntercepted)) {
                                    if (byteBufferChannel2.writeSuspendPredicate(i2) || !C0526xc40028dd.m1169m(ByteBufferChannel._writeOp$FU, byteBufferChannel, continuationIntercepted, null)) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            throw new IllegalStateException("Operation is already in progress".toString());
                        }
                    }
                }
                this.this$0.flushImpl(i2);
                if (this.this$0.shouldResumeReadOp()) {
                    this.this$0.resumeReadOp();
                }
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
        };
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    public /* synthetic */ ByteBufferChannel(boolean z, ObjectPool objectPool, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i2 & 2) != 0 ? ObjectPoolKt.getBufferObjectPool() : objectPool, (i2 & 4) != 0 ? 8 : i);
    }

    /* JADX INFO: renamed from: getReservedSize$ktor_io, reason: from getter */
    public final int getReservedSize() {
        return this.reservedSize;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel(ByteBuffer content) {
        this(false, ObjectPoolKt.getBufferObjectNoPool(), 0);
        Intrinsics.checkNotNullParameter(content, "content");
        ByteBuffer byteBufferSlice = content.slice();
        Intrinsics.checkNotNullExpressionValue(byteBufferSlice, "content.slice()");
        ReadWriteBufferState.Initial initial = new ReadWriteBufferState.Initial(byteBufferSlice, 0);
        initial.capacity.resetForRead();
        Unit unit = Unit.INSTANCE;
        this._state = initial.startWriting$ktor_io();
        restoreStateAfterWrite$ktor_io();
        ByteWriteChannelKt.close(this);
        tryTerminate$ktor_io();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReadWriteBufferState getState() {
        return (ReadWriteBufferState) this._state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClosedElement getClosed() {
        return (ClosedElement) this._closed;
    }

    private final void setClosed(ClosedElement closedElement) {
        this._closed = closedElement;
    }

    private final Continuation<Boolean> getReadOp() {
        return (Continuation) this._readOp;
    }

    private final void setReadOp(Continuation<? super Boolean> continuation) {
        this._readOp = continuation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Continuation<Unit> getWriteOp() {
        return (Continuation) this._writeOp;
    }

    private final void setWriteOp(Continuation<? super Unit> continuation) {
        this._writeOp = continuation;
    }

    public final ReadWriteBufferState currentState$ktor_io() {
        return getState();
    }

    /* JADX INFO: renamed from: getJoining$ktor_io, reason: from getter */
    public final JoiningState getJoining() {
        return this.joining;
    }

    @Override // io.ktor.utils.p098io.ByteChannel
    public void attachJob(Job job) {
        Intrinsics.checkNotNullParameter(job, "job");
        Job job2 = this.attachedJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.attachedJob = job;
        Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new Function1<Throwable, Unit>() { // from class: io.ktor.utils.io.ByteBufferChannel.attachJob.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ByteBufferChannel.this.attachedJob = null;
                if (th != null) {
                    ByteBufferChannel.this.cancel(th);
                }
            }
        }, 2, null);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public ByteOrder getReadByteOrder() {
        return this.readByteOrder;
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public void setReadByteOrder(ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(byteOrder, "<set-?>");
        this.readByteOrder = byteOrder;
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public ByteOrder getWriteByteOrder() {
        return this.writeByteOrder;
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public void setWriteByteOrder(ByteOrder newOrder) {
        Intrinsics.checkNotNullParameter(newOrder, "newOrder");
        if (this.writeByteOrder != newOrder) {
            this.writeByteOrder = newOrder;
            JoiningState joiningState = this.joining;
            ByteBufferChannel delegatedTo = joiningState == null ? null : joiningState.getDelegatedTo();
            if (delegatedTo == null) {
                return;
            }
            delegatedTo.setWriteByteOrder(newOrder);
        }
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public int getAvailableForRead() {
        return getState().capacity._availableForRead$internal;
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public int getAvailableForWrite() {
        return getState().capacity._availableForWrite$internal;
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public boolean isClosedForRead() {
        return getState() == ReadWriteBufferState.Terminated.INSTANCE && getClosed() != null;
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel, io.ktor.utils.p098io.ByteWriteChannel
    public boolean isClosedForWrite() {
        return getClosed() != null;
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public long getTotalBytesRead() {
        return this.totalBytesRead;
    }

    public void setTotalBytesRead$ktor_io(long j) {
        this.totalBytesRead = j;
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public long getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    public void setTotalBytesWritten$ktor_io(long j) {
        this.totalBytesWritten = j;
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel, io.ktor.utils.p098io.ByteWriteChannel
    public Throwable getClosedCause() {
        ClosedElement closed = getClosed();
        if (closed == null) {
            return null;
        }
        return closed.getCause();
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public boolean close(Throwable cause) {
        ClosedElement closedElement;
        JoiningState joiningState;
        if (getClosed() != null) {
            return false;
        }
        if (cause == null) {
            closedElement = ClosedElement.INSTANCE.getEmptyCause();
        } else {
            closedElement = new ClosedElement(cause);
        }
        getState().capacity.flush();
        if (!C0526xc40028dd.m1169m(_closed$FU, this, null, closedElement)) {
            return false;
        }
        getState().capacity.flush();
        if (getState().capacity.isEmpty() || cause != null) {
            tryTerminate$ktor_io();
        }
        resumeClosed(cause);
        if (getState() == ReadWriteBufferState.Terminated.INSTANCE && (joiningState = this.joining) != null) {
            ensureClosedJoined(joiningState);
        }
        if (cause != null) {
            Job job = this.attachedJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.readSuspendContinuationCache.close(cause);
            this.writeSuspendContinuationCache.close(cause);
            return true;
        }
        this.writeSuspendContinuationCache.close(new ClosedWriteChannelException(ByteBufferChannelKt.DEFAULT_CLOSE_MESSAGE));
        this.readSuspendContinuationCache.close(Boolean.valueOf(getState().capacity.flush()));
        return true;
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public boolean cancel(Throwable cause) {
        if (cause == null) {
            cause = new CancellationException("Channel has been cancelled");
        }
        return close(cause);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushImpl(int minWriteSize) {
        ReadWriteBufferState state;
        ByteBufferChannel delegatedTo;
        JoiningState joiningState = this.joining;
        if (joiningState != null && (delegatedTo = joiningState.getDelegatedTo()) != null) {
            delegatedTo.flush();
        }
        do {
            state = getState();
            if (state == ReadWriteBufferState.Terminated.INSTANCE) {
                return;
            } else {
                state.capacity.flush();
            }
        } while (state != getState());
        int i = state.capacity._availableForWrite$internal;
        if (state.capacity._availableForRead$internal >= 1) {
            resumeReadOp();
        }
        JoiningState joiningState2 = this.joining;
        if (i >= minWriteSize) {
            if (joiningState2 == null || getState() == ReadWriteBufferState.Terminated.INSTANCE) {
                resumeWriteOp();
            }
        }
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public void flush() {
        flushImpl(1);
    }

    public final void prepareWriteBuffer$ktor_io(ByteBuffer buffer, int lockedSpace) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        prepareBuffer(buffer, getWriteByteOrder(), this.writePosition, lockedSpace);
    }

    private final void prepareBuffer(ByteBuffer byteBuffer, ByteOrder byteOrder, int i, int i2) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int iCapacity = byteBuffer.capacity() - this.reservedSize;
        byteBuffer.order(byteOrder.getNioOrder());
    }

    public final ByteBuffer setupStateForWrite$ktor_io() throws Throwable {
        Object obj;
        ReadWriteBufferState readWriteBufferState;
        ReadWriteBufferState.Writing writingStartWriting$ktor_io;
        Continuation<Unit> writeOp = getWriteOp();
        if (writeOp != null) {
            throw new IllegalStateException(Intrinsics.stringPlus("Write operation is already in progress: ", writeOp));
        }
        ReadWriteBufferState readWriteBufferState2 = null;
        ReadWriteBufferState.Initial initialNewBuffer = null;
        do {
            obj = this._state;
            readWriteBufferState = (ReadWriteBufferState) obj;
            if (this.joining != null) {
                if (initialNewBuffer != null) {
                    releaseBuffer(initialNewBuffer);
                }
                return null;
            }
            if (getClosed() != null) {
                if (initialNewBuffer != null) {
                    releaseBuffer(initialNewBuffer);
                }
                ClosedElement closed = getClosed();
                Intrinsics.checkNotNull(closed);
                ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                throw new KotlinNothingValueException();
            }
            if (readWriteBufferState == ReadWriteBufferState.IdleEmpty.INSTANCE) {
                if (initialNewBuffer == null) {
                    initialNewBuffer = newBuffer();
                }
                writingStartWriting$ktor_io = initialNewBuffer.startWriting$ktor_io();
            } else {
                if (readWriteBufferState == ReadWriteBufferState.Terminated.INSTANCE) {
                    if (initialNewBuffer != null) {
                        releaseBuffer(initialNewBuffer);
                    }
                    if (this.joining != null) {
                        return null;
                    }
                    ClosedElement closed2 = getClosed();
                    Intrinsics.checkNotNull(closed2);
                    ByteBufferChannelKt.rethrowClosed(closed2.getSendException());
                    throw new KotlinNothingValueException();
                }
                writingStartWriting$ktor_io = readWriteBufferState.startWriting$ktor_io();
            }
        } while (!C0526xc40028dd.m1169m(_state$FU, this, obj, writingStartWriting$ktor_io));
        if (getClosed() != null) {
            restoreStateAfterWrite$ktor_io();
            tryTerminate$ktor_io();
            ClosedElement closed3 = getClosed();
            Intrinsics.checkNotNull(closed3);
            ByteBufferChannelKt.rethrowClosed(closed3.getSendException());
            throw new KotlinNothingValueException();
        }
        ByteBuffer writeBuffer = writingStartWriting$ktor_io.getWriteBuffer();
        if (initialNewBuffer != null) {
            if (readWriteBufferState == null) {
                Intrinsics.throwUninitializedPropertyAccessException("old");
            } else {
                readWriteBufferState2 = readWriteBufferState;
            }
            if (readWriteBufferState2 != ReadWriteBufferState.IdleEmpty.INSTANCE) {
                releaseBuffer(initialNewBuffer);
            }
        }
        prepareBuffer(writeBuffer, getWriteByteOrder(), this.writePosition, writingStartWriting$ktor_io.capacity._availableForWrite$internal);
        return writeBuffer;
    }

    private final JoiningState setupDelegateTo(ByteBufferChannel delegate, boolean delegateClose) {
        if (!(this != delegate)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        JoiningState joiningState = new JoiningState(delegate, delegateClose);
        delegate.setWriteByteOrder(getWriteByteOrder());
        this.joining = joiningState;
        ClosedElement closed = getClosed();
        if (closed == null) {
            flush();
            return joiningState;
        }
        if (closed.getCause() != null) {
            delegate.close(closed.getCause());
        } else if (delegateClose && getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            ByteWriteChannelKt.close(delegate);
        } else {
            delegate.flush();
        }
        return joiningState;
    }

    private final boolean tryCompleteJoining(JoiningState joined) {
        if (!tryReleaseBuffer(true)) {
            return false;
        }
        ensureClosedJoined(joined);
        Continuation continuation = (Continuation) _readOp$FU.getAndSet(this, null);
        if (continuation != null) {
            IllegalStateException illegalStateException = new IllegalStateException("Joining is in progress");
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m7233constructorimpl(ResultKt.createFailure(illegalStateException)));
        }
        resumeWriteOp();
        return true;
    }

    public final boolean tryTerminate$ktor_io() {
        if (getClosed() == null || !tryReleaseBuffer(false)) {
            return false;
        }
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            ensureClosedJoined(joiningState);
        }
        resumeReadOp();
        resumeWriteOp();
        return true;
    }

    private final int carryIndex(ByteBuffer byteBuffer, int i) {
        return i >= byteBuffer.capacity() - this.reservedSize ? i - (byteBuffer.capacity() - this.reservedSize) : i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void writing(kotlin.jvm.functions.Function3<? super io.ktor.utils.p098io.ByteBufferChannel, ? super java.nio.ByteBuffer, ? super io.ktor.utils.p098io.internal.RingBufferCapacity, kotlin.Unit> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            io.ktor.utils.io.internal.JoiningState r0 = access$getJoining$p(r8)
            if (r0 != 0) goto L7
            goto Ld
        L7:
            io.ktor.utils.io.ByteBufferChannel r0 = access$resolveDelegation(r8, r8, r0)
            if (r0 != 0) goto Le
        Ld:
            r0 = r8
        Le:
            java.nio.ByteBuffer r1 = r0.setupStateForWrite$ktor_io()
            if (r1 != 0) goto L15
            return
        L15:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = access$getState(r0)
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.capacity
            long r3 = r0.getTotalBytesWritten()
            r5 = 1
            io.ktor.utils.io.internal.ClosedElement r6 = access$getClosed(r0)     // Catch: java.lang.Throwable -> L61
            if (r6 != 0) goto L54
            r9.invoke(r0, r1, r2)     // Catch: java.lang.Throwable -> L61
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            boolean r9 = r2.isFull()
            if (r9 != 0) goto L38
            boolean r9 = r0.getAutoFlush()
            if (r9 == 0) goto L3b
        L38:
            r0.flush()
        L3b:
            if (r0 == r8) goto L4a
            long r1 = r8.getTotalBytesWritten()
            long r6 = r0.getTotalBytesWritten()
            long r6 = r6 - r3
            long r1 = r1 + r6
            r8.setTotalBytesWritten$ktor_io(r1)
        L4a:
            r0.restoreStateAfterWrite$ktor_io()
            r0.tryTerminate$ktor_io()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            return
        L54:
            java.lang.Throwable r9 = r6.getSendException()     // Catch: java.lang.Throwable -> L61
            io.ktor.utils.p098io.ByteBufferChannelKt.access$rethrowClosed(r9)     // Catch: java.lang.Throwable -> L61
            kotlin.KotlinNothingValueException r9 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L61
            r9.<init>()     // Catch: java.lang.Throwable -> L61
            throw r9     // Catch: java.lang.Throwable -> L61
        L61:
            r9 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            boolean r1 = r2.isFull()
            if (r1 != 0) goto L71
            boolean r1 = r0.getAutoFlush()
            if (r1 == 0) goto L74
        L71:
            r0.flush()
        L74:
            if (r0 == r8) goto L83
            long r1 = r8.getTotalBytesWritten()
            long r6 = r0.getTotalBytesWritten()
            long r6 = r6 - r3
            long r1 = r1 + r6
            r8.setTotalBytesWritten$ktor_io(r1)
        L83:
            r0.restoreStateAfterWrite$ktor_io()
            r0.tryTerminate$ktor_io()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writing(kotlin.jvm.functions.Function3):void");
    }

    private final boolean reading(Function2<? super ByteBuffer, ? super RingBufferCapacity, Boolean> block) throws Throwable {
        ByteBuffer byteBuffer = setupStateForRead();
        if (byteBuffer == null) {
            return false;
        }
        RingBufferCapacity ringBufferCapacity = getState().capacity;
        try {
            if (ringBufferCapacity._availableForRead$internal == 0) {
                return false;
            }
            return block.invoke(byteBuffer, ringBufferCapacity).booleanValue();
        } finally {
            InlineMarker.finallyStart(1);
            restoreStateAfterRead();
            tryTerminate$ktor_io();
            InlineMarker.finallyEnd(1);
        }
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public final Object readFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) throws Throwable {
        int asMuchAsPossible = readAsMuchAsPossible(bArr, i, i2);
        if (asMuchAsPossible < i2) {
            Object fullySuspend = readFullySuspend(bArr, i + asMuchAsPossible, i2 - asMuchAsPossible, continuation);
            return fullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fullySuspend : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public final Object readFully(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) throws Throwable {
        int asMuchAsPossible = readAsMuchAsPossible(byteBuffer);
        return !byteBuffer.hasRemaining() ? Boxing.boxInt(asMuchAsPossible) : readFullySuspend(byteBuffer, asMuchAsPossible, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0055 -> B:21:0x0058). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readFullySuspend(java.nio.ByteBuffer r6, int r7, kotlin.coroutines.Continuation<? super java.lang.Integer> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52311
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52311) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.p098io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L58
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.ResultKt.throwOnFailure(r8)
            r2 = r5
        L40:
            boolean r8 = r6.hasRemaining()
            if (r8 == 0) goto L88
            r0.L$0 = r2
            r0.L$1 = r6
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r8 = r2.readSuspend(r3, r0)
            if (r8 != r1) goto L55
            return r1
        L55:
            r4 = r7
            r7 = r6
            r6 = r4
        L58:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L69
            int r8 = r2.readAsMuchAsPossible(r7)
            int r6 = r6 + r8
            r4 = r7
            r7 = r6
            r6 = r4
            goto L40
        L69:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r6 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "Unexpected EOF: expected "
            r8.<init>(r0)
            int r7 = r7.remaining()
            java.lang.StringBuilder r7 = r8.append(r7)
            java.lang.String r8 = " more bytes"
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L88:
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readFullySuspend(java.nio.ByteBuffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readFully$suspendImpl(ByteBufferChannel byteBufferChannel, IoBuffer ioBuffer, int i, Continuation continuation) throws Throwable {
        int asMuchAsPossible$default = readAsMuchAsPossible$default(byteBufferChannel, ioBuffer, 0, i, 2, null);
        if (asMuchAsPossible$default == i) {
            return Unit.INSTANCE;
        }
        Object fullySuspend = byteBufferChannel.readFullySuspend(ioBuffer, i - asMuchAsPossible$default, (Continuation<? super Unit>) continuation);
        return fullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fullySuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0064 -> B:22:0x0069). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readFullySuspend(io.ktor.utils.p098io.core.IoBuffer r13, int r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r15 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52322
            if (r0 == 0) goto L14
            r0 = r15
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$2 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52322) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$2 r0 = new io.ktor.utils.io.ByteBufferChannel$readFullySuspend$2
            r0.<init>(r15)
        L19:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            int r13 = r0.I$1
            int r14 = r0.I$0
            java.lang.Object r2 = r0.L$1
            io.ktor.utils.io.core.IoBuffer r2 = (io.ktor.utils.p098io.core.IoBuffer) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.p098io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r15)
            r10 = r4
            goto L69
        L37:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3f:
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = 0
            r4 = r12
        L44:
            r2 = r13
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.p098io.core.Buffer) r2
            int r5 = r2.getLimit()
            int r2 = r2.getWritePosition()
            if (r5 <= r2) goto L9d
            if (r15 >= r14) goto L9d
            r0.L$0 = r4
            r0.L$1 = r13
            r0.I$0 = r14
            r0.I$1 = r15
            r0.label = r3
            java.lang.Object r2 = r4.readSuspend(r3, r0)
            if (r2 != r1) goto L64
            return r1
        L64:
            r10 = r4
            r11 = r2
            r2 = r13
            r13 = r15
            r15 = r11
        L69:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L81
            r5 = r2
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.p098io.core.Buffer) r5
            int r7 = r14 - r13
            r8 = 2
            r9 = 0
            r6 = 0
            r4 = r10
            int r15 = readAsMuchAsPossible$default(r4, r5, r6, r7, r8, r9)
            int r15 = r15 + r13
            r13 = r2
            goto L44
        L81:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r15 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unexpected EOF: expected "
            r0.<init>(r1)
            int r14 = r14 - r13
            java.lang.StringBuilder r13 = r0.append(r14)
            java.lang.String r14 = " more bytes"
            java.lang.StringBuilder r13 = r13.append(r14)
            java.lang.String r13 = r13.toString()
            r15.<init>(r13)
            throw r15
        L9d:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readFullySuspend(io.ktor.utils.io.core.IoBuffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0058 -> B:19:0x005f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readFullySuspend(byte[] r8, int r9, int r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r11 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52333
            if (r0 == 0) goto L14
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52333) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            int r8 = r0.I$2
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            byte[] r2 = (byte[]) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.p098io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r11)
            goto L5f
        L38:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L40:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 0
            r4 = r7
        L45:
            r0.L$0 = r4
            r0.L$1 = r8
            r0.I$0 = r9
            r0.I$1 = r10
            r0.I$2 = r11
            r0.label = r3
            java.lang.Object r2 = r4.readSuspend(r3, r0)
            if (r2 != r1) goto L58
            return r1
        L58:
            r5 = r2
            r2 = r8
            r8 = r11
            r11 = r5
            r6 = r10
            r10 = r9
            r9 = r6
        L5f:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L77
            int r10 = r10 + r8
            int r8 = r9 - r8
            int r11 = r4.readAsMuchAsPossible(r2, r10, r8)
            if (r11 < r8) goto L73
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L73:
            r9 = r10
            r10 = r8
            r8 = r2
            goto L45
        L77:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r8 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Unexpected EOF: expected "
            r10.<init>(r11)
            java.lang.StringBuilder r9 = r10.append(r9)
            java.lang.String r10 = " more bytes"
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readFullySuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, byte[] bArr, int i, int i2, Continuation continuation) throws Throwable {
        int asMuchAsPossible = byteBufferChannel.readAsMuchAsPossible(bArr, i, i2);
        if (asMuchAsPossible == 0 && byteBufferChannel.getClosed() != null) {
            asMuchAsPossible = byteBufferChannel.getState().capacity.flush() ? byteBufferChannel.readAsMuchAsPossible(bArr, i, i2) : -1;
        } else if (asMuchAsPossible <= 0 && i2 != 0) {
            return byteBufferChannel.readAvailableSuspend(bArr, i, i2, continuation);
        }
        return Boxing.boxInt(asMuchAsPossible);
    }

    static /* synthetic */ Object readAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, ByteBuffer byteBuffer, Continuation continuation) throws Throwable {
        int asMuchAsPossible = byteBufferChannel.readAsMuchAsPossible(byteBuffer);
        if (asMuchAsPossible == 0 && byteBufferChannel.getClosed() != null) {
            asMuchAsPossible = byteBufferChannel.getState().capacity.flush() ? byteBufferChannel.readAsMuchAsPossible(byteBuffer) : -1;
        } else if (asMuchAsPossible <= 0 && byteBuffer.hasRemaining()) {
            return byteBufferChannel.readAvailableSuspend(byteBuffer, (Continuation<? super Integer>) continuation);
        }
        return Boxing.boxInt(asMuchAsPossible);
    }

    static /* synthetic */ Object readAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, IoBuffer ioBuffer, Continuation continuation) {
        IoBuffer ioBuffer2 = ioBuffer;
        int asMuchAsPossible$default = readAsMuchAsPossible$default(byteBufferChannel, ioBuffer2, 0, 0, 6, null);
        if (asMuchAsPossible$default == 0 && byteBufferChannel.getClosed() != null) {
            asMuchAsPossible$default = byteBufferChannel.getState().capacity.flush() ? readAsMuchAsPossible$default(byteBufferChannel, ioBuffer2, 0, 0, 6, null) : -1;
        } else if (asMuchAsPossible$default <= 0 && ioBuffer2.getLimit() > ioBuffer2.getWritePosition()) {
            return byteBufferChannel.readAvailableSuspend(ioBuffer, (Continuation<? super Integer>) continuation);
        }
        return Boxing.boxInt(asMuchAsPossible$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readAvailableSuspend(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation<? super java.lang.Integer> r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52231
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52231) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L76
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            int r8 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r6 = r0.L$1
            byte[] r6 = (byte[]) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.p098io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5a
        L45:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r9 = r5.readSuspend(r4, r0)
            if (r9 != r1) goto L59
            return r1
        L59:
            r2 = r5
        L5a:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L68
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L68:
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r9 = r2.readAvailable(r6, r7, r8, r0)
            if (r9 != r1) goto L76
            return r1
        L76:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readAvailableSuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readAvailableSuspend(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52242
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52242) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6e
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.p098io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L52
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.readSuspend(r4, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            r2 = r5
        L52:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L60
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L60:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r2.readAvailable(r6, r0)
            if (r7 != r1) goto L6e
            return r1
        L6e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readAvailableSuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readAvailableSuspend(io.ktor.utils.p098io.core.IoBuffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52253
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52253) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6e
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.core.IoBuffer r6 = (io.ktor.utils.p098io.core.IoBuffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.p098io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L52
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.readSuspend(r4, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            r2 = r5
        L52:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L60
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L60:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r2.readAvailable(r6, r0)
            if (r7 != r1) goto L6e
            return r1
        L6e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readAvailableSuspend(io.ktor.utils.io.core.IoBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readPacket$suspendImpl(ByteBufferChannel byteBufferChannel, int i, int i2, Continuation continuation) throws Throwable {
        Throwable cause;
        ClosedElement closed = byteBufferChannel.getClosed();
        if (closed != null && (cause = closed.getCause()) != null) {
            ByteBufferChannelKt.rethrowClosed(cause);
            throw new KotlinNothingValueException();
        }
        if (i == 0) {
            return ByteReadPacket.INSTANCE.getEmpty();
        }
        BytePacketBuilder BytePacketBuilder = PacketJVMKt.BytePacketBuilder(i2);
        ByteBuffer byteBufferBorrow = ObjectPoolKt.getBufferPool().borrow();
        while (i > 0) {
            try {
                if (byteBufferBorrow.remaining() > i) {
                }
                int asMuchAsPossible = byteBufferChannel.readAsMuchAsPossible(byteBufferBorrow);
                if (asMuchAsPossible == 0) {
                    break;
                }
                OutputArraysJVMKt.writeFully(BytePacketBuilder, byteBufferBorrow);
                i -= asMuchAsPossible;
            } catch (Throwable th) {
                ObjectPoolKt.getBufferPool().recycle(byteBufferBorrow);
                BytePacketBuilder.release();
                throw th;
            }
        }
        if (i == 0) {
            ObjectPoolKt.getBufferPool().recycle(byteBufferBorrow);
            return BytePacketBuilder.build();
        }
        return byteBufferChannel.readPacketSuspend(i, BytePacketBuilder, byteBufferBorrow, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b A[Catch: all -> 0x008e, TRY_ENTER, TryCatch #2 {all -> 0x008e, blocks: (B:26:0x006e, B:20:0x004b, B:22:0x0057, B:23:0x005d, B:27:0x0082), top: B:41:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082 A[Catch: all -> 0x008e, TRY_LEAVE, TryCatch #2 {all -> 0x008e, blocks: (B:26:0x006e, B:20:0x004b, B:22:0x0057, B:23:0x005d, B:27:0x0082), top: B:41:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006b -> B:41:0x006e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readPacketSuspend(int r7, io.ktor.utils.p098io.core.BytePacketBuilder r8, java.nio.ByteBuffer r9, kotlin.coroutines.Continuation<? super io.ktor.utils.p098io.core.ByteReadPacket> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52361
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52361) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            int r7 = r0.I$0
            java.lang.Object r8 = r0.L$2
            java.nio.ByteBuffer r8 = (java.nio.ByteBuffer) r8
            java.lang.Object r9 = r0.L$1
            io.ktor.utils.io.core.BytePacketBuilder r9 = (io.ktor.utils.p098io.core.BytePacketBuilder) r9
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.p098io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L3b
            r5 = r9
            r9 = r8
            r8 = r5
            goto L6e
        L3b:
            r7 = move-exception
            goto L92
        L3d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L45:
            kotlin.ResultKt.throwOnFailure(r10)
            r2 = r6
        L49:
            if (r7 <= 0) goto L82
            java.nio.Buffer r10 = r9.clear()     // Catch: java.lang.Throwable -> L8e
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10     // Catch: java.lang.Throwable -> L8e
            int r10 = r9.remaining()     // Catch: java.lang.Throwable -> L8e
            if (r10 <= r7) goto L5d
            java.nio.Buffer r10 = r9.limit(r7)     // Catch: java.lang.Throwable -> L8e
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10     // Catch: java.lang.Throwable -> L8e
        L5d:
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L8e
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L8e
            r0.L$2 = r9     // Catch: java.lang.Throwable -> L8e
            r0.I$0 = r7     // Catch: java.lang.Throwable -> L8e
            r0.label = r3     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r10 = r2.readFully(r9, r0)     // Catch: java.lang.Throwable -> L8e
            if (r10 != r1) goto L6e
            return r1
        L6e:
            java.lang.Number r10 = (java.lang.Number) r10     // Catch: java.lang.Throwable -> L8e
            int r10 = r10.intValue()     // Catch: java.lang.Throwable -> L8e
            java.nio.Buffer r4 = r9.flip()     // Catch: java.lang.Throwable -> L8e
            java.nio.ByteBuffer r4 = (java.nio.ByteBuffer) r4     // Catch: java.lang.Throwable -> L8e
            r4 = r8
            io.ktor.utils.io.core.Output r4 = (io.ktor.utils.p098io.core.Output) r4     // Catch: java.lang.Throwable -> L8e
            io.ktor.utils.p098io.core.OutputArraysJVMKt.writeFully(r4, r9)     // Catch: java.lang.Throwable -> L8e
            int r7 = r7 - r10
            goto L49
        L82:
            io.ktor.utils.io.core.ByteReadPacket r7 = r8.build()     // Catch: java.lang.Throwable -> L8e
            io.ktor.utils.io.pool.ObjectPool r8 = io.ktor.utils.p098io.internal.ObjectPoolKt.getBufferPool()
            r8.recycle(r9)
            return r7
        L8e:
            r7 = move-exception
            r5 = r9
            r9 = r8
            r8 = r5
        L92:
            r9.release()     // Catch: java.lang.Throwable -> L96
            throw r7     // Catch: java.lang.Throwable -> L96
        L96:
            r7 = move-exception
            io.ktor.utils.io.pool.ObjectPool r9 = io.ktor.utils.p098io.internal.ObjectPoolKt.getBufferPool()
            r9.recycle(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readPacketSuspend(int, io.ktor.utils.io.core.BytePacketBuilder, java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.utils.p098io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readBoolean(kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52271
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ByteBufferChannel$readBoolean$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52271) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$readBoolean$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readBoolean$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3e
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.Object r5 = r4.readByte(r0)
            if (r5 != r1) goto L3e
            return r1
        L3e:
            java.lang.Number r5 = (java.lang.Number) r5
            byte r5 = r5.byteValue()
            if (r5 == 0) goto L47
            goto L48
        L47:
            r3 = 0
        L48:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readBoolean(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Path cross not found for [B:17:0x0046, B:18:0x0048], limit reached: 49 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0095 -> B:39:0x0098). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.p098io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readByte(kotlin.coroutines.Continuation<? super java.lang.Byte> r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52281
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readByte$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52281) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$readByte$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readByte$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.p098io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r10)
            goto L98
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L39:
            kotlin.ResultKt.throwOnFailure(r10)
            r4 = r9
            r2 = r3
        L3e:
            java.nio.ByteBuffer r10 = access$setupStateForRead(r4)
            r5 = 0
            r6 = 0
            if (r10 != 0) goto L48
        L46:
            r10 = r5
            goto L7d
        L48:
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = access$getState(r4)
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.capacity
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> Lbc
            if (r8 != 0) goto L59
            access$restoreStateAfterRead(r4)
            r4.tryTerminate$ktor_io()
            goto L46
        L59:
            boolean r8 = r7.tryReadExact(r2)     // Catch: java.lang.Throwable -> Lbc
            if (r8 != 0) goto L61
            r10 = r5
            goto L77
        L61:
            int r6 = r10.remaining()     // Catch: java.lang.Throwable -> Lbc
            if (r6 >= r2) goto L6a
            access$rollBytes(r4, r10, r2)     // Catch: java.lang.Throwable -> Lbc
        L6a:
            byte r6 = r10.get()     // Catch: java.lang.Throwable -> Lbc
            java.lang.Byte r6 = kotlin.coroutines.jvm.internal.Boxing.boxByte(r6)     // Catch: java.lang.Throwable -> Lbc
            access$bytesRead(r4, r10, r7, r2)     // Catch: java.lang.Throwable -> Lbc
            r10 = r6
            r6 = r3
        L77:
            access$restoreStateAfterRead(r4)
            r4.tryTerminate$ktor_io()
        L7d:
            if (r6 == 0) goto L8b
            if (r10 != 0) goto L87
            java.lang.String r10 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            goto L8a
        L87:
            r5 = r10
            java.lang.Number r5 = (java.lang.Number) r5
        L8a:
            return r5
        L8b:
            r0.L$0 = r4
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r10 = access$readSuspend(r4, r2, r0)
            if (r10 != r1) goto L98
            return r1
        L98:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto La1
            goto L3e
        La1:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r10 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "EOF while "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r1 = " bytes expected"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        Lbc:
            r10 = move-exception
            access$restoreStateAfterRead(r4)
            r4.tryTerminate$ktor_io()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readByte(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Path cross not found for [B:17:0x0047, B:18:0x0049], limit reached: 49 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0096 -> B:39:0x0099). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.p098io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readShort(kotlin.coroutines.Continuation<? super java.lang.Short> r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52391
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readShort$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52391) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$readShort$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readShort$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.p098io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r10)
            goto L99
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L39:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = 2
            r4 = r9
            r2 = r10
        L3f:
            java.nio.ByteBuffer r10 = access$setupStateForRead(r4)
            r5 = 0
            r6 = 0
            if (r10 != 0) goto L49
        L47:
            r10 = r5
            goto L7e
        L49:
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = access$getState(r4)
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.capacity
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> Lbd
            if (r8 != 0) goto L5a
            access$restoreStateAfterRead(r4)
            r4.tryTerminate$ktor_io()
            goto L47
        L5a:
            boolean r8 = r7.tryReadExact(r2)     // Catch: java.lang.Throwable -> Lbd
            if (r8 != 0) goto L62
            r10 = r5
            goto L78
        L62:
            int r6 = r10.remaining()     // Catch: java.lang.Throwable -> Lbd
            if (r6 >= r2) goto L6b
            access$rollBytes(r4, r10, r2)     // Catch: java.lang.Throwable -> Lbd
        L6b:
            short r6 = r10.getShort()     // Catch: java.lang.Throwable -> Lbd
            java.lang.Short r6 = kotlin.coroutines.jvm.internal.Boxing.boxShort(r6)     // Catch: java.lang.Throwable -> Lbd
            access$bytesRead(r4, r10, r7, r2)     // Catch: java.lang.Throwable -> Lbd
            r10 = r6
            r6 = r3
        L78:
            access$restoreStateAfterRead(r4)
            r4.tryTerminate$ktor_io()
        L7e:
            if (r6 == 0) goto L8c
            if (r10 != 0) goto L88
            java.lang.String r10 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            goto L8b
        L88:
            r5 = r10
            java.lang.Number r5 = (java.lang.Number) r5
        L8b:
            return r5
        L8c:
            r0.L$0 = r4
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r10 = access$readSuspend(r4, r2, r0)
            if (r10 != r1) goto L99
            return r1
        L99:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto La2
            goto L3f
        La2:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r10 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "EOF while "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r1 = " bytes expected"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        Lbd:
            r10 = move-exception
            access$restoreStateAfterRead(r4)
            r4.tryTerminate$ktor_io()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readShort(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Path cross not found for [B:17:0x0047, B:18:0x0049], limit reached: 49 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0096 -> B:39:0x0099). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.p098io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readInt(kotlin.coroutines.Continuation<? super java.lang.Integer> r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52341
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readInt$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52341) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$readInt$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readInt$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.p098io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r10)
            goto L99
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L39:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = 4
            r4 = r9
            r2 = r10
        L3f:
            java.nio.ByteBuffer r10 = access$setupStateForRead(r4)
            r5 = 0
            r6 = 0
            if (r10 != 0) goto L49
        L47:
            r10 = r5
            goto L7e
        L49:
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = access$getState(r4)
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.capacity
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> Lbd
            if (r8 != 0) goto L5a
            access$restoreStateAfterRead(r4)
            r4.tryTerminate$ktor_io()
            goto L47
        L5a:
            boolean r8 = r7.tryReadExact(r2)     // Catch: java.lang.Throwable -> Lbd
            if (r8 != 0) goto L62
            r10 = r5
            goto L78
        L62:
            int r6 = r10.remaining()     // Catch: java.lang.Throwable -> Lbd
            if (r6 >= r2) goto L6b
            access$rollBytes(r4, r10, r2)     // Catch: java.lang.Throwable -> Lbd
        L6b:
            int r6 = r10.getInt()     // Catch: java.lang.Throwable -> Lbd
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)     // Catch: java.lang.Throwable -> Lbd
            access$bytesRead(r4, r10, r7, r2)     // Catch: java.lang.Throwable -> Lbd
            r10 = r6
            r6 = r3
        L78:
            access$restoreStateAfterRead(r4)
            r4.tryTerminate$ktor_io()
        L7e:
            if (r6 == 0) goto L8c
            if (r10 != 0) goto L88
            java.lang.String r10 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            goto L8b
        L88:
            r5 = r10
            java.lang.Number r5 = (java.lang.Number) r5
        L8b:
            return r5
        L8c:
            r0.L$0 = r4
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r10 = access$readSuspend(r4, r2, r0)
            if (r10 != r1) goto L99
            return r1
        L99:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto La2
            goto L3f
        La2:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r10 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "EOF while "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r1 = " bytes expected"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        Lbd:
            r10 = move-exception
            access$restoreStateAfterRead(r4)
            r4.tryTerminate$ktor_io()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readInt(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Path cross not found for [B:17:0x0048, B:18:0x004a], limit reached: 49 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0097 -> B:39:0x009a). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.p098io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readLong(kotlin.coroutines.Continuation<? super java.lang.Long> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52351
            if (r0 == 0) goto L14
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$readLong$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52351) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$readLong$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readLong$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.p098io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r11)
            goto L9a
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L39:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 8
            r4 = r10
            r2 = r11
        L40:
            java.nio.ByteBuffer r11 = access$setupStateForRead(r4)
            r5 = 0
            r6 = 0
            if (r11 != 0) goto L4a
        L48:
            r11 = r5
            goto L7f
        L4a:
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = access$getState(r4)
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.capacity
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> Lbe
            if (r8 != 0) goto L5b
            access$restoreStateAfterRead(r4)
            r4.tryTerminate$ktor_io()
            goto L48
        L5b:
            boolean r8 = r7.tryReadExact(r2)     // Catch: java.lang.Throwable -> Lbe
            if (r8 != 0) goto L63
            r11 = r5
            goto L79
        L63:
            int r6 = r11.remaining()     // Catch: java.lang.Throwable -> Lbe
            if (r6 >= r2) goto L6c
            access$rollBytes(r4, r11, r2)     // Catch: java.lang.Throwable -> Lbe
        L6c:
            long r8 = r11.getLong()     // Catch: java.lang.Throwable -> Lbe
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)     // Catch: java.lang.Throwable -> Lbe
            access$bytesRead(r4, r11, r7, r2)     // Catch: java.lang.Throwable -> Lbe
            r11 = r6
            r6 = r3
        L79:
            access$restoreStateAfterRead(r4)
            r4.tryTerminate$ktor_io()
        L7f:
            if (r6 == 0) goto L8d
            if (r11 != 0) goto L89
            java.lang.String r11 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            goto L8c
        L89:
            r5 = r11
            java.lang.Number r5 = (java.lang.Number) r5
        L8c:
            return r5
        L8d:
            r0.L$0 = r4
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r11 = access$readSuspend(r4, r2, r0)
            if (r11 != r1) goto L9a
            return r1
        L9a:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto La3
            goto L40
        La3:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r11 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "EOF while "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r1 = " bytes expected"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        Lbe:
            r11 = move-exception
            access$restoreStateAfterRead(r4)
            r4.tryTerminate$ktor_io()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readLong(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Path cross not found for [B:17:0x0047, B:18:0x0049], limit reached: 49 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00a2 -> B:40:0x00a5). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.p098io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readFloat(kotlin.coroutines.Continuation<? super java.lang.Float> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readFloat(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Path cross not found for [B:17:0x0048, B:18:0x004a], limit reached: 49 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00a3 -> B:40:0x00a6). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.p098io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readDouble(kotlin.coroutines.Continuation<? super java.lang.Double> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readDouble(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rollBytes(ByteBuffer byteBuffer, int i) {
        int iRemaining = byteBuffer.remaining();
        int i2 = i - iRemaining;
        if (i2 <= 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            byteBuffer.put(byteBuffer.capacity() + ReservedLongIndex + i3, byteBuffer.get(i3));
            if (i4 >= i2) {
                return;
            } else {
                i3 = i4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void carry(ByteBuffer byteBuffer) {
        int iCapacity = byteBuffer.capacity() - this.reservedSize;
        int iPosition = byteBuffer.position();
        if (iCapacity >= iPosition) {
            return;
        }
        int i = iCapacity;
        while (true) {
            int i2 = i + 1;
            byteBuffer.put(i - iCapacity, byteBuffer.get(i));
            if (i2 >= iPosition) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public final void bytesWrittenFromSession$ktor_io(ByteBuffer buffer, RingBufferCapacity capacity, int count) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(capacity, "capacity");
        bytesWritten(buffer, capacity, count);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bytesWritten(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.writePosition = carryIndex(byteBuffer, this.writePosition + i);
        ringBufferCapacity.completeWrite(i);
        setTotalBytesWritten$ktor_io(getTotalBytesWritten() + ((long) i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bytesRead(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.readPosition = carryIndex(byteBuffer, this.readPosition + i);
        ringBufferCapacity.completeRead(i);
        setTotalBytesRead$ktor_io(getTotalBytesRead() + ((long) i));
        resumeWriteOp();
    }

    public final ByteBufferChannel resolveChannelInstance$ktor_io() {
        ByteBufferChannel byteBufferChannelResolveDelegation;
        JoiningState joiningState = this.joining;
        return (joiningState == null || (byteBufferChannelResolveDelegation = resolveDelegation(this, joiningState)) == null) ? this : byteBufferChannelResolveDelegation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ByteBufferChannel resolveDelegation(ByteBufferChannel current, JoiningState joining) {
        while (current.getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            current = joining.getDelegatedTo();
            joining = current.joining;
            if (joining == null) {
                return current;
            }
        }
        return null;
    }

    private final Object delegateSuspend(JoiningState joiningState, Function1<? super ByteBufferChannel, Unit> function1, Continuation<? super Unit> continuation) throws Throwable {
        while (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
            InlineMarker.mark(0);
            writeSuspend(1, continuation);
            InlineMarker.mark(1);
        }
        function1.invoke(joiningState.getDelegatedTo());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Path cross not found for [B:23:0x0078, B:26:0x0081], limit reached: 105 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0141 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00f2 -> B:48:0x00f5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeByte$suspendImpl(io.ktor.utils.p098io.ByteBufferChannel r8, byte r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeByte$suspendImpl(io.ktor.utils.io.ByteBufferChannel, byte, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Path cross not found for [B:23:0x0078, B:26:0x0081], limit reached: 105 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00ef -> B:48:0x00f2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeShort$suspendImpl(io.ktor.utils.p098io.ByteBufferChannel r8, short r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeShort$suspendImpl(io.ktor.utils.io.ByteBufferChannel, short, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Path cross not found for [B:23:0x0079, B:26:0x0082], limit reached: 105 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00ee -> B:48:0x00f1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeInt$suspendImpl(io.ktor.utils.p098io.ByteBufferChannel r8, int r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeInt$suspendImpl(io.ktor.utils.io.ByteBufferChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Path cross not found for [B:23:0x007a, B:26:0x0083], limit reached: 105 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0140 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00f2 -> B:48:0x00f5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeLong$suspendImpl(io.ktor.utils.p098io.ByteBufferChannel r10, long r11, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeLong$suspendImpl(io.ktor.utils.io.ByteBufferChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object writeDouble$suspendImpl(ByteBufferChannel byteBufferChannel, double d, Continuation continuation) {
        Object objWriteLong = byteBufferChannel.writeLong(Double.doubleToRawLongBits(d), continuation);
        return objWriteLong == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteLong : Unit.INSTANCE;
    }

    static /* synthetic */ Object writeFloat$suspendImpl(ByteBufferChannel byteBufferChannel, float f, Continuation continuation) {
        Object objWriteInt = byteBufferChannel.writeInt(Float.floatToRawIntBits(f), continuation);
        return objWriteInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteInt : Unit.INSTANCE;
    }

    private final Object writePrimitive(int i, Function1<? super ByteBufferChannel, Unit> function1, Function1<? super ByteBuffer, Unit> function12, Continuation<? super Unit> continuation) throws Throwable {
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            ByteBufferChannel byteBufferChannelResolveDelegation = resolveDelegation(this, joiningState);
            if (byteBufferChannelResolveDelegation != null) {
                function1.invoke(byteBufferChannelResolveDelegation);
                return Unit.INSTANCE;
            }
        }
        ByteBuffer byteBuffer = setupStateForWrite$ktor_io();
        if (byteBuffer == null) {
            JoiningState joiningState2 = this.joining;
            Intrinsics.checkNotNull(joiningState2);
            if (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                while (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                    InlineMarker.mark(0);
                    writeSuspend(1, continuation);
                    InlineMarker.mark(1);
                }
                function1.invoke(joiningState2.getDelegatedTo());
            } else {
                function1.invoke(joiningState2.getDelegatedTo());
            }
            return Unit.INSTANCE;
        }
        RingBufferCapacity ringBufferCapacity = getState().capacity;
        if (ringBufferCapacity.tryWriteExact(i)) {
            prepareWriteBuffer$ktor_io(byteBuffer, i);
            if (byteBuffer.remaining() < i) {
                function12.invoke(byteBuffer);
                carry(byteBuffer);
            } else {
                function12.invoke(byteBuffer);
            }
            bytesWritten(byteBuffer, ringBufferCapacity, i);
            if (ringBufferCapacity.isFull() || getAutoFlush()) {
                flush();
            }
            restoreStateAfterWrite$ktor_io();
            tryTerminate$ktor_io();
            return Unit.INSTANCE;
        }
        while (true) {
            try {
                InlineMarker.mark(0);
                writeSuspend(i, continuation);
                InlineMarker.mark(1);
                if (this.joining != null) {
                    restoreStateAfterWrite$ktor_io();
                    JoiningState joiningState3 = this.joining;
                    Intrinsics.checkNotNull(joiningState3);
                    if (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                        while (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                            InlineMarker.mark(0);
                            writeSuspend(1, continuation);
                            InlineMarker.mark(1);
                        }
                        function1.invoke(joiningState3.getDelegatedTo());
                    } else {
                        function1.invoke(joiningState3.getDelegatedTo());
                    }
                } else if (ringBufferCapacity.tryWriteExact(i)) {
                    prepareWriteBuffer$ktor_io(byteBuffer, i);
                    if (byteBuffer.remaining() < i) {
                        function12.invoke(byteBuffer);
                        carry(byteBuffer);
                    } else {
                        function12.invoke(byteBuffer);
                    }
                    bytesWritten(byteBuffer, ringBufferCapacity, i);
                    if (ringBufferCapacity.isFull() || getAutoFlush()) {
                        flush();
                    }
                }
            } finally {
                restoreStateAfterWrite$ktor_io();
                tryTerminate$ktor_io();
            }
        }
        return Unit.INSTANCE;
    }

    private final boolean tryWritePrimitive(ByteBuffer byteBuffer, int i, RingBufferCapacity ringBufferCapacity, Function1<? super ByteBuffer, Unit> function1) {
        if (!ringBufferCapacity.tryWriteExact(i)) {
            return false;
        }
        prepareWriteBuffer$ktor_io(byteBuffer, i);
        if (byteBuffer.remaining() < i) {
            function1.invoke(byteBuffer);
            carry(byteBuffer);
        } else {
            function1.invoke(byteBuffer);
        }
        bytesWritten(byteBuffer, ringBufferCapacity, i);
        if (ringBufferCapacity.isFull() || getAutoFlush()) {
            flush();
        }
        restoreStateAfterWrite$ktor_io();
        tryTerminate$ktor_io();
        return true;
    }

    private final void doWritePrimitive(int size, ByteBuffer buffer, RingBufferCapacity capacity, Function1<? super ByteBuffer, Unit> writer) {
        if (buffer.remaining() < size) {
            writer.invoke(buffer);
            carry(buffer);
        } else {
            writer.invoke(buffer);
        }
        bytesWritten(buffer, capacity, size);
        if (capacity.isFull() || getAutoFlush()) {
            flush();
        }
        restoreStateAfterWrite$ktor_io();
        tryTerminate$ktor_io();
    }

    private final Object writeSuspendPrimitive(ByteBuffer byteBuffer, int i, RingBufferCapacity ringBufferCapacity, Function1<? super ByteBufferChannel, Unit> function1, Function1<? super ByteBuffer, Unit> function12, Continuation<? super Unit> continuation) throws Throwable {
        do {
            try {
                InlineMarker.mark(0);
                writeSuspend(i, continuation);
                InlineMarker.mark(1);
                if (this.joining != null) {
                    restoreStateAfterWrite$ktor_io();
                    JoiningState joiningState = this.joining;
                    Intrinsics.checkNotNull(joiningState);
                    if (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                        while (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                            InlineMarker.mark(0);
                            writeSuspend(1, continuation);
                            InlineMarker.mark(1);
                        }
                        function1.invoke(joiningState.getDelegatedTo());
                    } else {
                        function1.invoke(joiningState.getDelegatedTo());
                    }
                    return Unit.INSTANCE;
                }
            } catch (Throwable th) {
                restoreStateAfterWrite$ktor_io();
                tryTerminate$ktor_io();
                throw th;
            }
        } while (!ringBufferCapacity.tryWriteExact(i));
        prepareWriteBuffer$ktor_io(byteBuffer, i);
        if (byteBuffer.remaining() < i) {
            function12.invoke(byteBuffer);
            carry(byteBuffer);
        } else {
            function12.invoke(byteBuffer);
        }
        bytesWritten(byteBuffer, ringBufferCapacity, i);
        if (ringBufferCapacity.isFull() || getAutoFlush()) {
            flush();
        }
        restoreStateAfterWrite$ktor_io();
        tryTerminate$ktor_io();
        return Unit.INSTANCE;
    }

    private final Object delegatePrimitive(Function1<? super ByteBufferChannel, Unit> function1, Continuation<? super Unit> continuation) throws Throwable {
        JoiningState joiningState = this.joining;
        Intrinsics.checkNotNull(joiningState);
        if (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
            while (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                InlineMarker.mark(0);
                writeSuspend(1, continuation);
                InlineMarker.mark(1);
            }
            function1.invoke(joiningState.getDelegatedTo());
            return Unit.INSTANCE;
        }
        function1.invoke(joiningState.getDelegatedTo());
        return Unit.INSTANCE;
    }

    @ExperimentalIoApi
    static /* synthetic */ Object awaitFreeSpace$suspendImpl(ByteBufferChannel byteBufferChannel, Continuation continuation) throws Throwable {
        Object objWriteSuspend = byteBufferChannel.writeSuspend(1, continuation);
        return objWriteSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteSuspend : Unit.INSTANCE;
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, ByteBuffer byteBuffer, Continuation continuation) throws Throwable {
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
            ByteBufferChannel byteBufferChannelResolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState);
            if (byteBufferChannelResolveDelegation != null) {
                return byteBufferChannelResolveDelegation.writeAvailable(byteBuffer, (Continuation<? super Integer>) continuation);
            }
        }
        int iWriteAsMuchAsPossible = byteBufferChannel.writeAsMuchAsPossible(byteBuffer);
        if (iWriteAsMuchAsPossible > 0) {
            return Boxing.boxInt(iWriteAsMuchAsPossible);
        }
        JoiningState joiningState2 = byteBufferChannel.joining;
        if (joiningState2 != null) {
            ByteBufferChannel byteBufferChannelResolveDelegation2 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState2);
            if (byteBufferChannelResolveDelegation2 != null) {
                return byteBufferChannelResolveDelegation2.writeAvailableSuspend(byteBuffer, (Continuation<? super Integer>) continuation);
            }
        }
        return byteBufferChannel.writeAvailableSuspend(byteBuffer, (Continuation<? super Integer>) continuation);
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, IoBuffer ioBuffer, Continuation continuation) throws Throwable {
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
            ByteBufferChannel byteBufferChannelResolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState);
            if (byteBufferChannelResolveDelegation != null) {
                return byteBufferChannelResolveDelegation.writeAvailable(ioBuffer, (Continuation<? super Integer>) continuation);
            }
        }
        int iWriteAsMuchAsPossible = byteBufferChannel.writeAsMuchAsPossible(ioBuffer);
        if (iWriteAsMuchAsPossible > 0) {
            return Boxing.boxInt(iWriteAsMuchAsPossible);
        }
        JoiningState joiningState2 = byteBufferChannel.joining;
        if (joiningState2 != null) {
            ByteBufferChannel byteBufferChannelResolveDelegation2 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState2);
            if (byteBufferChannelResolveDelegation2 != null) {
                return byteBufferChannelResolveDelegation2.writeAvailableSuspend(ioBuffer, (Continuation<? super Integer>) continuation);
            }
        }
        return byteBufferChannel.writeAvailableSuspend(ioBuffer, (Continuation<? super Integer>) continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeAvailableSuspend(java.nio.ByteBuffer r7, kotlin.coroutines.Continuation<? super java.lang.Integer> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52471
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52471) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L48
            if (r2 == r5) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            kotlin.ResultKt.throwOnFailure(r8)
            goto L75
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L83
        L3c:
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.p098io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L59
        L48:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r8 = r6.writeSuspend(r5, r0)
            if (r8 != r1) goto L58
            return r1
        L58:
            r2 = r6
        L59:
            io.ktor.utils.io.internal.JoiningState r8 = r2.joining
            r5 = 0
            if (r8 != 0) goto L5f
            goto L68
        L5f:
            io.ktor.utils.io.ByteBufferChannel r8 = r2.resolveDelegation(r2, r8)
            if (r8 != 0) goto L76
            r8 = r5
            java.lang.Void r8 = (java.lang.Void) r8
        L68:
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r8 = r2.writeAvailable(r7, r0)
            if (r8 != r1) goto L75
            return r1
        L75:
            return r8
        L76:
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r4
            java.lang.Object r8 = r8.writeAvailableSuspend(r7, r0)
            if (r8 != r1) goto L83
            return r1
        L83:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeAvailableSuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeAvailableSuspend(io.ktor.utils.p098io.core.IoBuffer r7, kotlin.coroutines.Continuation<? super java.lang.Integer> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52483
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$3 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52483) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$3
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L48
            if (r2 == r5) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            kotlin.ResultKt.throwOnFailure(r8)
            goto L75
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L83
        L3c:
            java.lang.Object r7 = r0.L$1
            io.ktor.utils.io.core.IoBuffer r7 = (io.ktor.utils.p098io.core.IoBuffer) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.p098io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L59
        L48:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r8 = r6.writeSuspend(r5, r0)
            if (r8 != r1) goto L58
            return r1
        L58:
            r2 = r6
        L59:
            io.ktor.utils.io.internal.JoiningState r8 = r2.joining
            r5 = 0
            if (r8 != 0) goto L5f
            goto L68
        L5f:
            io.ktor.utils.io.ByteBufferChannel r8 = r2.resolveDelegation(r2, r8)
            if (r8 != 0) goto L76
            r8 = r5
            java.lang.Void r8 = (java.lang.Void) r8
        L68:
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r8 = r2.writeAvailable(r7, r0)
            if (r8 != r1) goto L75
            return r1
        L75:
            return r8
        L76:
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r4
            java.lang.Object r8 = r8.writeAvailableSuspend(r7, r0)
            if (r8 != r1) goto L83
            return r1
        L83:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeAvailableSuspend(io.ktor.utils.io.core.IoBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object writeFully$suspendImpl(ByteBufferChannel byteBufferChannel, ByteBuffer byteBuffer, Continuation continuation) throws Throwable {
        Object objWriteFullySuspend;
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
            ByteBufferChannel byteBufferChannelResolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState);
            if (byteBufferChannelResolveDelegation != null) {
                Object objWriteFully = byteBufferChannelResolveDelegation.writeFully(byteBuffer, (Continuation<? super Unit>) continuation);
                return objWriteFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteFully : Unit.INSTANCE;
            }
        }
        byteBufferChannel.writeAsMuchAsPossible(byteBuffer);
        return (byteBuffer.hasRemaining() && (objWriteFullySuspend = byteBufferChannel.writeFullySuspend(byteBuffer, (Continuation<? super Unit>) continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objWriteFullySuspend : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeFully$suspendImpl(io.ktor.utils.p098io.ByteBufferChannel r11, final io.ktor.utils.p098io.core.Buffer r12, kotlin.coroutines.Continuation r13) {
        /*
            boolean r0 = r13 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52503
            if (r0 == 0) goto L14
            r0 = r13
            io.ktor.utils.io.ByteBufferChannel$writeFully$3 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52503) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$writeFully$3 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFully$3
            r0.<init>(r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r11 = r0.L$1
            io.ktor.utils.io.core.Buffer r11 = (io.ktor.utils.p098io.core.Buffer) r11
            java.lang.Object r12 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r12 = (io.ktor.utils.p098io.ByteBufferChannel) r12
            kotlin.ResultKt.throwOnFailure(r13)
            r10 = r12
            r12 = r11
            r11 = r10
            goto L40
        L35:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3d:
            kotlin.ResultKt.throwOnFailure(r13)
        L40:
            int r13 = r12.getWritePosition()
            int r2 = r12.getReadPosition()
            int r13 = r13 - r2
            if (r13 <= 0) goto L67
            r4 = r11
            io.ktor.utils.io.ByteWriteChannel r4 = (io.ktor.utils.p098io.ByteWriteChannel) r4
            io.ktor.utils.io.ByteBufferChannel$writeFully$4 r13 = new io.ktor.utils.io.ByteBufferChannel$writeFully$4
            r13.<init>()
            r6 = r13
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.L$0 = r11
            r0.L$1 = r12
            r0.label = r3
            r5 = 0
            r8 = 1
            r9 = 0
            r7 = r0
            java.lang.Object r13 = io.ktor.utils.io.ByteWriteChannel.DefaultImpls.write$default(r4, r5, r6, r7, r8, r9)
            if (r13 != r1) goto L40
            return r1
        L67:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeFully$suspendImpl(io.ktor.utils.io.ByteBufferChannel, io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: writeFully-rGWNHyQ$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m6939writeFullyrGWNHyQ$suspendImpl(ByteBufferChannel byteBufferChannel, ByteBuffer byteBuffer, int i, int i2, Continuation continuation) {
        Object objWriteFully = byteBufferChannel.writeFully(Memory.m6961sliceSK3TCg8(byteBuffer, i, i2 - i), (Continuation<? super Unit>) continuation);
        return objWriteFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteFully : Unit.INSTANCE;
    }

    static /* synthetic */ Object writeFully$suspendImpl(ByteBufferChannel byteBufferChannel, IoBuffer ioBuffer, Continuation continuation) throws Throwable {
        IoBuffer ioBuffer2 = ioBuffer;
        byteBufferChannel.writeAsMuchAsPossible(ioBuffer2);
        if (ioBuffer2.getWritePosition() <= ioBuffer2.getReadPosition()) {
            return Unit.INSTANCE;
        }
        Object objWriteFullySuspend = byteBufferChannel.writeFullySuspend(ioBuffer, (Continuation<? super Unit>) continuation);
        return objWriteFullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteFullySuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0055 -> B:22:0x0058). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeFullySuspend(java.nio.ByteBuffer r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52521
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52521) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L77
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.p098io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L58
        L41:
            kotlin.ResultKt.throwOnFailure(r8)
            r2 = r6
        L45:
            boolean r8 = r7.hasRemaining()
            if (r8 == 0) goto L7a
            r0.L$0 = r2
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r2.tryWriteSuspend$ktor_io(r4, r0)
            if (r8 != r1) goto L58
            return r1
        L58:
            io.ktor.utils.io.internal.JoiningState r8 = r2.joining
            if (r8 != 0) goto L5d
            goto L66
        L5d:
            io.ktor.utils.io.ByteBufferChannel r8 = r2.resolveDelegation(r2, r8)
            r5 = 0
            if (r8 != 0) goto L6a
            java.lang.Void r5 = (java.lang.Void) r5
        L66:
            r2.writeAsMuchAsPossible(r7)
            goto L45
        L6a:
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = r8.writeFully(r7, r0)
            if (r7 != r1) goto L77
            return r1
        L77:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L7a:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeFullySuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005c -> B:22:0x005f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeFullySuspend(io.ktor.utils.p098io.core.IoBuffer r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52533
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52533) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L81
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.Object r7 = r0.L$1
            io.ktor.utils.io.core.IoBuffer r7 = (io.ktor.utils.p098io.core.IoBuffer) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.p098io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5f
        L41:
            kotlin.ResultKt.throwOnFailure(r8)
            r2 = r6
        L45:
            r8 = r7
            io.ktor.utils.io.core.Buffer r8 = (io.ktor.utils.p098io.core.Buffer) r8
            int r5 = r8.getWritePosition()
            int r8 = r8.getReadPosition()
            if (r5 <= r8) goto L84
            r0.L$0 = r2
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r2.tryWriteSuspend$ktor_io(r4, r0)
            if (r8 != r1) goto L5f
            return r1
        L5f:
            io.ktor.utils.io.internal.JoiningState r8 = r2.joining
            if (r8 != 0) goto L64
            goto L6d
        L64:
            io.ktor.utils.io.ByteBufferChannel r8 = r2.resolveDelegation(r2, r8)
            r5 = 0
            if (r8 != 0) goto L74
            java.lang.Void r5 = (java.lang.Void) r5
        L6d:
            r8 = r7
            io.ktor.utils.io.core.Buffer r8 = (io.ktor.utils.p098io.core.Buffer) r8
            r2.writeAsMuchAsPossible(r8)
            goto L45
        L74:
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = r8.writeFully(r7, r0)
            if (r7 != r1) goto L81
            return r1
        L81:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L84:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeFullySuspend(io.ktor.utils.io.core.IoBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitClose(Continuation<? super Unit> continuation) {
        if (getClosed() != null) {
            return Unit.INSTANCE;
        }
        JoiningState joiningState = this.joining;
        if (joiningState == null) {
            if (!(getClosed() != null)) {
                throw new IllegalStateException("Only works for joined.".toString());
            }
            return Unit.INSTANCE;
        }
        Object objAwaitClose = joiningState.awaitClose(continuation);
        return objAwaitClose == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitClose : Unit.INSTANCE;
    }

    public final Object joinFrom$ktor_io(ByteBufferChannel byteBufferChannel, boolean z, Continuation<? super Unit> continuation) throws Throwable {
        if (byteBufferChannel.getClosed() != null && byteBufferChannel.getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            if (z) {
                ClosedElement closed = byteBufferChannel.getClosed();
                Intrinsics.checkNotNull(closed);
                close(closed.getCause());
            }
            return Unit.INSTANCE;
        }
        ClosedElement closed2 = getClosed();
        if (closed2 != null) {
            if (byteBufferChannel.getClosed() == null) {
                ByteBufferChannelKt.rethrowClosed(closed2.getSendException());
                throw new KotlinNothingValueException();
            }
            return Unit.INSTANCE;
        }
        JoiningState joiningState = byteBufferChannel.setupDelegateTo(this, z);
        if (byteBufferChannel.tryCompleteJoining(joiningState)) {
            Object objAwaitClose = byteBufferChannel.awaitClose(continuation);
            return objAwaitClose == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitClose : Unit.INSTANCE;
        }
        Object objJoinFromSuspend = joinFromSuspend(byteBufferChannel, z, joiningState, continuation);
        return objJoinFromSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoinFromSuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object joinFromSuspend(io.ktor.utils.p098io.ByteBufferChannel r10, boolean r11, io.ktor.utils.p098io.internal.JoiningState r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52211
            if (r0 == 0) goto L14
            r0 = r13
            io.ktor.utils.io.ByteBufferChannel$joinFromSuspend$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52211) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$joinFromSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$joinFromSuspend$1
            r0.<init>(r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L43
            if (r1 == r2) goto L35
            if (r1 != r8) goto L2d
            kotlin.ResultKt.throwOnFailure(r13)
            goto L80
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            boolean r11 = r0.Z$0
            java.lang.Object r10 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r10 = (io.ktor.utils.p098io.ByteBufferChannel) r10
            java.lang.Object r12 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r12 = (io.ktor.utils.p098io.ByteBufferChannel) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L5f
        L43:
            kotlin.ResultKt.throwOnFailure(r13)
            r0.L$0 = r9
            r0.L$1 = r10
            r0.Z$0 = r11
            r0.label = r2
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r1 = r9
            r2 = r10
            r5 = r12
            r6 = r0
            java.lang.Object r12 = r1.copyDirect$ktor_io(r2, r3, r5, r6)
            if (r12 != r7) goto L5e
            return r7
        L5e:
            r12 = r9
        L5f:
            if (r11 == 0) goto L6f
            boolean r11 = r10.isClosedForRead()
            if (r11 == 0) goto L6f
            io.ktor.utils.io.ByteWriteChannel r12 = (io.ktor.utils.p098io.ByteWriteChannel) r12
            io.ktor.utils.p098io.ByteWriteChannelKt.close(r12)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L6f:
            r12.flush()
            r11 = 0
            r0.L$0 = r11
            r0.L$1 = r11
            r0.label = r8
            java.lang.Object r10 = r10.awaitClose(r0)
            if (r10 != r7) goto L80
            return r7
        L80:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.joinFromSuspend(io.ktor.utils.io.ByteBufferChannel, boolean, io.ktor.utils.io.internal.JoiningState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:226:0x0174, code lost:
    
        r1 = r26;
        r4 = r27;
        r7 = r29;
        r2 = r3;
        r0 = r8;
        r12 = r14;
        r3 = r15;
        r13 = r17;
        r8 = r20;
        r26 = r21;
        r17 = r23;
        r15 = r28;
     */
    /* JADX WARN: Path cross not found for [B:133:0x02fa, B:135:0x0300], limit reached: 222 */
    /* JADX WARN: Path cross not found for [B:135:0x0300, B:133:0x02fa], limit reached: 222 */
    /* JADX WARN: Path cross not found for [B:141:0x031d, B:147:0x033a], limit reached: 222 */
    /* JADX WARN: Path cross not found for [B:147:0x033a, B:141:0x031d], limit reached: 222 */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02fa A[Catch: all -> 0x03d2, TryCatch #2 {all -> 0x03d2, blocks: (B:131:0x02f4, B:133:0x02fa, B:137:0x0305, B:138:0x0312, B:135:0x0300), top: B:205:0x02f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0305 A[Catch: all -> 0x03d2, TryCatch #2 {all -> 0x03d2, blocks: (B:131:0x02f4, B:133:0x02fa, B:137:0x0305, B:138:0x0312, B:135:0x0300), top: B:205:0x02f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x031d A[Catch: all -> 0x0085, TRY_ENTER, TryCatch #6 {all -> 0x0085, blocks: (B:14:0x004c, B:50:0x0138, B:52:0x013e, B:58:0x014c, B:141:0x031d, B:144:0x0325, B:146:0x0331, B:147:0x033a, B:150:0x0342, B:152:0x034b, B:156:0x037b, B:159:0x0385, B:169:0x03a4, B:171:0x03a8, B:163:0x038e, B:61:0x0156, B:184:0x03f0, B:186:0x03f6, B:190:0x0401, B:191:0x040e, B:192:0x0414, B:188:0x03fc, B:55:0x0145, B:194:0x0417, B:195:0x041a, B:19:0x007f), top: B:213:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0342 A[Catch: all -> 0x0085, TryCatch #6 {all -> 0x0085, blocks: (B:14:0x004c, B:50:0x0138, B:52:0x013e, B:58:0x014c, B:141:0x031d, B:144:0x0325, B:146:0x0331, B:147:0x033a, B:150:0x0342, B:152:0x034b, B:156:0x037b, B:159:0x0385, B:169:0x03a4, B:171:0x03a8, B:163:0x038e, B:61:0x0156, B:184:0x03f0, B:186:0x03f6, B:190:0x0401, B:191:0x040e, B:192:0x0414, B:188:0x03fc, B:55:0x0145, B:194:0x0417, B:195:0x041a, B:19:0x007f), top: B:213:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03a8 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #6 {all -> 0x0085, blocks: (B:14:0x004c, B:50:0x0138, B:52:0x013e, B:58:0x014c, B:141:0x031d, B:144:0x0325, B:146:0x0331, B:147:0x033a, B:150:0x0342, B:152:0x034b, B:156:0x037b, B:159:0x0385, B:169:0x03a4, B:171:0x03a8, B:163:0x038e, B:61:0x0156, B:184:0x03f0, B:186:0x03f6, B:190:0x0401, B:191:0x040e, B:192:0x0414, B:188:0x03fc, B:55:0x0145, B:194:0x0417, B:195:0x041a, B:19:0x007f), top: B:213:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03f6 A[Catch: all -> 0x0085, TryCatch #6 {all -> 0x0085, blocks: (B:14:0x004c, B:50:0x0138, B:52:0x013e, B:58:0x014c, B:141:0x031d, B:144:0x0325, B:146:0x0331, B:147:0x033a, B:150:0x0342, B:152:0x034b, B:156:0x037b, B:159:0x0385, B:169:0x03a4, B:171:0x03a8, B:163:0x038e, B:61:0x0156, B:184:0x03f0, B:186:0x03f6, B:190:0x0401, B:191:0x040e, B:192:0x0414, B:188:0x03fc, B:55:0x0145, B:194:0x0417, B:195:0x041a, B:19:0x007f), top: B:213:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03fc A[Catch: all -> 0x0085, TryCatch #6 {all -> 0x0085, blocks: (B:14:0x004c, B:50:0x0138, B:52:0x013e, B:58:0x014c, B:141:0x031d, B:144:0x0325, B:146:0x0331, B:147:0x033a, B:150:0x0342, B:152:0x034b, B:156:0x037b, B:159:0x0385, B:169:0x03a4, B:171:0x03a8, B:163:0x038e, B:61:0x0156, B:184:0x03f0, B:186:0x03f6, B:190:0x0401, B:191:0x040e, B:192:0x0414, B:188:0x03fc, B:55:0x0145, B:194:0x0417, B:195:0x041a, B:19:0x007f), top: B:213:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0401 A[Catch: all -> 0x0085, TryCatch #6 {all -> 0x0085, blocks: (B:14:0x004c, B:50:0x0138, B:52:0x013e, B:58:0x014c, B:141:0x031d, B:144:0x0325, B:146:0x0331, B:147:0x033a, B:150:0x0342, B:152:0x034b, B:156:0x037b, B:159:0x0385, B:169:0x03a4, B:171:0x03a8, B:163:0x038e, B:61:0x0156, B:184:0x03f0, B:186:0x03f6, B:190:0x0401, B:191:0x040e, B:192:0x0414, B:188:0x03fc, B:55:0x0145, B:194:0x0417, B:195:0x041a, B:19:0x007f), top: B:213:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0417 A[Catch: all -> 0x0085, TryCatch #6 {all -> 0x0085, blocks: (B:14:0x004c, B:50:0x0138, B:52:0x013e, B:58:0x014c, B:141:0x031d, B:144:0x0325, B:146:0x0331, B:147:0x033a, B:150:0x0342, B:152:0x034b, B:156:0x037b, B:159:0x0385, B:169:0x03a4, B:171:0x03a8, B:163:0x038e, B:61:0x0156, B:184:0x03f0, B:186:0x03f6, B:190:0x0401, B:191:0x040e, B:192:0x0414, B:188:0x03fc, B:55:0x0145, B:194:0x0417, B:195:0x041a, B:19:0x007f), top: B:213:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0298 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013e A[Catch: all -> 0x0085, TryCatch #6 {all -> 0x0085, blocks: (B:14:0x004c, B:50:0x0138, B:52:0x013e, B:58:0x014c, B:141:0x031d, B:144:0x0325, B:146:0x0331, B:147:0x033a, B:150:0x0342, B:152:0x034b, B:156:0x037b, B:159:0x0385, B:169:0x03a4, B:171:0x03a8, B:163:0x038e, B:61:0x0156, B:184:0x03f0, B:186:0x03f6, B:190:0x0401, B:191:0x040e, B:192:0x0414, B:188:0x03fc, B:55:0x0145, B:194:0x0417, B:195:0x041a, B:19:0x007f), top: B:213:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017a A[Catch: all -> 0x03d5, TryCatch #5 {all -> 0x03d5, blocks: (B:66:0x0174, B:68:0x017a, B:70:0x017e), top: B:211:0x0174 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c7 A[Catch: all -> 0x01da, TRY_LEAVE, TryCatch #10 {all -> 0x01da, blocks: (B:77:0x01ba, B:81:0x01c7), top: B:220:0x01ba }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0212 A[Catch: all -> 0x02d5, TRY_LEAVE, TryCatch #4 {all -> 0x02d5, blocks: (B:88:0x0200, B:91:0x0212), top: B:209:0x0200 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:146:0x0331 -> B:50:0x0138). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:170:0x03a6 -> B:174:0x03ce). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:172:0x03cb -> B:174:0x03ce). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object copyDirect$ktor_io(io.ktor.utils.p098io.ByteBufferChannel r26, long r27, io.ktor.utils.p098io.internal.JoiningState r29, kotlin.coroutines.Continuation<? super java.lang.Long> r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1064
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.copyDirect$ktor_io(io.ktor.utils.io.ByteBufferChannel, long, io.ktor.utils.io.internal.JoiningState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void ensureClosedJoined(JoiningState joined) {
        ClosedElement closed = getClosed();
        if (closed == null) {
            return;
        }
        this.joining = null;
        if (!joined.getDelegateClose()) {
            joined.getDelegatedTo().flush();
            joined.complete();
            return;
        }
        ReadWriteBufferState state = joined.getDelegatedTo().getState();
        boolean z = (state instanceof ReadWriteBufferState.Writing) || (state instanceof ReadWriteBufferState.ReadingWriting);
        if (closed.getCause() != null || !z) {
            joined.getDelegatedTo().close(closed.getCause());
        } else {
            joined.getDelegatedTo().flush();
        }
        joined.complete();
    }

    static /* synthetic */ Object writeFully$suspendImpl(ByteBufferChannel byteBufferChannel, byte[] bArr, int i, int i2, Continuation continuation) throws Throwable {
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
            ByteBufferChannel byteBufferChannelResolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState);
            if (byteBufferChannelResolveDelegation != null) {
                Object objWriteFully = byteBufferChannelResolveDelegation.writeFully(bArr, i, i2, continuation);
                return objWriteFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteFully : Unit.INSTANCE;
            }
        }
        while (i2 > 0) {
            int iWriteAsMuchAsPossible = byteBufferChannel.writeAsMuchAsPossible(bArr, i, i2);
            if (iWriteAsMuchAsPossible == 0) {
                break;
            }
            i += iWriteAsMuchAsPossible;
            i2 -= iWriteAsMuchAsPossible;
        }
        if (i2 == 0) {
            return Unit.INSTANCE;
        }
        Object objWriteFullySuspend = byteBufferChannel.writeFullySuspend(bArr, i, i2, continuation);
        return objWriteFullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteFullySuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:20:0x0058). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeFullySuspend(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52545
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52545) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            int r6 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r8 = r0.L$1
            byte[] r8 = (byte[]) r8
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.p098io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L58
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            kotlin.ResultKt.throwOnFailure(r9)
            r2 = r5
        L42:
            if (r8 <= 0) goto L64
            r0.L$0 = r2
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r3
            java.lang.Object r9 = r2.writeAvailable(r6, r7, r8, r0)
            if (r9 != r1) goto L55
            return r1
        L55:
            r4 = r8
            r8 = r6
            r6 = r4
        L58:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            int r7 = r7 + r9
            int r6 = r6 - r9
            r4 = r8
            r8 = r6
            r6 = r4
            goto L42
        L64:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeFullySuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, byte[] bArr, int i, int i2, Continuation continuation) throws Throwable {
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
            ByteBufferChannel byteBufferChannelResolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState);
            if (byteBufferChannelResolveDelegation != null) {
                return byteBufferChannelResolveDelegation.writeAvailable(bArr, i, i2, continuation);
            }
        }
        int iWriteAsMuchAsPossible = byteBufferChannel.writeAsMuchAsPossible(bArr, i, i2);
        if (iWriteAsMuchAsPossible > 0) {
            return Boxing.boxInt(iWriteAsMuchAsPossible);
        }
        return byteBufferChannel.writeSuspend(bArr, i, i2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005a -> B:20:0x005d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeSuspend(byte[] r8, int r9, int r10, kotlin.coroutines.Continuation<? super java.lang.Integer> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52591
            if (r0 == 0) goto L14
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52591) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeSuspend$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r11)
            goto L83
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$1
            byte[] r10 = (byte[]) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.p098io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r6 = r10
            r10 = r8
            r8 = r6
            goto L5d
        L48:
            kotlin.ResultKt.throwOnFailure(r11)
            r2 = r7
        L4c:
            r0.L$0 = r2
            r0.L$1 = r8
            r0.I$0 = r9
            r0.I$1 = r10
            r0.label = r4
            java.lang.Object r11 = r2.tryWriteSuspend$ktor_io(r4, r0)
            if (r11 != r1) goto L5d
            return r1
        L5d:
            io.ktor.utils.io.internal.JoiningState r11 = r2.joining
            if (r11 != 0) goto L62
            goto L6b
        L62:
            io.ktor.utils.io.ByteBufferChannel r11 = r2.resolveDelegation(r2, r11)
            r5 = 0
            if (r11 != 0) goto L76
            java.lang.Void r5 = (java.lang.Void) r5
        L6b:
            int r11 = r2.writeAsMuchAsPossible(r8, r9, r10)
            if (r11 <= 0) goto L4c
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
            return r8
        L76:
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r11 = r11.writeSuspend(r8, r9, r10, r0)
            if (r11 != r1) goto L83
            return r1
        L83:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeSuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object write$suspendImpl(io.ktor.utils.p098io.ByteBufferChannel r5, int r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52461
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$write$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52461) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$write$1 r0 = new io.ktor.utils.io.ByteBufferChannel$write$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r7 = (io.ktor.utils.p098io.ByteBufferChannel) r7
            kotlin.ResultKt.throwOnFailure(r8)
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L52
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 0
            if (r6 <= 0) goto L48
            r2 = r3
            goto L49
        L48:
            r2 = r8
        L49:
            if (r2 == 0) goto L8b
            r2 = 4088(0xff8, float:5.729E-42)
            if (r6 > r2) goto L50
            r8 = r3
        L50:
            if (r8 == 0) goto L6a
        L52:
            int r8 = r5.writeAvailable(r6, r7)
            if (r8 < 0) goto L5b
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L5b:
            r0.L$0 = r5
            r0.L$1 = r7
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r8 = r5.awaitFreeSpaceOrDelegate(r6, r7, r0)
            if (r8 != r1) goto L52
            return r1
        L6a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "Min("
            r5.<init>(r7)
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = ") should'nt be greater than (4088)"
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            throw r6
        L8b:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "min should be positive"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.write$suspendImpl(io.ktor.utils.io.ByteBufferChannel, int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitFreeSpaceOrDelegate(int r6, kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52181
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52181) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1 r0 = new io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L74
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.p098io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L56
        L43:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r7
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r8 = r5.writeSuspend(r6, r0)
            if (r8 != r1) goto L55
            return r1
        L55:
            r2 = r5
        L56:
            io.ktor.utils.io.internal.JoiningState r8 = r2.joining
            if (r8 != 0) goto L5b
            goto L64
        L5b:
            io.ktor.utils.io.ByteBufferChannel r8 = r2.resolveDelegation(r2, r8)
            r2 = 0
            if (r8 != 0) goto L67
            java.lang.Void r2 = (java.lang.Void) r2
        L64:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L67:
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r6 = r8.write(r6, r7, r0)
            if (r6 != r1) goto L74
            return r1
        L74:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.awaitFreeSpaceOrDelegate(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object writeWhile$suspendImpl(ByteBufferChannel byteBufferChannel, Function1 function1, Continuation continuation) throws Throwable {
        if (!byteBufferChannel.writeWhileNoSuspend(function1)) {
            return Unit.INSTANCE;
        }
        ClosedElement closed = byteBufferChannel.getClosed();
        if (closed != null) {
            ByteBufferChannelKt.rethrowClosed(closed.getSendException());
            throw new KotlinNothingValueException();
        }
        Object objWriteWhileSuspend = byteBufferChannel.writeWhileSuspend(function1, continuation);
        return objWriteWhileSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteWhileSuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00da, code lost:
    
        if (r4.getClosed() != null) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cc A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:16:0x0060, B:38:0x00c7, B:41:0x00cc, B:43:0x00d2, B:44:0x00d6, B:35:0x00aa), top: B:84:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0161  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c4 -> B:38:0x00c7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeWhileSuspend(kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, java.lang.Boolean> r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeWhileSuspend(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean writeWhileLoop(ByteBuffer dst, RingBufferCapacity capacity, Function1<? super ByteBuffer, Boolean> block) {
        int iCapacity = dst.capacity() - this.reservedSize;
        boolean z = true;
        while (z) {
            int iTryWriteAtLeast = capacity.tryWriteAtLeast(1);
            if (iTryWriteAtLeast == 0) {
                break;
            }
            int i = this.writePosition;
            int iCoerceAtMost = RangesKt.coerceAtMost(i + iTryWriteAtLeast, iCapacity);
            try {
                boolean zBooleanValue = block.invoke(dst).booleanValue();
                if (!(dst.limit() == iCoerceAtMost)) {
                    throw new IllegalStateException("Buffer limit modified.".toString());
                }
                int iPosition = dst.position() - i;
                if (!(iPosition >= 0)) {
                    throw new IllegalStateException("Position has been moved backward: pushback is not supported.".toString());
                }
                bytesWritten(dst, capacity, iPosition);
                if (iPosition < iTryWriteAtLeast) {
                    capacity.completeRead(iTryWriteAtLeast - iPosition);
                }
                z = zBooleanValue;
            } catch (Throwable th) {
                capacity.completeRead(iTryWriteAtLeast);
                throw th;
            }
        }
        return z;
    }

    @Override // io.ktor.utils.p098io.HasReadSession
    public SuspendableReadSession startReadSession() {
        return this.readSession;
    }

    @Override // io.ktor.utils.p098io.HasReadSession
    public void endReadSession() {
        this.readSession.completed();
        ReadWriteBufferState state = getState();
        if ((state instanceof ReadWriteBufferState.Reading) || (state instanceof ReadWriteBufferState.ReadingWriting)) {
            restoreStateAfterRead();
            tryTerminate$ktor_io();
        }
    }

    @Override // io.ktor.utils.p098io.HasWriteSession
    public WriterSuspendSession beginWriteSession() {
        WriteSessionImpl writeSessionImpl = this.writeSession;
        writeSessionImpl.begin();
        return writeSessionImpl;
    }

    @Override // io.ktor.utils.p098io.HasWriteSession
    public void endWriteSession(int written) {
        this.writeSession.written(written);
        this.writeSession.complete();
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    @ExperimentalIoApi
    public void readSession(final Function1<? super ReadSession, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        lookAhead(new Function1<LookAheadSession, Unit>() { // from class: io.ktor.utils.io.ByteBufferChannel.readSession.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LookAheadSession lookAheadSession) {
                invoke2(lookAheadSession);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LookAheadSession lookAhead) {
                Intrinsics.checkNotNullParameter(lookAhead, "$this$lookAhead");
                try {
                    consumer.invoke(this.readSession);
                } finally {
                    this.readSession.completed();
                }
            }
        });
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readSuspendableSession$2 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lio/ktor/utils/io/LookAheadSuspendSession;"}, m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel$readSuspendableSession$2", m5608f = "ByteBufferChannel.kt", m5609i = {}, m5610l = {1651}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C52412 extends SuspendLambda implements Function2<LookAheadSuspendSession, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<SuspendableReadSession, Continuation<? super Unit>, Object> $consumer;
        int label;
        final /* synthetic */ ByteBufferChannel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C52412(Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, ByteBufferChannel byteBufferChannel, Continuation<? super C52412> continuation) {
            super(2, continuation);
            this.$consumer = function2;
            this.this$0 = byteBufferChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C52412(this.$consumer, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(LookAheadSuspendSession lookAheadSuspendSession, Continuation<? super Unit> continuation) {
            return ((C52412) create(lookAheadSuspendSession, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2<SuspendableReadSession, Continuation<? super Unit>, Object> function2 = this.$consumer;
                    ReadSessionImpl readSessionImpl = this.this$0.readSession;
                    this.label = 1;
                    if (function2.invoke(readSessionImpl, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.readSession.completed();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                this.this$0.readSession.completed();
                throw th;
            }
        }
    }

    @ExperimentalIoApi
    static /* synthetic */ Object readSuspendableSession$suspendImpl(ByteBufferChannel byteBufferChannel, Function2 function2, Continuation continuation) {
        Object objLookAheadSuspend = byteBufferChannel.lookAheadSuspend(new C52412(function2, byteBufferChannel, null), continuation);
        return objLookAheadSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLookAheadSuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[PHI: r10 r12 r13
      PHI (r10v2 long) = (r10v1 long), (r10v6 long) binds: [B:14:0x003c, B:30:0x0081] A[DONT_GENERATE, DONT_INLINE]
      PHI (r12v2 kotlin.jvm.internal.Ref$LongRef) = (r12v1 kotlin.jvm.internal.Ref$LongRef), (r12v4 kotlin.jvm.internal.Ref$LongRef) binds: [B:14:0x003c, B:30:0x0081] A[DONT_GENERATE, DONT_INLINE]
      PHI (r13v1 io.ktor.utils.io.ByteBufferChannel) = (r13v0 io.ktor.utils.io.ByteBufferChannel), (r13v2 io.ktor.utils.io.ByteBufferChannel) binds: [B:14:0x003c, B:30:0x0081] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0078 -> B:29:0x007b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object discardSuspend(long r10, long r12, kotlin.coroutines.Continuation<? super java.lang.Long> r14) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r14 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52201
            if (r0 == 0) goto L14
            r0 = r14
            io.ktor.utils.io.ByteBufferChannel$discardSuspend$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52201) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$discardSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$discardSuspend$1
            r0.<init>(r14)
        L19:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            long r10 = r0.J$0
            java.lang.Object r12 = r0.L$1
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            java.lang.Object r13 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r13 = (io.ktor.utils.p098io.ByteBufferChannel) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L7b
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3c:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.jvm.internal.Ref$LongRef r14 = new kotlin.jvm.internal.Ref$LongRef
            r14.<init>()
            r14.element = r10
            r10 = r12
            r12 = r14
            r13 = r9
        L49:
            long r4 = r12.element
            int r14 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r14 >= 0) goto Lac
            java.nio.ByteBuffer r14 = access$setupStateForRead(r13)
            if (r14 != 0) goto L56
            goto L66
        L56:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = access$getState(r13)
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.capacity
            int r4 = r2._availableForRead$internal     // Catch: java.lang.Throwable -> La4
            if (r4 != 0) goto L84
            access$restoreStateAfterRead(r13)
            r13.tryTerminate$ktor_io()
        L66:
            boolean r14 = r13.isClosedForRead()
            if (r14 != 0) goto Lac
            r0.L$0 = r13
            r0.L$1 = r12
            r0.J$0 = r10
            r0.label = r3
            java.lang.Object r14 = r13.readSuspend(r3, r0)
            if (r14 != r1) goto L7b
            return r1
        L7b:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 != 0) goto L49
            goto Lac
        L84:
            long r4 = r12.element     // Catch: java.lang.Throwable -> La4
            long r4 = r10 - r4
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r4 = java.lang.Math.min(r6, r4)     // Catch: java.lang.Throwable -> La4
            int r4 = (int) r4     // Catch: java.lang.Throwable -> La4
            int r4 = r2.tryReadAtMost(r4)     // Catch: java.lang.Throwable -> La4
            r13.bytesRead(r14, r2, r4)     // Catch: java.lang.Throwable -> La4
            long r5 = r12.element     // Catch: java.lang.Throwable -> La4
            long r7 = (long) r4     // Catch: java.lang.Throwable -> La4
            long r5 = r5 + r7
            r12.element = r5     // Catch: java.lang.Throwable -> La4
            access$restoreStateAfterRead(r13)
            r13.tryTerminate$ktor_io()
            goto L49
        La4:
            r10 = move-exception
            access$restoreStateAfterRead(r13)
            r13.tryTerminate$ktor_io()
            throw r10
        Lac:
            long r10 = r12.element
            java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.discardSuspend(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readBlockSuspend(int r6, kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52261
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52261) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L90
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.p098io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5a
        L43:
            kotlin.ResultKt.throwOnFailure(r8)
            int r8 = kotlin.ranges.RangesKt.coerceAtLeast(r6, r4)
            r0.L$0 = r5
            r0.L$1 = r7
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r8 = r5.readSuspend(r8, r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            r2 = r5
        L5a:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L82
            if (r6 > 0) goto L67
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L67:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "Got EOF but at least "
            r8.<init>(r0)
            java.lang.StringBuilder r6 = r8.append(r6)
            java.lang.String r8 = " bytes were expected"
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        L82:
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r6 = r2.read(r6, r7, r0)
            if (r6 != r1) goto L90
            return r1
        L90:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readBlockSuspend(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object writePacket$suspendImpl(ByteBufferChannel byteBufferChannel, ByteReadPacket byteReadPacket, Continuation continuation) {
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
            ByteBufferChannel byteBufferChannelResolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState);
            if (byteBufferChannelResolveDelegation != null) {
                Object objWritePacket = byteBufferChannelResolveDelegation.writePacket(byteReadPacket, continuation);
                return objWritePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWritePacket : Unit.INSTANCE;
            }
        }
        while (!byteReadPacket.isEmpty() && byteBufferChannel.tryWritePacketPart(byteReadPacket) != 0) {
            try {
            } catch (Throwable th) {
                byteReadPacket.release();
                throw th;
            }
        }
        if (byteReadPacket.getRemaining() > 0) {
            JoiningState joiningState2 = byteBufferChannel.joining;
            if (joiningState2 != null) {
                ByteBufferChannel byteBufferChannelResolveDelegation2 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState2);
                if (byteBufferChannelResolveDelegation2 != null) {
                    Object objWritePacket2 = byteBufferChannelResolveDelegation2.writePacket(byteReadPacket, continuation);
                    return objWritePacket2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWritePacket2 : Unit.INSTANCE;
                }
            }
            Object objWritePacketSuspend = byteBufferChannel.writePacketSuspend(byteReadPacket, continuation);
            return objWritePacketSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWritePacketSuspend : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:13:0x002d, B:38:0x007d, B:18:0x0041, B:28:0x005e, B:34:0x006c, B:23:0x004b, B:25:0x0051, B:31:0x0063, B:33:0x006a, B:35:0x0070), top: B:45:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0063 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:13:0x002d, B:38:0x007d, B:18:0x0041, B:28:0x005e, B:34:0x006c, B:23:0x004b, B:25:0x0051, B:31:0x0063, B:33:0x006a, B:35:0x0070), top: B:45:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005b -> B:28:0x005e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writePacketSuspend(io.ktor.utils.p098io.core.ByteReadPacket r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52571
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52571) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.core.ByteReadPacket r7 = (io.ktor.utils.p098io.core.ByteReadPacket) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L45
            goto L7d
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            java.lang.Object r7 = r0.L$1
            io.ktor.utils.io.core.ByteReadPacket r7 = (io.ktor.utils.p098io.core.ByteReadPacket) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.p098io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L45
            goto L5e
        L45:
            r8 = move-exception
            goto L89
        L47:
            kotlin.ResultKt.throwOnFailure(r8)
            r2 = r6
        L4b:
            boolean r8 = r7.isEmpty()     // Catch: java.lang.Throwable -> L45
            if (r8 != 0) goto L83
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L45
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L45
            r0.label = r4     // Catch: java.lang.Throwable -> L45
            java.lang.Object r8 = r2.writeSuspend(r4, r0)     // Catch: java.lang.Throwable -> L45
            if (r8 != r1) goto L5e
            return r1
        L5e:
            io.ktor.utils.io.internal.JoiningState r8 = r2.joining     // Catch: java.lang.Throwable -> L45
            if (r8 != 0) goto L63
            goto L6c
        L63:
            io.ktor.utils.io.ByteBufferChannel r8 = r2.resolveDelegation(r2, r8)     // Catch: java.lang.Throwable -> L45
            r5 = 0
            if (r8 != 0) goto L70
            java.lang.Void r5 = (java.lang.Void) r5     // Catch: java.lang.Throwable -> L45
        L6c:
            r2.tryWritePacketPart(r7)     // Catch: java.lang.Throwable -> L45
            goto L4b
        L70:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L45
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L45
            r0.label = r3     // Catch: java.lang.Throwable -> L45
            java.lang.Object r8 = r8.writePacket(r7, r0)     // Catch: java.lang.Throwable -> L45
            if (r8 != r1) goto L7d
            return r1
        L7d:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L45
            r7.release()
            return r8
        L83:
            r7.release()
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L89:
            r7.release()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writePacketSuspend(io.ktor.utils.io.core.ByteReadPacket, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public <R> R lookAhead(Function1<? super LookAheadSession, ? extends R> visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            return visitor.invoke(new FailedLookAhead(closedCause));
        }
        if (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
            boolean z = false;
            R rInvoke = null;
            if (setupStateForRead() != null) {
                try {
                    if (getState().capacity._availableForRead$internal != 0) {
                        rInvoke = visitor.invoke(this);
                        restoreStateAfterRead();
                        tryTerminate$ktor_io();
                        z = true;
                    }
                } finally {
                    restoreStateAfterRead();
                    tryTerminate$ktor_io();
                }
            }
            if (!z) {
                Throwable closedCause2 = getClosedCause();
                if (closedCause2 != null) {
                    return visitor.invoke(new FailedLookAhead(closedCause2));
                }
                return visitor.invoke(TerminatedLookAhead.INSTANCE);
            }
            Intrinsics.checkNotNull(rInvoke);
            return rInvoke;
        }
        return visitor.invoke(TerminatedLookAhead.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object lookAheadSuspend$suspendImpl(io.ktor.utils.p098io.ByteBufferChannel r7, kotlin.jvm.functions.Function2 r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.lookAheadSuspend$suspendImpl(io.ktor.utils.io.ByteBufferChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, kotlin.Unit] */
    @io.ktor.utils.p098io.core.ExperimentalIoApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeSuspendSession$suspendImpl(io.ktor.utils.p098io.ByteBufferChannel r4, kotlin.jvm.functions.Function2 r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52611
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52611) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.internal.WriteSessionImpl r4 = (io.ktor.utils.p098io.internal.WriteSessionImpl) r4
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L4f
            goto L49
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.utils.io.internal.WriteSessionImpl r4 = r4.writeSession
            r4.begin()
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L4f
            r0.label = r3     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r5 = r5.invoke(r4, r0)     // Catch: java.lang.Throwable -> L4f
            if (r5 != r1) goto L49
            return r1
        L49:
            r4.complete()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L4f:
            r5 = move-exception
            r4.complete()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeSuspendSession$suspendImpl(io.ktor.utils.io.ByteBufferChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.p098io.LookAheadSession
    /* JADX INFO: renamed from: consumed */
    public void mo7224consumed(int n) {
        if (!(n >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        ReadWriteBufferState state = getState();
        if (!state.capacity.tryReadExact(n)) {
            throw new IllegalStateException("Unable to consume " + n + " bytes: not enough available bytes");
        }
        if (n > 0) {
            bytesRead(state.getReadBuffer(), state.capacity, n);
        }
    }

    @Override // io.ktor.utils.p098io.LookAheadSuspendSession
    public final Object awaitAtLeast(int i, Continuation<? super Boolean> continuation) throws Throwable {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("atLeast parameter shouldn't be negative: ", Boxing.boxInt(i)).toString());
        }
        if (!(i <= 4088)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("atLeast parameter shouldn't be larger than max buffer size of 4088: ", Boxing.boxInt(i)).toString());
        }
        if (getState().capacity._availableForRead$internal >= i) {
            if (getState().getIdle() || (getState() instanceof ReadWriteBufferState.Writing)) {
                setupStateForRead();
            }
            return Boxing.boxBoolean(true);
        }
        if (getState().getIdle() || (getState() instanceof ReadWriteBufferState.Writing)) {
            return awaitAtLeastSuspend(i, continuation);
        }
        if (i == 1) {
            return readSuspendImpl(1, continuation);
        }
        return readSuspend(i, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitAtLeastSuspend(int r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52171
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52171) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.p098io.ByteBufferChannel) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r4.readSuspend(r5, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            r5 = r4
        L45:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L5a
            io.ktor.utils.io.internal.ReadWriteBufferState r0 = r5.getState()
            boolean r0 = r0.getIdle()
            if (r0 == 0) goto L5a
            r5.setupStateForRead()
        L5a:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.awaitAtLeastSuspend(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.p098io.LookAheadSession
    public ByteBuffer request(int skip, int atLeast) {
        ReadWriteBufferState state = getState();
        int i = state.capacity._availableForRead$internal;
        int i2 = this.readPosition;
        if (i < atLeast + skip) {
            return null;
        }
        if (state.getIdle() || (!(state instanceof ReadWriteBufferState.Reading) && !(state instanceof ReadWriteBufferState.ReadingWriting))) {
            if (setupStateForRead() == null) {
                return null;
            }
            return request(skip, atLeast);
        }
        ByteBuffer readBuffer = state.getReadBuffer();
        prepareBuffer(readBuffer, getReadByteOrder(), carryIndex(readBuffer, i2 + skip), i - skip);
        if (readBuffer.remaining() >= atLeast) {
            return readBuffer;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0068, code lost:
    
        if (r11 == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Path cross not found for [B:17:0x004d, B:18:0x004f], limit reached: 67 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00c5 -> B:52:0x00c8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object consumeEachBufferRangeSuspend(kotlin.jvm.functions.Function2<? super java.nio.ByteBuffer, ? super java.lang.Boolean, java.lang.Boolean> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.consumeEachBufferRangeSuspend(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int afterBufferVisited(ByteBuffer buffer, RingBufferCapacity capacity) {
        int iPosition = buffer.position() - this.readPosition;
        if (iPosition > 0) {
            if (!capacity.tryReadExact(iPosition)) {
                throw new IllegalStateException("Consumed more bytes than available");
            }
            bytesRead(buffer, capacity, iPosition);
            prepareBuffer(buffer, getReadByteOrder(), this.readPosition, capacity._availableForRead$internal);
        }
        return iPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readUTF8LineToAscii(final Appendable appendable, final int i, Continuation<? super Boolean> continuation) throws Throwable {
        if (getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            Throwable closedCause = getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            return Boxing.boxBoolean(false);
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        final char[] cArr = new char[8192];
        final CharBuffer buffer = CharBuffer.wrap(cArr);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        lookAhead(new Function1<LookAheadSession, Unit>() { // from class: io.ktor.utils.io.ByteBufferChannel.readUTF8LineToAscii.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LookAheadSession lookAheadSession) throws IOException {
                invoke2(lookAheadSession);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0086  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0090 A[LOOP:0: B:3:0x0022->B:26:0x0090, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0094 A[EDGE_INSN: B:35:0x0094->B:28:0x0094 BREAK  A[LOOP:0: B:3:0x0022->B:26:0x0090], SYNTHETIC] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke2(io.ktor.utils.p098io.LookAheadSession r20) throws java.io.IOException {
                /*
                    r19 = this;
                    r0 = r19
                    r1 = r20
                    java.lang.String r2 = "$this$lookAhead"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
                    kotlin.jvm.internal.Ref$BooleanRef r2 = r1
                    io.ktor.utils.io.ByteBufferChannel r3 = r2
                    java.lang.Appendable r4 = r3
                    char[] r5 = r4
                    java.nio.CharBuffer r6 = r5
                    java.lang.String r7 = "buffer"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                    io.ktor.utils.io.ByteBufferChannel r7 = r2
                    kotlin.jvm.internal.Ref$IntRef r8 = r6
                    char[] r9 = r4
                    int r10 = r7
                    r11 = 1
                    r12 = r11
                L22:
                    int r13 = r7.getAvailableForRead()
                    r14 = 0
                    if (r13 < r12) goto L92
                    java.nio.ByteBuffer r13 = r1.request(r14, r11)
                    if (r13 != 0) goto L30
                    goto L92
                L30:
                    int r15 = r13.position()
                    int r11 = r13.remaining()
                    if (r11 >= r12) goto L3d
                    io.ktor.utils.p098io.ByteBufferChannel.access$rollBytes(r3, r13, r12)
                L3d:
                    int r11 = r9.length
                    int r12 = r8.element
                    int r12 = r10 - r12
                    int r11 = java.lang.Math.min(r11, r12)
                    long r11 = io.ktor.utils.p098io.internal.StringsKt.decodeASCIILine(r13, r9, r14, r11)
                    int r16 = r13.position()
                    int r15 = r16 - r15
                    r1.mo7224consumed(r15)
                    r15 = 32
                    long r14 = r11 >> r15
                    int r14 = (int) r14
                    r17 = 4294967295(0xffffffff, double:2.1219957905E-314)
                    long r11 = r11 & r17
                    int r11 = (int) r11
                    r12 = -1
                    if (r11 != r12) goto L66
                    r12 = 0
                L64:
                    r13 = 1
                    goto L75
                L66:
                    if (r11 != 0) goto L6f
                    boolean r13 = r13.hasRemaining()
                    if (r13 == 0) goto L6f
                    goto L64
                L6f:
                    r13 = 1
                    int r11 = java.lang.Math.max(r13, r11)
                    r12 = r11
                L75:
                    int r11 = r8.element
                    int r11 = r11 + r14
                    r8.element = r11
                    boolean r11 = r4 instanceof java.lang.StringBuilder
                    if (r11 == 0) goto L86
                    r11 = r4
                    java.lang.StringBuilder r11 = (java.lang.StringBuilder) r11
                    r15 = 0
                    r11.append(r5, r15, r14)
                    goto L8d
                L86:
                    r15 = 0
                    r11 = r6
                    java.lang.CharSequence r11 = (java.lang.CharSequence) r11
                    r4.append(r11, r15, r14)
                L8d:
                    if (r12 > 0) goto L90
                    goto L94
                L90:
                    r11 = r13
                    goto L22
                L92:
                    r13 = r11
                    r15 = r14
                L94:
                    if (r12 != 0) goto L98
                    r11 = r13
                    goto L99
                L98:
                    r11 = r15
                L99:
                    r2.element = r11
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.C52432.invoke2(io.ktor.utils.io.LookAheadSession):void");
            }
        });
        if (booleanRef.element) {
            return Boxing.boxBoolean(true);
        }
        if (intRef.element == 0 && isClosedForRead()) {
            return Boxing.boxBoolean(false);
        }
        int i2 = i - intRef.element;
        Intrinsics.checkNotNullExpressionValue(buffer, "buffer");
        return readUTF8LineToUtf8Suspend(appendable, i2, cArr, buffer, intRef.element, continuation);
    }

    private final boolean readLineLoop(LookAheadSession lookAheadSession, Appendable appendable, char[] cArr, CharBuffer charBuffer, Function1<? super Integer, Boolean> function1, Function1<? super Integer, Unit> function12, Function1<? super ByteBuffer, Long> function13) throws IOException {
        ByteBuffer byteBufferRequest;
        int i = 1;
        while (function1.invoke(Integer.valueOf(i)).booleanValue() && (byteBufferRequest = lookAheadSession.request(0, 1)) != null) {
            int iPosition = byteBufferRequest.position();
            if (byteBufferRequest.remaining() < i) {
                rollBytes(byteBufferRequest, i);
            }
            long jLongValue = function13.invoke(byteBufferRequest).longValue();
            lookAheadSession.mo7224consumed(byteBufferRequest.position() - iPosition);
            int i2 = (int) (jLongValue >> 32);
            int i3 = (int) (jLongValue & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            int iMax = -1;
            if (i3 == -1) {
                iMax = 0;
            } else if (i3 != 0 || !byteBufferRequest.hasRemaining()) {
                iMax = Math.max(1, i3);
            }
            function12.invoke(Integer.valueOf(i2));
            if (appendable instanceof StringBuilder) {
                ((StringBuilder) appendable).append(cArr, 0, i2);
            } else {
                appendable.append(charBuffer, 0, i2);
            }
            i = iMax;
            if (iMax <= 0) {
                break;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readUTF8LineToUtf8Suspend(java.lang.Appendable r17, int r18, char[] r19, java.nio.CharBuffer r20, int r21, kotlin.coroutines.Continuation<? super java.lang.Boolean> r22) {
        /*
            r16 = this;
            r10 = r16
            r0 = r22
            boolean r1 = r0 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52441
            if (r1 == 0) goto L18
            r1 = r0
            io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$1 r1 = (io.ktor.utils.p098io.ByteBufferChannel.C52441) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L18
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1d
        L18:
            io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$1 r1 = new io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$1
            r1.<init>(r0)
        L1d:
            r11 = r1
            java.lang.Object r0 = r11.result
            java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r13 = 1
            if (r1 == 0) goto L3b
            if (r1 != r13) goto L33
            java.lang.Object r1 = r11.L$0
            kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L6c
        L33:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3b:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef
            r5.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r14 = new kotlin.jvm.internal.Ref$BooleanRef
            r14.<init>()
            r14.element = r13
            io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$2 r15 = new io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$2
            r9 = 0
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r19
            r4 = r20
            r6 = r21
            r7 = r14
            r8 = r18
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r11.L$0 = r14
            r11.label = r13
            java.lang.Object r0 = r10.lookAheadSuspend(r15, r11)
            if (r0 != r12) goto L6b
            return r12
        L6b:
            r1 = r14
        L6c:
            boolean r0 = r1.element
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readUTF8LineToUtf8Suspend(java.lang.Appendable, int, char[], java.nio.CharBuffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$2 */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lio/ktor/utils/io/LookAheadSuspendSession;"}, m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$2", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0, 0, 0, 0, 0}, m5610l = {2082}, m5611m = "invokeSuspend", m5612n = {"$this$lookAheadSuspend", "this_$iv", "$this$readLineLoop$iv", "out$iv", "ca$iv", "cb$iv", "required$iv"}, m5613s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$1"})
    static final class C52452 extends SuspendLambda implements Function2<LookAheadSuspendSession, Continuation<? super Unit>, Object> {
        final /* synthetic */ char[] $ca;
        final /* synthetic */ CharBuffer $cb;
        final /* synthetic */ int $consumed0;
        final /* synthetic */ Ref.IntRef $consumed1;
        final /* synthetic */ int $limit;
        final /* synthetic */ Appendable $out;
        final /* synthetic */ Ref.BooleanRef $result;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C52452(Appendable appendable, char[] cArr, CharBuffer charBuffer, Ref.IntRef intRef, int i, Ref.BooleanRef booleanRef, int i2, Continuation<? super C52452> continuation) {
            super(2, continuation);
            this.$out = appendable;
            this.$ca = cArr;
            this.$cb = charBuffer;
            this.$consumed1 = intRef;
            this.$consumed0 = i;
            this.$result = booleanRef;
            this.$limit = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C52452 c52452 = ByteBufferChannel.this.new C52452(this.$out, this.$ca, this.$cb, this.$consumed1, this.$consumed0, this.$result, this.$limit, continuation);
            c52452.L$0 = obj;
            return c52452;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(LookAheadSuspendSession lookAheadSuspendSession, Continuation<? super Unit> continuation) {
            return ((C52452) create(lookAheadSuspendSession, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0081 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00ca  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00f7  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00f9  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x015c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x007f -> B:12:0x0082). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 355
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.C52452.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object readUTF8Line$suspendImpl(io.ktor.utils.p098io.ByteBufferChannel r5, int r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52421
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52421) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            java.lang.StringBuilder r5 = (java.lang.StringBuilder) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4f
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r2 = r7
            java.lang.Appendable r2 = (java.lang.Appendable) r2
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r5 = r5.readUTF8LineTo(r2, r6, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            r4 = r7
            r7 = r5
            r5 = r4
        L4f:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            if (r6 != 0) goto L59
            r5 = 0
            return r5
        L59:
            java.lang.String r5 = r5.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readUTF8Line$suspendImpl(io.ktor.utils.io.ByteBufferChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readRemaining$suspendImpl(ByteBufferChannel byteBufferChannel, long j, int i, Continuation continuation) throws Throwable {
        if (byteBufferChannel.isClosedForWrite()) {
            Throwable closedCause = byteBufferChannel.getClosedCause();
            if (closedCause != null) {
                ByteBufferChannelKt.rethrowClosed(closedCause);
                throw new KotlinNothingValueException();
            }
            return byteBufferChannel.remainingPacket(j, i);
        }
        return byteBufferChannel.readRemainingSuspend(j, i, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079 A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:12:0x003a, B:32:0x00b2, B:43:0x00d0, B:21:0x0066, B:23:0x0079, B:24:0x007f, B:26:0x0096, B:28:0x009c), top: B:55:0x003a, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0096 A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:12:0x003a, B:32:0x00b2, B:43:0x00d0, B:21:0x0066, B:23:0x0079, B:24:0x007f, B:26:0x0096, B:28:0x009c), top: B:55:0x003a, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1 A[Catch: all -> 0x00d9, TRY_ENTER, TryCatch #0 {all -> 0x00d9, blocks: (B:38:0x00c1, B:40:0x00ca, B:42:0x00cf, B:45:0x00d5, B:46:0x00d8, B:12:0x003a, B:32:0x00b2, B:43:0x00d0, B:21:0x0066, B:23:0x0079, B:24:0x007f, B:26:0x0096, B:28:0x009c), top: B:52:0x0022, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d0 A[Catch: all -> 0x003f, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x003f, blocks: (B:12:0x003a, B:32:0x00b2, B:43:0x00d0, B:21:0x0066, B:23:0x0079, B:24:0x007f, B:26:0x0096, B:28:0x009c), top: B:55:0x003a, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [io.ktor.utils.io.core.BytePacketBuilder] */
    /* JADX WARN: Type inference failed for: r14v3, types: [io.ktor.utils.io.core.BytePacketBuilder] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [io.ktor.utils.io.core.BytePacketBuilder] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8, types: [io.ktor.utils.io.core.BytePacketBuilder] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00af -> B:32:0x00b2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00be -> B:37:0x00bf). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readRemainingSuspend(long r12, int r14, kotlin.coroutines.Continuation<? super io.ktor.utils.p098io.core.ByteReadPacket> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readRemainingSuspend(long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resumeReadOp() {
        Continuation continuation = (Continuation) _readOp$FU.getAndSet(this, null);
        if (continuation == null) {
            return;
        }
        ClosedElement closed = getClosed();
        Throwable cause = closed != null ? closed.getCause() : null;
        if (cause != null) {
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m7233constructorimpl(ResultKt.createFailure(cause)));
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            continuation.resumeWith(Result.m7233constructorimpl(true));
        }
    }

    private final void resumeReadOp(Function0<? extends Throwable> exception) {
        Continuation continuation = (Continuation) _readOp$FU.getAndSet(this, null);
        if (continuation == null) {
            return;
        }
        Throwable thInvoke = exception.invoke();
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m7233constructorimpl(ResultKt.createFailure(thInvoke)));
    }

    private final void resumeWriteOp() {
        Continuation<Unit> writeOp;
        ClosedElement closed;
        Object objCreateFailure;
        do {
            writeOp = getWriteOp();
            if (writeOp == null) {
                return;
            }
            closed = getClosed();
            if (closed == null && this.joining != null) {
                ReadWriteBufferState state = getState();
                if (!(state instanceof ReadWriteBufferState.Writing) && !(state instanceof ReadWriteBufferState.ReadingWriting) && state != ReadWriteBufferState.Terminated.INSTANCE) {
                    return;
                }
            }
        } while (!C0526xc40028dd.m1169m(_writeOp$FU, this, writeOp, null));
        if (closed == null) {
            objCreateFailure = Unit.INSTANCE;
            Result.Companion companion = Result.INSTANCE;
        } else {
            Throwable sendException = closed.getSendException();
            Result.Companion companion2 = Result.INSTANCE;
            objCreateFailure = ResultKt.createFailure(sendException);
        }
        writeOp.resumeWith(Result.m7233constructorimpl(objCreateFailure));
    }

    private final void resumeClosed(Throwable cause) {
        Continuation continuation = (Continuation) _readOp$FU.getAndSet(this, null);
        if (continuation != null) {
            if (cause != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m7233constructorimpl(ResultKt.createFailure(cause)));
            } else {
                Boolean boolValueOf = Boolean.valueOf(getState().capacity._availableForRead$internal > 0);
                Result.Companion companion2 = Result.INSTANCE;
                continuation.resumeWith(Result.m7233constructorimpl(boolValueOf));
            }
        }
        Continuation continuation2 = (Continuation) _writeOp$FU.getAndSet(this, null);
        if (continuation2 == null) {
            return;
        }
        if (cause == null) {
            cause = new ClosedWriteChannelException(ByteBufferChannelKt.DEFAULT_CLOSE_MESSAGE);
        }
        Result.Companion companion3 = Result.INSTANCE;
        continuation2.resumeWith(Result.m7233constructorimpl(ResultKt.createFailure(cause)));
    }

    static /* synthetic */ Object awaitContent$suspendImpl(ByteBufferChannel byteBufferChannel, Continuation continuation) throws Throwable {
        Object suspend = byteBufferChannel.readSuspend(1, continuation);
        return suspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? suspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readSuspend(int i, Continuation<? super Boolean> continuation) throws Throwable {
        if (getState().capacity._availableForRead$internal >= i) {
            return Boxing.boxBoolean(true);
        }
        ClosedElement closed = getClosed();
        if (closed == null) {
            if (i == 1) {
                return readSuspendImpl(1, continuation);
            }
            return readSuspendLoop(i, continuation);
        }
        Throwable cause = closed.getCause();
        if (cause != null) {
            ByteBufferChannelKt.rethrowClosed(cause);
            throw new KotlinNothingValueException();
        }
        RingBufferCapacity ringBufferCapacity = getState().capacity;
        boolean z = ringBufferCapacity.flush() && ringBufferCapacity._availableForRead$internal >= i;
        if (getReadOp() != null) {
            throw new IllegalStateException("Read operation is already in progress");
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005c -> B:24:0x005f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readSuspendLoop(int r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteBufferChannel.C52401
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1 r0 = (io.ktor.utils.p098io.ByteBufferChannel.C52401) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 != r4) goto L31
            int r6 = r0.I$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.p098io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5f
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            r2 = r5
        L3d:
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r2.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.capacity
            int r7 = r7._availableForRead$internal
            if (r7 < r6) goto L4c
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r6
        L4c:
            io.ktor.utils.io.internal.ClosedElement r7 = r2.getClosed()
            if (r7 != 0) goto L6c
            r0.L$0 = r2
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r7 = r2.readSuspendImpl(r6, r0)
            if (r7 != r1) goto L5f
            return r1
        L5f:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L3d
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        L6c:
            java.lang.Throwable r0 = r7.getCause()
            if (r0 != 0) goto L96
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r2.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.capacity
            boolean r0 = r7.flush()
            if (r0 == 0) goto L83
            int r7 = r7._availableForRead$internal
            if (r7 < r6) goto L83
            r3 = r4
        L83:
            kotlin.coroutines.Continuation r6 = r2.getReadOp()
            if (r6 != 0) goto L8e
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        L8e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Read operation is already in progress"
            r6.<init>(r7)
            throw r6
        L96:
            java.lang.Throwable r6 = r7.getCause()
            io.ktor.utils.p098io.ByteBufferChannelKt.access$rethrowClosed(r6)
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.readSuspendLoop(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean readSuspendPredicate(int size) {
        ReadWriteBufferState state = getState();
        return state.capacity._availableForRead$internal < size && (this.joining == null || getWriteOp() == null || !(state == ReadWriteBufferState.IdleEmpty.INSTANCE || (state instanceof ReadWriteBufferState.IdleNonEmpty)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldResumeReadOp() {
        return this.joining != null && (getState() == ReadWriteBufferState.IdleEmpty.INSTANCE || (getState() instanceof ReadWriteBufferState.IdleNonEmpty));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean writeSuspendPredicate(int size) {
        JoiningState joiningState = this.joining;
        ReadWriteBufferState state = getState();
        if (getClosed() != null) {
            return false;
        }
        if (joiningState != null) {
            if (state == ReadWriteBufferState.Terminated.INSTANCE || (state instanceof ReadWriteBufferState.Writing) || (state instanceof ReadWriteBufferState.ReadingWriting)) {
                return false;
            }
        } else if (state.capacity._availableForWrite$internal >= size || state == ReadWriteBufferState.IdleEmpty.INSTANCE) {
            return false;
        }
        return true;
    }

    public final Object tryWriteSuspend$ktor_io(int i, Continuation<? super Unit> continuation) throws Throwable {
        Throwable sendException;
        if (!writeSuspendPredicate(i)) {
            ClosedElement closed = getClosed();
            if (closed != null && (sendException = closed.getSendException()) != null) {
                ByteBufferChannelKt.rethrowClosed(sendException);
                throw new KotlinNothingValueException();
            }
            if (IntrinsicsKt.getCOROUTINE_SUSPENDED() == null) {
                return null;
            }
            return Unit.INSTANCE;
        }
        this.writeSuspensionSize = i;
        if (this.attachedJob != null) {
            Object objInvoke = this.writeSuspension.invoke(continuation);
            if (objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
        }
        CancellableReusableContinuation<Unit> cancellableReusableContinuation = this.writeSuspendContinuationCache;
        this.writeSuspension.invoke(cancellableReusableContinuation);
        Object objCompleteSuspendBlock = cancellableReusableContinuation.completeSuspendBlock(IntrinsicsKt.intercepted(continuation));
        if (objCompleteSuspendBlock == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objCompleteSuspendBlock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCompleteSuspendBlock : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a2, code lost:
    
        r2.flushImpl(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a9, code lost:
    
        if (r2.shouldResumeReadOp() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ab, code lost:
    
        r2.resumeReadOp();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ae, code lost:
    
        r11 = r11.getResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b6, code lost:
    
        if (r11 != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b8, code lost:
    
        kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bb, code lost:
    
        if (r11 != r1) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bd, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeSuspend(int r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeSuspend(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final ReadWriteBufferState.Initial newBuffer() {
        ReadWriteBufferState.Initial initialBorrow = this.pool.borrow();
        initialBorrow.getReadBuffer().order(getReadByteOrder().getNioOrder());
        initialBorrow.getWriteBuffer().order(getWriteByteOrder().getNioOrder());
        initialBorrow.capacity.resetForWrite();
        return initialBorrow;
    }

    private final void releaseBuffer(ReadWriteBufferState.Initial buffer) {
        this.pool.recycle(buffer);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX INFO: renamed from: peekTo-vHUFkk8$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object m6938peekTovHUFkk8$suspendImpl(io.ktor.utils.p098io.ByteBufferChannel r16, final java.nio.ByteBuffer r17, final long r18, final long r20, long r22, final long r24, kotlin.coroutines.Continuation r26) {
        /*
            r0 = r16
            r1 = r26
            boolean r2 = r1 instanceof io.ktor.utils.p098io.ByteBufferChannel$peekTo$1
            if (r2 == 0) goto L18
            r2 = r1
            io.ktor.utils.io.ByteBufferChannel$peekTo$1 r2 = (io.ktor.utils.p098io.ByteBufferChannel$peekTo$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            io.ktor.utils.io.ByteBufferChannel$peekTo$1 r2 = new io.ktor.utils.io.ByteBufferChannel$peekTo$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L3a
            if (r4 != r5) goto L32
            java.lang.Object r0 = r2.L$0
            kotlin.jvm.internal.Ref$IntRef r0 = (kotlin.jvm.internal.Ref.IntRef) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L68
        L32:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3a:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$IntRef r1 = new kotlin.jvm.internal.Ref$IntRef
            r1.<init>()
            long r6 = r22 + r20
            r8 = 4088(0xff8, double:2.0197E-320)
            long r6 = kotlin.ranges.RangesKt.coerceAtMost(r6, r8)
            int r4 = (int) r6
            io.ktor.utils.io.ByteBufferChannel$peekTo$2 r15 = new io.ktor.utils.io.ByteBufferChannel$peekTo$2
            r6 = r15
            r7 = r20
            r9 = r24
            r11 = r17
            r12 = r18
            r14 = r1
            r6.<init>()
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            r2.L$0 = r1
            r2.label = r5
            java.lang.Object r0 = r0.read(r4, r15, r2)
            if (r0 != r3) goto L67
            return r3
        L67:
            r0 = r1
        L68:
            int r0 = r0.element
            long r0 = (long) r0
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.m6938peekTovHUFkk8$suspendImpl(io.ktor.utils.io.ByteBufferChannel, java.nio.ByteBuffer, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public String toString() {
        return "ByteBufferChannel(" + hashCode() + ", " + getState() + ')';
    }

    public final void restoreStateAfterWrite$ktor_io() {
        Object obj;
        ReadWriteBufferState readWriteBufferStateStopWriting$ktor_io;
        ReadWriteBufferState.IdleNonEmpty idleNonEmpty;
        ReadWriteBufferState readWriteBufferState = null;
        do {
            obj = this._state;
            readWriteBufferStateStopWriting$ktor_io = ((ReadWriteBufferState) obj).stopWriting$ktor_io();
            if ((readWriteBufferStateStopWriting$ktor_io instanceof ReadWriteBufferState.IdleNonEmpty) && readWriteBufferStateStopWriting$ktor_io.capacity.isEmpty()) {
                readWriteBufferStateStopWriting$ktor_io = ReadWriteBufferState.IdleEmpty.INSTANCE;
                readWriteBufferState = readWriteBufferStateStopWriting$ktor_io;
            }
        } while (!C0526xc40028dd.m1169m(_state$FU, this, obj, readWriteBufferStateStopWriting$ktor_io));
        if (readWriteBufferStateStopWriting$ktor_io != ReadWriteBufferState.IdleEmpty.INSTANCE || (idleNonEmpty = (ReadWriteBufferState.IdleNonEmpty) readWriteBufferState) == null) {
            return;
        }
        releaseBuffer(idleNonEmpty.getInitial());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ByteBuffer setupStateForRead() throws Throwable {
        Object obj;
        Throwable cause;
        Throwable cause2;
        ReadWriteBufferState readWriteBufferStateStartReading$ktor_io;
        Throwable cause3;
        do {
            obj = this._state;
            ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) obj;
            if (Intrinsics.areEqual(readWriteBufferState, ReadWriteBufferState.Terminated.INSTANCE)) {
                ClosedElement closed = getClosed();
                if (closed == null || (cause = closed.getCause()) == null) {
                    return null;
                }
                ByteBufferChannelKt.rethrowClosed(cause);
                throw new KotlinNothingValueException();
            }
            if (Intrinsics.areEqual(readWriteBufferState, ReadWriteBufferState.IdleEmpty.INSTANCE)) {
                ClosedElement closed2 = getClosed();
                if (closed2 == null || (cause2 = closed2.getCause()) == null) {
                    return null;
                }
                ByteBufferChannelKt.rethrowClosed(cause2);
                throw new KotlinNothingValueException();
            }
            ClosedElement closed3 = getClosed();
            if (closed3 != null && (cause3 = closed3.getCause()) != null) {
                ByteBufferChannelKt.rethrowClosed(cause3);
                throw new KotlinNothingValueException();
            }
            if (readWriteBufferState.capacity._availableForRead$internal == 0) {
                return null;
            }
            readWriteBufferStateStartReading$ktor_io = readWriteBufferState.startReading$ktor_io();
        } while (!C0526xc40028dd.m1169m(_state$FU, this, obj, readWriteBufferStateStartReading$ktor_io));
        ByteBuffer readBuffer = readWriteBufferStateStartReading$ktor_io.getReadBuffer();
        prepareBuffer(readBuffer, getReadByteOrder(), this.readPosition, readWriteBufferStateStartReading$ktor_io.capacity._availableForRead$internal);
        return readBuffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restoreStateAfterRead() {
        Object obj;
        ReadWriteBufferState readWriteBufferStateStopReading$ktor_io;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ReadWriteBufferState readWriteBufferState = null;
        do {
            obj = this._state;
            ReadWriteBufferState readWriteBufferState2 = (ReadWriteBufferState) obj;
            ReadWriteBufferState.IdleNonEmpty idleNonEmpty = (ReadWriteBufferState.IdleNonEmpty) readWriteBufferState;
            if (idleNonEmpty != null) {
                idleNonEmpty.capacity.resetForWrite();
                resumeWriteOp();
                readWriteBufferState = null;
            }
            readWriteBufferStateStopReading$ktor_io = readWriteBufferState2.stopReading$ktor_io();
            if ((readWriteBufferStateStopReading$ktor_io instanceof ReadWriteBufferState.IdleNonEmpty) && getState() == readWriteBufferState2 && readWriteBufferStateStopReading$ktor_io.capacity.tryLockForRelease()) {
                readWriteBufferStateStopReading$ktor_io = ReadWriteBufferState.IdleEmpty.INSTANCE;
                readWriteBufferState = readWriteBufferStateStopReading$ktor_io;
            }
            atomicReferenceFieldUpdater = _state$FU;
        } while (!C0526xc40028dd.m1169m(atomicReferenceFieldUpdater, this, obj, readWriteBufferStateStopReading$ktor_io));
        if (readWriteBufferStateStopReading$ktor_io == ReadWriteBufferState.IdleEmpty.INSTANCE) {
            ReadWriteBufferState.IdleNonEmpty idleNonEmpty2 = (ReadWriteBufferState.IdleNonEmpty) readWriteBufferState;
            if (idleNonEmpty2 != null) {
                releaseBuffer(idleNonEmpty2.getInitial());
            }
            resumeWriteOp();
            return;
        }
        if ((readWriteBufferStateStopReading$ktor_io instanceof ReadWriteBufferState.IdleNonEmpty) && readWriteBufferStateStopReading$ktor_io.capacity.isEmpty() && readWriteBufferStateStopReading$ktor_io.capacity.tryLockForRelease() && C0526xc40028dd.m1169m(atomicReferenceFieldUpdater, this, readWriteBufferStateStopReading$ktor_io, ReadWriteBufferState.IdleEmpty.INSTANCE)) {
            readWriteBufferStateStopReading$ktor_io.capacity.resetForWrite();
            releaseBuffer(((ReadWriteBufferState.IdleNonEmpty) readWriteBufferStateStopReading$ktor_io).getInitial());
            resumeWriteOp();
        }
    }

    private final boolean tryReleaseBuffer(boolean forceTermination) {
        Object obj;
        ReadWriteBufferState.Terminated terminated;
        ReadWriteBufferState.Initial initial = null;
        do {
            obj = this._state;
            ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) obj;
            if (initial != null) {
                initial.capacity.resetForWrite();
                resumeWriteOp();
                initial = null;
            }
            ClosedElement closed = getClosed();
            if (readWriteBufferState == ReadWriteBufferState.Terminated.INSTANCE) {
                return true;
            }
            if (readWriteBufferState == ReadWriteBufferState.IdleEmpty.INSTANCE) {
                terminated = ReadWriteBufferState.Terminated.INSTANCE;
            } else if (closed != null && (readWriteBufferState instanceof ReadWriteBufferState.IdleNonEmpty) && (readWriteBufferState.capacity.tryLockForRelease() || closed.getCause() != null)) {
                if (closed.getCause() != null) {
                    readWriteBufferState.capacity.forceLockForRelease();
                }
                initial = ((ReadWriteBufferState.IdleNonEmpty) readWriteBufferState).getInitial();
                terminated = ReadWriteBufferState.Terminated.INSTANCE;
            } else {
                if (!forceTermination || !(readWriteBufferState instanceof ReadWriteBufferState.IdleNonEmpty) || !readWriteBufferState.capacity.tryLockForRelease()) {
                    return false;
                }
                initial = ((ReadWriteBufferState.IdleNonEmpty) readWriteBufferState).getInitial();
                terminated = ReadWriteBufferState.Terminated.INSTANCE;
            }
        } while (!C0526xc40028dd.m1169m(_state$FU, this, obj, terminated));
        if (initial != null && getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            releaseBuffer(initial);
        }
        return true;
    }

    private final int readAsMuchAsPossible(ByteBuffer dst) throws Throwable {
        ByteBuffer byteBuffer = setupStateForRead();
        int i = 0;
        if (byteBuffer != null) {
            RingBufferCapacity ringBufferCapacity = getState().capacity;
            try {
                if (ringBufferCapacity._availableForRead$internal != 0) {
                    int iCapacity = byteBuffer.capacity() - getReservedSize();
                    while (true) {
                        int iRemaining = dst.remaining();
                        if (iRemaining == 0) {
                            break;
                        }
                        int i2 = this.readPosition;
                        int iTryReadAtMost = ringBufferCapacity.tryReadAtMost(Math.min(iCapacity - i2, iRemaining));
                        if (iTryReadAtMost == 0) {
                            break;
                        }
                        dst.put(byteBuffer);
                        bytesRead(byteBuffer, ringBufferCapacity, iTryReadAtMost);
                        i += iTryReadAtMost;
                    }
                }
            } finally {
                restoreStateAfterRead();
                tryTerminate$ktor_io();
            }
        }
        return i;
    }

    private final int readAsMuchAsPossible(Buffer dst, int consumed, int max) throws Throwable {
        int iTryReadAtMost;
        do {
            ByteBuffer byteBuffer = setupStateForRead();
            boolean z = false;
            if (byteBuffer == null) {
                iTryReadAtMost = 0;
            } else {
                RingBufferCapacity ringBufferCapacity = getState().capacity;
                try {
                    if (ringBufferCapacity._availableForRead$internal == 0) {
                        iTryReadAtMost = 0;
                    } else {
                        int limit = dst.getLimit() - dst.getWritePosition();
                        iTryReadAtMost = ringBufferCapacity.tryReadAtMost(Math.min(byteBuffer.remaining(), Math.min(limit, max)));
                        if (iTryReadAtMost > 0) {
                            if (limit < byteBuffer.remaining()) {
                            }
                            BufferPrimitivesJvmKt.writeFully(dst, byteBuffer);
                            bytesRead(byteBuffer, ringBufferCapacity, iTryReadAtMost);
                            z = true;
                        }
                    }
                } finally {
                    restoreStateAfterRead();
                    tryTerminate$ktor_io();
                }
            }
            consumed += iTryReadAtMost;
            max -= iTryReadAtMost;
            if (!z || dst.getLimit() <= dst.getWritePosition()) {
                break;
            }
        } while (getState().capacity._availableForRead$internal > 0);
        return consumed;
    }

    static /* synthetic */ int readAsMuchAsPossible$default(ByteBufferChannel byteBufferChannel, Buffer buffer, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readAsMuchAsPossible");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = buffer.getLimit() - buffer.getWritePosition();
        }
        return byteBufferChannel.readAsMuchAsPossible(buffer, i, i2);
    }

    private final int readAsMuchAsPossible(byte[] dst, int offset, int length) throws Throwable {
        ByteBuffer byteBuffer = setupStateForRead();
        int i = 0;
        if (byteBuffer != null) {
            RingBufferCapacity ringBufferCapacity = getState().capacity;
            try {
                if (ringBufferCapacity._availableForRead$internal != 0) {
                    int iCapacity = byteBuffer.capacity() - getReservedSize();
                    while (true) {
                        int i2 = length - i;
                        if (i2 == 0) {
                            break;
                        }
                        int i3 = this.readPosition;
                        int iTryReadAtMost = ringBufferCapacity.tryReadAtMost(Math.min(iCapacity - i3, i2));
                        if (iTryReadAtMost == 0) {
                            break;
                        }
                        byteBuffer.get(dst, offset + i, iTryReadAtMost);
                        bytesRead(byteBuffer, ringBufferCapacity, iTryReadAtMost);
                        i += iTryReadAtMost;
                    }
                }
            } finally {
                restoreStateAfterRead();
                tryTerminate$ktor_io();
            }
        }
        return i;
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public int readAvailable(int min, Function1<? super ByteBuffer, Unit> block) throws Throwable {
        int i;
        Intrinsics.checkNotNullParameter(block, "block");
        int i2 = 1;
        if (!(min > 0)) {
            throw new IllegalArgumentException("min should be positive".toString());
        }
        if (min <= 4088) {
            ByteBuffer byteBuffer = setupStateForRead();
            if (byteBuffer == null) {
                i = 0;
            } else {
                RingBufferCapacity ringBufferCapacity = getState().capacity;
                try {
                    if (ringBufferCapacity._availableForRead$internal == 0) {
                        i = 0;
                    } else {
                        int iTryReadAtLeast = ringBufferCapacity.tryReadAtLeast(min);
                        if (iTryReadAtLeast <= 0 || iTryReadAtLeast < min) {
                            i2 = 0;
                        } else {
                            int iPosition = byteBuffer.position();
                            int iLimit = byteBuffer.limit();
                            block.invoke(byteBuffer);
                            if (!(iLimit == byteBuffer.limit())) {
                                throw new IllegalStateException("Buffer limit shouldn't be modified.".toString());
                            }
                            int iPosition2 = byteBuffer.position() - iPosition;
                            if ((iPosition2 >= 0 ? 1 : 0) == 0) {
                                throw new IllegalStateException("Position shouldn't been moved backwards.".toString());
                            }
                            bytesRead(byteBuffer, ringBufferCapacity, iPosition2);
                            if (iPosition2 < iTryReadAtLeast) {
                                ringBufferCapacity.completeWrite(iTryReadAtLeast - iPosition2);
                            }
                            i = iPosition2;
                        }
                        restoreStateAfterRead();
                        tryTerminate$ktor_io();
                        i = i;
                        i = i2;
                    }
                } finally {
                    restoreStateAfterRead();
                    tryTerminate$ktor_io();
                }
            }
            if (i == 0) {
                return -1;
            }
            return i;
        }
        throw new IllegalArgumentException(("Min(" + min + ") shouldn't be greater than 4088").toString());
    }

    private final <T extends Number> Object readPrimitive(int i, Function1<? super ByteBuffer, ? extends T> function1, Continuation<? super T> continuation) throws Throwable {
        T tInvoke;
        boolean z;
        Object suspend;
        do {
            ByteBuffer byteBuffer = setupStateForRead();
            if (byteBuffer == null) {
                tInvoke = null;
                z = false;
            } else {
                RingBufferCapacity ringBufferCapacity = getState().capacity;
                try {
                    if (ringBufferCapacity._availableForRead$internal == 0) {
                        tInvoke = null;
                        z = false;
                    } else if (ringBufferCapacity.tryReadExact(i)) {
                        if (byteBuffer.remaining() < i) {
                            rollBytes(byteBuffer, i);
                        }
                        tInvoke = function1.invoke(byteBuffer);
                        bytesRead(byteBuffer, ringBufferCapacity, i);
                        z = true;
                    } else {
                        tInvoke = null;
                        z = false;
                    }
                } finally {
                    InlineMarker.finallyStart(1);
                    restoreStateAfterRead();
                    tryTerminate$ktor_io();
                    InlineMarker.finallyEnd(1);
                }
            }
            if (z) {
                if (tInvoke != null) {
                    return tInvoke;
                }
                Intrinsics.throwUninitializedPropertyAccessException("result");
                return null;
            }
            InlineMarker.mark(0);
            suspend = readSuspend(i, continuation);
            InlineMarker.mark(1);
        } while (((Boolean) suspend).booleanValue());
        throw new ClosedReceiveChannelException("EOF while " + i + " bytes expected");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005a A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int writeAsMuchAsPossible(java.nio.ByteBuffer r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeAsMuchAsPossible(java.nio.ByteBuffer):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004f A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int writeAsMuchAsPossible(io.ktor.utils.p098io.core.Buffer r11) throws java.lang.Throwable {
        /*
            r10 = this;
            io.ktor.utils.io.internal.JoiningState r0 = access$getJoining$p(r10)
            if (r0 != 0) goto L7
            goto Ld
        L7:
            io.ktor.utils.io.ByteBufferChannel r0 = access$resolveDelegation(r10, r10, r0)
            if (r0 != 0) goto Le
        Ld:
            r0 = r10
        Le:
            java.nio.ByteBuffer r1 = r0.setupStateForWrite$ktor_io()
            r2 = 0
            if (r1 != 0) goto L16
            return r2
        L16:
            io.ktor.utils.io.internal.ReadWriteBufferState r3 = access$getState(r0)
            io.ktor.utils.io.internal.RingBufferCapacity r3 = r3.capacity
            long r4 = r0.getTotalBytesWritten()
            io.ktor.utils.io.internal.ClosedElement r6 = access$getClosed(r0)     // Catch: java.lang.Throwable -> L8a
            if (r6 != 0) goto L7d
            r6 = r0
            io.ktor.utils.io.ByteBufferChannel r6 = (io.ktor.utils.p098io.ByteBufferChannel) r6     // Catch: java.lang.Throwable -> L8a
        L29:
            int r6 = r11.getWritePosition()     // Catch: java.lang.Throwable -> L8a
            int r7 = r11.getReadPosition()     // Catch: java.lang.Throwable -> L8a
            int r6 = r6 - r7
            int r7 = r1.remaining()     // Catch: java.lang.Throwable -> L8a
            int r6 = java.lang.Math.min(r6, r7)     // Catch: java.lang.Throwable -> L8a
            int r6 = r3.tryWriteAtMost(r6)     // Catch: java.lang.Throwable -> L8a
            if (r6 != 0) goto L68
            r0.bytesWritten(r1, r3, r2)     // Catch: java.lang.Throwable -> L8a
            boolean r11 = r3.isFull()
            if (r11 != 0) goto L4f
            boolean r11 = r0.getAutoFlush()
            if (r11 == 0) goto L52
        L4f:
            r0.flush()
        L52:
            if (r0 == r10) goto L61
            long r6 = r10.getTotalBytesWritten()
            long r8 = r0.getTotalBytesWritten()
            long r8 = r8 - r4
            long r6 = r6 + r8
            r10.setTotalBytesWritten$ktor_io(r6)
        L61:
            r0.restoreStateAfterWrite$ktor_io()
            r0.tryTerminate$ktor_io()
            return r2
        L68:
            io.ktor.utils.p098io.core.IoBufferJVMKt.readFully(r11, r1, r6)     // Catch: java.lang.Throwable -> L8a
            int r2 = r2 + r6
            io.ktor.utils.io.core.ByteOrder r6 = r0.getWriteByteOrder()     // Catch: java.lang.Throwable -> L8a
            int r7 = r0.writePosition     // Catch: java.lang.Throwable -> L8a
            int r7 = r7 + r2
            int r7 = r0.carryIndex(r1, r7)     // Catch: java.lang.Throwable -> L8a
            int r8 = r3._availableForWrite$internal     // Catch: java.lang.Throwable -> L8a
            r0.prepareBuffer(r1, r6, r7, r8)     // Catch: java.lang.Throwable -> L8a
            goto L29
        L7d:
            java.lang.Throwable r11 = r6.getSendException()     // Catch: java.lang.Throwable -> L8a
            io.ktor.utils.p098io.ByteBufferChannelKt.access$rethrowClosed(r11)     // Catch: java.lang.Throwable -> L8a
            kotlin.KotlinNothingValueException r11 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L8a
            r11.<init>()     // Catch: java.lang.Throwable -> L8a
            throw r11     // Catch: java.lang.Throwable -> L8a
        L8a:
            r11 = move-exception
            boolean r1 = r3.isFull()
            if (r1 != 0) goto L97
            boolean r1 = r0.getAutoFlush()
            if (r1 == 0) goto L9a
        L97:
            r0.flush()
        L9a:
            if (r0 == r10) goto La9
            long r1 = r10.getTotalBytesWritten()
            long r6 = r0.getTotalBytesWritten()
            long r6 = r6 - r4
            long r1 = r1 + r6
            r10.setTotalBytesWritten$ktor_io(r1)
        La9:
            r0.restoreStateAfterWrite$ktor_io()
            r0.tryTerminate$ktor_io()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeAsMuchAsPossible(io.ktor.utils.io.core.Buffer):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int writeAsMuchAsPossible(byte[] r11, int r12, int r13) throws java.lang.Throwable {
        /*
            r10 = this;
            io.ktor.utils.io.internal.JoiningState r0 = access$getJoining$p(r10)
            if (r0 != 0) goto L7
            goto Ld
        L7:
            io.ktor.utils.io.ByteBufferChannel r0 = access$resolveDelegation(r10, r10, r0)
            if (r0 != 0) goto Le
        Ld:
            r0 = r10
        Le:
            java.nio.ByteBuffer r1 = r0.setupStateForWrite$ktor_io()
            r2 = 0
            if (r1 != 0) goto L16
            return r2
        L16:
            io.ktor.utils.io.internal.ReadWriteBufferState r3 = access$getState(r0)
            io.ktor.utils.io.internal.RingBufferCapacity r3 = r3.capacity
            long r4 = r0.getTotalBytesWritten()
            io.ktor.utils.io.internal.ClosedElement r6 = access$getClosed(r0)     // Catch: java.lang.Throwable -> L9b
            if (r6 != 0) goto L8e
            r6 = r0
            io.ktor.utils.io.ByteBufferChannel r6 = (io.ktor.utils.p098io.ByteBufferChannel) r6     // Catch: java.lang.Throwable -> L9b
            r6 = r2
        L2a:
            int r7 = r13 - r6
            int r8 = r1.remaining()     // Catch: java.lang.Throwable -> L9b
            int r7 = java.lang.Math.min(r7, r8)     // Catch: java.lang.Throwable -> L9b
            int r7 = r3.tryWriteAtMost(r7)     // Catch: java.lang.Throwable -> L9b
            if (r7 != 0) goto L62
            r0.bytesWritten(r1, r3, r6)     // Catch: java.lang.Throwable -> L9b
            boolean r11 = r3.isFull()
            if (r11 != 0) goto L49
            boolean r11 = r0.getAutoFlush()
            if (r11 == 0) goto L4c
        L49:
            r0.flush()
        L4c:
            if (r0 == r10) goto L5b
            long r11 = r10.getTotalBytesWritten()
            long r1 = r0.getTotalBytesWritten()
            long r1 = r1 - r4
            long r11 = r11 + r1
            r10.setTotalBytesWritten$ktor_io(r11)
        L5b:
            r0.restoreStateAfterWrite$ktor_io()
            r0.tryTerminate$ktor_io()
            return r6
        L62:
            if (r7 <= 0) goto L66
            r8 = 1
            goto L67
        L66:
            r8 = r2
        L67:
            if (r8 == 0) goto L80
            int r8 = r12 + r6
            r1.put(r11, r8, r7)     // Catch: java.lang.Throwable -> L9b
            int r6 = r6 + r7
            io.ktor.utils.io.core.ByteOrder r7 = r0.getWriteByteOrder()     // Catch: java.lang.Throwable -> L9b
            int r8 = r0.writePosition     // Catch: java.lang.Throwable -> L9b
            int r8 = r8 + r6
            int r8 = r0.carryIndex(r1, r8)     // Catch: java.lang.Throwable -> L9b
            int r9 = r3._availableForWrite$internal     // Catch: java.lang.Throwable -> L9b
            r0.prepareBuffer(r1, r7, r8, r9)     // Catch: java.lang.Throwable -> L9b
            goto L2a
        L80:
            java.lang.String r11 = "Failed requirement."
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L9b
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L9b
            r12.<init>(r11)     // Catch: java.lang.Throwable -> L9b
            java.lang.Throwable r12 = (java.lang.Throwable) r12     // Catch: java.lang.Throwable -> L9b
            throw r12     // Catch: java.lang.Throwable -> L9b
        L8e:
            java.lang.Throwable r11 = r6.getSendException()     // Catch: java.lang.Throwable -> L9b
            io.ktor.utils.p098io.ByteBufferChannelKt.access$rethrowClosed(r11)     // Catch: java.lang.Throwable -> L9b
            kotlin.KotlinNothingValueException r11 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L9b
            r11.<init>()     // Catch: java.lang.Throwable -> L9b
            throw r11     // Catch: java.lang.Throwable -> L9b
        L9b:
            r11 = move-exception
            boolean r12 = r3.isFull()
            if (r12 != 0) goto La8
            boolean r12 = r0.getAutoFlush()
            if (r12 == 0) goto Lab
        La8:
            r0.flush()
        Lab:
            if (r0 == r10) goto Lba
            long r12 = r10.getTotalBytesWritten()
            long r1 = r0.getTotalBytesWritten()
            long r1 = r1 - r4
            long r12 = r12 + r1
            r10.setTotalBytesWritten$ktor_io(r12)
        Lba:
            r0.restoreStateAfterWrite$ktor_io()
            r0.tryTerminate$ktor_io()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeAsMuchAsPossible(byte[], int, int):int");
    }

    /* JADX WARN: Finally extract failed */
    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public int writeAvailable(int min, Function1<? super ByteBuffer, Unit> block) throws Throwable {
        ByteBufferChannel byteBufferChannelResolveDelegation;
        int i;
        Intrinsics.checkNotNullParameter(block, "block");
        int i2 = 1;
        if (!(min > 0)) {
            throw new IllegalArgumentException("min should be positive".toString());
        }
        if (min <= 4088) {
            JoiningState joiningState = this.joining;
            if (joiningState == null || (byteBufferChannelResolveDelegation = resolveDelegation(this, joiningState)) == null) {
                byteBufferChannelResolveDelegation = this;
            }
            ByteBuffer byteBuffer = byteBufferChannelResolveDelegation.setupStateForWrite$ktor_io();
            if (byteBuffer == null) {
                i = 0;
            } else {
                RingBufferCapacity ringBufferCapacity = byteBufferChannelResolveDelegation.getState().capacity;
                long totalBytesWritten = byteBufferChannelResolveDelegation.getTotalBytesWritten();
                try {
                    ClosedElement closed = byteBufferChannelResolveDelegation.getClosed();
                    if (closed != null) {
                        ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                        throw new KotlinNothingValueException();
                    }
                    ByteBufferChannel byteBufferChannel = byteBufferChannelResolveDelegation;
                    int iTryWriteAtLeast = ringBufferCapacity.tryWriteAtLeast(min);
                    if (iTryWriteAtLeast <= 0) {
                        i2 = 0;
                    } else {
                        byteBufferChannelResolveDelegation.prepareBuffer(byteBuffer, byteBufferChannelResolveDelegation.getWriteByteOrder(), byteBufferChannelResolveDelegation.writePosition, iTryWriteAtLeast);
                        int iPosition = byteBuffer.position();
                        int iLimit = byteBuffer.limit();
                        block.invoke(byteBuffer);
                        if (!(iLimit == byteBuffer.limit())) {
                            throw new IllegalStateException("Buffer limit modified".toString());
                        }
                        int iPosition2 = byteBuffer.position() - iPosition;
                        if ((iPosition2 >= 0 ? 1 : 0) == 0) {
                            throw new IllegalStateException("Position has been moved backward: pushback is not supported".toString());
                        }
                        if (iPosition2 < 0) {
                            throw new IllegalStateException();
                        }
                        byteBufferChannelResolveDelegation.bytesWritten(byteBuffer, ringBufferCapacity, iPosition2);
                        if (iPosition2 < iTryWriteAtLeast) {
                            ringBufferCapacity.completeRead(iTryWriteAtLeast - iPosition2);
                        }
                        i = iPosition2;
                    }
                    if (ringBufferCapacity.isFull() || byteBufferChannelResolveDelegation.getAutoFlush()) {
                        byteBufferChannelResolveDelegation.flush();
                    }
                    if (byteBufferChannelResolveDelegation != this) {
                        setTotalBytesWritten$ktor_io(getTotalBytesWritten() + (byteBufferChannelResolveDelegation.getTotalBytesWritten() - totalBytesWritten));
                    }
                    byteBufferChannelResolveDelegation.restoreStateAfterWrite$ktor_io();
                    byteBufferChannelResolveDelegation.tryTerminate$ktor_io();
                    i = i;
                    i = i2;
                } catch (Throwable th) {
                    if (ringBufferCapacity.isFull() || byteBufferChannelResolveDelegation.getAutoFlush()) {
                        byteBufferChannelResolveDelegation.flush();
                    }
                    if (byteBufferChannelResolveDelegation != this) {
                        setTotalBytesWritten$ktor_io(getTotalBytesWritten() + (byteBufferChannelResolveDelegation.getTotalBytesWritten() - totalBytesWritten));
                    }
                    byteBufferChannelResolveDelegation.restoreStateAfterWrite$ktor_io();
                    byteBufferChannelResolveDelegation.tryTerminate$ktor_io();
                    throw th;
                }
            }
            if (i == 0) {
                return -1;
            }
            return i;
        }
        throw new IllegalArgumentException(("Min(" + min + ") shouldn't be greater than 4088").toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0039 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean writeWhileNoSuspend(kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            io.ktor.utils.io.internal.JoiningState r0 = access$getJoining$p(r7)
            if (r0 != 0) goto L7
            goto Ld
        L7:
            io.ktor.utils.io.ByteBufferChannel r0 = access$resolveDelegation(r7, r7, r0)
            if (r0 != 0) goto Le
        Ld:
            r0 = r7
        Le:
            java.nio.ByteBuffer r1 = r0.setupStateForWrite$ktor_io()
            if (r1 != 0) goto L16
            r8 = 1
            goto L51
        L16:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = access$getState(r0)
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.capacity
            long r3 = r0.getTotalBytesWritten()
            io.ktor.utils.io.internal.ClosedElement r5 = access$getClosed(r0)     // Catch: java.lang.Throwable -> L5f
            if (r5 != 0) goto L52
            r5 = r0
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.p098io.ByteBufferChannel) r5     // Catch: java.lang.Throwable -> L5f
            boolean r8 = r0.writeWhileLoop(r1, r2, r8)     // Catch: java.lang.Throwable -> L5f
            boolean r1 = r2.isFull()
            if (r1 != 0) goto L39
            boolean r1 = r0.getAutoFlush()
            if (r1 == 0) goto L3c
        L39:
            r0.flush()
        L3c:
            if (r0 == r7) goto L4b
            long r1 = r7.getTotalBytesWritten()
            long r5 = r0.getTotalBytesWritten()
            long r5 = r5 - r3
            long r1 = r1 + r5
            r7.setTotalBytesWritten$ktor_io(r1)
        L4b:
            r0.restoreStateAfterWrite$ktor_io()
            r0.tryTerminate$ktor_io()
        L51:
            return r8
        L52:
            java.lang.Throwable r8 = r5.getSendException()     // Catch: java.lang.Throwable -> L5f
            io.ktor.utils.p098io.ByteBufferChannelKt.access$rethrowClosed(r8)     // Catch: java.lang.Throwable -> L5f
            kotlin.KotlinNothingValueException r8 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L5f
            r8.<init>()     // Catch: java.lang.Throwable -> L5f
            throw r8     // Catch: java.lang.Throwable -> L5f
        L5f:
            r8 = move-exception
            boolean r1 = r2.isFull()
            if (r1 != 0) goto L6c
            boolean r1 = r0.getAutoFlush()
            if (r1 == 0) goto L6f
        L6c:
            r0.flush()
        L6f:
            if (r0 == r7) goto L7e
            long r1 = r7.getTotalBytesWritten()
            long r5 = r0.getTotalBytesWritten()
            long r5 = r5 - r3
            long r1 = r1 + r5
            r7.setTotalBytesWritten$ktor_io(r1)
        L7e:
            r0.restoreStateAfterWrite$ktor_io()
            r0.tryTerminate$ktor_io()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.writeWhileNoSuspend(kotlin.jvm.functions.Function1):boolean");
    }

    static /* synthetic */ Object read$suspendImpl(ByteBufferChannel byteBufferChannel, int i, Function1 function1, Continuation continuation) throws Throwable {
        boolean z = true;
        if (i >= 0) {
            ByteBuffer byteBuffer = byteBufferChannel.setupStateForRead();
            if (byteBuffer != null) {
                RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
                try {
                    if (ringBufferCapacity._availableForRead$internal != 0) {
                        int i2 = ringBufferCapacity._availableForRead$internal;
                        if (i2 <= 0 || i2 < i) {
                            z = false;
                        } else {
                            int iPosition = byteBuffer.position();
                            int iLimit = byteBuffer.limit();
                            function1.invoke(byteBuffer);
                            if (!(iLimit == byteBuffer.limit())) {
                                throw new IllegalStateException("Buffer limit modified.".toString());
                            }
                            int iPosition2 = byteBuffer.position() - iPosition;
                            if (!(iPosition2 >= 0)) {
                                throw new IllegalStateException("Position has been moved backward: pushback is not supported.".toString());
                            }
                            if (!ringBufferCapacity.tryReadExact(iPosition2)) {
                                throw new IllegalStateException("Check failed.".toString());
                            }
                            byteBufferChannel.bytesRead(byteBuffer, ringBufferCapacity, iPosition2);
                        }
                        byteBufferChannel.restoreStateAfterRead();
                        byteBufferChannel.tryTerminate$ktor_io();
                        z = z;
                    }
                } finally {
                    byteBufferChannel.restoreStateAfterRead();
                    byteBufferChannel.tryTerminate$ktor_io();
                }
            }
            if (!z) {
                if (byteBufferChannel.isClosedForRead()) {
                    return Unit.INSTANCE;
                }
                Object blockSuspend = byteBufferChannel.readBlockSuspend(i, function1, continuation);
                return blockSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? blockSuspend : Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalArgumentException("min should be positive or zero".toString());
    }

    static /* synthetic */ Object discard$suspendImpl(ByteBufferChannel byteBufferChannel, long j, Continuation continuation) throws Throwable {
        long j2 = 0;
        if (j >= 0) {
            ByteBuffer byteBuffer = byteBufferChannel.setupStateForRead();
            if (byteBuffer != null) {
                RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
                try {
                    if (ringBufferCapacity._availableForRead$internal != 0) {
                        int iTryReadAtMost = ringBufferCapacity.tryReadAtMost((int) Math.min(2147483647L, j));
                        byteBufferChannel.bytesRead(byteBuffer, ringBufferCapacity, iTryReadAtMost);
                        j2 = iTryReadAtMost;
                    }
                } finally {
                    byteBufferChannel.restoreStateAfterRead();
                    byteBufferChannel.tryTerminate$ktor_io();
                }
            }
            long j3 = j2;
            if (j3 == j || byteBufferChannel.isClosedForRead()) {
                return Boxing.boxLong(j3);
            }
            return byteBufferChannel.discardSuspend(j3, j, continuation);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("max shouldn't be negative: ", Boxing.boxLong(j)).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005a A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int tryWritePacketPart(io.ktor.utils.p098io.core.ByteReadPacket r10) throws java.lang.Throwable {
        /*
            r9 = this;
            io.ktor.utils.io.internal.JoiningState r0 = access$getJoining$p(r9)
            if (r0 != 0) goto L7
            goto Ld
        L7:
            io.ktor.utils.io.ByteBufferChannel r0 = access$resolveDelegation(r9, r9, r0)
            if (r0 != 0) goto Le
        Ld:
            r0 = r9
        Le:
            java.nio.ByteBuffer r1 = r0.setupStateForWrite$ktor_io()
            if (r1 != 0) goto L16
            r10 = 0
            goto L73
        L16:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = access$getState(r0)
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.capacity
            long r3 = r0.getTotalBytesWritten()
            io.ktor.utils.io.internal.ClosedElement r5 = access$getClosed(r0)     // Catch: java.lang.Throwable -> L81
            if (r5 != 0) goto L74
            r5 = r0
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.p098io.ByteBufferChannel) r5     // Catch: java.lang.Throwable -> L81
            long r5 = r10.getRemaining()     // Catch: java.lang.Throwable -> L81
            int r7 = r1.remaining()     // Catch: java.lang.Throwable -> L81
            long r7 = (long) r7     // Catch: java.lang.Throwable -> L81
            long r5 = java.lang.Math.min(r5, r7)     // Catch: java.lang.Throwable -> L81
            int r5 = (int) r5     // Catch: java.lang.Throwable -> L81
            int r5 = r2.tryWriteAtMost(r5)     // Catch: java.lang.Throwable -> L81
            if (r5 <= 0) goto L4e
            int r6 = r1.position()     // Catch: java.lang.Throwable -> L81
            int r6 = r6 + r5
            java.nio.Buffer r6 = r1.limit(r6)     // Catch: java.lang.Throwable -> L81
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6     // Catch: java.lang.Throwable -> L81
            io.ktor.utils.p098io.core.ByteBuffersKt.readFully(r10, r1)     // Catch: java.lang.Throwable -> L81
            r0.bytesWritten(r1, r2, r5)     // Catch: java.lang.Throwable -> L81
        L4e:
            boolean r10 = r2.isFull()
            if (r10 != 0) goto L5a
            boolean r10 = r0.getAutoFlush()
            if (r10 == 0) goto L5d
        L5a:
            r0.flush()
        L5d:
            if (r0 == r9) goto L6c
            long r1 = r9.getTotalBytesWritten()
            long r6 = r0.getTotalBytesWritten()
            long r6 = r6 - r3
            long r1 = r1 + r6
            r9.setTotalBytesWritten$ktor_io(r1)
        L6c:
            r0.restoreStateAfterWrite$ktor_io()
            r0.tryTerminate$ktor_io()
            r10 = r5
        L73:
            return r10
        L74:
            java.lang.Throwable r10 = r5.getSendException()     // Catch: java.lang.Throwable -> L81
            io.ktor.utils.p098io.ByteBufferChannelKt.access$rethrowClosed(r10)     // Catch: java.lang.Throwable -> L81
            kotlin.KotlinNothingValueException r10 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L81
            r10.<init>()     // Catch: java.lang.Throwable -> L81
            throw r10     // Catch: java.lang.Throwable -> L81
        L81:
            r10 = move-exception
            boolean r1 = r2.isFull()
            if (r1 != 0) goto L8e
            boolean r1 = r0.getAutoFlush()
            if (r1 == 0) goto L91
        L8e:
            r0.flush()
        L91:
            if (r0 == r9) goto La0
            long r1 = r9.getTotalBytesWritten()
            long r5 = r0.getTotalBytesWritten()
            long r5 = r5 - r3
            long r1 = r1 + r5
            r9.setTotalBytesWritten$ktor_io(r1)
        La0:
            r0.restoreStateAfterWrite$ktor_io()
            r0.tryTerminate$ktor_io()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.tryWritePacketPart(io.ktor.utils.io.core.ByteReadPacket):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    @Override // io.ktor.utils.p098io.ByteReadChannel
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object consumeEachBufferRange(kotlin.jvm.functions.Function2 r4, kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r3 = this;
            java.nio.ByteBuffer r0 = access$setupStateForRead(r3)
            if (r0 != 0) goto L7
            goto L1f
        L7:
            io.ktor.utils.io.internal.ReadWriteBufferState r1 = access$getState(r3)
            io.ktor.utils.io.internal.RingBufferCapacity r1 = r1.capacity
            int r2 = r1._availableForRead$internal     // Catch: java.lang.Throwable -> L5e
            if (r2 != 0) goto L18
        L11:
            access$restoreStateAfterRead(r3)
            r3.tryTerminate$ktor_io()
            goto L1f
        L18:
            boolean r2 = r0.hasRemaining()     // Catch: java.lang.Throwable -> L5e
            if (r2 != 0) goto L40
            goto L11
        L1f:
            io.ktor.utils.io.internal.ClosedElement r0 = access$getClosed(r3)
            if (r0 == 0) goto L32
            java.nio.ByteBuffer r5 = io.ktor.utils.p098io.internal.ReadWriteBufferStateKt.getEmptyByteBuffer()
            r0 = 1
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            r4.invoke(r5, r0)
            goto L5b
        L32:
            java.lang.Object r4 = r3.consumeEachBufferRangeSuspend(r4, r5)
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r5) goto L3d
            return r4
        L3d:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L40:
            r2 = 0
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r2 = r4.invoke(r0, r2)     // Catch: java.lang.Throwable -> L5e
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L5e
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L5e
            access$afterBufferVisited(r3, r0, r1)     // Catch: java.lang.Throwable -> L5e
            if (r2 == 0) goto L55
            goto L18
        L55:
            access$restoreStateAfterRead(r3)
            r3.tryTerminate$ktor_io()
        L5b:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L5e:
            r4 = move-exception
            access$restoreStateAfterRead(r3)
            r3.tryTerminate$ktor_io()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.consumeEachBufferRange(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
    
        kotlin.jvm.internal.InlineMarker.finallyStart(2);
        restoreStateAfterRead();
        tryTerminate$ktor_io();
        kotlin.jvm.internal.InlineMarker.finallyEnd(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean consumeEachBufferRangeFast(boolean r6, kotlin.jvm.functions.Function2<? super java.nio.ByteBuffer, ? super java.lang.Boolean, java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            java.nio.ByteBuffer r0 = access$setupStateForRead(r5)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto La
        L8:
            r6 = r1
            goto L35
        La:
            io.ktor.utils.io.internal.ReadWriteBufferState r3 = access$getState(r5)
            io.ktor.utils.io.internal.RingBufferCapacity r3 = r3.capacity
            int r4 = r3._availableForRead$internal     // Catch: java.lang.Throwable -> L73
            if (r4 != 0) goto L21
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            access$restoreStateAfterRead(r5)
            r5.tryTerminate$ktor_io()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            goto L8
        L21:
            boolean r1 = r0.hasRemaining()     // Catch: java.lang.Throwable -> L73
            if (r1 != 0) goto L4a
            if (r6 != 0) goto L4a
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            access$restoreStateAfterRead(r5)
            r5.tryTerminate$ktor_io()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
        L35:
            if (r6 != 0) goto L49
            io.ktor.utils.io.internal.ClosedElement r0 = access$getClosed(r5)
            if (r0 == 0) goto L49
            java.nio.ByteBuffer r6 = io.ktor.utils.p098io.internal.ReadWriteBufferStateKt.getEmptyByteBuffer()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            r7.invoke(r6, r0)
            return r2
        L49:
            return r6
        L4a:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r6)     // Catch: java.lang.Throwable -> L73
            java.lang.Object r1 = r7.invoke(r0, r1)     // Catch: java.lang.Throwable -> L73
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L73
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L73
            access$afterBufferVisited(r5, r0, r3)     // Catch: java.lang.Throwable -> L73
            if (r1 == 0) goto L65
            if (r6 == 0) goto L21
            boolean r1 = r0.hasRemaining()     // Catch: java.lang.Throwable -> L73
            if (r1 != 0) goto L21
        L65:
            r6 = 2
            kotlin.jvm.internal.InlineMarker.finallyStart(r6)
            access$restoreStateAfterRead(r5)
            r5.tryTerminate$ktor_io()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r6)
            return r2
        L73:
            r6 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            access$restoreStateAfterRead(r5)
            r5.tryTerminate$ktor_io()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.consumeEachBufferRangeFast(boolean, kotlin.jvm.functions.Function2):boolean");
    }

    private final ByteReadPacket remainingPacket(long limit, int headerSizeHint) {
        BytePacketBuilder BytePacketBuilder = PacketJVMKt.BytePacketBuilder(headerSizeHint);
        try {
            BytePacketBuilder bytePacketBuilder = BytePacketBuilder;
            ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(bytePacketBuilder, 1, (ChunkBuffer) null);
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                    if (chunkBuffer.getLimit() - chunkBuffer.getWritePosition() > limit) {
                        chunkBuffer.resetForWrite((int) limit);
                    }
                    limit -= (long) readAsMuchAsPossible$default(this, chunkBuffer, 0, 0, 6, null);
                    if (limit <= 0 || isClosedForRead()) {
                        break;
                    }
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(bytePacketBuilder, 1, chunkBufferPrepareWriteHead);
                } catch (Throwable th) {
                    UnsafeKt.afterHeadWrite(bytePacketBuilder, chunkBufferPrepareWriteHead);
                    throw th;
                }
            }
            UnsafeKt.afterHeadWrite(bytePacketBuilder, chunkBufferPrepareWriteHead);
            return BytePacketBuilder.build();
        } catch (Throwable th2) {
            BytePacketBuilder.release();
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e4, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        r7.resumeWith(kotlin.Result.m7233constructorimpl(true));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object suspensionForSize(int r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteBufferChannel.suspensionForSize(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readSuspendImpl(int i, Continuation<? super Boolean> continuation) throws Throwable {
        ReadWriteBufferState state = getState();
        if (state.capacity._availableForRead$internal >= i || (this.joining != null && getWriteOp() != null && (state == ReadWriteBufferState.IdleEmpty.INSTANCE || (state instanceof ReadWriteBufferState.IdleNonEmpty)))) {
            return Boxing.boxBoolean(true);
        }
        CancellableReusableContinuation<Boolean> cancellableReusableContinuation = this.readSuspendContinuationCache;
        suspensionForSize(i, cancellableReusableContinuation);
        Object objCompleteSuspendBlock = cancellableReusableContinuation.completeSuspendBlock(IntrinsicsKt.intercepted(continuation));
        if (objCompleteSuspendBlock == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objCompleteSuspendBlock;
    }
}
