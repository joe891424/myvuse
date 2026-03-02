package com.newrelic.agent.android.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsAttributeStore;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class SharedPrefsAnalyticsAttributeStore extends SharedPrefsStore implements AnalyticsAttributeStore {
    private static final String STORE_FILE = "NRAnalyticsAttributeStore";
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public SharedPrefsAnalyticsAttributeStore(Context context) {
        super(context, STORE_FILE);
    }

    public SharedPrefsAnalyticsAttributeStore(Context context, String str) {
        super(context, str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.newrelic.agent.android.analytics.AnalyticsAttributeStore, com.newrelic.agent.android.payload.PayloadStore
    public boolean store(AnalyticsAttribute analyticsAttribute) {
        synchronized (this) {
            if (!analyticsAttribute.isPersistent()) {
                return false;
            }
            SharedPreferences.Editor editorEdit = this.sharedPrefs.edit();
            int i = C37811.f4044x35709c72[analyticsAttribute.getAttributeDataType().ordinal()];
            if (i == 1) {
                log.audit("SharedPrefsAnalyticsAttributeStore.store(" + analyticsAttribute + ")");
                editorEdit.putString(analyticsAttribute.getName(), analyticsAttribute.getStringValue());
            } else if (i == 2) {
                log.audit("SharedPrefsAnalyticsAttributeStore.store(" + analyticsAttribute + ")");
                editorEdit.putLong(analyticsAttribute.getName(), Double.doubleToLongBits(analyticsAttribute.getDoubleValue()));
            } else if (i == 3) {
                log.audit("SharedPrefsAnalyticsAttributeStore.store(" + analyticsAttribute + ")");
                editorEdit.putBoolean(analyticsAttribute.getName(), analyticsAttribute.getBooleanValue());
            } else {
                log.error("SharedPrefsAnalyticsAttributeStore.store - unsupported analytic attribute data type" + analyticsAttribute.getName());
                return false;
            }
            return applyOrCommitEditor(editorEdit);
        }
    }

    /* JADX INFO: renamed from: com.newrelic.agent.android.stores.SharedPrefsAnalyticsAttributeStore$1 */
    static /* synthetic */ class C37811 {

        /* JADX INFO: renamed from: $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType */
        static final /* synthetic */ int[] f4044x35709c72;

        static {
            int[] iArr = new int[AnalyticsAttribute.AttributeDataType.values().length];
            f4044x35709c72 = iArr;
            try {
                iArr[AnalyticsAttribute.AttributeDataType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4044x35709c72[AnalyticsAttribute.AttributeDataType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4044x35709c72[AnalyticsAttribute.AttributeDataType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.newrelic.agent.android.stores.SharedPrefsStore, com.newrelic.agent.android.analytics.AnalyticsAttributeStore, com.newrelic.agent.android.payload.PayloadStore
    public List<AnalyticsAttribute> fetchAll() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.sharedPrefs.getAll().entrySet()) {
            AgentLog agentLog = log;
            agentLog.audit("SharedPrefsAnalyticsAttributeStore contains attribute [" + ((Object) entry.getKey()) + "=" + entry.getValue() + "]");
            if (entry.getValue() instanceof String) {
                arrayList.add(new AnalyticsAttribute(entry.getKey().toString(), entry.getValue().toString(), true));
            } else if (entry.getValue() instanceof Float) {
                arrayList.add(new AnalyticsAttribute(entry.getKey().toString(), Double.valueOf(entry.getValue().toString()).doubleValue(), true));
            } else if (entry.getValue() instanceof Long) {
                arrayList.add(new AnalyticsAttribute(entry.getKey().toString(), Double.longBitsToDouble(Long.valueOf(entry.getValue().toString()).longValue()), true));
            } else if (entry.getValue() instanceof Boolean) {
                arrayList.add(new AnalyticsAttribute(entry.getKey().toString(), Boolean.valueOf(entry.getValue().toString()).booleanValue(), true));
            } else {
                agentLog.error("SharedPrefsAnalyticsAttributeStore.fetchAll(): unsupported attribute [" + ((Object) entry.getKey()) + "=" + entry.getValue() + "]");
            }
        }
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.newrelic.agent.android.analytics.AnalyticsAttributeStore, com.newrelic.agent.android.payload.PayloadStore
    public void delete(AnalyticsAttribute analyticsAttribute) {
        synchronized (this) {
            log.audit("SharedPrefsAnalyticsAttributeStore.delete(" + analyticsAttribute.getName() + ")");
            super.delete(analyticsAttribute.getName());
        }
    }
}
