package com.newrelic.agent.android.hybrid;

import com.newrelic.agent.android.hybrid.rninterface.IStack;
import com.newrelic.agent.android.hybrid.rninterface.IStackFrame;
import java.util.UUID;

/* JADX INFO: loaded from: classes6.dex */
public class Stack implements IStack {

    /* JADX INFO: renamed from: id */
    private final String f4040id = UUID.randomUUID().toString();
    private StackFrame[] stackFrames;

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStack
    public boolean isThrowingThread() {
        return true;
    }

    Stack(StackFrame[] stackFrameArr) {
        this.stackFrames = stackFrameArr;
    }

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStack
    public String getId() {
        return this.f4040id;
    }

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStack
    public IStackFrame[] getStackFrames() {
        return this.stackFrames;
    }
}
