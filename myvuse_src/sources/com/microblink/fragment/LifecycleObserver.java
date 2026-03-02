package com.microblink.fragment;

import android.content.res.Configuration;
import android.os.Bundle;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface LifecycleObserver {
    void onConfigurationChanged(Configuration configuration);

    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();
}
