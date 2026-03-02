package io.ktor.utils.p098io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.imageutils.JfifUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import io.ktor.utils.p098io.ByteChannel;
import io.ktor.utils.p098io.core.AbstractInput;
import io.ktor.utils.p098io.core.Buffer;
import io.ktor.utils.p098io.core.ByteOrder;
import io.ktor.utils.p098io.core.BytePacketBuilder;
import io.ktor.utils.p098io.core.ByteReadPacket;
import io.ktor.utils.p098io.core.ExperimentalIoApi;
import io.ktor.utils.p098io.core.InputArraysKt;
import io.ktor.utils.p098io.core.InputPrimitivesKt;
import io.ktor.utils.p098io.core.IoBuffer;
import io.ktor.utils.p098io.core.Output;
import io.ktor.utils.p098io.core.OutputKt;
import io.ktor.utils.p098io.core.PacketJVMKt;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import io.ktor.utils.p098io.core.internal.RequireFailureCapture;
import io.ktor.utils.p098io.core.internal.UTF8Kt;
import io.ktor.utils.p098io.core.internal.UnsafeKt;
import io.ktor.utils.p098io.internal.AwaitingSlot;
import io.ktor.utils.p098io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: ByteChannelSequential.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b,\b'\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0017\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB%\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\b\u0010Y\u001a\u00020ZH\u0005J\u0010\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u001dH\u0004J\b\u0010\\\u001a\u00020ZH\u0005J\u0010\u0010\\\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u001dH\u0004J\u0019\u0010]\u001a\u00020\n2\u0006\u0010^\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010_J\u001b\u0010`\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u001dH\u0080@ø\u0001\u0000¢\u0006\u0004\ba\u0010_J\u001b\u0010b\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u001dH\u0080@ø\u0001\u0000¢\u0006\u0004\bc\u0010_J\u0011\u0010d\u001a\u00020ZH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0013\u0010f\u001a\u00020\nH\u0080@ø\u0001\u0000¢\u0006\u0004\bg\u0010eJ\u0019\u0010h\u001a\u00020\n2\u0006\u0010^\u001a\u00020\u001dH\u0084@ø\u0001\u0000¢\u0006\u0002\u0010_J\b\u0010i\u001a\u00020jH\u0016J\u0012\u0010k\u001a\u00020\n2\b\u0010l\u001a\u0004\u0018\u00010&H\u0016J\u001c\u0010m\u001a\u00020Z2\u0006\u0010n\u001a\u00020\u001d2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010-H\u0002J\u0012\u0010p\u001a\u00020\n2\b\u0010l\u001a\u0004\u0018\u00010&H\u0016J\b\u0010q\u001a\u00020ZH\u0002J\u0010\u0010r\u001a\u00020\u001d2\u0006\u0010s\u001a\u00020\u001dH\u0016J\u0019\u0010r\u001a\u00020\u00112\u0006\u0010t\u001a\u00020\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010uJ!\u0010v\u001a\u00020\u00112\u0006\u0010t\u001a\u00020\u00112\u0006\u0010w\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010xJ\b\u0010y\u001a\u00020ZH\u0016J\u0010\u0010z\u001a\u00020Z2\u0006\u0010{\u001a\u00020\u001dH\u0016J\b\u0010|\u001a\u00020ZH\u0002J\b\u0010}\u001a\u00020ZH\u0002J\u0010\u0010}\u001a\u00020Z2\u0006\u0010o\u001a\u00020-H\u0002J\b\u0010~\u001a\u00020ZH\u0016J\b\u0010\u007f\u001a\u00020\nH\u0002J\t\u0010\u0080\u0001\u001a\u00020ZH\u0002JF\u0010\u0081\u0001\u001a\u00020\u00112\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u00112\u0007\u0010\u0085\u0001\u001a\u00020\u00112\u0007\u0010\u0086\u0001\u001a\u00020\u00112\u0006\u0010t\u001a\u00020\u0011H\u0086@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\t\u0010\u0089\u0001\u001a\u00020ZH\u0004J \u0010\u008a\u0001\u001a\u00020\u001d2\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0080@ø\u0001\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001c\u0010\u008a\u0001\u001a\u00020\u001d2\u0007\u0010\u008b\u0001\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u008f\u0001J/\u0010\u008a\u0001\u001a\u00020\u001d2\b\u0010\u008b\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u001d2\u0007\u0010\u0091\u0001\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u0092\u0001J\t\u0010\u0093\u0001\u001a\u00020\u001dH\u0004J\u0012\u0010\u0094\u0001\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0012\u0010\u0095\u0001\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0013\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0013\u0010\u0098\u0001\u001a\u00030\u0097\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0013\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0013\u0010\u009b\u0001\u001a\u00030\u009a\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0013\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0013\u0010\u009e\u0001\u001a\u00030\u009d\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010eJ%\u0010\u009f\u0001\u001a\u00020Z2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0006\u0010s\u001a\u00020\u001dH\u0082@ø\u0001\u0000¢\u0006\u0003\u0010 \u0001J$\u0010\u009f\u0001\u001a\u00020Z2\u0007\u0010\u008b\u0001\u001a\u00020\b2\u0006\u0010s\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0003\u0010¡\u0001J/\u0010\u009f\u0001\u001a\u00020Z2\b\u0010\u008b\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u001d2\u0007\u0010\u0091\u0001\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u0092\u0001J%\u0010¢\u0001\u001a\u00020Z2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0006\u0010s\u001a\u00020\u001dH\u0082@ø\u0001\u0000¢\u0006\u0003\u0010 \u0001J/\u0010¢\u0001\u001a\u00020Z2\b\u0010\u008b\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u001d2\u0007\u0010\u0091\u0001\u001a\u00020\u001dH\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u0092\u0001J\u0012\u0010£\u0001\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0012\u0010¤\u0001\u001a\u00020\u001dH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0012\u0010¥\u0001\u001a\u00020\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0012\u0010¦\u0001\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010eJ-\u0010§\u0001\u001a\u00030¨\u00012\u0006\u0010s\u001a\u00020\u001d2\u000f\u0010©\u0001\u001a\n\u0012\u0005\u0012\u00030¨\u00010ª\u0001H\u0082Hø\u0001\u0000¢\u0006\u0003\u0010«\u0001J%\u0010¬\u0001\u001a\u00020G2\u0007\u0010\u00ad\u0001\u001a\u00020\u001d2\u0007\u0010®\u0001\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0003\u0010¯\u0001J%\u0010°\u0001\u001a\u00020G2\u0007\u0010±\u0001\u001a\u00020-2\u0007\u0010\u00ad\u0001\u001a\u00020\u001dH\u0082@ø\u0001\u0000¢\u0006\u0003\u0010²\u0001J%\u0010³\u0001\u001a\u00020G2\u0007\u0010´\u0001\u001a\u00020\u00112\u0007\u0010®\u0001\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0003\u0010µ\u0001J%\u0010¶\u0001\u001a\u00020G2\u0007\u0010±\u0001\u001a\u00020-2\u0007\u0010´\u0001\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010·\u0001J&\u0010¸\u0001\u001a\u00020Z2\u001b\u0010¹\u0001\u001a\u0016\u0012\u0005\u0012\u00030»\u0001\u0012\u0004\u0012\u00020Z0º\u0001¢\u0006\u0003\b¼\u0001H\u0017J\u0013\u0010½\u0001\u001a\u00030¾\u0001H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0013\u0010¿\u0001\u001a\u00030¾\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010eJ@\u0010À\u0001\u001a\u00020Z2+\u0010¹\u0001\u001a&\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020Z0Â\u0001\u0012\u0006\u0012\u0004\u0018\u00010/0Á\u0001¢\u0006\u0003\b¼\u0001H\u0097@ø\u0001\u0000¢\u0006\u0003\u0010Ã\u0001J\u001e\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u00012\u0007\u0010´\u0001\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010_J7\u0010Æ\u0001\u001a\u00020\n\"\u000f\b\u0000\u0010Ç\u0001*\b0È\u0001j\u0003`É\u00012\b\u0010Ê\u0001\u001a\u0003HÇ\u00012\u0007\u0010´\u0001\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0003\u0010Ë\u0001J\u0013\u0010Ì\u0001\u001a\u0004\u0018\u00010\b2\u0006\u0010^\u001a\u00020\u001dH\u0016J\u0013\u0010Í\u0001\u001a\u0004\u0018\u00010\b2\u0006\u0010^\u001a\u00020\u001dH\u0002J=\u0010Î\u0001\u001a\u0003HÏ\u0001\"\t\b\u0000\u0010Ï\u0001*\u00020/2\u000e\u0010\u0010\u001a\n\u0012\u0005\u0012\u0003HÏ\u00010ª\u00012\u000f\u0010Ð\u0001\u001a\n\u0012\u0005\u0012\u0003HÏ\u00010ª\u0001H\u0082\b¢\u0006\u0003\u0010Ñ\u0001J\t\u0010Ò\u0001\u001a\u00020\u0004H\u0016J\n\u0010Ó\u0001\u001a\u00020\u001dH\u0082\bJ!\u0010Ô\u0001\u001a\u00020\u00112\u0007\u0010\u008b\u0001\u001a\u00020\u00002\u0007\u0010´\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bÕ\u0001J\u001c\u0010Ö\u0001\u001a\u00020\u001d2\u0007\u0010×\u0001\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u008f\u0001J/\u0010Ö\u0001\u001a\u00020\u001d2\b\u0010×\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u001d2\u0007\u0010\u0091\u0001\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u0092\u0001J\u001c\u0010Ø\u0001\u001a\u00020\u001d2\u0007\u0010×\u0001\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u008f\u0001J/\u0010Ø\u0001\u001a\u00020\u001d2\b\u0010×\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u001d2\u0007\u0010\u0091\u0001\u001a\u00020\u001dH\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u0092\u0001J\u001d\u0010Ù\u0001\u001a\u00020Z2\b\u0010Ú\u0001\u001a\u00030\u0097\u0001H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010Û\u0001J\u001d\u0010Ü\u0001\u001a\u00020Z2\b\u0010Ý\u0001\u001a\u00030\u009a\u0001H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010Þ\u0001J\u001d\u0010ß\u0001\u001a\u00020Z2\b\u0010à\u0001\u001a\u00030\u009d\u0001H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010á\u0001J5\u0010â\u0001\u001a\u00020Z2\b\u0010ã\u0001\u001a\u00030\u0083\u00012\u0007\u0010ä\u0001\u001a\u00020\u001d2\u0007\u0010å\u0001\u001a\u00020\u001dH\u0096@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0006\bæ\u0001\u0010ç\u0001J\u001d\u0010â\u0001\u001a\u00020Z2\b\u0010×\u0001\u001a\u00030\u008c\u0001H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u008e\u0001J\u001c\u0010â\u0001\u001a\u00020Z2\u0007\u0010×\u0001\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u008f\u0001J/\u0010â\u0001\u001a\u00020Z2\b\u0010×\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u001d2\u0007\u0010\u0091\u0001\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u0092\u0001J\u001b\u0010è\u0001\u001a\u00020Z2\u0007\u0010é\u0001\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010_J\u001b\u0010ê\u0001\u001a\u00020Z2\u0007\u0010ë\u0001\u001a\u00020\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010uJ\u001c\u0010ì\u0001\u001a\u00020Z2\u0007\u0010í\u0001\u001a\u00020GH\u0096@ø\u0001\u0000¢\u0006\u0003\u0010î\u0001J\u001d\u0010ï\u0001\u001a\u00020Z2\b\u0010ð\u0001\u001a\u00030¾\u0001H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010ñ\u0001J@\u0010ò\u0001\u001a\u00020Z2+\u0010ó\u0001\u001a&\b\u0001\u0012\u0004\u0012\u00020j\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020Z0Â\u0001\u0012\u0006\u0012\u0004\u0018\u00010/0Á\u0001¢\u0006\u0003\b¼\u0001H\u0097@ø\u0001\u0000¢\u0006\u0003\u0010Ã\u0001J\u0010\u0010ô\u0001\u001a\u00030\u009a\u0001*\u00030\u009a\u0001H\u0082\bJ\u0010\u0010ô\u0001\u001a\u00030\u009d\u0001*\u00030\u009d\u0001H\u0082\bJ\u000e\u0010ô\u0001\u001a\u00020\u001d*\u00020\u001dH\u0082\bJ\u000e\u0010ô\u0001\u001a\u00020\u0011*\u00020\u0011H\u0082\bJ\u0010\u0010ô\u0001\u001a\u00030¾\u0001*\u00030¾\u0001H\u0082\bR$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR$\u0010\"\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n8D@DX\u0084\u000e¢\u0006\f\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010%R(\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u0010\u001a\u0004\u0018\u00010&8F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u00060/j\u0002`0X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u001fR\u0014\u00103\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u001bR\u0014\u00104\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u001bR$\u00105\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u001d8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u00108R$\u00109\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R*\u0010?\u001a\u00020>2\u0006\u0010\u0010\u001a\u00020>8V@VX\u0097\u000e¢\u0006\u0012\u0012\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020GX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010N\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u0014R\u0014\u0010P\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u0014R\u0014\u0010R\u001a\u00020-X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR*\u0010U\u001a\u00020>2\u0006\u0010\u0010\u001a\u00020>8V@VX\u0097\u000e¢\u0006\u0012\u0012\u0004\bV\u0010A\u001a\u0004\bW\u0010C\"\u0004\bX\u0010E\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006õ\u0001"}, m5598d2 = {"Lio/ktor/utils/io/ByteChannelSequentialBase;", "Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/utils/io/SuspendableReadSession;", "Lio/ktor/utils/io/HasReadSession;", "Lio/ktor/utils/io/HasWriteSession;", "initial", "Lio/ktor/utils/io/core/IoBuffer;", "autoFlush", "", "(Lio/ktor/utils/io/core/IoBuffer;Z)V", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(Lio/ktor/utils/io/core/IoBuffer;ZLio/ktor/utils/io/pool/ObjectPool;)V", "value", "", "_totalBytesRead", "get_totalBytesRead", "()J", "set_totalBytesRead", "(J)V", "_totalBytesWritten", "get_totalBytesWritten", "set_totalBytesWritten", "getAutoFlush", "()Z", "availableForRead", "", "getAvailableForRead", "()I", "availableForWrite", "getAvailableForWrite", "closed", "getClosed", "setClosed", "(Z)V", "", "closedCause", "getClosedCause", "()Ljava/lang/Throwable;", "setClosedCause", "(Ljava/lang/Throwable;)V", "flushBuffer", "Lio/ktor/utils/io/core/BytePacketBuilder;", "flushMutex", "", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "flushSize", "getFlushSize", "isClosedForRead", "isClosedForWrite", "lastReadAvailable", "getLastReadAvailable", "setLastReadAvailable", "(I)V", "lastReadView", "getLastReadView", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "setLastReadView", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "Lio/ktor/utils/io/core/ByteOrder;", "readByteOrder", "getReadByteOrder$annotations", "()V", "getReadByteOrder", "()Lio/ktor/utils/io/core/ByteOrder;", "setReadByteOrder", "(Lio/ktor/utils/io/core/ByteOrder;)V", "readable", "Lio/ktor/utils/io/core/ByteReadPacket;", "getReadable", "()Lio/ktor/utils/io/core/ByteReadPacket;", "slot", "Lio/ktor/utils/io/internal/AwaitingSlot;", "state", "Lio/ktor/utils/io/ByteChannelSequentialBaseSharedState;", "totalBytesRead", "getTotalBytesRead", "totalBytesWritten", "getTotalBytesWritten", "writable", "getWritable", "()Lio/ktor/utils/io/core/BytePacketBuilder;", "writeByteOrder", "getWriteByteOrder$annotations", "getWriteByteOrder", "setWriteByteOrder", "afterRead", "", NewHtcHomeBadger.COUNT, "afterWrite", "await", "atLeast", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAtLeastNBytesAvailableForRead", "awaitAtLeastNBytesAvailableForRead$ktor_io", "awaitAtLeastNBytesAvailableForWrite", "awaitAtLeastNBytesAvailableForWrite$ktor_io", "awaitFreeSpace", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternalAtLeast1", "awaitInternalAtLeast1$ktor_io", "awaitSuspend", "beginWriteSession", "Lio/ktor/utils/io/WriterSuspendSession;", "cancel", HexAttribute.HEX_ATTR_CAUSE, "checkClosed", "remaining", "closeable", "close", "completeReading", "discard", RsaJsonWebKey.MODULUS_MEMBER_NAME, "max", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discardSuspend", "discarded0", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endReadSession", "endWriteSession", "written", "ensureNotClosed", "ensureNotFailed", "flush", "flushImpl", "flushWrittenBytes", "peekTo", FirebaseAnalytics.Param.DESTINATION, "Lio/ktor/utils/io/bits/Memory;", "destinationOffset", TypedValues.CycleType.S_WAVE_OFFSET, "min", "peekTo-vHUFkk8", "(Ljava/nio/ByteBuffer;JJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareFlushedBytes", "readAvailable", C4352k.a.f5652f, "Lio/ktor/utils/io/core/Buffer;", "readAvailable$ktor_io", "(Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/utils/io/core/IoBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "length", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailableClosed", "readBoolean", "readBooleanSlow", "readByte", "", "readByteSlow", "readDouble", "", "readDoubleSlow", "readFloat", "", "readFloatSlow", "readFully", "(Lio/ktor/utils/io/core/Buffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/utils/io/core/IoBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFullySuspend", "readInt", "readIntSlow", "readLong", "readLongSlow", "readNSlow", "", "block", "Lkotlin/Function0;", "(ILkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readPacket", "size", "headerSizeHint", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readPacketSuspend", "builder", "(Lio/ktor/utils/io/core/BytePacketBuilder;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRemaining", "limit", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRemainingSuspend", "(Lio/ktor/utils/io/core/BytePacketBuilder;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readSession", "consumer", "Lkotlin/Function1;", "Lio/ktor/utils/io/ReadSession;", "Lkotlin/ExtensionFunctionType;", "readShort", "", "readShortSlow", "readSuspendableSession", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readUTF8Line", "", "readUTF8LineTo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "(Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "request", "requestNextView", "reverseWrite", ExifInterface.GPS_DIRECTION_TRUE, "reversed", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "startReadSession", "totalPending", "transferTo", "transferTo$ktor_io", "writeAvailable", ReactVideoViewManager.PROP_SRC, "writeAvailableSuspend", "writeByte", "b", "(BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeDouble", "d", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFloat", "f", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "memory", "startIndex", "endIndex", "writeFully-rGWNHyQ", "(Ljava/nio/ByteBuffer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeInt", ContextChain.TAG_INFRA, "writeLong", "l", "writePacket", "packet", "(Lio/ktor/utils/io/core/ByteReadPacket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeShort", "s", "(SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeSuspendSession", "visitor", "reverseRead", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
@DangerousInternalIoApi
public abstract class ByteChannelSequentialBase implements ByteChannel, ByteReadChannel, ByteWriteChannel, SuspendableReadSession, HasReadSession, HasWriteSession {
    private final boolean autoFlush;
    private final BytePacketBuilder flushBuffer;
    private final Object flushMutex;
    private final ByteReadPacket readable;
    private final AwaitingSlot slot;
    private final ByteChannelSequentialBaseSharedState state;
    private final BytePacketBuilder writable;

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0}, m5610l = {890}, m5611m = "awaitFreeSpace$suspendImpl", m5612n = {"this"}, m5613s = {"L$0"})
    static final class C52641 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52641(Continuation<? super C52641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.awaitFreeSpace$suspendImpl(ByteChannelSequentialBase.this, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0}, m5610l = {692}, m5611m = "awaitSuspend", m5612n = {"this", "atLeast"}, m5613s = {"L$0", "I$0"})
    static final class C52651 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52651(Continuation<? super C52651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.awaitSuspend(0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0, 0}, m5610l = {753}, m5611m = "discardSuspend", m5612n = {"this", "max", "discarded"}, m5613s = {"L$0", "J$0", "J$1"})
    static final class C52671 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52671(Continuation<? super C52671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.discardSuspend(0L, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0}, m5610l = {559}, m5611m = "readAvailable$ktor_io", m5612n = {"this", C4352k.a.f5652f}, m5613s = {"L$0", "L$1"})
    static final class C52682 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52682(Continuation<? super C52682> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readAvailable$ktor_io(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0, 0, 0}, m5610l = {TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE}, m5611m = "readAvailable$suspendImpl", m5612n = {"this", C4352k.a.f5652f, TypedValues.CycleType.S_WAVE_OFFSET, "length"}, m5613s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C52694 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52694(Continuation<? super C52694> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.readAvailable$suspendImpl(ByteChannelSequentialBase.this, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0}, m5610l = {639, 641}, m5611m = "readBooleanSlow", m5612n = {"this"}, m5613s = {"L$0"})
    static final class C52701 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52701(Continuation<? super C52701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readBooleanSlow(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0}, m5610l = {359}, m5611m = "readByteSlow", m5612n = {"this"}, m5613s = {"L$0"})
    static final class C52711 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52711(Continuation<? super C52711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readByteSlow(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0, 0}, m5610l = {920}, m5611m = "readDoubleSlow", m5612n = {"this", "this_$iv", "n$iv"}, m5613s = {"L$0", "L$1", "I$0"})
    static final class C52721 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52721(Continuation<? super C52721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readDoubleSlow(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0, 0}, m5610l = {920}, m5611m = "readFloatSlow", m5612n = {"this", "this_$iv", "n$iv"}, m5613s = {"L$0", "L$1", "I$0"})
    static final class C52731 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52731(Continuation<? super C52731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readFloatSlow(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readFully$6 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0, 0, 0}, m5610l = {616, 620}, m5611m = "readFully$suspendImpl", m5612n = {"this", C4352k.a.f5652f, TypedValues.CycleType.S_WAVE_OFFSET, "length"}, m5613s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C52746 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52746(Continuation<? super C52746> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.readFully$suspendImpl(ByteChannelSequentialBase.this, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0, 0}, m5610l = {591, 592}, m5611m = "readFullySuspend", m5612n = {"this", C4352k.a.f5652f, RsaJsonWebKey.MODULUS_MEMBER_NAME}, m5613s = {"L$0", "L$1", "I$0"})
    static final class C52751 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52751(Continuation<? super C52751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readFullySuspend(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0, 0, 0, 0}, m5610l = {627}, m5611m = "readFullySuspend", m5612n = {"this", C4352k.a.f5652f, TypedValues.CycleType.S_WAVE_OFFSET, "length", "written"}, m5613s = {"L$0", "L$1", "I$0", "I$1", "I$2"})
    static final class C52762 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52762(Continuation<? super C52762> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readFullySuspend(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0, 0}, m5610l = {920}, m5611m = "readIntSlow", m5612n = {"this", "this_$iv", "n$iv"}, m5613s = {"L$0", "L$1", "I$0"})
    static final class C52771 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52771(Continuation<? super C52771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readIntSlow(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0, 0}, m5610l = {920}, m5611m = "readLongSlow", m5612n = {"this", "this_$iv", "n$iv"}, m5613s = {"L$0", "L$1", "I$0"})
    static final class C52781 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52781(Continuation<? super C52781> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readLongSlow(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0, 0}, m5610l = {532}, m5611m = "readPacketSuspend", m5612n = {"this", "builder", "remaining"}, m5613s = {"L$0", "L$1", "I$0"})
    static final class C52791 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52791(Continuation<? super C52791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readPacketSuspend(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0, 0}, m5610l = {499}, m5611m = "readRemainingSuspend", m5612n = {"this", "builder", "limit"}, m5613s = {"L$0", "L$1", "J$0"})
    static final class C52801 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52801(Continuation<? super C52801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readRemainingSuspend(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0, 0}, m5610l = {920}, m5611m = "readShortSlow", m5612n = {"this", "this_$iv", "n$iv"}, m5613s = {"L$0", "L$1", "I$0"})
    static final class C52811 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52811(Continuation<? super C52811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readShortSlow(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0}, m5610l = {782}, m5611m = "readSuspendableSession$suspendImpl", m5612n = {"this"}, m5613s = {"L$0"})
    static final class C52821 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52821(Continuation<? super C52821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.readSuspendableSession$suspendImpl(ByteChannelSequentialBase.this, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0}, m5610l = {808}, m5611m = "readUTF8Line$suspendImpl", m5612n = {"sb"}, m5613s = {"L$0"})
    static final class C52831 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52831(Continuation<? super C52831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.readUTF8Line$suspendImpl(ByteChannelSequentialBase.this, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0}, m5610l = {862, 863}, m5611m = "writeAvailableSuspend", m5612n = {"this", ReactVideoViewManager.PROP_SRC}, m5613s = {"L$0", "L$1"})
    static final class C52851 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52851(Continuation<? super C52851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.writeAvailableSuspend(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0, 0, 0}, m5610l = {867, 868}, m5611m = "writeAvailableSuspend", m5612n = {"this", ReactVideoViewManager.PROP_SRC, TypedValues.CycleType.S_WAVE_OFFSET, "length"}, m5613s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C52862 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52862(Continuation<? super C52862> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.writeAvailableSuspend(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0}, m5610l = {185}, m5611m = "writeByte$suspendImpl", m5612n = {"this", "b"}, m5613s = {"L$0", "B$0"})
    static final class C52871 extends ContinuationImpl {
        byte B$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52871(Continuation<? super C52871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeByte$suspendImpl(ByteChannelSequentialBase.this, (byte) 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0}, m5610l = {ISO7816Kt.INS_CREATE_FILE}, m5611m = "writeDouble$suspendImpl", m5612n = {"this", "d"}, m5613s = {"L$0", "D$0"})
    static final class C52881 extends ContinuationImpl {
        double D$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52881(Continuation<? super C52881> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeDouble$suspendImpl(ByteChannelSequentialBase.this, 0.0d, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0}, m5610l = {JfifUtil.MARKER_SOS}, m5611m = "writeFloat$suspendImpl", m5612n = {"this", "f"}, m5613s = {"L$0", "F$0"})
    static final class C52891 extends ContinuationImpl {
        float F$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52891(Continuation<? super C52891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeFloat$suspendImpl(ByteChannelSequentialBase.this, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0}, m5610l = {241}, m5611m = "writeFully$suspendImpl", m5612n = {"this", ReactVideoViewManager.PROP_SRC}, m5613s = {"L$0", "L$1"})
    static final class C52902 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52902(Continuation<? super C52902> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeFully$suspendImpl(ByteChannelSequentialBase.this, (Buffer) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0, 0, 0}, m5610l = {252}, m5611m = "writeFully$suspendImpl", m5612n = {"this", ReactVideoViewManager.PROP_SRC, "currentIndex", "endIndex"}, m5613s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C52913 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52913(Continuation<? super C52913> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeFully$suspendImpl(ByteChannelSequentialBase.this, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeFully$4 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0, 0, 0}, m5610l = {266}, m5611m = "writeFully-rGWNHyQ$suspendImpl", m5612n = {"this", "memory", "endIndex", "currentIndex"}, m5613s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C52924 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52924(Continuation<? super C52924> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.m6942writeFullyrGWNHyQ$suspendImpl(ByteChannelSequentialBase.this, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0}, m5610l = {OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_SERVICE_SPECIFIC_OFF}, m5611m = "writeInt$suspendImpl", m5612n = {"this", ContextChain.TAG_INFRA}, m5613s = {"L$0", "I$0"})
    static final class C52931 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52931(Continuation<? super C52931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeInt$suspendImpl(ByteChannelSequentialBase.this, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0}, m5610l = {212}, m5611m = "writeLong$suspendImpl", m5612n = {"this", "l"}, m5613s = {"L$0", "J$0"})
    static final class C52941 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52941(Continuation<? super C52941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeLong$suspendImpl(ByteChannelSequentialBase.this, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0}, m5610l = {230}, m5611m = "writePacket$suspendImpl", m5612n = {"this", "packet"}, m5613s = {"L$0", "L$1"})
    static final class C52951 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52951(Continuation<? super C52951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writePacket$suspendImpl(ByteChannelSequentialBase.this, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0, 0}, m5610l = {200}, m5611m = "writeShort$suspendImpl", m5612n = {"this", "s"}, m5613s = {"L$0", "S$0"})
    static final class C52961 extends ContinuationImpl {
        Object L$0;
        short S$0;
        int label;
        /* synthetic */ Object result;

        C52961(Continuation<? super C52961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeShort$suspendImpl(ByteChannelSequentialBase.this, (short) 0, this);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Setting byte order is no longer supported. Read/write in big endian and use reverseByteOrder() extensions.")
    public static /* synthetic */ void getReadByteOrder$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Setting byte order is no longer supported. Read/write in big endian and use reverseByteOrder() extensions.")
    public static /* synthetic */ void getWriteByteOrder$annotations() {
    }

    @Override // io.ktor.utils.p098io.SuspendableReadSession
    public Object await(int i, Continuation<? super Boolean> continuation) {
        return await$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object awaitFreeSpace(Continuation<? super Unit> continuation) {
        return awaitFreeSpace$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object discard(long j, Continuation<? super Long> continuation) {
        return discard$suspendImpl(this, j, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readAvailable(IoBuffer ioBuffer, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, ioBuffer, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readBoolean(Continuation<? super Boolean> continuation) {
        return readBoolean$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readByte(Continuation<? super Byte> continuation) {
        return readByte$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readDouble(Continuation<? super Double> continuation) {
        return readDouble$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readFloat(Continuation<? super Float> continuation) {
        return readFloat$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readFully(IoBuffer ioBuffer, int i, Continuation<? super Unit> continuation) {
        return readFully$suspendImpl(this, ioBuffer, i, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        return readFully$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readInt(Continuation<? super Integer> continuation) {
        return readInt$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readLong(Continuation<? super Long> continuation) {
        return readLong$suspendImpl(this, continuation);
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
    public Object readShort(Continuation<? super Short> continuation) {
        return readShort$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    @Deprecated(message = "Use read instead.")
    public Object readSuspendableSession(Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return readSuspendableSession$suspendImpl(this, function2, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readUTF8Line(int i, Continuation<? super String> continuation) {
        return readUTF8Line$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public <A extends Appendable> Object readUTF8LineTo(A a2, int i, Continuation<? super Boolean> continuation) {
        return readUTF8LineTo$suspendImpl(this, a2, i, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeAvailable(IoBuffer ioBuffer, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, ioBuffer, continuation);
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
    public Object writeFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    /* JADX INFO: renamed from: writeFully-rGWNHyQ */
    public Object mo6941writeFullyrGWNHyQ(ByteBuffer byteBuffer, int i, int i2, Continuation<? super Unit> continuation) {
        return m6942writeFullyrGWNHyQ$suspendImpl(this, byteBuffer, i, i2, continuation);
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

    public ByteChannelSequentialBase(IoBuffer initial, boolean z, ObjectPool<ChunkBuffer> pool) {
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.autoFlush = z;
        this.state = new ByteChannelSequentialBaseSharedState();
        this.writable = new BytePacketBuilder(0, pool);
        this.readable = new ByteReadPacket((ChunkBuffer) initial, pool);
        this.slot = new AwaitingSlot();
        this.flushMutex = new Object();
        this.flushBuffer = PacketJVMKt.BytePacketBuilder$default(0, 1, null);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ Object consumeEachBufferRange(Function2 function2, Continuation continuation) {
        return ByteChannel.DefaultImpls.consumeEachBufferRange(this, function2, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    public /* synthetic */ ByteChannelSequentialBase(IoBuffer ioBuffer, boolean z, ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ioBuffer, z, (i & 4) != 0 ? ChunkBuffer.INSTANCE.getPool() : objectPool);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ ByteChannelSequentialBase(IoBuffer initial, boolean z) {
        this(initial, z, ChunkBuffer.INSTANCE.getPool());
        Intrinsics.checkNotNullParameter(initial, "initial");
    }

    protected final boolean getClosed() {
        return this.state.getClosed();
    }

    protected final void setClosed(boolean z) {
        this.state.setClosed(z);
    }

    protected final BytePacketBuilder getWritable() {
        return this.writable;
    }

    protected final ByteReadPacket getReadable() {
        return this.readable;
    }

    private final int totalPending() {
        return getAvailableForRead() + this.writable.getSize();
    }

    private final int getFlushSize() {
        return this.flushBuffer.getSize();
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public int getAvailableForRead() {
        return getFlushSize() + ((int) this.readable.getRemaining());
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public ByteOrder getReadByteOrder() {
        return this.state.getReadByteOrder();
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public void setReadByteOrder(ByteOrder value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.state.setReadByteOrder(value);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public ByteOrder getWriteByteOrder() {
        return this.state.getWriteByteOrder();
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public void setWriteByteOrder(ByteOrder value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.state.setWriteByteOrder(value);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public boolean isClosedForRead() {
        return getClosed() && this.readable.isEmpty() && getFlushSize() == 0 && this.writable.isEmpty();
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel, io.ktor.utils.p098io.ByteWriteChannel
    public boolean isClosedForWrite() {
        return getClosed();
    }

    private final long get_totalBytesRead() {
        return this.state.getTotalBytesRead();
    }

    private final void set_totalBytesRead(long j) {
        this.state.setTotalBytesRead(j);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public long getTotalBytesRead() {
        return this.state.getTotalBytesRead();
    }

    private final long get_totalBytesWritten() {
        return this.state.getTotalBytesWritten();
    }

    private final void set_totalBytesWritten(long j) {
        this.state.setTotalBytesWritten(j);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public long getTotalBytesWritten() {
        return this.state.getTotalBytesWritten();
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel, io.ktor.utils.p098io.ByteWriteChannel
    public final Throwable getClosedCause() {
        return this.state.getClosedCause();
    }

    private final void setClosedCause(Throwable th) {
        this.state.setClosedCause(th);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitAtLeastNBytesAvailableForWrite$ktor_io(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            int r5 = r0.I$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L3c
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.ResultKt.throwOnFailure(r6)
            r2 = r4
        L3c:
            int r6 = r2.getAvailableForWrite()
            if (r6 >= r5) goto L5d
            boolean r6 = r2.getClosed()
            if (r6 != 0) goto L5d
            boolean r6 = r2.flushImpl()
            if (r6 != 0) goto L3c
            io.ktor.utils.io.internal.AwaitingSlot r6 = r2.slot
            r0.L$0 = r2
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.sleep(r0)
            if (r6 != r1) goto L3c
            return r1
        L5d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitAtLeastNBytesAvailableForRead$ktor_io(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            int r5 = r0.I$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L3c
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.ResultKt.throwOnFailure(r6)
            r2 = r4
        L3c:
            int r6 = r2.getAvailableForRead()
            if (r6 >= r5) goto L57
            boolean r6 = r2.getClosed()
            if (r6 != 0) goto L57
            io.ktor.utils.io.internal.AwaitingSlot r6 = r2.slot
            r0.L$0 = r2
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.sleep(r0)
            if (r6 != r1) goto L3c
            return r1
        L57:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.awaitAtLeastNBytesAvailableForRead$ktor_io(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public void flush() {
        flushImpl();
    }

    private final boolean flushImpl() {
        if (this.writable.isEmpty()) {
            return false;
        }
        flushWrittenBytes();
        this.slot.resume();
        return true;
    }

    private final void flushWrittenBytes() {
        synchronized (this.flushMutex) {
            ChunkBuffer chunkBufferStealAll$ktor_io = getWritable().stealAll$ktor_io();
            Intrinsics.checkNotNull(chunkBufferStealAll$ktor_io);
            this.flushBuffer.writeChunkBuffer$ktor_io(chunkBufferStealAll$ktor_io);
            Unit unit = Unit.INSTANCE;
        }
    }

    protected final void prepareFlushedBytes() {
        synchronized (this.flushMutex) {
            UnsafeKt.unsafeAppend(getReadable(), this.flushBuffer);
        }
    }

    private final void ensureNotClosed() throws Throwable {
        if (getClosed()) {
            Throwable closedCause = getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            throw new ClosedWriteChannelException("Channel is already closed");
        }
    }

    private final void ensureNotFailed() throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    private final void ensureNotFailed(BytePacketBuilder closeable) throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause == null) {
            return;
        }
        closeable.release();
        throw closedCause;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeByte$suspendImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r4, byte r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52871
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52871) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            byte r5 = r0.B$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L48
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.B$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r6 != r1) goto L48
            return r1
        L48:
            io.ktor.utils.io.core.BytePacketBuilder r6 = r4.getWritable()
            byte r5 = (byte) r5
            r6.writeByte(r5)
            r4.afterWrite(r3)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.writeByte$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, byte, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final <T> T reverseWrite(Function0<? extends T> value, Function0<? extends T> reversed) {
        if (getWriteByteOrder() == ByteOrder.BIG_ENDIAN) {
            return value.invoke();
        }
        return reversed.invoke();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeShort$suspendImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r5, short r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52961
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52961) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 != r4) goto L31
            short r6 = r0.S$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L49
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.S$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r7 != r1) goto L49
            return r1
        L49:
            io.ktor.utils.io.core.BytePacketBuilder r7 = r5.getWritable()
            io.ktor.utils.io.core.Output r7 = (io.ktor.utils.p098io.core.Output) r7
            io.ktor.utils.io.core.ByteOrder r0 = r5.getWriteByteOrder()
            io.ktor.utils.io.core.ByteOrder r1 = io.ktor.utils.p098io.core.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L59
            short r6 = (short) r6
            goto L5e
        L59:
            short r6 = (short) r6
            short r6 = java.lang.Short.reverseBytes(r6)
        L5e:
            io.ktor.utils.p098io.core.OutputPrimitivesKt.writeShort(r7, r6)
            r5.afterWrite(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.writeShort$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, short, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeInt$suspendImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r5, int r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52931
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52931) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 != r4) goto L31
            int r6 = r0.I$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L49
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r7 != r1) goto L49
            return r1
        L49:
            io.ktor.utils.io.core.BytePacketBuilder r7 = r5.getWritable()
            io.ktor.utils.io.core.Output r7 = (io.ktor.utils.p098io.core.Output) r7
            io.ktor.utils.io.core.ByteOrder r0 = r5.getWriteByteOrder()
            io.ktor.utils.io.core.ByteOrder r1 = io.ktor.utils.p098io.core.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L58
            goto L5c
        L58:
            int r6 = java.lang.Integer.reverseBytes(r6)
        L5c:
            io.ktor.utils.p098io.core.OutputPrimitivesKt.writeInt(r7, r6)
            r5.afterWrite(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.writeInt$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeLong$suspendImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r5, long r6, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52941
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52941) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            long r6 = r0.J$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4a
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.J$0 = r6
            r0.label = r4
            java.lang.Object r8 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r8 != r1) goto L4a
            return r1
        L4a:
            io.ktor.utils.io.core.BytePacketBuilder r8 = r5.getWritable()
            io.ktor.utils.io.core.Output r8 = (io.ktor.utils.p098io.core.Output) r8
            io.ktor.utils.io.core.ByteOrder r0 = r5.getWriteByteOrder()
            io.ktor.utils.io.core.ByteOrder r1 = io.ktor.utils.p098io.core.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L59
            goto L5d
        L59:
            long r6 = java.lang.Long.reverseBytes(r6)
        L5d:
            io.ktor.utils.p098io.core.OutputPrimitivesKt.writeLong(r8, r6)
            r5.afterWrite(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.writeLong$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeFloat$suspendImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r5, float r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52891
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52891) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 != r4) goto L31
            float r6 = r0.F$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L49
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.F$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r7 != r1) goto L49
            return r1
        L49:
            io.ktor.utils.io.core.BytePacketBuilder r7 = r5.getWritable()
            io.ktor.utils.io.core.Output r7 = (io.ktor.utils.p098io.core.Output) r7
            io.ktor.utils.io.core.ByteOrder r0 = r5.getWriteByteOrder()
            io.ktor.utils.io.core.ByteOrder r1 = io.ktor.utils.p098io.core.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L58
            goto L64
        L58:
            int r6 = java.lang.Float.floatToRawIntBits(r6)
            int r6 = java.lang.Integer.reverseBytes(r6)
            float r6 = java.lang.Float.intBitsToFloat(r6)
        L64:
            io.ktor.utils.p098io.core.OutputPrimitivesKt.writeFloat(r7, r6)
            r5.afterWrite(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.writeFloat$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeDouble$suspendImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r5, double r6, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52881
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52881) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            double r6 = r0.D$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4a
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.D$0 = r6
            r0.label = r4
            java.lang.Object r8 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r8 != r1) goto L4a
            return r1
        L4a:
            io.ktor.utils.io.core.BytePacketBuilder r8 = r5.getWritable()
            io.ktor.utils.io.core.Output r8 = (io.ktor.utils.p098io.core.Output) r8
            io.ktor.utils.io.core.ByteOrder r0 = r5.getWriteByteOrder()
            io.ktor.utils.io.core.ByteOrder r1 = io.ktor.utils.p098io.core.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L59
            goto L65
        L59:
            long r6 = java.lang.Double.doubleToRawLongBits(r6)
            long r6 = java.lang.Long.reverseBytes(r6)
            double r6 = java.lang.Double.longBitsToDouble(r6)
        L65:
            io.ktor.utils.p098io.core.OutputPrimitivesKt.writeDouble(r8, r6)
            r5.afterWrite(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.writeDouble$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, double, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writePacket$suspendImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r4, io.ktor.utils.p098io.core.ByteReadPacket r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52951
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52951) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$1
            r5 = r4
            io.ktor.utils.io.core.ByteReadPacket r5 = (io.ktor.utils.p098io.core.ByteReadPacket) r5
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4b
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            long r0 = r5.getRemaining()
            int r6 = (int) r0
            io.ktor.utils.io.core.BytePacketBuilder r0 = r4.getWritable()
            r0.writePacket(r5)
            r4.afterWrite(r6)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.writePacket$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.core.ByteReadPacket, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object writeFully$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, IoBuffer ioBuffer, Continuation continuation) {
        Object objWriteFully = byteChannelSequentialBase.writeFully((Buffer) ioBuffer, (Continuation<? super Unit>) continuation);
        return objWriteFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteFully : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeFully$suspendImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r4, io.ktor.utils.p098io.core.Buffer r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52902
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52902) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$1
            r5 = r4
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.p098io.core.Buffer) r5
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4b
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            int r6 = r5.getWritePosition()
            int r0 = r5.getReadPosition()
            int r6 = r6 - r0
            io.ktor.utils.io.core.BytePacketBuilder r0 = r4.getWritable()
            io.ktor.utils.io.core.Output r0 = (io.ktor.utils.p098io.core.Output) r0
            r1 = 2
            r2 = 0
            r3 = 0
            io.ktor.utils.p098io.core.OutputKt.writeFully$default(r0, r5, r3, r1, r2)
            r4.afterWrite(r6)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005a -> B:19:0x005d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeFully$suspendImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r5, byte[] r6, int r7, int r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52913
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52913) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            int r5 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r8 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = r8
            r8 = r6
            r6 = r4
            goto L5d
        L39:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L41:
            kotlin.ResultKt.throwOnFailure(r9)
            int r8 = r8 + r7
            r4 = r6
            r6 = r5
            r5 = r8
            r8 = r7
            r7 = r4
        L4a:
            if (r8 >= r5) goto L75
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.I$1 = r5
            r0.label = r3
            java.lang.Object r9 = r6.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r9 != r1) goto L5d
            return r1
        L5d:
            int r9 = r6.getAvailableForWrite()
            int r2 = r5 - r8
            int r9 = java.lang.Math.min(r9, r2)
            io.ktor.utils.io.core.BytePacketBuilder r2 = r6.getWritable()
            io.ktor.utils.io.core.Output r2 = (io.ktor.utils.p098io.core.Output) r2
            io.ktor.utils.p098io.core.OutputKt.writeFully(r2, r7, r8, r9)
            int r8 = r8 + r9
            r6.afterWrite(r9)
            goto L4a
        L75:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0056 -> B:19:0x0059). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: writeFully-rGWNHyQ$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object m6942writeFullyrGWNHyQ$suspendImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r5, java.nio.ByteBuffer r6, int r7, int r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52924
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$4 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52924) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$4 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$4
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            int r5 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r8 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = r7
            r7 = r5
            r5 = r8
            r8 = r6
            r6 = r4
            goto L59
        L3b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L43:
            kotlin.ResultKt.throwOnFailure(r9)
        L46:
            if (r7 >= r8) goto L71
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r8
            r0.I$1 = r7
            r0.label = r3
            java.lang.Object r9 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r9 != r1) goto L59
            return r1
        L59:
            int r9 = r5.getAvailableForWrite()
            int r2 = r8 - r7
            int r9 = java.lang.Math.min(r9, r2)
            io.ktor.utils.io.core.BytePacketBuilder r2 = r5.getWritable()
            io.ktor.utils.io.core.Output r2 = (io.ktor.utils.p098io.core.Output) r2
            io.ktor.utils.p098io.core.OutputKt.m7173writeFullyp0stHsI(r2, r6, r7, r9)
            int r7 = r7 + r9
            r5.afterWrite(r9)
            goto L46
        L71:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.m6942writeFullyrGWNHyQ$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, java.nio.ByteBuffer, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, IoBuffer ioBuffer, Continuation continuation) throws Throwable {
        IoBuffer ioBuffer2 = ioBuffer;
        int writePosition = ioBuffer2.getWritePosition() - ioBuffer2.getReadPosition();
        if (writePosition == 0) {
            return Boxing.boxInt(0);
        }
        int iMin = Math.min(writePosition, byteChannelSequentialBase.getAvailableForWrite());
        if (iMin == 0) {
            return byteChannelSequentialBase.writeAvailableSuspend(ioBuffer, continuation);
        }
        OutputKt.writeFully((Output) byteChannelSequentialBase.getWritable(), (Buffer) ioBuffer2, iMin);
        byteChannelSequentialBase.afterWrite(iMin);
        return Boxing.boxInt(iMin);
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, byte[] bArr, int i, int i2, Continuation continuation) throws Throwable {
        if (i2 == 0) {
            return Boxing.boxInt(0);
        }
        int iMin = Math.min(i2, byteChannelSequentialBase.getAvailableForWrite());
        if (iMin == 0) {
            return byteChannelSequentialBase.writeAvailableSuspend(bArr, i, i2, continuation);
        }
        OutputKt.writeFully((Output) byteChannelSequentialBase.getWritable(), bArr, i, iMin);
        byteChannelSequentialBase.afterWrite(iMin);
        return Boxing.boxInt(iMin);
    }

    @ExperimentalIoApi
    static /* synthetic */ Object writeSuspendSession$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Function2 function2, Continuation continuation) {
        Object objInvoke = function2.invoke(byteChannelSequentialBase.beginWriteSession(), continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
    }

    @Override // io.ktor.utils.p098io.HasWriteSession
    public WriterSuspendSession beginWriteSession() {
        return new WriterSuspendSession() { // from class: io.ktor.utils.io.ByteChannelSequentialBase.beginWriteSession.1
            @Override // io.ktor.utils.p098io.WriterSession
            public IoBuffer request(int min) {
                if (ByteChannelSequentialBase.this.getAvailableForWrite() == 0) {
                    return null;
                }
                return (IoBuffer) ByteChannelSequentialBase.this.getWritable().prepareWriteHead(min);
            }

            @Override // io.ktor.utils.p098io.WriterSession
            public void written(int n) throws Throwable {
                ByteChannelSequentialBase.this.getWritable().afterHeadWrite();
                ByteChannelSequentialBase.this.afterWrite(n);
            }

            @Override // io.ktor.utils.p098io.WriterSession
            public void flush() {
                ByteChannelSequentialBase.this.flush();
            }

            @Override // io.ktor.utils.p098io.WriterSuspendSession
            public Object tryAwait(int i, Continuation<? super Unit> continuation) {
                if (ByteChannelSequentialBase.this.getAvailableForWrite() < i) {
                    Object objAwaitAtLeastNBytesAvailableForWrite$ktor_io = ByteChannelSequentialBase.this.awaitAtLeastNBytesAvailableForWrite$ktor_io(i, continuation);
                    return objAwaitAtLeastNBytesAvailableForWrite$ktor_io == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitAtLeastNBytesAvailableForWrite$ktor_io : Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // io.ktor.utils.p098io.HasWriteSession
    public void endWriteSession(int written) throws Throwable {
        this.writable.afterHeadWrite();
        afterWrite(written);
    }

    static /* synthetic */ Object readByte$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!byteChannelSequentialBase.getReadable().isEmpty()) {
            byte b = byteChannelSequentialBase.getReadable().readByte();
            byteChannelSequentialBase.afterRead(1);
            return Boxing.boxByte(b);
        }
        return byteChannelSequentialBase.readByteSlow(continuation);
    }

    static /* synthetic */ void checkClosed$default(ByteChannelSequentialBase byteChannelSequentialBase, int i, BytePacketBuilder bytePacketBuilder, int i2, Object obj) throws Throwable {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkClosed");
        }
        if ((i2 & 2) != 0) {
            bytePacketBuilder = null;
        }
        byteChannelSequentialBase.checkClosed(i, bytePacketBuilder);
    }

    private final void checkClosed(int remaining, BytePacketBuilder closeable) throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            if (closeable != null) {
                closeable.close();
                throw closedCause;
            }
            throw closedCause;
        }
        if (!getClosed() || getAvailableForRead() >= remaining) {
            return;
        }
        if (closeable != null) {
            closeable.close();
        }
        throw new EOFException(remaining + " bytes required but EOF reached");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:18:0x0045). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readByteSlow(kotlin.coroutines.Continuation<? super java.lang.Byte> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52711
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52711) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            r2 = r5
        L3a:
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r2.awaitSuspend(r3, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            io.ktor.utils.io.core.ByteReadPacket r6 = r2.getReadable()
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L65
            io.ktor.utils.io.core.ByteReadPacket r6 = r2.getReadable()
            byte r6 = r6.readByte()
            java.lang.Byte r6 = kotlin.coroutines.jvm.internal.Boxing.boxByte(r6)
            r0 = r6
            java.lang.Number r0 = (java.lang.Number) r0
            r0.byteValue()
            r2.afterRead(r3)
            return r6
        L65:
            r6 = 2
            r4 = 0
            checkClosed$default(r2, r3, r4, r6, r4)
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readByteSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readShort$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (byteChannelSequentialBase.getReadable().hasBytes(2)) {
            short sReverseBytes = InputPrimitivesKt.readShort(byteChannelSequentialBase.getReadable());
            if (byteChannelSequentialBase.getReadByteOrder() != ByteOrder.BIG_ENDIAN) {
                sReverseBytes = Short.reverseBytes(sReverseBytes);
            }
            byteChannelSequentialBase.afterRead(2);
            return Boxing.boxShort(sReverseBytes);
        }
        return byteChannelSequentialBase.readShortSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004f -> B:18:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readShortSlow(kotlin.coroutines.Continuation<? super java.lang.Short> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52811
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52811) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$1
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r6 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L52
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3d:
            kotlin.ResultKt.throwOnFailure(r8)
            r5 = r7
            r6 = r5
            r2 = r4
        L43:
            r0.L$0 = r6
            r0.L$1 = r5
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r8 = access$awaitSuspend(r5, r2, r0)
            if (r8 != r1) goto L52
            return r1
        L52:
            io.ktor.utils.io.core.ByteReadPacket r8 = access$getReadable(r5)
            boolean r8 = r8.hasBytes(r2)
            if (r8 == 0) goto L82
            io.ktor.utils.io.core.ByteReadPacket r8 = r6.getReadable()
            io.ktor.utils.io.core.Input r8 = (io.ktor.utils.p098io.core.Input) r8
            short r8 = io.ktor.utils.p098io.core.InputPrimitivesKt.readShort(r8)
            io.ktor.utils.io.core.ByteOrder r0 = r6.getReadByteOrder()
            io.ktor.utils.io.core.ByteOrder r1 = io.ktor.utils.p098io.core.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L6f
            goto L74
        L6f:
            short r8 = (short) r8
            short r8 = java.lang.Short.reverseBytes(r8)
        L74:
            java.lang.Short r8 = kotlin.coroutines.jvm.internal.Boxing.boxShort(r8)
            r0 = r8
            java.lang.Number r0 = (java.lang.Number) r0
            r0.shortValue()
            r6.afterRead(r4)
            return r8
        L82:
            r8 = 0
            checkClosed$default(r5, r2, r8, r4, r8)
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readShortSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Consider providing consumed count of bytes")
    protected final void afterRead() {
        afterRead(0);
    }

    protected final void afterRead(int count) {
        set_totalBytesRead(get_totalBytesRead() + ((long) count));
        this.slot.resume();
    }

    private final short reverseRead(short s) {
        return getReadByteOrder() == ByteOrder.BIG_ENDIAN ? s : Short.reverseBytes(s);
    }

    private final int reverseRead(int i) {
        return getReadByteOrder() == ByteOrder.BIG_ENDIAN ? i : Integer.reverseBytes(i);
    }

    private final long reverseRead(long j) {
        return getReadByteOrder() == ByteOrder.BIG_ENDIAN ? j : Long.reverseBytes(j);
    }

    private final float reverseRead(float f) {
        return getReadByteOrder() == ByteOrder.BIG_ENDIAN ? f : Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f)));
    }

    private final double reverseRead(double d) {
        return getReadByteOrder() == ByteOrder.BIG_ENDIAN ? d : Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d)));
    }

    static /* synthetic */ Object readInt$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (byteChannelSequentialBase.getReadable().hasBytes(4)) {
            int iReverseBytes = InputPrimitivesKt.readInt(byteChannelSequentialBase.getReadable());
            if (byteChannelSequentialBase.getReadByteOrder() != ByteOrder.BIG_ENDIAN) {
                iReverseBytes = Integer.reverseBytes(iReverseBytes);
            }
            byteChannelSequentialBase.afterRead(4);
            return Boxing.boxInt(iReverseBytes);
        }
        return byteChannelSequentialBase.readIntSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004f -> B:18:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readIntSlow(kotlin.coroutines.Continuation<? super java.lang.Integer> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52771
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52771) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 != r4) goto L35
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$1
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r6 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L52
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3d:
            kotlin.ResultKt.throwOnFailure(r9)
            r5 = r8
            r6 = r5
            r2 = r3
        L43:
            r0.L$0 = r6
            r0.L$1 = r5
            r0.I$0 = r2
            r0.label = r4
            java.lang.Object r9 = access$awaitSuspend(r5, r2, r0)
            if (r9 != r1) goto L52
            return r1
        L52:
            io.ktor.utils.io.core.ByteReadPacket r9 = access$getReadable(r5)
            boolean r9 = r9.hasBytes(r2)
            if (r9 == 0) goto L81
            io.ktor.utils.io.core.ByteReadPacket r9 = r6.getReadable()
            io.ktor.utils.io.core.Input r9 = (io.ktor.utils.p098io.core.Input) r9
            int r9 = io.ktor.utils.p098io.core.InputPrimitivesKt.readInt(r9)
            io.ktor.utils.io.core.ByteOrder r0 = r6.getReadByteOrder()
            io.ktor.utils.io.core.ByteOrder r1 = io.ktor.utils.p098io.core.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L6f
            goto L73
        L6f:
            int r9 = java.lang.Integer.reverseBytes(r9)
        L73:
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            r0 = r9
            java.lang.Number r0 = (java.lang.Number) r0
            r0.intValue()
            r6.afterRead(r3)
            return r9
        L81:
            r9 = 2
            r7 = 0
            checkClosed$default(r5, r2, r7, r9, r7)
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readIntSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readLong$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (byteChannelSequentialBase.getReadable().hasBytes(8)) {
            long jReverseBytes = InputPrimitivesKt.readLong(byteChannelSequentialBase.getReadable());
            if (byteChannelSequentialBase.getReadByteOrder() != ByteOrder.BIG_ENDIAN) {
                jReverseBytes = Long.reverseBytes(jReverseBytes);
            }
            byteChannelSequentialBase.afterRead(8);
            return Boxing.boxLong(jReverseBytes);
        }
        return byteChannelSequentialBase.readLongSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0050 -> B:18:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readLongSlow(kotlin.coroutines.Continuation<? super java.lang.Long> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52781
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52781) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 != r4) goto L36
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$1
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r6 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L53
        L36:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3e:
            kotlin.ResultKt.throwOnFailure(r9)
            r5 = r8
            r6 = r5
            r2 = r3
        L44:
            r0.L$0 = r6
            r0.L$1 = r5
            r0.I$0 = r2
            r0.label = r4
            java.lang.Object r9 = access$awaitSuspend(r5, r2, r0)
            if (r9 != r1) goto L53
            return r1
        L53:
            io.ktor.utils.io.core.ByteReadPacket r9 = access$getReadable(r5)
            boolean r9 = r9.hasBytes(r2)
            if (r9 == 0) goto L82
            io.ktor.utils.io.core.ByteReadPacket r9 = r6.getReadable()
            io.ktor.utils.io.core.Input r9 = (io.ktor.utils.p098io.core.Input) r9
            long r0 = io.ktor.utils.p098io.core.InputPrimitivesKt.readLong(r9)
            io.ktor.utils.io.core.ByteOrder r9 = r6.getReadByteOrder()
            io.ktor.utils.io.core.ByteOrder r2 = io.ktor.utils.p098io.core.ByteOrder.BIG_ENDIAN
            if (r9 != r2) goto L70
            goto L74
        L70:
            long r0 = java.lang.Long.reverseBytes(r0)
        L74:
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)
            r0 = r9
            java.lang.Number r0 = (java.lang.Number) r0
            r0.longValue()
            r6.afterRead(r3)
            return r9
        L82:
            r9 = 2
            r7 = 0
            checkClosed$default(r5, r2, r7, r9, r7)
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readLongSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readFloat$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (byteChannelSequentialBase.getReadable().hasBytes(4)) {
            float fIntBitsToFloat = InputPrimitivesKt.readFloat(byteChannelSequentialBase.getReadable());
            if (byteChannelSequentialBase.getReadByteOrder() != ByteOrder.BIG_ENDIAN) {
                fIntBitsToFloat = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(fIntBitsToFloat)));
            }
            byteChannelSequentialBase.afterRead(4);
            return Boxing.boxFloat(fIntBitsToFloat);
        }
        return byteChannelSequentialBase.readFloatSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004f -> B:18:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readFloatSlow(kotlin.coroutines.Continuation<? super java.lang.Float> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52731
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52731) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 != r4) goto L35
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$1
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r6 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L52
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3d:
            kotlin.ResultKt.throwOnFailure(r9)
            r5 = r8
            r6 = r5
            r2 = r3
        L43:
            r0.L$0 = r6
            r0.L$1 = r5
            r0.I$0 = r2
            r0.label = r4
            java.lang.Object r9 = access$awaitSuspend(r5, r2, r0)
            if (r9 != r1) goto L52
            return r1
        L52:
            io.ktor.utils.io.core.ByteReadPacket r9 = access$getReadable(r5)
            boolean r9 = r9.hasBytes(r2)
            if (r9 == 0) goto L89
            io.ktor.utils.io.core.ByteReadPacket r9 = r6.getReadable()
            io.ktor.utils.io.core.Input r9 = (io.ktor.utils.p098io.core.Input) r9
            float r9 = io.ktor.utils.p098io.core.InputPrimitivesKt.readFloat(r9)
            io.ktor.utils.io.core.ByteOrder r0 = r6.getReadByteOrder()
            io.ktor.utils.io.core.ByteOrder r1 = io.ktor.utils.p098io.core.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L6f
            goto L7b
        L6f:
            int r9 = java.lang.Float.floatToRawIntBits(r9)
            int r9 = java.lang.Integer.reverseBytes(r9)
            float r9 = java.lang.Float.intBitsToFloat(r9)
        L7b:
            java.lang.Float r9 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r9)
            r0 = r9
            java.lang.Number r0 = (java.lang.Number) r0
            r0.floatValue()
            r6.afterRead(r3)
            return r9
        L89:
            r9 = 2
            r7 = 0
            checkClosed$default(r5, r2, r7, r9, r7)
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readFloatSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readDouble$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (byteChannelSequentialBase.getReadable().hasBytes(8)) {
            double dLongBitsToDouble = InputPrimitivesKt.readDouble(byteChannelSequentialBase.getReadable());
            if (byteChannelSequentialBase.getReadByteOrder() != ByteOrder.BIG_ENDIAN) {
                dLongBitsToDouble = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(dLongBitsToDouble)));
            }
            byteChannelSequentialBase.afterRead(8);
            return Boxing.boxDouble(dLongBitsToDouble);
        }
        return byteChannelSequentialBase.readDoubleSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0050 -> B:18:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readDoubleSlow(kotlin.coroutines.Continuation<? super java.lang.Double> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52721
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52721) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 != r4) goto L36
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$1
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r6 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L53
        L36:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3e:
            kotlin.ResultKt.throwOnFailure(r9)
            r5 = r8
            r6 = r5
            r2 = r3
        L44:
            r0.L$0 = r6
            r0.L$1 = r5
            r0.I$0 = r2
            r0.label = r4
            java.lang.Object r9 = access$awaitSuspend(r5, r2, r0)
            if (r9 != r1) goto L53
            return r1
        L53:
            io.ktor.utils.io.core.ByteReadPacket r9 = access$getReadable(r5)
            boolean r9 = r9.hasBytes(r2)
            if (r9 == 0) goto L8a
            io.ktor.utils.io.core.ByteReadPacket r9 = r6.getReadable()
            io.ktor.utils.io.core.Input r9 = (io.ktor.utils.p098io.core.Input) r9
            double r0 = io.ktor.utils.p098io.core.InputPrimitivesKt.readDouble(r9)
            io.ktor.utils.io.core.ByteOrder r9 = r6.getReadByteOrder()
            io.ktor.utils.io.core.ByteOrder r2 = io.ktor.utils.p098io.core.ByteOrder.BIG_ENDIAN
            if (r9 != r2) goto L70
            goto L7c
        L70:
            long r0 = java.lang.Double.doubleToRawLongBits(r0)
            long r0 = java.lang.Long.reverseBytes(r0)
            double r0 = java.lang.Double.longBitsToDouble(r0)
        L7c:
            java.lang.Double r9 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r0)
            r0 = r9
            java.lang.Number r0 = (java.lang.Number) r0
            r0.doubleValue()
            r6.afterRead(r3)
            return r9
        L8a:
            r9 = 2
            r7 = 0
            checkClosed$default(r5, r2, r7, r9, r7)
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readDoubleSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readRemaining$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, long j, int i, Continuation continuation) throws Throwable {
        byteChannelSequentialBase.ensureNotFailed();
        BytePacketBuilder BytePacketBuilder = PacketJVMKt.BytePacketBuilder(i);
        BytePacketBuilder.writePacket(byteChannelSequentialBase.getReadable(), Math.min(j, byteChannelSequentialBase.getReadable().getRemaining()));
        long size = j - ((long) BytePacketBuilder.getSize());
        if (size == 0 || byteChannelSequentialBase.isClosedForRead()) {
            byteChannelSequentialBase.afterRead((int) size);
            byteChannelSequentialBase.ensureNotFailed(BytePacketBuilder);
            return BytePacketBuilder.build();
        }
        return byteChannelSequentialBase.readRemainingSuspend(BytePacketBuilder, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readRemainingSuspend(io.ktor.utils.p098io.core.BytePacketBuilder r11, long r12, kotlin.coroutines.Continuation<? super io.ktor.utils.p098io.core.ByteReadPacket> r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52801
            if (r0 == 0) goto L14
            r0 = r14
            io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1
            r0.<init>(r14)
        L19:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            long r11 = r0.J$0
            java.lang.Object r13 = r0.L$1
            io.ktor.utils.io.core.BytePacketBuilder r13 = (io.ktor.utils.p098io.core.BytePacketBuilder) r13
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r14)
            r8 = r11
            r11 = r13
            r12 = r8
            goto L43
        L37:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3f:
            kotlin.ResultKt.throwOnFailure(r14)
            r2 = r10
        L43:
            int r14 = r11.getSize()
            long r4 = (long) r14
            int r14 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r14 >= 0) goto L8a
            int r14 = r11.getSize()
            long r4 = (long) r14
            long r4 = r12 - r4
            io.ktor.utils.io.core.ByteReadPacket r14 = r2.getReadable()
            long r6 = r14.getRemaining()
            long r4 = java.lang.Math.min(r4, r6)
            io.ktor.utils.io.core.ByteReadPacket r14 = r2.getReadable()
            r11.writePacket(r14, r4)
            int r14 = (int) r4
            r2.afterRead(r14)
            r2.ensureNotFailed(r11)
            boolean r14 = r2.isClosedForRead()
            if (r14 != 0) goto L8a
            int r14 = r11.getSize()
            int r4 = (int) r12
            if (r14 != r4) goto L7b
            goto L8a
        L7b:
            r0.L$0 = r2
            r0.L$1 = r11
            r0.J$0 = r12
            r0.label = r3
            java.lang.Object r14 = r2.awaitSuspend(r3, r0)
            if (r14 != r1) goto L43
            return r1
        L8a:
            r2.ensureNotFailed(r11)
            io.ktor.utils.io.core.ByteReadPacket r11 = r11.build()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readRemainingSuspend(io.ktor.utils.io.core.BytePacketBuilder, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readPacket$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, int i, int i2, Continuation continuation) throws Throwable {
        checkClosed$default(byteChannelSequentialBase, i, null, 2, null);
        BytePacketBuilder BytePacketBuilder = PacketJVMKt.BytePacketBuilder(i2);
        int iMin = (int) Math.min(i, byteChannelSequentialBase.getReadable().getRemaining());
        int i3 = i - iMin;
        BytePacketBuilder.writePacket(byteChannelSequentialBase.getReadable(), iMin);
        byteChannelSequentialBase.afterRead(iMin);
        byteChannelSequentialBase.checkClosed(i3, BytePacketBuilder);
        if (i3 > 0) {
            return byteChannelSequentialBase.readPacketSuspend(BytePacketBuilder, i3, continuation);
        }
        return BytePacketBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readPacketSuspend(io.ktor.utils.p098io.core.BytePacketBuilder r10, int r11, kotlin.coroutines.Continuation<? super io.ktor.utils.p098io.core.ByteReadPacket> r12) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r12 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52791
            if (r0 == 0) goto L14
            r0 = r12
            io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52791) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1
            r0.<init>(r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$1
            io.ktor.utils.io.core.BytePacketBuilder r11 = (io.ktor.utils.p098io.core.BytePacketBuilder) r11
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r11
            r11 = r10
            r10 = r8
            goto L43
        L37:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3f:
            kotlin.ResultKt.throwOnFailure(r12)
            r2 = r9
        L43:
            if (r11 <= 0) goto L72
            long r4 = (long) r11
            io.ktor.utils.io.core.ByteReadPacket r12 = r2.getReadable()
            long r6 = r12.getRemaining()
            long r4 = java.lang.Math.min(r4, r6)
            int r12 = (int) r4
            int r11 = r11 - r12
            io.ktor.utils.io.core.ByteReadPacket r4 = r2.getReadable()
            r10.writePacket(r4, r12)
            r2.afterRead(r12)
            r2.checkClosed(r11, r10)
            if (r11 <= 0) goto L43
            r0.L$0 = r2
            r0.L$1 = r10
            r0.I$0 = r11
            r0.label = r3
            java.lang.Object r12 = r2.awaitSuspend(r3, r0)
            if (r12 != r1) goto L43
            return r1
        L72:
            r2.checkClosed(r11, r10)
            io.ktor.utils.io.core.ByteReadPacket r10 = r10.build()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readPacketSuspend(io.ktor.utils.io.core.BytePacketBuilder, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    protected final int readAvailableClosed() throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        if (getAvailableForRead() <= 0) {
            return -1;
        }
        prepareFlushedBytes();
        return -1;
    }

    static /* synthetic */ Object readAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, IoBuffer ioBuffer, Continuation continuation) {
        return byteChannelSequentialBase.readAvailable$ktor_io(ioBuffer, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readAvailable$ktor_io(io.ktor.utils.p098io.core.Buffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52682
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52682) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.p098io.core.Buffer) r6
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L7a
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Throwable r7 = r5.getClosedCause()
            if (r7 != 0) goto Laf
            boolean r7 = r5.getClosed()
            if (r7 == 0) goto L55
            int r7 = r5.getAvailableForRead()
            if (r7 != 0) goto L55
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L55:
            int r7 = r6.getLimit()
            int r2 = r6.getWritePosition()
            int r7 = r7 - r2
            if (r7 != 0) goto L66
            r6 = 0
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L66:
            int r7 = r5.getAvailableForRead()
            if (r7 != 0) goto L79
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r5.awaitSuspend(r3, r0)
            if (r7 != r1) goto L79
            return r1
        L79:
            r0 = r5
        L7a:
            io.ktor.utils.io.core.ByteReadPacket r7 = r0.getReadable()
            boolean r7 = r7.canRead()
            if (r7 != 0) goto L87
            r0.prepareFlushedBytes()
        L87:
            int r7 = r6.getLimit()
            int r1 = r6.getWritePosition()
            int r7 = r7 - r1
            long r1 = (long) r7
            io.ktor.utils.io.core.ByteReadPacket r7 = r0.getReadable()
            long r3 = r7.getRemaining()
            long r1 = java.lang.Math.min(r1, r3)
            int r7 = (int) r1
            io.ktor.utils.io.core.ByteReadPacket r1 = r0.getReadable()
            io.ktor.utils.io.core.Input r1 = (io.ktor.utils.p098io.core.Input) r1
            io.ktor.utils.p098io.core.InputArraysKt.readFully(r1, r6, r7)
            r0.afterRead(r7)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            return r6
        Laf:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readAvailable$ktor_io(io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readFully$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, IoBuffer ioBuffer, int i, Continuation continuation) throws Throwable {
        Object fully = byteChannelSequentialBase.readFully((Buffer) ioBuffer, i, (Continuation<? super Unit>) continuation);
        return fully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fully : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readFullySuspend(io.ktor.utils.p098io.core.Buffer r6, int r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52751
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52751) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1
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
            goto L64
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            int r7 = r0.I$0
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.p098io.core.Buffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L56
        L43:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.label = r4
            java.lang.Object r8 = r5.awaitSuspend(r7, r0)
            if (r8 != r1) goto L55
            return r1
        L55:
            r2 = r5
        L56:
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r6 = r2.readFully(r6, r7, r0)
            if (r6 != r1) goto L64
            return r1
        L64:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readFullySuspend(io.ktor.utils.io.core.Buffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object readAvailable$suspendImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r6, byte[] r7, int r8, int r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52694
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52694) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            int r6 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r8 = r0.L$1
            byte[] r8 = (byte[]) r8
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r9 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r4 = r9
            r9 = r6
            r6 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L7e
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Throwable r10 = r6.getClosedCause()
            if (r10 != 0) goto Laa
            boolean r10 = r6.getClosed()
            if (r10 == 0) goto L5f
            int r10 = r6.getAvailableForRead()
            if (r10 != 0) goto L5f
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L5f:
            if (r9 != 0) goto L67
            r6 = 0
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L67:
            int r10 = r6.getAvailableForRead()
            if (r10 != 0) goto L7e
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.I$1 = r9
            r0.label = r3
            java.lang.Object r10 = r6.awaitSuspend(r3, r0)
            if (r10 != r1) goto L7e
            return r1
        L7e:
            io.ktor.utils.io.core.ByteReadPacket r10 = r6.getReadable()
            boolean r10 = r10.canRead()
            if (r10 != 0) goto L8b
            r6.prepareFlushedBytes()
        L8b:
            long r9 = (long) r9
            io.ktor.utils.io.core.ByteReadPacket r0 = r6.getReadable()
            long r0 = r0.getRemaining()
            long r9 = java.lang.Math.min(r9, r0)
            int r9 = (int) r9
            io.ktor.utils.io.core.ByteReadPacket r10 = r6.getReadable()
            io.ktor.utils.io.core.Input r10 = (io.ktor.utils.p098io.core.Input) r10
            io.ktor.utils.p098io.core.InputArraysKt.readFully(r10, r7, r8, r9)
            r6.afterRead(r9)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            return r6
        Laa:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readAvailable$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object readFully$suspendImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r5, byte[] r6, int r7, int r8, kotlin.coroutines.Continuation r9) throws java.io.EOFException {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52746
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$readFully$6 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52746) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readFully$6 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFully$6
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L78
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            int r8 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r5 = r0.L$1
            r6 = r5
            byte[] r6 = (byte[]) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5a
        L46:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r9 = r5.readAvailable(r6, r7, r8, r0)
            if (r9 != r1) goto L5a
            return r1
        L5a:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            if (r9 != r8) goto L65
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L65:
            r2 = -1
            if (r9 == r2) goto L7b
            int r7 = r7 + r9
            int r8 = r8 - r9
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r5 = r5.readFullySuspend(r6, r7, r8, r0)
            if (r5 != r1) goto L78
            return r1
        L78:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L7b:
            java.io.EOFException r5 = new java.io.EOFException
            java.lang.String r6 = "Unexpected end of stream"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0067 -> B:12:0x003a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readFullySuspend(byte[] r8, int r9, int r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.io.EOFException {
        /*
            r7 = this;
            boolean r0 = r11 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52762
            if (r0 == 0) goto L14
            r0 = r11
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52762) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            int r8 = r0.I$2
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            byte[] r2 = (byte[]) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r11)
            r6 = r0
            r0 = r9
            r9 = r2
        L3a:
            r2 = r6
            goto L6b
        L3c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L44:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 0
            r4 = r7
            r6 = r9
            r9 = r8
            r8 = r11
            r11 = r10
            r10 = r6
        L4e:
            if (r8 >= r11) goto L80
            int r2 = r10 + r8
            int r5 = r11 - r8
            r0.L$0 = r4
            r0.L$1 = r9
            r0.I$0 = r10
            r0.I$1 = r11
            r0.I$2 = r8
            r0.label = r3
            java.lang.Object r2 = r4.readAvailable(r9, r2, r5, r0)
            if (r2 != r1) goto L67
            return r1
        L67:
            r6 = r0
            r0 = r11
            r11 = r2
            goto L3a
        L6b:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            r5 = -1
            if (r11 == r5) goto L78
            int r8 = r8 + r11
            r11 = r0
            r0 = r2
            goto L4e
        L78:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.String r9 = "Unexpected end of stream"
            r8.<init>(r9)
            throw r8
        L80:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readFullySuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readBoolean$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!byteChannelSequentialBase.getReadable().canRead()) {
            return byteChannelSequentialBase.readBooleanSlow(continuation);
        }
        boolean z = byteChannelSequentialBase.getReadable().readByte() == 1;
        byteChannelSequentialBase.afterRead(1);
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readBooleanSlow(kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52701
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52701) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5b
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L3d:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.awaitSuspend(r4, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            r2 = r5
        L4c:
            r6 = 0
            checkClosed$default(r2, r4, r6, r3, r6)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r2.readBoolean(r0)
            if (r6 != r1) goto L5b
            return r1
        L5b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readBooleanSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int getLastReadAvailable() {
        return this.state.getLastReadAvailable();
    }

    private final void setLastReadAvailable(int i) {
        this.state.setLastReadAvailable(i);
    }

    private final ChunkBuffer getLastReadView() {
        return this.state.getLastReadView();
    }

    private final void setLastReadView(ChunkBuffer chunkBuffer) {
        this.state.setLastReadView(chunkBuffer);
    }

    private final void completeReading() {
        ChunkBuffer lastReadView = getLastReadView();
        int lastReadAvailable = getLastReadAvailable() - (lastReadView.getWritePosition() - lastReadView.getReadPosition());
        if (getLastReadView() != Buffer.INSTANCE.getEmpty()) {
            UnsafeKt.completeReadHead(this.readable, getLastReadView());
        }
        if (lastReadAvailable > 0) {
            afterRead(lastReadAvailable);
        }
        setLastReadAvailable(0);
        setLastReadView(ChunkBuffer.INSTANCE.getEmpty());
    }

    static /* synthetic */ Object await$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, final int i, Continuation continuation) {
        if (!(i >= 0)) {
            new RequireFailureCapture() { // from class: io.ktor.utils.io.ByteChannelSequentialBase$await$suspendImpl$$inlined$require$1
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("atLeast parameter shouldn't be negative: ", Integer.valueOf(i)));
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
        long j = i;
        if (j <= 4088) {
            byteChannelSequentialBase.completeReading();
            if (i == 0) {
                return Boxing.boxBoolean(!byteChannelSequentialBase.isClosedForRead());
            }
            return byteChannelSequentialBase.getReadable().getRemaining() >= j ? Boxing.boxBoolean(true) : byteChannelSequentialBase.awaitSuspend(i, continuation);
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.ByteChannelSequentialBase$await$suspendImpl$$inlined$require$2
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException(Intrinsics.stringPlus("atLeast parameter shouldn't be larger than max buffer size of 4088: ", Integer.valueOf(i)));
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    public final Object awaitInternalAtLeast1$ktor_io(Continuation<? super Boolean> continuation) {
        if (getReadable().isEmpty()) {
            return awaitSuspend(1, continuation);
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitSuspend(int r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52651
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52651) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1
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
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L51
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            if (r6 < 0) goto L40
            r7 = r4
            goto L41
        L40:
            r7 = r3
        L41:
            if (r7 == 0) goto L6d
            r0.L$0 = r5
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForRead$ktor_io(r6, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            r0 = r5
        L51:
            r0.prepareFlushedBytes()
            java.lang.Throwable r7 = r0.getClosedCause()
            if (r7 != 0) goto L6c
            boolean r7 = r0.isClosedForRead()
            if (r7 != 0) goto L67
            int r7 = r0.getAvailableForRead()
            if (r7 < r6) goto L67
            r3 = r4
        L67:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        L6c:
            throw r7
        L6d:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Failed requirement."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.awaitSuspend(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.p098io.ReadSession
    public int discard(int n) throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        if (n == 0) {
            return 0;
        }
        int iDiscard = this.readable.discard(n);
        afterRead(n);
        requestNextView(1);
        return iDiscard;
    }

    @Override // io.ktor.utils.p098io.ReadSession
    public IoBuffer request(int atLeast) throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        completeReading();
        return requestNextView(atLeast);
    }

    private final IoBuffer requestNextView(int atLeast) {
        if (this.readable.isEmpty()) {
            prepareFlushedBytes();
        }
        IoBuffer ioBuffer = (IoBuffer) this.readable.prepareReadHead(atLeast);
        if (ioBuffer == null) {
            setLastReadView(ChunkBuffer.INSTANCE.getEmpty());
            setLastReadAvailable(0);
        } else {
            setLastReadView(ioBuffer);
            IoBuffer ioBuffer2 = ioBuffer;
            setLastReadAvailable(ioBuffer2.getWritePosition() - ioBuffer2.getReadPosition());
        }
        return ioBuffer;
    }

    static /* synthetic */ Object discard$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, long j, Continuation continuation) throws Throwable {
        long jDiscard = byteChannelSequentialBase.getReadable().discard(j);
        if (jDiscard == j || byteChannelSequentialBase.isClosedForRead()) {
            byteChannelSequentialBase.ensureNotFailed();
            return Boxing.boxLong(jDiscard);
        }
        return byteChannelSequentialBase.discardSuspend(j, jDiscard, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004d -> B:19:0x0050). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object discardSuspend(long r9, long r11, kotlin.coroutines.Continuation<? super java.lang.Long> r13) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r13 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52671
            if (r0 == 0) goto L14
            r0 = r13
            io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52671) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1
            r0.<init>(r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            long r9 = r0.J$1
            long r11 = r0.J$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r13)
            goto L50
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            kotlin.ResultKt.throwOnFailure(r13)
            r2 = r8
        L3e:
            r0.L$0 = r2
            r0.J$0 = r9
            r0.J$1 = r11
            r0.label = r3
            java.lang.Object r13 = r2.await(r3, r0)
            if (r13 != r1) goto L4d
            return r1
        L4d:
            r6 = r9
            r9 = r11
            r11 = r6
        L50:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L59
            goto L73
        L59:
            io.ktor.utils.io.core.ByteReadPacket r13 = r2.getReadable()
            long r4 = r11 - r9
            long r4 = r13.discard(r4)
            long r9 = r9 + r4
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L73
            boolean r13 = r2.isClosedForRead()
            if (r13 == 0) goto L6f
            goto L73
        L6f:
            r6 = r9
            r9 = r11
            r11 = r6
            goto L3e
        L73:
            r2.ensureNotFailed()
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.discardSuspend(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    @Deprecated(message = "Use read instead.")
    public void readSession(Function1<? super ReadSession, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        try {
            consumer.invoke(this);
        } finally {
            completeReading();
        }
    }

    @Override // io.ktor.utils.p098io.HasReadSession
    public SuspendableReadSession startReadSession() {
        return this;
    }

    @Override // io.ktor.utils.p098io.HasReadSession
    public void endReadSession() {
        completeReading();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r4v0, types: [io.ktor.utils.io.ByteChannelSequentialBase, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [io.ktor.utils.io.ByteChannelSequentialBase] */
    /* JADX WARN: Type inference failed for: r4v2, types: [io.ktor.utils.io.ByteChannelSequentialBase] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @kotlin.Deprecated(message = "Use read instead.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object readSuspendableSession$suspendImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r4, kotlin.jvm.functions.Function2 r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52821
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52821) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L4a
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L4a
            r0.label = r3     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r5 = r5.invoke(r4, r0)     // Catch: java.lang.Throwable -> L4a
            if (r5 != r1) goto L44
            return r1
        L44:
            r4.completeReading()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L4a:
            r5 = move-exception
            r4.completeReading()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readSuspendableSession$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readUTF8LineTo$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Appendable appendable, int i, Continuation continuation) throws Throwable {
        if (byteChannelSequentialBase.isClosedForRead()) {
            Throwable closedCause = byteChannelSequentialBase.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            return Boxing.boxBoolean(false);
        }
        return UTF8Kt.decodeUTF8LineLoopSuspend(appendable, i, byteChannelSequentialBase.new C52842(null), continuation);
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readUTF8LineTo$2 */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(m5597d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\f\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u008a@"}, m5598d2 = {"<anonymous>", "Lio/ktor/utils/io/core/AbstractInput;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "size", ""}, m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase$readUTF8LineTo$2", m5608f = "ByteChannelSequential.kt", m5609i = {}, m5610l = {801}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C52842 extends SuspendLambda implements Function2<Integer, Continuation<? super AbstractInput>, Object> {
        /* synthetic */ int I$0;
        int label;

        C52842(Continuation<? super C52842> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C52842 c52842 = ByteChannelSequentialBase.this.new C52842(continuation);
            c52842.I$0 = ((Number) obj).intValue();
            return c52842;
        }

        public final Object invoke(int i, Continuation<? super AbstractInput> continuation) {
            return ((C52842) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super AbstractInput> continuation) {
            return invoke(num.intValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int i2 = this.I$0;
                ByteChannelSequentialBase.this.afterRead(i2);
                this.label = 1;
                obj = ByteChannelSequentialBase.this.await(i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                return ByteChannelSequentialBase.this.getReadable();
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object readUTF8Line$suspendImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r5, int r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52831
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52831) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1
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
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.readUTF8Line$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public boolean cancel(Throwable cause) {
        if (getClosedCause() != null || getClosed()) {
            return false;
        }
        if (cause == null) {
            cause = new CancellationException("Channel cancelled");
        }
        return close(cause);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public boolean close(Throwable cause) {
        if (getClosed() || getClosedCause() != null) {
            return false;
        }
        setClosedCause(cause);
        setClosed(true);
        if (cause != null) {
            this.readable.release();
            this.writable.release();
            this.flushBuffer.release();
        } else {
            flush();
        }
        this.slot.cancel(cause);
        return true;
    }

    public final long transferTo$ktor_io(ByteChannelSequentialBase dst, long limit) throws Throwable {
        Intrinsics.checkNotNullParameter(dst, "dst");
        long remaining = this.readable.getRemaining();
        if (remaining > limit) {
            return 0L;
        }
        dst.writable.writePacket(this.readable);
        int i = (int) remaining;
        dst.afterWrite(i);
        afterRead(i);
        return remaining;
    }

    private final Object readNSlow(int i, Function0 function0, Continuation<?> continuation) throws Throwable {
        while (true) {
            InlineMarker.mark(0);
            awaitSuspend(i, continuation);
            InlineMarker.mark(1);
            if (this.readable.hasBytes(i)) {
                function0.invoke();
                throw new KotlinNothingValueException();
            }
            checkClosed$default(this, i, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeAvailableSuspend(io.ktor.utils.p098io.core.IoBuffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52851
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52851) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1
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
            goto L60
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.core.IoBuffer r6 = (io.ktor.utils.p098io.core.IoBuffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L52
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r4, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            r2 = r5
        L52:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r2.writeAvailable(r6, r0)
            if (r7 != r1) goto L60
            return r1
        L60:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.writeAvailableSuspend(io.ktor.utils.io.core.IoBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeAvailableSuspend(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation<? super java.lang.Integer> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52862
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52862) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2
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
            goto L68
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
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5a
        L45:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r9 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r4, r0)
            if (r9 != r1) goto L59
            return r1
        L59:
            r2 = r5
        L5a:
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r9 = r2.writeAvailable(r6, r7, r8, r0)
            if (r9 != r1) goto L68
            return r1
        L68:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.writeAvailableSuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Consider providing written count of bytes")
    protected final void afterWrite() throws Throwable {
        afterWrite(0);
    }

    protected final void afterWrite(int count) throws Throwable {
        set_totalBytesWritten(get_totalBytesWritten() + ((long) count));
        if (getClosed()) {
            this.writable.release();
            ensureNotClosed();
        }
        if (getAutoFlush() || getAvailableForWrite() == 0) {
            flush();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object awaitFreeSpace$suspendImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r4, kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase.C52641
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialBase.C52641) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L47
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r4.flush()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            r4.ensureNotClosed()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.awaitFreeSpace$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // io.ktor.utils.p098io.ByteReadChannel
    /* JADX INFO: renamed from: peekTo-vHUFkk8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mo6940peekTovHUFkk8(java.nio.ByteBuffer r19, long r20, long r22, long r24, long r26, kotlin.coroutines.Continuation<? super java.lang.Long> r28) {
        /*
            r18 = this;
            r0 = r18
            r1 = r28
            boolean r2 = r1 instanceof io.ktor.utils.p098io.ByteChannelSequentialBase$peekTo$1
            if (r2 == 0) goto L18
            r2 = r1
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1 r2 = (io.ktor.utils.p098io.ByteChannelSequentialBase$peekTo$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1 r2 = new io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L3a
            if (r4 != r5) goto L32
            java.lang.Object r2 = r2.L$0
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L63
        L32:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3a:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$LongRef r1 = new kotlin.jvm.internal.Ref$LongRef
            r1.<init>()
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2 r4 = new io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2
            r17 = 0
            r6 = r4
            r7 = r24
            r9 = r22
            r11 = r1
            r12 = r26
            r14 = r19
            r15 = r20
            r6.<init>(r7, r9, r11, r12, r14, r15, r17)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2.L$0 = r1
            r2.label = r5
            java.lang.Object r2 = r0.readSuspendableSession(r4, r2)
            if (r2 != r3) goto L62
            return r3
        L62:
            r2 = r1
        L63:
            long r1 = r2.element
            java.lang.Long r1 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialBase.mo6940peekTovHUFkk8(java.nio.ByteBuffer, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public int getAvailableForWrite() {
        return Math.max(0, 4088 - (getAvailableForRead() + this.writable.getSize()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readFully(Buffer buffer, final int i, Continuation<? super Unit> continuation) throws Throwable {
        if (!(i <= buffer.getLimit() - buffer.getWritePosition())) {
            new RequireFailureCapture() { // from class: io.ktor.utils.io.ByteChannelSequentialBase$readFully$$inlined$require$1
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    throw new IllegalArgumentException("Not enough space in the destination buffer to write " + i + " bytes");
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
        if (i >= 0) {
            if (getClosedCause() != null) {
                Throwable closedCause = getClosedCause();
                Intrinsics.checkNotNull(closedCause);
                throw closedCause;
            }
            if (getReadable().getRemaining() >= i) {
                InputArraysKt.readFully(getReadable(), buffer, i);
                Unit unit = Unit.INSTANCE;
                afterRead(i);
                return unit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? unit : Unit.INSTANCE;
            }
            if (getClosed()) {
                throw new EOFException("Channel is closed and not enough bytes available: required " + i + " but " + getAvailableForRead() + " available");
            }
            Object fullySuspend = readFullySuspend(buffer, i, continuation);
            return fullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fullySuspend : Unit.INSTANCE;
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.ByteChannelSequentialBase$readFully$$inlined$require$2
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException("n shouldn't be negative");
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }
}
