package io.ktor.utils.p098io.core;

import kotlin.Metadata;

/* JADX INFO: compiled from: BufferSharedStateJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\u0004¨\u0006\u0016"}, m5598d2 = {"Lio/ktor/utils/io/core/BufferSharedState;", "", "limit", "", "(I)V", "attachment", "getAttachment", "()Ljava/lang/Object;", "setAttachment", "(Ljava/lang/Object;)V", "getLimit", "()I", "setLimit", "readPosition", "getReadPosition", "setReadPosition", "startGap", "getStartGap", "setStartGap", "writePosition", "getWritePosition", "setWritePosition", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class BufferSharedState {
    private Object attachment;
    private int limit;
    private int readPosition;
    private int startGap;
    private int writePosition;

    public BufferSharedState(int i) {
        this.limit = i;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final void setLimit(int i) {
        this.limit = i;
    }

    public final int getReadPosition() {
        return this.readPosition;
    }

    public final void setReadPosition(int i) {
        this.readPosition = i;
    }

    public final int getWritePosition() {
        return this.writePosition;
    }

    public final void setWritePosition(int i) {
        this.writePosition = i;
    }

    public final int getStartGap() {
        return this.startGap;
    }

    public final void setStartGap(int i) {
        this.startGap = i;
    }

    public final Object getAttachment() {
        return this.attachment;
    }

    public final void setAttachment(Object obj) {
        this.attachment = obj;
    }
}
