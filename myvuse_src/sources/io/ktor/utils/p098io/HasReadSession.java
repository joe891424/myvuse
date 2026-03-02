package io.ktor.utils.p098io;

import kotlin.Metadata;

/* JADX INFO: compiled from: ReadSession.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m5598d2 = {"Lio/ktor/utils/io/HasReadSession;", "", "endReadSession", "", "startReadSession", "Lio/ktor/utils/io/SuspendableReadSession;", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public interface HasReadSession {
    void endReadSession();

    SuspendableReadSession startReadSession();
}
