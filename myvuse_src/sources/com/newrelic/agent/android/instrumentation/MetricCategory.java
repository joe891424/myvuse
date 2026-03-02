package com.newrelic.agent.android.instrumentation;

import com.google.firebase.perf.metrics.resource.ResourceType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public enum MetricCategory {
    NONE("None"),
    VIEW_LOADING("View Loading"),
    VIEW_LAYOUT("Layout"),
    DATABASE("Database"),
    IMAGE("Images"),
    JSON("JSON"),
    NETWORK(ResourceType.NETWORK);

    private static final Map<String, MetricCategory> methodMap = new HashMap<String, MetricCategory>() { // from class: com.newrelic.agent.android.instrumentation.MetricCategory.1
        {
            put("onCreate", MetricCategory.VIEW_LOADING);
        }
    };
    private String categoryName;

    MetricCategory(String str) {
        this.categoryName = str;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public static MetricCategory categoryForMethod(String str) {
        if (str == null) {
            return NONE;
        }
        int iIndexOf = str.indexOf("#");
        return methodMap.getOrDefault(iIndexOf >= 0 ? str.substring(iIndexOf + 1) : null, NONE);
    }
}
