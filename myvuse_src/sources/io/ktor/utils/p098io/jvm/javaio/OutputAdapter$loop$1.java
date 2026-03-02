package io.ktor.utils.p098io.jvm.javaio;

import kotlin.Metadata;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: Blocking.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, m5598d2 = {"io/ktor/utils/io/jvm/javaio/OutputAdapter$loop$1", "Lio/ktor/utils/io/jvm/javaio/BlockingAdapter;", "loop", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class OutputAdapter$loop$1 extends BlockingAdapter {
    final /* synthetic */ Job $parent;
    final /* synthetic */ OutputAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OutputAdapter$loop$1(OutputAdapter outputAdapter, Job job) {
        super(job);
        this.this$0 = outputAdapter;
        this.$parent = job;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c5 A[Catch: all -> 0x0045, TRY_ENTER, TryCatch #0 {all -> 0x0045, blocks: (B:13:0x002d, B:23:0x004c, B:24:0x0060, B:26:0x0066, B:30:0x0077, B:32:0x007f, B:34:0x0083, B:35:0x008f, B:37:0x0099, B:40:0x00a2, B:50:0x00c5, B:52:0x00cb, B:55:0x00e2, B:56:0x00e3, B:58:0x00e7, B:27:0x006d, B:29:0x0073, B:61:0x0105, B:62:0x010c, B:18:0x0041), top: B:75:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int, io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1] */
    /* JADX WARN: Type inference failed for: r7v1, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00e0 -> B:23:0x004c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00e5 -> B:23:0x004c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0102 -> B:23:0x004c). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.p098io.jvm.javaio.BlockingAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Object loop(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.jvm.javaio.OutputAdapter$loop$1.loop(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
