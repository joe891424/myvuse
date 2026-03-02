package com.reactnativenavigation.options.parsers;

import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.utils.CollectionUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class BoolParser {
    public static Bool parse(JSONObject jSONObject, String str) {
        return jSONObject.has(str) ? new Bool(Boolean.valueOf(jSONObject.optBoolean(str))) : new NullBool();
    }

    public static Bool parseFirst(final JSONObject jSONObject, String... strArr) {
        List listAsList = Arrays.asList(strArr);
        Objects.requireNonNull(jSONObject);
        String str = (String) CollectionUtils.first(listAsList, new CollectionUtils.Filter() { // from class: com.reactnativenavigation.options.parsers.BoolParser$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.CollectionUtils.Filter
            public final boolean filter(Object obj) {
                return jSONObject.has((String) obj);
            }
        });
        return str != null ? new Bool(Boolean.valueOf(jSONObject.optBoolean(str))) : new NullBool();
    }
}
