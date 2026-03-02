package io.ktor.utils.p098io;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: Coroutines.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m5598d2 = {"Lio/ktor/utils/io/ReaderJob;", "Lkotlinx/coroutines/Job;", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "getChannel", "()Lio/ktor/utils/io/ByteWriteChannel;", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public interface ReaderJob extends Job {
    ByteWriteChannel getChannel();

    /* JADX INFO: compiled from: Coroutines.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public static /* synthetic */ void cancel(ReaderJob readerJob) {
            Intrinsics.checkNotNullParameter(readerJob, "this");
            readerJob.cancel((CancellationException) null);
        }

        public static <R> R fold(ReaderJob readerJob, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            Intrinsics.checkNotNullParameter(readerJob, "this");
            Intrinsics.checkNotNullParameter(operation, "operation");
            return (R) Job.DefaultImpls.fold(readerJob, r, operation);
        }

        public static <E extends CoroutineContext.Element> E get(ReaderJob readerJob, CoroutineContext.Key<E> key) {
            Intrinsics.checkNotNullParameter(readerJob, "this");
            Intrinsics.checkNotNullParameter(key, "key");
            return (E) Job.DefaultImpls.get(readerJob, key);
        }

        public static CoroutineContext minusKey(ReaderJob readerJob, CoroutineContext.Key<?> key) {
            Intrinsics.checkNotNullParameter(readerJob, "this");
            Intrinsics.checkNotNullParameter(key, "key");
            return Job.DefaultImpls.minusKey(readerJob, key);
        }

        public static CoroutineContext plus(ReaderJob readerJob, CoroutineContext context) {
            Intrinsics.checkNotNullParameter(readerJob, "this");
            Intrinsics.checkNotNullParameter(context, "context");
            return Job.DefaultImpls.plus(readerJob, context);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static Job plus(ReaderJob readerJob, Job other) {
            Intrinsics.checkNotNullParameter(readerJob, "this");
            Intrinsics.checkNotNullParameter(other, "other");
            return Job.DefaultImpls.plus((Job) readerJob, other);
        }
    }
}
