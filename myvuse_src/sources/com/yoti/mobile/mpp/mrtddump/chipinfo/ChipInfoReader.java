package com.yoti.mobile.mpp.mrtddump.chipinfo;

import com.yoti.mobile.mpp.mrtddump.ExtendedLengthSetting;
import com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.f.d, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ChipInfoReader;", "", "generator", "Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ChipInfoGenerator;", "readerFactory", "Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileReader$Factory;", "(Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ChipInfoGenerator;Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileReader$Factory;)V", "read", "Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ChipInfo;", "config", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderConfig;", "session", "Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;", "commandGeneratorFactory", "Lcom/yoti/mobile/mpp/mrtddump/commands/CommandGeneratorFactory;", "(Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderConfig;Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession;Lcom/yoti/mobile/mpp/mrtddump/commands/CommandGeneratorFactory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ChipInfoReader {

    /* JADX INFO: renamed from: a */
    private final ChipInfoGenerator f8047a;

    /* JADX INFO: renamed from: b */
    private final MrtdFileReader.a f8048b;

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.f.d$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f8049a;

        static {
            int[] iArr = new int[ExtendedLengthSetting.values().length];
            iArr[ExtendedLengthSetting.DISABLE.ordinal()] = 1;
            iArr[ExtendedLengthSetting.FORCE.ordinal()] = 2;
            iArr[ExtendedLengthSetting.DEFAULT.ordinal()] = 3;
            f8049a = iArr;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.f.d$b */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfoReader", m5608f = "ChipInfoReader.kt", m5609i = {0, 0}, m5610l = {34}, m5611m = "read", m5612n = {"this", "config"}, m5613s = {"L$0", "L$1"})
    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f8050a;

        /* JADX INFO: renamed from: b */
        Object f8051b;

        /* JADX INFO: renamed from: c */
        /* synthetic */ Object f8052c;

        /* JADX INFO: renamed from: e */
        int f8054e;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f8052c = obj;
            this.f8054e |= Integer.MIN_VALUE;
            return ChipInfoReader.this.m5463a(null, null, null, this);
        }
    }

    public ChipInfoReader(ChipInfoGenerator generator, MrtdFileReader.a readerFactory) {
        Intrinsics.checkNotNullParameter(generator, "generator");
        Intrinsics.checkNotNullParameter(readerFactory, "readerFactory");
        this.f8047a = generator;
        this.f8048b = readerFactory;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5463a(com.yoti.mobile.mpp.mrtddump.MrtdReaderConfig r6, com.yoti.mobile.mpp.mrtddump.session.MessagingSession r7, com.yoti.mobile.mpp.mrtddump.commands.CommandGeneratorFactory r8, kotlin.coroutines.Continuation<? super com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfo> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfoReader.b
            if (r0 == 0) goto L13
            r0 = r9
            com.yoti.mobile.mpp.mrtddump.f.d$b r0 = (com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfoReader.b) r0
            int r1 = r0.f8054e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8054e = r1
            goto L18
        L13:
            com.yoti.mobile.mpp.mrtddump.f.d$b r0 = new com.yoti.mobile.mpp.mrtddump.f.d$b
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f8052c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8054e
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.f8051b
            com.yoti.mobile.mpp.mrtddump.MrtdReaderConfig r6 = (com.yoti.mobile.mpp.mrtddump.MrtdReaderConfig) r6
            java.lang.Object r7 = r0.f8050a
            com.yoti.mobile.mpp.mrtddump.f.d r7 = (com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfoReader) r7
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdException -> L31
            goto L73
        L31:
            r8 = move-exception
            goto L7e
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.ResultKt.throwOnFailure(r9)
            com.yoti.mobile.mpp.mrtddump.ExtendedLengthSetting r9 = r6.getExtendedLengthSupport()
            int[] r2 = com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfoReader.a.f8049a
            int r9 = r9.ordinal()
            r9 = r2[r9]
            if (r9 == r3) goto La0
            r2 = 2
            if (r9 == r2) goto L99
            r2 = 3
            if (r9 != r2) goto L93
            com.yoti.mobile.mpp.mrtddump.f.b r9 = r5.f8047a     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdException -> L7c
            com.yoti.mobile.mpp.mrtddump.f.a r9 = r9.m5455a(r6)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdException -> L7c
            com.yoti.mobile.mpp.mrtddump.g.f r8 = r8.m5477a(r9)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdException -> L7c
            com.yoti.mobile.mpp.mrtddump.reader.b$a r9 = r5.f8048b     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdException -> L7c
            com.yoti.mobile.mpp.mrtddump.reader.f r2 = com.yoti.mobile.mpp.mrtddump.reader.TransparentFileType.EF_ATR     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdException -> L7c
            r4 = 0
            com.yoti.mobile.mpp.mrtddump.reader.b r7 = r9.m5567a(r7, r8, r2, r4)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdException -> L7c
            r0.f8050a = r5     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdException -> L7c
            r0.f8051b = r6     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdException -> L7c
            r0.f8054e = r3     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdException -> L7c
            java.lang.Object r9 = r7.m5565a(r0)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdException -> L7c
            if (r9 != r1) goto L72
            return r1
        L72:
            r7 = r5
        L73:
            byte[] r9 = (byte[]) r9     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdException -> L31
            com.yoti.mobile.mpp.mrtddump.f.b r8 = r7.f8047a     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdException -> L31
            com.yoti.mobile.mpp.mrtddump.f.a r6 = r8.m5456a(r9, r6)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdException -> L31
            return r6
        L7c:
            r8 = move-exception
            r7 = r5
        L7e:
            int r9 = com.yoti.mobile.mpp.mrtddump.p096j.C5120d.m5539a()
            r0 = 4
            if (r9 > r0) goto L8c
            java.lang.String r9 = "Unable to read ATR"
            java.lang.String r0 = "ChipInfoReader"
            com.yoti.mobile.mpp.mrtddump.p096j.C5119c.m5538d(r0, r9, r8)
        L8c:
            com.yoti.mobile.mpp.mrtddump.f.b r7 = r7.f8047a
            com.yoti.mobile.mpp.mrtddump.f.a r6 = r7.m5455a(r6)
            return r6
        L93:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L99:
            com.yoti.mobile.mpp.mrtddump.f.b r6 = r5.f8047a
            com.yoti.mobile.mpp.mrtddump.f.a r6 = r6.m5454a()
            return r6
        La0:
            com.yoti.mobile.mpp.mrtddump.f.b r7 = r5.f8047a
            com.yoti.mobile.mpp.mrtddump.f.a r6 = r7.m5455a(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfoReader.m5463a(com.yoti.mobile.mpp.mrtddump.MrtdReaderConfig, com.yoti.mobile.mpp.mrtddump.i.a, com.yoti.mobile.mpp.mrtddump.g.c, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
