package com.reactnativenavigation.options;

import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.options.parsers.BoolParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class ModalOptions {
    public ModalPresentationStyle presentationStyle = ModalPresentationStyle.Unspecified;
    public Bool blurOnUnmount = new NullBool();

    public static ModalOptions parse(JSONObject jSONObject) {
        ModalOptions modalOptions = new ModalOptions();
        if (jSONObject == null) {
            return modalOptions;
        }
        modalOptions.presentationStyle = ModalPresentationStyle.fromString(jSONObject.optString("modalPresentationStyle"));
        modalOptions.blurOnUnmount = BoolParser.parse(jSONObject, "blurOnUnmount");
        return modalOptions;
    }

    public void mergeWith(ModalOptions modalOptions) {
        if (modalOptions.presentationStyleHasValue()) {
            this.presentationStyle = modalOptions.presentationStyle;
        }
        if (modalOptions.blurOnUnmount.hasValue()) {
            this.blurOnUnmount = modalOptions.blurOnUnmount;
        }
    }

    private boolean presentationStyleHasValue() {
        return this.presentationStyle != ModalPresentationStyle.Unspecified;
    }

    public void mergeWithDefault(ModalOptions modalOptions) {
        if (!presentationStyleHasValue()) {
            this.presentationStyle = modalOptions.presentationStyle;
        }
        if (this.blurOnUnmount.hasValue()) {
            return;
        }
        this.blurOnUnmount = modalOptions.blurOnUnmount;
    }
}
