package com.newrelic.agent.android.stores;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SharedPrefsStore {
    protected final SharedPreferences sharedPrefs;
    protected final String storeFilename;
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    protected static final Charset ENCODING = Charset.forName(InternalZipConstants.AES_HASH_CHARSET);

    public SharedPrefsStore(Context context, String str) {
        this.sharedPrefs = context.getSharedPreferences(str, 0);
        this.storeFilename = str;
    }

    public String getStoreFilename() {
        return this.storeFilename;
    }

    public boolean store(String str, byte[] bArr) {
        try {
            SharedPreferences.Editor editorEdit = this.sharedPrefs.edit();
            editorEdit.putString(str, decodeBytesToString(bArr));
            return applyOrCommitEditor(editorEdit);
        } catch (Exception e) {
            log.error("SharedPrefsStore.store(String, byte[]): ", e);
            return false;
        }
    }

    public boolean store(String str, Set<String> set) {
        try {
            SharedPreferences.Editor editorEdit = this.sharedPrefs.edit();
            editorEdit.putStringSet(str, set);
            return applyOrCommitEditor(editorEdit);
        } catch (Exception e) {
            log.error("SharedPrefsStore.store(String, Set<String>): ", e);
            return false;
        }
    }

    public boolean store(String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = this.sharedPrefs.edit();
            editorEdit.putString(str, str2);
            return applyOrCommitEditor(editorEdit);
        } catch (Exception e) {
            log.error("SharedPrefsStore.store(String, String): ", e);
            return false;
        }
    }

    public List<?> fetchAll() {
        ArrayList arrayList = new ArrayList();
        try {
            synchronized (this) {
                arrayList.addAll(this.sharedPrefs.getAll().values());
            }
        } catch (Exception e) {
            log.error("SharedPrefsStore.fetchAll(): ", e);
        }
        return arrayList;
    }

    public int count() {
        int size;
        try {
            synchronized (this.sharedPrefs) {
                size = this.sharedPrefs.getAll().size();
            }
            return size;
        } catch (Exception e) {
            log.error("SharedPrefsStore.count(): ", e);
            return 0;
        }
    }

    public void clear() {
        try {
            synchronized (this) {
                SharedPreferences.Editor editorEdit = this.sharedPrefs.edit();
                editorEdit.clear();
                applyOrCommitEditor(editorEdit);
            }
        } catch (Exception e) {
            log.error("SharedPrefsStore.clear(): ", e);
        }
    }

    public void delete(String str) {
        try {
            synchronized (this) {
                SharedPreferences.Editor editorEdit = this.sharedPrefs.edit();
                editorEdit.remove(str);
                applyOrCommitEditor(editorEdit);
            }
        } catch (Exception e) {
            log.error("SharedPrefsStore.delete(): ", e);
        }
    }

    protected String encodeBytes(byte[] bArr) {
        try {
            return Base64.encodeToString(bArr, 2);
        } catch (Exception e) {
            log.error("SharedPrefsStore.encodeBytes(byte[]): ", e);
            return null;
        }
    }

    protected byte[] decodeStringToBytes(String str) {
        try {
            return Base64.decode(str, 0);
        } catch (Exception e) {
            log.error("SharedPrefsStore.decodeStringToBytes(String): ", e);
            return null;
        }
    }

    protected String decodeBytesToString(byte[] bArr) {
        try {
            return new String(bArr, ENCODING);
        } catch (Exception e) {
            log.error("SharedPrefsStore.decodeBytesToString(byte[]): ", e);
            return null;
        }
    }

    protected boolean applyOrCommitEditor(SharedPreferences.Editor editor) {
        try {
            editor.apply();
            return true;
        } catch (Exception e) {
            log.error("SharedPrefsStore.applyOrCommitEditor(SharedPreferences.Editor): ", e);
            return true;
        }
    }
}
