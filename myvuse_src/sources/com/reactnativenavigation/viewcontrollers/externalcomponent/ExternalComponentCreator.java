package com.reactnativenavigation.viewcontrollers.externalcomponent;

import androidx.fragment.app.FragmentActivity;
import com.facebook.react.ReactInstanceManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public interface ExternalComponentCreator {
    ExternalComponent create(FragmentActivity fragmentActivity, ReactInstanceManager reactInstanceManager, JSONObject jSONObject);
}
