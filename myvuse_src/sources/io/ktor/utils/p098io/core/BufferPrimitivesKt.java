package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.brentvatne.react.ReactVideoViewManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.bits.MemoryJvmKt;
import io.ktor.utils.p098io.bits.PrimitiveArraysJvmKt;
import io.ktor.utils.p098io.core.internal.RequireFailureCapture;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BufferPrimitives.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0087\bø\u0001\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000e2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a0\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001a0\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a0\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00182\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a0\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u001b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a)\u0010\u0006\u001a\u00020\u0007*\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0087\b\u001a\n\u0010\u001f\u001a\u00020 *\u00020\u0002\u001a\r\u0010\u001f\u001a\u00020 *\u00020\u001eH\u0087\b\u001as\u0010!\u001a\u0002H\"\"\u0004\b\u0000\u0010\"*\u00020\u00022\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%26\u0010\u0003\u001a2\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b$\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b(\u0012\b\b$\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\"0&H\u0081\bø\u0001\u0001ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001¢\u0006\u0002\u0010*\u001a\n\u0010+\u001a\u00020,*\u00020\u0002\u001a\r\u0010+\u001a\u00020,*\u00020\u001eH\u0087\b\u001a\u001c\u0010-\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000e2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a0\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001¢\u0006\u0004\b.\u0010/\u001a0\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001¢\u0006\u0004\b0\u00101\u001a0\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00182\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001¢\u0006\u0004\b2\u00103\u001a0\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u001b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001¢\u0006\u0004\b4\u00105\u001a)\u0010-\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0087\b\u001a\n\u00106\u001a\u00020\u0007*\u00020\u0002\u001a\r\u00106\u001a\u00020\u0007*\u00020\u001eH\u0087\b\u001a\n\u00107\u001a\u000208*\u00020\u0002\u001a\r\u00107\u001a\u000208*\u00020\u001eH\u0087\b\u001a\n\u00109\u001a\u00020:*\u00020\u0002\u001a\r\u00109\u001a\u00020:*\u00020\u001eH\u0087\b\u001a\u0012\u0010;\u001a\u00020<*\u00020\u0002ø\u0001\u0001¢\u0006\u0002\u0010=\u001a\u0015\u0010;\u001a\u00020<*\u00020\u001eH\u0087\bø\u0001\u0001¢\u0006\u0002\u0010>\u001a\u0012\u0010?\u001a\u00020@*\u00020\u0002ø\u0001\u0001¢\u0006\u0002\u0010A\u001a\u0015\u0010?\u001a\u00020@*\u00020\u001eH\u0087\bø\u0001\u0001¢\u0006\u0002\u0010B\u001a\u0012\u0010C\u001a\u00020D*\u00020\u0002ø\u0001\u0001¢\u0006\u0002\u0010E\u001a\u0015\u0010C\u001a\u00020D*\u00020\u001eH\u0087\bø\u0001\u0001¢\u0006\u0002\u0010F\u001a\u0012\u0010G\u001a\u00020H*\u00020\u0002ø\u0001\u0001¢\u0006\u0002\u0010I\u001a\u0015\u0010G\u001a\u00020H*\u00020\u001eH\u0087\bø\u0001\u0001¢\u0006\u0002\u0010J\u001a\u0012\u0010K\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020 \u001a\u0015\u0010K\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020 H\u0087\b\u001ah\u0010M\u001a\u00020\u0001*\u00020\u00022\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%26\u0010\u0003\u001a2\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b$\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b(\u0012\b\b$\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010&H\u0081\bø\u0001\u0001ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u001a\u0012\u0010N\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020,\u001a\u0015\u0010N\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020,H\u0087\b\u001a\u0012\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010P\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u000e2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a0\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001¢\u0006\u0004\bR\u0010/\u001a0\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001¢\u0006\u0004\bS\u00101\u001a0\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00182\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001¢\u0006\u0004\bT\u00103\u001a0\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u001b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001¢\u0006\u0004\bU\u00105\u001a)\u0010O\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010Q\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0087\b\u001a\u0012\u0010V\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020\u0007\u001a\u0015\u0010V\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020\u0007H\u0087\b\u001a\u0012\u0010W\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u000208\u001a\u0015\u0010W\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u000208H\u0087\b\u001a\u0012\u0010X\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020:\u001a\u0015\u0010X\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020:H\u0087\b\u001a\u001c\u0010Y\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020<ø\u0001\u0001¢\u0006\u0004\bZ\u0010[\u001a\u001e\u0010Y\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020<H\u0007ø\u0001\u0001¢\u0006\u0004\b\\\u0010]\u001a\u001c\u0010^\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020@ø\u0001\u0001¢\u0006\u0004\b_\u0010`\u001a\u001f\u0010^\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020@H\u0087\bø\u0001\u0001¢\u0006\u0004\ba\u0010b\u001a\u001c\u0010c\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020Dø\u0001\u0001¢\u0006\u0004\bd\u0010e\u001a\u001f\u0010c\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020DH\u0087\bø\u0001\u0001¢\u0006\u0004\bf\u0010g\u001a\u001c\u0010h\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020Hø\u0001\u0001¢\u0006\u0004\bi\u0010j\u001a\u001f\u0010h\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020HH\u0087\bø\u0001\u0001¢\u0006\u0004\bk\u0010l\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006m"}, m5598d2 = {"forEach", "", "Lio/ktor/utils/io/core/Buffer;", "block", "Lkotlin/Function1;", "", "readAvailable", "", C4352k.a.f5652f, "length", FirebaseAnalytics.Param.DESTINATION, "", TypedValues.CycleType.S_WAVE_OFFSET, "", "", "", "", "", "Lkotlin/UByteArray;", "readAvailable-mPGAOow", "(Lio/ktor/utils/io/core/Buffer;[BII)I", "Lkotlin/UIntArray;", "readAvailable-uM_xt_c", "(Lio/ktor/utils/io/core/Buffer;[III)I", "Lkotlin/ULongArray;", "readAvailable-eOostTs", "(Lio/ktor/utils/io/core/Buffer;[JII)I", "Lkotlin/UShortArray;", "readAvailable-d1ESLyo", "(Lio/ktor/utils/io/core/Buffer;[SII)I", "Lio/ktor/utils/io/core/IoBuffer;", "readDouble", "", "readExact", "R", "size", "name", "", "Lkotlin/Function2;", "Lio/ktor/utils/io/bits/Memory;", "Lkotlin/ParameterName;", "memory", "(Lio/ktor/utils/io/core/Buffer;ILjava/lang/String;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "readFloat", "", "readFully", "readFully-mPGAOow", "(Lio/ktor/utils/io/core/Buffer;[BII)V", "readFully-uM_xt_c", "(Lio/ktor/utils/io/core/Buffer;[III)V", "readFully-eOostTs", "(Lio/ktor/utils/io/core/Buffer;[JII)V", "readFully-d1ESLyo", "(Lio/ktor/utils/io/core/Buffer;[SII)V", "readInt", "readLong", "", "readShort", "", "readUByte", "Lkotlin/UByte;", "(Lio/ktor/utils/io/core/Buffer;)B", "(Lio/ktor/utils/io/core/IoBuffer;)B", "readUInt", "Lkotlin/UInt;", "(Lio/ktor/utils/io/core/Buffer;)I", "(Lio/ktor/utils/io/core/IoBuffer;)I", "readULong", "Lkotlin/ULong;", "(Lio/ktor/utils/io/core/Buffer;)J", "(Lio/ktor/utils/io/core/IoBuffer;)J", "readUShort", "Lkotlin/UShort;", "(Lio/ktor/utils/io/core/Buffer;)S", "(Lio/ktor/utils/io/core/IoBuffer;)S", "writeDouble", "value", "writeExact", "writeFloat", "writeFully", ReactVideoViewManager.PROP_SRC, "source", "writeFully-mPGAOow", "writeFully-uM_xt_c", "writeFully-eOostTs", "writeFully-d1ESLyo", "writeInt", "writeLong", "writeShort", "writeUByte", "writeUByte-Nf7JEWI", "(Lio/ktor/utils/io/core/Buffer;B)V", "writeUByte-Bde3r5E", "(Lio/ktor/utils/io/core/IoBuffer;B)V", "writeUInt", "writeUInt-_mVlKAM", "(Lio/ktor/utils/io/core/Buffer;I)V", "writeUInt-WnNSA2s", "(Lio/ktor/utils/io/core/IoBuffer;I)V", "writeULong", "writeULong-Zrk_yTk", "(Lio/ktor/utils/io/core/Buffer;J)V", "writeULong-cJ4FwcA", "(Lio/ktor/utils/io/core/IoBuffer;J)V", "writeUShort", "writeUShort-YTqlC3I", "(Lio/ktor/utils/io/core/Buffer;S)V", "writeUShort-kYKMprU", "(Lio/ktor/utils/io/core/IoBuffer;S)V", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class BufferPrimitivesKt {
    public static final byte readUByte(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return UByte.m7251constructorimpl(buffer.readByte());
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final byte readUByte(IoBuffer ioBuffer) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        return readUByte((Buffer) ioBuffer);
    }

    /* JADX INFO: renamed from: writeUByte-Nf7JEWI, reason: not valid java name */
    public static final void m7136writeUByteNf7JEWI(Buffer writeUByte, byte b) {
        Intrinsics.checkNotNullParameter(writeUByte, "$this$writeUByte");
        writeUByte.writeByte(b);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    /* JADX INFO: renamed from: writeUByte-Bde3r5E, reason: not valid java name */
    public static final void m7135writeUByteBde3r5E(IoBuffer writeUByte, byte b) {
        Intrinsics.checkNotNullParameter(writeUByte, "$this$writeUByte");
        m7136writeUByteNf7JEWI(writeUByte, b);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final short readShort(IoBuffer ioBuffer) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        return readShort((Buffer) ioBuffer);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final short readUShort(IoBuffer ioBuffer) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        return readUShort((Buffer) ioBuffer);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final int readInt(IoBuffer ioBuffer) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        return readInt((Buffer) ioBuffer);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final int readUInt(IoBuffer ioBuffer) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        return readUInt((Buffer) ioBuffer);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final long readLong(IoBuffer ioBuffer) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        return readLong((Buffer) ioBuffer);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final long readULong(IoBuffer ioBuffer) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        return readULong((Buffer) ioBuffer);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final float readFloat(IoBuffer ioBuffer) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        return readFloat((Buffer) ioBuffer);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final double readDouble(IoBuffer ioBuffer) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        return readDouble((Buffer) ioBuffer);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void writeShort(IoBuffer ioBuffer, short s) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        writeShort((Buffer) ioBuffer, s);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    /* JADX INFO: renamed from: writeUShort-kYKMprU, reason: not valid java name */
    public static final void m7142writeUShortkYKMprU(IoBuffer writeUShort, short s) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeUShort, "$this$writeUShort");
        m7141writeUShortYTqlC3I(writeUShort, s);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void writeInt(IoBuffer ioBuffer, int i) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        writeInt((Buffer) ioBuffer, i);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    /* JADX INFO: renamed from: writeUInt-WnNSA2s, reason: not valid java name */
    public static final void m7137writeUIntWnNSA2s(IoBuffer writeUInt, int i) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeUInt, "$this$writeUInt");
        m7138writeUInt_mVlKAM(writeUInt, i);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void writeLong(IoBuffer ioBuffer, long j) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        writeLong((Buffer) ioBuffer, j);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    /* JADX INFO: renamed from: writeULong-cJ4FwcA, reason: not valid java name */
    public static final void m7140writeULongcJ4FwcA(IoBuffer writeULong, long j) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeULong, "$this$writeULong");
        m7139writeULongZrk_yTk(writeULong, j);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void writeFloat(IoBuffer ioBuffer, float f) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        writeFloat((Buffer) ioBuffer, f);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void writeDouble(IoBuffer ioBuffer, double d) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        writeDouble((Buffer) ioBuffer, d);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        readFully(buffer, bArr, i, i2);
    }

    public static /* synthetic */ void readFully$default(IoBuffer ioBuffer, byte[] destination, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = destination.length - i;
        }
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        readFully((Buffer) ioBuffer, destination, i, i2);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final void readFully(IoBuffer ioBuffer, byte[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        readFully((Buffer) ioBuffer, destination, i, i2);
    }

    /* JADX INFO: renamed from: readFully-mPGAOow$default, reason: not valid java name */
    public static /* synthetic */ void m7124readFullymPGAOow$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m7310getSizeimpl(bArr) - i;
        }
        m7123readFullymPGAOow(buffer, bArr, i, i2);
    }

    /* JADX INFO: renamed from: readFully-mPGAOow, reason: not valid java name */
    public static final void m7123readFullymPGAOow(Buffer readFully, byte[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(destination, "destination");
        readFully(readFully, destination, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        return readAvailable(buffer, bArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, final byte[] destination, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (!(i >= 0)) {
            new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$1
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("offset shouldn't be negative: ", Integer.valueOf(i)));
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
        if (i2 >= 0) {
            if (!(i + i2 <= destination.length)) {
                new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$3
                    @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                    public Void doFail() {
                        throw new IllegalArgumentException("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + destination.length);
                    }
                }.doFail();
                throw new KotlinNothingValueException();
            }
            if (buffer.getWritePosition() <= buffer.getReadPosition()) {
                return -1;
            }
            int iMin = Math.min(i2, buffer.getWritePosition() - buffer.getReadPosition());
            readFully(buffer, destination, i, iMin);
            return iMin;
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$2
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException(Intrinsics.stringPlus("length shouldn't be negative: ", Integer.valueOf(i2)));
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ int readAvailable$default(IoBuffer ioBuffer, byte[] destination, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = destination.length - i;
        }
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return readAvailable((Buffer) ioBuffer, destination, i, i2);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final int readAvailable(IoBuffer ioBuffer, byte[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return readAvailable((Buffer) ioBuffer, destination, i, i2);
    }

    /* JADX INFO: renamed from: readAvailable-mPGAOow$default, reason: not valid java name */
    public static /* synthetic */ int m7116readAvailablemPGAOow$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m7310getSizeimpl(bArr) - i;
        }
        return m7115readAvailablemPGAOow(buffer, bArr, i, i2);
    }

    /* JADX INFO: renamed from: readAvailable-mPGAOow, reason: not valid java name */
    public static final int m7115readAvailablemPGAOow(Buffer readAvailable, byte[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(readAvailable, "$this$readAvailable");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return readAvailable(readAvailable, destination, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        writeFully(buffer, bArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(IoBuffer ioBuffer, byte[] source, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = source.length - i;
        }
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFully((Buffer) ioBuffer, source, i, i2);
    }

    @Deprecated(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void writeFully(IoBuffer ioBuffer, byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFully((Buffer) ioBuffer, source, i, i2);
    }

    /* JADX INFO: renamed from: writeFully-mPGAOow$default, reason: not valid java name */
    public static /* synthetic */ void m7132writeFullymPGAOow$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m7310getSizeimpl(bArr) - i;
        }
        m7131writeFullymPGAOow(buffer, bArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFully-mPGAOow, reason: not valid java name */
    public static final void m7131writeFullymPGAOow(Buffer writeFully, byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFully(writeFully, source, i, i2);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        readFully(buffer, sArr, i, i2);
    }

    /* JADX INFO: renamed from: readFully-d1ESLyo$default, reason: not valid java name */
    public static /* synthetic */ void m7120readFullyd1ESLyo$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m7573getSizeimpl(sArr) - i;
        }
        m7119readFullyd1ESLyo(buffer, sArr, i, i2);
    }

    /* JADX INFO: renamed from: readFully-d1ESLyo, reason: not valid java name */
    public static final void m7119readFullyd1ESLyo(Buffer readFully, short[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(destination, "destination");
        readFully(readFully, destination, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        return readAvailable(buffer, sArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, final short[] destination, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (!(i >= 0)) {
            new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$4
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("offset shouldn't be negative: ", Integer.valueOf(i)));
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
        if (i2 >= 0) {
            if (!(i + i2 <= destination.length)) {
                new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$6
                    @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                    public Void doFail() {
                        throw new IllegalArgumentException("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + destination.length);
                    }
                }.doFail();
                throw new KotlinNothingValueException();
            }
            if (buffer.getWritePosition() <= buffer.getReadPosition()) {
                return -1;
            }
            int iMin = Math.min(i2 / 2, buffer.getWritePosition() - buffer.getReadPosition());
            readFully(buffer, destination, i, iMin);
            return iMin;
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$5
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException(Intrinsics.stringPlus("length shouldn't be negative: ", Integer.valueOf(i2)));
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: readAvailable-d1ESLyo$default, reason: not valid java name */
    public static /* synthetic */ int m7112readAvailabled1ESLyo$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m7573getSizeimpl(sArr) - i;
        }
        return m7111readAvailabled1ESLyo(buffer, sArr, i, i2);
    }

    /* JADX INFO: renamed from: readAvailable-d1ESLyo, reason: not valid java name */
    public static final int m7111readAvailabled1ESLyo(Buffer readAvailable, short[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(readAvailable, "$this$readAvailable");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return readAvailable(readAvailable, destination, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        writeFully(buffer, sArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFully-d1ESLyo$default, reason: not valid java name */
    public static /* synthetic */ void m7128writeFullyd1ESLyo$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m7573getSizeimpl(sArr) - i;
        }
        m7127writeFullyd1ESLyo(buffer, sArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFully-d1ESLyo, reason: not valid java name */
    public static final void m7127writeFullyd1ESLyo(Buffer writeFully, short[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFully(writeFully, source, i, i2);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        readFully(buffer, iArr, i, i2);
    }

    /* JADX INFO: renamed from: readFully-uM_xt_c$default, reason: not valid java name */
    public static /* synthetic */ void m7126readFullyuM_xt_c$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m7389getSizeimpl(iArr) - i;
        }
        m7125readFullyuM_xt_c(buffer, iArr, i, i2);
    }

    /* JADX INFO: renamed from: readFully-uM_xt_c, reason: not valid java name */
    public static final void m7125readFullyuM_xt_c(Buffer readFully, int[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(destination, "destination");
        readFully(readFully, destination, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        return readAvailable(buffer, iArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, final int[] destination, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (!(i >= 0)) {
            new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$7
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("offset shouldn't be negative: ", Integer.valueOf(i)));
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
        if (i2 >= 0) {
            if (!(i + i2 <= destination.length)) {
                new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$9
                    @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                    public Void doFail() {
                        throw new IllegalArgumentException("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + destination.length);
                    }
                }.doFail();
                throw new KotlinNothingValueException();
            }
            if (buffer.getWritePosition() <= buffer.getReadPosition()) {
                return -1;
            }
            int iMin = Math.min(i2 / 4, buffer.getWritePosition() - buffer.getReadPosition());
            readFully(buffer, destination, i, iMin);
            return iMin;
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$8
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException(Intrinsics.stringPlus("length shouldn't be negative: ", Integer.valueOf(i2)));
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: readAvailable-uM_xt_c$default, reason: not valid java name */
    public static /* synthetic */ int m7118readAvailableuM_xt_c$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m7389getSizeimpl(iArr) - i;
        }
        return m7117readAvailableuM_xt_c(buffer, iArr, i, i2);
    }

    /* JADX INFO: renamed from: readAvailable-uM_xt_c, reason: not valid java name */
    public static final int m7117readAvailableuM_xt_c(Buffer readAvailable, int[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(readAvailable, "$this$readAvailable");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return readAvailable(readAvailable, destination, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) throws InsufficientSpaceException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        writeFully(buffer, iArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFully-uM_xt_c$default, reason: not valid java name */
    public static /* synthetic */ void m7134writeFullyuM_xt_c$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) throws InsufficientSpaceException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m7389getSizeimpl(iArr) - i;
        }
        m7133writeFullyuM_xt_c(buffer, iArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFully-uM_xt_c, reason: not valid java name */
    public static final void m7133writeFullyuM_xt_c(Buffer writeFully, int[] source, int i, int i2) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFully(writeFully, source, i, i2);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        readFully(buffer, jArr, i, i2);
    }

    /* JADX INFO: renamed from: readFully-eOostTs$default, reason: not valid java name */
    public static /* synthetic */ void m7122readFullyeOostTs$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m7468getSizeimpl(jArr) - i;
        }
        m7121readFullyeOostTs(buffer, jArr, i, i2);
    }

    /* JADX INFO: renamed from: readFully-eOostTs, reason: not valid java name */
    public static final void m7121readFullyeOostTs(Buffer readFully, long[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(destination, "destination");
        readFully(readFully, destination, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        return readAvailable(buffer, jArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, final long[] destination, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (!(i >= 0)) {
            new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$10
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("offset shouldn't be negative: ", Integer.valueOf(i)));
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
        if (i2 >= 0) {
            if (!(i + i2 <= destination.length)) {
                new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$12
                    @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                    public Void doFail() {
                        throw new IllegalArgumentException("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + destination.length);
                    }
                }.doFail();
                throw new KotlinNothingValueException();
            }
            if (buffer.getWritePosition() <= buffer.getReadPosition()) {
                return -1;
            }
            int iMin = Math.min(i2 / 8, buffer.getWritePosition() - buffer.getReadPosition());
            readFully(buffer, destination, i, iMin);
            return iMin;
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$11
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException(Intrinsics.stringPlus("length shouldn't be negative: ", Integer.valueOf(i2)));
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: readAvailable-eOostTs$default, reason: not valid java name */
    public static /* synthetic */ int m7114readAvailableeOostTs$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m7468getSizeimpl(jArr) - i;
        }
        return m7113readAvailableeOostTs(buffer, jArr, i, i2);
    }

    /* JADX INFO: renamed from: readAvailable-eOostTs, reason: not valid java name */
    public static final int m7113readAvailableeOostTs(Buffer readAvailable, long[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(readAvailable, "$this$readAvailable");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return readAvailable(readAvailable, destination, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        writeFully(buffer, jArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFully-eOostTs$default, reason: not valid java name */
    public static /* synthetic */ void m7130writeFullyeOostTs$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m7468getSizeimpl(jArr) - i;
        }
        m7129writeFullyeOostTs(buffer, jArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFully-eOostTs, reason: not valid java name */
    public static final void m7129writeFullyeOostTs(Buffer writeFully, long[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFully(writeFully, source, i, i2);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        readFully(buffer, fArr, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        return readAvailable(buffer, fArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, final float[] destination, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (!(i >= 0)) {
            new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$13
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("offset shouldn't be negative: ", Integer.valueOf(i)));
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
        if (i2 >= 0) {
            if (!(i + i2 <= destination.length)) {
                new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$15
                    @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                    public Void doFail() {
                        throw new IllegalArgumentException("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + destination.length);
                    }
                }.doFail();
                throw new KotlinNothingValueException();
            }
            if (buffer.getWritePosition() <= buffer.getReadPosition()) {
                return -1;
            }
            int iMin = Math.min(i2 / 4, buffer.getWritePosition() - buffer.getReadPosition());
            readFully(buffer, destination, i, iMin);
            return iMin;
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$14
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException(Intrinsics.stringPlus("length shouldn't be negative: ", Integer.valueOf(i2)));
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        writeFully(buffer, fArr, i, i2);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        readFully(buffer, dArr, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        return readAvailable(buffer, dArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, final double[] destination, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (!(i >= 0)) {
            new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$16
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("offset shouldn't be negative: ", Integer.valueOf(i)));
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
        if (i2 >= 0) {
            if (!(i + i2 <= destination.length)) {
                new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$18
                    @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                    public Void doFail() {
                        throw new IllegalArgumentException("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + destination.length);
                    }
                }.doFail();
                throw new KotlinNothingValueException();
            }
            if (buffer.getWritePosition() <= buffer.getReadPosition()) {
                return -1;
            }
            int iMin = Math.min(i2 / 8, buffer.getWritePosition() - buffer.getReadPosition());
            readFully(buffer, destination, i, iMin);
            return iMin;
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$readAvailable$$inlined$require$17
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException(Intrinsics.stringPlus("length shouldn't be negative: ", Integer.valueOf(i2)));
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        writeFully(buffer, dArr, i, i2);
    }

    public static final int readFully(Buffer buffer, Buffer dst, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (!(i >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(i <= dst.getLimit() - dst.getWritePosition())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i) {
            Memory.m6952copyTof5Ywojk(memory, dst.getMemory(), readPosition, i, dst.getWritePosition());
            dst.commitWritten(i);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i);
            return i;
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("buffer content", i).doFail();
        throw new KotlinNothingValueException();
    }

    @ExperimentalIoApi
    public static final void forEach(Buffer buffer, Function1<? super Byte, Unit> block) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        if (readPosition < writePosition) {
            int i = readPosition;
            while (true) {
                int i2 = i + 1;
                block.invoke(Byte.valueOf(memory.get(i)));
                if (i2 >= writePosition) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        buffer.discardExact(writePosition - readPosition);
    }

    public static final short readShort(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 2) {
            Short shValueOf = Short.valueOf(memory.getShort(readPosition));
            buffer.discardExact(2);
            return shValueOf.shortValue();
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("short integer", 2).doFail();
        throw new KotlinNothingValueException();
    }

    public static final short readUShort(Buffer buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 2) {
            UShort uShortM7508boximpl = UShort.m7508boximpl(UShort.m7514constructorimpl(memory.getShort(readPosition)));
            buffer.discardExact(2);
            return uShortM7508boximpl.getData();
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("short unsigned integer", 2).doFail();
        throw new KotlinNothingValueException();
    }

    public static final int readInt(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 4) {
            Integer numValueOf = Integer.valueOf(memory.getInt(readPosition));
            buffer.discardExact(4);
            return numValueOf.intValue();
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("regular integer", 4).doFail();
        throw new KotlinNothingValueException();
    }

    public static final int readUInt(Buffer buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 4) {
            UInt uIntM7322boximpl = UInt.m7322boximpl(UInt.m7328constructorimpl(memory.getInt(readPosition)));
            buffer.discardExact(4);
            return uIntM7322boximpl.getData();
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("regular unsigned integer", 4).doFail();
        throw new KotlinNothingValueException();
    }

    public static final long readLong(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 8) {
            Long lValueOf = Long.valueOf(memory.getLong(readPosition));
            buffer.discardExact(8);
            return lValueOf.longValue();
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("long integer", 8).doFail();
        throw new KotlinNothingValueException();
    }

    public static final long readULong(Buffer buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 8) {
            ULong uLongM7401boximpl = ULong.m7401boximpl(ULong.m7407constructorimpl(memory.getLong(readPosition)));
            buffer.discardExact(8);
            return uLongM7401boximpl.getData();
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("long unsigned integer", 8).doFail();
        throw new KotlinNothingValueException();
    }

    public static final float readFloat(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 4) {
            Float fValueOf = Float.valueOf(memory.getFloat(readPosition));
            buffer.discardExact(4);
            return fValueOf.floatValue();
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("floating point number", 4).doFail();
        throw new KotlinNothingValueException();
    }

    public static final double readDouble(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 8) {
            Double dValueOf = Double.valueOf(memory.getDouble(readPosition));
            buffer.discardExact(8);
            return dValueOf.doubleValue();
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("long floating point number", 8).doFail();
        throw new KotlinNothingValueException();
    }

    public static final void writeShort(Buffer buffer, short s) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit < 2) {
            throw new InsufficientSpaceException("short integer", 2, limit);
        }
        memory.putShort(writePosition, s);
        buffer.commitWritten(2);
    }

    /* JADX INFO: renamed from: writeUShort-YTqlC3I, reason: not valid java name */
    public static final void m7141writeUShortYTqlC3I(Buffer writeUShort, short s) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeUShort, "$this$writeUShort");
        ByteBuffer memory = writeUShort.getMemory();
        int writePosition = writeUShort.getWritePosition();
        int limit = writeUShort.getLimit() - writePosition;
        if (limit < 2) {
            throw new InsufficientSpaceException("short unsigned integer", 2, limit);
        }
        memory.putShort(writePosition, s);
        writeUShort.commitWritten(2);
    }

    public static final void writeInt(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit < 4) {
            throw new InsufficientSpaceException("regular integer", 4, limit);
        }
        memory.putInt(writePosition, i);
        buffer.commitWritten(4);
    }

    /* JADX INFO: renamed from: writeUInt-_mVlKAM, reason: not valid java name */
    public static final void m7138writeUInt_mVlKAM(Buffer writeUInt, int i) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeUInt, "$this$writeUInt");
        ByteBuffer memory = writeUInt.getMemory();
        int writePosition = writeUInt.getWritePosition();
        int limit = writeUInt.getLimit() - writePosition;
        if (limit < 4) {
            throw new InsufficientSpaceException("regular unsigned integer", 4, limit);
        }
        memory.putInt(writePosition, i);
        writeUInt.commitWritten(4);
    }

    public static final void writeLong(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit < 8) {
            throw new InsufficientSpaceException("long integer", 8, limit);
        }
        memory.putLong(writePosition, j);
        buffer.commitWritten(8);
    }

    /* JADX INFO: renamed from: writeULong-Zrk_yTk, reason: not valid java name */
    public static final void m7139writeULongZrk_yTk(Buffer writeULong, long j) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeULong, "$this$writeULong");
        ByteBuffer memory = writeULong.getMemory();
        int writePosition = writeULong.getWritePosition();
        int limit = writeULong.getLimit() - writePosition;
        if (limit < 8) {
            throw new InsufficientSpaceException("long unsigned integer", 8, limit);
        }
        memory.putLong(writePosition, j);
        writeULong.commitWritten(8);
    }

    public static final void writeFloat(Buffer buffer, float f) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit < 4) {
            throw new InsufficientSpaceException("floating point number", 4, limit);
        }
        memory.putFloat(writePosition, f);
        buffer.commitWritten(4);
    }

    public static final void writeDouble(Buffer buffer, double d) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit < 8) {
            throw new InsufficientSpaceException("long floating point number", 8, limit);
        }
        memory.putDouble(writePosition, d);
        buffer.commitWritten(8);
    }

    public static final void readFully(Buffer buffer, byte[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (!(buffer.getWritePosition() - readPosition >= i2)) {
            new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("byte array", i2).doFail();
            throw new KotlinNothingValueException();
        }
        MemoryJvmKt.m6968copyToFs5fovk(memory, destination, readPosition, i2, i);
        Unit unit = Unit.INSTANCE;
        buffer.discardExact(i2);
    }

    public static final void writeFully(Buffer buffer, byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit < i2) {
            throw new InsufficientSpaceException("byte array", i2, limit);
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(source, i, i2).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m6952copyTof5Ywojk(Memory.m6951constructorimpl(byteBufferOrder), memory, 0, i2, writePosition);
        buffer.commitWritten(i2);
    }

    public static final void readFully(Buffer buffer, short[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int i3 = i2 * 2;
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i3) {
            PrimitiveArraysJvmKt.m7071loadShortArray96Q0Wk8(memory, readPosition, destination, i, i2);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i3);
            return;
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("short integers array", i3).doFail();
        throw new KotlinNothingValueException();
    }

    public static final void writeFully(Buffer buffer, short[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 * 2;
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i3) {
            PrimitiveArraysJvmKt.m7091storeShortArray96Q0Wk8(memory, writePosition, source, i, i2);
            buffer.commitWritten(i3);
            return;
        }
        throw new InsufficientSpaceException("short integers array", i3, limit);
    }

    public static final void readFully(Buffer buffer, int[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int i3 = i2 * 4;
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i3) {
            PrimitiveArraysJvmKt.m7063loadIntArrayfL2E08M(memory, readPosition, destination, i, i2);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i3);
            return;
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("integers array", i3).doFail();
        throw new KotlinNothingValueException();
    }

    public static final void writeFully(Buffer buffer, int[] source, int i, int i2) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 * 4;
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i3) {
            PrimitiveArraysJvmKt.m7083storeIntArrayfL2E08M(memory, writePosition, source, i, i2);
            buffer.commitWritten(i3);
            return;
        }
        throw new InsufficientSpaceException("integers array", i3, limit);
    }

    public static final void readFully(Buffer buffer, long[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int i3 = i2 * 8;
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i3) {
            PrimitiveArraysJvmKt.m7069loadLongArrayv7_xXSA(memory, readPosition, destination, i, i2);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i3);
            return;
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("long integers array", i3).doFail();
        throw new KotlinNothingValueException();
    }

    public static final void writeFully(Buffer buffer, long[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 * 8;
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i3) {
            PrimitiveArraysJvmKt.m7089storeLongArrayv7_xXSA(memory, writePosition, source, i, i2);
            buffer.commitWritten(i3);
            return;
        }
        throw new InsufficientSpaceException("long integers array", i3, limit);
    }

    public static final void readFully(Buffer buffer, float[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int i3 = i2 * 4;
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i3) {
            PrimitiveArraysJvmKt.m7059loadFloatArray4iahAcY(memory, readPosition, destination, i, i2);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i3);
            return;
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("floating point numbers array", i3).doFail();
        throw new KotlinNothingValueException();
    }

    public static final void writeFully(Buffer buffer, float[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 * 4;
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i3) {
            PrimitiveArraysJvmKt.m7079storeFloatArray4iahAcY(memory, writePosition, source, i, i2);
            buffer.commitWritten(i3);
            return;
        }
        throw new InsufficientSpaceException("floating point numbers array", i3, limit);
    }

    public static final void readFully(Buffer buffer, double[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int i3 = i2 * 8;
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i3) {
            PrimitiveArraysJvmKt.m7055loadDoubleArrayKUjKYZc(memory, readPosition, destination, i, i2);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i3);
            return;
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("floating point numbers array", i3).doFail();
        throw new KotlinNothingValueException();
    }

    public static final void writeFully(Buffer buffer, double[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 * 8;
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i3) {
            PrimitiveArraysJvmKt.m7075storeDoubleArrayKUjKYZc(memory, writePosition, source, i, i2);
            buffer.commitWritten(i3);
            return;
        }
        throw new InsufficientSpaceException("floating point numbers array", i3, limit);
    }

    public static /* synthetic */ int readFully$default(Buffer buffer, Buffer buffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = buffer2.getLimit() - buffer2.getWritePosition();
        }
        return readFully(buffer, buffer2, i);
    }

    public static final int readAvailable(Buffer buffer, Buffer dst, int i) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (buffer.getWritePosition() <= buffer.getReadPosition()) {
            return -1;
        }
        int iMin = Math.min(dst.getLimit() - dst.getWritePosition(), Math.min(buffer.getWritePosition() - buffer.getReadPosition(), i));
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= iMin) {
            Memory.m6952copyTof5Ywojk(memory, dst.getMemory(), readPosition, iMin, dst.getWritePosition());
            dst.commitWritten(iMin);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(iMin);
            return iMin;
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("buffer content", iMin).doFail();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, Buffer buffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = buffer2.getLimit() - buffer2.getWritePosition();
        }
        return readAvailable(buffer, buffer2, i);
    }

    public static final void writeFully(Buffer buffer, Buffer src) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        int writePosition = src.getWritePosition() - src.getReadPosition();
        ByteBuffer memory = buffer.getMemory();
        int writePosition2 = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition2;
        if (limit >= writePosition) {
            Memory.m6952copyTof5Ywojk(src.getMemory(), memory, src.getReadPosition(), writePosition, writePosition2);
            src.discardExact(writePosition);
            buffer.commitWritten(writePosition);
            return;
        }
        throw new InsufficientSpaceException("buffer readable content", writePosition, limit);
    }

    public static final void writeFully(final Buffer buffer, final Buffer src, final int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        if (!(i >= 0)) {
            new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$writeFully$$inlined$require$1
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("length shouldn't be negative: ", Integer.valueOf(i)));
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
        if (!(i <= src.getWritePosition() - src.getReadPosition())) {
            new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$writeFully$$inlined$require$2
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    StringBuilder sbAppend = new StringBuilder("length shouldn't be greater than the source read remaining: ").append(i).append(" > ");
                    Buffer buffer2 = src;
                    throw new IllegalArgumentException(sbAppend.append(buffer2.getWritePosition() - buffer2.getReadPosition()).toString());
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
        if (!(i <= buffer.getLimit() - buffer.getWritePosition())) {
            new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferPrimitivesKt$writeFully$$inlined$require$3
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    StringBuilder sbAppend = new StringBuilder("length shouldn't be greater than the destination write remaining space: ").append(i).append(" > ");
                    Buffer buffer2 = buffer;
                    throw new IllegalArgumentException(sbAppend.append(buffer2.getLimit() - buffer2.getWritePosition()).toString());
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i) {
            Memory.m6952copyTof5Ywojk(src.getMemory(), memory, src.getReadPosition(), i, writePosition);
            src.discardExact(i);
            buffer.commitWritten(i);
            return;
        }
        throw new InsufficientSpaceException("buffer readable content", i, limit);
    }

    public static final <R> R readExact(Buffer buffer, int i, String name, Function2<? super Memory, ? super Integer, ? extends R> block) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i) {
            R rInvoke = block.invoke(Memory.m6950boximpl(memory), Integer.valueOf(readPosition));
            buffer.discardExact(i);
            return rInvoke;
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1(name, i).doFail();
        throw new KotlinNothingValueException();
    }

    public static final void writeExact(Buffer buffer, int i, String name, Function2<? super Memory, ? super Integer, Unit> block) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit < i) {
            throw new InsufficientSpaceException(name, i, limit);
        }
        block.invoke(Memory.m6950boximpl(memory), Integer.valueOf(writePosition));
        buffer.commitWritten(i);
    }
}
