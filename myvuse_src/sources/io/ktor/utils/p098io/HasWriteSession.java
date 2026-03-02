package io.ktor.utils.p098io;

import kotlin.Metadata;

/* JADX INFO: compiled from: WriterSession.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m5598d2 = {"Lio/ktor/utils/io/HasWriteSession;", "", "beginWriteSession", "Lio/ktor/utils/io/WriterSuspendSession;", "endWriteSession", "", "written", "", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public interface HasWriteSession {
    WriterSuspendSession beginWriteSession();

    void endWriteSession(int written);
}
