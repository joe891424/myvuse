package com.newrelic.agent.android.instrumentation.p045io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
class StreamCompleteListenerManager {
    private boolean streamComplete = false;
    private ArrayList<StreamCompleteListener> streamCompleteListeners = new ArrayList<>();

    StreamCompleteListenerManager() {
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this) {
            z = this.streamComplete;
        }
        return z;
    }

    public void addStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        synchronized (this.streamCompleteListeners) {
            this.streamCompleteListeners.add(streamCompleteListener);
        }
    }

    public void removeStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        synchronized (this.streamCompleteListeners) {
            this.streamCompleteListeners.remove(streamCompleteListener);
        }
    }

    public void notifyStreamComplete(StreamCompleteEvent streamCompleteEvent) {
        if (checkComplete()) {
            return;
        }
        Iterator<StreamCompleteListener> it2 = getStreamCompleteListeners().iterator();
        while (it2.hasNext()) {
            it2.next().streamComplete(streamCompleteEvent);
        }
    }

    public void notifyStreamError(StreamCompleteEvent streamCompleteEvent) {
        if (checkComplete()) {
            return;
        }
        Iterator<StreamCompleteListener> it2 = getStreamCompleteListeners().iterator();
        while (it2.hasNext()) {
            it2.next().streamError(streamCompleteEvent);
        }
    }

    private boolean checkComplete() {
        boolean zIsComplete;
        synchronized (this) {
            zIsComplete = isComplete();
            if (!zIsComplete) {
                this.streamComplete = true;
            }
        }
        return zIsComplete;
    }

    private List<StreamCompleteListener> getStreamCompleteListeners() {
        ArrayList arrayList;
        synchronized (this.streamCompleteListeners) {
            arrayList = new ArrayList(this.streamCompleteListeners);
            this.streamCompleteListeners.clear();
        }
        return arrayList;
    }
}
