package com.yoti.mobile.android.documentcapture.p055id.data.remote;

import com.brentvatne.react.ReactVideoViewManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.MrzType;
import java.lang.reflect.Type;
import javax.inject.Inject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/MrzSerializer;", "Lcom/google/gson/JsonSerializer;", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/MrzType;", "()V", "serialize", "Lcom/google/gson/JsonElement;", ReactVideoViewManager.PROP_SRC, "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrzSerializer implements JsonSerializer<MrzType> {
    @Inject
    public MrzSerializer() {
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(MrzType src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src != null ? Integer.valueOf(src.getValue()) : null);
    }
}
