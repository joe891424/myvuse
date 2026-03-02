package com.newrelic.agent.android.aei;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes6.dex */
public class AEITrace {
    static final Pattern TRACE_HEADER_REGEXP = Pattern.compile(".*----- pid (?<pid>.\\d+) at (?<timeCreated>\\d{4}-\\d{2}-\\d{2}[T ]{0,}[0-9:.-]+) -----(?<body>.*$)");
    static final Pattern TRACE_THREADS_REGEXP = Pattern.compile(".*DALVIK THREADS \\((?<threadCnt>\\d+)\\):\\s(.*)----- end (\\d+) -----", 8);
    static final Pattern TRACE_THREAD_ID_REGEXP = Pattern.compile("^\"(?<threadName>.*)\" (.*)prio=(\\d+).*$");
    String createTime;
    String pid;
    final ArrayList<String> threads;

    public AEITrace() {
        this.threads = new ArrayList<>();
    }

    public AEITrace(File file) {
        this();
    }

    public AEITrace(int i, File file) {
        this(file);
        this.pid = String.valueOf(i);
    }

    public AEITrace decomposeFromSystemTrace(String str) {
        String strReplace = AEITrace$$ExternalSyntheticBackport0.m2717m(str).replace('\n', '\t');
        Matcher matcher = TRACE_HEADER_REGEXP.matcher(strReplace);
        if (matcher.matches()) {
            String str2 = this.pid;
            if (str2 == null || AEITrace$$ExternalSyntheticBackport0.m2721m(str2)) {
                this.pid = matcher.group(1);
            }
            this.createTime = AEITrace$$ExternalSyntheticBackport0.m2717m(matcher.group(2));
        } else {
            AgentLogManager.getAgentLog().debug("The trace file does not contain the expected file header.");
        }
        Matcher matcher2 = TRACE_THREADS_REGEXP.matcher(strReplace);
        if (matcher2.matches()) {
            parseThreadsData(AEITrace$$ExternalSyntheticBackport0.m2717m(matcher2.group(2)));
        } else {
            AgentLogManager.getAgentLog().error("The trace file does not contain the expected threads data.");
        }
        return this;
    }

    private ArrayList<String> parseThreadsData(String str) {
        if (str != null && !str.isEmpty()) {
            this.threads.addAll(AEITrace$$ExternalSyntheticBackport0.m2718m((Object[]) str.split("\t\t")));
            this.threads.removeIf(new Predicate() { // from class: com.newrelic.agent.android.aei.AEITrace$$ExternalSyntheticLambda2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return AEITrace.lambda$parseThreadsData$0((String) obj);
                }
            });
            this.threads.replaceAll(new UnaryOperator() { // from class: com.newrelic.agent.android.aei.AEITrace$$ExternalSyntheticLambda3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return AEITrace.lambda$parseThreadsData$2((String) obj);
                }
            });
        }
        return this.threads;
    }

    static /* synthetic */ boolean lambda$parseThreadsData$0(String str) {
        return !TRACE_THREAD_ID_REGEXP.matcher(str).matches();
    }

    static /* synthetic */ String lambda$parseThreadsData$2(String str) {
        return (String) Arrays.stream(str.split("\t")).filter(new Predicate() { // from class: com.newrelic.agent.android.aei.AEITrace$$ExternalSyntheticLambda4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AEITrace.lambda$parseThreadsData$1((String) obj);
            }
        }).collect(Collectors.joining(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE));
    }

    static /* synthetic */ boolean lambda$parseThreadsData$1(String str) {
        return !str.trim().matches("[(|-].*");
    }

    public ArrayList<String> getThreads() {
        return this.threads;
    }

    public String getPid() {
        return this.pid;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String toString() {
        return (String) this.threads.stream().collect(Collectors.joining("\n\n"));
    }
}
