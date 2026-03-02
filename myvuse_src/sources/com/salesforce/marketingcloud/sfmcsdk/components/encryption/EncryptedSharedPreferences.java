package com.salesforce.marketingcloud.sfmcsdk.components.encryption;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Pair;
import androidx.collection.ArraySet;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public final class EncryptedSharedPreferences implements SharedPreferences {
    private static final int BYTE_BYTES = 1;
    private static final int FLOAT_BYTES = 4;
    private static final int INTEGER_BYTES = 4;
    private static final String KEY_IV = "__iv__";
    private static final int LONG_BYTES = 8;
    private static final String NULL_VALUE = "__NULL__";
    final String mEncryptionKey;
    final String mFileName;
    final SharedPreferences mSharedPreferences;
    final List<SharedPreferences.OnSharedPreferenceChangeListener> mListeners = new ArrayList();

    /* JADX INFO: renamed from: iv */
    final byte[] f5546iv = generateKeyIv();

    private EncryptedSharedPreferences(String str, SharedPreferences sharedPreferences, String str2) throws NoSuchAlgorithmException {
        this.mFileName = str;
        this.mSharedPreferences = sharedPreferences;
        this.mEncryptionKey = str2;
    }

    public static SharedPreferences create(Context context, String str, String str2) throws NoSuchAlgorithmException {
        return new EncryptedSharedPreferences(str, context.getApplicationContext().getSharedPreferences(str, 0), str2);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : this.mSharedPreferences.getAll().entrySet()) {
            if (!isReservedKey(entry.getKey())) {
                String strDecryptKey = decryptKey(entry.getKey());
                map.put(strDecryptKey, getDecryptedObject(strDecryptKey));
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof String)) ? str2 : (String) decryptedObject;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> arraySet;
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject instanceof Set) {
            arraySet = (Set) decryptedObject;
        } else {
            arraySet = new ArraySet<>();
        }
        return arraySet.size() > 0 ? arraySet : set;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Integer)) ? i : ((Integer) decryptedObject).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Long)) ? j : ((Long) decryptedObject).longValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Float)) ? f : ((Float) decryptedObject).floatValue();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Boolean)) ? z : ((Boolean) decryptedObject).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (isReservedKey(str)) {
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
        return this.mSharedPreferences.contains(encryptKey(str));
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new Editor(this, this.mSharedPreferences.edit());
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mListeners.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mListeners.remove(onSharedPreferenceChangeListener);
    }

    private Object getDecryptedObject(String str) {
        if (isReservedKey(str)) {
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
        if (str == null) {
            str = NULL_VALUE;
        }
        String string = this.mSharedPreferences.getString(encryptKey(str), null);
        if (string == null) {
            return null;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(decryptValue(string));
        byteBufferWrap.position(0);
        switch (C43191.f5547xf2769dc2[EncryptedType.fromId(byteBufferWrap.getInt()).ordinal()]) {
            case 1:
                int i = byteBufferWrap.getInt();
                ByteBuffer byteBufferSlice = byteBufferWrap.slice();
                byteBufferWrap.limit(i);
                String string2 = StandardCharsets.UTF_8.decode(byteBufferSlice).toString();
                if (string2.equals(NULL_VALUE)) {
                    return null;
                }
                return string2;
            case 2:
                return Integer.valueOf(byteBufferWrap.getInt());
            case 3:
                return Long.valueOf(byteBufferWrap.getLong());
            case 4:
                return Float.valueOf(byteBufferWrap.getFloat());
            case 5:
                return Boolean.valueOf(byteBufferWrap.get() != 0);
            case 6:
                ArraySet arraySet = new ArraySet();
                while (byteBufferWrap.hasRemaining()) {
                    int i2 = byteBufferWrap.getInt();
                    ByteBuffer byteBufferSlice2 = byteBufferWrap.slice();
                    byteBufferSlice2.limit(i2);
                    byteBufferWrap.position(byteBufferWrap.position() + i2);
                    arraySet.add(StandardCharsets.UTF_8.decode(byteBufferSlice2).toString());
                }
                if (arraySet.size() == 1 && NULL_VALUE.equals(arraySet.valueAt(0))) {
                    return null;
                }
                return arraySet;
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.sfmcsdk.components.encryption.EncryptedSharedPreferences$1 */
    static /* synthetic */ class C43191 {

        /* JADX INFO: renamed from: $SwitchMap$com$salesforce$marketingcloud$sfmcsdk$components$encryption$EncryptedSharedPreferences$EncryptedType */
        static final /* synthetic */ int[] f5547xf2769dc2;

        static {
            int[] iArr = new int[EncryptedType.values().length];
            f5547xf2769dc2 = iArr;
            try {
                iArr[EncryptedType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5547xf2769dc2[EncryptedType.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5547xf2769dc2[EncryptedType.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5547xf2769dc2[EncryptedType.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5547xf2769dc2[EncryptedType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5547xf2769dc2[EncryptedType.STRING_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String encryptKey(String str) {
        if (str == null) {
            str = NULL_VALUE;
        }
        return Encryptor.encrypt(str, this.mEncryptionKey, this.f5546iv);
    }

    private String decryptKey(String str) {
        String strDecrypt = Encryptor.decrypt(str, this.mEncryptionKey);
        if (strDecrypt.equals(NULL_VALUE)) {
            return null;
        }
        return strDecrypt;
    }

    private String encryptValue(byte[] bArr) {
        return Encryptor.encrypt(Base64.encodeToString(bArr, 2), this.mEncryptionKey);
    }

    private byte[] decryptValue(String str) {
        return Base64.decode(Encryptor.decrypt(str, this.mEncryptionKey), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<String, String> encryptKeyValuePair(String str, byte[] bArr) {
        return new Pair<>(encryptKey(str), encryptValue(bArr));
    }

    private byte[] generateKeyIv() throws NoSuchAlgorithmException {
        String string = this.mSharedPreferences.getString(KEY_IV, null);
        if (string != null) {
            return Base64.decode(string, 2);
        }
        byte[] bArrGenerateInitVector = Encryptor.generateInitVector();
        this.mSharedPreferences.edit().putString(KEY_IV, Base64.encodeToString(bArrGenerateInitVector, 2)).apply();
        return bArrGenerateInitVector;
    }

    boolean isReservedKey(String str) {
        return KEY_IV.equals(str);
    }

    private enum EncryptedType {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);

        private final int mId;

        EncryptedType(int i) {
            this.mId = i;
        }

        public static EncryptedType fromId(int i) {
            if (i == 0) {
                return STRING;
            }
            if (i == 1) {
                return STRING_SET;
            }
            if (i == 2) {
                return INT;
            }
            if (i == 3) {
                return LONG;
            }
            if (i == 4) {
                return FLOAT;
            }
            if (i != 5) {
                return null;
            }
            return BOOLEAN;
        }

        public int getId() {
            return this.mId;
        }
    }

    private static final class Editor implements SharedPreferences.Editor {
        private final SharedPreferences.Editor mEditor;
        private final EncryptedSharedPreferences mEncryptedSharedPreferences;
        private final AtomicBoolean mClearRequested = new AtomicBoolean(false);
        private final List<String> mKeysChanged = new CopyOnWriteArrayList();

        Editor(EncryptedSharedPreferences encryptedSharedPreferences, SharedPreferences.Editor editor) {
            this.mEncryptedSharedPreferences = encryptedSharedPreferences;
            this.mEditor = editor;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            if (str2 == null) {
                str2 = EncryptedSharedPreferences.NULL_VALUE;
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + 8);
            byteBufferAllocate.putInt(EncryptedType.STRING.getId());
            byteBufferAllocate.putInt(length);
            byteBufferAllocate.put(bytes);
            putEncryptedObject(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            if (set == null) {
                set = new ArraySet<>();
                set.add(EncryptedSharedPreferences.NULL_VALUE);
            }
            ArrayList<byte[]> arrayList = new ArrayList(set.size());
            int size = set.size() * 4;
            Iterator<String> it2 = set.iterator();
            while (it2.hasNext()) {
                byte[] bytes = it2.next().getBytes(StandardCharsets.UTF_8);
                arrayList.add(bytes);
                size += bytes.length;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(size + 4);
            byteBufferAllocate.putInt(EncryptedType.STRING_SET.getId());
            for (byte[] bArr : arrayList) {
                byteBufferAllocate.putInt(bArr.length);
                byteBufferAllocate.put(bArr);
            }
            putEncryptedObject(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            byteBufferAllocate.putInt(EncryptedType.INT.getId());
            byteBufferAllocate.putInt(i);
            putEncryptedObject(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
            byteBufferAllocate.putInt(EncryptedType.LONG.getId());
            byteBufferAllocate.putLong(j);
            putEncryptedObject(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            byteBufferAllocate.putInt(EncryptedType.FLOAT.getId());
            byteBufferAllocate.putFloat(f);
            putEncryptedObject(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
            byteBufferAllocate.putInt(EncryptedType.BOOLEAN.getId());
            byteBufferAllocate.put(z ? (byte) 1 : (byte) 0);
            putEncryptedObject(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            if (!this.mEncryptedSharedPreferences.isReservedKey(str)) {
                this.mEditor.remove(this.mEncryptedSharedPreferences.encryptKey(str));
                this.mKeysChanged.remove(str);
                return this;
            }
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.mClearRequested.set(true);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            clearKeysIfNeeded();
            try {
                return this.mEditor.commit();
            } finally {
                notifyListeners();
                this.mKeysChanged.clear();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            clearKeysIfNeeded();
            this.mEditor.apply();
            notifyListeners();
            this.mKeysChanged.clear();
        }

        private void clearKeysIfNeeded() {
            if (this.mClearRequested.getAndSet(false)) {
                for (String str : this.mEncryptedSharedPreferences.getAll().keySet()) {
                    if (!this.mKeysChanged.contains(str) && !this.mEncryptedSharedPreferences.isReservedKey(str)) {
                        this.mEditor.remove(this.mEncryptedSharedPreferences.encryptKey(str));
                    }
                }
            }
        }

        private void putEncryptedObject(String str, byte[] bArr) {
            if (this.mEncryptedSharedPreferences.isReservedKey(str)) {
                throw new SecurityException(str + " is a reserved key for the encryption keyset.");
            }
            this.mKeysChanged.add(str);
            if (str == null) {
                str = EncryptedSharedPreferences.NULL_VALUE;
            }
            Pair pairEncryptKeyValuePair = this.mEncryptedSharedPreferences.encryptKeyValuePair(str, bArr);
            this.mEditor.putString((String) pairEncryptKeyValuePair.first, (String) pairEncryptKeyValuePair.second);
        }

        private void notifyListeners() {
            for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.mEncryptedSharedPreferences.mListeners) {
                Iterator<String> it2 = this.mKeysChanged.iterator();
                while (it2.hasNext()) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.mEncryptedSharedPreferences, it2.next());
                }
            }
        }
    }
}
