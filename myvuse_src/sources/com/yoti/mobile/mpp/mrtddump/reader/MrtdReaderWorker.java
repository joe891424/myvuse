package com.yoti.mobile.mpp.mrtddump.reader;

import com.yoti.mobile.mpp.mrtddump.MrtdReaderConfig;
import com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfo;
import com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfoReader;
import com.yoti.mobile.mpp.mrtddump.commands.CommandGeneratorFactory;
import com.yoti.mobile.mpp.mrtddump.p095io.NfcController;
import com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader;
import com.yoti.mobile.mpp.mrtddump.session.MessagingSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.reader.c, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001fB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000eH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J[\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u00182*\u0010\u0019\u001a&\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001aH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdReaderWorker;", "", "initialSession", "Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;", "readerConfig", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderConfig;", "infoReader", "Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ChipInfoReader;", "commandGeneratorFactory", "Lcom/yoti/mobile/mpp/mrtddump/commands/CommandGeneratorFactory;", "fileReaderFactory", "Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileReader$Factory;", "(Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderConfig;Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ChipInfoReader;Lcom/yoti/mobile/mpp/mrtddump/commands/CommandGeneratorFactory;Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileReader$Factory;)V", "connect", "Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ChipInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "open", "chipInfo", "(Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ChipInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", "", "Lcom/yoti/mobile/mpp/mrtddump/FileData;", "session", "file", "Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileType;", "progressCallback", "Lkotlin/Function3;", "", "Lkotlin/coroutines/Continuation;", "", "(Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ChipInfo;Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileType;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdReaderWorker {

    /* JADX INFO: renamed from: a */
    private final MessagingSession f8164a;

    /* JADX INFO: renamed from: b */
    private final MrtdReaderConfig f8165b;

    /* JADX INFO: renamed from: c */
    private final ChipInfoReader f8166c;

    /* JADX INFO: renamed from: d */
    private final CommandGeneratorFactory f8167d;

    /* JADX INFO: renamed from: e */
    private final MrtdFileReader.a f8168e;

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.reader.c$a */
    @Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdReaderWorker$Factory;", "", "commandGeneratorFactory", "Lcom/yoti/mobile/mpp/mrtddump/commands/CommandGeneratorFactory;", "sessionFactory", "Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession$Factory;", "infoReader", "Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ChipInfoReader;", "readerFactory", "Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileReader$Factory;", "(Lcom/yoti/mobile/mpp/mrtddump/commands/CommandGeneratorFactory;Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession$Factory;Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ChipInfoReader;Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileReader$Factory;)V", "create", "Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdReaderWorker;", "nfcController", "Lcom/yoti/mobile/mpp/mrtddump/io/NfcController;", "config", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderConfig;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a */
        private final CommandGeneratorFactory f8169a;

        /* JADX INFO: renamed from: b */
        private final MessagingSession.a f8170b;

        /* JADX INFO: renamed from: c */
        private final ChipInfoReader f8171c;

        /* JADX INFO: renamed from: d */
        private final MrtdFileReader.a f8172d;

        public a(CommandGeneratorFactory commandGeneratorFactory, MessagingSession.a sessionFactory, ChipInfoReader infoReader, MrtdFileReader.a readerFactory) {
            Intrinsics.checkNotNullParameter(commandGeneratorFactory, "commandGeneratorFactory");
            Intrinsics.checkNotNullParameter(sessionFactory, "sessionFactory");
            Intrinsics.checkNotNullParameter(infoReader, "infoReader");
            Intrinsics.checkNotNullParameter(readerFactory, "readerFactory");
            this.f8169a = commandGeneratorFactory;
            this.f8170b = sessionFactory;
            this.f8171c = infoReader;
            this.f8172d = readerFactory;
        }

        /* JADX INFO: renamed from: a */
        public final MrtdReaderWorker m5571a(NfcController nfcController, MrtdReaderConfig config) {
            Intrinsics.checkNotNullParameter(nfcController, "nfcController");
            Intrinsics.checkNotNullParameter(config, "config");
            return new MrtdReaderWorker(this.f8170b.m5514a(nfcController), config, this.f8171c, this.f8169a, this.f8172d);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.reader.c$b */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.reader.MrtdReaderWorker", m5608f = "MrtdReaderWorker.kt", m5609i = {0}, m5610l = {40, 42}, m5611m = "connect", m5612n = {"this"}, m5613s = {"L$0"})
    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f8173a;

        /* JADX INFO: renamed from: b */
        /* synthetic */ Object f8174b;

        /* JADX INFO: renamed from: d */
        int f8176d;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8174b = obj;
            this.f8176d |= Integer.MIN_VALUE;
            return MrtdReaderWorker.this.m5570a(this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.reader.c$c */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.reader.MrtdReaderWorker", m5608f = "MrtdReaderWorker.kt", m5609i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}, m5610l = {65, 75, 82}, m5611m = "open", m5612n = {"this", "authSuccess", "session", "pendingAuthErrors", "commandGenerator", "this", "authSuccess", "session", "pendingAuthErrors", "commandGenerator", "session", "pendingAuthErrors"}, m5613s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"})
    static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f8177a;

        /* JADX INFO: renamed from: b */
        Object f8178b;

        /* JADX INFO: renamed from: c */
        Object f8179c;

        /* JADX INFO: renamed from: d */
        Object f8180d;

        /* JADX INFO: renamed from: e */
        Object f8181e;

        /* JADX INFO: renamed from: f */
        /* synthetic */ Object f8182f;

        /* JADX INFO: renamed from: h */
        int f8184h;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8182f = obj;
            this.f8184h |= Integer.MIN_VALUE;
            return MrtdReaderWorker.this.m5569a(null, this);
        }
    }

    public MrtdReaderWorker(MessagingSession initialSession, MrtdReaderConfig readerConfig, ChipInfoReader infoReader, CommandGeneratorFactory commandGeneratorFactory, MrtdFileReader.a fileReaderFactory) {
        Intrinsics.checkNotNullParameter(initialSession, "initialSession");
        Intrinsics.checkNotNullParameter(readerConfig, "readerConfig");
        Intrinsics.checkNotNullParameter(infoReader, "infoReader");
        Intrinsics.checkNotNullParameter(commandGeneratorFactory, "commandGeneratorFactory");
        Intrinsics.checkNotNullParameter(fileReaderFactory, "fileReaderFactory");
        this.f8164a = initialSession;
        this.f8165b = readerConfig;
        this.f8166c = infoReader;
        this.f8167d = commandGeneratorFactory;
        this.f8168e = fileReaderFactory;
    }

    /* JADX INFO: renamed from: a */
    public final Object m5568a(ChipInfo chipInfo, MessagingSession messagingSession, MrtdFileType mrtdFileType, Function3<? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super byte[]> continuation) {
        if (messagingSession == null) {
            messagingSession = this.f8164a;
        }
        return this.f8168e.m5566a(messagingSession, this.f8167d.m5477a(chipInfo), mrtdFileType, function3).m5565a(continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0126 A[Catch: MrtdException -> 0x003a, TryCatch #1 {MrtdException -> 0x003a, blocks: (B:14:0x0035, B:57:0x0121, B:60:0x0126, B:62:0x012c, B:63:0x0131), top: B:85:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0164  */
    /* JADX WARN: Type inference failed for: r14v16, types: [T, com.yoti.mobile.mpp.mrtddump.i.c] */
    /* JADX WARN: Type inference failed for: r14v2, types: [T, com.yoti.mobile.mpp.mrtddump.i.a] */
    /* JADX WARN: Type inference failed for: r14v31, types: [T, com.yoti.mobile.mpp.mrtddump.i.c] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5569a(com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfo r13, kotlin.coroutines.Continuation<? super com.yoti.mobile.mpp.mrtddump.session.MessagingSession> r14) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.reader.MrtdReaderWorker.m5569a(com.yoti.mobile.mpp.mrtddump.f.a, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5570a(kotlin.coroutines.Continuation<? super com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfo> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.yoti.mobile.mpp.mrtddump.reader.MrtdReaderWorker.b
            if (r0 == 0) goto L13
            r0 = r10
            com.yoti.mobile.mpp.mrtddump.reader.c$b r0 = (com.yoti.mobile.mpp.mrtddump.reader.MrtdReaderWorker.b) r0
            int r1 = r0.f8176d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8176d = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.reader.c$b r0 = new com.yoti.mobile.mpp.mrtddump.reader.c$b
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f8174b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8176d
            java.lang.String r3 = "MrtdReaderWorker"
            r4 = 1
            r5 = 2
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r5) goto L2e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L6e
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L36:
            java.lang.Object r2 = r0.f8173a
            com.yoti.mobile.mpp.mrtddump.reader.c r2 = (com.yoti.mobile.mpp.mrtddump.reader.MrtdReaderWorker) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L5a
        L3e:
            kotlin.ResultKt.throwOnFailure(r10)
            int r10 = com.yoti.mobile.mpp.mrtddump.p096j.C5120d.m5539a()
            if (r10 > r5) goto L4c
            java.lang.String r10 = "Connecting to chip"
            com.yoti.mobile.mpp.mrtddump.p096j.C5119c.m5531a(r3, r10)
        L4c:
            com.yoti.mobile.mpp.mrtddump.i.a r10 = r9.f8164a
            r0.f8173a = r9
            r0.f8176d = r4
            java.lang.Object r10 = r10.m5511a(r0)
            if (r10 != r1) goto L59
            return r1
        L59:
            r2 = r9
        L5a:
            com.yoti.mobile.mpp.mrtddump.f.d r10 = r2.f8166c
            com.yoti.mobile.mpp.mrtddump.MrtdReaderConfig r6 = r2.f8165b
            com.yoti.mobile.mpp.mrtddump.i.a r7 = r2.f8164a
            com.yoti.mobile.mpp.mrtddump.g.c r2 = r2.f8167d
            r8 = 0
            r0.f8173a = r8
            r0.f8176d = r5
            java.lang.Object r10 = r10.m5463a(r6, r7, r2, r0)
            if (r10 != r1) goto L6e
            return r1
        L6e:
            r0 = r10
            com.yoti.mobile.mpp.mrtddump.f.a r0 = (com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfo) r0
            int r1 = com.yoti.mobile.mpp.mrtddump.p096j.C5120d.m5539a()
            if (r1 > r4) goto L80
            java.lang.String r1 = "Using chip info: "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)
            com.yoti.mobile.mpp.mrtddump.p096j.C5119c.m5531a(r3, r0)
        L80:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.reader.MrtdReaderWorker.m5570a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
