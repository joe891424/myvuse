package com.newrelic.agent.android.rum.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import com.newrelic.agent.android.rum.AppApplicationLifeCycle;
import com.newrelic.agent.android.rum.AppTracer;

/* JADX INFO: loaded from: classes6.dex */
public class NewRelicAppContentProvider extends ContentProvider {
    AppApplicationLifeCycle appApplicationLifeCycle = new AppApplicationLifeCycle();

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        AppTracer.getInstance().setContentProviderStartedTime(Long.valueOf(SystemClock.uptimeMillis()));
        Context context = getContext();
        if (context == null) {
            return false;
        }
        this.appApplicationLifeCycle.onColdStartInitiated(context);
        return true;
    }
}
