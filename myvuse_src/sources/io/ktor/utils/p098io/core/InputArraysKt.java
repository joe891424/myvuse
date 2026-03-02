package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.brentvatne.react.ReactVideoViewManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: compiled from: InputArrays.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000X\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a,\u0010\u0000\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00102\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00112\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00132\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a,\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a,\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\f\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00102\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00112\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00132\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001aj\u0010\u001b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012K\u0010\u001d\u001aG\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00160\u001eH\u0082\b\u001a\u0082\u0001\u0010\u001b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2`\u0010\u001d\u001a\\\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00160$H\u0082\bø\u0001\u0000\u001ar\u0010&\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00012K\u0010\u001d\u001aG\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00160\u001eH\u0082\b\u001a\r\u0010(\u001a\u00020\u0016*\u00020\u0001H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, m5598d2 = {"readAvailable", "", "Lio/ktor/utils/io/core/Input;", FirebaseAnalytics.Param.DESTINATION, "Lio/ktor/utils/io/bits/Memory;", "destinationOffset", "length", "readAvailable-9JA4kaw", "(Lio/ktor/utils/io/core/Input;Ljava/nio/ByteBuffer;II)I", "", "readAvailable-mCvI5oI", "(Lio/ktor/utils/io/core/Input;Ljava/nio/ByteBuffer;JJ)J", C4352k.a.f5652f, "Lio/ktor/utils/io/core/Buffer;", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "", "", "", "", "readFully", "", "readFully-9JA4kaw", "(Lio/ktor/utils/io/core/Input;Ljava/nio/ByteBuffer;II)V", "readFully-mCvI5oI", "(Lio/ktor/utils/io/core/Input;Ljava/nio/ByteBuffer;JJ)V", "readFullyBytesTemplate", "initialDstOffset", "readBlock", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", ReactVideoViewManager.PROP_SRC, "dstOffset", NewHtcHomeBadger.COUNT, "Lkotlin/Function4;", "srcOffset", "readFullyTemplate", "componentSize", "requireNoRemaining", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class InputArraysKt {
    public static /* synthetic */ void readFully$default(Input input, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        readFully(input, bArr, i, i2);
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

    public static /* synthetic */ void readFully$default(Input input, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        readFully(input, iArr, i, i2);
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

    public static /* synthetic */ void readFully$default(Input input, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        readFully(input, fArr, i, i2);
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

    /* JADX INFO: renamed from: readFully-9JA4kaw, reason: not valid java name */
    public static final void m7147readFully9JA4kaw(Input readFully, ByteBuffer destination, int i, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(destination, "destination");
        m7148readFullymCvI5oI(readFully, destination, i, i2);
    }

    /* JADX INFO: renamed from: readFully-mCvI5oI, reason: not valid java name */
    public static final void m7148readFullymCvI5oI(Input readFully, ByteBuffer destination, long j, long j2) throws EOFException {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (m7146readAvailablemCvI5oI(readFully, destination, j, j2) == j2) {
            return;
        }
        StringsKt.prematureEndOfStream(j2);
        throw new KotlinNothingValueException();
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

    public static /* synthetic */ int readAvailable$default(Input input, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        return readAvailable(input, sArr, i, i2);
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

    public static /* synthetic */ int readAvailable$default(Input input, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        return readAvailable(input, jArr, i, i2);
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

    public static /* synthetic */ int readAvailable$default(Input input, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        return readAvailable(input, dArr, i, i2);
    }

    /* JADX INFO: renamed from: readAvailable-9JA4kaw, reason: not valid java name */
    public static final int m7145readAvailable9JA4kaw(Input readAvailable, ByteBuffer destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(readAvailable, "$this$readAvailable");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return (int) m7146readAvailablemCvI5oI(readAvailable, destination, i, i2);
    }

    private static final void requireNoRemaining(int i) throws EOFException {
        if (i <= 0) {
            return;
        }
        StringsKt.prematureEndOfStream(i);
        throw new KotlinNothingValueException();
    }

    public static final void readFully(Input input, byte[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead != null) {
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                    int iMin = Math.min(i2, chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
                    BufferPrimitivesKt.readFully((Buffer) chunkBuffer, dst, i, iMin);
                    i2 -= iMin;
                    i += iMin;
                    if (i2 > 0) {
                        try {
                            chunkBufferM7223prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                            if (chunkBufferM7223prepareReadFirstHead == null) {
                                break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        if (i2 <= 0) {
            return;
        }
        StringsKt.prematureEndOfStream(i2);
        throw new KotlinNothingValueException();
    }

    public static final void readFully(Input input, short[] dst, int i, int i2) {
        ChunkBuffer chunkBuffer;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead != null) {
            int i3 = 1;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i3) {
                        try {
                            ChunkBuffer chunkBuffer2 = chunkBufferM7223prepareReadFirstHead;
                            int iMin = Math.min(i2, (chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition()) / 2);
                            BufferPrimitivesKt.readFully((Buffer) chunkBuffer2, dst, i, iMin);
                            i2 -= iMin;
                            i += iMin;
                            i3 = i2 > 0 ? 2 : 0;
                            ChunkBuffer chunkBuffer3 = chunkBufferM7223prepareReadFirstHead;
                            writePosition = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                        } finally {
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else if (writePosition >= i3) {
                        ChunkBuffer chunkBuffer4 = chunkBufferM7223prepareReadFirstHead;
                        if (chunkBuffer4.getCapacity() - chunkBuffer4.getLimit() < 8) {
                            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i3);
                        } else {
                            chunkBufferPrepareReadNextHead = chunkBufferM7223prepareReadFirstHead;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i3);
                    }
                    if (chunkBufferPrepareReadNextHead == null) {
                        z = false;
                        break;
                    } else {
                        chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
                        if (i3 <= 0) {
                            break;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z) {
                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
            }
        }
        if (i2 <= 0) {
            return;
        }
        StringsKt.prematureEndOfStream(i2);
        throw new KotlinNothingValueException();
    }

    public static final void readFully(Input input, int[] dst, int i, int i2) {
        ChunkBuffer chunkBuffer;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead != null) {
            int i3 = 1;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i3) {
                        try {
                            ChunkBuffer chunkBuffer2 = chunkBufferM7223prepareReadFirstHead;
                            int iMin = Math.min(i2, (chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition()) / 4);
                            BufferPrimitivesKt.readFully((Buffer) chunkBuffer2, dst, i, iMin);
                            i2 -= iMin;
                            i += iMin;
                            i3 = i2 > 0 ? 4 : 0;
                            ChunkBuffer chunkBuffer3 = chunkBufferM7223prepareReadFirstHead;
                            writePosition = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                        } finally {
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else if (writePosition >= i3) {
                        ChunkBuffer chunkBuffer4 = chunkBufferM7223prepareReadFirstHead;
                        if (chunkBuffer4.getCapacity() - chunkBuffer4.getLimit() < 8) {
                            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i3);
                        } else {
                            chunkBufferPrepareReadNextHead = chunkBufferM7223prepareReadFirstHead;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i3);
                    }
                    if (chunkBufferPrepareReadNextHead == null) {
                        z = false;
                        break;
                    } else {
                        chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
                        if (i3 <= 0) {
                            break;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z) {
                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
            }
        }
        if (i2 <= 0) {
            return;
        }
        StringsKt.prematureEndOfStream(i2);
        throw new KotlinNothingValueException();
    }

    public static final void readFully(Input input, long[] dst, int i, int i2) {
        ChunkBuffer chunkBuffer;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead != null) {
            int i3 = 1;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i3) {
                        try {
                            ChunkBuffer chunkBuffer2 = chunkBufferM7223prepareReadFirstHead;
                            int iMin = Math.min(i2, (chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition()) / 8);
                            BufferPrimitivesKt.readFully((Buffer) chunkBuffer2, dst, i, iMin);
                            i2 -= iMin;
                            i += iMin;
                            i3 = i2 > 0 ? 8 : 0;
                            ChunkBuffer chunkBuffer3 = chunkBufferM7223prepareReadFirstHead;
                            writePosition = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                        } finally {
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else if (writePosition >= i3) {
                        ChunkBuffer chunkBuffer4 = chunkBufferM7223prepareReadFirstHead;
                        if (chunkBuffer4.getCapacity() - chunkBuffer4.getLimit() < 8) {
                            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i3);
                        } else {
                            chunkBufferPrepareReadNextHead = chunkBufferM7223prepareReadFirstHead;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i3);
                    }
                    if (chunkBufferPrepareReadNextHead == null) {
                        z = false;
                        break;
                    } else {
                        chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
                        if (i3 <= 0) {
                            break;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z) {
                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
            }
        }
        if (i2 <= 0) {
            return;
        }
        StringsKt.prematureEndOfStream(i2);
        throw new KotlinNothingValueException();
    }

    public static final void readFully(Input input, float[] dst, int i, int i2) {
        ChunkBuffer chunkBuffer;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead != null) {
            int i3 = 1;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i3) {
                        try {
                            ChunkBuffer chunkBuffer2 = chunkBufferM7223prepareReadFirstHead;
                            int iMin = Math.min(i2, (chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition()) / 4);
                            BufferPrimitivesKt.readFully((Buffer) chunkBuffer2, dst, i, iMin);
                            i2 -= iMin;
                            i += iMin;
                            i3 = i2 > 0 ? 4 : 0;
                            ChunkBuffer chunkBuffer3 = chunkBufferM7223prepareReadFirstHead;
                            writePosition = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                        } finally {
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else if (writePosition >= i3) {
                        ChunkBuffer chunkBuffer4 = chunkBufferM7223prepareReadFirstHead;
                        if (chunkBuffer4.getCapacity() - chunkBuffer4.getLimit() < 8) {
                            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i3);
                        } else {
                            chunkBufferPrepareReadNextHead = chunkBufferM7223prepareReadFirstHead;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i3);
                    }
                    if (chunkBufferPrepareReadNextHead == null) {
                        z = false;
                        break;
                    } else {
                        chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
                        if (i3 <= 0) {
                            break;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z) {
                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
            }
        }
        if (i2 <= 0) {
            return;
        }
        StringsKt.prematureEndOfStream(i2);
        throw new KotlinNothingValueException();
    }

    public static final void readFully(Input input, double[] dst, int i, int i2) {
        ChunkBuffer chunkBuffer;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead != null) {
            int i3 = 1;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i3) {
                        try {
                            ChunkBuffer chunkBuffer2 = chunkBufferM7223prepareReadFirstHead;
                            int iMin = Math.min(i2, (chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition()) / 8);
                            BufferPrimitivesKt.readFully(chunkBuffer2, dst, i, iMin);
                            i2 -= iMin;
                            i += iMin;
                            i3 = i2 > 0 ? 8 : 0;
                            ChunkBuffer chunkBuffer3 = chunkBufferM7223prepareReadFirstHead;
                            writePosition = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                        } finally {
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else if (writePosition >= i3) {
                        ChunkBuffer chunkBuffer4 = chunkBufferM7223prepareReadFirstHead;
                        if (chunkBuffer4.getCapacity() - chunkBuffer4.getLimit() < 8) {
                            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i3);
                        } else {
                            chunkBufferPrepareReadNextHead = chunkBufferM7223prepareReadFirstHead;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i3);
                    }
                    if (chunkBufferPrepareReadNextHead == null) {
                        z = false;
                        break;
                    } else {
                        chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
                        if (i3 <= 0) {
                            break;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z) {
                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
            }
        }
        if (i2 <= 0) {
            return;
        }
        StringsKt.prematureEndOfStream(i2);
        throw new KotlinNothingValueException();
    }

    public static final void readFully(Input input, Buffer dst, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead != null) {
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                    int iMin = Math.min(i, chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
                    BufferPrimitivesKt.readFully(chunkBuffer, dst, iMin);
                    i -= iMin;
                    if (i > 0) {
                        try {
                            chunkBufferM7223prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                            if (chunkBufferM7223prepareReadFirstHead == null) {
                                break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        if (i <= 0) {
            return;
        }
        StringsKt.prematureEndOfStream(i);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void readFully$default(Input input, Buffer buffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = buffer.getLimit() - buffer.getWritePosition();
        }
        readFully(input, buffer, i);
    }

    public static final int readAvailable(Input input, byte[] dst, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead == null) {
            i3 = i2;
        } else {
            i3 = i2;
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                    int iMin = Math.min(i3, chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
                    BufferPrimitivesKt.readFully((Buffer) chunkBuffer, dst, i, iMin);
                    i3 -= iMin;
                    i += iMin;
                    if (i3 > 0) {
                        try {
                            chunkBufferM7223prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                            if (chunkBufferM7223prepareReadFirstHead == null) {
                                break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return i2 - i3;
    }

    public static final int readAvailable(Input input, short[] dst, int i, int i2) throws Throwable {
        int i3;
        ChunkBuffer chunkBuffer;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead == null) {
            i3 = i2;
        } else {
            i3 = i2;
            int i4 = 1;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i4) {
                        try {
                            ChunkBuffer chunkBuffer2 = chunkBufferM7223prepareReadFirstHead;
                            int iMin = Math.min(i3, (chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition()) / 2);
                            BufferPrimitivesKt.readFully((Buffer) chunkBuffer2, dst, i, iMin);
                            i3 -= iMin;
                            i += iMin;
                            i4 = i3 > 0 ? 2 : 0;
                            ChunkBuffer chunkBuffer3 = chunkBufferM7223prepareReadFirstHead;
                            writePosition = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                        } finally {
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else if (writePosition >= i4) {
                        ChunkBuffer chunkBuffer4 = chunkBufferM7223prepareReadFirstHead;
                        if (chunkBuffer4.getCapacity() - chunkBuffer4.getLimit() < 8) {
                            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i4);
                        } else {
                            chunkBufferPrepareReadNextHead = chunkBufferM7223prepareReadFirstHead;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i4);
                    }
                    if (chunkBufferPrepareReadNextHead == null) {
                        z = false;
                        break;
                    }
                    chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    if (i4 <= 0) {
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z) {
                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
            }
        }
        return i2 - i3;
    }

    public static final int readAvailable(Input input, int[] dst, int i, int i2) throws Throwable {
        int i3;
        ChunkBuffer chunkBuffer;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead == null) {
            i3 = i2;
        } else {
            i3 = i2;
            int i4 = 1;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i4) {
                        try {
                            ChunkBuffer chunkBuffer2 = chunkBufferM7223prepareReadFirstHead;
                            int iMin = Math.min(i3, (chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition()) / 4);
                            BufferPrimitivesKt.readFully((Buffer) chunkBuffer2, dst, i, iMin);
                            i3 -= iMin;
                            i += iMin;
                            i4 = i3 > 0 ? 4 : 0;
                            ChunkBuffer chunkBuffer3 = chunkBufferM7223prepareReadFirstHead;
                            writePosition = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                        } finally {
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else if (writePosition >= i4) {
                        ChunkBuffer chunkBuffer4 = chunkBufferM7223prepareReadFirstHead;
                        if (chunkBuffer4.getCapacity() - chunkBuffer4.getLimit() < 8) {
                            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i4);
                        } else {
                            chunkBufferPrepareReadNextHead = chunkBufferM7223prepareReadFirstHead;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i4);
                    }
                    if (chunkBufferPrepareReadNextHead == null) {
                        z = false;
                        break;
                    }
                    chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    if (i4 <= 0) {
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z) {
                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
            }
        }
        return i2 - i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int readAvailable(io.ktor.utils.p098io.core.Input r8, long[] r9, int r10, int r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.p098io.core.internal.UnsafeKt.m7223prepareReadFirstHead(r8, r0)
            if (r1 != 0) goto L14
            r3 = r11
            goto L8b
        L14:
            r3 = r11
            r2 = r0
        L16:
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.p098io.core.Buffer) r4     // Catch: java.lang.Throwable -> L8d
            int r5 = r4.getWritePosition()     // Catch: java.lang.Throwable -> L8d
            int r4 = r4.getReadPosition()     // Catch: java.lang.Throwable -> L8d
            int r5 = r5 - r4
            r4 = 0
            r6 = 8
            if (r5 < r2) goto L5b
            r2 = r1
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.p098io.core.Buffer) r2     // Catch: java.lang.Throwable -> L50
            int r5 = r2.getWritePosition()     // Catch: java.lang.Throwable -> L50
            int r7 = r2.getReadPosition()     // Catch: java.lang.Throwable -> L50
            int r5 = r5 - r7
            int r5 = r5 / r6
            int r5 = java.lang.Math.min(r3, r5)     // Catch: java.lang.Throwable -> L50
            io.ktor.utils.p098io.core.BufferPrimitivesKt.readFully(r2, r9, r10, r5)     // Catch: java.lang.Throwable -> L50
            int r3 = r3 - r5
            int r10 = r10 + r5
            if (r3 <= 0) goto L41
            r2 = r6
            goto L42
        L41:
            r2 = r4
        L42:
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.p098io.core.Buffer) r5     // Catch: java.lang.Throwable -> L8d
            int r7 = r5.getWritePosition()     // Catch: java.lang.Throwable -> L8d
            int r5 = r5.getReadPosition()     // Catch: java.lang.Throwable -> L8d
            int r5 = r7 - r5
            goto L5b
        L50:
            r9 = move-exception
            r10 = r1
            io.ktor.utils.io.core.Buffer r10 = (io.ktor.utils.p098io.core.Buffer) r10     // Catch: java.lang.Throwable -> L8d
            r10.getWritePosition()     // Catch: java.lang.Throwable -> L8d
            r10.getReadPosition()     // Catch: java.lang.Throwable -> L8d
            throw r9     // Catch: java.lang.Throwable -> L8d
        L5b:
            if (r5 != 0) goto L65
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.p098io.core.internal.UnsafeKt.prepareReadNextHead(r8, r1)     // Catch: java.lang.Throwable -> L62
            goto L7f
        L62:
            r9 = move-exception
            r0 = r4
            goto L8e
        L65:
            if (r5 < r2) goto L78
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.p098io.core.Buffer) r5     // Catch: java.lang.Throwable -> L62
            int r7 = r5.getCapacity()     // Catch: java.lang.Throwable -> L62
            int r5 = r5.getLimit()     // Catch: java.lang.Throwable -> L62
            int r7 = r7 - r5
            if (r7 >= r6) goto L76
            goto L78
        L76:
            r5 = r1
            goto L7f
        L78:
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r8, r1)     // Catch: java.lang.Throwable -> L62
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.p098io.core.internal.UnsafeKt.m7223prepareReadFirstHead(r8, r2)     // Catch: java.lang.Throwable -> L62
        L7f:
            if (r5 != 0) goto L83
            r0 = r4
            goto L86
        L83:
            r1 = r5
            if (r2 > 0) goto L16
        L86:
            if (r0 == 0) goto L8b
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r8, r1)
        L8b:
            int r11 = r11 - r3
            return r11
        L8d:
            r9 = move-exception
        L8e:
            if (r0 == 0) goto L93
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r8, r1)
        L93:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.InputArraysKt.readAvailable(io.ktor.utils.io.core.Input, long[], int, int):int");
    }

    public static final int readAvailable(Input input, float[] dst, int i, int i2) throws Throwable {
        int i3;
        ChunkBuffer chunkBuffer;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead == null) {
            i3 = i2;
        } else {
            i3 = i2;
            int i4 = 1;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i4) {
                        try {
                            ChunkBuffer chunkBuffer2 = chunkBufferM7223prepareReadFirstHead;
                            int iMin = Math.min(i3, (chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition()) / 4);
                            BufferPrimitivesKt.readFully((Buffer) chunkBuffer2, dst, i, iMin);
                            i3 -= iMin;
                            i += iMin;
                            i4 = i3 > 0 ? 4 : 0;
                            ChunkBuffer chunkBuffer3 = chunkBufferM7223prepareReadFirstHead;
                            writePosition = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                        } finally {
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else if (writePosition >= i4) {
                        ChunkBuffer chunkBuffer4 = chunkBufferM7223prepareReadFirstHead;
                        if (chunkBuffer4.getCapacity() - chunkBuffer4.getLimit() < 8) {
                            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i4);
                        } else {
                            chunkBufferPrepareReadNextHead = chunkBufferM7223prepareReadFirstHead;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i4);
                    }
                    if (chunkBufferPrepareReadNextHead == null) {
                        z = false;
                        break;
                    }
                    chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    if (i4 <= 0) {
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z) {
                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
            }
        }
        return i2 - i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int readAvailable(io.ktor.utils.p098io.core.Input r8, double[] r9, int r10, int r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.p098io.core.internal.UnsafeKt.m7223prepareReadFirstHead(r8, r0)
            if (r1 != 0) goto L14
            r3 = r11
            goto L8b
        L14:
            r3 = r11
            r2 = r0
        L16:
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.p098io.core.Buffer) r4     // Catch: java.lang.Throwable -> L8d
            int r5 = r4.getWritePosition()     // Catch: java.lang.Throwable -> L8d
            int r4 = r4.getReadPosition()     // Catch: java.lang.Throwable -> L8d
            int r5 = r5 - r4
            r4 = 0
            r6 = 8
            if (r5 < r2) goto L5b
            r2 = r1
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.p098io.core.Buffer) r2     // Catch: java.lang.Throwable -> L50
            int r5 = r2.getWritePosition()     // Catch: java.lang.Throwable -> L50
            int r7 = r2.getReadPosition()     // Catch: java.lang.Throwable -> L50
            int r5 = r5 - r7
            int r5 = r5 / r6
            int r5 = java.lang.Math.min(r3, r5)     // Catch: java.lang.Throwable -> L50
            io.ktor.utils.p098io.core.BufferPrimitivesKt.readFully(r2, r9, r10, r5)     // Catch: java.lang.Throwable -> L50
            int r3 = r3 - r5
            int r10 = r10 + r5
            if (r3 <= 0) goto L41
            r2 = r6
            goto L42
        L41:
            r2 = r4
        L42:
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.p098io.core.Buffer) r5     // Catch: java.lang.Throwable -> L8d
            int r7 = r5.getWritePosition()     // Catch: java.lang.Throwable -> L8d
            int r5 = r5.getReadPosition()     // Catch: java.lang.Throwable -> L8d
            int r5 = r7 - r5
            goto L5b
        L50:
            r9 = move-exception
            r10 = r1
            io.ktor.utils.io.core.Buffer r10 = (io.ktor.utils.p098io.core.Buffer) r10     // Catch: java.lang.Throwable -> L8d
            r10.getWritePosition()     // Catch: java.lang.Throwable -> L8d
            r10.getReadPosition()     // Catch: java.lang.Throwable -> L8d
            throw r9     // Catch: java.lang.Throwable -> L8d
        L5b:
            if (r5 != 0) goto L65
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.p098io.core.internal.UnsafeKt.prepareReadNextHead(r8, r1)     // Catch: java.lang.Throwable -> L62
            goto L7f
        L62:
            r9 = move-exception
            r0 = r4
            goto L8e
        L65:
            if (r5 < r2) goto L78
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.p098io.core.Buffer) r5     // Catch: java.lang.Throwable -> L62
            int r7 = r5.getCapacity()     // Catch: java.lang.Throwable -> L62
            int r5 = r5.getLimit()     // Catch: java.lang.Throwable -> L62
            int r7 = r7 - r5
            if (r7 >= r6) goto L76
            goto L78
        L76:
            r5 = r1
            goto L7f
        L78:
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r8, r1)     // Catch: java.lang.Throwable -> L62
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.p098io.core.internal.UnsafeKt.m7223prepareReadFirstHead(r8, r2)     // Catch: java.lang.Throwable -> L62
        L7f:
            if (r5 != 0) goto L83
            r0 = r4
            goto L86
        L83:
            r1 = r5
            if (r2 > 0) goto L16
        L86:
            if (r0 == 0) goto L8b
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r8, r1)
        L8b:
            int r11 = r11 - r3
            return r11
        L8d:
            r9 = move-exception
        L8e:
            if (r0 == 0) goto L93
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r8, r1)
        L93:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.InputArraysKt.readAvailable(io.ktor.utils.io.core.Input, double[], int, int):int");
    }

    public static final int readAvailable(Input input, Buffer dst, int i) throws Throwable {
        int i2;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead == null) {
            i2 = i;
        } else {
            i2 = i;
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                    int iMin = Math.min(i2, chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
                    BufferPrimitivesKt.readFully(chunkBuffer, dst, iMin);
                    i2 -= iMin;
                    if (i2 > 0) {
                        try {
                            chunkBufferM7223prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                            if (chunkBufferM7223prepareReadFirstHead == null) {
                                break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return i - i2;
    }

    public static /* synthetic */ int readAvailable$default(Input input, Buffer buffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = buffer.getLimit() - buffer.getWritePosition();
        }
        return readAvailable(input, buffer, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX INFO: renamed from: readAvailable-mCvI5oI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long m7146readAvailablemCvI5oI(io.ktor.utils.p098io.core.Input r18, java.nio.ByteBuffer r19, long r20, long r22) throws java.lang.Throwable {
        /*
            r1 = r18
            java.lang.String r0 = "$this$readAvailable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "destination"
            r10 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r11 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r0 = io.ktor.utils.p098io.core.internal.UnsafeKt.m7223prepareReadFirstHead(r1, r11)
            if (r0 != 0) goto L18
            r6 = r22
            goto L61
        L18:
            r14 = r20
            r6 = r22
            r8 = r0
        L1d:
            r0 = r8
            io.ktor.utils.io.core.Buffer r0 = (io.ktor.utils.p098io.core.Buffer) r0     // Catch: java.lang.Throwable -> L74
            int r2 = r0.getWritePosition()     // Catch: java.lang.Throwable -> L74
            int r3 = r0.getReadPosition()     // Catch: java.lang.Throwable -> L74
            int r2 = r2 - r3
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L74
            long r2 = java.lang.Math.min(r6, r2)     // Catch: java.lang.Throwable -> L74
            int r9 = (int) r2     // Catch: java.lang.Throwable -> L74
            java.nio.ByteBuffer r2 = r0.getMemory()     // Catch: java.lang.Throwable -> L74
            int r3 = r0.getReadPosition()     // Catch: java.lang.Throwable -> L74
            long r4 = (long) r3
            long r11 = (long) r9
            r3 = r19
            r16 = r6
            r6 = r11
            r13 = r8
            r10 = r9
            r8 = r14
            io.ktor.utils.p098io.bits.Memory.m6953copyToiAfECsU(r2, r3, r4, r6, r8)     // Catch: java.lang.Throwable -> L72
            r0.discardExact(r10)     // Catch: java.lang.Throwable -> L72
            long r6 = r16 - r11
            long r14 = r14 + r11
            r2 = 0
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L5e
            io.ktor.utils.io.core.internal.ChunkBuffer r8 = io.ktor.utils.p098io.core.internal.UnsafeKt.prepareReadNextHead(r1, r13)     // Catch: java.lang.Throwable -> L5b
            if (r8 != 0) goto L57
            goto L61
        L57:
            r10 = r19
            r11 = 1
            goto L1d
        L5b:
            r0 = move-exception
            r11 = 0
            goto L77
        L5e:
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r1, r13)
        L61:
            long r2 = r22 - r6
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L71
            boolean r0 = r18.isEmpty()
            if (r0 == 0) goto L71
            r2 = -1
        L71:
            return r2
        L72:
            r0 = move-exception
            goto L76
        L74:
            r0 = move-exception
            r13 = r8
        L76:
            r11 = 1
        L77:
            if (r11 == 0) goto L7c
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r1, r13)
        L7c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.InputArraysKt.m7146readAvailablemCvI5oI(io.ktor.utils.io.core.Input, java.nio.ByteBuffer, long, long):long");
    }

    private static final int readFullyBytesTemplate(Input input, int i, int i2, Function3<? super Buffer, ? super Integer, ? super Integer, Unit> function3) throws Throwable {
        boolean z;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead != null) {
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                    int iMin = Math.min(i2, chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
                    function3.invoke(chunkBuffer, Integer.valueOf(i), Integer.valueOf(iMin));
                    i2 -= iMin;
                    i += iMin;
                    if (i2 <= 0) {
                        z = true;
                        break;
                    }
                    z = false;
                    try {
                        ChunkBuffer chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                        if (chunkBufferPrepareReadNextHead == null) {
                            break;
                        }
                        chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
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
        return i2;
    }

    private static final long readFullyBytesTemplate(Input input, long j, long j2, Function4<? super Memory, ? super Long, ? super Long, ? super Integer, Unit> function4) throws Throwable {
        boolean z;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead != null) {
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                    int iMin = (int) Math.min(j2, chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
                    function4.invoke(Memory.m6950boximpl(chunkBuffer.getMemory()), Long.valueOf(chunkBuffer.getReadPosition()), Long.valueOf(j), Integer.valueOf(iMin));
                    chunkBuffer.discardExact(iMin);
                    long j3 = iMin;
                    j2 -= j3;
                    j += j3;
                    if (j2 <= 0) {
                        z = true;
                        break;
                    }
                    z = false;
                    try {
                        ChunkBuffer chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                        if (chunkBufferPrepareReadNextHead == null) {
                            break;
                        }
                        chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
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
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int readFullyTemplate(io.ktor.utils.p098io.core.Input r7, int r8, int r9, int r10, kotlin.jvm.functions.Function3<? super io.ktor.utils.p098io.core.Buffer, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.p098io.core.internal.UnsafeKt.m7223prepareReadFirstHead(r7, r0)
            if (r1 != 0) goto L9
            goto L98
        L9:
            r2 = r0
        La:
            r3 = r1
            io.ktor.utils.io.core.Buffer r3 = (io.ktor.utils.p098io.core.Buffer) r3     // Catch: java.lang.Throwable -> L9c
            int r4 = r3.getWritePosition()     // Catch: java.lang.Throwable -> L9c
            int r3 = r3.getReadPosition()     // Catch: java.lang.Throwable -> L9c
            int r4 = r4 - r3
            r3 = 0
            if (r4 < r2) goto L61
            r2 = r1
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.p098io.core.Buffer) r2     // Catch: java.lang.Throwable -> L50
            int r4 = r2.getWritePosition()     // Catch: java.lang.Throwable -> L50
            int r5 = r2.getReadPosition()     // Catch: java.lang.Throwable -> L50
            int r4 = r4 - r5
            int r4 = r4 / r10
            int r4 = java.lang.Math.min(r9, r4)     // Catch: java.lang.Throwable -> L50
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L50
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L50
            r11.invoke(r2, r5, r6)     // Catch: java.lang.Throwable -> L50
            int r9 = r9 - r4
            int r8 = r8 + r4
            if (r9 <= 0) goto L3b
            r2 = r10
            goto L3c
        L3b:
            r2 = r3
        L3c:
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)     // Catch: java.lang.Throwable -> L9c
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.p098io.core.Buffer) r4     // Catch: java.lang.Throwable -> L9c
            int r5 = r4.getWritePosition()     // Catch: java.lang.Throwable -> L9c
            int r4 = r4.getReadPosition()     // Catch: java.lang.Throwable -> L9c
            int r4 = r5 - r4
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)     // Catch: java.lang.Throwable -> L9c
            goto L61
        L50:
            r8 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)     // Catch: java.lang.Throwable -> L9c
            r9 = r1
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.p098io.core.Buffer) r9     // Catch: java.lang.Throwable -> L9c
            r9.getWritePosition()     // Catch: java.lang.Throwable -> L9c
            r9.getReadPosition()     // Catch: java.lang.Throwable -> L9c
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)     // Catch: java.lang.Throwable -> L9c
            throw r8     // Catch: java.lang.Throwable -> L9c
        L61:
            if (r4 != 0) goto L6a
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.p098io.core.internal.UnsafeKt.prepareReadNextHead(r7, r1)     // Catch: java.lang.Throwable -> L68
            goto L86
        L68:
            r8 = move-exception
            goto L9e
        L6a:
            if (r4 < r2) goto L7f
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.p098io.core.Buffer) r4     // Catch: java.lang.Throwable -> L68
            int r5 = r4.getCapacity()     // Catch: java.lang.Throwable -> L68
            int r4 = r4.getLimit()     // Catch: java.lang.Throwable -> L68
            int r5 = r5 - r4
            r4 = 8
            if (r5 >= r4) goto L7d
            goto L7f
        L7d:
            r4 = r1
            goto L86
        L7f:
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r7, r1)     // Catch: java.lang.Throwable -> L68
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.p098io.core.internal.UnsafeKt.m7223prepareReadFirstHead(r7, r2)     // Catch: java.lang.Throwable -> L68
        L86:
            if (r4 != 0) goto L89
            goto L8d
        L89:
            if (r2 > 0) goto L99
            r3 = r0
            r1 = r4
        L8d:
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            if (r3 == 0) goto L95
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L95:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
        L98:
            return r9
        L99:
            r1 = r4
            goto La
        L9c:
            r8 = move-exception
            r3 = r0
        L9e:
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            if (r3 == 0) goto La6
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        La6:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.InputArraysKt.readFullyTemplate(io.ktor.utils.io.core.Input, int, int, int, kotlin.jvm.functions.Function3):int");
    }
}
