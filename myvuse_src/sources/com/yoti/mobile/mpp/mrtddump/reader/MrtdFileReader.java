package com.yoti.mobile.mpp.mrtddump.reader;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bat.sdk.domain.device.FirmwareInstallationState;
import com.yoti.mobile.mpp.mrtddump.MrtdException;
import com.yoti.mobile.mpp.mrtddump.commands.ICommandGenerator;
import com.yoti.mobile.mpp.mrtddump.p096j.C5119c;
import com.yoti.mobile.mpp.mrtddump.p096j.C5120d;
import com.yoti.mobile.mpp.mrtddump.session.MessagingSession;
import com.yoti.mobile.mpp.smartcard.CommandAPDU;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.reader.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001*Bf\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012*\u0010\u000e\u001a&\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u001b\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010\u001c\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001e\u001a\u00020\u00112\n\u0010\u001f\u001a\u00060\u0016j\u0002`\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J\u001d\u0010!\u001a\u00020\u00112\n\u0010\u001f\u001a\u00060\u0016j\u0002`\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0015\u0010\"\u001a\u00060\u0016j\u0002`\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u0010$\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J%\u0010%\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J%\u0010)\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u000e\u001a&\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000fX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileReader;", "", "session", "Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;", "commandGenerator", "Lcom/yoti/mobile/mpp/mrtddump/commands/ICommandGenerator;", "shortFileId", "", "fileId", "", "fileName", "", "fileBuilder", "Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileBuilder;", "progressCallback", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;Lcom/yoti/mobile/mpp/mrtddump/commands/ICommandGenerator;Ljava/lang/Byte;ILjava/lang/String;Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileBuilder;Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function3;", "Ljava/lang/Byte;", "executeReadCommand", "", "Lcom/yoti/mobile/mpp/mrtddump/FileData;", "readCommand", "Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;", "(Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finishReadingFile", "bytesRead", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleContinuationBlockRead", "block", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleFirstBlockRead", "read", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFirstBlock", "readNextBlock", "totalBytesRead", "bytesRemaining", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readNextBlockWithoutSelect", "Factory", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdFileReader {

    /* JADX INFO: renamed from: a */
    private final MessagingSession f8139a;

    /* JADX INFO: renamed from: b */
    private final ICommandGenerator f8140b;

    /* JADX INFO: renamed from: c */
    private final Byte f8141c;

    /* JADX INFO: renamed from: d */
    private final int f8142d;

    /* JADX INFO: renamed from: e */
    private final String f8143e;

    /* JADX INFO: renamed from: f */
    private final MrtdFileBuilder f8144f;

    /* JADX INFO: renamed from: g */
    private final Function3<Integer, Integer, Continuation<? super Unit>, Object> f8145g;

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.reader.b$a */
    @Metadata(m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JR\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2*\u0010\u000b\u001a&\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\fø\u0001\u0000¢\u0006\u0002\u0010\u0010JR\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00112*\u0010\u000b\u001a&\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\fø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileReader$Factory;", "", "()V", "createReader", "Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileReader;", "session", "Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;", "commandGenerator", "Lcom/yoti/mobile/mpp/mrtddump/commands/ICommandGenerator;", "file", "Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileType;", "progressCallback", "Lkotlin/Function3;", "", "Lkotlin/coroutines/Continuation;", "", "(Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;Lcom/yoti/mobile/mpp/mrtddump/commands/ICommandGenerator;Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileType;Lkotlin/jvm/functions/Function3;)Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileReader;", "Lcom/yoti/mobile/mpp/mrtddump/reader/TransparentFileType;", "(Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;Lcom/yoti/mobile/mpp/mrtddump/commands/ICommandGenerator;Lcom/yoti/mobile/mpp/mrtddump/reader/TransparentFileType;Lkotlin/jvm/functions/Function3;)Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileReader;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a {
        /* JADX INFO: renamed from: a */
        public final MrtdFileReader m5566a(MessagingSession session, ICommandGenerator commandGenerator, MrtdFileType file, Function3<? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function3) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(commandGenerator, "commandGenerator");
            Intrinsics.checkNotNullParameter(file, "file");
            return new MrtdFileReader(session, commandGenerator, Byte.valueOf(file.getShortId()), file.getFileId(), file.name(), new TlvFileBuilder(), function3);
        }

        /* JADX INFO: renamed from: a */
        public final MrtdFileReader m5567a(MessagingSession session, ICommandGenerator commandGenerator, TransparentFileType file, Function3<? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function3) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(commandGenerator, "commandGenerator");
            Intrinsics.checkNotNullParameter(file, "file");
            return new MrtdFileReader(session, commandGenerator, null, file.getF8192f(), file.name(), new TransparentFileBuilder(), function3);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.reader.b$b */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader", m5608f = "MrtdFileReader.kt", m5609i = {0}, m5610l = {FirmwareInstallationState.Error.ERROR_BLE_LINK_LOSS_GATT}, m5611m = "executeReadCommand", m5612n = {"this"}, m5613s = {"L$0"})
    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f8146a;

        /* JADX INFO: renamed from: b */
        /* synthetic */ Object f8147b;

        /* JADX INFO: renamed from: d */
        int f8149d;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8147b = obj;
            this.f8149d |= Integer.MIN_VALUE;
            return MrtdFileReader.this.m5560a((CommandAPDU) null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.reader.b$c */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader", m5608f = "MrtdFileReader.kt", m5609i = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4}, m5610l = {75, 76, 82, 92, 93}, m5611m = "finishReadingFile", m5612n = {"this", "totalBytesRead", "this", "block", "totalBytesRead", "this", "totalBytesRead", "this", "totalBytesRead", "this", "block", "totalBytesRead"}, m5613s = {"L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "L$1", "I$0"})
    static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f8150a;

        /* JADX INFO: renamed from: b */
        Object f8151b;

        /* JADX INFO: renamed from: c */
        int f8152c;

        /* JADX INFO: renamed from: d */
        /* synthetic */ Object f8153d;

        /* JADX INFO: renamed from: f */
        int f8155f;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8153d = obj;
            this.f8155f |= Integer.MIN_VALUE;
            return MrtdFileReader.this.m5556a(0, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.reader.b$d */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader", m5608f = "MrtdFileReader.kt", m5609i = {0, 1}, m5610l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG, 52, LockFreeTaskQueueCore.CLOSED_SHIFT}, m5611m = "read", m5612n = {"this", "this"}, m5613s = {"L$0", "L$0"})
    static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f8156a;

        /* JADX INFO: renamed from: b */
        Object f8157b;

        /* JADX INFO: renamed from: c */
        /* synthetic */ Object f8158c;

        /* JADX INFO: renamed from: e */
        int f8160e;

        d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8158c = obj;
            this.f8160e |= Integer.MIN_VALUE;
            return MrtdFileReader.this.m5565a(this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.reader.b$e */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader", m5608f = "MrtdFileReader.kt", m5609i = {}, m5610l = {107}, m5611m = "readFirstBlock", m5612n = {}, m5613s = {})
    static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        /* synthetic */ Object f8161a;

        /* JADX INFO: renamed from: c */
        int f8163c;

        e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8161a = obj;
            this.f8163c |= Integer.MIN_VALUE;
            return MrtdFileReader.this.m5563b(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MrtdFileReader(MessagingSession session, ICommandGenerator commandGenerator, Byte b2, int i, String fileName, MrtdFileBuilder fileBuilder, Function3<? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(commandGenerator, "commandGenerator");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(fileBuilder, "fileBuilder");
        this.f8139a = session;
        this.f8140b = commandGenerator;
        this.f8141c = b2;
        this.f8142d = i;
        this.f8143e = fileName;
        this.f8144f = fileBuilder;
        this.f8145g = function3;
    }

    /* JADX INFO: renamed from: a */
    private final Object m5555a(int i, int i2, Continuation<? super byte[]> continuation) {
        return m5560a(this.f8140b.mo5474a(i, i2), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0121 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x011f -> B:56:0x0122). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5556a(int r12, kotlin.coroutines.Continuation<? super byte[]> r13) throws com.yoti.mobile.mpp.mrtddump.MrtdCommandFailedException, com.yoti.mobile.mpp.mrtddump.MrtdFileNotFoundException {
        /*
            Method dump skipped, instruction units count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader.m5556a(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5560a(com.yoti.mobile.mpp.smartcard.CommandAPDU r8, kotlin.coroutines.Continuation<? super byte[]> r9) throws com.yoti.mobile.mpp.mrtddump.MrtdCommunicationException, com.yoti.mobile.mpp.mrtddump.MrtdCommandFailedException, com.yoti.mobile.mpp.mrtddump.MrtdFileNotFoundException {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader.m5560a(com.yoti.mobile.mpp.smartcard.CommandAPDU, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: a */
    private final Object m5561a(byte[] bArr, Continuation<? super Unit> continuation) throws MrtdException {
        if (C5120d.m5539a() <= 1) {
            C5119c.m5531a("MrtdFileReader", "Read " + bArr.length + " bytes for " + this.f8143e);
        }
        if (bArr.length == 0) {
            throw new MrtdException(Intrinsics.stringPlus("Incorrect size for ", this.f8143e), null, 2, null);
        }
        this.f8144f.mo5547a(bArr);
        Function3<Integer, Integer, Continuation<? super Unit>, Object> function3 = this.f8145g;
        if (function3 != null) {
            Object objInvoke = function3.invoke(Boxing.boxInt(this.f8144f.mo5552e()), Boxing.boxInt(this.f8144f.mo5549b()), continuation);
            return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
        }
        if (IntrinsicsKt.getCOROUTINE_SUSPENDED() == null) {
            return null;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: b */
    private final Object m5562b(int i, int i2, Continuation<? super byte[]> continuation) {
        ICommandGenerator iCommandGenerator = this.f8140b;
        Byte b2 = this.f8141c;
        if (b2 != null) {
            return m5560a(iCommandGenerator.mo5472a(b2.byteValue(), i, i2), continuation);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5563b(kotlin.coroutines.Continuation<? super byte[]> r5) throws com.yoti.mobile.mpp.mrtddump.MrtdCommunicationException, com.yoti.mobile.mpp.mrtddump.MrtdCommandFailedException, com.yoti.mobile.mpp.mrtddump.MrtdFileNotFoundException {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader.e
            if (r0 == 0) goto L13
            r0 = r5
            com.yoti.mobile.mpp.mrtddump.reader.b$e r0 = (com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader.e) r0
            int r1 = r0.f8163c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8163c = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.reader.b$e r0 = new com.yoti.mobile.mpp.mrtddump.reader.b$e
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f8161a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8163c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4e
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.Byte r5 = r4.f8141c
            if (r5 != 0) goto L3a
            r5 = 0
            goto L50
        L3a:
            byte r5 = r5.byteValue()
            com.yoti.mobile.mpp.mrtddump.g.f r2 = r4.f8140b
            byte r5 = (byte) r5
            com.yoti.mobile.mpp.smartcard.CommandAPDU r5 = r2.mo5471a(r5)
            r0.f8163c = r3
            java.lang.Object r5 = r4.m5560a(r5, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            byte[] r5 = (byte[]) r5
        L50:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader.m5563b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: b */
    private final Object m5564b(byte[] bArr, Continuation<? super Unit> continuation) {
        this.f8144f.mo5547a(bArr);
        if (C5120d.m5539a() <= 1) {
            C5119c.m5531a("MrtdFileReader", Intrinsics.stringPlus("First block size: ", Boxing.boxInt(bArr.length)));
        }
        if (C5120d.m5539a() <= 2) {
            C5119c.m5531a("MrtdFileReader", Intrinsics.stringPlus("File size: ", Boxing.boxInt(this.f8144f.mo5549b())));
        }
        Function3<Integer, Integer, Continuation<? super Unit>, Object> function3 = this.f8145g;
        if (function3 != null) {
            Object objInvoke = function3.invoke(Boxing.boxInt(bArr.length), Boxing.boxInt(this.f8144f.mo5549b()), continuation);
            return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
        }
        if (IntrinsicsKt.getCOROUTINE_SUSPENDED() == null) {
            return null;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5565a(kotlin.coroutines.Continuation<? super byte[]> r9) throws com.yoti.mobile.mpp.mrtddump.MrtdCommunicationException, com.yoti.mobile.mpp.mrtddump.MrtdCommandFailedException, com.yoti.mobile.mpp.mrtddump.MrtdFileNotFoundException {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader.d
            if (r0 == 0) goto L13
            r0 = r9
            com.yoti.mobile.mpp.mrtddump.reader.b$d r0 = (com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader.d) r0
            int r1 = r0.f8160e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8160e = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.reader.b$d r0 = new com.yoti.mobile.mpp.mrtddump.reader.b$d
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f8158c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8160e
            java.lang.String r3 = "MrtdFileReader"
            r4 = 3
            r5 = 1
            r6 = 0
            r7 = 2
            if (r2 == 0) goto L50
            if (r2 == r5) goto L47
            if (r2 == r7) goto L3b
            if (r2 != r4) goto L33
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lb0
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3b:
            java.lang.Object r2 = r0.f8157b
            byte[] r2 = (byte[]) r2
            java.lang.Object r5 = r0.f8156a
            com.yoti.mobile.mpp.mrtddump.reader.b r5 = (com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto L84
        L47:
            java.lang.Object r2 = r0.f8156a
            com.yoti.mobile.mpp.mrtddump.reader.b r2 = (com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader) r2
            kotlin.ResultKt.throwOnFailure(r9)
            r5 = r2
            goto L70
        L50:
            kotlin.ResultKt.throwOnFailure(r9)
            int r9 = com.yoti.mobile.mpp.mrtddump.p096j.C5120d.m5539a()
            if (r9 > r7) goto L64
            java.lang.String r9 = r8.f8143e
            java.lang.String r2 = "Reading file "
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r9)
            com.yoti.mobile.mpp.mrtddump.p096j.C5119c.m5531a(r3, r9)
        L64:
            r0.f8156a = r8
            r0.f8160e = r5
            java.lang.Object r9 = r8.m5563b(r0)
            if (r9 != r1) goto L6f
            return r1
        L6f:
            r5 = r8
        L70:
            r2 = r9
            byte[] r2 = (byte[]) r2
            if (r2 != 0) goto L77
            r2 = r6
            goto L84
        L77:
            r0.f8156a = r5
            r0.f8157b = r2
            r0.f8160e = r7
            java.lang.Object r9 = r5.m5564b(r2, r0)
            if (r9 != r1) goto L84
            return r1
        L84:
            com.yoti.mobile.mpp.mrtddump.reader.a r9 = r5.f8144f
            boolean r9 = r9.mo5548a()
            if (r9 == 0) goto L9e
            int r9 = com.yoti.mobile.mpp.mrtddump.p096j.C5120d.m5539a()
            if (r9 > r7) goto L97
            java.lang.String r9 = "File read complete"
            com.yoti.mobile.mpp.mrtddump.p096j.C5119c.m5531a(r3, r9)
        L97:
            com.yoti.mobile.mpp.mrtddump.reader.a r9 = r5.f8144f
            byte[] r9 = r9.mo5550c()
            return r9
        L9e:
            if (r2 != 0) goto La2
            r9 = 0
            goto La3
        La2:
            int r9 = r2.length
        La3:
            r0.f8156a = r6
            r0.f8157b = r6
            r0.f8160e = r4
            java.lang.Object r9 = r5.m5556a(r9, r0)
            if (r9 != r1) goto Lb0
            return r1
        Lb0:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader.m5565a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
