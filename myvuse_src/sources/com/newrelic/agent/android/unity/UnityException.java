package com.newrelic.agent.android.unity;

/* JADX INFO: loaded from: classes6.dex */
public class UnityException extends RuntimeException {
    private String sourceExceptionType;

    public UnityException() {
        this.sourceExceptionType = null;
    }

    public UnityException(String str, String str2) {
        super(str2);
        this.sourceExceptionType = str;
    }

    public UnityException(String str) {
        super(str);
        this.sourceExceptionType = null;
    }

    public UnityException(String str, StackTraceElement[] stackTraceElementArr) {
        super(str);
        this.sourceExceptionType = null;
        setStackTrace(stackTraceElementArr);
    }

    public void appendStackFrame(StackTraceElement stackTraceElement) {
        StackTraceElement[] stackTrace = getStackTrace();
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[stackTrace.length + 1];
        for (int i = 0; i < stackTrace.length; i++) {
            stackTraceElementArr[i] = stackTrace[i];
        }
        stackTraceElementArr[stackTrace.length] = stackTraceElement;
        setStackTrace(stackTraceElementArr);
    }

    public void appendStackFrame(String str, String str2, String str3, int i) {
        StackTraceElement stackTraceElement = new StackTraceElement(str, str2, str3, i);
        StackTraceElement[] stackTrace = getStackTrace();
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[stackTrace.length + 1];
        for (int i2 = 0; i2 < stackTrace.length; i2++) {
            stackTraceElementArr[i2] = stackTrace[i2];
        }
        stackTraceElementArr[stackTrace.length] = stackTraceElement;
        setStackTrace(stackTraceElementArr);
    }

    public void setSourceExceptionType(String str) {
        this.sourceExceptionType = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        String str = this.sourceExceptionType;
        return (str == null || str.isEmpty()) ? getClass().getName() : this.sourceExceptionType;
    }
}
