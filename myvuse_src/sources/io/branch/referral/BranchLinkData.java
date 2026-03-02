package io.branch.referral;

import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import io.branch.referral.Defines;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
class BranchLinkData extends JSONObject {
    private String alias;
    private String campaign;
    private String channel;
    private int duration;
    private String feature;
    private JSONObject params;
    private String stage;
    private Collection<String> tags;
    private int type;

    public void putTags(Collection<String> collection) throws JSONException {
        if (collection != null) {
            this.tags = collection;
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it2 = collection.iterator();
            while (it2.hasNext()) {
                jSONArray.put(it2.next());
            }
            put(Defines.LinkParam.Tags.getKey(), jSONArray);
        }
    }

    public Collection<String> getTags() {
        return this.tags;
    }

    public void putAlias(String str) throws JSONException {
        if (str != null) {
            this.alias = str;
            put(Defines.LinkParam.Alias.getKey(), str);
        }
    }

    public String getAlias() {
        return this.alias;
    }

    public void putType(int i) throws JSONException {
        if (i != 0) {
            this.type = i;
            put(Defines.LinkParam.Type.getKey(), i);
        }
    }

    public int getType() {
        return this.type;
    }

    public void putDuration(int i) throws JSONException {
        if (i > 0) {
            this.duration = i;
            put(Defines.LinkParam.Duration.getKey(), i);
        }
    }

    public int getDuration() {
        return this.duration;
    }

    public void putChannel(String str) throws JSONException {
        if (str != null) {
            this.channel = str;
            put(Defines.LinkParam.Channel.getKey(), str);
        }
    }

    public String getChannel() {
        return this.channel;
    }

    public void putFeature(String str) throws JSONException {
        if (str != null) {
            this.feature = str;
            put(Defines.LinkParam.Feature.getKey(), str);
        }
    }

    public String getFeature() {
        return this.feature;
    }

    public void putStage(String str) throws JSONException {
        if (str != null) {
            this.stage = str;
            put(Defines.LinkParam.Stage.getKey(), str);
        }
    }

    public String getStage() {
        return this.stage;
    }

    public void putCampaign(String str) throws JSONException {
        if (str != null) {
            this.campaign = str;
            put(Defines.LinkParam.Campaign.getKey(), str);
        }
    }

    public String getCampaign() {
        return this.campaign;
    }

    public void putParams(JSONObject jSONObject) throws JSONException {
        this.params = jSONObject;
        put(Defines.LinkParam.Data.getKey(), jSONObject);
    }

    public JSONObject getParams() {
        return this.params;
    }

    public void putSource() throws JSONException {
        put("source", Defines.Jsonkey.URLSource.getKey());
    }

    public String getSource() {
        return Defines.Jsonkey.URLSource.getKey();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BranchLinkData branchLinkData = (BranchLinkData) obj;
        String str = this.alias;
        if (str == null) {
            if (branchLinkData.alias != null) {
                return false;
            }
        } else if (!str.equals(branchLinkData.alias)) {
            return false;
        }
        String str2 = this.channel;
        if (str2 == null) {
            if (branchLinkData.channel != null) {
                return false;
            }
        } else if (!str2.equals(branchLinkData.channel)) {
            return false;
        }
        String str3 = this.feature;
        if (str3 == null) {
            if (branchLinkData.feature != null) {
                return false;
            }
        } else if (!str3.equals(branchLinkData.feature)) {
            return false;
        }
        String str4 = this.stage;
        if (str4 == null) {
            if (branchLinkData.stage != null) {
                return false;
            }
        } else if (!str4.equals(branchLinkData.stage)) {
            return false;
        }
        String str5 = this.campaign;
        if (str5 == null) {
            if (branchLinkData.campaign != null) {
                return false;
            }
        } else if (!str5.equals(branchLinkData.campaign)) {
            return false;
        }
        if (this.type != branchLinkData.type || this.duration != branchLinkData.duration) {
            return false;
        }
        Collection<String> collection = this.tags;
        String string = null;
        if (collection == null) {
            if (branchLinkData.tags != null) {
                return false;
            }
        } else {
            String string2 = collection.toString();
            Collection<String> collection2 = branchLinkData.tags;
            if (!string2.equals(collection2 != null ? collection2.toString() : null)) {
                return false;
            }
        }
        JSONObject jSONObject = this.params;
        if (jSONObject == null) {
            if (branchLinkData.params != null) {
                return false;
            }
        } else {
            String string3 = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
            JSONObject jSONObject2 = branchLinkData.params;
            if (jSONObject2 != null) {
                string = !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2);
            }
            if (!string3.equals(string)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = (this.type + 19) * 19;
        String str = this.alias;
        int iHashCode = 0;
        int iHashCode2 = (i + (str == null ? 0 : str.toLowerCase().hashCode())) * 19;
        String str2 = this.channel;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.toLowerCase().hashCode())) * 19;
        String str3 = this.feature;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.toLowerCase().hashCode())) * 19;
        String str4 = this.stage;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.toLowerCase().hashCode())) * 19;
        String str5 = this.campaign;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.toLowerCase().hashCode())) * 19;
        JSONObject jSONObject = this.params;
        if (jSONObject != null) {
            iHashCode = (!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).toLowerCase().hashCode();
        }
        int iHashCode7 = ((iHashCode6 + iHashCode) * 19) + this.duration;
        Collection<String> collection = this.tags;
        if (collection != null) {
            Iterator<String> it2 = collection.iterator();
            while (it2.hasNext()) {
                iHashCode7 = (iHashCode7 * 19) + it2.next().toLowerCase().hashCode();
            }
        }
        return iHashCode7;
    }

    public JSONObject getLinkDataJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.channel)) {
                jSONObject.put("~" + Defines.LinkParam.Channel.getKey(), this.channel);
            }
            if (!TextUtils.isEmpty(this.alias)) {
                jSONObject.put("~" + Defines.LinkParam.Alias.getKey(), this.alias);
            }
            if (!TextUtils.isEmpty(this.feature)) {
                jSONObject.put("~" + Defines.LinkParam.Feature.getKey(), this.feature);
            }
            if (!TextUtils.isEmpty(this.stage)) {
                jSONObject.put("~" + Defines.LinkParam.Stage.getKey(), this.stage);
            }
            if (!TextUtils.isEmpty(this.campaign)) {
                jSONObject.put("~" + Defines.LinkParam.Campaign.getKey(), this.campaign);
            }
            if (has(Defines.LinkParam.Tags.getKey())) {
                jSONObject.put(Defines.LinkParam.Tags.getKey(), getJSONArray(Defines.LinkParam.Tags.getKey()));
            }
            jSONObject.put("~" + Defines.LinkParam.Type.getKey(), this.type);
            jSONObject.put("~" + Defines.LinkParam.Duration.getKey(), this.duration);
        } catch (JSONException e) {
            BranchLogger.m5575d(e.getMessage());
        }
        return jSONObject;
    }
}
