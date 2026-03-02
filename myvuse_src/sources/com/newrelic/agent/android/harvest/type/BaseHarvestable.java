package com.newrelic.agent.android.harvest.type;

import com.newrelic.agent.android.harvest.type.Harvestable;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import com.newrelic.com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class BaseHarvestable implements Harvestable {
    protected static final Type GSON_STRING_MAP_TYPE = new TypeToken<Map>() { // from class: com.newrelic.agent.android.harvest.type.BaseHarvestable.1
    }.getType();
    private final Harvestable.Type type;

    @Override // com.newrelic.agent.android.harvest.type.Harvestable
    public JsonArray asJsonArray() {
        return null;
    }

    @Override // com.newrelic.agent.android.harvest.type.Harvestable
    public JsonObject asJsonObject() {
        return null;
    }

    @Override // com.newrelic.agent.android.harvest.type.Harvestable
    public JsonPrimitive asJsonPrimitive() {
        return null;
    }

    public BaseHarvestable(Harvestable.Type type) {
        this.type = type;
    }

    /* JADX INFO: renamed from: com.newrelic.agent.android.harvest.type.BaseHarvestable$2 */
    static /* synthetic */ class C37522 {

        /* JADX INFO: renamed from: $SwitchMap$com$newrelic$agent$android$harvest$type$Harvestable$Type */
        static final /* synthetic */ int[] f4039x3e296f68;

        static {
            int[] iArr = new int[Harvestable.Type.values().length];
            f4039x3e296f68 = iArr;
            try {
                iArr[Harvestable.Type.OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4039x3e296f68[Harvestable.Type.ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4039x3e296f68[Harvestable.Type.VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.newrelic.agent.android.harvest.type.Harvestable
    public JsonElement asJson() {
        int i = C37522.f4039x3e296f68[this.type.ordinal()];
        if (i == 1) {
            return asJsonObject();
        }
        if (i == 2) {
            return asJsonArray();
        }
        if (i != 3) {
            return null;
        }
        return asJsonPrimitive();
    }

    @Override // com.newrelic.agent.android.harvest.type.Harvestable
    public Harvestable.Type getType() {
        return this.type;
    }

    @Override // com.newrelic.agent.android.harvest.type.Harvestable
    public String toJsonString() {
        return asJson().toString();
    }

    protected void notEmpty(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Missing Harvestable field.");
        }
    }

    protected void notNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Null field in Harvestable object");
        }
    }

    protected String optional(String str) {
        return str == null ? "" : str;
    }
}
