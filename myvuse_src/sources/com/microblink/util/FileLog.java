package com.microblink.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.webkit.internal.AssetHelper;
import com.android.vending.expansion.zipfile.APEZProvider;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.microblink.blinkid.secured.IIllIllIIl;
import com.microblink.util.Log;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class FileLog implements Log.LogWriter {
    private static String IlIllIlIIl;
    private PrintWriter llIIlIlIIl;

    private FileLog(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            llIIlIlIIl(context);
        } else {
            IlIllIlIIl(context);
        }
    }

    private void IlIllIlIIl(Context context) {
        try {
            File file = new File(getLogFolder(context));
            file.mkdirs();
            this.llIIlIlIIl = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsolutePath() + "/javaLog.txt", true)));
        } catch (IOException e) {
            LogInstrumentation.m2729e("LOG", "Failed to create file writer!", e);
            this.llIIlIlIIl = null;
        }
    }

    public static synchronized void disableFileLogging() {
        FileLog fileLog = (FileLog) Log.getLogWriter();
        if (fileLog != null) {
            synchronized (fileLog) {
                PrintWriter printWriter = fileLog.llIIlIlIIl;
                if (printWriter != null) {
                    printWriter.close();
                    fileLog.llIIlIlIIl = null;
                }
            }
            Log.setLogWriter(null);
        }
    }

    public static synchronized void enableFileLogging(Context context) {
        Log.setLogWriter(new FileLog(context));
    }

    public static synchronized String getLogFolder(Context context) {
        if (IlIllIlIIl == null) {
            IlIllIlIIl = (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory().toString() : context != null ? context.getCacheDir().getAbsolutePath() : Environment.getDataDirectory().getAbsolutePath()) + "/Documents/microblink";
            if (Log.getCurrentLogLevel().ordinal() >= Log.LogLevel.LOG_INFORMATION.ordinal()) {
                LogInstrumentation.m2730i("LOG", IIllIllIIl.llIIlIlIIl("Log folder will be ").append(IlIllIlIIl).toString());
            }
        }
        return IlIllIlIIl;
    }

    private void llIIlIlIIl(Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", "javaLog.txt");
        contentValues.put("mime_type", AssetHelper.DEFAULT_MIME_TYPE);
        contentValues.put("relative_path", "Documents/microblink");
        contentValues.put("is_pending", (Integer) 1);
        ContentResolver contentResolver = context.getContentResolver();
        Uri contentUri = MediaStore.Files.getContentUri("external_primary");
        Uri uriInsert = contentResolver.insert(contentUri, contentValues);
        if (uriInsert == null) {
            Bundle bundle = new Bundle();
            bundle.putString("android:query-arg-sql-selection", "_display_name = ? AND relative_path = ?");
            bundle.putStringArray("android:query-arg-sql-selection-args", new String[]{"javaLog.txt", "Documents/microblink/"});
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                bundle.putInt("android:query-arg-match-pending", 1);
            }
            Cursor cursorQuery = contentResolver.query(i < 30 ? MediaStore.setIncludePending(contentUri) : contentUri, new String[]{APEZProvider.FILEID}, bundle, null);
            if (cursorQuery.getCount() == 1) {
                cursorQuery.moveToFirst();
                uriInsert = Uri.withAppendedPath(contentUri, cursorQuery.getString(0));
            }
            cursorQuery.close();
        }
        try {
            this.llIIlIlIIl = new PrintWriter(new BufferedWriter(new OutputStreamWriter(contentResolver.openOutputStream(uriInsert))));
        } catch (FileNotFoundException e) {
            LogInstrumentation.m2729e("LOG", "Failed to create file writer!", e);
            this.llIIlIlIIl = null;
        } finally {
            contentValues.clear();
            contentValues.put("is_pending", (Integer) 0);
            contentResolver.update(uriInsert, contentValues, null, null);
        }
    }

    @Override // com.microblink.util.Log.LogWriter
    public void writeLog(String str, String str2, String str3, Throwable th) {
        synchronized (this) {
            PrintWriter printWriter = this.llIIlIlIIl;
            if (printWriter != null) {
                printWriter.write(str);
                Timestamp timestamp = new Timestamp(new Date().getTime());
                this.llIIlIlIIl.write(" (");
                this.llIIlIlIIl.write(timestamp.toString());
                this.llIIlIlIIl.write(") [");
                this.llIIlIlIIl.write(str2);
                this.llIIlIlIIl.write("] ");
                this.llIIlIlIIl.write(str3);
                this.llIIlIlIIl.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                if (th != null) {
                    th.printStackTrace(this.llIIlIlIIl);
                }
                this.llIIlIlIIl.flush();
            }
        }
    }
}
