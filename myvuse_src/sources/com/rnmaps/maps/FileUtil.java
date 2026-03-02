package com.rnmaps.maps;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.react.common.ReactConstants;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes6.dex */
public class FileUtil extends AsyncTask<String, Void, InputStream> implements TraceFieldInterface {
    public Trace _nr_trace;
    private Context context;

    @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ InputStream doInBackground(String[] strArr) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "FileUtil#doInBackground", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "FileUtil#doInBackground", null);
        }
        InputStream inputStreamDoInBackground2 = doInBackground2(strArr);
        TraceMachine.exitMethod();
        return inputStreamDoInBackground2;
    }

    public FileUtil(Context context) {
        this.context = context;
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected InputStream doInBackground2(String... strArr) {
        try {
            Uri uri = Uri.parse(strArr[0]);
            if (uri.getScheme().startsWith("http")) {
                return getDownloadFileInputStream(this.context, uri);
            }
            return this.context.getContentResolver().openInputStream(uri);
        } catch (Exception e) {
            FLog.m1278e(ReactConstants.TAG, "Could not retrieve file for contentUri " + strArr[0], e);
            return null;
        }
    }

    private InputStream getDownloadFileInputStream(Context context, Uri uri) throws IOException {
        File fileCreateTempFile = File.createTempFile("FileUtil", "temp", context.getApplicationContext().getCacheDir());
        fileCreateTempFile.deleteOnExit();
        InputStream inputStreamOpenStream = FirebasePerfUrlConnection.openStream(new URL(uri.toString()));
        try {
            ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(inputStreamOpenStream);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    fileOutputStream.getChannel().transferFrom(readableByteChannelNewChannel, 0L, Long.MAX_VALUE);
                    return new FileInputStream(fileCreateTempFile);
                } finally {
                    fileOutputStream.close();
                }
            } finally {
                readableByteChannelNewChannel.close();
            }
        } finally {
            inputStreamOpenStream.close();
        }
    }
}
