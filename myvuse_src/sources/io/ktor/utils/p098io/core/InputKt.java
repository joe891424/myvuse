package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import io.ktor.utils.p098io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: Input.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000`\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001\u001a$\u0010\u0007\u001a\u00020\u0004*\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH\u0087\bø\u0001\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0007\u001a\u0014\u0010\r\u001a\u00020\f*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0002\u001a\u001e\u0010\u000f\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007\u001a-\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u000f\u001a-\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00172\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u000f\u001a-\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00182\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u000f\u001a-\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00192\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u000f\u001a-\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u001a2\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u000f\u001a-\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u001b2\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u000f\u001a\u001e\u0010\u001c\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007\u001a-\u0010\u001d\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001c\u001a-\u0010\u001d\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00172\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001c\u001a-\u0010\u001d\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00182\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001c\u001a-\u0010\u001d\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00192\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001c\u001a-\u0010\u001d\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u001a2\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001c\u001a-\u0010\u001d\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u001b2\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001c\u001a$\u0010\u001e\u001a\u00020\u0004*\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\tH\u0087\bø\u0001\u0000\u001a.\u0010!\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00060\tH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, m5598d2 = {"discard", "", "Lio/ktor/utils/io/core/Input;", "discardExact", "", RsaJsonWebKey.MODULUS_MEMBER_NAME, "", "forEach", "block", "Lkotlin/Function1;", "", "peekCharUtf8", "", "peekCharUtf8Impl", "first", "readAvailable", C4352k.a.f5652f, "Lio/ktor/utils/io/core/IoBuffer;", "size", "readAvailableOld", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "", "", "", "", "", "readFully", "readFullyOld", "takeWhile", "Lio/ktor/utils/io/core/Buffer;", "", "takeWhileSize", "initialSize", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class InputKt {
    public static final long discard(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return input.discard(Long.MAX_VALUE);
    }

    public static final void discardExact(Input input, long j) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        long jDiscard = input.discard(j);
        if (jDiscard != j) {
            throw new IllegalStateException("Only " + jDiscard + " bytes were discarded of " + j + " requested");
        }
    }

    public static final void discardExact(Input input, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        discardExact(input, i);
    }

    @DangerousInternalIoApi
    public static final void takeWhile(Input input, Function1<? super Buffer, Boolean> block) throws Throwable {
        boolean z;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead == null) {
            return;
        }
        while (true) {
            try {
                if (!block.invoke(chunkBufferM7223prepareReadFirstHead).booleanValue()) {
                    z = true;
                    break;
                }
                z = false;
                try {
                    ChunkBuffer chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                    if (chunkBufferPrepareReadNextHead == null) {
                        break;
                    } else {
                        chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    }
                } catch (Throwable th) {
                    th = th;
                    InlineMarker.finallyStart(1);
                    if (z) {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                    }
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
        }
        InlineMarker.finallyStart(1);
        if (z) {
            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
        }
        InlineMarker.finallyEnd(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void takeWhileSize$default(io.ktor.utils.p098io.core.Input r3, int r4, kotlin.jvm.functions.Function1 r5, int r6, java.lang.Object r7) throws java.lang.Throwable {
        /*
            r7 = 1
            r6 = r6 & r7
            if (r6 == 0) goto L5
            r4 = r7
        L5:
            java.lang.String r6 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r6)
            java.lang.String r6 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = io.ktor.utils.p098io.core.internal.UnsafeKt.m7223prepareReadFirstHead(r3, r4)
            if (r6 != 0) goto L16
            return
        L16:
            r0 = r6
            io.ktor.utils.io.core.Buffer r0 = (io.ktor.utils.p098io.core.Buffer) r0     // Catch: java.lang.Throwable -> L8d
            int r1 = r0.getWritePosition()     // Catch: java.lang.Throwable -> L8d
            int r0 = r0.getReadPosition()     // Catch: java.lang.Throwable -> L8d
            int r1 = r1 - r0
            if (r1 < r4) goto L52
            java.lang.Object r4 = r5.invoke(r6)     // Catch: java.lang.Throwable -> L41
            java.lang.Number r4 = (java.lang.Number) r4     // Catch: java.lang.Throwable -> L41
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L41
            kotlin.jvm.internal.InlineMarker.finallyStart(r7)     // Catch: java.lang.Throwable -> L8d
            r0 = r6
            io.ktor.utils.io.core.Buffer r0 = (io.ktor.utils.p098io.core.Buffer) r0     // Catch: java.lang.Throwable -> L8d
            int r1 = r0.getWritePosition()     // Catch: java.lang.Throwable -> L8d
            int r0 = r0.getReadPosition()     // Catch: java.lang.Throwable -> L8d
            int r1 = r1 - r0
            kotlin.jvm.internal.InlineMarker.finallyEnd(r7)     // Catch: java.lang.Throwable -> L8d
            goto L52
        L41:
            r4 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r7)     // Catch: java.lang.Throwable -> L8d
            r5 = r6
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.p098io.core.Buffer) r5     // Catch: java.lang.Throwable -> L8d
            r5.getWritePosition()     // Catch: java.lang.Throwable -> L8d
            r5.getReadPosition()     // Catch: java.lang.Throwable -> L8d
            kotlin.jvm.internal.InlineMarker.finallyEnd(r7)     // Catch: java.lang.Throwable -> L8d
            throw r4     // Catch: java.lang.Throwable -> L8d
        L52:
            r0 = 0
            if (r1 != 0) goto L5c
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.p098io.core.internal.UnsafeKt.prepareReadNextHead(r3, r6)     // Catch: java.lang.Throwable -> L5a
            goto L78
        L5a:
            r4 = move-exception
            goto L8f
        L5c:
            if (r1 < r4) goto L71
            r1 = r6
            io.ktor.utils.io.core.Buffer r1 = (io.ktor.utils.p098io.core.Buffer) r1     // Catch: java.lang.Throwable -> L5a
            int r2 = r1.getCapacity()     // Catch: java.lang.Throwable -> L5a
            int r1 = r1.getLimit()     // Catch: java.lang.Throwable -> L5a
            int r2 = r2 - r1
            r1 = 8
            if (r2 >= r1) goto L6f
            goto L71
        L6f:
            r1 = r6
            goto L78
        L71:
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r3, r6)     // Catch: java.lang.Throwable -> L5a
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.p098io.core.internal.UnsafeKt.m7223prepareReadFirstHead(r3, r4)     // Catch: java.lang.Throwable -> L5a
        L78:
            if (r1 != 0) goto L7b
            goto L7f
        L7b:
            if (r4 > 0) goto L8b
            r0 = r7
            r6 = r1
        L7f:
            kotlin.jvm.internal.InlineMarker.finallyStart(r7)
            if (r0 == 0) goto L87
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r3, r6)
        L87:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r7)
            return
        L8b:
            r6 = r1
            goto L16
        L8d:
            r4 = move-exception
            r0 = r7
        L8f:
            kotlin.jvm.internal.InlineMarker.finallyStart(r7)
            if (r0 == 0) goto L97
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r3, r6)
        L97:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r7)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.InputKt.takeWhileSize$default(io.ktor.utils.io.core.Input, int, kotlin.jvm.functions.Function1, int, java.lang.Object):void");
    }

    @DangerousInternalIoApi
    public static final void takeWhileSize(Input input, int i, Function1<? super Buffer, Integer> block) throws Throwable {
        boolean z;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, i);
        if (chunkBufferM7223prepareReadFirstHead == null) {
            return;
        }
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                if (writePosition >= i) {
                    try {
                        i = block.invoke(chunkBufferM7223prepareReadFirstHead).intValue();
                        InlineMarker.finallyStart(1);
                        ChunkBuffer chunkBuffer2 = chunkBufferM7223prepareReadFirstHead;
                        writePosition = chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition();
                        InlineMarker.finallyEnd(1);
                    } finally {
                    }
                }
                z = false;
                if (writePosition == 0) {
                    try {
                        chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                    } catch (Throwable th) {
                        th = th;
                        InlineMarker.finallyStart(1);
                        if (z) {
                            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        }
                        InlineMarker.finallyEnd(1);
                        throw th;
                    }
                } else if (writePosition >= i) {
                    ChunkBuffer chunkBuffer3 = chunkBufferM7223prepareReadFirstHead;
                    if (chunkBuffer3.getCapacity() - chunkBuffer3.getLimit() < 8) {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i);
                    } else {
                        chunkBufferPrepareReadNextHead = chunkBufferM7223prepareReadFirstHead;
                    }
                } else {
                    UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                    chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i);
                }
                if (chunkBufferPrepareReadNextHead == null) {
                    break;
                }
                if (i <= 0) {
                    z = true;
                    chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    break;
                }
                chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
        }
        InlineMarker.finallyStart(1);
        if (z) {
            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
        }
        InlineMarker.finallyEnd(1);
    }

    @ExperimentalIoApi
    public static final char peekCharUtf8(Input input) throws EOFException {
        Intrinsics.checkNotNullParameter(input, "<this>");
        int iTryPeek = input.tryPeek();
        if ((iTryPeek & 128) == 0) {
            return (char) iTryPeek;
        }
        if (iTryPeek == -1) {
            throw new EOFException("Failed to peek a char: end of input");
        }
        return peekCharUtf8Impl(input, iTryPeek);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
    
        if (r11 != 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
    
        r3 = (char) r4;
        r0.discardExact(r10 - r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        io.ktor.utils.p098io.core.internal.UTF8Kt.malformedByteCount(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0091, code lost:
    
        if (io.ktor.utils.p098io.core.internal.UTF8Kt.isBmpCodePoint(r4) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0093, code lost:
    
        r3 = (char) r4;
        r0.discardExact(((r10 - r8) - r13) + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a0, code lost:
    
        if (io.ktor.utils.p098io.core.internal.UTF8Kt.isValidCodePoint(r4) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a6, code lost:
    
        r3 = (char) io.ktor.utils.p098io.core.internal.UTF8Kt.highSurrogate(r4);
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ab, code lost:
    
        r0.discardExact(((r10 - r8) - r13) + 1);
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b0, code lost:
    
        r6 = true;
        io.ktor.utils.p098io.core.internal.UTF8Kt.malformedCodePoint(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b9, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Removed duplicated region for block: B:88:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final char peekCharUtf8Impl(io.ktor.utils.p098io.core.Input r18, int r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.InputKt.peekCharUtf8Impl(io.ktor.utils.io.core.Input, int):char");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int readAvailable(Input input, IoBuffer dst, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        return InputArraysKt.readAvailable(input, dst, i);
    }

    public static /* synthetic */ int readAvailable$default(Input input, IoBuffer ioBuffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            IoBuffer ioBuffer2 = ioBuffer;
            i = ioBuffer2.getLimit() - ioBuffer2.getWritePosition();
        }
        return readAvailable(input, ioBuffer, i);
    }

    public static /* synthetic */ int readAvailable$default(Input input, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        return readAvailable(input, bArr, i, i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int readAvailable(Input input, byte[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        return InputArraysKt.readAvailable(input, dst, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Input input, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        return readAvailable(input, sArr, i, i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int readAvailable(Input input, short[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        return InputArraysKt.readAvailable(input, dst, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Input input, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        return readAvailable(input, iArr, i, i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int readAvailable(Input input, int[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        return InputArraysKt.readAvailable(input, dst, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Input input, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        return readAvailable(input, jArr, i, i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int readAvailable(Input input, long[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        return InputArraysKt.readAvailable(input, dst, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Input input, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        return readAvailable(input, fArr, i, i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int readAvailable(Input input, float[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        return InputArraysKt.readAvailable(input, dst, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Input input, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        return readAvailable(input, dArr, i, i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int readAvailable(Input input, double[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        return InputArraysKt.readAvailable(input, dst, i, i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void readFully(Input input, IoBuffer dst, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(input, dst, i);
    }

    public static /* synthetic */ void readFully$default(Input input, IoBuffer ioBuffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            IoBuffer ioBuffer2 = ioBuffer;
            i = ioBuffer2.getLimit() - ioBuffer2.getWritePosition();
        }
        readFully(input, ioBuffer, i);
    }

    public static /* synthetic */ void readFully$default(Input input, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        readFully(input, bArr, i, i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void readFully(Input input, byte[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(input, dst, i, i2);
    }

    public static /* synthetic */ void readFully$default(Input input, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        readFully(input, sArr, i, i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void readFully(Input input, short[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(input, dst, i, i2);
    }

    public static /* synthetic */ void readFully$default(Input input, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        readFully(input, iArr, i, i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void readFully(Input input, int[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(input, dst, i, i2);
    }

    public static /* synthetic */ void readFully$default(Input input, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        readFully(input, jArr, i, i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void readFully(Input input, long[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(input, dst, i, i2);
    }

    public static /* synthetic */ void readFully$default(Input input, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        readFully(input, fArr, i, i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void readFully(Input input, float[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(input, dst, i, i2);
    }

    public static /* synthetic */ void readFully$default(Input input, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        readFully(input, dArr, i, i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void readFully(Input input, double[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(input, dst, i, i2);
    }

    @ExperimentalIoApi
    public static final void forEach(Input input, Function1<? super Byte, Unit> block) throws Throwable {
        boolean z;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead == null) {
            return;
        }
        do {
            try {
                ChunkBuffer chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                ByteBuffer memory = chunkBuffer.getMemory();
                int readPosition = chunkBuffer.getReadPosition();
                int writePosition = chunkBuffer.getWritePosition();
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
                chunkBuffer.discardExact(writePosition - readPosition);
                try {
                    chunkBufferM7223prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                } catch (Throwable th) {
                    th = th;
                    z = false;
                    InlineMarker.finallyStart(1);
                    if (z) {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                    }
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
        } while (chunkBufferM7223prepareReadFirstHead != null);
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
    }
}
