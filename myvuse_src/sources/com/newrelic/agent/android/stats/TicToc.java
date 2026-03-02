package com.newrelic.agent.android.stats;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class TicToc {
    private long endTime;
    private long startTime;
    private State state;

    protected enum State {
        STOPPED,
        STARTED
    }

    public TicToc tic() {
        this.state = State.STARTED;
        this.startTime = TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
        return this;
    }

    public long toc() {
        this.endTime = TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
        if (this.state != State.STARTED) {
            return -1L;
        }
        this.state = State.STOPPED;
        return this.endTime - this.startTime;
    }

    public long peek() {
        long jConvert = TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
        if (this.state == State.STARTED) {
            return jConvert - this.startTime;
        }
        return 0L;
    }

    protected long getStartTime() {
        return this.startTime;
    }

    protected void setStartTime(long j) {
        this.startTime = j;
    }

    protected long getEndTime() {
        return this.endTime;
    }

    protected void setEndTime(long j) {
        this.endTime = j;
    }

    protected State getState() {
        return this.state;
    }

    protected void setState(State state) {
        this.state = state;
    }

    public long duration() {
        return this.state == State.STARTED ? peek() : System.currentTimeMillis() - this.startTime;
    }
}
