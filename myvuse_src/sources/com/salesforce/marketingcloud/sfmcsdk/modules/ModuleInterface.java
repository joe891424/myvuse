package com.salesforce.marketingcloud.sfmcsdk.modules;

import com.salesforce.marketingcloud.sfmcsdk.components.identity.ModuleIdentity;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: ModuleInterface.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/modules/ModuleInterface;", "", "moduleIdentity", "Lcom/salesforce/marketingcloud/sfmcsdk/components/identity/ModuleIdentity;", "getModuleIdentity", "()Lcom/salesforce/marketingcloud/sfmcsdk/components/identity/ModuleIdentity;", "state", "Lorg/json/JSONObject;", "getState", "()Lorg/json/JSONObject;", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ModuleInterface {
    ModuleIdentity getModuleIdentity();

    JSONObject getState();
}
