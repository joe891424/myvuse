package com.reactnativenavigation.options;

import com.reactnativenavigation.options.params.NullText;
import com.reactnativenavigation.options.params.Text;
import com.reactnativenavigation.options.parsers.TextParser;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class ExternalComponent {
    public Text name = new NullText();
    public JSONObject passProps = new JSONObject();

    public static ExternalComponent parse(JSONObject jSONObject) {
        ExternalComponent externalComponent = new ExternalComponent();
        if (jSONObject == null) {
            return externalComponent;
        }
        Text text = TextParser.parse(jSONObject, "name");
        externalComponent.name = text;
        if (!text.hasValue()) {
            throw new RuntimeException("ExternalComponent must have a name");
        }
        externalComponent.passProps = parsePassProps(jSONObject);
        return externalComponent;
    }

    private static JSONObject parsePassProps(JSONObject jSONObject) {
        if (jSONObject.has("passProps")) {
            try {
                return jSONObject.getJSONObject("passProps");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return new JSONObject();
    }

    public void mergeWith(ExternalComponent externalComponent) {
        if (externalComponent.name.hasValue()) {
            this.name = externalComponent.name;
        }
        if (externalComponent.passProps.length() > 0) {
            this.passProps = externalComponent.passProps;
        }
    }

    public void mergeWithDefault(ExternalComponent externalComponent) {
        if (!this.name.hasValue()) {
            this.name = externalComponent.name;
        }
        if (this.passProps.length() == 0) {
            this.passProps = externalComponent.passProps;
        }
    }
}
