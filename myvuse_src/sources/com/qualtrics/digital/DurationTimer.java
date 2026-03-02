package com.qualtrics.digital;

import java.util.Calendar;

/* JADX INFO: loaded from: classes6.dex */
public class DurationTimer {
    private static DurationTimer mDurationTimer;
    private long mStartSeconds;

    private DurationTimer() {
    }

    public static DurationTimer instance() {
        if (mDurationTimer == null) {
            mDurationTimer = new DurationTimer();
        }
        return mDurationTimer;
    }

    private long getCurrentTimeInSeconds() {
        return Calendar.getInstance().getTimeInMillis() / 1000;
    }

    public long getElapsedSeconds() {
        return getCurrentTimeInSeconds() - this.mStartSeconds;
    }

    double getElapsedMinutes() {
        return getElapsedSeconds() / 60.0d;
    }

    double getElapsedHours() {
        return getElapsedMinutes() / 60.0d;
    }

    public void start() {
        this.mStartSeconds = getCurrentTimeInSeconds();
    }
}
