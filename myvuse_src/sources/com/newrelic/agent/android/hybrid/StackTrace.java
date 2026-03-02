package com.newrelic.agent.android.hybrid;

import com.facebook.react.common.ReactConstants;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.newrelic.agent.android.hybrid.rninterface.IStack;
import com.newrelic.agent.android.hybrid.rninterface.IStackTrace;
import com.newrelic.agent.android.hybrid.rninterface.IStackTraceException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes6.dex */
public class StackTrace extends Throwable implements IStackTrace {
    private Map<String, Object> attributes;
    private final String buildId;
    private final boolean isFatal;
    private final IStackTraceException rnStackTraceException;
    private IStack[] rnStacks;
    private final UUID stackId;

    public StackTrace(String str, String str2, String str3, boolean z, String str4) {
        this(str, str2, str3, z, str4, null);
    }

    public StackTrace(String str, String str2, String str3, boolean z, String str4, Map<String, Object> map) {
        this.rnStacks = null;
        this.attributes = new HashMap();
        if (str3 == null || str3.isEmpty()) {
            throw new IllegalArgumentException("Cannot create a RNStackTrace without a stack.");
        }
        this.stackId = UUID.randomUUID();
        this.isFatal = z;
        this.buildId = str4;
        if (map != null) {
            this.attributes = map;
        }
        String[] strArrSplit = str3.split(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        this.rnStackTraceException = new StackTraceException((str == null || str.isEmpty()) ? str3.split(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)[0] : str, (str2 == null || str2.isEmpty()) ? str3.split(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)[0] : str2);
        int length = strArrSplit.length;
        int i = length - 1;
        if (i > 0) {
            StackFrame[] stackFrameArr = new StackFrame[i];
            for (int i2 = 1; i2 < length; i2++) {
                stackFrameArr[i2 - 1] = new StackFrame(strArrSplit[i2]);
            }
            this.rnStacks = new Stack[]{new Stack(stackFrameArr)};
        }
    }

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStackTrace
    public String getStackId() {
        return this.stackId.toString();
    }

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStackTrace
    public String getStackType() {
        return ReactConstants.TAG;
    }

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStackTrace
    public boolean isFatal() {
        return this.isFatal;
    }

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStackTrace
    public IStack[] getStacks() {
        return this.rnStacks;
    }

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStackTrace
    public IStackTraceException getStackTraceException() {
        return this.rnStackTraceException;
    }

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStackTrace
    public String getBuildId() {
        return this.buildId;
    }

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStackTrace
    public Map<String, Object> getCustomAttributes() {
        return this.attributes;
    }
}
