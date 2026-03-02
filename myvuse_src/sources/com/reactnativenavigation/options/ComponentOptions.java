package com.reactnativenavigation.options;

import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.options.params.NullNumber;
import com.reactnativenavigation.options.params.NullText;
import com.reactnativenavigation.options.params.Number;
import com.reactnativenavigation.options.params.Param;
import com.reactnativenavigation.options.params.Text;
import com.reactnativenavigation.options.parsers.BoolParser;
import com.reactnativenavigation.options.parsers.NumberParser;
import com.reactnativenavigation.options.parsers.TextParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class ComponentOptions {
    public Text name = new NullText();
    public Text componentId = new NullText();
    public Alignment alignment = Alignment.Default;
    public Bool waitForRender = new NullBool();
    public Number width = new NullNumber();
    public Number height = new NullNumber();

    public static ComponentOptions parse(JSONObject jSONObject) {
        ComponentOptions componentOptions = new ComponentOptions();
        if (jSONObject == null) {
            return componentOptions;
        }
        componentOptions.name = TextParser.parse(jSONObject, "name");
        componentOptions.componentId = TextParser.parse(jSONObject, "componentId");
        componentOptions.alignment = Alignment.fromString(TextParser.parse(jSONObject, "alignment").get(""));
        componentOptions.waitForRender = BoolParser.parse(jSONObject, "waitForRender");
        componentOptions.width = NumberParser.parse(jSONObject, "width");
        componentOptions.height = NumberParser.parse(jSONObject, "height");
        return componentOptions;
    }

    void mergeWith(ComponentOptions componentOptions) {
        if (componentOptions.componentId.hasValue()) {
            this.componentId = componentOptions.componentId;
        }
        if (componentOptions.name.hasValue()) {
            this.name = componentOptions.name;
        }
        if (componentOptions.waitForRender.hasValue()) {
            this.waitForRender = componentOptions.waitForRender;
        }
        if (componentOptions.alignment != Alignment.Default) {
            this.alignment = componentOptions.alignment;
        }
        if (componentOptions.width.hasValue()) {
            this.width = componentOptions.width;
        }
        if (componentOptions.height.hasValue()) {
            this.height = componentOptions.height;
        }
    }

    public void mergeWithDefault(ComponentOptions componentOptions) {
        if (!this.componentId.hasValue()) {
            this.componentId = componentOptions.componentId;
        }
        if (!this.name.hasValue()) {
            this.name = componentOptions.name;
        }
        if (!this.waitForRender.hasValue()) {
            this.waitForRender = componentOptions.waitForRender;
        }
        if (this.alignment == Alignment.Default) {
            this.alignment = componentOptions.alignment;
        }
        if (!this.width.hasValue()) {
            this.width = componentOptions.width;
        }
        if (this.height.hasValue()) {
            return;
        }
        this.height = componentOptions.height;
    }

    public boolean hasValue() {
        return this.name.hasValue();
    }

    public boolean equals(ComponentOptions componentOptions) {
        return this.name.equals((Param) componentOptions.name) && this.componentId.equals((Param) componentOptions.componentId) && this.alignment.equals(componentOptions.alignment) && this.waitForRender.equals((Param) componentOptions.waitForRender) && this.width.equals((Param) componentOptions.width) && this.height.equals((Param) componentOptions.height);
    }

    public void reset() {
        this.name = new NullText();
        this.componentId = new NullText();
        this.alignment = Alignment.Default;
        this.waitForRender = new NullBool();
        this.width = new NullNumber();
        this.height = new NullNumber();
    }
}
