package com.newrelic.agent.android.measurement;

/* JADX INFO: loaded from: classes6.dex */
public class ThreadInfo {

    /* JADX INFO: renamed from: id */
    private long f4042id;
    private String name;

    public ThreadInfo() {
        this(Thread.currentThread());
    }

    public ThreadInfo(long j, String str) {
        this.f4042id = j;
        this.name = str;
    }

    public ThreadInfo(Thread thread) {
        this(thread.getId(), thread.getName());
    }

    public static ThreadInfo fromThread(Thread thread) {
        return new ThreadInfo(thread);
    }

    public long getId() {
        return this.f4042id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(long j) {
        this.f4042id = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "ThreadInfo{id=" + this.f4042id + ", name='" + this.name + "'}";
    }
}
