package com.newrelic.agent.android.hybrid;

import com.newrelic.agent.android.hybrid.rninterface.IStackFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class StackFrame implements IStackFrame {
    private static final Pattern STACK_FRAME_PATTERN1 = Pattern.compile("^(?:(.*?)@)?(.*?)\\:([0-9]+)\\:([0-9]+)$");
    private static final Pattern STACK_FRAME_PATTERN2 = Pattern.compile("\\s*(?:at)\\s*(.+?)\\s*[@(](.*):([0-9]+):([0-9]+)[)]$");
    private int column;
    private String fileName;
    private int line;
    private String method;
    private final String rawJsLine;

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStackFrame
    public String getClassName() {
        return null;
    }

    StackFrame(String str) {
        this.rawJsLine = str.trim();
        parseRawJS();
    }

    private void parseRawJS() {
        Matcher matcher = STACK_FRAME_PATTERN1.matcher(this.rawJsLine);
        Matcher matcher2 = STACK_FRAME_PATTERN2.matcher(this.rawJsLine);
        if (matcher2.find()) {
            matcher = matcher2;
        } else if (!matcher.find()) {
            this.fileName = null;
            this.method = this.rawJsLine;
            this.line = -1;
            this.column = -1;
            return;
        }
        this.fileName = matcher.group(2);
        this.method = matcher.group(1) == null ? "(unknown)" : matcher.group(1);
        this.line = Integer.parseInt(matcher.group(3));
        this.column = Integer.parseInt(matcher.group(4));
    }

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStackFrame
    public String getMethodName() {
        return this.method;
    }

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStackFrame
    public String getFileName() {
        return this.fileName;
    }

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStackFrame
    public String getRawSourceLine() {
        return this.rawJsLine;
    }

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStackFrame
    public int getLineNumber() {
        return this.line;
    }

    @Override // com.newrelic.agent.android.hybrid.rninterface.IStackFrame
    public int getColumnNumber() {
        return this.column;
    }
}
