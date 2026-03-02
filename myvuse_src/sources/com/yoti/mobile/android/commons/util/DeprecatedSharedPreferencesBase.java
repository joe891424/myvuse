package com.yoti.mobile.android.commons.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class DeprecatedSharedPreferencesBase extends SharedPreferencesBase {

    /* JADX INFO: renamed from: com.yoti.mobile.android.commons.util.DeprecatedSharedPreferencesBase$a */
    static /* synthetic */ class C4586a {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f6591a;

        static {
            int[] iArr = new int[EnumC4587b.values().length];
            f6591a = iArr;
            try {
                iArr[EnumC4587b.NEW_INSTALLATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6591a[EnumC4587b.ALREADY_MIGRATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6591a[EnumC4587b.UPGRADE_FROM_NON_VERSIONED_WITH_PREFIX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6591a[EnumC4587b.SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.commons.util.DeprecatedSharedPreferencesBase$b */
    private enum EnumC4587b {
        NEW_INSTALLATION,
        ALREADY_MIGRATED,
        UPGRADE_FROM_NON_VERSIONED_WITH_PREFIX,
        SUCCESS
    }

    public DeprecatedSharedPreferencesBase(Context context, String str) {
        super(context, str);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    private void m4690a(String str) {
        SharedPreferences.Editor sharedEditor = getSharedEditor();
        sharedEditor.remove(str);
        sharedEditor.apply();
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    private EnumC4587b m4692b() {
        List<String> deprecatedPreferenceKeys = getDeprecatedPreferenceKeys();
        if (deprecatedPreferenceKeys == null || deprecatedPreferenceKeys.isEmpty()) {
            throw new RuntimeException("getDeprecatedPreferenceKeys() has to a return a list of preferences to migrate");
        }
        Map<String, ?> all = getSharedPreferences().getAll();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Map<String, Object> mapM4693b = m4693b(all, deprecatedPreferenceKeys);
        Map<String, Object> mapM4689a = m4689a(all, deprecatedPreferenceKeys);
        if (mapM4693b.isEmpty()) {
            return getStoredVersion() == -1 ? !mapM4689a.isEmpty() ? EnumC4587b.UPGRADE_FROM_NON_VERSIONED_WITH_PREFIX : EnumC4587b.NEW_INSTALLATION : EnumC4587b.ALREADY_MIGRATED;
        }
        for (Map.Entry<String, Object> entry : mapM4693b.entrySet()) {
            String strBuildCompleteKey = buildCompleteKey(entry.getKey());
            if (m4697e(entry.getValue())) {
                setStringPreference(entry.getKey(), (String) entry.getValue());
            } else if (m4694b(entry.getValue())) {
                setIntPreference(entry.getKey(), ((Integer) entry.getValue()).intValue());
            } else if (m4695c(entry.getValue())) {
                setLongPreference(entry.getKey(), ((Long) entry.getValue()).longValue());
            } else if (m4691a(entry.getValue())) {
                setBooleanPreference(entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
            } else if (m4696d(entry.getValue())) {
                setStringSetPreference(entry.getKey(), (Set) entry.getValue());
            } else {
                arrayList2.add(entry.getKey());
            }
            arrayList.add(entry.getKey() + " -> " + strBuildCompleteKey);
            m4690a(entry.getKey());
        }
        return EnumC4587b.SUCCESS;
    }

    /* JADX INFO: renamed from: c */
    private boolean m4695c(Object obj) {
        return obj.getClass().isAssignableFrom(Long.class);
    }

    /* JADX INFO: renamed from: d */
    private boolean m4696d(Object obj) {
        return obj.getClass().getSuperclass() != null && obj.getClass().getSuperclass().isAssignableFrom(AbstractSet.class);
    }

    /* JADX INFO: renamed from: e */
    private boolean m4697e(Object obj) {
        return obj.getClass().isAssignableFrom(String.class);
    }

    protected abstract List<String> getDeprecatedPreferenceKeys();

    @Override // com.yoti.mobile.android.commons.util.SharedPreferencesBase
    protected final void onPreCheckVersion() {
        int i = C4586a.f6591a[m4692b().ordinal()];
        if (i == 1) {
            setStoredVersion(getVersion());
        } else if ((i == 2 || i == 3 || i == 4) && getStoredVersion() == -1) {
            setStoredVersion(1);
        }
    }

    /* JADX INFO: renamed from: a */
    private Map<String, Object> m4689a(Map<String, ?> map, List<String> list) {
        HashMap map2 = new HashMap();
        for (String str : list) {
            if (map.containsKey(buildCompleteKey(str))) {
                map2.put(buildCompleteKey(str), map.get(buildCompleteKey(str)));
            }
        }
        return map2;
    }

    /* JADX INFO: renamed from: a */
    private boolean m4691a(Object obj) {
        return obj.getClass().isAssignableFrom(Boolean.class);
    }

    /* JADX INFO: renamed from: b */
    private Map<String, Object> m4693b(Map<String, ?> map, List<String> list) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            if (list.contains(entry.getKey())) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        return map2;
    }

    /* JADX INFO: renamed from: b */
    private boolean m4694b(Object obj) {
        return obj.getClass().isAssignableFrom(Integer.class);
    }
}
